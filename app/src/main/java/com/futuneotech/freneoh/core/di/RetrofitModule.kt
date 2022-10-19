package com.futuneotech.freneoh.core.di

import com.futuneotech.freneoh.BuildConfig
import com.futuneotech.freneoh.core.data.remote.WebService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    @Singleton
    @Provides
    fun provideGsonBuilder():Gson{
        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit.Builder{
        return Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Singleton
    @Provides
    fun provideWebService(retrofit: Retrofit.Builder):WebService{
        return retrofit
            .baseUrl(BuildConfig.SERVER)
            .build()
            .create(WebService::class.java)
    }
}