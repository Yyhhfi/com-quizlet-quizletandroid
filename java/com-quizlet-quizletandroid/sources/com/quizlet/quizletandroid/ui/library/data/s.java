package com.quizlet.quizletandroid.ui.library.data;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class s extends F {
    public final String a;

    public s(String questionId) {
        Intrinsics.checkNotNullParameter(questionId, "questionId");
        this.a = questionId;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof s) && Intrinsics.b(this.a, ((s) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return android.support.v4.media.session.a.t(new StringBuilder("ExplanationQuestion(questionId="), this.a, ")");
    }
}
