package androidx.core.app;

import android.media.AudioAttributes;

/* renamed from: androidx.core.app.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1033u {
    public static AudioAttributes a(AudioAttributes.Builder builder) {
        return builder.build();
    }

    public static AudioAttributes.Builder b() {
        return new AudioAttributes.Builder();
    }

    public static AudioAttributes.Builder c(AudioAttributes.Builder builder, int i) {
        return builder.setContentType(i);
    }

    public static AudioAttributes.Builder d(AudioAttributes.Builder builder, int i) {
        return builder.setUsage(i);
    }
}
