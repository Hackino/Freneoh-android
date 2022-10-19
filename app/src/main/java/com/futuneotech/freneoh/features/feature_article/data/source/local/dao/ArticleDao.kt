package com.futuneotech.freneoh.features.feature_article.data.source.local.dao

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.futuneotech.freneoh.features.feature_article.data.source.local.entity.ArticleEntity

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticle(articleEntity: ArticleEntity): Long

    //TODO fix later to get articles depending on published(period) date and section
    @Query("SELECT * FROM article")
    suspend fun getArticles(): List<ArticleEntity>

    @Query("SELECT * FROM article WHERE article.id=:id")
    suspend fun getArticle(id:Long): ArticleEntity
}