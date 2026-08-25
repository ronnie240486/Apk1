package androidx.mediarouter.app;

import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import p007a7.C0069f;
import p173q1.C3445s0;

public final class ViewTreeObserverOnGlobalLayoutListenerC1102n implements ViewTreeObserver.OnGlobalLayoutListener {

    public final HashMap f3275a;

    public final HashMap f3276b;

    public final DialogC1116u f3277c;

    public ViewTreeObserverOnGlobalLayoutListenerC1102n(DialogC1116u dialogC1116u, HashMap map, HashMap map2) {
        this.f3277c = dialogC1116u;
        this.f3275a = map;
        this.f3276b = map2;
    }

    @Override
    public final void onGlobalLayout() {
        HashMap map;
        HashMap map2;
        C1111r0 c1111r0;
        DialogC1116u dialogC1116u = this.f3277c;
        dialogC1116u.f3369D.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        HashSet hashSet = dialogC1116u.f3372G;
        if (hashSet == null || dialogC1116u.f3373H == null) {
            return;
        }
        int size = hashSet.size() - dialogC1116u.f3373H.size();
        AnimationAnimationListenerC1104o animationAnimationListenerC1104o = new AnimationAnimationListenerC1104o(0, dialogC1116u);
        int firstVisiblePosition = dialogC1116u.f3369D.getFirstVisiblePosition();
        int i6 = 0;
        boolean z7 = false;
        while (true) {
            int childCount = dialogC1116u.f3369D.getChildCount();
            map = this.f3275a;
            map2 = this.f3276b;
            if (i6 >= childCount) {
                break;
            }
            View childAt = dialogC1116u.f3369D.getChildAt(i6);
            C3445s0 c3445s0 = (C3445s0) dialogC1116u.f3370E.getItem(firstVisiblePosition + i6);
            Rect rect = (Rect) map.get(c3445s0);
            int top = childAt.getTop();
            int i10 = rect != null ? rect.top : (dialogC1116u.f3379N * size) + top;
            AnimationSet animationSet = new AnimationSet(true);
            HashSet hashSet2 = dialogC1116u.f3372G;
            if (hashSet2 != null && hashSet2.contains(c3445s0)) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.0f);
                alphaAnimation.setDuration(dialogC1116u.f3403i0);
                animationSet.addAnimation(alphaAnimation);
                i10 = top;
            }
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, i10 - top, 0.0f);
            translateAnimation.setDuration(dialogC1116u.f3401h0);
            animationSet.addAnimation(translateAnimation);
            animationSet.setFillAfter(true);
            animationSet.setFillEnabled(true);
            animationSet.setInterpolator(dialogC1116u.f3407k0);
            if (!z7) {
                animationSet.setAnimationListener(animationAnimationListenerC1104o);
                z7 = true;
            }
            childAt.clearAnimation();
            childAt.startAnimation(animationSet);
            map.remove(c3445s0);
            map2.remove(c3445s0);
            i6++;
        }
        for (Map.Entry entry : map2.entrySet()) {
            C3445s0 c3445s1 = (C3445s0) entry.getKey();
            BitmapDrawable bitmapDrawable = (BitmapDrawable) entry.getValue();
            Rect rect2 = (Rect) map.get(c3445s1);
            if (dialogC1116u.f3373H.contains(c3445s1)) {
                c1111r0 = new C1111r0(bitmapDrawable, rect2);
                c1111r0.f3356h = 0.0f;
                c1111r0.f3353e = dialogC1116u.f3405j0;
                c1111r0.f3352d = dialogC1116u.f3407k0;
            } else {
                int i11 = dialogC1116u.f3379N * size;
                C1111r0 c1111r1 = new C1111r0(bitmapDrawable, rect2);
                c1111r1.f3355g = i11;
                c1111r1.f3353e = dialogC1116u.f3401h0;
                c1111r1.f3352d = dialogC1116u.f3407k0;
                c1111r1.f3360l = new C0069f(dialogC1116u, 4, c3445s1);
                dialogC1116u.f3374I.add(c3445s1);
                c1111r0 = c1111r1;
            }
            dialogC1116u.f3369D.f3174a.add(c1111r0);
        }
    }
}
