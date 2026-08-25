package p205t;

import android.util.Log;
import androidx.constraintlayout.widget.C0307c;
import androidx.constraintlayout.widget.C0308d;
import java.util.HashMap;
import java.util.LinkedHashMap;
import p194s.C3681e;
import p225v.C3958e;
import p256y.C4184a;
import p256y.C4188e;
import p256y.C4189f;
import p256y.C4190g;

public final class C3772n implements Comparable {

    public int f12632c;

    public float f12630a = 1.0f;

    public int f12631b = 0;

    public float f12633d = 0.0f;

    public float f12634e = 0.0f;

    public float f12635f = 0.0f;

    public float f12636g = 0.0f;

    public float f12637h = 1.0f;

    public float f12638i = 1.0f;

    public float f12639j = Float.NaN;

    public float f12640k = Float.NaN;

    public float f12641l = 0.0f;

    public float f12642m = 0.0f;

    public float f12643n = 0.0f;

    public float f12644o = Float.NaN;

    public float f12645p = Float.NaN;

    public final LinkedHashMap f12646q = new LinkedHashMap();

    public static boolean m7514b(float f, float f3) {
        if (Float.isNaN(f) || Float.isNaN(f3)) {
            return Float.isNaN(f) != Float.isNaN(f3);
        }
        return Math.abs(f - f3) > 1.0E-6f;
    }

    public final void m7515a(HashMap map, int i6) {
        for (String str : map.keySet()) {
            AbstractC3761h0 abstractC3761h0 = (AbstractC3761h0) map.get(str);
            str.getClass();
            switch (str) {
                case "rotationX":
                    abstractC3761h0.mo7505b(i6, Float.isNaN(this.f12635f) ? 0.0f : this.f12635f);
                    break;
                case "rotationY":
                    abstractC3761h0.mo7505b(i6, Float.isNaN(this.f12636g) ? 0.0f : this.f12636g);
                    break;
                case "translationX":
                    abstractC3761h0.mo7505b(i6, Float.isNaN(this.f12641l) ? 0.0f : this.f12641l);
                    break;
                case "translationY":
                    abstractC3761h0.mo7505b(i6, Float.isNaN(this.f12642m) ? 0.0f : this.f12642m);
                    break;
                case "translationZ":
                    abstractC3761h0.mo7505b(i6, Float.isNaN(this.f12643n) ? 0.0f : this.f12643n);
                    break;
                case "progress":
                    abstractC3761h0.mo7505b(i6, Float.isNaN(this.f12645p) ? 0.0f : this.f12645p);
                    break;
                case "scaleX":
                    abstractC3761h0.mo7505b(i6, Float.isNaN(this.f12637h) ? 1.0f : this.f12637h);
                    break;
                case "scaleY":
                    abstractC3761h0.mo7505b(i6, Float.isNaN(this.f12638i) ? 1.0f : this.f12638i);
                    break;
                case "transformPivotX":
                    abstractC3761h0.mo7505b(i6, Float.isNaN(this.f12639j) ? 0.0f : this.f12639j);
                    break;
                case "transformPivotY":
                    abstractC3761h0.mo7505b(i6, Float.isNaN(this.f12640k) ? 0.0f : this.f12640k);
                    break;
                case "rotation":
                    abstractC3761h0.mo7505b(i6, Float.isNaN(this.f12634e) ? 0.0f : this.f12634e);
                    break;
                case "elevation":
                    abstractC3761h0.mo7505b(i6, Float.isNaN(this.f12633d) ? 0.0f : this.f12633d);
                    break;
                case "transitionPathRotate":
                    abstractC3761h0.mo7505b(i6, Float.isNaN(this.f12644o) ? 0.0f : this.f12644o);
                    break;
                case "alpha":
                    abstractC3761h0.mo7505b(i6, Float.isNaN(this.f12630a) ? 1.0f : this.f12630a);
                    break;
                default:
                    if (!str.startsWith("CUSTOM")) {
                        Log.e("MotionPaths", "UNKNOWN spline ".concat(str));
                        break;
                    } else {
                        String str2 = str.split(",")[1];
                        LinkedHashMap linkedHashMap = this.f12646q;
                        if (linkedHashMap.containsKey(str2)) {
                            C4184a c4184a = (C4184a) linkedHashMap.get(str2);
                            if (abstractC3761h0 instanceof C3755e0) {
                                ((C3755e0) abstractC3761h0).f12596f.append(i6, c4184a);
                            } else {
                                Log.e("MotionPaths", str + " splineSet not a CustomSet frame = " + i6 + ", value" + c4184a.m8235b() + abstractC3761h0);
                            }
                        } else {
                            Log.e("MotionPaths", "UNKNOWN customName " + str2);
                        }
                        break;
                    }
                    break;
            }
        }
    }

    public final void m7516c(C3958e c3958e, C0308d c0308d, int i6) {
        c3958e.m7906n();
        c3958e.m7907o();
        C0307c c0307cM897g = c0308d.m897g(i6);
        C4189f c4189f = c0307cM897g.f1407b;
        int i10 = c4189f.f14218c;
        this.f12631b = i10;
        int i11 = c4189f.f14217b;
        this.f12632c = i11;
        this.f12630a = (i11 == 0 || i10 != 0) ? c4189f.f14219d : 0.0f;
        C4190g c4190g = c0307cM897g.f1410e;
        boolean z7 = c4190g.f14233l;
        this.f12633d = c4190g.f14234m;
        this.f12634e = c4190g.f14223b;
        this.f12635f = c4190g.f14224c;
        this.f12636g = c4190g.f14225d;
        this.f12637h = c4190g.f14226e;
        this.f12638i = c4190g.f14227f;
        this.f12639j = c4190g.f14228g;
        this.f12640k = c4190g.f14229h;
        this.f12641l = c4190g.f14230i;
        this.f12642m = c4190g.f14231j;
        this.f12643n = c4190g.f14232k;
        C4188e c4188e = c0307cM897g.f1408c;
        C3681e.m7432c(c4188e.f14211c);
        this.f12644o = c4188e.f14215g;
        this.f12645p = c0307cM897g.f1407b.f14220e;
        for (String str : c0307cM897g.f1411f.keySet()) {
            C4184a c4184a = (C4184a) c0307cM897g.f1411f.get(str);
            if (c4184a.f14129b != 5) {
                this.f12646q.put(str, c4184a);
            }
        }
    }

    @Override
    public final int compareTo(Object obj) {
        ((C3772n) obj).getClass();
        return Float.compare(0.0f, 0.0f);
    }
}
