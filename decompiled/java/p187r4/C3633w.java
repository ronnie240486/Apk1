package p187r4;

import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.cast.HandlerC1731y0;
import p000a.AbstractC0004e;
import p230v4.C3988b;
import p261y4.InterfaceC4264l;

public final class C3633w {

    public final int f12201a;

    public final C3611a f12202b;

    public C3633w(C3611a c3611a, int i6) {
        this.f12201a = i6;
        this.f12202b = c3611a;
    }

    public final void m7359a(InterfaceC4264l interfaceC4264l) {
        C3622l c3622l = (C3622l) interfaceC4264l;
        switch (this.f12201a) {
            case 0:
                C3611a c3611a = this.f12202b;
                c3611a.getClass();
                Status statusMo3637h = c3622l.mo3637h();
                int i6 = statusMo3637h.f4994a;
                if (i6 != 0) {
                    StringBuilder sbM27u = AbstractC0004e.m27u(i6, "Error fetching queue item ids, statusCode=", ", statusMessage=");
                    sbM27u.append(statusMo3637h.f4995b);
                    C3988b c3988b = c3611a.f12115a;
                    Log.w(c3988b.f13521a, c3988b.m7977d(sbM27u.toString(), new Object[0]));
                }
                c3611a.f12126l = null;
                if (!c3611a.f12122h.isEmpty()) {
                    HandlerC1731y0 handlerC1731y0 = c3611a.f12123i;
                    C3627q c3627q = c3611a.f12124j;
                    handlerC1731y0.removeCallbacks(c3627q);
                    handlerC1731y0.postDelayed(c3627q, 500L);
                }
                break;
            default:
                C3611a c3611a2 = this.f12202b;
                c3611a2.getClass();
                Status statusMo3637h2 = c3622l.mo3637h();
                int i10 = statusMo3637h2.f4994a;
                if (i10 != 0) {
                    StringBuilder sbM27u2 = AbstractC0004e.m27u(i10, "Error fetching queue items, statusCode=", ", statusMessage=");
                    sbM27u2.append(statusMo3637h2.f4995b);
                    C3988b c3988b2 = c3611a2.f12115a;
                    Log.w(c3988b2.f13521a, c3988b2.m7977d(sbM27u2.toString(), new Object[0]));
                }
                c3611a2.f12125k = null;
                if (!c3611a2.f12122h.isEmpty()) {
                    HandlerC1731y0 handlerC1731y1 = c3611a2.f12123i;
                    C3627q c3627q2 = c3611a2.f12124j;
                    handlerC1731y1.removeCallbacks(c3627q2);
                    handlerC1731y1.postDelayed(c3627q2, 500L);
                }
                break;
        }
    }
}
