package p041d7;

import java.lang.ref.ReferenceQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;

public abstract class AbstractC2213h3 extends ReentrantLock {

    public static final int f7920g = 0;

    public final ConcurrentMapC2179c4 f7921a;

    public volatile int f7922b;

    public int f7923c;

    public int f7924d;

    public volatile AtomicReferenceArray f7925e;

    public final AtomicInteger f7926f = new AtomicInteger();

    public AbstractC2213h3(ConcurrentMapC2179c4 concurrentMapC2179c4, int i6) {
        this.f7921a = concurrentMapC2179c4;
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(i6);
        this.f7924d = (atomicReferenceArray.length() * 3) / 4;
        this.f7925e = atomicReferenceArray;
    }

    public final void m5192a(ReferenceQueue referenceQueue) {
        int i6 = 0;
        do {
            Object objPoll = referenceQueue.poll();
            if (objPoll == null) {
                return;
            }
            InterfaceC2199f3 interfaceC2199f3 = (InterfaceC2199f3) objPoll;
            ConcurrentMapC2179c4 concurrentMapC2179c4 = this.f7921a;
            concurrentMapC2179c4.getClass();
            int iMo5107c = interfaceC2199f3.mo5107c();
            AbstractC2213h3 abstractC2213h3M5122b = concurrentMapC2179c4.m5122b(iMo5107c);
            abstractC2213h3M5122b.lock();
            try {
                AtomicReferenceArray atomicReferenceArray = abstractC2213h3M5122b.f7925e;
                int length = iMo5107c & (atomicReferenceArray.length() - 1);
                InterfaceC2199f3 interfaceC2199f4 = (InterfaceC2199f3) atomicReferenceArray.get(length);
                for (InterfaceC2199f3 interfaceC2199f3Mo5106b = interfaceC2199f4; interfaceC2199f3Mo5106b != null; interfaceC2199f3Mo5106b = interfaceC2199f3Mo5106b.mo5106b()) {
                    if (interfaceC2199f3Mo5106b == interfaceC2199f3) {
                        abstractC2213h3M5122b.f7923c++;
                        InterfaceC2199f3 interfaceC2199f3M5200i = abstractC2213h3M5122b.m5200i(interfaceC2199f4, interfaceC2199f3Mo5106b);
                        int i10 = abstractC2213h3M5122b.f7922b - 1;
                        atomicReferenceArray.set(length, interfaceC2199f3M5200i);
                        abstractC2213h3M5122b.f7922b = i10;
                        break;
                    }
                }
                abstractC2213h3M5122b.unlock();
                i6++;
            } catch (Throwable th) {
                abstractC2213h3M5122b.unlock();
                throw th;
            }
        } while (i6 != 16);
    }

    public final void m5193b(ReferenceQueue referenceQueue) {
        int i6 = 0;
        do {
            Object objPoll = referenceQueue.poll();
            if (objPoll == null) {
                return;
            }
            InterfaceC2333z3 interfaceC2333z3 = (InterfaceC2333z3) objPoll;
            ConcurrentMapC2179c4 concurrentMapC2179c4 = this.f7921a;
            concurrentMapC2179c4.getClass();
            InterfaceC2199f3 interfaceC2199f3Mo5101a = interfaceC2333z3.mo5101a();
            int iMo5107c = interfaceC2199f3Mo5101a.mo5107c();
            AbstractC2213h3 abstractC2213h3M5122b = concurrentMapC2179c4.m5122b(iMo5107c);
            Object key = interfaceC2199f3Mo5101a.getKey();
            abstractC2213h3M5122b.lock();
            try {
                AtomicReferenceArray atomicReferenceArray = abstractC2213h3M5122b.f7925e;
                int length = (atomicReferenceArray.length() - 1) & iMo5107c;
                InterfaceC2199f3 interfaceC2199f3 = (InterfaceC2199f3) atomicReferenceArray.get(length);
                for (InterfaceC2199f3 interfaceC2199f3Mo5106b = interfaceC2199f3; interfaceC2199f3Mo5106b != null; interfaceC2199f3Mo5106b = interfaceC2199f3Mo5106b.mo5106b()) {
                    Object key2 = interfaceC2199f3Mo5106b.getKey();
                    if (interfaceC2199f3Mo5106b.mo5107c() == iMo5107c && key2 != null && abstractC2213h3M5122b.f7921a.f7857e.m3238c(key, key2)) {
                        if (((InterfaceC2327y3) interfaceC2199f3Mo5106b).mo5259a() != interfaceC2333z3) {
                            break;
                        }
                        abstractC2213h3M5122b.f7923c++;
                        InterfaceC2199f3 interfaceC2199f3M5200i = abstractC2213h3M5122b.m5200i(interfaceC2199f3, interfaceC2199f3Mo5106b);
                        int i10 = abstractC2213h3M5122b.f7922b - 1;
                        atomicReferenceArray.set(length, interfaceC2199f3M5200i);
                        abstractC2213h3M5122b.f7922b = i10;
                        break;
                    }
                }
                abstractC2213h3M5122b.unlock();
                i6++;
            } catch (Throwable th) {
                abstractC2213h3M5122b.unlock();
                throw th;
            }
        } while (i6 != 16);
    }

