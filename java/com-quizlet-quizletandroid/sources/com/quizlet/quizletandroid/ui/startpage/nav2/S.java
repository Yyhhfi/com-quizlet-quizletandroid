package com.quizlet.quizletandroid.ui.startpage.nav2;

import com.quizlet.features.achievements.ui.composables.C4222i;
import com.quizlet.quizletandroid.ui.startpage.nav2.model.C4721q;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class S extends kotlin.coroutines.jvm.internal.i implements Function2 {
    public int j;
    public /* synthetic */ Object k;
    public final /* synthetic */ Y l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public S(Y y, kotlin.coroutines.h hVar) {
        super(2, hVar);
        this.l = y;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final kotlin.coroutines.h create(Object obj, kotlin.coroutines.h hVar) {
        S s = new S(this.l, hVar);
        s.k = obj;
        return s;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((S) create((List) obj, (kotlin.coroutines.h) obj2)).invokeSuspend(Unit.a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.a;
        int i = this.j;
        if (i == 0) {
            androidx.glance.appwidget.protobuf.Z.e(obj);
            List data = (List) this.k;
            Y y = this.l;
            C4721q c4721q = y.t;
            Intrinsics.d(data);
            c4721q.getClass();
            Intrinsics.checkNotNullParameter(data, "data");
            c4721q.b = data;
            y.h1.j(new com.quizlet.quizletandroid.ui.startpage.nav2.screenstates.l(data));
            C4222i c4222i = new C4222i(data, 7);
            this.j = 1;
            if (Y.C(y, c4222i, this) == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            androidx.glance.appwidget.protobuf.Z.e(obj);
        }
        return Unit.a;
    }
}
