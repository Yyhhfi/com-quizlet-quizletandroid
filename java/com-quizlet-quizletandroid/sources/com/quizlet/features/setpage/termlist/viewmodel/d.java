package com.quizlet.features.setpage.termlist.viewmodel;

import androidx.glance.appwidget.protobuf.Z;
import com.quizlet.features.setpage.termlist.data.l;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.C;
import kotlinx.coroutines.flow.d0;

/* loaded from: classes3.dex */
public final class d extends kotlin.coroutines.jvm.internal.i implements Function2 {
    public int j;
    public final /* synthetic */ j k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(j jVar, kotlin.coroutines.h hVar) {
        super(2, hVar);
        this.k = jVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final kotlin.coroutines.h create(Object obj, kotlin.coroutines.h hVar) {
        return new d(this.k, hVar);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((d) create((C) obj, (kotlin.coroutines.h) obj2)).invokeSuspend(Unit.a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.a;
        int i = this.j;
        if (i == 0) {
            Z.e(obj);
            j jVar = this.k;
            d0 d0Var = jVar.i;
            l lVar = new l(jVar.g);
            this.j = 1;
            if (d0Var.emit(lVar, this) == aVar) {
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
