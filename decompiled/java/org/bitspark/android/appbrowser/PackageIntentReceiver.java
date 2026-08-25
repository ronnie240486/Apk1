package org.bitspark.android.appbrowser;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.nmmedit.protect.NativeUtil;

public class PackageIntentReceiver extends BroadcastReceiver {
    static {
        NativeUtil.classesInit0(66);
    }

    @Override
    public final native void onReceive(Context context, Intent intent);
}
