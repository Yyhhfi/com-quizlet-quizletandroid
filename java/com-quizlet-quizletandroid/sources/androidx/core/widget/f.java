package androidx.core.widget;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.appcompat.app.J;
import androidx.appcompat.widget.C0113u0;
import com.skydoves.balloon.internals.DefinitionKt;

/* loaded from: classes.dex */
public final class f implements View.OnTouchListener {
    public static final int r = ViewConfiguration.getTapTimeout();
    public final a a;
    public final AccelerateInterpolator b;
    public final ListView c;
    public J d;
    public final float[] e;
    public final float[] f;
    public final int g;
    public final int h;
    public final float[] i;
    public final float[] j;
    public final float[] k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public final C0113u0 q;

    public f(C0113u0 c0113u0) {
        a aVar = new a();
        aVar.e = Long.MIN_VALUE;
        aVar.g = -1L;
        aVar.f = 0L;
        this.a = aVar;
        this.b = new AccelerateInterpolator();
        float[] fArr = {DefinitionKt.NO_Float_VALUE, DefinitionKt.NO_Float_VALUE};
        this.e = fArr;
        float[] fArr2 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.f = fArr2;
        float[] fArr3 = {DefinitionKt.NO_Float_VALUE, DefinitionKt.NO_Float_VALUE};
        this.i = fArr3;
        float[] fArr4 = {DefinitionKt.NO_Float_VALUE, DefinitionKt.NO_Float_VALUE};
        this.j = fArr4;
        float[] fArr5 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.k = fArr5;
        this.c = c0113u0;
        float f = Resources.getSystem().getDisplayMetrics().density;
        float f2 = ((int) ((1575.0f * f) + 0.5f)) / 1000.0f;
        fArr5[0] = f2;
        fArr5[1] = f2;
        float f3 = ((int) ((f * 315.0f) + 0.5f)) / 1000.0f;
        fArr4[0] = f3;
        fArr4[1] = f3;
        this.g = 1;
        fArr2[0] = Float.MAX_VALUE;
        fArr2[1] = Float.MAX_VALUE;
        fArr[0] = 0.2f;
        fArr[1] = 0.2f;
        fArr3[0] = 0.001f;
        fArr3[1] = 0.001f;
        this.h = r;
        aVar.a = com.pubmatic.sdk.video.a.GENERAL_NONLINEAR_AD_ERROR;
        aVar.b = com.pubmatic.sdk.video.a.GENERAL_NONLINEAR_AD_ERROR;
        this.q = c0113u0;
    }

