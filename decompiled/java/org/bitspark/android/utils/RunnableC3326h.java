package org.bitspark.android.utils;

import com.nmmedit.protect.NativeUtil;
import p101j7.C2782c;

public final class RunnableC3326h implements Runnable {

    public final int f11234a;

    public final C2782c f11235b;

    public final String f11236c;

    static {
        NativeUtil.classesInit0(9);
    }

    public RunnableC3326h(C2782c c2782c, String str, int i6) {
        this.f11234a = i6;
        this.f11235b = c2782c;
        this.f11236c = str;
    }

    @Override
    public final native void run();
}
