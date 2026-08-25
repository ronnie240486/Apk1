package p116ka;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.p2serv.android.p032ds.R;
import com.tencent.mars.xlog.Log;
import org.bitspark.android.utils.AbstractC3331m;
import p002a1.C0026b;
import p003a2.AbstractC0032a;
import p055ea.AbstractC2442h;
import p055ea.EnumC2434d;
import p063fa.C2509b;
import p101j7.C2782c;
import p214ta.C3877a;
import sa.C3731b;

public class ViewOnKeyListenerC2907a extends C2909b implements View.OnKeyListener, View.OnFocusChangeListener {

    public static final String f9860Y = AbstractC0032a.m165s("SVzoB7W+\n", "Cw+pd8XNEf4=\n");

    public View f9861U;

    public RecyclerView f9862V;

    public C2509b f9863W;

    public C3877a f9864X;

    @Override
    public final void onFocusChange(View view, boolean z7) {
        view.getId();
    }

    @Override
    public final boolean onKey(View view, int i6, KeyEvent keyEvent) {
        view.getId();
        if (keyEvent.getRepeatCount() == 0) {
            keyEvent.getAction();
        }
        String str = AbstractC0032a.m165s("vDFZ/pWi\n", "018ym+yCdDA=\n") + i6;
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(f9860Y, str);
        return super.onKey(view, i6, keyEvent);
    }

    @Override
    public final View mo1329t(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f9861U = layoutInflater.inflate(R.layout.fragment_apps, (ViewGroup) null);
        String strM165s = AbstractC0032a.m165s("3N6ZykC8EW+bnt4=\n", "tbDwvhbVdBg=\n");
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(f9860Y, strM165s);
        ((RelativeLayout) this.f9861U.findViewById(R.id.apps_menu)).setOnKeyListener(this);
        C3731b c3731b = new C3731b(0, 0, 0, 0);
        this.f9862V = (RecyclerView) this.f9861U.findViewById(R.id.apps_rview);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(AbstractC2442h.f8614t);
        this.f9862V.addItemDecoration(c3731b);
        this.f9862V.setLayoutManager(gridLayoutManager);
        this.f9862V.setOnFocusChangeListener(this);
        this.f9862V.setOnKeyListener(this);
        try {
            Context contextM1321j = m1321j();
            C2509b c2509b = new C2509b(contextM1321j, EnumC2434d.f8535g);
            c2509b.f8747j = contextM1321j;
            this.f9863W = c2509b;
            c2509b.f8881h = new C2782c(5, this);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        this.f9862V.setAdapter(this.f9863W);
        if (this.f9862V.getVisibility() == 8) {
            this.f9862V.setVisibility(0);
        }
        String str = AbstractC2442h.f8595a;
        m1319h().setRequestedOrientation(0);
        this.f9864X = (C3877a) new C0026b(m1319h()).m136o(C3877a.class);
        return this.f9861U;
    }
}
