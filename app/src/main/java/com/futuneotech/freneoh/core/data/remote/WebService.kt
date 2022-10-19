package com.futuneotech.freneoh.core.data.remote

import com.futuneotech.freneoh.features.feature_article.data.source.remote.reponse.ArticleResponse
import retrofit2.http.GET
import retrofit2.http.Url

interface WebService {
    @GET
    suspend fun getArticles(@Url url:String):ArticleResponse
}