package androidx.media3.extractor.text.webvtt;

import android.text.TextUtils;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.text.AbstractC1026a;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.LegacySubtitleUtil;
import androidx.media3.extractor.text.Subtitle;
import androidx.media3.extractor.text.SubtitleParser;
import java.util.ArrayList;

@UnstableApi
public final class WebvttParser implements SubtitleParser {
    private static final String COMMENT_START = "NOTE";
    public static final int CUE_REPLACEMENT_BEHAVIOR = 1;
    private static final int EVENT_COMMENT = 1;
    private static final int EVENT_CUE = 3;
    private static final int EVENT_END_OF_FILE = 0;
    private static final int EVENT_NONE = -1;
    private static final int EVENT_STYLE_BLOCK = 2;
    private static final String STYLE_START = "STYLE";
    private final ParsableByteArray parsableWebvttData = new ParsableByteArray();
    private final WebvttCssParser cssParser = new WebvttCssParser();

    private static int getNextEvent(ParsableByteArray parsableByteArray) {
        int i6 = -1;
        int position = 0;
        while (i6 == -1) {
            position = parsableByteArray.getPosition();
            String line = parsableByteArray.readLine();
            if (line == null) {
                i6 = 0;
            } else if (STYLE_START.equals(line)) {
                i6 = 2;
            } else {
                i6 = line.startsWith(COMMENT_START) ? 1 : 3;
            }
        }
        parsableByteArray.setPosition(position);
        return i6;
    }

    private static void skipComment(ParsableByteArray parsableByteArray) {
        while (!TextUtils.isEmpty(parsableByteArray.readLine())) {
        }
    }

    @Override
    public int getCueReplacementBehavior() {
        return 1;
    }

    @Override
    public final void parse(byte[] bArr, SubtitleParser.OutputOptions outputOptions, Consumer consumer) {
        AbstractC1026a.m2673a(this, bArr, outputOptions, consumer);
    }

    @Override
    public final Subtitle parseToLegacySubtitle(byte[] bArr, int i6, int i10) {
        return AbstractC1026a.m2674b(this, bArr, i6, i10);
    }

    @Override
    public final void reset() {
        AbstractC1026a.m2675c(this);
    }

    @Override
    public void parse(byte[] bArr, int i6, int i10, SubtitleParser.OutputOptions outputOptions, Consumer<CuesWithTiming> consumer) {
        WebvttCueInfo cue;
        this.parsableWebvttData.reset(bArr, i10 + i6);
        this.parsableWebvttData.setPosition(i6);
        ArrayList arrayList = new ArrayList();
        try {
            WebvttParserUtil.validateWebvttHeaderLine(this.parsableWebvttData);
            while (!TextUtils.isEmpty(this.parsableWebvttData.readLine())) {
            }
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                int nextEvent = getNextEvent(this.parsableWebvttData);
                if (nextEvent == 0) {
                    LegacySubtitleUtil.toCuesWithTiming(new WebvttSubtitle(arrayList2), outputOptions, consumer);
                    return;
                }
                if (nextEvent == 1) {
                    skipComment(this.parsableWebvttData);
                } else if (nextEvent == 2) {
                    if (!arrayList2.isEmpty()) {
                        throw new IllegalArgumentException("A style block was found after the first cue.");
                    }
                    this.parsableWebvttData.readLine();
                    arrayList.addAll(this.cssParser.parseBlock(this.parsableWebvttData));
                } else if (nextEvent == 3 && (cue = WebvttCueParser.parseCue(this.parsableWebvttData, arrayList)) != null) {
                    arrayList2.add(cue);
                }
            }
        } catch (ParserException e5) {
            throw new IllegalArgumentException(e5);
        }
    }
}
