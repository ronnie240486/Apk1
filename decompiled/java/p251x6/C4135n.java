package p251x6;

import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import java.lang.ref.WeakReference;

public final class C4135n extends ViewPager2.OnPageChangeCallback {

    public final WeakReference f14054a;

    public int f14056c = 0;

    public int f14055b = 0;

    public C4135n(TabLayout tabLayout) {
        this.f14054a = new WeakReference(tabLayout);
    }

    @Override
    public final void onPageScrollStateChanged(int i6) {
        this.f14055b = this.f14056c;
        this.f14056c = i6;
    }

    @Override
    public final void onPageScrolled(int i6, float f, int i10) {
        TabLayout tabLayout = (TabLayout) this.f14054a.get();
        if (tabLayout != null) {
            int i11 = this.f14056c;
            tabLayout.m4347n(i6, f, i11 != 2 || this.f14055b == 1, (i11 == 2 && this.f14055b == 0) ? false : true);
        }
    }

    @Override
    public final void onPageSelected(int i6) {
        TabLayout tabLayout = (TabLayout) this.f14054a.get();
        if (tabLayout == null || tabLayout.getSelectedTabPosition() == i6 || i6 >= tabLayout.getTabCount()) {
            return;
        }
        int i10 = this.f14056c;
        tabLayout.m4345l(tabLayout.m4341h(i6), i10 == 0 || (i10 == 2 && this.f14055b == 0));
    }
}
