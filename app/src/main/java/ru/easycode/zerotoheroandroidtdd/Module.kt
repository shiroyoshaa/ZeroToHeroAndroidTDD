package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.MutableLiveData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


@Module
@InstallIn(SingletonComponent::class)

object Module {


    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://www.google.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun provideSimpleService(retrofit: Retrofit):
            SimpleService = retrofit.create(SimpleService::class.java)

    @Provides
    fun myRepo(service: SimpleService): Repository {
        return Repository.Base(service,"https://raw.githubusercontent.com/JohnnySC/ZeroToHeroAndroidTDD/task/018-clouddatasource/app/sampleresponse.json")
    }


    @Provides
    fun myWrapper(): LiveDataWrapper.Mutable {
        return LiveDataWrapper.Base()
    }


}