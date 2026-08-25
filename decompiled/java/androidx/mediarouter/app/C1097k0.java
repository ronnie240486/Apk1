package androidx.mediarouter.app;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.p2serv.android.p032ds.R;

public final class C1097k0 extends AbstractC1091h0 {

    public final TextView f3263e;

    public final int f3264f;

    public final C1105o0 f3265g;

    public C1097k0(C1105o0 c1105o0, View view) {
        super(c1105o0.f3299j, view, (ImageButton) view.findViewById(R.id.mr_cast_mute_button), (MediaRouteVolumeSlider) view.findViewById(R.id.mr_cast_volume_slider));
        this.f3265g = c1105o0;
        this.f3263e = (TextView) view.findViewById(R.id.mr_group_volume_route_name);
        Resources resources = c1105o0.f3299j.f3334m.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        TypedValue typedValue = new TypedValue();
        resources.getValue(R.dimen.mr_dynamic_volume_group_list_item_height, typedValue, true);
        this.f3264f = (int) typedValue.getDimension(displayMetrics);
    }
}
