package p063fa;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.AbstractC1174p1;
import com.p2serv.android.p032ds.R;
import com.tencent.mars.xlog.Log;
import org.bitspark.android.utils.AbstractC3331m;
import p000a.AbstractC0004e;
import p003a2.AbstractC0032a;

public final class C2509b extends AbstractC2548o {

    public static final String f8746k = AbstractC0032a.m165s("/OBmCvIsyDHp9WQ=\n", "nZAWebNIqUE=\n");

    public Context f8747j;

    @Override
    public final int getItemCount() {
        return 0;
    }

    @Override
    public final void onBindViewHolder(AbstractC1174p1 abstractC1174p1, int i6) {
        C2506a c2506a = (C2506a) abstractC1174p1;
        String str = AbstractC0032a.m165s("0ddkoN0Ykz6bmA==\n", "obgXyalx/FA=\n") + i6 + AbstractC0032a.m165s("EhCKKX2fY1pWKpsgdcY3\n", "MmPvRRj8Fz8=\n") + this.f8875b + AbstractC0032a.m165s("11kLJWgbjQOSVBoUaC2FVdc=\n", "9zduXRxI6G8=\n") + this.f8877d;
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(f8746k, str);
        boolean z10 = i6 == this.f8875b;
        if (z10) {
            int i10 = this.f8877d;
        }
        c2506a.itemView.setSelected(z10);
        throw null;
    }

    @Override
    public final AbstractC1174p1 onCreateViewHolder(ViewGroup viewGroup, int i6) {
        View viewM15i = AbstractC0004e.m15i(viewGroup, R.layout.app_item, viewGroup, false);
        C2506a c2506a = new C2506a(viewM15i);
        c2506a.f8740a = (ImageView) viewM15i.findViewById(R.id.app_icon);
        c2506a.f8741b = (TextView) viewM15i.findViewById(R.id.app_name);
        return c2506a;
    }
}
