package assistantMode.types.test;

import assistantMode.types.TestGeneratorOutputMetadata;
import assistantMode.types.TestGeneratorOutputMetadata$$serializer;
import java.util.List;
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
import org.jetbrains.annotations.NotNull;

@Metadata
@InterfaceC4935d
/* loaded from: classes.dex */
public final class Test$$serializer implements D {

    @NotNull
    public static final Test$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        Test$$serializer test$$serializer = new Test$$serializer();
        INSTANCE = test$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("Test", test$$serializer, 2);
        pluginGeneratedSerialDescriptor.k("questions", false);
        pluginGeneratedSerialDescriptor.k("metadata", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Test$$serializer() {
    }

    @Override // kotlinx.serialization.internal.D
    @NotNull
    public KSerializer[] childSerializers() {
        return new KSerializer[]{Test.c[0], TestGeneratorOutputMetadata$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.KSerializer
    @NotNull
    public Test deserialize(@NotNull Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        kotlinx.serialization.encoding.a aVarC = decoder.c(descriptor2);
        KSerializer[] kSerializerArr = Test.c;
        List list = null;
        boolean z = true;
        int i = 0;
        TestGeneratorOutputMetadata testGeneratorOutputMetadata = null;
        while (z) {
            int iT = aVarC.t(descriptor2);
            if (iT == -1) {
                z = false;
            } else if (iT == 0) {
                list = (List) aVarC.z(descriptor2, 0, kSerializerArr[0], list);
                i |= 1;
            } else {
                if (iT != 1) {
                    throw new UnknownFieldException(iT);
                }
                testGeneratorOutputMetadata = (TestGeneratorOutputMetadata) aVarC.z(descriptor2, 1, TestGeneratorOutputMetadata$$serializer.INSTANCE, testGeneratorOutputMetadata);
                i |= 2;
            }
        }
        aVarC.b(descriptor2);
        return new Test(i, list, testGeneratorOutputMetadata);
    }

    @Override // kotlinx.serialization.KSerializer
    @NotNull
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.KSerializer
    public void serialize(@NotNull Encoder encoder, @NotNull Test value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        kotlinx.serialization.encoding.b bVarC = encoder.c(descriptor2);
        bVarC.i(descriptor2, 0, Test.c[0], value.a);
        boolean zD = bVarC.D(descriptor2);
        TestGeneratorOutputMetadata testGeneratorOutputMetadata = value.b;
        if (zD || !Intrinsics.b(testGeneratorOutputMetadata, new TestGeneratorOutputMetadata(false, 7))) {
            bVarC.i(descriptor2, 1, TestGeneratorOutputMetadata$$serializer.INSTANCE, testGeneratorOutputMetadata);
        }
        bVarC.b(descriptor2);
    }

    @Override // kotlinx.serialization.internal.D
    @NotNull
    public KSerializer[] typeParametersSerializers() {
        return AbstractC5047c0.b;
    }
}
