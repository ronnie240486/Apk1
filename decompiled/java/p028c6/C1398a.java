package p028c6;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.lang.ref.WeakReference;
import p123l5.AbstractC2973a;
import p187r4.AbstractC3612b;

public final class C1398a extends AbstractC3612b {

    public final BottomSheetBehavior f4260c;

    public C1398a(BottomSheetBehavior bottomSheetBehavior) {
        this.f4260c = bottomSheetBehavior;
    }

    @Override
    public final void mo209G(int i6) {
        if (i6 == 1) {
            BottomSheetBehavior bottomSheetBehavior = this.f4260c;
            if (bottomSheetBehavior.f5966I) {
                bottomSheetBehavior.m4125B(1);
            }
        }
    }

    @Override
    public final void mo210H(View view, int i6, int i10) {
        this.f4260c.m4134u(i10);
    }

    @Override
    public final void mo211I(View view, float f, float f3) {
        int i6 = 6;
        BottomSheetBehavior bottomSheetBehavior = this.f4260c;
        if (f3 < 0.0f) {
            if (bottomSheetBehavior.f5986b) {
                i6 = 3;
            } else {
                int top = view.getTop();
                System.currentTimeMillis();
                bottomSheetBehavior.getClass();
                if (top <= bottomSheetBehavior.f5960C) {
                    i6 = 3;
                }
            }
        } else if (bottomSheetBehavior.f5964G && bottomSheetBehavior.m4126C(view, f3)) {
            if (Math.abs(f) >= Math.abs(f3) || f3 <= 500.0f) {
                if (view.getTop() > (bottomSheetBehavior.m4135x() + bottomSheetBehavior.f5974Q) / 2) {
                    i6 = 5;
                } else if (bottomSheetBehavior.f5986b || Math.abs(view.getTop() - bottomSheetBehavior.m4135x()) < Math.abs(view.getTop() - bottomSheetBehavior.f5960C)) {
                    i6 = 3;
                }
            } else {
                i6 = 5;
            }
        } else if (f3 == 0.0f || Math.abs(f) > Math.abs(f3)) {
            int top2 = view.getTop();
            if (!bottomSheetBehavior.f5986b) {
                int i10 = bottomSheetBehavior.f5960C;
                if (top2 < i10) {
                    if (top2 < Math.abs(top2 - bottomSheetBehavior.f5962E)) {
                        i6 = 3;
                    } else {
                        bottomSheetBehavior.getClass();
                    }
                } else if (Math.abs(top2 - i10) < Math.abs(top2 - bottomSheetBehavior.f5962E)) {
                    bottomSheetBehavior.getClass();
                } else {
                    i6 = 4;
                }
            } else if (Math.abs(top2 - bottomSheetBehavior.f5959B) < Math.abs(top2 - bottomSheetBehavior.f5962E)) {
                i6 = 3;
            } else {
                i6 = 4;
            }
        } else if (bottomSheetBehavior.f5986b) {
            i6 = 4;
        } else {
            int top3 = view.getTop();
            if (Math.abs(top3 - bottomSheetBehavior.f5960C) < Math.abs(top3 - bottomSheetBehavior.f5962E)) {
                bottomSheetBehavior.getClass();
            } else {
                i6 = 4;
            }
        }
        bottomSheetBehavior.getClass();
        bottomSheetBehavior.m4127D(view, i6, true);
    }

    @Override
    public final boolean mo212O(int i6, View view) {
        BottomSheetBehavior bottomSheetBehavior = this.f4260c;
        int i10 = bottomSheetBehavior.f5967J;
        if (i10 == 1 || bottomSheetBehavior.f5981X) {
            return false;
        }
        if (i10 == 3 && bottomSheetBehavior.f5979V == i6) {
            WeakReference weakReference = bottomSheetBehavior.f5976S;
            View view2 = weakReference != null ? (View) weakReference.get() : null;
            if (view2 != null && view2.canScrollVertically(-1)) {
                return false;
            }
        }
        System.currentTimeMillis();
        WeakReference weakReference2 = bottomSheetBehavior.f5975R;
        return weakReference2 != null && weakReference2.get() == view;
    }

    @Override
    public final int mo213d(int i6, View view) {
        return view.getLeft();
    }

    @Override
    public final int mo214e(int i6, View view) {
        BottomSheetBehavior bottomSheetBehavior = this.f4260c;
        return AbstractC2973a.m6016g(i6, bottomSheetBehavior.m4135x(), bottomSheetBehavior.f5964G ? bottomSheetBehavior.f5974Q : bottomSheetBehavior.f5962E);
    }

    @Override
    public final int mo3268y() {
        BottomSheetBehavior bottomSheetBehavior = this.f4260c;
        return bottomSheetBehavior.f5964G ? bottomSheetBehavior.f5974Q : bottomSheetBehavior.f5962E;
    }
}
