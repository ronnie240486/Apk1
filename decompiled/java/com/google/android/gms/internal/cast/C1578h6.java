package com.google.android.gms.internal.cast;

public final class C1578h6 extends AbstractC1503a1 {
    @Override
    public final C1548e6 mo3703d(AbstractC1558f6 abstractC1558f6) {
        C1548e6 c1548e6;
        C1548e6 c1548e7 = C1548e6.f5282d;
        synchronized (abstractC1558f6) {
            try {
                c1548e6 = abstractC1558f6.f5392e;
                if (c1548e6 != c1548e7) {
                    abstractC1558f6.f5392e = c1548e7;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return c1548e6;
    }

    @Override
    public final C1598j6 mo3704k(AbstractC1558f6 abstractC1558f6) {
        C1598j6 c1598j6;
        C1598j6 c1598j7 = C1598j6.f5365c;
        synchronized (abstractC1558f6) {
            try {
                c1598j6 = abstractC1558f6.f5393f;
                if (c1598j6 != c1598j7) {
                    abstractC1558f6.f5393f = c1598j7;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return c1598j6;
    }

    @Override
    public final void mo3705m(C1598j6 c1598j6, C1598j6 c1598j7) {
        c1598j6.f5367b = c1598j7;
    }

    @Override
    public final void mo3706o(C1598j6 c1598j6, Thread thread) {
        c1598j6.f5366a = thread;
    }

    @Override
    public final boolean mo3707q(AbstractC1558f6 abstractC1558f6, C1548e6 c1548e6, C1548e6 c1548e7) {
        synchronized (abstractC1558f6) {
            try {
                if (abstractC1558f6.f5392e != c1548e6) {
                    return false;
                }
                abstractC1558f6.f5392e = c1548e7;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override
    public final boolean mo3708r(AbstractC1608k6 abstractC1608k6, Object obj, Object obj2) {
        synchronized (abstractC1608k6) {
            try {
                if (abstractC1608k6.f5391d != obj) {
                    return false;
                }
                abstractC1608k6.f5391d = obj2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override
    public final boolean mo3709s(AbstractC1608k6 abstractC1608k6, C1598j6 c1598j6, C1598j6 c1598j7) {
        synchronized (abstractC1608k6) {
            try {
                if (abstractC1608k6.f5393f != c1598j6) {
                    return false;
                }
                abstractC1608k6.f5393f = c1598j7;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
