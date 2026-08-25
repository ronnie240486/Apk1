package androidx.lifecycle;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.C0280v;
import java.util.Map;
import p103j9.AbstractC2796i;
import p227v1.InterfaceC3972d;
import p243w8.C4067i;

public final class C0544q0 implements InterfaceC3972d {

    public final C0280v f2521a;

    public boolean f2522b;

    public Bundle f2523c;

    public final C4067i f2524d;

    public C0544q0(C0280v c0280v, ComponentActivity componentActivity) {
        AbstractC2796i.m5785f(c0280v, "savedStateRegistry");
        this.f2521a = c0280v;
        this.f2524d = new C4067i(new C0542p0(0, componentActivity));
    }

    public final void m1511a() {
        if (this.f2522b) {
            return;
        }
        Bundle bundleM787c = this.f2521a.m787c("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f2523c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if (bundleM787c != null) {
            bundle.putAll(bundleM787c);
        }
        this.f2523c = bundle;
        this.f2522b = true;
    }

    @Override
    public final Bundle saveState() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f2523c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry entry : ((C0546r0) this.f2524d.getValue()).f2527d.entrySet()) {
            String str = (String) entry.getKey();
            Bundle bundleSaveState = ((C0536m0) entry.getValue()).f2503e.saveState();
            if (!AbstractC2796i.m5780a(bundleSaveState, Bundle.EMPTY)) {
                bundle.putBundle(str, bundleSaveState);
            }
        }
        this.f2522b = false;
        return bundle;
    }
}
