package androidx.arch.core.internal;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class d extends e implements Iterator {
    public c a;
    public boolean b = true;
    public final /* synthetic */ f c;

    public d(f fVar) {
        this.c = fVar;
    }

    @Override // androidx.arch.core.internal.e
    public final void a(c cVar) {
        c cVar2 = this.a;
        if (cVar == cVar2) {
            c cVar3 = cVar2.d;
            this.a = cVar3;
            this.b = cVar3 == null;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.b) {
            return this.c.a != null;
        }
        c cVar = this.a;
        return (cVar == null || cVar.c == null) ? false : true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.b) {
            this.b = false;
            this.a = this.c.a;
        } else {
            c cVar = this.a;
            this.a = cVar != null ? cVar.c : null;
        }
        return this.a;
    }
}
