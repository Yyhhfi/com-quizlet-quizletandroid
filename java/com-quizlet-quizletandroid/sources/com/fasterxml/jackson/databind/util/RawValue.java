package com.fasterxml.jackson.databind.util;

import android.support.v4.media.session.a;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;

/* loaded from: classes.dex */
public class RawValue implements JsonSerializable {
    protected Object _value;

    public RawValue(String str) {
        this._value = str;
    }

    public void _serialize(JsonGenerator jsonGenerator) throws IOException {
        Object obj = this._value;
        if (obj instanceof SerializableString) {
            jsonGenerator.writeRawValue((SerializableString) obj);
        } else {
            jsonGenerator.writeRawValue(String.valueOf(obj));
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RawValue)) {
            return false;
        }
        Object obj2 = this._value;
        Object obj3 = ((RawValue) obj)._value;
        if (obj2 == obj3) {
            return true;
        }
        return obj2 != null && obj2.equals(obj3);
    }

    public int hashCode() {
        Object obj = this._value;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    @Override // com.fasterxml.jackson.databind.JsonSerializable
    public void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Object obj = this._value;
        if (obj instanceof JsonSerializable) {
            ((JsonSerializable) obj).serialize(jsonGenerator, serializerProvider);
        } else {
            _serialize(jsonGenerator);
        }
    }

    @Override // com.fasterxml.jackson.databind.JsonSerializable
    public void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        Object obj = this._value;
        if (obj instanceof JsonSerializable) {
            ((JsonSerializable) obj).serializeWithType(jsonGenerator, serializerProvider, typeSerializer);
        } else if (obj instanceof SerializableString) {
            serialize(jsonGenerator, serializerProvider);
        }
    }

    public String toString() {
        return a.B("[RawValue of type ", ClassUtil.classNameOf(this._value), "]");
    }
}
