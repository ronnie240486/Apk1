package androidx.lifecycle;

import android.os.Looper;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p000a.AbstractC0004e;
import p055ea.AbstractC2460q;
import p103j9.AbstractC2796i;
import p117l.C2946a;
import p127m.C3019a;
import p127m.C3020b;
import p127m.C3021c;
import p127m.C3022d;
import p227v1.C3969a;
import p235v9.C4024b;

public final class C0559y extends AbstractC0541p {

    public final boolean f2551b = true;

    public C3019a f2552c = new C3019a();

    public EnumC0539o f2553d;

    public final WeakReference f2554e;

    public int f2555f;

    public boolean f2556g;

    public boolean f2557h;

    public final ArrayList f2558i;

    public final C4024b f2559j;

    public C0559y(InterfaceC0555w interfaceC0555w) {
        EnumC0539o enumC0539o = EnumC0539o.f2508b;
        this.f2553d = enumC0539o;
        this.f2558i = new ArrayList();
        this.f2554e = new WeakReference(interfaceC0555w);
        this.f2559j = new C4024b(enumC0539o);
    }

    @Override
    public final void mo1508a(InterfaceC0553v interfaceC0553v) {
        InterfaceC0551u c0523g;
        InterfaceC0555w interfaceC0555w;
        ArrayList arrayList = this.f2558i;
        Object obj = null;
        int i6 = 1;
        AbstractC2796i.m5785f(interfaceC0553v, "observer");
        m1520e("addObserver");
        EnumC0539o enumC0539o = this.f2553d;
        EnumC0539o enumC0539o2 = EnumC0539o.f2507a;
        if (enumC0539o != enumC0539o2) {
            enumC0539o2 = EnumC0539o.f2508b;
        }
        C0557x c0557x = new C0557x();
        HashMap map = AbstractC0561z.f2560a;
        boolean z7 = interfaceC0553v instanceof InterfaceC0551u;
        boolean z10 = interfaceC0553v instanceof InterfaceC0519e;
        if (z7 && z10) {
            c0523g = new C0523g((InterfaceC0519e) interfaceC0553v, (InterfaceC0551u) interfaceC0553v);
        } else if (z10) {
            c0523g = new C0523g((InterfaceC0519e) interfaceC0553v, (InterfaceC0551u) null);
        } else if (z7) {
            c0523g = (InterfaceC0551u) interfaceC0553v;
        } else {
            Class<?> cls = interfaceC0553v.getClass();
            if (AbstractC0561z.m1526b(cls) == 2) {
                Object obj2 = AbstractC0561z.f2561b.get(cls);
                AbstractC2796i.m5782c(obj2);
                List list = (List) obj2;
                if (list.size() == 1) {
                    AbstractC0561z.m1525a((Constructor) list.get(0), interfaceC0553v);
                    throw null;
                }
                int size = list.size();
                InterfaceC0527i[] interfaceC0527iArr = new InterfaceC0527i[size];
                if (size > 0) {
                    AbstractC0561z.m1525a((Constructor) list.get(0), interfaceC0553v);
                    throw null;
                }
                c0523g = new C3969a(i6, interfaceC0527iArr);
            } else {
                c0523g = new C0523g(interfaceC0553v);
            }
        }
        c0557x.f2548b = c0523g;
        c0557x.f2547a = enumC0539o2;
        C3019a c3019a = this.f2552c;
        C3021c c3021cMo6095c = c3019a.mo6095c(interfaceC0553v);
        if (c3021cMo6095c != null) {
            obj = c3021cMo6095c.f10344b;
        } else {
            HashMap map2 = c3019a.f10339e;
            C3021c c3021c = new C3021c(interfaceC0553v, c0557x);
            c3019a.f10353d++;
            C3021c c3021c2 = c3019a.f10351b;
            if (c3021c2 == null) {
                c3019a.f10350a = c3021c;
                c3019a.f10351b = c3021c;
            } else {
                c3021c2.f10345c = c3021c;
                c3021c.f10346d = c3021c2;
                c3019a.f10351b = c3021c;
            }
            map2.put(interfaceC0553v, c3021c);
        }
        if (((C0557x) obj) == null && (interfaceC0555w = (InterfaceC0555w) this.f2554e.get()) != null) {
            boolean z11 = this.f2555f != 0 || this.f2556g;
            EnumC0539o enumC0539oM1519d = m1519d(interfaceC0553v);
            this.f2555f++;
            while (c0557x.f2547a.compareTo(enumC0539oM1519d) < 0 && this.f2552c.f10339e.containsKey(interfaceC0553v)) {
                arrayList.add(c0557x.f2547a);
                C0533l c0533l = EnumC0537n.Companion;
                EnumC0539o enumC0539o3 = c0557x.f2547a;
                c0533l.getClass();
                EnumC0537n enumC0537nM1498a = C0533l.m1498a(enumC0539o3);
                if (enumC0537nM1498a == null) {
                    throw new IllegalStateException("no event up from " + c0557x.f2547a);
                }
                c0557x.m1517a(interfaceC0555w, enumC0537nM1498a);
                arrayList.remove(arrayList.size() - 1);
                enumC0539oM1519d = m1519d(interfaceC0553v);
            }
            if (!z11) {
                m1524i();
            }
            this.f2555f--;
        }
    }

