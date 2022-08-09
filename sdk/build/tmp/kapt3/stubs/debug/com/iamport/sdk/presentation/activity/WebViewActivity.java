package com.iamport.sdk.presentation.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u00142\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u001e\u001a\u00020\u0014H\u0014J\u0012\u0010\u001f\u001a\u00020\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\u0010\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010$\u001a\u00020\u0014H\u0002J\u0010\u0010%\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\rH\u0016J\u0012\u0010&\u001a\u00020\u00142\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u0019H\u0002R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u00038VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006+"}, d2 = {"Lcom/iamport/sdk/presentation/activity/WebViewActivity;", "Lcom/iamport/sdk/presentation/activity/BaseActivity;", "Lcom/iamport/sdk/databinding/WebviewActivityBinding;", "Lcom/iamport/sdk/presentation/viewmodel/WebViewModel;", "Lcom/iamport/sdk/domain/di/IamportKoinComponent;", "()V", "layoutResourceId", "", "getLayoutResourceId", "()I", "loading", "Landroid/widget/ProgressBar;", "payment", "Lcom/iamport/sdk/data/sdk/Payment;", "viewModel", "getViewModel", "()Lcom/iamport/sdk/presentation/viewmodel/WebViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "close", "", "initLoading", "initStart", "loadingVisible", "visible", "", "movePlayStore", "intent", "Landroid/content/Intent;", "observeViewModel", "onDestroy", "onNewIntent", "openThirdPartyApp", "it", "Landroid/net/Uri;", "openWebView", "removeObservers", "requestPayment", "sdkFinish", "iamPortResponse", "Lcom/iamport/sdk/data/sdk/IamPortResponse;", "updateAlpha", "isWebViewPG", "sdk_debug"})
public final class WebViewActivity extends com.iamport.sdk.presentation.activity.BaseActivity<com.iamport.sdk.databinding.WebviewActivityBinding, com.iamport.sdk.presentation.viewmodel.WebViewModel> implements com.iamport.sdk.domain.di.IamportKoinComponent {
    private final int layoutResourceId = 0;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private android.widget.ProgressBar loading;
    private com.iamport.sdk.data.sdk.Payment payment;
    
    public WebViewActivity() {
        super(null);
    }
    
    @java.lang.Override()
    public int getLayoutResourceId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.iamport.sdk.presentation.viewmodel.WebViewModel getViewModel() {
        return null;
    }
    
    /**
     * 뱅크페이 앱 열기 위한 런처
     */
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @java.lang.Override()
    public void initStart() {
    }
    
    @java.lang.Override()
    protected void onNewIntent(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent) {
    }
    
    /**
     * 로딩 UI 초기화
     */
    private final void initLoading() {
    }
    
    /**
     * 액티비티 알파값 조정
     */
    private final void updateAlpha(boolean isWebViewPG) {
    }
    
    /**
     * 관찰할 LiveData 옵저빙
     */
    @java.lang.Override()
    public void observeViewModel(@org.jetbrains.annotations.Nullable()
    com.iamport.sdk.data.sdk.Payment payment) {
    }
    
    /**
     * 로딩 프로그래스 visible 여부
     */
    private final void loadingVisible(boolean visible) {
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
    
    private final void close() {
    }
    
    /**
     * 모든 결과 처리 및 SDK 종료
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
    public org.koin.core.Koin getKoin() {
        return null;
    }
}