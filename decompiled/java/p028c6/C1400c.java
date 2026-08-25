package p028c6;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.gms.common.Feature;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import p000a.RunnableC0005f;
import p058f2.C2491a;
import p130m2.AbstractC3062j;
import p130m2.C3057e;
import p130m2.C3069q;
import p138n0.AbstractC3155s0;
import p150o2.C3246a;
import p174q2.InterfaceC3466e;
import p271z4.InterfaceC4340k;

public final class C1400c implements InterfaceC3466e {

    public int f4263a;

    public boolean f4264b;

    public Object f4265c = new RunnableC0005f(7, this);

    public Object f4266d;

    public C1400c(BottomSheetBehavior bottomSheetBehavior) {
        this.f4266d = bottomSheetBehavior;
    }

    public static C1400c m3273c() {
        C1400c c1400c = new C1400c();
        c1400c.f4264b = true;
        c1400c.f4263a = 0;
        return c1400c;
    }

    @Override
    public void mo3274a() {
        C3246a c3246a = (C3246a) this.f4265c;
        Drawable drawable = c3246a.f10870b.getDrawable();
        AbstractC3062j abstractC3062j = (AbstractC3062j) this.f4266d;
        boolean z7 = abstractC3062j instanceof C3069q;
        C2491a c2491a = new C2491a(drawable, abstractC3062j.mo6107a(), abstractC3062j.mo6108b().f10490w, this.f4263a, (z7 && ((C3069q) abstractC3062j).f10520g) ? false : true, this.f4264b);
        if (z7) {
            c3246a.m6555g(c2491a);
        } else if (abstractC3062j instanceof C3057e) {
            c3246a.m6555g(c2491a);
        }
    }

    public C1400c m3275b() {
        if (!(((InterfaceC4340k) this.f4265c) != null)) {
            throw new IllegalArgumentException("execute parameter required");
        }
        Feature[] featureArr = (Feature[]) this.f4266d;
        boolean z7 = this.f4264b;
        int i6 = this.f4263a;
        C1400c c1400c = new C1400c();
        c1400c.f4266d = this;
        c1400c.f4265c = featureArr;
        boolean z10 = false;
        if (featureArr != null && z7) {
            z10 = true;
        }
        c1400c.f4264b = z10;
        c1400c.f4263a = i6;
        return c1400c;
    }

    public void m3276d(int i6) {
        BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.f4266d;
        WeakReference weakReference = bottomSheetBehavior.f5975R;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f4263a = i6;
        if (this.f4264b) {
            return;
        }
        View view = (View) bottomSheetBehavior.f5975R.get();
        RunnableC0005f runnableC0005f = (RunnableC0005f) this.f4265c;
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        view.postOnAnimation(runnableC0005f);
        this.f4264b = true;
    }
}
