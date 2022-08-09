package com.iamport.sdk.domain.strategy.webview;

import java.lang.System;

/**
 * // 해당로직 쓰지 않아도 정상 결제 되는 듯 함
 * // NiceTransWebViewStrategy 가 필요없어진 듯
 * // bankpay launcher 도 삭제해도 될 듯
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0003J\u001c\u0010\r\u001a\u00020\u00042\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000fH\u0002J\u001a\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000fJ\u001c\u0010\u0013\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/iamport/sdk/domain/strategy/webview/NiceTransWebViewStrategy;", "Lcom/iamport/sdk/domain/strategy/webview/WebViewStrategy;", "()V", "bankTid", "", "niceTransUrl", "webView", "Landroid/webkit/WebView;", "isNiceTransScheme", "", "uri", "Landroid/net/Uri;", "makeBankPayData", "makeNiceTransPaymentsQuery", "res", "Lkotlin/Pair;", "processBankPayPayment", "", "resPair", "shouldOverrideUrlLoading", "view", "request", "Landroid/webkit/WebResourceRequest;", "sdk_debug"})
public class NiceTransWebViewStrategy extends com.iamport.sdk.domain.strategy.webview.WebViewStrategy {
    private android.webkit.WebView webView;
    private java.lang.String bankTid = "";
    private java.lang.String niceTransUrl = "";
    
    public NiceTransWebViewStrategy() {
        super();
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.LOLLIPOP)
    @java.lang.Override()
    public boolean shouldOverrideUrlLoading(@org.jetbrains.annotations.Nullable()
    android.webkit.WebView view, @org.jetbrains.annotations.Nullable()
    android.webkit.WebResourceRequest request) {
        return false;
    }
    
    /**
     * 뱅크페이 결제 결과 처리 (BankPayContract result)
     */
    public final void processBankPayPayment(@org.jetbrains.annotations.NotNull()
    kotlin.Pair<java.lang.String, java.lang.String> resPair) {
    }
    
    private final java.lang.String makeNiceTransPaymentsQuery(kotlin.Pair<java.lang.String, java.lang.String> res) {
        return null;
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.KITKAT)
    private final java.lang.String makeBankPayData(android.net.Uri uri) {
        return null;
    }
    
    private final boolean isNiceTransScheme(android.net.Uri uri) {
        return false;
    }
}