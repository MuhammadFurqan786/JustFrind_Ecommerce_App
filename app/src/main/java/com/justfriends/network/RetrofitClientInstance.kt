package com.justfriends.network

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import com.justfriends.network.RetrofitClientInstance
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClientInstance {
    var gson = GsonBuilder()
        .setLenient()
        .create()
    private var retrofit: Retrofit? = null
    private const val BASE_URL = "http://ec2-54-219-170-27.us-west-1.compute.amazonaws.com/api/"
    val retrofitInstance: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
            }
            return retrofit
        }
}