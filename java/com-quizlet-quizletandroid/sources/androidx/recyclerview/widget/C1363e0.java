package androidx.recyclerview.widget;

import android.database.Observable;

/* renamed from: androidx.recyclerview.widget.e0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1363e0 extends Observable {
    public final boolean a() {
        return !((Observable) this).mObservers.isEmpty();
    }

    public final void b() {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((AbstractC1365f0) ((Observable) this).mObservers.get(size)).a();
        }
    }

    public final void c(int i, int i2) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((AbstractC1365f0) ((Observable) this).mObservers.get(size)).e(i, i2);
        }
    }

    public final void d(int i, int i2, Object obj) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((AbstractC1365f0) ((Observable) this).mObservers.get(size)).c(i, i2, obj);
        }
    }

    public final void e(int i, int i2) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((AbstractC1365f0) ((Observable) this).mObservers.get(size)).d(i, i2);
        }
    }

    public final void f(int i, int i2) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((AbstractC1365f0) ((Observable) this).mObservers.get(size)).f(i, i2);
        }
    }

    public final void g() {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((AbstractC1365f0) ((Observable) this).mObservers.get(size)).g();
        }
    }
}
