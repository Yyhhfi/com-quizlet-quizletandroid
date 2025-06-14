package com.google.android.material.motion;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.RoundedCorner;
import android.view.View;
import android.view.WindowInsets;
import androidx.appcompat.widget.C0076c;
import com.quizlet.quizletandroid.R;
import com.skydoves.balloon.internals.DefinitionKt;

/* loaded from: classes2.dex */
public final class g extends a {
    public final float g;
    public final float h;
    public float i;
    public Rect j;
    public Rect k;
    public Integer l;

    public g(View view) {
        super(view);
        Resources resources = view.getResources();
        this.g = resources.getDimension(R.dimen.m3_back_progress_main_container_min_edge_gap);
        this.h = resources.getDimension(R.dimen.m3_back_progress_main_container_max_translation_y);
    }

    public final AnimatorSet b(View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        View view2 = this.b;
        animatorSet.playTogether(ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, DefinitionKt.NO_Float_VALUE), ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, DefinitionKt.NO_Float_VALUE));
        animatorSet.addListener(new C0076c(view, 9));
        return animatorSet;
    }

    public final int c() {
        WindowInsets rootWindowInsets;
        if (this.l == null) {
            int[] iArr = new int[2];
            View view = this.b;
            view.getLocationOnScreen(iArr);
            if (iArr[1] == 0 && Build.VERSION.SDK_INT >= 31 && (rootWindowInsets = view.getRootWindowInsets()) != null) {
                RoundedCorner roundedCorner = rootWindowInsets.getRoundedCorner(0);
                int radius = roundedCorner != null ? roundedCorner.getRadius() : 0;
                RoundedCorner roundedCorner2 = rootWindowInsets.getRoundedCorner(1);
                int iMax = Math.max(radius, roundedCorner2 != null ? roundedCorner2.getRadius() : 0);
                RoundedCorner roundedCorner3 = rootWindowInsets.getRoundedCorner(3);
                int radius2 = roundedCorner3 != null ? roundedCorner3.getRadius() : 0;
                RoundedCorner roundedCorner4 = rootWindowInsets.getRoundedCorner(2);
                iMax = Math.max(iMax, Math.max(radius2, roundedCorner4 != null ? roundedCorner4.getRadius() : 0));
            }
            this.l = Integer.valueOf(iMax);
        }
        return this.l.intValue();
    }
}
