package com.iamport.sdk.presentation.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\bH&J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/iamport/sdk/presentation/activity/BaseMain;", "", "movePlayStore", "", "intent", "Landroid/content/Intent;", "observeViewModel", "payment", "Lcom/iamport/sdk/data/sdk/Payment;", "openThirdPartyApp", "it", "Landroid/net/Uri;", "openWebView", "requestPayment", "sdkFinish", "iamPortResponse", "Lcom/iamport/sdk/data/sdk/IamPortResponse;", "settingsWebView", "webView", "Landroid/webkit/WebView;", "sdk_debug"})
public abstract interface BaseMain {
    
    public abstract void openWebView(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.data.sdk.Payment payment);
    
    public abstract void openThirdPartyApp(@org.jetbrains.annotations.NotNull()
    android.net.Uri it);
    
    public abstract void observeViewModel(@org.jetbrains.annotations.Nullable()
    com.iamport.sdk.data.sdk.Payment payment);
    
    public abstract void requestPayment(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.data.sdk.Payment it);
    
    public abstract void sdkFinish(@org.jetbrains.annotations.Nullable()
    com.iamport.sdk.data.sdk.IamPortResponse iamPortResponse);
    
    public abstract void movePlayStore(@org.jetbrains.annotations.NotNull()
    android.content.Intent intent);
    
    /**
     * 웹뷰 기본 세팅
     */
    public abstract void settingsWebView(@org.jetbrains.annotations.NotNull()
    android.webkit.WebView webView);
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 3)
    public final class DefaultImpls {
        
        /**
         * 웹뷰 기본 세팅
         */
        public static void settingsWebView(@org.jetbrains.annotations.NotNull()
        com.iamport.sdk.presentation.activity.BaseMain $this, @org.jetbrains.annotations.NotNull()
        android.webkit.WebView webView) {
        }
    }
}