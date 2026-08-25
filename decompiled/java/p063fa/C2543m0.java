package p063fa;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.ViewOnFocusChangeListenerC0263r2;
import androidx.recyclerview.widget.AbstractC1158k0;
import androidx.recyclerview.widget.AbstractC1174p1;
import com.p2serv.android.p032ds.R;
import ga.C2626i;
import java.util.ArrayList;
import org.bitspark.android.beans.ChannelBean;
import org.bitspark.android.beans.HistoryBean;
import org.bitspark.android.view.MyProcessRelativeLayout;
import p000a.AbstractC0004e;

public final class C2543m0 extends AbstractC1158k0 {

    public InterfaceC2549o0 f8863a;

    public View.OnKeyListener f8864b;

    public int f8865c;

    public ArrayList f8866d;

    public ChannelBean f8867e;

    @Override
    public final int getItemCount() {
        return this.f8866d.size();
    }

    @Override
    public final void onBindViewHolder(AbstractC1174p1 abstractC1174p1, int i6) {
        int i10;
        C2540l0 c2540l0 = (C2540l0) abstractC1174p1;
        ChannelBean.SourcesBean sourcesBean = (ChannelBean.SourcesBean) this.f8866d.get(i6);
        c2540l0.f8858a.setText(sourcesBean.getSubTitle());
        HistoryBean historyBeanM5633a = C2626i.m5633a(this.f8867e.getChid(), "" + sourcesBean.getId());
        long j10 = 0;
        if (historyBeanM5633a != null) {
            long j11 = historyBeanM5633a.lastPosition;
            if (j11 > 0) {
                j10 = j11;
            }
        }
        if (historyBeanM5633a == null || (i10 = historyBeanM5633a.duration) <= 0) {
            i10 = 0;
        }
        MyProcessRelativeLayout myProcessRelativeLayout = c2540l0.f8859b;
        if (i10 > 0) {
            myProcessRelativeLayout.setProgress((((int) j10) * 100) / i10);
        } else {
            myProcessRelativeLayout.setProgress(0);
        }
        c2540l0.itemView.setTag(sourcesBean);
        c2540l0.itemView.setOnClickListener(new ViewOnClickListenerC2554q(this, i6, 3));
        c2540l0.itemView.setOnTouchListener(new ViewOnTouchListenerC2534j0(this, c2540l0, i6, 0));
        c2540l0.itemView.setOnFocusChangeListener(new ViewOnFocusChangeListenerC0263r2(5, this));
        c2540l0.itemView.setOnKeyListener(new ViewOnKeyListenerC2537k0(this, i6, c2540l0));
    }

    @Override
    public final AbstractC1174p1 onCreateViewHolder(ViewGroup viewGroup, int i6) {
        View viewM15i = AbstractC0004e.m15i(viewGroup, R.layout.vod_new_episode_item, viewGroup, false);
        C2540l0 c2540l0 = new C2540l0(viewM15i);
        c2540l0.f8858a = (TextView) viewM15i.findViewById(R.id.item_tv);
        c2540l0.f8859b = (MyProcessRelativeLayout) viewM15i.findViewById(R.id.item_vod_new_episode);
        return c2540l0;
    }
}
