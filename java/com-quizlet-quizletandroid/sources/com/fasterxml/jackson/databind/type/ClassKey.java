package com.fasterxml.jackson.databind.type;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class ClassKey implements Comparable<ClassKey>, Serializable {
    private Class<?> _class;
    private String _className;
    private int _hashCode;

    public ClassKey(Class<?> cls) {
        this._class = cls;
        String name = cls.getName();
        this._className = name;
        this._hashCode = name.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass() == ClassKey.class && ((ClassKey) obj)._class == this._class;
    }

    public int hashCode() {
        return this._hashCode;
    }

    public String toString() {
        return this._className;
    }

    @Override // java.lang.Comparable
    public int compareTo(ClassKey classKey) {
        return this._className.compareTo(classKey._className);
    }
}
