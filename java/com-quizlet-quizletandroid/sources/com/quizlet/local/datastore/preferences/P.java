package com.quizlet.local.datastore.preferences;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* loaded from: classes3.dex */
public final class P extends kotlin.coroutines.jvm.internal.i implements Function2 {
    public /* synthetic */ Object j;

    @Override // kotlin.coroutines.jvm.internal.a
    public final kotlin.coroutines.h create(Object obj, kotlin.coroutines.h hVar) {
        P p = new P(2, hVar);
        p.j = obj;
        return p;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((P) create((androidx.datastore.preferences.core.b) obj, (kotlin.coroutines.h) obj2)).invokeSuspend(Unit.a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.a;
        androidx.glance.appwidget.protobuf.Z.e(obj);
        androidx.datastore.preferences.core.b bVar = (androidx.datastore.preferences.core.b) this.j;
        bVar.b();
        bVar.a.clear();
        return Unit.a;
    }
}
