package ru.easycode.zerotoheroandroidtdd

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {


    @Binds
    @Singleton
    fun bindRepository(
        repository: DefaultRepository
    ): Repository

    @Binds
    @Singleton
    fun bindLiveDataWrapper(
        liveDataWrapper: LiveDataWrapperClass
    ): LiveDataWrapper
}