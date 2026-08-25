package androidx.media3.extractor.text;

import androidx.media3.common.C0565C;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.UnstableApi;
import java.util.List;

@UnstableApi
public class LegacySubtitleUtil {
    private LegacySubtitleUtil() {
    }

    private static int getStartIndex(Subtitle subtitle, long j10) {
        if (j10 == C0565C.TIME_UNSET) {
            return 0;
        }
        int nextEventTimeIndex = subtitle.getNextEventTimeIndex(j10);
        if (nextEventTimeIndex == -1) {
            nextEventTimeIndex = subtitle.getEventTimeCount();
        }
        return (nextEventTimeIndex <= 0 || subtitle.getEventTime(nextEventTimeIndex + (-1)) != j10) ? nextEventTimeIndex : nextEventTimeIndex - 1;
    }

    private static void outputSubtitleEvent(Subtitle subtitle, int i6, Consumer<CuesWithTiming> consumer) {
        long eventTime = subtitle.getEventTime(i6);
        List<Cue> cues = subtitle.getCues(eventTime);
        if (cues.isEmpty()) {
            return;
        }
        if (i6 == subtitle.getEventTimeCount() - 1) {
            throw new IllegalStateException();
        }
        long eventTime2 = subtitle.getEventTime(i6 + 1) - subtitle.getEventTime(i6);
        if (eventTime2 > 0) {
            consumer.accept(new CuesWithTiming(cues, eventTime, eventTime2));
        }
    }

    public static void toCuesWithTiming(Subtitle subtitle, SubtitleParser.OutputOptions outputOptions, Consumer<CuesWithTiming> consumer) {
        boolean z7;
        int startIndex = getStartIndex(subtitle, outputOptions.startTimeUs);
        if (outputOptions.startTimeUs == C0565C.TIME_UNSET || startIndex >= subtitle.getEventTimeCount()) {
            z7 = false;
        } else {
            List<Cue> cues = subtitle.getCues(outputOptions.startTimeUs);
            long eventTime = subtitle.getEventTime(startIndex);
            if (cues.isEmpty()) {
                z7 = false;
            } else {
                long j10 = outputOptions.startTimeUs;
                if (j10 < eventTime) {
                    consumer.accept(new CuesWithTiming(cues, j10, eventTime - j10));
                    z7 = true;
                } else {
                    z7 = false;
                }
            }
        }
        for (int i6 = startIndex; i6 < subtitle.getEventTimeCount(); i6++) {
            outputSubtitleEvent(subtitle, i6, consumer);
        }
        if (outputOptions.outputAllCues) {
            if (z7) {
                startIndex--;
            }
            for (int i10 = 0; i10 < startIndex; i10++) {
                outputSubtitleEvent(subtitle, i10, consumer);
            }
            if (z7) {
                consumer.accept(new CuesWithTiming(subtitle.getCues(outputOptions.startTimeUs), subtitle.getEventTime(startIndex), outputOptions.startTimeUs - subtitle.getEventTime(startIndex)));
            }
        }
    }
}
