package com.quizlet.features.setpage.termlist.usecase;

/* loaded from: classes3.dex */
public final class a extends kotlin.coroutines.jvm.internal.c {
    public /* synthetic */ Object j;
    public final /* synthetic */ com.quizlet.data.interactor.course.a k;
    public int l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(com.quizlet.data.interactor.course.a aVar, kotlin.coroutines.jvm.internal.c cVar) {
        super(cVar);
        this.k = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        this.j = obj;
        this.l |= Integer.MIN_VALUE;
        return this.k.e(0L, this);
    }
}
