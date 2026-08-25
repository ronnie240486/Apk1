package p251x6;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.AbstractC1158k0;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.p2serv.android.p032ds.R;
import p003a2.AbstractC0032a;
import p101j7.C2782c;
import p116ka.C2924i0;

public final class C4136o {

    public final TabLayout f14057a;

    public final ViewPager2 f14058b;

    public final C2782c f14059c;

    public AbstractC1158k0 f14060d;

    public boolean f14061e;

    public C4136o(TabLayout tabLayout, ViewPager2 viewPager2, C2782c c2782c) {
        this.f14057a = tabLayout;
        this.f14058b = viewPager2;
        this.f14059c = c2782c;
    }

    public final void m8156a() {
        TabLayout tabLayout = this.f14057a;
        tabLayout.m4344k();
        AbstractC1158k0 abstractC1158k0 = this.f14060d;
        if (abstractC1158k0 != null) {
            int itemCount = abstractC1158k0.getItemCount();
            int i6 = 0;
            while (i6 < itemCount) {
                C4129h c4129hM4342i = tabLayout.m4342i();
                RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(((C2924i0) this.f14059c.f9501b).m1321j()).inflate(R.layout.tab_custom, (ViewGroup) null);
                StringBuilder sb = new StringBuilder();
                sb.append(AbstractC0032a.m165s("ke8ZxT/XKw==\n", "wop4tlC5Cxc=\n"));
                i6++;
                sb.append(i6);
                String string = sb.toString();
                TextView textView = (TextView) relativeLayout.findViewById(R.id.tv);
                textView.setText(string);
                textView.setTextSize(15.0f);
                c4129hM4342i.f14031e = relativeLayout;
                c4129hM4342i.m8145a();
                tabLayout.m4335b(c4129hM4342i, false);
            }
            if (itemCount > 0) {
                int iMin = Math.min(this.f14058b.getCurrentItem(), tabLayout.getTabCount() - 1);
                if (iMin != tabLayout.getSelectedTabPosition()) {
                    tabLayout.m4345l(tabLayout.m4341h(iMin), true);
                }
            }
        }
    }
}
