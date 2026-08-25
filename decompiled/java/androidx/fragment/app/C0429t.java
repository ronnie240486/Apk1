package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.EnumC0537n;
import p227v1.InterfaceC3972d;

public final class C0429t implements InterfaceC3972d {

    public final FragmentActivity f1995a;

    public C0429t(FragmentActivity fragmentActivity) {
        this.f1995a = fragmentActivity;
    }

    @Override
    public final Bundle saveState() {
        FragmentActivity fragmentActivity;
        Bundle bundle = new Bundle();
        do {
            fragmentActivity = this.f1995a;
        } while (FragmentActivity.m1183l(fragmentActivity.m1184k()));
        fragmentActivity.f1766s.m1521f(EnumC0537n.ON_STOP);
        Parcelable parcelableM1230Q = ((C0433v) fragmentActivity.f1765r.f1833b).f2005i.m1230Q();
        if (parcelableM1230Q != null) {
            bundle.putParcelable("android:support:fragments", parcelableM1230Q);
        }
        return bundle;
    }
}
