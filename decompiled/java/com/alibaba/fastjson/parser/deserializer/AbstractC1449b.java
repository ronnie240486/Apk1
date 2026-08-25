package com.alibaba.fastjson.parser.deserializer;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public abstract class AbstractC1449b {
    public static Class m3370A() {
        return Period.class;
    }

    public static Class m3371B() {
        return Duration.class;
    }

    public static Class m3372C() {
        return Instant.class;
    }

    public static Class m3373D() {
        return LocalDate.class;
    }

    public static Class m3375b() {
        return ZonedDateTime.class;
    }

    public static Class m3396w() {
        return OffsetDateTime.class;
    }

    public static Class m3398y() {
        return OffsetTime.class;
    }

    public static Class m3399z() {
        return ZoneId.class;
    }
}
