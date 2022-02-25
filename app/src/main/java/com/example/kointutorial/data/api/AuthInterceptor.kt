package com.example.kointutorial.data.api

import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.Response

class AuthInterceptor : Interceptor {
  override fun intercept(chain: Chain): Response {
    val original = chain.request()
    val modified = original.url

    val modifiedUrl = modified.newBuilder()
      .addQueryParameter("api-key","asdjhasdhasjdh")
      .build()
    val requestBuilder = original.newBuilder().url(modifiedUrl).build()
    return chain.proceed(requestBuilder)
  }
}