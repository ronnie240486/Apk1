package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.audio.AudioSink;

public final class C0704u implements ListenerSet.Event {

    public final int f2752a;

    public final AnalyticsListener.EventTime f2753b;

    public final AudioSink.AudioTrackConfig f2754c;

    public C0704u(AnalyticsListener.EventTime eventTime, AudioSink.AudioTrackConfig audioTrackConfig, int i6) {
        this.f2752a = i6;
        this.f2753b = eventTime;
        this.f2754c = audioTrackConfig;
    }

    @Override
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        switch (this.f2752a) {
            case 0:
                analyticsListener.onAudioTrackInitialized(this.f2753b, this.f2754c);
                break;
            default:
                analyticsListener.onAudioTrackReleased(this.f2753b, this.f2754c);
                break;
        }
    }
}
