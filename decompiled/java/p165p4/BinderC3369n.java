package p165p4;

import androidx.appcompat.app.RunnableC0126c;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.internal.zza;
import com.google.android.gms.cast.internal.zzac;
import com.google.android.gms.common.api.Status;
import p004a3.RunnableC0038c;
import p230v4.AbstractBinderC3991e;
import p230v4.C4006t;
import p242w5.C4056d;

public final class BinderC3369n extends AbstractBinderC3991e {

    public final C3370o f11371d;

    public BinderC3369n(C3370o c3370o) {
        this.f11371d = c3370o;
    }

    @Override
    public final void mo6843a(int i6) {
        C3370o c3370o = this.f11371d;
        C3370o.m6859e(c3370o, i6);
        if (c3370o.f11376C != null) {
            C3370o.m6860l(c3370o).post(new RunnableC3368m(this, i6, 2));
        }
    }

    @Override
    public final void mo6844c(zza zzaVar) {
        C3370o.m6860l(this.f11371d).post(new RunnableC0038c(25, this, zzaVar, false));
    }

    @Override
    public final void mo6845d(int i6) {
        C3370o.m6860l(this.f11371d).post(new RunnableC3368m(this, i6, 1));
    }

    @Override
    public final void mo6846e(int i6) {
        C3370o.m6859e(this.f11371d, i6);
    }

    @Override
    public final void mo6847k(int i6) {
        C3370o.m6860l(this.f11371d).post(new RunnableC3368m(this, i6, 3));
    }

    @Override
    public final void mo6848m(int i6) {
        C3370o.m6860l(this.f11371d).post(new RunnableC3368m(this, i6, 0));
    }

    @Override
    public final void mo6849n(String str, String str2) {
        C3370o.f11372F.m7975b("Receive (type=text, ns=%s) %s", str, str2);
        C3370o.m6860l(this.f11371d).post(new RunnableC0126c((Object) this, str, str2, 5));
    }

    @Override
    public final void mo6850o() {
        C3370o.f11372F.m7975b("Deprecated callback: \"onStatusReceived\"", new Object[0]);
    }

    @Override
    public final void mo6851p(int i6) {
        C3370o.m6859e(this.f11371d, i6);
    }

    @Override
    public final void mo6852q(int i6, long j10) {
        C3370o.m6858d(this.f11371d, j10, i6);
    }

    @Override
    public final void mo6853r(int i6) {
        this.f11371d.m6863h(i6);
    }

    @Override
    public final void mo6854s(String str, byte[] bArr) {
        C3370o.f11372F.m7975b("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", str, Integer.valueOf(bArr.length));
    }

    @Override
    public final void mo6855t(long j10) {
        C3370o.m6858d(this.f11371d, j10, 0);
    }

    @Override
    public final void mo6856u(ApplicationMetadata applicationMetadata, String str, String str2, boolean z7) {
        C3370o c3370o = this.f11371d;
        c3370o.f11388s = applicationMetadata;
        c3370o.f11389t = str;
        C4006t c4006t = new C4006t(new Status(0, null, null, null), applicationMetadata, str, str2, z7);
        synchronized (c3370o.f11386q) {
            try {
                C4056d c4056d = c3370o.f11383n;
                if (c4056d != null) {
                    c4056d.m8059b(c4006t);
                }
                c3370o.f11383n = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override
    public final void mo6857v(zzac zzacVar) {
        C3370o.m6860l(this.f11371d).post(new RunnableC0038c(24, this, zzacVar, false));
    }
}
