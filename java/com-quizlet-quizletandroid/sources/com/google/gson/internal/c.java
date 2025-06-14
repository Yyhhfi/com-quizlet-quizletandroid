package com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

/* loaded from: classes2.dex */
public final class c implements WildcardType, Serializable {
    public final Type a;
    public final Type b;

    public c(Type[] typeArr, Type[] typeArr2) {
        d.c(typeArr2.length <= 1);
        d.c(typeArr.length == 1);
        if (typeArr2.length != 1) {
            typeArr[0].getClass();
            d.d(typeArr[0]);
            this.b = null;
            this.a = d.b(typeArr[0]);
            return;
        }
        typeArr2[0].getClass();
        d.d(typeArr2[0]);
        d.c(typeArr[0] == Object.class);
        this.b = d.b(typeArr2[0]);
        this.a = Object.class;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof WildcardType) && d.f(this, (WildcardType) obj);
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getLowerBounds() {
        Type type = this.b;
        return type != null ? new Type[]{type} : d.a;
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getUpperBounds() {
        return new Type[]{this.a};
    }

    public final int hashCode() {
        Type type = this.b;
        return (type != null ? type.hashCode() + 31 : 1) ^ (this.a.hashCode() + 31);
    }

    public final String toString() {
        Type type = this.b;
        if (type != null) {
            return "? super " + d.k(type);
        }
        Type type2 = this.a;
        if (type2 == Object.class) {
            return "?";
        }
        return "? extends " + d.k(type2);
    }
}
