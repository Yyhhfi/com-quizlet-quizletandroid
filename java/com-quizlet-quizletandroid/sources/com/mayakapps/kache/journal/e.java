package com.mayakapps.kache.journal;

import androidx.compose.animation.d0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class e implements h {
    public final String a;

    public e(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.a = key;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && Intrinsics.b(this.a, ((e) obj).a);
    }

    @Override // com.mayakapps.kache.journal.h
    public final String getKey() {
        return this.a;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return d0.r(new StringBuilder("Dirty(key="), this.a, ')');
    }
}
