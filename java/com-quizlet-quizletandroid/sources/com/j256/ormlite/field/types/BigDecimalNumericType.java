package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.math.BigDecimal;
import java.sql.SQLException;

/* loaded from: classes2.dex */
public class BigDecimalNumericType extends BaseDataType {
    private static final BigDecimalNumericType singleTon = new BigDecimalNumericType();

    private BigDecimalNumericType() {
        super(SqlType.BIG_DECIMAL);
    }

    public static BigDecimalNumericType getSingleton() {
        return singleTon;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public Class<?> getPrimaryClass() {
        return BigDecimal.class;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isAppropriateId() {
        return false;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isEscapedValue() {
        return false;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object parseDefaultString(FieldType fieldType, String str) throws SQLException {
        try {
            return new BigDecimal(str);
        } catch (IllegalArgumentException e) {
            throw new SQLException("Problems with field " + fieldType + " parsing default BigDecimal string '" + str + "'", e);
        }
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i) throws SQLException {
        return databaseResults.getBigDecimal(i);
    }

    public BigDecimalNumericType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }
}
