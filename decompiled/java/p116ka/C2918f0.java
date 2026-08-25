package p116ka;

import androidx.viewpager2.widget.ViewPager2;
import org.bitspark.android.view.LeanbackTabLayout;
import p003a2.AbstractC0032a;
import p004a3.RunnableC0038c;
import sa.C3741l;

public final class C2918f0 extends ViewPager2.OnPageChangeCallback {

    public final C2924i0 f9898a;

    public C2918f0(C2924i0 c2924i0) {
        this.f9898a = c2924i0;
    }

    @Override
    public final void onPageSelected(int i6) {
        C2924i0 c2924i0 = this.f9898a;
        if (c2924i0.f9924h0 && i6 == c2924i0.f9912U.f13006s) {
            String str = AbstractC0032a.m165s("Ug==\n", "NE2zTbcSSnI=\n") + c2924i0.f9912U.f13006s;
            if (((C3741l) c2924i0.m1319h().m1184k().m1264z(str)) != null) {
                c2924i0.m5916R(str);
            } else {
                c2924i0.f9920d0.postDelayed(new RunnableC0038c(this, 20, str), 500L);
                LeanbackTabLayout leanbackTabLayout = c2924i0.f9915X;
                leanbackTabLayout.m4345l(leanbackTabLayout.m4341h(i6), true);
            }
            c2924i0.f9924h0 = false;
        }
    }
}
