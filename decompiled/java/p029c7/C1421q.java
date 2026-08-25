package p029c7;

import java.lang.ref.ReferenceQueue;
import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import p249x4.C4112e;

public final class C1421q extends ReentrantLock {

    public final ConcurrentMapC1404b0 f4323a;

    public volatile int f4324b;

    public long f4325c;

    public int f4326d;

    public int f4327e;

    public volatile AtomicReferenceArray f4328f;

    public final long f4329g;

    public final ReferenceQueue f4330h;

    public final ReferenceQueue f4331i;

    public final AbstractQueue f4332j;

    public final AtomicInteger f4333k = new AtomicInteger();

    public final AbstractQueue f4334l;

    public final AbstractQueue f4335m;

    public final C4112e f4336n;

    public C1421q(ConcurrentMapC1404b0 concurrentMapC1404b0, int i6, long j10, C4112e c4112e) {
        this.f4323a = concurrentMapC1404b0;
        this.f4329g = j10;
        this.f4336n = c4112e;
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(i6);
        int length = (atomicReferenceArray.length() * 3) / 4;
        this.f4327e = length;
        if (concurrentMapC1404b0.f4283j == EnumC1405c.f4292a && length == j10) {
            this.f4327e = length + 1;
        }
        this.f4328f = atomicReferenceArray;
        this.f4330h = concurrentMapC1404b0.f4280g != 1 ? new ReferenceQueue() : null;
        this.f4331i = concurrentMapC1404b0.f4281h != 1 ? new ReferenceQueue() : null;
        this.f4332j = concurrentMapC1404b0.m3277a() ? new ConcurrentLinkedQueue() : ConcurrentMapC1404b0.f4273t;
        this.f4334l = concurrentMapC1404b0.m3278b() ? new C1414j(1) : ConcurrentMapC1404b0.f4273t;
        this.f4335m = concurrentMapC1404b0.m3277a() ? new C1414j(0) : ConcurrentMapC1404b0.f4273t;
    }

    public final InterfaceC1406c0 m3315a(InterfaceC1406c0 interfaceC1406c0, InterfaceC1406c0 interfaceC1406c1) {
        InterfaceC1406c0 interfaceC1406c0M3305b;
        InterfaceC1406c0 interfaceC1406c0M3305b2;
        Object key = interfaceC1406c0.getKey();
        if (key == null) {
            return null;
        }
        InterfaceC1426v interfaceC1426vMo3282a = interfaceC1406c0.mo3282a();
        Object obj = interfaceC1426vMo3282a.get();
        if (obj == null && interfaceC1426vMo3282a.isActive()) {
            return null;
        }
        int i6 = this.f4323a.f4287n;
        if (i6 == 2) {
            interfaceC1406c0M3305b = AbstractC1415k.m3305b(2, this, interfaceC1406c0, interfaceC1406c1, key);
            AbstractC1415k.m3304a(interfaceC1406c0, interfaceC1406c0M3305b);
        } else if (i6 == 3) {
            interfaceC1406c0M3305b = AbstractC1415k.m3305b(3, this, interfaceC1406c0, interfaceC1406c1, key);
            AbstractC1415k.m3306c(interfaceC1406c0, interfaceC1406c0M3305b);
        } else if (i6 == 4) {
            interfaceC1406c0M3305b = AbstractC1415k.m3305b(4, this, interfaceC1406c0, interfaceC1406c1, key);
            AbstractC1415k.m3304a(interfaceC1406c0, interfaceC1406c0M3305b);
            AbstractC1415k.m3306c(interfaceC1406c0, interfaceC1406c0M3305b);
        } else if (i6 == 6) {
            interfaceC1406c0M3305b = AbstractC1415k.m3305b(6, this, interfaceC1406c0, interfaceC1406c1, key);
            AbstractC1415k.m3304a(interfaceC1406c0, interfaceC1406c0M3305b);
        } else {
            if (i6 != 7) {
                if (i6 != 8) {
                    interfaceC1406c0M3305b2 = AbstractC1415k.m3305b(i6, this, interfaceC1406c0, interfaceC1406c1, key);
                } else {
                    interfaceC1406c0M3305b = AbstractC1415k.m3305b(8, this, interfaceC1406c0, interfaceC1406c1, key);
                    AbstractC1415k.m3304a(interfaceC1406c0, interfaceC1406c0M3305b);
                    AbstractC1415k.m3306c(interfaceC1406c0, interfaceC1406c0M3305b);
                }
                interfaceC1406c0M3305b2.mo3291j(interfaceC1426vMo3282a.mo3299b(this.f4331i, obj, interfaceC1406c0M3305b2));
                return interfaceC1406c0M3305b2;
            }
            interfaceC1406c0M3305b = AbstractC1415k.m3305b(7, this, interfaceC1406c0, interfaceC1406c1, key);
            AbstractC1415k.m3306c(interfaceC1406c0, interfaceC1406c0M3305b);
        }
        interfaceC1406c0M3305b2 = interfaceC1406c0M3305b;
        interfaceC1406c0M3305b2.mo3291j(interfaceC1426vMo3282a.mo3299b(this.f4331i, obj, interfaceC1406c0M3305b2));
        return interfaceC1406c0M3305b2;
    }

