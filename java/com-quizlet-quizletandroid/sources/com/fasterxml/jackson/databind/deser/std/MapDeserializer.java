package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.StreamReadCapability;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.NullValueProvider;
import com.fasterxml.jackson.databind.deser.ResolvableDeserializer;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.UnresolvedForwardReference;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator;
import com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer;
import com.fasterxml.jackson.databind.deser.impl.ReadableObjectId;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.IgnorePropertiesUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@JacksonStdImpl
/* loaded from: classes.dex */
public class MapDeserializer extends ContainerDeserializerBase<Map<Object, Object>> implements ContextualDeserializer, ResolvableDeserializer {
    protected boolean _checkDupSquash;
    protected JsonDeserializer<Object> _delegateDeserializer;
    protected final boolean _hasDefaultCreator;
    protected Set<String> _ignorableProperties;
    protected Set<String> _includableProperties;
    protected IgnorePropertiesUtil.Checker _inclusionChecker;
    protected final KeyDeserializer _keyDeserializer;
    protected PropertyBasedCreator _propertyBasedCreator;
    protected boolean _standardStringKey;
    protected final JsonDeserializer<Object> _valueDeserializer;
    protected final ValueInstantiator _valueInstantiator;
    protected final TypeDeserializer _valueTypeDeserializer;

    public static class MapReferring extends ReadableObjectId.Referring {
        private final MapReferringAccumulator _parent;
        public final Object key;
        public final Map<Object, Object> next;

        public MapReferring(MapReferringAccumulator mapReferringAccumulator, UnresolvedForwardReference unresolvedForwardReference, Class<?> cls, Object obj) {
            super(unresolvedForwardReference, cls);
            this.next = new LinkedHashMap();
            this._parent = mapReferringAccumulator;
            this.key = obj;
        }
    }

    public static final class MapReferringAccumulator {
        private List<MapReferring> _accumulator = new ArrayList();
        private Map<Object, Object> _result;
        private final Class<?> _valueType;

        public MapReferringAccumulator(Class<?> cls, Map<Object, Object> map) {
            this._valueType = cls;
            this._result = map;
        }

        public ReadableObjectId.Referring handleUnresolvedReference(UnresolvedForwardReference unresolvedForwardReference, Object obj) {
            MapReferring mapReferring = new MapReferring(this, unresolvedForwardReference, this._valueType, obj);
            this._accumulator.add(mapReferring);
            return mapReferring;
        }

        public void put(Object obj, Object obj2) {
            if (this._accumulator.isEmpty()) {
                this._result.put(obj, obj2);
            } else {
                this._accumulator.get(r0.size() - 1).next.put(obj, obj2);
            }
        }
    }

    public MapDeserializer(JavaType javaType, ValueInstantiator valueInstantiator, KeyDeserializer keyDeserializer, JsonDeserializer<Object> jsonDeserializer, TypeDeserializer typeDeserializer) {
        super(javaType, (NullValueProvider) null, (Boolean) null);
        this._keyDeserializer = keyDeserializer;
        this._valueDeserializer = jsonDeserializer;
        this._valueTypeDeserializer = typeDeserializer;
        this._valueInstantiator = valueInstantiator;
        this._hasDefaultCreator = valueInstantiator.canCreateUsingDefault();
        this._delegateDeserializer = null;
        this._propertyBasedCreator = null;
        this._standardStringKey = _isStdKeyDeser(javaType, keyDeserializer);
        this._inclusionChecker = null;
        this._checkDupSquash = javaType.getContentType().hasRawClass(Object.class);
    }

    private void handleUnresolvedReference(DeserializationContext deserializationContext, MapReferringAccumulator mapReferringAccumulator, Object obj, UnresolvedForwardReference unresolvedForwardReference) throws JsonMappingException {
        if (mapReferringAccumulator == null) {
            deserializationContext.reportInputMismatch(this, "Unresolved forward reference but no identity info: " + unresolvedForwardReference, new Object[0]);
        }
        unresolvedForwardReference.getRoid().appendReferring(mapReferringAccumulator.handleUnresolvedReference(unresolvedForwardReference, obj));
    }

