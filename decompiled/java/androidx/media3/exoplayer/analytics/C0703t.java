package androidx.media3.exoplayer.analytics;

import androidx.media3.common.Format;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.DecoderReuseEvaluation;

public final class C0703t implements ListenerSet.Event {

    public final int f2748a;

    public final AnalyticsListener.EventTime f2749b;

    public final Format f2750c;

    public final DecoderReuseEvaluation f2751d;

    public C0703t(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation, int i6) {
        this.f2748a = i6;
        this.f2749b = eventTime;
        this.f2750c = format;
        this.f2751d = decoderReuseEvaluation;
    }

    @Override
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        switch (this.f2748a) {
            case 0:
                analyticsListener.onVideoInputFormatChanged(this.f2749b, this.f2750c, this.f2751d);
                break;
            default:
                analyticsListener.onAudioInputFormatChanged(this.f2749b, this.f2750c, this.f2751d);
                break;
        }
    }
}
