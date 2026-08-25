package p116ka;

import android.os.Bundle;
import androidx.fragment.app.AbstractComponentCallbacksC0427s;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.mars.xlog.Log;
import java.util.ArrayList;
import org.bitspark.android.beans.ChannelBean;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;
import p063fa.C2543m0;
import p063fa.ViewOnKeyListenerC2573z0;
import sa.C3741l;

public final class C2914d0 extends FragmentStateAdapter {

    public final ChannelBean f9873a;

    public final ViewPager2 f9874b;

    public final int f9875c;

    public final C2924i0 f9876d;

    public C2914d0(C2924i0 c2924i0, FragmentActivity fragmentActivity, ChannelBean channelBean, ViewPager2 viewPager2, int i6) {
        super(fragmentActivity);
        this.f9876d = c2924i0;
        this.f9873a = channelBean;
        this.f9874b = viewPager2;
        this.f9875c = i6;
    }

    @Override
    public final AbstractComponentCallbacksC0427s createFragment(int i6) {
        try {
            ChannelBean channelBean = this.f9873a;
            C2543m0 c2543m0 = new C2543m0();
            c2543m0.f8865c = 7;
            ArrayList arrayList = new ArrayList();
            c2543m0.f8866d = arrayList;
            c2543m0.f8867e = channelBean;
            int i10 = i6 + 1;
            arrayList.addAll(channelBean.getSeasonSources(i10));
            c2543m0.f8864b = new ViewOnKeyListenerC2573z0(4, this);
            c2543m0.f8863a = new C2912c0(this, c2543m0);
            C3741l c3741l = new C3741l();
            Bundle bundle = new Bundle();
            bundle.putInt(C3741l.f12538X, i10);
            c3741l.m1316O(bundle);
            c3741l.f12539T = c2543m0;
            return c3741l;
        } catch (Exception e5) {
            String strM165s = AbstractC0032a.m165s("C+8hLNnb750xxjcJ28Lrmik=\n", "XYBFaLyvjvQ=\n");
            String string = e5.toString();
            boolean z7 = AbstractC3331m.f11244b;
            Log.m5049i(strM165s, string);
            return null;
        }
    }

    @Override
    public final int getItemCount() {
        return this.f9875c;
    }

    @Override
    public final long getItemId(int i6) {
        return i6;
    }
}
