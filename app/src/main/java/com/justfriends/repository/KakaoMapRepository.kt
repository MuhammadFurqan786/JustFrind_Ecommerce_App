package com.justfriends.repository

import com.justfriends.model.FilterResModel
import com.justfriends.model.KakaoMapResModel
import com.justfriends.network.RetrofitService
import com.justfriends.viewModel.KakaoMapViewModel
import java.lang.Exception

class KakaoMapRepository(private val apiService: RetrofitService) : BaseRepository() {
    suspend fun getKakaoMap(
        token: String,
        query: String
    ): KakaoMapResModel? {
        return try {
            safeApiCall(
                call = {
                    apiService.getKakaoMapAsync(token, query).await()
                }, error = " Error from server" + ""
            )
        } catch (e: Exception) {
            null
        }
    }
}