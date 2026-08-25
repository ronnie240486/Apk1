package p160p;

import java.util.Arrays;
import p000a.AbstractC0004e;
import p103j9.AbstractC2796i;
import p171q.AbstractC3387a;
import p253x8.AbstractC4146i;

public final class C3345i implements Cloneable {

    public boolean f11326a;

    public long[] f11327b;

    public Object[] f11328c;

    public int f11329d;

    public C3345i() {
        int i6;
        int i10 = 4;
        while (true) {
            i6 = 80;
            if (i10 >= 32) {
                break;
            }
            int i11 = (1 << i10) - 12;
            if (80 <= i11) {
                i6 = i11;
                break;
            }
            i10++;
        }
        int i12 = i6 / 8;
        this.f11327b = new long[i12];
        this.f11328c = new Object[i12];
    }

    public final void m6794a(long j10, Long l9) {
        int i6 = this.f11329d;
        if (i6 != 0 && j10 <= this.f11327b[i6 - 1]) {
            m6801h(j10, l9);
            return;
        }
        if (this.f11326a) {
            long[] jArr = this.f11327b;
            if (i6 >= jArr.length) {
                Object[] objArr = this.f11328c;
                int i10 = 0;
                for (int i11 = 0; i11 < i6; i11++) {
                    Object obj = objArr[i11];
                    if (obj != AbstractC3346j.f11330a) {
                        if (i11 != i10) {
                            jArr[i10] = jArr[i11];
                            objArr[i10] = obj;
                            objArr[i11] = null;
                        }
                        i10++;
                    }
                }
                this.f11326a = false;
                this.f11329d = i10;
            }
        }
        int i12 = this.f11329d;
        if (i12 >= this.f11327b.length) {
            int i13 = (i12 + 1) * 8;
            for (int i14 = 4; i14 < 32; i14++) {
                int i15 = (1 << i14) - 12;
                if (i13 <= i15) {
                    i13 = i15;
                    break;
                }
            }
            int i16 = i13 / 8;
            long[] jArrCopyOf = Arrays.copyOf(this.f11327b, i16);
            AbstractC2796i.m5784e(jArrCopyOf, "copyOf(this, newSize)");
            this.f11327b = jArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f11328c, i16);
            AbstractC2796i.m5784e(objArrCopyOf, "copyOf(this, newSize)");
            this.f11328c = objArrCopyOf;
        }
        this.f11327b[i12] = j10;
        this.f11328c[i12] = l9;
        this.f11329d = i12 + 1;
    }

    public final void m6795b() {
        int i6 = this.f11329d;
        Object[] objArr = this.f11328c;
        for (int i10 = 0; i10 < i6; i10++) {
            objArr[i10] = null;
        }
        this.f11329d = 0;
        this.f11326a = false;
    }

    public final C3345i clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        AbstractC2796i.m5783d(objClone, "null cannot be cast to non-null type androidx.collection.LongSparseArray<E of androidx.collection.LongSparseArray>");
        C3345i c3345i = (C3345i) objClone;
        c3345i.f11327b = (long[]) this.f11327b.clone();
        c3345i.f11328c = (Object[]) this.f11328c.clone();
        return c3345i;
    }

    public final Object m6797d(long j10) {
        Object obj;
        int iM6877b = AbstractC3387a.m6877b(this.f11327b, this.f11329d, j10);
        if (iM6877b < 0 || (obj = this.f11328c[iM6877b]) == AbstractC3346j.f11330a) {
            return null;
        }
        return obj;
    }

    public final Object m6798e(long j10) {
        Object obj;
        int iM6877b = AbstractC3387a.m6877b(this.f11327b, this.f11329d, j10);
        if (iM6877b < 0 || (obj = this.f11328c[iM6877b]) == AbstractC3346j.f11330a) {
            return -1L;
        }
        return obj;
    }

    public final int m6799f(long j10) {
        if (this.f11326a) {
            int i6 = this.f11329d;
            long[] jArr = this.f11327b;
            Object[] objArr = this.f11328c;
            int i10 = 0;
            for (int i11 = 0; i11 < i6; i11++) {
                Object obj = objArr[i11];
                if (obj != AbstractC3346j.f11330a) {
                    if (i11 != i10) {
                        jArr[i10] = jArr[i11];
                        objArr[i10] = obj;
                        objArr[i11] = null;
                    }
                    i10++;
                }
            }
            this.f11326a = false;
            this.f11329d = i10;
        }
        return AbstractC3387a.m6877b(this.f11327b, this.f11329d, j10);
    }

    public final long m6800g(int i6) {
        int i10;
        if (i6 < 0 || i6 >= (i10 = this.f11329d)) {
            throw new IllegalArgumentException(AbstractC0004e.m20n(i6, "Expected index to be within 0..size()-1, but was ").toString());
        }
        if (this.f11326a) {
            long[] jArr = this.f11327b;
            Object[] objArr = this.f11328c;
            int i11 = 0;
            for (int i12 = 0; i12 < i10; i12++) {
                Object obj = objArr[i12];
                if (obj != AbstractC3346j.f11330a) {
                    if (i12 != i11) {
                        jArr[i11] = jArr[i12];
                        objArr[i11] = obj;
                        objArr[i12] = null;
                    }
                    i11++;
                }
            }
            this.f11326a = false;
            this.f11329d = i11;
        }
        return this.f11327b[i6];
    }

    public final void m6801h(long j10, Object obj) {
        int iM6877b = AbstractC3387a.m6877b(this.f11327b, this.f11329d, j10);
        if (iM6877b >= 0) {
            this.f11328c[iM6877b] = obj;
            return;
        }
        int i6 = ~iM6877b;
        int i10 = this.f11329d;
        Object obj2 = AbstractC3346j.f11330a;
        if (i6 < i10) {
            Object[] objArr = this.f11328c;
            if (objArr[i6] == obj2) {
                this.f11327b[i6] = j10;
                objArr[i6] = obj;
                return;
            }
        }
        if (this.f11326a) {
            long[] jArr = this.f11327b;
            if (i10 >= jArr.length) {
                Object[] objArr2 = this.f11328c;
                int i11 = 0;
                for (int i12 = 0; i12 < i10; i12++) {
                    Object obj3 = objArr2[i12];
                    if (obj3 != obj2) {
                        if (i12 != i11) {
                            jArr[i11] = jArr[i12];
                            objArr2[i11] = obj3;
                            objArr2[i12] = null;
                        }
                        i11++;
                    }
                }
                this.f11326a = false;
                this.f11329d = i11;
                i6 = ~AbstractC3387a.m6877b(this.f11327b, i11, j10);
            }
        }
        int i13 = this.f11329d;
        if (i13 >= this.f11327b.length) {
            int i14 = (i13 + 1) * 8;
            for (int i15 = 4; i15 < 32; i15++) {
                int i16 = (1 << i15) - 12;
                if (i14 <= i16) {
                    i14 = i16;
                    break;
                }
            }
            int i17 = i14 / 8;
            long[] jArrCopyOf = Arrays.copyOf(this.f11327b, i17);
            AbstractC2796i.m5784e(jArrCopyOf, "copyOf(this, newSize)");
            this.f11327b = jArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f11328c, i17);
            AbstractC2796i.m5784e(objArrCopyOf, "copyOf(this, newSize)");
            this.f11328c = objArrCopyOf;
        }
        int i18 = this.f11329d - i6;
        if (i18 != 0) {
            long[] jArr2 = this.f11327b;
            int i19 = i6 + 1;
            AbstractC2796i.m5785f(jArr2, "<this>");
            System.arraycopy(jArr2, i6, jArr2, i19, i18);
            Object[] objArr3 = this.f11328c;
            AbstractC4146i.m8171D(i19, i6, this.f11329d, objArr3, objArr3);
        }
        this.f11327b[i6] = j10;
        this.f11328c[i6] = obj;
        this.f11329d++;
    }

    public final void m6802i(long j10) {
        int iM6877b = AbstractC3387a.m6877b(this.f11327b, this.f11329d, j10);
        if (iM6877b >= 0) {
            Object[] objArr = this.f11328c;
            Object obj = objArr[iM6877b];
            Object obj2 = AbstractC3346j.f11330a;
            if (obj != obj2) {
                objArr[iM6877b] = obj2;
                this.f11326a = true;
            }
        }
    }

    public final int m6803j() {
        if (this.f11326a) {
            int i6 = this.f11329d;
            long[] jArr = this.f11327b;
            Object[] objArr = this.f11328c;
            int i10 = 0;
            for (int i11 = 0; i11 < i6; i11++) {
                Object obj = objArr[i11];
                if (obj != AbstractC3346j.f11330a) {
                    if (i11 != i10) {
                        jArr[i10] = jArr[i11];
                        objArr[i10] = obj;
                        objArr[i11] = null;
                    }
                    i10++;
                }
            }
            this.f11326a = false;
            this.f11329d = i10;
        }
        return this.f11329d;
    }

    public final Object m6804k(int i6) {
        int i10;
        if (i6 < 0 || i6 >= (i10 = this.f11329d)) {
            throw new IllegalArgumentException(AbstractC0004e.m20n(i6, "Expected index to be within 0..size()-1, but was ").toString());
        }
        if (this.f11326a) {
            long[] jArr = this.f11327b;
            Object[] objArr = this.f11328c;
            int i11 = 0;
            for (int i12 = 0; i12 < i10; i12++) {
                Object obj = objArr[i12];
                if (obj != AbstractC3346j.f11330a) {
                    if (i12 != i11) {
                        jArr[i11] = jArr[i12];
                        objArr[i11] = obj;
                        objArr[i12] = null;
                    }
                    i11++;
                }
            }
            this.f11326a = false;
            this.f11329d = i11;
        }
        return this.f11328c[i6];
    }

    public final String toString() {
        if (m6803j() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f11329d * 28);
        sb.append('{');
        int i6 = this.f11329d;
        for (int i10 = 0; i10 < i6; i10++) {
            if (i10 > 0) {
                sb.append(", ");
            }
            sb.append(m6800g(i10));
            sb.append('=');
            Object objM6804k = m6804k(i10);
            if (objM6804k != sb) {
                sb.append(objM6804k);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        AbstractC2796i.m5784e(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }
}
