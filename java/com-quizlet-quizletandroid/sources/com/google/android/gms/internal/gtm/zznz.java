package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.u;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class zznz implements zzjm {
    @Override // com.google.android.gms.internal.gtm.zzjm
    public final zzqo zzd(zzhx zzhxVar, zzqo... zzqoVarArr) {
        u.b(zzqoVarArr != null);
        u.b(zzqoVarArr.length == 0);
        return new zzqz(Locale.getDefault().getCountry());
    }
}
