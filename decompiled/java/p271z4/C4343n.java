package p271z4;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.leanback.widget.RunnableC0485n0;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.AbstractC1500a;
import com.google.android.gms.internal.cast.HandlerC1731y0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import p000a.C0016q;
import p002a1.C0026b;
import p005a4.C0049h;
import p007a7.C0069f;
import p018b5.AbstractC1312l;
import p018b5.C1304d;
import p039d5.C2156c;
import p055ea.AbstractC2460q;
import p123l5.AbstractC2973a;
import p124l6.C2982h;
import p160p.C3341e;
import p160p.C3342f;
import p173q1.RunnableC3431n1;
import p187r4.C3621k;
import p187r4.C3624n;
import p220u5.C3899a;
import p231v5.C4010a;
import p242w5.C4056d;
import p249x4.C4109b;
import p261y4.AbstractC4259g;
import p261y4.C4265m;
import p261y4.InterfaceC4255c;
import p261y4.InterfaceC4260h;
import p261y4.InterfaceC4261i;

public final class C4343n implements InterfaceC4260h, InterfaceC4261i {

    public final InterfaceC4255c f14721d;

    public final C4331b f14722e;

    public final C2982h f14723f;

    public final int f14726i;

    public final BinderC4352w f14727j;

    public boolean f14728k;

    public final C4334e f14732o;

    public final LinkedList f14720c = new LinkedList();

    public final HashSet f14724g = new HashSet();

    public final HashMap f14725h = new HashMap();

    public final ArrayList f14729l = new ArrayList();

    public ConnectionResult f14730m = null;

    public int f14731n = 0;

    public C4343n(C4334e c4334e, AbstractC4259g abstractC4259g) {
        this.f14732o = c4334e;
        Looper looper = c4334e.f14710m.getLooper();
        C0026b c0026bM8304a = abstractC4259g.m8304a();
        C0049h c0049h = new C0049h((C3342f) c0026bM8304a.f54b, (String) c0026bM8304a.f55c, (String) c0026bM8304a.f56d);
        AbstractC2973a abstractC2973a = (AbstractC2973a) abstractC4259g.f14459c.f10225b;
        AbstractC1312l.m3198e(abstractC2973a);
        InterfaceC4255c interfaceC4255cMo3811c = abstractC2973a.mo3811c(abstractC4259g.f14457a, looper, c0049h, abstractC4259g.f14460d, this, this);
        String str = abstractC4259g.f14458b;
        if (str != null && (interfaceC4255cMo3811c instanceof AbstractC1500a)) {
            ((AbstractC1500a) interfaceC4255cMo3811c).f5087s = str;
        }
        if (str != null && (interfaceC4255cMo3811c instanceof AbstractServiceConnectionC4338i)) {
            AbstractC2460q.m5499m(interfaceC4255cMo3811c);
            throw null;
        }
        this.f14721d = interfaceC4255cMo3811c;
        this.f14722e = abstractC4259g.f14461e;
        this.f14723f = new C2982h(18);
        this.f14726i = abstractC4259g.f14463g;
        if (!interfaceC4255cMo3811c.mo3658k()) {
            this.f14727j = null;
            return;
        }
        Context context = c4334e.f14702e;
        HandlerC1731y0 handlerC1731y0 = c4334e.f14710m;
        C0026b c0026bM8304a2 = abstractC4259g.m8304a();
        this.f14727j = new BinderC4352w(context, handlerC1731y0, new C0049h((C3342f) c0026bM8304a2.f54b, (String) c0026bM8304a2.f55c, (String) c0026bM8304a2.f56d));
    }

    public final Feature m8367a(Feature[] featureArr) {
        if (featureArr != null && featureArr.length != 0) {
            Feature[] featureArrMo3653f = this.f14721d.mo3653f();
            if (featureArrMo3653f == null) {
                featureArrMo3653f = new Feature[0];
            }
            C3341e c3341e = new C3341e(featureArrMo3653f.length);
            for (Feature feature : featureArrMo3653f) {
                c3341e.put(feature.f4974a, Long.valueOf(feature.m3635j()));
            }
            for (Feature feature2 : featureArr) {
                Long l9 = (Long) c3341e.get(feature2.f4974a);
                if (l9 == null || l9.longValue() < feature2.m3635j()) {
                    return feature2;
                }
            }
        }
        return null;
    }

