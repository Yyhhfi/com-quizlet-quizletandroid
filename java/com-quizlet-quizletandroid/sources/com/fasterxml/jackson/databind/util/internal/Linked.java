package com.fasterxml.jackson.databind.util.internal;

import com.fasterxml.jackson.databind.util.internal.Linked;

/* loaded from: classes.dex */
interface Linked<T extends Linked<T>> {
    T getNext();

    T getPrevious();

    void setNext(T t);

    void setPrevious(T t);
}
