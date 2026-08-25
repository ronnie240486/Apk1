package p165p4;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.cast.AbstractC1542e0;
import java.util.Iterator;
import p176q4.C3475c;
import p176q4.C3478d0;
import p176q4.C3489o;
import p176q4.InterfaceC3491q;

public final class RunnableC3368m implements Runnable {

    public final int f11368a;

    public final BinderC3369n f11369b;

    public final int f11370c;

    public RunnableC3368m(BinderC3369n binderC3369n, int i6, int i10) {
        this.f11368a = i10;
        this.f11369b = binderC3369n;
        this.f11370c = i6;
    }

    private final void m6841a() {
        BinderC3369n binderC3369n = this.f11369b;
        C3370o c3370o = binderC3369n.f11371d;
        c3370o.f11392w = -1;
        c3370o.f11393x = -1;
        c3370o.f11388s = null;
        c3370o.f11389t = null;
        c3370o.f11390u = 0.0d;
        c3370o.m6866k();
        c3370o.f11391v = false;
        c3370o.f11394y = null;
        c3370o.f11378E = 1;
        int i6 = this.f11370c;
        synchronized (c3370o.f11377D) {
            try {
                Iterator it = c3370o.f11377D.iterator();
                while (it.hasNext()) {
                    InterfaceC3491q interfaceC3491q = ((C3478d0) it.next()).f11773a.f11758e;
                    if (interfaceC3491q != null) {
                        try {
                            ConnectionResult connectionResult = new ConnectionResult(i6);
                            C3489o c3489o = (C3489o) interfaceC3491q;
                            Parcel parcelM3687l = c3489o.m3687l();
                            AbstractC1542e0.m3809c(parcelM3687l, connectionResult);
                            c3489o.m3689x(parcelM3687l, 3);
                        } catch (RemoteException e5) {
                            C3475c.f11755m.m7974a(e5, "Unable to call %s on %s.", "onDisconnected", InterfaceC3491q.class.getSimpleName());
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        C3370o c3370o2 = binderC3369n.f11371d;
        c3370o2.m6862g();
        c3370o2.m6861f(c3370o2.f11379j);
    }

    private final void m6842b() {
        BinderC3369n binderC3369n = this.f11369b;
        int i6 = this.f11370c;
        if (i6 == 0) {
            C3370o c3370o = binderC3369n.f11371d;
            c3370o.f11378E = 3;
            c3370o.f11381l = true;
            c3370o.f11382m = true;
            synchronized (c3370o.f11377D) {
                try {
                    Iterator it = c3370o.f11377D.iterator();
                    while (it.hasNext()) {
                        ((C3478d0) it.next()).m7135a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        C3370o c3370o2 = binderC3369n.f11371d;
        c3370o2.f11378E = 1;
        synchronized (c3370o2.f11377D) {
            try {
                Iterator it2 = c3370o2.f11377D.iterator();
                while (it2.hasNext()) {
                    InterfaceC3491q interfaceC3491q = ((C3478d0) it2.next()).f11773a.f11758e;
                    if (interfaceC3491q != null) {
                        try {
                            ConnectionResult connectionResult = new ConnectionResult(i6);
                            C3489o c3489o = (C3489o) interfaceC3491q;
                            Parcel parcelM3687l = c3489o.m3687l();
                            AbstractC1542e0.m3809c(parcelM3687l, connectionResult);
                            c3489o.m3689x(parcelM3687l, 3);
                        } catch (RemoteException e5) {
                            C3475c.f11755m.m7974a(e5, "Unable to call %s on %s.", "onConnectionFailed", InterfaceC3491q.class.getSimpleName());
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        binderC3369n.f11371d.m6862g();
    }

    @Override
    public final void run() {
        switch (this.f11368a) {
            case 0:
                m6841a();
                return;
            case 1:
                m6842b();
                return;
            case 2:
                this.f11369b.f11371d.f11376C.m3906c(this.f11370c);
                return;
            default:
                C3370o c3370o = this.f11369b.f11371d;
                c3370o.f11378E = 4;
                int i6 = this.f11370c;
                synchronized (c3370o.f11377D) {
                    try {
                        Iterator it = c3370o.f11377D.iterator();
                        while (it.hasNext()) {
                            InterfaceC3491q interfaceC3491q = ((C3478d0) it.next()).f11773a.f11758e;
                            if (interfaceC3491q != null) {
                                try {
                                    C3489o c3489o = (C3489o) interfaceC3491q;
                                    Parcel parcelM3687l = c3489o.m3687l();
                                    parcelM3687l.writeInt(i6);
                                    c3489o.m3689x(parcelM3687l, 2);
                                } catch (RemoteException e5) {
                                    C3475c.f11755m.m7974a(e5, "Unable to call %s on %s.", "onConnectionSuspended", InterfaceC3491q.class.getSimpleName());
                                }
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return;
        }
    }
}