    public Map<Object, Object> _deserializeUsingCreator(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Object objDeserialize;
        PropertyBasedCreator propertyBasedCreator = this._propertyBasedCreator;
        PropertyValueBuffer propertyValueBufferStartBuilding = propertyBasedCreator.startBuilding(jsonParser, deserializationContext, null);
        JsonDeserializer<Object> jsonDeserializer = this._valueDeserializer;
        TypeDeserializer typeDeserializer = this._valueTypeDeserializer;
        String strNextFieldName = jsonParser.isExpectedStartObjectToken() ? jsonParser.nextFieldName() : jsonParser.hasToken(JsonToken.FIELD_NAME) ? jsonParser.currentName() : null;
        while (strNextFieldName != null) {
            JsonToken jsonTokenNextToken = jsonParser.nextToken();
            IgnorePropertiesUtil.Checker checker = this._inclusionChecker;
            if (checker == null || !checker.shouldIgnore(strNextFieldName)) {
                SettableBeanProperty settableBeanPropertyFindCreatorProperty = propertyBasedCreator.findCreatorProperty(strNextFieldName);
                if (settableBeanPropertyFindCreatorProperty == null) {
                    Object objDeserializeKey = this._keyDeserializer.deserializeKey(strNextFieldName, deserializationContext);
                    try {
                        if (jsonTokenNextToken != JsonToken.VALUE_NULL) {
                            objDeserialize = typeDeserializer == null ? jsonDeserializer.deserialize(jsonParser, deserializationContext) : jsonDeserializer.deserializeWithType(jsonParser, deserializationContext, typeDeserializer);
                        } else if (!this._skipNullValues) {
                            objDeserialize = this._nullProvider.getNullValue(deserializationContext);
                        }
                        propertyValueBufferStartBuilding.bufferMapProperty(objDeserializeKey, objDeserialize);
                    } catch (Exception e) {
                        wrapAndThrow(deserializationContext, e, this._containerType.getRawClass(), strNextFieldName);
                        return null;
                    }
                } else if (propertyValueBufferStartBuilding.assignParameter(settableBeanPropertyFindCreatorProperty, settableBeanPropertyFindCreatorProperty.deserialize(jsonParser, deserializationContext))) {
                    jsonParser.nextToken();
                    try {
                        return _readAndBind(jsonParser, deserializationContext, (Map) propertyBasedCreator.build(deserializationContext, propertyValueBufferStartBuilding));
                    } catch (Exception e2) {
                        return (Map) wrapAndThrow(deserializationContext, e2, this._containerType.getRawClass(), strNextFieldName);
                    }
                }
            } else {
                jsonParser.skipChildren();
            }
            strNextFieldName = jsonParser.nextFieldName();
        }
        try {
            return (Map) propertyBasedCreator.build(deserializationContext, propertyValueBufferStartBuilding);
        } catch (Exception e3) {
            wrapAndThrow(deserializationContext, e3, this._containerType.getRawClass(), strNextFieldName);
            return null;
        }
    }

    public final boolean _isStdKeyDeser(JavaType javaType, KeyDeserializer keyDeserializer) {
        JavaType keyType;
        if (keyDeserializer == null || (keyType = javaType.getKeyType()) == null) {
            return true;
        }
        Class<?> rawClass = keyType.getRawClass();
        return (rawClass == String.class || rawClass == Object.class) && isDefaultKeyDeserializer(keyDeserializer);
    }

