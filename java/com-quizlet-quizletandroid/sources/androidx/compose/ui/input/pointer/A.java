package androidx.compose.ui.input.pointer;

import androidx.glance.appwidget.protobuf.Z;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.C;

/* loaded from: classes.dex */
public final class A extends kotlin.coroutines.jvm.internal.i implements Function2 {
    public int j;
    public final /* synthetic */ B k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A(B b, kotlin.coroutines.h hVar) {
        super(2, hVar);
        this.k = b;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final kotlin.coroutines.h create(Object obj, kotlin.coroutines.h hVar) {
        return new A(this.k, hVar);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((A) create((C) obj, (kotlin.coroutines.h) obj2)).invokeSuspend(Unit.a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.a;
        int i = this.j;
        if (i == 0) {
            Z.e(obj);
            B b = this.k;
            Function2 function2 = b.p;
            this.j = 1;
            if (function2.invoke(b, this) == aVar) {
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
