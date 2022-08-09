package com.iamport.sdk.data.sdk;

import java.lang.System;

/**
 * {
 * "error_msg": "F0005:결제가 중단되었습니다(imp_42234234).01 | 사용자가 결제를 취소 하였습니다.",
 * "imp_success": "false",
 * "imp_uid": "imp_42234234",
 * "merchant_uid": "mid_634534534548"
 * }
 */
@kotlinx.parcelize.Parcelize()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0001(BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000fJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003JV\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006H\u00c6\u0001\u00a2\u0006\u0002\u0010\u001bJ\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001J\u0013\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u00d6\u0003J\t\u0010!\u001a\u00020\u001dH\u00d6\u0001J\t\u0010\"\u001a\u00020\u0006H\u00d6\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020\u001dH\u00d6\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0013\u0010\u000f\u00a8\u0006)"}, d2 = {"Lcom/iamport/sdk/data/sdk/IamPortResponse;", "Landroid/os/Parcelable;", "imp_success", "", "success", "imp_uid", "", "merchant_uid", "error_msg", "error_code", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getError_code", "()Ljava/lang/String;", "getError_msg", "getImp_success", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getImp_uid", "getMerchant_uid", "getSuccess", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/iamport/sdk/data/sdk/IamPortResponse;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "sdk_debug"})
public final class IamPortResponse implements android.os.Parcelable {
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean imp_success = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean success = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String imp_uid = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String merchant_uid = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String error_msg = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String error_code = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.iamport.sdk.data.sdk.IamPortResponse.Companion Companion = null;
    public static final android.os.Parcelable.Creator<com.iamport.sdk.data.sdk.IamPortResponse> CREATOR = null;
    
    /**
     * {
     * "error_msg": "F0005:결제가 중단되었습니다(imp_42234234).01 | 사용자가 결제를 취소 하였습니다.",
     * "imp_success": "false",
     * "imp_uid": "imp_42234234",
     * "merchant_uid": "mid_634534534548"
     * }
     */
    @org.jetbrains.annotations.NotNull()
    public final com.iamport.sdk.data.sdk.IamPortResponse copy(@org.jetbrains.annotations.Nullable()
    java.lang.Boolean imp_success, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean success, @org.jetbrains.annotations.Nullable()
    java.lang.String imp_uid, @org.jetbrains.annotations.Nullable()
    java.lang.String merchant_uid, @org.jetbrains.annotations.Nullable()
    java.lang.String error_msg, @org.jetbrains.annotations.Nullable()
    java.lang.String error_code) {
        return null;
    }
    
    /**
     * {
     * "error_msg": "F0005:결제가 중단되었습니다(imp_42234234).01 | 사용자가 결제를 취소 하였습니다.",
     * "imp_success": "false",
     * "imp_uid": "imp_42234234",
     * "merchant_uid": "mid_634534534548"
     * }
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * {
     * "error_msg": "F0005:결제가 중단되었습니다(imp_42234234).01 | 사용자가 결제를 취소 하였습니다.",
     * "imp_success": "false",
     * "imp_uid": "imp_42234234",
     * "merchant_uid": "mid_634534534548"
     * }
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * {
     * "error_msg": "F0005:결제가 중단되었습니다(imp_42234234).01 | 사용자가 결제를 취소 하였습니다.",
     * "imp_success": "false",
     * "imp_uid": "imp_42234234",
     * "merchant_uid": "mid_634534534548"
     * }
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public IamPortResponse(@org.jetbrains.annotations.Nullable()
    java.lang.Boolean imp_success, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean success, @org.jetbrains.annotations.Nullable()
    java.lang.String imp_uid, @org.jetbrains.annotations.Nullable()
    java.lang.String merchant_uid, @org.jetbrains.annotations.Nullable()
    java.lang.String error_msg, @org.jetbrains.annotations.Nullable()
    java.lang.String error_code) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getImp_success() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getSuccess() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getImp_uid() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMerchant_uid() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getError_msg() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getError_code() {
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
    public static final class Creator implements android.os.Parcelable.Creator<com.iamport.sdk.data.sdk.IamPortResponse> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.iamport.sdk.data.sdk.IamPortResponse createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.iamport.sdk.data.sdk.IamPortResponse[] newArray(int size) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\bJ\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\b2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\bJ\"\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\bJ\"\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\b2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\f"}, d2 = {"Lcom/iamport/sdk/data/sdk/IamPortResponse$Companion;", "", "()V", "makeFail", "Lcom/iamport/sdk/data/sdk/IamPortResponse;", "payment", "Lcom/iamport/sdk/data/sdk/Payment;", "impUid", "", "msg", "merchantUid", "makeSuccess", "sdk_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.iamport.sdk.data.sdk.IamPortResponse makeSuccess(@org.jetbrains.annotations.NotNull()
        com.iamport.sdk.data.sdk.Payment payment, @org.jetbrains.annotations.Nullable()
        java.lang.String impUid, @org.jetbrains.annotations.NotNull()
        java.lang.String msg) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.iamport.sdk.data.sdk.IamPortResponse makeFail(@org.jetbrains.annotations.NotNull()
        com.iamport.sdk.data.sdk.Payment payment, @org.jetbrains.annotations.Nullable()
        java.lang.String impUid, @org.jetbrains.annotations.NotNull()
        java.lang.String msg) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.iamport.sdk.data.sdk.IamPortResponse makeSuccess(@org.jetbrains.annotations.NotNull()
        java.lang.String merchantUid, @org.jetbrains.annotations.Nullable()
        java.lang.String impUid, @org.jetbrains.annotations.NotNull()
        java.lang.String msg) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.iamport.sdk.data.sdk.IamPortResponse makeFail(@org.jetbrains.annotations.NotNull()
        java.lang.String merchantUid, @org.jetbrains.annotations.Nullable()
        java.lang.String impUid, @org.jetbrains.annotations.NotNull()
        java.lang.String msg) {
            return null;
        }
    }
}