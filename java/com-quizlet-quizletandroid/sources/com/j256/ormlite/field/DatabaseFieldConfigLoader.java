package com.j256.ormlite.field;

import androidx.camera.camera2.internal.AbstractC0147y;
import java.io.BufferedWriter;
import java.io.IOException;
import java.sql.SQLException;

/* loaded from: classes2.dex */
public class DatabaseFieldConfigLoader {
    private static final String CONFIG_FILE_END_MARKER = "# --field-end--";
    private static final String CONFIG_FILE_START_MARKER = "# --field-start--";
    private static final DataPersister DEFAULT_DATA_PERSISTER;
    private static final DataType DEFAULT_DATA_TYPE;
    private static final int DEFAULT_MAX_EAGER_FOREIGN_COLLECTION_LEVEL = 1;
    private static final String FIELD_NAME_ALLOW_GENERATED_ID_INSERT = "allowGeneratedIdInsert";
    private static final String FIELD_NAME_CAN_BE_NULL = "canBeNull";
    private static final String FIELD_NAME_COLUMN_DEFINITION = "columnDefinition";
    private static final String FIELD_NAME_COLUMN_NAME = "columnName";
    private static final String FIELD_NAME_DATA_PERSISTER = "dataPersister";
    private static final String FIELD_NAME_DATA_TYPE = "dataType";
    private static final String FIELD_NAME_DEFAULT_VALUE = "defaultValue";
    private static final String FIELD_NAME_FIELD_NAME = "fieldName";
    private static final String FIELD_NAME_FOREIGN = "foreign";
    private static final String FIELD_NAME_FOREIGN_AUTO_CREATE = "foreignAutoCreate";
    private static final String FIELD_NAME_FOREIGN_AUTO_REFRESH = "foreignAutoRefresh";
    private static final String FIELD_NAME_FOREIGN_COLLECTION = "foreignCollection";
    private static final String FIELD_NAME_FOREIGN_COLLECTION_COLUMN_NAME = "foreignCollectionColumnName";
    private static final String FIELD_NAME_FOREIGN_COLLECTION_EAGER = "foreignCollectionEager";
    private static final String FIELD_NAME_FOREIGN_COLLECTION_FOREIGN_FIELD_NAME = "foreignCollectionForeignFieldName";
    private static final String FIELD_NAME_FOREIGN_COLLECTION_FOREIGN_FIELD_NAME_OLD = "foreignCollectionForeignColumnName";
    private static final String FIELD_NAME_FOREIGN_COLLECTION_ORDER_ASCENDING = "foreignCollectionOrderAscending";
    private static final String FIELD_NAME_FOREIGN_COLLECTION_ORDER_COLUMN_NAME = "foreignCollectionOrderColumnName";
    private static final String FIELD_NAME_FOREIGN_COLLECTION_ORDER_COLUMN_NAME_OLD = "foreignCollectionOrderColumn";
    private static final String FIELD_NAME_FOREIGN_COLUMN_NAME = "foreignColumnName";
    private static final String FIELD_NAME_FORMAT = "format";
    private static final String FIELD_NAME_FULL_COLUMN_DEFINITION = "fullColumnDefinition";
    private static final String FIELD_NAME_GENERATED_ID = "generatedId";
    private static final String FIELD_NAME_GENERATED_ID_SEQUENCE = "generatedIdSequence";
    private static final String FIELD_NAME_ID = "id";
    private static final String FIELD_NAME_INDEX = "index";
    private static final String FIELD_NAME_INDEX_NAME = "indexName";
    private static final String FIELD_NAME_JAVAX_ENTITY = "javaxEntity";
    private static final String FIELD_NAME_MAX_EAGER_FOREIGN_COLLECTION_LEVEL = "foreignCollectionMaxEagerLevel";
    private static final String FIELD_NAME_MAX_EAGER_FOREIGN_COLLECTION_LEVEL_OLD = "maxEagerForeignCollectionLevel";
    private static final String FIELD_NAME_MAX_FOREIGN_AUTO_REFRESH_LEVEL = "maxForeignAutoRefreshLevel";
    private static final String FIELD_NAME_PERSISTED = "persisted";
    private static final String FIELD_NAME_PERSISTER_CLASS = "persisterClass";
    private static final String FIELD_NAME_READ_ONLY = "readOnly";
    private static final String FIELD_NAME_THROW_IF_NULL = "throwIfNull";
    private static final String FIELD_NAME_UNIQUE = "unique";
    private static final String FIELD_NAME_UNIQUE_COMBO = "uniqueCombo";
    private static final String FIELD_NAME_UNIQUE_INDEX = "uniqueIndex";
    private static final String FIELD_NAME_UNIQUE_INDEX_NAME = "uniqueIndexName";
    private static final String FIELD_NAME_UNKNOWN_ENUM_VALUE = "unknownEnumValue";
    private static final String FIELD_NAME_USE_GET_SET = "useGetSet";
    private static final String FIELD_NAME_VERSION = "version";
    private static final String FIELD_NAME_WIDTH = "width";

