package p006a6;

import android.view.View;
import android.view.ViewParent;
import com.google.android.material.behavior.SwipeDismissBehavior;
import java.util.WeakHashMap;
import p004a3.RunnableC0038c;
import p138n0.AbstractC3155s0;
import p187r4.AbstractC3612b;

public final class C0063b extends AbstractC3612b {

    public int f177c;

    public int f178d = -1;

    public final SwipeDismissBehavior f179e;

    public C0063b(SwipeDismissBehavior swipeDismissBehavior) {
        this.f179e = swipeDismissBehavior;
    }

    @Override
    public final void mo208F(int i6, View view) {
        this.f178d = i6;
        this.f177c = view.getLeft();
        ViewParent parent = view.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    @Override
    public final void mo209G(int i6) {
        this.f179e.getClass();
    }

    @Override
    public final void mo210H(View view, int i6, int i10) {
        float f = this.f177c;
        float width = view.getWidth();
        SwipeDismissBehavior swipeDismissBehavior = this.f179e;
        float f3 = (width * swipeDismissBehavior.f5907d) + f;
        float width2 = (view.getWidth() * swipeDismissBehavior.f5908e) + this.f177c;
        float f4 = i6;
        if (f4 <= f3) {
            view.setAlpha(1.0f);
        } else if (f4 >= width2) {
            view.setAlpha(0.0f);
        } else {
            view.setAlpha(Math.min(Math.max(0.0f, 1.0f - ((f4 - f3) / (width2 - f3))), 1.0f));
        }
    }

    @Override
    public final void mo211I(View view, float f, float f3) {
        int left;
        int i6;
        int i10;
        this.f178d = -1;
        int width = view.getWidth();
        boolean z7 = true;
        SwipeDismissBehavior swipeDismissBehavior = this.f179e;
        if (f != 0.0f) {
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            boolean z10 = view.getLayoutDirection() == 1;
            int i11 = swipeDismissBehavior.f5906c;
            if (i11 != 2 && (i11 != 0 ? i11 != 1 || (!z10 ? f < 0.0f : f > 0.0f) : !z10 ? f > 0.0f : f < 0.0f)) {
                i10 = this.f177c;
                z7 = false;
            } else {
                left = view.getLeft();
                i6 = this.f177c;
                if (left < i6) {
                    i10 = i6 - width;
                } else {
                    i10 = i6 + width;
                }
            }
        } else {
            int left2 = view.getLeft() - this.f177c;
            float width2 = view.getWidth();
            swipeDismissBehavior.getClass();
            if (Math.abs(left2) >= Math.round(width2 * 0.5f)) {
                left = view.getLeft();
                i6 = this.f177c;
                if (left < i6) {
                    i10 = i6 - width;
                } else {
                    i10 = i6 + width;
                }
            } else {
                i10 = this.f177c;
                z7 = false;
            }
        }
        if (swipeDismissBehavior.f5904a.m7962q(i10, view.getTop())) {
            RunnableC0038c runnableC0038c = new RunnableC0038c(swipeDismissBehavior, view, z7);
            WeakHashMap weakHashMap2 = AbstractC3155s0.f10642a;
            view.postOnAnimation(runnableC0038c);
        }
    }

    @Override
    public final boolean mo212O(int i6, View view) {
        int i10 = this.f178d;
        return (i10 == -1 || i10 == i6) && this.f179e.mo4102s(view);
    }

    @Override
    public final int mo213d(int i6, View view) {
        int width;
        int width2;
        int width3;
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        boolean z7 = view.getLayoutDirection() == 1;
        int i10 = this.f179e.f5906c;
        if (i10 == 0) {
            if (z7) {
                width = this.f177c - view.getWidth();
                width2 = this.f177c;
            } else {
                width = this.f177c;
                width3 = view.getWidth();
                width2 = width3 + width;
            }
        } else if (i10 != 1) {
            width = this.f177c - view.getWidth();
            width2 = view.getWidth() + this.f177c;
        } else if (z7) {
            width = this.f177c;
            width3 = view.getWidth();
            width2 = width3 + width;
        } else {
            width = this.f177c - view.getWidth();
            width2 = this.f177c;
        }
        return Math.min(Math.max(width, i6), width2);
    }

    @Override
    public final int mo214e(int i6, View view) {
        return view.getTop();
    }

    @Override
    public final int mo215x(View view) {
        return view.getWidth();
    }
}