    @Override
    public final EnumC0539o mo1509b() {
        return this.f2553d;
    }

    @Override
    public final void mo1510c(InterfaceC0553v interfaceC0553v) {
        AbstractC2796i.m5785f(interfaceC0553v, "observer");
        m1520e("removeObserver");
        this.f2552c.mo6096d(interfaceC0553v);
    }

    public final EnumC0539o m1519d(InterfaceC0553v interfaceC0553v) {
        C0557x c0557x;
        HashMap map = this.f2552c.f10339e;
        C3021c c3021c = map.containsKey(interfaceC0553v) ? ((C3021c) map.get(interfaceC0553v)).f10346d : null;
        EnumC0539o enumC0539o = (c3021c == null || (c0557x = (C0557x) c3021c.f10344b) == null) ? null : c0557x.f2547a;
        ArrayList arrayList = this.f2558i;
        EnumC0539o enumC0539o2 = arrayList.isEmpty() ? null : (EnumC0539o) AbstractC2460q.m5491e(1, arrayList);
        EnumC0539o enumC0539o3 = this.f2553d;
        AbstractC2796i.m5785f(enumC0539o3, "state1");
        if (enumC0539o == null || enumC0539o.compareTo(enumC0539o3) >= 0) {
            enumC0539o = enumC0539o3;
        }
        return (enumC0539o2 == null || enumC0539o2.compareTo(enumC0539o) >= 0) ? enumC0539o : enumC0539o2;
    }

