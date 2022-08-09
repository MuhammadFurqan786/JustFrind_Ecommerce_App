package com.iamport.sdk.domain;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\bH\u0007J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\bH\u0007J\u001c\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\t2\u0006\u0010!\u001a\u00020\"H\u0002J\u0018\u0010$\u001a\u00020\t2\u0006\u0010!\u001a\u00020\"2\u0006\u0010%\u001a\u00020\bH\u0002J\b\u0010&\u001a\u00020\tH\u0007R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\'"}, d2 = {"Lcom/iamport/sdk/domain/JsNativeInterface;", "Lcom/iamport/sdk/domain/di/IamportKoinComponent;", "payment", "Lcom/iamport/sdk/data/sdk/Payment;", "gson", "Lcom/google/gson/Gson;", "evaluateJS", "Lkotlin/Function1;", "", "", "(Lcom/iamport/sdk/data/sdk/Payment;Lcom/google/gson/Gson;Lkotlin/jvm/functions/Function1;)V", "bus", "Lcom/iamport/sdk/domain/utils/WebViewLiveDataEventBus;", "getBus", "()Lcom/iamport/sdk/domain/utils/WebViewLiveDataEventBus;", "bus$delegate", "Lkotlin/Lazy;", "getEvaluateJS", "()Lkotlin/jvm/functions/Function1;", "getGson", "()Lcom/google/gson/Gson;", "getPayment", "()Lcom/iamport/sdk/data/sdk/Payment;", "certification", "Lcom/iamport/sdk/data/sdk/IamPortCertification;", "customCallback", "response", "debugConsoleLog", "logStr", "initSDK", "userCode", "tierCode", "requestPay", "request", "Lcom/iamport/sdk/data/sdk/IamPortRequest;", "requestPayNormal", "requestPayWithCustomData", "customData", "startWorkingSdk", "sdk_debug"})
public final class JsNativeInterface implements com.iamport.sdk.domain.di.IamportKoinComponent {
    @org.jetbrains.annotations.NotNull()
    private final com.iamport.sdk.data.sdk.Payment payment = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.gson.Gson gson = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> evaluateJS = null;
    private final kotlin.Lazy bus$delegate = null;
    
    public JsNativeInterface(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.data.sdk.Payment payment, @org.jetbrains.annotations.NotNull()
    com.google.gson.Gson gson, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> evaluateJS) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.iamport.sdk.data.sdk.Payment getPayment() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.gson.Gson getGson() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> getEvaluateJS() {
        return null;
    }
    
    private final com.iamport.sdk.domain.utils.WebViewLiveDataEventBus getBus() {
        return null;
    }
    
    /**
     * 아임포트 JS SDK 에서 콜백 호출시에 해당 함수 동작
     */
    @android.webkit.JavascriptInterface()
    public final void customCallback(@org.jetbrains.annotations.NotNull()
    java.lang.String response) {
    }
    
    /**
     * 아임포트 JS SDK 에서 콜백 호출시에 해당 함수 동작
     */
    @android.webkit.JavascriptInterface()
    public final void debugConsoleLog(@org.jetbrains.annotations.NotNull()
    java.lang.String logStr) {
    }
    
    /**
     * 아임포트 JS SDK 에서 콜백 호출시에 해당 함수 동작
     */
    @android.webkit.JavascriptInterface()
    public final void startWorkingSdk() {
    }
    
    private final void initSDK(java.lang.String userCode, java.lang.String tierCode) {
    }
    
    private final void requestPay(com.iamport.sdk.data.sdk.IamPortRequest request) {
    }
    
    private final void requestPayNormal(com.iamport.sdk.data.sdk.IamPortRequest request) {
    }
    
    private final void requestPayWithCustomData(com.iamport.sdk.data.sdk.IamPortRequest request, java.lang.String customData) {
    }
    
    private final void certification(com.iamport.sdk.data.sdk.IamPortCertification certification) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public org.koin.core.Koin getKoin() {
        return null;
    }
}