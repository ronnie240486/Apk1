package p006a6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.transition.Transition;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.textfield.C1875m;
import com.google.android.material.transformation.ExpandableTransformationBehavior;
import java.util.WeakHashMap;
import p002a1.C0026b;
import p124l6.AbstractC2976b;
import p138n0.AbstractC3155s0;
import p178q6.C3520q;

public final class C0062a extends AnimatorListenerAdapter {

    public final int f175a;

    public final Object f176b;

    public C0062a(int i6, Object obj) {
        this.f175a = i6;
        this.f176b = obj;
    }

    @Override
    public void onAnimationCancel(Animator animator) {
        switch (this.f175a) {
            case 2:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.f176b;
                actionBarOverlayLayout.f570w = null;
                actionBarOverlayLayout.f558k = false;
                break;
            case 5:
                ((AbstractC2976b) this.f176b).mo6029d();
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override
    public void onAnimationEnd(Animator animator) {
        Object obj = this.f176b;
        switch (this.f175a) {
            case 0:
                ((HideBottomViewOnScrollBehavior) obj).f5903d = null;
                break;
            case 1:
                ((ExpandableTransformationBehavior) obj).f6952b = null;
                break;
            case 2:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) obj;
                actionBarOverlayLayout.f570w = null;
                actionBarOverlayLayout.f558k = false;
                break;
            case 3:
                C0026b c0026b = (C0026b) obj;
                if (((ValueAnimator) c0026b.f55c) == animator) {
                    c0026b.f55c = null;
                }
                break;
            case 4:
                C1875m c1875m = (C1875m) obj;
                c1875m.f6869c.setChecked(c1875m.f6860m);
                c1875m.f6866s.start();
                break;
            case 5:
                ((AbstractC2976b) obj).mo6030e();
                break;
            case 6:
            default:
                super.onAnimationEnd(animator);
                break;
            case 7:
                WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                ((View) obj).setClipBounds(null);
                break;
            case 8:
                ((Transition) obj).m3059l();
                animator.removeListener(this);
                break;
        }
    }

    @Override
    public void onAnimationRepeat(Animator animator) {
        switch (this.f175a) {
            case 6:
                super.onAnimationRepeat(animator);
                C3520q c3520q = (C3520q) this.f176b;
                c3520q.f11867g = (c3520q.f11867g + 1) % c3520q.f11866f.f11811c.length;
                c3520q.f11868h = true;
                break;
            default:
                super.onAnimationRepeat(animator);
                break;
        }
    }

    @Override
    public void onAnimationStart(Animator animator) {
        switch (this.f175a) {
            case 5:
                ((AbstractC2976b) this.f176b).mo6031f(animator);
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }
}
