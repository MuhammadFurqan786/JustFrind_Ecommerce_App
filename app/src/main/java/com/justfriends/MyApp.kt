package com.justfriends

import android.app.Application
import android.util.Log
import com.kakao.sdk.common.KakaoSdk
import com.kakao.sdk.common.util.Utility
import com.sendbird.android.SendBird
import com.sendbird.android.SendBirdPushHelper




class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        KakaoSdk.init(this,getString(R.string.kakao_native_app_key)) //your native app key
        SendBird.init("4DE366EB-4DE6-4C42-9915-3C0AE29BF89D", this)
        SendBirdPushHelper.registerPushHandler(MyFirebaseMessagingService())
        val keyHash: String = Utility.getKeyHash(this /* context */)
        Log.d("TAG", "onCreate: keyHash = $keyHash")
    }
}