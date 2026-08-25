package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.C0307c;
import androidx.constraintlayout.widget.C0308d;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import p000a.AbstractC0004e;
import p003a2.AbstractC0032a;
import p028c6.C1399b;
import p055ea.AbstractC2460q;
import p138n0.InterfaceC3148q;
import p173q1.C3406f0;
import p194s.C3678b;
import p194s.C3681e;
import p194s.C3683g;
import p205t.AbstractC3761h0;
import p205t.AbstractC3762i;
import p205t.AbstractInterpolatorC3776p;
import p205t.C3746a;
import p205t.C3749b0;
import p205t.C3751c0;
import p205t.C3772n;
import p205t.C3774o;
import p205t.C3775o0;
import p205t.C3778r;
import p205t.C3779s;
import p205t.C3780t;
import p205t.C3781u;
import p205t.C3782v;
import p205t.C3785y;
import p205t.EnumC3784x;
import p205t.InterfaceC3783w;
import p205t.RunnableC3777q;
import p205t.ViewOnClickListenerC3747a0;
import p205t.ViewOnTouchListenerC3773n0;
import p225v.C3959f;
import p256y.AbstractC4193j;
import p256y.C4187d;
import p256y.C4189f;
import p256y.C4190g;
import p256y.C4194k;
import p256y.C4195l;

public class MotionLayout extends ConstraintLayout implements InterfaceC3148q {

    public static final int f1192A0 = 0;

    public long f1193A;

    public float f1194B;

    public float f1195C;

    public float f1196D;

    public long f1197E;

    public float f1198F;

    public boolean f1199G;

    public boolean f1200H;

    public InterfaceC3783w f1201I;

    public int f1202J;

    public C3779s f1203K;

    public boolean f1204L;

    public final C3683g f1205M;

    public final C3778r f1206N;

    public C3746a f1207O;

    public int f1208P;

    public int f1209Q;

    public boolean f1210R;

    public float f1211S;

    public float f1212T;

    public long f1213U;

    public float f1214V;

    public boolean f1215W;

    public ArrayList f1216b0;

    public ArrayList f1217c0;

    public ArrayList f1218d0;

    public int f1219e0;

    public long f1220f0;

    public float f1221g0;

    public int f1222h0;

    public float f1223i0;

    public boolean f1224j0;

    public int f1225k0;

    public int f1226l0;

    public int f1227m0;

    public int f1228n0;

    public int f1229o0;

    public int f1230p0;

    public C3751c0 f1231q;

    public float f1232q0;

    public Interpolator f1233r;

    public final C3781u f1234r0;

    public float f1235s;

    public boolean f1236s0;

    public int f1237t;

    public C3782v f1238t0;

    public int f1239u;

    public EnumC3784x f1240u0;

    public int f1241v;

    public final C3780t f1242v0;

    public int f1243w;

    public boolean f1244w0;

    public int f1245x;

    public final RectF f1246x0;

    public boolean f1247y;

    public View f1248y0;

    public final HashMap f1249z;

    public final ArrayList f1250z0;

