package com.fasterxml.jackson.databind.cfg;

/* loaded from: classes.dex */
public class DefaultCacheProvider implements CacheProvider {
    private static final DefaultCacheProvider DEFAULT = new DefaultCacheProvider(2000, 4000, 200);
    protected final int _maxDeserializerCacheSize;
    protected final int _maxSerializerCacheSize;
    protected final int _maxTypeFactoryCacheSize;

    public DefaultCacheProvider(int i, int i2, int i3) {
        this._maxDeserializerCacheSize = i;
        this._maxSerializerCacheSize = i2;
        this._maxTypeFactoryCacheSize = i3;
    }

    public static CacheProvider defaultInstance() {
        return DEFAULT;
    }
}
