package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import p041d7.C2161a0;
import p041d7.InterfaceC2270p4;

public class GuavaCodec implements ObjectSerializer, ObjectDeserializer {
    public static GuavaCodec instance = new GuavaCodec();

    @Override
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        if (type instanceof ParameterizedType) {
            type = ((ParameterizedType) type).getRawType();
        }
        if (type != C2161a0.class) {
            return null;
        }
        ?? r10 = (T) new C2161a0();
        for (Map.Entry<String, Object> entry : defaultJSONParser.parseObject().entrySet()) {
            Object value = entry.getValue();
            if (value instanceof Collection) {
                r10.m5286n((List) value, entry.getKey());
            } else {
                r10.put(entry.getKey(), value);
            }
        }
        return r10;
    }

    @Override
    public int getFastMatchToken() {
        return 0;
    }

    @Override
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i6) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj instanceof InterfaceC2270p4) {
            jSONSerializer.write(((InterfaceC2270p4) obj).mo5173d());
        }
    }
}