    public final Map<Object, Object> _readAndBind(JsonParser jsonParser, DeserializationContext deserializationContext, Map<Object, Object> map) throws IOException {
        String strCurrentName;
        Object objDeserialize;
        KeyDeserializer keyDeserializer = this._keyDeserializer;
        JsonDeserializer<Object> jsonDeserializer = this._valueDeserializer;
        TypeDeserializer typeDeserializer = this._valueTypeDeserializer;
        boolean z = jsonDeserializer.getObjectIdReader() != null;
        MapReferringAccumulator mapReferringAccumulator = z ? new MapReferringAccumulator(this._containerType.getContentType().getRawClass(), map) : null;
        if (jsonParser.isExpectedStartObjectToken()) {
            strCurrentName = jsonParser.nextFieldName();
        } else {
            JsonToken jsonTokenCurrentToken = jsonParser.currentToken();
            JsonToken jsonToken = JsonToken.FIELD_NAME;
            if (jsonTokenCurrentToken != jsonToken) {
                if (jsonTokenCurrentToken != JsonToken.END_OBJECT) {
                    deserializationContext.reportWrongTokenException(this, jsonToken, (String) null, new Object[0]);
                }
                return map;
            }
            strCurrentName = jsonParser.currentName();
        }
        String strNextFieldName = strCurrentName;
        while (strNextFieldName != null) {
            Object objDeserializeKey = keyDeserializer.deserializeKey(strNextFieldName, deserializationContext);
            JsonToken jsonTokenNextToken = jsonParser.nextToken();
            IgnorePropertiesUtil.Checker checker = this._inclusionChecker;
            if (checker == null || !checker.shouldIgnore(strNextFieldName)) {
                try {
                    if (jsonTokenNextToken != JsonToken.VALUE_NULL) {
                        objDeserialize = typeDeserializer == null ? jsonDeserializer.deserialize(jsonParser, deserializationContext) : jsonDeserializer.deserializeWithType(jsonParser, deserializationContext, typeDeserializer);
                    } else if (!this._skipNullValues) {
                        objDeserialize = this._nullProvider.getNullValue(deserializationContext);
                    }
                    Object obj = objDeserialize;
                    if (z) {
                        mapReferringAccumulator.put(objDeserializeKey, obj);
                    } else {
                        Object objPut = map.put(objDeserializeKey, obj);
                        if (objPut != null) {
                            _squashDups(deserializationContext, map, objDeserializeKey, objPut, obj);
                        }
                    }
                } catch (UnresolvedForwardReference e) {
                    handleUnresolvedReference(deserializationContext, mapReferringAccumulator, objDeserializeKey, e);
                } catch (Exception e2) {
                    wrapAndThrow(deserializationContext, e2, map, strNextFieldName);
                }
            } else {
                jsonParser.skipChildren();
            }
            strNextFieldName = jsonParser.nextFieldName();
        }
        return map;
    }

    public final Map<Object, Object> _readAndBindStringKeyMap(JsonParser jsonParser, DeserializationContext deserializationContext, Map<Object, Object> map) throws IOException {
        String strCurrentName;
        DeserializationContext deserializationContext2;
        Map<Object, Object> map2;
        Object objDeserialize;
        Object obj;
        JsonDeserializer<Object> jsonDeserializer = this._valueDeserializer;
        TypeDeserializer typeDeserializer = this._valueTypeDeserializer;
        boolean z = jsonDeserializer.getObjectIdReader() != null;
        MapReferringAccumulator mapReferringAccumulator = z ? new MapReferringAccumulator(this._containerType.getContentType().getRawClass(), map) : null;
        if (!jsonParser.isExpectedStartObjectToken()) {
            JsonToken jsonTokenCurrentToken = jsonParser.currentToken();
            if (jsonTokenCurrentToken != JsonToken.END_OBJECT) {
                JsonToken jsonToken = JsonToken.FIELD_NAME;
                if (jsonTokenCurrentToken != jsonToken) {
                    deserializationContext.reportWrongTokenException(this, jsonToken, (String) null, new Object[0]);
                }
                strCurrentName = jsonParser.currentName();
            }
            return map;
        }
        strCurrentName = jsonParser.nextFieldName();
        String strNextFieldName = strCurrentName;
        while (strNextFieldName != null) {
            JsonToken jsonTokenNextToken = jsonParser.nextToken();
            IgnorePropertiesUtil.Checker checker = this._inclusionChecker;
            if (checker == null || !checker.shouldIgnore(strNextFieldName)) {
                try {
                    if (jsonTokenNextToken != JsonToken.VALUE_NULL) {
                        objDeserialize = typeDeserializer == null ? jsonDeserializer.deserialize(jsonParser, deserializationContext) : jsonDeserializer.deserializeWithType(jsonParser, deserializationContext, typeDeserializer);
                    } else if (!this._skipNullValues) {
                        objDeserialize = this._nullProvider.getNullValue(deserializationContext);
                    }
                    obj = objDeserialize;
                } catch (UnresolvedForwardReference e) {
                    e = e;
                    deserializationContext2 = deserializationContext;
                    map2 = map;
                } catch (Exception e2) {
                    e = e2;
                    deserializationContext2 = deserializationContext;
                    map2 = map;
                }
                if (z) {
                    mapReferringAccumulator.put(strNextFieldName, obj);
                } else {
                    Object objPut = map.put(strNextFieldName, obj);
                    if (objPut != null) {
                        deserializationContext2 = deserializationContext;
                        map2 = map;
                        try {
                            _squashDups(deserializationContext2, map2, strNextFieldName, objPut, obj);
                        } catch (UnresolvedForwardReference e3) {
                            e = e3;
                            handleUnresolvedReference(deserializationContext2, mapReferringAccumulator, strNextFieldName, e);
                            strNextFieldName = jsonParser.nextFieldName();
                            deserializationContext = deserializationContext2;
                            map = map2;
                        } catch (Exception e4) {
                            e = e4;
                            wrapAndThrow(deserializationContext2, e, map2, strNextFieldName);
                            strNextFieldName = jsonParser.nextFieldName();
                            deserializationContext = deserializationContext2;
                            map = map2;
                        }
                    }
                    strNextFieldName = jsonParser.nextFieldName();
                    deserializationContext = deserializationContext2;
                    map = map2;
                }
            } else {
                jsonParser.skipChildren();
            }
            deserializationContext2 = deserializationContext;
            map2 = map;
            strNextFieldName = jsonParser.nextFieldName();
            deserializationContext = deserializationContext2;
            map = map2;
        }
        return map;
    }

