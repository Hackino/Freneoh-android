package com.futuneotech.freneoh.features.feature_article.data.utils

import com.futuneotech.freneoh.features.feature_article.data.source.local.utils.ArticleEntityMapper
import com.futuneotech.freneoh.features.feature_article.data.source.remote.utils.ArticleNetworkMapper

class ArticleMappers(
    val networkMapper: ArticleNetworkMapper,
    val articleEntityMapper: ArticleEntityMapper,
)