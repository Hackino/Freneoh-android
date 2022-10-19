package com.futuneotech.freneoh.features.feature_article.data.source.remote.utils

import com.futuneotech.freneoh.core.data.remote.utils.ServerConfig.checkUrlPath
import com.futuneotech.freneoh.core.data.remote.utils.ServerConfig.getBasicConfig

/**
Article basic params
 **/
object ArticleRemoteConfig{
fun getArticlesParams(
    section: String = "all-sections",
    period: Int =7,
): String {
    return getBasicConfig(
        "/svc"+
                "/mostpopular"+
                "/v2"+
                "/mostviewed"+
                checkUrlPath(section) +
                checkUrlPath("$period")
    )
}
}