package kotlin.io.encoding;

import kotlin.collections.C4930v;

/* loaded from: classes3.dex */
public abstract class d {
    public static final byte[] a;
    public static final int[] b;
    public static final byte[] c;
    public static final int[] d;

    static {
        byte[] bArr = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        a = bArr;
        int[] iArr = new int[256];
        C4930v.p(iArr, -1);
        iArr[61] = -2;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i2 < 64) {
            iArr[bArr[i2]] = i3;
            i2++;
            i3++;
        }
        b = iArr;
        byte[] bArr2 = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        c = bArr2;
        int[] iArr2 = new int[256];
        C4930v.p(iArr2, -1);
        iArr2[61] = -2;
        int i4 = 0;
        while (i < 64) {
            iArr2[bArr2[i]] = i4;
            i++;
            i4++;
        }
        d = iArr2;
    }
}
