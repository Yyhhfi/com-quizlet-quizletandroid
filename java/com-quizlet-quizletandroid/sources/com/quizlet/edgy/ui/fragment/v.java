package com.quizlet.edgy.ui.fragment;

import androidx.glance.appwidget.protobuf.Z;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.d0;
import kotlinx.coroutines.flow.e0;

/* loaded from: classes2.dex */
public final class v extends kotlin.coroutines.jvm.internal.i implements Function2 {
    public int j;
    public final /* synthetic */ EdgyAddSchoolManuallyFragment k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(EdgyAddSchoolManuallyFragment edgyAddSchoolManuallyFragment, kotlin.coroutines.h hVar) {
        super(2, hVar);
        this.k = edgyAddSchoolManuallyFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final kotlin.coroutines.h create(Object obj, kotlin.coroutines.h hVar) {
        return new v(this.k, hVar);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((v) create((kotlinx.coroutines.C) obj, (kotlin.coroutines.h) obj2)).invokeSuspend(Unit.a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.a;
        int i = this.j;
        if (i == 0) {
            Z.e(obj);
            String str = EdgyAddSchoolManuallyFragment.o;
            EdgyAddSchoolManuallyFragment edgyAddSchoolManuallyFragment = this.k;
            d0 d0Var = edgyAddSchoolManuallyFragment.U().i;
            u uVar = new u(edgyAddSchoolManuallyFragment, null);
            this.j = 1;
            if (e0.i(d0Var, uVar, this) == aVar) {
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