    public final void _readAndUpdate(JsonParser jsonParser, DeserializationContext deserializationContext, Map<Object, Object> map) throws IOException {
        String strCurrentName;
        KeyDeserializer keyDeserializer = this._keyDeserializer;
        JsonDeserializer<Object> jsonDeserializer = this._valueDeserializer;
        TypeDeserializer typeDeserializer = this._valueTypeDeserializer;
        if (jsonParser.isExpectedStartObjectToken()) {
            strCurrentName = jsonParser.nextFieldName();
        } else {
            JsonToken jsonTokenCurrentToken = jsonParser.currentToken();
            if (jsonTokenCurrentToken == JsonToken.END_OBJECT) {
                return;
            }
            JsonToken jsonToken = JsonToken.FIELD_NAME;
            if (jsonTokenCurrentToken != jsonToken) {
                deserializationContext.reportWrongTokenException(this, jsonToken, (String) null, new Object[0]);
            }
            strCurrentName = jsonParser.currentName();
        }
        while (strCurrentName != null) {
            Object objDeserializeKey = keyDeserializer.deserializeKey(strCurrentName, deserializationContext);
            JsonToken jsonTokenNextToken = jsonParser.nextToken();
            IgnorePropertiesUtil.Checker checker = this._inclusionChecker;
            if (checker == null || !checker.shouldIgnore(strCurrentName)) {
                try {
                    if (jsonTokenNextToken != JsonToken.VALUE_NULL) {
                        Object obj = map.get(objDeserializeKey);
                        Object objDeserialize = obj != null ? typeDeserializer == null ? jsonDeserializer.deserialize(jsonParser, deserializationContext, obj) : jsonDeserializer.deserializeWithType(jsonParser, deserializationContext, typeDeserializer, obj) : typeDeserializer == null ? jsonDeserializer.deserialize(jsonParser, deserializationContext) : jsonDeserializer.deserializeWithType(jsonParser, deserializationContext, typeDeserializer);
                        if (objDeserialize != obj) {
                            map.put(objDeserializeKey, objDeserialize);
                        }
                    } else if (!this._skipNullValues) {
                        map.put(objDeserializeKey, this._nullProvider.getNullValue(deserializationContext));
                    }
                } catch (Exception e) {
                    wrapAndThrow(deserializationContext, e, map, strCurrentName);
                }
            } else {
                jsonParser.skipChildren();
            }
            strCurrentName = jsonParser.nextFieldName();
        }
    }

