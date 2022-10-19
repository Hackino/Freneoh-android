package com.futuneotech.freneoh.features.feature_article.domain.model

data class Article(
    val uri:String,
    val url:String,
    val id:Long,
    val assetId:Long,
    val source:String,
    val publishedDate:String,
    val updated:String,
    val section:String,
    val subsection:String,
    val nytDSection:String,
    val adxKeywords:String,
    val byLine:String,
    val type:String,
    val title:String,
    val abstract:String,
    val descriptionFacet:ArrayList<String>,
    val organizationFacet:ArrayList<String>,
    val personFacet:ArrayList<String>,
    val geographicFacet:ArrayList<String>,
    val media:ArrayList<Media>,
)

data class Media(
    val type:String,
    val subtype:String,
    val caption:String,
    val copyright:String,
    val approvedForSyndication:Int,
    val mediaMetaData:ArrayList<MediaMetaData>,
)

data class MediaMetaData(
    val url:String,
    val format:String,
    val height:Int,
    val width:Int,
)