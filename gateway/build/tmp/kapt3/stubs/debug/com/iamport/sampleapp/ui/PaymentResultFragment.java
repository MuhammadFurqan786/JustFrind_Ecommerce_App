package com.iamport.sampleapp.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/iamport/sampleapp/ui/PaymentResultFragment;", "Lcom/iamport/sampleapp/ui/BaseFragment;", "Lcom/iamport/sampleapp/databinding/ResultFragmentBinding;", "()V", "layoutResourceId", "", "getLayoutResourceId", "()I", "initStart", "", "isSuccess", "", "iamPortResponse", "Lcom/iamport/sdk/data/sdk/IamPortResponse;", "gateway_debug"})
public final class PaymentResultFragment extends com.iamport.sampleapp.ui.BaseFragment<com.iamport.sampleapp.databinding.ResultFragmentBinding> {
    private final int layoutResourceId = com.iamport.sampleapp.R.layout.result_fragment;
    
    public PaymentResultFragment() {
        super();
    }
    
    @java.lang.Override()
    public int getLayoutResourceId() {
        return 0;
    }
    
    @java.lang.Override()
    public void initStart() {
    }
    
    private final boolean isSuccess(com.iamport.sdk.data.sdk.IamPortResponse iamPortResponse) {
        return false;
    }
}