package androidx.media3.exoplayer.rtsp;

import java.util.List;
import p041d7.AbstractC2301u1;

final class RtspOptionsResponse {
    public final int status;
    public final AbstractC2301u1 supportedMethods;

    public RtspOptionsResponse(int i6, List<Integer> list) {
        this.status = i6;
        this.supportedMethods = AbstractC2301u1.m5272n(list);
    }
}
