package com.j256.ormlite.dao;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.IOUtils;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.SelectArg;
import com.j256.ormlite.stmt.mapped.MappedPreparedStmt;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes2.dex */
public abstract class BaseForeignCollection<T, ID> implements ForeignCollection<T>, Serializable {
    private static final long serialVersionUID = -5158840898186237589L;
    protected final transient Dao<T, ID> dao;
    private final transient FieldType foreignFieldType;
    private final transient boolean orderAscending;
    private final transient String orderColumn;
    private final transient Object parent;
    private final transient Object parentId;
    private transient PreparedQuery<T> preparedQuery;

    public BaseForeignCollection(Dao<T, ID> dao, Object obj, Object obj2, FieldType fieldType, String str, boolean z) {
        this.dao = dao;
        this.foreignFieldType = fieldType;
        this.parentId = obj2;
        this.orderColumn = str;
        this.orderAscending = z;
        this.parent = obj;
    }

    private boolean addElement(T t) throws SQLException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        T t2;
        if (this.dao == null) {
            return false;
        }
        if (this.parent == null || this.foreignFieldType.getFieldValueIfNotDefault(t) != null) {
            t2 = t;
        } else {
            t2 = t;
            this.foreignFieldType.assignField(this.dao.getConnectionSource(), t2, this.parent, true, null);
        }
        this.dao.create((Dao<T, ID>) t2);
        return true;
    }

    @Override // com.j256.ormlite.dao.ForeignCollection, java.util.Collection
    public boolean add(T t) {
        try {
            return addElement(t);
        } catch (SQLException e) {
            throw new IllegalStateException("Could not create data element in dao", e);
        }
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        Iterator<? extends T> it2 = collection.iterator();
        boolean z = false;
        while (it2.hasNext()) {
            try {
                if (addElement(it2.next())) {
                    z = true;
                }
            } catch (SQLException e) {
                throw new IllegalStateException("Could not create data elements in dao", e);
            }
        }
        return z;
    }

    @Override // java.util.Collection
    public void clear() {
        if (this.dao == null) {
            return;
        }
        CloseableIterator closeableIterator = closeableIterator();
        while (closeableIterator.hasNext()) {
            try {
                closeableIterator.next();
                closeableIterator.remove();
            } finally {
                IOUtils.closeQuietly(closeableIterator);
            }
        }
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public abstract /* synthetic */ void closeLastIterator() throws Exception;

    @Override // com.j256.ormlite.dao.ForeignCollection, com.j256.ormlite.dao.CloseableIterable
    public abstract /* synthetic */ CloseableIterator closeableIterator();

    @Override // com.j256.ormlite.dao.ForeignCollection
    public abstract /* synthetic */ CloseableIterator closeableIterator(int i);

    @Override // com.j256.ormlite.dao.ForeignCollection
    public Dao<T, ?> getDao() {
        return this.dao;
    }

    public PreparedQuery<T> getPreparedQuery() throws SQLException {
        if (this.dao == null) {
            return null;
        }
        if (this.preparedQuery == null) {
            SelectArg selectArg = new SelectArg();
            selectArg.setValue(this.parentId);
            QueryBuilder<T, ID> queryBuilder = this.dao.queryBuilder();
            String str = this.orderColumn;
            if (str != null) {
                queryBuilder.orderBy(str, this.orderAscending);
            }
            PreparedQuery<T> preparedQueryPrepare = queryBuilder.where().eq(this.foreignFieldType.getColumnName(), selectArg).prepare();
            this.preparedQuery = preparedQueryPrepare;
            if (preparedQueryPrepare instanceof MappedPreparedStmt) {
                ((MappedPreparedStmt) preparedQueryPrepare).setParentInformation(this.parent, this.parentId);
            }
        }
        return this.preparedQuery;
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public abstract /* synthetic */ CloseableWrappedIterable getWrappedIterable();

    @Override // com.j256.ormlite.dao.ForeignCollection
    public abstract /* synthetic */ CloseableWrappedIterable getWrappedIterable(int i);

    @Override // com.j256.ormlite.dao.ForeignCollection
    public abstract /* synthetic */ boolean isEager();

    @Override // com.j256.ormlite.dao.ForeignCollection
    public abstract /* synthetic */ CloseableIterator iterator(int i);

    @Override // com.j256.ormlite.dao.ForeignCollection
    public abstract /* synthetic */ CloseableIterator iteratorThrow() throws SQLException;

    @Override // com.j256.ormlite.dao.ForeignCollection
    public abstract /* synthetic */ CloseableIterator iteratorThrow(int i) throws SQLException;

    @Override // com.j256.ormlite.dao.ForeignCollection
    public int refresh(T t) throws SQLException {
        Dao<T, ID> dao = this.dao;
        if (dao == null) {
            return 0;
        }
        return dao.refresh(t);
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public abstract /* synthetic */ int refreshAll() throws SQLException;

    @Override // com.j256.ormlite.dao.ForeignCollection
    public abstract /* synthetic */ int refreshCollection() throws SQLException;

    @Override // java.util.Collection
    public abstract boolean remove(Object obj);

    @Override // java.util.Collection
    public abstract boolean removeAll(Collection<?> collection);

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        if (this.dao == null) {
            return false;
        }
        CloseableIterator closeableIterator = closeableIterator();
        while (closeableIterator.hasNext()) {
            try {
                if (!collection.contains(closeableIterator.next())) {
                    closeableIterator.remove();
                    z = true;
                }
            } finally {
                IOUtils.closeQuietly(closeableIterator);
            }
        }
        return z;
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public int update(T t) throws SQLException {
        Dao<T, ID> dao = this.dao;
        if (dao == null) {
            return 0;
        }
        return dao.update((Dao<T, ID>) t);
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public abstract /* synthetic */ int updateAll() throws SQLException;
}
