package p251x6;

import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

public final class C4133l implements InterfaceC4125d {

    public final int f14051a;

    public final ViewGroup f14052b;

    public C4133l(ViewGroup viewGroup, int i6) {
        this.f14051a = i6;
        this.f14052b = viewGroup;
    }

    @Override
    public final void mo5905a(C4129h c4129h) {
        int i6 = this.f14051a;
    }

    @Override
    public final void mo5906b(C4129h c4129h) {
        int i6 = this.f14051a;
    }

    @Override
    public final void mo5907c(C4129h c4129h) {
        switch (this.f14051a) {
            case 0:
                ((ViewPager) this.f14052b).setCurrentItem(c4129h.f14030d);
                break;
            default:
                ((ViewPager2) this.f14052b).setCurrentItem(c4129h.f14030d, true);
                break;
        }
    }

    private final void m8152d(C4129h c4129h) {
    }

    private final void m8153e(C4129h c4129h) {
    }

    private final void m8154f(C4129h c4129h) {
    }

    private final void m8155g(C4129h c4129h) {
    }
}
