package p007a7;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.Drawable;
import androidx.transition.Transition;
import com.google.android.gms.cast.framework.internal.featurehighlight.C1497e;
import com.google.android.gms.internal.cast.RunnableC1631n;
import p059f6.InterfaceC2496e;
import p138n0.InterfaceC3105b1;
import p160p.C3341e;

public final class C0067d extends AnimatorListenerAdapter {

    public final int f190a;

    public final Object f191b;

    public final Object f192c;

    public C0067d(int i6, Object obj, Object obj2, boolean z7) {
        this.f190a = i6;
        this.f191b = obj2;
        this.f192c = obj;
    }

    @Override
    public void onAnimationCancel(Animator animator) {
        switch (this.f190a) {
            case 3:
                ((InterfaceC3105b1) this.f191b).mo633b();
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override
    public final void onAnimationEnd(Animator animator) {
        switch (this.f190a) {
            case 0:
                ((InterfaceC2496e) this.f191b).setCircularRevealOverlayDrawable(null);
                break;
            case 1:
                C1497e c1497e = (C1497e) this.f192c;
                c1497e.setVisibility(8);
                c1497e.f4818g = null;
                ((RunnableC1631n) this.f191b).run();
                break;
            case 2:
                C1497e c1497e2 = (C1497e) this.f192c;
                c1497e2.setVisibility(8);
                c1497e2.f4818g = null;
                ((RunnableC1631n) this.f191b).run();
                break;
            case 3:
                ((InterfaceC3105b1) this.f191b).mo463a();
                break;
            default:
                ((C3341e) this.f191b).remove(animator);
                ((Transition) this.f192c).f3803m.remove(animator);
                break;
        }
    }

    @Override
    public void onAnimationStart(Animator animator) {
        switch (this.f190a) {
            case 0:
                ((InterfaceC2496e) this.f191b).setCircularRevealOverlayDrawable((Drawable) this.f192c);
                break;
            case 1:
            case 2:
            default:
                super.onAnimationStart(animator);
                break;
            case 3:
                ((InterfaceC3105b1) this.f191b).mo464c();
                break;
            case 4:
                ((Transition) this.f192c).f3803m.add(animator);
                break;
        }
    }

    public C0067d(Object obj, int i6, Object obj2) {
        this.f190a = i6;
        this.f191b = obj;
        this.f192c = obj2;
    }
}
