package androidx.mediarouter.app;

import android.app.PendingIntent;
import android.support.v4.media.session.MediaControllerCompat;
import android.util.Log;
import android.view.View;

public final class ViewOnClickListenerC1096k implements View.OnClickListener {

    public final int f3261a;

    public final DialogC1116u f3262b;

    public ViewOnClickListenerC1096k(DialogC1116u dialogC1116u, int i6) {
        this.f3261a = i6;
        this.f3262b = dialogC1116u;
    }

    @Override
    public final void onClick(View view) {
        PendingIntent sessionActivity;
        switch (this.f3261a) {
            case 0:
                DialogC1116u dialogC1116u = this.f3262b;
                boolean z7 = dialogC1116u.f3395e0;
                dialogC1116u.f3395e0 = !z7;
                if (!z7) {
                    dialogC1116u.f3369D.setVisibility(0);
                }
                dialogC1116u.f3407k0 = dialogC1116u.f3395e0 ? dialogC1116u.f3409l0 : dialogC1116u.f3411m0;
                dialogC1116u.m2802v(true);
                break;
            case 1:
                this.f3262b.dismiss();
                break;
            default:
                DialogC1116u dialogC1116u2 = this.f3262b;
                MediaControllerCompat mediaControllerCompat = dialogC1116u2.f3383R;
                if (mediaControllerCompat != null && (sessionActivity = mediaControllerCompat.getSessionActivity()) != null) {
                    try {
                        sessionActivity.send();
                        dialogC1116u2.dismiss();
                    } catch (PendingIntent.CanceledException unused) {
                        Log.e("MediaRouteCtrlDialog", sessionActivity + " was not sent, it had been canceled.");
                    }
                    break;
                }
                break;
        }
    }
}
