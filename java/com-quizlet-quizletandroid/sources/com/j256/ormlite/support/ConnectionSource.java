package com.j256.ormlite.support;

import com.j256.ormlite.db.DatabaseType;
import java.sql.SQLException;

/* loaded from: classes2.dex */
public interface ConnectionSource extends AutoCloseable {
    void clearSpecialConnection(DatabaseConnection databaseConnection);

    void closeQuietly();

    DatabaseType getDatabaseType();

    DatabaseConnection getReadOnlyConnection(String str) throws SQLException;

    DatabaseConnection getReadWriteConnection(String str) throws SQLException;

    DatabaseConnection getSpecialConnection(String str);

    boolean isOpen(String str);

    boolean isSingleConnection(String str);

    void releaseConnection(DatabaseConnection databaseConnection) throws SQLException;

    boolean saveSpecialConnection(DatabaseConnection databaseConnection) throws SQLException;
}
