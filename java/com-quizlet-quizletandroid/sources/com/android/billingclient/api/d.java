package com.android.billingclient.api;

/* loaded from: classes.dex */
public final class d {
    public final /* synthetic */ int a;
    public int b;
    public String c;

    public /* synthetic */ d(int i) {
        this.a = i;
    }

    public static String n(String str) {
        StringBuilder sbB = org.jsoup.internal.a.b();
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i = 0;
        char c = 0;
        while (i < length) {
            char c2 = charArray[i];
            if (c2 != '\\') {
                sbB.append(c2);
            } else if (c == '\\') {
                sbB.append(c2);
            }
            i++;
            c = c2;
        }
        return org.jsoup.internal.a.g(sbB);
    }

    public e a() {
        e eVar = new e();
        eVar.a = this.b;
        eVar.b = this.c;
        return eVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0071 A[LOOP:0: B:3:0x0009->B:45:0x0071, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0055 A[EDGE_INSN: B:47:0x0055->B:38:0x0055 BREAK  A[LOOP:0: B:3:0x0009->B:45:0x0071], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String b(char r12, char r13) {
        /*
            r11 = this;
            r0 = -1
            r1 = 0
            r5 = r0
            r6 = r5
            r2 = r1
            r3 = r2
            r4 = r3
            r7 = r4
            r8 = r7
        L9:
            boolean r9 = r11.h()
            if (r9 == 0) goto L10
            goto L55
        L10:
            char r9 = r11.d()
            r10 = 92
            if (r2 == r10) goto L42
            r10 = 39
            if (r9 != r10) goto L23
            if (r9 == r12) goto L23
            if (r3 != 0) goto L23
            r4 = r4 ^ 1
            goto L2d
        L23:
            r10 = 34
            if (r9 != r10) goto L2d
            if (r9 == r12) goto L2d
            if (r4 != 0) goto L2d
            r3 = r3 ^ 1
        L2d:
            if (r4 != 0) goto L53
            if (r3 != 0) goto L53
            if (r8 == 0) goto L34
            goto L53
        L34:
            if (r9 != r12) goto L3d
            int r7 = r7 + 1
            if (r5 != r0) goto L4d
            int r5 = r11.b
            goto L4d
        L3d:
            if (r9 != r13) goto L4d
            int r7 = r7 + (-1)
            goto L4d
        L42:
            r10 = 81
            if (r9 != r10) goto L48
            r8 = 1
            goto L4d
        L48:
            r10 = 69
            if (r9 != r10) goto L4d
            r8 = r1
        L4d:
            if (r7 <= 0) goto L53
            if (r2 == 0) goto L53
            int r6 = r11.b
        L53:
            if (r7 > 0) goto L71
        L55:
            if (r6 < 0) goto L5e
            java.lang.String r12 = r11.c
            java.lang.String r12 = r12.substring(r5, r6)
            goto L60
        L5e:
            java.lang.String r12 = ""
        L60:
            if (r7 > 0) goto L63
            return r12
        L63:
            java.lang.String r13 = "Did not find balanced marker at '"
            java.lang.String r0 = "'"
            java.lang.String r12 = android.support.v4.media.session.a.B(r13, r12, r0)
            org.jsoup.helper.ValidationException r13 = new org.jsoup.helper.ValidationException
            r13.<init>(r12)
            throw r13
        L71:
            r2 = r9
            goto L9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.d.b(char, char):java.lang.String");
    }

    public String c() {
        String strM;
        int i = this.b;
        String str = this.c;
        int iIndexOf = str.indexOf(")", i);
        if (iIndexOf != -1) {
            strM = str.substring(this.b, iIndexOf);
            this.b = strM.length() + this.b;
        } else {
            strM = m();
        }
        i(")");
        return strM;
    }

    public char d() {
        int i = this.b;
        this.b = i + 1;
        return this.c.charAt(i);
    }

    public void e(String str) {
        if (!j(str)) {
            throw new IllegalStateException("Queue did not match expected sequence");
        }
        int length = str.length();
        int length2 = this.c.length();
        int i = this.b;
        if (length > length2 - i) {
            throw new IllegalStateException("Queue not long enough to consume sequence");
        }
        this.b = i + length;
    }

    public String f() {
        String str;
        int i = this.b;
        loop0: while (true) {
            boolean zH = h();
            str = this.c;
            if (zH) {
                break;
            }
            if (!l()) {
                char[] cArr = {'-', '_'};
                if (!h()) {
                    for (int i2 = 0; i2 < 2; i2++) {
                        if (str.charAt(this.b) == cArr[i2]) {
                            break;
                        }
                    }
                    break loop0;
                }
                break;
            }
            this.b++;
        }
        return str.substring(i, this.b);
    }

    public boolean g() {
        boolean z = false;
        while (!h() && org.jsoup.internal.a.e(this.c.charAt(this.b))) {
            this.b++;
            z = true;
        }
        return z;
    }

    public boolean h() {
        return this.c.length() - this.b == 0;
    }

    public boolean i(String str) {
        if (!j(str)) {
            return false;
        }
        this.b = str.length() + this.b;
        return true;
    }

    public boolean j(String str) {
        return this.c.regionMatches(true, this.b, str, 0, str.length());
    }

    public boolean k(String... strArr) {
        for (String str : strArr) {
            if (j(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean l() {
        return !h() && Character.isLetterOrDigit(this.c.charAt(this.b));
    }

    public String m() {
        int i = this.b;
        String str = this.c;
        String strSubstring = str.substring(i);
        this.b = str.length();
        return strSubstring;
    }

    public String toString() {
        switch (this.a) {
            case 3:
                return this.c.substring(this.b);
            default:
                return super.toString();
        }
    }

    public d(int i, String str) {
        this.a = 2;
        this.b = i;
        this.c = str;
    }

    public d(String str) {
        this.a = 3;
        this.b = 0;
        org.jsoup.helper.b.g(str);
        this.c = str;
    }
}
