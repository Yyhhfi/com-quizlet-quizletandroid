package com.quizlet.shared.models.api.notes;

import kotlin.InterfaceC4935d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.AbstractC5047c0;
import kotlinx.serialization.internal.D;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.q0;
import org.jetbrains.annotations.NotNull;

@Metadata
@InterfaceC4935d
/* loaded from: classes3.dex */
public final class NotesTitleArtifactResponse$$serializer implements D {

    @NotNull
    public static final NotesTitleArtifactResponse$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        NotesTitleArtifactResponse$$serializer notesTitleArtifactResponse$$serializer = new NotesTitleArtifactResponse$$serializer();
        INSTANCE = notesTitleArtifactResponse$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.quizlet.shared.models.api.notes.NotesTitleArtifactResponse", notesTitleArtifactResponse$$serializer, 1);
        pluginGeneratedSerialDescriptor.k("title", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private NotesTitleArtifactResponse$$serializer() {
    }

    @Override // kotlinx.serialization.internal.D
    @NotNull
    public KSerializer[] childSerializers() {
        return new KSerializer[]{q0.a};
    }

    @Override // kotlinx.serialization.KSerializer
    @NotNull
    public NotesTitleArtifactResponse deserialize(@NotNull Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        kotlinx.serialization.encoding.a aVarC = decoder.c(descriptor2);
        String strR = null;
        boolean z = true;
        int i = 0;
        while (z) {
            int iT = aVarC.t(descriptor2);
            if (iT == -1) {
                z = false;
            } else {
                if (iT != 0) {
                    throw new UnknownFieldException(iT);
                }
                strR = aVarC.r(descriptor2, 0);
                i = 1;
            }
        }
        aVarC.b(descriptor2);
        return new NotesTitleArtifactResponse(i, strR);
    }

    @Override // kotlinx.serialization.KSerializer
    @NotNull
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.KSerializer
    public void serialize(@NotNull Encoder encoder, @NotNull NotesTitleArtifactResponse value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        kotlinx.serialization.encoding.b bVarC = encoder.c(descriptor2);
        bVarC.r(descriptor2, 0, value.a);
        bVarC.b(descriptor2);
    }

    @Override // kotlinx.serialization.internal.D
    @NotNull
    public KSerializer[] typeParametersSerializers() {
        return AbstractC5047c0.b;
    }
}
