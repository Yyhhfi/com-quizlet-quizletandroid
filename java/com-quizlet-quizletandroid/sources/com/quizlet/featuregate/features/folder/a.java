package com.quizlet.featuregate.features.folder;

import kotlin.coroutines.h;

/* loaded from: classes2.dex */
public final class a extends kotlin.coroutines.jvm.internal.c {
    public b j;
    public /* synthetic */ Object k;
    public final /* synthetic */ b l;
    public int m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b bVar, h hVar) {
        super(hVar);
        this.l = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        this.k = obj;
        this.m |= Integer.MIN_VALUE;
        return this.l.a(this);
    }
}
