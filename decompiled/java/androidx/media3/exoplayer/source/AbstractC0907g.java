package androidx.media3.exoplayer.source;

import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.analytics.PlayerId;

public abstract class AbstractC0907g {
    public static boolean m2479a(MediaSource mediaSource, MediaItem mediaItem) {
        return false;
    }

    public static Timeline m2480b(MediaSource mediaSource) {
        return null;
    }

    public static boolean m2481c(MediaSource mediaSource) {
        return true;
    }

    public static void m2482d(MediaSource mediaSource, MediaSource.MediaSourceCaller mediaSourceCaller, TransferListener transferListener) {
        mediaSource.prepareSource(mediaSourceCaller, transferListener, PlayerId.UNSET);
    }

    public static void m2483e(MediaSource mediaSource, MediaItem mediaItem) {
    }
}
