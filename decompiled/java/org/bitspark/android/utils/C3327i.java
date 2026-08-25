package org.bitspark.android.utils;

import android.content.Context;
import com.nmmedit.protect.NativeUtil;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import p101j7.C2782c;

public final class C3327i implements Callback {

    public final C2782c f11237a;

    public final Context f11238b;

    public final AtomicLong f11239c;

    public final long f11240d;

    static {
        NativeUtil.classesInit0(8);
    }

    public C3327i(C2782c c2782c, Context context, AtomicLong atomicLong, long j10) {
        this.f11237a = c2782c;
        this.f11238b = context;
        this.f11239c = atomicLong;
        this.f11240d = j10;
    }

    @Override
    public final native void onFailure(Call call, IOException iOException);

    @Override
    public final native void onResponse(Call call, Response response);
}
