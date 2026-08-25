package p205t;

import android.util.Log;
import android.util.SparseArray;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.C0308d;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import p138n0.C3112e;
import p256y.C4185b;
import p256y.C4186c;

public final class C3782v {

    public float f12724a = Float.NaN;

    public float f12725b = Float.NaN;

    public int f12726c = -1;

    public int f12727d = -1;

    public final MotionLayout f12728e;

    public C3782v(MotionLayout motionLayout) {
        this.f12728e = motionLayout;
    }

    public final void m7535a() {
        int i6 = this.f12726c;
        MotionLayout motionLayout = this.f12728e;
        if (i6 != -1 || this.f12727d != -1) {
            EnumC3784x enumC3784x = EnumC3784x.f12730b;
            if (i6 == -1) {
                motionLayout.m851B(this.f12727d);
            } else {
                int i10 = this.f12727d;
                if (i10 == -1) {
                    motionLayout.setState(enumC3784x);
                    motionLayout.f1239u = i6;
                    motionLayout.f1237t = -1;
                    motionLayout.f1241v = -1;
                    C3112e c3112e = motionLayout.f1310k;
                    if (c3112e != null) {
                        float f = -1;
                        int i11 = c3112e.f10587c;
                        SparseArray sparseArray = (SparseArray) c3112e.f10589e;
                        int i12 = 0;
                        ConstraintLayout constraintLayout = (ConstraintLayout) c3112e.f10586b;
                        if (i11 == i6) {
                            C4185b c4185b = i6 == -1 ? (C4185b) sparseArray.valueAt(0) : (C4185b) sparseArray.get(i11);
                            int i13 = c3112e.f10588d;
                            if (i13 == -1 || !((C4186c) c4185b.f14136b.get(i13)).m8240a(f, f)) {
                                while (true) {
                                    ArrayList arrayList = c4185b.f14136b;
                                    if (i12 >= arrayList.size()) {
                                        i12 = -1;
                                        break;
                                    } else if (((C4186c) arrayList.get(i12)).m8240a(f, f)) {
                                        break;
                                    } else {
                                        i12++;
                                    }
                                }
                                if (c3112e.f10588d != i12) {
                                    ArrayList arrayList2 = c4185b.f14136b;
                                    C0308d c0308d = i12 == -1 ? null : ((C4186c) arrayList2.get(i12)).f14144f;
                                    if (i12 != -1) {
                                        int i14 = ((C4186c) arrayList2.get(i12)).f14143e;
                                    }
                                    if (c0308d != null) {
                                        c3112e.f10588d = i12;
                                        c0308d.m894b(constraintLayout);
                                    }
                                }
                            }
                        } else {
                            c3112e.f10587c = i6;
                            C4185b c4185b2 = (C4185b) sparseArray.get(i6);
                            while (true) {
                                ArrayList arrayList3 = c4185b2.f14136b;
                                if (i12 >= arrayList3.size()) {
                                    i12 = -1;
                                    break;
                                } else if (((C4186c) arrayList3.get(i12)).m8240a(f, f)) {
                                    break;
                                } else {
                                    i12++;
                                }
                            }
                            ArrayList arrayList4 = c4185b2.f14136b;
                            C0308d c0308d2 = i12 == -1 ? c4185b2.f14138d : ((C4186c) arrayList4.get(i12)).f14144f;
                            if (i12 != -1) {
                                int i15 = ((C4186c) arrayList4.get(i12)).f14143e;
                            }
                            if (c0308d2 == null) {
                                Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + i6 + ", dim =-1.0, -1.0");
                            } else {
                                c3112e.f10588d = i12;
                                c0308d2.m894b(constraintLayout);
                            }
                        }
                    } else {
                        C3751c0 c3751c0 = motionLayout.f1231q;
                        if (c3751c0 != null) {
                            c3751c0.m7492b(i6).m894b(motionLayout);
                        }
                    }
                } else {
                    motionLayout.m864z(i6, i10);
                }
            }
            motionLayout.setState(enumC3784x);
        }
        if (Float.isNaN(this.f12725b)) {
            if (Float.isNaN(this.f12724a)) {
                return;
            }
            motionLayout.setProgress(this.f12724a);
        } else {
            motionLayout.m863y(this.f12724a, this.f12725b);
            this.f12724a = Float.NaN;
            this.f12725b = Float.NaN;
            this.f12726c = -1;
            this.f12727d = -1;
        }
    }
}
