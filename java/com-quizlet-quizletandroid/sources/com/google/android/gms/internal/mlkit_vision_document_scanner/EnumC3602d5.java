package com.google.android.gms.internal.mlkit_vision_document_scanner;

import com.comscore.streaming.ContentType;
import com.onetrust.otpublishers.headless.Public.OTUIDisplayReason.OTUIDisplayReasonCode;

/* renamed from: com.google.android.gms.internal.mlkit_vision_document_scanner.d5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public enum EnumC3602d5 implements InterfaceC3652k {
    NO_ERROR(0),
    /* JADX INFO: Fake field, exist only in values array */
    INCOMPATIBLE_INPUT(1),
    /* JADX INFO: Fake field, exist only in values array */
    INCOMPATIBLE_OUTPUT(2),
    /* JADX INFO: Fake field, exist only in values array */
    INCOMPATIBLE_TFLITE_VERSION(3),
    /* JADX INFO: Fake field, exist only in values array */
    MISSING_OP(4),
    /* JADX INFO: Fake field, exist only in values array */
    DATA_TYPE_ERROR(6),
    /* JADX INFO: Fake field, exist only in values array */
    PERMISSION_DENIED(7),
    /* JADX INFO: Fake field, exist only in values array */
    TFLITE_UNKNOWN_ERROR(8),
    /* JADX INFO: Fake field, exist only in values array */
    MEDIAPIPE_ERROR(9),
    /* JADX INFO: Fake field, exist only in values array */
    TIME_OUT_FETCHING_MODEL_METADATA(5),
    /* JADX INFO: Fake field, exist only in values array */
    MODEL_NOT_DOWNLOADED(100),
    /* JADX INFO: Fake field, exist only in values array */
    URI_EXPIRED(101),
    /* JADX INFO: Fake field, exist only in values array */
    NO_NETWORK_CONNECTION(102),
    /* JADX INFO: Fake field, exist only in values array */
    METERED_NETWORK(103),
    /* JADX INFO: Fake field, exist only in values array */
    DOWNLOAD_FAILED(104),
    /* JADX INFO: Fake field, exist only in values array */
    PERMISSION_DENIED(OTUIDisplayReasonCode.UIShownCode.BANNER_SHOWN_CONSENT_EXPIRED),
    /* JADX INFO: Fake field, exist only in values array */
    LOW_LIGHT_IMAGE_CAPTURE_PROCESSING_FAILURE(OTUIDisplayReasonCode.UIShownCode.BANNER_SHOWN_SERVICE_SPECIFIC_OFF),
    /* JADX INFO: Fake field, exist only in values array */
    PERMISSION_DENIED(OTUIDisplayReasonCode.UIShownCode.BANNER_SHOWN_SYNC_FAILED),
    /* JADX INFO: Fake field, exist only in values array */
    LOW_LIGHT_IMAGE_CAPTURE_PROCESSING_FAILURE(OTUIDisplayReasonCode.UIShownCode.BANNER_SHOWN_BACKWARD_COMPATIBILITY),
    /* JADX INFO: Fake field, exist only in values array */
    PERMISSION_DENIED(OTUIDisplayReasonCode.UIShownCode.BANNER_SHOWN_MOVED_REGION),
    /* JADX INFO: Fake field, exist only in values array */
    LOW_LIGHT_IMAGE_CAPTURE_PROCESSING_FAILURE(OTUIDisplayReasonCode.UIShownCode.BANNER_SHOWN_SHOW_BANNER_CALLED),
    /* JADX INFO: Fake field, exist only in values array */
    PERMISSION_DENIED(111),
    /* JADX INFO: Fake field, exist only in values array */
    LOW_LIGHT_IMAGE_CAPTURE_PROCESSING_FAILURE(ContentType.LONG_FORM_ON_DEMAND),
    /* JADX INFO: Fake field, exist only in values array */
    PERMISSION_DENIED(ContentType.LIVE),
    /* JADX INFO: Fake field, exist only in values array */
    LOW_LIGHT_IMAGE_CAPTURE_PROCESSING_FAILURE(114),
    /* JADX INFO: Fake field, exist only in values array */
    PERMISSION_DENIED(115),
    /* JADX INFO: Fake field, exist only in values array */
    LOW_LIGHT_IMAGE_CAPTURE_PROCESSING_FAILURE(116),
    /* JADX INFO: Fake field, exist only in values array */
    PERMISSION_DENIED(201),
    /* JADX INFO: Fake field, exist only in values array */
    LOW_LIGHT_IMAGE_CAPTURE_PROCESSING_FAILURE(202),
    /* JADX INFO: Fake field, exist only in values array */
    PERMISSION_DENIED(203),
    /* JADX INFO: Fake field, exist only in values array */
    LOW_LIGHT_IMAGE_CAPTURE_PROCESSING_FAILURE(204),
    /* JADX INFO: Fake field, exist only in values array */
    PERMISSION_DENIED(205),
    /* JADX INFO: Fake field, exist only in values array */
    LOW_LIGHT_IMAGE_CAPTURE_PROCESSING_FAILURE(OTUIDisplayReasonCode.UIShownCode.PC_SHOWN_SERVICE_SPECIFIC_OFF),
    /* JADX INFO: Fake field, exist only in values array */
    PERMISSION_DENIED(OTUIDisplayReasonCode.UIShownCode.PC_SHOWN_SYNC_FAILED),
    /* JADX INFO: Fake field, exist only in values array */
    LOW_LIGHT_IMAGE_CAPTURE_PROCESSING_FAILURE(301),
    /* JADX INFO: Fake field, exist only in values array */
    PERMISSION_DENIED(302),
    /* JADX INFO: Fake field, exist only in values array */
    LOW_LIGHT_IMAGE_CAPTURE_PROCESSING_FAILURE(303),
    /* JADX INFO: Fake field, exist only in values array */
    PERMISSION_DENIED(304),
    /* JADX INFO: Fake field, exist only in values array */
    LOW_LIGHT_IMAGE_CAPTURE_PROCESSING_FAILURE(305),
    /* JADX INFO: Fake field, exist only in values array */
    PERMISSION_DENIED(400),
    /* JADX INFO: Fake field, exist only in values array */
    LOW_LIGHT_IMAGE_CAPTURE_PROCESSING_FAILURE(401),
    /* JADX INFO: Fake field, exist only in values array */
    PERMISSION_DENIED(402),
    /* JADX INFO: Fake field, exist only in values array */
    LOW_LIGHT_IMAGE_CAPTURE_PROCESSING_FAILURE(403),
    /* JADX INFO: Fake field, exist only in values array */
    PERMISSION_DENIED(404),
    /* JADX INFO: Fake field, exist only in values array */
    LOW_LIGHT_IMAGE_CAPTURE_PROCESSING_FAILURE(com.pubmatic.sdk.video.a.MEDIA_FILE_DISPLAY_ERROR),
    /* JADX INFO: Fake field, exist only in values array */
    PERMISSION_DENIED(406),
    /* JADX INFO: Fake field, exist only in values array */
    LOW_LIGHT_IMAGE_CAPTURE_PROCESSING_FAILURE(com.pubmatic.sdk.video.a.VERIFICATION_EXECUTION_ERROR),
    /* JADX INFO: Fake field, exist only in values array */
    PERMISSION_DENIED(com.pubmatic.sdk.video.a.GENERAL_NONLINEAR_AD_ERROR),
    /* JADX INFO: Fake field, exist only in values array */
    LOW_LIGHT_IMAGE_CAPTURE_PROCESSING_FAILURE(501),
    /* JADX INFO: Fake field, exist only in values array */
    PERMISSION_DENIED(com.pubmatic.sdk.video.a.GENERAL_COMPANION_AD_ERROR),
    CANCELLED(601),
    GOOGLE_PLAY_SERVICES_VERSION_TOO_OLD(602),
    LOW_MEMORY(603),
    UNKNOWN_ERROR(9999);

    public final int a;

    EnumC3602d5(int i) {
        this.a = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_document_scanner.InterfaceC3652k
    public final int zza() {
        return this.a;
    }
}
