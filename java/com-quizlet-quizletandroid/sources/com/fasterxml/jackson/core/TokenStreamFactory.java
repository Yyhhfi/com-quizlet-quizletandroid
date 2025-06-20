package com.fasterxml.jackson.core;

import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class TokenStreamFactory implements Serializable {
    public abstract int getFactoryFeatures();

    public abstract StreamReadConstraints streamReadConstraints();
}
