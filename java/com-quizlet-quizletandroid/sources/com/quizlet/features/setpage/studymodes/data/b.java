package com.quizlet.features.setpage.studymodes.data;

import androidx.glance.appwidget.protobuf.Z;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.C;

/* loaded from: classes3.dex */
public final class b extends kotlin.coroutines.jvm.internal.i implements Function2 {
    public int j;
    public final /* synthetic */ com.quizlet.remote.model.notes.e k;
    public final /* synthetic */ long l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(com.quizlet.remote.model.notes.e eVar, long j, kotlin.coroutines.h hVar) {
        super(2, hVar);
        this.k = eVar;
        this.l = j;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final kotlin.coroutines.h create(Object obj, kotlin.coroutines.h hVar) {
        return new b(this.k, this.l, hVar);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((b) create((C) obj, (kotlin.coroutines.h) obj2)).invokeSuspend(Unit.a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.a;
        int i = this.j;
        if (i == 0) {
            Z.e(obj);
            this.j = 1;
            if (this.k.p(this.l, this) == aVar) {
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
