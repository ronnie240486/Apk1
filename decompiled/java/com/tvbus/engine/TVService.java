package com.tvbus.engine;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.nmmedit.protect.NativeUtil;

public class TVService extends Service {
    static final String TAG = "TVBusService";
    public static boolean bInited;

    public class TVServer implements Runnable {
        private static final String TAG = "TVBusServer";
        TVCore tvcore;

        static {
            NativeUtil.classesInit0(46);
        }

        private TVServer() {
            this.tvcore = TVCore.getInstance();
        }

        @Override
        public native void run();
    }

    static {
        NativeUtil.classesInit0(17);
    }

    @Override
    public native IBinder onBind(Intent intent);

    @Override
    public native void onCreate();

    @Override
    public native void onDestroy();

    @Override
    public native int onStartCommand(Intent intent, int i6, int i10);
}
