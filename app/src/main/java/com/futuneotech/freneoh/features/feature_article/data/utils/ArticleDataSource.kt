package com.futuneotech.freneoh.features.feature_article.data.utils

import com.futuneotech.freneoh.core.data.remote.WebService
import com.futuneotech.freneoh.features.feature_article.data.source.local.dao.ArticleDao

class ArticleDataSource(
    val api: WebService,
    val dao: ArticleDao,
)