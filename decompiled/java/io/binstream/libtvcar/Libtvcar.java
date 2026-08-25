package io.binstream.libtvcar;

import p072go.Seq;

public abstract class Libtvcar {

    public static final class proxyListener implements Seq.Proxy, Listener {
        private final int refnum;

        public proxyListener(int i6) {
            this.refnum = i6;
            Seq.trackGoRef(i6, this);
        }

        @Override
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        @Override
        public native void onInfo(String str);

        @Override
        public native void onInited(String str);

        @Override
        public native void onPrepared(String str);

        @Override
        public native void onQuit(String str);

        @Override
        public native void onStart(String str);

        @Override
        public native void onStop(String str);
    }

    static {
        Seq.touch();
        _init();
    }

    private Libtvcar() {
    }

    private static native void _init();

    public static native String getVersion(long j10);

    public static native long init();

    public static native void release();

    public static native void run();

    public static native void setAuthURL(String str);

    public static native void setListener(Listener listener);

    public static native void setOption(String str, String str2);

    public static native void setPassword(String str);

    public static native void setPlayPort(long j10);

    public static native void setUsername(String str);

    public static native void start(String str);

    public static void touch() {
    }
}
