package p205t;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import p000a.AbstractC0004e;
import p001a0.C0022e;
import p055ea.AbstractC2460q;
import p187r4.AbstractC3612b;
import p187r4.C3621k;
import p194s.C3678b;
import p194s.C3681e;
import p256y.C4184a;

public final class C3774o {

    public final View f12648a;

    public final int f12649b;

    public AbstractC3612b[] f12655h;

    public C3678b f12656i;

    public int[] f12660m;

    public double[] f12661n;

    public double[] f12662o;

    public String[] f12663p;

    public int[] f12664q;

    public HashMap f12669v;

    public HashMap f12670w;

    public HashMap f12671x;

    public int f12650c = -1;

    public final C3785y f12651d = new C3785y();

    public final C3785y f12652e = new C3785y();

    public final C3772n f12653f = new C3772n();

    public final C3772n f12654g = new C3772n();

    public float f12657j = Float.NaN;

    public float f12658k = 0.0f;

    public float f12659l = 1.0f;

    public final float[] f12665r = new float[4];

    public final ArrayList f12666s = new ArrayList();

    public final float[] f12667t = new float[1];

    public final ArrayList f12668u = new ArrayList();

    public int f12672y = -1;

    public C3774o(View view) {
        this.f12648a = view;
        this.f12649b = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            ((ConstraintLayout.LayoutParams) layoutParams).getClass();
        }
    }

    public final float m7517a(float[] fArr, float f) {
        float f3 = 0.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f4 = this.f12659l;
            if (f4 != 1.0d) {
                float f5 = this.f12658k;
                if (f < f5) {
                    f = 0.0f;
                }
                if (f > f5 && f < 1.0d) {
                    f = (f - f5) * f4;
                }
            }
        }
        C3681e c3681e = this.f12651d.f12735a;
        float f10 = Float.NaN;
        for (C3785y c3785y : this.f12666s) {
            C3681e c3681e2 = c3785y.f12735a;
            if (c3681e2 != null) {
                float f11 = c3785y.f12737c;
                if (f11 < f) {
                    c3681e = c3681e2;
                    f3 = f11;
                } else if (Float.isNaN(f10)) {
                    f10 = c3785y.f12737c;
                }
            }
        }
        if (c3681e != null) {
            float f12 = (Float.isNaN(f10) ? 1.0f : f10) - f3;
            double d = (f - f3) / f12;
            f = (((float) c3681e.mo7428a(d)) * f12) + f3;
            if (fArr != null) {
                fArr[0] = (float) c3681e.mo7429b(d);
            }
        }
        return f;
    }

    public final void m7518b(float f, float f3, float f4, float[] fArr) {
        double[] dArr;
        float[] fArr2 = this.f12667t;
        float fM7517a = m7517a(fArr2, f);
        AbstractC3612b[] abstractC3612bArr = this.f12655h;
        int i6 = 0;
        if (abstractC3612bArr == null) {
            C3785y c3785y = this.f12652e;
            float f5 = c3785y.f12739e;
            C3785y c3785y2 = this.f12651d;
            float f10 = f5 - c3785y2.f12739e;
            float f11 = c3785y.f12740f - c3785y2.f12740f;
            float f12 = c3785y.f12741g - c3785y2.f12741g;
            float f13 = (c3785y.f12742h - c3785y2.f12742h) + f11;
            fArr[0] = ((f12 + f10) * f3) + ((1.0f - f3) * f10);
            fArr[1] = (f13 * f4) + ((1.0f - f4) * f11);
            return;
        }
        double d = fM7517a;
        abstractC3612bArr[0].mo7279v(d, this.f12662o);
        this.f12655h[0].mo7276r(d, this.f12661n);
        float f14 = fArr2[0];
        while (true) {
            dArr = this.f12662o;
            if (i6 >= dArr.length) {
                break;
            }
            dArr[i6] = dArr[i6] * ((double) f14);
            i6++;
        }
        C3678b c3678b = this.f12656i;
        if (c3678b == null) {
            int[] iArr = this.f12660m;
            double[] dArr2 = this.f12661n;
            this.f12651d.getClass();
            C3785y.m7537d(f3, f4, fArr, iArr, dArr, dArr2);
            return;
        }
        double[] dArr3 = this.f12661n;
        if (dArr3.length > 0) {
            c3678b.mo7276r(d, dArr3);
            this.f12656i.mo7279v(d, this.f12662o);
            int[] iArr2 = this.f12660m;
            double[] dArr4 = this.f12662o;
            double[] dArr5 = this.f12661n;
            this.f12651d.getClass();
            C3785y.m7537d(f3, f4, fArr, iArr2, dArr4, dArr5);
        }
    }

    public final boolean m7519c(float f, long j10, View view, C3781u c3781u) {
        C3767k0 c3767k0;
        boolean zMo7510b;
        boolean z7;
        float f3;
        boolean z10;
        C3785y c3785y;
        C3767k0 c3767k1;
        float fM7517a = m7517a(null, f);
        HashMap map = this.f12670w;
        if (map != null) {
            Iterator it = map.values().iterator();
            while (it.hasNext()) {
                ((AbstractC3761h0) it.next()).mo7504c(view, fM7517a);
            }
        }
        HashMap map2 = this.f12669v;
        if (map2 != null) {
            c3767k0 = null;
            zMo7510b = false;
            for (AbstractC3771m0 abstractC3771m0 : map2.values()) {
                if (abstractC3771m0 instanceof C3767k0) {
                    c3767k0 = (C3767k0) abstractC3771m0;
                } else {
                    zMo7510b |= abstractC3771m0.mo7510b(fM7517a, j10, view, c3781u);
                }
            }
        } else {
            c3767k0 = null;
            zMo7510b = false;
        }
        AbstractC3612b[] abstractC3612bArr = this.f12655h;
        C3785y c3785y2 = this.f12651d;
        if (abstractC3612bArr != null) {
            double d = fM7517a;
            abstractC3612bArr[0].mo7276r(d, this.f12661n);
            this.f12655h[0].mo7279v(d, this.f12662o);
            C3678b c3678b = this.f12656i;
            if (c3678b != null) {
                double[] dArr = this.f12661n;
                if (dArr.length > 0) {
                    c3678b.mo7276r(d, dArr);
                    this.f12656i.mo7279v(d, this.f12662o);
                }
            }
            int[] iArr = this.f12660m;
            double[] dArr2 = this.f12661n;
            double[] dArr3 = this.f12662o;
            float f4 = c3785y2.f12739e;
            float f5 = c3785y2.f12740f;
            float f10 = c3785y2.f12741g;
            float f11 = c3785y2.f12742h;
            if (iArr.length != 0) {
                f3 = f10;
                if (c3785y2.f12746l.length <= iArr[iArr.length - 1]) {
                    int i6 = iArr[iArr.length - 1] + 1;
                    c3785y2.f12746l = new double[i6];
                    c3785y2.f12747m = new double[i6];
                }
            } else {
                f3 = f10;
            }
            Arrays.fill(c3785y2.f12746l, Double.NaN);
            for (int i10 = 0; i10 < iArr.length; i10++) {
                double[] dArr4 = c3785y2.f12746l;
                int i11 = iArr[i10];
                dArr4[i11] = dArr2[i10];
                c3785y2.f12747m[i11] = dArr3[i10];
            }
            int i12 = 0;
            float f12 = Float.NaN;
            float f13 = 0.0f;
            float f14 = 0.0f;
            float f15 = 0.0f;
            float f16 = 0.0f;
            while (true) {
                double[] dArr5 = c3785y2.f12746l;
                if (i12 >= dArr5.length) {
                    break;
                }
                if (Double.isNaN(dArr5[i12])) {
                    c3785y = c3785y2;
                    c3767k1 = c3767k0;
                    z10 = zMo7510b;
                } else {
                    z10 = zMo7510b;
                    float f17 = (float) (Double.isNaN(c3785y2.f12746l[i12]) ? 0.0d : c3785y2.f12746l[i12] + 0.0d);
                    c3785y = c3785y2;
                    c3767k1 = c3767k0;
                    float f18 = (float) c3785y2.f12747m[i12];
                    if (i12 == 1) {
                        f4 = f17;
                        f13 = f18;
                    } else if (i12 == 2) {
                        f5 = f17;
                        f15 = f18;
                    } else if (i12 == 3) {
                        f3 = f17;
                        f14 = f18;
                    } else if (i12 == 4) {
                        f11 = f17;
                        f16 = f18;
                    } else if (i12 == 5) {
                        f12 = f17;
                    }
                }
                i12++;
                c3767k0 = c3767k1;
                c3785y2 = c3785y;
                zMo7510b = z10;
            }
            C3785y c3785y3 = c3785y2;
            C3767k0 c3767k2 = c3767k0;
            boolean z11 = zMo7510b;
            if (!Float.isNaN(f12)) {
                view.setRotation((float) (Math.toDegrees(Math.atan2((f16 / 2.0f) + f15, (f14 / 2.0f) + f13)) + ((double) f12) + ((double) (Float.isNaN(Float.NaN) ? 0.0f : Float.NaN))));
            } else if (!Float.isNaN(Float.NaN)) {
                view.setRotation(Float.NaN);
            }
            float f19 = f4 + 0.5f;
            int i13 = (int) f19;
            float f20 = f5 + 0.5f;
            int i14 = (int) f20;
            int i15 = (int) (f19 + f3);
            int i16 = (int) (f20 + f11);
            int i17 = i15 - i13;
            int i18 = i16 - i14;
            if (i17 != view.getMeasuredWidth() || i18 != view.getMeasuredHeight()) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i17, 1073741824), View.MeasureSpec.makeMeasureSpec(i18, 1073741824));
            }
            view.layout(i13, i14, i15, i16);
            HashMap map3 = this.f12670w;
            if (map3 != null) {
                for (AbstractC3761h0 abstractC3761h0 : map3.values()) {
                    if (abstractC3761h0 instanceof C3757f0) {
                        double[] dArr6 = this.f12662o;
                        view.setRotation(((C3757f0) abstractC3761h0).m7507a(fM7517a) + ((float) Math.toDegrees(Math.atan2(dArr6[1], dArr6[0]))));
                    }
                }
            }
            if (c3767k2 != null) {
                double[] dArr7 = this.f12662o;
                view.setRotation(c3767k2.m7513a(fM7517a, j10, view, c3781u) + ((float) Math.toDegrees(Math.atan2(dArr7[1], dArr7[0]))));
                z7 = z11 | c3767k2.f12627d;
            } else {
                z7 = z11;
            }
            int i19 = 1;
            while (true) {
                AbstractC3612b[] abstractC3612bArr2 = this.f12655h;
                if (i19 >= abstractC3612bArr2.length) {
                    break;
                }
                AbstractC3612b abstractC3612b = abstractC3612bArr2[i19];
                float[] fArr = this.f12665r;
                abstractC3612b.mo7277s(d, fArr);
                ((C4184a) c3785y3.f12745k.get(this.f12663p[i19 - 1])).m8238g(view, fArr);
                i19++;
            }
            C3772n c3772n = this.f12653f;
            if (c3772n.f12631b == 0) {
                if (fM7517a <= 0.0f) {
                    view.setVisibility(c3772n.f12632c);
                } else {
                    C3772n c3772n2 = this.f12654g;
                    if (fM7517a >= 1.0f) {
                        view.setVisibility(c3772n2.f12632c);
                    } else if (c3772n2.f12632c != c3772n.f12632c) {
                        view.setVisibility(0);
                    }
                }
            }
        } else {
            boolean z12 = zMo7510b;
            float f21 = c3785y2.f12739e;
            C3785y c3785y4 = this.f12652e;
            float fM5490d = AbstractC2460q.m5490d(c3785y4.f12739e, f21, fM7517a, f21);
            float f22 = c3785y2.f12740f;
            float fM5490d2 = AbstractC2460q.m5490d(c3785y4.f12740f, f22, fM7517a, f22);
            float f23 = c3785y2.f12741g;
            float f24 = c3785y4.f12741g;
            float fM5490d3 = AbstractC2460q.m5490d(f24, f23, fM7517a, f23);
            float f25 = c3785y2.f12742h;
            float f26 = c3785y4.f12742h;
            float f27 = fM5490d + 0.5f;
            int i20 = (int) f27;
            float f28 = fM5490d2 + 0.5f;
            int i21 = (int) f28;
            int i22 = (int) (f27 + fM5490d3);
            int iM5490d = (int) (f28 + AbstractC2460q.m5490d(f26, f25, fM7517a, f25));
            int i23 = i22 - i20;
            int i24 = iM5490d - i21;
            if (f24 != f23 || f26 != f25) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i23, 1073741824), View.MeasureSpec.makeMeasureSpec(i24, 1073741824));
            }
            view.layout(i20, i21, i22, iM5490d);
            z7 = z12;
        }
        HashMap map4 = this.f12671x;
        if (map4 != null) {
            for (AbstractC3762i abstractC3762i : map4.values()) {
                if (abstractC3762i instanceof C3758g) {
                    double[] dArr8 = this.f12662o;
                    view.setRotation(((C3758g) abstractC3762i).m7508a(fM7517a) + ((float) Math.toDegrees(Math.atan2(dArr8[1], dArr8[0]))));
                } else {
                    abstractC3762i.mo7503c(view, fM7517a);
                }
            }
        }
        return z7;
    }

    public final void m7520d(C3785y c3785y) {
        float x10 = (int) this.f12648a.getX();
        float y7 = (int) this.f12648a.getY();
        float width = this.f12648a.getWidth();
        float height = this.f12648a.getHeight();
        c3785y.f12739e = x10;
        c3785y.f12740f = y7;
        c3785y.f12741g = width;
        c3785y.f12742h = height;
    }

    public final void m7521e(long j10) {
        HashSet hashSet;
        String str;
        HashMap map;
        Object obj;
        String str2;
        String str3;
        ArrayList arrayList;
        String str4;
        Iterator it;
        int i6;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        Object obj2;
        String str13;
        String str14;
        byte b8;
        C3752d c3752d;
        AbstractC3762i c3752d2;
        AbstractC3762i c3752d3;
        int i10;
        int i11;
        HashSet hashSet2;
        Iterator it2;
        ArrayList arrayList2;
        String str15;
        byte b10;
        AbstractC3771m0 c3763i0;
        C3765j0 c3765j0;
        AbstractC3771m0 abstractC3771m0;
        HashSet hashSet3;
        String str16;
        Object obj3;
        byte b11;
        AbstractC3761h0 c3753d0;
        AbstractC3761h0 c3753d1;
        C3755e0 c3755e0;
        String str17 = "translationY";
        String str18 = "translationX";
        String str19 = "scaleY";
        String str20 = "scaleX";
        String str21 = "rotationY";
        String str22 = "rotationX";
        String str23 = "progress";
        String str24 = "transitionPathRotate";
        String str25 = "rotation";
        String str26 = "alpha";
        new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        HashSet<String> hashSet6 = new HashSet();
        HashMap map2 = new HashMap();
        int i12 = this.f12672y;
        C3785y c3785y = this.f12651d;
        HashMap map3 = map2;
        if (i12 != -1) {
            c3785y.f12744j = i12;
        }
        C3772n c3772n = this.f12653f;
        float f = c3772n.f12630a;
        C3785y c3785y2 = c3785y;
        C3772n c3772n2 = this.f12654g;
        if (C3772n.m7514b(f, c3772n2.f12630a)) {
            hashSet5.add("alpha");
        }
        if (C3772n.m7514b(c3772n.f12633d, c3772n2.f12633d)) {
            hashSet5.add("elevation");
        }
        int i13 = c3772n.f12632c;
        int i14 = c3772n2.f12632c;
        Object obj4 = "elevation";
        if (i13 != i14 && c3772n.f12631b == 0 && (i13 == 0 || i14 == 0)) {
            hashSet5.add("alpha");
        }
        if (C3772n.m7514b(c3772n.f12634e, c3772n2.f12634e)) {
            hashSet5.add("rotation");
        }
        if (!Float.isNaN(c3772n.f12644o) || !Float.isNaN(c3772n2.f12644o)) {
            hashSet5.add("transitionPathRotate");
        }
        if (!Float.isNaN(c3772n.f12645p) || !Float.isNaN(c3772n2.f12645p)) {
            hashSet5.add("progress");
        }
        if (C3772n.m7514b(c3772n.f12635f, c3772n2.f12635f)) {
            hashSet5.add("rotationX");
        }
        if (C3772n.m7514b(c3772n.f12636g, c3772n2.f12636g)) {
            hashSet5.add("rotationY");
        }
        if (C3772n.m7514b(c3772n.f12639j, c3772n2.f12639j)) {
            hashSet5.add("transformPivotX");
        }
        if (C3772n.m7514b(c3772n.f12640k, c3772n2.f12640k)) {
            hashSet5.add("transformPivotY");
        }
        if (C3772n.m7514b(c3772n.f12637h, c3772n2.f12637h)) {
            hashSet5.add("scaleX");
        }
        if (C3772n.m7514b(c3772n.f12638i, c3772n2.f12638i)) {
            hashSet5.add("scaleY");
        }
        if (C3772n.m7514b(c3772n.f12641l, c3772n2.f12641l)) {
            hashSet5.add("translationX");
        }
        if (C3772n.m7514b(c3772n.f12642m, c3772n2.f12642m)) {
            hashSet5.add("translationY");
        }
        if (C3772n.m7514b(c3772n.f12643n, c3772n2.f12643n)) {
            hashSet5.add("translationZ");
        }
        ArrayList arrayList3 = this.f12668u;
        if (arrayList3 != null) {
            Iterator it3 = arrayList3.iterator();
            if (it3.hasNext()) {
                throw AbstractC0004e.m18l(it3);
            }
        }
        String str27 = "CUSTOM,";
        if (hashSet5.isEmpty()) {
            hashSet = hashSet5;
            str = "CUSTOM,";
            map = map3;
            obj = obj4;
            str2 = "rotationX";
        } else {
            this.f12670w = new HashMap();
            Iterator it4 = hashSet5.iterator();
            while (it4.hasNext()) {
                Iterator it5 = it4;
                String str28 = (String) it4.next();
                if (!str28.startsWith(str27)) {
                    hashSet3 = hashSet5;
                    str16 = str27;
                    switch (str28.hashCode()) {
                        case -1249320806:
                            obj3 = obj4;
                            if (str28.equals(str22)) {
                                b11 = 0;
                            } else {
                                b11 = -1;
                            }
                            break;
                        case -1249320805:
                            obj3 = obj4;
                            if (str28.equals("rotationY")) {
                                b11 = 1;
                            } else {
                                b11 = -1;
                            }
                            break;
                        case -1225497657:
                            obj3 = obj4;
                            if (str28.equals("translationX")) {
                                b11 = 2;
                            } else {
                                b11 = -1;
                            }
                            break;
                        case -1225497656:
                            obj3 = obj4;
                            if (str28.equals("translationY")) {
                                b11 = 3;
                            } else {
                                b11 = -1;
                            }
                            break;
                        case -1225497655:
                            obj3 = obj4;
                            if (str28.equals("translationZ")) {
                                b11 = 4;
                            } else {
                                b11 = -1;
                            }
                            break;
                        case -1001078227:
                            obj3 = obj4;
                            if (str28.equals("progress")) {
                                b11 = 5;
                            } else {
                                b11 = -1;
                            }
                            break;
                        case -908189618:
                            obj3 = obj4;
                            if (str28.equals("scaleX")) {
                                b11 = 6;
                            } else {
                                b11 = -1;
                            }
                            break;
                        case -908189617:
                            obj3 = obj4;
                            if (str28.equals("scaleY")) {
                                b11 = 7;
                            } else {
                                b11 = -1;
                            }
                            break;
                        case -797520672:
                            obj3 = obj4;
                            if (str28.equals("waveVariesBy")) {
                                b11 = 8;
                            } else {
                                b11 = -1;
                            }
                            break;
                        case -760884510:
                            obj3 = obj4;
                            if (str28.equals("transformPivotX")) {
                                b11 = 9;
                            } else {
                                b11 = -1;
                            }
                            break;
                        case -760884509:
                            obj3 = obj4;
                            if (str28.equals("transformPivotY")) {
                                b11 = 10;
                            } else {
                                b11 = -1;
                            }
                            break;
                        case -40300674:
                            obj3 = obj4;
                            if (str28.equals("rotation")) {
                                b11 = 11;
                            } else {
                                b11 = -1;
                            }
                            break;
                        case -4379043:
                            obj3 = obj4;
                            if (str28.equals(obj3)) {
                                b11 = 12;
                            } else {
                                b11 = -1;
                            }
                            break;
                        case 37232917:
                            if (str28.equals("transitionPathRotate")) {
                                obj3 = obj4;
                                b11 = 13;
                            } else {
                                obj3 = obj4;
                                b11 = -1;
                            }
                            break;
                        case 92909918:
                            if (str28.equals("alpha")) {
                                obj3 = obj4;
                                b11 = 14;
                            } else {
                                obj3 = obj4;
                                b11 = -1;
                            }
                            break;
                        case 156108012:
                            if (str28.equals("waveOffset")) {
                                obj3 = obj4;
                                b11 = 15;
                            } else {
                                obj3 = obj4;
                                b11 = -1;
                            }
                            break;
                        default:
                            obj3 = obj4;
                            b11 = -1;
                            break;
                    }
                    switch (b11) {
                        case 0:
                            c3753d0 = new C3753d0(5);
                            c3753d1 = c3753d0;
                            break;
                        case 1:
                            c3753d0 = new C3753d0(6);
                            c3753d1 = c3753d0;
                            break;
                        case 2:
                            c3753d0 = new C3753d0(9);
                            c3753d1 = c3753d0;
                            break;
                        case 3:
                            c3753d0 = new C3753d0(10);
                            c3753d1 = c3753d0;
                            break;
                        case 4:
                            c3753d0 = new C3753d0(11);
                            c3753d1 = c3753d0;
                            break;
                        case 5:
                            C3759g0 c3759g0 = new C3759g0();
                            c3759g0.f12606f = false;
                            c3753d0 = c3759g0;
                            c3753d1 = c3753d0;
                            break;
                        case 6:
                            c3753d0 = new C3753d0(7);
                            c3753d1 = c3753d0;
                            break;
                        case 7:
                            c3753d0 = new C3753d0(8);
                            c3753d1 = c3753d0;
                            break;
                        case 8:
                            c3753d0 = new C3753d0(0);
                            c3753d1 = c3753d0;
                            break;
                        case 9:
                            c3753d0 = new C3753d0(2);
                            c3753d1 = c3753d0;
                            break;
                        case 10:
                            c3753d0 = new C3753d0(3);
                            c3753d1 = c3753d0;
                            break;
                        case 11:
                            c3753d0 = new C3753d0(4);
                            c3753d1 = c3753d0;
                            break;
                        case 12:
                            c3753d0 = new C3753d0(1);
                            c3753d1 = c3753d0;
                            break;
                        case 13:
                            c3753d0 = new C3757f0();
                            c3753d1 = c3753d0;
                            break;
                        case 14:
                            str22 = str22;
                            c3753d1 = new C3753d0(0);
                            break;
                        case 15:
                            str22 = str22;
                            c3753d1 = new C3753d0(0);
                            break;
                        default:
                            str22 = str22;
                            c3753d1 = null;
                            break;
                    }
                } else {
                    hashSet3 = hashSet5;
                    SparseArray sparseArray = new SparseArray();
                    String str29 = str28.split(",")[1];
                    Iterator it6 = arrayList3.iterator();
                    if (it6.hasNext()) {
                        throw AbstractC0004e.m18l(it6);
                    }
                    str16 = str27;
                    c3755e0 = new C3755e0();
                    String str30 = str28.split(",")[1];
                    c3755e0.f12596f = sparseArray;
                    obj3 = obj4;
                    str22 = str22;
                }
                if (c3753d1 == null) {
                    c3753d1 = c3755e0;
                } else {
                    c3753d1 = c3755e0;
                    c3753d1.f12612e = str28;
                    this.f12670w.put(str28, c3753d1);
                }
                str22 = str22;
                it4 = it5;
                str27 = str16;
                obj4 = obj3;
                hashSet5 = hashSet3;
            }
            hashSet = hashSet5;
            str = str27;
            obj = obj4;
            str2 = str22;
            if (arrayList3 != null) {
                Iterator it7 = arrayList3.iterator();
                while (it7.hasNext()) {
                    if (it7.next() != null) {
                        throw new ClassCastException();
                    }
                }
            }
            c3772n.m7515a(this.f12670w, 0);
            c3772n2.m7515a(this.f12670w, 100);
            Iterator it8 = this.f12670w.keySet().iterator();
            while (it8.hasNext()) {
                String str31 = (String) it8.next();
                HashMap map4 = map3;
                ((AbstractC3761h0) this.f12670w.get(str31)).mo7506d(map4.containsKey(str31) ? ((Integer) map4.get(str31)).intValue() : 0);
                it8 = it8;
                map3 = map4;
            }
            map = map3;
        }
        if (hashSet4.isEmpty()) {
            str3 = "rotationY";
            arrayList = arrayList3;
        } else {
            if (this.f12669v == null) {
                this.f12669v = new HashMap();
            }
            Iterator it9 = hashSet4.iterator();
            while (it9.hasNext()) {
                String str32 = (String) it9.next();
                if (!this.f12669v.containsKey(str32)) {
                    String str33 = str;
                    if (str32.startsWith(str33)) {
                        it2 = it9;
                        SparseArray sparseArray2 = new SparseArray();
                        String str34 = str32.split(",")[1];
                        Iterator it10 = arrayList3.iterator();
                        if (it10.hasNext()) {
                            throw AbstractC0004e.m18l(it10);
                        }
                        str = str33;
                        C3765j0 c3765j1 = new C3765j0();
                        arrayList2 = arrayList3;
                        c3765j1.f12620h = new SparseArray();
                        String str35 = str32.split(",")[1];
                        c3765j1.f12619g = sparseArray2;
                        c3765j0 = c3765j1;
                    } else {
                        it2 = it9;
                        arrayList2 = arrayList3;
                        str = str33;
                        switch (str32.hashCode()) {
                            case -1249320806:
                                str15 = str2;
                                b10 = str32.equals(str15) ? (byte) 0 : (byte) -1;
                                break;
                            case -1249320805:
                                if (str32.equals(str21)) {
                                    str15 = str2;
                                    b10 = 1;
                                } else {
                                    str15 = str2;
                                }
                                break;
                            case -1225497657:
                                if (str32.equals("translationX")) {
                                    str15 = str2;
                                    b10 = 2;
                                } else {
                                    str15 = str2;
                                }
                                break;
                            case -1225497656:
                                if (str32.equals("translationY")) {
                                    str15 = str2;
                                    b10 = 3;
                                } else {
                                    str15 = str2;
                                }
                                break;
                            case -1225497655:
                                if (str32.equals("translationZ")) {
                                    str15 = str2;
                                    b10 = 4;
                                } else {
                                    str15 = str2;
                                }
                                break;
                            case -1001078227:
                                if (str32.equals("progress")) {
                                    str15 = str2;
                                    b10 = 5;
                                } else {
                                    str15 = str2;
                                }
                                break;
                            case -908189618:
                                if (str32.equals("scaleX")) {
                                    str15 = str2;
                                    b10 = 6;
                                } else {
                                    str15 = str2;
                                }
                                break;
                            case -908189617:
                                if (str32.equals("scaleY")) {
                                    str15 = str2;
                                    b10 = 7;
                                } else {
                                    str15 = str2;
                                }
                                break;
                            case -40300674:
                                if (str32.equals("rotation")) {
                                    str15 = str2;
                                    b10 = 8;
                                } else {
                                    str15 = str2;
                                }
                                break;
                            case -4379043:
                                if (str32.equals(obj)) {
                                    str15 = str2;
                                    b10 = 9;
                                } else {
                                    str15 = str2;
                                }
                                break;
                            case 37232917:
                                if (str32.equals("transitionPathRotate")) {
                                    str15 = str2;
                                    b10 = 10;
                                } else {
                                    str15 = str2;
                                }
                                break;
                            case 92909918:
                                if (str32.equals("alpha")) {
                                    str15 = str2;
                                    b10 = 11;
                                } else {
                                    str15 = str2;
                                }
                                break;
                            default:
                                str15 = str2;
                                break;
                        }
                        switch (b10) {
                            case 0:
                                c3763i0 = new C3763i0(3);
                                str21 = str21;
                                str2 = str15;
                                c3763i0.f12628e = j10;
                                abstractC3771m0 = c3763i0;
                                break;
                            case 1:
                                c3763i0 = new C3763i0(4);
                                str21 = str21;
                                str2 = str15;
                                c3763i0.f12628e = j10;
                                abstractC3771m0 = c3763i0;
                                break;
                            case 2:
                                c3763i0 = new C3763i0(7);
                                str21 = str21;
                                str2 = str15;
                                c3763i0.f12628e = j10;
                                abstractC3771m0 = c3763i0;
                                break;
                            case 3:
                                c3763i0 = new C3763i0(8);
                                str21 = str21;
                                str2 = str15;
                                c3763i0.f12628e = j10;
                                abstractC3771m0 = c3763i0;
                                break;
                            case 4:
                                c3763i0 = new C3763i0(9);
                                str21 = str21;
                                str2 = str15;
                                c3763i0.f12628e = j10;
                                abstractC3771m0 = c3763i0;
                                break;
                            case 5:
                                C3769l0 c3769l0 = new C3769l0();
                                c3769l0.f12623g = false;
                                c3763i0 = c3769l0;
                                str21 = str21;
                                str2 = str15;
                                c3763i0.f12628e = j10;
                                abstractC3771m0 = c3763i0;
                                break;
                            case 6:
                                c3763i0 = new C3763i0(5);
                                str21 = str21;
                                str2 = str15;
                                c3763i0.f12628e = j10;
                                abstractC3771m0 = c3763i0;
                                break;
                            case 7:
                                c3763i0 = new C3763i0(6);
                                str21 = str21;
                                str2 = str15;
                                c3763i0.f12628e = j10;
                                abstractC3771m0 = c3763i0;
                                break;
                            case 8:
                                c3763i0 = new C3763i0(2);
                                str21 = str21;
                                str2 = str15;
                                c3763i0.f12628e = j10;
                                abstractC3771m0 = c3763i0;
                                break;
                            case 9:
                                c3763i0 = new C3763i0(1);
                                str21 = str21;
                                str2 = str15;
                                c3763i0.f12628e = j10;
                                abstractC3771m0 = c3763i0;
                                break;
                            case 10:
                                c3763i0 = new C3767k0();
                                str21 = str21;
                                str2 = str15;
                                c3763i0.f12628e = j10;
                                abstractC3771m0 = c3763i0;
                                break;
                            case 11:
                                c3763i0 = new C3763i0(0);
                                str21 = str21;
                                str2 = str15;
                                c3763i0.f12628e = j10;
                                abstractC3771m0 = c3763i0;
                                break;
                            default:
                                str2 = str15;
                                c3765j0 = null;
                                break;
                        }
                        if (abstractC3771m0 != null) {
                            abstractC3771m0.f12625b = str32;
                            this.f12669v.put(str32, abstractC3771m0);
                        }
                        str21 = str21;
                        it9 = it2;
                        arrayList3 = arrayList2;
                    }
                    abstractC3771m0 = c3765j0;
                    if (abstractC3771m0 != null) {
                        abstractC3771m0.f12625b = str32;
                        this.f12669v.put(str32, abstractC3771m0);
                    }
                    str21 = str21;
                    it9 = it2;
                    arrayList3 = arrayList2;
                }
            }
            str3 = str21;
            arrayList = arrayList3;
            if (arrayList != null) {
                Iterator it11 = arrayList.iterator();
                while (it11.hasNext()) {
                    if (it11.next() != null) {
                        throw new ClassCastException();
                    }
                }
            }
            for (String str36 : this.f12669v.keySet()) {
                HashMap map5 = map;
                ((AbstractC3771m0) this.f12669v.get(str36)).mo7512c(map5.containsKey(str36) ? ((Integer) map5.get(str36)).intValue() : 0);
                map = map5;
            }
        }
        ArrayList arrayList4 = this.f12666s;
        int size = arrayList4.size();
        int i15 = size + 2;
        C3785y[] c3785yArr = new C3785y[i15];
        c3785yArr[0] = c3785y2;
        C3785y c3785y3 = this.f12652e;
        c3785yArr[size + 1] = c3785y3;
        if (arrayList4.size() > 0) {
            str4 = str3;
            if (this.f12650c == -1) {
                this.f12650c = 0;
            }
        } else {
            str4 = str3;
        }
        Iterator it12 = arrayList4.iterator();
        int i16 = 1;
        while (it12.hasNext()) {
            c3785yArr[i16] = (C3785y) it12.next();
            i16++;
        }
        HashSet hashSet7 = new HashSet();
        Iterator it13 = c3785y3.f12745k.keySet().iterator();
        while (it13.hasNext()) {
            String str37 = (String) it13.next();
            Iterator it14 = it13;
            C3785y c3785y4 = c3785y2;
            if (c3785y4.f12745k.containsKey(str37)) {
                c3785y2 = c3785y4;
                hashSet2 = hashSet;
                if (!hashSet2.contains(str + str37)) {
                    hashSet7.add(str37);
                }
            } else {
                c3785y2 = c3785y4;
                hashSet2 = hashSet;
            }
            it13 = it14;
            hashSet = hashSet2;
        }
        String[] strArr = (String[]) hashSet7.toArray(new String[0]);
        this.f12663p = strArr;
        this.f12664q = new int[strArr.length];
        int i17 = 0;
        while (true) {
            String[] strArr2 = this.f12663p;
            if (i17 < strArr2.length) {
                String str38 = strArr2[i17];
                this.f12664q[i17] = 0;
                for (int i18 = 0; i18 < i15; i18++) {
                    if (c3785yArr[i18].f12745k.containsKey(str38)) {
                        int[] iArr = this.f12664q;
                        iArr[i17] = ((C4184a) c3785yArr[i18].f12745k.get(str38)).m8237d() + iArr[i17];
                        i17++;
                    }
                }
                i17++;
            } else {
                boolean z7 = c3785yArr[0].f12744j != -1;
                int length = 18 + strArr2.length;
                boolean[] zArr = new boolean[length];
                int i19 = 1;
                while (i19 < i15) {
                    String str39 = str18;
                    C3785y c3785y5 = c3785yArr[i19];
                    String str40 = str17;
                    C3785y c3785y6 = c3785yArr[i19 - 1];
                    c3785y5.getClass();
                    zArr[0] = zArr[0] | C3785y.m7536b(c3785y5.f12738d, c3785y6.f12738d);
                    zArr[1] = C3785y.m7536b(c3785y5.f12739e, c3785y6.f12739e) | z7 | zArr[1];
                    zArr[2] = C3785y.m7536b(c3785y5.f12740f, c3785y6.f12740f) | z7 | zArr[2];
                    zArr[3] = C3785y.m7536b(c3785y5.f12741g, c3785y6.f12741g) | zArr[3];
                    zArr[4] = C3785y.m7536b(c3785y5.f12742h, c3785y6.f12742h) | zArr[4];
                    i19++;
                    str18 = str39;
                    str19 = str19;
                    str17 = str40;
                    str23 = str23;
                    str20 = str20;
                }
                String str41 = str17;
                String str42 = str18;
                String str43 = str19;
                String str44 = str20;
                String str45 = str23;
                int i20 = 0;
                for (int i21 = 1; i21 < length; i21++) {
                    if (zArr[i21]) {
                        i20++;
                    }
                }
                this.f12660m = new int[i20];
                this.f12661n = new double[i20];
                this.f12662o = new double[i20];
                int i22 = 0;
                int i23 = 1;
                while (i23 < length) {
                    if (zArr[i23]) {
                        i11 = 1;
                        this.f12660m[i22] = i23;
                        i22++;
                    } else {
                        i11 = 1;
                    }
                    i23 += i11;
                }
                double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i15, this.f12660m.length);
                double[] dArr2 = new double[i15];
                int i24 = 0;
                while (i24 < i15) {
                    C3785y c3785y7 = c3785yArr[i24];
                    double[] dArr3 = dArr[i24];
                    int[] iArr2 = this.f12660m;
                    String str46 = str25;
                    Object obj5 = obj;
                    String str47 = str24;
                    String str48 = str26;
                    int i25 = 6;
                    float[] fArr = {c3785y7.f12738d, c3785y7.f12739e, c3785y7.f12740f, c3785y7.f12741g, c3785y7.f12742h, c3785y7.f12743i};
                    int i26 = 0;
                    int i27 = 0;
                    while (i26 < iArr2.length) {
                        int i28 = iArr2[i26];
                        if (i28 < i25) {
                            dArr3[i27] = fArr[i28];
                            i27++;
                        }
                        i26++;
                        i25 = 6;
                    }
                    dArr2[i24] = c3785yArr[i24].f12737c;
                    i24++;
                    str25 = str46;
                    obj = obj5;
                    str24 = str47;
                    str26 = str48;
                }
                String str49 = str24;
                String str50 = str25;
                String str51 = str26;
                Object obj6 = obj;
                int i29 = 0;
                while (true) {
                    int[] iArr3 = this.f12660m;
                    if (i29 < iArr3.length) {
                        if (iArr3[i29] < 6) {
                            String strM26t = AbstractC0004e.m26t(new StringBuilder(), C3785y.f12734n[this.f12660m[i29]], " [");
                            for (int i30 = 0; i30 < i15; i30++) {
                                StringBuilder sbM5498l = AbstractC2460q.m5498l(strM26t);
                                sbM5498l.append(dArr[i30][i29]);
                                strM26t = sbM5498l.toString();
                            }
                        }
                        i29++;
                    } else {
                        this.f12655h = new AbstractC3612b[this.f12663p.length + 1];
                        int i31 = 0;
                        while (true) {
                            String[] strArr3 = this.f12663p;
                            if (i31 >= strArr3.length) {
                                int i32 = i15;
                                this.f12655h[0] = AbstractC3612b.m7269k(this.f12650c, dArr2, dArr);
                                if (c3785yArr[0].f12744j != -1) {
                                    int[] iArr4 = new int[i32];
                                    double[] dArr4 = new double[i32];
                                    double[][] dArr5 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i32, 2);
                                    for (int i33 = 0; i33 < i32; i33++) {
                                        C3785y c3785y8 = c3785yArr[i33];
                                        iArr4[i33] = c3785y8.f12744j;
                                        dArr4[i33] = c3785y8.f12737c;
                                        double[] dArr6 = dArr5[i33];
                                        dArr6[0] = c3785y8.f12739e;
                                        dArr6[1] = c3785y8.f12740f;
                                    }
                                    this.f12656i = new C3678b(iArr4, dArr4, dArr5);
                                }
                                this.f12671x = new HashMap();
                                if (arrayList != null) {
                                    for (String str52 : hashSet6) {
                                        if (str52.startsWith("CUSTOM")) {
                                            C3754e c3754e = new C3754e();
                                            c3754e.f12595d = new float[1];
                                            c3752d2 = c3754e;
                                            str5 = str4;
                                            str6 = str42;
                                            str7 = str43;
                                            str8 = str2;
                                            str9 = str41;
                                            str10 = str45;
                                            str11 = str44;
                                            str12 = str50;
                                            obj2 = obj6;
                                            str13 = str49;
                                            str14 = str51;
                                        } else {
                                            switch (str52.hashCode()) {
                                                case -1249320806:
                                                    str5 = str4;
                                                    str6 = str42;
                                                    str7 = str43;
                                                    str8 = str2;
                                                    str9 = str41;
                                                    str10 = str45;
                                                    str11 = str44;
                                                    str12 = str50;
                                                    obj2 = obj6;
                                                    str13 = str49;
                                                    str14 = str51;
                                                    b8 = str52.equals(str8) ? (byte) 0 : (byte) -1;
                                                    break;
                                                case -1249320805:
                                                    str5 = str4;
                                                    str6 = str42;
                                                    str7 = str43;
                                                    str9 = str41;
                                                    str10 = str45;
                                                    str11 = str44;
                                                    str12 = str50;
                                                    obj2 = obj6;
                                                    str13 = str49;
                                                    str14 = str51;
                                                    if (str52.equals(str5)) {
                                                        str8 = str2;
                                                        b8 = 1;
                                                    } else {
                                                        str8 = str2;
                                                    }
                                                    break;
                                                case -1225497657:
                                                    str6 = str42;
                                                    str7 = str43;
                                                    str9 = str41;
                                                    str10 = str45;
                                                    str11 = str44;
                                                    str12 = str50;
                                                    obj2 = obj6;
                                                    str13 = str49;
                                                    str14 = str51;
                                                    if (str52.equals(str6)) {
                                                        str5 = str4;
                                                        str8 = str2;
                                                        b8 = 2;
                                                    } else {
                                                        str5 = str4;
                                                        str8 = str2;
                                                    }
                                                    break;
                                                case -1225497656:
                                                    str7 = str43;
                                                    str9 = str41;
                                                    str10 = str45;
                                                    str11 = str44;
                                                    str12 = str50;
                                                    obj2 = obj6;
                                                    str13 = str49;
                                                    str14 = str51;
                                                    str5 = str4;
                                                    if (str52.equals(str9)) {
                                                        str6 = str42;
                                                        str8 = str2;
                                                        b8 = 3;
                                                    } else {
                                                        str6 = str42;
                                                        str8 = str2;
                                                    }
                                                    break;
                                                case -1225497655:
                                                    str7 = str43;
                                                    str10 = str45;
                                                    str11 = str44;
                                                    str12 = str50;
                                                    obj2 = obj6;
                                                    str13 = str49;
                                                    str14 = str51;
                                                    if (str52.equals("translationZ")) {
                                                        str5 = str4;
                                                        str6 = str42;
                                                        str8 = str2;
                                                        str9 = str41;
                                                        b8 = 4;
                                                    } else {
                                                        str5 = str4;
                                                        str6 = str42;
                                                        str8 = str2;
                                                        str9 = str41;
                                                    }
                                                    break;
                                                case -1001078227:
                                                    str7 = str43;
                                                    str10 = str45;
                                                    str11 = str44;
                                                    str12 = str50;
                                                    obj2 = obj6;
                                                    str13 = str49;
                                                    str14 = str51;
                                                    if (str52.equals(str10)) {
                                                        str5 = str4;
                                                        str6 = str42;
                                                        str8 = str2;
                                                        str9 = str41;
                                                        b8 = 5;
                                                    } else {
                                                        str5 = str4;
                                                        str6 = str42;
                                                        str8 = str2;
                                                        str9 = str41;
                                                    }
                                                    break;
                                                case -908189618:
                                                    str7 = str43;
                                                    str11 = str44;
                                                    str12 = str50;
                                                    obj2 = obj6;
                                                    str13 = str49;
                                                    str14 = str51;
                                                    str5 = str4;
                                                    str6 = str42;
                                                    str8 = str2;
                                                    str9 = str41;
                                                    if (str52.equals(str11)) {
                                                        str10 = str45;
                                                        b8 = 6;
                                                    } else {
                                                        str10 = str45;
                                                    }
                                                    break;
                                                case -908189617:
                                                    str7 = str43;
                                                    str12 = str50;
                                                    obj2 = obj6;
                                                    str13 = str49;
                                                    str14 = str51;
                                                    str5 = str4;
                                                    str6 = str42;
                                                    str8 = str2;
                                                    str9 = str41;
                                                    str10 = str45;
                                                    if (str52.equals(str7)) {
                                                        str11 = str44;
                                                        b8 = 7;
                                                    } else {
                                                        str11 = str44;
                                                    }
                                                    break;
                                                case -797520672:
                                                    str12 = str50;
                                                    obj2 = obj6;
                                                    str13 = str49;
                                                    str14 = str51;
                                                    if (str52.equals("waveVariesBy")) {
                                                        str5 = str4;
                                                        str6 = str42;
                                                        str7 = str43;
                                                        str8 = str2;
                                                        str9 = str41;
                                                        str10 = str45;
                                                        str11 = str44;
                                                        b8 = 8;
                                                    } else {
                                                        str5 = str4;
                                                        str6 = str42;
                                                        str7 = str43;
                                                        str8 = str2;
                                                        str9 = str41;
                                                        str10 = str45;
                                                        str11 = str44;
                                                    }
                                                    break;
                                                case -40300674:
                                                    str12 = str50;
                                                    obj2 = obj6;
                                                    str13 = str49;
                                                    str14 = str51;
                                                    if (str52.equals(str12)) {
                                                        str5 = str4;
                                                        str6 = str42;
                                                        str7 = str43;
                                                        str8 = str2;
                                                        str9 = str41;
                                                        str10 = str45;
                                                        str11 = str44;
                                                        b8 = 9;
                                                    } else {
                                                        str5 = str4;
                                                        str6 = str42;
                                                        str7 = str43;
                                                        str8 = str2;
                                                        str9 = str41;
                                                        str10 = str45;
                                                        str11 = str44;
                                                    }
                                                    break;
                                                case -4379043:
                                                    obj2 = obj6;
                                                    str13 = str49;
                                                    str14 = str51;
                                                    if (str52.equals(obj2)) {
                                                        str5 = str4;
                                                        str6 = str42;
                                                        str7 = str43;
                                                        str8 = str2;
                                                        str9 = str41;
                                                        str10 = str45;
                                                        str11 = str44;
                                                        str12 = str50;
                                                        b8 = 10;
                                                    } else {
                                                        str5 = str4;
                                                        str6 = str42;
                                                        str7 = str43;
                                                        str8 = str2;
                                                        str9 = str41;
                                                        str10 = str45;
                                                        str11 = str44;
                                                        str12 = str50;
                                                    }
                                                    break;
                                                case 37232917:
                                                    str13 = str49;
                                                    str14 = str51;
                                                    if (str52.equals(str13)) {
                                                        str5 = str4;
                                                        str6 = str42;
                                                        str7 = str43;
                                                        str8 = str2;
                                                        str9 = str41;
                                                        str10 = str45;
                                                        str11 = str44;
                                                        str12 = str50;
                                                        obj2 = obj6;
                                                        b8 = 11;
                                                    } else {
                                                        str5 = str4;
                                                        str6 = str42;
                                                        str7 = str43;
                                                        str8 = str2;
                                                        str9 = str41;
                                                        str10 = str45;
                                                        str11 = str44;
                                                        str12 = str50;
                                                        obj2 = obj6;
                                                    }
                                                    break;
                                                case 92909918:
                                                    str14 = str51;
                                                    if (str52.equals(str14)) {
                                                        str5 = str4;
                                                        str6 = str42;
                                                        str7 = str43;
                                                        str8 = str2;
                                                        str9 = str41;
                                                        str10 = str45;
                                                        str11 = str44;
                                                        str12 = str50;
                                                        obj2 = obj6;
                                                        str13 = str49;
                                                        b8 = 12;
                                                    } else {
                                                        str5 = str4;
                                                        str6 = str42;
                                                        str7 = str43;
                                                        str8 = str2;
                                                        str9 = str41;
                                                        str10 = str45;
                                                        str11 = str44;
                                                        str12 = str50;
                                                        obj2 = obj6;
                                                        str13 = str49;
                                                    }
                                                    break;
                                                case 156108012:
                                                    if (str52.equals("waveOffset")) {
                                                        str5 = str4;
                                                        str6 = str42;
                                                        str7 = str43;
                                                        str8 = str2;
                                                        str9 = str41;
                                                        str10 = str45;
                                                        str11 = str44;
                                                        str12 = str50;
                                                        obj2 = obj6;
                                                        str13 = str49;
                                                        str14 = str51;
                                                        b8 = 13;
                                                        break;
                                                    }
                                                default:
                                                    str5 = str4;
                                                    str6 = str42;
                                                    str7 = str43;
                                                    str8 = str2;
                                                    str9 = str41;
                                                    str10 = str45;
                                                    str11 = str44;
                                                    str12 = str50;
                                                    obj2 = obj6;
                                                    str13 = str49;
                                                    str14 = str51;
                                                    break;
                                            }
                                            switch (b8) {
                                                case 0:
                                                    c3752d3 = new C3752d(3);
                                                    break;
                                                case 1:
                                                    c3752d2 = new C3752d(4);
                                                    break;
                                                case 2:
                                                    c3752d2 = new C3752d(7);
                                                    break;
                                                case 3:
                                                    c3752d2 = new C3752d(8);
                                                    break;
                                                case 4:
                                                    c3752d2 = new C3752d(9);
                                                    break;
                                                case 5:
                                                    C3760h c3760h = new C3760h();
                                                    c3760h.f12607d = false;
                                                    c3752d2 = c3760h;
                                                    break;
                                                case 6:
                                                    c3752d2 = new C3752d(5);
                                                    break;
                                                case 7:
                                                    c3752d2 = new C3752d(6);
                                                    break;
                                                case 8:
                                                    c3752d2 = new C3752d(0);
                                                    break;
                                                case 9:
                                                    c3752d2 = new C3752d(2);
                                                    break;
                                                case 10:
                                                    c3752d2 = new C3752d(1);
                                                    break;
                                                case 11:
                                                    c3752d2 = new C3758g();
                                                    break;
                                                case 12:
                                                    c3752d = new C3752d(0);
                                                    c3752d2 = c3752d;
                                                    break;
                                                case 13:
                                                    c3752d = new C3752d(0);
                                                    c3752d2 = c3752d;
                                                    break;
                                                default:
                                                    c3752d2 = null;
                                                    break;
                                            }
                                            if (c3752d3 == null) {
                                                c3752d3.f12614b = str52;
                                                this.f12671x.put(str52, c3752d3);
                                            }
                                            str51 = str14;
                                            str49 = str13;
                                            obj6 = obj2;
                                            str50 = str12;
                                            str43 = str7;
                                            str44 = str11;
                                            str45 = str10;
                                            str41 = str9;
                                            str42 = str6;
                                            str4 = str5;
                                            str2 = str8;
                                        }
                                        c3752d3 = c3752d2;
                                        if (c3752d3 == null) {
                                            c3752d3.f12614b = str52;
                                            this.f12671x.put(str52, c3752d3);
                                        }
                                        str51 = str14;
                                        str49 = str13;
                                        obj6 = obj2;
                                        str50 = str12;
                                        str43 = str7;
                                        str44 = str11;
                                        str45 = str10;
                                        str41 = str9;
                                        str42 = str6;
                                        str4 = str5;
                                        str2 = str8;
                                    }
                                    Iterator it15 = arrayList.iterator();
                                    while (it15.hasNext()) {
                                        if (it15.next() != null) {
                                            throw new ClassCastException();
                                        }
                                    }
                                    Iterator it16 = this.f12671x.values().iterator();
                                    while (it16.hasNext()) {
                                        AbstractC3762i abstractC3762i = (AbstractC3762i) it16.next();
                                        ArrayList arrayList5 = abstractC3762i.f12615c;
                                        int size2 = arrayList5.size();
                                        if (size2 == 0) {
                                            it = it16;
                                        } else {
                                            Collections.sort(arrayList5, new C0022e(7));
                                            double[] dArr7 = new double[size2];
                                            Class cls = Double.TYPE;
                                            double[][] dArr8 = (double[][]) Array.newInstance((Class<?>) cls, size2, 2);
                                            C3756f c3756f = new C3756f();
                                            C3621k c3621k = new C3621k(1);
                                            c3621k.f12170b = new float[0];
                                            c3621k.f12171c = new double[0];
                                            c3756f.f12598a = c3621k;
                                            new HashMap();
                                            c3756f.f12599b = new float[size2];
                                            c3756f.f12600c = new double[size2];
                                            c3756f.f12601d = new float[size2];
                                            c3756f.f12602e = new float[size2];
                                            float[] fArr2 = new float[size2];
                                            abstractC3762i.f12613a = c3756f;
                                            Iterator it17 = arrayList5.iterator();
                                            if (it17.hasNext()) {
                                                throw AbstractC0004e.m18l(it17);
                                            }
                                            C3756f c3756f2 = abstractC3762i.f12613a;
                                            double[] dArr9 = c3756f2.f12600c;
                                            double[][] dArr10 = (double[][]) Array.newInstance((Class<?>) cls, dArr9.length, 2);
                                            float[] fArr3 = c3756f2.f12599b;
                                            c3756f2.f12604g = new double[fArr3.length + 1];
                                            c3756f2.f12605h = new double[fArr3.length + 1];
                                            double d = dArr9[0];
                                            float[] fArr4 = c3756f2.f12601d;
                                            C3621k c3621k2 = c3756f2.f12598a;
                                            if (d > 0.0d) {
                                                c3621k2.m7330g(0.0d, fArr4[0]);
                                            }
                                            int length2 = dArr9.length - 1;
                                            if (dArr9[length2] < 1.0d) {
                                                c3621k2.m7330g(1.0d, fArr4[length2]);
                                            }
                                            for (int i34 = 0; i34 < dArr10.length; i34++) {
                                                dArr10[i34][0] = c3756f2.f12602e[i34];
                                                for (int i35 = 0; i35 < fArr3.length; i35++) {
                                                    dArr10[i35][1] = fArr3[i35];
                                                }
                                                c3621k2.m7330g(dArr9[i34], fArr4[i34]);
                                            }
                                            int i36 = 0;
                                            double d10 = 0.0d;
                                            while (true) {
                                                float[] fArr5 = (float[]) c3621k2.f12170b;
                                                if (i36 < fArr5.length) {
                                                    d10 += (double) fArr5[i36];
                                                    i36++;
                                                } else {
                                                    int i37 = 1;
                                                    double d11 = 0.0d;
                                                    while (true) {
                                                        float[] fArr6 = (float[]) c3621k2.f12170b;
                                                        if (i37 < fArr6.length) {
                                                            int i38 = i37 - 1;
                                                            float f3 = (fArr6[i38] + fArr6[i37]) / 2.0f;
                                                            double[] dArr11 = (double[]) c3621k2.f12171c;
                                                            d11 = ((dArr11[i37] - dArr11[i38]) * ((double) f3)) + d11;
                                                            i37++;
                                                            it16 = it16;
                                                        } else {
                                                            it = it16;
                                                            int i39 = 0;
                                                            while (true) {
                                                                float[] fArr7 = (float[]) c3621k2.f12170b;
                                                                if (i39 < fArr7.length) {
                                                                    fArr7[i39] = (float) (((double) fArr7[i39]) * (d10 / d11));
                                                                    i39++;
                                                                } else {
                                                                    ((double[]) c3621k2.f12172d)[0] = 0.0d;
                                                                    int i40 = 1;
                                                                    while (true) {
                                                                        float[] fArr8 = (float[]) c3621k2.f12170b;
                                                                        if (i40 < fArr8.length) {
                                                                            int i41 = i40 - 1;
                                                                            float f4 = (fArr8[i41] + fArr8[i40]) / 2.0f;
                                                                            double[] dArr12 = (double[]) c3621k2.f12171c;
                                                                            double d12 = dArr12[i40] - dArr12[i41];
                                                                            double[] dArr13 = (double[]) c3621k2.f12172d;
                                                                            dArr13[i40] = (d12 * ((double) f4)) + dArr13[i41];
                                                                            i40++;
                                                                        } else {
                                                                            if (dArr9.length > 1) {
                                                                                i6 = 0;
                                                                                c3756f2.f12603f = AbstractC3612b.m7269k(0, dArr9, dArr10);
                                                                            } else {
                                                                                i6 = 0;
                                                                                c3756f2.f12603f = null;
                                                                            }
                                                                            AbstractC3612b.m7269k(i6, dArr7, dArr8);
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        it16 = it;
                                    }
                                    return;
                                }
                                return;
                            }
                            String str53 = strArr3[i31];
                            int i42 = 0;
                            int i43 = 0;
                            double[] dArr14 = null;
                            double[][] dArr15 = null;
                            while (i42 < i15) {
                                if (c3785yArr[i42].f12745k.containsKey(str53)) {
                                    if (dArr15 == null) {
                                        dArr14 = new double[i15];
                                        dArr15 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i15, ((C4184a) c3785yArr[i42].f12745k.get(str53)).m8237d());
                                    }
                                    C3785y c3785y9 = c3785yArr[i42];
                                    dArr14[i43] = c3785y9.f12737c;
                                    double[] dArr16 = dArr15[i43];
                                    C4184a c4184a = (C4184a) c3785y9.f12745k.get(str53);
                                    if (c4184a.m8237d() == 1) {
                                        dArr16[0] = c4184a.m8235b();
                                    } else {
                                        int iM8237d = c4184a.m8237d();
                                        float[] fArr9 = new float[iM8237d];
                                        c4184a.m8236c(fArr9);
                                        int i44 = 0;
                                        int i45 = 0;
                                        while (i44 < iM8237d) {
                                            dArr16[i45] = fArr9[i44];
                                            i44++;
                                            i45++;
                                            dArr14 = dArr14;
                                            dArr15 = dArr15;
                                        }
                                    }
                                    i10 = 1;
                                    i43++;
                                    dArr14 = dArr14;
                                    dArr15 = dArr15;
                                } else {
                                    i15 = i15;
                                    i10 = 1;
                                }
                                i42 += i10;
                                i15 = i15;
                            }
                            i31++;
                            this.f12655h[i31] = AbstractC3612b.m7269k(this.f12650c, Arrays.copyOf(dArr14, i43), (double[][]) Arrays.copyOf(dArr15, i43));
                            i15 = i15;
                        }
                    }
                }
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(" start: x: ");
        C3785y c3785y = this.f12651d;
        sb.append(c3785y.f12739e);
        sb.append(" y: ");
        sb.append(c3785y.f12740f);
        sb.append(" end: x: ");
        C3785y c3785y2 = this.f12652e;
        sb.append(c3785y2.f12739e);
        sb.append(" y: ");
        sb.append(c3785y2.f12740f);
        return sb.toString();
    }
}
