package p002a1;

import android.os.SystemClock;
import android.view.Choreographer;
import java.util.ArrayList;
import p000a.AbstractC0004e;
import p001a0.C0019b;
import p160p.C3347k;
import p237w0.AbstractC4044e;

public final class ChoreographerFrameCallbackC0025a implements Choreographer.FrameCallback {

    public final int f50a;

    public final Object f51b;

    public ChoreographerFrameCallbackC0025a(int i6, Object obj) {
        this.f50a = i6;
        this.f51b = obj;
    }

    @Override
    public final void doFrame(long j10) {
        long j11;
        long j12;
        float f;
        float f3;
        C0031g c0031g;
        boolean z7;
        ThreadLocal threadLocal;
        C0027c c0027c;
        ArrayList arrayList;
        int iIndexOf;
        int i6;
        ArrayList arrayList2;
        int size;
        float f4;
        switch (this.f50a) {
            case 0:
                C0019b c0019b = (C0019b) ((C0026b) this.f51b).f54b;
                c0019b.getClass();
                long jUptimeMillis = SystemClock.uptimeMillis();
                C0027c c0027c2 = (C0027c) c0019b.f38b;
                c0027c2.getClass();
                long jUptimeMillis2 = SystemClock.uptimeMillis();
                boolean z10 = false;
                int i10 = 0;
                while (true) {
                    ArrayList arrayList3 = c0027c2.f59b;
                    if (i10 >= arrayList3.size()) {
                        if (c0027c2.f62e) {
                            for (int size2 = arrayList3.size() - 1; size2 >= 0; size2--) {
                                if (arrayList3.get(size2) == null) {
                                    arrayList3.remove(size2);
                                }
                            }
                            c0027c2.f62e = false;
                        }
                        if (arrayList3.size() > 0) {
                            if (c0027c2.f61d == null) {
                                c0027c2.f61d = new C0026b(c0027c2.f60c);
                            }
                            C0026b c0026b = c0027c2.f61d;
                            ((Choreographer) c0026b.f55c).postFrameCallback((ChoreographerFrameCallbackC0025a) c0026b.f56d);
                            return;
                        }
                        return;
                    }
                    C0030f c0030f = (C0030f) arrayList3.get(i10);
                    if (c0030f != null) {
                        C3347k c3347k = c0027c2.f58a;
                        Long l9 = (Long) c3347k.get(c0030f);
                        if (l9 != null) {
                            if (l9.longValue() < jUptimeMillis2) {
                                c3347k.remove(c0030f);
                                j11 = c0030f.f77g;
                                if (j11 == 0) {
                                    c0030f.f77g = jUptimeMillis;
                                    c0030f.m146a(c0030f.f72b);
                                    i10 = i10;
                                } else {
                                    j12 = jUptimeMillis - j11;
                                    c0030f.f77g = jUptimeMillis;
                                    if (c0030f.f83m) {
                                        f4 = c0030f.f82l;
                                        if (f4 != Float.MAX_VALUE) {
                                            c0030f.f81k.f92i = f4;
                                            c0030f.f82l = Float.MAX_VALUE;
                                        }
                                        c0030f.f72b = (float) c0030f.f81k.f92i;
                                        c0030f.f71a = 0.0f;
                                        c0030f.f83m = z10;
                                        i10 = i10;
                                    } else {
                                        if (c0030f.f82l != Float.MAX_VALUE) {
                                            C0031g c0031g2 = c0030f.f81k;
                                            double d = c0031g2.f92i;
                                            long j13 = j12 / 2;
                                            C0029e c0029eM148a = c0031g2.m148a(c0030f.f72b, c0030f.f71a, j13);
                                            C0031g c0031g3 = c0030f.f81k;
                                            c0031g3.f92i = c0030f.f82l;
                                            c0030f.f82l = Float.MAX_VALUE;
                                            C0029e c0029eM148a2 = c0031g3.m148a(c0029eM148a.f63a, c0029eM148a.f64b, j13);
                                            c0030f.f72b = c0029eM148a2.f63a;
                                            c0030f.f71a = c0029eM148a2.f64b;
                                            f = 0.0f;
                                        } else {
                                            f = 0.0f;
                                            C0029e c0029eM148a3 = c0030f.f81k.m148a(c0030f.f72b, c0030f.f71a, j12);
                                            c0030f.f72b = c0029eM148a3.f63a;
                                            c0030f.f71a = c0029eM148a3.f64b;
                                        }
                                        float fMax = Math.max(c0030f.f72b, -3.4028235E38f);
                                        c0030f.f72b = fMax;
                                        float fMin = Math.min(fMax, Float.MAX_VALUE);
                                        c0030f.f72b = fMin;
                                        f3 = c0030f.f71a;
                                        c0031g = c0030f.f81k;
                                        c0031g.getClass();
                                        if (Math.abs(f3) < c0031g.f88e || Math.abs(fMin - ((float) c0031g.f92i)) >= c0031g.f87d) {
                                            z7 = false;
                                        } else {
                                            c0030f.f72b = (float) c0030f.f81k.f92i;
                                            c0030f.f71a = f;
                                        }
                                        float fMin2 = Math.min(c0030f.f72b, Float.MAX_VALUE);
                                        c0030f.f72b = fMin2;
                                        float fMax2 = Math.max(fMin2, -3.4028235E38f);
                                        c0030f.f72b = fMax2;
                                        c0030f.m146a(fMax2);
                                        if (z7) {
                                            c0030f.f76f = false;
                                            threadLocal = C0027c.f57f;
                                            if (threadLocal.get() == null) {
                                                threadLocal.set(new C0027c());
                                            }
                                            c0027c = (C0027c) threadLocal.get();
                                            c0027c.f58a.remove(c0030f);
                                            arrayList = c0027c.f59b;
                                            iIndexOf = arrayList.indexOf(c0030f);
                                            if (iIndexOf >= 0) {
                                                arrayList.set(iIndexOf, null);
                                                c0027c.f62e = true;
                                            }
                                            c0030f.f77g = 0L;
                                            c0030f.f73c = false;
                                            i6 = 0;
                                            while (true) {
                                                arrayList2 = c0030f.f79i;
                                                if (i6 < arrayList2.size()) {
                                                    while (size >= 0) {
                                                        if (arrayList2.get(size) == null) {
                                                            arrayList2.remove(size);
                                                        }
                                                    }
                                                }
                                                if (arrayList2.get(i6) == null) {
                                                    throw AbstractC0004e.m17k(i6, arrayList2);
                                                }
                                                i6++;
                                            }
                                        } else {
                                            continue;
                                        }
                                    }
                                    z7 = true;
                                    float fMin3 = Math.min(c0030f.f72b, Float.MAX_VALUE);
                                    c0030f.f72b = fMin3;
                                    float fMax3 = Math.max(fMin3, -3.4028235E38f);
                                    c0030f.f72b = fMax3;
                                    c0030f.m146a(fMax3);
                                    if (z7) {
                                        c0030f.f76f = false;
                                        threadLocal = C0027c.f57f;
                                        if (threadLocal.get() == null) {
                                            threadLocal.set(new C0027c());
                                        }
                                        c0027c = (C0027c) threadLocal.get();
                                        c0027c.f58a.remove(c0030f);
                                        arrayList = c0027c.f59b;
                                        iIndexOf = arrayList.indexOf(c0030f);
                                        if (iIndexOf >= 0) {
                                            arrayList.set(iIndexOf, null);
                                            c0027c.f62e = true;
                                        }
                                        c0030f.f77g = 0L;
                                        c0030f.f73c = false;
                                        i6 = 0;
                                        while (true) {
                                            arrayList2 = c0030f.f79i;
                                            if (i6 < arrayList2.size()) {
                                                while (size >= 0) {
                                                    if (arrayList2.get(size) == null) {
                                                        arrayList2.remove(size);
                                                    }
                                                }
                                            }
                                            if (arrayList2.get(i6) == null) {
                                                throw AbstractC0004e.m17k(i6, arrayList2);
                                            }
                                            i6++;
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                            } else {
                                i10 = i10;
                            }
                            break;
                        } else {
                            j11 = c0030f.f77g;
                            if (j11 == 0) {
                                c0030f.f77g = jUptimeMillis;
                                c0030f.m146a(c0030f.f72b);
                                i10 = i10;
                            } else {
                                j12 = jUptimeMillis - j11;
                                c0030f.f77g = jUptimeMillis;
                                if (c0030f.f83m) {
                                    f4 = c0030f.f82l;
                                    if (f4 != Float.MAX_VALUE) {
                                        c0030f.f81k.f92i = f4;
                                        c0030f.f82l = Float.MAX_VALUE;
                                    }
                                    c0030f.f72b = (float) c0030f.f81k.f92i;
                                    c0030f.f71a = 0.0f;
                                    c0030f.f83m = z10;
                                    i10 = i10;
                                } else {
                                    if (c0030f.f82l != Float.MAX_VALUE) {
                                        C0031g c0031g4 = c0030f.f81k;
                                        double d10 = c0031g4.f92i;
                                        long j14 = j12 / 2;
                                        C0029e c0029eM148a4 = c0031g4.m148a(c0030f.f72b, c0030f.f71a, j14);
                                        C0031g c0031g5 = c0030f.f81k;
                                        c0031g5.f92i = c0030f.f82l;
                                        c0030f.f82l = Float.MAX_VALUE;
                                        C0029e c0029eM148a5 = c0031g5.m148a(c0029eM148a4.f63a, c0029eM148a4.f64b, j14);
                                        c0030f.f72b = c0029eM148a5.f63a;
                                        c0030f.f71a = c0029eM148a5.f64b;
                                        f = 0.0f;
                                    } else {
                                        f = 0.0f;
                                        C0029e c0029eM148a6 = c0030f.f81k.m148a(c0030f.f72b, c0030f.f71a, j12);
                                        c0030f.f72b = c0029eM148a6.f63a;
                                        c0030f.f71a = c0029eM148a6.f64b;
                                    }
                                    float fMax4 = Math.max(c0030f.f72b, -3.4028235E38f);
                                    c0030f.f72b = fMax4;
                                    float fMin4 = Math.min(fMax4, Float.MAX_VALUE);
                                    c0030f.f72b = fMin4;
                                    f3 = c0030f.f71a;
                                    c0031g = c0030f.f81k;
                                    c0031g.getClass();
                                    if (Math.abs(f3) < c0031g.f88e) {
                                    }
                                    z7 = false;
                                    float fMin5 = Math.min(c0030f.f72b, Float.MAX_VALUE);
                                    c0030f.f72b = fMin5;
                                    float fMax5 = Math.max(fMin5, -3.4028235E38f);
                                    c0030f.f72b = fMax5;
                                    c0030f.m146a(fMax5);
                                    if (z7) {
                                        c0030f.f76f = false;
                                        threadLocal = C0027c.f57f;
                                        if (threadLocal.get() == null) {
                                            threadLocal.set(new C0027c());
                                        }
                                        c0027c = (C0027c) threadLocal.get();
                                        c0027c.f58a.remove(c0030f);
                                        arrayList = c0027c.f59b;
                                        iIndexOf = arrayList.indexOf(c0030f);
                                        if (iIndexOf >= 0) {
                                            arrayList.set(iIndexOf, null);
                                            c0027c.f62e = true;
                                        }
                                        c0030f.f77g = 0L;
                                        c0030f.f73c = false;
                                        i6 = 0;
                                        while (true) {
                                            arrayList2 = c0030f.f79i;
                                            if (i6 < arrayList2.size()) {
                                                for (size = arrayList2.size() - 1; size >= 0; size--) {
                                                    if (arrayList2.get(size) == null) {
                                                        arrayList2.remove(size);
                                                    }
                                                }
                                            }
                                            if (arrayList2.get(i6) == null) {
                                                throw AbstractC0004e.m17k(i6, arrayList2);
                                            }
                                            i6++;
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                                z7 = true;
                                float fMin6 = Math.min(c0030f.f72b, Float.MAX_VALUE);
                                c0030f.f72b = fMin6;
                                float fMax6 = Math.max(fMin6, -3.4028235E38f);
                                c0030f.f72b = fMax6;
                                c0030f.m146a(fMax6);
                                if (z7) {
                                    c0030f.f76f = false;
                                    threadLocal = C0027c.f57f;
                                    if (threadLocal.get() == null) {
                                        threadLocal.set(new C0027c());
                                    }
                                    c0027c = (C0027c) threadLocal.get();
                                    c0027c.f58a.remove(c0030f);
                                    arrayList = c0027c.f59b;
                                    iIndexOf = arrayList.indexOf(c0030f);
                                    if (iIndexOf >= 0) {
                                        arrayList.set(iIndexOf, null);
                                        c0027c.f62e = true;
                                    }
                                    c0030f.f77g = 0L;
                                    c0030f.f73c = false;
                                    i6 = 0;
                                    while (true) {
                                        arrayList2 = c0030f.f79i;
                                        if (i6 < arrayList2.size()) {
                                            while (size >= 0) {
                                                if (arrayList2.get(size) == null) {
                                                    arrayList2.remove(size);
                                                }
                                            }
                                        }
                                        if (arrayList2.get(i6) == null) {
                                            throw AbstractC0004e.m17k(i6, arrayList2);
                                        }
                                        i6++;
                                    }
                                } else {
                                    continue;
                                }
                            }
                        }
                    } else {
                        i10 = i10;
                    }
                    i10++;
                    z10 = false;
                    break;
                }
                break;
            default:
                ((AbstractC4044e) this.f51b).f13696b.run();
                return;
        }
    }
}
