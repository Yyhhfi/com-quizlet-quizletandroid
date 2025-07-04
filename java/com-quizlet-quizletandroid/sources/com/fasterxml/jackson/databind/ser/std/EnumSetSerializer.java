package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;
import java.util.EnumSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class EnumSetSerializer extends AsArraySerializerBase<EnumSet<? extends Enum<?>>> {
    public EnumSetSerializer(JavaType javaType) {
        super((Class<?>) EnumSet.class, javaType, true, (TypeSerializer) null, (JsonSerializer<Object>) null);
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public EnumSetSerializer _withValueTypeSerializer(TypeSerializer typeSerializer) {
        return this;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase
    public /* bridge */ /* synthetic */ AsArraySerializerBase<EnumSet<? extends Enum<?>>> withResolved(BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer jsonSerializer, Boolean bool) {
        return withResolved2(beanProperty, typeSerializer, (JsonSerializer<?>) jsonSerializer, bool);
    }

    public EnumSetSerializer(EnumSetSerializer enumSetSerializer, BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, Boolean bool) {
        super(enumSetSerializer, beanProperty, typeSerializer, jsonSerializer, bool);
    }

    @Override // com.fasterxml.jackson.databind.JsonSerializer
    public boolean isEmpty(SerializerProvider serializerProvider, EnumSet<? extends Enum<?>> enumSet) {
        return enumSet.isEmpty();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, com.fasterxml.jackson.databind.JsonSerializer
    public void serialize(EnumSet<? extends Enum<?>> enumSet, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        int size = enumSet.size();
        if (size == 1 && ((this._unwrapSingle == null && serializerProvider.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
            serializeContents(enumSet, jsonGenerator, serializerProvider);
            return;
        }
        jsonGenerator.writeStartArray(enumSet, size);
        serializeContents(enumSet, jsonGenerator, serializerProvider);
        jsonGenerator.writeEndArray();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase
    public void serializeContents(EnumSet<? extends Enum<?>> enumSet, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.assignCurrentValue(enumSet);
        JsonSerializer<Object> jsonSerializerFindContentValueSerializer = this._elementSerializer;
        Iterator<? extends Enum<?>> it2 = enumSet.iterator();
        while (it2.hasNext()) {
            Enum<?> next = it2.next();
            if (jsonSerializerFindContentValueSerializer == null) {
                jsonSerializerFindContentValueSerializer = serializerProvider.findContentValueSerializer(next.getDeclaringClass(), this._property);
            }
            jsonSerializerFindContentValueSerializer.serialize(next, jsonGenerator, serializerProvider);
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase
    /* renamed from: withResolved, reason: avoid collision after fix types in other method */
    public AsArraySerializerBase<EnumSet<? extends Enum<?>>> withResolved2(BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, Boolean bool) {
        return new EnumSetSerializer(this, beanProperty, typeSerializer, jsonSerializer, bool);
    }
}
