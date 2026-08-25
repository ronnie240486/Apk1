package androidx.media3.exoplayer.analytics;

import androidx.media3.common.PlaybackException;
import androidx.media3.common.util.ListenerSet;

public final class C0699p implements ListenerSet.Event {

    public final int f2734a;

    public final AnalyticsListener.EventTime f2735b;

    public final PlaybackException f2736c;

    public C0699p(AnalyticsListener.EventTime eventTime, PlaybackException playbackException, int i6) {
        this.f2734a = i6;
        this.f2735b = eventTime;
        this.f2736c = playbackException;
    }

    @Override
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        switch (this.f2734a) {
            case 0:
                analyticsListener.onPlayerErrorChanged(this.f2735b, this.f2736c);
                break;
            default:
                analyticsListener.onPlayerError(this.f2735b, this.f2736c);
                break;
        }
    }
}
