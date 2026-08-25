package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;

public final class C0689f implements ListenerSet.Event {

    public final int f2697a;

    public final AnalyticsListener.EventTime f2698b;

    public final boolean f2699c;

    public C0689f(AnalyticsListener.EventTime eventTime, int i6, boolean z7) {
        this.f2697a = i6;
        this.f2698b = eventTime;
        this.f2699c = z7;
    }

    @Override
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        switch (this.f2697a) {
            case 0:
                DefaultAnalyticsCollector.lambda$onIsLoadingChanged$35(this.f2698b, this.f2699c, analyticsListener);
                break;
            case 1:
                analyticsListener.onSkipSilenceEnabledChanged(this.f2698b, this.f2699c);
                break;
            case 2:
                analyticsListener.onIsPlayingChanged(this.f2698b, this.f2699c);
                break;
            default:
                analyticsListener.onShuffleModeChanged(this.f2698b, this.f2699c);
                break;
        }
    }
}
