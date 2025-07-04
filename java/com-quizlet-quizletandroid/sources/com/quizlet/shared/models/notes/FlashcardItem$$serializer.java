package com.quizlet.shared.models.notes;

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
public final class FlashcardItem$$serializer implements D {

    @NotNull
    public static final FlashcardItem$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        FlashcardItem$$serializer flashcardItem$$serializer = new FlashcardItem$$serializer();
        INSTANCE = flashcardItem$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("StudyNoteArtifactInfoFlashcardsItem", flashcardItem$$serializer, 2);
        pluginGeneratedSerialDescriptor.k("term", false);
        pluginGeneratedSerialDescriptor.k("definition", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private FlashcardItem$$serializer() {
    }

    @Override // kotlinx.serialization.internal.D
    @NotNull
    public KSerializer[] childSerializers() {
        q0 q0Var = q0.a;
        return new KSerializer[]{q0Var, q0Var};
    }

    @Override // kotlinx.serialization.KSerializer
    @NotNull
    public FlashcardItem deserialize(@NotNull Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        kotlinx.serialization.encoding.a aVarC = decoder.c(descriptor2);
        String strR = null;
        boolean z = true;
        int i = 0;
        String strR2 = null;
        while (z) {
            int iT = aVarC.t(descriptor2);
            if (iT == -1) {
                z = false;
            } else if (iT == 0) {
                strR = aVarC.r(descriptor2, 0);
                i |= 1;
            } else {
                if (iT != 1) {
                    throw new UnknownFieldException(iT);
                }
                strR2 = aVarC.r(descriptor2, 1);
                i |= 2;
            }
        }
        aVarC.b(descriptor2);
        return new FlashcardItem(i, strR, strR2);
    }

    @Override // kotlinx.serialization.KSerializer
    @NotNull
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.KSerializer
    public void serialize(@NotNull Encoder encoder, @NotNull FlashcardItem value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        kotlinx.serialization.encoding.b bVarC = encoder.c(descriptor2);
        bVarC.r(descriptor2, 0, value.b);
        bVarC.r(descriptor2, 1, value.c);
        bVarC.b(descriptor2);
    }

    @Override // kotlinx.serialization.internal.D
    @NotNull
    public KSerializer[] typeParametersSerializers() {
        return AbstractC5047c0.b;
    }
}
