package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.media3.common.DataReader;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.mp3.Mp3Extractor;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import p020b7.C1350k;
import p041d7.AbstractC2182d0;
import p041d7.AbstractC2301u1;
import p041d7.C2288s1;

@UnstableApi
public final class BundledExtractorsAdapter implements ProgressiveMediaExtractor {
    private Extractor extractor;
    private ExtractorInput extractorInput;
    private final ExtractorsFactory extractorsFactory;

    public BundledExtractorsAdapter(ExtractorsFactory extractorsFactory) {
        this.extractorsFactory = extractorsFactory;
    }

    public static String lambda$init$0(Extractor extractor) {
        return extractor.getUnderlyingImplementation().getClass().getSimpleName();
    }

    @Override
    public void disableSeekingOnMp3Streams() {
        Extractor extractor = this.extractor;
        if (extractor == null) {
            return;
        }
        Extractor underlyingImplementation = extractor.getUnderlyingImplementation();
        if (underlyingImplementation instanceof Mp3Extractor) {
            ((Mp3Extractor) underlyingImplementation).disableSeeking();
        }
    }

    @Override
    public long getCurrentInputPosition() {
        ExtractorInput extractorInput = this.extractorInput;
        if (extractorInput != null) {
            return extractorInput.getPosition();
        }
        return -1L;
    }

    @Override
    public void init(DataReader dataReader, Uri uri, Map<String, List<String>> map, long j10, long j11, ExtractorOutput extractorOutput) throws IOException {
        DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(dataReader, j10, j11);
        this.extractorInput = defaultExtractorInput;
        if (this.extractor != null) {
            return;
        }
        Extractor[] extractorArrCreateExtractors = this.extractorsFactory.createExtractors(uri, map);
        C2288s1 c2288s1M5270l = AbstractC2301u1.m5270l(extractorArrCreateExtractors.length);
        boolean z7 = true;
        if (extractorArrCreateExtractors.length == 1) {
            this.extractor = extractorArrCreateExtractors[0];
        } else {
            for (Extractor extractor : extractorArrCreateExtractors) {
                try {
                    if (extractor.sniff(defaultExtractorInput)) {
                        this.extractor = extractor;
                        Assertions.checkState(true);
                        defaultExtractorInput.resetPeekPosition();
                        break;
                    } else {
                        c2288s1M5270l.m5257d(extractor.getSniffFailureDetails());
                        boolean z10 = this.extractor != null || defaultExtractorInput.getPosition() == j10;
                        Assertions.checkState(z10);
                        defaultExtractorInput.resetPeekPosition();
                    }
                } catch (EOFException unused) {
                    if (this.extractor != null || defaultExtractorInput.getPosition() == j10) {
                    }
                } catch (Throwable th) {
                    if (this.extractor == null && defaultExtractorInput.getPosition() != j10) {
                        z7 = false;
                    }
                    Assertions.checkState(z7);
                    defaultExtractorInput.resetPeekPosition();
                    throw th;
                }
                Assertions.checkState(z10);
                defaultExtractorInput.resetPeekPosition();
            }
            if (this.extractor == null) {
                throw new UnrecognizedInputFormatException("None of the available extractors (" + new C1350k(", ").m3241b(AbstractC2182d0.m5136H(AbstractC2301u1.m5273o(extractorArrCreateExtractors), new C0911k(1))) + ") could read the stream.", (Uri) Assertions.checkNotNull(uri), c2288s1M5270l.m5262g());
            }
        }
        this.extractor.init(extractorOutput);
    }

    @Override
    public int read(PositionHolder positionHolder) throws IOException {
        return ((Extractor) Assertions.checkNotNull(this.extractor)).read((ExtractorInput) Assertions.checkNotNull(this.extractorInput), positionHolder);
    }

    @Override
    public void release() {
        Extractor extractor = this.extractor;
        if (extractor != null) {
            extractor.release();
            this.extractor = null;
        }
        this.extractorInput = null;
    }

    @Override
    public void seek(long j10, long j11) {
        ((Extractor) Assertions.checkNotNull(this.extractor)).seek(j10, j11);
    }
}
