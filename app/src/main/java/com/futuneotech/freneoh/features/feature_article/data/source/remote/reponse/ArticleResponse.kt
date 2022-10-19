package com.futuneotech.freneoh.features.feature_article.data.source.remote.reponse

import com.futuneotech.freneoh.features.feature_article.data.source.remote.dto.ArticleDto
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ArticleResponse(
    @Expose
    @SerializedName("status")
    val status:String,

    @Expose
    @SerializedName("copyright")
    val copyright:String,

    @Expose
    @SerializedName("num_results")
    val numResults:Int,

    @Expose
    @SerializedName("results")
    val result: ArrayList<ArticleDto>
)
