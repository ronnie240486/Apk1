package p144n7;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Set;
import p001a0.C0022e;

public final class C3214l extends AbstractMap implements Serializable {

    public static final C0022e f10807h = new C0022e(5);

    public final Comparator f10808a;

    public C3213k f10809b;

    public int f10810c;

    public int f10811d;

    public final C3213k f10812e;

    public C3212j f10813f;

    public C3212j f10814g;

    public C3214l() {
        C0022e c0022e = f10807h;
        this.f10810c = 0;
        this.f10811d = 0;
        this.f10812e = new C3213k();
        this.f10808a = c0022e;
    }

    public final C3213k m6501a(Object obj, boolean z7) {
        int iCompareTo;
        C3213k c3213k;
        C3213k c3213k2 = this.f10809b;
        C0022e c0022e = f10807h;
        Comparator comparator = this.f10808a;
        if (c3213k2 != null) {
            Comparable comparable = comparator == c0022e ? (Comparable) obj : null;
            while (true) {
                Object obj2 = c3213k2.f10804f;
                iCompareTo = comparable != null ? comparable.compareTo(obj2) : comparator.compare(obj, obj2);
                if (iCompareTo == 0) {
                    return c3213k2;
                }
                C3213k c3213k3 = iCompareTo < 0 ? c3213k2.f10800b : c3213k2.f10801c;
                if (c3213k3 == null) {
                    break;
                }
                c3213k2 = c3213k3;
            }
        } else {
            iCompareTo = 0;
        }
        if (!z7) {
            return null;
        }
        C3213k c3213k4 = this.f10812e;
        if (c3213k2 != null) {
            c3213k = new C3213k(c3213k2, obj, c3213k4, c3213k4.f10803e);
            if (iCompareTo < 0) {
                c3213k2.f10800b = c3213k;
            } else {
                c3213k2.f10801c = c3213k;
            }
            m6502b(c3213k2, true);
        } else {
            if (comparator == c0022e && !(obj instanceof Comparable)) {
                throw new ClassCastException(obj.getClass().getName().concat(" is not Comparable"));
            }
            c3213k = new C3213k(c3213k2, obj, c3213k4, c3213k4.f10803e);
            this.f10809b = c3213k;
        }
        this.f10810c++;
        this.f10811d++;
        return c3213k;
    }

    public final void m6502b(C3213k c3213k, boolean z7) {
        while (c3213k != null) {
            C3213k c3213k2 = c3213k.f10800b;
            C3213k c3213k3 = c3213k.f10801c;
            int i6 = c3213k2 != null ? c3213k2.f10806h : 0;
            int i10 = c3213k3 != null ? c3213k3.f10806h : 0;
            int i11 = i6 - i10;
            if (i11 == -2) {
                C3213k c3213k4 = c3213k3.f10800b;
                C3213k c3213k5 = c3213k3.f10801c;
                int i12 = (c3213k4 != null ? c3213k4.f10806h : 0) - (c3213k5 != null ? c3213k5.f10806h : 0);
                if (i12 == -1 || (i12 == 0 && !z7)) {
                    m6505e(c3213k);
                } else {
                    m6506f(c3213k3);
                    m6505e(c3213k);
                }
                if (z7) {
                    return;
                }
            } else if (i11 == 2) {
                C3213k c3213k6 = c3213k2.f10800b;
                C3213k c3213k7 = c3213k2.f10801c;
                int i13 = (c3213k6 != null ? c3213k6.f10806h : 0) - (c3213k7 != null ? c3213k7.f10806h : 0);
                if (i13 == 1 || (i13 == 0 && !z7)) {
                    m6506f(c3213k);
                } else {
                    m6505e(c3213k2);
                    m6506f(c3213k);
                }
                if (z7) {
                    return;
                }
            } else if (i11 == 0) {
                c3213k.f10806h = i6 + 1;
                if (z7) {
                    return;
                }
            } else {
                c3213k.f10806h = Math.max(i6, i10) + 1;
                if (!z7) {
                    return;
                }
            }
            c3213k = c3213k.f10799a;
        }
    }

    public final void m6503c(C3213k c3213k, boolean z7) {
        C3213k c3213k2;
        C3213k c3213k3;
        int i6;
        if (z7) {
            C3213k c3213k4 = c3213k.f10803e;
            c3213k4.f10802d = c3213k.f10802d;
            c3213k.f10802d.f10803e = c3213k4;
        }
        C3213k c3213k5 = c3213k.f10800b;
        C3213k c3213k6 = c3213k.f10801c;
        C3213k c3213k7 = c3213k.f10799a;
        int i10 = 0;
        if (c3213k5 == null || c3213k6 == null) {
            if (c3213k5 != null) {
                m6504d(c3213k, c3213k5);
                c3213k.f10800b = null;
            } else if (c3213k6 != null) {
                m6504d(c3213k, c3213k6);
                c3213k.f10801c = null;
            } else {
                m6504d(c3213k, null);
            }
            m6502b(c3213k7, false);
            this.f10810c--;
            this.f10811d++;
            return;
        }
        if (c3213k5.f10806h > c3213k6.f10806h) {
            C3213k c3213k8 = c3213k5.f10801c;
            while (true) {
                C3213k c3213k9 = c3213k8;
                c3213k3 = c3213k5;
                c3213k5 = c3213k9;
                if (c3213k5 == null) {
                    break;
                } else {
                    c3213k8 = c3213k5.f10801c;
                }
            }
        } else {
            C3213k c3213k10 = c3213k6.f10800b;
            while (true) {
                c3213k2 = c3213k6;
                c3213k6 = c3213k10;
                if (c3213k6 == null) {
                    break;
                } else {
                    c3213k10 = c3213k6.f10800b;
                }
            }
            c3213k3 = c3213k2;
        }
        m6503c(c3213k3, false);
        C3213k c3213k11 = c3213k.f10800b;
        if (c3213k11 != null) {
            i6 = c3213k11.f10806h;
            c3213k3.f10800b = c3213k11;
            c3213k11.f10799a = c3213k3;
            c3213k.f10800b = null;
        } else {
            i6 = 0;
        }
        C3213k c3213k12 = c3213k.f10801c;
        if (c3213k12 != null) {
            i10 = c3213k12.f10806h;
            c3213k3.f10801c = c3213k12;
            c3213k12.f10799a = c3213k3;
            c3213k.f10801c = null;
        }
        c3213k3.f10806h = Math.max(i6, i10) + 1;
        m6504d(c3213k, c3213k3);
    }

