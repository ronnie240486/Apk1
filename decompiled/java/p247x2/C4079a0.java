package p247x2;

import android.os.SystemClock;
import android.util.Log;
import com.bumptech.glide.load.data.InterfaceC1479e;
import com.bumptech.glide.load.data.InterfaceC1481g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import p016b3.C1287t;
import p124l6.C2982h;
import p186r3.AbstractC3604h;
import p187r4.C3621k;
import p228v2.InterfaceC3975b;
import p228v2.InterfaceC3978e;
import p269z2.InterfaceC4300a;

public final class C4079a0 implements InterfaceC4084f, InterfaceC4083e {

    public final C4085g f13754a;

    public final RunnableC4087i f13755b;

    public volatile int f13756c;

    public volatile C4081c f13757d;

    public volatile Object f13758e;

    public volatile C1287t f13759f;

    public volatile C4082d f13760g;

    public C4079a0(C4085g c4085g, RunnableC4087i runnableC4087i) {
        this.f13754a = c4085g;
        this.f13755b = runnableC4087i;
    }

    @Override
    public final void mo8067a(InterfaceC3978e interfaceC3978e, Exception exc, InterfaceC1479e interfaceC1479e, int i6) {
        this.f13755b.mo8067a(interfaceC3978e, exc, interfaceC1479e, this.f13759f.f4054c.mo3153d());
    }

    @Override
    public final boolean mo8068b() {
        if (this.f13758e != null) {
            Object obj = this.f13758e;
            this.f13758e = null;
            try {
                if (!m8070d(obj)) {
                    return true;
                }
            } catch (IOException e5) {
                if (Log.isLoggable("SourceGenerator", 3)) {
                    Log.d("SourceGenerator", "Failed to properly rewind or write data to cache", e5);
                }
            }
        }
        if (this.f13757d != null && this.f13757d.mo8068b()) {
            return true;
        }
        this.f13757d = null;
        this.f13759f = null;
        boolean z7 = false;
        while (!z7 && this.f13756c < this.f13754a.m8072b().size()) {
            ArrayList arrayListM8072b = this.f13754a.m8072b();
            int i6 = this.f13756c;
            this.f13756c = i6 + 1;
            this.f13759f = (C1287t) arrayListM8072b.get(i6);
            if (this.f13759f != null && (this.f13754a.f13787p.m8094a(this.f13759f.f4054c.mo3153d()) || this.f13754a.m8073c(this.f13759f.f4054c.mo3151a()) != null)) {
                this.f13759f.f4054c.mo3154f(this.f13754a.f13786o, new C2982h(this, 12, this.f13759f));
                z7 = true;
            }
        }
        return z7;
    }

    @Override
    public final void mo8069c(InterfaceC3978e interfaceC3978e, Object obj, InterfaceC1479e interfaceC1479e, int i6, InterfaceC3978e interfaceC3978e2) {
        this.f13755b.mo8069c(interfaceC3978e, obj, interfaceC1479e, this.f13759f.f4054c.mo3153d(), interfaceC3978e);
    }

    @Override
    public final void cancel() {
        C1287t c1287t = this.f13759f;
        if (c1287t != null) {
            c1287t.f4054c.cancel();
        }
    }

    public final boolean m8070d(Object obj) throws Throwable {
        int i6 = AbstractC3604h.f12101b;
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        boolean z7 = false;
        try {
            InterfaceC1481g interfaceC1481gM3528h = this.f13754a.f13774c.m3518b().m3528h(obj);
            Object objMo3551e = interfaceC1481gM3528h.mo3551e();
            InterfaceC3975b interfaceC3975bM8074d = this.f13754a.m8074d(objMo3551e);
            C3621k c3621k = new C3621k(interfaceC3975bM8074d, objMo3551e, this.f13754a.f13780i, 5);
            InterfaceC3978e interfaceC3978e = this.f13759f.f4052a;
            C4085g c4085g = this.f13754a;
            C4082d c4082d = new C4082d(interfaceC3978e, c4085g.f13785n);
            InterfaceC4300a interfaceC4300aM3103a = c4085g.f13779h.m3103a();
            interfaceC4300aM3103a.mo6923c(c4082d, c3621k);
            if (Log.isLoggable("SourceGenerator", 2)) {
                Log.v("SourceGenerator", "Finished encoding source to cache, key: " + c4082d + ", data: " + obj + ", encoder: " + interfaceC3975bM8074d + ", duration: " + AbstractC3604h.m7226a(jElapsedRealtimeNanos));
            }
            if (interfaceC4300aM3103a.mo6926h(c4082d) != null) {
                this.f13760g = c4082d;
                this.f13757d = new C4081c(Collections.singletonList(this.f13759f.f4052a), this.f13754a, this);
                this.f13759f.f4054c.mo3152b();
                return true;
            }
            if (Log.isLoggable("SourceGenerator", 3)) {
                Log.d("SourceGenerator", "Attempt to write: " + this.f13760g + ", data: " + obj + " to the disk cache failed, maybe the disk cache is disabled? Trying to decode the data directly...");
            }
            try {
                this.f13755b.mo8069c(this.f13759f.f4052a, interfaceC1481gM3528h.mo3551e(), this.f13759f.f4054c, this.f13759f.f4054c.mo3153d(), this.f13759f.f4052a);
                return false;
            } catch (Throwable th) {
                th = th;
                z7 = true;
                if (!z7) {
                    this.f13759f.f4054c.mo3152b();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
