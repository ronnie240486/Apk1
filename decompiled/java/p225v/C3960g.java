package p225v;

public final class C3960g {

    public int f13397a;

    public C3956c f13400d;

    public C3956c f13401e;

    public C3956c f13402f;

    public C3956c f13403g;

    public int f13404h;

    public int f13405i;

    public int f13406j;

    public int f13407k;

    public int f13413q;

    public final C3961h f13414r;

    public C3958e f13398b = null;

    public int f13399c = 0;

    public int f13408l = 0;

    public int f13409m = 0;

    public int f13410n = 0;

    public int f13411o = 0;

    public int f13412p = 0;

    public C3960g(C3961h c3961h, int i6, C3956c c3956c, C3956c c3956c2, C3956c c3956c3, C3956c c3956c4, int i10) {
        this.f13414r = c3961h;
        this.f13404h = 0;
        this.f13405i = 0;
        this.f13406j = 0;
        this.f13407k = 0;
        this.f13413q = 0;
        this.f13397a = i6;
        this.f13400d = c3956c;
        this.f13401e = c3956c2;
        this.f13402f = c3956c3;
        this.f13403g = c3956c4;
        this.f13404h = c3961h.f13437m0;
        this.f13405i = c3961h.f13433i0;
        this.f13406j = c3961h.f13438n0;
        this.f13407k = c3961h.f13434j0;
        this.f13413q = i10;
    }

    public final void m7924a(C3958e c3958e) {
        int i6 = this.f13397a;
        EnumC3957d enumC3957d = EnumC3957d.f13321c;
        C3961h c3961h = this.f13414r;
        if (i6 == 0) {
            int iM7932F = c3961h.m7932F(c3958e, this.f13413q);
            if (c3958e.f13333J[0] == enumC3957d) {
                this.f13412p++;
                iM7932F = 0;
            }
            this.f13408l = iM7932F + (c3958e.f13347X != 8 ? c3961h.f13420F0 : 0) + this.f13408l;
            int iM7931E = c3961h.m7931E(c3958e, this.f13413q);
            if (this.f13398b == null || this.f13399c < iM7931E) {
                this.f13398b = c3958e;
                this.f13399c = iM7931E;
                this.f13409m = iM7931E;
            }
        } else {
            int iM7932F2 = c3961h.m7932F(c3958e, this.f13413q);
            int iM7931E2 = c3961h.m7931E(c3958e, this.f13413q);
            if (c3958e.f13333J[1] == enumC3957d) {
                this.f13412p++;
                iM7931E2 = 0;
            }
            this.f13409m = iM7931E2 + (c3958e.f13347X != 8 ? c3961h.f13421G0 : 0) + this.f13409m;
            if (this.f13398b == null || this.f13399c < iM7932F2) {
                this.f13398b = c3958e;
                this.f13399c = iM7932F2;
                this.f13408l = iM7932F2;
            }
        }
        this.f13411o++;
    }

