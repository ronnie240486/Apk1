package p125l7;

import java.io.EOFException;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import p124l6.C2982h;
import p144n7.AbstractC3206d;
import p144n7.C3208f;
import p154o7.AbstractC3275p;
import p154o7.C3261b;
import p154o7.C3262c;
import p154o7.C3263d;
import p154o7.C3266g;
import p154o7.C3267h;
import p154o7.C3270k;
import p154o7.C3272m;
import p154o7.C3273n;
import p190r7.AbstractC3641b;
import p202s7.C3723a;
import p212t7.C3812a;
import p212t7.C3813b;
import p212t7.C3814c;

public final class C3004k {

    public final ThreadLocal f10295a;

    public final ConcurrentHashMap f10296b;

    public final C2982h f10297c;

    public final C3262c f10298d;

    public final List f10299e;

    public final boolean f10300f;

    static {
        new C3723a(Object.class);
    }

    public C3004k() {
        C3208f c3208f = C3208f.f10787c;
        Map mapEmptyMap = Collections.emptyMap();
        Collections.emptyList();
        Collections.emptyList();
        List listEmptyList = Collections.emptyList();
        this.f10295a = new ThreadLocal();
        this.f10296b = new ConcurrentHashMap();
        C2982h c2982h = new C2982h(mapEmptyMap);
        this.f10297c = c2982h;
        this.f10300f = true;
        ArrayList arrayList = new ArrayList();
        arrayList.add(AbstractC3275p.f10962y);
        arrayList.add(C3267h.f10910b);
        arrayList.add(c3208f);
        arrayList.addAll(listEmptyList);
        arrayList.add(AbstractC3275p.f10952o);
        arrayList.add(AbstractC3275p.f10944g);
        arrayList.add(AbstractC3275p.f10941d);
        arrayList.add(AbstractC3275p.f10942e);
        arrayList.add(AbstractC3275p.f10943f);
        C3266g c3266g = AbstractC3275p.f10948k;
        arrayList.add(new C3273n(Long.TYPE, Long.class, c3266g));
        arrayList.add(new C3273n(Double.TYPE, Double.class, new C3001h(0)));
        arrayList.add(new C3273n(Float.TYPE, Float.class, new C3001h(1)));
        arrayList.add(C3266g.f10908b);
        arrayList.add(AbstractC3275p.f10945h);
        arrayList.add(AbstractC3275p.f10946i);
        arrayList.add(new C3272m(AtomicLong.class, new C3002i(new C3002i(c3266g, 0), 2), 0));
        arrayList.add(new C3272m(AtomicLongArray.class, new C3002i(new C3002i(c3266g, 1), 2), 0));
        arrayList.add(AbstractC3275p.f10947j);
        arrayList.add(AbstractC3275p.f10949l);
        arrayList.add(AbstractC3275p.f10953p);
        arrayList.add(AbstractC3275p.f10954q);
        arrayList.add(new C3272m(BigDecimal.class, AbstractC3275p.f10950m, 0));
        arrayList.add(new C3272m(BigInteger.class, AbstractC3275p.f10951n, 0));
        arrayList.add(AbstractC3275p.f10955r);
        arrayList.add(AbstractC3275p.f10956s);
        arrayList.add(AbstractC3275p.f10958u);
        arrayList.add(AbstractC3275p.f10959v);
        arrayList.add(AbstractC3275p.f10961x);
        arrayList.add(AbstractC3275p.f10957t);
        arrayList.add(AbstractC3275p.f10939b);
        arrayList.add(C3263d.f10900b);
        arrayList.add(AbstractC3275p.f10960w);
        if (AbstractC3641b.f12232a) {
            arrayList.add(AbstractC3641b.f12234c);
            arrayList.add(AbstractC3641b.f12233b);
            arrayList.add(AbstractC3641b.f12235d);
        }
        arrayList.add(C3261b.f10894d);
        arrayList.add(AbstractC3275p.f10938a);
        arrayList.add(new C3262c(c2982h, 0));
        arrayList.add(new C3262c(c2982h, 2));
        C3262c c3262c = new C3262c(c2982h, 1);
        this.f10298d = c3262c;
        arrayList.add(c3262c);
        arrayList.add(AbstractC3275p.f10963z);
        arrayList.add(new C3270k(c2982h, c3208f, c3262c));
        this.f10299e = Collections.unmodifiableList(arrayList);
    }

    public static void m6079a(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    public final Object m6080b(String str) {
        Class cls = Map.class;
        Object objMo6077a = null;
        if (str != null) {
            C3812a c3812a = new C3812a(new StringReader(str));
            boolean z7 = true;
            c3812a.f12873b = true;
            try {
                try {
                    try {
                        c3812a.m7612u();
                        try {
                            objMo6077a = m6081c(new C3723a(cls)).mo6077a(c3812a);
                        } catch (EOFException e5) {
                            e = e5;
                            z7 = false;
                            if (!z7) {
                                throw new C3007n(e);
                            }
                        }
                    } catch (EOFException e10) {
                        e = e10;
                    }
                    c3812a.f12873b = false;
                    if (objMo6077a != null) {
                        try {
                            if (c3812a.m7612u() != 10) {
                                throw new C3007n("JSON document was not fully consumed.");
                            }
                        } catch (C3814c e11) {
                            throw new C3007n(e11);
                        } catch (IOException e12) {
                            throw new C3007n(e12);
                        }
                    }
                } catch (IOException e13) {
                    throw new C3007n(e13);
                } catch (AssertionError e14) {
                    AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.9): " + e14.getMessage());
                    assertionError.initCause(e14);
                    throw assertionError;
                } catch (IllegalStateException e15) {
                    throw new C3007n(e15);
                }
            } catch (Throwable th) {
                c3812a.f12873b = false;
                throw th;
            }
        }
        if (cls == Integer.TYPE) {
            cls = Integer.class;
        } else if (cls == Float.TYPE) {
            cls = Float.class;
        } else if (cls == Byte.TYPE) {
            cls = Byte.class;
        } else if (cls == Double.TYPE) {
            cls = Double.class;
        } else if (cls == Long.TYPE) {
            cls = Long.class;
        } else if (cls == Character.TYPE) {
            cls = Character.class;
        } else if (cls == Boolean.TYPE) {
            cls = Boolean.class;
        } else if (cls == Short.TYPE) {
            cls = Short.class;
        } else if (cls == Void.TYPE) {
            cls = Void.class;
        }
        return cls.cast(objMo6077a);
    }

