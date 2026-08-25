package p230v4;

import androidx.appcompat.app.RunnableC0126c;
import androidx.leanback.widget.RunnableC0485n0;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.internal.zza;
import com.google.android.gms.cast.internal.zzac;
import com.google.android.gms.internal.cast.HandlerC1731y0;
import java.util.concurrent.atomic.AtomicReference;
import p018b5.HandlerC1314n;
import ua.RunnableC3940a;

public final class BinderC4007u extends AbstractBinderC3991e {

    public final AtomicReference f13571d;

    public final HandlerC1731y0 f13572e;

    public BinderC4007u(C4008v c4008v) {
        this.f13571d = new AtomicReference(c4008v);
        this.f13572e = new HandlerC1731y0(c4008v.f5072d, 0);
    }

    @Override
    public final void mo6843a(int i6) {
        C4008v c4008v = (C4008v) this.f13571d.get();
        if (c4008v == null) {
            return;
        }
        c4008v.f13590O = null;
        c4008v.f13591P = null;
        synchronized (C4008v.f13575U) {
        }
        if (c4008v.f13577B != null) {
            this.f13572e.post(new RunnableC0485n0(i6, 5, c4008v));
        }
    }

    @Override
    public final void mo6844c(zza zzaVar) {
        C4008v c4008v = (C4008v) this.f13571d.get();
        if (c4008v == null) {
            return;
        }
        C4008v.f13573S.m7975b("onApplicationStatusChanged", new Object[0]);
        this.f13572e.post(new RunnableC3940a(c4008v, 2, zzaVar));
    }

    @Override
    public final void mo6846e(int i6) {
        if (((C4008v) this.f13571d.get()) == null) {
            return;
        }
        synchronized (C4008v.f13575U) {
        }
    }

    @Override
    public final void mo6848m(int i6) {
        C4008v c4008v = null;
        C4008v c4008v2 = (C4008v) this.f13571d.getAndSet(null);
        if (c4008v2 != null) {
            c4008v2.f13588M = -1;
            c4008v2.f13589N = -1;
            c4008v2.f13594z = null;
            c4008v2.f13582G = null;
            c4008v2.f13586K = 0.0d;
            c4008v2.m8004B();
            c4008v2.f13583H = false;
            c4008v2.f13587L = null;
            c4008v = c4008v2;
        }
        if (c4008v == null) {
            return;
        }
        C4008v.f13573S.m7975b("ICastDeviceControllerListener.onDisconnected: %d", Integer.valueOf(i6));
        if (i6 != 0) {
            int i10 = c4008v.f5091w.get();
            HandlerC1314n handlerC1314n = c4008v.f5074f;
            handlerC1314n.sendMessage(handlerC1314n.obtainMessage(6, i10, 2));
        }
    }

    @Override
    public final void mo6849n(String str, String str2) {
        C4008v c4008v = (C4008v) this.f13571d.get();
        if (c4008v == null) {
            return;
        }
        C4008v.f13573S.m7975b("Receive (type=text, ns=%s) %s", str, str2);
        this.f13572e.post(new RunnableC0126c((Object) c4008v, str, str2, 6));
    }

    @Override
    public final void mo6850o() {
        C4008v.f13573S.m7975b("Deprecated callback: \"onStatusreceived\"", new Object[0]);
    }

    @Override
    public final void mo6851p(int i6) {
        if (((C4008v) this.f13571d.get()) == null) {
            return;
        }
        synchronized (C4008v.f13575U) {
        }
    }

    @Override
    public final void mo6852q(int i6, long j10) {
        C4008v c4008v = (C4008v) this.f13571d.get();
        if (c4008v == null) {
            return;
        }
        C4008v.m8002z(c4008v, j10);
    }

    @Override
    public final void mo6853r(int i6) {
        if (((C4008v) this.f13571d.get()) == null) {
            return;
        }
        synchronized (C4008v.f13574T) {
        }
    }

    @Override
    public final void mo6854s(String str, byte[] bArr) {
        if (((C4008v) this.f13571d.get()) == null) {
            return;
        }
        C4008v.f13573S.m7975b("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", str, Integer.valueOf(bArr.length));
    }

    @Override
    public final void mo6855t(long j10) {
        C4008v c4008v = (C4008v) this.f13571d.get();
        if (c4008v == null) {
            return;
        }
        C4008v.m8002z(c4008v, j10);
    }

    @Override
    public final void mo6856u(ApplicationMetadata applicationMetadata, String str, String str2, boolean z7) {
        C4008v c4008v = (C4008v) this.f13571d.get();
        if (c4008v == null) {
            return;
        }
        c4008v.f13594z = applicationMetadata;
        c4008v.f13590O = applicationMetadata.f4590a;
        c4008v.f13591P = str2;
        c4008v.f13582G = str;
        synchronized (C4008v.f13574T) {
        }
    }

    @Override
    public final void mo6857v(zzac zzacVar) {
        C4008v c4008v = (C4008v) this.f13571d.get();
        if (c4008v == null) {
            return;
        }
        C4008v.f13573S.m7975b("onDeviceStatusChanged", new Object[0]);
        this.f13572e.post(new RunnableC3940a(c4008v, 1, zzacVar));
    }

    @Override
    public final void mo6845d(int i6) {
    }

    @Override
    public final void mo6847k(int i6) {
    }
}
