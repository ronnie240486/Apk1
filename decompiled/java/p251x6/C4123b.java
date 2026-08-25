package p251x6;

import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import p015b2.AbstractC1249a;
import p015b2.InterfaceC1257i;

public final class C4123b implements InterfaceC1257i {

    public boolean f14014a;

    public final TabLayout f14015b;

    public C4123b(TabLayout tabLayout) {
        this.f14015b = tabLayout;
    }

    @Override
    public final void mo3135b(ViewPager viewPager, AbstractC1249a abstractC1249a, AbstractC1249a abstractC1249a2) {
        TabLayout tabLayout = this.f14015b;
        if (tabLayout.f6700K == viewPager) {
            tabLayout.m4346m(abstractC1249a2, this.f14014a);
        }
    }
}