    public final AbstractC3011r m6081c(C3723a c3723a) {
        boolean z7;
        ConcurrentHashMap concurrentHashMap = this.f10296b;
        AbstractC3011r abstractC3011r = (AbstractC3011r) concurrentHashMap.get(c3723a);
        if (abstractC3011r != null) {
            return abstractC3011r;
        }
        ThreadLocal threadLocal = this.f10295a;
        Map map = (Map) threadLocal.get();
        if (map == null) {
            map = new HashMap();
            threadLocal.set(map);
            z7 = true;
        } else {
            z7 = false;
        }
        C3003j c3003j = (C3003j) map.get(c3723a);
        if (c3003j != null) {
            return c3003j;
        }
        try {
            C3003j c3003j2 = new C3003j();
            map.put(c3723a, c3003j2);
            Iterator it = this.f10299e.iterator();
            while (it.hasNext()) {
                AbstractC3011r abstractC3011rMo6089a = ((InterfaceC3012s) it.next()).mo6089a(this, c3723a);
                if (abstractC3011rMo6089a != null) {
                    if (c3003j2.f10294a != null) {
                        throw new AssertionError();
                    }
                    c3003j2.f10294a = abstractC3011rMo6089a;
                    concurrentHashMap.put(c3723a, abstractC3011rMo6089a);
                    map.remove(c3723a);
                    if (z7) {
                        threadLocal.remove();
                    }
                    return abstractC3011rMo6089a;
                }
            }
            throw new IllegalArgumentException("GSON (2.8.9) cannot handle " + c3723a);
        } catch (Throwable th) {
            map.remove(c3723a);
            if (z7) {
                threadLocal.remove();
            }
            throw th;
        }
    }

    public final C3813b m6082d(Writer writer) {
        C3813b c3813b = new C3813b(writer);
        c3813b.f12896h = false;
        return c3813b;
    }

    public final String m6083e(Object obj) {
        if (obj == null) {
            StringWriter stringWriter = new StringWriter();
            try {
                m6085g(m6082d(stringWriter));
                return stringWriter.toString();
            } catch (IOException e5) {
                throw new C3007n(e5);
            }
        }
        Class cls = obj.getClass();
        StringWriter stringWriter2 = new StringWriter();
        try {
            m6084f(obj, cls, m6082d(stringWriter2));
            return stringWriter2.toString();
        } catch (IOException e10) {
            throw new C3007n(e10);
        }
    }

    public final void m6084f(Object obj, Class cls, C3813b c3813b) {
        AbstractC3011r abstractC3011rM6081c = m6081c(new C3723a(cls));
        boolean z7 = c3813b.f12893e;
        c3813b.f12893e = true;
        boolean z10 = c3813b.f12894f;
        c3813b.f12894f = this.f10300f;
        boolean z11 = c3813b.f12896h;
        c3813b.f12896h = false;
        try {
            try {
                try {
                    abstractC3011rM6081c.mo6078b(c3813b, obj);
                    c3813b.f12893e = z7;
                    c3813b.f12894f = z10;
                    c3813b.f12896h = z11;
                } catch (IOException e5) {
                    throw new C3007n(e5);
                }
            } catch (AssertionError e10) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.9): " + e10.getMessage());
                assertionError.initCause(e10);
                throw assertionError;
            }
        } catch (Throwable th) {
            c3813b.f12893e = z7;
            c3813b.f12894f = z10;
            c3813b.f12896h = z11;
            throw th;
        }
    }

    public final void m6085g(C3813b c3813b) {
        C3008o c3008o = C3008o.f10302a;
        boolean z7 = c3813b.f12893e;
        c3813b.f12893e = true;
        boolean z10 = c3813b.f12894f;
        c3813b.f12894f = this.f10300f;
        boolean z11 = c3813b.f12896h;
        c3813b.f12896h = false;
        try {
            try {
                AbstractC3206d.m6495l(c3008o, c3813b);
                c3813b.f12893e = z7;
                c3813b.f12894f = z10;
                c3813b.f12896h = z11;
            } catch (IOException e5) {
                throw new C3007n(e5);
            } catch (AssertionError e10) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.9): " + e10.getMessage());
                assertionError.initCause(e10);
                throw assertionError;
            }
        } catch (Throwable th) {
            c3813b.f12893e = z7;
            c3813b.f12894f = z10;
            c3813b.f12896h = z11;
            throw th;
        }
    }

    public final String toString() {
        return "{serializeNulls:false,factories:" + this.f10299e + ",instanceCreators:" + this.f10297c + "}";
    }
}
