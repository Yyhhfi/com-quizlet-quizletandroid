package com.quizlet.features.infra.legacyadapter.viewholder;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class f implements io.reactivex.rxjava3.functions.d {
    public final /* synthetic */ int a;
    public final /* synthetic */ com.quizlet.features.infra.legacyadapter.a b;

    public /* synthetic */ f(com.quizlet.features.infra.legacyadapter.a aVar, int i) {
        this.a = i;
        this.b = aVar;
    }

    @Override // io.reactivex.rxjava3.functions.d
    public final void accept(Object obj) {
        switch (this.a) {
            case 0:
                View view = (View) obj;
                Intrinsics.checkNotNullParameter(view, "view");
                this.b.onClick(view);
                break;
            default:
                this.b.onClick((View) obj);
                break;
        }
    }
}