    @Override
    public final void clear() {
        this.f10809b = null;
        this.f10810c = 0;
        this.f10811d++;
        C3213k c3213k = this.f10812e;
        c3213k.f10803e = c3213k;
        c3213k.f10802d = c3213k;
    }

    @Override
    public final boolean containsKey(Object obj) {
        C3213k c3213kM6501a = null;
        if (obj != null) {
            try {
                c3213kM6501a = m6501a(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        return c3213kM6501a != null;
    }

    public final void m6504d(C3213k c3213k, C3213k c3213k2) {
        C3213k c3213k3 = c3213k.f10799a;
        c3213k.f10799a = null;
        if (c3213k2 != null) {
            c3213k2.f10799a = c3213k3;
        }
        if (c3213k3 == null) {
            this.f10809b = c3213k2;
        } else if (c3213k3.f10800b == c3213k) {
            c3213k3.f10800b = c3213k2;
        } else {
            c3213k3.f10801c = c3213k2;
        }
    }

    public final void m6505e(C3213k c3213k) {
        C3213k c3213k2 = c3213k.f10800b;
        C3213k c3213k3 = c3213k.f10801c;
        C3213k c3213k4 = c3213k3.f10800b;
        C3213k c3213k5 = c3213k3.f10801c;
        c3213k.f10801c = c3213k4;
        if (c3213k4 != null) {
            c3213k4.f10799a = c3213k;
        }
        m6504d(c3213k, c3213k3);
        c3213k3.f10800b = c3213k;
        c3213k.f10799a = c3213k3;
        int iMax = Math.max(c3213k2 != null ? c3213k2.f10806h : 0, c3213k4 != null ? c3213k4.f10806h : 0) + 1;
        c3213k.f10806h = iMax;
        c3213k3.f10806h = Math.max(iMax, c3213k5 != null ? c3213k5.f10806h : 0) + 1;
    }

    @Override
    public final Set entrySet() {
        C3212j c3212j = this.f10813f;
        if (c3212j != null) {
            return c3212j;
        }
        C3212j c3212j2 = new C3212j(this, 0);
        this.f10813f = c3212j2;
        return c3212j2;
    }

    public final void m6506f(C3213k c3213k) {
        C3213k c3213k2 = c3213k.f10800b;
        C3213k c3213k3 = c3213k.f10801c;
        C3213k c3213k4 = c3213k2.f10800b;
        C3213k c3213k5 = c3213k2.f10801c;
        c3213k.f10800b = c3213k5;
        if (c3213k5 != null) {
            c3213k5.f10799a = c3213k;
        }
        m6504d(c3213k, c3213k2);
        c3213k2.f10801c = c3213k;
        c3213k.f10799a = c3213k2;
        int iMax = Math.max(c3213k3 != null ? c3213k3.f10806h : 0, c3213k5 != null ? c3213k5.f10806h : 0) + 1;
        c3213k.f10806h = iMax;
        c3213k2.f10806h = Math.max(iMax, c3213k4 != null ? c3213k4.f10806h : 0) + 1;
    }

    @Override
    public final Object get(Object obj) {
        C3213k c3213kM6501a;
        if (obj != null) {
            try {
                c3213kM6501a = m6501a(obj, false);
            } catch (ClassCastException unused) {
                c3213kM6501a = null;
            }
        } else {
            c3213kM6501a = null;
        }
        if (c3213kM6501a != null) {
            return c3213kM6501a.f10805g;
        }
        return null;
    }

    @Override
    public final Set keySet() {
        C3212j c3212j = this.f10814g;
        if (c3212j != null) {
            return c3212j;
        }
        C3212j c3212j2 = new C3212j(this, 1);
        this.f10814g = c3212j2;
        return c3212j2;
    }

    @Override
    public final Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        C3213k c3213kM6501a = m6501a(obj, true);
        Object obj3 = c3213kM6501a.f10805g;
        c3213kM6501a.f10805g = obj2;
        return obj3;
    }

    @Override
    public final Object remove(Object obj) {
        C3213k c3213kM6501a;
        if (obj != null) {
            try {
                c3213kM6501a = m6501a(obj, false);
            } catch (ClassCastException unused) {
                c3213kM6501a = null;
            }
        } else {
            c3213kM6501a = null;
        }
        if (c3213kM6501a != null) {
            m6503c(c3213kM6501a, true);
        }
        if (c3213kM6501a != null) {
            return c3213kM6501a.f10805g;
        }
        return null;
    }

    @Override
    public final int size() {
        return this.f10810c;
    }
}
