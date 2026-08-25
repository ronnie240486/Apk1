package androidx.mediarouter.app;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.AbstractC1174p1;
import com.p2serv.android.p032ds.R;
import p156o9.AbstractC3280d;
import p173q1.C3445s0;

public final class C1095j0 extends AbstractC1174p1 {

    public final View f3254a;

    public final ImageView f3255b;

    public final ProgressBar f3256c;

    public final TextView f3257d;

    public final float f3258e;

    public C3445s0 f3259f;

    public final C1105o0 f3260g;

    public C1095j0(C1105o0 c1105o0, View view) {
        super(view);
        this.f3260g = c1105o0;
        this.f3254a = view;
        this.f3255b = (ImageView) view.findViewById(R.id.mr_cast_group_icon);
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.mr_cast_group_progress_bar);
        this.f3256c = progressBar;
        this.f3257d = (TextView) view.findViewById(R.id.mr_cast_group_name);
        this.f3258e = AbstractC3280d.m6595m(c1105o0.f3299j.f3334m);
        AbstractC3280d.m6566C(c1105o0.f3299j.f3334m, progressBar);
    }
}
