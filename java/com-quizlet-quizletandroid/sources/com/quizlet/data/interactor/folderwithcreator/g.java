package com.quizlet.data.interactor.folderwithcreator;

import androidx.datastore.core.C1086s;

/* loaded from: classes2.dex */
public final class g extends kotlin.coroutines.jvm.internal.c {
    public /* synthetic */ Object j;
    public int k;
    public final /* synthetic */ C1086s l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(C1086s c1086s, kotlin.coroutines.h hVar) {
        super(hVar);
        this.l = c1086s;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        this.j = obj;
        this.k |= Integer.MIN_VALUE;
        return this.l.emit(null, this);
    }
}
