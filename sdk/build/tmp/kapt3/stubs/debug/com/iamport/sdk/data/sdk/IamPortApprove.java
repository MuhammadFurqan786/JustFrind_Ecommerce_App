package com.iamport.sdk.data.sdk;

import java.lang.System;

@kotlinx.parcelize.Parcelize()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 52\u00020\u0001:\u00015B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\fH\u00c6\u0003Ju\u0010\'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\t\u0010(\u001a\u00020)H\u00d6\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u00d6\u0003J\t\u0010.\u001a\u00020)H\u00d6\u0001J\t\u0010/\u001a\u00020\u0003H\u00d6\u0001J\u0019\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020)H\u00d6\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0010\u00a8\u00066"}, d2 = {"Lcom/iamport/sdk/data/sdk/IamPortApprove;", "Landroid/os/Parcelable;", "userCode", "", "merchantUid", "customerUid", "paymentId", "subscriptionId", "impUid", "idempotencyKey", "publicAPIKey", "status", "Lcom/iamport/sdk/data/chai/response/ChaiPaymentStatus;", "msg", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/iamport/sdk/data/chai/response/ChaiPaymentStatus;Ljava/lang/String;)V", "getCustomerUid", "()Ljava/lang/String;", "getIdempotencyKey", "getImpUid", "getMerchantUid", "getMsg", "getPaymentId", "getPublicAPIKey", "getStatus", "()Lcom/iamport/sdk/data/chai/response/ChaiPaymentStatus;", "setStatus", "(Lcom/iamport/sdk/data/chai/response/ChaiPaymentStatus;)V", "getSubscriptionId", "getUserCode", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "sdk_debug"})
public final class IamPortApprove implements android.os.Parcelable {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String userCode = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String merchantUid = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String customerUid = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String paymentId = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String subscriptionId = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String impUid = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String idempotencyKey = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String publicAPIKey = null;
    @org.jetbrains.annotations.NotNull()
    private com.iamport.sdk.data.chai.response.ChaiPaymentStatus status;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String msg = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.iamport.sdk.data.sdk.IamPortApprove.Companion Companion = null;
    public static final android.os.Parcelable.Creator<com.iamport.sdk.data.sdk.IamPortApprove> CREATOR = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.iamport.sdk.data.sdk.IamPortApprove copy(@org.jetbrains.annotations.NotNull()
    java.lang.String userCode, @org.jetbrains.annotations.NotNull()
    java.lang.String merchantUid, @org.jetbrains.annotations.Nullable()
    java.lang.String customerUid, @org.jetbrains.annotations.Nullable()
    java.lang.String paymentId, @org.jetbrains.annotations.Nullable()
    java.lang.String subscriptionId, @org.jetbrains.annotations.NotNull()
    java.lang.String impUid, @org.jetbrains.annotations.NotNull()
    java.lang.String idempotencyKey, @org.jetbrains.annotations.NotNull()
    java.lang.String publicAPIKey, @org.jetbrains.annotations.NotNull()
    com.iamport.sdk.data.chai.response.ChaiPaymentStatus status, @org.jetbrains.annotations.Nullable()
    java.lang.String msg) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public IamPortApprove(@org.jetbrains.annotations.NotNull()
    java.lang.String userCode, @org.jetbrains.annotations.NotNull()
    java.lang.String merchantUid, @org.jetbrains.annotations.Nullable()
    java.lang.String customerUid, @org.jetbrains.annotations.Nullable()
    java.lang.String paymentId, @org.jetbrains.annotations.Nullable()
    java.lang.String subscriptionId, @org.jetbrains.annotations.NotNull()
    java.lang.String impUid, @org.jetbrains.annotations.NotNull()
    java.lang.String idempotencyKey, @org.jetbrains.annotations.NotNull()
    java.lang.String publicAPIKey, @org.jetbrains.annotations.NotNull()
    com.iamport.sdk.data.chai.response.ChaiPaymentStatus status, @org.jetbrains.annotations.Nullable()
    java.lang.String msg) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUserCode() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMerchantUid() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCustomerUid() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPaymentId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSubscriptionId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getImpUid() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getIdempotencyKey() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPublicAPIKey() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.iamport.sdk.data.chai.response.ChaiPaymentStatus component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.iamport.sdk.data.chai.response.ChaiPaymentStatus getStatus() {
        return null;
    }
    
    public final void setStatus(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.data.chai.response.ChaiPaymentStatus p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMsg() {
        return null;
    }
    
    @java.lang.Override()
    public int describeContents() {
        return 0;
    }
    
    @java.lang.Override()
    public void writeToParcel(@org.jetbrains.annotations.NotNull()
    android.os.Parcel parcel, int flags) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 3)
    public static final class Creator implements android.os.Parcelable.Creator<com.iamport.sdk.data.sdk.IamPortApprove> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.iamport.sdk.data.sdk.IamPortApprove createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.iamport.sdk.data.sdk.IamPortApprove[] newArray(int size) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n\u00a8\u0006\u000b"}, d2 = {"Lcom/iamport/sdk/data/sdk/IamPortApprove$Companion;", "", "()V", "make", "Lcom/iamport/sdk/data/sdk/IamPortApprove;", "payment", "Lcom/iamport/sdk/data/sdk/Payment;", "data", "Lcom/iamport/sdk/data/chai/response/PrepareData;", "status", "Lcom/iamport/sdk/data/chai/response/ChaiPaymentStatus;", "sdk_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.iamport.sdk.data.sdk.IamPortApprove make(@org.jetbrains.annotations.NotNull()
        com.iamport.sdk.data.sdk.Payment payment, @org.jetbrains.annotations.NotNull()
        com.iamport.sdk.data.chai.response.PrepareData data, @org.jetbrains.annotations.NotNull()
        com.iamport.sdk.data.chai.response.ChaiPaymentStatus status) {
            return null;
        }
    }
}