package com.iamport.sdk.presentation.activity;

import java.lang.System;

/**
 * 사실상 여기가 activity 같은 역할
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u0001B9\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u00a2\u0006\u0002\u0010\nJ\u0010\u0010<\u001a\u00020\u00102\u0006\u0010=\u001a\u00020\u000fH\u0002J\u0010\u0010>\u001a\u00020&2\u0006\u0010?\u001a\u00020)H\u0002J\b\u0010@\u001a\u00020\u0010H\u0002J\u0006\u0010A\u001a\u00020\u0010J\b\u0010B\u001a\u00020\u0010H\u0002J\u0006\u0010C\u001a\u00020\u0010J\u0014\u0010D\u001a\u00020\u00102\f\u0010E\u001a\b\u0012\u0004\u0012\u0002000\u0003J\u0006\u0010F\u001a\u00020\u0010J\u0012\u0010G\u001a\u0004\u0018\u00010)2\u0006\u0010H\u001a\u00020IH\u0002J\b\u0010J\u001a\u00020\u0010H\u0002J\u0006\u0010K\u001a\u00020\u0010J<\u0010L\u001a\u00020\u00102\u0006\u0010M\u001a\u00020\t2\u0014\u0010N\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000e2\u0016\u00101\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u000102\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000eJ&\u0010L\u001a\u00020\u00102\u0006\u0010M\u001a\u00020\t2\u0016\u00101\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u000102\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000eJ\u0012\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%0OJ\u0006\u0010P\u001a\u00020&J\u0014\u0010Q\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020R0%\u0018\u00010OJ\u0010\u0010S\u001a\u00020\u00102\u0006\u0010H\u001a\u00020IH\u0002J\u0010\u0010T\u001a\u00020\u00102\u0006\u0010M\u001a\u00020\tH\u0002J\u0010\u0010U\u001a\u00020\u00102\u0006\u0010M\u001a\u00020\tH\u0002J\u0010\u0010V\u001a\u00020\u00102\u0006\u0010W\u001a\u00020)H\u0002J\u0014\u0010X\u001a\u00020\u00102\f\u0010E\u001a\b\u0012\u0004\u0012\u0002000\u0003J\u000e\u0010Y\u001a\u00020\u00102\u0006\u0010=\u001a\u00020\u000fJ\u0010\u0010Z\u001a\u00020\u00102\u0006\u0010M\u001a\u00020\tH\u0002J\u001a\u0010[\u001a\u00020\u00102\u0006\u0010M\u001a\u00020\t2\b\b\u0002\u0010\\\u001a\u00020&H\u0002J\u0010\u0010]\u001a\u00020\u00102\u0006\u0010M\u001a\u00020\tH\u0002J\b\u0010^\u001a\u00020\u0010H\u0002J\u0012\u0010_\u001a\u00020\u00102\b\u0010`\u001a\u0004\u0018\u000102H\u0002J\u0010\u0010a\u001a\u00020\u00102\u0006\u0010W\u001a\u00020&H\u0002R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\fR\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010\u0016\u001a\u0004\b \u0010!R\u001a\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%0$X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\'\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)0(\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010*\u001a\u0004\u0018\u00010+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010\u0016\u001a\u0004\b,\u0010-R\u0016\u0010/\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u00101\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u000102\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u00103\u001a\u0002048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b7\u0010\u0016\u001a\u0004\b5\u00106R\u000e\u00108\u001a\u000209X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010;\u00a8\u0006b"}, d2 = {"Lcom/iamport/sdk/presentation/activity/IamportSdk;", "Lcom/iamport/sdk/domain/di/IamportKoinComponent;", "activity", "Ljava/lang/ref/WeakReference;", "Landroidx/activity/ComponentActivity;", "fragment", "Landroidx/fragment/app/Fragment;", "webViewActivityLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/iamport/sdk/data/sdk/Payment;", "(Ljava/lang/ref/WeakReference;Ljava/lang/ref/WeakReference;Landroidx/activity/result/ActivityResultLauncher;)V", "getActivity", "()Ljava/lang/ref/WeakReference;", "chaiApproveCallBack", "Lkotlin/Function1;", "Lcom/iamport/sdk/data/sdk/IamPortApprove;", "", "chaiContract", "Lcom/iamport/sdk/presentation/contract/ChaiContract;", "getChaiContract", "()Lcom/iamport/sdk/presentation/contract/ChaiContract;", "chaiContract$delegate", "Lkotlin/Lazy;", "getFragment", "hostHelper", "Lcom/iamport/sdk/domain/utils/HostHelper;", "iamPortMobileWebMode", "Lcom/iamport/sdk/presentation/activity/IamPortMobileWebMode;", "iamPortWebViewMode", "Lcom/iamport/sdk/presentation/activity/IamPortWebViewMode;", "iamportReceiver", "Lcom/iamport/sdk/domain/core/IamportReceiver;", "getIamportReceiver", "()Lcom/iamport/sdk/domain/core/IamportReceiver;", "iamportReceiver$delegate", "isPolling", "Landroidx/lifecycle/MutableLiveData;", "Lcom/iamport/sdk/domain/utils/Event;", "", "launcherChai", "Lkotlin/Pair;", "", "mainViewModel", "Lcom/iamport/sdk/presentation/viewmodel/MainViewModel;", "getMainViewModel", "()Lcom/iamport/sdk/presentation/viewmodel/MainViewModel;", "mainViewModel$delegate", "modeWebViewRef", "Landroid/webkit/WebView;", "paymentResultCallBack", "Lcom/iamport/sdk/data/sdk/IamPortResponse;", "preventOverlapRun", "Lcom/iamport/sdk/domain/utils/PreventOverlapRun;", "getPreventOverlapRun", "()Lcom/iamport/sdk/domain/utils/PreventOverlapRun;", "preventOverlapRun$delegate", "screenBrReceiver", "Landroid/content/BroadcastReceiver;", "getWebViewActivityLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "askApproveFromChai", "approve", "checkChaiVersionCode", "chaiPackageName", "clearMainViewModel", "close", "closeDeleteWebViewMode", "disableWebViewMode", "enableWebViewMode", "webviewRef", "failFinish", "getIntentPackage", "intent", "Landroid/content/Intent;", "initClearData", "initClose", "initStart", "payment", "approveCallback", "Landroidx/lifecycle/LiveData;", "isWebViewMode", "mobileWebModeShouldOverrideUrlLoading", "Landroid/net/Uri;", "movePlayStore", "observeCertification", "observeViewModel", "openChaiApp", "it", "pluginMobileWebSupporter", "requestApprovePayments", "requestCertification", "requestPayment", "ignoreNative", "requestWebViewActivityPayment", "resultCallback", "sdkFinish", "iamPortResponse", "updatePolling", "sdk_debug"})
public final class IamportSdk implements com.iamport.sdk.domain.di.IamportKoinComponent {
    @org.jetbrains.annotations.Nullable()
    private final java.lang.ref.WeakReference<androidx.activity.ComponentActivity> activity = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.ref.WeakReference<androidx.fragment.app.Fragment> fragment = null;
    @org.jetbrains.annotations.Nullable()
    private final androidx.activity.result.ActivityResultLauncher<com.iamport.sdk.data.sdk.Payment> webViewActivityLauncher = null;
    private final com.iamport.sdk.domain.utils.HostHelper hostHelper = null;
    private final kotlin.Lazy mainViewModel$delegate = null;
    private kotlin.jvm.functions.Function1<? super com.iamport.sdk.data.sdk.IamPortResponse, kotlin.Unit> paymentResultCallBack;
    private java.lang.ref.WeakReference<android.webkit.WebView> modeWebViewRef;
    private com.iamport.sdk.presentation.activity.IamPortWebViewMode iamPortWebViewMode;
    private com.iamport.sdk.presentation.activity.IamPortMobileWebMode iamPortMobileWebMode;
    private androidx.activity.result.ActivityResultLauncher<kotlin.Pair<java.lang.String, java.lang.String>> launcherChai;
    private final kotlin.Lazy chaiContract$delegate = null;
    private kotlin.jvm.functions.Function1<? super com.iamport.sdk.data.sdk.IamPortApprove, kotlin.Unit> chaiApproveCallBack;
    private final androidx.lifecycle.MutableLiveData<com.iamport.sdk.domain.utils.Event<java.lang.Boolean>> isPolling = null;
    private final kotlin.Lazy preventOverlapRun$delegate = null;
    private final kotlin.Lazy iamportReceiver$delegate = null;
    private final android.content.BroadcastReceiver screenBrReceiver = null;
    
    public IamportSdk(@org.jetbrains.annotations.Nullable()
    java.lang.ref.WeakReference<androidx.activity.ComponentActivity> activity, @org.jetbrains.annotations.Nullable()
    java.lang.ref.WeakReference<androidx.fragment.app.Fragment> fragment, @org.jetbrains.annotations.Nullable()
    androidx.activity.result.ActivityResultLauncher<com.iamport.sdk.data.sdk.Payment> webViewActivityLauncher) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.ref.WeakReference<androidx.activity.ComponentActivity> getActivity() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.ref.WeakReference<androidx.fragment.app.Fragment> getFragment() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.activity.result.ActivityResultLauncher<com.iamport.sdk.data.sdk.Payment> getWebViewActivityLauncher() {
        return null;
    }
    
    private final com.iamport.sdk.presentation.viewmodel.MainViewModel getMainViewModel() {
        return null;
    }
    
    private final com.iamport.sdk.presentation.contract.ChaiContract getChaiContract() {
        return null;
    }
    
    private final com.iamport.sdk.domain.utils.PreventOverlapRun getPreventOverlapRun() {
        return null;
    }
    
    private final com.iamport.sdk.domain.core.IamportReceiver getIamportReceiver() {
        return null;
    }
    
    public final void enableWebViewMode(@org.jetbrains.annotations.NotNull()
    java.lang.ref.WeakReference<android.webkit.WebView> webviewRef) {
    }
    
    public final void disableWebViewMode() {
    }
    
    public final boolean isWebViewMode() {
        return false;
    }
    
    public final void pluginMobileWebSupporter(@org.jetbrains.annotations.NotNull()
    java.lang.ref.WeakReference<android.webkit.WebView> webviewRef) {
    }
    
    /**
     * 모든 결과 처리 및 SDK 종료
     */
    private final void sdkFinish(com.iamport.sdk.data.sdk.IamPortResponse iamPortResponse) {
    }
    
    /**
     * 뷰모델 데이터 클리어
     */
    private final void clearMainViewModel() {
    }
    
    private final void initClearData() {
    }
    
    private final void closeDeleteWebViewMode() {
    }
    
    public final void close() {
    }
    
    public final void initClose() {
    }
    
    public final void failFinish() {
    }
    
    /**
     * 본인인증 요청시 실행
     */
    public final void initStart(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.data.sdk.Payment payment, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super com.iamport.sdk.data.sdk.IamPortResponse, kotlin.Unit> paymentResultCallBack) {
    }
    
    /**
     * 결제 요청시 실행
     */
    public final void initStart(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.data.sdk.Payment payment, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super com.iamport.sdk.data.sdk.IamPortApprove, kotlin.Unit> approveCallback, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super com.iamport.sdk.data.sdk.IamPortResponse, kotlin.Unit> paymentResultCallBack) {
    }
    
    /**
     * 관찰할 LiveData 옵저빙
     */
    private final void observeViewModel(com.iamport.sdk.data.sdk.Payment payment) {
    }
    
    private final void observeCertification(com.iamport.sdk.data.sdk.Payment payment) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.lifecycle.LiveData<com.iamport.sdk.domain.utils.Event<android.net.Uri>> mobileWebModeShouldOverrideUrlLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.iamport.sdk.domain.utils.Event<java.lang.Boolean>> isPolling() {
        return null;
    }
    
    private final void updatePolling(boolean it) {
    }
    
    private final void askApproveFromChai(com.iamport.sdk.data.sdk.IamPortApprove approve) {
    }
    
    public final void requestApprovePayments(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.data.sdk.IamPortApprove approve) {
    }
    
    /**
     * 차이 앱 종료 콜백 감지
     */
    private final void resultCallback() {
    }
    
    /**
     * 결제 요청 실행
     */
    private final void requestPayment(com.iamport.sdk.data.sdk.Payment payment, boolean ignoreNative) {
    }
    
    /**
     * 결제 요청 실행
     */
    private final void requestCertification(com.iamport.sdk.data.sdk.Payment payment) {
    }
    
    /**
     * 웹뷰 결제 요청 실행
     */
    private final void requestWebViewActivityPayment(com.iamport.sdk.data.sdk.Payment payment) {
    }
    
    /**
     * 차이앱 외부앱 열기
     */
    private final void openChaiApp(java.lang.String it) {
    }
    
    private final java.lang.String getIntentPackage(android.content.Intent intent) {
        return null;
    }
    
    /**
     * 앱 패키지 검색하여 플레이 스토어로 이동
     */
    private final void movePlayStore(android.content.Intent intent) {
    }
    
    private final boolean checkChaiVersionCode(java.lang.String chaiPackageName) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public org.koin.core.Koin getKoin() {
        return null;
    }
}