package p225v;

import java.util.ArrayList;
import p215u.C3880c;
import p215u.C3882e;
import p215u.C3886i;

public abstract class AbstractC3964k {

    public static final boolean[] f13458a = new boolean[3];

    public static void m7936a(C3959f c3959f, C3882e c3882e, int i6) {
        int i10;
        C3955b[] c3955bArr;
        int i11;
        int i12;
        int i13;
        boolean z7;
        boolean z10;
        boolean z11;
        C3956c[] c3956cArr;
        C3955b[] c3955bArr2;
        C3958e c3958e;
        C3956c[] c3956cArr2;
        int i14;
        C3956c c3956c;
        C3956c c3956c2;
        C3886i c3886i;
        C3956c c3956c3;
        C3886i c3886i2;
        int i15;
        C3886i c3886i3;
        C3956c c3956c4;
        C3886i c3886i4;
        C3956c c3956c5;
        C3886i c3886i5;
        C3886i c3886i6;
        int size;
        C3956c c3956c6;
        C3958e c3958e2;
        int i16;
        C3958e c3958e3;
        C3959f c3959f2 = c3959f;
        if (i6 == 0) {
            i10 = c3959f2.f13390o0;
            c3955bArr = c3959f2.f13393r0;
            i11 = 0;
        } else {
            i10 = c3959f2.f13391p0;
            c3955bArr = c3959f2.f13392q0;
            i11 = 2;
        }
        int i17 = 0;
        while (i17 < i10) {
            C3955b c3955b = c3955bArr[i17];
            boolean z12 = c3955b.f13311q;
            EnumC3957d enumC3957d = EnumC3957d.f13321c;
            C3958e c3958e4 = c3955b.f13295a;
            int i18 = 1;
            int i19 = 8;
            if (z12) {
                i12 = i17;
                i13 = i10;
            } else {
                int i20 = c3955b.f13306l;
                int i21 = i20 * 2;
                C3958e c3958e5 = c3958e4;
                C3958e c3958e6 = c3958e5;
                boolean z13 = false;
                while (!z13) {
                    c3955b.f13303i += i18;
                    c3958e5.f13357d0[i20] = null;
                    c3958e5.f13355c0[i20] = null;
                    int i22 = c3958e5.f13347X;
                    C3956c[] c3956cArr3 = c3958e5.f13330G;
                    if (i22 != i19) {
                        c3958e5.m7901i(i20);
                        c3956cArr3[i21].m7887c();
                        int i23 = i21 + 1;
                        c3956cArr3[i23].m7887c();
                        c3956cArr3[i21].m7887c();
                        c3956cArr3[i23].m7887c();
                        if (c3955b.f13296b == null) {
                            c3955b.f13296b = c3958e5;
                        }
                        c3955b.f13298d = c3958e5;
                        EnumC3957d enumC3957d2 = c3958e5.f13333J[i20];
                        if (enumC3957d2 == enumC3957d) {
                            int i24 = c3958e5.f13367l[i20];
                            if (i24 == 0 || i24 == 3 || i24 == 2) {
                                c3955b.f13304j++;
                                float f = c3958e5.f13353b0[i20];
                                if (f > 0.0f) {
                                    c3955b.f13305k += f;
                                }
                                if (c3958e5.f13347X != 8 && enumC3957d2 == enumC3957d && (i24 == 0 || i24 == 3)) {
                                    if (f < 0.0f) {
                                        c3955b.f13308n = true;
                                    } else {
                                        c3955b.f13309o = true;
                                    }
                                    if (c3955b.f13302h == null) {
                                        c3955b.f13302h = new ArrayList();
                                    }
                                    c3955b.f13302h.add(c3958e5);
                                }
                                if (c3955b.f13300f == null) {
                                    c3955b.f13300f = c3958e5;
                                }
                                C3958e c3958e7 = c3955b.f13301g;
                                if (c3958e7 != null) {
                                    c3958e7.f13355c0[i20] = c3958e5;
                                }
                                c3955b.f13301g = c3958e5;
                            } else {
                                i17 = i17;
                            }
                            if (i20 == 0) {
                                if (c3958e5.f13365j == 0 && c3958e5.f13368m == 0) {
                                    int i25 = c3958e5.f13369n;
                                }
                            } else if (c3958e5.f13366k == 0 && c3958e5.f13371p == 0) {
                                int i26 = c3958e5.f13372q;
                            }
                        } else {
                            i17 = i17;
                            i10 = i10;
                        }
                    } else {
                        i17 = i17;
                        i10 = i10;
                    }
                    C3958e c3958e8 = c3958e6;
                    if (c3958e8 != c3958e5) {
                        c3958e8.f13357d0[i20] = c3958e5;
                    }
                    C3956c c3956c7 = c3956cArr3[i21 + 1].f13315d;
                    if (c3956c7 != null) {
                        c3958e3 = c3956c7.f13313b;
                        C3956c c3956c8 = c3958e3.f13330G[i21].f13315d;
                        if (c3956c8 == null || c3956c8.f13313b != c3958e5) {
                            c3958e3 = null;
                        }
                    } else {
                        c3958e3 = null;
                    }
                    if (c3958e3 == null) {
                        c3958e3 = c3958e5;
                        z13 = true;
                    }
                    c3958e6 = c3958e5;
                    i17 = i17;
                    i10 = i10;
                    i19 = 8;
                    c3958e5 = c3958e3;
                    i18 = 1;
                }
                i12 = i17;
                i13 = i10;
                C3958e c3958e9 = c3955b.f13296b;
                if (c3958e9 != null) {
                    c3958e9.f13330G[i21].m7887c();
                }
                C3958e c3958e10 = c3955b.f13298d;
                if (c3958e10 != null) {
                    c3958e10.f13330G[i21 + 1].m7887c();
                }
                c3955b.f13297c = c3958e5;
                if (i20 == 0 && c3955b.f13307m) {
                    c3955b.f13299e = c3958e5;
                } else {
                    c3955b.f13299e = c3958e4;
                }
                c3955b.f13310p = c3955b.f13309o && c3955b.f13308n;
            }
            c3955b.f13311q = true;
            C3958e c3958e11 = c3955b.f13297c;
            C3958e c3958e12 = c3955b.f13296b;
            C3958e c3958e13 = c3955b.f13298d;
            C3958e c3958e14 = c3955b.f13299e;
            float f3 = c3955b.f13305k;
            boolean z14 = c3959f2.f13333J[i6] == EnumC3957d.f13320b;
            if (i6 == 0) {
                int i27 = c3958e14.f13349Z;
                boolean z15 = i27 == 0;
                z11 = i27 == 1;
                z7 = i27 == 2;
                z10 = z15;
            } else {
                int i28 = c3958e14.f13351a0;
                boolean z16 = i28 == 0;
                boolean z17 = i28 == 1;
                z7 = i28 == 2;
                z10 = z16;
                z11 = z17;
            }
            boolean z18 = false;
            while (true) {
                c3956cArr = c3959f2.f13330G;
                c3955bArr2 = c3955bArr;
                if (z18) {
                    break;
                }
                C3956c c3956c9 = c3958e4.f13330G[i11];
                int i29 = z7 ? 1 : 4;
                int iM7887c = c3956c9.m7887c();
                boolean z19 = z18;
                boolean z20 = c3958e4.f13333J[i6] == enumC3957d && c3958e4.f13367l[i6] == 0;
                C3956c c3956c10 = c3956c9.f13315d;
                if (c3956c10 != null && c3958e4 != c3958e4) {
                    iM7887c = c3956c10.m7887c() + iM7887c;
                }
                int i30 = iM7887c;
                if (z7 && c3958e4 != c3958e4 && c3958e4 != c3958e12) {
                    i29 = 5;
                }
                C3956c c3956c11 = c3956c9.f13315d;
                if (c3956c11 != null) {
                    if (c3958e4 == c3958e12) {
                        c3882e.m7771f(c3956c9.f13318g, c3956c11.f13318g, i30, 6);
                    } else {
                        c3882e.m7771f(c3956c9.f13318g, c3956c11.f13318g, i30, 8);
                    }
                    c3882e.m7770e(c3956c9.f13318g, c3956c9.f13315d.f13318g, i30, (!z20 || z7) ? i29 : 5);
                } else {
                    c3955b = c3955b;
                    c3958e12 = c3958e12;
                }
                C3956c[] c3956cArr4 = c3958e4.f13330G;
                if (z14) {
                    if (c3958e4.f13347X == 8 || c3958e4.f13333J[i6] != enumC3957d) {
                        i16 = 0;
                    } else {
                        i16 = 0;
                        c3882e.m7771f(c3956cArr4[i11 + 1].f13318g, c3956cArr4[i11].f13318g, 0, 5);
                    }
                    c3882e.m7771f(c3956cArr4[i11].f13318g, c3956cArr[i11].f13318g, i16, 8);
                }
                C3956c c3956c12 = c3956cArr4[i11 + 1].f13315d;
                if (c3956c12 != null) {
                    c3958e2 = c3956c12.f13313b;
                    C3956c c3956c13 = c3958e2.f13330G[i11].f13315d;
                    if (c3956c13 == null || c3956c13.f13313b != c3958e4) {
                        c3958e2 = null;
                    }
                } else {
                    c3958e2 = null;
                }
                if (c3958e2 != null) {
                    c3958e4 = c3958e2;
                    z18 = z19;
                } else {
                    z18 = true;
                }
                c3955bArr = c3955bArr2;
                c3958e4 = c3958e4;
                c3958e14 = c3958e14;
                c3958e12 = c3958e12;
                c3955b = c3955b;
            }
            C3955b c3955b2 = c3955b;
            C3958e c3958e15 = c3958e14;
            C3958e c3958e16 = c3958e4;
            C3958e c3958e17 = c3958e12;
            if (c3958e13 != null) {
                int i31 = i11 + 1;
                if (c3958e11.f13330G[i31].f13315d != null) {
                    C3956c c3956c14 = c3958e13.f13330G[i31];
                    if (c3958e13.f13333J[i6] == enumC3957d && c3958e13.f13367l[i6] == 0 && !z7) {
                        C3956c c3956c15 = c3956c14.f13315d;
                        if (c3956c15.f13313b == c3959f2) {
                            c3882e.m7770e(c3956c14.f13318g, c3956c15.f13318g, -c3956c14.m7887c(), 5);
                        } else if (z7) {
                            c3956c6 = c3956c14.f13315d;
                            if (c3956c6.f13313b == c3959f2) {
                                c3882e.m7770e(c3956c14.f13318g, c3956c6.f13318g, -c3956c14.m7887c(), 4);
                            }
                        }
                    } else if (z7) {
                        c3956c6 = c3956c14.f13315d;
                        if (c3956c6.f13313b == c3959f2) {
                            c3882e.m7770e(c3956c14.f13318g, c3956c6.f13318g, -c3956c14.m7887c(), 4);
                        }
                    }
                    c3882e.m7772g(c3956c14.f13318g, c3958e11.f13330G[i31].f13315d.f13318g, -c3956c14.m7887c(), 6);
                }
            }
            if (z14) {
                int i32 = i11 + 1;
                C3886i c3886i7 = c3956cArr[i32].f13318g;
                C3956c c3956c16 = c3958e11.f13330G[i32];
                c3882e.m7771f(c3886i7, c3956c16.f13318g, c3956c16.m7887c(), 8);
            }
            C3955b c3955b3 = c3955b2;
            ArrayList arrayList = c3955b3.f13302h;
            if (arrayList != null && (size = arrayList.size()) > 1) {
                float f4 = (!c3955b3.f13308n || c3955b3.f13310p) ? f3 : c3955b3.f13304j;
                C3958e c3958e18 = null;
                float f5 = 0.0f;
                int i33 = 0;
                while (i33 < size) {
                    C3958e c3958e19 = (C3958e) arrayList.get(i33);
                    float f10 = c3958e19.f13353b0[i6];
                    C3956c[] c3956cArr5 = c3958e19.f13330G;
                    if (f10 < 0.0f) {
                        if (c3955b3.f13310p) {
                            c3882e.m7770e(c3956cArr5[i11 + 1].f13318g, c3956cArr5[i11].f13318g, 0, 4);
                        } else {
                            f10 = 1.0f;
                        }
                        c3955b3 = c3955b3;
                        arrayList = arrayList;
                        size = size;
                        i33++;
                        c3955b3 = c3955b3;
                        size = size;
                        arrayList = arrayList;
                    }
                    if (f10 == 0.0f) {
                        c3882e.m7770e(c3956cArr5[i11 + 1].f13318g, c3956cArr5[i11].f13318g, 0, 8);
                        c3955b3 = c3955b3;
                        arrayList = arrayList;
                        size = size;
                    } else {
                        if (c3958e18 != null) {
                            C3956c[] c3956cArr6 = c3958e18.f13330G;
                            C3886i c3886i8 = c3956cArr6[i11].f13318g;
                            int i34 = i11 + 1;
                            C3886i c3886i9 = c3956cArr6[i34].f13318g;
                            C3886i c3886i10 = c3956cArr5[i11].f13318g;
                            C3886i c3886i11 = c3956cArr5[i34].f13318g;
                            C3880c c3880cM7776k = c3882e.m7776k();
                            c3880cM7776k.f13025b = 0.0f;
                            if (f4 == 0.0f || f5 == f10) {
                                c3880cM7776k.f13027d.mo7753h(c3886i8, 1.0f);
                                c3880cM7776k.f13027d.mo7753h(c3886i9, -1.0f);
                                c3880cM7776k.f13027d.mo7753h(c3886i11, 1.0f);
                                c3880cM7776k.f13027d.mo7753h(c3886i10, -1.0f);
                            } else if (f5 == 0.0f) {
                                c3880cM7776k.f13027d.mo7753h(c3886i8, 1.0f);
                                c3880cM7776k.f13027d.mo7753h(c3886i9, -1.0f);
                            } else if (f10 == 0.0f) {
                                c3880cM7776k.f13027d.mo7753h(c3886i10, 1.0f);
                                c3880cM7776k.f13027d.mo7753h(c3886i11, -1.0f);
                            } else {
                                float f11 = (f5 / f4) / (f10 / f4);
                                c3880cM7776k.f13027d.mo7753h(c3886i8, 1.0f);
                                c3880cM7776k.f13027d.mo7753h(c3886i9, -1.0f);
                                c3880cM7776k.f13027d.mo7753h(c3886i11, f11);
                                c3880cM7776k.f13027d.mo7753h(c3886i10, -f11);
                            }
                            c3882e.m7768c(c3880cM7776k);
                        }
                        f5 = f10;
                        c3958e18 = c3958e19;
                    }
                    i33++;
                    c3955b3 = c3955b3;
                    size = size;
                    arrayList = arrayList;
                }
            }
            C3955b c3955b4 = c3955b3;
            if (c3958e17 != null) {
                c3958e = c3958e17;
                if (c3958e == c3958e13 || z7) {
                    C3956c c3956c17 = c3958e16.f13330G[i11];
                    int i35 = i11 + 1;
                    C3956c c3956c18 = c3958e11.f13330G[i35];
                    C3956c c3956c19 = c3956c17.f13315d;
                    C3886i c3886i12 = c3956c19 != null ? c3956c19.f13318g : null;
                    C3956c c3956c20 = c3956c18.f13315d;
                    C3886i c3886i13 = c3956c20 != null ? c3956c20.f13318g : null;
                    C3956c c3956c21 = c3958e.f13330G[i11];
                    C3956c c3956c22 = c3958e13.f13330G[i35];
                    if (c3886i12 == null || c3886i13 == null) {
                        i12 = i12;
                    } else {
                        i12 = i12;
                        c3882e.m7767b(c3956c21.f13318g, c3886i12, c3956c21.m7887c(), i6 == 0 ? c3958e15.f13344U : c3958e15.f13345V, c3886i13, c3956c22.f13318g, c3956c22.m7887c(), 7);
                    }
                }
                if ((z10 || z11) && c3958e != null && c3958e != c3958e13) {
                    c3956cArr2 = c3958e.f13330G;
                    C3956c c3956c23 = c3956cArr2[i11];
                    i14 = i11 + 1;
                    c3956c = c3958e13.f13330G[i14];
                    c3956c2 = c3956c23.f13315d;
                    if (c3956c2 != null) {
                        c3886i = c3956c2.f13318g;
                    } else {
                        c3886i = null;
                    }
                    c3956c3 = c3956c.f13315d;
                    if (c3956c3 != null) {
                        c3886i2 = c3956c3.f13318g;
                    } else {
                        c3886i2 = null;
                    }
                    if (c3958e11 != c3958e13) {
                        C3956c c3956c24 = c3958e11.f13330G[i14].f13315d;
                        c3886i2 = c3956c24 != null ? c3956c24.f13318g : null;
                    }
                    if (c3958e == c3958e13) {
                        c3956c = c3956cArr2[i14];
                    }
                    if (c3886i == null && c3886i2 != null) {
                        c3882e.m7767b(c3956c23.f13318g, c3886i, c3956c23.m7887c(), 0.5f, c3886i2, c3956c.f13318g, c3958e13.f13330G[i14].m7887c(), 5);
                    }
                }
                i17 = i12 + 1;
                c3959f2 = c3959f;
                i10 = i13;
                c3955bArr = c3955bArr2;
            } else {
                c3958e = c3958e17;
            }
            if (!z10 || c3958e == null) {
                int i36 = 8;
                if (z11 && c3958e != null) {
                    int i37 = c3955b4.f13304j;
                    boolean z21 = i37 > 0 && c3955b4.f13303i == i37;
                    C3958e c3958e20 = c3958e;
                    C3958e c3958e21 = c3958e20;
                    while (c3958e20 != null) {
                        C3958e c3958e22 = c3958e20.f13357d0[i6];
                        while (c3958e22 != null && c3958e22.f13347X == i36) {
                            c3958e22 = c3958e22.f13357d0[i6];
                        }
                        if (c3958e20 == c3958e || c3958e20 == c3958e13 || c3958e22 == null) {
                            c3958e21 = c3958e21;
                            i15 = 8;
                        } else {
                            C3958e c3958e23 = c3958e22 == c3958e13 ? null : c3958e22;
                            C3956c[] c3956cArr7 = c3958e20.f13330G;
                            C3956c c3956c25 = c3956cArr7[i11];
                            C3886i c3886i14 = c3956c25.f13318g;
                            int i38 = i11 + 1;
                            C3886i c3886i15 = c3958e21.f13330G[i38].f13318g;
                            int iM7887c2 = c3956c25.m7887c();
                            int iM7887c3 = c3956cArr7[i38].m7887c();
                            if (c3958e23 != null) {
                                c3956c4 = c3958e23.f13330G[i11];
                                c3886i4 = c3956c4.f13318g;
                                C3956c c3956c26 = c3956c4.f13315d;
                                c3886i3 = c3956c26 != null ? c3956c26.f13318g : null;
                            } else {
                                C3956c c3956c27 = c3958e13.f13330G[i11];
                                C3886i c3886i16 = c3956c27 != null ? c3956c27.f13318g : null;
                                c3886i3 = c3956cArr7[i38].f13318g;
                                c3956c4 = c3956c27;
                                c3886i4 = c3886i16;
                            }
                            int iM7887c4 = c3956c4 != null ? c3956c4.m7887c() + iM7887c3 : iM7887c3;
                            int iM7887c5 = c3958e21.f13330G[i38].m7887c() + iM7887c2;
                            int i39 = z21 ? 8 : 4;
                            if (c3886i14 == null || c3886i15 == null || c3886i4 == null || c3886i3 == null) {
                                i15 = 8;
                            } else {
                                i15 = 8;
                                c3882e.m7767b(c3886i14, c3886i15, iM7887c5, 0.5f, c3886i4, c3886i3, iM7887c4, i39);
                            }
                            c3958e22 = c3958e23;
                        }
                        if (c3958e20.f13347X != i15) {
                            c3958e21 = c3958e20;
                        }
                        c3958e20 = c3958e22;
                        c3958e21 = c3958e21;
                        i36 = 8;
                    }
                    C3956c c3956c28 = c3958e.f13330G[i11];
                    C3956c c3956c29 = c3958e16.f13330G[i11].f13315d;
                    int i40 = i11 + 1;
                    C3956c c3956c30 = c3958e13.f13330G[i40];
                    C3956c c3956c31 = c3958e11.f13330G[i40].f13315d;
                    if (c3956c29 != null) {
                        if (c3958e != c3958e13) {
                            c3882e.m7770e(c3956c28.f13318g, c3956c29.f13318g, c3956c28.m7887c(), 5);
                        } else if (c3956c31 != null) {
                            c3882e.m7767b(c3956c28.f13318g, c3956c29.f13318g, c3956c28.m7887c(), 0.5f, c3956c30.f13318g, c3956c31.f13318g, c3956c30.m7887c(), 5);
                        }
                    }
                    if (c3956c31 != null && c3958e != c3958e13) {
                        c3882e.m7770e(c3956c30.f13318g, c3956c31.f13318g, -c3956c30.m7887c(), 5);
                    }
                }
            } else {
                int i41 = c3955b4.f13304j;
                boolean z22 = i41 > 0 && c3955b4.f13303i == i41;
                C3958e c3958e24 = c3958e;
                C3958e c3958e25 = c3958e24;
                while (c3958e25 != null) {
                    C3958e c3958e26 = c3958e25.f13357d0[i6];
                    while (c3958e26 != null && c3958e26.f13347X == 8) {
                        c3958e26 = c3958e26.f13357d0[i6];
                    }
                    if (c3958e26 != null || c3958e25 == c3958e13) {
                        C3956c[] c3956cArr8 = c3958e25.f13330G;
                        C3956c c3956c32 = c3956cArr8[i11];
                        C3886i c3886i17 = c3956c32.f13318g;
                        C3956c c3956c33 = c3956c32.f13315d;
                        C3886i c3886i18 = c3956c33 != null ? c3956c33.f13318g : null;
                        if (c3958e24 != c3958e25) {
                            c3886i18 = c3958e24.f13330G[i11 + 1].f13318g;
                        } else if (c3958e25 == c3958e && c3958e24 == c3958e25) {
                            C3956c c3956c34 = c3958e16.f13330G[i11].f13315d;
                            c3886i18 = c3956c34 != null ? c3956c34.f13318g : null;
                        }
                        int iM7887c6 = c3956c32.m7887c();
                        int i42 = i11 + 1;
                        int iM7887c7 = c3956cArr8[i42].m7887c();
                        if (c3958e26 != null) {
                            c3956c5 = c3958e26.f13330G[i11];
                            c3886i5 = c3956c5.f13318g;
                            c3886i6 = c3956cArr8[i42].f13318g;
                        } else {
                            c3956c5 = c3958e11.f13330G[i42].f13315d;
                            c3886i5 = c3956c5 != null ? c3956c5.f13318g : null;
                            c3886i6 = c3956cArr8[i42].f13318g;
                        }
                        C3886i c3886i19 = c3886i6;
                        if (c3956c5 != null) {
                            iM7887c7 = c3956c5.m7887c() + iM7887c7;
                        }
                        if (c3958e24 != null) {
                            iM7887c6 += c3958e24.f13330G[i42].m7887c();
                        }
                        if (c3886i17 != null && c3886i18 != null && c3886i5 != null && c3886i19 != null) {
                            int iM7887c8 = c3958e25 == c3958e ? c3958e.f13330G[i11].m7887c() : iM7887c6;
                            if (c3958e25 == c3958e13) {
                                iM7887c7 = c3958e13.f13330G[i42].m7887c();
                            }
                            c3882e.m7767b(c3886i17, c3886i18, iM7887c8, 0.5f, c3886i5, c3886i19, iM7887c7, z22 ? 8 : 5);
                        }
                    }
                    if (c3958e25.f13347X != 8) {
                        c3958e24 = c3958e25;
                    }
                    c3958e25 = c3958e26;
                    c3958e24 = c3958e24;
                    c3958e16 = c3958e16;
                }
            }
            if (z10) {
                c3956cArr2 = c3958e.f13330G;
                C3956c c3956c210 = c3956cArr2[i11];
                i14 = i11 + 1;
                c3956c = c3958e13.f13330G[i14];
                c3956c2 = c3956c210.f13315d;
                if (c3956c2 != null) {
                    c3886i = c3956c2.f13318g;
                } else {
                    c3886i = null;
                }
                c3956c3 = c3956c.f13315d;
                if (c3956c3 != null) {
                    c3886i2 = c3956c3.f13318g;
                } else {
                    c3886i2 = null;
                }
                if (c3958e11 != c3958e13) {
                    C3956c c3956c211 = c3958e11.f13330G[i14].f13315d;
                    c3886i2 = c3956c211 != null ? c3956c211.f13318g : null;
                }
                if (c3958e == c3958e13) {
                    c3956c = c3956cArr2[i14];
                }
                if (c3886i == null) {
                }
            } else {
                c3956cArr2 = c3958e.f13330G;
                C3956c c3956c212 = c3956cArr2[i11];
                i14 = i11 + 1;
                c3956c = c3958e13.f13330G[i14];
                c3956c2 = c3956c212.f13315d;
                if (c3956c2 != null) {
                    c3886i = c3956c2.f13318g;
                } else {
                    c3886i = null;
                }
                c3956c3 = c3956c.f13315d;
                if (c3956c3 != null) {
                    c3886i2 = c3956c3.f13318g;
                } else {
                    c3886i2 = null;
                }
                if (c3958e11 != c3958e13) {
                    C3956c c3956c213 = c3958e11.f13330G[i14].f13315d;
                    c3886i2 = c3956c213 != null ? c3956c213.f13318g : null;
                }
                if (c3958e == c3958e13) {
                    c3956c = c3956cArr2[i14];
                }
                if (c3886i == null) {
                }
            }
            i17 = i12 + 1;
            c3959f2 = c3959f;
            i10 = i13;
            c3955bArr = c3955bArr2;
        }
    }
}
