package com.j256.ormlite.dao;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class LruObjectCache implements ObjectCache {
    private final int capacity;
    private final ConcurrentHashMap<Class<?>, Map<Object, Object>> classMaps = new ConcurrentHashMap<>();

    public static class LimitedLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
        private static final long serialVersionUID = -4566528080395573236L;
        private final int capacity;

        public LimitedLinkedHashMap(int i) {
            super(i, 0.75f, true);
            this.capacity = i;
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<K, V> entry) {
            return size() > this.capacity;
        }
    }

    public LruObjectCache(int i) {
        this.capacity = i;
    }

    private Map<Object, Object> getMapForClass(Class<?> cls) {
        Map<Object, Object> map = this.classMaps.get(cls);
        if (map == null) {
            return null;
        }
        return map;
    }

    @Override // com.j256.ormlite.dao.ObjectCache
    public <T> void clear(Class<T> cls) {
        Map<Object, Object> mapForClass = getMapForClass(cls);
        if (mapForClass != null) {
            mapForClass.clear();
        }
    }

    @Override // com.j256.ormlite.dao.ObjectCache
    public void clearAll() {
        Iterator<Map<Object, Object>> it2 = this.classMaps.values().iterator();
        while (it2.hasNext()) {
            it2.next().clear();
        }
    }

    @Override // com.j256.ormlite.dao.ObjectCache
    public <T, ID> T get(Class<T> cls, ID id) {
        Map<Object, Object> mapForClass = getMapForClass(cls);
        if (mapForClass == null) {
            return null;
        }
        return (T) mapForClass.get(id);
    }

    @Override // com.j256.ormlite.dao.ObjectCache
    public <T, ID> void put(Class<T> cls, ID id, T t) {
        Map<Object, Object> mapForClass = getMapForClass(cls);
        if (mapForClass != null) {
            mapForClass.put(id, t);
        }
    }

    @Override // com.j256.ormlite.dao.ObjectCache
    public synchronized <T> void registerClass(Class<T> cls) {
        if (this.classMaps.get(cls) == null) {
            this.classMaps.put(cls, Collections.synchronizedMap(new LimitedLinkedHashMap(this.capacity)));
        }
    }

    @Override // com.j256.ormlite.dao.ObjectCache
    public <T, ID> void remove(Class<T> cls, ID id) {
        Map<Object, Object> mapForClass = getMapForClass(cls);
        if (mapForClass != null) {
            mapForClass.remove(id);
        }
    }

    @Override // com.j256.ormlite.dao.ObjectCache
    public <T> int size(Class<T> cls) {
        Map<Object, Object> mapForClass = getMapForClass(cls);
        if (mapForClass == null) {
            return 0;
        }
        return mapForClass.size();
    }

    @Override // com.j256.ormlite.dao.ObjectCache
    public int sizeAll() {
        Iterator<Map<Object, Object>> it2 = this.classMaps.values().iterator();
        int size = 0;
        while (it2.hasNext()) {
            size += it2.next().size();
        }
        return size;
    }

    @Override // com.j256.ormlite.dao.ObjectCache
    public <T, ID> T updateId(Class<T> cls, ID id, ID id2) {
        T t;
        Map<Object, Object> mapForClass = getMapForClass(cls);
        if (mapForClass == null || (t = (T) mapForClass.remove(id)) == null) {
            return null;
        }
        mapForClass.put(id2, t);
        return t;
    }
}
