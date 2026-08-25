package org.bitspark.android.utils;

import com.nmmedit.protect.NativeUtil;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public final class C3330l implements HostnameVerifier {

    public final int f11242a;

    static {
        NativeUtil.classesInit0(6);
    }

    @Override
    public final native boolean verify(String str, SSLSession sSLSession);
}
