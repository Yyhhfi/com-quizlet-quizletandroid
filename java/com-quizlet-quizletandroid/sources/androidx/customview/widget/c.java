package androidx.customview.widget;

import android.view.animation.Interpolator;

/* loaded from: classes.dex */
public final class c implements Interpolator {
    public final /* synthetic */ int a;

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        switch (this.a) {
            case 0:
                float f2 = f - 1.0f;
                return (f2 * f2 * f2 * f2 * f2) + 1.0f;
            default:
                float f3 = f - 1.0f;
                return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    }
}
