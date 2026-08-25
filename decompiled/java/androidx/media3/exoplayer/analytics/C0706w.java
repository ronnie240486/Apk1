package androidx.media3.exoplayer.analytics;

import android.text.TextUtils;
import androidx.media3.common.Player;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import com.tencent.mars.xlog.Log;
import java.util.ArrayList;
import java.util.List;
import org.bitspark.android.Spark;
import org.bitspark.android.beans.ChannelBean;
import org.bitspark.android.utils.AbstractC3331m;
import org.bitspark.android.utils.C3333o;
import p003a2.AbstractC0032a;
import p063fa.C2569x0;
import p116ka.C2924i0;
import p116ka.C2930l0;
import p116ka.ViewOnKeyListenerC2932m0;
import p126l8.InterfaceC3013a;
import p214ta.C3877a;

public final class C0706w implements ListenerSet.Event, Consumer, InterfaceC3013a {

    public final int f2758a;

    public final Object f2759b;

    public final int f2760c;

    public final Object f2761d;

    public final Object f2762e;

    public C0706w(AnalyticsListener.EventTime eventTime, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i6) {
        this.f2758a = 0;
        this.f2759b = eventTime;
        this.f2760c = i6;
        this.f2761d = positionInfo;
        this.f2762e = positionInfo2;
    }

    @Override
    public void accept(Object obj) {
        switch (this.f2758a) {
            case 2:
                ((MediaSourceEventListener.EventDispatcher) this.f2759b).lambda$loadStarted$0((LoadEventInfo) this.f2761d, (MediaLoadData) this.f2762e, this.f2760c, (MediaSourceEventListener) obj);
                break;
            default:
                C2930l0 c2930l0 = (C2930l0) this.f2759b;
                String str = (String) this.f2761d;
                ChannelBean channelBean = (ChannelBean) this.f2762e;
                int size = this.f2760c;
                ChannelBean channelBean2 = (ChannelBean) obj;
                c2930l0.f9944d.f9987z0.put(str, Boolean.TRUE);
                c2930l0.f9944d.getClass();
                List<ChannelBean.SourcesBean> sources = channelBean.getSources();
                List<ChannelBean.SourcesBean> sources2 = channelBean2.getSources();
                if (sources2 != null && sources.size() == sources2.size()) {
                    for (int i6 = 0; i6 < sources.size(); i6++) {
                        String address = sources.get(i6).getAddress();
                        String address2 = sources2.get(i6).getAddress();
                        if (!TextUtils.isEmpty(address) && address.equals(address2)) {
                        }
                    }
                }
                String strM165s = AbstractC0032a.m165s("oNmoiZw=\n", "4or+5viTcrs=\n");
                String strM165s2 = AbstractC0032a.m165s("hV6i5+u026GNQ5TqxLT5p9YNFT4LNgNxCb19\n", "7C3xhobRmMk=\n");
                boolean z7 = AbstractC3331m.f11244b;
                Log.m5049i(strM165s, strM165s2);
                if (c2930l0.f9944d.f9985x0.isShown()) {
                    C3333o c3333o = C3333o.f11249f;
                    ViewOnKeyListenerC2932m0 viewOnKeyListenerC2932m0 = c2930l0.f9944d;
                    String strM5933W = viewOnKeyListenerC2932m0.m5933W(viewOnKeyListenerC2932m0.f9982u0);
                    C2924i0 c2924i0 = c3333o.f11252c;
                    if (c2924i0 != null) {
                        c2924i0.m5919U(channelBean2, strM5933W);
                        c3333o.f11252c.m5917S(channelBean2, strM5933W);
                    }
                    C3877a c3877a = c3333o.f11251b;
                    c3877a.f13004q = channelBean2;
                    c3877a.m7742l();
                    c3333o.f11251b.m7744n();
                    Spark.f11003Y1.m5636d(channelBean2);
                    c2930l0.f9944d.m5935Y(-5, null);
                    C2569x0 c2569x0 = c2930l0.f9944d.f9965d0;
                    ArrayList arrayList = c2569x0.f8932j;
                    if (size >= arrayList.size()) {
                        size = arrayList.size() - 1;
                    }
                    c2569x0.f8877d = size;
                    c2569x0.f8875b = size;
                    c2569x0.notifyItemChanged(size);
                }
                break;
        }
    }

    @Override
    public void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        switch (this.f2758a) {
            case 0:
                DefaultAnalyticsCollector.lambda$onPositionDiscontinuity$46((AnalyticsListener.EventTime) this.f2759b, this.f2760c, (Player.PositionInfo) this.f2761d, (Player.PositionInfo) this.f2762e, analyticsListener);
                break;
            default:
                DefaultAnalyticsCollector.lambda$onLoadStarted$26((AnalyticsListener.EventTime) this.f2759b, (LoadEventInfo) this.f2761d, (MediaLoadData) this.f2762e, this.f2760c, analyticsListener);
                break;
        }
    }

    public C0706w(Object obj, Object obj2, Object obj3, int i6, int i10) {
        this.f2758a = i10;
        this.f2759b = obj;
        this.f2761d = obj2;
        this.f2762e = obj3;
        this.f2760c = i6;
    }
}
