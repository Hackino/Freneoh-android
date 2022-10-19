package com.futuneotech.freneoh.features.feature_article.di

import com.futuneotech.freneoh.core.data.local.db.CacheDatabase
import com.futuneotech.freneoh.core.data.remote.WebService
import com.futuneotech.freneoh.features.feature_article.data.source.local.utils.ArticleEntityMapper
import com.futuneotech.freneoh.features.feature_article.data.source.remote.utils.ArticleNetworkMapper
import com.futuneotech.freneoh.features.feature_article.data.repository.ArticleRepositoryImpl
import com.futuneotech.freneoh.features.feature_article.data.utils.ArticleDataSource
import com.futuneotech.freneoh.features.feature_article.data.utils.ArticleMappers
import com.futuneotech.freneoh.features.feature_article.data.utils.ArticleUseCases
import com.futuneotech.freneoh.features.feature_article.domain.use_case.GetArticleById
import com.futuneotech.freneoh.features.feature_article.domain.use_case.GetArticles
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ArticleModule {

    @Singleton
    @Provides
    fun provideArticleDataSource(
        api: WebService,
        db: CacheDatabase
    ): ArticleDataSource {
        return ArticleDataSource(api, db.articleDao())
    }

    @Singleton
    @Provides
    fun provideArticleMappers(
        networkMapper: ArticleNetworkMapper,
        articleEntityMapper: ArticleEntityMapper
    ): ArticleMappers {
        return ArticleMappers(
            networkMapper = networkMapper,
            articleEntityMapper =articleEntityMapper,
        )
    }


    @Singleton
    @Provides
    fun provideArticleRepository(
        dataSource: ArticleDataSource,
        mappers: ArticleMappers,
    ): ArticleRepositoryImpl {
        return ArticleRepositoryImpl(
            dataSource = dataSource,
            mappers = mappers
        )
    }

    @Singleton
    @Provides
    fun provideArticleUseCases(
        getArticles: GetArticles,
        getArticleById: GetArticleById
    ): ArticleUseCases {
        return ArticleUseCases(getArticles, getArticleById)
    }

}