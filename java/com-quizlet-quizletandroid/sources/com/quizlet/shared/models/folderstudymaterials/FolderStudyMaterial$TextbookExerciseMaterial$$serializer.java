package com.quizlet.shared.models.folderstudymaterials;

import com.quizlet.shared.enums.o;
import com.quizlet.shared.enums.p;
import com.quizlet.shared.models.explanations.TextbookExercise;
import com.quizlet.shared.models.explanations.TextbookExercise$$serializer;
import com.quizlet.shared.models.folderstudymaterials.FolderStudyMaterial$TextbookExerciseMaterial;
import kotlin.InterfaceC4935d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.encoding.b;
import kotlinx.serialization.internal.AbstractC5047c0;
import kotlinx.serialization.internal.D;
import kotlinx.serialization.internal.P;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.q0;
import org.jetbrains.annotations.NotNull;

@Metadata
@InterfaceC4935d
/* loaded from: classes3.dex */
public final class FolderStudyMaterial$TextbookExerciseMaterial$$serializer implements D {

    @NotNull
    public static final FolderStudyMaterial$TextbookExerciseMaterial$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        FolderStudyMaterial$TextbookExerciseMaterial$$serializer folderStudyMaterial$TextbookExerciseMaterial$$serializer = new FolderStudyMaterial$TextbookExerciseMaterial$$serializer();
        INSTANCE = folderStudyMaterial$TextbookExerciseMaterial$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("FolderStudyMaterialTextbookExerciseMaterial", folderStudyMaterial$TextbookExerciseMaterial$$serializer, 6);
        pluginGeneratedSerialDescriptor.k("data", false);
        pluginGeneratedSerialDescriptor.k("id", false);
        pluginGeneratedSerialDescriptor.k("timestampSec", false);
        pluginGeneratedSerialDescriptor.k("materialId", true);
        pluginGeneratedSerialDescriptor.k("studyMaterialType", true);
        pluginGeneratedSerialDescriptor.k("name", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private FolderStudyMaterial$TextbookExerciseMaterial$$serializer() {
    }

    @Override // kotlinx.serialization.internal.D
    @NotNull
    public KSerializer[] childSerializers() {
        P p = P.a;
        q0 q0Var = q0.a;
        return new KSerializer[]{TextbookExercise$$serializer.INSTANCE, p, p, q0Var, o.f, q0Var};
    }

    @Override // kotlinx.serialization.KSerializer
    @NotNull
    public FolderStudyMaterial$TextbookExerciseMaterial deserialize(@NotNull Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        kotlinx.serialization.encoding.a aVarC = decoder.c(descriptor2);
        int i = 0;
        TextbookExercise textbookExercise = null;
        String strR = null;
        p pVar = null;
        String strR2 = null;
        long j = 0;
        long j2 = 0;
        boolean z = true;
        while (z) {
            int iT = aVarC.t(descriptor2);
            switch (iT) {
                case -1:
                    z = false;
                    break;
                case 0:
                    textbookExercise = (TextbookExercise) aVarC.z(descriptor2, 0, TextbookExercise$$serializer.INSTANCE, textbookExercise);
                    i |= 1;
                    break;
                case 1:
                    j = aVarC.j(descriptor2, 1);
                    i |= 2;
                    break;
                case 2:
                    j2 = aVarC.j(descriptor2, 2);
                    i |= 4;
                    break;
                case 3:
                    strR = aVarC.r(descriptor2, 3);
                    i |= 8;
                    break;
                case 4:
                    pVar = (p) aVarC.z(descriptor2, 4, o.f, pVar);
                    i |= 16;
                    break;
                case 5:
                    strR2 = aVarC.r(descriptor2, 5);
                    i |= 32;
                    break;
                default:
                    throw new UnknownFieldException(iT);
            }
        }
        aVarC.b(descriptor2);
        return new FolderStudyMaterial$TextbookExerciseMaterial(i, textbookExercise, j, j2, strR, pVar, strR2);
    }

    @Override // kotlinx.serialization.KSerializer
    @NotNull
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.KSerializer
    public void serialize(@NotNull Encoder encoder, @NotNull FolderStudyMaterial$TextbookExerciseMaterial value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        b bVarC = encoder.c(descriptor2);
        FolderStudyMaterial$TextbookExerciseMaterial.Companion companion = FolderStudyMaterial$TextbookExerciseMaterial.Companion;
        bVarC.i(descriptor2, 0, TextbookExercise$$serializer.INSTANCE, value.b);
        bVarC.C(descriptor2, 1, value.c);
        bVarC.C(descriptor2, 2, value.d);
        boolean zD = bVarC.D(descriptor2);
        TextbookExercise textbookExercise = value.b;
        String str = value.e;
        if (zD || !Intrinsics.b(str, textbookExercise.d)) {
            bVarC.r(descriptor2, 3, str);
        }
        boolean zD2 = bVarC.D(descriptor2);
        p pVar = value.f;
        if (zD2 || pVar != p.e) {
            bVarC.i(descriptor2, 4, o.f, pVar);
        }
        boolean zD3 = bVarC.D(descriptor2);
        String str2 = value.g;
        if (zD3 || !Intrinsics.b(str2, textbookExercise.c)) {
            bVarC.r(descriptor2, 5, str2);
        }
        bVarC.b(descriptor2);
    }

    @Override // kotlinx.serialization.internal.D
    @NotNull
    public KSerializer[] typeParametersSerializers() {
        return AbstractC5047c0.b;
    }
}
