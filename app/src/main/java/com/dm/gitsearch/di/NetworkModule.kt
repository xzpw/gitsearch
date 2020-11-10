package com.dm.gitsearch.di

import com.dm.gitsearch.api.BASE_URL
import com.dm.gitsearch.api.ServiceApi
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val netWorkModule = module {

    single<Call.Factory> { okHttp() }
    single { retrofit(get()) }
    single { githubApiProvider(get()) }
}

fun okHttp() = OkHttpClient.Builder()
    .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
    .build()

fun retrofit(callFactory: Call.Factory) = Retrofit.Builder()
    .callFactory(callFactory)
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

fun githubApiProvider(retrofit: Retrofit) = retrofit.create(ServiceApi::class.java)