    public static float b(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float a(int r4, float r5, float r6, float r7) {
        /*
            r3 = this;
            float[] r0 = r3.e
            r0 = r0[r4]
            float[] r1 = r3.f
            r1 = r1[r4]
            float r0 = r0 * r6
            r2 = 0
            float r0 = b(r0, r2, r1)
            float r1 = r3.c(r5, r0)
            float r6 = r6 - r5
            float r5 = r3.c(r6, r0)
            float r5 = r5 - r1
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            android.view.animation.AccelerateInterpolator r0 = r3.b
            if (r6 >= 0) goto L25
            float r5 = -r5
            float r5 = r0.getInterpolation(r5)
            float r5 = -r5
            goto L2d
        L25:
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r6 <= 0) goto L36
            float r5 = r0.getInterpolation(r5)
        L2d:
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            r0 = 1065353216(0x3f800000, float:1.0)
            float r5 = b(r5, r6, r0)
            goto L37
        L36:
            r5 = r2
        L37:
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r6 != 0) goto L3c
            return r2
        L3c:
            float[] r0 = r3.i
            r0 = r0[r4]
            float[] r1 = r3.j
            r1 = r1[r4]
            float[] r2 = r3.k
            r4 = r2[r4]
            float r0 = r0 * r7
            if (r6 <= 0) goto L51
            float r5 = r5 * r0
            float r4 = b(r5, r1, r4)
            return r4
        L51:
            float r5 = -r5
            float r5 = r5 * r0
            float r4 = b(r5, r1, r4)
            float r4 = -r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.f.a(int, float, float, float):float");
    }

    public final float c(float f, float f2) {
        if (f2 != DefinitionKt.NO_Float_VALUE) {
            int i = this.g;
            if (i == 0 || i == 1) {
                if (f < f2) {
                    if (f >= DefinitionKt.NO_Float_VALUE) {
                        return 1.0f - (f / f2);
                    }
                    if (this.o && i == 1) {
                        return 1.0f;
                    }
                }
            } else if (i == 2 && f < DefinitionKt.NO_Float_VALUE) {
                return f / (-f2);
            }
        }
        return DefinitionKt.NO_Float_VALUE;
    }

    public final void d() {
        int i = 0;
        if (this.m) {
            this.o = false;
            return;
        }
        a aVar = this.a;
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        int i2 = (int) (jCurrentAnimationTimeMillis - aVar.e);
        int i3 = aVar.b;
        if (i2 > i3) {
            i = i3;
        } else if (i2 >= 0) {
            i = i2;
        }
        aVar.i = i;
        aVar.h = aVar.a(jCurrentAnimationTimeMillis);
        aVar.g = jCurrentAnimationTimeMillis;
    }

    public final boolean e() {
        C0113u0 c0113u0;
        int count;
        a aVar = this.a;
        float f = aVar.d;
        int iAbs = (int) (f / Math.abs(f));
        Math.abs(aVar.c);
        if (iAbs != 0 && (count = (c0113u0 = this.q).getCount()) != 0) {
            int childCount = c0113u0.getChildCount();
            int firstVisiblePosition = c0113u0.getFirstVisiblePosition();
            int i = firstVisiblePosition + childCount;
            if (iAbs <= 0 ? !(iAbs >= 0 || (firstVisiblePosition <= 0 && c0113u0.getChildAt(0).getTop() >= 0)) : !(i >= count && c0113u0.getChildAt(childCount - 1).getBottom() <= c0113u0.getHeight())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0014, code lost:
    
        if (r0 != 3) goto L30;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
        /*
            r7 = this;
            boolean r0 = r7.p
            r1 = 0
            if (r0 != 0) goto L7
            goto L7e
        L7:
            int r0 = r9.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1b
            if (r0 == r2) goto L17
            r3 = 2
            if (r0 == r3) goto L1f
            r8 = 3
            if (r0 == r8) goto L17
            goto L7e
        L17:
            r7.d()
            return r1
        L1b:
            r7.n = r2
            r7.l = r1
        L1f:
            float r0 = r9.getX()
            int r3 = r8.getWidth()
            float r3 = (float) r3
            android.widget.ListView r4 = r7.c
            int r5 = r4.getWidth()
            float r5 = (float) r5
            float r0 = r7.a(r1, r0, r3, r5)
            float r9 = r9.getY()
            int r8 = r8.getHeight()
            float r8 = (float) r8
            int r3 = r4.getHeight()
            float r3 = (float) r3
            float r8 = r7.a(r2, r9, r8, r3)
            androidx.core.widget.a r9 = r7.a
            r9.c = r0
            r9.d = r8
            boolean r8 = r7.o
            if (r8 != 0) goto L7e
            boolean r8 = r7.e()
            if (r8 == 0) goto L7e
            androidx.appcompat.app.J r8 = r7.d
            if (r8 != 0) goto L62
            androidx.appcompat.app.J r8 = new androidx.appcompat.app.J
            r9 = 10
            r8.<init>(r7, r9)
            r7.d = r8
        L62:
            r7.o = r2
            r7.m = r2
            boolean r8 = r7.l
            if (r8 != 0) goto L77
            int r8 = r7.h
            if (r8 <= 0) goto L77
            androidx.appcompat.app.J r9 = r7.d
            long r5 = (long) r8
            java.util.WeakHashMap r8 = androidx.core.view.V.a
            r4.postOnAnimationDelayed(r9, r5)
            goto L7c
        L77:
            androidx.appcompat.app.J r8 = r7.d
            r8.run()
        L7c:
            r7.l = r2
        L7e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.f.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
