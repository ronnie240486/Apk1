package p236w;

import java.util.ArrayList;
import java.util.Iterator;
import p055ea.AbstractC2460q;
import p225v.C3956c;
import p225v.C3958e;
import p225v.C3959f;
import p225v.EnumC3957d;

public final class C4029d extends AbstractC4039n {

    public final ArrayList f13653k;

    public int f13654l;

    public C4029d(C3958e c3958e, int i6) {
        C3958e c3958e2;
        super(c3958e);
        this.f13653k = new ArrayList();
        this.f13686f = i6;
        C3958e c3958e3 = this.f13682b;
        C3958e c3958eM7904l = c3958e3.m7904l(i6);
        while (true) {
            C3958e c3958e4 = c3958eM7904l;
            c3958e2 = c3958e3;
            c3958e3 = c3958e4;
            if (c3958e3 == null) {
                break;
            } else {
                c3958eM7904l = c3958e3.m7904l(this.f13686f);
            }
        }
        this.f13682b = c3958e2;
        int i10 = this.f13686f;
        AbstractC4039n abstractC4039n = i10 == 0 ? c3958e2.f13356d : i10 == 1 ? c3958e2.f13358e : null;
        ArrayList<AbstractC4039n> arrayList = this.f13653k;
        arrayList.add(abstractC4039n);
        C3958e c3958eM7903k = c3958e2.m7903k(this.f13686f);
        while (c3958eM7903k != null) {
            int i11 = this.f13686f;
            arrayList.add(i11 == 0 ? c3958eM7903k.f13356d : i11 == 1 ? c3958eM7903k.f13358e : null);
            c3958eM7903k = c3958eM7903k.m7903k(this.f13686f);
        }
        for (AbstractC4039n abstractC4039n2 : arrayList) {
            int i12 = this.f13686f;
            if (i12 == 0) {
                abstractC4039n2.f13682b.f13352b = this;
            } else if (i12 == 1) {
                abstractC4039n2.f13682b.f13354c = this;
            }
        }
        if (this.f13686f == 0 && ((C3959f) this.f13682b.f13334K).f13386k0 && arrayList.size() > 1) {
            this.f13682b = ((AbstractC4039n) AbstractC2460q.m5491e(1, arrayList)).f13682b;
        }
        this.f13654l = this.f13686f == 0 ? this.f13682b.f13349Z : this.f13682b.f13351a0;
    }

