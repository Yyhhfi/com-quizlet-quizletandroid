package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.io.NumberOutput;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class IntNode extends NumericNode {
    private static final IntNode[] CANONICALS = new IntNode[12];
    protected final int _value;

    static {
        for (int i = 0; i < 12; i++) {
            CANONICALS[i] = new IntNode(i - 1);
        }
    }

    public IntNode(int i) {
        this._value = i;
    }

    public static IntNode valueOf(int i) {
        return (i > 10 || i < -1) ? new IntNode(i) : CANONICALS[i - (-1)];
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public String asText() {
        return NumberOutput.toString(this._value);
    }

    @Override // com.fasterxml.jackson.databind.node.ValueNode, com.fasterxml.jackson.core.TreeNode
    public JsonToken asToken() {
        return JsonToken.VALUE_NUMBER_INT;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public BigInteger bigIntegerValue() {
        return BigInteger.valueOf(this._value);
    }

    @Override // com.fasterxml.jackson.databind.node.NumericNode
    public boolean canConvertToInt() {
        return true;
    }

    @Override // com.fasterxml.jackson.databind.node.NumericNode
    public boolean canConvertToLong() {
        return true;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public BigDecimal decimalValue() {
        return BigDecimal.valueOf(this._value);
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public double doubleValue() {
        return this._value;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj != null && (obj instanceof IntNode) && ((IntNode) obj)._value == this._value;
    }

    public int hashCode() {
        return this._value;
    }

    @Override // com.fasterxml.jackson.databind.node.NumericNode
    public int intValue() {
        return this._value;
    }

    @Override // com.fasterxml.jackson.databind.node.NumericNode
    public long longValue() {
        return this._value;
    }

    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode, com.fasterxml.jackson.core.TreeNode
    public JsonParser.NumberType numberType() {
        return JsonParser.NumberType.INT;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public Number numberValue() {
        return Integer.valueOf(this._value);
    }

    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode, com.fasterxml.jackson.databind.JsonSerializable
    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeNumber(this._value);
    }
}
