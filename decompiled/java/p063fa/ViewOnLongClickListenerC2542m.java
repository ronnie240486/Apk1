package p063fa;

import android.view.View;
import androidx.recyclerview.widget.AbstractC1158k0;
import com.tencent.mars.xlog.Log;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;

public final class ViewOnLongClickListenerC2542m implements View.OnLongClickListener {

    public final int f8861a;

    public final AbstractC1158k0 f8862b;

    public ViewOnLongClickListenerC2542m(AbstractC1158k0 abstractC1158k0, int i6) {
        this.f8861a = i6;
        this.f8862b = abstractC1158k0;
    }

    @Override
    public final boolean onLongClick(View view) {
        AbstractC1158k0 abstractC1158k0 = this.f8862b;
        switch (this.f8861a) {
            case 0:
                AbstractC2548o abstractC2548o = (AbstractC2548o) abstractC1158k0;
                if (abstractC2548o.f8878e.findViewHolderForAdapterPosition(abstractC2548o.f8875b) != null && abstractC2548o.f8878e.findViewHolderForAdapterPosition(abstractC2548o.f8875b).itemView != null) {
                    abstractC2548o.f8878e.findViewHolderForAdapterPosition(abstractC2548o.f8875b).itemView.performLongClick();
                }
                String str = AbstractC2548o.f8873i;
                String strM165s = AbstractC0032a.m165s("LxPn8Yu3szUvE+f9h7uuZ3xitaLRyeJhcUXg\n", "Ei7azLaKjgg=\n");
                boolean z7 = AbstractC3331m.f11244b;
                Log.m5049i(str, strM165s);
                return true;
            case 1:
                AbstractC2562u abstractC2562u = (AbstractC2562u) abstractC1158k0;
                if (abstractC2562u.f8916d.findViewHolderForAdapterPosition(abstractC2562u.f8914b) != null && abstractC2562u.f8916d.findViewHolderForAdapterPosition(abstractC2562u.f8914b).itemView != null) {
                    abstractC2562u.f8916d.findViewHolderForAdapterPosition(abstractC2562u.f8914b).itemView.performLongClick();
                }
                String str2 = AbstractC2562u.f8911e;
                String strM165s2 = AbstractC0032a.m165s("ZsIefIYbrc9mwh5wihewnTWzTC/cZfybOJQZ\n", "W/8jQbsmkPI=\n");
                boolean z10 = AbstractC3331m.f11244b;
                Log.m5049i(str2, strM165s2);
                return true;
            default:
                C2525g0 c2525g0 = (C2525g0) abstractC1158k0;
                c2525g0.f8803h = true;
                c2525g0.f8801f.getClass();
                return false;
        }
    }

    public ViewOnLongClickListenerC2542m(C2525g0 c2525g0, int i6) {
        this.f8861a = 2;
        this.f8862b = c2525g0;
    }
}
