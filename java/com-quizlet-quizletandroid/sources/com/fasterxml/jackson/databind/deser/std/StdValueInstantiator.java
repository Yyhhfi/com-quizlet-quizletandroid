package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;

@JacksonStdImpl
/* loaded from: classes.dex */
public class StdValueInstantiator extends ValueInstantiator implements Serializable {
    protected SettableBeanProperty[] _arrayDelegateArguments;
    protected AnnotatedWithParams _arrayDelegateCreator;
    protected JavaType _arrayDelegateType;
    protected SettableBeanProperty[] _constructorArguments;
    protected AnnotatedWithParams _defaultCreator;
    protected SettableBeanProperty[] _delegateArguments;
    protected AnnotatedWithParams _delegateCreator;
    protected JavaType _delegateType;
    protected AnnotatedWithParams _fromBigDecimalCreator;
    protected AnnotatedWithParams _fromBigIntegerCreator;
    protected AnnotatedWithParams _fromBooleanCreator;
    protected AnnotatedWithParams _fromDoubleCreator;
    protected AnnotatedWithParams _fromIntCreator;
    protected AnnotatedWithParams _fromLongCreator;
    protected AnnotatedWithParams _fromStringCreator;
    protected final Class<?> _valueClass;
    protected final String _valueTypeDesc;
    protected AnnotatedWithParams _withArgsCreator;

    public StdValueInstantiator(DeserializationConfig deserializationConfig, JavaType javaType) {
        this._valueTypeDesc = javaType == null ? "UNKNOWN TYPE" : javaType.toString();
        this._valueClass = javaType == null ? Object.class : javaType.getRawClass();
    }

    private Object _createUsingDelegate(AnnotatedWithParams annotatedWithParams, SettableBeanProperty[] settableBeanPropertyArr, DeserializationContext deserializationContext, Object obj) throws IOException {
        if (annotatedWithParams == null) {
            throw new IllegalStateException("No delegate constructor for " + getValueTypeDesc());
        }
        try {
            if (settableBeanPropertyArr == null) {
                return annotatedWithParams.call1(obj);
            }
            int length = settableBeanPropertyArr.length;
            Object[] objArr = new Object[length];
            for (int i = 0; i < length; i++) {
                SettableBeanProperty settableBeanProperty = settableBeanPropertyArr[i];
                if (settableBeanProperty == null) {
                    objArr[i] = obj;
                } else {
                    objArr[i] = deserializationContext.findInjectableValue(settableBeanProperty.getInjectableValueId(), settableBeanProperty, null);
                }
            }
            return annotatedWithParams.call(objArr);
        } catch (Exception e) {
            throw rewrapCtorProblem(deserializationContext, e);
        }
    }

