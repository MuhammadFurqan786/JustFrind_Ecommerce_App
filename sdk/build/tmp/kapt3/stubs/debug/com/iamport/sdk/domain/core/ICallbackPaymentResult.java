package com.iamport.sdk.domain.core;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/iamport/sdk/domain/core/ICallbackPaymentResult;", "", "result", "", "iamPortResponse", "Lcom/iamport/sdk/data/sdk/IamPortResponse;", "sdk_debug"})
public abstract interface ICallbackPaymentResult {
    
    public abstract void result(@org.jetbrains.annotations.Nullable()
    com.iamport.sdk.data.sdk.IamPortResponse iamPortResponse);
}