package androidx.media3.exoplayer.analytics;

import android.media.metrics.MediaMetricsManager;
import android.media.metrics.NetworkEvent;
import android.media.metrics.PlaybackErrorEvent;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackStateEvent;
import android.media.metrics.TrackChangeEvent;

public abstract class AbstractC0683a0 {
    public static MediaMetricsManager m2060b(Object obj) {
        return (MediaMetricsManager) obj;
    }

    public static NetworkEvent.Builder m2061c() {
        return new NetworkEvent.Builder();
    }

    public static PlaybackErrorEvent.Builder m2062d() {
        return new PlaybackErrorEvent.Builder();
    }

    public static PlaybackMetrics.Builder m2067i() {
        return new PlaybackMetrics.Builder();
    }

    public static PlaybackStateEvent.Builder m2070l() {
        return new PlaybackStateEvent.Builder();
    }

    public static TrackChangeEvent.Builder m2074p(int i6) {
        return new TrackChangeEvent.Builder(i6);
    }
}
