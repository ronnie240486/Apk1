package p029c7;

import androidx.media3.common.C0565C;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.logging.Logger;
import p020b7.AbstractC1332b;
import p020b7.AbstractC1344h;
import p020b7.AbstractC1351k0;
import p020b7.C1340f;
import p020b7.C1345h0;
import p187r4.AbstractC3612b;
import p249x4.C4112e;

public final class ConcurrentMapC1404b0 extends AbstractMap implements ConcurrentMap {

    public static final C1409e f4272s;

    public static final C1410f f4273t;

    public final int f4274a;

    public final int f4275b;

    public final C1421q[] f4276c;

    public final AbstractC1344h f4278e;

    public final AbstractC1344h f4279f;

    public final long f4282i;

    public final EnumC1405c f4283j;

    public final long f4284k;

    public final C1410f f4285l;

    public final AbstractC1351k0 f4286m;

    public final int f4287n;

    public final C4112e f4288o;

    public C1417m f4289p;

    public C1427w f4290q;

    public C1417m f4291r;

    public final int f4277d = Math.min(4, C0565C.DEFAULT_BUFFER_SEGMENT_SIZE);

    public final int f4280g = 1;

    public final int f4281h = 1;

    static {
        Logger.getLogger(ConcurrentMapC1404b0.class.getName());
        f4272s = new C1409e();
        f4273t = new C1410f();
    }

    public ConcurrentMapC1404b0(C1407d c1407d) {
        C1340f c1340f = C1340f.f4155a;
        this.f4278e = (AbstractC1344h) AbstractC1332b.m3227r(null, c1340f);
        this.f4279f = (AbstractC1344h) AbstractC1332b.m3227r(null, c1340f);
        long j10 = c1407d.f4297b;
        long j11 = j10 != 0 ? c1407d.f4296a : 0L;
        this.f4282i = j11;
        this.f4283j = EnumC1405c.f4292a;
        this.f4284k = j10 == -1 ? 0L : j10;
        this.f4285l = f4273t;
        this.f4286m = !m3278b() ? C1407d.f4295d : AbstractC1351k0.f4168a;
        this.f4287n = AbstractC1415k.f4306a[(m3277a() ? 1 : 0) | (m3278b() || m3278b() ? 2 : 0)];
        C1345h0 c1345h0 = C1407d.f4294c;
        this.f4288o = c1345h0.f4165a;
        int iMin = Math.min(16, 1073741824);
        iMin = m3277a() ? (int) Math.min(iMin, j11) : iMin;
        int i6 = 1;
        int i10 = 0;
        while (i6 < this.f4277d && (!m3277a() || ((long) i6) * 20 <= this.f4282i)) {
            i10++;
            i6 <<= 1;
        }
        this.f4275b = 32 - i10;
        this.f4274a = i6 - 1;
        this.f4276c = new C1421q[i6];
        int i11 = iMin / i6;
        int i12 = 1;
        while (i12 < (i11 * i6 < iMin ? i11 + 1 : i11)) {
            i12 <<= 1;
        }
        if (m3277a()) {
            long j12 = this.f4282i;
            long j13 = i6;
            long j14 = (j12 / j13) + 1;
            long j15 = j12 % j13;
            int i13 = 0;
            while (true) {
                C1421q[] c1421qArr = this.f4276c;
                if (i13 >= c1421qArr.length) {
                    return;
                }
                if (i13 == j15) {
                    j14--;
                }
                c1421qArr[i13] = new C1421q(this, i12, j14, c1345h0.f4165a);
                i13++;
            }
        } else {
            int i14 = 0;
            while (true) {
                C1421q[] c1421qArr2 = this.f4276c;
                if (i14 >= c1421qArr2.length) {
                    return;
                }
                c1421qArr2[i14] = new C1421q(this, i12, -1L, c1345h0.f4165a);
                i14++;
            }
        }
    }

    public final boolean m3277a() {
        return this.f4282i >= 0;
    }

    public final boolean m3278b() {
        return this.f4284k > 0;
    }

    public final int m3279c(Object obj) {
        int iMo3237b;
        AbstractC1344h abstractC1344h = this.f4278e;
        if (obj == null) {
            abstractC1344h.getClass();
            iMo3237b = 0;
        } else {
            iMo3237b = abstractC1344h.mo3237b(obj);
        }
        int i6 = iMo3237b + ((iMo3237b << 15) ^ (-12931));
        int i10 = i6 ^ (i6 >>> 10);
        int i11 = i10 + (i10 << 3);
        int i12 = i11 ^ (i11 >>> 6);
        int i13 = (i12 << 2) + (i12 << 14) + i12;
        return (i13 >>> 16) ^ i13;
    }

