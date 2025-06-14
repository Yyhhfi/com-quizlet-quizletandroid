package org.ccil.cowan.tagsoup;

/* loaded from: classes3.dex */
public final class b {
    public String a;
    public String b;
    public String c;
    public int d;
    public int e;
    public int f;
    public a g;
    public b h;
    public d i;

    public static String b(String str) {
        if (str == null) {
            return str;
        }
        String strTrim = str.trim();
        if (strTrim.indexOf("  ") == -1) {
            return strTrim;
        }
        int length = strTrim.length();
        StringBuffer stringBuffer = new StringBuffer(length);
        boolean z = false;
        for (int i = 0; i < length; i++) {
            char cCharAt = strTrim.charAt(i);
            if (cCharAt == ' ') {
                if (!z) {
                    stringBuffer.append(cCharAt);
                }
                z = true;
            } else {
                stringBuffer.append(cCharAt);
                z = false;
            }
        }
        return stringBuffer.toString();
    }

    public final String a(String str, boolean z) {
        int iIndexOf = str.indexOf(58);
        if (iIndexOf == -1) {
            return z ? "" : this.i.c;
        }
        String strSubstring = str.substring(0, iIndexOf);
        return strSubstring.equals("xml") ? "http://www.w3.org/XML/1998/namespace" : "urn:x-prefix:".concat(strSubstring).intern();
    }

    public final void c(a aVar, String str, String str2, String str3) {
        int length;
        if (str.equals("xmlns") || str.startsWith("xmlns:")) {
            return;
        }
        String strA = a(str, true);
        int iIndexOf = str.indexOf(58);
        String strIntern = iIndexOf == -1 ? str : str.substring(iIndexOf + 1).intern();
        int index = aVar.getIndex(str);
        if (index != -1) {
            if (str2 == null) {
                str2 = aVar.getType(index);
            }
            if (!str2.equals("CDATA")) {
                str3 = b(str3);
            }
            if (index < 0 || index >= aVar.a) {
                a.a(index);
                throw null;
            }
            String[] strArr = aVar.b;
            int i = index * 5;
            strArr[i] = strA;
            strArr[i + 1] = strIntern;
            strArr[i + 2] = str;
            strArr[i + 3] = str2;
            strArr[i + 4] = str3;
            return;
        }
        String strIntern2 = str.intern();
        if (str2 == null) {
            str2 = "CDATA";
        }
        if (!str2.equals("CDATA")) {
            str3 = b(str3);
        }
        int i2 = aVar.a + 1;
        if (i2 > 0) {
            String[] strArr2 = aVar.b;
            if (strArr2 != null && strArr2.length != 0) {
                length = strArr2.length < i2 * 5 ? strArr2.length : 25;
            }
            while (length < i2 * 5) {
                length *= 2;
            }
            String[] strArr3 = new String[length];
            int i3 = aVar.a;
            if (i3 > 0) {
                System.arraycopy(aVar.b, 0, strArr3, 0, i3 * 5);
            }
            aVar.b = strArr3;
        }
        String[] strArr4 = aVar.b;
        int i4 = aVar.a;
        int i5 = i4 * 5;
        strArr4[i5] = strA;
        strArr4[i5 + 1] = strIntern;
        strArr4[i5 + 2] = strIntern2;
        strArr4[i5 + 3] = str2;
        strArr4[i5 + 4] = str3;
        aVar.a = i4 + 1;
    }
}
