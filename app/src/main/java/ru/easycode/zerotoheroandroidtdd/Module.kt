package ru.easycode.zerotoheroandroidtdd

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object Module {
    @Provides
    fun myRepository(): Repository{
        return Repository.Base()
    }

    @Provides
    fun myLiveDataWrapper(): LiveDataWrapper {
        return LiveDataWrapper.Base()
    }
}