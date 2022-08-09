package com.iamport.sdk.data.chai.response;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000f"}, d2 = {"Lcom/iamport/sdk/data/chai/response/ChaiPaymentStatus;", "", "(Ljava/lang/String;I)V", "waiting", "prepared", "approved", "user_canceled", "canceled", "failed", "timeout", "confirmed", "partial_confirmed", "inactive", "churn", "Companion", "sdk_debug"})
public enum ChaiPaymentStatus {
    /*public static final*/ waiting /* = new waiting() */,
    /*public static final*/ prepared /* = new prepared() */,
    /*public static final*/ approved /* = new approved() */,
    /*public static final*/ user_canceled /* = new user_canceled() */,
    /*public static final*/ canceled /* = new canceled() */,
    /*public static final*/ failed /* = new failed() */,
    /*public static final*/ timeout /* = new timeout() */,
    /*public static final*/ confirmed /* = new confirmed() */,
    /*public static final*/ partial_confirmed /* = new partial_confirmed() */,
    /*public static final*/ inactive /* = new inactive() */,
    /*public static final*/ churn /* = new churn() */;
    @org.jetbrains.annotations.NotNull()
    public static final com.iamport.sdk.data.chai.response.ChaiPaymentStatus.Companion Companion = null;
    
    ChaiPaymentStatus() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/iamport/sdk/data/chai/response/ChaiPaymentStatus$Companion;", "", "()V", "from", "Lcom/iamport/sdk/data/chai/response/ChaiPaymentStatus;", "displayStatus", "", "sdk_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.iamport.sdk.data.chai.response.ChaiPaymentStatus from(@org.jetbrains.annotations.NotNull()
        java.lang.String displayStatus) {
            return null;
        }
    }
}