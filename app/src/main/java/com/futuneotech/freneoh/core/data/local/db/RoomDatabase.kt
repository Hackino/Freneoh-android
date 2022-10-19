package com.futuneotech.freneoh.core.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.futuneotech.freneoh.features.feature_article.data.source.local.converters.ArticleConverters
import com.futuneotech.freneoh.features.feature_article.data.source.local.dao.ArticleDao
import com.futuneotech.freneoh.features.feature_article.data.source.local.entity.ArticleEntity

@Database(entities = [ArticleEntity::class], version = 1, exportSchema = false)
@TypeConverters(ArticleConverters::class)
abstract class CacheDatabase: RoomDatabase() {

    abstract fun articleDao(): ArticleDao

    companion object{
        val DATABASE_NAME: String = "caching_db"
    }
}