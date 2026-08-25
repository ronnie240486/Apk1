package p063fa;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.AbstractC1174p1;
import com.p2serv.android.p032ds.R;
import java.util.List;
import org.bitspark.android.beans.Menu;
import p000a.AbstractC0004e;

public final class C2550o1 extends AbstractC2512c {

    public final int f8882i;

    public C2550o1(int i6, List list) {
        super(list);
        this.f8882i = i6;
    }

    @Override
    public final int getItemCount() {
        switch (this.f8882i) {
            case 0:
                break;
        }
        return this.f8755h.size();
    }

    @Override
    public final void onBindViewHolder(AbstractC1174p1 abstractC1174p1, int i6) {
        switch (this.f8882i) {
            case 0:
                C2547n1 c2547n1 = (C2547n1) abstractC1174p1;
                int i10 = this.f8752e;
                if (i10 == i6) {
                    this.f8753f = c2547n1.itemView;
                }
                c2547n1.itemView.setSelected(i10 == i6);
                Menu menu = (Menu) this.f8755h.get(i6);
                c2547n1.f8872a.setText(menu.getName());
                if (this.f8750c != null) {
                    c2547n1.itemView.setOnFocusChangeListener(new ViewOnFocusChangeListenerC2538k1(this, i6, c2547n1, menu, 1));
                }
                if (this.f8751d != null) {
                    c2547n1.itemView.setOnKeyListener(new ViewOnKeyListenerC2573z0(2, this));
                }
                if (this.f8754g != null) {
                    c2547n1.itemView.setOnClickListener(new ViewOnClickListenerC2554q(this, i6, 5));
                }
                break;
            default:
                C2553p1 c2553p1 = (C2553p1) abstractC1174p1;
                Menu menu2 = (Menu) this.f8755h.get(i6);
                c2553p1.f8890a.setText(menu2.getName());
                c2553p1.f8891b.setText(menu2.getName());
                boolean z7 = this.f8752e == i6;
                c2553p1.itemView.setSelected(z7);
                LinearLayout linearLayout = c2553p1.f8893d;
                LinearLayout linearLayout2 = c2553p1.f8892c;
                if (z7) {
                    linearLayout2.setVisibility(0);
                    linearLayout.setVisibility(8);
                } else {
                    linearLayout2.setVisibility(8);
                    linearLayout.setVisibility(0);
                }
                c2553p1.itemView.setOnTouchListener(new ViewOnTouchListenerC2534j0(this, c2553p1, i6, 3));
                if (this.f8754g != null) {
                    c2553p1.itemView.setOnClickListener(new ViewOnClickListenerC2554q(this, i6, 6));
                }
                if (this.f8751d != null) {
                    c2553p1.itemView.setOnKeyListener(new ViewOnKeyListenerC2573z0(3, this));
                }
                break;
        }
    }

    @Override
    public final AbstractC1174p1 onCreateViewHolder(ViewGroup viewGroup, int i6) {
        switch (this.f8882i) {
            case 0:
                View viewM15i = AbstractC0004e.m15i(viewGroup, R.layout.item_vod_season, viewGroup, false);
                C2547n1 c2547n1 = new C2547n1(viewM15i);
                c2547n1.f8872a = (TextView) viewM15i.findViewById(R.id.item_tv);
                return c2547n1;
            default:
                View viewM15i2 = AbstractC0004e.m15i(viewGroup, R.layout.item_vod_audio, viewGroup, false);
                C2553p1 c2553p1 = new C2553p1(viewM15i2);
                c2553p1.f8890a = (TextView) viewM15i2.findViewById(R.id.tv_selected);
                c2553p1.f8891b = (TextView) viewM15i2.findViewById(R.id.tv_unselected);
                c2553p1.f8892c = (LinearLayout) viewM15i2.findViewById(R.id.selected_layout);
                c2553p1.f8893d = (LinearLayout) viewM15i2.findViewById(R.id.unselected_layout);
                return c2553p1;
        }
    }
}
