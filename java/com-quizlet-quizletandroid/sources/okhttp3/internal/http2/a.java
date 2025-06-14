package okhttp3.internal.http2;

/* loaded from: classes3.dex */
public enum a {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    /* JADX INFO: Fake field, exist only in values array */
    SETTINGS_TIMEOUT(4),
    /* JADX INFO: Fake field, exist only in values array */
    STREAM_CLOSED(5),
    /* JADX INFO: Fake field, exist only in values array */
    FRAME_SIZE_ERROR(6),
    REFUSED_STREAM(7),
    CANCEL(8),
    /* JADX INFO: Fake field, exist only in values array */
    COMPRESSION_ERROR(9),
    /* JADX INFO: Fake field, exist only in values array */
    CONNECT_ERROR(10),
    /* JADX INFO: Fake field, exist only in values array */
    ENHANCE_YOUR_CALM(11),
    /* JADX INFO: Fake field, exist only in values array */
    INADEQUATE_SECURITY(12),
    /* JADX INFO: Fake field, exist only in values array */
    HTTP_1_1_REQUIRED(13);

    public final int a;

    a(int i) {
        this.a = i;
    }
}
