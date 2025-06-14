package io.reactivex.rxjava3.operators;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes3.dex */
public final class g implements d {
    public static final int i = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    public static final Object j = new Object();
    public final AtomicLong a;
    public final int b;
    public long c;
    public final int d;
    public AtomicReferenceArray e;
    public final int f;
    public AtomicReferenceArray g;
    public final AtomicLong h;

    public g(int i2) {
        AtomicLong atomicLong = new AtomicLong();
        this.a = atomicLong;
        this.h = new AtomicLong();
        int iNumberOfLeadingZeros = 1 << (32 - Integer.numberOfLeadingZeros(Math.max(8, i2) - 1));
        int i3 = iNumberOfLeadingZeros - 1;
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(iNumberOfLeadingZeros + 1);
        this.e = atomicReferenceArray;
        this.d = i3;
        this.b = Math.min(iNumberOfLeadingZeros / 4, i);
        this.g = atomicReferenceArray;
        this.f = i3;
        this.c = iNumberOfLeadingZeros - 2;
        atomicLong.lazySet(0L);
    }

    @Override // io.reactivex.rxjava3.operators.e
    public final void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // io.reactivex.rxjava3.operators.e
    public final boolean isEmpty() {
        return this.a.get() == this.h.get();
    }

    @Override // io.reactivex.rxjava3.operators.e
    public final boolean offer(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray atomicReferenceArray = this.e;
        AtomicLong atomicLong = this.a;
        long j2 = atomicLong.get();
        int i2 = this.d;
        int i3 = ((int) j2) & i2;
        if (j2 < this.c) {
            atomicReferenceArray.lazySet(i3, obj);
            atomicLong.lazySet(j2 + 1);
            return true;
        }
        long j3 = this.b + j2;
        if (atomicReferenceArray.get(((int) j3) & i2) == null) {
            this.c = j3 - 1;
            atomicReferenceArray.lazySet(i3, obj);
            atomicLong.lazySet(j2 + 1);
            return true;
        }
        long j4 = j2 + 1;
        if (atomicReferenceArray.get(((int) j4) & i2) == null) {
            atomicReferenceArray.lazySet(i3, obj);
            atomicLong.lazySet(j4);
            return true;
        }
        AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(atomicReferenceArray.length());
        this.e = atomicReferenceArray2;
        this.c = (j2 + i2) - 1;
        atomicReferenceArray2.lazySet(i3, obj);
        atomicReferenceArray.lazySet(atomicReferenceArray.length() - 1, atomicReferenceArray2);
        atomicReferenceArray.lazySet(i3, j);
        atomicLong.lazySet(j4);
        return true;
    }

    @Override // io.reactivex.rxjava3.operators.e
    public final Object poll() {
        AtomicReferenceArray atomicReferenceArray = this.g;
        AtomicLong atomicLong = this.h;
        long j2 = atomicLong.get();
        int i2 = this.f;
        int i3 = ((int) j2) & i2;
        Object obj = atomicReferenceArray.get(i3);
        boolean z = obj == j;
        if (obj != null && !z) {
            atomicReferenceArray.lazySet(i3, null);
            atomicLong.lazySet(j2 + 1);
            return obj;
        }
        if (!z) {
            return null;
        }
        int i4 = i2 + 1;
        AtomicReferenceArray atomicReferenceArray2 = (AtomicReferenceArray) atomicReferenceArray.get(i4);
        atomicReferenceArray.lazySet(i4, null);
        this.g = atomicReferenceArray2;
        Object obj2 = atomicReferenceArray2.get(i3);
        if (obj2 != null) {
            atomicReferenceArray2.lazySet(i3, null);
            atomicLong.lazySet(j2 + 1);
        }
        return obj2;
    }
}
