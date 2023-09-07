package com.example.actionquoteswidget.data.di


import com.example.actionquoteswidget.data.services.network.QuotesApiClient
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RetroFitModule {


    fun providesOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return  OkHttpClient.Builder().readTimeout(20, TimeUnit.SECONDS)
            .connectTimeout(20, TimeUnit.SECONDS)
            .build() }

    fun providesRetrofitLyrics(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(providesOkHttpClient())
            .build()
    }

    fun providesQuotesApiClient(): QuotesApiClient {
        return providesRetrofitLyrics().create(QuotesApiClient::class.java)
    }

}