    public final void m3316b() {
        while (true) {
            InterfaceC1406c0 interfaceC1406c0 = (InterfaceC1406c0) this.f4332j.poll();
            if (interfaceC1406c0 == null) {
                return;
            }
            AbstractQueue abstractQueue = this.f4335m;
            if (abstractQueue.contains(interfaceC1406c0)) {
                abstractQueue.add(interfaceC1406c0);
            }
        }
    }

    public final void m3317c() {
        if (this.f4323a.f4280g != 1) {
            int i6 = 0;
            do {
                Object objPoll = this.f4330h.poll();
                if (objPoll == null) {
                    break;
                }
                InterfaceC1406c0 interfaceC1406c0 = (InterfaceC1406c0) objPoll;
                ConcurrentMapC1404b0 concurrentMapC1404b0 = this.f4323a;
                concurrentMapC1404b0.getClass();
                int iMo3284c = interfaceC1406c0.mo3284c();
                C1421q c1421qM3281e = concurrentMapC1404b0.m3281e(iMo3284c);
                c1421qM3281e.lock();
                try {
                    AtomicReferenceArray atomicReferenceArray = c1421qM3281e.f4328f;
                    int length = iMo3284c & (atomicReferenceArray.length() - 1);
                    InterfaceC1406c0 interfaceC1406c1 = (InterfaceC1406c0) atomicReferenceArray.get(length);
                    InterfaceC1406c0 interfaceC1406c0Mo3283b = interfaceC1406c1;
                    while (interfaceC1406c0Mo3283b != null) {
                        if (interfaceC1406c0Mo3283b == interfaceC1406c0) {
                            c1421qM3281e.f4326d++;
                            InterfaceC1406c0 interfaceC1406c0M3328n = c1421qM3281e.m3328n(interfaceC1406c1, interfaceC1406c0Mo3283b, interfaceC1406c0Mo3283b.getKey(), iMo3284c, interfaceC1406c0Mo3283b.mo3282a().get(), interfaceC1406c0Mo3283b.mo3282a(), 3);
                            int i10 = c1421qM3281e.f4324b - 1;
                            atomicReferenceArray.set(length, interfaceC1406c0M3328n);
                            c1421qM3281e.f4324b = i10;
                            break;
                        }
                        int i11 = length;
                        interfaceC1406c0Mo3283b = interfaceC1406c0Mo3283b.mo3283b();
                        length = i11;
                    }
                    c1421qM3281e.unlock();
                    c1421qM3281e.m3330p();
                    i6++;
                } catch (Throwable th) {
                    c1421qM3281e.unlock();
                    c1421qM3281e.m3330p();
                    throw th;
                }
            } while (i6 != 16);
        }
        if (this.f4323a.f4281h != 1) {
            int i12 = 0;
            do {
                Object objPoll2 = this.f4331i.poll();
                if (objPoll2 == null) {
                    return;
                }
                InterfaceC1426v interfaceC1426v = (InterfaceC1426v) objPoll2;
                ConcurrentMapC1404b0 concurrentMapC1404b1 = this.f4323a;
                concurrentMapC1404b1.getClass();
                InterfaceC1406c0 interfaceC1406c0Mo3298a = interfaceC1426v.mo3298a();
                int iMo3284c2 = interfaceC1406c0Mo3298a.mo3284c();
                C1421q c1421qM3281e2 = concurrentMapC1404b1.m3281e(iMo3284c2);
                Object key = interfaceC1406c0Mo3298a.getKey();
                c1421qM3281e2.lock();
                try {
                    AtomicReferenceArray atomicReferenceArray2 = c1421qM3281e2.f4328f;
                    int length2 = iMo3284c2 & (atomicReferenceArray2.length() - 1);
                    InterfaceC1406c0 interfaceC1406c2 = (InterfaceC1406c0) atomicReferenceArray2.get(length2);
                    InterfaceC1406c0 interfaceC1406c0Mo3283b2 = interfaceC1406c2;
                    while (true) {
                        if (interfaceC1406c0Mo3283b2 == null) {
                            c1421qM3281e2.unlock();
                            if (!c1421qM3281e2.isHeldByCurrentThread()) {
                                c1421qM3281e2.m3330p();
                                break;
                            }
                            break;
                        }
                        Object key2 = interfaceC1406c0Mo3283b2.getKey();
                        if (interfaceC1406c0Mo3283b2.mo3284c() == iMo3284c2 && key2 != null && c1421qM3281e2.f4323a.f4278e.m3238c(key, key2)) {
                            if (interfaceC1406c0Mo3283b2.mo3282a() != interfaceC1426v) {
                                c1421qM3281e2.unlock();
                                if (!c1421qM3281e2.isHeldByCurrentThread()) {
                                    c1421qM3281e2.m3330p();
                                    break;
                                }
                                break;
                            }
                            c1421qM3281e2.f4326d++;
                            InterfaceC1406c0 interfaceC1406c0M3328n2 = c1421qM3281e2.m3328n(interfaceC1406c2, interfaceC1406c0Mo3283b2, key2, iMo3284c2, interfaceC1426v.get(), interfaceC1426v, 3);
                            int i13 = c1421qM3281e2.f4324b - 1;
                            atomicReferenceArray2.set(length2, interfaceC1406c0M3328n2);
                            c1421qM3281e2.f4324b = i13;
                            c1421qM3281e2.unlock();
                            if (!c1421qM3281e2.isHeldByCurrentThread()) {
                                c1421qM3281e2.m3330p();
                                break;
                            }
                            break;
                        }
                        int i14 = length2;
                        interfaceC1406c0Mo3283b2 = interfaceC1406c0Mo3283b2.mo3283b();
                        length2 = i14;
                    }
                    i12++;
                } catch (Throwable th2) {
                    c1421qM3281e2.unlock();
                    if (!c1421qM3281e2.isHeldByCurrentThread()) {
                        c1421qM3281e2.m3330p();
                    }
                    throw th2;
                }
            } while (i12 != 16);
        }
    }

