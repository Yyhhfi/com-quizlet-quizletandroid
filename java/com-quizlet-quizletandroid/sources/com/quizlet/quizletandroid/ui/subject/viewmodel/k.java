package com.quizlet.quizletandroid.ui.subject.viewmodel;

import androidx.glance.appwidget.protobuf.Z;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.C;

/* loaded from: classes3.dex */
public final class k extends kotlin.coroutines.jvm.internal.i implements Function2 {
    public final /* synthetic */ m j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(m mVar, kotlin.coroutines.h hVar) {
        super(2, hVar);
        this.j = mVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final kotlin.coroutines.h create(Object obj, kotlin.coroutines.h hVar) {
        return new k(this.j, hVar);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((k) create((C) obj, (kotlin.coroutines.h) obj2)).invokeSuspend(Unit.a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.a;
        Z.e(obj);
        this.j.g.j(c.a);
        return Unit.a;
    }
}
