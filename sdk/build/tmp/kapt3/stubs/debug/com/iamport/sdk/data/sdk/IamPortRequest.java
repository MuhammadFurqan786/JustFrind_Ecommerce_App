package com.iamport.sdk.data.sdk;

import java.lang.System;

/**
 * SDK 에 결제 요청할 데이터
 * https://docs.iamport.kr/tech/imp?lang=ko#param
 */
@kotlinx.parcelize.Parcelize()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u0093\u00012\u00020\u0001:\u0002\u0093\u0001B\u008f\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u0016\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\'\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*\u00a2\u0006\u0002\u0010+J\t\u0010d\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010l\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016H\u00c6\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u0018H\u00c6\u0003J\u0010\u0010n\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u00109J\t\u0010o\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010s\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u00109J\u0010\u0010t\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u00109J\u000b\u0010u\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010v\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u0016H\u00c6\u0003J\u0010\u0010w\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u00109J\u000b\u0010x\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010y\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010z\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u00109J\u0010\u0010{\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u00109J\u000b\u0010|\u001a\u0004\u0018\u00010\'H\u00c6\u0003J\u000b\u0010}\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010~\u001a\u0004\u0018\u00010*H\u00c6\u0003J\t\u0010\u007f\u001a\u00020\u0003H\u00c6\u0003J\f\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\n\u0010\u0082\u0001\u001a\u00020\u0003H\u00c6\u0003J\f\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010\u0084\u0001\u001a\u0004\u0018\u00010\rH\u00c6\u0003\u00a2\u0006\u0002\u0010aJ\u00a0\u0003\u0010\u0085\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u00162\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*H\u00c6\u0001\u00a2\u0006\u0003\u0010\u0086\u0001J\u000b\u0010\u0087\u0001\u001a\u00030\u0088\u0001H\u00d6\u0001J\u0016\u0010\u0089\u0001\u001a\u00020\u00062\n\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u008b\u0001H\u00d6\u0003J\u000b\u0010\u008c\u0001\u001a\u00030\u0088\u0001H\u00d6\u0001J\n\u0010\u008d\u0001\u001a\u00020\u0003H\u00d6\u0001J\u001f\u0010\u008e\u0001\u001a\u00030\u008f\u00012\b\u0010\u0090\u0001\u001a\u00030\u0091\u00012\b\u0010\u0092\u0001\u001a\u00030\u0088\u0001H\u00d6\u0001R\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010-R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010-R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010-R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010-R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010-R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010-R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010-R\u0013\u0010)\u001a\u0004\u0018\u00010*\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0013\u0010(\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010-R\u0015\u0010%\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\n\n\u0002\u0010:\u001a\u0004\b8\u00109R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010-R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010-R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010-R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\n\n\u0002\u0010:\u001a\u0004\b>\u00109R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\n\n\u0002\u0010:\u001a\u0004\bA\u00109R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u0010-R\u0010\u0010C\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bD\u0010-R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bE\u0010-R\u0013\u0010$\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bF\u0010-R\u0015\u0010\"\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\n\n\u0002\u0010:\u001a\u0004\bG\u00109R\u0013\u0010&\u001a\u0004\u0018\u00010\'\u00a2\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\n\n\u0002\u0010:\u001a\u0004\bJ\u00109R\u0013\u0010#\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bK\u0010-R\u0019\u0010 \u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bN\u0010-R\u000e\u0010O\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\bP\u0010MR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bQ\u0010-R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bR\u0010-R\u0019\u0010S\u001a\u0004\u0018\u00010T8F\u00a2\u0006\f\u0012\u0004\bU\u0010V\u001a\u0004\bW\u0010XR0\u0010Z\u001a\u0004\u0018\u00010\u00032\b\u0010Y\u001a\u0004\u0018\u00010\u00038F@FX\u0086\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b[\u0010V\u001a\u0004\b\\\u0010-\"\u0004\b]\u0010^R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\n\n\u0002\u0010:\u001a\u0004\b_\u00109R\u0015\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\n\n\u0002\u0010b\u001a\u0004\b`\u0010aR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bc\u0010-\u00a8\u0006\u0094\u0001"}, d2 = {"Lcom/iamport/sdk/data/sdk/IamPortRequest;", "Landroid/os/Parcelable;", "pg", "", "pay_method", "escrow", "", "merchant_uid", "customer_uid", "name", "amount", "custom_data", "tax_free", "", "currency", "language", "buyer_name", "buyer_tel", "buyer_email", "buyer_addr", "buyer_postcode", "notice_url", "", "display", "Lcom/iamport/sdk/data/sdk/CardQuota;", "digital", "vbank_due", "app_scheme", "biz_num", "popup", "naverPopupMode", "naverUseCfm", "naverProducts", "Lcom/iamport/sdk/data/sdk/BaseProductItem;", "naverCultureBenefit", "naverProductCode", "naverActionType", "cultureBenefit", "naverInterface", "Lcom/iamport/sdk/data/sdk/NaverInterface;", "confirm_url", "card", "Lcom/iamport/sdk/data/sdk/Card;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/iamport/sdk/data/sdk/CardQuota;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/iamport/sdk/data/sdk/NaverInterface;Ljava/lang/String;Lcom/iamport/sdk/data/sdk/Card;)V", "getAmount", "()Ljava/lang/String;", "getApp_scheme", "getBiz_num", "getBuyer_addr", "getBuyer_email", "getBuyer_name", "getBuyer_postcode", "getBuyer_tel", "getCard", "()Lcom/iamport/sdk/data/sdk/Card;", "getConfirm_url", "getCultureBenefit", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCurrency", "getCustom_data", "getCustomer_uid", "getDigital", "getDisplay", "()Lcom/iamport/sdk/data/sdk/CardQuota;", "getEscrow", "getLanguage", "m_redirect_url", "getMerchant_uid", "getName", "getNaverActionType", "getNaverCultureBenefit", "getNaverInterface", "()Lcom/iamport/sdk/data/sdk/NaverInterface;", "getNaverPopupMode", "getNaverProductCode", "getNaverProducts", "()Ljava/util/List;", "getNaverUseCfm", "niceMobileV2", "getNotice_url", "getPay_method", "getPg", "pgEnum", "Lcom/iamport/sdk/data/sdk/PG;", "getPgEnum$annotations", "()V", "getPgEnum", "()Lcom/iamport/sdk/data/sdk/PG;", "value", "platform", "getPlatform$annotations", "getPlatform", "setPlatform", "(Ljava/lang/String;)V", "getPopup", "getTax_free", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getVbank_due", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/iamport/sdk/data/sdk/CardQuota;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/iamport/sdk/data/sdk/NaverInterface;Ljava/lang/String;Lcom/iamport/sdk/data/sdk/Card;)Lcom/iamport/sdk/data/sdk/IamPortRequest;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "sdk_debug"})
public final class IamPortRequest implements android.os.Parcelable {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String pg = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String pay_method = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean escrow = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String merchant_uid = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String customer_uid = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String name = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String amount = null;
    @org.jetbrains.annotations.Nullable()
    @kotlin.jvm.Transient()
    private final transient java.lang.String custom_data = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Float tax_free = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String currency = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String language = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String buyer_name = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String buyer_tel = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String buyer_email = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String buyer_addr = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String buyer_postcode = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<java.lang.String> notice_url = null;
    @org.jetbrains.annotations.Nullable()
    private final com.iamport.sdk.data.sdk.CardQuota display = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean digital = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String vbank_due = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String app_scheme = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String biz_num = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean popup = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean naverPopupMode = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String naverUseCfm = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<com.iamport.sdk.data.sdk.BaseProductItem> naverProducts = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean naverCultureBenefit = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String naverProductCode = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String naverActionType = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean cultureBenefit = null;
    @org.jetbrains.annotations.Nullable()
    private final com.iamport.sdk.data.sdk.NaverInterface naverInterface = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String confirm_url = null;
    @org.jetbrains.annotations.Nullable()
    private final com.iamport.sdk.data.sdk.Card card = null;
    private java.lang.String m_redirect_url;
    private final boolean niceMobileV2 = true;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String platform;
    @org.jetbrains.annotations.NotNull()
    public static final com.iamport.sdk.data.sdk.IamPortRequest.Companion Companion = null;
    public static final android.os.Parcelable.Creator<com.iamport.sdk.data.sdk.IamPortRequest> CREATOR = null;
    
