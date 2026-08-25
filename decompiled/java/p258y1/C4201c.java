package p258y1;

import android.view.ViewGroup;
import androidx.transition.Transition;

public final class C4201c extends AbstractC4237z {

    public boolean f14277a = false;

    public final ViewGroup f14278b;

    public C4201c(ViewGroup viewGroup) {
        this.f14278b = viewGroup;
    }

    @Override
    public final void mo8251b() {
        AbstractC4233v.m8276j(this.f14278b, false);
    }

    @Override
    public final void mo8252c() {
        AbstractC4233v.m8276j(this.f14278b, true);
    }

    @Override
    public final void mo8253d() {
        AbstractC4233v.m8276j(this.f14278b, false);
        this.f14277a = true;
    }

    @Override
    public final void mo8254e(Transition transition) {
        if (!this.f14277a) {
            AbstractC4233v.m8276j(this.f14278b, false);
        }
        transition.m3065u(this);
    }
}