    public final void m3318d(int i6, Object obj, Object obj2, int i10) {
        this.f4325c -= (long) i6;
        boolean z7 = false;
        if (i10 != 1 && i10 != 2) {
            z7 = true;
        }
        if (z7) {
            this.f4336n.getClass();
        }
        ConcurrentMapC1404b0 concurrentMapC1404b0 = this.f4323a;
        if (concurrentMapC1404b0.f4285l != ConcurrentMapC1404b0.f4273t) {
            new C1408d0(obj, obj2);
            concurrentMapC1404b0.f4285l.getClass();
        }
    }

    public final void m3319e(InterfaceC1406c0 interfaceC1406c0) {
        InterfaceC1406c0 interfaceC1406c1;
        if (this.f4323a.m3277a()) {
            m3316b();
            long jMo3301d = interfaceC1406c0.mo3282a().mo3301d();
            long j10 = this.f4329g;
            if (jMo3301d > j10 && !m3327m(interfaceC1406c0, interfaceC1406c0.mo3284c(), 5)) {
                throw new AssertionError();
            }
            while (this.f4325c > j10) {
                Iterator it = this.f4335m.iterator();
                do {
                    if (!it.hasNext()) {
                        throw new AssertionError();
                    }
                    interfaceC1406c1 = (InterfaceC1406c0) it.next();
                } while (interfaceC1406c1.mo3282a().mo3301d() <= 0);
                if (!m3327m(interfaceC1406c1, interfaceC1406c1.mo3284c(), 5)) {
                    throw new AssertionError();
                }
            }
        }
    }

