package androidx.constraintlayout.widget;

import android.view.View;
import android.view.ViewGroup;
import p225v.C3956c;
import p225v.C3958e;
import p225v.C3961h;
import p225v.EnumC3957d;
import p236w.C4027b;
import p236w.InterfaceC4028c;

public final class C0306b implements InterfaceC4028c {

    public final ConstraintLayout f1399a;

    public int f1400b;

    public int f1401c;

    public int f1402d;

    public int f1403e;

    public int f1404f;

    public int f1405g;

    public C0306b(ConstraintLayout constraintLayout) {
        this.f1399a = constraintLayout;
    }

    public final void m886a(C3958e c3958e, C4027b c4027b) {
        int iMakeMeasureSpec;
        int iMakeMeasureSpec2;
        boolean z7;
        int iOrdinal;
        int iMakeMeasureSpec3;
        boolean z10;
        EnumC3957d enumC3957d;
        boolean z11;
        boolean z12;
        EnumC3957d enumC3957d2;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        ConstraintLayout.LayoutParams layoutParams;
        int measuredWidth;
        int measuredHeight;
        int i6;
        int i10;
        int iMin;
        int i11;
        int i12;
        int measuredHeight2;
        int i13;
        int i14;
        int i15;
        int baseline;
        boolean z17;
        boolean z18;
        boolean z19;
        int i16;
        int childMeasureSpec;
        if (c3958e == null) {
            return;
        }
        if (c3958e.f13347X == 8 && !c3958e.f13379x) {
            c4027b.f13647e = 0;
            c4027b.f13648f = 0;
            c4027b.f13649g = 0;
            return;
        }
        EnumC3957d enumC3957d3 = c4027b.f13643a;
        EnumC3957d enumC3957d4 = c4027b.f13644b;
        int i17 = c4027b.f13645c;
        int i18 = c4027b.f13646d;
        int i19 = this.f1400b + this.f1401c;
        int i20 = this.f1402d;
        View view = c3958e.f13346W;
        int iOrdinal2 = enumC3957d3.ordinal();
        C3956c c3956c = c3958e.f13324A;
        C3956c c3956c2 = c3958e.f13380y;
        int[] iArr = c3958e.f13362g;
        if (iOrdinal2 != 0) {
            if (iOrdinal2 != 1) {
                if (iOrdinal2 == 2) {
                    childMeasureSpec = ViewGroup.getChildMeasureSpec(this.f1404f, i20, -2);
                    boolean z20 = c3958e.f13365j == 1;
                    iArr[2] = 0;
                    if (c4027b.f13652j) {
                        boolean z21 = !(!z20 || iArr[3] == 0 || iArr[0] == c3958e.m7905m()) || (view instanceof Placeholder);
                        if (!z20 || z21) {
                            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(c3958e.m7905m(), 1073741824);
                        }
                    }
                } else if (iOrdinal2 != 3) {
                    z7 = false;
                    iMakeMeasureSpec2 = 0;
                } else {
                    int i21 = this.f1404f;
                    int i22 = c3956c2 != null ? c3956c2.f13316e : 0;
                    if (c3956c != null) {
                        i22 += c3956c.f13316e;
                    }
                    iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(i21, i20 + i22, -1);
                    iArr[2] = -1;
                    z7 = false;
                }
                iOrdinal = enumC3957d4.ordinal();
                if (iOrdinal != 0) {
                    if (iOrdinal == 1) {
                        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f1405g, i19, -2);
                        iArr[3] = -2;
                        iMakeMeasureSpec3 = childMeasureSpec2;
                    } else {
                        if (iOrdinal != 2) {
                            if (iOrdinal != 3) {
                                z10 = false;
                                iMakeMeasureSpec3 = 0;
                            } else {
                                int i23 = this.f1405g;
                                if (c3956c2 != null) {
                                    i16 = c3958e.f13381z.f13316e;
                                } else {
                                    i16 = 0;
                                }
                                if (c3956c != null) {
                                    i16 += c3958e.f13325B.f13316e;
                                }
                                int childMeasureSpec3 = ViewGroup.getChildMeasureSpec(i23, i19 + i16, -1);
                                iArr[3] = -1;
                                iMakeMeasureSpec3 = childMeasureSpec3;
                            }
                            enumC3957d = EnumC3957d.f13321c;
                            if (enumC3957d3 == enumC3957d) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (enumC3957d4 == enumC3957d) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            enumC3957d2 = EnumC3957d.f13322d;
                            EnumC3957d enumC3957d5 = EnumC3957d.f13319a;
                            if (enumC3957d4 != enumC3957d2 || enumC3957d4 == enumC3957d5) {
                                z13 = true;
                            } else {
                                z13 = false;
                            }
                            if (enumC3957d3 != enumC3957d2 || enumC3957d3 == enumC3957d5) {
                                z14 = true;
                            } else {
                                z14 = false;
                            }
                            if (z11 || c3958e.f13337N <= 0.0f) {
                                z15 = false;
                            } else {
                                z15 = true;
                            }
                            if (z12 || c3958e.f13337N <= 0.0f) {
                                z16 = false;
                            } else {
                                z16 = true;
                            }
                            layoutParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();
                            if (c4027b.f13652j && z11 && c3958e.f13365j == 0 && z12 && c3958e.f13366k == 0) {
                                i15 = -1;
                                iMin = 0;
                                baseline = 0;
                                measuredHeight2 = 0;
                            } else {
                                if ((view instanceof VirtualLayout) || !(c3958e instanceof C3961h)) {
                                    view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                                } else {
                                    ((VirtualLayout) view).mo844m((C3961h) c3958e, iMakeMeasureSpec2, iMakeMeasureSpec3);
                                }
                                measuredWidth = view.getMeasuredWidth();
                                measuredHeight = view.getMeasuredHeight();
                                int baseline2 = view.getBaseline();
                                if (z7) {
                                    i6 = 0;
                                    iArr[0] = measuredWidth;
                                    iArr[2] = measuredHeight;
                                } else {
                                    i6 = 0;
                                    iArr[0] = 0;
                                    iArr[2] = 0;
                                }
                                if (z10) {
                                    iArr[1] = measuredHeight;
                                    iArr[3] = measuredWidth;
                                } else {
                                    iArr[1] = i6;
                                    iArr[3] = i6;
                                }
                                i10 = c3958e.f13368m;
                                if (i10 > 0) {
                                    iMin = Math.max(i10, measuredWidth);
                                } else {
                                    iMin = measuredWidth;
                                }
                                i11 = c3958e.f13369n;
                                if (i11 > 0) {
                                    iMin = Math.min(i11, iMin);
                                }
                                i12 = c3958e.f13371p;
                                if (i12 > 0) {
                                    measuredHeight2 = Math.max(i12, measuredHeight);
                                } else {
                                    measuredHeight2 = measuredHeight;
                                }
                                i13 = c3958e.f13372q;
                                if (i13 > 0) {
                                    measuredHeight2 = Math.min(i13, measuredHeight2);
                                }
                                if (!z15 && z13) {
                                    iMin = (int) ((measuredHeight2 * c3958e.f13337N) + 0.5f);
                                } else if (z16 && z14) {
                                    measuredHeight2 = (int) ((iMin / c3958e.f13337N) + 0.5f);
                                }
                                if (measuredWidth == iMin || measuredHeight != measuredHeight2) {
                                    if (measuredWidth != iMin) {
                                        i14 = 1073741824;
                                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                                    } else {
                                        i14 = 1073741824;
                                    }
                                    if (measuredHeight != measuredHeight2) {
                                        iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredHeight2, i14);
                                    }
                                    view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                                    int measuredWidth2 = view.getMeasuredWidth();
                                    measuredHeight2 = view.getMeasuredHeight();
                                    iMin = measuredWidth2;
                                    i15 = -1;
                                    baseline = view.getBaseline();
                                } else {
                                    baseline = baseline2;
                                    i15 = -1;
                                }
                            }
                            if (baseline != i15) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (iMin == c4027b.f13645c || measuredHeight2 != c4027b.f13646d) {
                                z18 = true;
                            } else {
                                z18 = false;
                            }
                            c4027b.f13651i = z18;
                            if (layoutParams.f1338X) {
                                z17 = true;
                            }
                            if (z17 && baseline != -1 && c3958e.f13341R != baseline) {
                                c4027b.f13651i = true;
                            }
                            c4027b.f13647e = iMin;
                            c4027b.f13648f = measuredHeight2;
                            c4027b.f13650h = z17;
                            c4027b.f13649g = baseline;
                        }
                        iMakeMeasureSpec3 = ViewGroup.getChildMeasureSpec(this.f1405g, i19, -2);
                        if (c3958e.f13366k == 1) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        iArr[3] = 0;
                        if (c4027b.f13652j) {
                            boolean z22 = !(z19 || iArr[2] == 0 || iArr[1] == c3958e.m7902j()) || (view instanceof Placeholder);
                            if (z19 || z22) {
                                iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(c3958e.m7902j(), 1073741824);
                            }
                        }
                    }
                    z10 = true;
                    enumC3957d = EnumC3957d.f13321c;
                    if (enumC3957d3 == enumC3957d) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (enumC3957d4 == enumC3957d) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    enumC3957d2 = EnumC3957d.f13322d;
                    EnumC3957d enumC3957d6 = EnumC3957d.f13319a;
                    if (enumC3957d4 != enumC3957d2) {
                        z13 = true;
                    } else {
                        z13 = true;
                    }
                    if (enumC3957d3 != enumC3957d2) {
                        z14 = true;
                    } else {
                        z14 = true;
                    }
                    if (z11) {
                        z15 = false;
                    } else {
                        z15 = false;
                    }
                    if (z12) {
                        z16 = false;
                    } else {
                        z16 = false;
                    }
                    layoutParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();
                    if (c4027b.f13652j) {
                        if (view instanceof VirtualLayout) {
                            view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                        } else {
                            view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                        }
                        measuredWidth = view.getMeasuredWidth();
                        measuredHeight = view.getMeasuredHeight();
                        int baseline3 = view.getBaseline();
                        if (z7) {
                            i6 = 0;
                            iArr[0] = measuredWidth;
                            iArr[2] = measuredHeight;
                        } else {
                            i6 = 0;
                            iArr[0] = 0;
                            iArr[2] = 0;
                        }
                        if (z10) {
                            iArr[1] = measuredHeight;
                            iArr[3] = measuredWidth;
                        } else {
                            iArr[1] = i6;
                            iArr[3] = i6;
                        }
                        i10 = c3958e.f13368m;
                        if (i10 > 0) {
                            iMin = Math.max(i10, measuredWidth);
                        } else {
                            iMin = measuredWidth;
                        }
                        i11 = c3958e.f13369n;
                        if (i11 > 0) {
                            iMin = Math.min(i11, iMin);
                        }
                        i12 = c3958e.f13371p;
                        if (i12 > 0) {
                            measuredHeight2 = Math.max(i12, measuredHeight);
                        } else {
                            measuredHeight2 = measuredHeight;
                        }
                        i13 = c3958e.f13372q;
                        if (i13 > 0) {
                            measuredHeight2 = Math.min(i13, measuredHeight2);
                        }
                        if (!z15) {
                            if (z16) {
                                measuredHeight2 = (int) ((iMin / c3958e.f13337N) + 0.5f);
                            }
                        } else if (z16) {
                            measuredHeight2 = (int) ((iMin / c3958e.f13337N) + 0.5f);
                        }
                        if (measuredWidth == iMin) {
                            if (measuredWidth != iMin) {
                                i14 = 1073741824;
                                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                            } else {
                                i14 = 1073741824;
                            }
                            if (measuredHeight != measuredHeight2) {
                                iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredHeight2, i14);
                            }
                            view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                            int measuredWidth3 = view.getMeasuredWidth();
                            measuredHeight2 = view.getMeasuredHeight();
                            iMin = measuredWidth3;
                            i15 = -1;
                            baseline = view.getBaseline();
                        } else {
                            if (measuredWidth != iMin) {
                                i14 = 1073741824;
                                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                            } else {
                                i14 = 1073741824;
                            }
                            if (measuredHeight != measuredHeight2) {
                                iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredHeight2, i14);
                            }
                            view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                            int measuredWidth4 = view.getMeasuredWidth();
                            measuredHeight2 = view.getMeasuredHeight();
                            iMin = measuredWidth4;
                            i15 = -1;
                            baseline = view.getBaseline();
                        }
                    } else {
                        if (view instanceof VirtualLayout) {
                            view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                        } else {
                            view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                        }
                        measuredWidth = view.getMeasuredWidth();
                        measuredHeight = view.getMeasuredHeight();
                        int baseline4 = view.getBaseline();
                        if (z7) {
                            i6 = 0;
                            iArr[0] = measuredWidth;
                            iArr[2] = measuredHeight;
                        } else {
                            i6 = 0;
                            iArr[0] = 0;
                            iArr[2] = 0;
                        }
                        if (z10) {
                            iArr[1] = measuredHeight;
                            iArr[3] = measuredWidth;
                        } else {
                            iArr[1] = i6;
                            iArr[3] = i6;
                        }
                        i10 = c3958e.f13368m;
                        if (i10 > 0) {
                            iMin = Math.max(i10, measuredWidth);
                        } else {
                            iMin = measuredWidth;
                        }
                        i11 = c3958e.f13369n;
                        if (i11 > 0) {
                            iMin = Math.min(i11, iMin);
                        }
                        i12 = c3958e.f13371p;
                        if (i12 > 0) {
                            measuredHeight2 = Math.max(i12, measuredHeight);
                        } else {
                            measuredHeight2 = measuredHeight;
                        }
                        i13 = c3958e.f13372q;
                        if (i13 > 0) {
                            measuredHeight2 = Math.min(i13, measuredHeight2);
                        }
                        if (!z15) {
                            if (z16) {
                                measuredHeight2 = (int) ((iMin / c3958e.f13337N) + 0.5f);
                            }
                        } else if (z16) {
                            measuredHeight2 = (int) ((iMin / c3958e.f13337N) + 0.5f);
                        }
                        if (measuredWidth == iMin) {
                            if (measuredWidth != iMin) {
                                i14 = 1073741824;
                                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                            } else {
                                i14 = 1073741824;
                            }
                            if (measuredHeight != measuredHeight2) {
                                iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredHeight2, i14);
                            }
                            view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                            int measuredWidth5 = view.getMeasuredWidth();
                            measuredHeight2 = view.getMeasuredHeight();
                            iMin = measuredWidth5;
                            i15 = -1;
                            baseline = view.getBaseline();
                        } else {
                            if (measuredWidth != iMin) {
                                i14 = 1073741824;
                                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                            } else {
                                i14 = 1073741824;
                            }
                            if (measuredHeight != measuredHeight2) {
                                iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredHeight2, i14);
                            }
                            view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                            int measuredWidth6 = view.getMeasuredWidth();
                            measuredHeight2 = view.getMeasuredHeight();
                            iMin = measuredWidth6;
                            i15 = -1;
                            baseline = view.getBaseline();
                        }
                    }
                    if (baseline != i15) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (iMin == c4027b.f13645c) {
                        z18 = true;
                    } else {
                        z18 = true;
                    }
                    c4027b.f13651i = z18;
                    if (layoutParams.f1338X) {
                        z17 = true;
                    }
                    if (z17) {
                        c4027b.f13651i = true;
                    }
                    c4027b.f13647e = iMin;
                    c4027b.f13648f = measuredHeight2;
                    c4027b.f13650h = z17;
                    c4027b.f13649g = baseline;
                }
                iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(i18, 1073741824);
                iArr[3] = i18;
                z10 = false;
                enumC3957d = EnumC3957d.f13321c;
                if (enumC3957d3 == enumC3957d) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (enumC3957d4 == enumC3957d) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                enumC3957d2 = EnumC3957d.f13322d;
                EnumC3957d enumC3957d7 = EnumC3957d.f13319a;
                if (enumC3957d4 != enumC3957d2) {
                    z13 = true;
                } else {
                    z13 = true;
                }
                if (enumC3957d3 != enumC3957d2) {
                    z14 = true;
                } else {
                    z14 = true;
                }
                if (z11) {
                    z15 = false;
                } else {
                    z15 = false;
                }
                if (z12) {
                    z16 = false;
                } else {
                    z16 = false;
                }
                layoutParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();
                if (c4027b.f13652j) {
                    if (view instanceof VirtualLayout) {
                        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                    } else {
                        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                    }
                    measuredWidth = view.getMeasuredWidth();
                    measuredHeight = view.getMeasuredHeight();
                    int baseline5 = view.getBaseline();
                    if (z7) {
                        i6 = 0;
                        iArr[0] = measuredWidth;
                        iArr[2] = measuredHeight;
                    } else {
                        i6 = 0;
                        iArr[0] = 0;
                        iArr[2] = 0;
                    }
                    if (z10) {
                        iArr[1] = measuredHeight;
                        iArr[3] = measuredWidth;
                    } else {
                        iArr[1] = i6;
                        iArr[3] = i6;
                    }
                    i10 = c3958e.f13368m;
                    if (i10 > 0) {
                        iMin = Math.max(i10, measuredWidth);
                    } else {
                        iMin = measuredWidth;
                    }
                    i11 = c3958e.f13369n;
                    if (i11 > 0) {
                        iMin = Math.min(i11, iMin);
                    }
                    i12 = c3958e.f13371p;
                    if (i12 > 0) {
                        measuredHeight2 = Math.max(i12, measuredHeight);
                    } else {
                        measuredHeight2 = measuredHeight;
                    }
                    i13 = c3958e.f13372q;
                    if (i13 > 0) {
                        measuredHeight2 = Math.min(i13, measuredHeight2);
                    }
                    if (!z15) {
                        if (z16) {
                            measuredHeight2 = (int) ((iMin / c3958e.f13337N) + 0.5f);
                        }
                    } else if (z16) {
                        measuredHeight2 = (int) ((iMin / c3958e.f13337N) + 0.5f);
                    }
                    if (measuredWidth == iMin) {
                        if (measuredWidth != iMin) {
                            i14 = 1073741824;
                            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                        } else {
                            i14 = 1073741824;
                        }
                        if (measuredHeight != measuredHeight2) {
                            iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredHeight2, i14);
                        }
                        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                        int measuredWidth7 = view.getMeasuredWidth();
                        measuredHeight2 = view.getMeasuredHeight();
                        iMin = measuredWidth7;
                        i15 = -1;
                        baseline = view.getBaseline();
                    } else {
                        if (measuredWidth != iMin) {
                            i14 = 1073741824;
                            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                        } else {
                            i14 = 1073741824;
                        }
                        if (measuredHeight != measuredHeight2) {
                            iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredHeight2, i14);
                        }
                        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                        int measuredWidth8 = view.getMeasuredWidth();
                        measuredHeight2 = view.getMeasuredHeight();
                        iMin = measuredWidth8;
                        i15 = -1;
                        baseline = view.getBaseline();
                    }
                } else {
                    if (view instanceof VirtualLayout) {
                        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                    } else {
                        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                    }
                    measuredWidth = view.getMeasuredWidth();
                    measuredHeight = view.getMeasuredHeight();
                    int baseline6 = view.getBaseline();
                    if (z7) {
                        i6 = 0;
                        iArr[0] = measuredWidth;
                        iArr[2] = measuredHeight;
                    } else {
                        i6 = 0;
                        iArr[0] = 0;
                        iArr[2] = 0;
                    }
                    if (z10) {
                        iArr[1] = measuredHeight;
                        iArr[3] = measuredWidth;
                    } else {
                        iArr[1] = i6;
                        iArr[3] = i6;
                    }
                    i10 = c3958e.f13368m;
                    if (i10 > 0) {
                        iMin = Math.max(i10, measuredWidth);
                    } else {
                        iMin = measuredWidth;
                    }
                    i11 = c3958e.f13369n;
                    if (i11 > 0) {
                        iMin = Math.min(i11, iMin);
                    }
                    i12 = c3958e.f13371p;
                    if (i12 > 0) {
                        measuredHeight2 = Math.max(i12, measuredHeight);
                    } else {
                        measuredHeight2 = measuredHeight;
                    }
                    i13 = c3958e.f13372q;
                    if (i13 > 0) {
                        measuredHeight2 = Math.min(i13, measuredHeight2);
                    }
                    if (!z15) {
                        if (z16) {
                            measuredHeight2 = (int) ((iMin / c3958e.f13337N) + 0.5f);
                        }
                    } else if (z16) {
                        measuredHeight2 = (int) ((iMin / c3958e.f13337N) + 0.5f);
                    }
                    if (measuredWidth == iMin) {
                        if (measuredWidth != iMin) {
                            i14 = 1073741824;
                            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                        } else {
                            i14 = 1073741824;
                        }
                        if (measuredHeight != measuredHeight2) {
                            iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredHeight2, i14);
                        }
                        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                        int measuredWidth9 = view.getMeasuredWidth();
                        measuredHeight2 = view.getMeasuredHeight();
                        iMin = measuredWidth9;
                        i15 = -1;
                        baseline = view.getBaseline();
                    } else {
                        if (measuredWidth != iMin) {
                            i14 = 1073741824;
                            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                        } else {
                            i14 = 1073741824;
                        }
                        if (measuredHeight != measuredHeight2) {
                            iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredHeight2, i14);
                        }
                        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                        int measuredWidth10 = view.getMeasuredWidth();
                        measuredHeight2 = view.getMeasuredHeight();
                        iMin = measuredWidth10;
                        i15 = -1;
                        baseline = view.getBaseline();
                    }
                }
                if (baseline != i15) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (iMin == c4027b.f13645c) {
                    z18 = true;
                } else {
                    z18 = true;
                }
                c4027b.f13651i = z18;
                if (layoutParams.f1338X) {
                    z17 = true;
                }
                if (z17) {
                    c4027b.f13651i = true;
                }
                c4027b.f13647e = iMin;
                c4027b.f13648f = measuredHeight2;
                c4027b.f13650h = z17;
                c4027b.f13649g = baseline;
            }
            childMeasureSpec = ViewGroup.getChildMeasureSpec(this.f1404f, i20, -2);
            iArr[2] = -2;
            iMakeMeasureSpec2 = childMeasureSpec;
            z7 = true;
            iOrdinal = enumC3957d4.ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal == 1) {
                    int childMeasureSpec4 = ViewGroup.getChildMeasureSpec(this.f1405g, i19, -2);
                    iArr[3] = -2;
                    iMakeMeasureSpec3 = childMeasureSpec4;
                } else {
                    if (iOrdinal != 2) {
                        if (iOrdinal != 3) {
                            z10 = false;
                            iMakeMeasureSpec3 = 0;
                        } else {
                            int i24 = this.f1405g;
                            if (c3956c2 != null) {
                                i16 = c3958e.f13381z.f13316e;
                            } else {
                                i16 = 0;
                            }
                            if (c3956c != null) {
                                i16 += c3958e.f13325B.f13316e;
                            }
                            int childMeasureSpec5 = ViewGroup.getChildMeasureSpec(i24, i19 + i16, -1);
                            iArr[3] = -1;
                            iMakeMeasureSpec3 = childMeasureSpec5;
                        }
                        enumC3957d = EnumC3957d.f13321c;
                        if (enumC3957d3 == enumC3957d) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (enumC3957d4 == enumC3957d) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        enumC3957d2 = EnumC3957d.f13322d;
                        EnumC3957d enumC3957d8 = EnumC3957d.f13319a;
                        if (enumC3957d4 != enumC3957d2) {
                            z13 = true;
                        } else {
                            z13 = true;
                        }
                        if (enumC3957d3 != enumC3957d2) {
                            z14 = true;
                        } else {
                            z14 = true;
                        }
                        if (z11) {
                            z15 = false;
                        } else {
                            z15 = false;
                        }
                        if (z12) {
                            z16 = false;
                        } else {
                            z16 = false;
                        }
                        layoutParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();
                        if (c4027b.f13652j) {
                            if (view instanceof VirtualLayout) {
                                view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                            } else {
                                view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                            }
                            measuredWidth = view.getMeasuredWidth();
                            measuredHeight = view.getMeasuredHeight();
                            int baseline7 = view.getBaseline();
                            if (z7) {
                                i6 = 0;
                                iArr[0] = measuredWidth;
                                iArr[2] = measuredHeight;
                            } else {
                                i6 = 0;
                                iArr[0] = 0;
                                iArr[2] = 0;
                            }
                            if (z10) {
                                iArr[1] = measuredHeight;
                                iArr[3] = measuredWidth;
                            } else {
                                iArr[1] = i6;
                                iArr[3] = i6;
                            }
                            i10 = c3958e.f13368m;
                            if (i10 > 0) {
                                iMin = Math.max(i10, measuredWidth);
                            } else {
                                iMin = measuredWidth;
                            }
                            i11 = c3958e.f13369n;
                            if (i11 > 0) {
                                iMin = Math.min(i11, iMin);
                            }
                            i12 = c3958e.f13371p;
                            if (i12 > 0) {
                                measuredHeight2 = Math.max(i12, measuredHeight);
                            } else {
                                measuredHeight2 = measuredHeight;
                            }
                            i13 = c3958e.f13372q;
                            if (i13 > 0) {
                                measuredHeight2 = Math.min(i13, measuredHeight2);
                            }
                            if (!z15) {
                                if (z16) {
                                    measuredHeight2 = (int) ((iMin / c3958e.f13337N) + 0.5f);
                                }
                            } else if (z16) {
                                measuredHeight2 = (int) ((iMin / c3958e.f13337N) + 0.5f);
                            }
                            if (measuredWidth == iMin) {
                                if (measuredWidth != iMin) {
                                    i14 = 1073741824;
                                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                                } else {
                                    i14 = 1073741824;
                                }
                                if (measuredHeight != measuredHeight2) {
                                    iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredHeight2, i14);
                                }
                                view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                                int measuredWidth11 = view.getMeasuredWidth();
                                measuredHeight2 = view.getMeasuredHeight();
                                iMin = measuredWidth11;
                                i15 = -1;
                                baseline = view.getBaseline();
                            } else {
                                if (measuredWidth != iMin) {
                                    i14 = 1073741824;
                                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                                } else {
                                    i14 = 1073741824;
                                }
                                if (measuredHeight != measuredHeight2) {
                                    iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredHeight2, i14);
                                }
                                view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                                int measuredWidth12 = view.getMeasuredWidth();
                                measuredHeight2 = view.getMeasuredHeight();
                                iMin = measuredWidth12;
                                i15 = -1;
                                baseline = view.getBaseline();
                            }
                        } else {
                            if (view instanceof VirtualLayout) {
                                view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                            } else {
                                view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                            }
                            measuredWidth = view.getMeasuredWidth();
                            measuredHeight = view.getMeasuredHeight();
                            int baseline8 = view.getBaseline();
                            if (z7) {
                                i6 = 0;
                                iArr[0] = measuredWidth;
                                iArr[2] = measuredHeight;
                            } else {
                                i6 = 0;
                                iArr[0] = 0;
                                iArr[2] = 0;
                            }
                            if (z10) {
                                iArr[1] = measuredHeight;
                                iArr[3] = measuredWidth;
                            } else {
                                iArr[1] = i6;
                                iArr[3] = i6;
                            }
                            i10 = c3958e.f13368m;
                            if (i10 > 0) {
                                iMin = Math.max(i10, measuredWidth);
                            } else {
                                iMin = measuredWidth;
                            }
                            i11 = c3958e.f13369n;
                            if (i11 > 0) {
                                iMin = Math.min(i11, iMin);
                            }
                            i12 = c3958e.f13371p;
                            if (i12 > 0) {
                                measuredHeight2 = Math.max(i12, measuredHeight);
                            } else {
                                measuredHeight2 = measuredHeight;
                            }
                            i13 = c3958e.f13372q;
                            if (i13 > 0) {
                                measuredHeight2 = Math.min(i13, measuredHeight2);
                            }
                            if (!z15) {
                                if (z16) {
                                    measuredHeight2 = (int) ((iMin / c3958e.f13337N) + 0.5f);
                                }
                            } else if (z16) {
                                measuredHeight2 = (int) ((iMin / c3958e.f13337N) + 0.5f);
                            }
                            if (measuredWidth == iMin) {
                                if (measuredWidth != iMin) {
                                    i14 = 1073741824;
                                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                                } else {
                                    i14 = 1073741824;
                                }
                                if (measuredHeight != measuredHeight2) {
                                    iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredHeight2, i14);
                                }
                                view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                                int measuredWidth13 = view.getMeasuredWidth();
                                measuredHeight2 = view.getMeasuredHeight();
                                iMin = measuredWidth13;
                                i15 = -1;
                                baseline = view.getBaseline();
                            } else {
                                if (measuredWidth != iMin) {
                                    i14 = 1073741824;
                                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                                } else {
                                    i14 = 1073741824;
                                }
                                if (measuredHeight != measuredHeight2) {
                                    iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredHeight2, i14);
                                }
                                view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                                int measuredWidth14 = view.getMeasuredWidth();
                                measuredHeight2 = view.getMeasuredHeight();
                                iMin = measuredWidth14;
                                i15 = -1;
                                baseline = view.getBaseline();
                            }
                        }
                        if (baseline != i15) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (iMin == c4027b.f13645c) {
                            z18 = true;
                        } else {
                            z18 = true;
                        }
                        c4027b.f13651i = z18;
                        if (layoutParams.f1338X) {
                            z17 = true;
                        }
                        if (z17) {
                            c4027b.f13651i = true;
                        }
                        c4027b.f13647e = iMin;
                        c4027b.f13648f = measuredHeight2;
                        c4027b.f13650h = z17;
                        c4027b.f13649g = baseline;
                    }
                    iMakeMeasureSpec3 = ViewGroup.getChildMeasureSpec(this.f1405g, i19, -2);
                    if (c3958e.f13366k == 1) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    iArr[3] = 0;
                    if (c4027b.f13652j) {
                        if (z19) {
                        }
                        if (z19) {
                        }
                        iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(c3958e.m7902j(), 1073741824);
                    }
                }
                z10 = true;
                enumC3957d = EnumC3957d.f13321c;
                if (enumC3957d3 == enumC3957d) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (enumC3957d4 == enumC3957d) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                enumC3957d2 = EnumC3957d.f13322d;
                EnumC3957d enumC3957d9 = EnumC3957d.f13319a;
                if (enumC3957d4 != enumC3957d2) {
                    z13 = true;
                } else {
                    z13 = true;
                }
                if (enumC3957d3 != enumC3957d2) {
                    z14 = true;
                } else {
                    z14 = true;
                }
                if (z11) {
                    z15 = false;
                } else {
                    z15 = false;
                }
                if (z12) {
                    z16 = false;
                } else {
                    z16 = false;
                }
                layoutParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();
                if (c4027b.f13652j) {
                    if (view instanceof VirtualLayout) {
                        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                    } else {
                        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                    }
                    measuredWidth = view.getMeasuredWidth();
                    measuredHeight = view.getMeasuredHeight();
                    int baseline9 = view.getBaseline();
                    if (z7) {
                        i6 = 0;
                        iArr[0] = measuredWidth;
                        iArr[2] = measuredHeight;
                    } else {
                        i6 = 0;
                        iArr[0] = 0;
                        iArr[2] = 0;
                    }
                    if (z10) {
                        iArr[1] = measuredHeight;
                        iArr[3] = measuredWidth;
                    } else {
                        iArr[1] = i6;
                        iArr[3] = i6;
                    }
                    i10 = c3958e.f13368m;
                    if (i10 > 0) {
                        iMin = Math.max(i10, measuredWidth);
                    } else {
                        iMin = measuredWidth;
                    }
                    i11 = c3958e.f13369n;
                    if (i11 > 0) {
                        iMin = Math.min(i11, iMin);
                    }
                    i12 = c3958e.f13371p;
                    if (i12 > 0) {
                        measuredHeight2 = Math.max(i12, measuredHeight);
                    } else {
                        measuredHeight2 = measuredHeight;
                    }
                    i13 = c3958e.f13372q;
                    if (i13 > 0) {
                        measuredHeight2 = Math.min(i13, measuredHeight2);
                    }
                    if (!z15) {
                        if (z16) {
                            measuredHeight2 = (int) ((iMin / c3958e.f13337N) + 0.5f);
                        }
                    } else if (z16) {
                        measuredHeight2 = (int) ((iMin / c3958e.f13337N) + 0.5f);
                    }
                    if (measuredWidth == iMin) {
                        if (measuredWidth != iMin) {
                            i14 = 1073741824;
                            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                        } else {
                            i14 = 1073741824;
                        }
                        if (measuredHeight != measuredHeight2) {
                            iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredHeight2, i14);
                        }
                        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                        int measuredWidth15 = view.getMeasuredWidth();
                        measuredHeight2 = view.getMeasuredHeight();
                        iMin = measuredWidth15;
                        i15 = -1;
                        baseline = view.getBaseline();
                    } else {
                        if (measuredWidth != iMin) {
                            i14 = 1073741824;
                            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                        } else {
                            i14 = 1073741824;
                        }
                        if (measuredHeight != measuredHeight2) {
                            iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredHeight2, i14);
                        }
                        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                        int measuredWidth16 = view.getMeasuredWidth();
                        measuredHeight2 = view.getMeasuredHeight();
                        iMin = measuredWidth16;
                        i15 = -1;
                        baseline = view.getBaseline();
                    }
                } else {
                    if (view instanceof VirtualLayout) {
                        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                    } else {
                        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                    }
                    measuredWidth = view.getMeasuredWidth();
                    measuredHeight = view.getMeasuredHeight();
                    int baseline10 = view.getBaseline();
                    if (z7) {
                        i6 = 0;
                        iArr[0] = measuredWidth;
                        iArr[2] = measuredHeight;
                    } else {
                        i6 = 0;
                        iArr[0] = 0;
                        iArr[2] = 0;
                    }
                    if (z10) {
                        iArr[1] = measuredHeight;
                        iArr[3] = measuredWidth;
                    } else {
                        iArr[1] = i6;
                        iArr[3] = i6;
                    }
                    i10 = c3958e.f13368m;
                    if (i10 > 0) {
                        iMin = Math.max(i10, measuredWidth);
                    } else {
                        iMin = measuredWidth;
                    }
                    i11 = c3958e.f13369n;
                    if (i11 > 0) {
                        iMin = Math.min(i11, iMin);
                    }
                    i12 = c3958e.f13371p;
                    if (i12 > 0) {
                        measuredHeight2 = Math.max(i12, measuredHeight);
                    } else {
                        measuredHeight2 = measuredHeight;
                    }
                    i13 = c3958e.f13372q;
                    if (i13 > 0) {
                        measuredHeight2 = Math.min(i13, measuredHeight2);
                    }
                    if (!z15) {
                        if (z16) {
                            measuredHeight2 = (int) ((iMin / c3958e.f13337N) + 0.5f);
                        }
                    } else if (z16) {
                        measuredHeight2 = (int) ((iMin / c3958e.f13337N) + 0.5f);
                    }
                    if (measuredWidth == iMin) {
                        if (measuredWidth != iMin) {
                            i14 = 1073741824;
                            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                        } else {
                            i14 = 1073741824;
                        }
                        if (measuredHeight != measuredHeight2) {
                            iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredHeight2, i14);
                        }
                        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                        int measuredWidth17 = view.getMeasuredWidth();
                        measuredHeight2 = view.getMeasuredHeight();
                        iMin = measuredWidth17;
                        i15 = -1;
                        baseline = view.getBaseline();
                    } else {
                        if (measuredWidth != iMin) {
                            i14 = 1073741824;
                            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                        } else {
                            i14 = 1073741824;
                        }
                        if (measuredHeight != measuredHeight2) {
                            iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredHeight2, i14);
                        }
                        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                        int measuredWidth18 = view.getMeasuredWidth();
                        measuredHeight2 = view.getMeasuredHeight();
                        iMin = measuredWidth18;
                        i15 = -1;
                        baseline = view.getBaseline();
                    }
                }
                if (baseline != i15) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (iMin == c4027b.f13645c) {
                    z18 = true;
                } else {
                    z18 = true;
                }
                c4027b.f13651i = z18;
                if (layoutParams.f1338X) {
                    z17 = true;
                }
                if (z17) {
                    c4027b.f13651i = true;
                }
                c4027b.f13647e = iMin;
                c4027b.f13648f = measuredHeight2;
                c4027b.f13650h = z17;
                c4027b.f13649g = baseline;
            }
            iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(i18, 1073741824);
            iArr[3] = i18;
            z10 = false;
            enumC3957d = EnumC3957d.f13321c;
            if (enumC3957d3 == enumC3957d) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (enumC3957d4 == enumC3957d) {
                z12 = true;
            } else {
                z12 = false;
            }
            enumC3957d2 = EnumC3957d.f13322d;
            EnumC3957d enumC3957d10 = EnumC3957d.f13319a;
            if (enumC3957d4 != enumC3957d2) {
                z13 = true;
            } else {
                z13 = true;
            }
            if (enumC3957d3 != enumC3957d2) {
                z14 = true;
            } else {
                z14 = true;
            }
            if (z11) {
                z15 = false;
            } else {
                z15 = false;
            }
            if (z12) {
                z16 = false;
            } else {
                z16 = false;
            }
            layoutParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();
            if (c4027b.f13652j) {
                if (view instanceof VirtualLayout) {
                    view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                } else {
                    view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                }
                measuredWidth = view.getMeasuredWidth();
                measuredHeight = view.getMeasuredHeight();
                int baseline11 = view.getBaseline();
                if (z7) {
                    i6 = 0;
                    iArr[0] = measuredWidth;
                    iArr[2] = measuredHeight;
                } else {
                    i6 = 0;
                    iArr[0] = 0;
                    iArr[2] = 0;
                }
                if (z10) {
                    iArr[1] = measuredHeight;
                    iArr[3] = measuredWidth;
                } else {
                    iArr[1] = i6;
                    iArr[3] = i6;
                }
                i10 = c3958e.f13368m;
                if (i10 > 0) {
                    iMin = Math.max(i10, measuredWidth);
                } else {
                    iMin = measuredWidth;
                }
                i11 = c3958e.f13369n;
                if (i11 > 0) {
                    iMin = Math.min(i11, iMin);
                }
                i12 = c3958e.f13371p;
                if (i12 > 0) {
                    measuredHeight2 = Math.max(i12, measuredHeight);
                } else {
                    measuredHeight2 = measuredHeight;
                }
                i13 = c3958e.f13372q;
                if (i13 > 0) {
                    measuredHeight2 = Math.min(i13, measuredHeight2);
                }
                if (!z15) {
                    if (z16) {
                        measuredHeight2 = (int) ((iMin / c3958e.f13337N) + 0.5f);
                    }
                } else if (z16) {
                    measuredHeight2 = (int) ((iMin / c3958e.f13337N) + 0.5f);
                }
                if (measuredWidth == iMin) {
                    if (measuredWidth != iMin) {
                        i14 = 1073741824;
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                    } else {
                        i14 = 1073741824;
                    }
                    if (measuredHeight != measuredHeight2) {
                        iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredHeight2, i14);
                    }
                    view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                    int measuredWidth19 = view.getMeasuredWidth();
                    measuredHeight2 = view.getMeasuredHeight();
                    iMin = measuredWidth19;
                    i15 = -1;
                    baseline = view.getBaseline();
                } else {
                    if (measuredWidth != iMin) {
                        i14 = 1073741824;
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                    } else {
                        i14 = 1073741824;
                    }
                    if (measuredHeight != measuredHeight2) {
                        iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredHeight2, i14);
                    }
                    view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                    int measuredWidth110 = view.getMeasuredWidth();
                    measuredHeight2 = view.getMeasuredHeight();
                    iMin = measuredWidth110;
                    i15 = -1;
                    baseline = view.getBaseline();
                }
            } else {
                if (view instanceof VirtualLayout) {
                    view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                } else {
                    view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                }
                measuredWidth = view.getMeasuredWidth();
                measuredHeight = view.getMeasuredHeight();
                int baseline12 = view.getBaseline();
                if (z7) {
                    i6 = 0;
                    iArr[0] = measuredWidth;
                    iArr[2] = measuredHeight;
                } else {
                    i6 = 0;
                    iArr[0] = 0;
                    iArr[2] = 0;
                }
                if (z10) {
                    iArr[1] = measuredHeight;
                    iArr[3] = measuredWidth;
                } else {
                    iArr[1] = i6;
                    iArr[3] = i6;
                }
                i10 = c3958e.f13368m;
                if (i10 > 0) {
                    iMin = Math.max(i10, measuredWidth);
                } else {
                    iMin = measuredWidth;
                }
                i11 = c3958e.f13369n;
                if (i11 > 0) {
                    iMin = Math.min(i11, iMin);
                }
                i12 = c3958e.f13371p;
                if (i12 > 0) {
                    measuredHeight2 = Math.max(i12, measuredHeight);
                } else {
                    measuredHeight2 = measuredHeight;
                }
                i13 = c3958e.f13372q;
                if (i13 > 0) {
                    measuredHeight2 = Math.min(i13, measuredHeight2);
                }
                if (!z15) {
                    if (z16) {
                        measuredHeight2 = (int) ((iMin / c3958e.f13337N) + 0.5f);
                    }
                } else if (z16) {
                    measuredHeight2 = (int) ((iMin / c3958e.f13337N) + 0.5f);
                }
                if (measuredWidth == iMin) {
                    if (measuredWidth != iMin) {
                        i14 = 1073741824;
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                    } else {
                        i14 = 1073741824;
                    }
                    if (measuredHeight != measuredHeight2) {
                        iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredHeight2, i14);
                    }
                    view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                    int measuredWidth111 = view.getMeasuredWidth();
                    measuredHeight2 = view.getMeasuredHeight();
                    iMin = measuredWidth111;
                    i15 = -1;
                    baseline = view.getBaseline();
                } else {
                    if (measuredWidth != iMin) {
                        i14 = 1073741824;
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                    } else {
                        i14 = 1073741824;
                    }
                    if (measuredHeight != measuredHeight2) {
                        iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredHeight2, i14);
                    }
                    view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                    int measuredWidth112 = view.getMeasuredWidth();
                    measuredHeight2 = view.getMeasuredHeight();
                    iMin = measuredWidth112;
                    i15 = -1;
                    baseline = view.getBaseline();
                }
            }
            if (baseline != i15) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (iMin == c4027b.f13645c) {
                z18 = true;
            } else {
                z18 = true;
            }
            c4027b.f13651i = z18;
            if (layoutParams.f1338X) {
                z17 = true;
            }
            if (z17) {
                c4027b.f13651i = true;
            }
            c4027b.f13647e = iMin;
            c4027b.f13648f = measuredHeight2;
            c4027b.f13650h = z17;
            c4027b.f13649g = baseline;
        }
        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i17, 1073741824);
        iArr[2] = i17;
        iMakeMeasureSpec2 = iMakeMeasureSpec;
        z7 = false;
        iOrdinal = enumC3957d4.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                int childMeasureSpec6 = ViewGroup.getChildMeasureSpec(this.f1405g, i19, -2);
                iArr[3] = -2;
                iMakeMeasureSpec3 = childMeasureSpec6;
            } else {
                if (iOrdinal != 2) {
                    if (iOrdinal != 3) {
                        z10 = false;
                        iMakeMeasureSpec3 = 0;
                    } else {
                        int i25 = this.f1405g;
                        if (c3956c2 != null) {
                            i16 = c3958e.f13381z.f13316e;
                        } else {
                            i16 = 0;
                        }
                        if (c3956c != null) {
                            i16 += c3958e.f13325B.f13316e;
                        }
                        int childMeasureSpec7 = ViewGroup.getChildMeasureSpec(i25, i19 + i16, -1);
                        iArr[3] = -1;
                        iMakeMeasureSpec3 = childMeasureSpec7;
                    }
                    enumC3957d = EnumC3957d.f13321c;
                    if (enumC3957d3 == enumC3957d) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (enumC3957d4 == enumC3957d) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    enumC3957d2 = EnumC3957d.f13322d;
                    EnumC3957d enumC3957d11 = EnumC3957d.f13319a;
                    if (enumC3957d4 != enumC3957d2) {
                        z13 = true;
                    } else {
                        z13 = true;
                    }
                    if (enumC3957d3 != enumC3957d2) {
                        z14 = true;
                    } else {
                        z14 = true;
                    }
                    if (z11) {
                        z15 = false;
                    } else {
                        z15 = false;
                    }
                    if (z12) {
                        z16 = false;
                    } else {
                        z16 = false;
                    }
                    layoutParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();
                    if (c4027b.f13652j) {
                        if (view instanceof VirtualLayout) {
                            view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                        } else {
                            view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                        }
                        measuredWidth = view.getMeasuredWidth();
                        measuredHeight = view.getMeasuredHeight();
                        int baseline13 = view.getBaseline();
                        if (z7) {
                            i6 = 0;
                            iArr[0] = measuredWidth;
                            iArr[2] = measuredHeight;
                        } else {
                            i6 = 0;
                            iArr[0] = 0;
                            iArr[2] = 0;
                        }
                        if (z10) {
                            iArr[1] = measuredHeight;
                            iArr[3] = measuredWidth;
                        } else {
                            iArr[1] = i6;
                            iArr[3] = i6;
                        }
                        i10 = c3958e.f13368m;
                        if (i10 > 0) {
                            iMin = Math.max(i10, measuredWidth);
                        } else {
                            iMin = measuredWidth;
                        }
                        i11 = c3958e.f13369n;
                        if (i11 > 0) {
                            iMin = Math.min(i11, iMin);
                        }
                        i12 = c3958e.f13371p;
                        if (i12 > 0) {
                            measuredHeight2 = Math.max(i12, measuredHeight);
                        } else {
                            measuredHeight2 = measuredHeight;
                        }
                        i13 = c3958e.f13372q;
                        if (i13 > 0) {
                            measuredHeight2 = Math.min(i13, measuredHeight2);
                        }
                        if (!z15) {
                            if (z16) {
                                measuredHeight2 = (int) ((iMin / c3958e.f13337N) + 0.5f);
                            }
                        } else if (z16) {
                            measuredHeight2 = (int) ((iMin / c3958e.f13337N) + 0.5f);
                        }
                        if (measuredWidth == iMin) {
                            if (measuredWidth != iMin) {
                                i14 = 1073741824;
                                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                            } else {
                                i14 = 1073741824;
                            }
                            if (measuredHeight != measuredHeight2) {
                                iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredHeight2, i14);
                            }
                            view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                            int measuredWidth113 = view.getMeasuredWidth();
                            measuredHeight2 = view.getMeasuredHeight();
                            iMin = measuredWidth113;
                            i15 = -1;
                            baseline = view.getBaseline();
                        } else {
                            if (measuredWidth != iMin) {
                                i14 = 1073741824;
                                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                            } else {
                                i14 = 1073741824;
                            }
                            if (measuredHeight != measuredHeight2) {
                                iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredHeight2, i14);
                            }
                            view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                            int measuredWidth114 = view.getMeasuredWidth();
                            measuredHeight2 = view.getMeasuredHeight();
                            iMin = measuredWidth114;
                            i15 = -1;
                            baseline = view.getBaseline();
                        }
                    } else {
                        if (view instanceof VirtualLayout) {
                            view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                        } else {
                            view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                        }
                        measuredWidth = view.getMeasuredWidth();
                        measuredHeight = view.getMeasuredHeight();
                        int baseline14 = view.getBaseline();
                        if (z7) {
                            i6 = 0;
                            iArr[0] = measuredWidth;
                            iArr[2] = measuredHeight;
                        } else {
                            i6 = 0;
                            iArr[0] = 0;
                            iArr[2] = 0;
                        }
                        if (z10) {
                            iArr[1] = measuredHeight;
                            iArr[3] = measuredWidth;
                        } else {
                            iArr[1] = i6;
                            iArr[3] = i6;
                        }
                        i10 = c3958e.f13368m;
                        if (i10 > 0) {
                            iMin = Math.max(i10, measuredWidth);
                        } else {
                            iMin = measuredWidth;
                        }
                        i11 = c3958e.f13369n;
                        if (i11 > 0) {
                            iMin = Math.min(i11, iMin);
                        }
                        i12 = c3958e.f13371p;
                        if (i12 > 0) {
                            measuredHeight2 = Math.max(i12, measuredHeight);
                        } else {
                            measuredHeight2 = measuredHeight;
                        }
                        i13 = c3958e.f13372q;
                        if (i13 > 0) {
                            measuredHeight2 = Math.min(i13, measuredHeight2);
                        }
                        if (!z15) {
                            if (z16) {
                                measuredHeight2 = (int) ((iMin / c3958e.f13337N) + 0.5f);
                            }
                        } else if (z16) {
                            measuredHeight2 = (int) ((iMin / c3958e.f13337N) + 0.5f);
                        }
                        if (measuredWidth == iMin) {
                            if (measuredWidth != iMin) {
                                i14 = 1073741824;
                                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                            } else {
                                i14 = 1073741824;
                            }
                            if (measuredHeight != measuredHeight2) {
                                iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredHeight2, i14);
                            }
                            view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                            int measuredWidth115 = view.getMeasuredWidth();
                            measuredHeight2 = view.getMeasuredHeight();
                            iMin = measuredWidth115;
                            i15 = -1;
                            baseline = view.getBaseline();
                        } else {
                            if (measuredWidth != iMin) {
                                i14 = 1073741824;
                                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                            } else {
                                i14 = 1073741824;
                            }
                            if (measuredHeight != measuredHeight2) {
                                iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredHeight2, i14);
                            }
                            view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                            int measuredWidth116 = view.getMeasuredWidth();
                            measuredHeight2 = view.getMeasuredHeight();
                            iMin = measuredWidth116;
                            i15 = -1;
                            baseline = view.getBaseline();
                        }
                    }
                    if (baseline != i15) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (iMin == c4027b.f13645c) {
                        z18 = true;
                    } else {
                        z18 = true;
                    }
                    c4027b.f13651i = z18;
                    if (layoutParams.f1338X) {
                        z17 = true;
                    }
                    if (z17) {
                        c4027b.f13651i = true;
                    }
                    c4027b.f13647e = iMin;
                    c4027b.f13648f = measuredHeight2;
                    c4027b.f13650h = z17;
                    c4027b.f13649g = baseline;
                }
                iMakeMeasureSpec3 = ViewGroup.getChildMeasureSpec(this.f1405g, i19, -2);
                if (c3958e.f13366k == 1) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                iArr[3] = 0;
                if (c4027b.f13652j) {
                    if (z19) {
                    }
                    if (z19) {
                    }
                    iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(c3958e.m7902j(), 1073741824);
                }
            }
            z10 = true;
            enumC3957d = EnumC3957d.f13321c;
            if (enumC3957d3 == enumC3957d) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (enumC3957d4 == enumC3957d) {
                z12 = true;
            } else {
                z12 = false;
            }
            enumC3957d2 = EnumC3957d.f13322d;
            EnumC3957d enumC3957d12 = EnumC3957d.f13319a;
            if (enumC3957d4 != enumC3957d2) {
                z13 = true;
            } else {
                z13 = true;
            }
            if (enumC3957d3 != enumC3957d2) {
                z14 = true;
            } else {
                z14 = true;
            }
            if (z11) {
                z15 = false;
            } else {
                z15 = false;
            }
            if (z12) {
                z16 = false;
            } else {
                z16 = false;
            }
            layoutParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();
            if (c4027b.f13652j) {
                if (view instanceof VirtualLayout) {
                    view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                } else {
                    view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                }
                measuredWidth = view.getMeasuredWidth();
                measuredHeight = view.getMeasuredHeight();
                int baseline15 = view.getBaseline();
                if (z7) {
                    i6 = 0;
                    iArr[0] = measuredWidth;
                    iArr[2] = measuredHeight;
                } else {
                    i6 = 0;
                    iArr[0] = 0;
                    iArr[2] = 0;
                }
                if (z10) {
                    iArr[1] = measuredHeight;
                    iArr[3] = measuredWidth;
                } else {
                    iArr[1] = i6;
                    iArr[3] = i6;
                }
                i10 = c3958e.f13368m;
                if (i10 > 0) {
                    iMin = Math.max(i10, measuredWidth);
                } else {
                    iMin = measuredWidth;
                }
                i11 = c3958e.f13369n;
                if (i11 > 0) {
                    iMin = Math.min(i11, iMin);
                }
                i12 = c3958e.f13371p;
                if (i12 > 0) {
                    measuredHeight2 = Math.max(i12, measuredHeight);
                } else {
                    measuredHeight2 = measuredHeight;
                }
                i13 = c3958e.f13372q;
                if (i13 > 0) {
                    measuredHeight2 = Math.min(i13, measuredHeight2);
                }
                if (!z15) {
                    if (z16) {
                        measuredHeight2 = (int) ((iMin / c3958e.f13337N) + 0.5f);
                    }
                } else if (z16) {
                    measuredHeight2 = (int) ((iMin / c3958e.f13337N) + 0.5f);
                }
                if (measuredWidth == iMin) {
                    if (measuredWidth != iMin) {
                        i14 = 1073741824;
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                    } else {
                        i14 = 1073741824;
                    }
                    if (measuredHeight != measuredHeight2) {
                        iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredHeight2, i14);
                    }
                    view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                    int measuredWidth117 = view.getMeasuredWidth();
                    measuredHeight2 = view.getMeasuredHeight();
                    iMin = measuredWidth117;
                    i15 = -1;
                    baseline = view.getBaseline();
                } else {
                    if (measuredWidth != iMin) {
                        i14 = 1073741824;
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                    } else {
                        i14 = 1073741824;
                    }
                    if (measuredHeight != measuredHeight2) {
                        iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredHeight2, i14);
                    }
                    view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                    int measuredWidth118 = view.getMeasuredWidth();
                    measuredHeight2 = view.getMeasuredHeight();
                    iMin = measuredWidth118;
                    i15 = -1;
                    baseline = view.getBaseline();
                }
            } else {
                if (view instanceof VirtualLayout) {
                    view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                } else {
                    view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                }
                measuredWidth = view.getMeasuredWidth();
                measuredHeight = view.getMeasuredHeight();
                int baseline16 = view.getBaseline();
                if (z7) {
                    i6 = 0;
                    iArr[0] = measuredWidth;
                    iArr[2] = measuredHeight;
                } else {
                    i6 = 0;
                    iArr[0] = 0;
                    iArr[2] = 0;
                }
                if (z10) {
                    iArr[1] = measuredHeight;
                    iArr[3] = measuredWidth;
                } else {
                    iArr[1] = i6;
                    iArr[3] = i6;
                }
                i10 = c3958e.f13368m;
                if (i10 > 0) {
                    iMin = Math.max(i10, measuredWidth);
                } else {
                    iMin = measuredWidth;
                }
                i11 = c3958e.f13369n;
                if (i11 > 0) {
                    iMin = Math.min(i11, iMin);
                }
                i12 = c3958e.f13371p;
                if (i12 > 0) {
                    measuredHeight2 = Math.max(i12, measuredHeight);
                } else {
                    measuredHeight2 = measuredHeight;
                }
                i13 = c3958e.f13372q;
                if (i13 > 0) {
                    measuredHeight2 = Math.min(i13, measuredHeight2);
                }
                if (!z15) {
                    if (z16) {
                        measuredHeight2 = (int) ((iMin / c3958e.f13337N) + 0.5f);
                    }
                } else if (z16) {
                    measuredHeight2 = (int) ((iMin / c3958e.f13337N) + 0.5f);
                }
                if (measuredWidth == iMin) {
                    if (measuredWidth != iMin) {
                        i14 = 1073741824;
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                    } else {
                        i14 = 1073741824;
                    }
                    if (measuredHeight != measuredHeight2) {
                        iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredHeight2, i14);
                    }
                    view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                    int measuredWidth119 = view.getMeasuredWidth();
                    measuredHeight2 = view.getMeasuredHeight();
                    iMin = measuredWidth119;
                    i15 = -1;
                    baseline = view.getBaseline();
                } else {
                    if (measuredWidth != iMin) {
                        i14 = 1073741824;
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                    } else {
                        i14 = 1073741824;
                    }
                    if (measuredHeight != measuredHeight2) {
                        iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredHeight2, i14);
                    }
                    view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                    int measuredWidth1110 = view.getMeasuredWidth();
                    measuredHeight2 = view.getMeasuredHeight();
                    iMin = measuredWidth1110;
                    i15 = -1;
                    baseline = view.getBaseline();
                }
            }
            if (baseline != i15) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (iMin == c4027b.f13645c) {
                z18 = true;
            } else {
                z18 = true;
            }
            c4027b.f13651i = z18;
            if (layoutParams.f1338X) {
                z17 = true;
            }
            if (z17) {
                c4027b.f13651i = true;
            }
            c4027b.f13647e = iMin;
            c4027b.f13648f = measuredHeight2;
            c4027b.f13650h = z17;
            c4027b.f13649g = baseline;
        }
        iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(i18, 1073741824);
        iArr[3] = i18;
        z10 = false;
        enumC3957d = EnumC3957d.f13321c;
        if (enumC3957d3 == enumC3957d) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (enumC3957d4 == enumC3957d) {
            z12 = true;
        } else {
            z12 = false;
        }
        enumC3957d2 = EnumC3957d.f13322d;
        EnumC3957d enumC3957d13 = EnumC3957d.f13319a;
        if (enumC3957d4 != enumC3957d2) {
            z13 = true;
        } else {
            z13 = true;
        }
        if (enumC3957d3 != enumC3957d2) {
            z14 = true;
        } else {
            z14 = true;
        }
        if (z11) {
            z15 = false;
        } else {
            z15 = false;
        }
        if (z12) {
            z16 = false;
        } else {
            z16 = false;
        }
        layoutParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();
        if (c4027b.f13652j) {
            if (view instanceof VirtualLayout) {
                view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
            } else {
                view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
            }
            measuredWidth = view.getMeasuredWidth();
            measuredHeight = view.getMeasuredHeight();
            int baseline17 = view.getBaseline();
            if (z7) {
                i6 = 0;
                iArr[0] = measuredWidth;
                iArr[2] = measuredHeight;
            } else {
                i6 = 0;
                iArr[0] = 0;
                iArr[2] = 0;
            }
            if (z10) {
                iArr[1] = measuredHeight;
                iArr[3] = measuredWidth;
            } else {
                iArr[1] = i6;
                iArr[3] = i6;
            }
            i10 = c3958e.f13368m;
            if (i10 > 0) {
                iMin = Math.max(i10, measuredWidth);
            } else {
                iMin = measuredWidth;
            }
            i11 = c3958e.f13369n;
            if (i11 > 0) {
                iMin = Math.min(i11, iMin);
            }
            i12 = c3958e.f13371p;
            if (i12 > 0) {
                measuredHeight2 = Math.max(i12, measuredHeight);
            } else {
                measuredHeight2 = measuredHeight;
            }
            i13 = c3958e.f13372q;
            if (i13 > 0) {
                measuredHeight2 = Math.min(i13, measuredHeight2);
            }
            if (!z15) {
                if (z16) {
                    measuredHeight2 = (int) ((iMin / c3958e.f13337N) + 0.5f);
                }
            } else if (z16) {
                measuredHeight2 = (int) ((iMin / c3958e.f13337N) + 0.5f);
            }
            if (measuredWidth == iMin) {
                if (measuredWidth != iMin) {
                    i14 = 1073741824;
                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                } else {
                    i14 = 1073741824;
                }
                if (measuredHeight != measuredHeight2) {
                    iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredHeight2, i14);
                }
                view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                int measuredWidth1111 = view.getMeasuredWidth();
                measuredHeight2 = view.getMeasuredHeight();
                iMin = measuredWidth1111;
                i15 = -1;
                baseline = view.getBaseline();
            } else {
                if (measuredWidth != iMin) {
                    i14 = 1073741824;
                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                } else {
                    i14 = 1073741824;
                }
                if (measuredHeight != measuredHeight2) {
                    iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredHeight2, i14);
                }
                view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                int measuredWidth1112 = view.getMeasuredWidth();
                measuredHeight2 = view.getMeasuredHeight();
                iMin = measuredWidth1112;
                i15 = -1;
                baseline = view.getBaseline();
            }
        } else {
            if (view instanceof VirtualLayout) {
                view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
            } else {
                view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
            }
            measuredWidth = view.getMeasuredWidth();
            measuredHeight = view.getMeasuredHeight();
            int baseline18 = view.getBaseline();
            if (z7) {
                i6 = 0;
                iArr[0] = measuredWidth;
                iArr[2] = measuredHeight;
            } else {
                i6 = 0;
                iArr[0] = 0;
                iArr[2] = 0;
            }
            if (z10) {
                iArr[1] = measuredHeight;
                iArr[3] = measuredWidth;
            } else {
                iArr[1] = i6;
                iArr[3] = i6;
            }
            i10 = c3958e.f13368m;
            if (i10 > 0) {
                iMin = Math.max(i10, measuredWidth);
            } else {
                iMin = measuredWidth;
            }
            i11 = c3958e.f13369n;
            if (i11 > 0) {
                iMin = Math.min(i11, iMin);
            }
            i12 = c3958e.f13371p;
            if (i12 > 0) {
                measuredHeight2 = Math.max(i12, measuredHeight);
            } else {
                measuredHeight2 = measuredHeight;
            }
            i13 = c3958e.f13372q;
            if (i13 > 0) {
                measuredHeight2 = Math.min(i13, measuredHeight2);
            }
            if (!z15) {
                if (z16) {
                    measuredHeight2 = (int) ((iMin / c3958e.f13337N) + 0.5f);
                }
            } else if (z16) {
                measuredHeight2 = (int) ((iMin / c3958e.f13337N) + 0.5f);
            }
            if (measuredWidth == iMin) {
                if (measuredWidth != iMin) {
                    i14 = 1073741824;
                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                } else {
                    i14 = 1073741824;
                }
                if (measuredHeight != measuredHeight2) {
                    iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredHeight2, i14);
                }
                view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                int measuredWidth1113 = view.getMeasuredWidth();
                measuredHeight2 = view.getMeasuredHeight();
                iMin = measuredWidth1113;
                i15 = -1;
                baseline = view.getBaseline();
            } else {
                if (measuredWidth != iMin) {
                    i14 = 1073741824;
                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                } else {
                    i14 = 1073741824;
                }
                if (measuredHeight != measuredHeight2) {
                    iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredHeight2, i14);
                }
                view.measure(iMakeMeasureSpec2, iMakeMeasureSpec3);
                int measuredWidth1114 = view.getMeasuredWidth();
                measuredHeight2 = view.getMeasuredHeight();
                iMin = measuredWidth1114;
                i15 = -1;
                baseline = view.getBaseline();
            }
        }
        if (baseline != i15) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (iMin == c4027b.f13645c) {
            z18 = true;
        } else {
            z18 = true;
        }
        c4027b.f13651i = z18;
        if (layoutParams.f1338X) {
            z17 = true;
        }
        if (z17) {
            c4027b.f13651i = true;
        }
        c4027b.f13647e = iMin;
        c4027b.f13648f = measuredHeight2;
        c4027b.f13650h = z17;
        c4027b.f13649g = baseline;
    }
}
