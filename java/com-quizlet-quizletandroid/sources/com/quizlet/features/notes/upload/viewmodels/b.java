package com.quizlet.features.notes.upload.viewmodels;

import com.quizlet.features.infra.models.folders.AddMaterialFolderData;

/* loaded from: classes3.dex */
public final class b extends kotlin.coroutines.jvm.internal.c {
    public AddMaterialFolderData j;
    public /* synthetic */ Object k;
    public final /* synthetic */ c l;
    public int m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c cVar, kotlin.coroutines.jvm.internal.c cVar2) {
        super(cVar2);
        this.l = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        this.k = obj;
        this.m |= Integer.MIN_VALUE;
        return this.l.J(null, this);
    }
}
