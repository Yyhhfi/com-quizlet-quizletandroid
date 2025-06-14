package com.google.firebase.heartbeatinfo;

import androidx.camera.camera2.internal.AbstractC0147y;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class a {
    public final String a;
    public final ArrayList b;

    public a(ArrayList arrayList, String str) {
        if (str == null) {
            throw new NullPointerException("Null userAgent");
        }
        this.a = str;
        this.b = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.a.equals(aVar.a) && this.b.equals(aVar.b);
    }

    public final int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("HeartBeatResult{userAgent=");
        sb.append(this.a);
        sb.append(", usedDates=");
        return AbstractC0147y.f("}", sb, this.b);
    }
}