    public static Double tryConvertToDouble(BigDecimal bigDecimal) {
        double dDoubleValue = bigDecimal.doubleValue();
        if (Double.isInfinite(dDoubleValue)) {
            return null;
        }
        return Double.valueOf(dDoubleValue);
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public boolean canCreateFromBigDecimal() {
        return this._fromBigDecimalCreator != null;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public boolean canCreateFromBigInteger() {
        return this._fromBigIntegerCreator != null;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public boolean canCreateFromBoolean() {
        return this._fromBooleanCreator != null;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public boolean canCreateFromDouble() {
        return this._fromDoubleCreator != null;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public boolean canCreateFromInt() {
        return this._fromIntCreator != null;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public boolean canCreateFromLong() {
        return this._fromLongCreator != null;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public boolean canCreateFromObjectWith() {
        return this._withArgsCreator != null;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public boolean canCreateFromString() {
        return this._fromStringCreator != null;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public boolean canCreateUsingArrayDelegate() {
        return this._arrayDelegateType != null;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public boolean canCreateUsingDefault() {
        return this._defaultCreator != null;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public boolean canCreateUsingDelegate() {
        return this._delegateType != null;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public boolean canInstantiate() {
        return canCreateUsingDefault() || canCreateUsingDelegate() || canCreateUsingArrayDelegate() || canCreateFromObjectWith() || canCreateFromString() || canCreateFromInt() || canCreateFromLong() || canCreateFromDouble() || canCreateFromBoolean();
    }

    public void configureFromArraySettings(AnnotatedWithParams annotatedWithParams, JavaType javaType, SettableBeanProperty[] settableBeanPropertyArr) {
        this._arrayDelegateCreator = annotatedWithParams;
        this._arrayDelegateType = javaType;
        this._arrayDelegateArguments = settableBeanPropertyArr;
    }

    public void configureFromBigDecimalCreator(AnnotatedWithParams annotatedWithParams) {
        this._fromBigDecimalCreator = annotatedWithParams;
    }

    public void configureFromBigIntegerCreator(AnnotatedWithParams annotatedWithParams) {
        this._fromBigIntegerCreator = annotatedWithParams;
    }

    public void configureFromBooleanCreator(AnnotatedWithParams annotatedWithParams) {
        this._fromBooleanCreator = annotatedWithParams;
    }

    public void configureFromDoubleCreator(AnnotatedWithParams annotatedWithParams) {
        this._fromDoubleCreator = annotatedWithParams;
    }

    public void configureFromIntCreator(AnnotatedWithParams annotatedWithParams) {
        this._fromIntCreator = annotatedWithParams;
    }

    public void configureFromLongCreator(AnnotatedWithParams annotatedWithParams) {
        this._fromLongCreator = annotatedWithParams;
    }

    public void configureFromObjectSettings(AnnotatedWithParams annotatedWithParams, AnnotatedWithParams annotatedWithParams2, JavaType javaType, SettableBeanProperty[] settableBeanPropertyArr, AnnotatedWithParams annotatedWithParams3, SettableBeanProperty[] settableBeanPropertyArr2) {
        this._defaultCreator = annotatedWithParams;
        this._delegateCreator = annotatedWithParams2;
        this._delegateType = javaType;
        this._delegateArguments = settableBeanPropertyArr;
        this._withArgsCreator = annotatedWithParams3;
        this._constructorArguments = settableBeanPropertyArr2;
    }

    public void configureFromStringCreator(AnnotatedWithParams annotatedWithParams) {
        this._fromStringCreator = annotatedWithParams;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public Object createFromBigDecimal(DeserializationContext deserializationContext, BigDecimal bigDecimal) throws IOException {
        Double dTryConvertToDouble;
        AnnotatedWithParams annotatedWithParams = this._fromBigDecimalCreator;
        if (annotatedWithParams != null) {
            try {
                return annotatedWithParams.call1(bigDecimal);
            } catch (Exception e) {
                return deserializationContext.handleInstantiationProblem(this._fromBigDecimalCreator.getDeclaringClass(), bigDecimal, rewrapCtorProblem(deserializationContext, e));
            }
        }
        if (this._fromDoubleCreator == null || (dTryConvertToDouble = tryConvertToDouble(bigDecimal)) == null) {
            return super.createFromBigDecimal(deserializationContext, bigDecimal);
        }
        try {
            return this._fromDoubleCreator.call1(dTryConvertToDouble);
        } catch (Exception e2) {
            return deserializationContext.handleInstantiationProblem(this._fromDoubleCreator.getDeclaringClass(), dTryConvertToDouble, rewrapCtorProblem(deserializationContext, e2));
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public Object createFromBigInteger(DeserializationContext deserializationContext, BigInteger bigInteger) throws IOException {
        AnnotatedWithParams annotatedWithParams = this._fromBigIntegerCreator;
        if (annotatedWithParams == null) {
            return super.createFromBigInteger(deserializationContext, bigInteger);
        }
        try {
            return annotatedWithParams.call1(bigInteger);
        } catch (Exception e) {
            return deserializationContext.handleInstantiationProblem(this._fromBigIntegerCreator.getDeclaringClass(), bigInteger, rewrapCtorProblem(deserializationContext, e));
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public Object createFromBoolean(DeserializationContext deserializationContext, boolean z) throws IOException {
        if (this._fromBooleanCreator == null) {
            return super.createFromBoolean(deserializationContext, z);
        }
        Boolean boolValueOf = Boolean.valueOf(z);
        try {
            return this._fromBooleanCreator.call1(boolValueOf);
        } catch (Exception e) {
            return deserializationContext.handleInstantiationProblem(this._fromBooleanCreator.getDeclaringClass(), boolValueOf, rewrapCtorProblem(deserializationContext, e));
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public Object createFromDouble(DeserializationContext deserializationContext, double d) throws IOException {
        if (this._fromDoubleCreator != null) {
            Double dValueOf = Double.valueOf(d);
            try {
                return this._fromDoubleCreator.call1(dValueOf);
            } catch (Exception e) {
                return deserializationContext.handleInstantiationProblem(this._fromDoubleCreator.getDeclaringClass(), dValueOf, rewrapCtorProblem(deserializationContext, e));
            }
        }
        if (this._fromBigDecimalCreator == null) {
            return super.createFromDouble(deserializationContext, d);
        }
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(d);
        try {
            return this._fromBigDecimalCreator.call1(bigDecimalValueOf);
        } catch (Exception e2) {
            return deserializationContext.handleInstantiationProblem(this._fromBigDecimalCreator.getDeclaringClass(), bigDecimalValueOf, rewrapCtorProblem(deserializationContext, e2));
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public Object createFromInt(DeserializationContext deserializationContext, int i) throws IOException {
        if (this._fromIntCreator != null) {
            Integer numValueOf = Integer.valueOf(i);
            try {
                return this._fromIntCreator.call1(numValueOf);
            } catch (Exception e) {
                return deserializationContext.handleInstantiationProblem(this._fromIntCreator.getDeclaringClass(), numValueOf, rewrapCtorProblem(deserializationContext, e));
            }
        }
        if (this._fromLongCreator != null) {
            Long lValueOf = Long.valueOf(i);
            try {
                return this._fromLongCreator.call1(lValueOf);
            } catch (Exception e2) {
                return deserializationContext.handleInstantiationProblem(this._fromLongCreator.getDeclaringClass(), lValueOf, rewrapCtorProblem(deserializationContext, e2));
            }
        }
        if (this._fromBigIntegerCreator != null) {
            BigInteger bigIntegerValueOf = BigInteger.valueOf(i);
            try {
                return this._fromBigIntegerCreator.call1(bigIntegerValueOf);
            } catch (Exception e3) {
                return deserializationContext.handleInstantiationProblem(this._fromBigIntegerCreator.getDeclaringClass(), bigIntegerValueOf, rewrapCtorProblem(deserializationContext, e3));
            }
        }
        if (this._fromDoubleCreator == null) {
            return super.createFromInt(deserializationContext, i);
        }
        Double dValueOf = Double.valueOf(i);
        try {
            return this._fromDoubleCreator.call1(dValueOf);
        } catch (Exception e4) {
            return deserializationContext.handleInstantiationProblem(this._fromDoubleCreator.getDeclaringClass(), dValueOf, rewrapCtorProblem(deserializationContext, e4));
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public Object createFromLong(DeserializationContext deserializationContext, long j) throws IOException {
        if (this._fromLongCreator != null) {
            Long lValueOf = Long.valueOf(j);
            try {
                return this._fromLongCreator.call1(lValueOf);
            } catch (Exception e) {
                return deserializationContext.handleInstantiationProblem(this._fromLongCreator.getDeclaringClass(), lValueOf, rewrapCtorProblem(deserializationContext, e));
            }
        }
        if (this._fromBigIntegerCreator != null) {
            BigInteger bigIntegerValueOf = BigInteger.valueOf(j);
            try {
                return this._fromBigIntegerCreator.call1(bigIntegerValueOf);
            } catch (Exception e2) {
                return deserializationContext.handleInstantiationProblem(this._fromBigIntegerCreator.getDeclaringClass(), bigIntegerValueOf, rewrapCtorProblem(deserializationContext, e2));
            }
        }
        if (this._fromDoubleCreator == null) {
            return super.createFromLong(deserializationContext, j);
        }
        Double dValueOf = Double.valueOf(j);
        try {
            return this._fromDoubleCreator.call1(dValueOf);
        } catch (Exception e3) {
            return deserializationContext.handleInstantiationProblem(this._fromDoubleCreator.getDeclaringClass(), dValueOf, rewrapCtorProblem(deserializationContext, e3));
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public Object createFromObjectWith(DeserializationContext deserializationContext, Object[] objArr) throws IOException {
        AnnotatedWithParams annotatedWithParams = this._withArgsCreator;
        if (annotatedWithParams == null) {
            return super.createFromObjectWith(deserializationContext, objArr);
        }
        try {
            return annotatedWithParams.call(objArr);
        } catch (Exception e) {
            return deserializationContext.handleInstantiationProblem(this._valueClass, objArr, rewrapCtorProblem(deserializationContext, e));
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public Object createFromString(DeserializationContext deserializationContext, String str) throws IOException {
        AnnotatedWithParams annotatedWithParams = this._fromStringCreator;
        if (annotatedWithParams == null) {
            return super.createFromString(deserializationContext, str);
        }
        try {
            return annotatedWithParams.call1(str);
        } catch (Exception e) {
            return deserializationContext.handleInstantiationProblem(this._fromStringCreator.getDeclaringClass(), str, rewrapCtorProblem(deserializationContext, e));
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public Object createUsingArrayDelegate(DeserializationContext deserializationContext, Object obj) throws IOException {
        AnnotatedWithParams annotatedWithParams = this._arrayDelegateCreator;
        return (annotatedWithParams != null || this._delegateCreator == null) ? _createUsingDelegate(annotatedWithParams, this._arrayDelegateArguments, deserializationContext, obj) : createUsingDelegate(deserializationContext, obj);
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public Object createUsingDefault(DeserializationContext deserializationContext) throws IOException {
        AnnotatedWithParams annotatedWithParams = this._defaultCreator;
        if (annotatedWithParams == null) {
            return super.createUsingDefault(deserializationContext);
        }
        try {
            return annotatedWithParams.call();
        } catch (Exception e) {
            return deserializationContext.handleInstantiationProblem(this._valueClass, null, rewrapCtorProblem(deserializationContext, e));
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public Object createUsingDefaultOrWithoutArguments(DeserializationContext deserializationContext) throws IOException {
        return this._defaultCreator != null ? createUsingDefault(deserializationContext) : this._withArgsCreator != null ? createFromObjectWith(deserializationContext, new Object[this._constructorArguments.length]) : super.createUsingDefaultOrWithoutArguments(deserializationContext);
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public Object createUsingDelegate(DeserializationContext deserializationContext, Object obj) throws IOException {
        AnnotatedWithParams annotatedWithParams;
        AnnotatedWithParams annotatedWithParams2 = this._delegateCreator;
        return (annotatedWithParams2 != null || (annotatedWithParams = this._arrayDelegateCreator) == null) ? _createUsingDelegate(annotatedWithParams2, this._delegateArguments, deserializationContext, obj) : _createUsingDelegate(annotatedWithParams, this._arrayDelegateArguments, deserializationContext, obj);
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public AnnotatedWithParams getArrayDelegateCreator() {
        return this._arrayDelegateCreator;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public JavaType getArrayDelegateType(DeserializationConfig deserializationConfig) {
        return this._arrayDelegateType;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public AnnotatedWithParams getDefaultCreator() {
        return this._defaultCreator;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public AnnotatedWithParams getDelegateCreator() {
        return this._delegateCreator;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public JavaType getDelegateType(DeserializationConfig deserializationConfig) {
        return this._delegateType;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public SettableBeanProperty[] getFromObjectArguments(DeserializationConfig deserializationConfig) {
        return this._constructorArguments;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public Class<?> getValueClass() {
        return this._valueClass;
    }

    public String getValueTypeDesc() {
        return this._valueTypeDesc;
    }

    public JsonMappingException rewrapCtorProblem(DeserializationContext deserializationContext, Throwable th) {
        Throwable cause;
        if (((th instanceof ExceptionInInitializerError) || (th instanceof InvocationTargetException)) && (cause = th.getCause()) != null) {
            th = cause;
        }
        return wrapAsJsonMappingException(deserializationContext, th);
    }

    public JsonMappingException wrapAsJsonMappingException(DeserializationContext deserializationContext, Throwable th) {
        return th instanceof JsonMappingException ? (JsonMappingException) th : deserializationContext.instantiationException(getValueClass(), th);
    }
}
