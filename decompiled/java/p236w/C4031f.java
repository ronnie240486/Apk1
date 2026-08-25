package p236w;

import androidx.constraintlayout.widget.C0306b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import p055ea.AbstractC2460q;
import p225v.C3956c;
import p225v.C3958e;
import p225v.C3959f;
import p225v.C3962i;
import p225v.C3963j;
import p225v.EnumC3957d;

public final class C4031f {

    public C3959f f13655a;

    public boolean f13656b;

    public boolean f13657c;

    public C3959f f13658d;

    public ArrayList f13659e;

    public InterfaceC4028c f13660f;

    public C4027b f13661g;

    public ArrayList f13662h;

    public final void m8021a(C4032g c4032g, int i6, ArrayList arrayList, C4037l c4037l) {
        AbstractC4039n abstractC4039n = c4032g.f13666d;
        if (abstractC4039n.f13683c == null) {
            C3959f c3959f = this.f13655a;
            if (abstractC4039n == c3959f.f13356d || abstractC4039n == c3959f.f13358e) {
                return;
            }
            if (c4037l == null) {
                c4037l = new C4037l();
                c4037l.f13677a = null;
                c4037l.f13678b = new ArrayList();
                c4037l.f13677a = abstractC4039n;
                arrayList.add(c4037l);
            }
            abstractC4039n.f13683c = c4037l;
            c4037l.f13678b.add(abstractC4039n);
            C4032g c4032g2 = abstractC4039n.f13688h;
            for (InterfaceC4030e interfaceC4030e : c4032g2.f13673k) {
                if (interfaceC4030e instanceof C4032g) {
                    m8021a((C4032g) interfaceC4030e, i6, arrayList, c4037l);
                }
            }
            C4032g c4032g3 = abstractC4039n.f13689i;
            for (InterfaceC4030e interfaceC4030e2 : c4032g3.f13673k) {
                if (interfaceC4030e2 instanceof C4032g) {
                    m8021a((C4032g) interfaceC4030e2, i6, arrayList, c4037l);
                }
            }
            if (i6 == 1 && (abstractC4039n instanceof C4038m)) {
                for (InterfaceC4030e interfaceC4030e3 : ((C4038m) abstractC4039n).f13679k.f13673k) {
                    if (interfaceC4030e3 instanceof C4032g) {
                        m8021a((C4032g) interfaceC4030e3, i6, arrayList, c4037l);
                    }
                }
            }
            Iterator it = c4032g2.f13674l.iterator();
            while (it.hasNext()) {
                m8021a((C4032g) it.next(), i6, arrayList, c4037l);
            }
            Iterator it2 = c4032g3.f13674l.iterator();
            while (it2.hasNext()) {
                m8021a((C4032g) it2.next(), i6, arrayList, c4037l);
            }
            if (i6 == 1 && (abstractC4039n instanceof C4038m)) {
                Iterator it3 = ((C4038m) abstractC4039n).f13679k.f13674l.iterator();
                while (it3.hasNext()) {
                    m8021a((C4032g) it3.next(), i6, arrayList, c4037l);
                }
            }
        }
    }

