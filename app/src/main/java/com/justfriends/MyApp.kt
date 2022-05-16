package com.justfriends

import android.app.Application
import android.util.Log
import com.kakao.sdk.common.KakaoSdk
import com.kakao.sdk.common.util.Utility

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        KakaoSdk.init(this,getString(R.string.kakao_native_app_key)) //your native app key

        val keyHash: String = Utility.getKeyHash(this /* context */)
        Log.d("TAG", "onCreate: keyHash = $keyHash")
    }
}