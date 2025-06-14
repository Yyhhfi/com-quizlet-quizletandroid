package com.fasterxml.jackson.core.io;

import androidx.compose.animation.d0;
import com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_0.JavaDoubleParser;
import com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_0.JavaFloatParser;
import com.pubmatic.sdk.video.c;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public abstract class NumberInput {
    static final String MIN_LONG_STR_NO_SIGN = String.valueOf(Long.MIN_VALUE).substring(1);
    static final String MAX_LONG_STR = String.valueOf(Long.MAX_VALUE);
    private static final Pattern PATTERN_FLOAT = Pattern.compile("[+-]?[0-9]*[\\.]?[0-9]+([eE][+-]?[0-9]+)?");
    private static final Pattern PATTERN_FLOAT_TRAILING_DOT = Pattern.compile("[+-]?[0-9]+[\\.]");

    public static boolean inLongRange(char[] cArr, int i, int i2, boolean z) {
        String str = z ? MIN_LONG_STR_NO_SIGN : MAX_LONG_STR;
        int length = str.length();
        if (i2 < length) {
            return true;
        }
        if (i2 > length) {
            return false;
        }
        for (int i3 = 0; i3 < length; i3++) {
            int iCharAt = cArr[i + i3] - str.charAt(i3);
            if (iCharAt != 0) {
                return iCharAt < 0;
            }
        }
        return true;
    }

    public static boolean looksLikeValidNumber(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        if (str.length() != 1) {
            return PATTERN_FLOAT.matcher(str).matches() || PATTERN_FLOAT_TRAILING_DOT.matcher(str).matches();
        }
        char cCharAt = str.charAt(0);
        return cCharAt <= '9' && cCharAt >= '0';
    }

    public static int parseAsInt(String str, int i) {
        String strTrim;
        int length;
        if (str != null && (length = (strTrim = str.trim()).length()) != 0) {
            int i2 = 0;
            char cCharAt = strTrim.charAt(0);
            if (cCharAt == '+') {
                strTrim = strTrim.substring(1);
                length = strTrim.length();
            } else if (cCharAt == '-') {
                i2 = 1;
            }
            while (i2 < length) {
                try {
                    char cCharAt2 = strTrim.charAt(i2);
                    if (cCharAt2 > '9' || cCharAt2 < '0') {
                        return (int) parseDouble(strTrim, true);
                    }
                    i2++;
                } catch (NumberFormatException unused) {
                }
            }
            return Integer.parseInt(strTrim);
        }
        return i;
    }

    public static long parseAsLong(String str, long j) {
        String strTrim;
        int length;
        if (str != null && (length = (strTrim = str.trim()).length()) != 0) {
            int i = 0;
            char cCharAt = strTrim.charAt(0);
            if (cCharAt == '+') {
                strTrim = strTrim.substring(1);
                length = strTrim.length();
            } else if (cCharAt == '-') {
                i = 1;
            }
            while (i < length) {
                try {
                    char cCharAt2 = strTrim.charAt(i);
                    if (cCharAt2 > '9' || cCharAt2 < '0') {
                        return (long) parseDouble(strTrim, true);
                    }
                    i++;
                } catch (NumberFormatException unused) {
                }
            }
            return Long.parseLong(strTrim);
        }
        return j;
    }

    public static BigDecimal parseBigDecimal(String str, boolean z) throws NumberFormatException {
        return z ? BigDecimalParser.parseWithFastParser(str) : BigDecimalParser.parse(str);
    }

    public static BigInteger parseBigInteger(String str, boolean z) throws NumberFormatException {
        return z ? BigIntegerParser.parseWithFastParser(str) : new BigInteger(str);
    }

    public static double parseDouble(String str, boolean z) throws NumberFormatException {
        return z ? JavaDoubleParser.parseDouble(str) : Double.parseDouble(str);
    }

    public static float parseFloat(String str, boolean z) throws NumberFormatException {
        return z ? JavaFloatParser.parseFloat(str) : Float.parseFloat(str);
    }

    public static int parseInt(char[] cArr, int i, int i2) {
        if (i2 > 0 && cArr[i] == '+') {
            i++;
            i2--;
        }
        int iC = cArr[(i + i2) - 1] - '0';
        switch (i2) {
            case 9:
                iC = d0.c(cArr[i], 48, 100000000, iC);
                i++;
            case 8:
                iC = d0.c(cArr[i], 48, 10000000, iC);
                i++;
            case 7:
                iC = d0.c(cArr[i], 48, 1000000, iC);
                i++;
            case 6:
                iC = d0.c(cArr[i], 48, 100000, iC);
                i++;
            case 5:
                iC = d0.c(cArr[i], 48, c.a.DEFAULT_MEDIA_URI_TIMEOUT, iC);
                i++;
            case 4:
                iC = d0.c(cArr[i], 48, 1000, iC);
                i++;
            case 3:
                iC = d0.c(cArr[i], 48, 100, iC);
                i++;
            case 2:
                return d0.c(cArr[i], 48, 10, iC);
            default:
                return iC;
        }
    }

    public static long parseLong(char[] cArr, int i, int i2) {
        int i3 = i2 - 9;
        return (parseInt(cArr, i, i3) * 1000000000) + parseInt(cArr, i + i3, 9);
    }

    public static long parseLong19(char[] cArr, int i, boolean z) {
        long j = 0;
        for (int i2 = 0; i2 < 19; i2++) {
            j = (j * 10) + (cArr[i + i2] - '0');
        }
        return z ? -j : j;
    }

    public static double parseDouble(char[] cArr, boolean z) throws NumberFormatException {
        return parseDouble(cArr, 0, cArr.length, z);
    }

    public static BigDecimal parseBigDecimal(char[] cArr, int i, int i2, boolean z) throws NumberFormatException {
        if (z) {
            return BigDecimalParser.parseWithFastParser(cArr, i, i2);
        }
        return BigDecimalParser.parse(cArr, i, i2);
    }

    public static double parseDouble(char[] cArr, int i, int i2, boolean z) throws NumberFormatException {
        if (z) {
            return JavaDoubleParser.parseDouble(cArr, i, i2);
        }
        return Double.parseDouble(new String(cArr, i, i2));
    }

    public static float parseFloat(char[] cArr, boolean z) throws NumberFormatException {
        return parseFloat(cArr, 0, cArr.length, z);
    }

    public static long parseLong(String str) {
        if (str.length() <= 9) {
            return parseInt(str);
        }
        return Long.parseLong(str);
    }

    public static boolean inLongRange(String str, boolean z) {
        String str2 = z ? MIN_LONG_STR_NO_SIGN : MAX_LONG_STR;
        int length = str2.length();
        int length2 = str.length();
        if (length2 < length) {
            return true;
        }
        if (length2 > length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            int iCharAt = str.charAt(i) - str2.charAt(i);
            if (iCharAt != 0) {
                return iCharAt < 0;
            }
        }
        return true;
    }

    public static float parseFloat(char[] cArr, int i, int i2, boolean z) throws NumberFormatException {
        if (z) {
            return JavaFloatParser.parseFloat(cArr, i, i2);
        }
        return Float.parseFloat(new String(cArr, i, i2));
    }

    public static BigDecimal parseBigDecimal(char[] cArr, boolean z) throws NumberFormatException {
        if (z) {
            return BigDecimalParser.parseWithFastParser(cArr, 0, cArr.length);
        }
        return BigDecimalParser.parse(cArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0072, code lost:
    
        return java.lang.Integer.parseInt(r10);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int parseInt(java.lang.String r10) {
        /*
            r0 = 0
            char r1 = r10.charAt(r0)
            int r2 = r10.length()
            r3 = 45
            r4 = 1
            if (r1 != r3) goto Lf
            r0 = r4
        Lf:
            r3 = 2
            r5 = 10
            if (r0 == 0) goto L24
            if (r2 == r4) goto L1f
            if (r2 <= r5) goto L19
            goto L1f
        L19:
            char r1 = r10.charAt(r4)
            r4 = r3
            goto L2d
        L1f:
            int r10 = java.lang.Integer.parseInt(r10)
            return r10
        L24:
            r6 = 9
            if (r2 <= r6) goto L2d
            int r10 = java.lang.Integer.parseInt(r10)
            return r10
        L2d:
            r6 = 57
            if (r1 > r6) goto L82
            r7 = 48
            if (r1 >= r7) goto L36
            goto L82
        L36:
            int r1 = r1 - r7
            if (r4 >= r2) goto L7d
            int r8 = r4 + 1
            char r9 = r10.charAt(r4)
            if (r9 > r6) goto L78
            if (r9 >= r7) goto L44
            goto L78
        L44:
            int r1 = r1 * 10
            int r9 = r9 - r7
            int r1 = r1 + r9
            if (r8 >= r2) goto L7d
            int r4 = r4 + r3
            char r3 = r10.charAt(r8)
            if (r3 > r6) goto L73
            if (r3 >= r7) goto L54
            goto L73
        L54:
            int r1 = r1 * 10
            int r3 = r3 - r7
            int r1 = r1 + r3
            if (r4 >= r2) goto L7d
        L5a:
            int r3 = r4 + 1
            char r4 = r10.charAt(r4)
            if (r4 > r6) goto L6e
            if (r4 >= r7) goto L65
            goto L6e
        L65:
            int r1 = r1 * r5
            int r4 = r4 + (-48)
            int r1 = r1 + r4
            if (r3 < r2) goto L6c
            goto L7d
        L6c:
            r4 = r3
            goto L5a
        L6e:
            int r10 = java.lang.Integer.parseInt(r10)
            return r10
        L73:
            int r10 = java.lang.Integer.parseInt(r10)
            return r10
        L78:
            int r10 = java.lang.Integer.parseInt(r10)
            return r10
        L7d:
            if (r0 == 0) goto L81
            int r10 = -r1
            return r10
        L81:
            return r1
        L82:
            int r10 = java.lang.Integer.parseInt(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.io.NumberInput.parseInt(java.lang.String):int");
    }
}