    public MotionLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1235s = 0.0f;
        this.f1237t = -1;
        this.f1239u = -1;
        this.f1241v = -1;
        this.f1243w = 0;
        this.f1245x = 0;
        this.f1247y = true;
        this.f1249z = new HashMap();
        this.f1193A = 0L;
        this.f1194B = 1.0f;
        this.f1195C = 0.0f;
        this.f1196D = 0.0f;
        this.f1198F = 0.0f;
        this.f1200H = false;
        this.f1202J = 0;
        this.f1204L = false;
        this.f1205M = new C3683g();
        this.f1206N = new C3778r(this);
        this.f1210R = false;
        this.f1215W = false;
        this.f1216b0 = null;
        this.f1217c0 = null;
        this.f1218d0 = null;
        this.f1219e0 = 0;
        this.f1220f0 = -1L;
        this.f1221g0 = 0.0f;
        this.f1222h0 = 0;
        this.f1223i0 = 0.0f;
        this.f1224j0 = false;
        this.f1234r0 = new C3781u();
        this.f1236s0 = false;
        this.f1240u0 = EnumC3784x.f12729a;
        this.f1242v0 = new C3780t(this);
        this.f1244w0 = false;
        this.f1246x0 = new RectF();
        this.f1248y0 = null;
        this.f1250z0 = new ArrayList();
        m859u(attributeSet);
    }

    public final void m850A(float f, float f3, int i6) {
        boolean z7;
        C3775o0 c3775o0;
        float f4;
        float f5;
        float fM7496f;
        C3749b0 c3749b0;
        float f10;
        C3683g c3683g;
        C3775o0 c3775o1;
        if (this.f1231q == null || this.f1196D == f) {
            return;
        }
        this.f1204L = true;
        this.f1193A = getNanoTime();
        C3751c0 c3751c0 = this.f1231q;
        C3749b0 c3749b1 = c3751c0.f12578c;
        float f11 = (c3749b1 != null ? c3749b1.f12565h : c3751c0.f12585j) / 1000.0f;
        this.f1194B = f11;
        this.f1198F = f;
        this.f1200H = true;
        C3683g c3683g2 = this.f1205M;
        if (i6 == 0 || i6 == 1 || i6 == 2) {
            if (i6 == 1) {
                f = 0.0f;
            } else if (i6 == 2) {
                f = 1.0f;
            }
            float f12 = this.f1196D;
            float fM7496f2 = c3751c0.m7496f();
            C3749b0 c3749b2 = this.f1231q.f12578c;
            float f13 = (c3749b2 == null || (c3775o0 = c3749b2.f12569l) == null) ? 0.0f : c3775o0.f12690p;
            C3683g c3683g3 = this.f1205M;
            c3683g3.f12338l = f12;
            z7 = f12 > f;
            c3683g3.f12337k = z7;
            if (z7) {
                c3683g3.m7437c(-f3, f12 - f, fM7496f2, f13, f11);
            } else {
                c3683g3.m7437c(f3, f - f12, fM7496f2, f13, f11);
            }
            int i10 = this.f1239u;
            this.f1198F = f;
            this.f1239u = i10;
            this.f1233r = c3683g2;
        } else {
            C3778r c3778r = this.f1206N;
            if (i6 == 4) {
                float f14 = this.f1196D;
                float fM7496f3 = c3751c0.m7496f();
                c3778r.f12697a = f3;
                c3778r.f12698b = f14;
                c3778r.f12699c = fM7496f3;
                this.f1233r = c3778r;
            } else if (i6 == 5) {
                float f15 = this.f1196D;
                float fM7496f4 = c3751c0.m7496f();
                if (f3 > 0.0f) {
                    float f16 = f3 / fM7496f4;
                    if (((f3 * f16) - (((fM7496f4 * f16) * f16) / 2.0f)) + f15 > 1.0f) {
                        float f17 = this.f1196D;
                        float fM7496f5 = this.f1231q.m7496f();
                        c3778r.f12697a = f3;
                        c3778r.f12698b = f17;
                        c3778r.f12699c = fM7496f5;
                        this.f1233r = c3778r;
                    } else {
                        f4 = this.f1196D;
                        f5 = this.f1194B;
                        fM7496f = this.f1231q.m7496f();
                        c3749b0 = this.f1231q.f12578c;
                        if (c3749b0 != null || (c3775o1 = c3749b0.f12569l) == null) {
                            f10 = 0.0f;
                        } else {
                            f10 = c3775o1.f12690p;
                        }
                        c3683g = this.f1205M;
                        c3683g.f12338l = f4;
                        z7 = f4 > f;
                        c3683g.f12337k = z7;
                        if (z7) {
                            c3683g.m7437c(-f3, f4 - f, fM7496f, f10, f5);
                        } else {
                            c3683g.m7437c(f3, f - f4, fM7496f, f10, f5);
                        }
                        this.f1235s = 0.0f;
                        int i11 = this.f1239u;
                        this.f1198F = f;
                        this.f1239u = i11;
                        this.f1233r = c3683g2;
                    }
                } else {
                    float f18 = (-f3) / fM7496f4;
                    if ((((fM7496f4 * f18) * f18) / 2.0f) + (f3 * f18) + f15 < 0.0f) {
                        float f19 = this.f1196D;
                        float fM7496f6 = this.f1231q.m7496f();
                        c3778r.f12697a = f3;
                        c3778r.f12698b = f19;
                        c3778r.f12699c = fM7496f6;
                        this.f1233r = c3778r;
                    } else {
                        f4 = this.f1196D;
                        f5 = this.f1194B;
                        fM7496f = this.f1231q.m7496f();
                        c3749b0 = this.f1231q.f12578c;
                        if (c3749b0 != null) {
                            f10 = 0.0f;
                        } else {
                            f10 = 0.0f;
                        }
                        c3683g = this.f1205M;
                        c3683g.f12338l = f4;
                        if (f4 > f) {
                        }
                        c3683g.f12337k = z7;
                        if (z7) {
                            c3683g.m7437c(-f3, f4 - f, fM7496f, f10, f5);
                        } else {
                            c3683g.m7437c(f3, f - f4, fM7496f, f10, f5);
                        }
                        this.f1235s = 0.0f;
                        int i12 = this.f1239u;
                        this.f1198F = f;
                        this.f1239u = i12;
                        this.f1233r = c3683g2;
                    }
                }
            }
        }
        this.f1199G = false;
        this.f1193A = getNanoTime();
        invalidate();
    }

    public final void m851B(int i6) {
        C1399b c1399b;
        if (!super.isAttachedToWindow()) {
            if (this.f1238t0 == null) {
                this.f1238t0 = new C3782v(this);
            }
            this.f1238t0.f12727d = i6;
            return;
        }
        C3751c0 c3751c0 = this.f1231q;
        if (c3751c0 != null && (c1399b = c3751c0.f12577b) != null) {
            int i10 = this.f1239u;
            float f = -1;
            C4194k c4194k = (C4194k) ((SparseArray) c1399b.f4262b).get(i6);
            if (c4194k != null) {
                ArrayList arrayList = c4194k.f14257b;
                int i11 = c4194k.f14258c;
                if (f != -1.0f && f != -1.0f) {
                    Iterator it = arrayList.iterator();
                    C4195l c4195l = null;
                    while (true) {
                        if (!it.hasNext()) {
                            if (c4195l != null) {
                                i10 = c4195l.f14263e;
                                break;
                            } else {
                                i10 = i11;
                                break;
                            }
                        }
                        C4195l c4195l2 = (C4195l) it.next();
                        if (c4195l2.m8248a(f, f)) {
                            if (i10 == c4195l2.f14263e) {
                                break;
                            } else {
                                c4195l = c4195l2;
                            }
                        }
                    }
                } else if (i11 != i10) {
                    Iterator it2 = arrayList.iterator();
                    do {
                        if (!it2.hasNext()) {
                            i10 = i11;
                            break;
                        }
                    } while (i10 != ((C4195l) it2.next()).f14263e);
                }
            } else {
                i10 = i6;
            }
            if (i10 != -1) {
                i6 = i10;
            }
        }
        int i12 = this.f1239u;
        if (i12 == i6) {
            return;
        }
        if (this.f1237t == i6) {
            m853o(0.0f);
            return;
        }
        if (this.f1241v == i6) {
            m853o(1.0f);
            return;
        }
        this.f1241v = i6;
        if (i12 != -1) {
            m864z(i12, i6);
            m853o(1.0f);
            this.f1196D = 0.0f;
            m853o(1.0f);
            return;
        }
        this.f1204L = false;
        this.f1198F = 1.0f;
        this.f1195C = 0.0f;
        this.f1196D = 0.0f;
        this.f1197E = getNanoTime();
        this.f1193A = getNanoTime();
        this.f1199G = false;
        this.f1233r = null;
        C3751c0 c3751c1 = this.f1231q;
        C3749b0 c3749b0 = c3751c1.f12578c;
        this.f1194B = (c3749b0 != null ? c3749b0.f12565h : c3751c1.f12585j) / 1000.0f;
        this.f1237t = -1;
        c3751c1.m7501k(-1, this.f1241v);
        this.f1231q.m7497g();
        int childCount = getChildCount();
        HashMap map = this.f1249z;
        map.clear();
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            map.put(childAt, new C3774o(childAt));
        }
        this.f1200H = true;
        C0308d c0308dM7492b = this.f1231q.m7492b(i6);
        C3780t c3780t = this.f1242v0;
        c3780t.m7532d(null, c0308dM7492b);
        m862x();
        c3780t.m7531a();
        int childCount2 = getChildCount();
        for (int i14 = 0; i14 < childCount2; i14++) {
            View childAt2 = getChildAt(i14);
            C3774o c3774o = (C3774o) map.get(childAt2);
            if (c3774o != null) {
                C3785y c3785y = c3774o.f12651d;
                c3785y.f12737c = 0.0f;
                c3785y.f12738d = 0.0f;
                float x10 = childAt2.getX();
                float y7 = childAt2.getY();
                float width = childAt2.getWidth();
                float height = childAt2.getHeight();
                c3785y.f12739e = x10;
                c3785y.f12740f = y7;
                c3785y.f12741g = width;
                c3785y.f12742h = height;
                C3772n c3772n = c3774o.f12653f;
                c3772n.getClass();
                childAt2.getX();
                childAt2.getY();
                childAt2.getWidth();
                childAt2.getHeight();
                c3772n.f12632c = childAt2.getVisibility();
                c3772n.f12630a = childAt2.getVisibility() != 0 ? 0.0f : childAt2.getAlpha();
                c3772n.f12633d = childAt2.getElevation();
                c3772n.f12634e = childAt2.getRotation();
                c3772n.f12635f = childAt2.getRotationX();
                c3772n.f12636g = childAt2.getRotationY();
                c3772n.f12637h = childAt2.getScaleX();
                c3772n.f12638i = childAt2.getScaleY();
                c3772n.f12639j = childAt2.getPivotX();
                c3772n.f12640k = childAt2.getPivotY();
                c3772n.f12641l = childAt2.getTranslationX();
                c3772n.f12642m = childAt2.getTranslationY();
                c3772n.f12643n = childAt2.getTranslationZ();
            }
        }
        getWidth();
        getHeight();
        for (int i15 = 0; i15 < childCount; i15++) {
            C3774o c3774o2 = (C3774o) map.get(getChildAt(i15));
            this.f1231q.m7495e(c3774o2);
            c3774o2.m7521e(getNanoTime());
        }
        C3749b0 c3749b1 = this.f1231q.f12578c;
        float f3 = c3749b1 != null ? c3749b1.f12566i : 0.0f;
        if (f3 != 0.0f) {
            float fMin = Float.MAX_VALUE;
            float fMax = -3.4028235E38f;
            for (int i16 = 0; i16 < childCount; i16++) {
                C3785y c3785y2 = ((C3774o) map.get(getChildAt(i16))).f12652e;
                float f4 = c3785y2.f12740f + c3785y2.f12739e;
                fMin = Math.min(fMin, f4);
                fMax = Math.max(fMax, f4);
            }
            for (int i17 = 0; i17 < childCount; i17++) {
                C3774o c3774o3 = (C3774o) map.get(getChildAt(i17));
                C3785y c3785y3 = c3774o3.f12652e;
                float f5 = c3785y3.f12739e;
                float f10 = c3785y3.f12740f;
                c3774o3.f12659l = 1.0f / (1.0f - f3);
                c3774o3.f12658k = f3 - ((((f5 + f10) - fMin) * f3) / (fMax - fMin));
            }
        }
        this.f1195C = 0.0f;
        this.f1196D = 0.0f;
        this.f1200H = true;
        invalidate();
    }

    @Override
    public final void mo548b(View view, int i6, int i10, int[] iArr, int i11) {
        C3749b0 c3749b0;
        boolean z7;
        C3775o0 c3775o0;
        float f;
        C3775o0 c3775o1;
        C3775o0 c3775o2;
        int i12;
        C3751c0 c3751c0 = this.f1231q;
        if (c3751c0 == null || (c3749b0 = c3751c0.f12578c) == null || (z7 = c3749b0.f12572o)) {
            return;
        }
        if (z7 || (c3775o2 = c3749b0.f12569l) == null || (i12 = c3775o2.f12679e) == -1 || view.getId() == i12) {
            C3751c0 c3751c1 = this.f1231q;
            if (c3751c1 != null) {
                C3749b0 c3749b1 = c3751c1.f12578c;
                if ((c3749b1 == null || (c3775o1 = c3749b1.f12569l) == null) ? false : c3775o1.f12692r) {
                    float f3 = this.f1195C;
                    if ((f3 == 1.0f || f3 == 0.0f) && view.canScrollVertically(-1)) {
                        return;
                    }
                }
            }
            if (c3749b0.f12569l != null) {
                C3775o0 c3775o3 = this.f1231q.f12578c.f12569l;
                if ((c3775o3.f12694t & 1) != 0) {
                    float f4 = i6;
                    float f5 = i10;
                    c3775o3.f12689o.m857s(c3775o3.f12678d, c3775o3.f12689o.getProgress(), c3775o3.f12682h, c3775o3.f12681g, c3775o3.f12686l);
                    float f10 = c3775o3.f12683i;
                    float[] fArr = c3775o3.f12686l;
                    if (f10 != 0.0f) {
                        if (fArr[0] == 0.0f) {
                            fArr[0] = 1.0E-7f;
                        }
                        f = (f4 * f10) / fArr[0];
                    } else {
                        if (fArr[1] == 0.0f) {
                            fArr[1] = 1.0E-7f;
                        }
                        f = (f5 * c3775o3.f12684j) / fArr[1];
                    }
                    float f11 = this.f1196D;
                    if ((f11 <= 0.0f && f < 0.0f) || (f11 >= 1.0f && f > 0.0f)) {
                        view.setNestedScrollingEnabled(false);
                        view.post(new RunnableC3777q((ViewGroup) view));
                        return;
                    }
                }
            }
            float f12 = this.f1195C;
            long nanoTime = getNanoTime();
            float f13 = i6;
            this.f1211S = f13;
            float f14 = i10;
            this.f1212T = f14;
            this.f1214V = (float) ((nanoTime - this.f1213U) * 1.0E-9d);
            this.f1213U = nanoTime;
            C3749b0 c3749b2 = this.f1231q.f12578c;
            if (c3749b2 != null && (c3775o0 = c3749b2.f12569l) != null) {
                MotionLayout motionLayout = c3775o0.f12689o;
                float progress = motionLayout.getProgress();
                if (!c3775o0.f12685k) {
                    c3775o0.f12685k = true;
                    motionLayout.setProgress(progress);
                }
                c3775o0.f12689o.m857s(c3775o0.f12678d, progress, c3775o0.f12682h, c3775o0.f12681g, c3775o0.f12686l);
                float f15 = c3775o0.f12683i;
                float[] fArr2 = c3775o0.f12686l;
                if (Math.abs((c3775o0.f12684j * fArr2[1]) + (f15 * fArr2[0])) < 0.01d) {
                    fArr2[0] = 0.01f;
                    fArr2[1] = 0.01f;
                }
                float f16 = c3775o0.f12683i;
                float fMax = Math.max(Math.min(progress + (f16 != 0.0f ? (f13 * f16) / fArr2[0] : (f14 * c3775o0.f12684j) / fArr2[1]), 1.0f), 0.0f);
                if (fMax != motionLayout.getProgress()) {
                    motionLayout.setProgress(fMax);
                }
            }
            if (f12 != this.f1195C) {
                iArr[0] = i6;
                iArr[1] = i10;
            }
            m854p(false);
            if (iArr[0] == 0 && iArr[1] == 0) {
                return;
            }
            this.f1210R = true;
        }
    }

    @Override
    public final void dispatchDraw(Canvas canvas) {
        int i6;
        ArrayList<C3785y> arrayList;
        int i10;
        Iterator it;
        int i11;
        AbstractC3761h0 abstractC3761h0;
        Paint paint;
        double dMo7428a;
        Paint paint2;
        Canvas canvas2 = canvas;
        int i12 = 0;
        m854p(false);
        super.dispatchDraw(canvas);
        if (this.f1231q == null) {
            return;
        }
        if ((this.f1202J & 1) == 1 && !isInEditMode()) {
            this.f1219e0++;
            long nanoTime = getNanoTime();
            long j10 = this.f1220f0;
            if (j10 != -1) {
                long j11 = nanoTime - j10;
                if (j11 > 200000000) {
                    this.f1221g0 = ((int) ((this.f1219e0 / (j11 * 1.0E-9f)) * 100.0f)) / 100.0f;
                    this.f1219e0 = 0;
                    this.f1220f0 = nanoTime;
                }
            } else {
                this.f1220f0 = nanoTime;
            }
            Paint paint3 = new Paint();
            paint3.setTextSize(42.0f);
            float progress = ((int) (getProgress() * 1000.0f)) / 10.0f;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f1221g0);
            sb.append(" fps ");
            int i13 = this.f1237t;
            StringBuilder sbM5498l = AbstractC2460q.m5498l(AbstractC0004e.m26t(sb, i13 == -1 ? "UNDEFINED" : getContext().getResources().getResourceEntryName(i13), " -> "));
            int i14 = this.f1241v;
            sbM5498l.append(i14 == -1 ? "UNDEFINED" : getContext().getResources().getResourceEntryName(i14));
            sbM5498l.append(" (progress: ");
            sbM5498l.append(progress);
            sbM5498l.append(" ) state=");
            int i15 = this.f1239u;
            sbM5498l.append(i15 == -1 ? "undefined" : i15 != -1 ? getContext().getResources().getResourceEntryName(i15) : "UNDEFINED");
            String string = sbM5498l.toString();
            paint3.setColor(-16777216);
            canvas2.drawText(string, 11.0f, getHeight() - 29, paint3);
            paint3.setColor(-7864184);
            canvas2.drawText(string, 10.0f, getHeight() - 30, paint3);
        }
        if (this.f1202J > 1) {
            if (this.f1203K == null) {
                this.f1203K = new C3779s(this);
            }
            C3779s c3779s = this.f1203K;
            HashMap map = this.f1249z;
            C3751c0 c3751c0 = this.f1231q;
            C3749b0 c3749b0 = c3751c0.f12578c;
            int i16 = c3749b0 != null ? c3749b0.f12565h : c3751c0.f12585j;
            int i17 = this.f1202J;
            c3779s.getClass();
            if (map == null || map.size() == 0) {
                return;
            }
            canvas.save();
            MotionLayout motionLayout = c3779s.f12714n;
            boolean zIsInEditMode = motionLayout.isInEditMode();
            Paint paint4 = c3779s.f12705e;
            if (!zIsInEditMode && (i17 & 1) == 2) {
                String str = motionLayout.getContext().getResources().getResourceName(motionLayout.f1241v) + ":" + motionLayout.getProgress();
                canvas2.drawText(str, 10.0f, motionLayout.getHeight() - 30, c3779s.f12708h);
                canvas2.drawText(str, 11.0f, motionLayout.getHeight() - 29, paint4);
            }
            Iterator it2 = map.values().iterator();
            while (it2.hasNext()) {
                C3774o c3774o = (C3774o) it2.next();
                int iMax = c3774o.f12651d.f12736b;
                ArrayList arrayList2 = c3774o.f12666s;
                Iterator it3 = arrayList2.iterator();
                while (it3.hasNext()) {
                    iMax = Math.max(iMax, ((C3785y) it3.next()).f12736b);
                }
                int iMax2 = Math.max(iMax, c3774o.f12652e.f12736b);
                if (i17 > 0 && iMax2 == 0) {
                    iMax2 = 1;
                }
                if (iMax2 != 0) {
                    C3785y c3785y = c3774o.f12651d;
                    float[] fArr = c3779s.f12703c;
                    if (fArr != null) {
                        double[] dArrMo7280w = c3774o.f12655h[i12].mo7280w();
                        int[] iArr = c3779s.f12702b;
                        if (iArr != null) {
                            Iterator it4 = arrayList2.iterator();
                            int i18 = 0;
                            while (it4.hasNext()) {
                                ((C3785y) it4.next()).getClass();
                                iArr[i18] = i12;
                                i18++;
                            }
                        }
                        int i19 = 0;
                        int i20 = 0;
                        while (i20 < dArrMo7280w.length) {
                            c3774o.f12655h[0].mo7276r(dArrMo7280w[i20], c3774o.f12661n);
                            c3785y.m7539c(c3774o.f12660m, c3774o.f12661n, fArr, i19);
                            i19 += 2;
                            i20++;
                            i17 = i17;
                            arrayList2 = arrayList2;
                        }
                        i6 = i17;
                        arrayList = arrayList2;
                        i10 = i19 / 2;
                    } else {
                        i6 = i17;
                        arrayList = arrayList2;
                        i10 = 0;
                    }
                    c3779s.f12711k = i10;
                    if (iMax2 >= 1) {
                        int i21 = i16 / 16;
                        float[] fArr2 = c3779s.f12701a;
                        if (fArr2 == null || fArr2.length != i21 * 2) {
                            c3779s.f12701a = new float[i21 * 2];
                            c3779s.f12704d = new Path();
                        }
                        int i22 = c3779s.f12713m;
                        float f = i22;
                        canvas2.translate(f, f);
                        paint4.setColor(1996488704);
                        Paint paint5 = c3779s.f12709i;
                        paint5.setColor(1996488704);
                        Paint paint6 = c3779s.f12706f;
                        paint6.setColor(1996488704);
                        Paint paint7 = c3779s.f12707g;
                        paint7.setColor(1996488704);
                        float[] fArr3 = c3779s.f12701a;
                        float f3 = 1.0f / (i21 - 1);
                        HashMap map2 = c3774o.f12670w;
                        it = it2;
                        AbstractC3761h0 abstractC3761h1 = map2 == null ? null : (AbstractC3761h0) map2.get("translationX");
                        HashMap map3 = c3774o.f12670w;
                        AbstractC3761h0 abstractC3761h2 = map3 == null ? null : (AbstractC3761h0) map3.get("translationY");
                        HashMap map4 = c3774o.f12671x;
                        AbstractC3762i abstractC3762i = map4 == null ? null : (AbstractC3762i) map4.get("translationX");
                        HashMap map5 = c3774o.f12671x;
                        AbstractC3762i abstractC3762i2 = map5 == null ? null : (AbstractC3762i) map5.get("translationY");
                        int i23 = 0;
                        while (true) {
                            float f4 = Float.NaN;
                            float f5 = 0.0f;
                            if (i23 >= i21) {
                                break;
                            }
                            int i24 = i21;
                            float f10 = i23 * f3;
                            float f11 = f3;
                            float f12 = c3774o.f12659l;
                            if (f12 != 1.0f) {
                                paint = paint5;
                                float f13 = c3774o.f12658k;
                                if (f10 < f13) {
                                    f10 = 0.0f;
                                }
                                if (f10 > f13) {
                                    i11 = iMax2;
                                    abstractC3761h0 = abstractC3761h2;
                                    if (f10 < 1.0d) {
                                        f10 = (f10 - f13) * f12;
                                    }
                                } else {
                                    i11 = iMax2;
                                    abstractC3761h0 = abstractC3761h2;
                                }
                            } else {
                                i11 = iMax2;
                                abstractC3761h0 = abstractC3761h2;
                                paint = paint5;
                            }
                            double d = f10;
                            C3681e c3681e = c3785y.f12735a;
                            for (C3785y c3785y2 : arrayList) {
                                double d10 = d;
                                C3681e c3681e2 = c3785y2.f12735a;
                                if (c3681e2 != null) {
                                    float f14 = c3785y2.f12737c;
                                    if (f14 < f10) {
                                        f5 = f14;
                                        c3681e = c3681e2;
                                    } else if (Float.isNaN(f4)) {
                                        f4 = c3785y2.f12737c;
                                    }
                                }
                                d = d10;
                            }
                            double d11 = d;
                            if (c3681e != null) {
                                if (Float.isNaN(f4)) {
                                    f4 = 1.0f;
                                }
                                float f15 = f4 - f5;
                                dMo7428a = (((float) c3681e.mo7428a((f10 - f5) / f15)) * f15) + f5;
                            } else {
                                dMo7428a = d11;
                            }
                            c3774o.f12655h[0].mo7276r(dMo7428a, c3774o.f12661n);
                            C3678b c3678b = c3774o.f12656i;
                            if (c3678b != null) {
                                double[] dArr = c3774o.f12661n;
                                paint2 = paint6;
                                if (dArr.length > 0) {
                                    c3678b.mo7276r(dMo7428a, dArr);
                                }
                            } else {
                                paint2 = paint6;
                            }
                            int i25 = i23 * 2;
                            c3785y.m7539c(c3774o.f12660m, c3774o.f12661n, fArr3, i25);
                            if (abstractC3762i != null) {
                                fArr3[i25] = abstractC3762i.m7508a(f10) + fArr3[i25];
                            } else if (abstractC3761h1 != null) {
                                fArr3[i25] = abstractC3761h1.m7507a(f10) + fArr3[i25];
                            }
                            if (abstractC3762i2 != null) {
                                int i26 = i25 + 1;
                                fArr3[i26] = abstractC3762i2.m7508a(f10) + fArr3[i26];
                            } else {
                                if (abstractC3761h0 != null) {
                                    int i27 = i25 + 1;
                                    abstractC3761h2 = abstractC3761h0;
                                    fArr3[i27] = abstractC3761h2.m7507a(f10) + fArr3[i27];
                                }
                                i23++;
                                i21 = i24;
                                f3 = f11;
                                paint5 = paint;
                                iMax2 = i11;
                                paint6 = paint2;
                            }
                            abstractC3761h2 = abstractC3761h0;
                            i23++;
                            i21 = i24;
                            f3 = f11;
                            paint5 = paint;
                            iMax2 = i11;
                            paint6 = paint2;
                        }
                        int i28 = iMax2;
                        c3779s.m7524a(canvas2, i28, c3779s.f12711k, c3774o);
                        paint4.setColor(-21965);
                        paint6.setColor(-2067046);
                        paint5.setColor(-2067046);
                        paint7.setColor(-13391360);
                        float f16 = -i22;
                        canvas2.translate(f16, f16);
                        c3779s.m7524a(canvas2, i28, c3779s.f12711k, c3774o);
                        if (i28 == 5) {
                            c3779s.f12704d.reset();
                            for (int i29 = 0; i29 <= 50; i29++) {
                                c3774o.f12655h[0].mo7276r(c3774o.m7517a(null, i29 / 50), c3774o.f12661n);
                                int[] iArr2 = c3774o.f12660m;
                                double[] dArr2 = c3774o.f12661n;
                                float f17 = c3785y.f12739e;
                                float f18 = c3785y.f12740f;
                                float f19 = c3785y.f12741g;
                                float f20 = c3785y.f12742h;
                                for (int i30 = 0; i30 < iArr2.length; i30++) {
                                    float f21 = (float) dArr2[i30];
                                    int i31 = iArr2[i30];
                                    if (i31 == 1) {
                                        f17 = f21;
                                    } else if (i31 == 2) {
                                        f18 = f21;
                                    } else if (i31 == 3) {
                                        f19 = f21;
                                    } else if (i31 == 4) {
                                        f20 = f21;
                                    }
                                }
                                float f22 = f19 + f17;
                                float f23 = f20 + f18;
                                Float.isNaN(Float.NaN);
                                Float.isNaN(Float.NaN);
                                float f24 = f17 + 0.0f;
                                float f25 = f18 + 0.0f;
                                float f26 = f22 + 0.0f;
                                float f27 = f23 + 0.0f;
                                float[] fArr4 = c3779s.f12710j;
                                fArr4[0] = f24;
                                fArr4[1] = f25;
                                fArr4[2] = f26;
                                fArr4[3] = f25;
                                fArr4[4] = f26;
                                fArr4[5] = f27;
                                fArr4[6] = f24;
                                fArr4[7] = f27;
                                c3779s.f12704d.moveTo(f24, f25);
                                c3779s.f12704d.lineTo(fArr4[2], fArr4[3]);
                                c3779s.f12704d.lineTo(fArr4[4], fArr4[5]);
                                c3779s.f12704d.lineTo(fArr4[6], fArr4[7]);
                                c3779s.f12704d.close();
                            }
                            paint4.setColor(1140850688);
                            canvas2 = canvas;
                            canvas2.translate(2.0f, 2.0f);
                            canvas2.drawPath(c3779s.f12704d, paint4);
                            canvas2.translate(-2.0f, -2.0f);
                            paint4.setColor(-65536);
                            canvas2.drawPath(c3779s.f12704d, paint4);
                        }
                        canvas2 = canvas2;
                        i17 = i6;
                        it2 = it;
                        i16 = i16;
                        i12 = 0;
                    } else {
                        it = it2;
                        i16 = i16;
                    }
                    canvas2 = canvas2;
                    i17 = i6;
                    it2 = it;
                    i16 = i16;
                    i12 = 0;
                }
            }
            canvas.restore();
        }
    }

    @Override
    public final void mo551f(int i6, View view) {
        C3775o0 c3775o0;
        C3751c0 c3751c0 = this.f1231q;
        if (c3751c0 == null) {
            return;
        }
        float f = this.f1211S;
        float f3 = this.f1214V;
        float f4 = f / f3;
        float f5 = this.f1212T / f3;
        C3749b0 c3749b0 = c3751c0.f12578c;
        if (c3749b0 == null || (c3775o0 = c3749b0.f12569l) == null) {
            return;
        }
        c3775o0.f12685k = false;
        MotionLayout motionLayout = c3775o0.f12689o;
        float progress = motionLayout.getProgress();
        c3775o0.f12689o.m857s(c3775o0.f12678d, progress, c3775o0.f12682h, c3775o0.f12681g, c3775o0.f12686l);
        float f10 = c3775o0.f12683i;
        float[] fArr = c3775o0.f12686l;
        float f11 = f10 != 0.0f ? (f4 * f10) / fArr[0] : (f5 * c3775o0.f12684j) / fArr[1];
        if (!Float.isNaN(f11)) {
            progress += f11 / 3.0f;
        }
        if (progress != 0.0f) {
            boolean z7 = progress != 1.0f;
            int i10 = c3775o0.f12677c;
            if ((i10 != 3) && z7) {
                motionLayout.m850A(((double) progress) >= 0.5d ? 1.0f : 0.0f, f11, i10);
            }
        }
    }

    @Override
    public final void mo552g(View view, int i6, int i10, int i11, int i12, int i13, int[] iArr) {
        if (this.f1210R || i6 != 0 || i10 != 0) {
            iArr[0] = iArr[0] + i11;
            iArr[1] = iArr[1] + i12;
        }
        this.f1210R = false;
    }

    public int[] getConstraintSetIds() {
        C3751c0 c3751c0 = this.f1231q;
        if (c3751c0 == null) {
            return null;
        }
        SparseArray sparseArray = c3751c0.f12582g;
        int size = sparseArray.size();
        int[] iArr = new int[size];
        for (int i6 = 0; i6 < size; i6++) {
            iArr[i6] = sparseArray.keyAt(i6);
        }
        return iArr;
    }

    public int getCurrentState() {
        return this.f1239u;
    }

    public ArrayList<C3749b0> getDefinedTransitions() {
        C3751c0 c3751c0 = this.f1231q;
        if (c3751c0 == null) {
            return null;
        }
        return c3751c0.f12579d;
    }

    public C3746a getDesignTool() {
        if (this.f1207O == null) {
            this.f1207O = new C3746a();
        }
        return this.f1207O;
    }

    public int getEndState() {
        return this.f1241v;
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.f1196D;
    }

    public int getStartState() {
        return this.f1237t;
    }

    public float getTargetPosition() {
        return this.f1198F;
    }

    public Bundle getTransitionState() {
        if (this.f1238t0 == null) {
            this.f1238t0 = new C3782v(this);
        }
        C3782v c3782v = this.f1238t0;
        MotionLayout motionLayout = c3782v.f12728e;
        c3782v.f12727d = motionLayout.f1241v;
        c3782v.f12726c = motionLayout.f1237t;
        c3782v.f12725b = motionLayout.getVelocity();
        c3782v.f12724a = motionLayout.getProgress();
        C3782v c3782v2 = this.f1238t0;
        c3782v2.getClass();
        Bundle bundle = new Bundle();
        bundle.putFloat("motion.progress", c3782v2.f12724a);
        bundle.putFloat("motion.velocity", c3782v2.f12725b);
        bundle.putInt("motion.StartState", c3782v2.f12726c);
        bundle.putInt("motion.EndState", c3782v2.f12727d);
        return bundle;
    }

    public long getTransitionTimeMs() {
        C3751c0 c3751c0 = this.f1231q;
        if (c3751c0 != null) {
            C3749b0 c3749b0 = c3751c0.f12578c;
            this.f1194B = (c3749b0 != null ? c3749b0.f12565h : c3751c0.f12585j) / 1000.0f;
        }
        return (long) (this.f1194B * 1000.0f);
    }

    public float getVelocity() {
        return this.f1235s;
    }

    @Override
    public final boolean mo555j(View view, View view2, int i6, int i10) {
        C3749b0 c3749b0;
        C3775o0 c3775o0;
        C3751c0 c3751c0 = this.f1231q;
        return (c3751c0 == null || (c3749b0 = c3751c0.f12578c) == null || (c3775o0 = c3749b0.f12569l) == null || (c3775o0.f12694t & 2) != 0) ? false : true;
    }

    @Override
    public final void mo852l(int i6) {
        this.f1310k = null;
    }

    public final void m853o(float f) {
        C3751c0 c3751c0 = this.f1231q;
        if (c3751c0 == null) {
            return;
        }
        float f3 = this.f1196D;
        float f4 = this.f1195C;
        if (f3 != f4 && this.f1199G) {
            this.f1196D = f4;
        }
        float f5 = this.f1196D;
        if (f5 == f) {
            return;
        }
        this.f1204L = false;
        this.f1198F = f;
        C3749b0 c3749b0 = c3751c0.f12578c;
        this.f1194B = (c3749b0 != null ? c3749b0.f12565h : c3751c0.f12585j) / 1000.0f;
        setProgress(f);
        this.f1233r = this.f1231q.m7494d();
        this.f1199G = false;
        this.f1193A = getNanoTime();
        this.f1200H = true;
        this.f1195C = f5;
        this.f1196D = f5;
        invalidate();
    }

    @Override
    public final void onAttachedToWindow() {
        int i6;
        super.onAttachedToWindow();
        C3751c0 c3751c0 = this.f1231q;
        if (c3751c0 != null && (i6 = this.f1239u) != -1) {
            C0308d c0308dM7492b = c3751c0.m7492b(i6);
            C3751c0 c3751c1 = this.f1231q;
            int i10 = 0;
            loop0: while (true) {
                SparseArray sparseArray = c3751c1.f12582g;
                if (i10 >= sparseArray.size()) {
                    for (int i11 = 0; i11 < sparseArray.size(); i11++) {
                        C0308d c0308d = (C0308d) sparseArray.valueAt(i11);
                        c0308d.getClass();
                        int childCount = getChildCount();
                        for (int i12 = 0; i12 < childCount; i12++) {
                            View childAt = getChildAt(i12);
                            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                            int id = childAt.getId();
                            if (c0308d.f1415b && id == -1) {
                                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                            }
                            HashMap map = c0308d.f1416c;
                            if (!map.containsKey(Integer.valueOf(id))) {
                                map.put(Integer.valueOf(id), new C0307c());
                            }
                            C0307c c0307c = (C0307c) map.get(Integer.valueOf(id));
                            if (!c0307c.f1409d.f14174b) {
                                c0307c.m888b(id, layoutParams);
                                boolean z7 = childAt instanceof ConstraintHelper;
                                C4187d c4187d = c0307c.f1409d;
                                if (z7) {
                                    c4187d.f14181e0 = ((ConstraintHelper) childAt).getReferencedIds();
                                    if (childAt instanceof Barrier) {
                                        Barrier barrier = (Barrier) childAt;
                                        c4187d.f14191j0 = barrier.f1291j.f13293j0;
                                        c4187d.f14175b0 = barrier.getType();
                                        c4187d.f14177c0 = barrier.getMargin();
                                    }
                                }
                                c4187d.f14174b = true;
                            }
                            C4189f c4189f = c0307c.f1407b;
                            if (!c4189f.f14216a) {
                                c4189f.f14217b = childAt.getVisibility();
                                c4189f.f14219d = childAt.getAlpha();
                                c4189f.f14216a = true;
                            }
                            C4190g c4190g = c0307c.f1410e;
                            if (!c4190g.f14222a) {
                                c4190g.f14222a = true;
                                c4190g.f14223b = childAt.getRotation();
                                c4190g.f14224c = childAt.getRotationX();
                                c4190g.f14225d = childAt.getRotationY();
                                c4190g.f14226e = childAt.getScaleX();
                                c4190g.f14227f = childAt.getScaleY();
                                float pivotX = childAt.getPivotX();
                                float pivotY = childAt.getPivotY();
                                if (pivotX != 0.0d || pivotY != 0.0d) {
                                    c4190g.f14228g = pivotX;
                                    c4190g.f14229h = pivotY;
                                }
                                c4190g.f14230i = childAt.getTranslationX();
                                c4190g.f14231j = childAt.getTranslationY();
                                c4190g.f14232k = childAt.getTranslationZ();
                                if (c4190g.f14233l) {
                                    c4190g.f14234m = childAt.getElevation();
                                }
                            }
                        }
                    }
                    break;
                }
                int iKeyAt = sparseArray.keyAt(i10);
                SparseIntArray sparseIntArray = c3751c1.f12584i;
                int i13 = sparseIntArray.get(iKeyAt);
                int size = sparseIntArray.size();
                while (true) {
                    if (i13 > 0) {
                        if (i13 != iKeyAt) {
                            int i14 = size - 1;
                            if (size >= 0) {
                                i13 = sparseIntArray.get(i13);
                                size = i14;
                            }
                        }
                        Log.e("MotionScene", "Cannot be derived from yourself");
                        break loop0;
                    }
                    c3751c1.m7500j(iKeyAt);
                    i10++;
                }
            }
            if (c0308dM7492b != null) {
                c0308dM7492b.m894b(this);
            }
            this.f1237t = this.f1239u;
        }
        m860v();
        C3782v c3782v = this.f1238t0;
        if (c3782v != null) {
            c3782v.m7535a();
        }
    }

    @Override
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        C3749b0 c3749b0;
        C3775o0 c3775o0;
        int i6;
        RectF rectFM7522a;
        C3751c0 c3751c0 = this.f1231q;
        if (c3751c0 != null && this.f1247y && (c3749b0 = c3751c0.f12578c) != null && !c3749b0.f12572o && (c3775o0 = c3749b0.f12569l) != null && ((motionEvent.getAction() != 0 || (rectFM7522a = c3775o0.m7522a(this, new RectF())) == null || rectFM7522a.contains(motionEvent.getX(), motionEvent.getY())) && (i6 = c3775o0.f12679e) != -1)) {
            View view = this.f1248y0;
            if (view == null || view.getId() != i6) {
                this.f1248y0 = findViewById(i6);
            }
            View view2 = this.f1248y0;
            if (view2 != null) {
                RectF rectF = this.f1246x0;
                rectF.set(view2.getLeft(), this.f1248y0.getTop(), this.f1248y0.getRight(), this.f1248y0.getBottom());
                if (rectF.contains(motionEvent.getX(), motionEvent.getY()) && !m858t(0.0f, 0.0f, this.f1248y0, motionEvent)) {
                    return onTouchEvent(motionEvent);
                }
            }
        }
        return false;
    }

    @Override
    public final void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        this.f1236s0 = true;
        try {
            if (this.f1231q == null) {
                super.onLayout(z7, i6, i10, i11, i12);
                return;
            }
            int i13 = i11 - i6;
            int i14 = i12 - i10;
            if (this.f1208P != i13 || this.f1209Q != i14) {
                m862x();
                m854p(true);
            }
            this.f1208P = i13;
            this.f1209Q = i14;
        } finally {
            this.f1236s0 = false;
        }
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        boolean z7;
        if (this.f1231q == null) {
            super.onMeasure(i6, i10);
            return;
        }
        boolean z10 = true;
        boolean z11 = (this.f1243w == i6 && this.f1245x == i10) ? false : true;
        if (this.f1244w0) {
            this.f1244w0 = false;
            m860v();
            m861w();
            z11 = true;
        }
        if (this.f1307h) {
            z11 = true;
        }
        this.f1243w = i6;
        this.f1245x = i10;
        int iM7497g = this.f1231q.m7497g();
        C3749b0 c3749b0 = this.f1231q.f12578c;
        int i11 = c3749b0 == null ? -1 : c3749b0.f12560c;
        C3959f c3959f = this.f1302c;
        C3780t c3780t = this.f1242v0;
        if ((!z11 && iM7497g == c3780t.f12719e && i11 == c3780t.f12720f) || this.f1237t == -1) {
            z7 = true;
        } else {
            super.onMeasure(i6, i10);
            c3780t.m7532d(this.f1231q.m7492b(iM7497g), this.f1231q.m7492b(i11));
            c3780t.m7533e();
            c3780t.f12719e = iM7497g;
            c3780t.f12720f = i11;
            z7 = false;
        }
        if (this.f1224j0 || z7) {
            int paddingBottom = getPaddingBottom() + getPaddingTop();
            int iM7905m = c3959f.m7905m() + getPaddingRight() + getPaddingLeft();
            int iM7902j = c3959f.m7902j() + paddingBottom;
            int i12 = this.f1229o0;
            if (i12 == Integer.MIN_VALUE || i12 == 0) {
                int i13 = this.f1225k0;
                iM7905m = (int) ((this.f1232q0 * (this.f1227m0 - i13)) + i13);
                requestLayout();
            }
            int i14 = this.f1230p0;
            if (i14 == Integer.MIN_VALUE || i14 == 0) {
                int i15 = this.f1226l0;
                iM7902j = (int) ((this.f1232q0 * (this.f1228n0 - i15)) + i15);
                requestLayout();
            }
            setMeasuredDimension(iM7905m, iM7902j);
        }
        float fSignum = Math.signum(this.f1198F - this.f1196D);
        long nanoTime = getNanoTime();
        Interpolator interpolator = this.f1233r;
        float interpolation = this.f1196D + (!(interpolator instanceof C3683g) ? (((nanoTime - this.f1197E) * fSignum) * 1.0E-9f) / this.f1194B : 0.0f);
        if (this.f1199G) {
            interpolation = this.f1198F;
        }
        if ((fSignum <= 0.0f || interpolation < this.f1198F) && (fSignum > 0.0f || interpolation > this.f1198F)) {
            z10 = false;
        } else {
            interpolation = this.f1198F;
        }
        if (interpolator != null && !z10) {
            interpolation = this.f1204L ? interpolator.getInterpolation((nanoTime - this.f1193A) * 1.0E-9f) : interpolator.getInterpolation(interpolation);
        }
        if ((fSignum > 0.0f && interpolation >= this.f1198F) || (fSignum <= 0.0f && interpolation <= this.f1198F)) {
            interpolation = this.f1198F;
        }
        this.f1232q0 = interpolation;
        int childCount = getChildCount();
        long nanoTime2 = getNanoTime();
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            C3774o c3774o = (C3774o) this.f1249z.get(childAt);
            if (c3774o != null) {
                c3774o.m7519c(interpolation, nanoTime2, childAt, this.f1234r0);
            }
        }
        if (this.f1224j0) {
            requestLayout();
        }
    }

    @Override
    public final boolean onNestedFling(View view, float f, float f3, boolean z7) {
        return false;
    }

    @Override
    public final boolean onNestedPreFling(View view, float f, float f3) {
        return false;
    }

    @Override
    public final void onRtlPropertiesChanged(int i6) {
        C3775o0 c3775o0;
        C3751c0 c3751c0 = this.f1231q;
        if (c3751c0 != null) {
            boolean zM881k = m881k();
            c3751c0.f12590o = zM881k;
            C3749b0 c3749b0 = c3751c0.f12578c;
            if (c3749b0 == null || (c3775o0 = c3749b0.f12569l) == null) {
                return;
            }
            c3775o0.m7523b(zM881k);
        }
    }

    @Override
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        C3781u c3781u;
        C3775o0 c3775o0;
        char c5;
        char c8;
        int i6;
        char c10;
        char c11;
        char c12;
        char c13;
        View viewFindViewById;
        RectF rectF;
        MotionEvent motionEvent2;
        C3749b0 c3749b0;
        int iM3271c;
        C3775o0 c3775o1;
        Iterator it;
        C3751c0 c3751c0 = this.f1231q;
        if (c3751c0 == null || !this.f1247y || !c3751c0.m7502l()) {
            return super.onTouchEvent(motionEvent);
        }
        C3751c0 c3751c1 = this.f1231q;
        C3749b0 c3749b1 = c3751c1.f12578c;
        if (c3749b1 != null && c3749b1.f12572o) {
            return super.onTouchEvent(motionEvent);
        }
        int currentState = getCurrentState();
        RectF rectF2 = new RectF();
        C3781u c3781u2 = c3751c1.f12589n;
        MotionLayout motionLayout = c3751c1.f12576a;
        if (c3781u2 == null) {
            motionLayout.getClass();
            C3781u c3781u3 = C3781u.f12722b;
            c3781u3.f12723a = VelocityTracker.obtain();
            c3751c1.f12589n = c3781u3;
        }
        VelocityTracker velocityTracker = (VelocityTracker) c3751c1.f12589n.f12723a;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        if (currentState != -1) {
            int action = motionEvent.getAction();
            if (action == 0) {
                c3751c1.f12591p = motionEvent.getRawX();
                c3751c1.f12592q = motionEvent.getRawY();
                c3751c1.f12587l = motionEvent;
                C3775o0 c3775o2 = c3751c1.f12578c.f12569l;
                if (c3775o2 == null) {
                    return true;
                }
                int i10 = c3775o2.f12680f;
                if (i10 == -1 || (viewFindViewById = motionLayout.findViewById(i10)) == null) {
                    rectF = null;
                } else {
                    rectF2.set(viewFindViewById.getLeft(), viewFindViewById.getTop(), viewFindViewById.getRight(), viewFindViewById.getBottom());
                    rectF = rectF2;
                }
                if (rectF != null && !rectF.contains(c3751c1.f12587l.getX(), c3751c1.f12587l.getY())) {
                    c3751c1.f12587l = null;
                    return true;
                }
                RectF rectFM7522a = c3751c1.f12578c.f12569l.m7522a(motionLayout, rectF2);
                if (rectFM7522a == null || rectFM7522a.contains(c3751c1.f12587l.getX(), c3751c1.f12587l.getY())) {
                    c3751c1.f12588m = false;
                } else {
                    c3751c1.f12588m = true;
                }
                C3775o0 c3775o3 = c3751c1.f12578c.f12569l;
                float f = c3751c1.f12591p;
                float f3 = c3751c1.f12592q;
                c3775o3.f12687m = f;
                c3775o3.f12688n = f3;
                return true;
            }
            if (action == 2) {
                float rawY = motionEvent.getRawY() - c3751c1.f12592q;
                float rawX = motionEvent.getRawX() - c3751c1.f12591p;
                if ((rawX == 0.0d && rawY == 0.0d) || (motionEvent2 = c3751c1.f12587l) == null) {
                    return true;
                }
                if (currentState != -1) {
                    C1399b c1399b = c3751c1.f12577b;
                    if (c1399b == null || (iM3271c = c1399b.m3271c(currentState)) == -1) {
                        iM3271c = currentState;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (C3749b0 c3749b2 : c3751c1.f12579d) {
                        if (c3749b2.f12561d == iM3271c || c3749b2.f12560c == iM3271c) {
                            arrayList.add(c3749b2);
                        }
                    }
                    RectF rectF3 = new RectF();
                    Iterator it2 = arrayList.iterator();
                    float f4 = 0.0f;
                    c3749b0 = null;
                    while (it2.hasNext()) {
                        C3749b0 c3749b3 = (C3749b0) it2.next();
                        if (c3749b3.f12572o || (c3775o1 = c3749b3.f12569l) == null) {
                            it = it2;
                        } else {
                            c3775o1.m7523b(c3751c1.f12590o);
                            RectF rectFM7522a2 = c3749b3.f12569l.m7522a(motionLayout, rectF3);
                            if (rectFM7522a2 != null) {
                                it = it2;
                                if (!rectFM7522a2.contains(motionEvent2.getX(), motionEvent2.getY())) {
                                }
                            } else {
                                it = it2;
                            }
                            RectF rectFM7522a3 = c3749b3.f12569l.m7522a(motionLayout, rectF3);
                            if (rectFM7522a3 == null || rectFM7522a3.contains(motionEvent2.getX(), motionEvent2.getY())) {
                                C3775o0 c3775o4 = c3749b3.f12569l;
                                float f5 = ((c3775o4.f12684j * rawY) + (c3775o4.f12683i * rawX)) * (c3749b3.f12560c == currentState ? -1.0f : 1.1f);
                                if (f5 > f4) {
                                    f4 = f5;
                                    c3749b0 = c3749b3;
                                }
                            }
                        }
                        it2 = it;
                    }
                } else {
                    c3749b0 = c3751c1.f12578c;
                }
                if (c3749b0 != null) {
                    setTransition(c3749b0);
                    RectF rectFM7522a4 = c3751c1.f12578c.f12569l.m7522a(motionLayout, rectF2);
                    c3751c1.f12588m = (rectFM7522a4 == null || rectFM7522a4.contains(c3751c1.f12587l.getX(), c3751c1.f12587l.getY())) ? false : true;
                    C3775o0 c3775o5 = c3751c1.f12578c.f12569l;
                    float f10 = c3751c1.f12591p;
                    float f11 = c3751c1.f12592q;
                    c3775o5.f12687m = f10;
                    c3775o5.f12688n = f11;
                    c3775o5.f12685k = false;
                }
            }
        }
        C3749b0 c3749b4 = c3751c1.f12578c;
        if (c3749b4 != null && (c3775o0 = c3749b4.f12569l) != null && !c3751c1.f12588m) {
            C3781u c3781u4 = c3751c1.f12589n;
            VelocityTracker velocityTracker2 = (VelocityTracker) c3781u4.f12723a;
            if (velocityTracker2 != null) {
                velocityTracker2.addMovement(motionEvent);
            }
            int action2 = motionEvent.getAction();
            if (action2 != 0) {
                float[] fArr = c3775o0.f12686l;
                MotionLayout motionLayout2 = c3775o0.f12689o;
                if (action2 == 1) {
                    c3775o0.f12685k = false;
                    ((VelocityTracker) c3781u4.f12723a).computeCurrentVelocity(1000);
                    float xVelocity = ((VelocityTracker) c3781u4.f12723a).getXVelocity();
                    float yVelocity = ((VelocityTracker) c3781u4.f12723a).getYVelocity();
                    float progress = motionLayout2.getProgress();
                    int i11 = c3775o0.f12678d;
                    if (i11 != -1) {
                        c3775o0.f12689o.m857s(i11, progress, c3775o0.f12682h, c3775o0.f12681g, c3775o0.f12686l);
                        c8 = 0;
                        c5 = 1;
                    } else {
                        float fMin = Math.min(motionLayout2.getWidth(), motionLayout2.getHeight());
                        c5 = 1;
                        fArr[1] = c3775o0.f12684j * fMin;
                        c8 = 0;
                        fArr[0] = fMin * c3775o0.f12683i;
                    }
                    float f12 = c3775o0.f12683i != 0.0f ? xVelocity / fArr[c8] : yVelocity / fArr[c5];
                    float f13 = !Float.isNaN(f12) ? (f12 / 3.0f) + progress : progress;
                    EnumC3784x enumC3784x = EnumC3784x.f12732d;
                    if (f13 != 0.0f && f13 != 1.0f && (i6 = c3775o0.f12677c) != 3) {
                        motionLayout2.m850A(((double) f13) < 0.5d ? 0.0f : 1.0f, f12, i6);
                        if (0.0f >= progress || 1.0f <= progress) {
                            motionLayout2.setState(enumC3784x);
                        }
                    } else if (0.0f >= f13 || 1.0f <= f13) {
                        motionLayout2.setState(enumC3784x);
                    }
                } else if (action2 == 2) {
                    float rawY2 = motionEvent.getRawY() - c3775o0.f12688n;
                    float rawX2 = motionEvent.getRawX() - c3775o0.f12687m;
                    if (Math.abs((c3775o0.f12684j * rawY2) + (c3775o0.f12683i * rawX2)) > c3775o0.f12695u || c3775o0.f12685k) {
                        float progress2 = motionLayout2.getProgress();
                        if (!c3775o0.f12685k) {
                            c3775o0.f12685k = true;
                            motionLayout2.setProgress(progress2);
                        }
                        int i12 = c3775o0.f12678d;
                        if (i12 != -1) {
                            c3775o0.f12689o.m857s(i12, progress2, c3775o0.f12682h, c3775o0.f12681g, c3775o0.f12686l);
                            c11 = 0;
                            c10 = 1;
                        } else {
                            float fMin2 = Math.min(motionLayout2.getWidth(), motionLayout2.getHeight());
                            c10 = 1;
                            fArr[1] = c3775o0.f12684j * fMin2;
                            c11 = 0;
                            fArr[0] = fMin2 * c3775o0.f12683i;
                        }
                        if (Math.abs(((c3775o0.f12684j * fArr[c10]) + (c3775o0.f12683i * fArr[c11])) * c3775o0.f12693s) < 0.01d) {
                            c12 = 0;
                            fArr[0] = 0.01f;
                            c13 = 1;
                            fArr[1] = 0.01f;
                        } else {
                            c12 = 0;
                            c13 = 1;
                        }
                        float fMax = Math.max(Math.min(progress2 + (c3775o0.f12683i != 0.0f ? rawX2 / fArr[c12] : rawY2 / fArr[c13]), 1.0f), 0.0f);
                        if (fMax != motionLayout2.getProgress()) {
                            motionLayout2.setProgress(fMax);
                            ((VelocityTracker) c3781u4.f12723a).computeCurrentVelocity(1000);
                            motionLayout2.f1235s = c3775o0.f12683i != 0.0f ? ((VelocityTracker) c3781u4.f12723a).getXVelocity() / fArr[0] : ((VelocityTracker) c3781u4.f12723a).getYVelocity() / fArr[1];
                        } else {
                            motionLayout2.f1235s = 0.0f;
                        }
                        c3775o0.f12687m = motionEvent.getRawX();
                        c3775o0.f12688n = motionEvent.getRawY();
                    }
                }
            } else {
                c3775o0.f12687m = motionEvent.getRawX();
                c3775o0.f12688n = motionEvent.getRawY();
                c3775o0.f12685k = false;
            }
        }
        c3751c1.f12591p = motionEvent.getRawX();
        c3751c1.f12592q = motionEvent.getRawY();
        if (motionEvent.getAction() != 1 || (c3781u = c3751c1.f12589n) == null) {
            return true;
        }
        ((VelocityTracker) c3781u.f12723a).recycle();
        c3781u.f12723a = null;
        c3751c1.f12589n = null;
        int i13 = this.f1239u;
        if (i13 == -1) {
            return true;
        }
        c3751c1.m7491a(this, i13);
        return true;
    }

    @Override
    public final void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof MotionHelper) {
            MotionHelper motionHelper = (MotionHelper) view;
            if (this.f1218d0 == null) {
                this.f1218d0 = new ArrayList();
            }
            this.f1218d0.add(motionHelper);
            if (motionHelper.f1188h) {
                if (this.f1216b0 == null) {
                    this.f1216b0 = new ArrayList();
                }
                this.f1216b0.add(motionHelper);
            }
            if (motionHelper.f1189i) {
                if (this.f1217c0 == null) {
                    this.f1217c0 = new ArrayList();
                }
                this.f1217c0.add(motionHelper);
            }
        }
    }

    @Override
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList arrayList = this.f1216b0;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList arrayList2 = this.f1217c0;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    public final void m854p(boolean z7) {
        float f;
        boolean z10;
        int i6;
        float interpolation;
        boolean z11;
        if (this.f1197E == -1) {
            this.f1197E = getNanoTime();
        }
        float f3 = this.f1196D;
        if (f3 > 0.0f && f3 < 1.0f) {
            this.f1239u = -1;
        }
        boolean z12 = false;
        if (this.f1215W || (this.f1200H && (z7 || this.f1198F != f3))) {
            float fSignum = Math.signum(this.f1198F - f3);
            long nanoTime = getNanoTime();
            Interpolator interpolator = this.f1233r;
            if (interpolator instanceof AbstractInterpolatorC3776p) {
                f = 0.0f;
            } else {
                f = (((nanoTime - this.f1197E) * fSignum) * 1.0E-9f) / this.f1194B;
                this.f1235s = f;
            }
            float f4 = this.f1196D + f;
            if (this.f1199G) {
                f4 = this.f1198F;
            }
            if ((fSignum <= 0.0f || f4 < this.f1198F) && (fSignum > 0.0f || f4 > this.f1198F)) {
                z10 = false;
            } else {
                f4 = this.f1198F;
                this.f1200H = false;
                z10 = true;
            }
            this.f1196D = f4;
            this.f1195C = f4;
            this.f1197E = nanoTime;
            if (interpolator != null && !z10) {
                if (this.f1204L) {
                    interpolation = interpolator.getInterpolation((nanoTime - this.f1193A) * 1.0E-9f);
                    this.f1196D = interpolation;
                    this.f1197E = nanoTime;
                    Interpolator interpolator2 = this.f1233r;
                    if (interpolator2 instanceof AbstractInterpolatorC3776p) {
                        float fMo7435a = ((AbstractInterpolatorC3776p) interpolator2).mo7435a();
                        this.f1235s = fMo7435a;
                        if (Math.abs(fMo7435a) * this.f1194B <= 1.0E-5f) {
                            this.f1200H = false;
                        }
                        if (fMo7435a > 0.0f && interpolation >= 1.0f) {
                            this.f1196D = 1.0f;
                            this.f1200H = false;
                            interpolation = 1.0f;
                        }
                        if (fMo7435a < 0.0f && interpolation <= 0.0f) {
                            this.f1196D = 0.0f;
                            this.f1200H = false;
                            f4 = 0.0f;
                        }
                    }
                } else {
                    interpolation = interpolator.getInterpolation(f4);
                    Interpolator interpolator3 = this.f1233r;
                    if (interpolator3 instanceof AbstractInterpolatorC3776p) {
                        this.f1235s = ((AbstractInterpolatorC3776p) interpolator3).mo7435a();
                    } else {
                        this.f1235s = ((interpolator3.getInterpolation(f4 + f) - interpolation) * fSignum) / f;
                    }
                }
                f4 = interpolation;
            }
            if (Math.abs(this.f1235s) > 1.0E-5f) {
                setState(EnumC3784x.f12731c);
            }
            if ((fSignum > 0.0f && f4 >= this.f1198F) || (fSignum <= 0.0f && f4 <= this.f1198F)) {
                f4 = this.f1198F;
                this.f1200H = false;
            }
            EnumC3784x enumC3784x = EnumC3784x.f12732d;
            if (f4 >= 1.0f || f4 <= 0.0f) {
                this.f1200H = false;
                setState(enumC3784x);
            }
            int childCount = getChildCount();
            this.f1215W = false;
            long nanoTime2 = getNanoTime();
            this.f1232q0 = f4;
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = getChildAt(i10);
                C3774o c3774o = (C3774o) this.f1249z.get(childAt);
                if (c3774o != null) {
                    this.f1215W = c3774o.m7519c(f4, nanoTime2, childAt, this.f1234r0) | this.f1215W;
                }
            }
            boolean z13 = (fSignum > 0.0f && f4 >= this.f1198F) || (fSignum <= 0.0f && f4 <= this.f1198F);
            if (!this.f1215W && !this.f1200H && z13) {
                setState(enumC3784x);
            }
            if (this.f1224j0) {
                requestLayout();
            }
            this.f1215W = (!z13) | this.f1215W;
            if (f4 > 0.0f || (i6 = this.f1237t) == -1 || this.f1239u == i6) {
                z12 = false;
            } else {
                this.f1239u = i6;
                this.f1231q.m7492b(i6).m893a(this);
                setState(enumC3784x);
                z12 = true;
            }
            if (f4 >= 1.0d) {
                int i11 = this.f1239u;
                int i12 = this.f1241v;
                if (i11 != i12) {
                    this.f1239u = i12;
                    this.f1231q.m7492b(i12).m893a(this);
                    setState(enumC3784x);
                    z12 = true;
                }
            }
            if (this.f1215W || this.f1200H) {
                invalidate();
            } else if ((fSignum > 0.0f && f4 == 1.0f) || (fSignum < 0.0f && f4 == 0.0f)) {
                setState(enumC3784x);
            }
            if ((!this.f1215W && this.f1200H && fSignum > 0.0f && f4 == 1.0f) || (fSignum < 0.0f && f4 == 0.0f)) {
                m860v();
            }
        }
        float f5 = this.f1196D;
        if (f5 < 1.0f) {
            if (f5 <= 0.0f) {
                int i13 = this.f1239u;
                int i14 = this.f1237t;
                z11 = i13 == i14 ? z12 : true;
                this.f1239u = i14;
            }
            this.f1244w0 |= z12;
            if (z12 && !this.f1236s0) {
                requestLayout();
            }
            this.f1195C = this.f1196D;
        }
        int i15 = this.f1239u;
        int i16 = this.f1241v;
        z11 = i15 == i16 ? z12 : true;
        this.f1239u = i16;
        z12 = z11;
        this.f1244w0 |= z12;
        if (z12) {
            requestLayout();
        }
        this.f1195C = this.f1196D;
    }

    public final void m855q() {
        ArrayList arrayList;
        if ((this.f1201I == null && ((arrayList = this.f1218d0) == null || arrayList.isEmpty())) || this.f1223i0 == this.f1195C) {
            return;
        }
        if (this.f1222h0 != -1) {
            InterfaceC3783w interfaceC3783w = this.f1201I;
            if (interfaceC3783w != null) {
                interfaceC3783w.getClass();
            }
            ArrayList arrayList2 = this.f1218d0;
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((InterfaceC3783w) it.next()).getClass();
                }
            }
        }
        this.f1222h0 = -1;
        this.f1223i0 = this.f1195C;
        InterfaceC3783w interfaceC3783w2 = this.f1201I;
        if (interfaceC3783w2 != null) {
            interfaceC3783w2.getClass();
        }
        ArrayList arrayList3 = this.f1218d0;
        if (arrayList3 != null) {
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                ((InterfaceC3783w) it2.next()).getClass();
            }
        }
    }

    public final void m856r() {
        ArrayList arrayList;
        if ((this.f1201I != null || ((arrayList = this.f1218d0) != null && !arrayList.isEmpty())) && this.f1222h0 == -1) {
            this.f1222h0 = this.f1239u;
            ArrayList arrayList2 = this.f1250z0;
            int iIntValue = !arrayList2.isEmpty() ? ((Integer) AbstractC2460q.m5491e(1, arrayList2)).intValue() : -1;
            int i6 = this.f1239u;
            if (iIntValue != i6 && i6 != -1) {
                arrayList2.add(Integer.valueOf(i6));
            }
        }
        m861w();
    }

    @Override
    public final void requestLayout() {
        C3751c0 c3751c0;
        C3749b0 c3749b0;
        if (this.f1224j0 || this.f1239u != -1 || (c3751c0 = this.f1231q) == null || (c3749b0 = c3751c0.f12578c) == null || c3749b0.f12574q != 0) {
            super.requestLayout();
        }
    }

    public final void m857s(int i6, float f, float f3, float f4, float[] fArr) {
        View viewM878d = m878d(i6);
        C3774o c3774o = (C3774o) this.f1249z.get(viewM878d);
        if (c3774o != null) {
            c3774o.m7518b(f, f3, f4, fArr);
            viewM878d.getY();
        } else {
            Log.w("MotionLayout", "WARNING could not find view id " + (viewM878d == null ? AbstractC0004e.m20n(i6, "") : viewM878d.getContext().getResources().getResourceName(i6)));
        }
    }

    public void setDebugMode(int i6) {
        this.f1202J = i6;
        invalidate();
    }

    public void setInteractionEnabled(boolean z7) {
        this.f1247y = z7;
    }

    public void setInterpolatedProgress(float f) {
        if (this.f1231q != null) {
            setState(EnumC3784x.f12731c);
            Interpolator interpolatorM7494d = this.f1231q.m7494d();
            if (interpolatorM7494d != null) {
                setProgress(interpolatorM7494d.getInterpolation(f));
                return;
            }
        }
        setProgress(f);
    }

    public void setOnHide(float f) {
        ArrayList arrayList = this.f1217c0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i6 = 0; i6 < size; i6++) {
                ((MotionHelper) this.f1217c0.get(i6)).setProgress(f);
            }
        }
    }

    public void setOnShow(float f) {
        ArrayList arrayList = this.f1216b0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i6 = 0; i6 < size; i6++) {
                ((MotionHelper) this.f1216b0.get(i6)).setProgress(f);
            }
        }
    }

    public void setProgress(float f) {
        if (!super.isAttachedToWindow()) {
            if (this.f1238t0 == null) {
                this.f1238t0 = new C3782v(this);
            }
            this.f1238t0.f12724a = f;
            return;
        }
        EnumC3784x enumC3784x = EnumC3784x.f12732d;
        if (f <= 0.0f) {
            this.f1239u = this.f1237t;
            if (this.f1196D == 0.0f) {
                setState(enumC3784x);
            }
        } else if (f >= 1.0f) {
            this.f1239u = this.f1241v;
            if (this.f1196D == 1.0f) {
                setState(enumC3784x);
            }
        } else {
            this.f1239u = -1;
            setState(EnumC3784x.f12731c);
        }
        if (this.f1231q == null) {
            return;
        }
        this.f1199G = true;
        this.f1198F = f;
        this.f1195C = f;
        this.f1197E = -1L;
        this.f1193A = -1L;
        this.f1233r = null;
        this.f1200H = true;
        invalidate();
    }

    public void setScene(C3751c0 c3751c0) {
        C3775o0 c3775o0;
        this.f1231q = c3751c0;
        boolean zM881k = m881k();
        c3751c0.f12590o = zM881k;
        C3749b0 c3749b0 = c3751c0.f12578c;
        if (c3749b0 != null && (c3775o0 = c3749b0.f12569l) != null) {
            c3775o0.m7523b(zM881k);
        }
        m862x();
    }

    public void setState(EnumC3784x enumC3784x) {
        EnumC3784x enumC3784x2 = EnumC3784x.f12732d;
        if (enumC3784x == enumC3784x2 && this.f1239u == -1) {
            return;
        }
        EnumC3784x enumC3784x3 = this.f1240u0;
        this.f1240u0 = enumC3784x;
        EnumC3784x enumC3784x4 = EnumC3784x.f12731c;
        if (enumC3784x3 == enumC3784x4 && enumC3784x == enumC3784x4) {
            m855q();
        }
        int iOrdinal = enumC3784x3.ordinal();
        if (iOrdinal != 0 && iOrdinal != 1) {
            if (iOrdinal == 2 && enumC3784x == enumC3784x2) {
                m856r();
                return;
            }
            return;
        }
        if (enumC3784x == enumC3784x4) {
            m855q();
        }
        if (enumC3784x == enumC3784x2) {
            m856r();
        }
    }

    public void setTransition(int i6) {
        C3749b0 c3749b0;
        float f;
        C3751c0 c3751c0 = this.f1231q;
        if (c3751c0 != null) {
            Iterator it = c3751c0.f12579d.iterator();
            do {
                if (!it.hasNext()) {
                    c3749b0 = null;
                    break;
                }
                c3749b0 = (C3749b0) it.next();
            } while (c3749b0.f12558a != i6);
            this.f1237t = c3749b0.f12561d;
            this.f1241v = c3749b0.f12560c;
            if (!super.isAttachedToWindow()) {
                if (this.f1238t0 == null) {
                    this.f1238t0 = new C3782v(this);
                }
                C3782v c3782v = this.f1238t0;
                c3782v.f12726c = this.f1237t;
                c3782v.f12727d = this.f1241v;
                return;
            }
            int i10 = this.f1239u;
            if (i10 == this.f1237t) {
                f = 0.0f;
            } else {
                f = i10 == this.f1241v ? 1.0f : Float.NaN;
            }
            C3751c0 c3751c1 = this.f1231q;
            c3751c1.f12578c = c3749b0;
            C3775o0 c3775o0 = c3749b0.f12569l;
            if (c3775o0 != null) {
                c3775o0.m7523b(c3751c1.f12590o);
            }
            this.f1242v0.m7532d(this.f1231q.m7492b(this.f1237t), this.f1231q.m7492b(this.f1241v));
            m862x();
            this.f1196D = Float.isNaN(f) ? 0.0f : f;
            if (!Float.isNaN(f)) {
                setProgress(f);
                return;
            }
            Log.v("MotionLayout", AbstractC0032a.m169w() + " transitionToStart ");
            m853o(0.0f);
        }
    }

    public void setTransitionDuration(int i6) {
        C3751c0 c3751c0 = this.f1231q;
        if (c3751c0 == null) {
            Log.e("MotionLayout", "MotionScene not defined");
            return;
        }
        C3749b0 c3749b0 = c3751c0.f12578c;
        if (c3749b0 != null) {
            c3749b0.f12565h = i6;
        } else {
            c3751c0.f12585j = i6;
        }
    }

    public void setTransitionListener(InterfaceC3783w interfaceC3783w) {
        this.f1201I = interfaceC3783w;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.f1238t0 == null) {
            this.f1238t0 = new C3782v(this);
        }
        C3782v c3782v = this.f1238t0;
        c3782v.getClass();
        c3782v.f12724a = bundle.getFloat("motion.progress");
        c3782v.f12725b = bundle.getFloat("motion.velocity");
        c3782v.f12726c = bundle.getInt("motion.StartState");
        c3782v.f12727d = bundle.getInt("motion.EndState");
        if (super.isAttachedToWindow()) {
            this.f1238t0.m7535a();
        }
    }

    public final boolean m858t(float f, float f3, View view, MotionEvent motionEvent) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                if (m858t(view.getLeft() + f, view.getTop() + f3, viewGroup.getChildAt(i6), motionEvent)) {
                    return true;
                }
            }
        }
        float left = view.getLeft() + f;
        float top = view.getTop() + f3;
        float right = f + view.getRight();
        float bottom = f3 + view.getBottom();
        RectF rectF = this.f1246x0;
        rectF.set(left, top, right, bottom);
        if (motionEvent.getAction() == 0) {
            if (rectF.contains(motionEvent.getX(), motionEvent.getY()) && view.onTouchEvent(motionEvent)) {
                return true;
            }
        } else if (view.onTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    @Override
    public final String toString() {
        Context context = getContext();
        return AbstractC0032a.m170x(context, this.f1237t) + "->" + AbstractC0032a.m170x(context, this.f1241v) + " (pos:" + this.f1196D + " Dpos/Dt:" + this.f1235s;
    }

    public final void m859u(AttributeSet attributeSet) {
        C3751c0 c3751c0;
        String string;
        isInEditMode();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, AbstractC4193j.f14245k);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            boolean z7 = true;
            for (int i6 = 0; i6 < indexCount; i6++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i6);
                if (index == 2) {
                    this.f1231q = new C3751c0(getContext(), this, typedArrayObtainStyledAttributes.getResourceId(index, -1));
                } else if (index == 1) {
                    this.f1239u = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                } else if (index == 4) {
                    this.f1198F = typedArrayObtainStyledAttributes.getFloat(index, 0.0f);
                    this.f1200H = true;
                } else if (index == 0) {
                    z7 = typedArrayObtainStyledAttributes.getBoolean(index, z7);
                } else if (index == 5) {
                    if (this.f1202J == 0) {
                        this.f1202J = typedArrayObtainStyledAttributes.getBoolean(index, false) ? 2 : 0;
                    }
                } else if (index == 3) {
                    this.f1202J = typedArrayObtainStyledAttributes.getInt(index, 0);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            if (this.f1231q == null) {
                Log.e("MotionLayout", "WARNING NO app:layoutDescription tag");
            }
            if (!z7) {
                this.f1231q = null;
            }
        }
        if (this.f1202J != 0) {
            C3751c0 c3751c1 = this.f1231q;
            if (c3751c1 == null) {
                Log.e("MotionLayout", "CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
            } else {
                int iM7497g = c3751c1.m7497g();
                C3751c0 c3751c2 = this.f1231q;
                C0308d c0308dM7492b = c3751c2.m7492b(c3751c2.m7497g());
                String strM170x = AbstractC0032a.m170x(getContext(), iM7497g);
                int childCount = getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    View childAt = getChildAt(i10);
                    int id = childAt.getId();
                    if (id == -1) {
                        StringBuilder sbM30x = AbstractC0004e.m30x("CHECK: ", strM170x, " ALL VIEWS SHOULD HAVE ID's ");
                        sbM30x.append(childAt.getClass().getName());
                        sbM30x.append(" does not!");
                        Log.w("MotionLayout", sbM30x.toString());
                    }
                    HashMap map = c0308dM7492b.f1416c;
                    if ((map.containsKey(Integer.valueOf(id)) ? (C0307c) map.get(Integer.valueOf(id)) : null) == null) {
                        StringBuilder sbM30x2 = AbstractC0004e.m30x("CHECK: ", strM170x, " NO CONSTRAINTS for ");
                        sbM30x2.append(AbstractC0032a.m171y(childAt));
                        Log.w("MotionLayout", sbM30x2.toString());
                    }
                }
                Integer[] numArr = (Integer[]) c0308dM7492b.f1416c.keySet().toArray(new Integer[0]);
                int length = numArr.length;
                int[] iArr = new int[length];
                for (int i11 = 0; i11 < length; i11++) {
                    iArr[i11] = numArr[i11].intValue();
                }
                for (int i12 = 0; i12 < length; i12++) {
                    int i13 = iArr[i12];
                    String strM170x2 = AbstractC0032a.m170x(getContext(), i13);
                    if (findViewById(iArr[i12]) == null) {
                        Log.w("MotionLayout", "CHECK: " + strM170x + " NO View matches id " + strM170x2);
                    }
                    if (c0308dM7492b.m897g(i13).f1409d.f14178d == -1) {
                        Log.w("MotionLayout", "CHECK: " + strM170x + "(" + strM170x2 + ") no LAYOUT_HEIGHT");
                    }
                    if (c0308dM7492b.m897g(i13).f1409d.f14176c == -1) {
                        Log.w("MotionLayout", "CHECK: " + strM170x + "(" + strM170x2 + ") no LAYOUT_HEIGHT");
                    }
                }
                SparseIntArray sparseIntArray = new SparseIntArray();
                SparseIntArray sparseIntArray2 = new SparseIntArray();
                for (C3749b0 c3749b0 : this.f1231q.f12579d) {
                    if (c3749b0 == this.f1231q.f12578c) {
                        Log.v("MotionLayout", "CHECK: CURRENT");
                    }
                    StringBuilder sb = new StringBuilder("CHECK: transition = ");
                    Context context = getContext();
                    String resourceEntryName = c3749b0.f12561d == -1 ? "null" : context.getResources().getResourceEntryName(c3749b0.f12561d);
                    if (c3749b0.f12560c == -1) {
                        string = AbstractC2460q.m5494h(resourceEntryName, " -> null");
                    } else {
                        StringBuilder sbM29w = AbstractC0004e.m29w(resourceEntryName, " -> ");
                        sbM29w.append(context.getResources().getResourceEntryName(c3749b0.f12560c));
                        string = sbM29w.toString();
                    }
                    sb.append(string);
                    Log.v("MotionLayout", sb.toString());
                    Log.v("MotionLayout", "CHECK: transition.setDuration = " + c3749b0.f12565h);
                    if (c3749b0.f12561d == c3749b0.f12560c) {
                        Log.e("MotionLayout", "CHECK: start and end constraint set should not be the same!");
                    }
                    int i14 = c3749b0.f12561d;
                    int i15 = c3749b0.f12560c;
                    String strM170x3 = AbstractC0032a.m170x(getContext(), i14);
                    String strM170x4 = AbstractC0032a.m170x(getContext(), i15);
                    if (sparseIntArray.get(i14) == i15) {
                        Log.e("MotionLayout", "CHECK: two transitions with the same start and end " + strM170x3 + "->" + strM170x4);
                    }
                    if (sparseIntArray2.get(i15) == i14) {
                        Log.e("MotionLayout", "CHECK: you can't have reverse transitions" + strM170x3 + "->" + strM170x4);
                    }
                    sparseIntArray.put(i14, i15);
                    sparseIntArray2.put(i15, i14);
                    if (this.f1231q.m7492b(i14) == null) {
                        Log.e("MotionLayout", " no such constraintSetStart " + strM170x3);
                    }
                    if (this.f1231q.m7492b(i15) == null) {
                        Log.e("MotionLayout", " no such constraintSetEnd " + strM170x3);
                    }
                }
            }
        }
        if (this.f1239u != -1 || (c3751c0 = this.f1231q) == null) {
            return;
        }
        this.f1239u = c3751c0.m7497g();
        this.f1237t = this.f1231q.m7497g();
        C3749b0 c3749b1 = this.f1231q.f12578c;
        this.f1241v = c3749b1 != null ? c3749b1.f12560c : -1;
    }

    public final void m860v() {
        C3749b0 c3749b0;
        C3775o0 c3775o0;
        View viewFindViewById;
        C3751c0 c3751c0 = this.f1231q;
        if (c3751c0 == null) {
            return;
        }
        if (c3751c0.m7491a(this, this.f1239u)) {
            requestLayout();
            return;
        }
        int i6 = this.f1239u;
        if (i6 != -1) {
            C3751c0 c3751c1 = this.f1231q;
            ArrayList<C3749b0> arrayList = c3751c1.f12579d;
            for (C3749b0 c3749b1 : arrayList) {
                if (c3749b1.f12570m.size() > 0) {
                    Iterator it = c3749b1.f12570m.iterator();
                    while (it.hasNext()) {
                        ((ViewOnClickListenerC3747a0) it.next()).m7490b(this);
                    }
                }
            }
            ArrayList<C3749b0> arrayList2 = c3751c1.f12581f;
            for (C3749b0 c3749b2 : arrayList2) {
                if (c3749b2.f12570m.size() > 0) {
                    Iterator it2 = c3749b2.f12570m.iterator();
                    while (it2.hasNext()) {
                        ((ViewOnClickListenerC3747a0) it2.next()).m7490b(this);
                    }
                }
            }
            for (C3749b0 c3749b3 : arrayList) {
                if (c3749b3.f12570m.size() > 0) {
                    Iterator it3 = c3749b3.f12570m.iterator();
                    while (it3.hasNext()) {
                        ((ViewOnClickListenerC3747a0) it3.next()).m7489a(this, i6, c3749b3);
                    }
                }
            }
            for (C3749b0 c3749b4 : arrayList2) {
                if (c3749b4.f12570m.size() > 0) {
                    Iterator it4 = c3749b4.f12570m.iterator();
                    while (it4.hasNext()) {
                        ((ViewOnClickListenerC3747a0) it4.next()).m7489a(this, i6, c3749b4);
                    }
                }
            }
        }
        if (!this.f1231q.m7502l() || (c3749b0 = this.f1231q.f12578c) == null || (c3775o0 = c3749b0.f12569l) == null) {
            return;
        }
        int i10 = c3775o0.f12678d;
        if (i10 != -1) {
            MotionLayout motionLayout = c3775o0.f12689o;
            viewFindViewById = motionLayout.findViewById(i10);
            if (viewFindViewById == null) {
                Log.e("TouchResponse", "cannot find TouchAnchorId @id/" + AbstractC0032a.m170x(motionLayout.getContext(), c3775o0.f12678d));
            }
        } else {
            viewFindViewById = null;
        }
        if (viewFindViewById instanceof NestedScrollView) {
            NestedScrollView nestedScrollView = (NestedScrollView) viewFindViewById;
            nestedScrollView.setOnTouchListener(new ViewOnTouchListenerC3773n0(0));
            nestedScrollView.setOnScrollChangeListener(new C3406f0(2));
        }
    }

    public final void m861w() {
        ArrayList arrayList;
        if (this.f1201I == null && ((arrayList = this.f1218d0) == null || arrayList.isEmpty())) {
            return;
        }
        ArrayList<Integer> arrayList2 = this.f1250z0;
        for (Integer num : arrayList2) {
            InterfaceC3783w interfaceC3783w = this.f1201I;
            if (interfaceC3783w != null) {
                num.intValue();
                interfaceC3783w.getClass();
            }
            ArrayList<InterfaceC3783w> arrayList3 = this.f1218d0;
            if (arrayList3 != null) {
                for (InterfaceC3783w interfaceC3783w2 : arrayList3) {
                    num.intValue();
                    interfaceC3783w2.getClass();
                }
            }
        }
        arrayList2.clear();
    }

    public final void m862x() {
        this.f1242v0.m7533e();
        invalidate();
    }

    public final void m863y(float f, float f3) {
        if (super.isAttachedToWindow()) {
            setProgress(f);
            setState(EnumC3784x.f12731c);
            this.f1235s = f3;
            m853o(1.0f);
            return;
        }
        if (this.f1238t0 == null) {
            this.f1238t0 = new C3782v(this);
        }
        C3782v c3782v = this.f1238t0;
        c3782v.f12724a = f;
        c3782v.f12725b = f3;
    }

    public final void m864z(int i6, int i10) {
        if (!super.isAttachedToWindow()) {
            if (this.f1238t0 == null) {
                this.f1238t0 = new C3782v(this);
            }
            C3782v c3782v = this.f1238t0;
            c3782v.f12726c = i6;
            c3782v.f12727d = i10;
            return;
        }
        C3751c0 c3751c0 = this.f1231q;
        if (c3751c0 != null) {
            this.f1237t = i6;
            this.f1241v = i10;
            c3751c0.m7501k(i6, i10);
            this.f1242v0.m7532d(this.f1231q.m7492b(i6), this.f1231q.m7492b(i10));
            m862x();
            this.f1196D = 0.0f;
            m853o(0.0f);
        }
    }

    public void setTransition(C3749b0 c3749b0) {
        C3775o0 c3775o0;
        C3751c0 c3751c0 = this.f1231q;
        c3751c0.f12578c = c3749b0;
        if (c3749b0 != null && (c3775o0 = c3749b0.f12569l) != null) {
            c3775o0.m7523b(c3751c0.f12590o);
        }
        setState(EnumC3784x.f12730b);
        int i6 = this.f1239u;
        C3749b0 c3749b1 = this.f1231q.f12578c;
        if (i6 == (c3749b1 == null ? -1 : c3749b1.f12560c)) {
            this.f1196D = 1.0f;
            this.f1195C = 1.0f;
            this.f1198F = 1.0f;
        } else {
            this.f1196D = 0.0f;
            this.f1195C = 0.0f;
            this.f1198F = 0.0f;
        }
        this.f1197E = (c3749b0.f12575r & 1) != 0 ? -1L : getNanoTime();
        int iM7497g = this.f1231q.m7497g();
        C3751c0 c3751c1 = this.f1231q;
        C3749b0 c3749b2 = c3751c1.f12578c;
        int i10 = c3749b2 != null ? c3749b2.f12560c : -1;
        if (iM7497g == this.f1237t && i10 == this.f1241v) {
            return;
        }
        this.f1237t = iM7497g;
        this.f1241v = i10;
        c3751c1.m7501k(iM7497g, i10);
        C0308d c0308dM7492b = this.f1231q.m7492b(this.f1237t);
        C0308d c0308dM7492b2 = this.f1231q.m7492b(this.f1241v);
        C3780t c3780t = this.f1242v0;
        c3780t.m7532d(c0308dM7492b, c0308dM7492b2);
        int i11 = this.f1237t;
        int i12 = this.f1241v;
        c3780t.f12719e = i11;
        c3780t.f12720f = i12;
        c3780t.m7533e();
        m862x();
    }

    public MotionLayout(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f1235s = 0.0f;
        this.f1237t = -1;
        this.f1239u = -1;
        this.f1241v = -1;
        this.f1243w = 0;
        this.f1245x = 0;
        this.f1247y = true;
        this.f1249z = new HashMap();
        this.f1193A = 0L;
        this.f1194B = 1.0f;
        this.f1195C = 0.0f;
        this.f1196D = 0.0f;
        this.f1198F = 0.0f;
        this.f1200H = false;
        this.f1202J = 0;
        this.f1204L = false;
        this.f1205M = new C3683g();
        this.f1206N = new C3778r(this);
        this.f1210R = false;
        this.f1215W = false;
        this.f1216b0 = null;
        this.f1217c0 = null;
        this.f1218d0 = null;
        this.f1219e0 = 0;
        this.f1220f0 = -1L;
        this.f1221g0 = 0.0f;
        this.f1222h0 = 0;
        this.f1223i0 = 0.0f;
        this.f1224j0 = false;
        this.f1234r0 = new C3781u();
        this.f1236s0 = false;
        this.f1240u0 = EnumC3784x.f12729a;
        this.f1242v0 = new C3780t(this);
        this.f1244w0 = false;
        this.f1246x0 = new RectF();
        this.f1248y0 = null;
        this.f1250z0 = new ArrayList();
        m859u(attributeSet);
    }

    @Override
    public final void mo547a(View view, View view2, int i6, int i10) {
    }

    @Override
    public final void mo554i(View view, int i6, int i10, int i11, int i12, int i13) {
    }
}