    public final void m3320f() {
        AtomicReferenceArray atomicReferenceArray = this.f4328f;
        int length = atomicReferenceArray.length();
        if (length >= 1073741824) {
            return;
        }
        int i6 = this.f4324b;
        AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(length << 1);
        this.f4327e = (atomicReferenceArray2.length() * 3) / 4;
        int length2 = atomicReferenceArray2.length() - 1;
        for (int i10 = 0; i10 < length; i10++) {
            InterfaceC1406c0 interfaceC1406c0Mo3283b = (InterfaceC1406c0) atomicReferenceArray.get(i10);
            if (interfaceC1406c0Mo3283b != null) {
                InterfaceC1406c0 interfaceC1406c0Mo3283b2 = interfaceC1406c0Mo3283b.mo3283b();
                int iMo3284c = interfaceC1406c0Mo3283b.mo3284c() & length2;
                if (interfaceC1406c0Mo3283b2 == null) {
                    atomicReferenceArray2.set(iMo3284c, interfaceC1406c0Mo3283b);
                } else {
                    InterfaceC1406c0 interfaceC1406c0 = interfaceC1406c0Mo3283b;
                    while (interfaceC1406c0Mo3283b2 != null) {
                        int iMo3284c2 = interfaceC1406c0Mo3283b2.mo3284c() & length2;
                        if (iMo3284c2 != iMo3284c) {
                            interfaceC1406c0 = interfaceC1406c0Mo3283b2;
                            iMo3284c = iMo3284c2;
                        }
                        interfaceC1406c0Mo3283b2 = interfaceC1406c0Mo3283b2.mo3283b();
                    }
                    atomicReferenceArray2.set(iMo3284c, interfaceC1406c0);
                    while (interfaceC1406c0Mo3283b != interfaceC1406c0) {
                        int iMo3284c3 = interfaceC1406c0Mo3283b.mo3284c() & length2;
                        InterfaceC1406c0 interfaceC1406c0M3315a = m3315a(interfaceC1406c0Mo3283b, (InterfaceC1406c0) atomicReferenceArray2.get(iMo3284c3));
                        if (interfaceC1406c0M3315a != null) {
                            atomicReferenceArray2.set(iMo3284c3, interfaceC1406c0M3315a);
                        } else {
                            m3326l(interfaceC1406c0Mo3283b);
                            i6--;
                        }
                        interfaceC1406c0Mo3283b = interfaceC1406c0Mo3283b.mo3283b();
                    }
                }
            }
        }
        this.f4328f = atomicReferenceArray2;
        this.f4324b = i6;
    }

    public final void m3321g(long j10) {
        InterfaceC1406c0 interfaceC1406c0;
        InterfaceC1406c0 interfaceC1406c1;
        m3316b();
        do {
            interfaceC1406c0 = (InterfaceC1406c0) this.f4334l.peek();
            ConcurrentMapC1404b0 concurrentMapC1404b0 = this.f4323a;
            if (interfaceC1406c0 == null || !concurrentMapC1404b0.m3280d(interfaceC1406c0, j10)) {
                do {
                    interfaceC1406c1 = (InterfaceC1406c0) this.f4335m.peek();
                    if (interfaceC1406c1 == null || !concurrentMapC1404b0.m3280d(interfaceC1406c1, j10)) {
                        return;
                    }
                } while (m3327m(interfaceC1406c1, interfaceC1406c1.mo3284c(), 4));
                throw new AssertionError();
            }
        } while (m3327m(interfaceC1406c0, interfaceC1406c0.mo3284c(), 4));
        throw new AssertionError();
    }

    public final Object m3322h(int i6, Object obj) {
        try {
            if (this.f4324b != 0) {
                InterfaceC1406c0 interfaceC1406c0M3323i = m3323i(i6, this.f4323a.f4286m.mo3239a(), obj);
                if (interfaceC1406c0M3323i == null) {
                    return null;
                }
                Object obj2 = interfaceC1406c0M3323i.mo3282a().get();
                if (obj2 != null) {
                    this.f4323a.getClass();
                    this.f4332j.add(interfaceC1406c0M3323i);
                    interfaceC1406c0M3323i.getKey();
                    this.f4323a.getClass();
                    this.f4323a.getClass();
                    return obj2;
                }
                m3332r();
            }
            return null;
        } finally {
            m3324j();
        }
    }

