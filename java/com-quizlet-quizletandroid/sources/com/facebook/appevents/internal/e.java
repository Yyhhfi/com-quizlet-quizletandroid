package com.facebook.appevents.internal;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class e {
    public static final e a;
    public static final e b;
    public static final /* synthetic */ e[] c;

    static {
        e eVar = new e("MOBILE_INSTALL_EVENT", 0);
        a = eVar;
        e eVar2 = new e("CUSTOM_APP_EVENTS", 1);
        b = eVar2;
        c = new e[]{eVar, eVar2};
    }

    public static e valueOf(String str) {
        return (e) Enum.valueOf(e.class, str);
    }

    public static e[] values() {
        return (e[]) c.clone();
    }
}
