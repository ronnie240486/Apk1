package p210t4;

import android.util.Log;
import android.view.View;
import androidx.fragment.app.AbstractComponentCallbacksC0427s;
import androidx.fragment.app.C0391a;
import androidx.fragment.app.C0412k0;
import androidx.fragment.app.FragmentActivity;
import androidx.media3.exoplayer.smoothstreaming.SsMediaSource;
import com.google.android.gms.cast.framework.media.widget.ExpandedControllerActivity;
import java.io.IOException;
import p018b5.AbstractC1312l;
import p165p4.C3370o;
import p176q4.C3473b;
import p176q4.C3475c;
import p187r4.C3616f;
import p187r4.C3617g;
import p187r4.C3626p;
import p230v4.C3988b;

public final class ViewOnClickListenerC3810c implements View.OnClickListener {

    public final int f12858a;

    public final C3809b f12859b;

    public ViewOnClickListenerC3810c(C3809b c3809b, int i6) {
        this.f12858a = i6;
        this.f12859b = c3809b;
    }

    @Override
    public final void onClick(View view) {
        boolean z7;
        C3809b c3809b = this.f12859b;
        switch (this.f12858a) {
            case 0:
                C3475c c3475cM7142c = C3473b.m7099b(c3809b.f12851a.getApplicationContext()).m7102a().m7142c();
                if (c3475cM7142c != null && c3475cM7142c.m7136a()) {
                    try {
                        AbstractC1312l.m3195b("Must be called from the main thread.");
                        C3370o c3370o = c3475cM7142c.f11762i;
                        if (c3370o == null || !c3370o.m6865j()) {
                            z7 = false;
                        } else {
                            AbstractC1312l.m3200g("Not connected to device", c3370o.m6865j());
                            if (c3370o.f11391v) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                        }
                        c3475cM7142c.m7126g(!z7);
                    } catch (IOException | IllegalArgumentException e5) {
                        Object[] objArr = {e5};
                        C3988b c3988b = C3809b.f12850h;
                        Log.e(c3988b.f13521a, c3988b.m7977d("Unable to call CastSession.setMute(boolean).", objArr));
                        return;
                    }
                    break;
                }
                break;
            case 1:
                C3616f c3616fM7585p = c3809b.m7585p();
                if (c3616fM7585p != null && c3616fM7585p.m7305i()) {
                    c3616fM7585p.m7318v();
                    break;
                }
                break;
            case 2:
                C3616f c3616fM7585p2 = c3809b.m7585p();
                if (c3616fM7585p2 != null && c3616fM7585p2.m7305i()) {
                    c3616fM7585p2.m7313q();
                    break;
                }
                break;
            case 3:
                C3616f c3616fM7585p3 = c3809b.m7585p();
                if (c3616fM7585p3 != null && c3616fM7585p3.m7305i()) {
                    c3616fM7585p3.m7314r();
                    break;
                }
                break;
            case 4:
                C3616f c3616fM7585p4 = c3809b.m7585p();
                if (c3616fM7585p4 != null && c3616fM7585p4.m7305i()) {
                    if (!c3616fM7585p4.m7294D()) {
                        c3616fM7585p4.m7317u(c3616fM7585p4.m7299c() + SsMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_MS);
                    } else {
                        long jM7299c = c3616fM7585p4.m7299c() + SsMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_MS;
                        C3626p c3626p = c3809b.f12855e;
                        c3616fM7585p4.m7317u(Math.min(jM7299c, c3626p.m7351e() + ((long) c3626p.m7349c())));
                    }
                    break;
                }
                break;
            case 5:
                C3616f c3616fM7585p5 = c3809b.m7585p();
                if (c3616fM7585p5 != null && c3616fM7585p5.m7305i()) {
                    if (!c3616fM7585p5.m7294D()) {
                        c3616fM7585p5.m7317u(c3616fM7585p5.m7299c() - SsMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_MS);
                    } else {
                        long jM7299c2 = c3616fM7585p5.m7299c() - SsMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_MS;
                        C3626p c3626p2 = c3809b.f12855e;
                        c3616fM7585p5.m7317u(Math.max(jM7299c2, c3626p2.m7351e() + ((long) c3626p2.m7350d())));
                    }
                    break;
                }
                break;
            default:
                C3616f c3616fM7585p6 = c3809b.m7585p();
                if (c3616fM7585p6 != null && c3616fM7585p6.m7305i()) {
                    ExpandedControllerActivity expandedControllerActivity = c3809b.f12851a;
                    if (expandedControllerActivity instanceof FragmentActivity) {
                        C3617g c3617g = new C3617g();
                        C0412k0 c0412k0M1184k = expandedControllerActivity.m1184k();
                        c0412k0M1184k.getClass();
                        C0391a c0391a = new C0391a(c0412k0M1184k);
                        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427sM1264z = expandedControllerActivity.m1184k().m1264z("TRACKS_CHOOSER_DIALOG_TAG");
                        if (abstractComponentCallbacksC0427sM1264z != null) {
                            c0391a.m1193h(abstractComponentCallbacksC0427sM1264z);
                        }
                        c3617g.f1910h0 = false;
                        c3617g.f1911i0 = true;
                        c0391a.m1191f(0, c3617g, "TRACKS_CHOOSER_DIALOG_TAG", 1);
                        c3617g.f1909g0 = false;
                        c3617g.f1905c0 = c0391a.m1190e(false);
                    }
                    break;
                }
                break;
        }
    }
}