    static {
        DataType dataType = DatabaseFieldConfig.DEFAULT_DATA_TYPE;
        DEFAULT_DATA_TYPE = dataType;
        DEFAULT_DATA_PERSISTER = dataType.getDataPersister();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0019, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0016, code lost:
    
        if (r2 == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0018, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.j256.ormlite.field.DatabaseFieldConfig fromReader(java.io.BufferedReader r6) throws java.sql.SQLException, java.io.IOException {
        /*
            com.j256.ormlite.field.DatabaseFieldConfig r0 = new com.j256.ormlite.field.DatabaseFieldConfig
            r0.<init>()
            r1 = 0
            r2 = r1
        L7:
            java.lang.String r3 = r6.readLine()     // Catch: java.io.IOException -> L53
            if (r3 != 0) goto Le
            goto L16
        Le:
            java.lang.String r4 = "# --field-end--"
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L1b
        L16:
            if (r2 == 0) goto L19
            return r0
        L19:
            r6 = 0
            return r6
        L1b:
            int r4 = r3.length()
            if (r4 == 0) goto L7
            java.lang.String r4 = "#"
            boolean r4 = r3.startsWith(r4)
            if (r4 != 0) goto L7
            java.lang.String r4 = "# --field-start--"
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L32
            goto L7
        L32:
            java.lang.String r2 = "="
            r4 = -2
            java.lang.String[] r2 = r3.split(r2, r4)
            int r4 = r2.length
            r5 = 2
            if (r4 != r5) goto L47
            r3 = r2[r1]
            r4 = 1
            r2 = r2[r4]
            readField(r0, r3, r2)
            r2 = r4
            goto L7
        L47:
            java.sql.SQLException r6 = new java.sql.SQLException
            java.lang.String r0 = "DatabaseFieldConfig reading from stream cannot parse line: "
            java.lang.String r0 = r0.concat(r3)
            r6.<init>(r0)
            throw r6
        L53:
            r6 = move-exception
            java.sql.SQLException r0 = new java.sql.SQLException
            java.lang.String r1 = "Could not read DatabaseFieldConfig from stream"
            r0.<init>(r1, r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.field.DatabaseFieldConfigLoader.fromReader(java.io.BufferedReader):com.j256.ormlite.field.DatabaseFieldConfig");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void readField(DatabaseFieldConfig databaseFieldConfig, String str, String str2) {
        if (str.equals(FIELD_NAME_FIELD_NAME)) {
            databaseFieldConfig.setFieldName(str2);
            return;
        }
        if (str.equals(FIELD_NAME_COLUMN_NAME)) {
            databaseFieldConfig.setColumnName(str2);
            return;
        }
        if (str.equals(FIELD_NAME_DATA_TYPE)) {
            databaseFieldConfig.setDataType(DataType.valueOf(str2));
            return;
        }
        if (str.equals(FIELD_NAME_DATA_PERSISTER)) {
            databaseFieldConfig.setDataPersister(DataType.valueOf(str2).getDataPersister());
            return;
        }
        if (str.equals(FIELD_NAME_DEFAULT_VALUE)) {
            databaseFieldConfig.setDefaultValue(str2);
            return;
        }
        if (str.equals("width")) {
            databaseFieldConfig.setWidth(Integer.parseInt(str2));
            return;
        }
        if (str.equals(FIELD_NAME_CAN_BE_NULL)) {
            databaseFieldConfig.setCanBeNull(Boolean.parseBoolean(str2));
            return;
        }
        if (str.equals("id")) {
            databaseFieldConfig.setId(Boolean.parseBoolean(str2));
            return;
        }
        if (str.equals(FIELD_NAME_GENERATED_ID)) {
            databaseFieldConfig.setGeneratedId(Boolean.parseBoolean(str2));
            return;
        }
        if (str.equals(FIELD_NAME_GENERATED_ID_SEQUENCE)) {
            databaseFieldConfig.setGeneratedIdSequence(str2);
            return;
        }
        if (str.equals(FIELD_NAME_FOREIGN)) {
            databaseFieldConfig.setForeign(Boolean.parseBoolean(str2));
            return;
        }
        if (str.equals(FIELD_NAME_USE_GET_SET)) {
            databaseFieldConfig.setUseGetSet(Boolean.parseBoolean(str2));
            return;
        }
        if (str.equals(FIELD_NAME_UNKNOWN_ENUM_VALUE)) {
            String[] strArrSplit = str2.split("#", -2);
            if (strArrSplit.length != 2) {
                throw new IllegalArgumentException("Invalid value for unknownEnumValue which should be in class#name format: ".concat(str2));
            }
            try {
                Object[] enumConstants = Class.forName(strArrSplit[0]).getEnumConstants();
                if (enumConstants == null) {
                    throw new IllegalArgumentException("Invalid class is not an Enum for unknownEnumValue: ".concat(str2));
                }
                boolean z = false;
                for (Enum r5 : (Enum[]) enumConstants) {
                    if (r5.name().equals(strArrSplit[1])) {
                        databaseFieldConfig.setUnknownEnumValue(r5);
                        z = true;
                    }
                }
                if (!z) {
                    throw new IllegalArgumentException("Invalid enum value name for unknownEnumvalue: ".concat(str2));
                }
                return;
            } catch (ClassNotFoundException unused) {
                throw new IllegalArgumentException("Unknown class specified for unknownEnumValue: ".concat(str2));
            }
        }
        if (str.equals(FIELD_NAME_THROW_IF_NULL)) {
            databaseFieldConfig.setThrowIfNull(Boolean.parseBoolean(str2));
            return;
        }
        if (str.equals(FIELD_NAME_PERSISTED)) {
            databaseFieldConfig.setPersisted(Boolean.parseBoolean(str2));
            return;
        }
        if (str.equals(FIELD_NAME_FORMAT)) {
            databaseFieldConfig.setFormat(str2);
            return;
        }
        if (str.equals(FIELD_NAME_UNIQUE)) {
            databaseFieldConfig.setUnique(Boolean.parseBoolean(str2));
            return;
        }
        if (str.equals(FIELD_NAME_UNIQUE_COMBO)) {
            databaseFieldConfig.setUniqueCombo(Boolean.parseBoolean(str2));
            return;
        }
        if (str.equals(FIELD_NAME_INDEX)) {
            databaseFieldConfig.setIndex(Boolean.parseBoolean(str2));
            return;
        }
        if (str.equals(FIELD_NAME_INDEX_NAME)) {
            databaseFieldConfig.setIndex(true);
            databaseFieldConfig.setIndexName(str2);
            return;
        }
        if (str.equals(FIELD_NAME_UNIQUE_INDEX)) {
            databaseFieldConfig.setUniqueIndex(Boolean.parseBoolean(str2));
            return;
        }
        if (str.equals(FIELD_NAME_UNIQUE_INDEX_NAME)) {
            databaseFieldConfig.setUniqueIndex(true);
            databaseFieldConfig.setUniqueIndexName(str2);
            return;
        }
        if (str.equals(FIELD_NAME_FOREIGN_AUTO_REFRESH)) {
            databaseFieldConfig.setForeignAutoRefresh(Boolean.parseBoolean(str2));
            return;
        }
        if (str.equals(FIELD_NAME_MAX_FOREIGN_AUTO_REFRESH_LEVEL)) {
            databaseFieldConfig.setMaxForeignAutoRefreshLevel(Integer.parseInt(str2));
            return;
        }
        if (str.equals(FIELD_NAME_PERSISTER_CLASS)) {
            try {
                databaseFieldConfig.setPersisterClass(Class.forName(str2));
                return;
            } catch (ClassNotFoundException unused2) {
                throw new IllegalArgumentException(AbstractC0147y.d("Could not find persisterClass: ", str2));
            }
        }
        if (str.equals(FIELD_NAME_ALLOW_GENERATED_ID_INSERT)) {
            databaseFieldConfig.setAllowGeneratedIdInsert(Boolean.parseBoolean(str2));
            return;
        }
        if (str.equals(FIELD_NAME_COLUMN_DEFINITION)) {
            databaseFieldConfig.setColumnDefinition(str2);
            return;
        }
        if (str.equals(FIELD_NAME_FULL_COLUMN_DEFINITION)) {
            databaseFieldConfig.setFullColumnDefinition(str2);
            return;
        }
        if (str.equals(FIELD_NAME_FOREIGN_AUTO_CREATE)) {
            databaseFieldConfig.setForeignAutoCreate(Boolean.parseBoolean(str2));
            return;
        }
        if (str.equals(FIELD_NAME_VERSION)) {
            databaseFieldConfig.setVersion(Boolean.parseBoolean(str2));
            return;
        }
        if (str.equals(FIELD_NAME_FOREIGN_COLUMN_NAME)) {
            databaseFieldConfig.setForeignColumnName(str2);
            return;
        }
        if (str.equals(FIELD_NAME_READ_ONLY)) {
            databaseFieldConfig.setReadOnly(Boolean.parseBoolean(str2));
            return;
        }
        if (str.equals(FIELD_NAME_JAVAX_ENTITY)) {
            databaseFieldConfig.setJavaxEntity(Boolean.parseBoolean(str2));
            return;
        }
        if (str.equals(FIELD_NAME_FOREIGN_COLLECTION)) {
            databaseFieldConfig.setForeignCollection(Boolean.parseBoolean(str2));
            return;
        }
        if (str.equals(FIELD_NAME_FOREIGN_COLLECTION_EAGER)) {
            databaseFieldConfig.setForeignCollectionEager(Boolean.parseBoolean(str2));
            return;
        }
        if (str.equals(FIELD_NAME_MAX_EAGER_FOREIGN_COLLECTION_LEVEL_OLD)) {
            databaseFieldConfig.setForeignCollectionMaxEagerLevel(Integer.parseInt(str2));
            return;
        }
        if (str.equals(FIELD_NAME_MAX_EAGER_FOREIGN_COLLECTION_LEVEL)) {
            databaseFieldConfig.setForeignCollectionMaxEagerLevel(Integer.parseInt(str2));
            return;
        }
        if (str.equals(FIELD_NAME_FOREIGN_COLLECTION_COLUMN_NAME)) {
            databaseFieldConfig.setForeignCollectionColumnName(str2);
            return;
        }
        if (str.equals(FIELD_NAME_FOREIGN_COLLECTION_ORDER_COLUMN_NAME_OLD)) {
            databaseFieldConfig.setForeignCollectionOrderColumnName(str2);
            return;
        }
        if (str.equals(FIELD_NAME_FOREIGN_COLLECTION_ORDER_COLUMN_NAME)) {
            databaseFieldConfig.setForeignCollectionOrderColumnName(str2);
            return;
        }
        if (str.equals(FIELD_NAME_FOREIGN_COLLECTION_ORDER_ASCENDING)) {
            databaseFieldConfig.setForeignCollectionOrderAscending(Boolean.parseBoolean(str2));
        } else if (str.equals(FIELD_NAME_FOREIGN_COLLECTION_FOREIGN_FIELD_NAME_OLD)) {
            databaseFieldConfig.setForeignCollectionForeignFieldName(str2);
        } else if (str.equals(FIELD_NAME_FOREIGN_COLLECTION_FOREIGN_FIELD_NAME)) {
            databaseFieldConfig.setForeignCollectionForeignFieldName(str2);
        }
    }

    public static void write(BufferedWriter bufferedWriter, DatabaseFieldConfig databaseFieldConfig, String str) throws SQLException {
        try {
            writeConfig(bufferedWriter, databaseFieldConfig, str);
        } catch (IOException e) {
            throw new SQLException("Could not write config to writer", e);
        }
    }

    public static void writeConfig(BufferedWriter bufferedWriter, DatabaseFieldConfig databaseFieldConfig, String str) throws IOException {
        bufferedWriter.append(CONFIG_FILE_START_MARKER);
        bufferedWriter.newLine();
        if (databaseFieldConfig.getFieldName() != null) {
            bufferedWriter.append(FIELD_NAME_FIELD_NAME).append('=').append((CharSequence) databaseFieldConfig.getFieldName());
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.getColumnName() != null) {
            bufferedWriter.append(FIELD_NAME_COLUMN_NAME).append('=').append((CharSequence) databaseFieldConfig.getColumnName());
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.getDataType() != DEFAULT_DATA_TYPE) {
            bufferedWriter.append(FIELD_NAME_DATA_TYPE).append('=').append((CharSequence) databaseFieldConfig.getDataType().name());
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.getDataPersister() != DEFAULT_DATA_PERSISTER) {
            for (DataType dataType : DataType.values()) {
                if (dataType.getDataPersister() == databaseFieldConfig.getDataPersister()) {
                    bufferedWriter.append(FIELD_NAME_DATA_PERSISTER).append('=').append((CharSequence) dataType.name());
                    bufferedWriter.newLine();
                }
            }
            throw new IllegalArgumentException("Unknown data persister field: " + databaseFieldConfig.getDataPersister());
        }
        if (databaseFieldConfig.getDefaultValue() != null) {
            bufferedWriter.append(FIELD_NAME_DEFAULT_VALUE).append('=').append((CharSequence) databaseFieldConfig.getDefaultValue());
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.getWidth() != 0) {
            bufferedWriter.append("width").append('=').append((CharSequence) Integer.toString(databaseFieldConfig.getWidth()));
            bufferedWriter.newLine();
        }
        if (!databaseFieldConfig.isCanBeNull()) {
            bufferedWriter.append(FIELD_NAME_CAN_BE_NULL).append('=').append((CharSequence) Boolean.toString(databaseFieldConfig.isCanBeNull()));
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.isId()) {
            bufferedWriter.append("id").append('=').append("true");
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.isGeneratedId()) {
            bufferedWriter.append(FIELD_NAME_GENERATED_ID).append('=').append("true");
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.getGeneratedIdSequence() != null) {
            bufferedWriter.append(FIELD_NAME_GENERATED_ID_SEQUENCE).append('=').append((CharSequence) databaseFieldConfig.getGeneratedIdSequence());
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.isForeign()) {
            bufferedWriter.append(FIELD_NAME_FOREIGN).append('=').append("true");
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.isUseGetSet()) {
            bufferedWriter.append(FIELD_NAME_USE_GET_SET).append('=').append("true");
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.getUnknownEnumValue() != null) {
            bufferedWriter.append(FIELD_NAME_UNKNOWN_ENUM_VALUE).append('=').append((CharSequence) databaseFieldConfig.getUnknownEnumValue().getDeclaringClass().getName()).append('#').append((CharSequence) databaseFieldConfig.getUnknownEnumValue().name());
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.isThrowIfNull()) {
            bufferedWriter.append(FIELD_NAME_THROW_IF_NULL).append('=').append("true");
            bufferedWriter.newLine();
        }
        if (!databaseFieldConfig.isPersisted()) {
            bufferedWriter.append(FIELD_NAME_PERSISTED).append('=').append((CharSequence) Boolean.toString(databaseFieldConfig.isPersisted()));
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.getFormat() != null) {
            bufferedWriter.append(FIELD_NAME_FORMAT).append('=').append((CharSequence) databaseFieldConfig.getFormat());
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.isUnique()) {
            bufferedWriter.append(FIELD_NAME_UNIQUE).append('=').append("true");
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.isUniqueCombo()) {
            bufferedWriter.append(FIELD_NAME_UNIQUE_COMBO).append('=').append("true");
            bufferedWriter.newLine();
        }
        String indexName = databaseFieldConfig.getIndexName(str);
        if (indexName != null) {
            bufferedWriter.append(FIELD_NAME_INDEX_NAME).append('=').append((CharSequence) indexName);
            bufferedWriter.newLine();
        }
        String uniqueIndexName = databaseFieldConfig.getUniqueIndexName(str);
        if (uniqueIndexName != null) {
            bufferedWriter.append(FIELD_NAME_UNIQUE_INDEX_NAME).append('=').append((CharSequence) uniqueIndexName);
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.isForeignAutoRefresh()) {
            bufferedWriter.append(FIELD_NAME_FOREIGN_AUTO_REFRESH).append('=').append("true");
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.getMaxForeignAutoRefreshLevel() != -1) {
            bufferedWriter.append(FIELD_NAME_MAX_FOREIGN_AUTO_REFRESH_LEVEL).append('=').append((CharSequence) Integer.toString(databaseFieldConfig.getMaxForeignAutoRefreshLevel()));
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.getPersisterClass() != DatabaseFieldConfig.DEFAULT_PERSISTER_CLASS) {
            bufferedWriter.append(FIELD_NAME_PERSISTER_CLASS).append('=').append((CharSequence) databaseFieldConfig.getPersisterClass().getName());
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.isAllowGeneratedIdInsert()) {
            bufferedWriter.append(FIELD_NAME_ALLOW_GENERATED_ID_INSERT).append('=').append("true");
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.getColumnDefinition() != null) {
            bufferedWriter.append(FIELD_NAME_COLUMN_DEFINITION).append('=').append((CharSequence) databaseFieldConfig.getColumnDefinition());
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.getFullColumnDefinition() != null) {
            bufferedWriter.append(FIELD_NAME_FULL_COLUMN_DEFINITION).append('=').append((CharSequence) databaseFieldConfig.getFullColumnDefinition());
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.isForeignAutoCreate()) {
            bufferedWriter.append(FIELD_NAME_FOREIGN_AUTO_CREATE).append('=').append("true");
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.isVersion()) {
            bufferedWriter.append(FIELD_NAME_VERSION).append('=').append("true");
            bufferedWriter.newLine();
        }
        String foreignColumnName = databaseFieldConfig.getForeignColumnName();
        if (foreignColumnName != null) {
            bufferedWriter.append(FIELD_NAME_FOREIGN_COLUMN_NAME).append('=').append((CharSequence) foreignColumnName);
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.isReadOnly()) {
            bufferedWriter.append(FIELD_NAME_READ_ONLY).append('=').append("true");
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.isJavaxEntity()) {
            bufferedWriter.append(FIELD_NAME_JAVAX_ENTITY).append('=').append("true");
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.isForeignCollection()) {
            bufferedWriter.append(FIELD_NAME_FOREIGN_COLLECTION).append('=').append("true");
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.isForeignCollectionEager()) {
            bufferedWriter.append(FIELD_NAME_FOREIGN_COLLECTION_EAGER).append('=').append("true");
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.getForeignCollectionMaxEagerLevel() != 1) {
            bufferedWriter.append(FIELD_NAME_MAX_EAGER_FOREIGN_COLLECTION_LEVEL).append('=').append((CharSequence) Integer.toString(databaseFieldConfig.getForeignCollectionMaxEagerLevel()));
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.getForeignCollectionColumnName() != null) {
            bufferedWriter.append(FIELD_NAME_FOREIGN_COLLECTION_COLUMN_NAME).append('=').append((CharSequence) databaseFieldConfig.getForeignCollectionColumnName());
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.getForeignCollectionOrderColumnName() != null) {
            bufferedWriter.append(FIELD_NAME_FOREIGN_COLLECTION_ORDER_COLUMN_NAME).append('=').append((CharSequence) databaseFieldConfig.getForeignCollectionOrderColumnName());
            bufferedWriter.newLine();
        }
        if (!databaseFieldConfig.isForeignCollectionOrderAscending()) {
            bufferedWriter.append(FIELD_NAME_FOREIGN_COLLECTION_ORDER_ASCENDING).append('=').append((CharSequence) Boolean.toString(databaseFieldConfig.isForeignCollectionOrderAscending()));
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.getForeignCollectionForeignFieldName() != null) {
            bufferedWriter.append(FIELD_NAME_FOREIGN_COLLECTION_FOREIGN_FIELD_NAME).append('=').append((CharSequence) databaseFieldConfig.getForeignCollectionForeignFieldName());
            bufferedWriter.newLine();
        }
        bufferedWriter.append(CONFIG_FILE_END_MARKER);
        bufferedWriter.newLine();
    }
}
