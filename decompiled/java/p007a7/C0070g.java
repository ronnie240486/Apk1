package p007a7;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.recyclerview.widget.C1172p;
import java.util.WeakHashMap;
import p138n0.AbstractC3155s0;
import p258y1.AbstractC4210g0;

public final class C0070g extends AnimatorListenerAdapter {

    public final int f198a;

    public final Object f199b;

    public boolean f200c;

    public C0070g(View view, boolean z7) {
        this.f198a = 0;
        this.f200c = z7;
        this.f199b = view;
    }

    @Override
    public void onAnimationCancel(Animator animator) {
        switch (this.f198a) {
            case 2:
                this.f200c = true;
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override
    public final void onAnimationEnd(Animator animator) {
        switch (this.f198a) {
            case 0:
                if (!this.f200c) {
                    ((View) this.f199b).setVisibility(4);
                }
                break;
            case 1:
                View view = (View) this.f199b;
                AbstractC4210g0.m8257b(view, 1.0f);
                if (this.f200c) {
                    view.setLayerType(0, null);
                }
                break;
            default:
                if (!this.f200c) {
                    C1172p c1172p = (C1172p) this.f199b;
                    if (((Float) c1172p.f3671z.getAnimatedValue()).floatValue() != 0.0f) {
                        c1172p.f3644A = 2;
                        c1172p.f3664s.invalidate();
                    } else {
                        c1172p.f3644A = 0;
                        c1172p.m2978d(0);
                    }
                } else {
                    this.f200c = false;
                }
                break;
        }
    }

    @Override
    public void onAnimationStart(Animator animator) {
        Object obj = this.f199b;
        switch (this.f198a) {
            case 0:
                if (this.f200c) {
                    ((View) obj).setVisibility(0);
                }
                break;
            case 1:
                WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                View view = (View) obj;
                if (view.hasOverlappingRendering() && view.getLayerType() == 0) {
                    this.f200c = true;
                    view.setLayerType(2, null);
                    break;
                }
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }

    public C0070g(View view) {
        this.f198a = 1;
        this.f200c = false;
        this.f199b = view;
    }

    public C0070g(C1172p c1172p) {
        this.f198a = 2;
        this.f199b = c1172p;
        this.f200c = false;
    }
}
