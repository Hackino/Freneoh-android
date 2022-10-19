package com.futuneotech.freneoh.features.feature_article.data.utils

import com.futuneotech.freneoh.features.feature_article.domain.use_case.GetArticleById
import com.futuneotech.freneoh.features.feature_article.domain.use_case.GetArticles

class ArticleUseCases(
    val getArticles: GetArticles,
    val getArticleById: GetArticleById
)