    /**
     * SDK 에 결제 요청할 데이터
     * https://docs.iamport.kr/tech/imp?lang=ko#param
     */
    @org.jetbrains.annotations.NotNull()
    public final com.iamport.sdk.data.sdk.IamPortRequest copy(@org.jetbrains.annotations.NotNull()
    java.lang.String pg, @org.jetbrains.annotations.NotNull()
    java.lang.String pay_method, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean escrow, @org.jetbrains.annotations.NotNull()
    java.lang.String merchant_uid, @org.jetbrains.annotations.Nullable()
    java.lang.String customer_uid, @org.jetbrains.annotations.Nullable()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String amount, @org.jetbrains.annotations.Nullable()
    java.lang.String custom_data, @org.jetbrains.annotations.Nullable()
    java.lang.Float tax_free, @org.jetbrains.annotations.Nullable()
    java.lang.String currency, @org.jetbrains.annotations.Nullable()
    java.lang.String language, @org.jetbrains.annotations.Nullable()
    java.lang.String buyer_name, @org.jetbrains.annotations.Nullable()
    java.lang.String buyer_tel, @org.jetbrains.annotations.Nullable()
    java.lang.String buyer_email, @org.jetbrains.annotations.Nullable()
    java.lang.String buyer_addr, @org.jetbrains.annotations.Nullable()
    java.lang.String buyer_postcode, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> notice_url, @org.jetbrains.annotations.Nullable()
    com.iamport.sdk.data.sdk.CardQuota display, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean digital, @org.jetbrains.annotations.Nullable()
    java.lang.String vbank_due, @org.jetbrains.annotations.Nullable()
    java.lang.String app_scheme, @org.jetbrains.annotations.Nullable()
    java.lang.String biz_num, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean popup, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean naverPopupMode, @org.jetbrains.annotations.Nullable()
    java.lang.String naverUseCfm, @org.jetbrains.annotations.Nullable()
    java.util.List<? extends com.iamport.sdk.data.sdk.BaseProductItem> naverProducts, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean naverCultureBenefit, @org.jetbrains.annotations.Nullable()
    java.lang.String naverProductCode, @org.jetbrains.annotations.Nullable()
    java.lang.String naverActionType, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean cultureBenefit, @org.jetbrains.annotations.Nullable()
    com.iamport.sdk.data.sdk.NaverInterface naverInterface, @org.jetbrains.annotations.Nullable()
    java.lang.String confirm_url, @org.jetbrains.annotations.Nullable()
    com.iamport.sdk.data.sdk.Card card) {
        return null;
    }
    
