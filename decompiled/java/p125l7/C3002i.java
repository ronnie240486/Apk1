package p125l7;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import p212t7.C3812a;
import p212t7.C3813b;

public final class C3002i extends AbstractC3011r {

    public final int f10292a;

    public final AbstractC3011r f10293b;

    public C3002i(AbstractC3011r abstractC3011r, int i6) {
        this.f10292a = i6;
        this.f10293b = abstractC3011r;
    }

    @Override
    public final Object mo6077a(C3812a c3812a) throws IOException {
        switch (this.f10292a) {
            case 0:
                return new AtomicLong(((Number) this.f10293b.mo6077a(c3812a)).longValue());
            case 1:
                ArrayList arrayList = new ArrayList();
                c3812a.m7592a();
                while (c3812a.m7599h()) {
                    arrayList.add(Long.valueOf(((Number) this.f10293b.mo6077a(c3812a)).longValue()));
                }
                c3812a.m7596e();
                int size = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i6 = 0; i6 < size; i6++) {
                    atomicLongArray.set(i6, ((Long) arrayList.get(i6)).longValue());
                }
                return atomicLongArray;
            default:
                if (c3812a.m7612u() != 9) {
                    return this.f10293b.mo6077a(c3812a);
                }
                c3812a.m7608q();
                return null;
        }
    }

    @Override
    public final void mo6078b(C3813b c3813b, Object obj) throws IOException {
        switch (this.f10292a) {
            case 0:
                this.f10293b.mo6078b(c3813b, Long.valueOf(((AtomicLong) obj).get()));
                break;
            case 1:
                AtomicLongArray atomicLongArray = (AtomicLongArray) obj;
                c3813b.m7619b();
                int length = atomicLongArray.length();
                for (int i6 = 0; i6 < length; i6++) {
                    this.f10293b.mo6078b(c3813b, Long.valueOf(atomicLongArray.get(i6)));
                }
                c3813b.m7622e();
                break;
            default:
                if (obj == null) {
                    c3813b.m7626i();
                } else {
                    this.f10293b.mo6078b(c3813b, obj);
                }
                break;
        }
    }
}
