package androidx.mediarouter.app;

import android.support.v4.media.session.PlaybackStateCompat;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import com.p2serv.android.p032ds.R;
import p173q1.C3451u0;

public final class ViewOnClickListenerC1106p implements View.OnClickListener {

    public final DialogC1116u f3300a;

    public ViewOnClickListenerC1106p(DialogC1116u dialogC1116u) {
        this.f3300a = dialogC1116u;
    }

    @Override
    public final void onClick(View view) {
        int i6;
        PlaybackStateCompat playbackStateCompat;
        int id = view.getId();
        DialogC1116u dialogC1116u = this.f3300a;
        if (id == 16908313 || id == 16908314) {
            if (dialogC1116u.f3400h.m7024g()) {
                i6 = id == 16908313 ? 2 : 1;
                dialogC1116u.f3396f.getClass();
                C3451u0.m7073i(i6);
            }
            dialogC1116u.dismiss();
            return;
        }
        if (id != R.id.mr_control_playback_ctrl) {
            if (id == R.id.mr_close) {
                dialogC1116u.dismiss();
                return;
            }
            return;
        }
        if (dialogC1116u.f3383R == null || (playbackStateCompat = dialogC1116u.f3385T) == null) {
            return;
        }
        int i10 = 0;
        i6 = playbackStateCompat.getState() != 3 ? 0 : 1;
        if (i6 != 0 && (dialogC1116u.f3385T.getActions() & 514) != 0) {
            dialogC1116u.f3383R.getTransportControls().pause();
            i10 = R.string.mr_controller_pause;
        } else if (i6 != 0 && (dialogC1116u.f3385T.getActions() & 1) != 0) {
            dialogC1116u.f3383R.getTransportControls().stop();
            i10 = R.string.mr_controller_stop;
        } else if (i6 == 0 && (dialogC1116u.f3385T.getActions() & 516) != 0) {
            dialogC1116u.f3383R.getTransportControls().play();
            i10 = R.string.mr_controller_play;
        }
        AccessibilityManager accessibilityManager = dialogC1116u.f3413n0;
        if (accessibilityManager == null || !accessibilityManager.isEnabled() || i10 == 0) {
            return;
        }
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(16384);
        accessibilityEventObtain.setPackageName(dialogC1116u.f3402i.getPackageName());
        accessibilityEventObtain.setClassName(ViewOnClickListenerC1106p.class.getName());
        accessibilityEventObtain.getText().add(dialogC1116u.f3402i.getString(i10));
        accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain);
    }
}
