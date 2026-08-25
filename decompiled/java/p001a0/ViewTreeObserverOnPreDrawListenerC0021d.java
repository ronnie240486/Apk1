package p001a0;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.WeakHashMap;
import p124l6.AbstractC2991q;
import p138n0.AbstractC3155s0;
import p258y1.C4225o;

public final class ViewTreeObserverOnPreDrawListenerC0021d implements ViewTreeObserver.OnPreDrawListener {

    public final int f40a;

    public final Object f41b;

    public ViewTreeObserverOnPreDrawListenerC0021d(int i6, Object obj) {
        this.f40a = i6;
        this.f41b = obj;
    }

    @Override
    public final boolean onPreDraw() {
        View view;
        Object obj = this.f41b;
        switch (this.f40a) {
            case 0:
                ((CoordinatorLayout) obj).m913u(0);
                break;
            case 1:
                AbstractC2991q abstractC2991q = (AbstractC2991q) obj;
                float rotation = abstractC2991q.f10284v.getRotation();
                if (abstractC2991q.f10277o != rotation) {
                    abstractC2991q.f10277o = rotation;
                    abstractC2991q.mo6071q();
                }
                break;
            default:
                WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                C4225o c4225o = (C4225o) obj;
                c4225o.postInvalidateOnAnimation();
                ViewGroup viewGroup = c4225o.f14360a;
                if (viewGroup != null && (view = c4225o.f14361b) != null) {
                    viewGroup.endViewTransition(view);
                    c4225o.f14360a.postInvalidateOnAnimation();
                    c4225o.f14360a = null;
                    c4225o.f14361b = null;
                }
                break;
        }
        return true;
    }
}
