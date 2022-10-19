package com.futuneotech.freneoh.core.di

import android.content.Context
import com.futuneotech.freneoh.application.FreneohApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): FreneohApp {
        return app as FreneohApp
    }

}