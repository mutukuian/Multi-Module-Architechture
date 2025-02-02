package com.search.ui.di

import com.search.ui.navigation.SearchFeatureApi
import com.search.ui.navigation.SearchFeatureApiImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object UiModule {
    @Provides
    fun provideSearchFeatureApi(): SearchFeatureApi{
        return SearchFeatureApiImpl()
    }
}