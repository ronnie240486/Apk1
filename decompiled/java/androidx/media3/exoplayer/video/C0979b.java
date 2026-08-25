package androidx.media3.exoplayer.video;

import android.media.MediaFormat;
import androidx.media3.common.Format;

public final class C0979b implements VideoFrameMetadataListener {
    @Override
    public final void onVideoFrameAboutToBeRendered(long j10, long j11, Format format, MediaFormat mediaFormat) {
        DefaultVideoSink.lambda$new$1(j10, j11, format, mediaFormat);
    }
}
