package com.iamport.sampleapp.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0006\u0010 \u001a\u00020\u0017J\b\u0010!\u001a\u00020\u0017H\u0002J\b\u0010\"\u001a\u00020\u0017H\u0002J\b\u0010#\u001a\u00020\u0017H\u0002J&\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010,\u001a\u00020\u0017H\u0016J\b\u0010-\u001a\u00020\u0017H\u0002J\b\u0010.\u001a\u00020\u0017H\u0016J\u0010\u0010/\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013\u00a8\u00060"}, d2 = {"Lcom/iamport/sampleapp/ui/PaymentFragment;", "Lcom/iamport/sampleapp/ui/BaseFragment;", "Lcom/iamport/sampleapp/databinding/PaymentFragmentBinding;", "()V", "backPressCallback", "Landroidx/activity/OnBackPressedCallback;", "callBackListener", "Lcom/iamport/sdk/domain/core/ICallbackPaymentResult;", "layoutResourceId", "", "getLayoutResourceId", "()I", "pgSelectListener", "Landroid/widget/AdapterView$OnItemSelectedListener;", "receiver", "Lcom/iamport/sampleapp/MerchantReceiver;", "viewModel", "Lcom/iamport/sampleapp/ViewModel;", "getViewModel", "()Lcom/iamport/sampleapp/ViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "approveCallback", "", "iamPortApprove", "Lcom/iamport/sdk/data/sdk/IamPortApprove;", "getRandomMerchantUid", "", "initStart", "onAttach", "context", "Landroid/content/Context;", "onClickCertification", "onClickMobileWebModePayment", "onClickPayment", "onClickWebViewModePayment", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPolling", "onStart", "registForegroundServiceReceiver", "gateway_debug"})
public final class PaymentFragment extends com.iamport.sampleapp.ui.BaseFragment<com.iamport.sampleapp.databinding.PaymentFragmentBinding> {
    private final int layoutResourceId = com.iamport.sampleapp.R.layout.payment_fragment;
    private final com.iamport.sampleapp.MerchantReceiver receiver = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private final com.iamport.sdk.domain.core.ICallbackPaymentResult callBackListener = null;
    private final android.widget.AdapterView.OnItemSelectedListener pgSelectListener = null;
    private final androidx.activity.OnBackPressedCallback backPressCallback = null;
    
    public PaymentFragment() {
        super();
    }
    
    @java.lang.Override()
    public int getLayoutResourceId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.iamport.sampleapp.ViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    private final void registForegroundServiceReceiver(android.content.Context context) {
    }
    
    @java.lang.Override()
    public void initStart() {
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    private final void onPolling() {
    }
    
    public final void onClickCertification() {
    }
    
    private final void onClickMobileWebModePayment() {
    }
    
    private final void onClickWebViewModePayment() {
    }
    
    private final void onClickPayment() {
    }
    
    /**
     * TODO: CHAI 결제시 재고확인 등 최종결제를 위한 처리를 해주세요
     * CONST.CHAI_FINAL_PAYMENT_TIME_OUT_SEC 만큼 타임아웃 후 결제 데이터가
     * 초기화 되기 때문에 타임아웃 시간 안에 Iamport.chaiPayment 함수를 호출해주셔야 합니다.
     */
    private final void approveCallback(com.iamport.sdk.data.sdk.IamPortApprove iamPortApprove) {
    }
    
    private final java.lang.String getRandomMerchantUid() {
        return null;
    }
}