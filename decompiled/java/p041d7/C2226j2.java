package p041d7;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class C2226j2 extends AbstractC2267p1 {

    public Object[] f7957d;

    public int f7958e;

    @Override
    public AbstractC2267p1 mo5221b(Object obj) {
        m5222g(obj);
        return this;
    }

    public void m5222g(Object obj) {
        obj.getClass();
        if (this.f7957d != null) {
            int iM5234j = AbstractC2233k2.m5234j(this.f8021b);
            Object[] objArr = this.f7957d;
            if (iM5234j <= objArr.length) {
                int length = objArr.length - 1;
                int iHashCode = obj.hashCode();
                int iM5129A = AbstractC2182d0.m5129A(iHashCode);
                while (true) {
                    int i6 = iM5129A & length;
                    Object[] objArr2 = this.f7957d;
                    Object obj2 = objArr2[i6];
                    if (obj2 == null) {
                        objArr2[i6] = obj;
                        this.f7958e += iHashCode;
                        m5255a(obj);
                        return;
                    } else if (obj2.equals(obj)) {
                        return;
                    } else {
                        iM5129A = i6 + 1;
                    }
                }
            }
        }
        this.f7957d = null;
        m5255a(obj);
    }

    public void m5223h(List list) {
        list.getClass();
        if (this.f7957d == null) {
            m5257d(list);
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            m5222g(it.next());
        }
    }

    public AbstractC2233k2 m5224i() {
        AbstractC2233k2 abstractC2233k2M5235k;
        int i6 = this.f8021b;
        if (i6 == 0) {
            int i10 = AbstractC2233k2.f7972c;
            return C2222i5.f7947j;
        }
        if (i6 == 1) {
            Object obj = this.f8020a[0];
            Objects.requireNonNull(obj);
            int i11 = AbstractC2233k2.f7972c;
            return new C2247m2(obj);
        }
        if (this.f7957d == null || AbstractC2233k2.m5234j(i6) != this.f7957d.length) {
            abstractC2233k2M5235k = AbstractC2233k2.m5235k(this.f8020a, this.f8021b);
            this.f8021b = abstractC2233k2M5235k.size();
        } else {
            int i12 = this.f8021b;
            Object[] objArrCopyOf = this.f8020a;
            int length = objArrCopyOf.length;
            if (i12 < (length >> 1) + (length >> 2)) {
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, i12);
            }
            int i13 = this.f7958e;
            Object[] objArr = this.f7957d;
            abstractC2233k2M5235k = new C2222i5(i13, objArr.length - 1, this.f8021b, objArrCopyOf, objArr);
        }
        this.f8022c = true;
        this.f7957d = null;
        return abstractC2233k2M5235k;
    }
}
