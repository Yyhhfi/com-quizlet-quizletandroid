package com.j256.ormlite.support;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.logger.Logger;
import java.sql.SQLException;

/* loaded from: classes2.dex */
public abstract class BaseConnectionSource implements ConnectionSource {
    private ThreadLocal<NestedConnection> specialConnection = new ThreadLocal<>();

    public static class NestedConnection {
        public final DatabaseConnection connection;
        private int nestedC = 1;

        public NestedConnection(DatabaseConnection databaseConnection) {
            this.connection = databaseConnection;
        }

        public int decrementAndGet() {
            int i = this.nestedC - 1;
            this.nestedC = i;
            return i;
        }

        public void increment() {
            this.nestedC++;
        }
    }

    public boolean clearSpecial(DatabaseConnection databaseConnection, Logger logger) {
        NestedConnection nestedConnection = this.specialConnection.get();
        if (databaseConnection == null) {
            return false;
        }
        if (nestedConnection == null) {
            logger.error("no connection has been saved when clear() called");
            return false;
        }
        DatabaseConnection databaseConnection2 = nestedConnection.connection;
        if (databaseConnection2 != databaseConnection) {
            logger.error("connection saved {} is not the one being cleared {}", databaseConnection2, databaseConnection);
            return false;
        }
        if (nestedConnection.decrementAndGet() != 0) {
            return true;
        }
        this.specialConnection.set(null);
        return true;
    }

    @Override // com.j256.ormlite.support.ConnectionSource
    public abstract /* synthetic */ void clearSpecialConnection(DatabaseConnection databaseConnection);

    @Override // com.j256.ormlite.support.ConnectionSource
    public abstract /* synthetic */ void closeQuietly();

    @Override // com.j256.ormlite.support.ConnectionSource
    public abstract /* synthetic */ DatabaseType getDatabaseType();

    @Override // com.j256.ormlite.support.ConnectionSource
    public abstract /* synthetic */ DatabaseConnection getReadOnlyConnection(String str) throws SQLException;

    @Override // com.j256.ormlite.support.ConnectionSource
    public abstract /* synthetic */ DatabaseConnection getReadWriteConnection(String str) throws SQLException;

    public DatabaseConnection getSavedConnection() {
        NestedConnection nestedConnection = this.specialConnection.get();
        if (nestedConnection == null) {
            return null;
        }
        return nestedConnection.connection;
    }

    @Override // com.j256.ormlite.support.ConnectionSource
    public DatabaseConnection getSpecialConnection(String str) {
        NestedConnection nestedConnection = this.specialConnection.get();
        if (nestedConnection == null) {
            return null;
        }
        return nestedConnection.connection;
    }

    @Override // com.j256.ormlite.support.ConnectionSource
    public abstract /* synthetic */ boolean isOpen(String str);

    public boolean isSavedConnection(DatabaseConnection databaseConnection) {
        NestedConnection nestedConnection = this.specialConnection.get();
        return nestedConnection != null && nestedConnection.connection == databaseConnection;
    }

    public boolean isSingleConnection(DatabaseConnection databaseConnection, DatabaseConnection databaseConnection2) throws SQLException {
        databaseConnection.setAutoCommit(true);
        databaseConnection2.setAutoCommit(true);
        try {
            databaseConnection.setAutoCommit(false);
            return !databaseConnection2.isAutoCommit();
        } finally {
            databaseConnection.setAutoCommit(true);
        }
    }

    @Override // com.j256.ormlite.support.ConnectionSource
    public abstract /* synthetic */ boolean isSingleConnection(String str);

    @Override // com.j256.ormlite.support.ConnectionSource
    public abstract /* synthetic */ void releaseConnection(DatabaseConnection databaseConnection) throws SQLException;

    public boolean saveSpecial(DatabaseConnection databaseConnection) throws SQLException {
        NestedConnection nestedConnection = this.specialConnection.get();
        if (nestedConnection == null) {
            this.specialConnection.set(new NestedConnection(databaseConnection));
            return true;
        }
        if (nestedConnection.connection == databaseConnection) {
            nestedConnection.increment();
            return false;
        }
        throw new SQLException("trying to save connection " + databaseConnection + " but already have saved connection " + nestedConnection.connection);
    }

    @Override // com.j256.ormlite.support.ConnectionSource
    public abstract /* synthetic */ boolean saveSpecialConnection(DatabaseConnection databaseConnection) throws SQLException;
}
