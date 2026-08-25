package androidx.recyclerview.widget;

import android.util.Log;
import android.view.animation.Interpolator;

public final class C1153i1 {

    public int f3585a;

    public int f3586b;

    public int f3587c;

    public int f3588d;

    public Interpolator f3589e;

    public boolean f3590f;

    public int f3591g;

    public final void m2950a(RecyclerView recyclerView) {
        int i6 = this.f3588d;
        if (i6 >= 0) {
            this.f3588d = -1;
            recyclerView.jumpToPositionForSmoothScroller(i6);
            this.f3590f = false;
            return;
        }
        if (!this.f3590f) {
            this.f3591g = 0;
            return;
        }
        Interpolator interpolator = this.f3589e;
        if (interpolator != null && this.f3587c < 1) {
            throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
        }
        int i10 = this.f3587c;
        if (i10 < 1) {
            throw new IllegalStateException("Scroll duration must be a positive number");
        }
        recyclerView.mViewFlinger.m2974c(this.f3585a, this.f3586b, interpolator, i10);
        int i11 = this.f3591g + 1;
        this.f3591g = i11;
        if (i11 > 10) {
            Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
        }
        this.f3590f = false;
    }

    public final void m2951b(int i6, int i10, Interpolator interpolator, int i11) {
        this.f3585a = i6;
        this.f3586b = i10;
        this.f3587c = i11;
        this.f3589e = interpolator;
        this.f3590f = true;
    }
}
