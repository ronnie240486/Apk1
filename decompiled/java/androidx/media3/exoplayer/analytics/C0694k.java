package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;

public final class C0694k implements ListenerSet.Event {

    public final int f2713a;

    public final AnalyticsListener.EventTime f2714b;

    public final Exception f2715c;

    public C0694k(AnalyticsListener.EventTime eventTime, Exception exc, int i6) {
        this.f2713a = i6;
        this.f2714b = eventTime;
        this.f2715c = exc;
    }

    @Override
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        switch (this.f2713a) {
            case 0:
                analyticsListener.onVideoCodecError(this.f2714b, this.f2715c);
                break;
            case 1:
                analyticsListener.onDrmSessionManagerError(this.f2714b, this.f2715c);
                break;
            case 2:
                analyticsListener.onAudioCodecError(this.f2714b, this.f2715c);
                break;
            default:
                analyticsListener.onAudioSinkError(this.f2714b, this.f2715c);
                break;
        }
    }
}
