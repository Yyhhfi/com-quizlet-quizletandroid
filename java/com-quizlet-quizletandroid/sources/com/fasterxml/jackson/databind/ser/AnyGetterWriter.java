package com.fasterxml.jackson.databind.ser;

import android.support.v4.media.session.a;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.ser.std.MapSerializer;
import java.io.Serializable;
import java.util.Map;

/* loaded from: classes.dex */
public class AnyGetterWriter extends BeanPropertyWriter implements Serializable {
    protected final AnnotatedMember _accessor;
    protected MapSerializer _mapSerializer;
    protected final BeanProperty _property;
    protected JsonSerializer<Object> _serializer;

    public AnyGetterWriter(BeanPropertyWriter beanPropertyWriter, BeanProperty beanProperty, AnnotatedMember annotatedMember, JsonSerializer<?> jsonSerializer) {
        super(beanPropertyWriter);
        this._accessor = annotatedMember;
        this._property = beanProperty;
        this._serializer = jsonSerializer;
        if (jsonSerializer instanceof MapSerializer) {
            this._mapSerializer = (MapSerializer) jsonSerializer;
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.BeanPropertyWriter
    public void fixAccess(SerializationConfig serializationConfig) throws SecurityException {
        this._accessor.fixAccess(serializationConfig.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
    }

    public void getAndSerialize(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws Exception {
        Object value = this._accessor.getValue(obj);
        if (value == null) {
            return;
        }
        if (!(value instanceof Map)) {
            serializerProvider.reportBadDefinition(this._property.getType(), a.m("Value returned by 'any-getter' ", this._accessor.getName(), "() not java.util.Map but ", value.getClass().getName()));
        }
        MapSerializer mapSerializer = this._mapSerializer;
        if (mapSerializer != null) {
            mapSerializer.serializeWithoutTypeInfo((Map) value, jsonGenerator, serializerProvider);
        } else {
            this._serializer.serialize(value, jsonGenerator, serializerProvider);
        }
    }

    public void resolve(SerializerProvider serializerProvider) throws JsonMappingException {
        JsonSerializer<?> jsonSerializer = this._serializer;
        if (jsonSerializer instanceof ContextualSerializer) {
            JsonSerializer<?> jsonSerializerHandlePrimaryContextualization = serializerProvider.handlePrimaryContextualization(jsonSerializer, this._property);
            this._serializer = jsonSerializerHandlePrimaryContextualization;
            if (jsonSerializerHandlePrimaryContextualization instanceof MapSerializer) {
                this._mapSerializer = (MapSerializer) jsonSerializerHandlePrimaryContextualization;
            }
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.BeanPropertyWriter
    public void serializeAsField(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws Exception {
        getAndSerialize(obj, jsonGenerator, serializerProvider);
    }
}
