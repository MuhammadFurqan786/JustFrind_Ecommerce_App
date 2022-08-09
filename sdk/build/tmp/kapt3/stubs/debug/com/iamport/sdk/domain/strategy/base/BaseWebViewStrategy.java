package com.iamport.sdk.domain.strategy.base;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0016H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0004J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0004J\u0018\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\"\u0010#\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J&\u0010&\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0017J\u0012\u0010+\u001a\u00020\u00162\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u001e\u0010.\u001a\u0004\u0018\u00010/2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u00100\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0010H\u0004R\u001b\u0010\u0004\u001a\u00020\u00058DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00061"}, d2 = {"Lcom/iamport/sdk/domain/strategy/base/BaseWebViewStrategy;", "Landroid/webkit/WebViewClient;", "Lcom/iamport/sdk/domain/strategy/base/IStrategy;", "()V", "bus", "Lcom/iamport/sdk/domain/utils/WebViewLiveDataEventBus;", "getBus", "()Lcom/iamport/sdk/domain/utils/WebViewLiveDataEventBus;", "bus$delegate", "Lkotlin/Lazy;", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "payment", "Lcom/iamport/sdk/data/sdk/Payment;", "getPayment", "()Lcom/iamport/sdk/data/sdk/Payment;", "setPayment", "(Lcom/iamport/sdk/data/sdk/Payment;)V", "doWork", "", "(Lcom/iamport/sdk/data/sdk/Payment;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "init", "isAppUrl", "", "uri", "Landroid/net/Uri;", "isPaymentOver", "onPageFinished", "view", "Landroid/webkit/WebView;", "url", "", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onReceivedError", "request", "Landroid/webkit/WebResourceRequest;", "error", "Landroid/webkit/WebResourceError;", "sdkFinish", "response", "Lcom/iamport/sdk/data/sdk/IamPortResponse;", "shouldInterceptRequest", "Landroid/webkit/WebResourceResponse;", "successFinish", "sdk_debug"})
public class BaseWebViewStrategy extends android.webkit.WebViewClient implements com.iamport.sdk.domain.strategy.base.IStrategy {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy gson$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy bus$delegate = null;
    public com.iamport.sdk.data.sdk.Payment payment;
    
    public BaseWebViewStrategy() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final com.google.gson.Gson getGson() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final com.iamport.sdk.domain.utils.WebViewLiveDataEventBus getBus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.iamport.sdk.data.sdk.Payment getPayment() {
        return null;
    }
    
    public final void setPayment(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.data.sdk.Payment p0) {
    }
    
    @java.lang.Override()
    public void init() {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object doWork(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.data.sdk.Payment payment, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    /**
     * SDK 종료
     */
    @java.lang.Override()
    public void sdkFinish(@org.jetbrains.annotations.Nullable()
    com.iamport.sdk.data.sdk.IamPortResponse response) {
    }
    
    @java.lang.Override()
    public void onPageStarted(@org.jetbrains.annotations.NotNull()
    android.webkit.WebView view, @org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.Nullable()
    android.graphics.Bitmap favicon) {
    }
    
    @java.lang.Override()
    public void onPageFinished(@org.jetbrains.annotations.NotNull()
    android.webkit.WebView view, @org.jetbrains.annotations.NotNull()
    java.lang.String url) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.M)
    @java.lang.Override()
    public void onReceivedError(@org.jetbrains.annotations.Nullable()
    android.webkit.WebView view, @org.jetbrains.annotations.Nullable()
    android.webkit.WebResourceRequest request, @org.jetbrains.annotations.Nullable()
    android.webkit.WebResourceError error) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.webkit.WebResourceResponse shouldInterceptRequest(@org.jetbrains.annotations.Nullable()
    android.webkit.WebView view, @org.jetbrains.annotations.Nullable()
    android.webkit.WebResourceRequest request) {
        return null;
    }
    
    /**
     * 성공해서 SDK 종료
     */
    protected final void successFinish(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.data.sdk.Payment payment) {
    }
    
    /**
     * 앱 uri 인지 여부
     */
    protected final boolean isAppUrl(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri) {
        return false;
    }
    
    /**
     * 결제 끝났는지 여부
     */
    protected final boolean isPaymentOver(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri) {
        return false;
    }
    
    public void failureFinish(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.data.sdk.Payment payment, @org.jetbrains.annotations.Nullable()
    com.iamport.sdk.data.chai.response.PrepareData prepareData, @org.jetbrains.annotations.NotNull()
    java.lang.String msg) {
    }
    
    public void failureFinish(@org.jetbrains.annotations.NotNull()
    java.lang.String merchantUid, @org.jetbrains.annotations.NotNull()
    java.lang.String impUid, @org.jetbrains.annotations.NotNull()
    java.lang.String msg) {
    }
    
    public void successFinish(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.data.sdk.Payment payment, @org.jetbrains.annotations.Nullable()
    com.iamport.sdk.data.chai.response.PrepareData prepareData, @org.jetbrains.annotations.NotNull()
    java.lang.String msg) {
    }
    
    public void successFinish(@org.jetbrains.annotations.NotNull()
    java.lang.String merchantUid, @org.jetbrains.annotations.NotNull()
    java.lang.String impUid, @org.jetbrains.annotations.NotNull()
    java.lang.String msg) {
    }
}