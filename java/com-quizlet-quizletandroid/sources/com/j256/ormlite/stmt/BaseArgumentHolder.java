package com.j256.ormlite.stmt;

import androidx.compose.ui.node.B;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.sql.SQLException;

/* loaded from: classes2.dex */
public abstract class BaseArgumentHolder implements ArgumentHolder {
    private String columnName;
    private FieldType fieldType;
    private SqlType sqlType;

    public BaseArgumentHolder() {
        this.columnName = null;
        this.fieldType = null;
        this.sqlType = null;
    }

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public String getColumnName() {
        return this.columnName;
    }

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public FieldType getFieldType() {
        return this.fieldType;
    }

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public Object getSqlArgValue() throws SQLException {
        if (!isValueSet()) {
            throw new SQLException("Column value has not been set for " + this.columnName);
        }
        Object value = getValue();
        if (value == null) {
            return null;
        }
        FieldType fieldType = this.fieldType;
        return fieldType == null ? value : (fieldType.isForeign() && this.fieldType.getType() == value.getClass()) ? this.fieldType.getForeignRefField().extractJavaFieldValue(value) : this.fieldType.convertJavaFieldToSqlArgValue(value);
    }

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public SqlType getSqlType() {
        return this.sqlType;
    }

    public abstract Object getValue();

    public abstract boolean isValueSet();

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public void setMetaInfo(String str) {
        String str2 = this.columnName;
        if (str2 != null && !str2.equals(str)) {
            throw new IllegalArgumentException(B.j(new StringBuilder("Column name cannot be set twice from "), this.columnName, " to ", str, ".  Using a SelectArg twice in query with different columns?"));
        }
        this.columnName = str;
    }

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public abstract void setValue(Object obj);

    public String toString() {
        if (!isValueSet()) {
            return "[unset]";
        }
        try {
            Object sqlArgValue = getSqlArgValue();
            return sqlArgValue == null ? "[null]" : sqlArgValue.toString();
        } catch (SQLException e) {
            return "[could not get value: " + e + "]";
        }
    }

    public BaseArgumentHolder(String str) {
        this.fieldType = null;
        this.sqlType = null;
        this.columnName = str;
    }

    public BaseArgumentHolder(SqlType sqlType) {
        this.columnName = null;
        this.fieldType = null;
        this.sqlType = sqlType;
    }

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public void setMetaInfo(FieldType fieldType) {
        FieldType fieldType2 = this.fieldType;
        if (fieldType2 == null || fieldType2 == fieldType) {
            this.fieldType = fieldType;
            return;
        }
        throw new IllegalArgumentException("FieldType name cannot be set twice from " + this.fieldType + " to " + fieldType + ".  Using a SelectArg twice in query with different columns?");
    }

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public void setMetaInfo(String str, FieldType fieldType) {
        setMetaInfo(str);
        setMetaInfo(fieldType);
    }
}
