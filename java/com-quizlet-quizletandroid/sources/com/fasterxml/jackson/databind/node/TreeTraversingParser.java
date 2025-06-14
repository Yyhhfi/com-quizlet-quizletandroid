package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.StreamReadCapability;
import com.fasterxml.jackson.core.StreamReadConstraints;
import com.fasterxml.jackson.core.base.ParserMinimalBase;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.NodeCursor;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class TreeTraversingParser extends ParserMinimalBase {
    protected boolean _closed;
    protected NodeCursor _nodeCursor;
    protected ObjectCodec _objectCodec;

    /* renamed from: com.fasterxml.jackson.databind.node.TreeTraversingParser$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$jackson$core$JsonToken;

        static {
            int[] iArr = new int[JsonToken.values().length];
            $SwitchMap$com$fasterxml$jackson$core$JsonToken = iArr;
            try {
                iArr[JsonToken.START_OBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.START_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.END_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.END_ARRAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.FIELD_NAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_NUMBER_INT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_EMBEDDED_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public TreeTraversingParser(JsonNode jsonNode, ObjectCodec objectCodec) {
        super(StreamReadConstraints.defaults());
        this._objectCodec = objectCodec;
        this._nodeCursor = new NodeCursor.RootCursor(jsonNode, null);
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase
    public void _handleEOF() {
        _throwInternal();
    }

    @Override // com.fasterxml.jackson.core.JsonParser, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this._closed) {
            return;
        }
        this._closed = true;
        this._nodeCursor = null;
        _updateTokenToNull();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonLocation currentLocation() {
        return JsonLocation.NA;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String currentName() {
        NodeCursor parent = this._nodeCursor;
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.START_OBJECT || jsonToken == JsonToken.START_ARRAY) {
            parent = parent.getParent();
        }
        if (parent == null) {
            return null;
        }
        return parent.getCurrentName();
    }

    public JsonNode currentNode() {
        NodeCursor nodeCursor;
        if (this._closed || (nodeCursor = this._nodeCursor) == null) {
            return null;
        }
        return nodeCursor.currentNode();
    }

    public JsonNode currentNumericNode() throws JacksonException {
        JsonNode jsonNodeCurrentNode = currentNode();
        if (jsonNodeCurrentNode != null && jsonNodeCurrentNode.isNumber()) {
            return jsonNodeCurrentNode;
        }
        throw _constructError("Current token (" + (jsonNodeCurrentNode == null ? null : jsonNodeCurrentNode.asToken()) + ") not numeric, cannot use numeric value accessors");
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonLocation currentTokenLocation() {
        return JsonLocation.NA;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public BigInteger getBigIntegerValue() throws IOException {
        return currentNumericNode().bigIntegerValue();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public byte[] getBinaryValue(Base64Variant base64Variant) throws IOException {
        JsonNode jsonNodeCurrentNode = currentNode();
        if (jsonNodeCurrentNode != null) {
            return jsonNodeCurrentNode instanceof TextNode ? ((TextNode) jsonNodeCurrentNode).getBinaryValue(base64Variant) : jsonNodeCurrentNode.binaryValue();
        }
        return null;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public ObjectCodec getCodec() {
        return this._objectCodec;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    @Deprecated
    public String getCurrentName() {
        return currentName();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public BigDecimal getDecimalValue() throws IOException {
        return currentNumericNode().decimalValue();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public double getDoubleValue() throws IOException {
        return currentNumericNode().doubleValue();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Object getEmbeddedObject() {
        JsonNode jsonNodeCurrentNode;
        if (this._closed || (jsonNodeCurrentNode = currentNode()) == null) {
            return null;
        }
        if (jsonNodeCurrentNode.isPojo()) {
            return ((POJONode) jsonNodeCurrentNode).getPojo();
        }
        if (jsonNodeCurrentNode.isBinary()) {
            return ((BinaryNode) jsonNodeCurrentNode).binaryValue();
        }
        return null;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public float getFloatValue() throws IOException {
        return (float) currentNumericNode().doubleValue();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int getIntValue() throws IOException {
        NumericNode numericNode = (NumericNode) currentNumericNode();
        if (!numericNode.canConvertToInt()) {
            reportOverflowInt();
        }
        return numericNode.intValue();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public long getLongValue() throws IOException {
        NumericNode numericNode = (NumericNode) currentNumericNode();
        if (!numericNode.canConvertToLong()) {
            reportOverflowLong();
        }
        return numericNode.longValue();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonParser.NumberType getNumberType() throws IOException {
        JsonNode jsonNodeCurrentNumericNode = currentNumericNode();
        if (jsonNodeCurrentNumericNode == null) {
            return null;
        }
        return jsonNodeCurrentNumericNode.numberType();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonParser.NumberTypeFP getNumberTypeFP() throws IOException {
        JsonParser.NumberType numberType = getNumberType();
        return numberType == JsonParser.NumberType.BIG_DECIMAL ? JsonParser.NumberTypeFP.BIG_DECIMAL : numberType == JsonParser.NumberType.DOUBLE ? JsonParser.NumberTypeFP.DOUBLE64 : numberType == JsonParser.NumberType.FLOAT ? JsonParser.NumberTypeFP.FLOAT32 : JsonParser.NumberTypeFP.UNKNOWN;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Number getNumberValue() throws IOException {
        return currentNumericNode().numberValue();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonStreamContext getParsingContext() {
        return this._nodeCursor;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JacksonFeatureSet<StreamReadCapability> getReadCapabilities() {
        return JsonParser.DEFAULT_READ_CAPABILITIES;
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public String getText() {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == null) {
            return null;
        }
        switch (AnonymousClass1.$SwitchMap$com$fasterxml$jackson$core$JsonToken[jsonToken.ordinal()]) {
            case 5:
                return this._nodeCursor.getCurrentName();
            case 6:
                return currentNode().textValue();
            case 7:
            case 8:
                return String.valueOf(currentNode().numberValue());
            case 9:
                JsonNode jsonNodeCurrentNode = currentNode();
                if (jsonNodeCurrentNode != null && jsonNodeCurrentNode.isBinary()) {
                    return jsonNodeCurrentNode.asText();
                }
                break;
        }
        return this._currToken.asString();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public char[] getTextCharacters() throws IOException {
        return getText().toCharArray();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int getTextLength() throws IOException {
        return getText().length();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int getTextOffset() throws IOException {
        return 0;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean hasTextCharacters() {
        return false;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean isNaN() {
        if (this._closed) {
            return false;
        }
        JsonNode jsonNodeCurrentNode = currentNode();
        if (jsonNodeCurrentNode instanceof NumericNode) {
            return ((NumericNode) jsonNodeCurrentNode).isNaN();
        }
        return false;
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public JsonToken nextToken() throws IOException {
        _nullSafeUpdateToken(this._nodeCursor.nextToken());
        JsonToken jsonToken = this._currToken;
        if (jsonToken == null) {
            this._closed = true;
            return null;
        }
        int i = AnonymousClass1.$SwitchMap$com$fasterxml$jackson$core$JsonToken[jsonToken.ordinal()];
        if (i == 1) {
            this._nodeCursor = this._nodeCursor.startObject();
        } else if (i == 2) {
            this._nodeCursor = this._nodeCursor.startArray();
        } else if (i == 3 || i == 4) {
            this._nodeCursor = this._nodeCursor.getParent();
        }
        return this._currToken;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int readBinaryValue(Base64Variant base64Variant, OutputStream outputStream) throws IOException {
        byte[] binaryValue = getBinaryValue(base64Variant);
        if (binaryValue == null) {
            return 0;
        }
        outputStream.write(binaryValue, 0, binaryValue.length);
        return binaryValue.length;
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public JsonParser skipChildren() throws IOException {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.START_OBJECT) {
            this._nodeCursor = this._nodeCursor.getParent();
            _updateToken(JsonToken.END_OBJECT);
            return this;
        }
        if (jsonToken == JsonToken.START_ARRAY) {
            this._nodeCursor = this._nodeCursor.getParent();
            _updateToken(JsonToken.END_ARRAY);
        }
        return this;
    }
}
