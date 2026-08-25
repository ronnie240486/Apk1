package p173q1;

import android.content.ComponentName;
import android.content.Context;
import androidx.appcompat.app.C0157r0;
import androidx.mediarouter.app.HandlerC1080c;
import java.util.Objects;
import p101j7.C2782c;
import p222u7.AbstractC3928d;

public abstract class AbstractC3403e0 {

    public final Context f11450a;

    public final C2782c f11451b;

    public final HandlerC1080c f11452c = new HandlerC1080c(8, this);

    public AbstractC3928d f11453d;

    public C3456x f11454e;

    public boolean f11455f;

    public C0157r0 f11456g;

    public boolean f11457h;

    public AbstractC3403e0(Context context, C2782c c2782c) {
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        }
        this.f11450a = context;
        if (c2782c != null) {
            this.f11451b = c2782c;
        } else {
            this.f11451b = new C2782c(27, new ComponentName(context, getClass()));
        }
    }

    public AbstractC3394b0 mo6902a(String str, C3400d0 c3400d0) {
        if (str != null) {
            return null;
        }
        throw new IllegalArgumentException("initialMemberRouteId cannot be null.");
    }

    public AbstractC3397c0 mo6903b(String str) {
        if (str != null) {
            return null;
        }
        throw new IllegalArgumentException("routeId cannot be null");
    }

    public AbstractC3397c0 mo6904c(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("routeId cannot be null");
        }
        if (str2 != null) {
            return mo6905d(str, C3400d0.f11443b);
        }
        throw new IllegalArgumentException("routeGroupId cannot be null");
    }

    public AbstractC3397c0 mo6905d(String str, C3400d0 c3400d0) {
        return mo6903b(str);
    }

    public abstract void mo6906e(C3456x c3456x);

    public final void m6907f(C0157r0 c0157r0) {
        C3451u0.m7067b();
        if (this.f11456g != c0157r0) {
            this.f11456g = c0157r0;
            if (this.f11457h) {
                return;
            }
            this.f11457h = true;
            this.f11452c.sendEmptyMessage(1);
        }
    }

    public final void m6908g(C3456x c3456x) {
        C3451u0.m7067b();
        if (Objects.equals(this.f11454e, c3456x)) {
            return;
        }
        this.f11454e = c3456x;
        if (this.f11455f) {
            return;
        }
        this.f11455f = true;
        this.f11452c.sendEmptyMessage(2);
    }
}
