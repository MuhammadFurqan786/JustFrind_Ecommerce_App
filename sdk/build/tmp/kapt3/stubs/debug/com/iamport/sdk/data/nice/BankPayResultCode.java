package com.iamport.sdk.data.nice;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\u000e"}, d2 = {"Lcom/iamport/sdk/data/nice/BankPayResultCode;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode", "()Ljava/lang/String;", "OK", "CANCEL", "TIME_OUT", "FAIL_SIGN", "FAIL_OTP", "FAIL_CERT_MODULE_INIT", "Companion", "sdk_debug"})
public enum BankPayResultCode {
    /*public static final*/ OK /* = new OK(null) */,
    /*public static final*/ CANCEL /* = new CANCEL(null) */,
    /*public static final*/ TIME_OUT /* = new TIME_OUT(null) */,
    /*public static final*/ FAIL_SIGN /* = new FAIL_SIGN(null) */,
    /*public static final*/ FAIL_OTP /* = new FAIL_OTP(null) */,
    /*public static final*/ FAIL_CERT_MODULE_INIT /* = new FAIL_CERT_MODULE_INIT(null) */;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String code = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.iamport.sdk.data.nice.BankPayResultCode.Companion Companion = null;
    
    BankPayResultCode(java.lang.String code) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCode() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0004\u00a8\u0006\t"}, d2 = {"Lcom/iamport/sdk/data/nice/BankPayResultCode$Companion;", "", "()V", "desc", "", "code", "Lcom/iamport/sdk/data/nice/BankPayResultCode;", "from", "s", "sdk_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.iamport.sdk.data.nice.BankPayResultCode from(@org.jetbrains.annotations.NotNull()
        java.lang.String s) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String desc(@org.jetbrains.annotations.NotNull()
        com.iamport.sdk.data.nice.BankPayResultCode code) {
            return null;
        }
    }
}