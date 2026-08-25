package p251x6;

import com.google.android.material.tabs.TabLayout;
import java.lang.ref.WeakReference;
import p015b2.InterfaceC1258j;

public final class C4130i implements InterfaceC1258j {

    public final WeakReference f14034a;

    public int f14035b;

    public int f14036c;

    public C4130i(TabLayout tabLayout) {
        this.f14034a = new WeakReference(tabLayout);
    }

    @Override
    public final void mo3134a(int i6, float f) {
        TabLayout tabLayout = (TabLayout) this.f14034a.get();
        if (tabLayout != null) {
            int i10 = this.f14036c;
            tabLayout.m4347n(i6, f, i10 != 2 || this.f14035b == 1, (i10 == 2 && this.f14035b == 0) ? false : true);
        }
    }

    @Override
    public final void onPageScrollStateChanged(int i6) {
        this.f14035b = this.f14036c;
        this.f14036c = i6;
    }

    @Override
    public final void onPageSelected(int i6) {
        TabLayout tabLayout = (TabLayout) this.f14034a.get();
        if (tabLayout == null || tabLayout.getSelectedTabPosition() == i6 || i6 >= tabLayout.getTabCount()) {
            return;
        }
        int i10 = this.f14036c;
        tabLayout.m4345l(tabLayout.m4341h(i6), i10 == 0 || (i10 == 2 && this.f14035b == 0));
    }
}
