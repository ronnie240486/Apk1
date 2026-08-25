package androidx.appcompat.app;

import android.os.Bundle;
import androidx.appcompat.widget.C0280v;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import p103j9.AbstractC2796i;
import p227v1.InterfaceC3972d;

public final class C0142k implements InterfaceC3972d {

    public final int f395a = 0;

    public final Object f396b;

    public C0142k(C0280v c0280v) {
        AbstractC2796i.m5785f(c0280v, "registry");
        this.f396b = new LinkedHashSet();
        c0280v.m790f("androidx.savedstate.Restarter", this);
    }

    @Override
    public final Bundle saveState() {
        switch (this.f395a) {
            case 0:
                Bundle bundle = new Bundle();
                ((AppCompatActivity) this.f396b).m364m().getClass();
                return bundle;
            default:
                Bundle bundle2 = new Bundle();
                bundle2.putStringArrayList("classes_to_restore", new ArrayList<>((LinkedHashSet) this.f396b));
                return bundle2;
        }
    }

    public C0142k(AppCompatActivity appCompatActivity) {
        this.f396b = appCompatActivity;
    }
}
