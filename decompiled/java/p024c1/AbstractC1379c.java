package p024c1;

import android.os.Build;
import android.view.View;
import java.nio.ByteBuffer;
import p138n0.AbstractC3155s0;
import p138n0.C3100a;
import p138n0.C3103b;
import p221u6.C3905e;

public abstract class AbstractC1379c {

    public int f4191a;

    public int f4192b;

    public int f4193c;

    public Object f4194d;

    public AbstractC1379c() {
        if (C3905e.f13104b == null) {
            C3905e.f13104b = new C3905e(5);
        }
    }

    public int m3244a(int i6) {
        if (i6 < this.f4193c) {
            return ((ByteBuffer) this.f4194d).getShort(this.f4192b + i6);
        }
        return 0;
    }

    public abstract Object mo3245b(View view);

    public abstract void mo3246c(View view, Object obj);

    public void m3247d(View view, Object obj) {
        Object tag;
        C3103b c3103b;
        if (Build.VERSION.SDK_INT >= this.f4192b) {
            mo3246c(view, obj);
            return;
        }
        if (Build.VERSION.SDK_INT >= this.f4192b) {
            tag = mo3245b(view);
        } else {
            tag = view.getTag(this.f4191a);
            if (!((Class) this.f4194d).isInstance(tag)) {
                tag = null;
            }
        }
        if (mo3248e(tag, obj)) {
            View.AccessibilityDelegate accessibilityDelegateM6334d = AbstractC3155s0.m6334d(view);
            if (accessibilityDelegateM6334d == null) {
                c3103b = null;
            } else {
                c3103b = accessibilityDelegateM6334d instanceof C3100a ? ((C3100a) accessibilityDelegateM6334d).f10568a : new C3103b(accessibilityDelegateM6334d);
            }
            if (c3103b == null) {
                c3103b = new C3103b();
            }
            AbstractC3155s0.m6347q(view, c3103b);
            view.setTag(this.f4191a, obj);
            AbstractC3155s0.m6338h(this.f4193c, view);
        }
    }

    public abstract boolean mo3248e(Object obj, Object obj2);
}
