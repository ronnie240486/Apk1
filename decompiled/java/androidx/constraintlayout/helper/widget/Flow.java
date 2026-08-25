package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.widget.C0306b;
import androidx.constraintlayout.widget.C0307c;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.VirtualLayout;
import java.util.ArrayList;
import java.util.Arrays;
import p225v.C3956c;
import p225v.C3958e;
import p225v.C3959f;
import p225v.C3960g;
import p225v.C3961h;
import p225v.C3962i;
import p225v.C3963j;
import p225v.EnumC3957d;
import p236w.C4027b;
import p236w.InterfaceC4028c;
import p256y.AbstractC4193j;

public class Flow extends VirtualLayout {

    public C3961h f1169j;

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override
    public final void mo841g(AttributeSet attributeSet) {
        super.mo841g(attributeSet);
        this.f1169j = new C3961h();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, AbstractC4193j.f14236b);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i6 = 0; i6 < indexCount; i6++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i6);
                if (index == 0) {
                    this.f1169j.f13426L0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 1) {
                    C3961h c3961h = this.f1169j;
                    int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                    c3961h.f13433i0 = dimensionPixelSize;
                    c3961h.f13434j0 = dimensionPixelSize;
                    c3961h.f13435k0 = dimensionPixelSize;
                    c3961h.f13436l0 = dimensionPixelSize;
                } else if (index == 11) {
                    C3961h c3961h2 = this.f1169j;
                    int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                    c3961h2.f13435k0 = dimensionPixelSize2;
                    c3961h2.f13437m0 = dimensionPixelSize2;
                    c3961h2.f13438n0 = dimensionPixelSize2;
                } else if (index == 12) {
                    this.f1169j.f13436l0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 2) {
                    this.f1169j.f13437m0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 3) {
                    this.f1169j.f13433i0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 4) {
                    this.f1169j.f13438n0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 5) {
                    this.f1169j.f13434j0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 37) {
                    this.f1169j.f13424J0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 27) {
                    this.f1169j.f13444t0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 36) {
                    this.f1169j.f13445u0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 21) {
                    this.f1169j.f13446v0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 29) {
                    this.f1169j.f13448x0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 23) {
                    this.f1169j.f13447w0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 31) {
                    this.f1169j.f13449y0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 25) {
                    this.f1169j.f13450z0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 20) {
                    this.f1169j.f13416B0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 28) {
                    this.f1169j.f13418D0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 22) {
                    this.f1169j.f13417C0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 30) {
                    this.f1169j.f13419E0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 34) {
                    this.f1169j.f13415A0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 24) {
                    this.f1169j.f13422H0 = typedArrayObtainStyledAttributes.getInt(index, 2);
                } else if (index == 33) {
                    this.f1169j.f13423I0 = typedArrayObtainStyledAttributes.getInt(index, 2);
                } else if (index == 26) {
                    this.f1169j.f13420F0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 35) {
                    this.f1169j.f13421G0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 32) {
                    this.f1169j.f13425K0 = typedArrayObtainStyledAttributes.getInt(index, -1);
                }
            }
        }
        this.f1295d = this.f1169j;
        m876l();
    }

    @Override
    public final void mo842h(C0307c c0307c, C3963j c3963j, Constraints.LayoutParams layoutParams, SparseArray sparseArray) {
        super.mo842h(c0307c, c3963j, layoutParams, sparseArray);
        if (c3963j instanceof C3961h) {
            C3961h c3961h = (C3961h) c3963j;
            int i6 = layoutParams.f1332R;
            if (i6 != -1) {
                c3961h.f13426L0 = i6;
            }
        }
    }

    @Override
    public final void mo843i(C3958e c3958e, boolean z7) {
        C3961h c3961h = this.f1169j;
        int i6 = c3961h.f13435k0;
        if (i6 > 0 || c3961h.f13436l0 > 0) {
            if (z7) {
                c3961h.f13437m0 = c3961h.f13436l0;
                c3961h.f13438n0 = i6;
            } else {
                c3961h.f13437m0 = i6;
                c3961h.f13438n0 = c3961h.f13436l0;
            }
        }
    }

    @Override
    public final void mo844m(C3961h c3961h, int i6, int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        int[] iArr;
        int i15;
        int i16;
        int i17;
        C3958e[] c3958eArr;
        int i18;
        int i19;
        int i20;
        C3958e[] c3958eArr2;
        int i21;
        int i22;
        int i23;
        C3958e[] c3958eArr3;
        int i24;
        ArrayList arrayList;
        int i25;
        int i26;
        C3958e[] c3958eArr4;
        int i27;
        int i28;
        char c5;
        int i29;
        int i30;
        int i31;
        C3960g c3960g;
        int i32;
        char c8;
        int i33;
        int i34;
        int i35;
        int iMin;
        int iMin2;
        boolean z7;
        int i36;
        C3960g c3960g2;
        int i37;
        EnumC3957d enumC3957d;
        EnumC3957d enumC3957d2;
        EnumC3957d enumC3957d3;
        C3960g c3960g3;
        int i38;
        int i39;
        int i40;
        C3958e c3958e;
        int iM7931E;
        EnumC3957d enumC3957d4;
        boolean z10;
        EnumC3957d enumC3957d5;
        C3958e[] c3958eArr5;
        int i41;
        int size;
        int i42;
        int i43;
        int i44;
        int i45;
        EnumC3957d[] enumC3957dArr;
        EnumC3957d enumC3957d6;
        boolean z11;
        C3956c c3956c;
        C3956c c3956c2;
        C3956c c3956c3;
        C3956c c3956c4;
        C3956c c3956c5;
        C3956c c3956c6;
        int i46;
        int i47;
        int i48;
        C3956c c3956c7;
        C3960g c3960g4;
        int iM7927d;
        int iM7926c;
        int i49;
        C3960g c3960g5;
        C3960g c3960g6;
        int i50;
        int i51;
        C3958e c3958e2;
        int iM7932F;
        boolean z12;
        EnumC3957d enumC3957d7;
        EnumC3957d enumC3957d8;
        C3958e c3958e3;
        int i52;
        int i53;
        int i54;
        int iCeil;
        int iCeil2;
        int i55;
        int i56;
        int i57;
        C3958e c3958e4;
        int iM7931E2;
        boolean z13;
        C3958e[] c3958eArr6;
        Object obj;
        C3958e[] c3958eArr7;
        int i58;
        int i59;
        int iM7932F2;
        int i60;
        int iM7931E3;
        C3958e c3958e5;
        C3958e c3958e6;
        int i61;
        int i62;
        C3958e c3958e7;
        int i63;
        C3958e c3958e8;
        C3958e c3958e9;
        int i64;
        int i65;
        int i66;
        C3958e c3958e10;
        int iM7932F3;
        C3958e[] c3958eArr8;
        int i67;
        int i68;
        C3958e c3958e11;
        int mode = View.MeasureSpec.getMode(i6);
        int size2 = View.MeasureSpec.getSize(i6);
        int mode2 = View.MeasureSpec.getMode(i10);
        int size3 = View.MeasureSpec.getSize(i10);
        if (c3961h == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int i69 = c3961h.f13457h0;
        EnumC3957d enumC3957d9 = EnumC3957d.f13320b;
        EnumC3957d enumC3957d10 = EnumC3957d.f13321c;
        if (i69 <= 0) {
            i11 = c3961h.f13437m0;
            i12 = c3961h.f13438n0;
            i13 = c3961h.f13433i0;
            i14 = c3961h.f13434j0;
            iArr = new int[2];
            i15 = (size2 - i11) - i12;
            i16 = c3961h.f13426L0;
            if (i16 == 1) {
                i15 = (size3 - i13) - i14;
            }
            i17 = i15;
            if (i16 == 0) {
                if (c3961h.f13444t0 == -1) {
                    c3961h.f13444t0 = 0;
                }
                if (c3961h.f13445u0 == -1) {
                    c3961h.f13445u0 = 0;
                }
            } else {
                if (c3961h.f13444t0 == -1) {
                    c3961h.f13444t0 = 0;
                }
                if (c3961h.f13445u0 == -1) {
                    c3961h.f13445u0 = 0;
                }
            }
            c3958eArr = c3961h.f13456g0;
            i18 = 0;
            i19 = 0;
            while (true) {
                i20 = c3961h.f13457h0;
                c3958eArr2 = c3958eArr;
                if (i18 < i20) {
                    break;
                }
                if (c3961h.f13456g0[i18].f13347X == 8) {
                    i19++;
                }
                i18++;
                c3958eArr = c3958eArr2;
            }
            if (i19 > 0) {
                c3958eArr8 = new C3958e[i20 - i19];
                i67 = 0;
                i68 = 0;
                while (i67 < c3961h.f13457h0) {
                    c3958e11 = c3961h.f13456g0[i67];
                    int i70 = i14;
                    int i71 = i13;
                    if (c3958e11.f13347X != 8) {
                        c3958eArr8[i68] = c3958e11;
                        i68++;
                    }
                    i67++;
                    i14 = i70;
                    i13 = i71;
                }
                i21 = i14;
                i22 = i13;
                c3958eArr3 = c3958eArr8;
                i23 = i68;
            } else {
                i21 = i14;
                i22 = i13;
                i23 = i20;
                c3958eArr3 = c3958eArr2;
            }
            c3961h.f13431Q0 = c3958eArr3;
            c3961h.f13432R0 = i23;
            i24 = c3961h.f13424J0;
            arrayList = c3961h.f13427M0;
            if (i24 != 0) {
                iArr = iArr;
                i25 = i12;
                i26 = i11;
                mode = mode;
                size2 = size2;
                mode2 = mode2;
                c3958eArr4 = c3958eArr3;
                i27 = i21;
                i28 = i22;
                c5 = 1;
                i29 = i23;
                i30 = size3;
                i31 = c3961h.f13426L0;
                if (i29 == 0) {
                    c8 = 0;
                } else {
                    if (arrayList.size() == 0) {
                        c3960g = new C3960g(c3961h, i31, c3961h.f13380y, c3961h.f13381z, c3961h.f13324A, c3961h.f13325B, i17);
                        arrayList.add(c3960g);
                    } else {
                        c3960g = (C3960g) arrayList.get(0);
                        c3960g.f13399c = 0;
                        c3960g.f13398b = null;
                        c3960g.f13408l = 0;
                        c3960g.f13409m = 0;
                        c3960g.f13410n = 0;
                        c3960g.f13411o = 0;
                        c3960g.f13412p = 0;
                        c3960g.m7929f(i31, c3961h.f13380y, c3961h.f13381z, c3961h.f13324A, c3961h.f13325B, c3961h.f13437m0, c3961h.f13433i0, c3961h.f13438n0, c3961h.f13434j0, i17);
                    }
                    for (i32 = 0; i32 < i29; i32++) {
                        c3960g.m7924a(c3958eArr4[i32]);
                    }
                    c8 = 0;
                    iArr[0] = c3960g.m7927d();
                    iArr[1] = c3960g.m7926c();
                }
            } else if (i24 != 1) {
                if (i24 != 2) {
                    i25 = i12;
                    i26 = i11;
                    i30 = size3;
                } else {
                    i53 = c3961h.f13426L0;
                    if (i53 == 0) {
                        i64 = c3961h.f13425K0;
                        if (i64 <= 0) {
                            i65 = 0;
                            i66 = 0;
                            iCeil2 = 0;
                            while (true) {
                                if (i65 < i23) {
                                    i54 = i17;
                                    break;
                                }
                                if (i65 > 0) {
                                    i66 += c3961h.f13420F0;
                                }
                                c3958e10 = c3958eArr3[i65];
                                if (c3958e10 == null) {
                                    i54 = i17;
                                } else {
                                    i54 = i17;
                                    iM7932F3 = c3961h.m7932F(c3958e10, i54) + i66;
                                    if (iM7932F3 > i54) {
                                        break;
                                    }
                                    iCeil2++;
                                    i66 = iM7932F3;
                                }
                                i65++;
                                i17 = i54;
                            }
                        } else {
                            i54 = i17;
                            iCeil2 = i64;
                        }
                        iCeil = 0;
                    } else {
                        i54 = i17;
                        iCeil = c3961h.f13425K0;
                        if (iCeil <= 0) {
                            i56 = 0;
                            i57 = 0;
                            for (i55 = 0; i55 < i23; i55++) {
                                if (i55 > 0) {
                                    i56 += c3961h.f13421G0;
                                }
                                c3958e4 = c3958eArr3[i55];
                                if (c3958e4 != null) {
                                    iM7931E2 = c3961h.m7931E(c3958e4, i54) + i56;
                                    if (iM7931E2 > i54) {
                                        break;
                                    }
                                    i57++;
                                    i56 = iM7931E2;
                                }
                            }
                            iCeil = i57;
                        }
                        iCeil2 = 0;
                    }
                    if (c3961h.f13430P0 == null) {
                        c3961h.f13430P0 = new int[2];
                    }
                    z13 = (iCeil != 0 && i53 == 1) || (iCeil2 == 0 && i53 == 0);
                    while (!z13) {
                        if (i53 == 0) {
                            iCeil = (int) Math.ceil(i23 / iCeil2);
                        } else {
                            iCeil2 = (int) Math.ceil(i23 / iCeil);
                        }
                        c3958eArr6 = c3961h.f13429O0;
                        if (c3958eArr6 != null || c3958eArr6.length < iCeil2) {
                            obj = null;
                            c3961h.f13429O0 = new C3958e[iCeil2];
                        } else {
                            obj = null;
                            Arrays.fill(c3958eArr6, (Object) null);
                        }
                        c3958eArr7 = c3961h.f13428N0;
                        if (c3958eArr7 != null || c3958eArr7.length < iCeil) {
                            c3961h.f13428N0 = new C3958e[iCeil];
                        } else {
                            Arrays.fill(c3958eArr7, obj);
                        }
                        for (i58 = 0; i58 < iCeil2; i58++) {
                            i61 = 0;
                            while (i61 < iCeil) {
                                i62 = (i61 * iCeil2) + i58;
                                int i72 = i11;
                                if (i53 == 1) {
                                    i62 = (i58 * iCeil) + i61;
                                }
                                if (i62 >= c3958eArr3.length && (c3958e7 = c3958eArr3[i62]) != null) {
                                    int iM7932F4 = c3961h.m7932F(c3958e7, i54);
                                    i63 = size3;
                                    c3958e8 = c3961h.f13429O0[i58];
                                    if (c3958e8 != null || c3958e8.m7905m() < iM7932F4) {
                                        c3961h.f13429O0[i58] = c3958e7;
                                    }
                                    int iM7931E4 = c3961h.m7931E(c3958e7, i54);
                                    c3958e9 = c3961h.f13428N0[i61];
                                    if (c3958e9 != null || c3958e9.m7902j() < iM7931E4) {
                                        c3961h.f13428N0[i61] = c3958e7;
                                    }
                                } else {
                                    i63 = size3;
                                }
                                i61++;
                                i11 = i72;
                                size3 = i63;
                            }
                        }
                        int i73 = i11;
                        int i74 = size3;
                        iM7932F2 = 0;
                        for (i59 = 0; i59 < iCeil2; i59++) {
                            c3958e6 = c3961h.f13429O0[i59];
                            if (c3958e6 == null) {
                                if (i59 > 0) {
                                    iM7932F2 += c3961h.f13420F0;
                                }
                                iM7932F2 = c3961h.m7932F(c3958e6, i54) + iM7932F2;
                            }
                        }
                        iM7931E3 = 0;
                        for (i60 = 0; i60 < iCeil; i60++) {
                            c3958e5 = c3961h.f13428N0[i60];
                            if (c3958e5 == null) {
                                if (i60 > 0) {
                                    iM7931E3 += c3961h.f13421G0;
                                }
                                iM7931E3 = c3961h.m7931E(c3958e5, i54) + iM7931E3;
                            }
                        }
                        iArr[0] = iM7932F2;
                        iArr[1] = iM7931E3;
                        if (i53 == 0) {
                            if (iM7932F2 > i54 || iCeil2 <= 1) {
                                z13 = true;
                            } else {
                                iCeil2--;
                                z13 = z13;
                            }
                        } else if (iM7931E3 > i54 || iCeil <= 1) {
                            z13 = true;
                        } else {
                            iCeil--;
                            z13 = z13;
                        }
                        i12 = i12;
                        i11 = i73;
                        size3 = i74;
                    }
                    i30 = size3;
                    int[] iArr2 = c3961h.f13430P0;
                    iArr2[0] = iCeil2;
                    iArr2[1] = iCeil;
                    i25 = i12;
                    i26 = i11;
                }
                i27 = i21;
                i28 = i22;
                c8 = 0;
                c5 = 1;
            } else {
                i30 = size3;
                i36 = c3961h.f13426L0;
                if (i23 == 0) {
                    iArr = iArr;
                    mode = mode;
                    size2 = size2;
                    mode2 = mode2;
                    i25 = i12;
                    i26 = i11;
                    i27 = i21;
                    i28 = i22;
                    c5 = 1;
                } else {
                    arrayList.clear();
                    i37 = i23;
                    iArr = iArr;
                    i27 = i21;
                    mode2 = mode2;
                    i28 = i22;
                    i25 = i12;
                    i26 = i11;
                    size2 = size2;
                    c5 = 1;
                    mode = mode;
                    enumC3957d = enumC3957d10;
                    c3960g2 = new C3960g(c3961h, i36, c3961h.f13380y, c3961h.f13381z, c3961h.f13324A, c3961h.f13325B, i17);
                    arrayList.add(c3960g2);
                    if (i36 == 0) {
                        i38 = 0;
                        i50 = 0;
                        i51 = 0;
                        while (i51 < i37) {
                            c3958e2 = c3958eArr3[i51];
                            iM7932F = c3961h.m7932F(c3958e2, i17);
                            if (c3958e2.f13333J[0] == enumC3957d) {
                                c3960g6 = c3960g2;
                                i38++;
                            }
                            c3960g6 = c3960g2;
                            int i75 = i38;
                            z12 = (i50 != i17 || (c3961h.f13420F0 + i50) + iM7932F > i17) && c3960g6.f13398b != null;
                            if (!z12 && i51 > 0 && (i52 = c3961h.f13425K0) > 0 && i51 % i52 == 0) {
                                z12 = true;
                            }
                            if (z12) {
                                enumC3957d8 = enumC3957d9;
                                enumC3957d7 = enumC3957d;
                                c3958e3 = c3958e2;
                                C3960g c3960g7 = new C3960g(c3961h, i36, c3961h.f13380y, c3961h.f13381z, c3961h.f13324A, c3961h.f13325B, i17);
                                c3960g7.f13410n = i51;
                                arrayList.add(c3960g7);
                                c3960g6 = c3960g7;
                            } else {
                                enumC3957d7 = enumC3957d;
                                enumC3957d8 = enumC3957d9;
                                c3958e3 = c3958e2;
                                if (i51 > 0) {
                                    i50 = c3961h.f13420F0 + iM7932F + i50;
                                }
                                c3960g6.m7924a(c3958e3);
                                i51++;
                                enumC3957d9 = enumC3957d8;
                                i38 = i75;
                                enumC3957d = enumC3957d7;
                            }
                            i50 = iM7932F;
                            c3960g6.m7924a(c3958e3);
                            i51++;
                            enumC3957d9 = enumC3957d8;
                            i38 = i75;
                            enumC3957d = enumC3957d7;
                        }
                        c3960g6 = c3960g2;
                        enumC3957d3 = enumC3957d9;
                    } else {
                        enumC3957d2 = enumC3957d;
                        enumC3957d3 = enumC3957d9;
                        i38 = 0;
                        i39 = 0;
                        i40 = 0;
                        while (i40 < i37) {
                            c3958e = c3958eArr3[i40];
                            iM7931E = c3961h.m7931E(c3958e, i17);
                            enumC3957d4 = enumC3957d2;
                            if (c3958e.f13333J[1] == enumC3957d4) {
                                c3960g3 = c3960g2;
                                i38++;
                            }
                            c3960g3 = c3960g2;
                            int i76 = i38;
                            z10 = (i39 != i17 || (c3961h.f13421G0 + i39) + iM7931E > i17) && c3960g3.f13398b != null;
                            if (!z10 && i40 > 0 && (i41 = c3961h.f13425K0) > 0 && i40 % i41 == 0) {
                                z10 = true;
                            }
                            if (z10) {
                                c3958eArr5 = c3958eArr3;
                                enumC3957d5 = enumC3957d4;
                                C3960g c3960g8 = new C3960g(c3961h, i36, c3961h.f13380y, c3961h.f13381z, c3961h.f13324A, c3961h.f13325B, i17);
                                c3960g8.f13410n = i40;
                                arrayList.add(c3960g8);
                                c3960g3 = c3960g8;
                            } else {
                                enumC3957d5 = enumC3957d4;
                                c3958eArr5 = c3958eArr3;
                                if (i40 > 0) {
                                    i39 = c3961h.f13421G0 + iM7931E + i39;
                                }
                                c3960g3.m7924a(c3958e);
                                i40++;
                                c3958eArr3 = c3958eArr5;
                                i38 = i76;
                                enumC3957d2 = enumC3957d5;
                            }
                            i39 = iM7931E;
                            c3960g3.m7924a(c3958e);
                            i40++;
                            c3958eArr3 = c3958eArr5;
                            i38 = i76;
                            enumC3957d2 = enumC3957d5;
                        }
                        c3960g3 = c3960g2;
                    }
                    size = arrayList.size();
                    i42 = c3961h.f13437m0;
                    i43 = c3961h.f13433i0;
                    i44 = c3961h.f13438n0;
                    i45 = c3961h.f13434j0;
                    enumC3957dArr = c3961h.f13333J;
                    enumC3957d6 = enumC3957d3;
                    if (enumC3957dArr[0] != enumC3957d6 || enumC3957dArr[1] == enumC3957d6) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (i38 > 0 && z11) {
                        for (i49 = 0; i49 < size; i49++) {
                            c3960g5 = (C3960g) arrayList.get(i49);
                            if (i36 == 0) {
                                c3960g5.m7928e(i17 - c3960g5.m7927d());
                            } else {
                                c3960g5.m7928e(i17 - c3960g5.m7926c());
                            }
                        }
                    }
                    c3956c = c3961h.f13325B;
                    c3956c2 = c3961h.f13324A;
                    c3956c3 = c3961h.f13380y;
                    c3956c4 = c3961h.f13381z;
                    c3956c5 = c3956c;
                    c3956c6 = c3956c2;
                    i46 = 0;
                    i47 = 0;
                    i48 = 0;
                    while (i46 < size) {
                        c3956c7 = c3956c;
                        c3960g4 = (C3960g) arrayList.get(i46);
                        if (i36 == 0) {
                            if (i46 < size - 1) {
                                c3956c5 = ((C3960g) arrayList.get(i46 + 1)).f13398b.f13381z;
                                i45 = 0;
                            } else {
                                i45 = c3961h.f13434j0;
                                c3956c5 = c3956c7;
                            }
                            C3956c c3956c8 = c3960g4.f13398b.f13325B;
                            c3960g4.m7929f(i36, c3956c3, c3956c4, c3956c6, c3956c5, i42, i43, i44, i45, i17);
                            int iMax = Math.max(i47, c3960g4.m7927d());
                            iM7926c = c3960g4.m7926c() + i48;
                            if (i46 > 0) {
                                iM7926c += c3961h.f13421G0;
                            }
                            i48 = iM7926c;
                            i47 = iMax;
                            c3956c4 = c3956c8;
                            i43 = 0;
                        } else {
                            c3956c2 = c3956c2;
                            if (i46 < size - 1) {
                                c3956c6 = ((C3960g) arrayList.get(i46 + 1)).f13398b.f13380y;
                                i44 = 0;
                            } else {
                                i44 = c3961h.f13438n0;
                                c3956c6 = c3956c2;
                            }
                            C3956c c3956c9 = c3960g4.f13398b.f13324A;
                            c3960g4.m7929f(i36, c3956c3, c3956c4, c3956c6, c3956c5, i42, i43, i44, i45, i17);
                            iM7927d = c3960g4.m7927d() + i47;
                            int iMax2 = Math.max(i48, c3960g4.m7926c());
                            if (i46 > 0) {
                                iM7927d += c3961h.f13420F0;
                            }
                            i48 = iMax2;
                            i47 = iM7927d;
                            c3956c3 = c3956c9;
                            i42 = 0;
                        }
                        i46++;
                        c3956c = c3956c7;
                        c3956c2 = c3956c2;
                    }
                    iArr[0] = i47;
                    iArr[1] = i48;
                }
                c8 = 0;
            }
            i33 = iArr[c8] + i26 + i25;
            i34 = iArr[c5] + i28 + i27;
            i35 = mode;
            if (i35 == 1073741824) {
                iMin = size2;
            } else if (i35 == Integer.MIN_VALUE) {
                iMin = Math.min(i33, size2);
            } else if (i35 == 0) {
                iMin = i33;
            } else {
                iMin = 0;
            }
            if (mode2 == 1073741824) {
                iMin2 = i30;
            } else if (mode2 == -2147483648) {
                iMin2 = Math.min(i34, i30);
            } else if (mode2 == 0) {
                iMin2 = i34;
            } else {
                iMin2 = 0;
            }
            c3961h.f13440p0 = iMin;
            c3961h.f13441q0 = iMin2;
            c3961h.m7918z(iMin);
            c3961h.m7915w(iMin2);
            if (c3961h.f13457h0 > 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            c3961h.f13439o0 = z7;
        } else {
            C3958e c3958e12 = c3961h.f13334K;
            InterfaceC4028c interfaceC4028c = c3958e12 != null ? ((C3959f) c3958e12).f13385j0 : null;
            if (interfaceC4028c == null) {
                c3961h.f13440p0 = 0;
                c3961h.f13441q0 = 0;
                c3961h.f13439o0 = false;
            } else {
                for (int i77 = 0; i77 < c3961h.f13457h0; i77++) {
                    C3958e c3958e13 = c3961h.f13456g0[i77];
                    if (c3958e13 != null && !(c3958e13 instanceof C3962i)) {
                        EnumC3957d enumC3957dM7901i = c3958e13.m7901i(0);
                        EnumC3957d enumC3957dM7901i2 = c3958e13.m7901i(1);
                        if (enumC3957dM7901i != enumC3957d10 || c3958e13.f13365j == 1 || enumC3957dM7901i2 != enumC3957d10 || c3958e13.f13366k == 1) {
                            if (enumC3957dM7901i == enumC3957d10) {
                                enumC3957dM7901i = enumC3957d9;
                            }
                            if (enumC3957dM7901i2 == enumC3957d10) {
                                enumC3957dM7901i2 = enumC3957d9;
                            }
                            C4027b c4027b = c3961h.f13442r0;
                            c4027b.f13643a = enumC3957dM7901i;
                            c4027b.f13644b = enumC3957dM7901i2;
                            c4027b.f13645c = c3958e13.m7905m();
                            c4027b.f13646d = c3958e13.m7902j();
                            ((C0306b) interfaceC4028c).m886a(c3958e13, c4027b);
                            c3958e13.m7918z(c4027b.f13647e);
                            c3958e13.m7915w(c4027b.f13648f);
                            int i78 = c4027b.f13649g;
                            c3958e13.f13341R = i78;
                            c3958e13.f13378w = i78 > 0;
                        }
                    }
                }
                i11 = c3961h.f13437m0;
                i12 = c3961h.f13438n0;
                i13 = c3961h.f13433i0;
                i14 = c3961h.f13434j0;
                iArr = new int[2];
                i15 = (size2 - i11) - i12;
                i16 = c3961h.f13426L0;
                if (i16 == 1) {
                    i15 = (size3 - i13) - i14;
                }
                i17 = i15;
                if (i16 == 0) {
                    if (c3961h.f13444t0 == -1) {
                        c3961h.f13444t0 = 0;
                    }
                    if (c3961h.f13445u0 == -1) {
                        c3961h.f13445u0 = 0;
                    }
                } else {
                    if (c3961h.f13444t0 == -1) {
                        c3961h.f13444t0 = 0;
                    }
                    if (c3961h.f13445u0 == -1) {
                        c3961h.f13445u0 = 0;
                    }
                }
                c3958eArr = c3961h.f13456g0;
                i18 = 0;
                i19 = 0;
                while (true) {
                    i20 = c3961h.f13457h0;
                    c3958eArr2 = c3958eArr;
                    if (i18 < i20) {
                        break;
                        break;
                    }
                    if (c3961h.f13456g0[i18].f13347X == 8) {
                        i19++;
                    }
                    i18++;
                    c3958eArr = c3958eArr2;
                }
                if (i19 > 0) {
                    c3958eArr8 = new C3958e[i20 - i19];
                    i67 = 0;
                    i68 = 0;
                    while (i67 < c3961h.f13457h0) {
                        c3958e11 = c3961h.f13456g0[i67];
                        int i79 = i14;
                        int i710 = i13;
                        if (c3958e11.f13347X != 8) {
                            c3958eArr8[i68] = c3958e11;
                            i68++;
                        }
                        i67++;
                        i14 = i79;
                        i13 = i710;
                    }
                    i21 = i14;
                    i22 = i13;
                    c3958eArr3 = c3958eArr8;
                    i23 = i68;
                } else {
                    i21 = i14;
                    i22 = i13;
                    i23 = i20;
                    c3958eArr3 = c3958eArr2;
                }
                c3961h.f13431Q0 = c3958eArr3;
                c3961h.f13432R0 = i23;
                i24 = c3961h.f13424J0;
                arrayList = c3961h.f13427M0;
                if (i24 != 0) {
                    iArr = iArr;
                    i25 = i12;
                    i26 = i11;
                    mode = mode;
                    size2 = size2;
                    mode2 = mode2;
                    c3958eArr4 = c3958eArr3;
                    i27 = i21;
                    i28 = i22;
                    c5 = 1;
                    i29 = i23;
                    i30 = size3;
                    i31 = c3961h.f13426L0;
                    if (i29 == 0) {
                        c8 = 0;
                    } else {
                        if (arrayList.size() == 0) {
                            c3960g = new C3960g(c3961h, i31, c3961h.f13380y, c3961h.f13381z, c3961h.f13324A, c3961h.f13325B, i17);
                            arrayList.add(c3960g);
                        } else {
                            c3960g = (C3960g) arrayList.get(0);
                            c3960g.f13399c = 0;
                            c3960g.f13398b = null;
                            c3960g.f13408l = 0;
                            c3960g.f13409m = 0;
                            c3960g.f13410n = 0;
                            c3960g.f13411o = 0;
                            c3960g.f13412p = 0;
                            c3960g.m7929f(i31, c3961h.f13380y, c3961h.f13381z, c3961h.f13324A, c3961h.f13325B, c3961h.f13437m0, c3961h.f13433i0, c3961h.f13438n0, c3961h.f13434j0, i17);
                        }
                        while (i32 < i29) {
                            c3960g.m7924a(c3958eArr4[i32]);
                        }
                        c8 = 0;
                        iArr[0] = c3960g.m7927d();
                        iArr[1] = c3960g.m7926c();
                    }
                } else if (i24 != 1) {
                    if (i24 != 2) {
                        i25 = i12;
                        i26 = i11;
                        i30 = size3;
                    } else {
                        i53 = c3961h.f13426L0;
                        if (i53 == 0) {
                            i64 = c3961h.f13425K0;
                            if (i64 <= 0) {
                                i65 = 0;
                                i66 = 0;
                                iCeil2 = 0;
                                while (true) {
                                    if (i65 < i23) {
                                        i54 = i17;
                                        break;
                                    }
                                    if (i65 > 0) {
                                        i66 += c3961h.f13420F0;
                                    }
                                    c3958e10 = c3958eArr3[i65];
                                    if (c3958e10 == null) {
                                        i54 = i17;
                                    } else {
                                        i54 = i17;
                                        iM7932F3 = c3961h.m7932F(c3958e10, i54) + i66;
                                        if (iM7932F3 > i54) {
                                            break;
                                            break;
                                        } else {
                                            iCeil2++;
                                            i66 = iM7932F3;
                                        }
                                    }
                                    i65++;
                                    i17 = i54;
                                }
                            } else {
                                i54 = i17;
                                iCeil2 = i64;
                            }
                            iCeil = 0;
                        } else {
                            i54 = i17;
                            iCeil = c3961h.f13425K0;
                            if (iCeil <= 0) {
                                i56 = 0;
                                i57 = 0;
                                while (i55 < i23) {
                                    if (i55 > 0) {
                                        i56 += c3961h.f13421G0;
                                    }
                                    c3958e4 = c3958eArr3[i55];
                                    if (c3958e4 != null) {
                                        iM7931E2 = c3961h.m7931E(c3958e4, i54) + i56;
                                        if (iM7931E2 > i54) {
                                            break;
                                            break;
                                        } else {
                                            i57++;
                                            i56 = iM7931E2;
                                        }
                                    }
                                }
                                iCeil = i57;
                            }
                            iCeil2 = 0;
                        }
                        if (c3961h.f13430P0 == null) {
                            c3961h.f13430P0 = new int[2];
                        }
                        if (iCeil != 0) {
                        }
                        while (!z13) {
                            if (i53 == 0) {
                                iCeil = (int) Math.ceil(i23 / iCeil2);
                            } else {
                                iCeil2 = (int) Math.ceil(i23 / iCeil);
                            }
                            c3958eArr6 = c3961h.f13429O0;
                            if (c3958eArr6 != null) {
                                obj = null;
                                c3961h.f13429O0 = new C3958e[iCeil2];
                            } else {
                                obj = null;
                                c3961h.f13429O0 = new C3958e[iCeil2];
                            }
                            c3958eArr7 = c3961h.f13428N0;
                            if (c3958eArr7 != null) {
                                c3961h.f13428N0 = new C3958e[iCeil];
                            } else {
                                c3961h.f13428N0 = new C3958e[iCeil];
                            }
                            while (i58 < iCeil2) {
                                i61 = 0;
                                while (i61 < iCeil) {
                                    i62 = (i61 * iCeil2) + i58;
                                    int i711 = i11;
                                    if (i53 == 1) {
                                        i62 = (i58 * iCeil) + i61;
                                    }
                                    if (i62 >= c3958eArr3.length) {
                                        i63 = size3;
                                    } else {
                                        int iM7932F5 = c3961h.m7932F(c3958e7, i54);
                                        i63 = size3;
                                        c3958e8 = c3961h.f13429O0[i58];
                                        if (c3958e8 != null) {
                                            c3961h.f13429O0[i58] = c3958e7;
                                        } else {
                                            c3961h.f13429O0[i58] = c3958e7;
                                        }
                                        int iM7931E5 = c3961h.m7931E(c3958e7, i54);
                                        c3958e9 = c3961h.f13428N0[i61];
                                        if (c3958e9 != null) {
                                            c3961h.f13428N0[i61] = c3958e7;
                                        } else {
                                            c3961h.f13428N0[i61] = c3958e7;
                                        }
                                    }
                                    i61++;
                                    i11 = i711;
                                    size3 = i63;
                                }
                            }
                            int i712 = i11;
                            int i713 = size3;
                            iM7932F2 = 0;
                            while (i59 < iCeil2) {
                                c3958e6 = c3961h.f13429O0[i59];
                                if (c3958e6 == null) {
                                    if (i59 > 0) {
                                        iM7932F2 += c3961h.f13420F0;
                                    }
                                    iM7932F2 = c3961h.m7932F(c3958e6, i54) + iM7932F2;
                                }
                            }
                            iM7931E3 = 0;
                            while (i60 < iCeil) {
                                c3958e5 = c3961h.f13428N0[i60];
                                if (c3958e5 == null) {
                                    if (i60 > 0) {
                                        iM7931E3 += c3961h.f13421G0;
                                    }
                                    iM7931E3 = c3961h.m7931E(c3958e5, i54) + iM7931E3;
                                }
                            }
                            iArr[0] = iM7932F2;
                            iArr[1] = iM7931E3;
                            if (i53 == 0) {
                                if (iM7932F2 > i54) {
                                }
                                z13 = true;
                            } else {
                                if (iM7931E3 > i54) {
                                }
                                z13 = true;
                            }
                            i12 = i12;
                            i11 = i712;
                            size3 = i713;
                        }
                        i30 = size3;
                        int[] iArr3 = c3961h.f13430P0;
                        iArr3[0] = iCeil2;
                        iArr3[1] = iCeil;
                        i25 = i12;
                        i26 = i11;
                    }
                    i27 = i21;
                    i28 = i22;
                    c8 = 0;
                    c5 = 1;
                } else {
                    i30 = size3;
                    i36 = c3961h.f13426L0;
                    if (i23 == 0) {
                        iArr = iArr;
                        mode = mode;
                        size2 = size2;
                        mode2 = mode2;
                        i25 = i12;
                        i26 = i11;
                        i27 = i21;
                        i28 = i22;
                        c5 = 1;
                    } else {
                        arrayList.clear();
                        i37 = i23;
                        iArr = iArr;
                        i27 = i21;
                        mode2 = mode2;
                        i28 = i22;
                        i25 = i12;
                        i26 = i11;
                        size2 = size2;
                        c5 = 1;
                        mode = mode;
                        enumC3957d = enumC3957d10;
                        c3960g2 = new C3960g(c3961h, i36, c3961h.f13380y, c3961h.f13381z, c3961h.f13324A, c3961h.f13325B, i17);
                        arrayList.add(c3960g2);
                        if (i36 == 0) {
                            i38 = 0;
                            i50 = 0;
                            i51 = 0;
                            while (i51 < i37) {
                                c3958e2 = c3958eArr3[i51];
                                iM7932F = c3961h.m7932F(c3958e2, i17);
                                if (c3958e2.f13333J[0] == enumC3957d) {
                                    c3960g6 = c3960g2;
                                    i38++;
                                }
                                c3960g6 = c3960g2;
                                int i714 = i38;
                                if (i50 != i17) {
                                }
                                if (!z12) {
                                    z12 = true;
                                }
                                if (z12) {
                                    enumC3957d8 = enumC3957d9;
                                    enumC3957d7 = enumC3957d;
                                    c3958e3 = c3958e2;
                                    C3960g c3960g9 = new C3960g(c3961h, i36, c3961h.f13380y, c3961h.f13381z, c3961h.f13324A, c3961h.f13325B, i17);
                                    c3960g9.f13410n = i51;
                                    arrayList.add(c3960g9);
                                    c3960g6 = c3960g9;
                                } else {
                                    enumC3957d7 = enumC3957d;
                                    enumC3957d8 = enumC3957d9;
                                    c3958e3 = c3958e2;
                                    if (i51 > 0) {
                                        i50 = c3961h.f13420F0 + iM7932F + i50;
                                    }
                                    c3960g6.m7924a(c3958e3);
                                    i51++;
                                    enumC3957d9 = enumC3957d8;
                                    i38 = i714;
                                    enumC3957d = enumC3957d7;
                                }
                                i50 = iM7932F;
                                c3960g6.m7924a(c3958e3);
                                i51++;
                                enumC3957d9 = enumC3957d8;
                                i38 = i714;
                                enumC3957d = enumC3957d7;
                            }
                            c3960g6 = c3960g2;
                            enumC3957d3 = enumC3957d9;
                        } else {
                            enumC3957d2 = enumC3957d;
                            enumC3957d3 = enumC3957d9;
                            i38 = 0;
                            i39 = 0;
                            i40 = 0;
                            while (i40 < i37) {
                                c3958e = c3958eArr3[i40];
                                iM7931E = c3961h.m7931E(c3958e, i17);
                                enumC3957d4 = enumC3957d2;
                                if (c3958e.f13333J[1] == enumC3957d4) {
                                    c3960g3 = c3960g2;
                                    i38++;
                                }
                                c3960g3 = c3960g2;
                                int i715 = i38;
                                if (i39 != i17) {
                                }
                                if (!z10) {
                                    z10 = true;
                                }
                                if (z10) {
                                    c3958eArr5 = c3958eArr3;
                                    enumC3957d5 = enumC3957d4;
                                    C3960g c3960g10 = new C3960g(c3961h, i36, c3961h.f13380y, c3961h.f13381z, c3961h.f13324A, c3961h.f13325B, i17);
                                    c3960g10.f13410n = i40;
                                    arrayList.add(c3960g10);
                                    c3960g3 = c3960g10;
                                } else {
                                    enumC3957d5 = enumC3957d4;
                                    c3958eArr5 = c3958eArr3;
                                    if (i40 > 0) {
                                        i39 = c3961h.f13421G0 + iM7931E + i39;
                                    }
                                    c3960g3.m7924a(c3958e);
                                    i40++;
                                    c3958eArr3 = c3958eArr5;
                                    i38 = i715;
                                    enumC3957d2 = enumC3957d5;
                                }
                                i39 = iM7931E;
                                c3960g3.m7924a(c3958e);
                                i40++;
                                c3958eArr3 = c3958eArr5;
                                i38 = i715;
                                enumC3957d2 = enumC3957d5;
                            }
                            c3960g3 = c3960g2;
                        }
                        size = arrayList.size();
                        i42 = c3961h.f13437m0;
                        i43 = c3961h.f13433i0;
                        i44 = c3961h.f13438n0;
                        i45 = c3961h.f13434j0;
                        enumC3957dArr = c3961h.f13333J;
                        enumC3957d6 = enumC3957d3;
                        if (enumC3957dArr[0] != enumC3957d6) {
                            z11 = true;
                        } else {
                            z11 = true;
                        }
                        if (i38 > 0) {
                            while (i49 < size) {
                                c3960g5 = (C3960g) arrayList.get(i49);
                                if (i36 == 0) {
                                    c3960g5.m7928e(i17 - c3960g5.m7927d());
                                } else {
                                    c3960g5.m7928e(i17 - c3960g5.m7926c());
                                }
                            }
                        }
                        c3956c = c3961h.f13325B;
                        c3956c2 = c3961h.f13324A;
                        c3956c3 = c3961h.f13380y;
                        c3956c4 = c3961h.f13381z;
                        c3956c5 = c3956c;
                        c3956c6 = c3956c2;
                        i46 = 0;
                        i47 = 0;
                        i48 = 0;
                        while (i46 < size) {
                            c3956c7 = c3956c;
                            c3960g4 = (C3960g) arrayList.get(i46);
                            if (i36 == 0) {
                                if (i46 < size - 1) {
                                    c3956c5 = ((C3960g) arrayList.get(i46 + 1)).f13398b.f13381z;
                                    i45 = 0;
                                } else {
                                    i45 = c3961h.f13434j0;
                                    c3956c5 = c3956c7;
                                }
                                C3956c c3956c10 = c3960g4.f13398b.f13325B;
                                c3960g4.m7929f(i36, c3956c3, c3956c4, c3956c6, c3956c5, i42, i43, i44, i45, i17);
                                int iMax3 = Math.max(i47, c3960g4.m7927d());
                                iM7926c = c3960g4.m7926c() + i48;
                                if (i46 > 0) {
                                    iM7926c += c3961h.f13421G0;
                                }
                                i48 = iM7926c;
                                i47 = iMax3;
                                c3956c4 = c3956c10;
                                i43 = 0;
                            } else {
                                c3956c2 = c3956c2;
                                if (i46 < size - 1) {
                                    c3956c6 = ((C3960g) arrayList.get(i46 + 1)).f13398b.f13380y;
                                    i44 = 0;
                                } else {
                                    i44 = c3961h.f13438n0;
                                    c3956c6 = c3956c2;
                                }
                                C3956c c3956c11 = c3960g4.f13398b.f13324A;
                                c3960g4.m7929f(i36, c3956c3, c3956c4, c3956c6, c3956c5, i42, i43, i44, i45, i17);
                                iM7927d = c3960g4.m7927d() + i47;
                                int iMax4 = Math.max(i48, c3960g4.m7926c());
                                if (i46 > 0) {
                                    iM7927d += c3961h.f13420F0;
                                }
                                i48 = iMax4;
                                i47 = iM7927d;
                                c3956c3 = c3956c11;
                                i42 = 0;
                            }
                            i46++;
                            c3956c = c3956c7;
                            c3956c2 = c3956c2;
                        }
                        iArr[0] = i47;
                        iArr[1] = i48;
                    }
                    c8 = 0;
                }
                i33 = iArr[c8] + i26 + i25;
                i34 = iArr[c5] + i28 + i27;
                i35 = mode;
                if (i35 == 1073741824) {
                    iMin = size2;
                } else if (i35 == Integer.MIN_VALUE) {
                    iMin = Math.min(i33, size2);
                } else if (i35 == 0) {
                    iMin = i33;
                } else {
                    iMin = 0;
                }
                if (mode2 == 1073741824) {
                    iMin2 = i30;
                } else if (mode2 == -2147483648) {
                    iMin2 = Math.min(i34, i30);
                } else if (mode2 == 0) {
                    iMin2 = i34;
                } else {
                    iMin2 = 0;
                }
                c3961h.f13440p0 = iMin;
                c3961h.f13441q0 = iMin2;
                c3961h.m7918z(iMin);
                c3961h.m7915w(iMin2);
                if (c3961h.f13457h0 > 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                c3961h.f13439o0 = z7;
            }
        }
        setMeasuredDimension(c3961h.f13440p0, c3961h.f13441q0);
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        mo844m(this.f1169j, i6, i10);
    }

    public void setFirstHorizontalBias(float f) {
        this.f1169j.f13416B0 = f;
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i6) {
        this.f1169j.f13446v0 = i6;
        requestLayout();
    }

    public void setFirstVerticalBias(float f) {
        this.f1169j.f13417C0 = f;
        requestLayout();
    }

    public void setFirstVerticalStyle(int i6) {
        this.f1169j.f13447w0 = i6;
        requestLayout();
    }

    public void setHorizontalAlign(int i6) {
        this.f1169j.f13422H0 = i6;
        requestLayout();
    }

    public void setHorizontalBias(float f) {
        this.f1169j.f13450z0 = f;
        requestLayout();
    }

    public void setHorizontalGap(int i6) {
        this.f1169j.f13420F0 = i6;
        requestLayout();
    }

    public void setHorizontalStyle(int i6) {
        this.f1169j.f13444t0 = i6;
        requestLayout();
    }

    public void setMaxElementsWrap(int i6) {
        this.f1169j.f13425K0 = i6;
        requestLayout();
    }

    public void setOrientation(int i6) {
        this.f1169j.f13426L0 = i6;
        requestLayout();
    }

    public void setPadding(int i6) {
        C3961h c3961h = this.f1169j;
        c3961h.f13433i0 = i6;
        c3961h.f13434j0 = i6;
        c3961h.f13435k0 = i6;
        c3961h.f13436l0 = i6;
        requestLayout();
    }

    public void setPaddingBottom(int i6) {
        this.f1169j.f13434j0 = i6;
        requestLayout();
    }

    public void setPaddingLeft(int i6) {
        this.f1169j.f13437m0 = i6;
        requestLayout();
    }

    public void setPaddingRight(int i6) {
        this.f1169j.f13438n0 = i6;
        requestLayout();
    }

    public void setPaddingTop(int i6) {
        this.f1169j.f13433i0 = i6;
        requestLayout();
    }

    public void setVerticalAlign(int i6) {
        this.f1169j.f13423I0 = i6;
        requestLayout();
    }

    public void setVerticalBias(float f) {
        this.f1169j.f13415A0 = f;
        requestLayout();
    }

    public void setVerticalGap(int i6) {
        this.f1169j.f13421G0 = i6;
        requestLayout();
    }

    public void setVerticalStyle(int i6) {
        this.f1169j.f13445u0 = i6;
        requestLayout();
    }

    public void setWrapMode(int i6) {
        this.f1169j.f13424J0 = i6;
        requestLayout();
    }

    public Flow(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
    }
}
