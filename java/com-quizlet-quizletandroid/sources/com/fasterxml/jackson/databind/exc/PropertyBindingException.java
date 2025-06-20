package com.fasterxml.jackson.databind.exc;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class PropertyBindingException extends MismatchedInputException {
    protected transient String _propertiesAsString;
    protected final Collection<Object> _propertyIds;
    protected final String _propertyName;
    protected final Class<?> _referringClass;

    public PropertyBindingException(JsonParser jsonParser, String str, JsonLocation jsonLocation, Class<?> cls, String str2, Collection<Object> collection) {
        super(jsonParser, str, jsonLocation);
        this._referringClass = cls;
        this._propertyName = str2;
        this._propertyIds = collection;
    }

    @Override // com.fasterxml.jackson.core.JsonProcessingException
    public String getMessageSuffix() {
        String str = this._propertiesAsString;
        if (str != null || this._propertyIds == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this._propertyIds.size();
        if (size != 1) {
            sb.append(" (");
            sb.append(size);
            sb.append(" known properties: ");
            Iterator<Object> it2 = this._propertyIds.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                sb.append('\"');
                sb.append(String.valueOf(it2.next()));
                sb.append('\"');
                if (sb.length() > 1000) {
                    sb.append(" [truncated]");
                    break;
                }
                if (it2.hasNext()) {
                    sb.append(", ");
                }
            }
        } else {
            sb.append(" (one known property: \"");
            sb.append(String.valueOf(this._propertyIds.iterator().next()));
            sb.append('\"');
        }
        sb.append("])");
        String string = sb.toString();
        this._propertiesAsString = string;
        return string;
    }
}
