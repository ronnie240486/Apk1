package com.qiniu.android.dns;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.nmmedit.protect.NativeUtil;

public final class NetworkReceiver extends BroadcastReceiver {
    @Override
    public final native void onReceive(Context context, Intent intent);

    static {
        NativeUtil.classesInit0(20);
        Uri.parse("content://telephony/carriers/preferapn");
    }
}
