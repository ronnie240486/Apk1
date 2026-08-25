package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;

public final class C0690g implements ListenerSet.Event {

    public final int f2700a;

    public final AnalyticsListener.EventTime f2701b;

    public final String f2702c;

    public C0690g(AnalyticsListener.EventTime eventTime, String str, int i6) {
        this.f2700a = i6;
        this.f2701b = eventTime;
        this.f2702c = str;
    }

    @Override
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        switch (this.f2700a) {
            case 0:
                analyticsListener.onAudioDecoderReleased(this.f2701b, this.f2702c);
                break;
            default:
                analyticsListener.onVideoDecoderReleased(this.f2701b, this.f2702c);
                break;
        }
    }
}
