package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.AbstractC3489l3;

/* loaded from: classes2.dex */
public final class zzov extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzov> CREATOR = new com.google.android.gms.fido.fido2.api.common.i(13);
    public final String a;
    public final long b;
    public final int c;

    public zzov(int i, long j, String str) {
        this.a = str;
        this.b = j;
        this.c = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iN = AbstractC3489l3.n(20293, parcel);
        AbstractC3489l3.h(parcel, 1, this.a);
        AbstractC3489l3.m(parcel, 2, 8);
        parcel.writeLong(this.b);
        AbstractC3489l3.m(parcel, 3, 4);
        parcel.writeInt(this.c);
        AbstractC3489l3.o(iN, parcel);
    }
}
