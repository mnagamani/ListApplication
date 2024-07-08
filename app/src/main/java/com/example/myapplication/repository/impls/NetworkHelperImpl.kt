package com.example.myapplication.repository.impls

import com.example.myapplication.repository.interfaces.NetworkHelper
import com.example.myapplication.service.api.RetrofitService
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

/**
 * provides Retrofit service
 */
class NetworkHelperImpl @Inject constructor(): NetworkHelper {
    /**
     * function to build retrofit service
     */
    override fun getService(): RetrofitService {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        val client = OkHttpClient.Builder()
        return Retrofit.Builder()
            .baseUrl("https://fetch-hiring.s3.amazonaws.com/")
            .addConverterFactory(GsonConverterFactory.create(gsonBuilder.create()))
            .client(client.build())
            .build()
            .create(RetrofitService::class.java)
    }
}