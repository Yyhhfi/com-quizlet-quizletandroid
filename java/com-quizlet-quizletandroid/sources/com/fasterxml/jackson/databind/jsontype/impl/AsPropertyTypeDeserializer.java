package com.fasterxml.jackson.databind.jsontype.impl;

import android.support.v4.media.session.a;
import androidx.camera.camera2.internal.AbstractC0147y;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.util.JsonParserSequence;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.IOException;

/* loaded from: classes.dex */
public class AsPropertyTypeDeserializer extends AsArrayTypeDeserializer {
    protected final JsonTypeInfo.As _inclusion;
    protected final String _msgForMissingId;
    protected final boolean _strictTypeIdHandling;

    public AsPropertyTypeDeserializer(AsPropertyTypeDeserializer asPropertyTypeDeserializer, BeanProperty beanProperty) {
        super(asPropertyTypeDeserializer, beanProperty);
        BeanProperty beanProperty2 = this._property;
        this._msgForMissingId = beanProperty2 == null ? a.B("missing type id property '", this._typePropertyName, "'") : AbstractC0147y.e("missing type id property '", this._typePropertyName, "' (for POJO property '", beanProperty2.getName(), "')");
        this._inclusion = asPropertyTypeDeserializer._inclusion;
        this._strictTypeIdHandling = asPropertyTypeDeserializer._strictTypeIdHandling;
    }

    public Object _deserializeTypedForId(JsonParser jsonParser, DeserializationContext deserializationContext, TokenBuffer tokenBuffer, String str) throws IOException {
        JsonDeserializer<Object> jsonDeserializer_findDeserializer = _findDeserializer(deserializationContext, str);
        if (this._typeIdVisible) {
            if (tokenBuffer == null) {
                tokenBuffer = deserializationContext.bufferForInputBuffering(jsonParser);
            }
            tokenBuffer.writeFieldName(jsonParser.currentName());
            tokenBuffer.writeString(str);
        }
        if (tokenBuffer != null) {
            jsonParser.clearCurrentToken();
            jsonParser = JsonParserSequence.createFlattened(false, tokenBuffer.asParser(jsonParser), jsonParser);
        }
        if (jsonParser.currentToken() != JsonToken.END_OBJECT) {
            jsonParser.nextToken();
        }
        return jsonDeserializer_findDeserializer.deserialize(jsonParser, deserializationContext);
    }

    public Object _deserializeTypedUsingDefaultImpl(JsonParser jsonParser, DeserializationContext deserializationContext, TokenBuffer tokenBuffer, String str) throws IOException {
        if (!hasDefaultImpl()) {
            Object objDeserializeIfNatural = TypeDeserializer.deserializeIfNatural(jsonParser, deserializationContext, this._baseType);
            if (objDeserializeIfNatural != null) {
                return objDeserializeIfNatural;
            }
            if (jsonParser.isExpectedStartArrayToken()) {
                return super.deserializeTypedFromAny(jsonParser, deserializationContext);
            }
            if (jsonParser.hasToken(JsonToken.VALUE_STRING) && deserializationContext.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT) && jsonParser.getText().trim().isEmpty()) {
                return null;
            }
        }
        JsonDeserializer<Object> jsonDeserializer_findDefaultImplDeserializer = _findDefaultImplDeserializer(deserializationContext);
        if (jsonDeserializer_findDefaultImplDeserializer == null) {
            JavaType javaType_handleMissingTypeId = this._strictTypeIdHandling ? _handleMissingTypeId(deserializationContext, str) : this._baseType;
            if (javaType_handleMissingTypeId == null) {
                return null;
            }
            jsonDeserializer_findDefaultImplDeserializer = deserializationContext.findContextualValueDeserializer(javaType_handleMissingTypeId, this._property);
        }
        if (tokenBuffer != null) {
            tokenBuffer.writeEndObject();
            jsonParser = tokenBuffer.asParser(jsonParser);
            jsonParser.nextToken();
        }
        return jsonDeserializer_findDefaultImplDeserializer.deserialize(jsonParser, deserializationContext);
    }

    @Override // com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeDeserializer, com.fasterxml.jackson.databind.jsontype.TypeDeserializer
    public Object deserializeTypedFromAny(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return jsonParser.hasToken(JsonToken.START_ARRAY) ? super.deserializeTypedFromArray(jsonParser, deserializationContext) : deserializeTypedFromObject(jsonParser, deserializationContext);
    }

    @Override // com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeDeserializer, com.fasterxml.jackson.databind.jsontype.TypeDeserializer
    public Object deserializeTypedFromObject(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String valueAsString;
        Object typeId;
        if (jsonParser.canReadTypeId() && (typeId = jsonParser.getTypeId()) != null) {
            return _deserializeWithNativeTypeId(jsonParser, deserializationContext, typeId);
        }
        JsonToken jsonTokenCurrentToken = jsonParser.currentToken();
        TokenBuffer tokenBufferBufferForInputBuffering = null;
        if (jsonTokenCurrentToken == JsonToken.START_OBJECT) {
            jsonTokenCurrentToken = jsonParser.nextToken();
        } else if (jsonTokenCurrentToken != JsonToken.FIELD_NAME) {
            return _deserializeTypedUsingDefaultImpl(jsonParser, deserializationContext, null, this._msgForMissingId);
        }
        boolean zIsEnabled = deserializationContext.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
        while (jsonTokenCurrentToken == JsonToken.FIELD_NAME) {
            String strCurrentName = jsonParser.currentName();
            jsonParser.nextToken();
            if ((strCurrentName.equals(this._typePropertyName) || (zIsEnabled && strCurrentName.equalsIgnoreCase(this._typePropertyName))) && (valueAsString = jsonParser.getValueAsString()) != null) {
                return _deserializeTypedForId(jsonParser, deserializationContext, tokenBufferBufferForInputBuffering, valueAsString);
            }
            if (tokenBufferBufferForInputBuffering == null) {
                tokenBufferBufferForInputBuffering = deserializationContext.bufferForInputBuffering(jsonParser);
            }
            tokenBufferBufferForInputBuffering.writeFieldName(strCurrentName);
            tokenBufferBufferForInputBuffering.copyCurrentStructure(jsonParser);
            jsonTokenCurrentToken = jsonParser.nextToken();
        }
        return _deserializeTypedUsingDefaultImpl(jsonParser, deserializationContext, tokenBufferBufferForInputBuffering, this._msgForMissingId);
    }

    @Override // com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeDeserializer, com.fasterxml.jackson.databind.jsontype.TypeDeserializer
    public TypeDeserializer forProperty(BeanProperty beanProperty) {
        return beanProperty == this._property ? this : new AsPropertyTypeDeserializer(this, beanProperty);
    }

    @Override // com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeDeserializer, com.fasterxml.jackson.databind.jsontype.TypeDeserializer
    public JsonTypeInfo.As getTypeInclusion() {
        return this._inclusion;
    }

    public AsPropertyTypeDeserializer(JavaType javaType, TypeIdResolver typeIdResolver, String str, boolean z, JavaType javaType2, JsonTypeInfo.As as, boolean z2) {
        String strE;
        super(javaType, typeIdResolver, str, z, javaType2);
        BeanProperty beanProperty = this._property;
        if (beanProperty == null) {
            strE = a.B("missing type id property '", this._typePropertyName, "'");
        } else {
            strE = AbstractC0147y.e("missing type id property '", this._typePropertyName, "' (for POJO property '", beanProperty.getName(), "')");
        }
        this._msgForMissingId = strE;
        this._inclusion = as;
        this._strictTypeIdHandling = z2;
    }
}
