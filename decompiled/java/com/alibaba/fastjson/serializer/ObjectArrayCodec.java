package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import okhttp3.HttpUrl;

public class ObjectArrayCodec implements ObjectSerializer, ObjectDeserializer {
    public static final ObjectArrayCodec instance = new ObjectArrayCodec();

    private <T> T toObjectArray(DefaultJSONParser defaultJSONParser, Class<?> cls, JSONArray jSONArray) {
        Object objCast;
        if (jSONArray == null) {
            return null;
        }
        int size = jSONArray.size();
        T t5 = (T) Array.newInstance(cls, size);
        for (int i6 = 0; i6 < size; i6++) {
            Object objectArray = jSONArray.get(i6);
            if (objectArray == jSONArray) {
                Array.set(t5, i6, t5);
            } else if (cls.isArray()) {
                if (!cls.isInstance(objectArray)) {
                    objectArray = toObjectArray(defaultJSONParser, cls, (JSONArray) objectArray);
                }
                Array.set(t5, i6, objectArray);
            } else {
                if (objectArray instanceof JSONArray) {
                    JSONArray jSONArray2 = (JSONArray) objectArray;
                    int size2 = jSONArray2.size();
                    boolean z7 = false;
                    for (int i10 = 0; i10 < size2; i10++) {
                        if (jSONArray2.get(i10) == jSONArray) {
                            jSONArray2.set(i6, t5);
                            z7 = true;
                        }
                    }
                    if (z7) {
                        objCast = jSONArray2.toArray();
                    } else {
                        objCast = null;
                    }
                } else {
                    objCast = null;
                }
                if (objCast == null) {
                    objCast = TypeUtils.cast(objectArray, (Class<Object>) cls, defaultJSONParser.getConfig());
                }
                Array.set(t5, i6, objCast);
            }
        }
        jSONArray.setRelatedArray(t5);
        jSONArray.setComponentType(cls);
        return t5;
    }

    @Override
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        Type componentType;
        Class cls;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i6 = jSONLexer.token();
        Type type2 = null;
        if (i6 == 8) {
            jSONLexer.nextToken(16);
            return null;
        }
        if (i6 == 4 || i6 == 26) {
            ?? r10 = (T) jSONLexer.bytesValue();
            jSONLexer.nextToken(16);
            if (r10.length != 0 || type == byte[].class) {
                return r10;
            }
            return null;
        }
        if (type instanceof GenericArrayType) {
            componentType = ((GenericArrayType) type).getGenericComponentType();
            if (componentType instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) componentType;
                Type type3 = defaultJSONParser.getContext().type;
                if (type3 instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type3;
                    Type rawType = parameterizedType.getRawType();
                    if (rawType instanceof Class) {
                        TypeVariable<Class<T>>[] typeParameters = ((Class) rawType).getTypeParameters();
                        for (int i10 = 0; i10 < typeParameters.length; i10++) {
                            if (typeParameters[i10].getName().equals(typeVariable.getName())) {
                                type2 = parameterizedType.getActualTypeArguments()[i10];
                            }
                        }
                    }
                    cls = type2 instanceof Class ? (Class) type2 : Object.class;
                } else {
                    cls = TypeUtils.getClass(typeVariable.getBounds()[0]);
                }
            } else {
                cls = TypeUtils.getClass(componentType);
            }
        } else {
            componentType = ((Class) type).getComponentType();
            cls = componentType;
        }
        JSONArray jSONArray = new JSONArray();
        defaultJSONParser.parseArray(componentType, jSONArray, obj);
        return (T) toObjectArray(defaultJSONParser, cls, jSONArray);
    }

    @Override
    public int getFastMatchToken() {
        return 14;
    }

    @Override
    public final void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i6) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        Object[] objArr = (Object[]) obj;
        if (obj == null) {
            serializeWriter.writeNull(SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        int length = objArr.length;
        int i10 = length - 1;
        if (i10 == -1) {
            serializeWriter.append((CharSequence) HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            return;
        }
        SerialContext serialContext = jSONSerializer.context;
        jSONSerializer.setContext(serialContext, obj, obj2, 0);
        try {
            serializeWriter.append('[');
            if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                jSONSerializer.incrementIndent();
                jSONSerializer.println();
                for (int i11 = 0; i11 < length; i11++) {
                    if (i11 != 0) {
                        serializeWriter.write(44);
                        jSONSerializer.println();
                    }
                    jSONSerializer.writeWithFieldName(objArr[i11], Integer.valueOf(i11));
                }
                jSONSerializer.decrementIdent();
                jSONSerializer.println();
                serializeWriter.write(93);
                return;
            }
            Class<?> cls = null;
            ObjectSerializer objectWriter = null;
            for (int i12 = 0; i12 < i10; i12++) {
                Object obj3 = objArr[i12];
                if (obj3 == null) {
                    serializeWriter.append((CharSequence) "null,");
                } else {
                    if (jSONSerializer.containsReference(obj3)) {
                        jSONSerializer.writeReference(obj3);
                    } else {
                        Class<?> cls2 = obj3.getClass();
                        if (cls2 == cls) {
                            objectWriter.write(jSONSerializer, obj3, Integer.valueOf(i12), null, 0);
                        } else {
                            objectWriter = jSONSerializer.getObjectWriter(cls2);
                            objectWriter.write(jSONSerializer, obj3, Integer.valueOf(i12), null, 0);
                            cls = cls2;
                        }
                    }
                    serializeWriter.append(',');
                }
            }
            Object obj4 = objArr[i10];
            if (obj4 == null) {
                serializeWriter.append((CharSequence) "null]");
            } else {
                if (jSONSerializer.containsReference(obj4)) {
                    jSONSerializer.writeReference(obj4);
                } else {
                    jSONSerializer.writeWithFieldName(obj4, Integer.valueOf(i10));
                }
                serializeWriter.append(']');
            }
        } finally {
            jSONSerializer.context = serialContext;
        }
    }
}
