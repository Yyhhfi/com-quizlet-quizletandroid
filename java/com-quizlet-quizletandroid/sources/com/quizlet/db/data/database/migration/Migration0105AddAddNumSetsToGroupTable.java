package com.quizlet.db.data.database.migration;

import androidx.compose.runtime.AbstractC0772a;
import com.quizlet.android.migrator.a;
import com.quizlet.android.migrator.migrations.e;
import com.quizlet.android.migrator.tools.c;
import com.quizlet.db.data.models.persisted.DBGroup;
import com.quizlet.db.data.models.persisted.fields.DBGroupFields;
import java.sql.SQLException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes2.dex */
public final class Migration0105AddAddNumSetsToGroupTable extends e {
    @Override // com.quizlet.android.migrator.migrations.a
    public final void b(AbstractC0772a abstractC0772a) throws SQLException {
        c t = (c) abstractC0772a;
        Intrinsics.checkNotNullParameter(t, "t");
        t.o(DBGroup.class, DBGroup.TABLE_NAME, DBGroupFields.Names.NUM_SETS, a.a);
    }
}
