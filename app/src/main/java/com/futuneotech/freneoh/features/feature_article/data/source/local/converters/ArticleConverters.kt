package com.futuneotech.freneoh.features.feature_article.data.source.local.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.futuneotech.freneoh.core.domain.utils.JsonParser
import com.futuneotech.freneoh.features.feature_article.data.source.local.entity.MediaEntity
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class ArticleConverters(
    private val jsonParser: JsonParser,
) {
    @TypeConverter
    fun fromMediaJson(json: String): ArrayList<MediaEntity> {
        return jsonParser.fromJson<ArrayList<MediaEntity>>(
            json,
            object : TypeToken<ArrayList<MediaEntity>>(){}.type
        ) ?: ArrayList()
    }

    @TypeConverter
    fun toMediaJson(meanings: ArrayList<MediaEntity>): String {
        return jsonParser.toJson(
            meanings,
            object : TypeToken<ArrayList<MediaEntity>>(){}.type
        ) ?: "[]"
    }

    @TypeConverter
    fun fromStringArrayJson(json: String): ArrayList<String> {
        return jsonParser.fromJson(
            json,
            object : TypeToken<ArrayList<String>>(){}.type
        )?:ArrayList()
    }

    @TypeConverter
    fun toStringArrayJson(array: ArrayList<String>): String {
        return jsonParser.toJson(
            array,
            object : TypeToken<ArrayList<String>>(){}.type
        ) ?: "[]"
    }
}