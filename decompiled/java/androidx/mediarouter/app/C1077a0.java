package androidx.mediarouter.app;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.AbstractC1174p1;
import com.p2serv.android.p032ds.R;
import p156o9.AbstractC3280d;

public final class C1077a0 extends AbstractC1174p1 {

    public final View f3178a;

    public final ImageView f3179b;

    public final ProgressBar f3180c;

    public final TextView f3181d;

    public final C1079b0 f3182e;

    public C1077a0(C1079b0 c1079b0, View view) {
        super(view);
        this.f3182e = c1079b0;
        this.f3178a = view;
        this.f3179b = (ImageView) view.findViewById(R.id.mr_picker_route_icon);
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.mr_picker_route_progress_bar);
        this.f3180c = progressBar;
        this.f3181d = (TextView) view.findViewById(R.id.mr_picker_route_name);
        AbstractC3280d.m6566C(c1079b0.f3191g.f3196g, progressBar);
    }
}