    @Override
    public final void clear() {
        for (C1421q c1421q : this.f4276c) {
            if (c1421q.f4324b != 0) {
                c1421q.lock();
                try {
                    c1421q.m3329o(c1421q.f4323a.f4286m.mo3239a());
                    AtomicReferenceArray atomicReferenceArray = c1421q.f4328f;
                    for (int i6 = 0; i6 < atomicReferenceArray.length(); i6++) {
                        for (InterfaceC1406c0 interfaceC1406c0Mo3283b = (InterfaceC1406c0) atomicReferenceArray.get(i6); interfaceC1406c0Mo3283b != null; interfaceC1406c0Mo3283b = interfaceC1406c0Mo3283b.mo3283b()) {
                            if (interfaceC1406c0Mo3283b.mo3282a().isActive()) {
                                Object key = interfaceC1406c0Mo3283b.getKey();
                                Object obj = interfaceC1406c0Mo3283b.mo3282a().get();
                                int i10 = (key == null || obj == null) ? 3 : 1;
                                interfaceC1406c0Mo3283b.mo3284c();
                                c1421q.m3318d(interfaceC1406c0Mo3283b.mo3282a().mo3301d(), key, obj, i10);
                            }
                        }
                    }
                    for (int i11 = 0; i11 < atomicReferenceArray.length(); i11++) {
                        atomicReferenceArray.set(i11, null);
                    }
                    ConcurrentMapC1404b0 concurrentMapC1404b0 = c1421q.f4323a;
                    if (concurrentMapC1404b0.f4280g != 1) {
                        while (c1421q.f4330h.poll() != null) {
                        }
                    }
                    if (concurrentMapC1404b0.f4281h != 1) {
                        while (c1421q.f4331i.poll() != null) {
                        }
                    }
                    c1421q.f4334l.clear();
                    c1421q.f4335m.clear();
                    c1421q.f4333k.set(0);
                    c1421q.f4326d++;
                    c1421q.f4324b = 0;
                    c1421q.unlock();
                    c1421q.m3330p();
                } catch (Throwable th) {
                    c1421q.unlock();
                    c1421q.m3330p();
                    throw th;
                }
            }
        }
    }

    @Override
    public final boolean containsKey(Object obj) {
        InterfaceC1406c0 interfaceC1406c0M3323i;
        boolean z7 = false;
        if (obj == null) {
            return false;
        }
        int iM3279c = m3279c(obj);
        C1421q c1421qM3281e = m3281e(iM3279c);
        c1421qM3281e.getClass();
        try {
            if (c1421qM3281e.f4324b != 0 && (interfaceC1406c0M3323i = c1421qM3281e.m3323i(iM3279c, c1421qM3281e.f4323a.f4286m.mo3239a(), obj)) != null && interfaceC1406c0M3323i.mo3282a().get() != null) {
                z7 = true;
            }
            return z7;
        } finally {
            c1421qM3281e.m3324j();
        }
    }

    @Override
    public final boolean containsValue(Object obj) {
        Object obj2;
        C1421q[] c1421qArr;
        Object obj3;
        if (obj == null) {
            return false;
        }
        long jMo3239a = this.f4286m.mo3239a();
        C1421q[] c1421qArr2 = this.f4276c;
        long j10 = -1;
        int i6 = 0;
        while (i6 < 3) {
            int length = c1421qArr2.length;
            long j11 = 0;
            int i10 = 0;
            while (i10 < length) {
                C1421q c1421q = c1421qArr2[i10];
                int i11 = c1421q.f4324b;
                AtomicReferenceArray atomicReferenceArray = c1421q.f4328f;
                for (int i12 = 0; i12 < atomicReferenceArray.length(); i12++) {
                    InterfaceC1406c0 interfaceC1406c0Mo3283b = (InterfaceC1406c0) atomicReferenceArray.get(i12);
                    while (interfaceC1406c0Mo3283b != null) {
                        if (interfaceC1406c0Mo3283b.getKey() == null || (obj2 = interfaceC1406c0Mo3283b.mo3282a().get()) == null) {
                            c1421q.m3332r();
                            c1421qArr = c1421qArr2;
                            obj3 = null;
                        } else {
                            c1421qArr = c1421qArr2;
                            if (c1421q.f4323a.m3280d(interfaceC1406c0Mo3283b, jMo3239a)) {
                                if (c1421q.tryLock()) {
                                    try {
                                        c1421q.m3321g(jMo3239a);
                                        c1421q.unlock();
                                    } catch (Throwable th) {
                                        c1421q.unlock();
                                        throw th;
                                    }
                                }
                                obj3 = null;
                            } else {
                                obj3 = obj2;
                            }
                        }
                        long j12 = jMo3239a;
                        if (obj3 != null && this.f4279f.m3238c(obj, obj3)) {
                            return true;
                        }
                        interfaceC1406c0Mo3283b = interfaceC1406c0Mo3283b.mo3283b();
                        jMo3239a = j12;
                        c1421qArr2 = c1421qArr;
                    }
                }
                j11 += (long) c1421q.f4326d;
                i10++;
                jMo3239a = jMo3239a;
            }
            long j13 = jMo3239a;
            C1421q[] c1421qArr3 = c1421qArr2;
            if (j11 == j10) {
                return false;
            }
            i6++;
            j10 = j11;
            jMo3239a = j13;
            c1421qArr2 = c1421qArr3;
        }
        return false;
    }

