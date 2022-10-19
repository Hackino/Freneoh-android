package com.futuneotech.freneoh.core.data.remote.utils

import com.futuneotech.freneoh.BuildConfig
import com.futuneotech.freneoh.core.utils.Constants.API_KEY

/**
    URL basic Config
 **/
object ServerConfig {
    fun getBasicConfig(urlBody: String): String =
        BuildConfig.SERVER +
                urlBody +
                ".json?api-key=$API_KEY"


    fun checkUrlPath(path: String?): String =
        if (path.isNullOrEmpty()) "" else "/$path"
}