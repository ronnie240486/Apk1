package p048e2;

import android.net.ConnectivityManager;
import android.util.Log;
import com.google.android.gms.internal.cast.C1668r0;
import java.io.File;
import okio.Path;
import p012b.C1224a;
import p103j9.AbstractC2796i;
import p109k3.C2882n;
import p109k3.InterfaceC2883o;
import p185r2.AbstractC3587f;
import p197s2.C3698b;
import p197s2.C3699c;

public final class C2368c implements InterfaceC2883o {

    public boolean f8286a;

    public final Object f8287b;

    public final Object f8288c;

    public final Object f8289d;

    public C2368c(C1224a c1224a, C2882n c2882n) {
        this.f8289d = new C1668r0(1, this);
        this.f8288c = c1224a;
        this.f8287b = c2882n;
    }

    @Override
    public void mo5379a() {
        ((ConnectivityManager) ((C1224a) this.f8288c).get()).unregisterNetworkCallback((C1668r0) this.f8289d);
    }

    @Override
    public boolean mo5380b() {
        C1224a c1224a = (C1224a) this.f8288c;
        this.f8286a = ((ConnectivityManager) c1224a.get()).getActiveNetwork() != null;
        try {
            ((ConnectivityManager) c1224a.get()).registerDefaultNetworkCallback((C1668r0) this.f8289d);
            return true;
        } catch (RuntimeException e5) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to register callback", e5);
            }
            return false;
        }
    }

    public void m5381c() {
        C3699c.m7450a((C3699c) this.f8289d, this, false);
    }

    public void m5382d(boolean z7) {
        C2373h c2373h = (C2373h) this.f8289d;
        synchronized (c2373h) {
            try {
                if (this.f8286a) {
                    throw new IllegalStateException("editor is closed");
                }
                if (AbstractC2796i.m5780a(((C2369d) this.f8287b).f8296g, this)) {
                    C2373h.m5386a(c2373h, this, z7);
                }
                this.f8286a = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Path m5383e(int i6) {
        Path path;
        C2373h c2373h = (C2373h) this.f8289d;
        synchronized (c2373h) {
            if (this.f8286a) {
                throw new IllegalStateException("editor is closed");
            }
            ((boolean[]) this.f8288c)[i6] = true;
            Object obj = ((C2369d) this.f8287b).f8293d.get(i6);
            C2371f c2371f = c2373h.f8319p;
            Path path2 = (Path) obj;
            if (!c2371f.exists(path2)) {
                AbstractC3587f.m7208a(c2371f.sink(path2));
            }
            path = (Path) obj;
        }
        return path;
    }

    public File m5384f() {
        File file;
        synchronized (((C3699c) this.f8289d)) {
            try {
                C3698b c3698b = (C3698b) this.f8287b;
                if (c3698b.f12388f != this) {
                    throw new IllegalStateException();
                }
                if (!c3698b.f12387e) {
                    ((boolean[]) this.f8288c)[0] = true;
                }
                file = c3698b.f12386d[0];
                ((C3699c) this.f8289d).f12390a.mkdirs();
            } catch (Throwable th) {
                throw th;
            }
        }
        return file;
    }

    public C2368c(C2373h c2373h, C2369d c2369d) {
        this.f8289d = c2373h;
        this.f8287b = c2369d;
        c2373h.getClass();
        this.f8288c = new boolean[2];
    }

    public C2368c(C3699c c3699c, C3698b c3698b) {
        this.f8289d = c3699c;
        this.f8287b = c3698b;
        this.f8288c = c3698b.f12387e ? null : new boolean[c3699c.f12396g];
    }
}
