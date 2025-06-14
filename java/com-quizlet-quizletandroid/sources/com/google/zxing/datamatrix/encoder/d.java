package com.google.zxing.datamatrix.encoder;

import com.comscore.streaming.AdvertisementType;
import com.comscore.streaming.ContentType;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.onetrust.otpublishers.headless.Public.OTUIDisplayReason.OTUIDisplayReasonCode;

/* loaded from: classes2.dex */
public abstract class d {
    public static final int[] a = {5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};
    public static final int[][] b = {new int[]{228, 48, 15, 111, 62}, new int[]{23, 68, 144, 134, 240, 92, 254}, new int[]{28, 24, 185, 166, 223, 248, 116, 255, OTUIDisplayReasonCode.UIShownCode.BANNER_SHOWN_SHOW_BANNER_CALLED, 61}, new int[]{175, 138, 205, 12, 194, 168, 39, 245, 60, 97, 120}, new int[]{41, 153, 158, 91, 61, 42, 142, AdvertisementType.ON_DEMAND_POST_ROLL, 97, 178, 100, 242}, new int[]{156, 97, 192, 252, 95, 9, 157, 119, 138, 45, 18, 186, 83, 185}, new int[]{83, 195, 100, 39, 188, 75, 66, 61, 241, AdvertisementType.ON_DEMAND_POST_ROLL, OTUIDisplayReasonCode.UIShownCode.BANNER_SHOWN_MOVED_REGION, 129, 94, 254, 225, 48, 90, 188}, new int[]{15, 195, 244, 9, AdvertisementType.BRANDED_ON_DEMAND_POST_ROLL, 71, 168, 2, 188, 160, 153, 145, 253, 79, OTUIDisplayReasonCode.UIShownCode.BANNER_SHOWN_BACKWARD_COMPATIBILITY, 82, 27, 174, 186, 172}, new int[]{52, 190, 88, 205, OTUIDisplayReasonCode.UIShownCode.BANNER_SHOWN_MOVED_REGION, 39, 176, 21, 155, 197, 251, 223, 155, 21, 5, 172, 254, 124, 12, 181, 184, 96, 50, 193}, new int[]{211, AdvertisementType.BRANDED_ON_DEMAND_PRE_ROLL, 43, 97, 71, 96, 103, 174, 37, 151, 170, 53, 75, 34, 249, ContentType.USER_GENERATED_SHORT_FORM_ON_DEMAND, 17, 138, OTUIDisplayReasonCode.UIShownCode.BANNER_SHOWN_SHOW_BANNER_CALLED, AdvertisementType.ON_DEMAND_POST_ROLL, ModuleDescriptor.MODULE_VERSION, 136, 120, 151, AdvertisementType.BRANDED_ON_DEMAND_POST_ROLL, 168, 93, 255}, new int[]{245, 127, 242, 218, 130, 250, 162, 181, 102, 120, 84, 179, 220, 251, 80, 182, 229, 18, 2, 4, 68, 33, 101, 137, 95, 119, 115, 44, 175, 184, 59, 25, 225, 98, 81, ContentType.LONG_FORM_ON_DEMAND}, new int[]{77, 193, 137, 31, 19, 38, 22, 153, 247, OTUIDisplayReasonCode.UIShownCode.BANNER_SHOWN_CONSENT_EXPIRED, ContentType.USER_GENERATED_LONG_FORM_ON_DEMAND, 2, 245, 133, 242, 8, 175, 95, 100, 9, 167, OTUIDisplayReasonCode.UIShownCode.BANNER_SHOWN_CONSENT_EXPIRED, 214, 111, 57, ContentType.USER_GENERATED_SHORT_FORM_ON_DEMAND, 21, 1, 253, 57, 54, 101, 248, 202, 69, 50, 150, 177, 226, 5, 9, 5}, new int[]{245, 132, 172, 223, 96, 32, 117, 22, 238, 133, 238, AdvertisementType.BRANDED_ON_DEMAND_PRE_ROLL, 205, 188, 237, 87, 191, OTUIDisplayReasonCode.UIShownCode.BANNER_SHOWN_SERVICE_SPECIFIC_OFF, 16, 147, 118, 23, 37, 90, 170, 205, 131, 88, 120, 100, 66, 138, 186, 240, 82, 44, 176, 87, 187, 147, 160, 175, 69, AdvertisementType.ON_DEMAND_POST_ROLL, 92, 253, 225, 19}, new int[]{175, 9, 223, 238, 12, 17, 220, OTUIDisplayReasonCode.UIShownCode.PC_SHOWN_BACKWARD_COMPATIBILITY, 100, 29, 175, 170, 230, 192, 215, AdvertisementType.BRANDED_DURING_LIVE, 150, 159, 36, 223, 38, 200, 132, 54, 228, 146, 218, AdvertisementType.BRANDED_AS_CONTENT, 117, 203, 29, AdvertisementType.BRANDED_ON_DEMAND_MID_ROLL, 144, 238, 22, 150, 201, 117, 62, OTUIDisplayReasonCode.UIShownCode.PC_SHOWN_SYNC_FAILED, 164, 13, 137, 245, 127, 67, 247, 28, 155, 43, 203, OTUIDisplayReasonCode.UIShownCode.BANNER_SHOWN_SYNC_FAILED, AdvertisementType.BRANDED_ON_DEMAND_POST_ROLL, 53, 143, 46}, new int[]{242, 93, 169, 50, 144, OTUIDisplayReasonCode.UIShownCode.PC_SHOWN_SHOW_PC_CALLED, 39, 118, 202, 188, 201, 189, 143, OTUIDisplayReasonCode.UIShownCode.BANNER_SHOWN_BACKWARD_COMPATIBILITY, 196, 37, 185, ContentType.LONG_FORM_ON_DEMAND, 134, 230, 245, 63, 197, 190, 250, OTUIDisplayReasonCode.UIShownCode.BANNER_SHOWN_SERVICE_SPECIFIC_OFF, 185, AdvertisementType.LIVE, 175, 64, 114, 71, 161, 44, 147, 6, 27, 218, 51, 63, 87, 10, 40, 130, 188, 17, 163, 31, 176, 170, 4, OTUIDisplayReasonCode.UIShownCode.BANNER_SHOWN_SYNC_FAILED, AdvertisementType.BRANDED_ON_DEMAND_MID_ROLL, 7, 94, 166, 224, 124, 86, 47, 11, 204}, new int[]{220, 228, 173, 89, 251, 149, 159, 56, 89, 33, 147, 244, 154, 36, 73, 127, AdvertisementType.ON_DEMAND_POST_ROLL, 136, 248, SubsamplingScaleImageView.ORIENTATION_180, AdvertisementType.BRANDED_AS_CONTENT, 197, 158, 177, 68, ContentType.USER_GENERATED_LONG_FORM_ON_DEMAND, 93, AdvertisementType.ON_DEMAND_POST_ROLL, 15, 160, 227, 236, 66, 139, 153, 185, 202, 167, 179, 25, 220, AdvertisementType.BRANDED_ON_DEMAND_MID_ROLL, 96, OTUIDisplayReasonCode.UIShownCode.PC_SHOWN_SHOW_PC_CALLED, AdvertisementType.BRANDED_ON_DEMAND_PRE_ROLL, 136, 223, 239, 181, 241, 59, 52, 172, 25, 49, AdvertisementType.BRANDED_ON_DEMAND_MID_ROLL, 211, 189, 64, 54, OTUIDisplayReasonCode.UIShownCode.BANNER_SHOWN_BACKWARD_COMPATIBILITY, 153, 132, 63, 96, 103, 82, 186}};
    public static final int[] c = new int[256];
    public static final int[] d = new int[255];

