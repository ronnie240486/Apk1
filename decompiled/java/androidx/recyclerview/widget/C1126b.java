package androidx.recyclerview.widget;

import java.util.ArrayList;
import p128m0.C3027c;

public final class C1126b {

    public final C1152i0 f3517d;

    public final C3027c f3514a = new C3027c(30);

    public final ArrayList f3515b = new ArrayList();

    public final ArrayList f3516c = new ArrayList();

    public int f3519f = 0;

    public final C1152i0 f3518e = new C1152i0(this);

    public C1126b(C1152i0 c1152i0) {
        this.f3517d = c1152i0;
    }

    public final boolean m2871a(int i6) {
        ArrayList arrayList = this.f3516c;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            C1122a c1122a = (C1122a) arrayList.get(i10);
            int i11 = c1122a.f3510a;
            if (i11 == 8) {
                if (m2876f(c1122a.f3513d, i10 + 1) == i6) {
                    return true;
                }
            } else if (i11 == 1) {
                int i12 = c1122a.f3511b;
                int i13 = c1122a.f3513d + i12;
                while (i12 < i13) {
                    if (m2876f(i12, i10 + 1) == i6) {
                        return true;
                    }
                    i12++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public final void m2872b() {
        ArrayList arrayList = this.f3516c;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            this.f3517d.m2947a((C1122a) arrayList.get(i6));
        }
        m2881k(arrayList);
        this.f3519f = 0;
    }

    public final void m2873c() {
        m2872b();
        ArrayList arrayList = this.f3515b;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            C1122a c1122a = (C1122a) arrayList.get(i6);
            int i10 = c1122a.f3510a;
            C1152i0 c1152i0 = this.f3517d;
            if (i10 == 1) {
                c1152i0.m2947a(c1122a);
                int i11 = c1122a.f3511b;
                int i12 = c1122a.f3513d;
                RecyclerView recyclerView = (RecyclerView) c1152i0.f3584a;
                recyclerView.offsetPositionRecordsForInsert(i11, i12);
                recyclerView.mItemsAddedOrRemoved = true;
            } else if (i10 == 2) {
                c1152i0.m2947a(c1122a);
                int i13 = c1122a.f3511b;
                int i14 = c1122a.f3513d;
                RecyclerView recyclerView2 = (RecyclerView) c1152i0.f3584a;
                recyclerView2.offsetPositionRecordsForRemove(i13, i14, true);
                recyclerView2.mItemsAddedOrRemoved = true;
                recyclerView2.mState.f3617c += i14;
            } else if (i10 == 4) {
                c1152i0.m2947a(c1122a);
                int i15 = c1122a.f3511b;
                int i16 = c1122a.f3513d;
                Object obj = c1122a.f3512c;
                RecyclerView recyclerView3 = (RecyclerView) c1152i0.f3584a;
                recyclerView3.viewRangeUpdate(i15, i16, obj);
                recyclerView3.mItemsChanged = true;
            } else if (i10 == 8) {
                c1152i0.m2947a(c1122a);
                int i17 = c1122a.f3511b;
                int i18 = c1122a.f3513d;
                RecyclerView recyclerView4 = (RecyclerView) c1152i0.f3584a;
                recyclerView4.offsetPositionRecordsForMove(i17, i18);
                recyclerView4.mItemsAddedOrRemoved = true;
            }
        }
        m2881k(arrayList);
        this.f3519f = 0;
    }

    public final void m2874d(C1122a c1122a) {
        int i6;
        int i10 = c1122a.f3510a;
        if (i10 == 1 || i10 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iM2882l = m2882l(c1122a.f3511b, i10);
        int i11 = c1122a.f3511b;
        int i12 = c1122a.f3510a;
        if (i12 == 2) {
            i6 = 0;
        } else {
            if (i12 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + c1122a);
            }
            i6 = 1;
        }
        int i13 = 1;
        for (int i14 = 1; i14 < c1122a.f3513d; i14++) {
            int iM2882l2 = m2882l((i6 * i14) + c1122a.f3511b, c1122a.f3510a);
            int i15 = c1122a.f3510a;
            if (i15 == 2 ? iM2882l2 != iM2882l : !(i15 == 4 && iM2882l2 == iM2882l + 1)) {
                C1122a c1122aM2878h = m2878h(i15, iM2882l, i13, c1122a.f3512c);
                m2875e(c1122aM2878h, i11);
                c1122aM2878h.f3512c = null;
                this.f3514a.mo6101c(c1122aM2878h);
                if (c1122a.f3510a == 4) {
                    i11 += i13;
                }
                iM2882l = iM2882l2;
                i13 = 1;
            } else {
                i13++;
            }
        }
        Object obj = c1122a.f3512c;
        c1122a.f3512c = null;
        this.f3514a.mo6101c(c1122a);
        if (i13 > 0) {
            C1122a c1122aM2878h2 = m2878h(c1122a.f3510a, iM2882l, i13, obj);
            m2875e(c1122aM2878h2, i11);
            c1122aM2878h2.f3512c = null;
            this.f3514a.mo6101c(c1122aM2878h2);
        }
    }

    public final void m2875e(C1122a c1122a, int i6) {
        C1152i0 c1152i0 = this.f3517d;
        c1152i0.m2947a(c1122a);
        int i10 = c1122a.f3510a;
        RecyclerView recyclerView = (RecyclerView) c1152i0.f3584a;
        if (i10 != 2) {
            if (i10 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            recyclerView.viewRangeUpdate(i6, c1122a.f3513d, c1122a.f3512c);
            recyclerView.mItemsChanged = true;
            return;
        }
        int i11 = c1122a.f3513d;
        recyclerView.offsetPositionRecordsForRemove(i6, i11, true);
        recyclerView.mItemsAddedOrRemoved = true;
        recyclerView.mState.f3617c += i11;
    }

    public final int m2876f(int i6, int i10) {
        ArrayList arrayList = this.f3516c;
        int size = arrayList.size();
        while (i10 < size) {
            C1122a c1122a = (C1122a) arrayList.get(i10);
            int i11 = c1122a.f3510a;
            if (i11 == 8) {
                int i12 = c1122a.f3511b;
                if (i12 == i6) {
                    i6 = c1122a.f3513d;
                } else {
                    if (i12 < i6) {
                        i6--;
                    }
                    if (c1122a.f3513d <= i6) {
                        i6++;
                    }
                }
            } else {
                int i13 = c1122a.f3511b;
                if (i13 > i6) {
                    continue;
                } else if (i11 == 2) {
                    int i14 = c1122a.f3513d;
                    if (i6 < i13 + i14) {
                        return -1;
                    }
                    i6 -= i14;
                } else if (i11 == 1) {
                    i6 += c1122a.f3513d;
                }
            }
            i10++;
        }
        return i6;
    }

    public final boolean m2877g() {
        return this.f3515b.size() > 0;
    }

    public final C1122a m2878h(int i6, int i10, int i11, Object obj) {
        C1122a c1122a = (C1122a) this.f3514a.mo6099a();
        if (c1122a != null) {
            c1122a.f3510a = i6;
            c1122a.f3511b = i10;
            c1122a.f3513d = i11;
            c1122a.f3512c = obj;
            return c1122a;
        }
        C1122a c1122a2 = new C1122a();
        c1122a2.f3510a = i6;
        c1122a2.f3511b = i10;
        c1122a2.f3513d = i11;
        c1122a2.f3512c = obj;
        return c1122a2;
    }

    public final void m2879i(C1122a c1122a) {
        this.f3516c.add(c1122a);
        int i6 = c1122a.f3510a;
        C1152i0 c1152i0 = this.f3517d;
        if (i6 == 1) {
            int i10 = c1122a.f3511b;
            int i11 = c1122a.f3513d;
            RecyclerView recyclerView = (RecyclerView) c1152i0.f3584a;
            recyclerView.offsetPositionRecordsForInsert(i10, i11);
            recyclerView.mItemsAddedOrRemoved = true;
            return;
        }
        if (i6 == 2) {
            int i12 = c1122a.f3511b;
            int i13 = c1122a.f3513d;
            RecyclerView recyclerView2 = (RecyclerView) c1152i0.f3584a;
            recyclerView2.offsetPositionRecordsForRemove(i12, i13, false);
            recyclerView2.mItemsAddedOrRemoved = true;
            return;
        }
        if (i6 == 4) {
            int i14 = c1122a.f3511b;
            int i15 = c1122a.f3513d;
            Object obj = c1122a.f3512c;
            RecyclerView recyclerView3 = (RecyclerView) c1152i0.f3584a;
            recyclerView3.viewRangeUpdate(i14, i15, obj);
            recyclerView3.mItemsChanged = true;
            return;
        }
        if (i6 != 8) {
            throw new IllegalArgumentException("Unknown update op type for " + c1122a);
        }
        int i16 = c1122a.f3511b;
        int i17 = c1122a.f3513d;
        RecyclerView recyclerView4 = (RecyclerView) c1152i0.f3584a;
        recyclerView4.offsetPositionRecordsForMove(i16, i17);
        recyclerView4.mItemsAddedOrRemoved = true;
    }

    public final void m2880j() {
        byte b8;
        boolean z7;
        byte b10;
        C1122a c1122aM2878h;
        int i6;
        int i10;
        int i11;
        C1122a c1122aM2878h2;
        boolean z10;
        boolean z11;
        C1122a c1122aM2878h3;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        ArrayList arrayList = this.f3515b;
        C1152i0 c1152i0 = this.f3518e;
        c1152i0.getClass();
        while (true) {
            int size = arrayList.size() - 1;
            boolean z12 = false;
            while (true) {
                b8 = -1;
                if (size < 0) {
                    size = -1;
                    break;
                }
                if (((C1122a) arrayList.get(size)).f3510a != 8) {
                    z12 = true;
                } else if (z12) {
                    break;
                }
                size--;
            }
            if (size == -1) {
                break;
            }
            int i20 = size + 1;
            C1122a c1122a = (C1122a) arrayList.get(size);
            C1122a c1122a2 = (C1122a) arrayList.get(i20);
            int i21 = c1122a2.f3510a;
            if (i21 != 1) {
                C1126b c1126b = (C1126b) c1152i0.f3584a;
                if (i21 == 2) {
                    int i22 = c1122a.f3511b;
                    int i23 = c1122a.f3513d;
                    if (i22 < i23) {
                        z10 = c1122a2.f3511b == i22 && c1122a2.f3513d == i23 - i22;
                        z11 = false;
                    } else {
                        z10 = c1122a2.f3511b == i23 + 1 && c1122a2.f3513d == i22 - i23;
                        z11 = true;
                    }
                    int i24 = c1122a2.f3511b;
                    if (i23 < i24) {
                        c1122a2.f3511b = i24 - 1;
                    } else {
                        int i25 = c1122a2.f3513d;
                        if (i23 < i24 + i25) {
                            c1122a2.f3513d = i25 - 1;
                            c1122a.f3510a = 2;
                            c1122a.f3513d = 1;
                            if (c1122a2.f3513d == 0) {
                                arrayList.remove(i20);
                                c1126b.getClass();
                                c1122a2.f3512c = null;
                                c1126b.f3514a.mo6101c(c1122a2);
                            }
                        }
                    }
                    int i26 = c1122a.f3511b;
                    int i27 = c1122a2.f3511b;
                    if (i26 <= i27) {
                        c1122a2.f3511b = i27 + 1;
                    } else {
                        int i28 = i27 + c1122a2.f3513d;
                        if (i26 < i28) {
                            c1122aM2878h3 = c1126b.m2878h(2, i26 + 1, i28 - i26, null);
                            c1122a2.f3513d = c1122a.f3511b - c1122a2.f3511b;
                        }
                        if (z10) {
                            arrayList.set(size, c1122a2);
                            arrayList.remove(i20);
                            c1126b.getClass();
                            c1122a.f3512c = null;
                            c1126b.f3514a.mo6101c(c1122a);
                        } else {
                            if (z11) {
                                if (c1122aM2878h3 != null) {
                                    i18 = c1122a.f3511b;
                                    if (i18 > c1122aM2878h3.f3511b) {
                                        c1122a.f3511b = i18 - c1122aM2878h3.f3513d;
                                    }
                                    i19 = c1122a.f3513d;
                                    if (i19 > c1122aM2878h3.f3511b) {
                                        c1122a.f3513d = i19 - c1122aM2878h3.f3513d;
                                    }
                                }
                                i16 = c1122a.f3511b;
                                if (i16 > c1122a2.f3511b) {
                                    c1122a.f3511b = i16 - c1122a2.f3513d;
                                }
                                i17 = c1122a.f3513d;
                                if (i17 > c1122a2.f3511b) {
                                    c1122a.f3513d = i17 - c1122a2.f3513d;
                                }
                            } else {
                                if (c1122aM2878h3 != null) {
                                    i14 = c1122a.f3511b;
                                    if (i14 >= c1122aM2878h3.f3511b) {
                                        c1122a.f3511b = i14 - c1122aM2878h3.f3513d;
                                    }
                                    i15 = c1122a.f3513d;
                                    if (i15 >= c1122aM2878h3.f3511b) {
                                        c1122a.f3513d = i15 - c1122aM2878h3.f3513d;
                                    }
                                }
                                i12 = c1122a.f3511b;
                                if (i12 >= c1122a2.f3511b) {
                                    c1122a.f3511b = i12 - c1122a2.f3513d;
                                }
                                i13 = c1122a.f3513d;
                                if (i13 >= c1122a2.f3511b) {
                                    c1122a.f3513d = i13 - c1122a2.f3513d;
                                }
                            }
                            arrayList.set(size, c1122a2);
                            if (c1122a.f3511b != c1122a.f3513d) {
                                arrayList.set(i20, c1122a);
                            } else {
                                arrayList.remove(i20);
                            }
                            if (c1122aM2878h3 != null) {
                                arrayList.add(size, c1122aM2878h3);
                            }
                        }
                    }
                    c1122aM2878h3 = null;
                    if (z10) {
                        arrayList.set(size, c1122a2);
                        arrayList.remove(i20);
                        c1126b.getClass();
                        c1122a.f3512c = null;
                        c1126b.f3514a.mo6101c(c1122a);
                    } else {
                        if (z11) {
                            if (c1122aM2878h3 != null) {
                                i18 = c1122a.f3511b;
                                if (i18 > c1122aM2878h3.f3511b) {
                                    c1122a.f3511b = i18 - c1122aM2878h3.f3513d;
                                }
                                i19 = c1122a.f3513d;
                                if (i19 > c1122aM2878h3.f3511b) {
                                    c1122a.f3513d = i19 - c1122aM2878h3.f3513d;
                                }
                            }
                            i16 = c1122a.f3511b;
                            if (i16 > c1122a2.f3511b) {
                                c1122a.f3511b = i16 - c1122a2.f3513d;
                            }
                            i17 = c1122a.f3513d;
                            if (i17 > c1122a2.f3511b) {
                                c1122a.f3513d = i17 - c1122a2.f3513d;
                            }
                        } else {
                            if (c1122aM2878h3 != null) {
                                i14 = c1122a.f3511b;
                                if (i14 >= c1122aM2878h3.f3511b) {
                                    c1122a.f3511b = i14 - c1122aM2878h3.f3513d;
                                }
                                i15 = c1122a.f3513d;
                                if (i15 >= c1122aM2878h3.f3511b) {
                                    c1122a.f3513d = i15 - c1122aM2878h3.f3513d;
                                }
                            }
                            i12 = c1122a.f3511b;
                            if (i12 >= c1122a2.f3511b) {
                                c1122a.f3511b = i12 - c1122a2.f3513d;
                            }
                            i13 = c1122a.f3513d;
                            if (i13 >= c1122a2.f3511b) {
                                c1122a.f3513d = i13 - c1122a2.f3513d;
                            }
                        }
                        arrayList.set(size, c1122a2);
                        if (c1122a.f3511b != c1122a.f3513d) {
                            arrayList.set(i20, c1122a);
                        } else {
                            arrayList.remove(i20);
                        }
                        if (c1122aM2878h3 != null) {
                            arrayList.add(size, c1122aM2878h3);
                        }
                    }
                } else if (i21 == 4) {
                    int i29 = c1122a.f3513d;
                    int i30 = c1122a2.f3511b;
                    if (i29 < i30) {
                        c1122a2.f3511b = i30 - 1;
                    } else {
                        int i31 = c1122a2.f3513d;
                        if (i29 < i30 + i31) {
                            c1122a2.f3513d = i31 - 1;
                            c1122aM2878h = c1126b.m2878h(4, c1122a.f3511b, 1, c1122a2.f3512c);
                        }
                        i6 = c1122a.f3511b;
                        i10 = c1122a2.f3511b;
                        if (i6 <= i10) {
                            c1122a2.f3511b = i10 + 1;
                        } else {
                            i11 = i10 + c1122a2.f3513d;
                            if (i6 < i11) {
                                int i32 = i11 - i6;
                                c1122aM2878h2 = c1126b.m2878h(4, i6 + 1, i32, c1122a2.f3512c);
                                c1122a2.f3513d -= i32;
                            }
                            arrayList.set(i20, c1122a);
                            if (c1122a2.f3513d > 0) {
                                arrayList.set(size, c1122a2);
                            } else {
                                arrayList.remove(size);
                                c1126b.getClass();
                                c1122a2.f3512c = null;
                                c1126b.f3514a.mo6101c(c1122a2);
                            }
                            if (c1122aM2878h != null) {
                                arrayList.add(size, c1122aM2878h);
                            }
                            if (c1122aM2878h2 != null) {
                                arrayList.add(size, c1122aM2878h2);
                            }
                        }
                        c1122aM2878h2 = null;
                        arrayList.set(i20, c1122a);
                        if (c1122a2.f3513d > 0) {
                            arrayList.set(size, c1122a2);
                        } else {
                            arrayList.remove(size);
                            c1126b.getClass();
                            c1122a2.f3512c = null;
                            c1126b.f3514a.mo6101c(c1122a2);
                        }
                        if (c1122aM2878h != null) {
                            arrayList.add(size, c1122aM2878h);
                        }
                        if (c1122aM2878h2 != null) {
                            arrayList.add(size, c1122aM2878h2);
                        }
                    }
                    c1122aM2878h = null;
                    i6 = c1122a.f3511b;
                    i10 = c1122a2.f3511b;
                    if (i6 <= i10) {
                        c1122a2.f3511b = i10 + 1;
                    } else {
                        i11 = i10 + c1122a2.f3513d;
                        if (i6 < i11) {
                            int i33 = i11 - i6;
                            c1122aM2878h2 = c1126b.m2878h(4, i6 + 1, i33, c1122a2.f3512c);
                            c1122a2.f3513d -= i33;
                        }
                        arrayList.set(i20, c1122a);
                        if (c1122a2.f3513d > 0) {
                            arrayList.set(size, c1122a2);
                        } else {
                            arrayList.remove(size);
                            c1126b.getClass();
                            c1122a2.f3512c = null;
                            c1126b.f3514a.mo6101c(c1122a2);
                        }
                        if (c1122aM2878h != null) {
                            arrayList.add(size, c1122aM2878h);
                        }
                        if (c1122aM2878h2 != null) {
                            arrayList.add(size, c1122aM2878h2);
                        }
                    }
                    c1122aM2878h2 = null;
                    arrayList.set(i20, c1122a);
                    if (c1122a2.f3513d > 0) {
                        arrayList.set(size, c1122a2);
                    } else {
                        arrayList.remove(size);
                        c1126b.getClass();
                        c1122a2.f3512c = null;
                        c1126b.f3514a.mo6101c(c1122a2);
                    }
                    if (c1122aM2878h != null) {
                        arrayList.add(size, c1122aM2878h);
                    }
                    if (c1122aM2878h2 != null) {
                        arrayList.add(size, c1122aM2878h2);
                    }
                }
            } else {
                int i34 = c1122a.f3513d;
                int i35 = c1122a2.f3511b;
                int i36 = i34 < i35 ? -1 : 0;
                int i37 = c1122a.f3511b;
                if (i37 < i35) {
                    i36++;
                }
                if (i35 <= i37) {
                    c1122a.f3511b = i37 + c1122a2.f3513d;
                }
                int i38 = c1122a2.f3511b;
                if (i38 <= i34) {
                    c1122a.f3513d = i34 + c1122a2.f3513d;
                }
                c1122a2.f3511b = i38 + i36;
                arrayList.set(size, c1122a2);
                arrayList.set(i20, c1122a);
            }
        }
        int size2 = arrayList.size();
        int i39 = 0;
        while (i39 < size2) {
            C1122a c1122aM2878h4 = (C1122a) arrayList.get(i39);
            int i40 = c1122aM2878h4.f3510a;
            if (i40 != 1) {
                C1152i0 c1152i1 = this.f3517d;
                if (i40 == 2) {
                    int i41 = c1122aM2878h4.f3511b;
                    int i42 = c1122aM2878h4.f3513d + i41;
                    int i43 = i41;
                    int i44 = 0;
                    byte b11 = -1;
                    while (i43 < i42) {
                        if (c1152i1.m2948b(i43) != null || m2871a(i43)) {
                            if (b11 == 0) {
                                m2874d(m2878h(2, i41, i44, null));
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            b10 = 1;
                        } else {
                            if (b11 == 1) {
                                m2879i(m2878h(2, i41, i44, null));
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            b10 = 0;
                        }
                        if (z7) {
                            i43 -= i44;
                            i42 -= i44;
                            i44 = 1;
                        } else {
                            i44++;
                        }
                        i43++;
                        b11 = b10;
                    }
                    if (i44 != c1122aM2878h4.f3513d) {
                        c1122aM2878h4.f3512c = null;
                        this.f3514a.mo6101c(c1122aM2878h4);
                        c1122aM2878h4 = m2878h(2, i41, i44, null);
                    }
                    if (b11 == 0) {
                        m2874d(c1122aM2878h4);
                    } else {
                        m2879i(c1122aM2878h4);
                    }
                } else if (i40 == 4) {
                    int i45 = c1122aM2878h4.f3511b;
                    int i46 = c1122aM2878h4.f3513d + i45;
                    int i47 = i45;
                    int i48 = 0;
                    while (i45 < i46) {
                        if (c1152i1.m2948b(i45) != null || m2871a(i45)) {
                            if (b8 == 0) {
                                m2874d(m2878h(4, i47, i48, c1122aM2878h4.f3512c));
                                i47 = i45;
                                i48 = 0;
                            }
                            b8 = 1;
                        } else {
                            if (b8 == 1) {
                                m2879i(m2878h(4, i47, i48, c1122aM2878h4.f3512c));
                                i47 = i45;
                                i48 = 0;
                            }
                            b8 = 0;
                        }
                        i48++;
                        i45++;
                    }
                    if (i48 != c1122aM2878h4.f3513d) {
                        Object obj = c1122aM2878h4.f3512c;
                        c1122aM2878h4.f3512c = null;
                        this.f3514a.mo6101c(c1122aM2878h4);
                        c1122aM2878h4 = m2878h(4, i47, i48, obj);
                    }
                    if (b8 == 0) {
                        m2874d(c1122aM2878h4);
                    } else {
                        m2879i(c1122aM2878h4);
                    }
                } else if (i40 == 8) {
                    m2879i(c1122aM2878h4);
                }
            } else {
                m2879i(c1122aM2878h4);
            }
            i39++;
            b8 = -1;
        }
        arrayList.clear();
    }

    public final void m2881k(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            C1122a c1122a = (C1122a) arrayList.get(i6);
            c1122a.f3512c = null;
            this.f3514a.mo6101c(c1122a);
        }
        arrayList.clear();
    }

    public final int m2882l(int i6, int i10) {
        int i11;
        int i12;
        ArrayList arrayList = this.f3516c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            C1122a c1122a = (C1122a) arrayList.get(size);
            int i13 = c1122a.f3510a;
            if (i13 == 8) {
                int i14 = c1122a.f3511b;
                int i15 = c1122a.f3513d;
                if (i14 < i15) {
                    i12 = i14;
                    i11 = i15;
                } else {
                    i11 = i14;
                    i12 = i15;
                }
                if (i6 < i12 || i6 > i11) {
                    if (i6 < i14) {
                        if (i10 == 1) {
                            c1122a.f3511b = i14 + 1;
                            c1122a.f3513d = i15 + 1;
                        } else if (i10 == 2) {
                            c1122a.f3511b = i14 - 1;
                            c1122a.f3513d = i15 - 1;
                        }
                    }
                } else if (i12 == i14) {
                    if (i10 == 1) {
                        c1122a.f3513d = i15 + 1;
                    } else if (i10 == 2) {
                        c1122a.f3513d = i15 - 1;
                    }
                    i6++;
                } else {
                    if (i10 == 1) {
                        c1122a.f3511b = i14 + 1;
                    } else if (i10 == 2) {
                        c1122a.f3511b = i14 - 1;
                    }
                    i6--;
                }
            } else {
                int i16 = c1122a.f3511b;
                if (i16 <= i6) {
                    if (i13 == 1) {
                        i6 -= c1122a.f3513d;
                    } else if (i13 == 2) {
                        i6 += c1122a.f3513d;
                    }
                } else if (i10 == 1) {
                    c1122a.f3511b = i16 + 1;
                } else if (i10 == 2) {
                    c1122a.f3511b = i16 - 1;
                }
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            C1122a c1122a2 = (C1122a) arrayList.get(size2);
            if (c1122a2.f3510a == 8) {
                int i17 = c1122a2.f3513d;
                if (i17 == c1122a2.f3511b || i17 < 0) {
                    arrayList.remove(size2);
                    c1122a2.f3512c = null;
                    this.f3514a.mo6101c(c1122a2);
                }
            } else if (c1122a2.f3513d <= 0) {
                arrayList.remove(size2);
                c1122a2.f3512c = null;
                this.f3514a.mo6101c(c1122a2);
            }
        }
        return i6;
    }
}
