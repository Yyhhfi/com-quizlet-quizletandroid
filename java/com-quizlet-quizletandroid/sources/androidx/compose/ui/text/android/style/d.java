package androidx.compose.ui.text.android.style;

import android.text.Layout;

/* loaded from: classes.dex */
public abstract /* synthetic */ class d {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[Layout.Alignment.values().length];
        try {
            iArr[Layout.Alignment.ALIGN_CENTER.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        a = iArr;
    }
}
