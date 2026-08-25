package androidx.media3.extractor.p010ts;

import androidx.media3.common.C0565C;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.AbstractC1009b;
import androidx.media3.extractor.Ac4Util;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import java.io.IOException;
import java.util.List;
import p005a4.C0060s;

@UnstableApi
public final class Ac4Extractor implements Extractor {
    public static final ExtractorsFactory FACTORY = new C0060s(20);
    private static final int FRAME_HEADER_SIZE = 7;
    private static final int MAX_SNIFF_BYTES = 8192;
    private static final int READ_BUFFER_SIZE = 16384;
    private final Ac4Reader reader = new Ac4Reader(MimeTypes.AUDIO_AC4);
    private final ParsableByteArray sampleData = new ParsableByteArray(16384);
    private boolean startedPacket;

    public static Extractor[] lambda$static$0() {
        return new Extractor[]{new Ac4Extractor()};
    }

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
        this.reader.createTracks(extractorOutput, new TsPayloadReader.TrackIdGenerator(0, 1));
        extractorOutput.endTracks();
        extractorOutput.seekMap(new SeekMap.Unseekable(C0565C.TIME_UNSET));
    }

    @Override
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int i6 = extractorInput.read(this.sampleData.getData(), 0, 16384);
        if (i6 == -1) {
            return -1;
        }
        this.sampleData.setPosition(0);
        this.sampleData.setLimit(i6);
        if (!this.startedPacket) {
            this.reader.packetStarted(0L, 4);
            this.startedPacket = true;
        }
        this.reader.consume(this.sampleData);
        return 0;
    }

    @Override
    public void seek(long j10, long j11) {
        this.startedPacket = false;
        this.reader.seek();
    }

    @Override
    public boolean sniff(ExtractorInput extractorInput) throws IOException {
        ParsableByteArray parsableByteArray = new ParsableByteArray(10);
        int i6 = 0;
        while (true) {
            extractorInput.peekFully(parsableByteArray.getData(), 0, 10);
            parsableByteArray.setPosition(0);
            if (parsableByteArray.readUnsignedInt24() != 4801587) {
                break;
            }
            parsableByteArray.skipBytes(3);
            int synchSafeInt = parsableByteArray.readSynchSafeInt();
            i6 += synchSafeInt + 10;
            extractorInput.advancePeekPosition(synchSafeInt);
        }
        extractorInput.resetPeekPosition();
        extractorInput.advancePeekPosition(i6);
        int i10 = i6;
        while (true) {
            int i11 = 0;
            while (true) {
                extractorInput.peekFully(parsableByteArray.getData(), 0, 7);
                parsableByteArray.setPosition(0);
                int unsignedShort = parsableByteArray.readUnsignedShort();
                if (unsignedShort == 44096 || unsignedShort == 44097) {
                    i11++;
                    if (i11 >= 4) {
                        return true;
                    }
                    int ac4SyncframeSize = Ac4Util.parseAc4SyncframeSize(parsableByteArray.getData(), unsignedShort);
                    if (ac4SyncframeSize == -1) {
                        return false;
                    }
                    extractorInput.advancePeekPosition(ac4SyncframeSize - 7);
                }
            }
            extractorInput.resetPeekPosition();
            i10++;
            if (i10 - i6 >= 8192) {
                return false;
            }
            extractorInput.advancePeekPosition(i10);
        }
    }

    @Override
    public void release() {
    }
}
