package com.iamport.sdk.presentation.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0012\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0002J\u0012\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/iamport/sdk/presentation/activity/IamPortMobileWebMode;", "Lcom/iamport/sdk/presentation/activity/IamPortWebViewMode;", "()V", "detectShouldOverrideUrlLoading", "Landroidx/lifecycle/LiveData;", "Lcom/iamport/sdk/domain/utils/Event;", "Landroid/net/Uri;", "initStart", "", "activity", "Landroidx/activity/ComponentActivity;", "webview", "Landroid/webkit/WebView;", "observeViewModel", "payment", "Lcom/iamport/sdk/data/sdk/Payment;", "openWebView", "sdkFinish", "iamPortResponse", "Lcom/iamport/sdk/data/sdk/IamPortResponse;", "sdk_debug"})
public class IamPortMobileWebMode extends com.iamport.sdk.presentation.activity.IamPortWebViewMode {
    
    public IamPortMobileWebMode() {
        super(null);
    }
    
    public final void initStart(@org.jetbrains.annotations.NotNull()
    androidx.activity.ComponentActivity activity, @org.jetbrains.annotations.NotNull()
    android.webkit.WebView webview) {
    }
    
    /**
     * 관찰할 LiveData 옵저빙
     */
    @java.lang.Override()
    public void observeViewModel(@org.jetbrains.annotations.Nullable()
    com.iamport.sdk.data.sdk.Payment payment) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.iamport.sdk.domain.utils.Event<android.net.Uri>> detectShouldOverrideUrlLoading() {
        return null;
    }
    
    @java.lang.Override()
    public void sdkFinish(@org.jetbrains.annotations.Nullable()
    com.iamport.sdk.data.sdk.IamPortResponse iamPortResponse) {
    }
    
    private final void openWebView() {
    }
}