package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;

public final class C0691h implements ListenerSet.Event {

    public final int f2703a;

    public final AnalyticsListener.EventTime f2704b;

    public final int f2705c;

    public C0691h(AnalyticsListener.EventTime eventTime, int i6, int i10) {
        this.f2703a = i10;
        this.f2704b = eventTime;
        this.f2705c = i6;
    }

    @Override
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        switch (this.f2703a) {
            case 0:
                analyticsListener.onTimelineChanged(this.f2704b, this.f2705c);
                break;
            case 1:
                analyticsListener.onPlaybackSuppressionReasonChanged(this.f2704b, this.f2705c);
                break;
            case 2:
                analyticsListener.onPlaybackStateChanged(this.f2704b, this.f2705c);
                break;
            case 3:
                DefaultAnalyticsCollector.lambda$onDrmSessionAcquired$64(this.f2704b, this.f2705c, analyticsListener);
                break;
            case 4:
                analyticsListener.onAudioSessionIdChanged(this.f2704b, this.f2705c);
                break;
            default:
                analyticsListener.onRepeatModeChanged(this.f2704b, this.f2705c);
                break;
        }
    }
}
