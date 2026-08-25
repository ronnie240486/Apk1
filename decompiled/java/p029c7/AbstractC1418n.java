package p029c7;

import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import p020b7.AbstractC1332b;
import p041d7.AbstractC2213h3;
import p041d7.C2172b4;
import p041d7.ConcurrentMapC2179c4;
import p041d7.InterfaceC2199f3;

public abstract class AbstractC1418n implements Iterator {

    public int f4312b;

    public AtomicReferenceArray f4314d;

    public ReentrantLock f4315e;

    public Object f4316f;

    public Map.Entry f4317g;

    public Map.Entry f4318h;

    public final AbstractMap f4319i;

    public final int f4311a = 0;

    public int f4313c = -1;

    public AbstractC1418n(ConcurrentMapC2179c4 concurrentMapC2179c4) {
        this.f4319i = concurrentMapC2179c4;
        this.f4312b = concurrentMapC2179c4.f7855c.length - 1;
        m3308a();
    }

    public final void m3308a() {
        switch (this.f4311a) {
            case 0:
                this.f4317g = null;
                if (!m3313f() && !m3314g()) {
                    while (true) {
                        int i6 = this.f4312b;
                        if (i6 < 0) {
                            break;
                        } else {
                            C1421q[] c1421qArr = ((ConcurrentMapC1404b0) this.f4319i).f4276c;
                            this.f4312b = i6 - 1;
                            C1421q c1421q = c1421qArr[i6];
                            this.f4315e = c1421q;
                            if (c1421q.f4324b != 0) {
                                AtomicReferenceArray atomicReferenceArray = ((C1421q) this.f4315e).f4328f;
                                this.f4314d = atomicReferenceArray;
                                this.f4313c = atomicReferenceArray.length() - 1;
                                if (m3314g()) {
                                    break;
                                }
                            }
                        }
                    }
                }
                break;
            default:
                this.f4317g = null;
                if (!m3313f() && !m3314g()) {
                    while (true) {
                        int i10 = this.f4312b;
                        if (i10 < 0) {
                            break;
                        } else {
                            AbstractC2213h3[] abstractC2213h3Arr = ((ConcurrentMapC2179c4) this.f4319i).f7855c;
                            this.f4312b = i10 - 1;
                            AbstractC2213h3 abstractC2213h3 = abstractC2213h3Arr[i10];
                            this.f4315e = abstractC2213h3;
                            if (abstractC2213h3.f7922b != 0) {
                                AtomicReferenceArray atomicReferenceArray2 = ((AbstractC2213h3) this.f4315e).f7925e;
                                this.f4314d = atomicReferenceArray2;
                                this.f4313c = atomicReferenceArray2.length() - 1;
                                if (m3314g()) {
                                    break;
                                }
                            }
                        }
                    }
                }
                break;
        }
    }

    public boolean m3309b(InterfaceC1406c0 interfaceC1406c0) {
        Object obj;
        ReentrantLock reentrantLock;
        C1421q c1421q;
        ConcurrentMapC1404b0 concurrentMapC1404b0 = (ConcurrentMapC1404b0) this.f4319i;
        try {
            long jMo3239a = concurrentMapC1404b0.f4286m.mo3239a();
            Object key = interfaceC1406c0.getKey();
            Object obj2 = null;
            if (interfaceC1406c0.getKey() != null && (obj = interfaceC1406c0.mo3282a().get()) != null && !concurrentMapC1404b0.m3280d(interfaceC1406c0, jMo3239a)) {
                obj2 = obj;
            }
            if (obj2 == null) {
                return false;
            }
            this.f4317g = new C1402a0(concurrentMapC1404b0, key, obj2);
            return true;
        } finally {
            ((C1421q) this.f4315e).m3324j();
        }
    }

    public boolean m3310c(InterfaceC2199f3 interfaceC2199f3) {
        ReentrantLock reentrantLock;
        AbstractC2213h3 abstractC2213h3;
        ConcurrentMapC2179c4 concurrentMapC2179c4 = (ConcurrentMapC2179c4) this.f4319i;
        try {
            Object key = interfaceC2199f3.getKey();
            concurrentMapC2179c4.getClass();
            Object value = interfaceC2199f3.getKey() == null ? null : interfaceC2199f3.getValue();
            if (value == null) {
                return false;
            }
            this.f4317g = new C2172b4(concurrentMapC2179c4, key, value);
            return true;
        } finally {
            ((AbstractC2213h3) this.f4315e).m5198g();
        }
    }

