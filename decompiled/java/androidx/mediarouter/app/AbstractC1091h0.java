package androidx.mediarouter.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageButton;
import androidx.recyclerview.widget.AbstractC1174p1;
import com.bumptech.glide.AbstractC1465c;
import com.p2serv.android.p032ds.R;
import p065g0.AbstractC2581a;
import p143n5.AbstractC3198d;
import p156o9.AbstractC3280d;
import p173q1.C3445s0;
import p222u7.AbstractC3928d;

public abstract class AbstractC1091h0 extends AbstractC1174p1 {

    public C3445s0 f3246a;

    public final ImageButton f3247b;

    public final MediaRouteVolumeSlider f3248c;

    public final DialogC1109q0 f3249d;

    public AbstractC1091h0(DialogC1109q0 dialogC1109q0, View view, ImageButton imageButton, MediaRouteVolumeSlider mediaRouteVolumeSlider) {
        int iM7847i;
        int iM7847i2;
        super(view);
        this.f3249d = dialogC1109q0;
        this.f3247b = imageButton;
        this.f3248c = mediaRouteVolumeSlider;
        Context context = dialogC1109q0.f3334m;
        Drawable drawableM6448W = AbstractC3198d.m6448W(AbstractC1465c.m3473h(context, R.drawable.mr_cast_mute_button));
        if (AbstractC3280d.m6602t(context)) {
            AbstractC2581a.m5585g(drawableM6448W, AbstractC3928d.m7847i(context, R.color.mr_dynamic_dialog_icon_light));
        }
        imageButton.setImageDrawable(drawableM6448W);
        Context context2 = dialogC1109q0.f3334m;
        if (AbstractC3280d.m6602t(context2)) {
            iM7847i = AbstractC3928d.m7847i(context2, R.color.mr_cast_progressbar_progress_and_thumb_light);
            iM7847i2 = AbstractC3928d.m7847i(context2, R.color.mr_cast_progressbar_background_light);
        } else {
            iM7847i = AbstractC3928d.m7847i(context2, R.color.mr_cast_progressbar_progress_and_thumb_dark);
            iM7847i2 = AbstractC3928d.m7847i(context2, R.color.mr_cast_progressbar_background_dark);
        }
        mediaRouteVolumeSlider.m2736a(iM7847i, iM7847i2);
    }

    public final void m2748b(C3445s0 c3445s0) {
        this.f3246a = c3445s0;
        int i6 = c3445s0.f11667p;
        boolean z7 = i6 == 0;
        ImageButton imageButton = this.f3247b;
        imageButton.setActivated(z7);
        imageButton.setOnClickListener(new ViewOnClickListenerC1089g0(0, this));
        C3445s0 c3445s1 = this.f3246a;
        MediaRouteVolumeSlider mediaRouteVolumeSlider = this.f3248c;
        mediaRouteVolumeSlider.setTag(c3445s1);
        mediaRouteVolumeSlider.setMax(c3445s0.f11668q);
        mediaRouteVolumeSlider.setProgress(i6);
        mediaRouteVolumeSlider.setOnSeekBarChangeListener(this.f3249d.f3341t);
    }

    public final void m2749c(boolean z7) {
        ImageButton imageButton = this.f3247b;
        if (imageButton.isActivated() == z7) {
            return;
        }
        imageButton.setActivated(z7);
        DialogC1109q0 dialogC1109q0 = this.f3249d;
        if (z7) {
            dialogC1109q0.f3344w.put(this.f3246a.f11654c, Integer.valueOf(this.f3248c.getProgress()));
        } else {
            dialogC1109q0.f3344w.remove(this.f3246a.f11654c);
        }
    }
}
