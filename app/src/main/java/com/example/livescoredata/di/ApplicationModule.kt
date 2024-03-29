package com.example.livescoredata.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.livescoredata.data.service.ServiceApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(@ApplicationContext context: Context): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(ChuckerInterceptor(context))
            .build()
    }

    @Provides
    @Singleton
    fun provideServiceApi(okHttpClient: OkHttpClient): ServiceApi {
        return Retrofit.Builder().baseUrl("https://apivx.misli.com/api/mobile/v2/")
            .client(okHttpClient).addConverterFactory(
            GsonConverterFactory.create()
        )
            .build().create(ServiceApi::class.java)
    }

}