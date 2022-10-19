package com.futuneotech.freneoh.features.feature_article.domain.use_case

import com.futuneotech.freneoh.features.feature_article.data.repository.ArticleRepositoryImpl
import com.futuneotech.freneoh.features.feature_article.domain.model.Article
import com.futuneotech.freneoh.features.feature_article.domain.repository.ArticleRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetArticleById @Inject constructor(
    private val repository: ArticleRepositoryImpl,
) {
    operator fun invoke(id: Long): Flow<Article> {
        return repository.getArticleById(id)
    }
}
