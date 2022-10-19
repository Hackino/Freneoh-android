package com.futuneotech.freneoh.features.feature_article.data.source.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ArticleDto(

    @Expose
    @SerializedName("uri")
    val uri:String,

    @Expose
    @SerializedName("url")
    val url:String,

    @Expose
    @SerializedName("id")
    val id:Long,

    @Expose
    @SerializedName("asset_id")
    val assetId:Long,

    @Expose
    @SerializedName("source")
    val source:String,

    @Expose
    @SerializedName("published_date")
    val publishedDate:String,

    @Expose
    @SerializedName("updated")
    val updated:String,

    @Expose
    @SerializedName("section")
    val section:String,

    @Expose
    @SerializedName("subsection")
    val subsection:String,

    @Expose
    @SerializedName("nytdsection")
    val nytDSection:String,

    @Expose
    @SerializedName("adx_keywords")
    val adxKeywords:String,

    @Expose
    @SerializedName("byline")
    val byLine:String,

    @Expose
    @SerializedName("type")
    val type:String,

    @Expose
    @SerializedName("title")
    val title:String,

    @Expose
    @SerializedName("abstract")
    val abstract:String,

    @Expose
    @SerializedName("des_facet")
    val descriptionFacet:ArrayList<String>,

    @Expose
    @SerializedName("org_facet")
    val organizationFacet:ArrayList<String>,

    @Expose
    @SerializedName("per_facet")
    val personFacet:ArrayList<String>,

    @Expose
    @SerializedName("geo_facet")
    val geographicFacet:ArrayList<String>,

    @Expose
    @SerializedName("media")
    val media:ArrayList<MediaDto>,
)


data class MediaDto(
    @Expose
    @SerializedName("type")
    val type:String,

    @Expose
    @SerializedName("subtype")
    val subtype:String,

    @Expose
    @SerializedName("caption")
    val caption:String,

    @Expose
    @SerializedName("copyright")
    val copyright:String,

    @Expose
    @SerializedName("approved_for_syndication")
    val approvedForSyndication:Int,

    @Expose
    @SerializedName("media-metadata")
    val mediaMetaData:ArrayList<MediaMetaDataDto>,
)

data class MediaMetaDataDto(
    @Expose
    @SerializedName("url")
    val url:String,

    @Expose
    @SerializedName("format")
    val format:String,

    @Expose
    @SerializedName("height")
    val height:Int,

    @Expose
    @SerializedName("width")
    val width:Int,
)