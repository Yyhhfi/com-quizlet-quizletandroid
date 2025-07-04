package assistantMode.refactored.modelTypes;

import com.quizlet.db.data.models.persisted.fields.DBAnswerFields;
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
import kotlinx.serialization.internal.C5053g;
import kotlinx.serialization.internal.D;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import org.jetbrains.annotations.NotNull;

@Metadata
@InterfaceC4935d
/* loaded from: classes.dex */
public final class ParsedMultipleChoiceOption$$serializer implements D {

    @NotNull
    public static final ParsedMultipleChoiceOption$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        ParsedMultipleChoiceOption$$serializer parsedMultipleChoiceOption$$serializer = new ParsedMultipleChoiceOption$$serializer();
        INSTANCE = parsedMultipleChoiceOption$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("assistantMode.refactored.modelTypes.ParsedMultipleChoiceOption", parsedMultipleChoiceOption$$serializer, 2);
        pluginGeneratedSerialDescriptor.k("media", false);
        pluginGeneratedSerialDescriptor.k(DBAnswerFields.Names.IS_CORRECT, false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ParsedMultipleChoiceOption$$serializer() {
    }

    @Override // kotlinx.serialization.internal.D
    @NotNull
    public KSerializer[] childSerializers() {
        return new KSerializer[]{ParsedMultipleChoiceOption.c[0], C5053g.a};
    }

    @Override // kotlinx.serialization.KSerializer
    @NotNull
    public ParsedMultipleChoiceOption deserialize(@NotNull Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        kotlinx.serialization.encoding.a aVarC = decoder.c(descriptor2);
        KSerializer[] kSerializerArr = ParsedMultipleChoiceOption.c;
        List list = null;
        boolean z = true;
        int i = 0;
        boolean zQ = false;
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
                zQ = aVarC.q(descriptor2, 1);
                i |= 2;
            }
        }
        aVarC.b(descriptor2);
        return new ParsedMultipleChoiceOption(zQ, i, list);
    }

    @Override // kotlinx.serialization.KSerializer
    @NotNull
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.KSerializer
    public void serialize(@NotNull Encoder encoder, @NotNull ParsedMultipleChoiceOption value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        kotlinx.serialization.encoding.b bVarC = encoder.c(descriptor2);
        bVarC.i(descriptor2, 0, ParsedMultipleChoiceOption.c[0], value.a);
        bVarC.p(descriptor2, 1, value.b);
        bVarC.b(descriptor2);
    }

    @Override // kotlinx.serialization.internal.D
    @NotNull
    public KSerializer[] typeParametersSerializers() {
        return AbstractC5047c0.b;
    }
}