    public final void m5194c() {
        AtomicReferenceArray atomicReferenceArray = this.f7925e;
        int length = atomicReferenceArray.length();
        if (length >= 1073741824) {
            return;
        }
        int i6 = this.f7922b;
        AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(length << 1);
        this.f7924d = (atomicReferenceArray2.length() * 3) / 4;
        int length2 = atomicReferenceArray2.length() - 1;
        for (int i10 = 0; i10 < length; i10++) {
            InterfaceC2199f3 interfaceC2199f3Mo5106b = (InterfaceC2199f3) atomicReferenceArray.get(i10);
            if (interfaceC2199f3Mo5106b != null) {
                InterfaceC2199f3 interfaceC2199f3Mo5106b2 = interfaceC2199f3Mo5106b.mo5106b();
                int iMo5107c = interfaceC2199f3Mo5106b.mo5107c() & length2;
                if (interfaceC2199f3Mo5106b2 == null) {
                    atomicReferenceArray2.set(iMo5107c, interfaceC2199f3Mo5106b);
                } else {
                    InterfaceC2199f3 interfaceC2199f3 = interfaceC2199f3Mo5106b;
                    while (interfaceC2199f3Mo5106b2 != null) {
                        int iMo5107c2 = interfaceC2199f3Mo5106b2.mo5107c() & length2;
                        if (iMo5107c2 != iMo5107c) {
                            interfaceC2199f3 = interfaceC2199f3Mo5106b2;
                            iMo5107c = iMo5107c2;
                        }
                        interfaceC2199f3Mo5106b2 = interfaceC2199f3Mo5106b2.mo5106b();
                    }
                    atomicReferenceArray2.set(iMo5107c, interfaceC2199f3);
                    while (interfaceC2199f3Mo5106b != interfaceC2199f3) {
                        int iMo5107c3 = interfaceC2199f3Mo5106b.mo5107c() & length2;
                        InterfaceC2199f3 interfaceC2199f3Mo5184e = this.f7921a.f7858f.mo5184e(mo5202k(), interfaceC2199f3Mo5106b, (InterfaceC2199f3) atomicReferenceArray2.get(iMo5107c3));
                        if (interfaceC2199f3Mo5184e != null) {
                            atomicReferenceArray2.set(iMo5107c3, interfaceC2199f3Mo5184e);
                        } else {
                            i6--;
                        }
                        interfaceC2199f3Mo5106b = interfaceC2199f3Mo5106b.mo5106b();
                    }
                }
            }
        }
        this.f7925e = atomicReferenceArray2;
        this.f7922b = i6;
    }

