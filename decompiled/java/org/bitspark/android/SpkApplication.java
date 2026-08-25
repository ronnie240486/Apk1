package org.bitspark.android;

import android.app.Application;
import android.content.Context;
import com.nmmedit.protect.NativeUtil;
import p003a2.AbstractC0032a;

public class SpkApplication extends Application {

    public static final String f11159b;

    public static SpkApplication f11160c;

    public boolean f11161a = false;

    @Override
    public final native void attachBaseContext(Context context);

    @Override
    public final native void onCreate();

    static {
        NativeUtil.classesInit0(47);
        f11159b = AbstractC0032a.m165s("meBbdJg=\n", "1JkaBOg7zzw=\n");
    }
}
