package com.fasterxml.jackson.core.exc;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;

/* loaded from: classes.dex */
public abstract class StreamReadException extends JsonProcessingException {
    protected transient JsonParser _processor;

    public StreamReadException(JsonParser jsonParser, String str) {
        this(jsonParser, str, _currentLocation(jsonParser), null);
    }

    public static JsonLocation _currentLocation(JsonParser jsonParser) {
        if (jsonParser == null) {
            return null;
        }
        return jsonParser.currentLocation();
    }

    @Override // com.fasterxml.jackson.core.JsonProcessingException, java.lang.Throwable
    public String getMessage() {
        return super.getMessage();
    }

    public StreamReadException(JsonParser jsonParser, String str, JsonLocation jsonLocation, Throwable th) {
        super(str, jsonLocation, th);
        this._processor = jsonParser;
    }

    @Override // com.fasterxml.jackson.core.JsonProcessingException, com.fasterxml.jackson.core.JacksonException
    public JsonParser getProcessor() {
        return this._processor;
    }
}
