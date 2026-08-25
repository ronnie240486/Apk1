package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.deserializer.AbstractC1451d;
import java.io.IOException;
import java.lang.reflect.Type;

public class AdderSerializer implements ObjectSerializer {
    public static final AdderSerializer instance = new AdderSerializer();

    @Override
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i6) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (AbstractC1451d.m3458y(obj)) {
            serializeWriter.writeFieldValue('{', "value", AbstractC1451d.m3454u(obj).longValue());
            serializeWriter.write(125);
        } else if (AbstractC1451d.m3431B(obj)) {
            serializeWriter.writeFieldValue('{', "value", AbstractC1451d.m3453t(obj).doubleValue());
            serializeWriter.write(125);
        }
    }
}
