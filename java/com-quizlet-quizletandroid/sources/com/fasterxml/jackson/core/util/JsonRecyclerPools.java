package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.util.RecyclerPool;

/* loaded from: classes.dex */
public abstract class JsonRecyclerPools {

    public static class NonRecyclingPool extends RecyclerPool.NonRecyclingPoolBase<BufferRecycler> {
        protected static final NonRecyclingPool GLOBAL = new NonRecyclingPool();

        public Object readResolve() {
            return GLOBAL;
        }

        @Override // com.fasterxml.jackson.core.util.RecyclerPool.NonRecyclingPoolBase
        public BufferRecycler acquirePooled() {
            return new BufferRecycler();
        }
    }

    public static class ThreadLocalPool extends RecyclerPool.ThreadLocalPoolBase<BufferRecycler> {
        protected static final ThreadLocalPool GLOBAL = new ThreadLocalPool();

        private ThreadLocalPool() {
        }

        public Object readResolve() {
            return GLOBAL;
        }

        @Override // com.fasterxml.jackson.core.util.RecyclerPool.ThreadLocalPoolBase
        public BufferRecycler acquirePooled() {
            return BufferRecyclers.getBufferRecycler();
        }
    }

    public static RecyclerPool<BufferRecycler> defaultPool() {
        return threadLocalPool();
    }

    public static RecyclerPool<BufferRecycler> nonRecyclingPool() {
        return NonRecyclingPool.GLOBAL;
    }

    public static RecyclerPool<BufferRecycler> threadLocalPool() {
        return ThreadLocalPool.GLOBAL;
    }
}
