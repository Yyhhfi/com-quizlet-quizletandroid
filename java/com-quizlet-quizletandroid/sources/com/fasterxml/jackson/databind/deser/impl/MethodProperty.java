package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.NullValueProvider;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.Annotations;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class MethodProperty extends SettableBeanProperty {
    protected final AnnotatedMethod _annotated;
    protected final transient Method _setter;
    protected final boolean _skipNulls;

    public MethodProperty(BeanPropertyDefinition beanPropertyDefinition, JavaType javaType, TypeDeserializer typeDeserializer, Annotations annotations, AnnotatedMethod annotatedMethod) {
        super(beanPropertyDefinition, javaType, typeDeserializer, annotations);
        this._annotated = annotatedMethod;
        this._setter = annotatedMethod.getAnnotated();
        this._skipNulls = NullsConstantProvider.isSkipper(this._nullProvider);
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public void deserializeAndSet(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        Object objDeserializeWithType;
        if (!jsonParser.hasToken(JsonToken.VALUE_NULL)) {
            TypeDeserializer typeDeserializer = this._valueTypeDeserializer;
            if (typeDeserializer == null) {
                Object objDeserialize = this._valueDeserializer.deserialize(jsonParser, deserializationContext);
                if (objDeserialize != null) {
                    objDeserializeWithType = objDeserialize;
                } else if (this._skipNulls) {
                    return;
                } else {
                    objDeserializeWithType = this._nullProvider.getNullValue(deserializationContext);
                }
            } else {
                objDeserializeWithType = this._valueDeserializer.deserializeWithType(jsonParser, deserializationContext, typeDeserializer);
            }
        } else if (this._skipNulls) {
            return;
        } else {
            objDeserializeWithType = this._nullProvider.getNullValue(deserializationContext);
        }
        try {
            this._setter.invoke(obj, objDeserializeWithType);
        } catch (Exception e) {
            _throwAsIOE(jsonParser, e, objDeserializeWithType);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0041 A[RETURN] */
    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object deserializeSetAndReturn(com.fasterxml.jackson.core.JsonParser r3, com.fasterxml.jackson.databind.DeserializationContext r4, java.lang.Object r5) throws java.lang.IllegalAccessException, java.io.IOException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            r2 = this;
            com.fasterxml.jackson.core.JsonToken r0 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL
            boolean r0 = r3.hasToken(r0)
            if (r0 == 0) goto L14
            boolean r0 = r2._skipNulls
            if (r0 == 0) goto Ld
            goto L40
        Ld:
            com.fasterxml.jackson.databind.deser.NullValueProvider r0 = r2._nullProvider
            java.lang.Object r4 = r0.getNullValue(r4)
            goto L34
        L14:
            com.fasterxml.jackson.databind.jsontype.TypeDeserializer r0 = r2._valueTypeDeserializer
            if (r0 != 0) goto L2e
            com.fasterxml.jackson.databind.JsonDeserializer<java.lang.Object> r0 = r2._valueDeserializer
            java.lang.Object r0 = r0.deserialize(r3, r4)
            if (r0 != 0) goto L2c
            boolean r0 = r2._skipNulls
            if (r0 == 0) goto L25
            goto L40
        L25:
            com.fasterxml.jackson.databind.deser.NullValueProvider r0 = r2._nullProvider
            java.lang.Object r4 = r0.getNullValue(r4)
            goto L34
        L2c:
            r4 = r0
            goto L34
        L2e:
            com.fasterxml.jackson.databind.JsonDeserializer<java.lang.Object> r1 = r2._valueDeserializer
            java.lang.Object r4 = r1.deserializeWithType(r3, r4, r0)
        L34:
            java.lang.reflect.Method r0 = r2._setter     // Catch: java.lang.Exception -> L42
            java.lang.Object[] r1 = new java.lang.Object[]{r4}     // Catch: java.lang.Exception -> L42
            java.lang.Object r3 = r0.invoke(r5, r1)     // Catch: java.lang.Exception -> L42
            if (r3 != 0) goto L41
        L40:
            return r5
        L41:
            return r3
        L42:
            r5 = move-exception
            r2._throwAsIOE(r3, r5, r4)
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.impl.MethodProperty.deserializeSetAndReturn(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext, java.lang.Object):java.lang.Object");
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public void fixAccess(DeserializationConfig deserializationConfig) throws SecurityException {
        this._annotated.fixAccess(deserializationConfig.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty, com.fasterxml.jackson.databind.BeanProperty
    public AnnotatedMember getMember() {
        return this._annotated;
    }

    public Object readResolve() {
        return new MethodProperty(this, this._annotated.getAnnotated());
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final void set(Object obj, Object obj2) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        if (obj2 == null && this._skipNulls) {
            return;
        }
        try {
            this._setter.invoke(obj, obj2);
        } catch (Exception e) {
            _throwAsIOE(e, obj2);
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public Object setAndReturn(Object obj, Object obj2) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        if (obj2 != null || !this._skipNulls) {
            try {
                Object objInvoke = this._setter.invoke(obj, obj2);
                if (objInvoke != null) {
                    return objInvoke;
                }
            } catch (Exception e) {
                _throwAsIOE(e, obj2);
                return null;
            }
        }
        return obj;
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public SettableBeanProperty withName(PropertyName propertyName) {
        return new MethodProperty(this, propertyName);
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public SettableBeanProperty withNullProvider(NullValueProvider nullValueProvider) {
        return new MethodProperty(this, this._valueDeserializer, nullValueProvider);
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public SettableBeanProperty withValueDeserializer(JsonDeserializer<?> jsonDeserializer) {
        JsonDeserializer<?> jsonDeserializer2 = this._valueDeserializer;
        if (jsonDeserializer2 == jsonDeserializer) {
            return this;
        }
        NullValueProvider nullValueProvider = this._nullProvider;
        if (jsonDeserializer2 == nullValueProvider) {
            nullValueProvider = jsonDeserializer;
        }
        return new MethodProperty(this, jsonDeserializer, nullValueProvider);
    }

    public MethodProperty(MethodProperty methodProperty, JsonDeserializer<?> jsonDeserializer, NullValueProvider nullValueProvider) {
        super(methodProperty, jsonDeserializer, nullValueProvider);
        this._annotated = methodProperty._annotated;
        this._setter = methodProperty._setter;
        this._skipNulls = NullsConstantProvider.isSkipper(nullValueProvider);
    }

    public MethodProperty(MethodProperty methodProperty, PropertyName propertyName) {
        super(methodProperty, propertyName);
        this._annotated = methodProperty._annotated;
        this._setter = methodProperty._setter;
        this._skipNulls = methodProperty._skipNulls;
    }

    public MethodProperty(MethodProperty methodProperty, Method method) {
        super(methodProperty);
        this._annotated = methodProperty._annotated;
        this._setter = method;
        this._skipNulls = methodProperty._skipNulls;
    }
}
