package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.DecoderCounters;

public final class C0687d implements ListenerSet.Event {

    public final int f2691a;

    public final AnalyticsListener.EventTime f2692b;

    public final DecoderCounters f2693c;

    public C0687d(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters, int i6) {
        this.f2691a = i6;
        this.f2692b = eventTime;
        this.f2693c = decoderCounters;
    }

    @Override
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        switch (this.f2691a) {
            case 0:
                analyticsListener.onAudioEnabled(this.f2692b, this.f2693c);
                break;
            case 1:
                analyticsListener.onAudioDisabled(this.f2692b, this.f2693c);
                break;
            case 2:
                analyticsListener.onVideoDisabled(this.f2692b, this.f2693c);
                break;
            default:
                analyticsListener.onVideoEnabled(this.f2692b, this.f2693c);
                break;
        }
    }
}