    static {
        int i = 1;
        for (int i2 = 0; i2 < 255; i2++) {
            d[i2] = i;
            c[i] = i2;
            i <<= 1;
            if (i >= 256) {
                i ^= 301;
            }
        }
    }

    public static String a(int i, String str) {
        int[] iArr;
        int[] iArr2;
        int i2;
        int i3;
        int length = str.length();
        int i4 = 0;
        while (true) {
            if (i4 >= 16) {
                i4 = -1;
                break;
            }
            if (a[i4] == i) {
                break;
            }
            i4++;
        }
        if (i4 < 0) {
            throw new IllegalArgumentException("Illegal number of error correction codewords specified: ".concat(String.valueOf(i)));
        }
        int[] iArr3 = b[i4];
        char[] cArr = new char[i];
        for (int i5 = 0; i5 < i; i5++) {
            cArr[i5] = 0;
        }
        for (int i6 = 0; i6 < length; i6++) {
            int i7 = i - 1;
            int iCharAt = cArr[i7] ^ str.charAt(i6);
            while (true) {
                iArr = c;
                iArr2 = d;
                if (i7 <= 0) {
                    break;
                }
                if (iCharAt == 0 || (i3 = iArr3[i7]) == 0) {
                    cArr[i7] = cArr[i7 - 1];
                } else {
                    cArr[i7] = (char) (iArr2[(iArr[iCharAt] + iArr[i3]) % 255] ^ cArr[i7 - 1]);
                }
                i7--;
            }
            if (iCharAt == 0 || (i2 = iArr3[0]) == 0) {
                cArr[0] = 0;
            } else {
                cArr[0] = (char) iArr2[(iArr[iCharAt] + iArr[i2]) % 255];
            }
        }
        char[] cArr2 = new char[i];
        for (int i8 = 0; i8 < i; i8++) {
            cArr2[i8] = cArr[(i - i8) - 1];
        }
        return String.valueOf(cArr2);
    }
}
