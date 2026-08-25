package p258y1;

import android.view.View;
import androidx.transition.Transition;
import androidx.transition.TransitionSet;

public final class C4219l extends AbstractC4237z {

    public final int f14338a;

    public Object f14339b;

    public C4219l() {
        this.f14338a = 2;
    }

    @Override
    public void mo8255a() {
        switch (this.f14338a) {
            case 2:
                TransitionSet transitionSet = (TransitionSet) this.f14339b;
                if (!transitionSet.f3811A) {
                    transitionSet.m3050D();
                    transitionSet.f3811A = true;
                }
                break;
        }
    }

    @Override
    public final void mo8254e(Transition transition) {
        switch (this.f14338a) {
            case 0:
                AbstractC4210g0.m8257b((View) this.f14339b, 1.0f);
                AbstractC4210g0.f14313a.getClass();
                transition.m3065u(this);
                break;
            case 1:
                ((Transition) this.f14339b).mo3067w();
                transition.m3065u(this);
                break;
            default:
                TransitionSet transitionSet = (TransitionSet) this.f14339b;
                int i6 = transitionSet.f3815z - 1;
                transitionSet.f3815z = i6;
                if (i6 == 0) {
                    transitionSet.f3811A = false;
                    transitionSet.m3059l();
                }
                transition.m3065u(this);
                break;
        }
    }

    public C4219l(int i6, Object obj) {
        this.f14338a = i6;
        this.f14339b = obj;
    }
}
