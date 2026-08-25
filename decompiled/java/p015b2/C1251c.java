package p015b2;

import android.database.DataSetObserver;
import androidx.viewpager.widget.PagerTitleStrip;
import androidx.viewpager.widget.ViewPager;

public final class C1251c extends DataSetObserver implements InterfaceC1258j, InterfaceC1257i {

    public int f3974a;

    public final PagerTitleStrip f3975b;

    public C1251c(PagerTitleStrip pagerTitleStrip) {
        this.f3975b = pagerTitleStrip;
    }

    @Override
    public final void mo3134a(int i6, float f) {
        if (f > 0.5f) {
            i6++;
        }
        this.f3975b.mo3078c(f, i6, false);
    }

    @Override
    public final void mo3135b(ViewPager viewPager, AbstractC1249a abstractC1249a, AbstractC1249a abstractC1249a2) {
        this.f3975b.m3079a(abstractC1249a, abstractC1249a2);
    }

    @Override
    public final void onChanged() {
        PagerTitleStrip pagerTitleStrip = this.f3975b;
        pagerTitleStrip.m3080b(pagerTitleStrip.f3837a.getCurrentItem(), pagerTitleStrip.f3837a.getAdapter());
        float f = pagerTitleStrip.f3842f;
        if (f < 0.0f) {
            f = 0.0f;
        }
        pagerTitleStrip.mo3078c(f, pagerTitleStrip.f3837a.getCurrentItem(), true);
    }

    @Override
    public final void onPageScrollStateChanged(int i6) {
        this.f3974a = i6;
    }

    @Override
    public final void onPageSelected(int i6) {
        if (this.f3974a == 0) {
            PagerTitleStrip pagerTitleStrip = this.f3975b;
            pagerTitleStrip.m3080b(pagerTitleStrip.f3837a.getCurrentItem(), pagerTitleStrip.f3837a.getAdapter());
            float f = pagerTitleStrip.f3842f;
            if (f < 0.0f) {
                f = 0.0f;
            }
            pagerTitleStrip.mo3078c(f, pagerTitleStrip.f3837a.getCurrentItem(), true);
        }
    }
}
