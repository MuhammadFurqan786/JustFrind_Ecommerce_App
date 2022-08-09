package com.iamport.sdk.domain.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016\u00a8\u0006\u0004"}, d2 = {"Lcom/iamport/sdk/domain/di/IamportKoinComponent;", "Lorg/koin/core/component/KoinComponent;", "getKoin", "Lorg/koin/core/Koin;", "sdk_debug"})
public abstract interface IamportKoinComponent extends org.koin.core.component.KoinComponent {
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public abstract org.koin.core.Koin getKoin();
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 3)
    public final class DefaultImpls {
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public static org.koin.core.Koin getKoin(@org.jetbrains.annotations.NotNull()
        com.iamport.sdk.domain.di.IamportKoinComponent $this) {
            return null;
        }
    }
}