    public final void m8022b(C3959f c3959f) {
        int iM7902j;
        EnumC3957d enumC3957d;
        C4038m c4038m;
        C4036k c4036k;
        EnumC3957d[] enumC3957dArr;
        EnumC3957d enumC3957d2;
        EnumC3957d enumC3957d3;
        Iterator it = c3959f.f13382g0.iterator();
        while (it.hasNext()) {
            C3958e c3958e = (C3958e) it.next();
            EnumC3957d[] enumC3957dArr2 = c3958e.f13333J;
            EnumC3957d enumC3957d4 = enumC3957dArr2[0];
            EnumC3957d enumC3957d5 = enumC3957dArr2[1];
            if (c3958e.f13347X == 8) {
                c3958e.f13350a = true;
            } else {
                float f = c3958e.f13370o;
                EnumC3957d enumC3957d6 = EnumC3957d.f13321c;
                if (f < 1.0f && enumC3957d4 == enumC3957d6) {
                    c3958e.f13365j = 2;
                }
                float f3 = c3958e.f13373r;
                if (f3 < 1.0f && enumC3957d5 == enumC3957d6) {
                    c3958e.f13366k = 2;
                }
                float f4 = c3958e.f13337N;
                EnumC3957d enumC3957d7 = EnumC3957d.f13320b;
                EnumC3957d enumC3957d8 = EnumC3957d.f13319a;
                if (f4 > 0.0f) {
                    if (enumC3957d4 == enumC3957d6 && (enumC3957d5 == enumC3957d7 || enumC3957d5 == enumC3957d8)) {
                        c3958e.f13365j = 3;
                    } else if (enumC3957d5 == enumC3957d6 && (enumC3957d4 == enumC3957d7 || enumC3957d4 == enumC3957d8)) {
                        c3958e.f13366k = 3;
                    } else if (enumC3957d4 == enumC3957d6 && enumC3957d5 == enumC3957d6) {
                        if (c3958e.f13365j == 0) {
                            c3958e.f13365j = 3;
                        }
                        if (c3958e.f13366k == 0) {
                            c3958e.f13366k = 3;
                        }
                    }
                }
                C3956c c3956c = c3958e.f13324A;
                C3956c c3956c2 = c3958e.f13380y;
                if (enumC3957d4 == enumC3957d6 && c3958e.f13365j == 1 && (c3956c2.f13315d == null || c3956c.f13315d == null)) {
                    enumC3957d4 = enumC3957d7;
                }
                C3956c c3956c3 = c3958e.f13325B;
                C3956c c3956c4 = c3958e.f13381z;
                EnumC3957d enumC3957d9 = (enumC3957d5 == enumC3957d6 && c3958e.f13366k == 1 && (c3956c4.f13315d == null || c3956c3.f13315d == null)) ? enumC3957d7 : enumC3957d5;
                C4036k c4036k2 = c3958e.f13356d;
                c4036k2.f13684d = enumC3957d4;
                int i6 = c3958e.f13365j;
                c4036k2.f13681a = i6;
                C4038m c4038m2 = c3958e.f13358e;
                c4038m2.f13684d = enumC3957d9;
                Iterator it2 = it;
                int i10 = c3958e.f13366k;
                c4038m2.f13681a = i10;
                EnumC3957d enumC3957d10 = EnumC3957d.f13322d;
                if ((enumC3957d4 == enumC3957d10 || enumC3957d4 == enumC3957d8 || enumC3957d4 == enumC3957d7) && (enumC3957d9 == enumC3957d10 || enumC3957d9 == enumC3957d8 || enumC3957d9 == enumC3957d7)) {
                    int iM7905m = c3958e.m7905m();
                    if (enumC3957d4 == enumC3957d10) {
                        iM7905m = (c3959f.m7905m() - c3956c2.f13316e) - c3956c.f13316e;
                        enumC3957d4 = enumC3957d8;
                    }
                    int iM7902j2 = c3958e.m7902j();
                    if (enumC3957d9 == enumC3957d10) {
                        iM7902j = (c3959f.m7902j() - c3956c4.f13316e) - c3956c3.f13316e;
                        enumC3957d = enumC3957d8;
                    } else {
                        iM7902j = iM7902j2;
                        enumC3957d = enumC3957d9;
                    }
                    m8026f(c3958e, enumC3957d4, iM7905m, enumC3957d, iM7902j);
                    c4036k2.f13685e.mo8030d(c3958e.m7905m());
                    c4038m2.f13685e.mo8030d(c3958e.m7902j());
                    c3958e.f13350a = true;
                } else {
                    C3956c[] c3956cArr = c3958e.f13330G;
                    if (enumC3957d4 != enumC3957d6 || (enumC3957d9 != enumC3957d7 && enumC3957d9 != enumC3957d8)) {
                        c4038m = c4038m2;
                        c4036k = c4036k2;
                    } else if (i6 == 3) {
                        if (enumC3957d9 == enumC3957d7) {
                            m8026f(c3958e, enumC3957d7, 0, enumC3957d7, 0);
                        }
                        int iM7902j3 = c3958e.m7902j();
                        m8026f(c3958e, enumC3957d8, (int) ((iM7902j3 * c3958e.f13337N) + 0.5f), enumC3957d8, iM7902j3);
                        c4036k2.f13685e.mo8030d(c3958e.m7905m());
                        c4038m2.f13685e.mo8030d(c3958e.m7902j());
                        c3958e.f13350a = true;
                    } else {
                        c4036k = c4036k2;
                        if (i6 == 1) {
                            m8026f(c3958e, enumC3957d7, 0, enumC3957d9, 0);
                            c4036k.f13685e.f13675m = c3958e.m7905m();
                        } else if (i6 == 2) {
                            EnumC3957d enumC3957d11 = c3959f.f13333J[0];
                            if (enumC3957d11 == enumC3957d8 || enumC3957d11 == enumC3957d10) {
                                m8026f(c3958e, enumC3957d8, (int) ((f * c3959f.m7905m()) + 0.5f), enumC3957d9, c3958e.m7902j());
                                c4036k.f13685e.mo8030d(c3958e.m7905m());
                                c4038m2.f13685e.mo8030d(c3958e.m7902j());
                                c3958e.f13350a = true;
                            } else {
                                c4038m = c4038m2;
                            }
                        } else if (c3956cArr[0].f13315d == null || c3956cArr[1].f13315d == null) {
                            m8026f(c3958e, enumC3957d7, 0, enumC3957d9, 0);
                            c4036k.f13685e.mo8030d(c3958e.m7905m());
                            c4038m2.f13685e.mo8030d(c3958e.m7902j());
                            c3958e.f13350a = true;
                        } else {
                            c4038m = c4038m2;
                        }
                    }
                    if (enumC3957d9 == enumC3957d6 && (enumC3957d4 == enumC3957d7 || enumC3957d4 == enumC3957d8)) {
                        if (i10 == 3) {
                            if (enumC3957d4 == enumC3957d7) {
                                m8026f(c3958e, enumC3957d7, 0, enumC3957d7, 0);
                            }
                            int iM7905m2 = c3958e.m7905m();
                            float f5 = c3958e.f13337N;
                            if (c3958e.f13338O == -1) {
                                f5 = 1.0f / f5;
                            }
                            m8026f(c3958e, enumC3957d8, iM7905m2, enumC3957d8, (int) ((iM7905m2 * f5) + 0.5f));
                            c4036k.f13685e.mo8030d(c3958e.m7905m());
                            c4038m.f13685e.mo8030d(c3958e.m7902j());
                            c3958e.f13350a = true;
                        } else if (i10 == 1) {
                            m8026f(c3958e, enumC3957d4, 0, enumC3957d7, 0);
                            c4038m.f13685e.f13675m = c3958e.m7902j();
                        } else if (i10 == 2) {
                            EnumC3957d enumC3957d12 = c3959f.f13333J[1];
                            if (enumC3957d12 == enumC3957d8 || enumC3957d12 == enumC3957d10) {
                                m8026f(c3958e, enumC3957d4, c3958e.m7905m(), enumC3957d8, (int) ((f3 * c3959f.m7902j()) + 0.5f));
                                c4036k.f13685e.mo8030d(c3958e.m7905m());
                                c4038m.f13685e.mo8030d(c3958e.m7902j());
                                c3958e.f13350a = true;
                            } else if (enumC3957d4 == enumC3957d6) {
                                if (i6 != 1) {
                                    m8026f(c3958e, enumC3957d7, 0, enumC3957d7, 0);
                                    c4036k.f13685e.f13675m = c3958e.m7905m();
                                    c4038m.f13685e.f13675m = c3958e.m7902j();
                                } else {
                                    m8026f(c3958e, enumC3957d7, 0, enumC3957d7, 0);
                                    c4036k.f13685e.f13675m = c3958e.m7905m();
                                    c4038m.f13685e.f13675m = c3958e.m7902j();
                                }
                            }
                        } else if (c3956cArr[2].f13315d == null || c3956cArr[3].f13315d == null) {
                            m8026f(c3958e, enumC3957d7, 0, enumC3957d9, 0);
                            c4036k.f13685e.mo8030d(c3958e.m7905m());
                            c4038m.f13685e.mo8030d(c3958e.m7902j());
                            c3958e.f13350a = true;
                        } else if (enumC3957d4 == enumC3957d6) {
                            if (i6 != 1) {
                                m8026f(c3958e, enumC3957d7, 0, enumC3957d7, 0);
                                c4036k.f13685e.f13675m = c3958e.m7905m();
                                c4038m.f13685e.f13675m = c3958e.m7902j();
                            } else {
                                m8026f(c3958e, enumC3957d7, 0, enumC3957d7, 0);
                                c4036k.f13685e.f13675m = c3958e.m7905m();
                                c4038m.f13685e.f13675m = c3958e.m7902j();
                            }
                        }
                    } else if (enumC3957d4 == enumC3957d6 && enumC3957d9 == enumC3957d6) {
                        if (i6 != 1 || i10 == 1) {
                            m8026f(c3958e, enumC3957d7, 0, enumC3957d7, 0);
                            c4036k.f13685e.f13675m = c3958e.m7905m();
                            c4038m.f13685e.f13675m = c3958e.m7902j();
                        } else if (i10 == 2 && i6 == 2 && (((enumC3957d2 = (enumC3957dArr = c3959f.f13333J)[0]) == enumC3957d8 || enumC3957d2 == enumC3957d8) && ((enumC3957d3 = enumC3957dArr[1]) == enumC3957d8 || enumC3957d3 == enumC3957d8))) {
                            m8026f(c3958e, enumC3957d8, (int) ((f * c3959f.m7905m()) + 0.5f), enumC3957d8, (int) ((f3 * c3959f.m7902j()) + 0.5f));
                            c4036k.f13685e.mo8030d(c3958e.m7905m());
                            c4038m.f13685e.mo8030d(c3958e.m7902j());
                            c3958e.f13350a = true;
                        }
                    }
                }
                it = it2;
            }
        }
    }

