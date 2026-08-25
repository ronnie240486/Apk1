package androidx.media3.exoplayer.analytics;

import androidx.media3.common.MediaMetadata;
import androidx.media3.common.util.ListenerSet;

public final class C0705v implements ListenerSet.Event {

    public final int f2755a;

    public final AnalyticsListener.EventTime f2756b;

    public final MediaMetadata f2757c;

    public C0705v(AnalyticsListener.EventTime eventTime, MediaMetadata mediaMetadata, int i6) {
        this.f2755a = i6;
        this.f2756b = eventTime;
        this.f2757c = mediaMetadata;
    }

    @Override
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        switch (this.f2755a) {
            case 0:
                analyticsListener.onPlaylistMetadataChanged(this.f2756b, this.f2757c);
                break;
            default:
                analyticsListener.onMediaMetadataChanged(this.f2756b, this.f2757c);
                break;
        }
    }
}
