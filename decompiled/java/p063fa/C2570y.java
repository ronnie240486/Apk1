package p063fa;

import androidx.fragment.app.AbstractC0418n0;
import androidx.fragment.app.AbstractComponentCallbacksC0427s;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;

public final class C2570y extends AbstractC0418n0 {

    public ArrayList f8941g;

    public AbstractComponentCallbacksC0427s f8942h;

    @Override
    public final int mo3131c() {
        return this.f8941g.size();
    }

    @Override
    public final void mo1285e(ViewPager viewPager, int i6, AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s) {
        this.f8942h = abstractComponentCallbacksC0427s;
        super.mo1285e(viewPager, i6, abstractComponentCallbacksC0427s);
    }

    @Override
    public final AbstractComponentCallbacksC0427s mo1287h(int i6) {
        return (AbstractComponentCallbacksC0427s) this.f8941g.get(i6);
    }
}
