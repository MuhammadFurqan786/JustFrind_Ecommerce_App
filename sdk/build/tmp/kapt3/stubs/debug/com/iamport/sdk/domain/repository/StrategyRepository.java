package com.iamport.sdk.domain.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001&B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u000fJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0006\u0010 \u001a\u00020!J\u0006\u0010\u0016\u001a\u00020\"J\u0006\u0010#\u001a\u00020\u001aJ\u000e\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u000fR\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\b\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\'"}, d2 = {"Lcom/iamport/sdk/domain/repository/StrategyRepository;", "Lcom/iamport/sdk/domain/di/IamportKoinComponent;", "()V", "chaiStrategy", "Lcom/iamport/sdk/domain/strategy/chai/ChaiStrategy;", "getChaiStrategy", "()Lcom/iamport/sdk/domain/strategy/chai/ChaiStrategy;", "chaiStrategy$delegate", "Lkotlin/Lazy;", "judgeStrategy", "Lcom/iamport/sdk/domain/strategy/base/JudgeStrategy;", "getJudgeStrategy", "()Lcom/iamport/sdk/domain/strategy/base/JudgeStrategy;", "judgeStrategy$delegate", "mobileWebModeStrategy", "Lcom/iamport/sdk/domain/strategy/webview/IamPortMobileModeWebViewClient;", "getMobileWebModeStrategy", "()Lcom/iamport/sdk/domain/strategy/webview/IamPortMobileModeWebViewClient;", "setMobileWebModeStrategy", "(Lcom/iamport/sdk/domain/strategy/webview/IamPortMobileModeWebViewClient;)V", "webViewStrategy", "Lcom/iamport/sdk/domain/strategy/webview/WebViewStrategy;", "getWebViewStrategy", "()Lcom/iamport/sdk/domain/strategy/webview/WebViewStrategy;", "webViewStrategy$delegate", "failSdkFinish", "", "payment", "Lcom/iamport/sdk/data/sdk/Payment;", "getMobileWebModeClient", "getPaymentKinds", "Lcom/iamport/sdk/domain/repository/StrategyRepository$PaymentKinds;", "getWebViewClient", "Landroid/webkit/WebViewClient;", "Lcom/iamport/sdk/domain/strategy/base/IStrategy;", "init", "updateMobileWebModeClient", "client", "PaymentKinds", "sdk_debug"})
public final class StrategyRepository implements com.iamport.sdk.domain.di.IamportKoinComponent {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy judgeStrategy$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy chaiStrategy$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private com.iamport.sdk.domain.strategy.webview.IamPortMobileModeWebViewClient mobileWebModeStrategy;
    private final kotlin.Lazy webViewStrategy$delegate = null;
    
    public StrategyRepository() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.iamport.sdk.domain.strategy.base.JudgeStrategy getJudgeStrategy() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.iamport.sdk.domain.strategy.chai.ChaiStrategy getChaiStrategy() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.iamport.sdk.domain.strategy.webview.IamPortMobileModeWebViewClient getMobileWebModeStrategy() {
        return null;
    }
    
    public final void setMobileWebModeStrategy(@org.jetbrains.annotations.Nullable()
    com.iamport.sdk.domain.strategy.webview.IamPortMobileModeWebViewClient p0) {
    }
    
    private final com.iamport.sdk.domain.strategy.webview.WebViewStrategy getWebViewStrategy() {
        return null;
    }
    
    public final void init() {
    }
    
    public final void failSdkFinish(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.data.sdk.Payment payment) {
    }
    
    /**
     * PG 와 PayMethod 로 결제 타입하여 가져옴
     * @return PaymenyKinds
     */
    private final com.iamport.sdk.domain.repository.StrategyRepository.PaymentKinds getPaymentKinds(com.iamport.sdk.data.sdk.Payment payment) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.iamport.sdk.domain.strategy.base.IStrategy getWebViewStrategy() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.webkit.WebViewClient getWebViewClient() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.iamport.sdk.domain.strategy.webview.IamPortMobileModeWebViewClient getMobileWebModeClient() {
        return null;
    }
    
    public final void updateMobileWebModeClient(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.domain.strategy.webview.IamPortMobileModeWebViewClient client) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public org.koin.core.Koin getKoin() {
        return null;
    }
    
    /**
     * 실제로 앱 띄울 결제 타입
     */
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/iamport/sdk/domain/repository/StrategyRepository$PaymentKinds;", "", "(Ljava/lang/String;I)V", "CHAI", "NICE", "WEB", "sdk_debug"})
    public static enum PaymentKinds {
        /*public static final*/ CHAI /* = new CHAI() */,
        /*public static final*/ NICE /* = new NICE() */,
        /*public static final*/ WEB /* = new WEB() */;
        
        PaymentKinds() {
        }
    }
}