    public final void m8368b(ConnectionResult connectionResult) {
        HashSet hashSet = this.f14724g;
        Iterator it = hashSet.iterator();
        if (!it.hasNext()) {
            hashSet.clear();
        } else {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (AbstractC1312l.m3201h(connectionResult, ConnectionResult.f4969e)) {
                this.f14721d.mo3654g();
            }
            throw null;
        }
    }

    public final void m8369c(Status status) {
        AbstractC1312l.m3194a(this.f14732o.f14710m);
        m8370d(status, null, false);
    }

    public final void m8370d(Status status, RuntimeException runtimeException, boolean z7) {
        AbstractC1312l.m3194a(this.f14732o.f14710m);
        if ((status == null) == (runtimeException == null)) {
            throw new IllegalArgumentException("Status XOR exception should be null");
        }
        Iterator it = this.f14720c.iterator();
        while (it.hasNext()) {
            AbstractC4346q abstractC4346q = (AbstractC4346q) it.next();
            if (!z7 || abstractC4346q.f14735a == 2) {
                if (status != null) {
                    abstractC4346q.mo8385c(status);
                } else {
                    abstractC4346q.mo8386d(runtimeException);
                }
                it.remove();
            }
        }
    }

    public final void m8371e() {
        LinkedList linkedList = this.f14720c;
        ArrayList arrayList = new ArrayList(linkedList);
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            AbstractC4346q abstractC4346q = (AbstractC4346q) arrayList.get(i6);
            if (!this.f14721d.isConnected()) {
                return;
            }
            if (m8375j(abstractC4346q)) {
                linkedList.remove(abstractC4346q);
            }
        }
    }

    public final void m8372f() {
        InterfaceC4255c interfaceC4255c = this.f14721d;
        C4334e c4334e = this.f14732o;
        AbstractC1312l.m3194a(c4334e.f14710m);
        this.f14730m = null;
        m8368b(ConnectionResult.f4969e);
        if (this.f14728k) {
            HandlerC1731y0 handlerC1731y0 = c4334e.f14710m;
            C4331b c4331b = this.f14722e;
            handlerC1731y0.removeMessages(11, c4331b);
            c4334e.f14710m.removeMessages(9, c4331b);
            this.f14728k = false;
        }
        Iterator it = this.f14725h.values().iterator();
        while (it.hasNext()) {
            C4350u c4350u = (C4350u) it.next();
            if (m8367a((Feature[]) c4350u.f14748a.f12171c) != null) {
                it.remove();
            } else {
                try {
                    C3621k c3621k = c4350u.f14748a;
                    ((C4339j) c3621k.f12172d).f14714a.mo99p(interfaceC4255c, new C4056d());
                } catch (DeadObjectException unused) {
                    mo8307g(3);
                    interfaceC4255c.mo3651c("DeadObjectException thrown while calling register listener method.");
                } catch (RemoteException unused2) {
                    it.remove();
                }
            }
        }
        m8371e();
        m8374i();
    }

    @Override
    public final void mo8307g(int i6) {
        Looper looperMyLooper = Looper.myLooper();
        C4334e c4334e = this.f14732o;
        if (looperMyLooper == c4334e.f14710m.getLooper()) {
            m8373h(i6);
        } else {
            c4334e.f14710m.post(new RunnableC0485n0(i6, 6, this));
        }
    }

    public final void m8373h(int i6) {
        C4334e c4334e = this.f14732o;
        AbstractC1312l.m3194a(c4334e.f14710m);
        this.f14730m = null;
        this.f14728k = true;
        String strMo3655h = this.f14721d.mo3655h();
        C2982h c2982h = this.f14723f;
        c2982h.getClass();
        StringBuilder sb = new StringBuilder("The connection to Google Play services was lost");
        if (i6 == 1) {
            sb.append(" due to service disconnection.");
        } else if (i6 == 3) {
            sb.append(" due to dead object exception.");
        }
        if (strMo3655h != null) {
            sb.append(" Last reason for disconnect: ");
            sb.append(strMo3655h);
        }
        c2982h.m6040C(true, new Status(20, sb.toString(), null, null));
        HandlerC1731y0 handlerC1731y0 = c4334e.f14710m;
        C4331b c4331b = this.f14722e;
        handlerC1731y0.sendMessageDelayed(Message.obtain(handlerC1731y0, 9, c4331b), 5000L);
        HandlerC1731y0 handlerC1731y1 = c4334e.f14710m;
        handlerC1731y1.sendMessageDelayed(Message.obtain(handlerC1731y1, 11, c4331b), 120000L);
        ((SparseIntArray) c4334e.f14704g.f196b).clear();
        Iterator it = this.f14725h.values().iterator();
        while (it.hasNext()) {
            ((C4350u) it.next()).getClass();
        }
    }

    public final void m8374i() {
        C4334e c4334e = this.f14732o;
        HandlerC1731y0 handlerC1731y0 = c4334e.f14710m;
        C4331b c4331b = this.f14722e;
        handlerC1731y0.removeMessages(12, c4331b);
        HandlerC1731y0 handlerC1731y1 = c4334e.f14710m;
        handlerC1731y1.sendMessageDelayed(handlerC1731y1.obtainMessage(12, c4331b), c4334e.f14698a);
    }

    public final boolean m8375j(AbstractC4346q abstractC4346q) {
        if (!(abstractC4346q instanceof AbstractC4346q)) {
            InterfaceC4255c interfaceC4255c = this.f14721d;
            abstractC4346q.mo8388f(this.f14723f, interfaceC4255c.mo3658k());
            try {
                abstractC4346q.mo8387e(this);
            } catch (DeadObjectException unused) {
                mo8307g(1);
                interfaceC4255c.mo3651c("DeadObjectException thrown while running ApiCallRunner.");
            }
            return true;
        }
        Feature featureM8367a = m8367a(abstractC4346q.mo8384b(this));
        if (featureM8367a == null) {
            InterfaceC4255c interfaceC4255c2 = this.f14721d;
            abstractC4346q.mo8388f(this.f14723f, interfaceC4255c2.mo3658k());
            try {
                abstractC4346q.mo8387e(this);
            } catch (DeadObjectException unused2) {
                mo8307g(1);
                interfaceC4255c2.mo3651c("DeadObjectException thrown while running ApiCallRunner.");
            }
            return true;
        }
        Log.w("GoogleApiManager", this.f14721d.getClass().getName() + " could not execute call because it requires feature (" + featureM8367a.f4974a + ", " + featureM8367a.m3635j() + ").");
        if (!this.f14732o.f14711n || !abstractC4346q.mo8383a(this)) {
            abstractC4346q.mo8386d(new C4265m(featureM8367a));
            return true;
        }
        C4344o c4344o = new C4344o(this.f14722e, featureM8367a);
        int iIndexOf = this.f14729l.indexOf(c4344o);
        if (iIndexOf >= 0) {
            C4344o c4344o2 = (C4344o) this.f14729l.get(iIndexOf);
            this.f14732o.f14710m.removeMessages(15, c4344o2);
            HandlerC1731y0 handlerC1731y0 = this.f14732o.f14710m;
            handlerC1731y0.sendMessageDelayed(Message.obtain(handlerC1731y0, 15, c4344o2), 5000L);
            return false;
        }
        this.f14729l.add(c4344o);
        HandlerC1731y0 handlerC1731y1 = this.f14732o.f14710m;
        handlerC1731y1.sendMessageDelayed(Message.obtain(handlerC1731y1, 15, c4344o), 5000L);
        HandlerC1731y0 handlerC1731y2 = this.f14732o.f14710m;
        handlerC1731y2.sendMessageDelayed(Message.obtain(handlerC1731y2, 16, c4344o), 120000L);
        ConnectionResult connectionResult = new ConnectionResult(2, null);
        if (m8376k(connectionResult)) {
            return false;
        }
        this.f14732o.m8361b(connectionResult, this.f14726i);
        return false;
    }

    public final boolean m8376k(ConnectionResult connectionResult) {
        synchronized (C4334e.f14696q) {
            this.f14732o.getClass();
        }
        return false;
    }

    @Override
    public final void mo8308l(ConnectionResult connectionResult) {
        m8379o(connectionResult, null);
    }

    public final void m8377m() {
        C4334e c4334e = this.f14732o;
        AbstractC1312l.m3194a(c4334e.f14710m);
        InterfaceC4255c interfaceC4255c = this.f14721d;
        if (interfaceC4255c.isConnected() || interfaceC4255c.mo3652e()) {
            return;
        }
        try {
            C0069f c0069f = c4334e.f14704g;
            Context context = c4334e.f14702e;
            c0069f.getClass();
            AbstractC1312l.m3198e(context);
            int iMo3875d = interfaceC4255c.mo3875d();
            SparseIntArray sparseIntArray = (SparseIntArray) c0069f.f196b;
            int iM8129b = sparseIntArray.get(iMo3875d, -1);
            if (iM8129b == -1) {
                iM8129b = 0;
                int i6 = 0;
                while (true) {
                    if (i6 >= sparseIntArray.size()) {
                        iM8129b = -1;
                        break;
                    }
                    int iKeyAt = sparseIntArray.keyAt(i6);
                    if (iKeyAt > iMo3875d && sparseIntArray.get(iKeyAt) == 0) {
                        break;
                    } else {
                        i6++;
                    }
                }
                if (iM8129b == -1) {
                    iM8129b = ((C4109b) c0069f.f197c).m8129b(context, iMo3875d);
                }
                sparseIntArray.put(iMo3875d, iM8129b);
            }
            if (iM8129b != 0) {
                ConnectionResult connectionResult = new ConnectionResult(iM8129b, null);
                Log.w("GoogleApiManager", "The service for " + interfaceC4255c.getClass().getName() + " is not available: " + connectionResult.toString());
                m8379o(connectionResult, null);
                return;
            }
            C0016q c0016q = new C0016q(c4334e, interfaceC4255c, this.f14722e);
            if (interfaceC4255c.mo3658k()) {
                BinderC4352w binderC4352w = this.f14727j;
                AbstractC1312l.m3198e(binderC4352w);
                C4010a c4010a = binderC4352w.f14757i;
                if (c4010a != null) {
                    c4010a.disconnect();
                }
                Integer numValueOf = Integer.valueOf(System.identityHashCode(binderC4352w));
                C0049h c0049h = binderC4352w.f14756h;
                c0049h.f140b = numValueOf;
                HandlerC1731y0 handlerC1731y0 = binderC4352w.f14753e;
                binderC4352w.f14757i = (C4010a) binderC4352w.f14754f.mo3811c(binderC4352w.f14752d, handlerC1731y0.getLooper(), c0049h, (C3899a) c0049h.f144f, binderC4352w, binderC4352w);
                binderC4352w.f14758j = c0016q;
                Set set = binderC4352w.f14755g;
                if (set == null || set.isEmpty()) {
                    handlerC1731y0.post(new RunnableC3431n1(11, binderC4352w));
                } else {
                    C4010a c4010a2 = binderC4352w.f14757i;
                    c4010a2.getClass();
                    c4010a2.mo3657j(new C1304d(c4010a2));
                }
            }
            try {
                interfaceC4255c.mo3657j(c0016q);
            } catch (SecurityException e5) {
                m8379o(new ConnectionResult(10), e5);
            }
        } catch (IllegalStateException e10) {
            m8379o(new ConnectionResult(10), e10);
        }
    }

    public final void m8378n(AbstractC4346q abstractC4346q) {
        AbstractC1312l.m3194a(this.f14732o.f14710m);
        boolean zIsConnected = this.f14721d.isConnected();
        LinkedList linkedList = this.f14720c;
        if (zIsConnected) {
            if (m8375j(abstractC4346q)) {
                m8374i();
                return;
            } else {
                linkedList.add(abstractC4346q);
                return;
            }
        }
        linkedList.add(abstractC4346q);
        ConnectionResult connectionResult = this.f14730m;
        if (connectionResult == null || connectionResult.f4971b == 0 || connectionResult.f4972c == null) {
            m8377m();
        } else {
            m8379o(connectionResult, null);
        }
    }

    public final void m8379o(ConnectionResult connectionResult, RuntimeException runtimeException) {
        C4010a c4010a;
        AbstractC1312l.m3194a(this.f14732o.f14710m);
        BinderC4352w binderC4352w = this.f14727j;
        if (binderC4352w != null && (c4010a = binderC4352w.f14757i) != null) {
            c4010a.disconnect();
        }
        AbstractC1312l.m3194a(this.f14732o.f14710m);
        this.f14730m = null;
        ((SparseIntArray) this.f14732o.f14704g.f196b).clear();
        m8368b(connectionResult);
        if ((this.f14721d instanceof C2156c) && connectionResult.f4971b != 24) {
            C4334e c4334e = this.f14732o;
            c4334e.f14699b = true;
            HandlerC1731y0 handlerC1731y0 = c4334e.f14710m;
            handlerC1731y0.sendMessageDelayed(handlerC1731y0.obtainMessage(19), 300000L);
        }
        if (connectionResult.f4971b == 4) {
            m8369c(C4334e.f14695p);
            return;
        }
        if (this.f14720c.isEmpty()) {
            this.f14730m = connectionResult;
            return;
        }
        if (runtimeException != null) {
            AbstractC1312l.m3194a(this.f14732o.f14710m);
            m8370d(null, runtimeException, false);
            return;
        }
        if (!this.f14732o.f14711n) {
            m8369c(C4334e.m8358c(this.f14722e, connectionResult));
            return;
        }
        m8370d(C4334e.m8358c(this.f14722e, connectionResult), null, true);
        if (this.f14720c.isEmpty() || m8376k(connectionResult) || this.f14732o.m8361b(connectionResult, this.f14726i)) {
            return;
        }
        if (connectionResult.f4971b == 18) {
            this.f14728k = true;
        }
        if (!this.f14728k) {
            m8369c(C4334e.m8358c(this.f14722e, connectionResult));
            return;
        }
        C4334e c4334e2 = this.f14732o;
        C4331b c4331b = this.f14722e;
        HandlerC1731y0 handlerC1731y1 = c4334e2.f14710m;
        handlerC1731y1.sendMessageDelayed(Message.obtain(handlerC1731y1, 9, c4331b), 5000L);
    }

    @Override
    public final void onConnected() {
        Looper looperMyLooper = Looper.myLooper();
        C4334e c4334e = this.f14732o;
        if (looperMyLooper == c4334e.f14710m.getLooper()) {
            m8372f();
        } else {
            c4334e.f14710m.post(new RunnableC3431n1(9, this));
        }
    }

    public final void m8380p(ConnectionResult connectionResult) {
        AbstractC1312l.m3194a(this.f14732o.f14710m);
        InterfaceC4255c interfaceC4255c = this.f14721d;
        interfaceC4255c.mo3651c("onSignInFailed for " + interfaceC4255c.getClass().getName() + " with " + String.valueOf(connectionResult));
        m8379o(connectionResult, null);
    }

    public final void m8381q() {
        AbstractC1312l.m3194a(this.f14732o.f14710m);
        Status status = C4334e.f14694o;
        m8369c(status);
        this.f14723f.m6040C(false, status);
        for (C4336g c4336g : (C4336g[]) this.f14725h.keySet().toArray(new C4336g[0])) {
            m8378n(new C4353x(c4336g, new C4056d()));
        }
        m8368b(new ConnectionResult(4));
        InterfaceC4255c interfaceC4255c = this.f14721d;
        if (interfaceC4255c.isConnected()) {
            interfaceC4255c.mo3656i(new C3624n(13, this));
        }
    }
}
