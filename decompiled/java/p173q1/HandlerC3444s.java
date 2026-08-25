package p173q1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;

public final class HandlerC3444s extends Handler {

    public final C3452v f11650a;

    public final String f11651b;

    public HandlerC3444s(C3452v c3452v, String str) {
        super(Looper.myLooper());
        this.f11650a = c3452v;
        this.f11651b = str;
    }

    @Override
    public final void handleMessage(Message message) {
        Messenger messenger = message.replyTo;
        int i6 = message.what;
        int i10 = message.arg1;
        Object obj = message.obj;
        Bundle data = message.getData();
        C3452v c3452v = this.f11650a;
        if (i6 == 7) {
            int i11 = data.getInt("volume", -1);
            String string = data.getString("routeId");
            if (i11 < 0 || string == null) {
                return;
            }
            AbstractC3397c0 abstractC3397c0M7077b = c3452v.m7077b(string);
            if (abstractC3397c0M7077b == null) {
                Log.w("MR2ProviderService", "setRouteVolume: Couldn't find a controller for routeId=".concat(string));
                return;
            } else {
                abstractC3397c0M7077b.mo6894g(i11);
                return;
            }
        }
        if (i6 == 8) {
            int i12 = data.getInt("volume", 0);
            String string2 = data.getString("routeId");
            if (i12 == 0 || string2 == null) {
                return;
            }
            AbstractC3397c0 abstractC3397c0M7077b2 = c3452v.m7077b(string2);
            if (abstractC3397c0M7077b2 == null) {
                Log.w("MR2ProviderService", "updateRouteVolume: Couldn't find a controller for routeId=".concat(string2));
                return;
            } else {
                abstractC3397c0M7077b2.mo6895j(i12);
                return;
            }
        }
        if (i6 == 9 && (obj instanceof Intent)) {
            Intent intent = (Intent) obj;
            c3452v.getClass();
            String str = this.f11651b;
            if (c3452v.getSessionInfo(str) == null) {
                Log.w("MR2ProviderService", "onCustomCommand: Couldn't find a session");
                return;
            }
            AbstractC3394b0 abstractC3394b0M7078c = c3452v.m7078c(str);
            if (abstractC3394b0M7078c != null) {
                abstractC3394b0M7078c.mo6896d(intent, new C3438q(str, intent, messenger, i10));
            } else {
                Log.w("MR2ProviderService", "onControlRequest: Couldn't find a controller");
                c3452v.notifyRequestFailed(i10, 3);
            }
        }
    }
}
