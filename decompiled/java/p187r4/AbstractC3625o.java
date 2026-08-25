package p187r4;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import java.util.Iterator;
import p176q4.C3474b0;
import p230v4.C3996j;
import p230v4.InterfaceC3999m;
import p261y4.InterfaceC4264l;

public abstract class AbstractC3625o extends BasePendingResult {

    public C3624n f12183r;

    public final boolean f12184s;

    public final C3616f f12185t;

    public AbstractC3625o(C3616f c3616f, boolean z7) {
        this.f12185t = c3616f;
        this.f12184s = z7;
    }

    @Override
    public final InterfaceC4264l mo3639c0(Status status) {
        return new C3622l(status, 1);
    }

    public abstract void mo7323k0();

    public final InterfaceC3999m m7344l0() {
        if (this.f12183r == null) {
            this.f12183r = new C3624n(0, this);
        }
        return this.f12183r;
    }

    public final void m7345m0() {
        if (!this.f12184s) {
            C3616f c3616f = this.f12185t;
            Iterator it = c3616f.f12154g.iterator();
            while (it.hasNext()) {
                ((InterfaceC3614d) it.next()).mo7286f();
            }
            Iterator it2 = c3616f.f12155h.iterator();
            while (it2.hasNext()) {
                ((C3474b0) it2.next()).getClass();
            }
        }
        try {
            synchronized (this.f12185t.f12148a) {
                mo7323k0();
            }
        } catch (C3996j unused) {
            m3643g0(new C3622l(new Status(2100, null, null, null), 1));
        }
    }
}
