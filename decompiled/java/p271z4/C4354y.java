package p271z4;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import java.util.Map;
import p028c6.C1400c;
import p124l6.C2982h;
import p242w5.C4056d;
import p261y4.C4257e;
import p261y4.C4263k;

public final class C4354y extends AbstractC4346q {

    public final C1400c f14762b;

    public final C4056d f14763c;

    public final C4330a f14764d;

    public C4354y(int i6, C1400c c1400c, C4056d c4056d, C4330a c4330a) {
        super(i6);
        this.f14763c = c4056d;
        this.f14762b = c1400c;
        this.f14764d = c4330a;
        if (i6 == 2 && c1400c.f4264b) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    @Override
    public final boolean mo8383a(C4343n c4343n) {
        return this.f14762b.f4264b;
    }

    @Override
    public final Feature[] mo8384b(C4343n c4343n) {
        return (Feature[]) this.f14762b.f4265c;
    }

    @Override
    public final void mo8385c(Status status) {
        this.f14764d.getClass();
        this.f14763c.m8060c(status.f4996c != null ? new C4263k(status) : new C4257e(status));
    }

    @Override
    public final void mo8386d(RuntimeException runtimeException) {
        this.f14763c.m8060c(runtimeException);
    }

    @Override
    public final void mo8387e(C4343n c4343n) throws DeadObjectException {
        C4056d c4056d = this.f14763c;
        try {
            C1400c c1400c = this.f14762b;
            ((InterfaceC4340k) ((C1400c) c1400c.f4266d).f4265c).mo99p(c4343n.f14721d, c4056d);
        } catch (DeadObjectException e5) {
            throw e5;
        } catch (RemoteException e10) {
            mo8385c(AbstractC4346q.m8382g(e10));
        } catch (RuntimeException e11) {
            c4056d.m8060c(e11);
        }
    }

    @Override
    public final void mo8388f(C2982h c2982h, boolean z7) {
        Boolean boolValueOf = Boolean.valueOf(z7);
        Map map = (Map) c2982h.f10226c;
        C4056d c4056d = this.f14763c;
        map.put(c4056d, boolValueOf);
        c4056d.f13720a.m7128a(new C2982h(c2982h, 17, c4056d));
    }
}
