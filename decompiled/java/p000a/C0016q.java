package p000a;

import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.fragment.app.AbstractC0410j0;
import androidx.fragment.app.C0394b0;
import com.google.android.gms.common.ConnectionResult;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import p018b5.InterfaceC1302b;
import p094j0.AbstractC2754b;
import p261y4.InterfaceC4255c;
import p271z4.C4331b;
import p271z4.C4334e;
import p271z4.C4343n;
import ua.RunnableC3940a;

public final class C0016q implements InterfaceC1302b {

    public boolean f31a;

    public final Object f32b;

    public final Object f33c;

    public Object f34d;

    public Object f35e;

    public Object f36f;

    public C0016q(C4334e c4334e, InterfaceC4255c interfaceC4255c, C4331b c4331b) {
        this.f36f = c4334e;
        this.f34d = null;
        this.f35e = null;
        this.f31a = false;
        this.f32b = interfaceC4255c;
        this.f33c = c4331b;
    }

    @Override
    public void mo48a(ConnectionResult connectionResult) {
        ((C4334e) this.f36f).f14710m.post(new RunnableC3940a(8, this, connectionResult, false));
    }

    public boolean m49b(Method method, Class cls) {
        StringBuilder sb = (StringBuilder) this.f35e;
        sb.setLength(0);
        sb.append(method.getName());
        sb.append('>');
        sb.append(cls.getName());
        String string = sb.toString();
        Class<?> declaringClass = method.getDeclaringClass();
        HashMap map = (HashMap) this.f34d;
        Class cls2 = (Class) map.put(string, declaringClass);
        if (cls2 == null || cls2.isAssignableFrom(declaringClass)) {
            return true;
        }
        map.put(string, cls2);
        return false;
    }

    public void m50c() {
        Iterator itDescendingIterator = ((ArrayDeque) this.f33c).descendingIterator();
        while (itDescendingIterator.hasNext()) {
            C0394b0 c0394b0 = (C0394b0) itDescendingIterator.next();
            if (c0394b0.f1823a) {
                AbstractC0410j0 abstractC0410j0 = c0394b0.f1826d;
                abstractC0410j0.m1259u(true);
                if (abstractC0410j0.f1868h.f1823a) {
                    abstractC0410j0.m1225L();
                    return;
                } else {
                    abstractC0410j0.f1867g.m50c();
                    return;
                }
            }
        }
        Runnable runnable = (Runnable) this.f32b;
        if (runnable != null) {
            runnable.run();
        }
    }

    public void m51d() {
        boolean z7;
        Iterator itDescendingIterator = ((ArrayDeque) this.f33c).descendingIterator();
        while (true) {
            if (!itDescendingIterator.hasNext()) {
                z7 = false;
                break;
            } else if (((C0394b0) itDescendingIterator.next()).f1823a) {
                z7 = true;
                break;
            }
        }
        OnBackInvokedDispatcher onBackInvokedDispatcher = (OnBackInvokedDispatcher) this.f36f;
        if (onBackInvokedDispatcher != null) {
            if (z7 && !this.f31a) {
                AbstractC0013n.m46b(onBackInvokedDispatcher, 0, (OnBackInvokedCallback) this.f35e);
                this.f31a = true;
            } else {
                if (z7 || !this.f31a) {
                    return;
                }
                AbstractC0013n.m47c(onBackInvokedDispatcher, (OnBackInvokedCallback) this.f35e);
                this.f31a = false;
            }
        }
    }

    public void m52e(ConnectionResult connectionResult) {
        C4343n c4343n = (C4343n) ((C4334e) this.f36f).f14707j.get((C4331b) this.f33c);
        if (c4343n != null) {
            c4343n.m8380p(connectionResult);
        }
    }

    public C0016q(Runnable runnable) {
        this.f33c = new ArrayDeque();
        this.f31a = false;
        this.f32b = runnable;
        if (AbstractC2754b.m5721a()) {
            this.f34d = new C0011l(this);
            this.f35e = AbstractC0013n.m45a(new RunnableC0001b(2, this));
        }
    }

    public C0016q() {
        this.f32b = new ArrayList();
        this.f33c = new HashMap();
        this.f34d = new HashMap();
        this.f35e = new StringBuilder(128);
    }
}
