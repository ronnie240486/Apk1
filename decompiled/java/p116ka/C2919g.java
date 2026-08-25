package p116ka;

import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.ComponentCallbacks2C1464b;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import java.util.ArrayList;
import org.bitspark.android.beans.EventBean;

public final class C2919g extends BannerImageAdapter {

    public final ViewOnKeyListenerC2925j f9899a;

    public C2919g(ViewOnKeyListenerC2925j viewOnKeyListenerC2925j, ArrayList arrayList) {
        super(arrayList);
        this.f9899a = viewOnKeyListenerC2925j;
    }

    @Override
    public final void onBindView(Object obj, Object obj2, int i6, int i10) {
        BannerImageHolder bannerImageHolder = (BannerImageHolder) obj;
        bannerImageHolder.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        FragmentActivity fragmentActivityM1319h = this.f9899a.m1319h();
        ComponentCallbacks2C1464b.m3462b(fragmentActivityM1319h).m5865c(fragmentActivityM1319h).m3571n(((EventBean) obj2).imageRes).m3533A(bannerImageHolder.imageView);
    }
}
