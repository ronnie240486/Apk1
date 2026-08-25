package p176q4;

import androidx.fragment.app.C0423q;
import androidx.mediarouter.app.MediaRouteButton;
import org.bitspark.android.Spark;
import p018b5.AbstractC1312l;
import p109k3.C2888t;
import p114k8.C2904d;
import p242w5.AbstractC4057e;
import p242w5.C4058f;
import p242w5.InterfaceC4053a;
import p242w5.InterfaceC4055c;

public final class C3477d {

    public boolean f11768a;

    public final Object f11769b;

    public final Object f11770c;

    public Object f11771d;

    public Object f11772e;

    public C3477d() {
        this.f11769b = new Object();
        this.f11770c = new C2888t(5);
    }

    public void m7128a(InterfaceC4053a interfaceC4053a) {
        ((C2888t) this.f11770c).m5891h(new C4058f(AbstractC4057e.f13721a, interfaceC4053a));
        m7134g();
    }

    public void m7129b(InterfaceC4055c interfaceC4055c) {
        ((C2888t) this.f11770c).m5891h(new C4058f(AbstractC4057e.f13721a, interfaceC4055c));
        m7134g();
    }

    public Exception m7130c() {
        Exception exc;
        synchronized (this.f11769b) {
            exc = (Exception) this.f11772e;
        }
        return exc;
    }

    public Object m7131d() {
        Object obj;
        synchronized (this.f11769b) {
            try {
                AbstractC1312l.m3200g("Task is not yet complete", this.f11768a);
                Exception exc = (Exception) this.f11772e;
                if (exc != null) {
                    throw new C0423q(exc, 11);
                }
                obj = this.f11771d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    public boolean m7132e() {
        boolean z7;
        synchronized (this.f11769b) {
            z7 = false;
            if (this.f11768a && ((Exception) this.f11772e) == null) {
                z7 = true;
            }
        }
        return z7;
    }

    public void m7133f() {
        boolean z7;
        String strConcat;
        if (this.f11768a) {
            int i6 = C2904d.f9859a;
            synchronized (this.f11769b) {
                z7 = this.f11768a;
            }
            if (!z7) {
                throw new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
            }
            Exception excM7130c = m7130c();
            if (excM7130c == null) {
                strConcat = m7132e() ? "result ".concat(String.valueOf(m7131d())) : "unknown issue";
            } else {
                strConcat = "failure";
            }
        }
    }

    public void m7134g() {
        synchronized (this.f11769b) {
            try {
                if (this.f11768a) {
                    ((C2888t) this.f11770c).m5892i(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public C3477d(Spark spark, MediaRouteButton mediaRouteButton) {
        this.f11769b = spark;
        AbstractC1312l.m3198e(mediaRouteButton);
        this.f11770c = mediaRouteButton;
    }
}
