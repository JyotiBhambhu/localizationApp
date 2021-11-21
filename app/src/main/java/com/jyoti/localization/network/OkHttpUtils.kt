package com.jyoti.localization.network

import okhttp3.OkHttpClient
import okhttp3.Request
import java.util.concurrent.TimeUnit


object OkHttpUtils {

    private const val TIME_OUT: Long = 1
    private val okhttpClient: OkHttpClient by lazy {
        val builder = OkHttpClient.Builder()
        .readTimeout(TIME_OUT, TimeUnit.MINUTES)
        .writeTimeout(TIME_OUT, TimeUnit.MINUTES)
        .connectTimeout(TIME_OUT, TimeUnit.MINUTES)

        builder.retryOnConnectionFailure(true)
        builder.build()
    }

    fun get(url: String): String {
        val request = Request.Builder()
            .url(url)
            .build()

        okhttpClient.newCall(request).execute().use { response ->
            if (!response.isSuccessful) {
                throw Throwable("Unexpected code $response")
            }

            response.body?.string()?.let { res ->
                return res
            } ?:  throw Throwable("No Data Found")
        }
    }
}