package androidx.media3.extractor.bmp;

import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.AbstractC1009b;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SingleSampleExtractor;
import java.io.IOException;
import java.util.List;

@UnstableApi
public final class BmpExtractor implements Extractor {
    private static final int BMP_FILE_SIGNATURE = 16973;
    private static final int BMP_FILE_SIGNATURE_LENGTH = 2;
    private final SingleSampleExtractor imageExtractor = new SingleSampleExtractor(BMP_FILE_SIGNATURE, 2, MimeTypes.IMAGE_BMP);

    @Override
    public final List getSniffFailureDetails() {
        return AbstractC1009b.m2645a(this);
    }

    @Override
    public final Extractor getUnderlyingImplementation() {
        return AbstractC1009b.m2646b(this);
    }

    @Override
    public void init(ExtractorOutput extractorOutput) {
        this.imageExtractor.init(extractorOutput);
    }

    @Override
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        return this.imageExtractor.read(extractorInput, positionHolder);
    }

    @Override
    public void seek(long j10, long j11) {
        this.imageExtractor.seek(j10, j11);
    }

    @Override
    public boolean sniff(ExtractorInput extractorInput) throws IOException {
        return this.imageExtractor.sniff(extractorInput);
    }

    @Override
    public void release() {
    }
}
