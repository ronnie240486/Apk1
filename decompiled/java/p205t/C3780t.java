package p205t;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.C0307c;
import androidx.constraintlayout.widget.C0308d;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.Constraints;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import p003a2.AbstractC0032a;
import p225v.C3954a;
import p225v.C3958e;
import p225v.C3959f;
import p225v.C3961h;
import p225v.C3962i;
import p225v.C3963j;
import p225v.EnumC3957d;
import p236w.InterfaceC4028c;

public final class C3780t {

    public C3959f f12715a = new C3959f();

    public C3959f f12716b = new C3959f();

    public C0308d f12717c = null;

    public C0308d f12718d = null;

    public int f12719e;

    public int f12720f;

    public final MotionLayout f12721g;

    public C3780t(MotionLayout motionLayout) {
        this.f12721g = motionLayout;
    }

    public static void m7529b(C3959f c3959f, C3959f c3959f2) {
        C3958e c3963j;
        ArrayList<C3958e> arrayList = c3959f.f13382g0;
        HashMap map = new HashMap();
        map.put(c3959f, c3959f2);
        c3959f2.f13382g0.clear();
        c3959f2.mo7884f(c3959f, map);
        for (C3958e c3958e : arrayList) {
            if (c3958e instanceof C3954a) {
                c3963j = new C3954a();
            } else if (c3958e instanceof C3962i) {
                c3963j = new C3962i();
            } else if (c3958e instanceof C3961h) {
                c3963j = new C3961h();
            } else {
                c3963j = c3958e instanceof C3963j ? new C3963j() : new C3958e();
            }
            c3959f2.f13382g0.add(c3963j);
            C3958e c3958e2 = c3963j.f13334K;
            if (c3958e2 != null) {
                ((C3959f) c3958e2).f13382g0.remove(c3963j);
                c3963j.f13334K = null;
            }
            c3963j.f13334K = c3959f2;
            map.put(c3958e, c3963j);
        }
        for (C3958e c3958e3 : arrayList) {
            ((C3958e) map.get(c3958e3)).mo7884f(c3958e3, map);
        }
    }

