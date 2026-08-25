package com.alibaba.fastjson.parser.deserializer;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAccessor;

public abstract class AbstractC1448a {
    public static Class m3345b() {
        return LocalTime.class;
    }

    public static TemporalAccessor m3359p(Object obj) {
        return (TemporalAccessor) obj;
    }

    public static Class m3361r() {
        return LocalDateTime.class;
    }
}
