package com.quizlet.edgy.ui.fragment;

import androidx.glance.appwidget.protobuf.Z;
import androidx.lifecycle.p0;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class z extends kotlin.coroutines.jvm.internal.i implements Function2 {
    public int j;
    public final /* synthetic */ EdgyAddSchoolManuallyFragment k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(EdgyAddSchoolManuallyFragment edgyAddSchoolManuallyFragment, kotlin.coroutines.h hVar) {
        super(2, hVar);
        this.k = edgyAddSchoolManuallyFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final kotlin.coroutines.h create(Object obj, kotlin.coroutines.h hVar) {
        return new z(this.k, hVar);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((z) create((kotlinx.coroutines.C) obj, (kotlin.coroutines.h) obj2)).invokeSuspend(Unit.a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.a;
        int i = this.j;
        if (i == 0) {
            Z.e(obj);
            EdgyAddSchoolManuallyFragment edgyAddSchoolManuallyFragment = this.k;
            androidx.lifecycle.J viewLifecycleOwner = edgyAddSchoolManuallyFragment.getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            androidx.lifecycle.B b = androidx.lifecycle.B.c;
            y yVar = new y(edgyAddSchoolManuallyFragment, null);
            this.j = 1;
            if (p0.m(viewLifecycleOwner, b, yVar, this) == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Z.e(obj);
        }
        return Unit.a;
    }
}
