package com.quizlet.snowplow;

import android.app.Activity;
import androidx.glance.appwidget.protobuf.Z;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.i;
import kotlin.jvm.functions.Function2;

/* loaded from: classes3.dex */
public final class c extends i implements Function2 {
    public /* synthetic */ Object j;

    @Override // kotlin.coroutines.jvm.internal.a
    public final kotlin.coroutines.h create(Object obj, kotlin.coroutines.h hVar) {
        c cVar = new c(2, hVar);
        cVar.j = obj;
        return cVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((c) create((Activity) obj, (kotlin.coroutines.h) obj2)).invokeSuspend(Unit.a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.a;
        Z.e(obj);
        Activity activity = (Activity) this.j;
        return Boolean.valueOf((activity.isFinishing() || activity.isDestroyed()) ? false : true);
    }
}
