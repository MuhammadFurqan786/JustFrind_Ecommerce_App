package com.justfriends.network

import android.content.ActivityNotFoundException
import android.util.Log
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object ApiFactory {

    private const val API_TIMEOUT: Long = 60

    private const val BASE_URL = "http://ec2-54-219-170-27.us-west-1.compute.amazonaws.com/api/"
    const val IMAGE_BASE_URL = "http://ec2-54-219-170-27.us-west-1.compute.amazonaws.com/"



    fun makeServiceApi(): RetrofitService {
        val okHttpClient = makeOkHttpClient(makeOkHttpLoggingInterceptor())
        return makeRetrofit(okHttpClient, makeGson()).create(RetrofitService::class.java)
    }
    fun makeServiceCallApi(): RetrofitService {
        val okHttpClient = makeOkHttpClient(makeOkHttpLoggingInterceptor())
        return makeRetrofitCall(okHttpClient, makeGson()).create(RetrofitService::class.java)
    }

    private fun makeOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        try {
            return OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(API_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(API_TIMEOUT, TimeUnit.SECONDS)
                .build()
        } catch (e: ActivityNotFoundException) {
            e.printStackTrace()
        }
        return OkHttpClient() 

    }

    private fun makeRetrofit(okHttpClient: OkHttpClient,gson: Gson): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .baseUrl(BASE_URL)
            .build()
    }
    private fun makeRetrofitCall(okHttpClient: OkHttpClient,gson: Gson): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BASE_URL)
            .build()
    }




    private fun makeGson(): Gson{
        return GsonBuilder()
            .setLenient()
            .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
            .create()

    }

    private fun makeOkHttpLoggingInterceptor(): HttpLoggingInterceptor{
        val loggingInterceptor = HttpLoggingInterceptor(httpLogger)
        loggingInterceptor.level  = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    private val httpLogger : HttpLoggingInterceptor.Logger by  lazy {
        HttpLoggingInterceptor.Logger { message ->
            Log.println(
                Log.VERBOSE,
                "WEB_SERVICE",
                "RESPONSE_VALUE $message"
            )
        }

    }
}