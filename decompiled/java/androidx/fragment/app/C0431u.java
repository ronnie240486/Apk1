package androidx.fragment.app;

import android.os.Bundle;
import androidx.appcompat.widget.C0280v;
import p012b.InterfaceC1225b;

public final class C0431u implements InterfaceC1225b {

    public final FragmentActivity f1998a;

    public C0431u(FragmentActivity fragmentActivity) {
        this.f1998a = fragmentActivity;
    }

    @Override
    public final void mo0a() {
        FragmentActivity fragmentActivity = this.f1998a;
        C0433v c0433v = (C0433v) fragmentActivity.f1765r.f1833b;
        c0433v.f2005i.m1240b(c0433v, c0433v, null);
        Bundle bundleM787c = ((C0280v) fragmentActivity.f229e.f9833d).m787c("android:support:fragments");
        if (bundleM787c != null) {
            ((C0433v) fragmentActivity.f1765r.f1833b).f2005i.m1229P(bundleM787c.getParcelable("android:support:fragments"));
        }
    }
}
