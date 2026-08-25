package p063fa;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.p2serv.android.p032ds.R;
import com.tencent.mars.xlog.Log;
import org.bitspark.android.R$drawable;
import org.bitspark.android.utils.AbstractC3331m;
import org.bitspark.android.view.LeanbackTabLayout;
import p003a2.AbstractC0032a;

public final class ViewOnFocusChangeListenerC2545n implements View.OnFocusChangeListener {

    public final int f8869a = 1;

    public ViewGroup f8870b;

    public Object f8871c;

    public ViewOnFocusChangeListenerC2545n() {
    }

    @Override
    public final void onFocusChange(View view, boolean z7) {
        ViewPager2 viewPager2;
        switch (this.f8869a) {
            case 0:
                AbstractC2548o abstractC2548o = (AbstractC2548o) this.f8871c;
                if (z7) {
                    if (abstractC2548o.f8877d <= 0) {
                        abstractC2548o.f8877d = 0;
                    }
                }
                String str = AbstractC2548o.f8873i;
                String str2 = AbstractC0032a.m165s("m54vcxQNtbmbni8xV2b398PAQTZYTv/xlg==\n", "trMCXjkgmJQ=\n") + z7 + AbstractC0032a.m165s("kyZJw/GKTmzWL1PS+IIN\n", "s0sapp3vLRg=\n") + abstractC2548o.f8875b;
                boolean z10 = AbstractC3331m.f11244b;
                Log.m5049i(str, str2);
                if (abstractC2548o.f8875b < ((RecyclerView) this.f8870b).getAdapter().getItemCount()) {
                    int i6 = abstractC2548o.f8875b;
                    abstractC2548o.f8875b = i6;
                    abstractC2548o.notifyItemChanged(i6);
                } else {
                    abstractC2548o.f8875b = 0;
                    abstractC2548o.notifyItemChanged(0);
                }
                break;
            default:
                View viewFindViewById = view.findViewById(R.id.tab_underline);
                if (viewFindViewById != null) {
                    if (z7) {
                        viewFindViewById.setBackgroundResource(R$drawable.shape_color_fff);
                    } else {
                        viewFindViewById.setBackgroundResource(R$drawable.shape_color_73ffffff);
                    }
                }
                if (z7) {
                    LinearLayout linearLayout = (LinearLayout) ((LeanbackTabLayout) this.f8870b).getChildAt(0);
                    for (int i10 = 0; i10 < linearLayout.getChildCount(); i10++) {
                        if (view == linearLayout.getChildAt(i10) && (viewPager2 = (ViewPager2) this.f8871c) != null) {
                            viewPager2.setCurrentItem(i10, false);
                        }
                    }
                }
                break;
        }
    }

    public ViewOnFocusChangeListenerC2545n(AbstractC2548o abstractC2548o, RecyclerView recyclerView) {
        this.f8871c = abstractC2548o;
        this.f8870b = recyclerView;
    }
}
