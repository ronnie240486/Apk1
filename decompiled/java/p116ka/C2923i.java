package p116ka;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.app.ViewOnClickListenerC0122a;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.C1474l;
import com.bumptech.glide.ComponentCallbacks2C1464b;
import com.p2serv.android.p032ds.R;
import com.youth.banner.adapter.BannerAdapter;
import java.util.ArrayList;
import org.bitspark.android.beans.EventBean;
import p000a.AbstractC0004e;
import p063fa.C2572z;
import p247x2.C4089k;

public final class C2923i extends BannerAdapter {

    public final ViewOnKeyListenerC2925j f9910a;

    public C2923i(ViewOnKeyListenerC2925j viewOnKeyListenerC2925j, ArrayList arrayList) {
        super(arrayList);
        this.f9910a = viewOnKeyListenerC2925j;
    }

    @Override
    public final void onBindView(Object obj, Object obj2, int i6, int i10) {
        C2572z c2572z = (C2572z) obj;
        EventBean eventBean = (EventBean) obj2;
        FragmentActivity fragmentActivityM1319h = this.f9910a.m1319h();
        ((C1474l) ComponentCallbacks2C1464b.m3462b(fragmentActivityM1319h).m5865c(fragmentActivityM1319h).m3572o(eventBean.image).m6383d(C4089k.f13830c)).m3533A(c2572z.f8947a);
        c2572z.f8947a.setOnClickListener(new ViewOnClickListenerC0122a(14, this));
        int i11 = eventBean.tag;
        ImageView imageView = c2572z.f8948b;
        if (i11 == 0 && eventBean.channel == 0) {
            imageView.setVisibility(8);
        } else if (i11 == 0) {
            imageView.setVisibility(0);
            imageView.setImageResource(R.mipmap.home_vod_play_3x);
        } else {
            imageView.setVisibility(0);
            imageView.setImageResource(R.mipmap.home_vod_list_3x);
        }
    }

    @Override
    public final Object onCreateHolder(ViewGroup viewGroup, int i6) {
        View viewM15i = AbstractC0004e.m15i(viewGroup, R.layout.item_banner, viewGroup, false);
        C2572z c2572z = new C2572z(viewM15i);
        c2572z.f8947a = (ImageView) viewM15i.findViewById(R.id.imageView);
        c2572z.f8948b = (ImageView) viewM15i.findViewById(R.id.icon);
        return c2572z;
    }
}
