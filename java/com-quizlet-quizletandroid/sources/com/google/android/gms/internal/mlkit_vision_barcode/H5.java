package com.google.android.gms.internal.mlkit_vision_barcode;

/* loaded from: classes2.dex */
public enum H5 implements J {
    TYPE_UNKNOWN(0),
    TYPE_CONTACT_INFO(1),
    TYPE_EMAIL(2),
    TYPE_ISBN(3),
    TYPE_PHONE(4),
    TYPE_PRODUCT(5),
    TYPE_SMS(6),
    TYPE_TEXT(7),
    TYPE_URL(8),
    TYPE_WIFI(9),
    TYPE_GEO(10),
    TYPE_CALENDAR_EVENT(11),
    TYPE_DRIVER_LICENSE(12);

    public final int a;

    H5(int i) {
        this.a = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.J
    public final int zza() {
        return this.a;
    }
}
