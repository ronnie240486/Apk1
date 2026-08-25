package androidx.mediarouter.app;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import java.util.HashSet;
import p000a.AbstractC0004e;
import p056f0.AbstractC2478a;
import p156o9.AbstractC3280d;
import p173q1.C3445s0;
import p173q1.C3451u0;

public final class C1114t extends ArrayAdapter {

    public final float f3363a;

    public final DialogC1116u f3364b;

    public C1114t(DialogC1116u dialogC1116u, Context context, ArrayList arrayList) {
        super(context, 0, arrayList);
        this.f3364b = dialogC1116u;
        this.f3363a = AbstractC3280d.m6595m(context);
    }

    @Override
    public final View getView(int i6, View view, ViewGroup viewGroup) {
        DialogC1116u dialogC1116u = this.f3364b;
        if (view == null) {
            view = AbstractC0004e.m15i(viewGroup, R.layout.mr_controller_volume_item, viewGroup, false);
        } else {
            dialogC1116u.getClass();
            DialogC1116u.m2790q(dialogC1116u.f3379N, (LinearLayout) view.findViewById(R.id.volume_item_container));
            View viewFindViewById = view.findViewById(R.id.mr_volume_item_icon);
            ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
            int i10 = dialogC1116u.f3378M;
            layoutParams.width = i10;
            layoutParams.height = i10;
            viewFindViewById.setLayoutParams(layoutParams);
        }
        C3445s0 c3445s0 = (C3445s0) getItem(i6);
        if (c3445s0 != null) {
            boolean z7 = c3445s0.f11658g;
            TextView textView = (TextView) view.findViewById(R.id.mr_name);
            textView.setEnabled(z7);
            textView.setText(c3445s0.f11655d);
            MediaRouteVolumeSlider mediaRouteVolumeSlider = (MediaRouteVolumeSlider) view.findViewById(R.id.mr_volume_slider);
            Context context = viewGroup.getContext();
            OverlayListView overlayListView = dialogC1116u.f3369D;
            int iM6594l = AbstractC3280d.m6594l(context, 0);
            if (Color.alpha(iM6594l) != 255) {
                iM6594l = AbstractC2478a.m5511f(iM6594l, ((Integer) overlayListView.getTag()).intValue());
            }
            mediaRouteVolumeSlider.m2736a(iM6594l, iM6594l);
            mediaRouteVolumeSlider.setTag(c3445s0);
            dialogC1116u.f3382Q.put(c3445s0, mediaRouteVolumeSlider);
            mediaRouteVolumeSlider.m2737b(!z7);
            mediaRouteVolumeSlider.setEnabled(z7);
            if (z7) {
                if (dialogC1116u.f3424x) {
                    if (((!c3445s0.m7022e() || C3451u0.m7072g()) ? c3445s0.f11666o : 0) == 1) {
                        mediaRouteVolumeSlider.setMax(c3445s0.f11668q);
                        mediaRouteVolumeSlider.setProgress(c3445s0.f11667p);
                        mediaRouteVolumeSlider.setOnSeekBarChangeListener(dialogC1116u.f3376K);
                    } else {
                        mediaRouteVolumeSlider.setMax(100);
                        mediaRouteVolumeSlider.setProgress(100);
                        mediaRouteVolumeSlider.setEnabled(false);
                    }
                } else {
                    mediaRouteVolumeSlider.setMax(100);
                    mediaRouteVolumeSlider.setProgress(100);
                    mediaRouteVolumeSlider.setEnabled(false);
                }
            }
            ((ImageView) view.findViewById(R.id.mr_volume_item_icon)).setAlpha(z7 ? 255 : (int) (this.f3363a * 255.0f));
            ((LinearLayout) view.findViewById(R.id.volume_item_container)).setVisibility(dialogC1116u.f3374I.contains(c3445s0) ? 4 : 0);
            HashSet hashSet = dialogC1116u.f3372G;
            if (hashSet != null && hashSet.contains(c3445s0)) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.0f);
                alphaAnimation.setDuration(0L);
                alphaAnimation.setFillEnabled(true);
                alphaAnimation.setFillAfter(true);
                view.clearAnimation();
                view.startAnimation(alphaAnimation);
            }
        }
        return view;
    }

    @Override
    public final boolean isEnabled(int i6) {
        return false;
    }
}