    @Override
    public final void mo8013a(InterfaceC4030e interfaceC4030e) {
        int i6;
        EnumC3957d enumC3957d;
        ArrayList arrayList;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        float f;
        boolean z7;
        EnumC3957d enumC3957d2;
        ArrayList arrayList2;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        EnumC3957d enumC3957d3;
        float f3;
        int i20;
        int i21;
        int i22;
        int i23;
        AbstractC4039n abstractC4039n;
        int i24;
        C4032g c4032g;
        C4032g c4032g2;
        C4033h c4033h;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        AbstractC4039n abstractC4039n2;
        int i30;
        C4032g c4032g3;
        C4032g c4032g4;
        int i31;
        C4033h c4033h2;
        int iMin;
        int i32;
        int i33;
        int i34;
        int i35;
        AbstractC4039n abstractC4039n3;
        int i36;
        C4032g c4032g5;
        C4032g c4032g6;
        C4033h c4033h3;
        int i37;
        EnumC3957d enumC3957d4;
        int i38;
        int i39;
        float f4;
        int i40;
        int i41;
        float f5;
        C4032g c4032g7 = this.f13688h;
        if (c4032g7.f13672j) {
            C4032g c4032g8 = this.f13689i;
            if (c4032g8.f13672j) {
                C3958e c3958e = this.f13682b.f13334K;
                boolean z10 = (c3958e == null || !(c3958e instanceof C3959f)) ? false : ((C3959f) c3958e).f13386k0;
                int i42 = c4032g8.f13669g - c4032g7.f13669g;
                ArrayList arrayList3 = this.f13653k;
                int size = arrayList3.size();
                int i43 = 0;
                while (true) {
                    i6 = -1;
                    if (i43 >= size) {
                        i43 = -1;
                        break;
                    } else if (((AbstractC4039n) arrayList3.get(i43)).f13682b.f13347X != 8) {
                        break;
                    } else {
                        i43++;
                    }
                }
                int i44 = size - 1;
                for (int i45 = i44; i45 >= 0; i45--) {
                    if (((AbstractC4039n) arrayList3.get(i45)).f13682b.f13347X != 8) {
                        i6 = i45;
                        break;
                    }
                }
                int i46 = 0;
                while (true) {
                    enumC3957d = EnumC3957d.f13321c;
                    if (i46 >= 2) {
                        arrayList = arrayList3;
                        i10 = size;
                        i11 = i43;
                        i12 = 0;
                        i13 = 0;
                        i14 = 0;
                        f = 0.0f;
                        break;
                    }
                    int i47 = 0;
                    i14 = 0;
                    int i48 = 0;
                    int i49 = 0;
                    f = 0.0f;
                    while (i47 < size) {
                        AbstractC4039n abstractC4039n4 = (AbstractC4039n) arrayList3.get(i47);
                        C3958e c3958e2 = abstractC4039n4.f13682b;
                        ArrayList arrayList4 = arrayList3;
                        int i50 = size;
                        if (c3958e2.f13347X == 8) {
                            i40 = i43;
                        } else {
                            i49++;
                            if (i47 > 0 && i47 >= i43) {
                                i14 += abstractC4039n4.f13688h.f13668f;
                            }
                            C4033h c4033h4 = abstractC4039n4.f13685e;
                            int i51 = c4033h4.f13669g;
                            boolean z11 = abstractC4039n4.f13684d != enumC3957d;
                            if (z11) {
                                int i52 = this.f13686f;
                                if (i52 == 0 && !c3958e2.f13356d.f13685e.f13672j) {
                                    return;
                                }
                                if (i52 == 1 && !c3958e2.f13358e.f13685e.f13672j) {
                                    return;
                                } else {
                                    i40 = i43;
                                }
                            } else {
                                i40 = i43;
                                if (abstractC4039n4.f13681a == 1 && i46 == 0) {
                                    i41 = c4033h4.f13675m;
                                    i48++;
                                } else {
                                    if (c4033h4.f13672j) {
                                        i41 = i51;
                                    }
                                    if (z11) {
                                        i14 += i41;
                                    } else {
                                        i48++;
                                        f5 = c3958e2.f13353b0[this.f13686f];
                                        if (f5 >= 0.0f) {
                                            f += f5;
                                        }
                                    }
                                    if (i47 >= i44 && i47 < i6) {
                                        i14 += -abstractC4039n4.f13689i.f13668f;
                                    }
                                }
                                z11 = true;
                                if (z11) {
                                    i48++;
                                    f5 = c3958e2.f13353b0[this.f13686f];
                                    if (f5 >= 0.0f) {
                                        f += f5;
                                    }
                                } else {
                                    i14 += i41;
                                }
                                if (i47 >= i44) {
                                }
                            }
                            i41 = i51;
                            if (z11) {
                                i48++;
                                f5 = c3958e2.f13353b0[this.f13686f];
                                if (f5 >= 0.0f) {
                                    f += f5;
                                }
                            } else {
                                i14 += i41;
                            }
                            if (i47 >= i44) {
                            }
                        }
                        i47++;
                        arrayList3 = arrayList4;
                        size = i50;
                        i43 = i40;
                    }
                    arrayList = arrayList3;
                    i10 = size;
                    i11 = i43;
                    if (i14 < i42 || i48 == 0) {
                        i12 = i48;
                        i13 = i49;
                        break;
                    } else {
                        i46++;
                        arrayList3 = arrayList;
                        size = i10;
                        i43 = i11;
                    }
                }
                int i53 = c4032g7.f13669g;
                if (z10) {
                    i53 = c4032g8.f13669g;
                }
                if (i14 > i42) {
                    i53 = z10 ? i53 + ((int) (((i14 - i42) / 2.0f) + 0.5f)) : i53 - ((int) (((i14 - i42) / 2.0f) + 0.5f));
                }
                if (i12 > 0) {
                    float f10 = i42 - i14;
                    int i54 = (int) ((f10 / i12) + 0.5f);
                    i15 = i10;
                    int i55 = 0;
                    int i56 = 0;
                    while (i55 < i15) {
                        ArrayList arrayList5 = arrayList;
                        int i57 = i54;
                        AbstractC4039n abstractC4039n5 = (AbstractC4039n) arrayList5.get(i55);
                        int i58 = i14;
                        C3958e c3958e3 = abstractC4039n5.f13682b;
                        int i59 = i53;
                        boolean z12 = z10;
                        if (c3958e3.f13347X != 8 && abstractC4039n5.f13684d == enumC3957d) {
                            C4033h c4033h5 = abstractC4039n5.f13685e;
                            if (c4033h5.f13672j) {
                                f4 = f10;
                                enumC3957d = enumC3957d;
                            } else {
                                int i60 = f > 0.0f ? (int) (((c3958e3.f13353b0[this.f13686f] * f10) / f) + 0.5f) : i57;
                                if (this.f13686f == 0) {
                                    int i61 = c3958e3.f13369n;
                                    f4 = f10;
                                    int iMax = Math.max(c3958e3.f13368m, abstractC4039n5.f13681a == 1 ? Math.min(i60, c4033h5.f13675m) : i60);
                                    if (i61 > 0) {
                                        iMax = Math.min(i61, iMax);
                                    }
                                    if (iMax != i60) {
                                        i56++;
                                        i60 = iMax;
                                    }
                                } else {
                                    f4 = f10;
                                    int i62 = c3958e3.f13372q;
                                    int iMax2 = Math.max(c3958e3.f13371p, abstractC4039n5.f13681a == 1 ? Math.min(i60, c4033h5.f13675m) : i60);
                                    if (i62 > 0) {
                                        iMax2 = Math.min(i62, iMax2);
                                    }
                                    if (iMax2 != i60) {
                                        i56++;
                                        i60 = iMax2;
                                    }
                                }
                                c4033h5.mo8030d(i60);
                            }
                        } else {
                            f4 = f10;
                            enumC3957d = enumC3957d;
                        }
                        i55++;
                        i14 = i58;
                        i54 = i57;
                        i53 = i59;
                        z10 = z12;
                        enumC3957d = enumC3957d;
                        f10 = f4;
                        arrayList = arrayList5;
                    }
                    i18 = i53;
                    z7 = z10;
                    enumC3957d2 = enumC3957d;
                    int i63 = i14;
                    arrayList2 = arrayList;
                    if (i56 > 0) {
                        i12 -= i56;
                        int i64 = 0;
                        i14 = 0;
                        while (i64 < i15) {
                            AbstractC4039n abstractC4039n6 = (AbstractC4039n) arrayList2.get(i64);
                            if (abstractC4039n6.f13682b.f13347X == 8) {
                                i39 = i11;
                            } else {
                                i39 = i11;
                                if (i64 > 0 && i64 >= i39) {
                                    i14 += abstractC4039n6.f13688h.f13668f;
                                }
                                i14 += abstractC4039n6.f13685e.f13669g;
                                if (i64 < i44 && i64 < i6) {
                                    i14 += -abstractC4039n6.f13689i.f13668f;
                                }
                            }
                            i64++;
                            i11 = i39;
                        }
                        i16 = i11;
                    } else {
                        i16 = i11;
                        i14 = i63;
                    }
                    i17 = 2;
                    if (this.f13654l == 2 && i56 == 0) {
                        this.f13654l = 0;
                    }
                    if (i14 > i42) {
                        this.f13654l = i17;
                    }
                    if (i13 > 0 && i12 == 0 && i16 == i6) {
                        this.f13654l = i17;
                    }
                    i19 = this.f13654l;
                    if (i19 == 1) {
                        if (i13 > 1) {
                            i32 = (i42 - i14) / (i13 - 1);
                        } else if (i13 == 1) {
                            i32 = (i42 - i14) / 2;
                        } else {
                            i32 = 0;
                        }
                        if (i12 > 0) {
                            i32 = 0;
                        }
                        i33 = i18;
                        i34 = 0;
                        while (i34 < i15) {
                            if (z7) {
                                i35 = i15 - (i34 + 1);
                            } else {
                                i35 = i34;
                            }
                            abstractC4039n3 = (AbstractC4039n) arrayList2.get(i35);
                            i36 = abstractC4039n3.f13682b.f13347X;
                            c4032g5 = abstractC4039n3.f13689i;
                            c4032g6 = abstractC4039n3.f13688h;
                            if (i36 == 8) {
                                c4032g6.mo8030d(i33);
                                c4032g5.mo8030d(i33);
                                i38 = i32;
                                enumC3957d4 = enumC3957d2;
                            } else {
                                if (i34 > 0) {
                                    if (z7) {
                                        i33 -= i32;
                                    } else {
                                        i33 += i32;
                                    }
                                }
                                if (i34 > 0 && i34 >= i16) {
                                    if (z7) {
                                        i33 -= c4032g6.f13668f;
                                    } else {
                                        i33 += c4032g6.f13668f;
                                    }
                                }
                                if (z7) {
                                    c4032g5.mo8030d(i33);
                                } else {
                                    c4032g6.mo8030d(i33);
                                }
                                c4033h3 = abstractC4039n3.f13685e;
                                i37 = c4033h3.f13669g;
                                enumC3957d4 = enumC3957d2;
                                if (abstractC4039n3.f13684d == enumC3957d4) {
                                    i38 = i32;
                                    if (abstractC4039n3.f13681a == 1) {
                                        i37 = c4033h3.f13675m;
                                    }
                                } else {
                                    i38 = i32;
                                }
                                if (z7) {
                                    i33 -= i37;
                                } else {
                                    i33 += i37;
                                }
                                if (z7) {
                                    c4032g6.mo8030d(i33);
                                } else {
                                    c4032g5.mo8030d(i33);
                                }
                                abstractC4039n3.f13687g = true;
                                if (i34 >= i44 && i34 < i6) {
                                    i33 = z7 ? i33 - (-c4032g5.f13668f) : i33 + (-c4032g5.f13668f);
                                }
                            }
                            i34++;
                            i32 = i38;
                            enumC3957d2 = enumC3957d4;
                        }
                        return;
                    }
                    enumC3957d3 = enumC3957d2;
                    if (i19 == 0) {
                        i26 = (i42 - i14) / (i13 + 1);
                        if (i12 > 0) {
                            i26 = 0;
                        }
                        i27 = i18;
                        for (i28 = 0; i28 < i15; i28++) {
                            if (z7) {
                                i29 = i15 - (i28 + 1);
                            } else {
                                i29 = i28;
                            }
                            abstractC4039n2 = (AbstractC4039n) arrayList2.get(i29);
                            i30 = abstractC4039n2.f13682b.f13347X;
                            c4032g3 = abstractC4039n2.f13689i;
                            c4032g4 = abstractC4039n2.f13688h;
                            if (i30 == 8) {
                                c4032g4.mo8030d(i27);
                                c4032g3.mo8030d(i27);
                            } else {
                                if (z7) {
                                    i31 = i27 - i26;
                                } else {
                                    i31 = i27 + i26;
                                }
                                if (i28 > 0 && i28 >= i16) {
                                    if (z7) {
                                        i31 -= c4032g4.f13668f;
                                    } else {
                                        i31 += c4032g4.f13668f;
                                    }
                                }
                                if (z7) {
                                    c4032g3.mo8030d(i31);
                                } else {
                                    c4032g4.mo8030d(i31);
                                }
                                c4033h2 = abstractC4039n2.f13685e;
                                iMin = c4033h2.f13669g;
                                if (abstractC4039n2.f13684d == enumC3957d3 && abstractC4039n2.f13681a == 1) {
                                    iMin = Math.min(iMin, c4033h2.f13675m);
                                }
                                if (z7) {
                                    i27 = i31 - iMin;
                                } else {
                                    i27 = i31 + iMin;
                                }
                                if (z7) {
                                    c4032g4.mo8030d(i27);
                                } else {
                                    c4032g3.mo8030d(i27);
                                }
                                if (i28 >= i44 && i28 < i6) {
                                    i27 = z7 ? i27 - (-c4032g3.f13668f) : i27 + (-c4032g3.f13668f);
                                }
                            }
                        }
                        return;
                    }
                    if (i19 == 2) {
                        if (this.f13686f == 0) {
                            f3 = this.f13682b.f13344U;
                        } else {
                            f3 = this.f13682b.f13345V;
                        }
                        if (z7) {
                            f3 = 1.0f - f3;
                        }
                        i20 = (int) (((i42 - i14) * f3) + 0.5f);
                        if (i20 >= 0 || i12 > 0) {
                            i20 = 0;
                        }
                        if (z7) {
                            i21 = i18 - i20;
                        } else {
                            i21 = i18 + i20;
                        }
                        for (i22 = 0; i22 < i15; i22++) {
                            if (z7) {
                                i23 = i15 - (i22 + 1);
                            } else {
                                i23 = i22;
                            }
                            abstractC4039n = (AbstractC4039n) arrayList2.get(i23);
                            i24 = abstractC4039n.f13682b.f13347X;
                            c4032g = abstractC4039n.f13689i;
                            c4032g2 = abstractC4039n.f13688h;
                            if (i24 == 8) {
                                c4032g2.mo8030d(i21);
                                c4032g.mo8030d(i21);
                            } else {
                                if (i22 > 0 && i22 >= i16) {
                                    if (z7) {
                                        i21 -= c4032g2.f13668f;
                                    } else {
                                        i21 += c4032g2.f13668f;
                                    }
                                }
                                if (z7) {
                                    c4032g.mo8030d(i21);
                                } else {
                                    c4032g2.mo8030d(i21);
                                }
                                c4033h = abstractC4039n.f13685e;
                                i25 = c4033h.f13669g;
                                if (abstractC4039n.f13684d == enumC3957d3 && abstractC4039n.f13681a == 1) {
                                    i25 = c4033h.f13675m;
                                }
                                if (z7) {
                                    i21 -= i25;
                                } else {
                                    i21 += i25;
                                }
                                if (z7) {
                                    c4032g2.mo8030d(i21);
                                } else {
                                    c4032g.mo8030d(i21);
                                }
                                if (i22 >= i44 && i22 < i6) {
                                    i21 = z7 ? i21 - (-c4032g.f13668f) : i21 + (-c4032g.f13668f);
                                }
                            }
                        }
                    }
                }
                z7 = z10;
                enumC3957d2 = enumC3957d;
                arrayList2 = arrayList;
                i15 = i10;
                i16 = i11;
                i17 = 2;
                i18 = i53;
                if (i14 > i42) {
                    this.f13654l = i17;
                }
                if (i13 > 0) {
                    this.f13654l = i17;
                }
                i19 = this.f13654l;
                if (i19 == 1) {
                    if (i13 > 1) {
                        i32 = (i42 - i14) / (i13 - 1);
                    } else if (i13 == 1) {
                        i32 = (i42 - i14) / 2;
                    } else {
                        i32 = 0;
                    }
                    if (i12 > 0) {
                        i32 = 0;
                    }
                    i33 = i18;
                    i34 = 0;
                    while (i34 < i15) {
                        if (z7) {
                            i35 = i15 - (i34 + 1);
                        } else {
                            i35 = i34;
                        }
                        abstractC4039n3 = (AbstractC4039n) arrayList2.get(i35);
                        i36 = abstractC4039n3.f13682b.f13347X;
                        c4032g5 = abstractC4039n3.f13689i;
                        c4032g6 = abstractC4039n3.f13688h;
                        if (i36 == 8) {
                            c4032g6.mo8030d(i33);
                            c4032g5.mo8030d(i33);
                            i38 = i32;
                            enumC3957d4 = enumC3957d2;
                        } else {
                            if (i34 > 0) {
                                if (z7) {
                                    i33 -= i32;
                                } else {
                                    i33 += i32;
                                }
                            }
                            if (i34 > 0) {
                                if (z7) {
                                    i33 -= c4032g6.f13668f;
                                } else {
                                    i33 += c4032g6.f13668f;
                                }
                            }
                            if (z7) {
                                c4032g5.mo8030d(i33);
                            } else {
                                c4032g6.mo8030d(i33);
                            }
                            c4033h3 = abstractC4039n3.f13685e;
                            i37 = c4033h3.f13669g;
                            enumC3957d4 = enumC3957d2;
                            if (abstractC4039n3.f13684d == enumC3957d4) {
                                i38 = i32;
                                if (abstractC4039n3.f13681a == 1) {
                                    i37 = c4033h3.f13675m;
                                }
                            } else {
                                i38 = i32;
                            }
                            if (z7) {
                                i33 -= i37;
                            } else {
                                i33 += i37;
                            }
                            if (z7) {
                                c4032g6.mo8030d(i33);
                            } else {
                                c4032g5.mo8030d(i33);
                            }
                            abstractC4039n3.f13687g = true;
                            if (i34 >= i44) {
                            }
                        }
                        i34++;
                        i32 = i38;
                        enumC3957d2 = enumC3957d4;
                    }
                    return;
                }
                enumC3957d3 = enumC3957d2;
                if (i19 == 0) {
                    i26 = (i42 - i14) / (i13 + 1);
                    if (i12 > 0) {
                        i26 = 0;
                    }
                    i27 = i18;
                    while (i28 < i15) {
                        if (z7) {
                            i29 = i15 - (i28 + 1);
                        } else {
                            i29 = i28;
                        }
                        abstractC4039n2 = (AbstractC4039n) arrayList2.get(i29);
                        i30 = abstractC4039n2.f13682b.f13347X;
                        c4032g3 = abstractC4039n2.f13689i;
                        c4032g4 = abstractC4039n2.f13688h;
                        if (i30 == 8) {
                            c4032g4.mo8030d(i27);
                            c4032g3.mo8030d(i27);
                        } else {
                            if (z7) {
                                i31 = i27 - i26;
                            } else {
                                i31 = i27 + i26;
                            }
                            if (i28 > 0) {
                                if (z7) {
                                    i31 -= c4032g4.f13668f;
                                } else {
                                    i31 += c4032g4.f13668f;
                                }
                            }
                            if (z7) {
                                c4032g3.mo8030d(i31);
                            } else {
                                c4032g4.mo8030d(i31);
                            }
                            c4033h2 = abstractC4039n2.f13685e;
                            iMin = c4033h2.f13669g;
                            if (abstractC4039n2.f13684d == enumC3957d3) {
                                iMin = Math.min(iMin, c4033h2.f13675m);
                            }
                            if (z7) {
                                i27 = i31 - iMin;
                            } else {
                                i27 = i31 + iMin;
                            }
                            if (z7) {
                                c4032g4.mo8030d(i27);
                            } else {
                                c4032g3.mo8030d(i27);
                            }
                            if (i28 >= i44) {
                            }
                        }
                    }
                    return;
                }
                if (i19 == 2) {
                    if (this.f13686f == 0) {
                        f3 = this.f13682b.f13344U;
                    } else {
                        f3 = this.f13682b.f13345V;
                    }
                    if (z7) {
                        f3 = 1.0f - f3;
                    }
                    i20 = (int) (((i42 - i14) * f3) + 0.5f);
                    if (i20 >= 0) {
                        i20 = 0;
                    } else {
                        i20 = 0;
                    }
                    if (z7) {
                        i21 = i18 - i20;
                    } else {
                        i21 = i18 + i20;
                    }
                    while (i22 < i15) {
                        if (z7) {
                            i23 = i15 - (i22 + 1);
                        } else {
                            i23 = i22;
                        }
                        abstractC4039n = (AbstractC4039n) arrayList2.get(i23);
                        i24 = abstractC4039n.f13682b.f13347X;
                        c4032g = abstractC4039n.f13689i;
                        c4032g2 = abstractC4039n.f13688h;
                        if (i24 == 8) {
                            c4032g2.mo8030d(i21);
                            c4032g.mo8030d(i21);
                        } else {
                            if (i22 > 0) {
                                if (z7) {
                                    i21 -= c4032g2.f13668f;
                                } else {
                                    i21 += c4032g2.f13668f;
                                }
                            }
                            if (z7) {
                                c4032g.mo8030d(i21);
                            } else {
                                c4032g2.mo8030d(i21);
                            }
                            c4033h = abstractC4039n.f13685e;
                            i25 = c4033h.f13669g;
                            if (abstractC4039n.f13684d == enumC3957d3) {
                                i25 = c4033h.f13675m;
                            }
                            if (z7) {
                                i21 -= i25;
                            } else {
                                i21 += i25;
                            }
                            if (z7) {
                                c4032g2.mo8030d(i21);
                            } else {
                                c4032g.mo8030d(i21);
                            }
                            if (i22 >= i44) {
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public final void mo8014d() {
        ArrayList arrayList = this.f13653k;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((AbstractC4039n) it.next()).mo8014d();
        }
        int size = arrayList.size();
        if (size < 1) {
            return;
        }
        C3958e c3958e = ((AbstractC4039n) arrayList.get(0)).f13682b;
        C3958e c3958e2 = ((AbstractC4039n) arrayList.get(size - 1)).f13682b;
        int i6 = this.f13686f;
        C4032g c4032g = this.f13689i;
        C4032g c4032g2 = this.f13688h;
        if (i6 == 0) {
            C3956c c3956c = c3958e.f13380y;
            C3956c c3956c2 = c3958e2.f13324A;
            C4032g c4032gM8040i = AbstractC4039n.m8040i(c3956c, 0);
            int iM7887c = c3956c.m7887c();
            C3958e c3958eM8019m = m8019m();
            if (c3958eM8019m != null) {
                iM7887c = c3958eM8019m.f13380y.m7887c();
            }
            if (c4032gM8040i != null) {
                AbstractC4039n.m8038b(c4032g2, c4032gM8040i, iM7887c);
            }
            C4032g c4032gM8040i2 = AbstractC4039n.m8040i(c3956c2, 0);
            int iM7887c2 = c3956c2.m7887c();
            C3958e c3958eM8020n = m8020n();
            if (c3958eM8020n != null) {
                iM7887c2 = c3958eM8020n.f13324A.m7887c();
            }
            if (c4032gM8040i2 != null) {
                AbstractC4039n.m8038b(c4032g, c4032gM8040i2, -iM7887c2);
            }
        } else {
            C3956c c3956c3 = c3958e.f13381z;
            C3956c c3956c4 = c3958e2.f13325B;
            C4032g c4032gM8040i3 = AbstractC4039n.m8040i(c3956c3, 1);
            int iM7887c3 = c3956c3.m7887c();
            C3958e c3958eM8019m2 = m8019m();
            if (c3958eM8019m2 != null) {
                iM7887c3 = c3958eM8019m2.f13381z.m7887c();
            }
            if (c4032gM8040i3 != null) {
                AbstractC4039n.m8038b(c4032g2, c4032gM8040i3, iM7887c3);
            }
            C4032g c4032gM8040i4 = AbstractC4039n.m8040i(c3956c4, 1);
            int iM7887c4 = c3956c4.m7887c();
            C3958e c3958eM8020n2 = m8020n();
            if (c3958eM8020n2 != null) {
                iM7887c4 = c3958eM8020n2.f13325B.m7887c();
            }
            if (c4032gM8040i4 != null) {
                AbstractC4039n.m8038b(c4032g, c4032gM8040i4, -iM7887c4);
            }
        }
        c4032g2.f13663a = this;
        c4032g.f13663a = this;
    }

    @Override
    public final void mo8015e() {
        int i6 = 0;
        while (true) {
            ArrayList arrayList = this.f13653k;
            if (i6 >= arrayList.size()) {
                return;
            }
            ((AbstractC4039n) arrayList.get(i6)).mo8015e();
            i6++;
        }
    }

    @Override
    public final void mo8016f() {
        this.f13683c = null;
        Iterator it = this.f13653k.iterator();
        while (it.hasNext()) {
            ((AbstractC4039n) it.next()).mo8016f();
        }
    }

    @Override
    public final long mo8017j() {
        ArrayList arrayList = this.f13653k;
        int size = arrayList.size();
        long jMo8017j = 0;
        for (int i6 = 0; i6 < size; i6++) {
            AbstractC4039n abstractC4039n = (AbstractC4039n) arrayList.get(i6);
            jMo8017j = ((long) abstractC4039n.f13689i.f13668f) + abstractC4039n.mo8017j() + jMo8017j + ((long) abstractC4039n.f13688h.f13668f);
        }
        return jMo8017j;
    }

    @Override
    public final boolean mo8018k() {
        ArrayList arrayList = this.f13653k;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            if (!((AbstractC4039n) arrayList.get(i6)).mo8018k()) {
                return false;
            }
        }
        return true;
    }

    public final C3958e m8019m() {
        int i6 = 0;
        while (true) {
            ArrayList arrayList = this.f13653k;
            if (i6 >= arrayList.size()) {
                return null;
            }
            C3958e c3958e = ((AbstractC4039n) arrayList.get(i6)).f13682b;
            if (c3958e.f13347X != 8) {
                return c3958e;
            }
            i6++;
        }
    }

    public final C3958e m8020n() {
        ArrayList arrayList = this.f13653k;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            C3958e c3958e = ((AbstractC4039n) arrayList.get(size)).f13682b;
            if (c3958e.f13347X != 8) {
                return c3958e;
            }
        }
        return null;
    }

    public final String toString() {
        String strConcat = "ChainRun ".concat(this.f13686f == 0 ? "horizontal : " : "vertical : ");
        for (AbstractC4039n abstractC4039n : this.f13653k) {
            strConcat = AbstractC2460q.m5494h(AbstractC2460q.m5494h(strConcat, "<") + abstractC4039n, "> ");
        }
        return strConcat;
    }
}
