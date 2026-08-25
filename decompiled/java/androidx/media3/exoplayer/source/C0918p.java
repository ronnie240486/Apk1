package androidx.media3.exoplayer.source;

import androidx.media3.common.util.Consumer;
import androidx.media3.exoplayer.analytics.PlayerId;

public final class C0918p implements Consumer, ProgressiveMediaExtractor.Factory {

    public final int f3000a;

    public C0918p(int i6) {
        this.f3000a = i6;
    }

    @Override
    public void accept(Object obj) {
        switch (this.f3000a) {
            case 0:
                SampleQueue.lambda$new$0((SampleQueue.SharedSampleMetadata) obj);
                break;
            default:
                SpannedData.lambda$new$0(obj);
                break;
        }
    }

    @Override
    public ProgressiveMediaExtractor createProgressiveMediaExtractor(PlayerId playerId) {
        return MediaParserExtractorAdapter.lambda$static$0(playerId);
    }
}
