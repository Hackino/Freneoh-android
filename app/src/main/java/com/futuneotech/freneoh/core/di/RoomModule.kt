package com.futuneotech.freneoh.core.di

import android.content.Context
import androidx.room.Room
import com.futuneotech.freneoh.core.data.local.db.CacheDatabase
import com.futuneotech.freneoh.core.data.utils.GsonParser
import com.futuneotech.freneoh.features.feature_article.data.source.local.converters.ArticleConverters
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {
    @Singleton
    @Provides
    fun provideDb(@ApplicationContext context: Context): CacheDatabase {
        return Room
            .databaseBuilder(
                context,
                CacheDatabase::class.java,
                CacheDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .addTypeConverter(ArticleConverters(GsonParser(Gson())))
            .build()
    }
}