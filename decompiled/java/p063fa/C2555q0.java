package p063fa;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.AbstractC1158k0;
import androidx.recyclerview.widget.AbstractC1174p1;
import com.p2serv.android.p032ds.R;
import p000a.AbstractC0004e;

public final class C2555q0 extends AbstractC1158k0 {

    public float f8897a;

    @Override
    public final int getItemCount() {
        return 5;
    }

    @Override
    public final void onBindViewHolder(AbstractC1174p1 abstractC1174p1, int i6) {
        C2552p0 c2552p0 = (C2552p0) abstractC1174p1;
        float f = this.f8897a;
        float f3 = i6;
        if ((f - 1.0f) - f3 > 0.0f) {
            c2552p0.f8889a.setSelected(true);
            c2552p0.f8889a.setActivated(true);
        } else if (f > f3) {
            c2552p0.f8889a.setActivated(false);
            c2552p0.f8889a.setSelected(true);
        } else {
            c2552p0.f8889a.setSelected(false);
            c2552p0.f8889a.setSelected(false);
        }
    }

    @Override
    public final AbstractC1174p1 onCreateViewHolder(ViewGroup viewGroup, int i6) {
        View viewM15i = AbstractC0004e.m15i(viewGroup, R.layout.item_vod_detail_ratingbar, viewGroup, false);
        C2552p0 c2552p0 = new C2552p0(viewM15i);
        c2552p0.f8889a = (ImageView) viewM15i.findViewById(R.id.imageView);
        return c2552p0;
    }
}
