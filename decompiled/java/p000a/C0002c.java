package p000a;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.C0536m0;
import java.util.ArrayList;
import java.util.HashMap;
import p227v1.InterfaceC3972d;

public final class C0002c implements InterfaceC3972d {

    public final int f2a;

    public final Object f3b;

    public C0002c(int i6, Object obj) {
        this.f2a = i6;
        this.f3b = obj;
    }

    @Override
    public final Bundle saveState() {
        Object obj = this.f3b;
        switch (this.f2a) {
            case 0:
                int i6 = ComponentActivity.f225q;
                ComponentActivity componentActivity = (ComponentActivity) obj;
                componentActivity.getClass();
                Bundle bundle = new Bundle();
                C0006g c0006g = componentActivity.f233i;
                c0006g.getClass();
                HashMap map = c0006g.f9c;
                bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(map.values()));
                bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(map.keySet()));
                bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(c0006g.f11e));
                bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) c0006g.f14h.clone());
                bundle.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", c0006g.f7a);
                return bundle;
            default:
                return C0536m0.m1500a((C0536m0) obj);
        }
    }
}
