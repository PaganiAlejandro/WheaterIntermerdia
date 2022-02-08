package com.aplicacion.wheater.di

import com.aplicacion.wheater.data.network.CurrentCityNetworkResourceImpl
import com.aplicacion.wheater.data.services.WheaterService
import com.aplicacion.wheater.util.CoroutinesDispatcherProvider
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single { provideHttpClient() }
    single { provideRetrofit(get()) }

    single { get<Retrofit>().create(WheaterService::class.java)}

    single { CurrentCityNetworkResourceImpl(get(), get()) }

    single { CoroutinesDispatcherProvider(Dispatchers.Main, Dispatchers.Default, Dispatchers.IO) }
}

fun provideHttpClient(): OkHttpClient {
    val okHttpClientBuilder = OkHttpClient.Builder()
        .connectTimeout(40, TimeUnit.SECONDS)
        .readTimeout(40, TimeUnit.SECONDS)
    if (BuildConfig.DEBUG) {
        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        okHttpClientBuilder.addInterceptor(httpLoggingInterceptor)
    }
    okHttpClientBuilder.build()
    return okHttpClientBuilder.build()
}

fun provideRetrofit(client: OkHttpClient): Retrofit {
    val baseUrl = "https://api.openweathermap.org/data/2.5/"
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
}