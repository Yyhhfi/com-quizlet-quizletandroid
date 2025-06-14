package com.google.android.gms.internal.gtm;

import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.google.android.gms.common.internal.u;
import com.google.android.gms.common.util.c;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzcs {
    private final zzbu zza;
    private volatile Boolean zzb;
    private String zzc;
    private Set zzd;

    public zzcs(zzbu zzbuVar) {
        u.h(zzbuVar);
        this.zza = zzbuVar;
    }

    public static final long zzc() {
        return ((Long) zzeh.zzy.zzb()).longValue();
    }

    public static final long zzd() {
        return ((Long) zzeh.zzg.zzb()).longValue();
    }

    public static final long zze() {
        return ((Long) zzeh.zzf.zzb()).longValue();
    }

    public static final int zzf() {
        return ((Integer) zzeh.zzr.zzb()).intValue();
    }

    public static final int zzg() {
        return ((Integer) zzeh.zzj.zzb()).intValue();
    }

    public static final int zzh() {
        return ((Integer) zzeh.zzi.zzb()).intValue();
    }

    public static final String zzi() {
        return (String) zzeh.zzl.zzb();
    }

    public static final String zzj() {
        return (String) zzeh.zzm.zzb();
    }

    public static final String zzk() {
        return (String) zzeh.zzk.zzb();
    }

    public static final boolean zzl() {
        return ((Boolean) zzeh.zza.zzb()).booleanValue();
    }

    public final Set zza() {
        String str;
        String str2 = (String) zzeh.zzu.zzb();
        if (this.zzd == null || (str = this.zzc) == null || !str.equals(str2)) {
            String[] strArrSplit = TextUtils.split(str2, ",");
            HashSet hashSet = new HashSet();
            for (String str3 : strArrSplit) {
                try {
                    hashSet.add(Integer.valueOf(Integer.parseInt(str3)));
                } catch (NumberFormatException unused) {
                }
            }
            this.zzc = str2;
            this.zzd = hashSet;
        }
        return this.zzd;
    }

    public final boolean zzb() {
        if (this.zzb == null) {
            synchronized (this) {
                try {
                    if (this.zzb == null) {
                        ApplicationInfo applicationInfo = this.zza.zza().getApplicationInfo();
                        String strH = c.h();
                        if (applicationInfo != null) {
                            String str = applicationInfo.processName;
                            boolean z = false;
                            if (str != null && str.equals(strH)) {
                                z = true;
                            }
                            this.zzb = Boolean.valueOf(z);
                        }
                        if ((this.zzb == null || !this.zzb.booleanValue()) && "com.google.android.gms.analytics".equals(strH)) {
                            this.zzb = Boolean.TRUE;
                        }
                        if (this.zzb == null) {
                            this.zzb = Boolean.TRUE;
                            this.zza.zzm().zzI("My process not in the list of running processes");
                        }
                    }
                } finally {
                }
            }
        }
        return this.zzb.booleanValue();
    }
}
