package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;

public final class C0698o implements ListenerSet.Event {

    public final int f2730a = 0;

    public final AnalyticsListener.EventTime f2731b;

    public final long f2732c;

    public final int f2733d;

    public C0698o(AnalyticsListener.EventTime eventTime, int i6, long j10) {
        this.f2731b = eventTime;
        this.f2733d = i6;
        this.f2732c = j10;
    }

    @Override
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        switch (this.f2730a) {
            case 0:
                analyticsListener.onDroppedVideoFrames(this.f2731b, this.f2733d, this.f2732c);
                break;
            default:
                analyticsListener.onVideoFrameProcessingOffset(this.f2731b, this.f2732c, this.f2733d);
                break;
        }
    }

    public C0698o(AnalyticsListener.EventTime eventTime, long j10, int i6) {
        this.f2731b = eventTime;
        this.f2732c = j10;
        this.f2733d = i6;
    }
}
