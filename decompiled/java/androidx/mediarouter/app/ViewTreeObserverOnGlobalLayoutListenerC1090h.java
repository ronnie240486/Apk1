package androidx.mediarouter.app;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import java.util.HashSet;
import p173q1.C3445s0;

public final class ViewTreeObserverOnGlobalLayoutListenerC1090h implements ViewTreeObserver.OnGlobalLayoutListener {

    public final DialogC1116u f3245a;

    public ViewTreeObserverOnGlobalLayoutListenerC1090h(DialogC1116u dialogC1116u) {
        this.f3245a = dialogC1116u;
    }

    @Override
    public final void onGlobalLayout() {
        DialogC1116u dialogC1116u = this.f3245a;
        dialogC1116u.f3369D.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        HashSet hashSet = dialogC1116u.f3372G;
        if (hashSet == null || hashSet.size() == 0) {
            dialogC1116u.m2794m(true);
            return;
        }
        AnimationAnimationListenerC1104o animationAnimationListenerC1104o = new AnimationAnimationListenerC1104o(1, dialogC1116u);
        int firstVisiblePosition = dialogC1116u.f3369D.getFirstVisiblePosition();
        boolean z7 = false;
        for (int i6 = 0; i6 < dialogC1116u.f3369D.getChildCount(); i6++) {
            View childAt = dialogC1116u.f3369D.getChildAt(i6);
            if (dialogC1116u.f3372G.contains((C3445s0) dialogC1116u.f3370E.getItem(firstVisiblePosition + i6))) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(dialogC1116u.f3403i0);
                alphaAnimation.setFillEnabled(true);
                alphaAnimation.setFillAfter(true);
                if (!z7) {
                    alphaAnimation.setAnimationListener(animationAnimationListenerC1104o);
                    z7 = true;
                }
                childAt.clearAnimation();
                childAt.startAnimation(alphaAnimation);
            }
        }
    }
}
