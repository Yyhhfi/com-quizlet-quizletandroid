package com.perimeterx.mobile_sdk.doctor_app;

import com.google.android.gms.internal.mlkit_vision_camera.AbstractC3328d;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class g {
    public static final g a;
    public static final g b;
    public static final /* synthetic */ g[] c;

    static {
        g gVar = new g("NATIVE", 0);
        a = gVar;
        g gVar2 = new g("WEB_VIEW", 1);
        b = gVar2;
        g[] gVarArr = {gVar, gVar2};
        c = gVarArr;
        AbstractC3328d.f(gVarArr);
    }

    public static g valueOf(String str) {
        return (g) Enum.valueOf(g.class, str);
    }

    public static g[] values() {
        return (g[]) c.clone();
    }
}
