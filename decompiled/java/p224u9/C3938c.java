package p224u9;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import p008a9.InterfaceC0079i;
import p055ea.AbstractC2460q;
import p103j9.AbstractC2796i;
import p213t9.AbstractC3819b0;
import p213t9.AbstractC3855p;
import p213t9.AbstractC3865u;
import p213t9.InterfaceC3873y;
import p254x9.AbstractC4172n;
import p275z9.C4362d;

public final class C3938c extends AbstractC3855p implements InterfaceC3873y {
    private volatile C3938c _immediate;

    public final Handler f13234c;

    public final String f13235d;

    public final boolean f13236e;

    public final C3938c f13237f;

    public C3938c(Handler handler, String str, boolean z7) {
        this.f13234c = handler;
        this.f13235d = str;
        this.f13236e = z7;
        this._immediate = z7 ? this : null;
        C3938c c3938c = this._immediate;
        if (c3938c == null) {
            c3938c = new C3938c(handler, str, true);
            this._immediate = c3938c;
        }
        this.f13237f = c3938c;
    }

    @Override
    public final void mo7665d(InterfaceC0079i interfaceC0079i, Runnable runnable) {
        if (this.f13234c.post(runnable)) {
            return;
        }
        AbstractC3865u.m7686a(interfaceC0079i, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        AbstractC3819b0.f12902b.mo7665d(interfaceC0079i, runnable);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof C3938c) && ((C3938c) obj).f13234c == this.f13234c;
    }

    @Override
    public final boolean mo7683g() {
        return (this.f13236e && AbstractC2796i.m5780a(Looper.myLooper(), this.f13234c.getLooper())) ? false : true;
    }

    public final int hashCode() {
        return System.identityHashCode(this.f13234c);
    }

    @Override
    public final String toString() {
        C3938c c3938c;
        String str;
        C4362d c4362d = AbstractC3819b0.f12901a;
        C3938c c3938c2 = AbstractC4172n.f14112a;
        if (this == c3938c2) {
            str = "Dispatchers.Main";
        } else {
            try {
                c3938c = c3938c2.f13237f;
            } catch (UnsupportedOperationException unused) {
                c3938c = null;
            }
            str = this == c3938c ? "Dispatchers.Main.immediate" : null;
        }
        if (str != null) {
            return str;
        }
        String string = this.f13235d;
        if (string == null) {
            string = this.f13234c.toString();
        }
        return this.f13236e ? AbstractC2460q.m5494h(string, ".immediate") : string;
    }

    public C3938c(Handler handler) {
        this(handler, null, false);
    }
}
