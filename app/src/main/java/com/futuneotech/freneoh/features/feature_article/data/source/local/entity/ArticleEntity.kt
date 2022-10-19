package com.futuneotech.freneoh.features.feature_article.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "article")
data class ArticleEntity(
    @ColumnInfo(name = "uri")
    var uri:String,

    @ColumnInfo(name = "url")
    var url:String,

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id:Long,

    @ColumnInfo(name = "asset_id")
    var assetId:Long,

    @ColumnInfo(name = "source")
    var source:String,

    @ColumnInfo(name = "published_date")
    var publishedDate:String,

    @ColumnInfo(name = "updated")
    var updated:String,

    @ColumnInfo(name = "section")
    var section:String,

    @ColumnInfo(name = "subsection")
    var subsection:String,

    @ColumnInfo(name = "nytdsection")
    var nytDSection:String,

    @ColumnInfo(name = "adx_keywords")
    var adxKeywords:String,

    @ColumnInfo(name = "byline")
    var byLine:String,

    @ColumnInfo(name = "type")
    var type:String,

    @ColumnInfo(name = "title")
    var title:String,

    @ColumnInfo(name = "abstract")
    var articleAbstract:String,

    @ColumnInfo(name = "des_facet")
    var descriptionFacet:ArrayList<String>,

    @ColumnInfo(name = "org_facet")
    var organizationFacet:ArrayList<String>,

    @ColumnInfo(name = "per_facet")
    var personFacet:ArrayList<String>,

    @ColumnInfo(name = "geo_facet")
    var geographicFacet:ArrayList<String>,

    @ColumnInfo(name = "media")
    var media:ArrayList<MediaEntity>,
)

data class MediaEntity(
    @ColumnInfo(name = "type")
    var type:String,

    @ColumnInfo(name = "subtype")
    var subtype:String,

    @ColumnInfo(name = "caption")
    var caption:String,

    @ColumnInfo(name = "copyright")
    var copyright:String,

    @ColumnInfo(name = "approved_for_syndication")
    var approvedForSyndication:Int,

    @ColumnInfo(name = "media-metadata")
    var mediaMetaData:ArrayList<MediaMetaDataEntity>,
)

data class MediaMetaDataEntity(

    @ColumnInfo(name = "url")
    var url:String,

    @ColumnInfo(name = "format")
    var format:String,

    @ColumnInfo(name = "height")
    var height:Int,

    @ColumnInfo(name = "width")
    var width:Int,
)