package com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_0;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.NavigableMap;

/* loaded from: classes.dex */
final class JavaBigDecimalFromCharSequence extends AbstractBigDecimalParser {
    public BigDecimal parseBigDecimalString(CharSequence charSequence, int i, int i2) {
        boolean z;
        int i3;
        long j;
        int i4;
        int i5;
        long j2;
        int iTryToParseFourDigits;
        int i6 = i;
        try {
            int iCheckBounds = AbstractNumberParser.checkBounds(charSequence.length(), i6, i2);
            if (AbstractBigDecimalParser.hasManyDigits(i2)) {
                return parseBigDecimalStringWithManyDigits(charSequence, i, i2);
            }
            char cCharAt = AbstractNumberParser.charAt(charSequence, i6, iCheckBounds);
            boolean z2 = cCharAt == '-';
            if ((z2 || cCharAt == '+') && (cCharAt = AbstractNumberParser.charAt(charSequence, (i6 = i6 + 1), iCheckBounds)) == 0) {
                throw new NumberFormatException("illegal syntax");
            }
            int i7 = -1;
            int i8 = i6;
            long j3 = 0;
            boolean z3 = false;
            while (true) {
                if (i8 >= iCheckBounds) {
                    z = true;
                    break;
                }
                cCharAt = charSequence.charAt(i8);
                z = true;
                char c = (char) (cCharAt - '0');
                if (c >= '\n') {
                    if (cCharAt != '.') {
                        break;
                    }
                    z3 |= i7 >= 0;
                    int i9 = i8;
                    while (i9 < iCheckBounds - 4 && (iTryToParseFourDigits = FastDoubleSwar.tryToParseFourDigits(charSequence, i9 + 1)) >= 0) {
                        j3 = (j3 * 10000) + iTryToParseFourDigits;
                        i9 += 4;
                    }
                    i7 = i8;
                    i8 = i9;
                } else {
                    j3 = (j3 * 10) + c;
                }
                i8++;
            }
            if (i7 < 0) {
                i3 = i8 - i6;
                i4 = i8;
                j = 0;
            } else {
                i3 = (i8 - i6) - 1;
                j = (i7 - i8) + 1;
                i4 = i7;
            }
            if ((cCharAt | ' ') == 101) {
                int i10 = i8 + 1;
                char cCharAt2 = AbstractNumberParser.charAt(charSequence, i10, iCheckBounds);
                boolean z4 = cCharAt2 == '-' ? z : false;
                if (z4 || cCharAt2 == '+') {
                    i10 = i8 + 2;
                    cCharAt2 = AbstractNumberParser.charAt(charSequence, i10, iCheckBounds);
                }
                char c2 = (char) (cCharAt2 - '0');
                z3 |= c2 >= '\n' ? z : false;
                long j4 = 0;
                while (true) {
                    if (j4 < 2147483647L) {
                        j4 = (j4 * 10) + c2;
                    }
                    j2 = j4;
                    i10++;
                    char cCharAt3 = (char) (AbstractNumberParser.charAt(charSequence, i10, iCheckBounds) - '0');
                    if (cCharAt3 >= '\n') {
                        break;
                    }
                    j4 = j2;
                    c2 = cCharAt3;
                }
                if (z4) {
                    j2 = -j2;
                }
                j += j2;
                i5 = i10;
            } else {
                i5 = i8;
                i8 = iCheckBounds;
            }
            long j5 = j;
            if (i3 != 0) {
                z = false;
            }
            AbstractBigDecimalParser.checkParsedBigDecimalBounds(z3 | z, i5, iCheckBounds, i3, j5);
            if (i3 >= 19) {
                return valueOfBigDecimalString(charSequence, i6, i4, i4 + 1, i8, z2, (int) j5);
            }
            if (z2) {
                j3 = -j3;
            }
            return new BigDecimal(j3).scaleByPowerOfTen((int) j5);
        } catch (ArithmeticException e) {
            NumberFormatException numberFormatException = new NumberFormatException("value exceeds limits");
            numberFormatException.initCause(e);
            throw numberFormatException;
        }
    }

