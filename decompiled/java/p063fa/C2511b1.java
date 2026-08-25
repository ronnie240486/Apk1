package p063fa;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.AbstractC1174p1;
import com.p2serv.android.p032ds.R;
import org.bitspark.android.beans.ChannelBean;
import p000a.AbstractC0004e;

public final class C2511b1 extends AbstractC2512c {
    @Override
    public final void onBindViewHolder(AbstractC1174p1 abstractC1174p1, int i6) {
        C2508a1 c2508a1 = (C2508a1) abstractC1174p1;
        int i10 = this.f8752e;
        if (i10 == i6) {
            this.f8753f = c2508a1.itemView;
        }
        c2508a1.itemView.setSelected(i10 == i6);
        ChannelBean.SourcesBean sourcesBean = (ChannelBean.SourcesBean) this.f8755h.get(i6);
        int i11 = this.f8752e;
        ImageView imageView = c2508a1.f8745b;
        if (i6 == i11) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        c2508a1.f8744a.setText(sourcesBean.getSubTitle());
        if (this.f8750c != null) {
            c2508a1.itemView.setOnFocusChangeListener(new ViewOnFocusChangeListenerC2571y0(this, c2508a1, sourcesBean, i6));
        }
        c2508a1.itemView.setOnTouchListener(new ViewOnTouchListenerC2534j0(this, c2508a1, i6, 1));
        if (this.f8751d != null) {
            c2508a1.itemView.setOnKeyListener(new ViewOnKeyListenerC2573z0(0, this));
        }
        if (this.f8754g != null) {
            c2508a1.itemView.setOnClickListener(new ViewOnClickListenerC2554q(this, i6, 4));
        }
    }

    @Override
    public final AbstractC1174p1 onCreateViewHolder(ViewGroup viewGroup, int i6) {
        View viewM15i = AbstractC0004e.m15i(viewGroup, R.layout.item_vod_episode, viewGroup, false);
        C2508a1 c2508a1 = new C2508a1(viewM15i);
        c2508a1.f8744a = (TextView) viewM15i.findViewById(R.id.item_tv);
        c2508a1.f8745b = (ImageView) viewM15i.findViewById(R.id.iv_playing);
        return c2508a1;
    }
}
