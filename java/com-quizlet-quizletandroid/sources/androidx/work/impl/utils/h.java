package androidx.work.impl.utils;

import android.content.ComponentName;
import android.content.Context;
import androidx.work.z;

/* loaded from: classes.dex */
public abstract class h {
    static {
        z.e("PackageManagerHelper");
    }

    public static void a(Context context, Class cls, boolean z) {
        try {
            int componentEnabledSetting = context.getPackageManager().getComponentEnabledSetting(new ComponentName(context, cls.getName()));
            boolean z2 = false;
            if (componentEnabledSetting != 0 && componentEnabledSetting == 1) {
                z2 = true;
            }
            if (z == z2) {
                z.c().getClass();
            } else {
                context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, cls.getName()), z ? 1 : 2, 1);
                z.c().getClass();
            }
        } catch (Exception unused) {
            z.c().getClass();
        }
    }
}
