package com.quizlet.features.folders.viewmodel.usecases;

import androidx.compose.foundation.text.C0494i0;

/* loaded from: classes3.dex */
public final class l extends kotlin.coroutines.jvm.internal.c {
    public /* synthetic */ Object j;
    public int k;
    public final /* synthetic */ C0494i0 l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(C0494i0 c0494i0, kotlin.coroutines.h hVar) {
        super(hVar);
        this.l = c0494i0;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        this.j = obj;
        this.k |= Integer.MIN_VALUE;
        return this.l.emit(null, this);
    }
}
