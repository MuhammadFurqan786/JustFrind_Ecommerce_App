package com.iamport.sdk.domain.core;

import java.lang.System;

/**
 * 머천트와 소통하는 싱글턴 object 객체
 * 실제로는 IamportSdk 객체를 생성하여 동작함
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010&\u001a\u00020\u00062\u0006\u0010\'\u001a\u00020\u0005JD\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020/2\u0014\u00100\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00060\u0004J\b\u00101\u001a\u00020\u0006H\u0007J-\u00102\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u001f2\u0016\u00104\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0000\u00a2\u0006\u0002\b5JC\u00106\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u001f2\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0016\u00104\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0000\u00a2\u0006\u0002\b7J\u000e\u00108\u001a\u00020\u00062\u0006\u00109\u001a\u00020:J\u001a\u0010;\u001a\u00020\u00062\u0006\u00109\u001a\u00020:2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=J\b\u0010>\u001a\u00020\u0006H\u0002J\u0018\u0010?\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\u000f2\b\b\u0002\u0010A\u001a\u00020\u000fJ\u0010\u0010B\u001a\u00020\u00062\u0006\u0010C\u001a\u00020-H\u0002J\b\u0010D\u001a\u00020\u0006H\u0007J\b\u0010E\u001a\u0004\u0018\u00010=J\f\u0010F\u001a\b\u0012\u0004\u0012\u00020H0GJ\u000e\u0010I\u001a\u00020\u00062\u0006\u0010J\u001a\u00020KJ\u000e\u0010I\u001a\u00020\u00062\u0006\u0010L\u001a\u00020MJ\u0010\u0010N\u001a\u00020\u000f2\u0006\u0010O\u001a\u00020*H\u0002J\u0014\u0010P\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0R\u0018\u00010QJ\u0006\u0010S\u001a\u00020\u000fJ\b\u0010T\u001a\u00020\u000fH\u0002J\u0010\u0010U\u001a\u00020\u000f2\u0006\u00103\u001a\u00020\u001fH\u0002J\u0006\u0010V\u001a\u00020\u000fJ\u0014\u0010W\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020X0R\u0018\u00010QJ\\\u00103\u001a\u00020\u00062\u0006\u0010)\u001a\u00020*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010Y\u001a\u00020Z2\u0016\b\u0002\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0014\u00104\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00060\u0004J\u000e\u0010[\u001a\u00020\u00062\u0006\u0010C\u001a\u00020-R\u001c\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001f\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u0006\\"}, d2 = {"Lcom/iamport/sdk/domain/core/Iamport;", "", "()V", "approveCallback", "Lkotlin/Function1;", "Lcom/iamport/sdk/data/sdk/IamPortApprove;", "", "callback", "Lcom/iamport/sdk/data/sdk/IamPortResponse;", "getCallback", "()Lkotlin/jvm/functions/Function1;", "iamportSdk", "Lcom/iamport/sdk/presentation/activity/IamportSdk;", "impCallbackFunction", "isCreated", "", "preventOverlapRun", "Lcom/iamport/sdk/domain/utils/PreventOverlapRun;", "getPreventOverlapRun", "()Lcom/iamport/sdk/domain/utils/PreventOverlapRun;", "preventOverlapRun$delegate", "Lkotlin/Lazy;", "response", "getResponse", "()Lcom/iamport/sdk/data/sdk/IamPortResponse;", "setResponse", "(Lcom/iamport/sdk/data/sdk/IamPortResponse;)V", "webViewActivityContract", "Lcom/iamport/sdk/presentation/contract/WebViewActivityContract;", "webViewActivityLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/iamport/sdk/data/sdk/Payment;", "webViewCacheMode", "", "getWebViewCacheMode", "()I", "setWebViewCacheMode", "(I)V", "approvePayment", "approve", "certification", "userCode", "", "tierCode", "webviewMode", "Landroid/webkit/WebView;", "iamPortCertification", "Lcom/iamport/sdk/data/sdk/IamPortCertification;", "resultCallback", "close", "coreCertification", "payment", "paymentResultCallback", "coreCertification$sdk_debug", "corePayment", "corePayment$sdk_debug", "create", "app", "Landroid/app/Application;", "createWithKoin", "koinApp", "Lorg/koin/core/KoinApplication;", "disableWebViewMode", "enableChaiPollingForegroundService", "enableService", "enableFailStopButton", "enableWebViewMode", "webview", "failFinish", "getKoinApplition", "getKoinModules", "", "Lorg/koin/core/module/Module;", "init", "componentActivity", "Landroidx/activity/ComponentActivity;", "fragment", "Landroidx/fragment/app/Fragment;", "isCalledResponse", "impUid", "isPolling", "Landroidx/lifecycle/LiveData;", "Lcom/iamport/sdk/domain/utils/Event;", "isPollingValue", "isSDKCreate", "isSDKInit", "isWebViewMode", "mobileWebModeShouldOverrideUrlLoading", "Landroid/net/Uri;", "iamPortRequest", "Lcom/iamport/sdk/data/sdk/IamPortRequest;", "pluginMobileWebSupporter", "sdk_debug"})
public final class Iamport {
    @org.jetbrains.annotations.NotNull()
    public static final com.iamport.sdk.domain.core.Iamport INSTANCE = null;
    private static com.iamport.sdk.presentation.activity.IamportSdk iamportSdk;
    private static kotlin.jvm.functions.Function1<? super com.iamport.sdk.data.sdk.IamPortResponse, kotlin.Unit> impCallbackFunction;
    private static kotlin.jvm.functions.Function1<? super com.iamport.sdk.data.sdk.IamPortApprove, kotlin.Unit> approveCallback;
    private static androidx.activity.result.ActivityResultLauncher<com.iamport.sdk.data.sdk.Payment> webViewActivityLauncher;
    private static final com.iamport.sdk.presentation.contract.WebViewActivityContract webViewActivityContract = null;
    private static final kotlin.Lazy preventOverlapRun$delegate = null;
    private static boolean isCreated = false;
    private static int webViewCacheMode = android.webkit.WebSettings.LOAD_NO_CACHE;
    @org.jetbrains.annotations.Nullable()
    private static com.iamport.sdk.data.sdk.IamPortResponse response;
    
    /**
     * 전달받은 결제결과 콜백
     */
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.jvm.functions.Function1<com.iamport.sdk.data.sdk.IamPortResponse, kotlin.Unit> callback = null;
    
    private Iamport() {
        super();
    }
    
    private final com.iamport.sdk.domain.utils.PreventOverlapRun getPreventOverlapRun() {
        return null;
    }
    
    public final int getWebViewCacheMode() {
        return 0;
    }
    
    public final void setWebViewCacheMode(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.iamport.sdk.data.sdk.IamPortResponse getResponse() {
        return null;
    }
    
    public final void setResponse(@org.jetbrains.annotations.Nullable()
    com.iamport.sdk.data.sdk.IamPortResponse p0) {
    }
    
    private final boolean isSDKCreate() {
        return false;
    }
    
    private final boolean isSDKInit(com.iamport.sdk.data.sdk.Payment payment) {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.koin.core.KoinApplication getKoinApplition() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<org.koin.core.module.Module> getKoinModules() {
        return null;
    }
    
    public final void create(@org.jetbrains.annotations.NotNull()
    android.app.Application app) {
    }
    
    /**
     * Application instance 를 통해, DI 초기화
     */
    public final void createWithKoin(@org.jetbrains.annotations.NotNull()
    android.app.Application app, @org.jetbrains.annotations.Nullable()
    org.koin.core.KoinApplication koinApp) {
    }
    
    /**
     * 외부에서 SDK 종료
     */
    @androidx.annotation.MainThread()
    public final void close() {
    }
    
    /**
     * 외부에서 SDK 실패 종료
     */
    @androidx.annotation.MainThread()
    public final void failFinish() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.iamport.sdk.data.sdk.IamPortResponse, kotlin.Unit> getCallback() {
        return null;
    }
    
    private final boolean isCalledResponse(java.lang.String impUid) {
        return false;
    }
    
    /**
     * SDK Activity 열기 위한 Contract for Activity
     * @param componentActivity : Host Activity
     */
    public final void init(@org.jetbrains.annotations.NotNull()
    androidx.activity.ComponentActivity componentActivity) {
    }
    
    /**
     * SDK Activity 열기 위한 Contract for Fragment
     * @param fragment : Host Fragment
     */
    public final void init(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment fragment) {
    }
    
    /**
     * 결제 요청
     * @param ((IamPortApprove?) -> Unit)? : (옵셔널) 차이 최종 결제 요청전 콜백
     * @param (IamPortResponse?) -> Unit: ICallbackPaymentResult? : 결제결과 callbck type#2 함수 호출
     */
    public final void payment(@org.jetbrains.annotations.NotNull()
    java.lang.String userCode, @org.jetbrains.annotations.Nullable()
    java.lang.String tierCode, @org.jetbrains.annotations.Nullable()
    android.webkit.WebView webviewMode, @org.jetbrains.annotations.NotNull()
    com.iamport.sdk.data.sdk.IamPortRequest iamPortRequest, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super com.iamport.sdk.data.sdk.IamPortApprove, kotlin.Unit> approveCallback, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.iamport.sdk.data.sdk.IamPortResponse, kotlin.Unit> paymentResultCallback) {
    }
    
    /**
     * 결제 요청
     * @param ((IamPortApprove?) -> Unit)? : (옵셔널) 차이 최종 결제 요청전 콜백
     * @param (IamPortResponse?) -> Unit: ICallbackPaymentResult? : 결제결과 callbck type#2 함수 호출
     */
    public final void certification(@org.jetbrains.annotations.NotNull()
    java.lang.String userCode, @org.jetbrains.annotations.Nullable()
    java.lang.String tierCode, @org.jetbrains.annotations.Nullable()
    android.webkit.WebView webviewMode, @org.jetbrains.annotations.NotNull()
    com.iamport.sdk.data.sdk.IamPortCertification iamPortCertification, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.iamport.sdk.data.sdk.IamPortResponse, kotlin.Unit> resultCallback) {
    }
    
    public final void coreCertification$sdk_debug(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.data.sdk.Payment payment, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super com.iamport.sdk.data.sdk.IamPortResponse, kotlin.Unit> paymentResultCallback) {
    }
    
    public final void corePayment$sdk_debug(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.data.sdk.Payment payment, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super com.iamport.sdk.data.sdk.IamPortApprove, kotlin.Unit> approveCallback, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super com.iamport.sdk.data.sdk.IamPortResponse, kotlin.Unit> paymentResultCallback) {
    }
    
    private final void enableWebViewMode(android.webkit.WebView webview) {
    }
    
    private final void disableWebViewMode() {
    }
    
    public final boolean isWebViewMode() {
        return false;
    }
    
    public final void pluginMobileWebSupporter(@org.jetbrains.annotations.NotNull()
    android.webkit.WebView webview) {
    }
    
    /**
     * MobileWebMode 일 때, 웹뷰의 url 이 변경되면 값이 전달됨
     */
    @org.jetbrains.annotations.Nullable()
    public final androidx.lifecycle.LiveData<com.iamport.sdk.domain.utils.Event<android.net.Uri>> mobileWebModeShouldOverrideUrlLoading() {
        return null;
    }
    
    public final void enableChaiPollingForegroundService(boolean enableService, boolean enableFailStopButton) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.lifecycle.LiveData<com.iamport.sdk.domain.utils.Event<java.lang.Boolean>> isPolling() {
        return null;
    }
    
    public final boolean isPollingValue() {
        return false;
    }
    
    /**
     * 외부에서 차이 최종결제 요청
     */
    public final void approvePayment(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.data.sdk.IamPortApprove approve) {
    }
}