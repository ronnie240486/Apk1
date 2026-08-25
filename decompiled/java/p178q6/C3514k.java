package p178q6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import java.util.ArrayList;
import java.util.Iterator;

public final class C3514k extends AnimatorListenerAdapter {

    public final int f11840a;

    public final AbstractC3515l f11841b;

    public C3514k(AbstractC3515l abstractC3515l, int i6) {
        this.f11840a = i6;
        this.f11841b = abstractC3515l;
    }

    @Override
    public void onAnimationEnd(Animator animator) {
        switch (this.f11840a) {
            case 1:
                super.onAnimationEnd(animator);
                AbstractC3515l abstractC3515l = this.f11841b;
                super/*android.graphics.drawable.Drawable*/.setVisible(false, false);
                ArrayList arrayList = abstractC3515l.f11848f;
                if (arrayList != null && !abstractC3515l.f11849g) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((C3506c) it.next()).m7147a();
                    }
                    break;
                }
                break;
            default:
                super.onAnimationEnd(animator);
                break;
        }
    }

    @Override
    public void onAnimationStart(Animator animator) {
        switch (this.f11840a) {
            case 0:
                super.onAnimationStart(animator);
                AbstractC3515l abstractC3515l = this.f11841b;
                ArrayList arrayList = abstractC3515l.f11848f;
                if (arrayList != null && !abstractC3515l.f11849g) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((C3506c) it.next()).getClass();
                    }
                    break;
                }
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }
}
