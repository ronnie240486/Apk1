package p063fa;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.AbstractC1174p1;
import com.p2serv.android.p032ds.R;
import java.util.List;
import org.bitspark.android.beans.Menu;
import p000a.AbstractC0004e;

public final class C2544m1 extends AbstractC2512c {

    public int f8868i;

    @Override
    public final void mo5549a(List list) {
        this.f8752e = -1;
        super.mo5549a(list);
    }

    @Override
    public final void onBindViewHolder(AbstractC1174p1 abstractC1174p1, int i6) {
        C2541l1 c2541l1 = (C2541l1) abstractC1174p1;
        Menu menu = (Menu) this.f8755h.get(i6);
        c2541l1.f8860a.setText(menu.getName());
        c2541l1.itemView.setOnKeyListener(new ViewOnKeyListenerC2573z0(1, this));
        c2541l1.itemView.setOnTouchListener(new ViewOnTouchListenerC2534j0(this, c2541l1, i6, 2));
        if (this.f8750c != null) {
            c2541l1.itemView.setOnFocusChangeListener(new ViewOnFocusChangeListenerC2538k1(this, i6, c2541l1, menu, 0));
        }
        c2541l1.itemView.setOnClickListener(new ViewOnClickListenerC2524g(2));
    }

    @Override
    public final AbstractC1174p1 onCreateViewHolder(ViewGroup viewGroup, int i6) {
        View viewM15i = AbstractC0004e.m15i(viewGroup, R.layout.item_vod_menu, viewGroup, false);
        C2541l1 c2541l1 = new C2541l1(viewM15i);
        c2541l1.f8860a = (TextView) viewM15i.findViewById(R.id.item_tv_menu);
        return c2541l1;
    }
}