    public final void m7925b(int i6, boolean z7, boolean z10) {
        C3961h c3961h;
        int i10;
        C3958e c3958e;
        int i11;
        int i12;
        int i13;
        int i14 = this.f13411o;
        int i15 = 0;
        while (true) {
            c3961h = this.f13414r;
            if (i15 >= i14 || (i13 = this.f13410n + i15) >= c3961h.f13432R0) {
                break;
            }
            C3958e c3958e2 = c3961h.f13431Q0[i13];
            if (c3958e2 != null) {
                c3958e2.m7913u();
            }
            i15++;
        }
        if (i14 == 0 || this.f13398b == null) {
            return;
        }
        boolean z11 = z10 && i6 == 0;
        int i16 = -1;
        int i17 = -1;
        for (int i18 = 0; i18 < i14; i18++) {
            int i19 = this.f13410n + (z7 ? (i14 - 1) - i18 : i18);
            if (i19 >= c3961h.f13432R0) {
                break;
            }
            if (c3961h.f13431Q0[i19].f13347X == 0) {
                if (i16 == -1) {
                    i16 = i18;
                }
                i17 = i18;
            }
        }
        if (this.f13397a != 0) {
            C3958e c3958e3 = this.f13398b;
            c3958e3.f13349Z = c3961h.f13444t0;
            int i20 = this.f13404h;
            if (i6 > 0) {
                i20 += c3961h.f13420F0;
            }
            C3956c c3956c = c3958e3.f13380y;
            C3956c c3956c2 = c3958e3.f13324A;
            if (z7) {
                c3956c2.m7885a(this.f13402f, i20);
                if (z10) {
                    c3956c.m7885a(this.f13400d, this.f13406j);
                }
                if (i6 > 0) {
                    this.f13402f.f13313b.f13380y.m7885a(c3956c2, 0);
                }
            } else {
                c3956c.m7885a(this.f13400d, i20);
                if (z10) {
                    c3956c2.m7885a(this.f13402f, this.f13406j);
                }
                if (i6 > 0) {
                    this.f13400d.f13313b.f13324A.m7885a(c3956c, 0);
                }
            }
            int i21 = 0;
            C3958e c3958e4 = null;
            while (i21 < i14) {
                int i22 = this.f13410n + i21;
                if (i22 >= c3961h.f13432R0) {
                    return;
                }
                C3958e c3958e5 = c3961h.f13431Q0[i22];
                if (i21 == 0) {
                    c3958e5.m7898e(c3958e5.f13381z, this.f13401e, this.f13405i);
                    int i23 = c3961h.f13445u0;
                    float f = c3961h.f13415A0;
                    if (this.f13410n == 0) {
                        int i24 = c3961h.f13447w0;
                        i10 = -1;
                        if (i24 != -1) {
                            f = c3961h.f13417C0;
                        }
                        i23 = i24;
                        c3958e5.f13351a0 = i23;
                        c3958e5.f13345V = f;
                    } else {
                        i10 = -1;
                    }
                    if (z10 && (i24 = c3961h.f13449y0) != i10) {
                        f = c3961h.f13419E0;
                        i23 = i24;
                    }
                    c3958e5.f13351a0 = i23;
                    c3958e5.f13345V = f;
                }
                if (i21 == i14 - 1) {
                    c3958e5.m7898e(c3958e5.f13325B, this.f13403g, this.f13407k);
                }
                if (c3958e4 != null) {
                    C3956c c3956c3 = c3958e5.f13381z;
                    int i25 = c3961h.f13421G0;
                    C3956c c3956c4 = c3958e4.f13325B;
                    c3956c3.m7885a(c3956c4, i25);
                    C3956c c3956c5 = c3958e5.f13381z;
                    if (i21 == i16) {
                        int i26 = this.f13405i;
                        if (c3956c5.m7890f()) {
                            c3956c5.f13317f = i26;
                        }
                    }
                    c3956c4.m7885a(c3956c5, 0);
                    if (i21 == i17 + 1) {
                        int i27 = this.f13407k;
                        if (c3956c4.m7890f()) {
                            c3956c4.f13317f = i27;
                        }
                    }
                }
                if (c3958e5 != c3958e3) {
                    if (z7) {
                        int i28 = c3961h.f13422H0;
                        if (i28 == 0) {
                            c3958e5.f13324A.m7885a(c3956c2, 0);
                        } else if (i28 == 1) {
                            c3958e5.f13380y.m7885a(c3956c, 0);
                        } else if (i28 == 2) {
                            c3958e5.f13380y.m7885a(c3956c, 0);
                            c3958e5.f13324A.m7885a(c3956c2, 0);
                        }
                    } else {
                        int i29 = c3961h.f13422H0;
                        if (i29 == 0) {
                            c3958e5.f13380y.m7885a(c3956c, 0);
                        } else if (i29 == 1) {
                            c3958e5.f13324A.m7885a(c3956c2, 0);
                        } else if (i29 == 2) {
                            if (z11) {
                                c3958e5.f13380y.m7885a(this.f13400d, this.f13404h);
                                c3958e5.f13324A.m7885a(this.f13402f, this.f13406j);
                            } else {
                                c3958e5.f13380y.m7885a(c3956c, 0);
                                c3958e5.f13324A.m7885a(c3956c2, 0);
                            }
                        }
                    }
                }
                i21++;
                c3958e4 = c3958e5;
            }
            return;
        }
        C3958e c3958e6 = this.f13398b;
        c3958e6.f13351a0 = c3961h.f13445u0;
        int i30 = this.f13405i;
        if (i6 > 0) {
            i30 += c3961h.f13421G0;
        }
        C3956c c3956c6 = this.f13401e;
        C3956c c3956c7 = c3958e6.f13381z;
        c3956c7.m7885a(c3956c6, i30);
        C3956c c3956c8 = c3958e6.f13325B;
        if (z10) {
            c3956c8.m7885a(this.f13403g, this.f13407k);
        }
        if (i6 > 0) {
            this.f13401e.f13313b.f13325B.m7885a(c3956c7, 0);
        }
        if (c3961h.f13423I0 != 3 || c3958e6.f13378w) {
            c3958e = c3958e6;
            break;
        }
        int i31 = 0;
        while (true) {
            if (i31 < i14) {
                int i32 = this.f13410n + (z7 ? (i14 - 1) - i31 : i31);
                if (i32 < c3961h.f13432R0) {
                    c3958e = c3961h.f13431Q0[i32];
                    if (c3958e.f13378w) {
                        break;
                    } else {
                        i31++;
                    }
                }
            }
            c3958e = c3958e6;
            break;
        }
        C3958e c3958e7 = null;
        int i33 = 0;
        while (i33 < i14) {
            int i34 = z7 ? (i14 - 1) - i33 : i33;
            int i35 = this.f13410n + i34;
            if (i35 >= c3961h.f13432R0) {
                return;
            }
            C3958e c3958e8 = c3961h.f13431Q0[i35];
            if (i33 == 0) {
                c3958e8.m7898e(c3958e8.f13380y, this.f13400d, this.f13404h);
            }
            if (i34 == 0) {
                int i36 = c3961h.f13444t0;
                float f3 = c3961h.f13450z0;
                if (this.f13410n == 0) {
                    int i37 = c3961h.f13446v0;
                    i11 = -1;
                    if (i37 != -1) {
                        f3 = c3961h.f13416B0;
                    }
                    i12 = i37;
                    c3958e8.f13349Z = i12;
                    c3958e8.f13344U = f3;
                } else {
                    i11 = -1;
                }
                if (!z10 || (i37 = c3961h.f13448x0) == i11) {
                    i12 = i36;
                } else {
                    f3 = c3961h.f13418D0;
                    i12 = i37;
                }
                c3958e8.f13349Z = i12;
                c3958e8.f13344U = f3;
            }
            if (i33 == i14 - 1) {
                c3958e8.m7898e(c3958e8.f13324A, this.f13402f, this.f13406j);
            }
            if (c3958e7 != null) {
                C3956c c3956c9 = c3958e8.f13380y;
                int i38 = c3961h.f13420F0;
                C3956c c3956c10 = c3958e7.f13324A;
                c3956c9.m7885a(c3956c10, i38);
                C3956c c3956c11 = c3958e8.f13380y;
                if (i33 == i16) {
                    int i39 = this.f13404h;
                    if (c3956c11.m7890f()) {
                        c3956c11.f13317f = i39;
                    }
                }
                c3956c10.m7885a(c3956c11, 0);
                if (i33 == i17 + 1) {
                    int i40 = this.f13406j;
                    if (c3956c10.m7890f()) {
                        c3956c10.f13317f = i40;
                    }
                }
            }
            if (c3958e8 != c3958e6) {
                int i41 = c3961h.f13423I0;
                if (i41 == 3 && c3958e.f13378w && c3958e8 != c3958e && c3958e8.f13378w) {
                    c3958e8.f13326C.m7885a(c3958e.f13326C, 0);
                } else if (i41 == 0) {
                    c3958e8.f13381z.m7885a(c3956c7, 0);
                } else if (i41 == 1) {
                    c3958e8.f13325B.m7885a(c3956c8, 0);
                } else if (z11) {
                    c3958e8.f13381z.m7885a(this.f13401e, this.f13405i);
                    c3958e8.f13325B.m7885a(this.f13403g, this.f13407k);
                } else {
                    c3958e8.f13381z.m7885a(c3956c7, 0);
                    c3958e8.f13325B.m7885a(c3956c8, 0);
                }
            }
            i33++;
            c3958e7 = c3958e8;
        }
    }

