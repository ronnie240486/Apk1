package com.nmmedit.protect;

public class NativeUtil {
    static {
        System.loadLibrary("ijkplayer");
    }

    public static native void classesInit0(int i6);
}
