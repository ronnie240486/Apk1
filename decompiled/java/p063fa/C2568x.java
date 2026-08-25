package p063fa;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.mediarouter.app.ViewOnClickListenerC1121z;
import androidx.recyclerview.widget.AbstractC1174p1;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import org.bitspark.android.beans.Menu;
import p000a.AbstractC0004e;
import p055ea.C2448k;

public final class C2568x extends AbstractC2531i0 {

    public ArrayList f8930c;

    public C2448k f8931d;

    @Override
    public final int getItemCount() {
        return this.f8930c.size();
    }

    @Override
    public final void onBindViewHolder(AbstractC1174p1 abstractC1174p1, int i6) {
        C2566w c2566w = (C2566w) abstractC1174p1;
        c2566w.itemView.setOnFocusChangeListener(new ViewOnFocusChangeListenerC2528h0(this));
        Menu menu = (Menu) this.f8930c.get(i6);
        String name = menu.getName();
        TextView textView = c2566w.f8924a;
        textView.setText(name);
        c2566w.itemView.setSelected(menu.isSelected());
        if (menu.isSelected()) {
            textView.setTypeface(null, 1);
        } else {
            textView.setTypeface(null, 0);
        }
        c2566w.itemView.setOnClickListener(new ViewOnClickListenerC1121z(this, 2, c2566w));
        c2566w.itemView.setOnKeyListener(new ViewOnKeyListenerC2564v(0));
    }

    @Override
    public final AbstractC1174p1 onCreateViewHolder(ViewGroup viewGroup, int i6) {
        View viewM15i = AbstractC0004e.m15i(viewGroup, R.layout.item_live_source, viewGroup, false);
        C2566w c2566w = new C2566w(viewM15i);
        c2566w.f8924a = (TextView) viewM15i.findViewById(R.id.tv);
        return c2566w;
    }
}
