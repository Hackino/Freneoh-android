package com.futuneotech.freneoh.features.feature_article.data.repository

import com.futuneotech.freneoh.core.data.utils.Resource
import com.futuneotech.freneoh.features.feature_article.data.source.remote.utils.ArticleRemoteConfig.getArticlesParams
import com.futuneotech.freneoh.features.feature_article.data.utils.ArticleDataSource
import com.futuneotech.freneoh.features.feature_article.data.utils.ArticleMappers
import com.futuneotech.freneoh.features.feature_article.domain.model.Article
import com.futuneotech.freneoh.features.feature_article.domain.repository.ArticleRepository
import com.futuneotech.freneoh.utils.dLog
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class ArticleRepositoryImpl(
    private val dataSource: ArticleDataSource,
    private val mappers: ArticleMappers
): ArticleRepository {
    override fun getArticles(period: Int, section: String): Flow<Resource<List<Article>>> = flow{
        emit(Resource.Loading())

        try {
            val remoteArticles = dataSource.api.getArticles(
                getArticlesParams(
                    section,
                    period = period
                )
            ).result
            dLog("fromApi",remoteArticles)
            val articles = mappers.networkMapper.mapFromEntityList(remoteArticles)
            for (article in articles) {
                dataSource.dao.insertArticle( mappers.articleEntityMapper.mapToEntity(article))
            }
            val cachedArticles = dataSource.dao.getArticles()
            emit(Resource.Success(mappers.articleEntityMapper.mapFromEntityList(cachedArticles)))
        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    message = "Oops, something went wrong!",
                    data = mappers.articleEntityMapper.mapFromEntityList(dataSource.dao.getArticles())
                )
            )
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    message = "Couldn't reach server, check your internet connection.",
                    data = mappers.articleEntityMapper.mapFromEntityList(dataSource.dao.getArticles())
                )
            )
        }
    }

    override fun getArticleById(id: Long): Flow<Article> = flow {
        val cachedArticles = dataSource.dao.getArticle(id)
        emit(mappers.articleEntityMapper.mapFromEntity(cachedArticles))
    }

}