    public final void _readAndUpdateStringKeyMap(JsonParser jsonParser, DeserializationContext deserializationContext, Map<Object, Object> map) throws IOException {
        String strCurrentName;
        JsonDeserializer<Object> jsonDeserializer = this._valueDeserializer;
        TypeDeserializer typeDeserializer = this._valueTypeDeserializer;
        if (jsonParser.isExpectedStartObjectToken()) {
            strCurrentName = jsonParser.nextFieldName();
        } else {
            JsonToken jsonTokenCurrentToken = jsonParser.currentToken();
            if (jsonTokenCurrentToken == JsonToken.END_OBJECT) {
                return;
            }
            JsonToken jsonToken = JsonToken.FIELD_NAME;
            if (jsonTokenCurrentToken != jsonToken) {
                deserializationContext.reportWrongTokenException(this, jsonToken, (String) null, new Object[0]);
            }
            strCurrentName = jsonParser.currentName();
        }
        while (strCurrentName != null) {
            JsonToken jsonTokenNextToken = jsonParser.nextToken();
            IgnorePropertiesUtil.Checker checker = this._inclusionChecker;
            if (checker == null || !checker.shouldIgnore(strCurrentName)) {
                try {
                    if (jsonTokenNextToken != JsonToken.VALUE_NULL) {
                        Object obj = map.get(strCurrentName);
                        Object objDeserialize = obj != null ? typeDeserializer == null ? jsonDeserializer.deserialize(jsonParser, deserializationContext, obj) : jsonDeserializer.deserializeWithType(jsonParser, deserializationContext, typeDeserializer, obj) : typeDeserializer == null ? jsonDeserializer.deserialize(jsonParser, deserializationContext) : jsonDeserializer.deserializeWithType(jsonParser, deserializationContext, typeDeserializer);
                        if (objDeserialize != obj) {
                            map.put(strCurrentName, objDeserialize);
                        }
                    } else if (!this._skipNullValues) {
                        map.put(strCurrentName, this._nullProvider.getNullValue(deserializationContext));
                    }
                } catch (Exception e) {
                    wrapAndThrow(deserializationContext, e, map, strCurrentName);
                }
            } else {
                jsonParser.skipChildren();
            }
            strCurrentName = jsonParser.nextFieldName();
        }
    }