    public final void m1520e(String str) {
        if (this.f2551b) {
            C2946a.m5967V().f10115r.getClass();
            if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                throw new IllegalStateException(AbstractC0004e.m24r("Method ", str, " must be called on the main thread").toString());
            }
        }
    }

    public final void m1521f(EnumC0537n enumC0537n) {
        AbstractC2796i.m5785f(enumC0537n, "event");
        m1520e("handleLifecycleEvent");
        m1522g(enumC0537n.m1501a());
    }

    public final void m1522g(EnumC0539o enumC0539o) {
        EnumC0539o enumC0539o2 = this.f2553d;
        if (enumC0539o2 == enumC0539o) {
            return;
        }
        EnumC0539o enumC0539o3 = EnumC0539o.f2508b;
        EnumC0539o enumC0539o4 = EnumC0539o.f2507a;
        if (enumC0539o2 == enumC0539o3 && enumC0539o == enumC0539o4) {
            throw new IllegalStateException(("no event down from " + this.f2553d + " in component " + this.f2554e.get()).toString());
        }
        this.f2553d = enumC0539o;
        if (this.f2556g || this.f2555f != 0) {
            this.f2557h = true;
            return;
        }
        this.f2556g = true;
        m1524i();
        this.f2556g = false;
        if (this.f2553d == enumC0539o4) {
            this.f2552c = new C3019a();
        }
    }

    public final void m1523h() {
        EnumC0539o enumC0539o = EnumC0539o.f2509c;
        m1520e("setCurrentState");
        m1522g(enumC0539o);
    }

    public final void m1524i() {
        EnumC0537n enumC0537n;
        InterfaceC0555w interfaceC0555w = (InterfaceC0555w) this.f2554e.get();
        if (interfaceC0555w == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
        }
        while (true) {
            C3019a c3019a = this.f2552c;
            if (c3019a.f10353d != 0) {
                C3021c c3021c = c3019a.f10350a;
                AbstractC2796i.m5782c(c3021c);
                EnumC0539o enumC0539o = ((C0557x) c3021c.f10344b).f2547a;
                C3021c c3021c2 = this.f2552c.f10351b;
                AbstractC2796i.m5782c(c3021c2);
                EnumC0539o enumC0539o2 = ((C0557x) c3021c2.f10344b).f2547a;
                if (enumC0539o == enumC0539o2 && this.f2553d == enumC0539o2) {
                    break;
                }
                this.f2557h = false;
                EnumC0539o enumC0539o3 = this.f2553d;
                C3021c c3021c3 = this.f2552c.f10350a;
                AbstractC2796i.m5782c(c3021c3);
                if (enumC0539o3.compareTo(((C0557x) c3021c3.f10344b).f2547a) < 0) {
                    C3019a c3019a2 = this.f2552c;
                    C3020b c3020b = new C3020b(c3019a2.f10351b, c3019a2.f10350a, 1);
                    c3019a2.f10352c.put(c3020b, Boolean.FALSE);
                    while (c3020b.hasNext() && !this.f2557h) {
                        Map.Entry entry = (Map.Entry) c3020b.next();
                        AbstractC2796i.m5784e(entry, "next()");
                        InterfaceC0553v interfaceC0553v = (InterfaceC0553v) entry.getKey();
                        C0557x c0557x = (C0557x) entry.getValue();
                        while (c0557x.f2547a.compareTo(this.f2553d) > 0 && !this.f2557h && this.f2552c.f10339e.containsKey(interfaceC0553v)) {
                            C0533l c0533l = EnumC0537n.Companion;
                            EnumC0539o enumC0539o4 = c0557x.f2547a;
                            c0533l.getClass();
                            AbstractC2796i.m5785f(enumC0539o4, "state");
                            int iOrdinal = enumC0539o4.ordinal();
                            if (iOrdinal == 2) {
                                enumC0537n = EnumC0537n.ON_DESTROY;
                            } else if (iOrdinal != 3) {
                                enumC0537n = iOrdinal != 4 ? null : EnumC0537n.ON_PAUSE;
                            } else {
                                enumC0537n = EnumC0537n.ON_STOP;
                            }
                            if (enumC0537n == null) {
                                throw new IllegalStateException("no event down from " + c0557x.f2547a);
                            }
                            this.f2558i.add(enumC0537n.m1501a());
                            c0557x.m1517a(interfaceC0555w, enumC0537n);
                            ArrayList arrayList = this.f2558i;
                            arrayList.remove(arrayList.size() - 1);
                        }
                    }
                }
                C3021c c3021c4 = this.f2552c.f10351b;
                if (!this.f2557h && c3021c4 != null && this.f2553d.compareTo(((C0557x) c3021c4.f10344b).f2547a) > 0) {
                    C3019a c3019a3 = this.f2552c;
                    c3019a3.getClass();
                    C3022d c3022d = new C3022d(c3019a3);
                    c3019a3.f10352c.put(c3022d, Boolean.FALSE);
                    while (c3022d.hasNext() && !this.f2557h) {
                        Map.Entry entry2 = (Map.Entry) c3022d.next();
                        InterfaceC0553v interfaceC0553v2 = (InterfaceC0553v) entry2.getKey();
                        C0557x c0557x2 = (C0557x) entry2.getValue();
                        while (c0557x2.f2547a.compareTo(this.f2553d) < 0 && !this.f2557h && this.f2552c.f10339e.containsKey(interfaceC0553v2)) {
                            this.f2558i.add(c0557x2.f2547a);
                            C0533l c0533l2 = EnumC0537n.Companion;
                            EnumC0539o enumC0539o5 = c0557x2.f2547a;
                            c0533l2.getClass();
                            EnumC0537n enumC0537nM1498a = C0533l.m1498a(enumC0539o5);
                            if (enumC0537nM1498a == null) {
                                throw new IllegalStateException("no event up from " + c0557x2.f2547a);
                            }
                            c0557x2.m1517a(interfaceC0555w, enumC0537nM1498a);
                            ArrayList arrayList2 = this.f2558i;
                            arrayList2.remove(arrayList2.size() - 1);
                        }
                    }
                }
            } else {
                break;
            }
        }
        this.f2557h = false;
        this.f2559j.m8012a(this.f2553d);
    }
}
