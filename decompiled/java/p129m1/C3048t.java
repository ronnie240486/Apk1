package p129m1;

import android.media.VolumeProvider;
import p173q1.C3399d;
import p173q1.C3411h;
import p173q1.RunnableC3396c;

public final class C3048t extends VolumeProvider {

    public final AbstractC3052x f10404a;

    public C3048t(AbstractC3052x abstractC3052x, int i6, int i10, int i11, String str) {
        super(i6, i10, i11, str);
        this.f10404a = abstractC3052x;
    }

    @Override
    public final void onAdjustVolume(int i6) {
        C3399d c3399d = (C3399d) this.f10404a;
        C3411h c3411h = c3399d.f11442g.f11449c;
        c3411h.f11488a.post(new RunnableC3396c(i6, 1, c3399d));
    }

    @Override
    public final void onSetVolumeTo(int i6) {
        C3399d c3399d = (C3399d) this.f10404a;
        C3411h c3411h = c3399d.f11442g.f11449c;
        c3411h.f11488a.post(new RunnableC3396c(i6, 0, c3399d));
    }
}
