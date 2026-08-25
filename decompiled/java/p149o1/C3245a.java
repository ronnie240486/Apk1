package p149o1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.view.KeyEvent;

public final class C3245a extends MediaBrowserCompat.ConnectionCallback {

    public final Context f10865a;

    public final Intent f10866b;

    public final BroadcastReceiver.PendingResult f10867c;

    public MediaBrowserCompat f10868d;

    public C3245a(Context context, Intent intent, BroadcastReceiver.PendingResult pendingResult) {
        this.f10865a = context;
        this.f10866b = intent;
        this.f10867c = pendingResult;
    }

    @Override
    public final void onConnected() {
        new MediaControllerCompat(this.f10865a, this.f10868d.getSessionToken()).dispatchMediaButtonEvent((KeyEvent) this.f10866b.getParcelableExtra("android.intent.extra.KEY_EVENT"));
        this.f10868d.disconnect();
        this.f10867c.finish();
    }

    @Override
    public final void onConnectionFailed() {
        this.f10868d.disconnect();
        this.f10867c.finish();
    }

    @Override
    public final void onConnectionSuspended() {
        this.f10868d.disconnect();
        this.f10867c.finish();
    }
}