    public BigDecimal parseBigDecimalStringWithManyDigits(CharSequence charSequence, int i, int i2) {
        int i3;
        int i4;
        boolean z;
        int i5;
        long j;
        int i6;
        boolean z2;
        long j2;
        int i7;
        boolean z3;
        int i8;
        int i9 = i;
        int i10 = i9 + i2;
        char cCharAt = AbstractNumberParser.charAt(charSequence, i9, i10);
        boolean z4 = cCharAt == '-';
        if ((z4 || cCharAt == '+') && (cCharAt = AbstractNumberParser.charAt(charSequence, (i9 = i9 + 1), i10)) == 0) {
            throw new NumberFormatException("illegal syntax");
        }
        int iMin = Math.min(i10 - 8, 1073741824);
        int i11 = i9;
        while (i11 < iMin && FastDoubleSwar.isEightZeroes(charSequence, i11)) {
            i11 += 8;
        }
        while (i11 < i10 && charSequence.charAt(i11) == '0') {
            i11++;
        }
        int i12 = i11;
        while (i12 < iMin && FastDoubleSwar.isEightDigits(charSequence, i12)) {
            i12 += 8;
        }
        while (i12 < i10) {
            cCharAt = charSequence.charAt(i12);
            if (!FastDoubleSwar.isDigit(cCharAt)) {
                break;
            }
            i12++;
        }
        if (cCharAt == '.') {
            int i13 = i12 + 1;
            while (i13 < iMin && FastDoubleSwar.isEightZeroes(charSequence, i13)) {
                i13 += 8;
            }
            while (i13 < i10 && charSequence.charAt(i13) == '0') {
                i13++;
            }
            int i14 = i13;
            while (i14 < iMin && FastDoubleSwar.isEightDigits(charSequence, i14)) {
                i14 += 8;
            }
            while (i14 < i10) {
                cCharAt = charSequence.charAt(i14);
                if (!FastDoubleSwar.isDigit(cCharAt)) {
                    break;
                }
                i14++;
            }
            i4 = i13;
            i3 = i12;
            i12 = i14;
        } else {
            i3 = -1;
            i4 = -1;
        }
        long j3 = 0;
        if (i3 < 0) {
            z = true;
            i6 = i12 - i11;
            i4 = i12;
            i3 = i4;
            i5 = i3;
            j = 0;
        } else {
            z = true;
            i5 = i12;
            j = (i3 - i12) + 1;
            i6 = i11 == i3 ? i12 - i4 : (i12 - i11) - 1;
        }
        if ((cCharAt | ' ') == 101) {
            int i15 = i5 + 1;
            char cCharAt2 = AbstractNumberParser.charAt(charSequence, i15, i10);
            boolean z5 = cCharAt2 == '-' ? z : false;
            if (z5 || cCharAt2 == '+') {
                i15 = i5 + 2;
                cCharAt2 = AbstractNumberParser.charAt(charSequence, i15, i10);
            }
            char cCharAt3 = (char) (cCharAt2 - '0');
            z3 = cCharAt3 >= '\n' ? z : false;
            while (true) {
                if (j3 < 2147483647L) {
                    z2 = z4;
                    j3 = (j3 * 10) + cCharAt3;
                } else {
                    z2 = z4;
                }
                i15++;
                cCharAt3 = (char) (AbstractNumberParser.charAt(charSequence, i15, i10) - '0');
                if (cCharAt3 >= '\n') {
                    break;
                }
                z4 = z2;
            }
            if (z5) {
                j3 = -j3;
            }
            i7 = i15;
            j2 = j + j3;
            i8 = i5;
        } else {
            z2 = z4;
            j2 = j;
            i7 = i5;
            z3 = false;
            i8 = i10;
        }
        AbstractBigDecimalParser.checkParsedBigDecimalBounds(z3 | ((i9 == i3 && i3 == i8) ? z : false), i7, i10, i6, j2);
        return valueOfBigDecimalString(charSequence, i11, i3, i4, i8, z2, (int) j2);
    }

    public BigDecimal valueOfBigDecimalString(CharSequence charSequence, int i, int i2, int i3, int i4, boolean z, int i5) {
        BigInteger bigIntegerNegate;
        BigInteger digitsIterative;
        int i6 = (i4 - i2) - 1;
        int i7 = i4 - i3;
        int i8 = i2 - i;
        NavigableMap<Integer, BigInteger> navigableMapCreatePowersOfTenFloor16Map = null;
        if (i8 <= 0) {
            bigIntegerNegate = BigInteger.ZERO;
        } else if (i8 > 400) {
            navigableMapCreatePowersOfTenFloor16Map = FastIntegerMath.createPowersOfTenFloor16Map();
            FastIntegerMath.fillPowersOfNFloor16Recursive(navigableMapCreatePowersOfTenFloor16Map, i, i2);
            bigIntegerNegate = ParseDigitsTaskCharSequence.parseDigitsRecursive(charSequence, i, i2, navigableMapCreatePowersOfTenFloor16Map, 400);
        } else {
            bigIntegerNegate = ParseDigitsTaskCharSequence.parseDigitsIterative(charSequence, i, i2);
        }
        if (i6 > 0) {
            if (i7 > 400) {
                if (navigableMapCreatePowersOfTenFloor16Map == null) {
                    navigableMapCreatePowersOfTenFloor16Map = FastIntegerMath.createPowersOfTenFloor16Map();
                }
                FastIntegerMath.fillPowersOfNFloor16Recursive(navigableMapCreatePowersOfTenFloor16Map, i3, i4);
                digitsIterative = ParseDigitsTaskCharSequence.parseDigitsRecursive(charSequence, i3, i4, navigableMapCreatePowersOfTenFloor16Map, 400);
            } else {
                digitsIterative = ParseDigitsTaskCharSequence.parseDigitsIterative(charSequence, i3, i4);
            }
            if (bigIntegerNegate.signum() != 0) {
                digitsIterative = FftMultiplier.multiply(bigIntegerNegate, FastIntegerMath.computePowerOfTen(navigableMapCreatePowersOfTenFloor16Map, i6)).add(digitsIterative);
            }
            bigIntegerNegate = digitsIterative;
        }
        if (z) {
            bigIntegerNegate = bigIntegerNegate.negate();
        }
        return new BigDecimal(bigIntegerNegate, -i5);
    }
}