    public final InterfaceC1406c0 m3323i(int i6, long j10, Object obj) {
        AtomicReferenceArray atomicReferenceArray = this.f4328f;
        InterfaceC1406c0 interfaceC1406c0Mo3283b = (InterfaceC1406c0) atomicReferenceArray.get((atomicReferenceArray.length() - 1) & i6);
        while (true) {
            if (interfaceC1406c0Mo3283b == null) {
                interfaceC1406c0Mo3283b = null;
                break;
            }
            if (interfaceC1406c0Mo3283b.mo3284c() == i6) {
                Object key = interfaceC1406c0Mo3283b.getKey();
                if (key == null) {
                    m3332r();
                } else if (this.f4323a.f4278e.m3238c(obj, key)) {
                    break;
                }
            }
            interfaceC1406c0Mo3283b = interfaceC1406c0Mo3283b.mo3283b();
        }
        if (interfaceC1406c0Mo3283b == null) {
            return null;
        }
        if (!this.f4323a.m3280d(interfaceC1406c0Mo3283b, j10)) {
            return interfaceC1406c0Mo3283b;
        }
        if (tryLock()) {
            try {
                m3321g(j10);
            } finally {
                unlock();
            }
        }
        return null;
    }

    public final void m3324j() {
        if ((this.f4333k.incrementAndGet() & 63) == 0) {
            m3329o(this.f4323a.f4286m.mo3239a());
            m3330p();
        }
    }

    public final Object m3325k(int i6, Object obj, Object obj2, boolean z7) {
        int i10;
        lock();
        try {
            long jMo3239a = this.f4323a.f4286m.mo3239a();
            m3329o(jMo3239a);
            if (this.f4324b + 1 > this.f4327e) {
                m3320f();
            }
            AtomicReferenceArray atomicReferenceArray = this.f4328f;
            int length = (atomicReferenceArray.length() - 1) & i6;
            InterfaceC1406c0 interfaceC1406c0 = (InterfaceC1406c0) atomicReferenceArray.get(length);
            for (InterfaceC1406c0 interfaceC1406c0Mo3283b = interfaceC1406c0; interfaceC1406c0Mo3283b != null; interfaceC1406c0Mo3283b = interfaceC1406c0Mo3283b.mo3283b()) {
                Object key = interfaceC1406c0Mo3283b.getKey();
                if (interfaceC1406c0Mo3283b.mo3284c() == i6 && key != null && this.f4323a.f4278e.m3238c(obj, key)) {
                    InterfaceC1426v interfaceC1426vMo3282a = interfaceC1406c0Mo3283b.mo3282a();
                    Object obj3 = interfaceC1426vMo3282a.get();
                    if (obj3 != null) {
                        if (z7) {
                            this.f4323a.getClass();
                            this.f4335m.add(interfaceC1406c0Mo3283b);
                            return obj3;
                        }
                        this.f4326d++;
                        m3318d(interfaceC1426vMo3282a.mo3301d(), obj, obj3, 2);
                        m3331q(interfaceC1406c0Mo3283b, obj2, jMo3239a);
                        m3319e(interfaceC1406c0Mo3283b);
                        return obj3;
                    }
                    this.f4326d++;
                    if (interfaceC1426vMo3282a.isActive()) {
                        m3318d(interfaceC1426vMo3282a.mo3301d(), obj, obj3, 3);
                        m3331q(interfaceC1406c0Mo3283b, obj2, jMo3239a);
                        i10 = this.f4324b;
                    } else {
                        m3331q(interfaceC1406c0Mo3283b, obj2, jMo3239a);
                        i10 = this.f4324b + 1;
                    }
                    this.f4324b = i10;
                    m3319e(interfaceC1406c0Mo3283b);
                    return null;
                }
            }
            this.f4326d++;
            int i11 = this.f4323a.f4287n;
            obj.getClass();
            InterfaceC1406c0 interfaceC1406c0M3307d = AbstractC1415k.m3307d(i11, this, obj, i6, interfaceC1406c0);
            m3331q(interfaceC1406c0M3307d, obj2, jMo3239a);
            atomicReferenceArray.set(length, interfaceC1406c0M3307d);
            this.f4324b++;
            m3319e(interfaceC1406c0M3307d);
            return null;
        } finally {
            unlock();
            m3330p();
        }
    }