    public void _squashDups(DeserializationContext deserializationContext, Map<Object, Object> map, Object obj, Object obj2, Object obj3) {
        if (this._checkDupSquash && deserializationContext.isEnabled(StreamReadCapability.DUPLICATE_PROPERTIES)) {
            if (obj2 instanceof List) {
                ((List) obj2).add(obj3);
                map.put(obj, obj2);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(obj2);
                arrayList.add(obj3);
                map.put(obj, arrayList);
            }
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.ContextualDeserializer
    public JsonDeserializer<?> createContextual(DeserializationContext deserializationContext, BeanProperty beanProperty) throws JsonMappingException {
        AnnotatedMember member;
        Set<String> included;
        KeyDeserializer keyDeserializerFindKeyDeserializer = this._keyDeserializer;
        if (keyDeserializerFindKeyDeserializer == null) {
            keyDeserializerFindKeyDeserializer = deserializationContext.findKeyDeserializer(this._containerType.getKeyType(), beanProperty);
        }
        KeyDeserializer keyDeserializer = keyDeserializerFindKeyDeserializer;
        JsonDeserializer<?> jsonDeserializerFindConvertingContentDeserializer = this._valueDeserializer;
        if (beanProperty != null) {
            jsonDeserializerFindConvertingContentDeserializer = findConvertingContentDeserializer(deserializationContext, beanProperty, jsonDeserializerFindConvertingContentDeserializer);
        }
        JavaType contentType = this._containerType.getContentType();
        JsonDeserializer<?> jsonDeserializerFindContextualValueDeserializer = jsonDeserializerFindConvertingContentDeserializer == null ? deserializationContext.findContextualValueDeserializer(contentType, beanProperty) : deserializationContext.handleSecondaryContextualization(jsonDeserializerFindConvertingContentDeserializer, beanProperty, contentType);
        TypeDeserializer typeDeserializerForProperty = this._valueTypeDeserializer;
        if (typeDeserializerForProperty != null) {
            typeDeserializerForProperty = typeDeserializerForProperty.forProperty(beanProperty);
        }
        TypeDeserializer typeDeserializer = typeDeserializerForProperty;
        Set<String> hashSet = this._ignorableProperties;
        Set<String> hashSet2 = this._includableProperties;
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        if (StdDeserializer._neitherNull(annotationIntrospector, beanProperty) && (member = beanProperty.getMember()) != null) {
            DeserializationConfig config = deserializationContext.getConfig();
            JsonIgnoreProperties.Value valueFindPropertyIgnoralByName = annotationIntrospector.findPropertyIgnoralByName(config, member);
            if (valueFindPropertyIgnoralByName != null) {
                Set<String> setFindIgnoredForDeserialization = valueFindPropertyIgnoralByName.findIgnoredForDeserialization();
                if (!setFindIgnoredForDeserialization.isEmpty()) {
                    hashSet = hashSet == null ? new HashSet<>() : new HashSet(hashSet);
                    Iterator<String> it2 = setFindIgnoredForDeserialization.iterator();
                    while (it2.hasNext()) {
                        hashSet.add(it2.next());
                    }
                }
            }
            JsonIncludeProperties.Value valueFindPropertyInclusionByName = annotationIntrospector.findPropertyInclusionByName(config, member);
            if (valueFindPropertyInclusionByName != null && (included = valueFindPropertyInclusionByName.getIncluded()) != null) {
                HashSet hashSet3 = new HashSet();
                if (hashSet2 == null) {
                    hashSet2 = new HashSet<>(included);
                } else {
                    for (String str : included) {
                        if (hashSet2.contains(str)) {
                            hashSet3.add(str);
                        }
                    }
                    hashSet2 = hashSet3;
                }
            }
        }
        return withResolved(keyDeserializer, typeDeserializer, jsonDeserializerFindContextualValueDeserializer, findContentNullProvider(deserializationContext, beanProperty, jsonDeserializerFindContextualValueDeserializer), hashSet, hashSet2);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException {
        return typeDeserializer.deserializeTypedFromObject(jsonParser, deserializationContext);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase
    public JsonDeserializer<Object> getContentDeserializer() {
        return this._valueDeserializer;
    }

    public final Class<?> getMapClass() {
        return this._containerType.getRawClass();
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer
    public ValueInstantiator getValueInstantiator() {
        return this._valueInstantiator;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase, com.fasterxml.jackson.databind.deser.std.StdDeserializer
    public JavaType getValueType() {
        return this._containerType;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public boolean isCachable() {
        return this._valueDeserializer == null && this._keyDeserializer == null && this._valueTypeDeserializer == null && this._ignorableProperties == null && this._includableProperties == null;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public LogicalType logicalType() {
        return LogicalType.Map;
    }

    @Override // com.fasterxml.jackson.databind.deser.ResolvableDeserializer
    public void resolve(DeserializationContext deserializationContext) throws JsonMappingException {
        if (this._valueInstantiator.canCreateUsingDelegate()) {
            JavaType delegateType = this._valueInstantiator.getDelegateType(deserializationContext.getConfig());
            if (delegateType == null) {
                JavaType javaType = this._containerType;
                deserializationContext.reportBadDefinition(javaType, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'", javaType, this._valueInstantiator.getClass().getName()));
            }
            this._delegateDeserializer = findDeserializer(deserializationContext, delegateType, null);
        } else if (this._valueInstantiator.canCreateUsingArrayDelegate()) {
            JavaType arrayDelegateType = this._valueInstantiator.getArrayDelegateType(deserializationContext.getConfig());
            if (arrayDelegateType == null) {
                JavaType javaType2 = this._containerType;
                deserializationContext.reportBadDefinition(javaType2, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingArrayDelegate()', but null for 'getArrayDelegateType()'", javaType2, this._valueInstantiator.getClass().getName()));
            }
            this._delegateDeserializer = findDeserializer(deserializationContext, arrayDelegateType, null);
        }
        if (this._valueInstantiator.canCreateFromObjectWith()) {
            this._propertyBasedCreator = PropertyBasedCreator.construct(deserializationContext, this._valueInstantiator, this._valueInstantiator.getFromObjectArguments(deserializationContext.getConfig()), deserializationContext.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES));
        }
        this._standardStringKey = _isStdKeyDeser(this._containerType, this._keyDeserializer);
    }

    public void setIgnorableProperties(Set<String> set) {
        if (set == null || set.isEmpty()) {
            set = null;
        }
        this._ignorableProperties = set;
        this._inclusionChecker = IgnorePropertiesUtil.buildCheckerIfNeeded(set, this._includableProperties);
    }

    public void setIncludableProperties(Set<String> set) {
        this._includableProperties = set;
        this._inclusionChecker = IgnorePropertiesUtil.buildCheckerIfNeeded(this._ignorableProperties, set);
    }

    public MapDeserializer withResolved(KeyDeserializer keyDeserializer, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer, NullValueProvider nullValueProvider, Set<String> set, Set<String> set2) {
        return (this._keyDeserializer == keyDeserializer && this._valueDeserializer == jsonDeserializer && this._valueTypeDeserializer == typeDeserializer && this._nullProvider == nullValueProvider && this._ignorableProperties == set && this._includableProperties == set2) ? this : new MapDeserializer(this, keyDeserializer, jsonDeserializer, typeDeserializer, nullValueProvider, set, set2);
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Map<Object, Object> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (this._propertyBasedCreator != null) {
            return _deserializeUsingCreator(jsonParser, deserializationContext);
        }
        JsonDeserializer<Object> jsonDeserializer = this._delegateDeserializer;
        if (jsonDeserializer != null) {
            return (Map) this._valueInstantiator.createUsingDelegate(deserializationContext, jsonDeserializer.deserialize(jsonParser, deserializationContext));
        }
        if (!this._hasDefaultCreator) {
            return (Map) deserializationContext.handleMissingInstantiator(getMapClass(), getValueInstantiator(), jsonParser, "no default constructor found", new Object[0]);
        }
        int iCurrentTokenId = jsonParser.currentTokenId();
        if (iCurrentTokenId != 1 && iCurrentTokenId != 2) {
            if (iCurrentTokenId == 3) {
                return _deserializeFromArray(jsonParser, deserializationContext);
            }
            if (iCurrentTokenId != 5) {
                if (iCurrentTokenId != 6) {
                    return (Map) deserializationContext.handleUnexpectedToken(getValueType(deserializationContext), jsonParser);
                }
                return _deserializeFromString(jsonParser, deserializationContext);
            }
        }
        Map<Object, Object> map = (Map) this._valueInstantiator.createUsingDefault(deserializationContext);
        if (this._standardStringKey) {
            return _readAndBindStringKeyMap(jsonParser, deserializationContext, map);
        }
        return _readAndBind(jsonParser, deserializationContext, map);
    }

    public MapDeserializer(MapDeserializer mapDeserializer, KeyDeserializer keyDeserializer, JsonDeserializer<Object> jsonDeserializer, TypeDeserializer typeDeserializer, NullValueProvider nullValueProvider, Set<String> set, Set<String> set2) {
        super(mapDeserializer, nullValueProvider, mapDeserializer._unwrapSingle);
        this._keyDeserializer = keyDeserializer;
        this._valueDeserializer = jsonDeserializer;
        this._valueTypeDeserializer = typeDeserializer;
        this._valueInstantiator = mapDeserializer._valueInstantiator;
        this._propertyBasedCreator = mapDeserializer._propertyBasedCreator;
        this._delegateDeserializer = mapDeserializer._delegateDeserializer;
        this._hasDefaultCreator = mapDeserializer._hasDefaultCreator;
        this._ignorableProperties = set;
        this._includableProperties = set2;
        this._inclusionChecker = IgnorePropertiesUtil.buildCheckerIfNeeded(set, set2);
        this._standardStringKey = _isStdKeyDeser(this._containerType, keyDeserializer);
        this._checkDupSquash = mapDeserializer._checkDupSquash;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Map<Object, Object> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, Map<Object, Object> map) throws IOException {
        jsonParser.assignCurrentValue(map);
        JsonToken jsonTokenCurrentToken = jsonParser.currentToken();
        if (jsonTokenCurrentToken != JsonToken.START_OBJECT && jsonTokenCurrentToken != JsonToken.FIELD_NAME) {
            return (Map) deserializationContext.handleUnexpectedToken(getMapClass(), jsonParser);
        }
        if (this._standardStringKey) {
            _readAndUpdateStringKeyMap(jsonParser, deserializationContext, map);
            return map;
        }
        _readAndUpdate(jsonParser, deserializationContext, map);
        return map;
    }
}
