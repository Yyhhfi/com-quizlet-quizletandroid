package com.j256.ormlite.stmt.query;

import android.support.v4.media.session.a;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.ArgumentHolder;
import java.sql.SQLException;
import java.util.List;

/* loaded from: classes2.dex */
public class Between extends BaseComparison {
    private Object high;
    private Object low;

    public Between(String str, FieldType fieldType, Object obj, Object obj2) throws SQLException {
        super(str, fieldType, null, true);
        this.low = obj;
        this.high = obj2;
    }

    @Override // com.j256.ormlite.stmt.query.BaseComparison, com.j256.ormlite.stmt.query.Comparison
    public void appendOperation(StringBuilder sb) {
        sb.append("BETWEEN ");
    }

    @Override // com.j256.ormlite.stmt.query.BaseComparison, com.j256.ormlite.stmt.query.Comparison, com.j256.ormlite.stmt.query.Clause
    public /* bridge */ /* synthetic */ void appendSql(DatabaseType databaseType, String str, StringBuilder sb, List list, Clause clause) throws SQLException {
        super.appendSql(databaseType, str, sb, list, clause);
    }

    @Override // com.j256.ormlite.stmt.query.BaseComparison, com.j256.ormlite.stmt.query.Comparison
    public void appendValue(DatabaseType databaseType, StringBuilder sb, List<ArgumentHolder> list) throws SQLException {
        Object obj = this.low;
        if (obj == null) {
            throw new IllegalArgumentException(a.t(new StringBuilder("BETWEEN low value for '"), this.columnName, "' is null"));
        }
        if (this.high == null) {
            throw new IllegalArgumentException(a.t(new StringBuilder("BETWEEN high value for '"), this.columnName, "' is null"));
        }
        appendArgOrValue(databaseType, this.fieldType, sb, list, obj);
        sb.append("AND ");
        appendArgOrValue(databaseType, this.fieldType, sb, list, this.high);
    }

    @Override // com.j256.ormlite.stmt.query.BaseComparison, com.j256.ormlite.stmt.query.Comparison
    public /* bridge */ /* synthetic */ String getColumnName() {
        return super.getColumnName();
    }

    @Override // com.j256.ormlite.stmt.query.BaseComparison
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