    public C1402a0 m3311d() {
        C1402a0 c1402a0 = (C1402a0) this.f4317g;
        if (c1402a0 == null) {
            throw new NoSuchElementException();
        }
        this.f4318h = c1402a0;
        m3308a();
        return (C1402a0) this.f4318h;
    }

    public C2172b4 m3312e() {
        C2172b4 c2172b4 = (C2172b4) this.f4317g;
        if (c2172b4 == null) {
            throw new NoSuchElementException();
        }
        this.f4318h = c2172b4;
        m3308a();
        return (C2172b4) this.f4318h;
    }

    public final boolean m3313f() {
        switch (this.f4311a) {
            case 0:
                InterfaceC1406c0 interfaceC1406c0 = (InterfaceC1406c0) this.f4316f;
                if (interfaceC1406c0 != null) {
                    while (true) {
                        this.f4316f = interfaceC1406c0.mo3283b();
                        InterfaceC1406c0 interfaceC1406c1 = (InterfaceC1406c0) this.f4316f;
                        if (interfaceC1406c1 != null) {
                            if (m3309b(interfaceC1406c1)) {
                                return true;
                            }
                            interfaceC1406c0 = (InterfaceC1406c0) this.f4316f;
                        }
                    }
                }
                return false;
            default:
                InterfaceC2199f3 interfaceC2199f3 = (InterfaceC2199f3) this.f4316f;
                if (interfaceC2199f3 != null) {
                    while (true) {
                        this.f4316f = interfaceC2199f3.mo5106b();
                        InterfaceC2199f3 interfaceC2199f4 = (InterfaceC2199f3) this.f4316f;
                        if (interfaceC2199f4 != null) {
                            if (m3310c(interfaceC2199f4)) {
                                return true;
                            }
                            interfaceC2199f3 = (InterfaceC2199f3) this.f4316f;
                        }
                    }
                }
                return false;
        }
    }

    public final boolean m3314g() {
        switch (this.f4311a) {
            case 0:
                while (true) {
                    int i6 = this.f4313c;
                    if (i6 < 0) {
                        return false;
                    }
                    AtomicReferenceArray atomicReferenceArray = this.f4314d;
                    this.f4313c = i6 - 1;
                    InterfaceC1406c0 interfaceC1406c0 = (InterfaceC1406c0) atomicReferenceArray.get(i6);
                    this.f4316f = interfaceC1406c0;
                    if (interfaceC1406c0 != null && (m3309b(interfaceC1406c0) || m3313f())) {
                        return true;
                    }
                }
                break;
            default:
                while (true) {
                    int i10 = this.f4313c;
                    if (i10 < 0) {
                        return false;
                    }
                    AtomicReferenceArray atomicReferenceArray2 = this.f4314d;
                    this.f4313c = i10 - 1;
                    InterfaceC2199f3 interfaceC2199f3 = (InterfaceC2199f3) atomicReferenceArray2.get(i10);
                    this.f4316f = interfaceC2199f3;
                    if (interfaceC2199f3 != null && (m3310c(interfaceC2199f3) || m3313f())) {
                        return true;
                    }
                }
                break;
        }
    }

    @Override
    public final boolean hasNext() {
        switch (this.f4311a) {
            case 0:
                return ((C1402a0) this.f4317g) != null;
            default:
                return ((C2172b4) this.f4317g) != null;
        }
    }

    @Override
    public Object next() {
        switch (this.f4311a) {
            case 0:
                return m3311d();
            default:
                return m3312e();
        }
    }

    @Override
    public final void remove() {
        switch (this.f4311a) {
            case 0:
                AbstractC1332b.m3224o(((C1402a0) this.f4318h) != null);
                ((ConcurrentMapC1404b0) this.f4319i).remove(((C1402a0) this.f4318h).f4267a);
                this.f4318h = null;
                break;
            default:
                AbstractC1332b.m3223n("no calls to next() since the last call to remove()", ((C2172b4) this.f4318h) != null);
                ((ConcurrentMapC2179c4) this.f4319i).remove(((C2172b4) this.f4318h).f7837a);
                this.f4318h = null;
                break;
        }
    }

    public AbstractC1418n(ConcurrentMapC1404b0 concurrentMapC1404b0) {
        this.f4319i = concurrentMapC1404b0;
        this.f4312b = concurrentMapC1404b0.f4276c.length - 1;
        m3308a();
    }
}