    public final boolean m3280d(InterfaceC1406c0 interfaceC1406c0, long j10) {
        interfaceC1406c0.getClass();
        return m3278b() && j10 - interfaceC1406c0.mo3292k() >= this.f4284k;
    }

    public final C1421q m3281e(int i6) {
        return this.f4276c[(i6 >>> this.f4275b) & this.f4274a];
    }

    @Override
    public final Set entrySet() {
        C1417m c1417m = this.f4291r;
        if (c1417m != null) {
            return c1417m;
        }
        C1417m c1417m2 = new C1417m(this, 0);
        this.f4291r = c1417m2;
        return c1417m2;
    }

    @Override
    public final Object get(Object obj) {
        if (obj == null) {
            return null;
        }
        int iM3279c = m3279c(obj);
        return m3281e(iM3279c).m3322h(iM3279c, obj);
    }

    @Override
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override
    public final boolean isEmpty() {
        C1421q[] c1421qArr = this.f4276c;
        long j10 = 0;
        for (C1421q c1421q : c1421qArr) {
            if (c1421q.f4324b != 0) {
                return false;
            }
            j10 += (long) c1421q.f4326d;
        }
        if (j10 == 0) {
            return true;
        }
        for (C1421q c1421q2 : c1421qArr) {
            if (c1421q2.f4324b != 0) {
                return false;
            }
            j10 -= (long) c1421q2.f4326d;
        }
        return j10 == 0;
    }

    @Override
    public final Set keySet() {
        C1417m c1417m = this.f4289p;
        if (c1417m != null) {
            return c1417m;
        }
        C1417m c1417m2 = new C1417m(this, 1);
        this.f4289p = c1417m2;
        return c1417m2;
    }

    @Override
    public final Object put(Object obj, Object obj2) {
        obj.getClass();
        obj2.getClass();
        int iM3279c = m3279c(obj);
        return m3281e(iM3279c).m3325k(iM3279c, obj, obj2, false);
    }

