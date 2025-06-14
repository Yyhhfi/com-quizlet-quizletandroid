package com.google.firebase.crashlytics.internal.model;

/* loaded from: classes2.dex */
public final class K extends v0 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;

    public K(String str, String str2, String str3, String str4, String str5, String str6) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v0) {
            v0 v0Var = (v0) obj;
            if (this.a.equals(((K) v0Var).a)) {
                K k = (K) v0Var;
                if (this.b.equals(k.b)) {
                    String str = k.c;
                    String str2 = this.c;
                    if (str2 != null ? str2.equals(str) : str == null) {
                        String str3 = k.d;
                        String str4 = this.d;
                        if (str4 != null ? str4.equals(str3) : str3 == null) {
                            String str5 = k.e;
                            String str6 = this.e;
                            if (str6 != null ? str6.equals(str5) : str5 == null) {
                                String str7 = k.f;
                                String str8 = this.f;
                                if (str8 != null ? str8.equals(str7) : str7 == null) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003;
        String str = this.c;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * (-721379959);
        String str2 = this.d;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.e;
        int iHashCode4 = (iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f;
        return iHashCode4 ^ (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Application{identifier=");
        sb.append(this.a);
        sb.append(", version=");
        sb.append(this.b);
        sb.append(", displayVersion=");
        sb.append(this.c);
        sb.append(", organization=null, installationUuid=");
        sb.append(this.d);
        sb.append(", developmentPlatform=");
        sb.append(this.e);
        sb.append(", developmentPlatformVersion=");
        return android.support.v4.media.session.a.t(sb, this.f, "}");
    }
}
