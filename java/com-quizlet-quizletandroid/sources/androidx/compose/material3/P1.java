package androidx.compose.material3;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.C4956o;

/* loaded from: classes.dex */
public final /* synthetic */ class P1 extends C4956o implements Function2 {
    public static final P1 a = new P1(2, androidx.compose.ui.layout.J.class, "minIntrinsicWidth", "minIntrinsicWidth(I)I", 0);

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return Integer.valueOf(((androidx.compose.ui.layout.J) obj).x(((Number) obj2).intValue()));
    }
}