    @Override
    public final void putAll(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public final Object putIfAbsent(Object obj, Object obj2) {
        obj.getClass();
        obj2.getClass();
        int iM3279c = m3279c(obj);
        return m3281e(iM3279c).m3325k(iM3279c, obj, obj2, true);
    }

    @Override
    public final Object remove(Object obj) {
        int i6;
        if (obj == null) {
            return null;
        }
        int iM3279c = m3279c(obj);
        C1421q c1421qM3281e = m3281e(iM3279c);
        c1421qM3281e.lock();
        try {
            c1421qM3281e.m3329o(c1421qM3281e.f4323a.f4286m.mo3239a());
            AtomicReferenceArray atomicReferenceArray = c1421qM3281e.f4328f;
            int length = iM3279c & (atomicReferenceArray.length() - 1);
            InterfaceC1406c0 interfaceC1406c0 = (InterfaceC1406c0) atomicReferenceArray.get(length);
            for (InterfaceC1406c0 interfaceC1406c0Mo3283b = interfaceC1406c0; interfaceC1406c0Mo3283b != null; interfaceC1406c0Mo3283b = interfaceC1406c0Mo3283b.mo3283b()) {
                Object key = interfaceC1406c0Mo3283b.getKey();
                if (interfaceC1406c0Mo3283b.mo3284c() == iM3279c && key != null && c1421qM3281e.f4323a.f4278e.m3238c(obj, key)) {
                    InterfaceC1426v interfaceC1426vMo3282a = interfaceC1406c0Mo3283b.mo3282a();
                    Object obj2 = interfaceC1426vMo3282a.get();
                    if (obj2 == null) {
                        if (!interfaceC1426vMo3282a.isActive()) {
                            break;
                        }
                        i6 = 3;
                    } else {
                        i6 = 1;
                    }
                    c1421qM3281e.f4326d++;
                    InterfaceC1406c0 interfaceC1406c0M3328n = c1421qM3281e.m3328n(interfaceC1406c0, interfaceC1406c0Mo3283b, key, iM3279c, obj2, interfaceC1426vMo3282a, i6);
                    int i10 = c1421qM3281e.f4324b - 1;
                    atomicReferenceArray.set(length, interfaceC1406c0M3328n);
                    c1421qM3281e.f4324b = i10;
                    return obj2;
                }
            }
            return null;
        } finally {
            c1421qM3281e.unlock();
            c1421qM3281e.m3330p();
        }
    }

    @Override
    public final Object replace(Object obj, Object obj2) {
        obj.getClass();
        obj2.getClass();
        int iM3279c = m3279c(obj);
        C1421q c1421qM3281e = m3281e(iM3279c);
        c1421qM3281e.lock();
        try {
            long jMo3239a = c1421qM3281e.f4323a.f4286m.mo3239a();
            c1421qM3281e.m3329o(jMo3239a);
            AtomicReferenceArray atomicReferenceArray = c1421qM3281e.f4328f;
            int length = iM3279c & (atomicReferenceArray.length() - 1);
            InterfaceC1406c0 interfaceC1406c0 = (InterfaceC1406c0) atomicReferenceArray.get(length);
            for (InterfaceC1406c0 interfaceC1406c0Mo3283b = interfaceC1406c0; interfaceC1406c0Mo3283b != null; interfaceC1406c0Mo3283b = interfaceC1406c0Mo3283b.mo3283b()) {
                Object key = interfaceC1406c0Mo3283b.getKey();
                if (interfaceC1406c0Mo3283b.mo3284c() == iM3279c && key != null && c1421qM3281e.f4323a.f4278e.m3238c(obj, key)) {
                    InterfaceC1426v interfaceC1426vMo3282a = interfaceC1406c0Mo3283b.mo3282a();
                    Object obj3 = interfaceC1426vMo3282a.get();
                    if (obj3 != null) {
                        c1421qM3281e.f4326d++;
                        c1421qM3281e.m3318d(interfaceC1426vMo3282a.mo3301d(), obj, obj3, 2);
                        c1421qM3281e.m3331q(interfaceC1406c0Mo3283b, obj2, jMo3239a);
                        c1421qM3281e.m3319e(interfaceC1406c0Mo3283b);
                        return obj3;
                    }
                    if (!interfaceC1426vMo3282a.isActive()) {
                        break;
                    }
                    c1421qM3281e.f4326d++;
                    InterfaceC1406c0 interfaceC1406c0M3328n = c1421qM3281e.m3328n(interfaceC1406c0, interfaceC1406c0Mo3283b, key, iM3279c, obj3, interfaceC1426vMo3282a, 3);
                    int i6 = c1421qM3281e.f4324b - 1;
                    atomicReferenceArray.set(length, interfaceC1406c0M3328n);
                    c1421qM3281e.f4324b = i6;
                    break;
                }
            }
            return null;
        } finally {
            c1421qM3281e.unlock();
            c1421qM3281e.m3330p();
        }
    }

    @Override
    public final int size() {
        long jMax = 0;
        for (C1421q c1421q : this.f4276c) {
            jMax += (long) Math.max(0, c1421q.f4324b);
        }
        return AbstractC3612b.m7255K(jMax);
    }

    @Override
    public final Collection values() {
        C1427w c1427w = this.f4290q;
        if (c1427w != null) {
            return c1427w;
        }
        C1427w c1427w2 = new C1427w(this, 0);
        this.f4290q = c1427w2;
        return c1427w2;
    }

    @Override
    public final boolean remove(Object obj, Object obj2) {
        int i6;
        boolean z7 = false;
        if (obj == null || obj2 == null) {
            return false;
        }
        int iM3279c = m3279c(obj);
        C1421q c1421qM3281e = m3281e(iM3279c);
        c1421qM3281e.lock();
        try {
            c1421qM3281e.m3329o(c1421qM3281e.f4323a.f4286m.mo3239a());
            AtomicReferenceArray atomicReferenceArray = c1421qM3281e.f4328f;
            int length = iM3279c & (atomicReferenceArray.length() - 1);
            InterfaceC1406c0 interfaceC1406c0 = (InterfaceC1406c0) atomicReferenceArray.get(length);
            for (InterfaceC1406c0 interfaceC1406c0Mo3283b = interfaceC1406c0; interfaceC1406c0Mo3283b != null; interfaceC1406c0Mo3283b = interfaceC1406c0Mo3283b.mo3283b()) {
                Object key = interfaceC1406c0Mo3283b.getKey();
                if (interfaceC1406c0Mo3283b.mo3284c() == iM3279c && key != null && c1421qM3281e.f4323a.f4278e.m3238c(obj, key)) {
                    InterfaceC1426v interfaceC1426vMo3282a = interfaceC1406c0Mo3283b.mo3282a();
                    Object obj3 = interfaceC1426vMo3282a.get();
                    if (!c1421qM3281e.f4323a.f4279f.m3238c(obj2, obj3)) {
                        if (obj3 != null || !interfaceC1426vMo3282a.isActive()) {
                            break;
                            break;
                        }
                        i6 = 3;
                    } else {
                        i6 = 1;
                    }
                    c1421qM3281e.f4326d++;
                    InterfaceC1406c0 interfaceC1406c0M3328n = c1421qM3281e.m3328n(interfaceC1406c0, interfaceC1406c0Mo3283b, key, iM3279c, obj3, interfaceC1426vMo3282a, i6);
                    int i10 = c1421qM3281e.f4324b - 1;
                    atomicReferenceArray.set(length, interfaceC1406c0M3328n);
                    c1421qM3281e.f4324b = i10;
                    if (i6 != 1) {
                        break;
                    }
                    z7 = true;
                    break;
                }
            }
            return z7;
        } finally {
            c1421qM3281e.unlock();
            c1421qM3281e.m3330p();
        }
    }

    @Override
    public final boolean replace(Object obj, Object obj2, Object obj3) {
        obj.getClass();
        obj3.getClass();
        if (obj2 == null) {
            return false;
        }
        int iM3279c = m3279c(obj);
        C1421q c1421qM3281e = m3281e(iM3279c);
        c1421qM3281e.lock();
        try {
            long jMo3239a = c1421qM3281e.f4323a.f4286m.mo3239a();
            c1421qM3281e.m3329o(jMo3239a);
            AtomicReferenceArray atomicReferenceArray = c1421qM3281e.f4328f;
            int length = iM3279c & (atomicReferenceArray.length() - 1);
            InterfaceC1406c0 interfaceC1406c0 = (InterfaceC1406c0) atomicReferenceArray.get(length);
            for (InterfaceC1406c0 interfaceC1406c0Mo3283b = interfaceC1406c0; interfaceC1406c0Mo3283b != null; interfaceC1406c0Mo3283b = interfaceC1406c0Mo3283b.mo3283b()) {
                Object key = interfaceC1406c0Mo3283b.getKey();
                if (interfaceC1406c0Mo3283b.mo3284c() == iM3279c && key != null && c1421qM3281e.f4323a.f4278e.m3238c(obj, key)) {
                    InterfaceC1426v interfaceC1426vMo3282a = interfaceC1406c0Mo3283b.mo3282a();
                    Object obj4 = interfaceC1426vMo3282a.get();
                    if (obj4 == null) {
                        if (!interfaceC1426vMo3282a.isActive()) {
                            break;
                        }
                        c1421qM3281e.f4326d++;
                        InterfaceC1406c0 interfaceC1406c0M3328n = c1421qM3281e.m3328n(interfaceC1406c0, interfaceC1406c0Mo3283b, key, iM3279c, obj4, interfaceC1426vMo3282a, 3);
                        int i6 = c1421qM3281e.f4324b - 1;
                        atomicReferenceArray.set(length, interfaceC1406c0M3328n);
                        c1421qM3281e.f4324b = i6;
                        break;
                    }
                    if (c1421qM3281e.f4323a.f4279f.m3238c(obj2, obj4)) {
                        c1421qM3281e.f4326d++;
                        c1421qM3281e.m3318d(interfaceC1426vMo3282a.mo3301d(), obj, obj4, 2);
                        c1421qM3281e.m3331q(interfaceC1406c0Mo3283b, obj3, jMo3239a);
                        c1421qM3281e.m3319e(interfaceC1406c0Mo3283b);
                        return true;
                    }
                    c1421qM3281e.f4323a.getClass();
                    c1421qM3281e.f4335m.add(interfaceC1406c0Mo3283b);
                    break;
                }
            }
            return false;
        } finally {
            c1421qM3281e.unlock();
            c1421qM3281e.m3330p();
        }
    }
}
