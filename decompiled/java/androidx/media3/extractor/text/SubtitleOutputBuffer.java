package androidx.media3.extractor.text;

import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.DecoderOutputBuffer;
import java.util.List;

@UnstableApi
public abstract class SubtitleOutputBuffer extends DecoderOutputBuffer implements Subtitle {
    private long subsampleOffsetUs;
    private Subtitle subtitle;

    @Override
    public void clear() {
        super.clear();
        this.subtitle = null;
    }

    @Override
    public List<Cue> getCues(long j10) {
        return ((Subtitle) Assertions.checkNotNull(this.subtitle)).getCues(j10 - this.subsampleOffsetUs);
    }

    @Override
    public long getEventTime(int i6) {
        return ((Subtitle) Assertions.checkNotNull(this.subtitle)).getEventTime(i6) + this.subsampleOffsetUs;
    }

    @Override
    public int getEventTimeCount() {
        return ((Subtitle) Assertions.checkNotNull(this.subtitle)).getEventTimeCount();
    }

    @Override
    public int getNextEventTimeIndex(long j10) {
        return ((Subtitle) Assertions.checkNotNull(this.subtitle)).getNextEventTimeIndex(j10 - this.subsampleOffsetUs);
    }

    public void setContent(long j10, Subtitle subtitle, long j11) {
        this.timeUs = j10;
        this.subtitle = subtitle;
        if (j11 != Long.MAX_VALUE) {
            j10 = j11;
        }
        this.subsampleOffsetUs = j10;
    }
}
