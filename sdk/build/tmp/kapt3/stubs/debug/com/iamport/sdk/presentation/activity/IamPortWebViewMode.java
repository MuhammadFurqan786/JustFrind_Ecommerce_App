package com.iamport.sdk.presentation.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\u0006\u0010&\u001a\u00020\u0017J6\u0010\'\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!2\u0006\u0010(\u001a\u00020)2\u0016\u0010\u0014\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0015J\u0010\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020,H\u0016J\u0012\u0010-\u001a\u00020\u00172\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0010\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)H\u0016J\t\u00102\u001a\u00020\u0017H\u0096\u0001J\b\u00103\u001a\u00020\u0017H\u0002J\u0010\u00104\u001a\u00020\u00172\u0006\u0010/\u001a\u00020)H\u0016J\u0012\u00105\u001a\u00020\u00172\b\u00106\u001a\u0004\u0018\u00010\u0016H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u0011X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R*\u0010\u0014\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u00067"}, d2 = {"Lcom/iamport/sdk/presentation/activity/IamPortWebViewMode;", "Lcom/iamport/sdk/domain/di/IamportKoinComponent;", "Lcom/iamport/sdk/presentation/activity/BaseMain;", "Lcom/iamport/sdk/domain/utils/BaseCoroutineScope;", "scope", "(Lcom/iamport/sdk/domain/utils/BaseCoroutineScope;)V", "activity", "Landroidx/activity/ComponentActivity;", "getActivity", "()Landroidx/activity/ComponentActivity;", "setActivity", "(Landroidx/activity/ComponentActivity;)V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "job", "Lkotlinx/coroutines/Job;", "getJob", "()Lkotlinx/coroutines/Job;", "paymentResultCallBack", "Lkotlin/Function1;", "Lcom/iamport/sdk/data/sdk/IamPortResponse;", "", "getPaymentResultCallBack", "()Lkotlin/jvm/functions/Function1;", "setPaymentResultCallBack", "(Lkotlin/jvm/functions/Function1;)V", "viewModel", "Lcom/iamport/sdk/presentation/viewmodel/WebViewModel;", "getViewModel", "()Lcom/iamport/sdk/presentation/viewmodel/WebViewModel;", "webview", "Landroid/webkit/WebView;", "getWebview", "()Landroid/webkit/WebView;", "setWebview", "(Landroid/webkit/WebView;)V", "close", "initStart", "payment", "Lcom/iamport/sdk/data/sdk/Payment;", "movePlayStore", "intent", "Landroid/content/Intent;", "observeViewModel", "openThirdPartyApp", "it", "Landroid/net/Uri;", "openWebView", "releaseCoroutine", "removeObservers", "requestPayment", "sdkFinish", "iamPortResponse", "sdk_debug"})
public class IamPortWebViewMode implements com.iamport.sdk.domain.di.IamportKoinComponent, com.iamport.sdk.presentation.activity.BaseMain, com.iamport.sdk.domain.utils.BaseCoroutineScope {
    @org.jetbrains.annotations.NotNull()
    private final com.iamport.sdk.presentation.viewmodel.WebViewModel viewModel = null;
    @org.jetbrains.annotations.Nullable()
    private androidx.activity.ComponentActivity activity;
    @org.jetbrains.annotations.Nullable()
    private android.webkit.WebView webview;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function1<? super com.iamport.sdk.data.sdk.IamPortResponse, kotlin.Unit> paymentResultCallBack;
    
    @kotlin.jvm.JvmOverloads()
    public IamPortWebViewMode() {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public IamPortWebViewMode(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.domain.utils.BaseCoroutineScope scope) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.iamport.sdk.presentation.viewmodel.WebViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.activity.ComponentActivity getActivity() {
        return null;
    }
    
    public final void setActivity(@org.jetbrains.annotations.Nullable()
    androidx.activity.ComponentActivity p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.webkit.WebView getWebview() {
        return null;
    }
    
    public final void setWebview(@org.jetbrains.annotations.Nullable()
    android.webkit.WebView p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlin.jvm.functions.Function1<com.iamport.sdk.data.sdk.IamPortResponse, kotlin.Unit> getPaymentResultCallBack() {
        return null;
    }
    
    public final void setPaymentResultCallBack(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super com.iamport.sdk.data.sdk.IamPortResponse, kotlin.Unit> p0) {
    }
    
    /**
     * BaseActivity 에서 onCreate 시 호출
     */
    public final void initStart(@org.jetbrains.annotations.NotNull()
    androidx.activity.ComponentActivity activity, @org.jetbrains.annotations.NotNull()
    android.webkit.WebView webview, @org.jetbrains.annotations.NotNull()
    com.iamport.sdk.data.sdk.Payment payment, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super com.iamport.sdk.data.sdk.IamPortResponse, kotlin.Unit> paymentResultCallBack) {
    }
    
    /**
     * 관찰할 LiveData 옵저빙
     */
    @java.lang.Override()
    public void observeViewModel(@org.jetbrains.annotations.Nullable()
    com.iamport.sdk.data.sdk.Payment payment) {
    }
    
    /**
     * 결제 요청 실행
     */
    @java.lang.Override()
    public void requestPayment(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.data.sdk.Payment it) {
    }
    
    private final void removeObservers() {
    }
    
    public final void close() {
    }
    
    /**
     * 모든 결과 처리 및 SDK 종료
     * IamportSdk 안건너고, 바로 콜백 호출하여 종료.
     */
    @java.lang.Override()
    public void sdkFinish(@org.jetbrains.annotations.Nullable()
    com.iamport.sdk.data.sdk.IamPortResponse iamPortResponse) {
    }
    
    /**
     * 외부앱 열기
     */
    @java.lang.Override()
    public void openThirdPartyApp(@org.jetbrains.annotations.NotNull()
    android.net.Uri it) {
    }
    
    /**
     * 앱 패키지 검색하여 플레이 스토어로 이동
     */
    @java.lang.Override()
    public void movePlayStore(@org.jetbrains.annotations.NotNull()
    android.content.Intent intent) {
    }
    
    /**
     * 웹뷰 오픈
     */
    @java.lang.Override()
    public void openWebView(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.data.sdk.Payment payment) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.coroutines.CoroutineContext getCoroutineContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.Job getJob() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public org.koin.core.Koin getKoin() {
        return null;
    }
    
    /**
     * Coroutine job cancel
     */
    @java.lang.Override()
    public void releaseCoroutine() {
    }
    
    /**
     * 웹뷰 기본 세팅
     */
    public void settingsWebView(@org.jetbrains.annotations.NotNull()
    android.webkit.WebView webView) {
    }
}