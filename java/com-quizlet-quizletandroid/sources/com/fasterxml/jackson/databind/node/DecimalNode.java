package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class DecimalNode extends NumericNode {
    protected final BigDecimal _value;
    public static final DecimalNode ZERO = new DecimalNode(BigDecimal.ZERO);
    private static final BigDecimal MIN_INTEGER = BigDecimal.valueOf(-2147483648L);
    private static final BigDecimal MAX_INTEGER = BigDecimal.valueOf(2147483647L);
    private static final BigDecimal MIN_LONG = BigDecimal.valueOf(Long.MIN_VALUE);
    private static final BigDecimal MAX_LONG = BigDecimal.valueOf(Long.MAX_VALUE);

    public DecimalNode(BigDecimal bigDecimal) {
        this._value = bigDecimal;
    }

    public static DecimalNode valueOf(BigDecimal bigDecimal) {
        return new DecimalNode(bigDecimal);
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public String asText() {
        return this._value.toString();
    }

    @Override // com.fasterxml.jackson.databind.node.ValueNode, com.fasterxml.jackson.core.TreeNode
    public JsonToken asToken() {
        return JsonToken.VALUE_NUMBER_FLOAT;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public BigInteger bigIntegerValue() {
        return _bigIntFromBigDec(this._value);
    }

    @Override // com.fasterxml.jackson.databind.node.NumericNode
    public boolean canConvertToInt() {
        return this._value.compareTo(MIN_INTEGER) >= 0 && this._value.compareTo(MAX_INTEGER) <= 0;
    }

    @Override // com.fasterxml.jackson.databind.node.NumericNode
    public boolean canConvertToLong() {
        return this._value.compareTo(MIN_LONG) >= 0 && this._value.compareTo(MAX_LONG) <= 0;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public BigDecimal decimalValue() {
        return this._value;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public double doubleValue() {
        return this._value.doubleValue();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof DecimalNode)) {
            BigDecimal bigDecimal = ((DecimalNode) obj)._value;
            if (bigDecimal == null) {
                return this._value == null;
            }
            BigDecimal bigDecimal2 = this._value;
            if (bigDecimal2 != null && bigDecimal.compareTo(bigDecimal2) == 0) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this._value == null) {
            return 0;
        }
        return Double.hashCode(doubleValue());
    }

    @Override // com.fasterxml.jackson.databind.node.NumericNode
    public int intValue() {
        return this._value.intValue();
    }

    @Override // com.fasterxml.jackson.databind.node.NumericNode
    public long longValue() {
        return this._value.longValue();
    }

    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode, com.fasterxml.jackson.core.TreeNode
    public JsonParser.NumberType numberType() {
        return JsonParser.NumberType.BIG_DECIMAL;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public Number numberValue() {
        return this._value;
    }

    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode, com.fasterxml.jackson.databind.JsonSerializable
    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeNumber(this._value);
    }
}
