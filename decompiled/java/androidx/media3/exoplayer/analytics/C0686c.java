package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;

public final class C0686c implements ListenerSet.Event {

    public final int f2689a;

    public final AnalyticsListener.EventTime f2690b;

    public C0686c(AnalyticsListener.EventTime eventTime, int i6) {
        this.f2689a = i6;
        this.f2690b = eventTime;
    }

    @Override
    public final void invoke(Object obj) {
        switch (this.f2689a) {
            case 0:
                ((AnalyticsListener) obj).onPlayerReleased(this.f2690b);
                break;
            case 1:
                ((AnalyticsListener) obj).onDrmKeysRemoved(this.f2690b);
                break;
            case 2:
                ((AnalyticsListener) obj).onDrmKeysRestored(this.f2690b);
                break;
            case 3:
                ((AnalyticsListener) obj).onSeekStarted(this.f2690b);
                break;
            case 4:
                ((AnalyticsListener) obj).onDrmKeysLoaded(this.f2690b);
                break;
            default:
                ((AnalyticsListener) obj).onDrmSessionReleased(this.f2690b);
                break;
        }
    }
}
