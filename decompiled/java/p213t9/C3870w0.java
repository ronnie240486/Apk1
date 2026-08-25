package p213t9;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public final class C3870w0 implements InterfaceC3846k0 {

    public static final AtomicIntegerFieldUpdater f12972b = AtomicIntegerFieldUpdater.newUpdater(C3870w0.class, "_isCompleting");

    public static final AtomicReferenceFieldUpdater f12973c = AtomicReferenceFieldUpdater.newUpdater(C3870w0.class, Object.class, "_rootCause");

    public static final AtomicReferenceFieldUpdater f12974d = AtomicReferenceFieldUpdater.newUpdater(C3870w0.class, Object.class, "_exceptionsHolder");
    private volatile Object _exceptionsHolder;
    private volatile int _isCompleting = 0;
    private volatile Object _rootCause;

    public final C3876z0 f12975a;

    public C3870w0(C3876z0 c3876z0, Throwable th) {
        this.f12975a = c3876z0;
        this._rootCause = th;
    }

    public final void m7704a(Throwable th) {
        Throwable thM7705b = m7705b();
        if (thM7705b == null) {
            f12973c.set(this, th);
            return;
        }
        if (th == thM7705b) {
            return;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12974d;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if (obj == null) {
            atomicReferenceFieldUpdater.set(this, th);
            return;
        }
        if (!(obj instanceof Throwable)) {
            if (obj instanceof ArrayList) {
                ((ArrayList) obj).add(th);
                return;
            } else {
                throw new IllegalStateException(("State is " + obj).toString());
            }
        }
        if (th == obj) {
            return;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(th);
        atomicReferenceFieldUpdater.set(this, arrayList);
    }

    public final Throwable m7705b() {
        return (Throwable) f12973c.get(this);
    }

    @Override
    public final C3876z0 mo7647c() {
        return this.f12975a;
    }

    public final boolean m7706d() {
        return m7705b() != null;
    }

    public final boolean m7707e() {
        return f12972b.get(this) != 0;
    }

    public final ArrayList m7708f(Throwable th) {
        ArrayList arrayList;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12974d;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if (obj == null) {
            arrayList = new ArrayList(4);
        } else if (obj instanceof Throwable) {
            ArrayList arrayList2 = new ArrayList(4);
            arrayList2.add(obj);
            arrayList = arrayList2;
        } else {
            if (!(obj instanceof ArrayList)) {
                throw new IllegalStateException(("State is " + obj).toString());
            }
            arrayList = (ArrayList) obj;
        }
        Throwable thM7705b = m7705b();
        if (thM7705b != null) {
            arrayList.add(0, thM7705b);
        }
        if (th != null && !th.equals(thM7705b)) {
            arrayList.add(th);
        }
        atomicReferenceFieldUpdater.set(this, AbstractC3865u.f12961g);
        return arrayList;
    }

    @Override
    public final boolean isActive() {
        return m7705b() == null;
    }

    public final String toString() {
        return "Finishing[cancelling=" + m7706d() + ", completing=" + m7707e() + ", rootCause=" + m7705b() + ", exceptions=" + f12974d.get(this) + ", list=" + this.f12975a + ']';
    }
}
