package p269z2;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import p048e2.C2368c;
import p086i3.C2685a;
import p124l6.C2982h;
import p187r4.C3621k;
import p187r4.C3624n;
import p197s2.C3699c;
import p228v2.C3981h;
import p228v2.InterfaceC3975b;
import p228v2.InterfaceC3978e;

public final class C4302c implements InterfaceC4300a {

    public final File f14596b;

    public final long f14597c;

    public C3699c f14599e;

    public final C2982h f14598d = new C2982h(15);

    public final C2982h f14595a = new C2982h(16);

    public C4302c(File file, long j10) {
        this.f14596b = file;
        this.f14597c = j10;
    }

    public final synchronized C3699c m8353a() {
        try {
            if (this.f14599e == null) {
                this.f14599e = C3699c.m7454h(this.f14596b, this.f14597c);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f14599e;
    }

    @Override
    public final void mo6923c(InterfaceC3978e interfaceC3978e, C3621k c3621k) {
        C4301b c4301bM5685a;
        String strM6048u = this.f14595a.m6048u(interfaceC3978e);
        C2982h c2982h = this.f14598d;
        synchronized (c2982h) {
            try {
                c4301bM5685a = (C4301b) ((HashMap) c2982h.f10225b).get(strM6048u);
                if (c4301bM5685a == null) {
                    c4301bM5685a = ((C2685a) c2982h.f10226c).m5685a();
                    ((HashMap) c2982h.f10225b).put(strM6048u, c4301bM5685a);
                }
                c4301bM5685a.f14594b++;
            } catch (Throwable th) {
                throw th;
            }
        }
        c4301bM5685a.f14593a.lock();
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + strM6048u + " for for Key: " + interfaceC3978e);
            }
            try {
                C3699c c3699cM8353a = m8353a();
                if (c3699cM8353a.m7457f(strM6048u) != null) {
                    this.f14598d.m6053z(strM6048u);
                    return;
                }
                C2368c c2368cM7456d = c3699cM8353a.m7456d(strM6048u);
                if (c2368cM7456d == null) {
                    throw new IllegalStateException("Had two simultaneous puts for: ".concat(strM6048u));
                }
                try {
                    if (((InterfaceC3975b) c3621k.f12170b).mo93i(c3621k.f12171c, c2368cM7456d.m5384f(), (C3981h) c3621k.f12172d)) {
                        C3699c.m7450a((C3699c) c2368cM7456d.f8289d, c2368cM7456d, true);
                        c2368cM7456d.f8286a = true;
                    }
                    if (!c2368cM7456d.f8286a) {
                        try {
                            c2368cM7456d.m5381c();
                        } catch (IOException unused) {
                        }
                    }
                    this.f14598d.m6053z(strM6048u);
                } catch (Throwable th2) {
                    if (!c2368cM7456d.f8286a) {
                        try {
                            c2368cM7456d.m5381c();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th2;
                }
            } catch (IOException e5) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e5);
                }
            }
        } catch (Throwable th3) {
            this.f14598d.m6053z(strM6048u);
            throw th3;
        }
    }

    @Override
    public final File mo6926h(InterfaceC3978e interfaceC3978e) {
        String strM6048u = this.f14595a.m6048u(interfaceC3978e);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + strM6048u + " for for Key: " + interfaceC3978e);
        }
        try {
            C3624n c3624nM7457f = m8353a().m7457f(strM6048u);
            if (c3624nM7457f != null) {
                return ((File[]) c3624nM7457f.f12182b)[0];
            }
            return null;
        } catch (IOException e5) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e5);
            return null;
        }
    }
}
