package com.quizlet.features.infra.folder.menu.composable;

import androidx.compose.runtime.InterfaceC0773a0;
import androidx.glance.appwidget.protobuf.Z;
import androidx.lifecycle.B;
import androidx.lifecycle.E;
import androidx.lifecycle.J;
import androidx.lifecycle.p0;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.C;
import kotlinx.coroutines.flow.InterfaceC4992i;

/* loaded from: classes3.dex */
public final class d extends kotlin.coroutines.jvm.internal.i implements Function2 {
    public final /* synthetic */ J j;
    public final /* synthetic */ InterfaceC4992i k;
    public final /* synthetic */ InterfaceC0773a0 l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(InterfaceC0773a0 interfaceC0773a0, J j, kotlin.coroutines.h hVar, InterfaceC4992i interfaceC4992i) {
        super(2, hVar);
        B b = B.a;
        this.j = j;
        this.k = interfaceC4992i;
        this.l = interfaceC0773a0;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final kotlin.coroutines.h create(Object obj, kotlin.coroutines.h hVar) {
        B b = B.a;
        return new d(this.l, this.j, hVar, this.k);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((d) create((C) obj, (kotlin.coroutines.h) obj2)).invokeSuspend(Unit.a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.a;
        Z.e(obj);
        J j = this.j;
        E eH = p0.h(j);
        InterfaceC0773a0 interfaceC0773a0 = this.l;
        B b = B.a;
        kotlinx.coroutines.E.A(eH, null, null, new c(interfaceC0773a0, j, null, this.k), 3);
        return Unit.a;
    }
}
