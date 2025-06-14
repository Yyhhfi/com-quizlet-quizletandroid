package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public final class D extends AbstractC3300y {
    public final transient G c;
    public final transient Object[] d;
    public final transient int e = 1;

    public D(G g, Object[] objArr) {
        this.c = g;
        this.d = objArr;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.AbstractC3252s
    public final int a(Object[] objArr, int i) {
        AbstractC3292x c = this.b;
        if (c == null) {
            c = new C(this);
            this.b = c;
        }
        return c.a(objArr, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.c.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        AbstractC3292x c = this.b;
        if (c == null) {
            c = new C(this);
            this.b = c;
        }
        return c.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.e;
    }
}