    public final void m8023c() {
        ArrayList<AbstractC4039n> arrayList = this.f13659e;
        arrayList.clear();
        C3959f c3959f = this.f13658d;
        c3959f.f13356d.mo8016f();
        C4038m c4038m = c3959f.f13358e;
        c4038m.mo8016f();
        arrayList.add(c3959f.f13356d);
        arrayList.add(c4038m);
        HashSet hashSet = null;
        for (C3958e c3958e : c3959f.f13382g0) {
            if (c3958e instanceof C3962i) {
                C4034i c4034i = new C4034i(c3958e);
                c3958e.f13356d.mo8016f();
                c3958e.f13358e.mo8016f();
                c4034i.f13686f = ((C3962i) c3958e).f13455k0;
                arrayList.add(c4034i);
            } else {
                if (c3958e.m7910r()) {
                    if (c3958e.f13352b == null) {
                        c3958e.f13352b = new C4029d(c3958e, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(c3958e.f13352b);
                } else {
                    arrayList.add(c3958e.f13356d);
                }
                if (c3958e.m7911s()) {
                    if (c3958e.f13354c == null) {
                        c3958e.f13354c = new C4029d(c3958e, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(c3958e.f13354c);
                } else {
                    arrayList.add(c3958e.f13358e);
                }
                if (c3958e instanceof C3963j) {
                    arrayList.add(new C4035j(c3958e));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((AbstractC4039n) it.next()).mo8016f();
        }
        for (AbstractC4039n abstractC4039n : arrayList) {
            if (abstractC4039n.f13682b != c3959f) {
                abstractC4039n.mo8014d();
            }
        }
        ArrayList arrayList2 = this.f13662h;
        arrayList2.clear();
        C3959f c3959f2 = this.f13655a;
        m8025e(c3959f2.f13356d, 0, arrayList2);
        m8025e(c3959f2.f13358e, 1, arrayList2);
        this.f13656b = false;
    }

    public final int m8024d(C3959f c3959f, int i6) {
        ArrayList arrayList;
        int i10;
        int i11;
        long jMo8017j;
        float f;
        long j10;
        ArrayList arrayList2 = this.f13662h;
        int size = arrayList2.size();
        int i12 = 0;
        long jMax = 0;
        while (i12 < size) {
            AbstractC4039n abstractC4039n = ((C4037l) arrayList2.get(i12)).f13677a;
            if (!(abstractC4039n instanceof C4029d) ? !(i6 != 0 ? (abstractC4039n instanceof C4038m) : (abstractC4039n instanceof C4036k)) : ((C4029d) abstractC4039n).f13686f != i6) {
                C4032g c4032g = (i6 == 0 ? c3959f.f13356d : c3959f.f13358e).f13688h;
                C4032g c4032g2 = (i6 == 0 ? c3959f.f13356d : c3959f.f13358e).f13689i;
                boolean zContains = abstractC4039n.f13688h.f13674l.contains(c4032g);
                C4032g c4032g3 = abstractC4039n.f13689i;
                boolean zContains2 = c4032g3.f13674l.contains(c4032g2);
                long jMo8017j2 = abstractC4039n.mo8017j();
                C4032g c4032g4 = abstractC4039n.f13688h;
                if (zContains && zContains2) {
                    long jM8036b = C4037l.m8036b(c4032g4, 0L);
                    ArrayList arrayList3 = arrayList2;
                    i10 = size;
                    long jM8035a = C4037l.m8035a(c4032g3, 0L);
                    long j11 = jM8036b - jMo8017j2;
                    int i13 = c4032g3.f13668f;
                    arrayList = arrayList3;
                    i11 = i12;
                    if (j11 >= (-i13)) {
                        j11 += (long) i13;
                    }
                    long j12 = (-jM8035a) - jMo8017j2;
                    long j13 = c4032g4.f13668f;
                    long j14 = j12 - j13;
                    if (j14 >= j13) {
                        j14 -= j13;
                    }
                    C3958e c3958e = abstractC4039n.f13682b;
                    if (i6 == 0) {
                        f = c3958e.f13344U;
                    } else if (i6 == 1) {
                        f = c3958e.f13345V;
                    } else {
                        c3958e.getClass();
                        f = -1.0f;
                    }
                    if (f > 0.0f) {
                        j10 = (long) ((j11 / (1.0f - f)) + (j14 / f));
                    } else {
                        j10 = 0;
                    }
                    float f3 = j10;
                    jMo8017j = (((long) c4032g4.f13668f) + ((((long) ((f3 * f) + 0.5f)) + jMo8017j2) + ((long) AbstractC2460q.m5490d(1.0f, f, f3, 0.5f)))) - ((long) c4032g3.f13668f);
                } else {
                    arrayList = arrayList2;
                    i10 = size;
                    i11 = i12;
                    if (zContains) {
                        jMo8017j = Math.max(C4037l.m8036b(c4032g4, c4032g4.f13668f), ((long) c4032g4.f13668f) + jMo8017j2);
                    } else if (zContains2) {
                        jMo8017j = Math.max(-C4037l.m8035a(c4032g3, c4032g3.f13668f), ((long) (-c4032g3.f13668f)) + jMo8017j2);
                    } else {
                        jMo8017j = (abstractC4039n.mo8017j() + ((long) c4032g4.f13668f)) - ((long) c4032g3.f13668f);
                    }
                }
            } else {
                arrayList = arrayList2;
                i10 = size;
                i11 = i12;
                jMo8017j = 0;
            }
            jMax = Math.max(jMax, jMo8017j);
            i12 = i11 + 1;
            size = i10;
            arrayList2 = arrayList;
        }
        return (int) jMax;
    }

    public final void m8025e(AbstractC4039n abstractC4039n, int i6, ArrayList arrayList) {
        C4032g c4032g;
        Iterator it = abstractC4039n.f13688h.f13673k.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            c4032g = abstractC4039n.f13689i;
            if (!zHasNext) {
                break;
            }
            InterfaceC4030e interfaceC4030e = (InterfaceC4030e) it.next();
            if (interfaceC4030e instanceof C4032g) {
                m8021a((C4032g) interfaceC4030e, i6, arrayList, null);
            } else if (interfaceC4030e instanceof AbstractC4039n) {
                m8021a(((AbstractC4039n) interfaceC4030e).f13688h, i6, arrayList, null);
            }
        }
        for (InterfaceC4030e interfaceC4030e2 : c4032g.f13673k) {
            if (interfaceC4030e2 instanceof C4032g) {
                m8021a((C4032g) interfaceC4030e2, i6, arrayList, null);
            } else if (interfaceC4030e2 instanceof AbstractC4039n) {
                m8021a(((AbstractC4039n) interfaceC4030e2).f13689i, i6, arrayList, null);
            }
        }
        if (i6 == 1) {
            for (InterfaceC4030e interfaceC4030e3 : ((C4038m) abstractC4039n).f13679k.f13673k) {
                if (interfaceC4030e3 instanceof C4032g) {
                    m8021a((C4032g) interfaceC4030e3, i6, arrayList, null);
                }
            }
        }
    }

    public final void m8026f(C3958e c3958e, EnumC3957d enumC3957d, int i6, EnumC3957d enumC3957d2, int i10) {
        C4027b c4027b = this.f13661g;
        c4027b.f13643a = enumC3957d;
        c4027b.f13644b = enumC3957d2;
        c4027b.f13645c = i6;
        c4027b.f13646d = i10;
        ((C0306b) this.f13660f).m886a(c3958e, c4027b);
        c3958e.m7918z(c4027b.f13647e);
        c3958e.m7915w(c4027b.f13648f);
        c3958e.f13378w = c4027b.f13650h;
        int i11 = c4027b.f13649g;
        c3958e.f13341R = i11;
        c3958e.f13378w = i11 > 0;
    }

    public final void m8027g() {
        C4026a c4026a;
        for (C3958e c3958e : this.f13655a.f13382g0) {
            if (!c3958e.f13350a) {
                EnumC3957d[] enumC3957dArr = c3958e.f13333J;
                boolean z7 = false;
                EnumC3957d enumC3957d = enumC3957dArr[0];
                EnumC3957d enumC3957d2 = enumC3957dArr[1];
                int i6 = c3958e.f13365j;
                int i10 = c3958e.f13366k;
                EnumC3957d enumC3957d3 = EnumC3957d.f13320b;
                EnumC3957d enumC3957d4 = EnumC3957d.f13321c;
                boolean z10 = enumC3957d == enumC3957d3 || (enumC3957d == enumC3957d4 && i6 == 1);
                if (enumC3957d2 == enumC3957d3 || (enumC3957d2 == enumC3957d4 && i10 == 1)) {
                    z7 = true;
                }
                C4036k c4036k = c3958e.f13356d;
                C4033h c4033h = c4036k.f13685e;
                boolean z11 = c4033h.f13672j;
                C4038m c4038m = c3958e.f13358e;
                C4033h c4033h2 = c4038m.f13685e;
                boolean z12 = c4033h2.f13672j;
                EnumC3957d enumC3957d5 = EnumC3957d.f13319a;
                if (z11 && z12) {
                    m8026f(c3958e, enumC3957d5, c4033h.f13669g, enumC3957d5, c4033h2.f13669g);
                    c3958e.f13350a = true;
                } else if (z11 && z7) {
                    m8026f(c3958e, enumC3957d5, c4033h.f13669g, enumC3957d3, c4033h2.f13669g);
                    if (enumC3957d2 == enumC3957d4) {
                        c4038m.f13685e.f13675m = c3958e.m7902j();
                    } else {
                        c4038m.f13685e.mo8030d(c3958e.m7902j());
                        c3958e.f13350a = true;
                    }
                } else if (z12 && z10) {
                    m8026f(c3958e, enumC3957d3, c4033h.f13669g, enumC3957d5, c4033h2.f13669g);
                    if (enumC3957d == enumC3957d4) {
                        c4036k.f13685e.f13675m = c3958e.m7905m();
                    } else {
                        c4036k.f13685e.mo8030d(c3958e.m7905m());
                        c3958e.f13350a = true;
                    }
                }
                if (c3958e.f13350a && (c4026a = c4038m.f13680l) != null) {
                    c4026a.mo8030d(c3958e.f13341R);
                }
            }
        }
    }
}
