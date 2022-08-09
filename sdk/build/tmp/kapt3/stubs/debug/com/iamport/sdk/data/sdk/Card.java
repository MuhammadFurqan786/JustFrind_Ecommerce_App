package com.iamport.sdk.data.sdk;

import java.lang.System;

/**
 * for naverpay
 */
@kotlinx.parcelize.Parcelize()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\t\u0010\t\u001a\u00020\nH\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u00d6\u0003J\t\u0010\u000f\u001a\u00020\nH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0017"}, d2 = {"Lcom/iamport/sdk/data/sdk/Card;", "Landroid/os/Parcelable;", "direct", "Lcom/iamport/sdk/data/sdk/Direct;", "(Lcom/iamport/sdk/data/sdk/Direct;)V", "getDirect", "()Lcom/iamport/sdk/data/sdk/Direct;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "sdk_debug"})
public final class Card implements android.os.Parcelable {
    @org.jetbrains.annotations.NotNull()
    private final com.iamport.sdk.data.sdk.Direct direct = null;
    public static final android.os.Parcelable.Creator<com.iamport.sdk.data.sdk.Card> CREATOR = null;
    
    /**
     * for naverpay
     */
    @org.jetbrains.annotations.NotNull()
    public final com.iamport.sdk.data.sdk.Card copy(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.data.sdk.Direct direct) {
        return null;
    }
    
    /**
     * for naverpay
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * for naverpay
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * for naverpay
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public Card(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.data.sdk.Direct direct) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.iamport.sdk.data.sdk.Direct component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.iamport.sdk.data.sdk.Direct getDirect() {
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
    public static final class Creator implements android.os.Parcelable.Creator<com.iamport.sdk.data.sdk.Card> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.iamport.sdk.data.sdk.Card createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.iamport.sdk.data.sdk.Card[] newArray(int size) {
            return null;
        }
    }
}