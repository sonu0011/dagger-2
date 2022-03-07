package com.sonu.dagger2example.example.di

import com.sonu.dagger2example.example.retrofit.FakeApi
import com.sonu.dagger2example.example.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    @Singleton
    @Provides
    fun provideFakeApiService(
        retrofit: Retrofit
    ): FakeApi {
        return retrofit.create(FakeApi::class.java)
    }
}