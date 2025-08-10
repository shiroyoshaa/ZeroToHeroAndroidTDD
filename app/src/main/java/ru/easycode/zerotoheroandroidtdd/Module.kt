package ru.easycode.zerotoherandroidtdd

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import ru.easycode.zerotoheroandroidtdd.LiveDataWrapper
import ru.easycode.zerotoheroandroidtdd.Repository
import ru.easycode.zerotoheroandroidtdd.SimpleResponse
import ru.easycode.zerotoheroandroidtdd.SimpleService


@Module
@InstallIn(SingletonComponent::class)

object Module {
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://www.google.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun provideSimpleServices(retrofit: Retrofit):
            SimpleService = retrofit.create(SimpleService::class.java)

    @Provides
    fun myRepo(service: SimpleService): Repository {
        return Repository.Base(
            service = service,
            url = "https://raw.githubusercontent.com/JohnnySC/ZeroToHeroAndroidTDD/task/018-clouddatasource/app/sampleresponse.json"
        )
    }
    @Provides
    fun myWrapper(): LiveDataWrapper{
        return LiveDataWrapper.Base()
    }
}