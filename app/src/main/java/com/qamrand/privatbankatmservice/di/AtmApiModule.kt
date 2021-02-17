package com.qamrand.privatbankatmservice.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.qamrand.privatbankatmservice.remote.api.AtmApi
import com.qamrand.privatbankatmservice.remote.api.AtmDataSource
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AtmApiModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.privatbank.ua/p24api/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttpClient)
        .build()

    @Provides
    fun provideOkHttp() = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().setLenient().create()

    @Singleton
    @Provides
    fun provideAtmApi(retrofit: Retrofit) : AtmApi = retrofit.create(AtmApi::class.java)

    @Singleton
    @Provides
    fun provideAtmDataSource(atmApi: AtmApi) : AtmDataSource = AtmDataSource(atmApi)


}