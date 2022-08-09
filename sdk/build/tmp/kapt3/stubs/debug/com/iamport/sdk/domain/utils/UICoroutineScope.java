package com.iamport.sdk.domain.utils;

import java.lang.System;

/**
 * https://thdev.tech/kotlin/2019/04/05/Init-Coroutines/
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/iamport/sdk/domain/utils/UICoroutineScope;", "Lcom/iamport/sdk/domain/utils/BaseCoroutineScope;", "dispatchers", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "coroutineContext", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "job", "Lkotlinx/coroutines/Job;", "getJob", "()Lkotlinx/coroutines/Job;", "releaseCoroutine", "", "sdk_debug"})
public final class UICoroutineScope implements com.iamport.sdk.domain.utils.BaseCoroutineScope {
    private final kotlin.coroutines.CoroutineContext dispatchers = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.Job job = null;
    
    public UICoroutineScope() {
        super();
    }
    
    public UICoroutineScope(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.CoroutineContext dispatchers) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.Job getJob() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.coroutines.CoroutineContext getCoroutineContext() {
        return null;
    }
    
    @java.lang.Override()
    public void releaseCoroutine() {
    }
}