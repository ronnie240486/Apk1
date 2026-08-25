package p271z4;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import p124l6.C2982h;
import p187r4.C3621k;
import p242w5.C4056d;
import p261y4.C4257e;

public final class C4353x extends AbstractC4346q {

    public final C4056d f14759b;

    public final int f14760c;

    public final Object f14761d;

    public C4353x(int i6, C4056d c4056d) {
        super(i6);
        this.f14759b = c4056d;
    }

    @Override
    public final boolean mo8383a(C4343n c4343n) {
        switch (this.f14760c) {
            case 0:
                ((C4350u) this.f14761d).f14748a.getClass();
                return true;
            default:
                return ((C4350u) c4343n.f14725h.get((C4336g) this.f14761d)) != null;
        }
    }

    @Override
    public final Feature[] mo8384b(C4343n c4343n) {
        switch (this.f14760c) {
            case 0:
                return (Feature[]) ((C4350u) this.f14761d).f14748a.f12171c;
            default:
                C4350u c4350u = (C4350u) c4343n.f14725h.get((C4336g) this.f14761d);
                if (c4350u == null) {
                    return null;
                }
                return (Feature[]) c4350u.f14748a.f12171c;
        }
    }

    @Override
    public final void mo8385c(Status status) {
        this.f14759b.m8060c(new C4257e(status));
    }

    @Override
    public final void mo8386d(RuntimeException runtimeException) {
        this.f14759b.m8060c(runtimeException);
    }

    @Override
    public final void mo8387e(C4343n c4343n) throws DeadObjectException {
        try {
            m8392h(c4343n);
        } catch (DeadObjectException e5) {
            mo8385c(AbstractC4346q.m8382g(e5));
            throw e5;
        } catch (RemoteException e10) {
            mo8385c(AbstractC4346q.m8382g(e10));
        } catch (RuntimeException e11) {
            this.f14759b.m8060c(e11);
        }
    }

    @Override
    public final void mo8388f(C2982h c2982h, boolean z7) {
        int i6 = this.f14760c;
    }

    public final void m8392h(C4343n c4343n) {
        switch (this.f14760c) {
            case 0:
                C3621k c3621k = ((C4350u) this.f14761d).f14748a;
                ((C4339j) c3621k.f12172d).f14714a.mo99p(c4343n.f14721d, this.f14759b);
                C4336g c4336g = ((C4337h) ((C4350u) this.f14761d).f14748a.f12170b).f14713a;
                if (c4336g != null) {
                    c4343n.f14725h.put(c4336g, (C4350u) this.f14761d);
                }
                break;
            default:
                C4350u c4350u = (C4350u) c4343n.f14725h.remove((C4336g) this.f14761d);
                if (c4350u == null) {
                    this.f14759b.m8061d(Boolean.FALSE);
                } else {
                    ((C4339j) c4350u.f14749b.f12182b).f14715b.mo99p(c4343n.f14721d, this.f14759b);
                    ((C4337h) c4350u.f14748a.f12170b).f14713a = null;
                }
                break;
        }
    }

    public C4353x(C4336g c4336g, C4056d c4056d) {
        this(4, c4056d);
        this.f14760c = 1;
        this.f14761d = c4336g;
    }

    public C4353x(C4350u c4350u, C4056d c4056d) {
        this(3, c4056d);
        this.f14760c = 0;
        this.f14761d = c4350u;
    }

    private final void m8390i(C2982h c2982h, boolean z7) {
    }

    private final void m8391j(C2982h c2982h, boolean z7) {
    }
}
