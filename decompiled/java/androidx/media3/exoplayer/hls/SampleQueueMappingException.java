package androidx.media3.exoplayer.hls;

import androidx.media3.common.util.UnstableApi;
import java.io.IOException;
import p000a.AbstractC0004e;

@UnstableApi
public final class SampleQueueMappingException extends IOException {
    public SampleQueueMappingException(String str) {
        super(AbstractC0004e.m24r("Unable to bind a sample queue to TrackGroup with MIME type ", str, "."));
    }
}
