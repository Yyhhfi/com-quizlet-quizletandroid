package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import java.io.IOException;

/* loaded from: classes.dex */
public class ValueInjector extends BeanProperty.Std {
    protected final Object _valueId;

    public ValueInjector(PropertyName propertyName, JavaType javaType, AnnotatedMember annotatedMember, Object obj) {
        super(propertyName, javaType, null, annotatedMember, PropertyMetadata.STD_OPTIONAL);
        this._valueId = obj;
    }

    public Object findValue(DeserializationContext deserializationContext, Object obj) throws JsonMappingException {
        return deserializationContext.findInjectableValue(this._valueId, this, obj);
    }

    public void inject(DeserializationContext deserializationContext, Object obj) throws UnsupportedOperationException, IOException, IllegalArgumentException {
        this._member.setValue(obj, findValue(deserializationContext, obj));
    }
}
