package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import p124l6.C2982h;
import p173q1.RunnableC3431n1;

public final class zabx extends BroadcastReceiver {

    public Context f5009a;

    public final C2982h f5010b;

    public zabx(C2982h c2982h) {
        this.f5010b = c2982h;
    }

    @Override
    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            ((RunnableC3431n1) this.f5010b.f10226c).getClass();
            throw null;
        }
    }
}