    public final InterfaceC2199f3 m5195d(int i6, Object obj) {
        if (this.f7922b != 0) {
            AtomicReferenceArray atomicReferenceArray = this.f7925e;
            for (InterfaceC2199f3 interfaceC2199f3Mo5106b = (InterfaceC2199f3) atomicReferenceArray.get((atomicReferenceArray.length() - 1) & i6); interfaceC2199f3Mo5106b != null; interfaceC2199f3Mo5106b = interfaceC2199f3Mo5106b.mo5106b()) {
                if (interfaceC2199f3Mo5106b.mo5107c() == i6) {
                    Object key = interfaceC2199f3Mo5106b.getKey();
                    if (key == null) {
                        m5204m();
                    } else if (this.f7921a.f7857e.m3238c(obj, key)) {
                        return interfaceC2199f3Mo5106b;
                    }
                }
            }
        }
        return null;
    }

    public final void m5198g() {
        if ((this.f7926f.incrementAndGet() & 63) == 0) {
            m5201j();
        }
    }

    public final Object m5199h(int i6, Object obj, Object obj2, boolean z7) {
        lock();
        try {
            m5201j();
            int i10 = this.f7922b + 1;
            if (i10 > this.f7924d) {
                m5194c();
                i10 = this.f7922b + 1;
            }
            AtomicReferenceArray atomicReferenceArray = this.f7925e;
            int length = (atomicReferenceArray.length() - 1) & i6;
            InterfaceC2199f3 interfaceC2199f3 = (InterfaceC2199f3) atomicReferenceArray.get(length);
            for (InterfaceC2199f3 interfaceC2199f3Mo5106b = interfaceC2199f3; interfaceC2199f3Mo5106b != null; interfaceC2199f3Mo5106b = interfaceC2199f3Mo5106b.mo5106b()) {
                Object key = interfaceC2199f3Mo5106b.getKey();
                if (interfaceC2199f3Mo5106b.mo5107c() == i6 && key != null && this.f7921a.f7857e.m3238c(obj, key)) {
                    Object value = interfaceC2199f3Mo5106b.getValue();
                    if (value == null) {
                        this.f7923c++;
                        m5203l(interfaceC2199f3Mo5106b, obj2);
                        this.f7922b = this.f7922b;
                        return null;
                    }
                    if (z7) {
                        return value;
                    }
                    this.f7923c++;
                    m5203l(interfaceC2199f3Mo5106b, obj2);
                    return value;
                }
            }
            this.f7923c++;
            InterfaceC2199f3 interfaceC2199f3Mo5180a = this.f7921a.f7858f.mo5180a(mo5202k(), obj, i6, interfaceC2199f3);
            m5203l(interfaceC2199f3Mo5180a, obj2);
            atomicReferenceArray.set(length, interfaceC2199f3Mo5180a);
            this.f7922b = i10;
            return null;
        } finally {
            unlock();
        }
    }

    public final InterfaceC2199f3 m5200i(InterfaceC2199f3 interfaceC2199f3, InterfaceC2199f3 interfaceC2199f4) {
        int i6 = this.f7922b;
        InterfaceC2199f3 interfaceC2199f3Mo5106b = interfaceC2199f4.mo5106b();
        while (interfaceC2199f3 != interfaceC2199f4) {
            InterfaceC2199f3 interfaceC2199f3Mo5184e = this.f7921a.f7858f.mo5184e(mo5202k(), interfaceC2199f3, interfaceC2199f3Mo5106b);
            if (interfaceC2199f3Mo5184e != null) {
                interfaceC2199f3Mo5106b = interfaceC2199f3Mo5184e;
            } else {
                i6--;
            }
            interfaceC2199f3 = interfaceC2199f3.mo5106b();
        }
        this.f7922b = i6;
        return interfaceC2199f3Mo5106b;
    }

    public final void m5201j() {
        if (tryLock()) {
            try {
                mo5197f();
                this.f7926f.set(0);
            } finally {
                unlock();
            }
        }
    }

    public abstract AbstractC2213h3 mo5202k();

    public final void m5203l(InterfaceC2199f3 interfaceC2199f3, Object obj) {
        this.f7921a.f7858f.mo5182c(mo5202k(), interfaceC2199f3, obj);
    }

    public final void m5204m() {
        if (tryLock()) {
            try {
                mo5197f();
            } finally {
                unlock();
            }
        }
    }

    public void mo5196e() {
    }

    public void mo5197f() {
    }
}
