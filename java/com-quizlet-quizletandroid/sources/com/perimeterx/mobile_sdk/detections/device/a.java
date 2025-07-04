package com.perimeterx.mobile_sdk.detections.device;

import android.os.Build;
import com.google.android.gms.internal.ads.C2034f0;
import java.util.ArrayList;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class a {
    public final ArrayList A;
    public final ArrayList B;
    public final String a;
    public final int b;
    public final int c;
    public final int d;
    public final String e;
    public final boolean f;
    public final com.perimeterx.mobile_sdk.reachability.a g;
    public final Integer h;
    public final String i;
    public final int j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final boolean o;
    public final boolean p;
    public final boolean q;
    public final boolean r;
    public final boolean s;
    public final boolean t;
    public final boolean u;
    public final C2034f0 v;
    public final String w;
    public final long x;
    public final boolean y;
    public final boolean z;

    public a(String androidId, int i, int i2, int i3, String str, boolean z, com.perimeterx.mobile_sdk.reachability.a aVar, Integer num, int i4, String systemOsVersion, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, C2034f0 c2034f0, String deviceLanguage, long j, boolean z9, boolean z10, ArrayList touchDatas, ArrayList deviceMotionDatas) {
        String osVersion = Build.VERSION.RELEASE;
        String deviceModel = Build.MODEL;
        String deviceName = Build.DEVICE;
        String deviceManufacturer = Build.MANUFACTURER;
        String deviceFingerprint = Build.FINGERPRINT;
        String deviceBoard = Build.BOARD;
        String deviceBootloader = Build.BOOTLOADER;
        String deviceBrand = Build.BRAND;
        String deviceDisplay = Build.DISPLAY;
        String deviceHardware = Build.HARDWARE;
        String deviceUser = Build.USER;
        Intrinsics.checkNotNullParameter(androidId, "androidId");
        Intrinsics.checkNotNullParameter(osVersion, "osVersion");
        Intrinsics.checkNotNullParameter(systemOsVersion, "systemOsVersion");
        Intrinsics.checkNotNullParameter(deviceModel, "deviceModel");
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        Intrinsics.checkNotNullParameter(deviceManufacturer, "deviceManufacturer");
        Intrinsics.checkNotNullParameter(deviceFingerprint, "deviceFingerprint");
        Intrinsics.checkNotNullParameter(deviceBoard, "deviceBoard");
        Intrinsics.checkNotNullParameter(deviceBootloader, "deviceBootloader");
        Intrinsics.checkNotNullParameter(deviceBrand, "deviceBrand");
        Intrinsics.checkNotNullParameter(deviceDisplay, "deviceDisplay");
        Intrinsics.checkNotNullParameter(deviceHardware, "deviceHardware");
        Intrinsics.checkNotNullParameter(deviceUser, "deviceUser");
        Intrinsics.checkNotNullParameter(deviceLanguage, "deviceLanguage");
        Intrinsics.checkNotNullParameter(touchDatas, "touchDatas");
        Intrinsics.checkNotNullParameter(deviceMotionDatas, "deviceMotionDatas");
        Intrinsics.checkNotNullExpressionValue(UUID.randomUUID().toString(), "toString(...)");
        this.a = androidId;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = str;
        this.f = z;
        this.g = aVar;
        this.h = num;
        this.i = osVersion;
        this.j = i4;
        this.k = systemOsVersion;
        this.l = deviceModel;
        this.m = deviceName;
        this.n = deviceManufacturer;
        this.o = z2;
        this.p = z3;
        this.q = z4;
        this.r = z5;
        this.s = z6;
        this.t = z7;
        this.u = z8;
        this.v = c2034f0;
        this.w = deviceLanguage;
        this.x = j;
        this.y = z9;
        this.z = z10;
        this.A = touchDatas;
        this.B = deviceMotionDatas;
    }
}