    public final void m3326l(InterfaceC1406c0 interfaceC1406c0) {
        Object key = interfaceC1406c0.getKey();
        interfaceC1406c0.mo3284c();
        m3318d(interfaceC1406c0.mo3282a().mo3301d(), key, interfaceC1406c0.mo3282a().get(), 3);
        this.f4334l.remove(interfaceC1406c0);
        this.f4335m.remove(interfaceC1406c0);
    }

    public final boolean m3327m(InterfaceC1406c0 interfaceC1406c0, int i6, int i10) {
        AtomicReferenceArray atomicReferenceArray = this.f4328f;
        int length = (atomicReferenceArray.length() - 1) & i6;
        InterfaceC1406c0 interfaceC1406c1 = (InterfaceC1406c0) atomicReferenceArray.get(length);
        for (InterfaceC1406c0 interfaceC1406c0Mo3283b = interfaceC1406c1; interfaceC1406c0Mo3283b != null; interfaceC1406c0Mo3283b = interfaceC1406c0Mo3283b.mo3283b()) {
            if (interfaceC1406c0Mo3283b == interfaceC1406c0) {
                this.f4326d++;
                InterfaceC1406c0 interfaceC1406c0M3328n = m3328n(interfaceC1406c1, interfaceC1406c0Mo3283b, interfaceC1406c0Mo3283b.getKey(), i6, interfaceC1406c0Mo3283b.mo3282a().get(), interfaceC1406c0Mo3283b.mo3282a(), i10);
                int i11 = this.f4324b - 1;
                atomicReferenceArray.set(length, interfaceC1406c0M3328n);
                this.f4324b = i11;
                return true;
            }
        }
        return false;
    }

    public final InterfaceC1406c0 m3328n(InterfaceC1406c0 interfaceC1406c0, InterfaceC1406c0 interfaceC1406c1, Object obj, int i6, Object obj2, InterfaceC1426v interfaceC1426v, int i10) {
        m3318d(interfaceC1426v.mo3301d(), obj, obj2, i10);
        this.f4334l.remove(interfaceC1406c1);
        this.f4335m.remove(interfaceC1406c1);
        if (interfaceC1426v.isLoading()) {
            interfaceC1426v.mo3300c(null);
            return interfaceC1406c0;
        }
        int i11 = this.f4324b;
        InterfaceC1406c0 interfaceC1406c0Mo3283b = interfaceC1406c1.mo3283b();
        while (interfaceC1406c0 != interfaceC1406c1) {
            InterfaceC1406c0 interfaceC1406c0M3315a = m3315a(interfaceC1406c0, interfaceC1406c0Mo3283b);
            if (interfaceC1406c0M3315a != null) {
                interfaceC1406c0Mo3283b = interfaceC1406c0M3315a;
            } else {
                m3326l(interfaceC1406c0);
                i11--;
            }
            interfaceC1406c0 = interfaceC1406c0.mo3283b();
        }
        this.f4324b = i11;
        return interfaceC1406c0Mo3283b;
    }

    public final void m3329o(long j10) {
        if (tryLock()) {
            try {
                m3317c();
                m3321g(j10);
                this.f4333k.set(0);
            } finally {
                unlock();
            }
        }
    }

    public final void m3330p() {
        if (isHeldByCurrentThread()) {
            return;
        }
        this.f4323a.f4285l.getClass();
    }

    public final void m3331q(InterfaceC1406c0 interfaceC1406c0, Object obj, long j10) {
        InterfaceC1426v interfaceC1426vMo3282a = interfaceC1406c0.mo3282a();
        ConcurrentMapC1404b0 concurrentMapC1404b0 = this.f4323a;
        concurrentMapC1404b0.f4283j.getClass();
        if (concurrentMapC1404b0.f4281h == 0) {
            throw null;
        }
        interfaceC1406c0.mo3291j(new C1425u(obj));
        m3316b();
        this.f4325c += (long) 1;
        if (concurrentMapC1404b0.m3278b()) {
            interfaceC1406c0.mo3285d(j10);
        }
        this.f4335m.add(interfaceC1406c0);
        this.f4334l.add(interfaceC1406c0);
        interfaceC1426vMo3282a.mo3300c(obj);
    }

    public final void m3332r() {
        if (tryLock()) {
            try {
                m3317c();
            } finally {
                unlock();
            }
        }
    }
}