    /**
     * SDK 에 결제 요청할 데이터
     * https://docs.iamport.kr/tech/imp?lang=ko#param
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * SDK 에 결제 요청할 데이터
     * https://docs.iamport.kr/tech/imp?lang=ko#param
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * SDK 에 결제 요청할 데이터
     * https://docs.iamport.kr/tech/imp?lang=ko#param
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public IamPortRequest(@org.jetbrains.annotations.NotNull()
    java.lang.String pg, @org.jetbrains.annotations.NotNull()
    java.lang.String pay_method, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean escrow, @org.jetbrains.annotations.NotNull()
    java.lang.String merchant_uid, @org.jetbrains.annotations.Nullable()
    java.lang.String customer_uid, @org.jetbrains.annotations.Nullable()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String amount, @org.jetbrains.annotations.Nullable()
    java.lang.String custom_data, @org.jetbrains.annotations.Nullable()
    java.lang.Float tax_free, @org.jetbrains.annotations.Nullable()
    java.lang.String currency, @org.jetbrains.annotations.Nullable()
    java.lang.String language, @org.jetbrains.annotations.Nullable()
    java.lang.String buyer_name, @org.jetbrains.annotations.Nullable()
    java.lang.String buyer_tel, @org.jetbrains.annotations.Nullable()
    java.lang.String buyer_email, @org.jetbrains.annotations.Nullable()
    java.lang.String buyer_addr, @org.jetbrains.annotations.Nullable()
    java.lang.String buyer_postcode, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> notice_url, @org.jetbrains.annotations.Nullable()
    com.iamport.sdk.data.sdk.CardQuota display, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean digital, @org.jetbrains.annotations.Nullable()
    java.lang.String vbank_due, @org.jetbrains.annotations.Nullable()
    java.lang.String app_scheme, @org.jetbrains.annotations.Nullable()
    java.lang.String biz_num, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean popup, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean naverPopupMode, @org.jetbrains.annotations.Nullable()
    java.lang.String naverUseCfm, @org.jetbrains.annotations.Nullable()
    java.util.List<? extends com.iamport.sdk.data.sdk.BaseProductItem> naverProducts, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean naverCultureBenefit, @org.jetbrains.annotations.Nullable()
    java.lang.String naverProductCode, @org.jetbrains.annotations.Nullable()
    java.lang.String naverActionType, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean cultureBenefit, @org.jetbrains.annotations.Nullable()
    com.iamport.sdk.data.sdk.NaverInterface naverInterface, @org.jetbrains.annotations.Nullable()
    java.lang.String confirm_url, @org.jetbrains.annotations.Nullable()
    com.iamport.sdk.data.sdk.Card card) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPg() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPay_method() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getEscrow() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMerchant_uid() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCustomer_uid() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAmount() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCustom_data() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Float component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Float getTax_free() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCurrency() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLanguage() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getBuyer_name() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getBuyer_tel() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component14() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getBuyer_email() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getBuyer_addr() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component16() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getBuyer_postcode() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> component17() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getNotice_url() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.iamport.sdk.data.sdk.CardQuota component18() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.iamport.sdk.data.sdk.CardQuota getDisplay() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component19() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getDigital() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component20() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getVbank_due() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component21() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getApp_scheme() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component22() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getBiz_num() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component23() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getPopup() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component24() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getNaverPopupMode() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component25() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getNaverUseCfm() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.iamport.sdk.data.sdk.BaseProductItem> component26() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.iamport.sdk.data.sdk.BaseProductItem> getNaverProducts() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component27() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getNaverCultureBenefit() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component28() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getNaverProductCode() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component29() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getNaverActionType() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component30() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getCultureBenefit() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.iamport.sdk.data.sdk.NaverInterface component31() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.iamport.sdk.data.sdk.NaverInterface getNaverInterface() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component32() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getConfirm_url() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.iamport.sdk.data.sdk.Card component33() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.iamport.sdk.data.sdk.Card getCard() {
        return null;
    }
    
    /**
     * string pg 으로 enum PG 가져옴
     */
    @kotlinx.parcelize.IgnoredOnParcel()
    @java.lang.Deprecated()
    public static void getPgEnum$annotations() {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.iamport.sdk.data.sdk.PG getPgEnum() {
        return null;
    }
    
    @kotlinx.parcelize.IgnoredOnParcel()
    @java.lang.Deprecated()
    public static void getPlatform$annotations() {
    }
    
    public final void setPlatform(@org.jetbrains.annotations.Nullable()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPlatform() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.JvmStatic()
    public static final com.iamport.sdk.data.sdk.IamPortRequest.Companion.Builder builder() {
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
    public static final class Creator implements android.os.Parcelable.Creator<com.iamport.sdk.data.sdk.IamPortRequest> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.iamport.sdk.data.sdk.IamPortRequest createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.iamport.sdk.data.sdk.IamPortRequest[] newArray(int size) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007\u00a8\u0006\u0006"}, d2 = {"Lcom/iamport/sdk/data/sdk/IamPortRequest$Companion;", "", "()V", "builder", "Lcom/iamport/sdk/data/sdk/IamPortRequest$Companion$Builder;", "Builder", "sdk_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @kotlin.jvm.JvmStatic()
        public final com.iamport.sdk.data.sdk.IamPortRequest.Companion.Builder builder() {
            return null;
        }
        
        @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010z\u001a\u00020{J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0004J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0004J\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0004J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"J\u000e\u0010(\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u0004J\u000e\u0010+\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u0004J\u000e\u0010.\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u0004J\u000e\u00101\u001a\u00020\u00002\u0006\u00101\u001a\u00020\"J\u000e\u00104\u001a\u00020\u00002\u0006\u00104\u001a\u000205J\u000e\u0010:\u001a\u00020\u00002\u0006\u0010:\u001a\u00020\"J\u000e\u0010=\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\u0004J\u000e\u0010A\u001a\u00020\u00002\u0006\u0010A\u001a\u00020\u0004J\u000e\u0010D\u001a\u00020\u00002\u0006\u0010D\u001a\u00020\u0004J\u000e\u0010G\u001a\u00020\u00002\u0006\u0010G\u001a\u00020\u0004J\u000e\u0010J\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\"J\u000e\u0010M\u001a\u00020\u00002\u0006\u0010M\u001a\u00020NJ\u000e\u0010S\u001a\u00020\u00002\u0006\u0010S\u001a\u00020\"J\u000e\u0010V\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u0004J\u0014\u0010Y\u001a\u00020\u00002\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020[0ZJ\u000e\u0010`\u001a\u00020\u00002\u0006\u0010`\u001a\u00020\u0004J\u0014\u0010d\u001a\u00020\u00002\f\u0010d\u001a\b\u0012\u0004\u0012\u00020\u00040ZJ\u000e\u0010g\u001a\u00020\u00002\u0006\u0010g\u001a\u00020\u0004J\u000e\u0010j\u001a\u00020\u00002\u0006\u0010j\u001a\u00020\u0004J\u000e\u0010m\u001a\u00020\u00002\u0006\u0010m\u001a\u00020\"J\u000e\u0010p\u001a\u00020\u00002\u0006\u0010p\u001a\u00020qJ\u000e\u0010w\u001a\u00020\u00002\u0006\u0010w\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001e\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\'\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010(\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR\u001c\u0010+\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR\u001c\u0010.\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\bR\u001e\u00101\u001a\u0004\u0018\u00010\"X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\'\u001a\u0004\b2\u0010$\"\u0004\b3\u0010&R\u001c\u00104\u001a\u0004\u0018\u000105X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001e\u0010:\u001a\u0004\u0018\u00010\"X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\'\u001a\u0004\b;\u0010$\"\u0004\b<\u0010&R\u001c\u0010=\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0006\"\u0004\b?\u0010\bR\u0010\u0010@\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010A\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0006\"\u0004\bC\u0010\bR\u001c\u0010D\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0006\"\u0004\bF\u0010\bR\u001c\u0010G\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0006\"\u0004\bI\u0010\bR\u001e\u0010J\u001a\u0004\u0018\u00010\"X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\'\u001a\u0004\bK\u0010$\"\u0004\bL\u0010&R\u001c\u0010M\u001a\u0004\u0018\u00010NX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u001e\u0010S\u001a\u0004\u0018\u00010\"X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\'\u001a\u0004\bT\u0010$\"\u0004\bU\u0010&R\u001c\u0010V\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u0006\"\u0004\bX\u0010\bR\"\u0010Y\u001a\n\u0012\u0004\u0012\u00020[\u0018\u00010ZX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u001c\u0010`\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\ba\u0010\u0006\"\u0004\bb\u0010\bR\u000e\u0010c\u001a\u00020\"X\u0082D\u00a2\u0006\u0002\n\u0000R\"\u0010d\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010ZX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\be\u0010]\"\u0004\bf\u0010_R\u001a\u0010g\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\u0006\"\u0004\bi\u0010\bR\u001a\u0010j\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bk\u0010\u0006\"\u0004\bl\u0010\bR\u001e\u0010m\u001a\u0004\u0018\u00010\"X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\'\u001a\u0004\bn\u0010$\"\u0004\bo\u0010&R\u001e\u0010p\u001a\u0004\u0018\u00010qX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010v\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\u001c\u0010w\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bx\u0010\u0006\"\u0004\by\u0010\b\u00a8\u0006|"}, d2 = {"Lcom/iamport/sdk/data/sdk/IamPortRequest$Companion$Builder;", "", "()V", "amount", "", "getAmount", "()Ljava/lang/String;", "setAmount", "(Ljava/lang/String;)V", "app_scheme", "getApp_scheme", "setApp_scheme", "biz_num", "getBiz_num", "setBiz_num", "buyer_addr", "getBuyer_addr", "setBuyer_addr", "buyer_email", "getBuyer_email", "setBuyer_email", "buyer_name", "getBuyer_name", "setBuyer_name", "buyer_postcode", "getBuyer_postcode", "setBuyer_postcode", "buyer_tel", "getBuyer_tel", "setBuyer_tel", "confirm_url", "getConfirm_url", "setConfirm_url", "cultureBenefit", "", "getCultureBenefit", "()Ljava/lang/Boolean;", "setCultureBenefit", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "currency", "getCurrency", "setCurrency", "custom_data", "getCustom_data", "setCustom_data", "customer_uid", "getCustomer_uid", "setCustomer_uid", "digital", "getDigital", "setDigital", "display", "Lcom/iamport/sdk/data/sdk/CardQuota;", "getDisplay", "()Lcom/iamport/sdk/data/sdk/CardQuota;", "setDisplay", "(Lcom/iamport/sdk/data/sdk/CardQuota;)V", "escrow", "getEscrow", "setEscrow", "language", "getLanguage", "setLanguage", "m_redirect_url", "merchant_uid", "getMerchant_uid", "setMerchant_uid", "name", "getName", "setName", "naverActionType", "getNaverActionType", "setNaverActionType", "naverCultureBenefit", "getNaverCultureBenefit", "setNaverCultureBenefit", "naverInterface", "Lcom/iamport/sdk/data/sdk/NaverInterface;", "getNaverInterface", "()Lcom/iamport/sdk/data/sdk/NaverInterface;", "setNaverInterface", "(Lcom/iamport/sdk/data/sdk/NaverInterface;)V", "naverPopupMode", "getNaverPopupMode", "setNaverPopupMode", "naverProductCode", "getNaverProductCode", "setNaverProductCode", "naverProducts", "", "Lcom/iamport/sdk/data/sdk/BaseProductItem;", "getNaverProducts", "()Ljava/util/List;", "setNaverProducts", "(Ljava/util/List;)V", "naverUseCfm", "getNaverUseCfm", "setNaverUseCfm", "niceMobileV2", "notice_url", "getNotice_url", "setNotice_url", "pay_method", "getPay_method", "setPay_method", "pg", "getPg", "setPg", "popup", "getPopup", "setPopup", "tax_free", "", "getTax_free", "()Ljava/lang/Float;", "setTax_free", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "vbank_due", "getVbank_due", "setVbank_due", "build", "Lcom/iamport/sdk/data/sdk/IamPortRequest;", "sdk_debug"})
        public static final class Builder {
            public java.lang.String pg;
            public java.lang.String merchant_uid;
            public java.lang.String amount;
            @org.jetbrains.annotations.NotNull()
            private java.lang.String pay_method;
            @org.jetbrains.annotations.Nullable()
            private java.lang.Boolean escrow;
            @org.jetbrains.annotations.Nullable()
            private java.lang.String customer_uid;
            @org.jetbrains.annotations.Nullable()
            private java.lang.String name;
            @org.jetbrains.annotations.Nullable()
            private java.lang.String custom_data;
            @org.jetbrains.annotations.Nullable()
            private java.lang.Float tax_free;
            @org.jetbrains.annotations.Nullable()
            private java.lang.String currency;
            @org.jetbrains.annotations.Nullable()
            private java.lang.String language;
            @org.jetbrains.annotations.Nullable()
            private java.lang.String buyer_name;
            @org.jetbrains.annotations.Nullable()
            private java.lang.String buyer_tel;
            @org.jetbrains.annotations.Nullable()
            private java.lang.String buyer_email;
            @org.jetbrains.annotations.Nullable()
            private java.lang.String buyer_addr;
            @org.jetbrains.annotations.Nullable()
            private java.lang.String buyer_postcode;
            @org.jetbrains.annotations.Nullable()
            private java.util.List<java.lang.String> notice_url;
            @org.jetbrains.annotations.Nullable()
            private com.iamport.sdk.data.sdk.CardQuota display;
            @org.jetbrains.annotations.Nullable()
            private java.lang.Boolean digital;
            @org.jetbrains.annotations.Nullable()
            private java.lang.String vbank_due;
            private java.lang.String m_redirect_url;
            @org.jetbrains.annotations.Nullable()
            private java.lang.String app_scheme;
            @org.jetbrains.annotations.Nullable()
            private java.lang.String biz_num;
            @org.jetbrains.annotations.Nullable()
            private java.lang.Boolean popup;
            private final boolean niceMobileV2 = true;
            @org.jetbrains.annotations.Nullable()
            private java.lang.Boolean naverPopupMode;
            @org.jetbrains.annotations.Nullable()
            private java.lang.String naverUseCfm;
            @org.jetbrains.annotations.Nullable()
            private java.util.List<? extends com.iamport.sdk.data.sdk.BaseProductItem> naverProducts;
            @org.jetbrains.annotations.Nullable()
            private java.lang.Boolean naverCultureBenefit;
            @org.jetbrains.annotations.Nullable()
            private java.lang.String naverProductCode;
            @org.jetbrains.annotations.Nullable()
            private java.lang.String naverActionType;
            @org.jetbrains.annotations.Nullable()
            private java.lang.Boolean cultureBenefit;
            @org.jetbrains.annotations.Nullable()
            private com.iamport.sdk.data.sdk.NaverInterface naverInterface;
            @org.jetbrains.annotations.Nullable()
            private java.lang.String confirm_url;
            
            public Builder() {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getPg() {
                return null;
            }
            
            public final void setPg(@org.jetbrains.annotations.NotNull()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getMerchant_uid() {
                return null;
            }
            
            public final void setMerchant_uid(@org.jetbrains.annotations.NotNull()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getAmount() {
                return null;
            }
            
            public final void setAmount(@org.jetbrains.annotations.NotNull()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getPay_method() {
                return null;
            }
            
            public final void setPay_method(@org.jetbrains.annotations.NotNull()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.Boolean getEscrow() {
                return null;
            }
            
            public final void setEscrow(@org.jetbrains.annotations.Nullable()
            java.lang.Boolean p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getCustomer_uid() {
                return null;
            }
            
            public final void setCustomer_uid(@org.jetbrains.annotations.Nullable()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getName() {
                return null;
            }
            
            public final void setName(@org.jetbrains.annotations.Nullable()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getCustom_data() {
                return null;
            }
            
            public final void setCustom_data(@org.jetbrains.annotations.Nullable()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.Float getTax_free() {
                return null;
            }
            
            public final void setTax_free(@org.jetbrains.annotations.Nullable()
            java.lang.Float p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getCurrency() {
                return null;
            }
            
            public final void setCurrency(@org.jetbrains.annotations.Nullable()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getLanguage() {
                return null;
            }
            
            public final void setLanguage(@org.jetbrains.annotations.Nullable()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getBuyer_name() {
                return null;
            }
            
            public final void setBuyer_name(@org.jetbrains.annotations.Nullable()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getBuyer_tel() {
                return null;
            }
            
            public final void setBuyer_tel(@org.jetbrains.annotations.Nullable()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getBuyer_email() {
                return null;
            }
            
            public final void setBuyer_email(@org.jetbrains.annotations.Nullable()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getBuyer_addr() {
                return null;
            }
            
            public final void setBuyer_addr(@org.jetbrains.annotations.Nullable()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getBuyer_postcode() {
                return null;
            }
            
            public final void setBuyer_postcode(@org.jetbrains.annotations.Nullable()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.util.List<java.lang.String> getNotice_url() {
                return null;
            }
            
            public final void setNotice_url(@org.jetbrains.annotations.Nullable()
            java.util.List<java.lang.String> p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final com.iamport.sdk.data.sdk.CardQuota getDisplay() {
                return null;
            }
            
            public final void setDisplay(@org.jetbrains.annotations.Nullable()
            com.iamport.sdk.data.sdk.CardQuota p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.Boolean getDigital() {
                return null;
            }
            
            public final void setDigital(@org.jetbrains.annotations.Nullable()
            java.lang.Boolean p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getVbank_due() {
                return null;
            }
            
            public final void setVbank_due(@org.jetbrains.annotations.Nullable()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getApp_scheme() {
                return null;
            }
            
            public final void setApp_scheme(@org.jetbrains.annotations.Nullable()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getBiz_num() {
                return null;
            }
            
            public final void setBiz_num(@org.jetbrains.annotations.Nullable()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.Boolean getPopup() {
                return null;
            }
            
            public final void setPopup(@org.jetbrains.annotations.Nullable()
            java.lang.Boolean p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.Boolean getNaverPopupMode() {
                return null;
            }
            
            public final void setNaverPopupMode(@org.jetbrains.annotations.Nullable()
            java.lang.Boolean p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getNaverUseCfm() {
                return null;
            }
            
            public final void setNaverUseCfm(@org.jetbrains.annotations.Nullable()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.util.List<com.iamport.sdk.data.sdk.BaseProductItem> getNaverProducts() {
                return null;
            }
            
            public final void setNaverProducts(@org.jetbrains.annotations.Nullable()
            java.util.List<? extends com.iamport.sdk.data.sdk.BaseProductItem> p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.Boolean getNaverCultureBenefit() {
                return null;
            }
            
            public final void setNaverCultureBenefit(@org.jetbrains.annotations.Nullable()
            java.lang.Boolean p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getNaverProductCode() {
                return null;
            }
            
            public final void setNaverProductCode(@org.jetbrains.annotations.Nullable()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getNaverActionType() {
                return null;
            }
            
            public final void setNaverActionType(@org.jetbrains.annotations.Nullable()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.Boolean getCultureBenefit() {
                return null;
            }
            
            public final void setCultureBenefit(@org.jetbrains.annotations.Nullable()
            java.lang.Boolean p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final com.iamport.sdk.data.sdk.NaverInterface getNaverInterface() {
                return null;
            }
            
            public final void setNaverInterface(@org.jetbrains.annotations.Nullable()
            com.iamport.sdk.data.sdk.NaverInterface p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getConfirm_url() {
                return null;
            }
            
            public final void setConfirm_url(@org.jetbrains.annotations.Nullable()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.iamport.sdk.data.sdk.IamPortRequest.Companion.Builder pg(@org.jetbrains.annotations.NotNull()
            java.lang.String pg) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.iamport.sdk.data.sdk.IamPortRequest.Companion.Builder pay_method(@org.jetbrains.annotations.NotNull()
            java.lang.String pay_method) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.iamport.sdk.data.sdk.IamPortRequest.Companion.Builder escrow(boolean escrow) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.iamport.sdk.data.sdk.IamPortRequest.Companion.Builder merchant_uid(@org.jetbrains.annotations.NotNull()
            java.lang.String merchant_uid) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.iamport.sdk.data.sdk.IamPortRequest.Companion.Builder name(@org.jetbrains.annotations.NotNull()
            java.lang.String name) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.iamport.sdk.data.sdk.IamPortRequest.Companion.Builder customer_uid(@org.jetbrains.annotations.NotNull()
            java.lang.String customer_uid) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.iamport.sdk.data.sdk.IamPortRequest.Companion.Builder amount(@org.jetbrains.annotations.NotNull()
            java.lang.String amount) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.iamport.sdk.data.sdk.IamPortRequest.Companion.Builder custom_data(@org.jetbrains.annotations.NotNull()
            java.lang.String custom_data) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.iamport.sdk.data.sdk.IamPortRequest.Companion.Builder tax_free(float tax_free) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.iamport.sdk.data.sdk.IamPortRequest.Companion.Builder currency(@org.jetbrains.annotations.NotNull()
            java.lang.String currency) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.iamport.sdk.data.sdk.IamPortRequest.Companion.Builder language(@org.jetbrains.annotations.NotNull()
            java.lang.String language) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.iamport.sdk.data.sdk.IamPortRequest.Companion.Builder buyer_name(@org.jetbrains.annotations.NotNull()
            java.lang.String buyer_name) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.iamport.sdk.data.sdk.IamPortRequest.Companion.Builder buyer_tel(@org.jetbrains.annotations.NotNull()
            java.lang.String buyer_tel) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.iamport.sdk.data.sdk.IamPortRequest.Companion.Builder buyer_email(@org.jetbrains.annotations.NotNull()
            java.lang.String buyer_email) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.iamport.sdk.data.sdk.IamPortRequest.Companion.Builder buyer_addr(@org.jetbrains.annotations.NotNull()
            java.lang.String buyer_addr) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.iamport.sdk.data.sdk.IamPortRequest.Companion.Builder buyer_postcode(@org.jetbrains.annotations.NotNull()
            java.lang.String buyer_postcode) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.iamport.sdk.data.sdk.IamPortRequest.Companion.Builder notice_url(@org.jetbrains.annotations.NotNull()
            java.util.List<java.lang.String> notice_url) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.iamport.sdk.data.sdk.IamPortRequest.Companion.Builder display(@org.jetbrains.annotations.NotNull()
            com.iamport.sdk.data.sdk.CardQuota display) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.iamport.sdk.data.sdk.IamPortRequest.Companion.Builder digital(boolean digital) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.iamport.sdk.data.sdk.IamPortRequest.Companion.Builder vbank_due(@org.jetbrains.annotations.NotNull()
            java.lang.String vbank_due) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.iamport.sdk.data.sdk.IamPortRequest.Companion.Builder app_scheme(@org.jetbrains.annotations.NotNull()
            java.lang.String app_scheme) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.iamport.sdk.data.sdk.IamPortRequest.Companion.Builder biz_num(@org.jetbrains.annotations.NotNull()
            java.lang.String biz_num) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.iamport.sdk.data.sdk.IamPortRequest.Companion.Builder popup(boolean popup) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.iamport.sdk.data.sdk.IamPortRequest.Companion.Builder naverPopupMode(boolean naverPopupMode) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.iamport.sdk.data.sdk.IamPortRequest.Companion.Builder naverUseCfm(@org.jetbrains.annotations.NotNull()
            java.lang.String naverUseCfm) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.iamport.sdk.data.sdk.IamPortRequest.Companion.Builder naverProducts(@org.jetbrains.annotations.NotNull()
            java.util.List<? extends com.iamport.sdk.data.sdk.BaseProductItem> naverProducts) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.iamport.sdk.data.sdk.IamPortRequest.Companion.Builder naverCultureBenefit(boolean naverCultureBenefit) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.iamport.sdk.data.sdk.IamPortRequest.Companion.Builder naverProductCode(@org.jetbrains.annotations.NotNull()
            java.lang.String naverProductCode) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.iamport.sdk.data.sdk.IamPortRequest.Companion.Builder naverActionType(@org.jetbrains.annotations.NotNull()
            java.lang.String naverActionType) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.iamport.sdk.data.sdk.IamPortRequest.Companion.Builder cultureBenefit(boolean cultureBenefit) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.iamport.sdk.data.sdk.IamPortRequest.Companion.Builder naverInterface(@org.jetbrains.annotations.NotNull()
            com.iamport.sdk.data.sdk.NaverInterface naverInterface) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.iamport.sdk.data.sdk.IamPortRequest.Companion.Builder confirm_url(@org.jetbrains.annotations.NotNull()
            java.lang.String confirm_url) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.iamport.sdk.data.sdk.IamPortRequest build() {
                return null;
            }
        }
    }
}