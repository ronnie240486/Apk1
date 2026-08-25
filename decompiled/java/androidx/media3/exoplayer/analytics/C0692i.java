package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;

public final class C0692i implements ListenerSet.Event {

    public final int f2706a;

    public final AnalyticsListener.EventTime f2707b;

    public final int f2708c;

    public final long f2709d;

    public final long f2710e;

    public C0692i(AnalyticsListener.EventTime eventTime, int i6, long j10, long j11, int i10) {
        this.f2706a = i10;
        this.f2707b = eventTime;
        this.f2708c = i6;
        this.f2709d = j10;
        this.f2710e = j11;
    }

    @Override
    public final void invoke(Object obj) {
        switch (this.f2706a) {
            case 0:
                ((AnalyticsListener) obj).onBandwidthEstimate(this.f2707b, this.f2708c, this.f2709d, this.f2710e);
                break;
            default:
                ((AnalyticsListener) obj).onAudioUnderrun(this.f2707b, this.f2708c, this.f2709d, this.f2710e);
                break;
        }
    }
}
