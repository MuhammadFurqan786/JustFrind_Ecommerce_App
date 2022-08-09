package com.iamport.sdk.presentation.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\rJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0013J\u0014\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u000e0\rJ\u0012\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u000e0\rJ\b\u0010\u0018\u001a\u00020\u0019H\u0014J\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u000e0\rJ\u000e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001bJ\u0012\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\rJ\u000e\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u0011R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/iamport/sdk/presentation/viewmodel/WebViewModel;", "Lcom/iamport/sdk/presentation/viewmodel/BaseViewModel;", "Lcom/iamport/sdk/domain/di/IamportKoinComponent;", "repository", "Lcom/iamport/sdk/domain/repository/StrategyRepository;", "(Lcom/iamport/sdk/domain/repository/StrategyRepository;)V", "bus", "Lcom/iamport/sdk/domain/utils/WebViewLiveDataEventBus;", "getBus", "()Lcom/iamport/sdk/domain/utils/WebViewLiveDataEventBus;", "bus$delegate", "Lkotlin/Lazy;", "changeUrl", "Landroidx/lifecycle/LiveData;", "Lcom/iamport/sdk/domain/utils/Event;", "Landroid/net/Uri;", "getMobileWebModeClient", "Lcom/iamport/sdk/domain/strategy/webview/IamPortMobileModeWebViewClient;", "getWebViewClient", "Landroid/webkit/WebViewClient;", "impResponse", "Lcom/iamport/sdk/data/sdk/IamPortResponse;", "loading", "", "onCleared", "", "openWebView", "Lcom/iamport/sdk/data/sdk/Payment;", "requestPayment", "payment", "thirdPartyUri", "updateMobileWebModeClient", "client", "sdk_debug"})
public final class WebViewModel extends com.iamport.sdk.presentation.viewmodel.BaseViewModel implements com.iamport.sdk.domain.di.IamportKoinComponent {
    private final com.iamport.sdk.domain.repository.StrategyRepository repository = null;
    private final kotlin.Lazy bus$delegate = null;
    
    public WebViewModel(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.domain.repository.StrategyRepository repository) {
        super();
    }
    
    private final com.iamport.sdk.domain.utils.WebViewLiveDataEventBus getBus() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
    
    /**
     * 오픈 웹뷰
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.iamport.sdk.domain.utils.Event<com.iamport.sdk.data.sdk.Payment>> openWebView() {
        return null;
    }
    
    /**
     * 외부앱 열기
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.iamport.sdk.domain.utils.Event<android.net.Uri>> thirdPartyUri() {
        return null;
    }
    
    /**
     * 결제 결과 콜백 및 종료
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.iamport.sdk.domain.utils.Event<com.iamport.sdk.data.sdk.IamPortResponse>> impResponse() {
        return null;
    }
    
    /**
     * 모바일 웹 모드 url 변경
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.iamport.sdk.domain.utils.Event<android.net.Uri>> changeUrl() {
        return null;
    }
    
    /**
     * 로딩 프로그래스
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.iamport.sdk.domain.utils.Event<java.lang.Boolean>> loading() {
        return null;
    }
    
    /**
     * PG(nice or 비nice) 따라 webview client 가져오기
     */
    @org.jetbrains.annotations.NotNull()
    public final android.webkit.WebViewClient getWebViewClient() {
        return null;
    }
    
    /**
     * MobileWebMode WebViewClient
     */
    @org.jetbrains.annotations.NotNull()
    public final com.iamport.sdk.domain.strategy.webview.IamPortMobileModeWebViewClient getMobileWebModeClient() {
        return null;
    }
    
    /**
     * MobileWebMode WebViewClient
     */
    public final void updateMobileWebModeClient(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.domain.strategy.webview.IamPortMobileModeWebViewClient client) {
    }
    
    /**
     * 결제 요청
     */
    public final void requestPayment(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.data.sdk.Payment payment) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public org.koin.core.Koin getKoin() {
        return null;
    }
}