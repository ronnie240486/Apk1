package androidx.media3.extractor.text;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.AbstractC1009b;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import java.io.IOException;
import java.util.List;

@UnstableApi
@Deprecated
public class SubtitleTranscodingExtractor implements Extractor {
    private final Extractor delegate;
    private final SubtitleParser.Factory subtitleParserFactory;
    private SubtitleTranscodingExtractorOutput transcodingExtractorOutput;

    public SubtitleTranscodingExtractor(Extractor extractor, SubtitleParser.Factory factory) {
        this.delegate = extractor;
        this.subtitleParserFactory = factory;
    }

    @Override
    public final List getSniffFailureDetails() {
        return AbstractC1009b.m2645a(this);
    }

    @Override
    public Extractor getUnderlyingImplementation() {
        return this.delegate;
    }

    @Override
    public void init(ExtractorOutput extractorOutput) {
        SubtitleTranscodingExtractorOutput subtitleTranscodingExtractorOutput = new SubtitleTranscodingExtractorOutput(extractorOutput, this.subtitleParserFactory);
        this.transcodingExtractorOutput = subtitleTranscodingExtractorOutput;
        this.delegate.init(subtitleTranscodingExtractorOutput);
    }

    @Override
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        return this.delegate.read(extractorInput, positionHolder);
    }

    @Override
    public void release() {
        this.delegate.release();
    }

    @Override
    public void seek(long j10, long j11) {
        SubtitleTranscodingExtractorOutput subtitleTranscodingExtractorOutput = this.transcodingExtractorOutput;
        if (subtitleTranscodingExtractorOutput != null) {
            subtitleTranscodingExtractorOutput.resetSubtitleParsers();
        }
        this.delegate.seek(j10, j11);
    }

    @Override
    public boolean sniff(ExtractorInput extractorInput) throws IOException {
        return this.delegate.sniff(extractorInput);
    }
}
