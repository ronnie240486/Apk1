package p015b2;

import android.view.View;
import androidx.viewpager.widget.PagerTabStrip;
import androidx.viewpager.widget.ViewPager;

public final class ViewOnClickListenerC1250b implements View.OnClickListener {

    public final int f3972a;

    public final PagerTabStrip f3973b;

    public ViewOnClickListenerC1250b(PagerTabStrip pagerTabStrip, int i6) {
        this.f3972a = i6;
        this.f3973b = pagerTabStrip;
    }

    @Override
    public final void onClick(View view) {
        switch (this.f3972a) {
            case 0:
                ViewPager viewPager = this.f3973b.f3837a;
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
                break;
            default:
                ViewPager viewPager2 = this.f3973b.f3837a;
                viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
                break;
        }
    }
}