    public static C3958e m7530c(C3959f c3959f, View view) {
        if (c3959f.f13346W == view) {
            return c3959f;
        }
        ArrayList arrayList = c3959f.f13382g0;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            C3958e c3958e = (C3958e) arrayList.get(i6);
            if (c3958e.f13346W == view) {
                return c3958e;
            }
        }
        return null;
    }

    public final void m7531a() {
        int i6;
        MotionLayout motionLayout = this.f12721g;
        int childCount = motionLayout.getChildCount();
        motionLayout.f1249z.clear();
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = motionLayout.getChildAt(i11);
            motionLayout.f1249z.put(childAt, new C3774o(childAt));
        }
        while (i10 < childCount) {
            View childAt2 = motionLayout.getChildAt(i10);
            C3774o c3774o = (C3774o) motionLayout.f1249z.get(childAt2);
            if (c3774o == null) {
                i6 = childCount;
            } else {
                if (this.f12717c != null) {
                    C3958e c3958eM7530c = m7530c(this.f12715a, childAt2);
                    if (c3958eM7530c != null) {
                        C0308d c0308d = this.f12717c;
                        C3785y c3785y = c3774o.f12651d;
                        c3785y.f12737c = 0.0f;
                        c3785y.f12738d = 0.0f;
                        c3774o.m7520d(c3785y);
                        float fM7906n = c3958eM7530c.m7906n();
                        float fM7907o = c3958eM7530c.m7907o();
                        float fM7905m = c3958eM7530c.m7905m();
                        i6 = childCount;
                        float fM7902j = c3958eM7530c.m7902j();
                        c3785y.f12739e = fM7906n;
                        c3785y.f12740f = fM7907o;
                        c3785y.f12741g = fM7905m;
                        c3785y.f12742h = fM7902j;
                        C0307c c0307cM897g = c0308d.m897g(c3774o.f12649b);
                        c3785y.m7538a(c0307cM897g);
                        c3774o.f12657j = c0307cM897g.f1408c.f14214f;
                        c3774o.f12653f.m7516c(c3958eM7530c, c0308d, c3774o.f12649b);
                    } else {
                        i6 = childCount;
                        if (motionLayout.f1202J != 0) {
                            Log.e("MotionLayout", AbstractC0032a.m169w() + "no widget for  " + AbstractC0032a.m171y(childAt2) + " (" + childAt2.getClass().getName() + ")");
                        }
                    }
                } else {
                    i6 = childCount;
                }
                if (this.f12718d != null) {
                    C3958e c3958eM7530c2 = m7530c(this.f12716b, childAt2);
                    if (c3958eM7530c2 != null) {
                        C0308d c0308d2 = this.f12718d;
                        C3785y c3785y2 = c3774o.f12652e;
                        c3785y2.f12737c = 1.0f;
                        c3785y2.f12738d = 1.0f;
                        c3774o.m7520d(c3785y2);
                        float fM7906n2 = c3958eM7530c2.m7906n();
                        float fM7907o2 = c3958eM7530c2.m7907o();
                        float fM7905m2 = c3958eM7530c2.m7905m();
                        float fM7902j2 = c3958eM7530c2.m7902j();
                        c3785y2.f12739e = fM7906n2;
                        c3785y2.f12740f = fM7907o2;
                        c3785y2.f12741g = fM7905m2;
                        c3785y2.f12742h = fM7902j2;
                        c3785y2.m7538a(c0308d2.m897g(c3774o.f12649b));
                        c3774o.f12654g.m7516c(c3958eM7530c2, c0308d2, c3774o.f12649b);
                    } else if (motionLayout.f1202J != 0) {
                        Log.e("MotionLayout", AbstractC0032a.m169w() + "no widget for  " + AbstractC0032a.m171y(childAt2) + " (" + childAt2.getClass().getName() + ")");
                    }
                }
            }
            i10++;
            childCount = i6;
        }
    }

    public final void m7532d(C0308d c0308d, C0308d c0308d2) {
        this.f12717c = c0308d;
        this.f12718d = c0308d2;
        this.f12715a = new C3959f();
        C3959f c3959f = new C3959f();
        this.f12716b = c3959f;
        C3959f c3959f2 = this.f12715a;
        int i6 = MotionLayout.f1192A0;
        MotionLayout motionLayout = this.f12721g;
        C3959f c3959f3 = motionLayout.f1302c;
        InterfaceC4028c interfaceC4028c = c3959f3.f13385j0;
        c3959f2.f13385j0 = interfaceC4028c;
        c3959f2.f13384i0.f13660f = interfaceC4028c;
        InterfaceC4028c interfaceC4028c2 = c3959f3.f13385j0;
        c3959f.f13385j0 = interfaceC4028c2;
        c3959f.f13384i0.f13660f = interfaceC4028c2;
        c3959f2.f13382g0.clear();
        this.f12716b.f13382g0.clear();
        m7529b(motionLayout.f1302c, this.f12715a);
        m7529b(motionLayout.f1302c, this.f12716b);
        if (motionLayout.f1196D > 0.5d) {
            if (c0308d != null) {
                m7534f(this.f12715a, c0308d);
            }
            m7534f(this.f12716b, c0308d2);
        } else {
            m7534f(this.f12716b, c0308d2);
            if (c0308d != null) {
                m7534f(this.f12715a, c0308d);
            }
        }
        this.f12715a.f13386k0 = motionLayout.m881k();
        this.f12715a.m7923G();
        this.f12716b.f13386k0 = motionLayout.m881k();
        this.f12716b.m7923G();
        ViewGroup.LayoutParams layoutParams = motionLayout.getLayoutParams();
        if (layoutParams != null) {
            int i10 = layoutParams.width;
            EnumC3957d enumC3957d = EnumC3957d.f13320b;
            if (i10 == -2) {
                this.f12715a.m7916x(enumC3957d);
                this.f12716b.m7916x(enumC3957d);
            }
            if (layoutParams.height == -2) {
                this.f12715a.m7917y(enumC3957d);
                this.f12716b.m7917y(enumC3957d);
            }
        }
    }

    public final void m7533e() {
        MotionLayout motionLayout = this.f12721g;
        int i6 = motionLayout.f1243w;
        int i10 = motionLayout.f1245x;
        int mode = View.MeasureSpec.getMode(i6);
        int mode2 = View.MeasureSpec.getMode(i10);
        motionLayout.f1229o0 = mode;
        motionLayout.f1230p0 = mode2;
        int optimizationLevel = motionLayout.getOptimizationLevel();
        if (motionLayout.f1239u == motionLayout.getStartState()) {
            motionLayout.m883n(this.f12716b, optimizationLevel, i6, i10);
            if (this.f12717c != null) {
                motionLayout.m883n(this.f12715a, optimizationLevel, i6, i10);
            }
        } else {
            if (this.f12717c != null) {
                motionLayout.m883n(this.f12715a, optimizationLevel, i6, i10);
            }
            motionLayout.m883n(this.f12716b, optimizationLevel, i6, i10);
        }
        int i11 = 0;
        if (!(motionLayout.getParent() instanceof MotionLayout) || mode != 1073741824 || mode2 != 1073741824) {
            motionLayout.f1229o0 = mode;
            motionLayout.f1230p0 = mode2;
            if (motionLayout.f1239u == motionLayout.getStartState()) {
                motionLayout.m883n(this.f12716b, optimizationLevel, i6, i10);
                if (this.f12717c != null) {
                    motionLayout.m883n(this.f12715a, optimizationLevel, i6, i10);
                }
            } else {
                if (this.f12717c != null) {
                    motionLayout.m883n(this.f12715a, optimizationLevel, i6, i10);
                }
                motionLayout.m883n(this.f12716b, optimizationLevel, i6, i10);
            }
            motionLayout.f1225k0 = this.f12715a.m7905m();
            motionLayout.f1226l0 = this.f12715a.m7902j();
            motionLayout.f1227m0 = this.f12716b.m7905m();
            int iM7902j = this.f12716b.m7902j();
            motionLayout.f1228n0 = iM7902j;
            motionLayout.f1224j0 = (motionLayout.f1225k0 == motionLayout.f1227m0 && motionLayout.f1226l0 == iM7902j) ? false : true;
        }
        int i12 = motionLayout.f1225k0;
        int i13 = motionLayout.f1226l0;
        int i14 = motionLayout.f1229o0;
        if (i14 == Integer.MIN_VALUE || i14 == 0) {
            i12 = (int) ((motionLayout.f1232q0 * (motionLayout.f1227m0 - i12)) + i12);
        }
        int i15 = i12;
        int i16 = motionLayout.f1230p0;
        int i17 = (i16 == Integer.MIN_VALUE || i16 == 0) ? (int) ((motionLayout.f1232q0 * (motionLayout.f1228n0 - i13)) + i13) : i13;
        C3959f c3959f = this.f12715a;
        motionLayout.m882m(i6, i10, i15, i17, c3959f.f13395t0 || this.f12716b.f13395t0, c3959f.f13396u0 || this.f12716b.f13396u0);
        int childCount = motionLayout.getChildCount();
        motionLayout.f1242v0.m7531a();
        motionLayout.f1200H = true;
        motionLayout.getWidth();
        motionLayout.getHeight();
        C3749b0 c3749b0 = motionLayout.f1231q.f12578c;
        int i18 = c3749b0 != null ? c3749b0.f12573p : -1;
        HashMap map = motionLayout.f1249z;
        if (i18 != -1) {
            for (int i19 = 0; i19 < childCount; i19++) {
                C3774o c3774o = (C3774o) map.get(motionLayout.getChildAt(i19));
                if (c3774o != null) {
                    c3774o.f12672y = i18;
                }
            }
        }
        for (int i20 = 0; i20 < childCount; i20++) {
            C3774o c3774o2 = (C3774o) map.get(motionLayout.getChildAt(i20));
            if (c3774o2 != null) {
                motionLayout.f1231q.m7495e(c3774o2);
                c3774o2.m7521e(motionLayout.getNanoTime());
            }
        }
        C3749b0 c3749b1 = motionLayout.f1231q.f12578c;
        float f = c3749b1 != null ? c3749b1.f12566i : 0.0f;
        if (f != 0.0f) {
            boolean z7 = ((double) f) < 0.0d;
            float fAbs = Math.abs(f);
            float fMax = -3.4028235E38f;
            float fMin = Float.MAX_VALUE;
            float fMin2 = Float.MAX_VALUE;
            float fMax2 = -3.4028235E38f;
            for (int i21 = 0; i21 < childCount; i21++) {
                C3774o c3774o3 = (C3774o) map.get(motionLayout.getChildAt(i21));
                if (!Float.isNaN(c3774o3.f12657j)) {
                    for (int i22 = 0; i22 < childCount; i22++) {
                        C3774o c3774o4 = (C3774o) map.get(motionLayout.getChildAt(i22));
                        if (!Float.isNaN(c3774o4.f12657j)) {
                            fMin = Math.min(fMin, c3774o4.f12657j);
                            fMax = Math.max(fMax, c3774o4.f12657j);
                        }
                    }
                    while (i11 < childCount) {
                        C3774o c3774o5 = (C3774o) map.get(motionLayout.getChildAt(i11));
                        if (!Float.isNaN(c3774o5.f12657j)) {
                            c3774o5.f12659l = 1.0f / (1.0f - fAbs);
                            if (z7) {
                                c3774o5.f12658k = fAbs - (((fMax - c3774o5.f12657j) / (fMax - fMin)) * fAbs);
                            } else {
                                c3774o5.f12658k = fAbs - (((c3774o5.f12657j - fMin) * fAbs) / (fMax - fMin));
                            }
                        }
                        i11++;
                    }
                    return;
                }
                C3785y c3785y = c3774o3.f12652e;
                float f3 = c3785y.f12739e;
                float f4 = c3785y.f12740f;
                float f5 = z7 ? f4 - f3 : f4 + f3;
                fMin2 = Math.min(fMin2, f5);
                fMax2 = Math.max(fMax2, f5);
            }
            while (i11 < childCount) {
                C3774o c3774o6 = (C3774o) map.get(motionLayout.getChildAt(i11));
                C3785y c3785y2 = c3774o6.f12652e;
                float f10 = c3785y2.f12739e;
                float f11 = c3785y2.f12740f;
                float f12 = z7 ? f11 - f10 : f11 + f10;
                c3774o6.f12659l = 1.0f / (1.0f - fAbs);
                c3774o6.f12658k = fAbs - (((f12 - fMin2) * fAbs) / (fMax2 - fMin2));
                i11++;
            }
        }
    }

    public final void m7534f(C3959f c3959f, C0308d c0308d) {
        SparseArray sparseArray = new SparseArray();
        Constraints.LayoutParams layoutParams = new Constraints.LayoutParams();
        sparseArray.clear();
        sparseArray.put(0, c3959f);
        MotionLayout motionLayout = this.f12721g;
        sparseArray.put(motionLayout.getId(), c3959f);
        for (C3958e c3958e : c3959f.f13382g0) {
            sparseArray.put(c3958e.f13346W.getId(), c3958e);
        }
        for (C3958e c3958e2 : c3959f.f13382g0) {
            View view = c3958e2.f13346W;
            int id = view.getId();
            HashMap map = c0308d.f1416c;
            if (map.containsKey(Integer.valueOf(id))) {
                ((C0307c) map.get(Integer.valueOf(id))).m887a(layoutParams);
            }
            c3958e2.m7918z(c0308d.m897g(view.getId()).f1409d.f14176c);
            c3958e2.m7915w(c0308d.m897g(view.getId()).f1409d.f14178d);
            if (view instanceof ConstraintHelper) {
                ConstraintHelper constraintHelper = (ConstraintHelper) view;
                int id2 = constraintHelper.getId();
                HashMap map2 = c0308d.f1416c;
                if (map2.containsKey(Integer.valueOf(id2))) {
                    C0307c c0307c = (C0307c) map2.get(Integer.valueOf(id2));
                    if (c3958e2 instanceof C3963j) {
                        constraintHelper.mo842h(c0307c, (C3963j) c3958e2, layoutParams, sparseArray);
                    }
                }
                if (view instanceof Barrier) {
                    ((Barrier) view).m876l();
                }
            }
            layoutParams.resolveLayoutDirection(motionLayout.getLayoutDirection());
            int i6 = MotionLayout.f1192A0;
            this.f12721g.m877c(false, view, c3958e2, layoutParams, sparseArray);
            if (c0308d.m897g(view.getId()).f1407b.f14218c == 1) {
                c3958e2.f13347X = view.getVisibility();
            } else {
                c3958e2.f13347X = c0308d.m897g(view.getId()).f1407b.f14217b;
            }
        }
        for (C3958e c3958e3 : c3959f.f13382g0) {
            if (c3958e3 instanceof C3961h) {
                ConstraintHelper constraintHelper2 = (ConstraintHelper) c3958e3.f13346W;
                C3963j c3963j = (C3963j) c3958e3;
                constraintHelper2.getClass();
                c3963j.f13457h0 = 0;
                Arrays.fill(c3963j.f13456g0, (Object) null);
                for (int i10 = 0; i10 < constraintHelper2.f1293b; i10++) {
                    c3963j.m7935C((C3958e) sparseArray.get(constraintHelper2.f1292a[i10]));
                }
                C3961h c3961h = (C3961h) c3963j;
                for (int i11 = 0; i11 < c3961h.f13457h0; i11++) {
                    C3958e c3958e4 = c3961h.f13456g0[i11];
                }
            }
        }
    }
}
