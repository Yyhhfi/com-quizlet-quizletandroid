package com.fasterxml.jackson.core.util;

import java.lang.ref.SoftReference;

@Deprecated
/* loaded from: classes.dex */
public abstract class BufferRecyclers {
    private static final ThreadLocalBufferManager _bufferRecyclerTracker;
    protected static final ThreadLocal<SoftReference<BufferRecycler>> _recyclerRef;

    static {
        boolean zEquals;
        try {
            zEquals = "true".equals(System.getProperty("com.fasterxml.jackson.core.util.BufferRecyclers.trackReusableBuffers"));
        } catch (SecurityException unused) {
            zEquals = false;
        }
        _bufferRecyclerTracker = zEquals ? ThreadLocalBufferManager.instance() : null;
        _recyclerRef = new ThreadLocal<>();
    }

    @Deprecated
    public static BufferRecycler getBufferRecycler() {
        ThreadLocal<SoftReference<BufferRecycler>> threadLocal = _recyclerRef;
        SoftReference<BufferRecycler> softReference = threadLocal.get();
        BufferRecycler bufferRecycler = softReference == null ? null : softReference.get();
        if (bufferRecycler == null) {
            bufferRecycler = new BufferRecycler();
            ThreadLocalBufferManager threadLocalBufferManager = _bufferRecyclerTracker;
            threadLocal.set(threadLocalBufferManager != null ? threadLocalBufferManager.wrapAndTrack(bufferRecycler) : new SoftReference<>(bufferRecycler));
        }
        return bufferRecycler;
    }
}
