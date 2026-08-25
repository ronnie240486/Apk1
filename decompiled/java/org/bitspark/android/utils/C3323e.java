package org.bitspark.android.utils;

import com.nmmedit.protect.NativeUtil;
import java.nio.charset.Charset;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import p003a2.AbstractC0032a;

public final class C3323e implements Interceptor {

    public static final Charset f11226c;

    public volatile EnumC3322d f11227a;

    public String f11228b;

    public static native boolean m6741b(MediaType mediaType);

    public final native void m6742a(Request request);

    public final native void m6743c(String str);

    public final native void m6744d(EnumC3322d enumC3322d);

    @Override
    public final native Response intercept(Interceptor.Chain chain);

    static {
        NativeUtil.classesInit0(13);
        f11226c = Charset.forName(AbstractC0032a.m165s("2M91XhY=\n", "jZszcy6Dsf8=\n"));
    }
}
