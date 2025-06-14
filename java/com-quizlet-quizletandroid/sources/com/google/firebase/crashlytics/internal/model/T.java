package com.google.firebase.crashlytics.internal.model;

/* loaded from: classes2.dex */
public final class T extends x0 {
    public final long a;
    public final long b;
    public final String c;
    public final String d;

    public T(long j, long j2, String str, String str2) {
        this.a = j;
        this.b = j2;
        this.c = str;
        this.d = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof x0) {
            x0 x0Var = (x0) obj;
            if (this.a == ((T) x0Var).a) {
                T t = (T) x0Var;
                if (this.b == t.b && this.c.equals(t.c)) {
                    String str = t.d;
                    String str2 = this.d;
                    if (str2 != null ? str2.equals(str) : str == null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.a;
        long j2 = this.b;
        int iHashCode = (((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.c.hashCode()) * 1000003;
        String str = this.d;
        return iHashCode ^ (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BinaryImage{baseAddress=");
        sb.append(this.a);
        sb.append(", size=");
        sb.append(this.b);
        sb.append(", name=");
        sb.append(this.c);
        sb.append(", uuid=");
        return android.support.v4.media.session.a.t(sb, this.d, "}");
    }
}
