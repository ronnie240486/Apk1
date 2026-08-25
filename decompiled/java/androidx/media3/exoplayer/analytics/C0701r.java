package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.source.MediaLoadData;

public final class C0701r implements ListenerSet.Event {

    public final int f2741a;

    public final AnalyticsListener.EventTime f2742b;

    public final MediaLoadData f2743c;

    public C0701r(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData, int i6) {
        this.f2741a = i6;
        this.f2742b = eventTime;
        this.f2743c = mediaLoadData;
    }

    @Override
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        switch (this.f2741a) {
            case 0:
                analyticsListener.onDownstreamFormatChanged(this.f2742b, this.f2743c);
                break;
            default:
                analyticsListener.onUpstreamDiscarded(this.f2742b, this.f2743c);
                break;
        }
    }
}
