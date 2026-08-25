package sa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.AbstractComponentCallbacksC0427s;
import androidx.leanback.widget.VerticalGridView;
import androidx.recyclerview.widget.RecyclerView;
import com.p2serv.android.p032ds.R;
import p002a1.C0026b;
import p003a2.AbstractC0032a;
import p004a3.RunnableC0038c;
import p063fa.C2543m0;
import p214ta.C3877a;

public class C3741l extends AbstractComponentCallbacksC0427s {

    public static final String f12538X = AbstractC0032a.m165s("wkzN9obVoqHERM7gmw==\n", "sSmshem7/c8=\n");

    public C2543m0 f12539T;

    public RecyclerView f12540U;

    public C3877a f12541V;

    public int f12542W = 7;

    @Override
    public final View mo1329t(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate;
        C3877a c3877a = (C3877a) new C0026b(m1319h()).m136o(C3877a.class);
        this.f12541V = c3877a;
        if (c3877a.m7738h()) {
            viewInflate = layoutInflater.inflate(R.layout.vod_season_touch_mode, viewGroup, false);
            RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.episode_list_view);
            this.f12540U = recyclerView;
            recyclerView.addItemDecoration(new C3731b(0, 0, 15, 22));
            this.f12540U.setHasFixedSize(true);
            this.f12540U.setAdapter(this.f12539T);
        } else {
            viewInflate = layoutInflater.inflate(R.layout.vod_season, viewGroup, false);
            VerticalGridView verticalGridView = (VerticalGridView) viewInflate.findViewById(R.id.episode_list_view);
            this.f12540U = verticalGridView;
            verticalGridView.addItemDecoration(new C3731b(0, 0, 15, 22));
            verticalGridView.setHasFixedSize(true);
            verticalGridView.setAdapter(this.f12539T);
        }
        RecyclerView recyclerView2 = this.f12540U;
        recyclerView2.post(new RunnableC0038c(this, 27, recyclerView2));
        return viewInflate;
    }
}
