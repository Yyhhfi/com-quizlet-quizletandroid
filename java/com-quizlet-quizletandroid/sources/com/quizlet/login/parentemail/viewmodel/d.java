package com.quizlet.login.parentemail.viewmodel;

/* loaded from: classes3.dex */
public final class d extends kotlin.coroutines.jvm.internal.c {
    public e j;
    public /* synthetic */ Object k;
    public final /* synthetic */ e l;
    public int m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(e eVar, kotlin.coroutines.jvm.internal.c cVar) {
        super(cVar);
        this.l = eVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        this.k = obj;
        this.m |= Integer.MIN_VALUE;
        return e.A(this.l, null, this);
    }
}
