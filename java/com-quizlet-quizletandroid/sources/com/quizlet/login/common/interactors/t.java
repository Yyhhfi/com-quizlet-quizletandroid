package com.quizlet.login.common.interactors;

import androidx.glance.appwidget.protobuf.Z;
import com.google.android.gms.internal.mlkit_vision_camera.I1;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.V;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.C;

/* loaded from: classes3.dex */
public final class t extends kotlin.coroutines.jvm.internal.i implements Function2 {
    public int j;
    public final /* synthetic */ String k;
    public final /* synthetic */ com.google.firebase.messaging.u l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(String str, com.google.firebase.messaging.u uVar, kotlin.coroutines.h hVar) {
        super(2, hVar);
        this.k = str;
        this.l = uVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final kotlin.coroutines.h create(Object obj, kotlin.coroutines.h hVar) {
        return new t(this.k, this.l, hVar);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((t) create((C) obj, (kotlin.coroutines.h) obj2)).invokeSuspend(Unit.a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.a;
        int i = this.j;
        com.google.firebase.messaging.u uVar = this.l;
        try {
            if (i == 0) {
                Z.e(obj);
                io.reactivex.rxjava3.internal.operators.single.g gVarJ = ((io.ktor.client.plugins.api.d) uVar.a).j(null, V.f(new Pair("fbToken", this.k), new Pair("state", ((com.quizlet.qutils.string.c) uVar.b).b())));
                this.j = 1;
                obj = I1.b(gVarJ, this);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Z.e(obj);
            }
            return (com.quizlet.login.authentication.data.i) obj;
        } catch (Exception e) {
            return ((io.ktor.client.plugins.api.d) uVar.a).x(null, e);
        }
    }
}
