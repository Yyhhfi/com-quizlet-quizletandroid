package com.google.android.gms.internal.ads;

import androidx.camera.camera2.internal.AbstractC0147y;

/* loaded from: classes2.dex */
public final class TB extends OA {
    private static final TB zza;
    private static volatile InterfaceC2219jB zzb;
    private int zzc;
    private BA zzd;
    private BA zze;
    private BA zzf;

    static {
        TB tb = new TB();
        zza = tb;
        OA.k(TB.class, tb);
    }

    public TB() {
        C2905zA c2905zA = BA.b;
        this.zzd = c2905zA;
        this.zze = c2905zA;
        this.zzf = c2905zA;
    }

    @Override // com.google.android.gms.internal.ads.OA
    public final Object s(int i, OA oa) {
        InterfaceC2219jB na;
        int iK = AbstractC0147y.k(i);
        if (iK == 0) {
            return (byte) 1;
        }
        if (iK == 2) {
            return new C2391nB(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
        }
        if (iK == 3) {
            return new TB();
        }
        if (iK == 4) {
            return new C1954d7(zza);
        }
        if (iK == 5) {
            return zza;
        }
        if (iK != 6) {
            throw null;
        }
        InterfaceC2219jB interfaceC2219jB = zzb;
        if (interfaceC2219jB != null) {
            return interfaceC2219jB;
        }
        synchronized (TB.class) {
            try {
                na = zzb;
                if (na == null) {
                    na = new NA();
                    zzb = na;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return na;
    }
}
