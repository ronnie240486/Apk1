package org.bitspark.android.utils;

import android.content.Context;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.internal.cast.C1591j;
import com.nmmedit.protect.NativeUtil;
import java.util.List;

public class CastOptionsProvider {
    static {
        NativeUtil.classesInit0(45);
    }

    public native List<C1591j> getAdditionalSessionProviders(Context context);

    public native CastOptions getCastOptions(Context context);
}
