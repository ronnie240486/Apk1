package androidx.mediarouter.app;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.AbstractC1465c;
import com.p2serv.android.p032ds.R;
import p065g0.AbstractC2581a;
import p143n5.AbstractC3198d;
import p156o9.AbstractC3280d;
import p173q1.C3436p0;
import p173q1.C3445s0;
import p173q1.C3460z;
import p222u7.AbstractC3928d;

public final class C1103n0 extends AbstractC1091h0 {

    public final View f3278e;

    public final ImageView f3279f;

    public final ProgressBar f3280g;

    public final TextView f3281h;

    public final RelativeLayout f3282i;

    public final CheckBox f3283j;

    public final float f3284k;

    public final int f3285l;

    public final ViewOnClickListenerC1089g0 f3286m;

    public final C1105o0 f3287n;

    public C1103n0(C1105o0 c1105o0, View view) {
        super(c1105o0.f3299j, view, (ImageButton) view.findViewById(R.id.mr_cast_mute_button), (MediaRouteVolumeSlider) view.findViewById(R.id.mr_cast_volume_slider));
        this.f3287n = c1105o0;
        this.f3286m = new ViewOnClickListenerC1089g0(4, this);
        this.f3278e = view;
        this.f3279f = (ImageView) view.findViewById(R.id.mr_cast_route_icon);
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.mr_cast_route_progress_bar);
        this.f3280g = progressBar;
        this.f3281h = (TextView) view.findViewById(R.id.mr_cast_route_name);
        this.f3282i = (RelativeLayout) view.findViewById(R.id.mr_cast_volume_layout);
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.mr_cast_checkbox);
        this.f3283j = checkBox;
        DialogC1109q0 dialogC1109q0 = c1105o0.f3299j;
        Context context = dialogC1109q0.f3334m;
        Drawable drawableM6448W = AbstractC3198d.m6448W(AbstractC1465c.m3473h(context, R.drawable.mr_cast_checkbox));
        if (AbstractC3280d.m6602t(context)) {
            AbstractC2581a.m5585g(drawableM6448W, AbstractC3928d.m7847i(context, R.color.mr_dynamic_dialog_icon_light));
        }
        checkBox.setButtonDrawable(drawableM6448W);
        AbstractC3280d.m6566C(dialogC1109q0.f3334m, progressBar);
        this.f3284k = AbstractC3280d.m6595m(dialogC1109q0.f3334m);
        Resources resources = dialogC1109q0.f3334m.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        TypedValue typedValue = new TypedValue();
        resources.getValue(R.dimen.mr_dynamic_dialog_row_height, typedValue, true);
        this.f3285l = (int) typedValue.getDimension(displayMetrics);
    }

    public final boolean m2760d(C3445s0 c3445s0) {
        if (c3445s0.m7024g()) {
            return true;
        }
        C3436p0 c3436p0M7019a = this.f3287n.f3299j.f3329h.m7019a();
        if (c3436p0M7019a != null) {
            C3460z c3460z = (C3460z) c3436p0M7019a.f11621x.get(c3445s0.f11654c);
            if ((c3460z != null ? c3460z.f11720b : 4) == 3) {
                return true;
            }
        }
        return false;
    }

    public final void m2761e(boolean z7, boolean z10) {
        CheckBox checkBox = this.f3283j;
        checkBox.setEnabled(false);
        this.f3278e.setEnabled(false);
        checkBox.setChecked(z7);
        if (z7) {
            this.f3279f.setVisibility(4);
            this.f3280g.setVisibility(0);
        }
        if (z10) {
            this.f3287n.m2767a(z7 ? this.f3285l : 0, this.f3282i);
        }
    }
}
