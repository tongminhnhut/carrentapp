package com.tongminhnhut.carrent.di

import com.tongminhnhut.carrent.data.remote.ApiInterface
import com.tongminhnhut.carrent.network.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModules {
    @Singleton
    @Provides
    @Named("base_url")
    fun getBaseUrl(): String = BASE_URL

    @Singleton
    @Provides
    fun getRetrofitClient(
        @Named("base_url") baseUrl: String,
    ): Retrofit =
        Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(
                GsonConverterFactory.create(),
            ).build()

    @Singleton
    @Provides
    fun getApiClient(retrofit: Retrofit): ApiInterface = retrofit.create(ApiInterface::class.java)
}
