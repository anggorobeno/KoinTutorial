package com.example.kointutorial.di.module

import android.content.Context
import com.example.kointutorial.BuildConfig
import com.example.kointutorial.data.api.ApiHelper
import com.example.kointutorial.data.api.ApiHelperImpl
import com.example.kointutorial.data.api.ApiService
import com.example.kointutorial.utils.NetworkHelper
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


    val appModule = module {
        single { provideOkHttpClient() }
        single { provideRetrofit(get(), BuildConfig.BASE_URL) }
        single { provideApiService(get()) }
        single { provideNetworkHelper(androidContext()) }
        single<ApiHelper> {
            return@single ApiHelperImpl(get())
        }
    }

    private fun provideNetworkHelper(context: Context) = NetworkHelper(context)

    private fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else OkHttpClient
        .Builder()
        .build()

    private fun provideRetrofit(
        okHttpClient: OkHttpClient,
        BASE_URL: String
    ): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()

    private fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    private fun provideApiHelper(apiHelper: ApiHelperImpl): ApiHelper = apiHelper
