package com.quizlet.features.questiontypes.mcq;

import androidx.glance.appwidget.protobuf.Z;
import com.quizlet.db.data.models.persisted.DBAnswer;
import com.quizlet.studiablemodels.MultipleChoiceStudiableQuestion;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.C;
import kotlinx.coroutines.flow.d0;

/* loaded from: classes3.dex */
public final class h extends kotlin.coroutines.jvm.internal.i implements Function2 {
    public int j;
    public final /* synthetic */ l k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(l lVar, kotlin.coroutines.h hVar) {
        super(2, hVar);
        this.k = lVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final kotlin.coroutines.h create(Object obj, kotlin.coroutines.h hVar) {
        return new h(this.k, hVar);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((h) create((C) obj, (kotlin.coroutines.h) obj2)).invokeSuspend(Unit.a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.a;
        int i = this.j;
        if (i == 0) {
            Z.e(obj);
            l lVar = this.k;
            com.quizlet.quizletandroid.ui.studymodes.questionTypes.managers.a aVar2 = lVar.f;
            int i2 = lVar.w.a;
            MultipleChoiceStudiableQuestion multipleChoiceStudiableQuestion = lVar.i;
            long j = lVar.j;
            DBAnswer dBAnswerB = aVar2.b(multipleChoiceStudiableQuestion, i2, j);
            com.quizlet.features.questiontypes.basequestion.g gVar = new com.quizlet.features.questiontypes.basequestion.g(new com.quizlet.features.questiontypes.basequestion.data.b(dBAnswerB, lVar.f.c(dBAnswerB, multipleChoiceStudiableQuestion, j)));
            d0 d0Var = lVar.u;
            this.j = 1;
            if (d0Var.emit(gVar, this) == aVar) {
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
