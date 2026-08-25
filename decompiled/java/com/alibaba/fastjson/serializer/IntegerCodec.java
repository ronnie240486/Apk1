package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import p055ea.AbstractC2460q;

public class IntegerCodec implements ObjectSerializer, ObjectDeserializer {
    public static IntegerCodec instance = new IntegerCodec();

    @Override
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        Object obj2;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i6 = jSONLexer.token();
        if (i6 == 8) {
            jSONLexer.nextToken(16);
            return null;
        }
        try {
            if (i6 == 2) {
                int iIntValue = jSONLexer.intValue();
                jSONLexer.nextToken(16);
                obj2 = (T) Integer.valueOf(iIntValue);
            } else if (i6 == 3) {
                obj2 = (T) Integer.valueOf(TypeUtils.intValue(jSONLexer.decimalValue()));
                jSONLexer.nextToken(16);
            } else if (i6 == 12) {
                JSONObject jSONObject = new JSONObject(true);
                defaultJSONParser.parseObject((Map) jSONObject);
                obj2 = (T) TypeUtils.castToInt(jSONObject);
            } else {
                obj2 = (T) TypeUtils.castToInt(defaultJSONParser.parse());
            }
            obj = AtomicInteger.class;
            return type == obj ? (T) new AtomicInteger(((Integer) obj2).intValue()) : (T) obj2;
        } catch (Exception e5) {
            throw new JSONException(obj != null ? AbstractC2460q.m5493g(obj, "parseInt error, field : ") : "parseInt error", e5);
        }
    }

    @Override
    public int getFastMatchToken() {
        return 2;
    }

    @Override
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i6) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        Number number = (Number) obj;
        if (number == null) {
            serializeWriter.writeNull(SerializerFeature.WriteNullNumberAsZero);
            return;
        }
        if (obj instanceof Long) {
            serializeWriter.writeLong(number.longValue());
        } else {
            serializeWriter.writeInt(number.intValue());
        }
        if (serializeWriter.isEnabled(SerializerFeature.WriteClassName)) {
            Class<?> cls = number.getClass();
            if (cls == Byte.class) {
                serializeWriter.write(66);
            } else if (cls == Short.class) {
                serializeWriter.write(83);
            }
        }
    }
}
