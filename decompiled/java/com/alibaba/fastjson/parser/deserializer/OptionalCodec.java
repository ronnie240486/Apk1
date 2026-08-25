package com.alibaba.fastjson.parser.deserializer;

import androidx.media3.exoplayer.source.mediaparser.AbstractC0915a;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class OptionalCodec implements ObjectSerializer, ObjectDeserializer {
    public static OptionalCodec instance = new OptionalCodec();

    @Override
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        if (type == AbstractC0915a.m2502e()) {
            Integer numCastToInt = TypeUtils.castToInt(defaultJSONParser.parseObject((Class) Integer.class));
            return numCastToInt == null ? (T) OptionalInt.empty() : (T) OptionalInt.of(numCastToInt.intValue());
        }
        if (type == AbstractC0915a.m2521x()) {
            Long lCastToLong = TypeUtils.castToLong(defaultJSONParser.parseObject((Class) Long.class));
            return lCastToLong == null ? (T) OptionalLong.empty() : (T) OptionalLong.of(lCastToLong.longValue());
        }
        if (type == AbstractC0915a.m2495B()) {
            Double dCastToDouble = TypeUtils.castToDouble(defaultJSONParser.parseObject((Class) Double.class));
            return dCastToDouble == null ? (T) OptionalDouble.empty() : (T) OptionalDouble.of(dCastToDouble.doubleValue());
        }
        Object object = defaultJSONParser.parseObject(TypeUtils.unwrapOptional(type));
        return object == null ? (T) Optional.empty() : (T) Optional.of(object);
    }

    @Override
    public int getFastMatchToken() {
        return 12;
    }

    @Override
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i6) throws IOException {
        if (obj == null) {
            jSONSerializer.writeNull();
            return;
        }
        if (AbstractC0915a.m2514q(obj)) {
            Optional optionalM2505h = AbstractC0915a.m2505h(obj);
            jSONSerializer.write(optionalM2505h.isPresent() ? optionalM2505h.get() : null);
            return;
        }
        if (AbstractC0915a.m2496C(obj)) {
            OptionalDouble optionalDoubleM2506i = AbstractC0915a.m2506i(obj);
            if (optionalDoubleM2506i.isPresent()) {
                jSONSerializer.write(Double.valueOf(optionalDoubleM2506i.getAsDouble()));
                return;
            } else {
                jSONSerializer.writeNull();
                return;
            }
        }
        if (AbstractC0915a.m2497D(obj)) {
            OptionalInt optionalIntM2509l = AbstractC0915a.m2509l(obj);
            if (optionalIntM2509l.isPresent()) {
                jSONSerializer.out.writeInt(optionalIntM2509l.getAsInt());
                return;
            } else {
                jSONSerializer.writeNull();
                return;
            }
        }
        if (!AbstractC0915a.m2494A(obj)) {
            throw new JSONException("not support optional : " + obj.getClass());
        }
        OptionalLong optionalLongM2512o = AbstractC0915a.m2512o(obj);
        if (optionalLongM2512o.isPresent()) {
            jSONSerializer.out.writeLong(optionalLongM2512o.getAsLong());
        } else {
            jSONSerializer.writeNull();
        }
    }
}
