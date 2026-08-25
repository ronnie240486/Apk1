package com.tencent.mars.xlog;

import android.os.Handler;
import p000a.RunnableC0005f;

public final class C2107a implements Log.LogImp {

    public Handler f7715a;

    @Override
    public final int getLogLevel(long j10) {
        return Log.level;
    }

    @Override
    public final long getXlogInstance(String str) {
        return 0L;
    }

    @Override
    public final void logD(long j10, String str, String str2, String str3, int i6, int i10, long j11, long j12, String str4) {
        if (Log.level <= 1) {
            android.util.Log.d(str, str4);
        }
    }

    @Override
    public final void logE(long j10, String str, String str2, String str3, int i6, int i10, long j11, long j12, String str4) {
        if (Log.level <= 4) {
            android.util.Log.e(str, str4);
        }
    }

    @Override
    public final void logF(long j10, String str, String str2, String str3, int i6, int i10, long j11, long j12, String str4) {
        if (Log.level > 5) {
            return;
        }
        android.util.Log.e(str, str4);
        if (Log.toastSupportContext != null) {
            this.f7715a.post(new RunnableC0005f(8, str4));
        }
    }

    @Override
    public final void logI(long j10, String str, String str2, String str3, int i6, int i10, long j11, long j12, String str4) {
        if (Log.level <= 2) {
            android.util.Log.i(str, str4);
        }
    }

    @Override
    public final void logV(long j10, String str, String str2, String str3, int i6, int i10, long j11, long j12, String str4) {
        if (Log.level <= 0) {
            android.util.Log.v(str, str4);
        }
    }

    @Override
    public final void logW(long j10, String str, String str2, String str3, int i6, int i10, long j11, long j12, String str4) {
        if (Log.level <= 3) {
            android.util.Log.w(str, str4);
        }
    }

    @Override
    public final long openLogInstance(int i6, int i10, String str, String str2, String str3, int i11) {
        return 0L;
    }

    @Override
    public final void appenderClose() {
    }

    @Override
    public final void releaseXlogInstance(String str) {
    }

    @Override
    public final void appenderFlush(long j10, boolean z7) {
    }

    @Override
    public final void setAppenderMode(long j10, int i6) {
    }

    @Override
    public final void setConsoleLogOpen(long j10, boolean z7) {
    }

    @Override
    public final void setMaxAliveTime(long j10, long j11) {
    }

    @Override
    public final void setMaxFileSize(long j10, long j11) {
    }

    @Override
    public final void appenderOpen(int i6, int i10, String str, String str2, String str3, int i11) {
    }
}
