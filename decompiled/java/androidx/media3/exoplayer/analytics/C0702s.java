package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;

public final class C0702s implements ListenerSet.Event {

    public final int f2744a;

    public final AnalyticsListener.EventTime f2745b;

    public final LoadEventInfo f2746c;

    public final MediaLoadData f2747d;

    public C0702s(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, int i6) {
        this.f2744a = i6;
        this.f2745b = eventTime;
        this.f2746c = loadEventInfo;
        this.f2747d = mediaLoadData;
    }

    @Override
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        switch (this.f2744a) {
            case 0:
                analyticsListener.onLoadCanceled(this.f2745b, this.f2746c, this.f2747d);
                break;
            default:
                analyticsListener.onLoadCompleted(this.f2745b, this.f2746c, this.f2747d);
                break;
        }
    }
}
