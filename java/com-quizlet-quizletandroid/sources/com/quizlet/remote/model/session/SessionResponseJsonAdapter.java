package com.quizlet.remote.model.session;

import com.airbnb.lottie.parser.moshi.c;
import com.quizlet.data.model.AbstractC4178x;
import com.quizlet.remote.model.base.ModelError;
import com.quizlet.remote.model.base.PagingInfo;
import com.quizlet.remote.model.base.ValidationError;
import com.quizlet.remote.model.session.SessionResponse;
import com.squareup.moshi.D;
import com.squareup.moshi.H;
import com.squareup.moshi.l;
import com.squareup.moshi.p;
import com.squareup.moshi.w;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.M;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public final class SessionResponseJsonAdapter extends l {
    public final c a;
    public final l b;
    public final l c;
    public final l d;
    public final l e;

    public SessionResponseJsonAdapter(@NotNull D moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        c cVarB = c.b("models", "paging", "validationErrors", "error");
        Intrinsics.checkNotNullExpressionValue(cVarB, "of(...)");
        this.a = cVarB;
        M m = M.a;
        l lVarA = moshi.a(SessionResponse.SessionModels.class, m, "models");
        Intrinsics.checkNotNullExpressionValue(lVarA, "adapter(...)");
        this.b = lVarA;
        l lVarA2 = moshi.a(PagingInfo.class, m, "pagingInfo");
        Intrinsics.checkNotNullExpressionValue(lVarA2, "adapter(...)");
        this.c = lVarA2;
        l lVarA3 = moshi.a(H.f(List.class, ValidationError.class), m, "validationErrors");
        Intrinsics.checkNotNullExpressionValue(lVarA3, "adapter(...)");
        this.d = lVarA3;
        l lVarA4 = moshi.a(ModelError.class, m, "error");
        Intrinsics.checkNotNullExpressionValue(lVarA4, "adapter(...)");
        this.e = lVarA4;
    }

    @Override // com.squareup.moshi.l
    public final Object a(p reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        reader.d();
        SessionResponse.SessionModels sessionModels = null;
        List list = null;
        ModelError modelError = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        PagingInfo pagingInfo = null;
        while (reader.l()) {
            int iK0 = reader.k0(this.a);
            if (iK0 == -1) {
                reader.m0();
                reader.n0();
            } else if (iK0 == 0) {
                sessionModels = (SessionResponse.SessionModels) this.b.a(reader);
            } else if (iK0 == 1) {
                pagingInfo = (PagingInfo) this.c.a(reader);
                z = true;
            } else if (iK0 == 2) {
                list = (List) this.d.a(reader);
                z2 = true;
            } else if (iK0 == 3) {
                modelError = (ModelError) this.e.a(reader);
                z3 = true;
            }
        }
        reader.i();
        SessionResponse sessionResponse = new SessionResponse(sessionModels);
        if (z) {
            sessionResponse.a = pagingInfo;
        }
        if (z2) {
            sessionResponse.b = list;
        }
        if (z3) {
            sessionResponse.c = modelError;
        }
        return sessionResponse;
    }

    @Override // com.squareup.moshi.l
    public final void g(w writer, Object obj) {
        SessionResponse sessionResponse = (SessionResponse) obj;
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (sessionResponse == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        writer.d();
        writer.l("models");
        this.b.g(writer, sessionResponse.d);
        writer.l("paging");
        this.c.g(writer, sessionResponse.a);
        writer.l("validationErrors");
        this.d.g(writer, sessionResponse.b);
        writer.l("error");
        this.e.g(writer, sessionResponse.c);
        writer.f();
    }

    public final String toString() {
        return AbstractC4178x.m(37, "GeneratedJsonAdapter(SessionResponse)", "toString(...)");
    }
}