    public final int m7926c() {
        return this.f13397a == 1 ? this.f13409m - this.f13414r.f13421G0 : this.f13409m;
    }

    public final int m7927d() {
        return this.f13397a == 0 ? this.f13408l - this.f13414r.f13420F0 : this.f13408l;
    }

    public final void m7928e(int i6) {
        int i10 = this.f13412p;
        if (i10 == 0) {
            return;
        }
        int i11 = this.f13411o;
        int i12 = i6 / i10;
        for (int i13 = 0; i13 < i11; i13++) {
            int i14 = this.f13410n;
            int i15 = i14 + i13;
            C3961h c3961h = this.f13414r;
            if (i15 >= c3961h.f13432R0) {
                break;
            }
            C3958e c3958e = c3961h.f13431Q0[i14 + i13];
            int i16 = this.f13397a;
            EnumC3957d enumC3957d = EnumC3957d.f13319a;
            EnumC3957d enumC3957d2 = EnumC3957d.f13321c;
            if (i16 == 0) {
                if (c3958e != null) {
                    EnumC3957d[] enumC3957dArr = c3958e.f13333J;
                    if (enumC3957dArr[0] == enumC3957d2 && c3958e.f13365j == 0) {
                        c3961h.m7933G(c3958e, enumC3957d, i12, enumC3957dArr[1], c3958e.m7902j());
                    }
                }
            } else if (c3958e != null) {
                EnumC3957d[] enumC3957dArr2 = c3958e.f13333J;
                if (enumC3957dArr2[1] == enumC3957d2 && c3958e.f13366k == 0) {
                    c3961h.m7933G(c3958e, enumC3957dArr2[0], c3958e.m7905m(), enumC3957d, i12);
                }
            }
        }
        this.f13408l = 0;
        this.f13409m = 0;
        this.f13398b = null;
        this.f13399c = 0;
        int i17 = this.f13411o;
        for (int i18 = 0; i18 < i17; i18++) {
            int i19 = this.f13410n + i18;
            C3961h c3961h2 = this.f13414r;
            if (i19 >= c3961h2.f13432R0) {
                return;
            }
            C3958e c3958e2 = c3961h2.f13431Q0[i19];
            if (this.f13397a == 0) {
                int iM7905m = c3958e2.m7905m();
                int i20 = c3961h2.f13420F0;
                if (c3958e2.f13347X == 8) {
                    i20 = 0;
                }
                this.f13408l = iM7905m + i20 + this.f13408l;
                int iM7931E = c3961h2.m7931E(c3958e2, this.f13413q);
                if (this.f13398b == null || this.f13399c < iM7931E) {
                    this.f13398b = c3958e2;
                    this.f13399c = iM7931E;
                    this.f13409m = iM7931E;
                }
            } else {
                int iM7932F = c3961h2.m7932F(c3958e2, this.f13413q);
                int iM7931E2 = c3961h2.m7931E(c3958e2, this.f13413q);
                int i21 = c3961h2.f13421G0;
                if (c3958e2.f13347X == 8) {
                    i21 = 0;
                }
                this.f13409m = iM7931E2 + i21 + this.f13409m;
                if (this.f13398b == null || this.f13399c < iM7932F) {
                    this.f13398b = c3958e2;
                    this.f13399c = iM7932F;
                    this.f13408l = iM7932F;
                }
            }
        }
    }

    public final void m7929f(int i6, C3956c c3956c, C3956c c3956c2, C3956c c3956c3, C3956c c3956c4, int i10, int i11, int i12, int i13, int i14) {
        this.f13397a = i6;
        this.f13400d = c3956c;
        this.f13401e = c3956c2;
        this.f13402f = c3956c3;
        this.f13403g = c3956c4;
        this.f13404h = i10;
        this.f13405i = i11;
        this.f13406j = i12;
        this.f13407k = i13;
        this.f13413q = i14;
    }
}
