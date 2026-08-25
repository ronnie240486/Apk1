package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;

public final class C0697n implements ListenerSet.Event {

    public final int f2725a;

    public final AnalyticsListener.EventTime f2726b;

    public final String f2727c;

    public final long f2728d;

    public final long f2729e;

    public C0697n(AnalyticsListener.EventTime eventTime, String str, long j10, long j11, int i6) {
        this.f2725a = i6;
        this.f2726b = eventTime;
        this.f2727c = str;
        this.f2728d = j10;
        this.f2729e = j11;
    }

    @Override
    public final void invoke(Object obj) {
        switch (this.f2725a) {
            case 0:
                String str = this.f2727c;
                long j10 = this.f2728d;
                DefaultAnalyticsCollector.lambda$onAudioDecoderInitialized$5(this.f2726b, str, j10, this.f2729e, (AnalyticsListener) obj);
                break;
            default:
                String str2 = this.f2727c;
                long j11 = this.f2728d;
                DefaultAnalyticsCollector.lambda$onVideoDecoderInitialized$17(this.f2726b, str2, j11, this.f2729e, (AnalyticsListener) obj);
                break;
        }
    }
}
