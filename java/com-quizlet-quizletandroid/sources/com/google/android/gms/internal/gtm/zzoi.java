package com.google.android.gms.internal.gtm;

import android.os.Build;
import com.google.android.gms.common.internal.u;

/* loaded from: classes2.dex */
public final class zzoi implements zzjm {
    @Override // com.google.android.gms.internal.gtm.zzjm
    public final zzqo zzd(zzhx zzhxVar, zzqo... zzqoVarArr) {
        u.b(zzqoVarArr != null);
        u.b(zzqoVarArr.length == 0);
        return new zzqq(Double.valueOf(Build.VERSION.SDK_INT));
    }
}
