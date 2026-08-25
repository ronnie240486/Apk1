package org.bitspark.android;

import com.nmmedit.protect.NativeUtil;

public enum Constants$VIDEO_TYPE {
    BSLIVE,
    BSPALYBACK,
    BSVOD,
    STATIC;

    public static native Constants$VIDEO_TYPE valueOf(String str);

    public static native Constants$VIDEO_TYPE[] values();

    static {
        NativeUtil.classesInit0(54);
    }
}
