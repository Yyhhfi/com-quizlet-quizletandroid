package com.facebook.appevents;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class o {
    public static final o a;
    public static final o b;
    public static final o c;
    public static final /* synthetic */ o[] d;

    static {
        o oVar = new o("SUCCESS", 0);
        a = oVar;
        o oVar2 = new o("SERVER_ERROR", 1);
        b = oVar2;
        o oVar3 = new o("NO_CONNECTIVITY", 2);
        c = oVar3;
        d = new o[]{oVar, oVar2, oVar3, new o("UNKNOWN_ERROR", 3)};
    }

    public static o valueOf(String str) {
        return (o) Enum.valueOf(o.class, str);
    }

    public static o[] values() {
        return (o[]) d.clone();
    }
}
