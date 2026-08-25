package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;

public final class C0696m implements ListenerSet.Event {

    public final int f2721a;

    public final AnalyticsListener.EventTime f2722b;

    public final int f2723c;

    public final boolean f2724d;

    public C0696m(AnalyticsListener.EventTime eventTime, int i6, int i10, boolean z7) {
        this.f2721a = i10;
        this.f2722b = eventTime;
        this.f2724d = z7;
        this.f2723c = i6;
    }

    @Override
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        switch (this.f2721a) {
            case 0:
                analyticsListener.onPlayerStateChanged(this.f2722b, this.f2724d, this.f2723c);
                break;
            case 1:
                analyticsListener.onDeviceVolumeChanged(this.f2722b, this.f2723c, this.f2724d);
                break;
            default:
                analyticsListener.onPlayWhenReadyChanged(this.f2722b, this.f2724d, this.f2723c);
                break;
        }
    }

    public C0696m(AnalyticsListener.EventTime eventTime, int i6, boolean z7) {
        this.f2721a = 1;
        this.f2722b = eventTime;
        this.f2723c = i6;
        this.f2724d = z7;
    }
}
