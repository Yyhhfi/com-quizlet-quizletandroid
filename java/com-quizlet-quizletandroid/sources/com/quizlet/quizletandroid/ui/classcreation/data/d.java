package com.quizlet.quizletandroid.ui.classcreation.data;

/* loaded from: classes3.dex */
public final class d extends e {
    public final long a;

    public d(long j) {
        this.a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d) && this.a == ((d) obj).a;
    }

    public final int hashCode() {
        return Long.hashCode(this.a);
    }

    public final String toString() {
        return android.support.v4.media.session.a.g(this.a, ")", new StringBuilder("NewClass(classId="));
    }
}
