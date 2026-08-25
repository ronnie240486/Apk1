package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class EnumCreatorDeserializer implements ObjectDeserializer {
    private final Method creator;
    private final Class paramType;

    public EnumCreatorDeserializer(Method method) {
        this.creator = method;
        this.paramType = method.getParameterTypes()[0];
    }

    @Override
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        try {
            return (T) this.creator.invoke(null, defaultJSONParser.parseObject((Class) this.paramType));
        } catch (IllegalAccessException e5) {
            throw new JSONException("parse enum error", e5);
        } catch (InvocationTargetException e10) {
            throw new JSONException("parse enum error", e10);
        }
    }

    @Override
    public int getFastMatchToken() {
        return 0;
    }
}
