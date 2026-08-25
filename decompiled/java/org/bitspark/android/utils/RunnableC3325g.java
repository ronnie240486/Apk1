package org.bitspark.android.utils;

import android.content.Context;
import com.nmmedit.protect.NativeUtil;
import p101j7.C2782c;

public final class RunnableC3325g implements Runnable {

    public final int f11231a;

    public final C2782c f11232b;

    public final Context f11233c;

    static {
        NativeUtil.classesInit0(10);
    }

    public RunnableC3325g(C2782c c2782c, Context context, int i6) {
        this.f11231a = i6;
        this.f11232b = c2782c;
        this.f11233c = context;
    }

    @Override
    public final native void run();
}
