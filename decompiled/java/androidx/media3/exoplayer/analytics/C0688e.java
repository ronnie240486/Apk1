package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;

public final class C0688e implements ListenerSet.Event {

    public final int f2694a;

    public final AnalyticsListener.EventTime f2695b;

    public final long f2696c;

    public C0688e(AnalyticsListener.EventTime eventTime, long j10, int i6) {
        this.f2694a = i6;
        this.f2695b = eventTime;
        this.f2696c = j10;
    }

    @Override
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        switch (this.f2694a) {
            case 0:
                analyticsListener.onSeekForwardIncrementChanged(this.f2695b, this.f2696c);
                break;
            case 1:
                analyticsListener.onAudioPositionAdvancing(this.f2695b, this.f2696c);
                break;
            case 2:
                analyticsListener.onSeekBackIncrementChanged(this.f2695b, this.f2696c);
                break;
            default:
                analyticsListener.onMaxSeekToPreviousPositionChanged(this.f2695b, this.f2696c);
                break;
        }
    }
}
