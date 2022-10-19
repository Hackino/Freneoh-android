package com.futuneotech.freneoh.features.feature_article.domain.repository

import com.futuneotech.freneoh.core.data.utils.Resource
import com.futuneotech.freneoh.features.feature_article.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {
    fun getArticles(period: Int, section: String): Flow<Resource<List<Article>>>
    fun getArticleById(id: Long): Flow<Article>
}
