package com.quizlet.features.universaluploadflow;

import kotlin.jvm.functions.Function2;

/* loaded from: classes3.dex */
public final class a implements Function2 {
    public final /* synthetic */ int a;
    public final /* synthetic */ UniversalUploadFlowActivity b;

    public /* synthetic */ a(UniversalUploadFlowActivity universalUploadFlowActivity, int i) {
        this.a = i;
        this.b = universalUploadFlowActivity;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0074  */
    @Override // kotlin.jvm.functions.Function2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invoke(java.lang.Object r9, java.lang.Object r10) {
        /*
            r8 = this;
            int r0 = r8.a
            switch(r0) {
                case 0: goto L59;
                default: goto L5;
            }
        L5:
            r5 = r9
            androidx.compose.runtime.l r5 = (androidx.compose.runtime.InterfaceC0806l) r5
            java.lang.Number r10 = (java.lang.Number) r10
            int r9 = r10.intValue()
            r9 = r9 & 3
            r10 = 2
            if (r9 != r10) goto L21
            r9 = r5
            androidx.compose.runtime.p r9 = (androidx.compose.runtime.C0814p) r9
            boolean r10 = r9.x()
            if (r10 != 0) goto L1d
            goto L21
        L1d:
            r9.Q()
            goto L56
        L21:
            com.quizlet.themes.h r3 = new com.quizlet.themes.h
            androidx.compose.runtime.B r9 = com.quizlet.themes.g.a
            r10 = r5
            androidx.compose.runtime.p r10 = (androidx.compose.runtime.C0814p) r10
            java.lang.Object r0 = r10.j(r9)
            com.quizlet.themes.b r0 = (com.quizlet.themes.b) r0
            long r0 = r0.o()
            java.lang.Object r9 = r10.j(r9)
            com.quizlet.themes.b r9 = (com.quizlet.themes.b) r9
            long r9 = r9.L()
            r3.<init>(r0, r9)
            com.quizlet.features.universaluploadflow.a r9 = new com.quizlet.features.universaluploadflow.a
            com.quizlet.features.universaluploadflow.UniversalUploadFlowActivity r10 = r8.b
            r0 = 0
            r9.<init>(r10, r0)
            r10 = -1605310606(0xffffffffa050e772, float:-1.7694864E-19)
            androidx.compose.runtime.internal.d r4 = androidx.compose.runtime.internal.e.e(r10, r9, r5)
            r6 = 3072(0xc00, float:4.305E-42)
            r7 = 3
            r1 = 0
            r2 = 0
            com.google.android.gms.internal.mlkit_vision_barcode.AbstractC3178j5.b(r1, r2, r3, r4, r5, r6, r7)
        L56:
            kotlin.Unit r9 = kotlin.Unit.a
            return r9
        L59:
            androidx.compose.runtime.l r9 = (androidx.compose.runtime.InterfaceC0806l) r9
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = r10.intValue()
            r10 = r10 & 3
            r0 = 2
            if (r10 != r0) goto L74
            r10 = r9
            androidx.compose.runtime.p r10 = (androidx.compose.runtime.C0814p) r10
            boolean r0 = r10.x()
            if (r0 != 0) goto L70
            goto L74
        L70:
            r10.Q()
            goto L9e
        L74:
            com.quizlet.features.universaluploadflow.UniversalUploadFlowActivity r10 = r8.b
            android.content.Intent r10 = r10.getIntent()
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 34
            r2 = 0
            if (r0 < r1) goto L86
            java.io.Serializable r10 = androidx.core.content.e.c(r10)
            goto L96
        L86:
            java.lang.String r0 = "source"
            java.io.Serializable r10 = r10.getSerializableExtra(r0)
            java.lang.Class<com.quizlet.data.model.m2> r0 = com.quizlet.data.model.m2.class
            boolean r0 = r0.isInstance(r10)
            if (r0 == 0) goto L95
            goto L96
        L95:
            r10 = r2
        L96:
            if (r10 == 0) goto La1
            com.quizlet.data.model.m2 r10 = (com.quizlet.data.model.m2) r10
            r0 = 0
            com.quizlet.features.universaluploadflow.navigation.c.e(r10, r2, r2, r9, r0)
        L9e:
            kotlin.Unit r9 = kotlin.Unit.a
            return r9
        La1:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "Required value was null."
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quizlet.features.universaluploadflow.a.invoke(java.lang.Object, java.lang.Object):java.lang.Object");
    }
}
