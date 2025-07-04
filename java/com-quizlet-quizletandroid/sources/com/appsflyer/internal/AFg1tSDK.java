package com.appsflyer.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes.dex */
public final class AFg1tSDK implements AFg1vSDK {

    @NotNull
    private Map<String, String> getRevenue = new LinkedHashMap();

    @Override // com.appsflyer.internal.AFg1vSDK
    @NotNull
    public final Map<String, String> AFAdRevenueData(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        if (this.getRevenue.isEmpty()) {
            Resources resources = context.getResources();
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            int i = resources.getConfiguration().screenLayout & 15;
            this.getRevenue.put("xdp", String.valueOf(displayMetrics.xdpi));
            this.getRevenue.put("ydp", String.valueOf(displayMetrics.ydpi));
            this.getRevenue.put("x_px", String.valueOf(displayMetrics.widthPixels));
            this.getRevenue.put("y_px", String.valueOf(displayMetrics.heightPixels));
            this.getRevenue.put("d_dpi", String.valueOf(displayMetrics.densityDpi));
            this.getRevenue.put("size", String.valueOf(i));
        }
        return this.getRevenue;
    }
}
