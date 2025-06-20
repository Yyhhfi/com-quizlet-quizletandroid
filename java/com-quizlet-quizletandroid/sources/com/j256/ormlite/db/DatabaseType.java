package com.j256.ormlite.db;

import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.FieldConverter;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.List;

/* loaded from: classes2.dex */
public interface DatabaseType {
    void addPrimaryKeySql(FieldType[] fieldTypeArr, List<String> list, List<String> list2, List<String> list3, List<String> list4) throws SQLException;

    void addUniqueComboSql(FieldType[] fieldTypeArr, List<String> list, List<String> list2, List<String> list3, List<String> list4) throws SQLException;

    void appendColumnArg(String str, StringBuilder sb, FieldType fieldType, List<String> list, List<String> list2, List<String> list3, List<String> list4) throws SQLException;

    void appendCreateSchemaSuffix(StringBuilder sb);

    void appendCreateTableSuffix(StringBuilder sb);

    void appendDeleteLimitValue(StringBuilder sb, long j);

    void appendEscapedEntityName(StringBuilder sb, String str);

    void appendEscapedWord(StringBuilder sb, String str);

    void appendInsertNoColumns(StringBuilder sb);

    void appendLimitValue(StringBuilder sb, long j, Long l);

    void appendOffsetValue(StringBuilder sb, long j);

    void appendSelectNextValFromSequence(StringBuilder sb, String str);

    void appendUpdateLimitValue(StringBuilder sb, long j);

    String downCaseString(String str, boolean z);

    void dropColumnArg(FieldType fieldType, List<String> list, List<String> list2);

    <T> DatabaseTableConfig<T> extractDatabaseTableConfig(ConnectionSource connectionSource, Class<T> cls) throws SQLException;

    String generateIdSequenceName(String str, FieldType fieldType);

    String getCommentLinePrefix();

    DataPersister getDataPersister(DataPersister dataPersister, FieldType fieldType);

    String getDatabaseName();

    FieldConverter getFieldConverter(DataPersister dataPersister, FieldType fieldType);

    String getPingStatement();

    boolean isAllowGeneratedIdInsertSupported();

    boolean isBatchUseTransaction();

    boolean isCreateIfNotExistsSupported();

    boolean isCreateIndexIfNotExistsSupported();

    boolean isCreateSchemaIfNotExistsSupported();

    boolean isCreateSchemaReturnsNegative();

    boolean isCreateSchemaReturnsZero();

    boolean isCreateTableReturnsNegative();

    boolean isCreateTableReturnsZero();

    boolean isDatabaseUrlThisType(String str, String str2);

    boolean isEntityNamesMustBeUpCase();

    boolean isIdSequenceNeeded();

    boolean isLimitAfterDeleteSupported();

    boolean isLimitAfterSelect();

    boolean isLimitAfterUpdateSupported();

    boolean isLimitDeleteAtEndSupported();

    boolean isLimitSqlSupported();

    boolean isLimitUpdateAtEndSupported();

    boolean isNestedSavePointsSupported();

    boolean isOffsetLimitArgument();

    boolean isOffsetSqlSupported();

    boolean isSelectSequenceBeforeInsert();

    boolean isSequenceNamesMustBeLowerCase();

    boolean isTruncateSupported();

    boolean isVarcharFieldWidthSupported();

    boolean loadDriver();

    void setDriver(Driver driver);

    String upCaseEntityName(String str);

    String upCaseString(String str, boolean z);
}
