package androidx.media3.exoplayer.rtsp;

import java.util.List;
import p041d7.AbstractC2301u1;

final class RtspPlayResponse {
    public final RtspSessionTiming sessionTiming;
    public final int status;
    public final AbstractC2301u1 trackTimingList;

    public RtspPlayResponse(int i6, RtspSessionTiming rtspSessionTiming, List<RtspTrackTiming> list) {
        this.status = i6;
        this.sessionTiming = rtspSessionTiming;
        this.trackTimingList = AbstractC2301u1.m5272n(list);
    }
}
