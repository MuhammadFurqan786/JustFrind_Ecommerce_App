package com.justfriends.network

import com.google.gson.JsonObject
import com.justfriends.model.AddressResModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface GetDateService {

    @POST("address/add")
    fun addNewAddress(
        @Header("Authorization") token: String?,
        @Body newAddressBody: JsonObject,
    ): Call<AddressResModel?>?
}