package com.quizlet.shared.usecase.studynotes;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class j implements s {
    public final com.quizlet.shared.repository.studynotes.e a;
    public final q b;

    public j(com.quizlet.shared.repository.studynotes.e repository, q getStudyNotesArtifactFromResponseUseCase) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        Intrinsics.checkNotNullParameter(getStudyNotesArtifactFromResponseUseCase, "getStudyNotesArtifactFromResponseUseCase");
        this.a = repository;
        this.b = getStudyNotesArtifactFromResponseUseCase;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(java.lang.String r6, kotlin.coroutines.jvm.internal.c r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.quizlet.shared.usecase.studynotes.i
            if (r0 == 0) goto L13
            r0 = r7
            com.quizlet.shared.usecase.studynotes.i r0 = (com.quizlet.shared.usecase.studynotes.i) r0
            int r1 = r0.m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.m = r1
            goto L18
        L13:
            com.quizlet.shared.usecase.studynotes.i r0 = new com.quizlet.shared.usecase.studynotes.i
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.k
            kotlin.coroutines.intrinsics.a r1 = kotlin.coroutines.intrinsics.a.a
            int r2 = r0.m
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            androidx.glance.appwidget.protobuf.Z.e(r7)
            return r7
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            com.quizlet.shared.usecase.studynotes.j r6 = r0.j
            androidx.glance.appwidget.protobuf.Z.e(r7)
            goto L54
        L38:
            androidx.glance.appwidget.protobuf.Z.e(r7)
            com.quizlet.shared.models.api.notes.f r7 = new com.quizlet.shared.models.api.notes.f
            r7.<init>(r6)
            r0.j = r5
            r0.m = r4
            com.quizlet.shared.repository.studynotes.e r6 = r5.a
            androidx.compose.animation.core.J0 r6 = (androidx.compose.animation.core.J0) r6
            java.lang.Object r6 = r6.b
            com.quizlet.shared.quizletapi.base.e r6 = (com.quizlet.shared.quizletapi.base.e) r6
            java.lang.Object r7 = r6.a(r7, r0)
            if (r7 != r1) goto L53
            goto L72
        L53:
            r6 = r5
        L54:
            if (r7 == 0) goto L74
            kotlin.r r7 = (kotlin.r) r7
            java.lang.Object r7 = r7.a
            androidx.glance.appwidget.protobuf.Z.e(r7)
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r7 = kotlin.collections.CollectionsKt.L(r7)
            com.quizlet.shared.models.api.notes.StudyNotesResponse r7 = (com.quizlet.shared.models.api.notes.StudyNotesResponse) r7
            com.quizlet.shared.usecase.studynotes.q r6 = r6.b
            r2 = 0
            r0.j = r2
            r0.m = r3
            java.lang.Object r6 = com.google.android.gms.internal.mlkit_vision_barcode.V4.k(r7, r6, r0)
            if (r6 != r1) goto L73
        L72:
            return r1
        L73:
            return r6
        L74:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "Required value was null."
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quizlet.shared.usecase.studynotes.j.a(java.lang.String, kotlin.coroutines.jvm.internal.c):java.lang.Object");
    }
}
