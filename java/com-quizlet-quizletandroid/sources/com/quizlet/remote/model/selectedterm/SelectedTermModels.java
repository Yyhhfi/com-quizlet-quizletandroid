package com.quizlet.remote.model.selectedterm;

import com.squareup.moshi.InterfaceC4853h;
import com.squareup.moshi.m;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@m(generateAdapter = true)
@Metadata
/* loaded from: classes3.dex */
public final class SelectedTermModels {
    public final List a;

    public SelectedTermModels(@InterfaceC4853h(name = "selectedTerm") List<? extends a> list) {
        this.a = list;
    }

    @NotNull
    public final SelectedTermModels copy(@InterfaceC4853h(name = "selectedTerm") List<? extends a> list) {
        return new SelectedTermModels(list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SelectedTermModels) && Intrinsics.b(this.a, ((SelectedTermModels) obj).a);
    }

    public final int hashCode() {
        List list = this.a;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public final String toString() {
        return android.support.v4.media.session.a.n(")", new StringBuilder("SelectedTermModels(term="), this.a);
    }
}
