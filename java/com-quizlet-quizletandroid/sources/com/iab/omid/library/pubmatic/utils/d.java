package com.iab.omid.library.pubmatic.utils;

import android.text.TextUtils;
import android.util.Log;

/* loaded from: classes2.dex */
public final class d {
    public static void a(String str) {
        if (!com.iab.omid.library.pubmatic.a.a.booleanValue() || TextUtils.isEmpty(str)) {
            return;
        }
        Log.i("OMIDLIB", str);
    }

    public static void b(String str) {
        if (!com.iab.omid.library.pubmatic.a.a.booleanValue() || TextUtils.isEmpty(str)) {
            return;
        }
        Log.w("OMIDLIB", str);
    }

    public static void a(String str, Exception exc) {
        if ((!com.iab.omid.library.pubmatic.a.a.booleanValue() || TextUtils.isEmpty(str)) && exc == null) {
            return;
        }
        Log.e("OMIDLIB", str, exc);
    }
}
