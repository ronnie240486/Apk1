package com.alibaba.fastjson.parser.deserializer;

import android.os.LocaleList;
import java.util.Locale;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.atomic.LongAdder;

public abstract class AbstractC1451d {
    public static boolean m3431B(Object obj) {
        return obj instanceof DoubleAdder;
    }

    public static LocaleList m3441h(Object obj) {
        return (LocaleList) obj;
    }

    public static LocaleList m3442i(Locale[] localeArr) {
        return new LocaleList(localeArr);
    }

    public static DoubleAdder m3453t(Object obj) {
        return (DoubleAdder) obj;
    }

    public static LongAdder m3454u(Object obj) {
        return (LongAdder) obj;
    }

    public static boolean m3458y(Object obj) {
        return obj instanceof LongAdder;
    }
}
