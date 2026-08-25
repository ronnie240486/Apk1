package androidx.media3.extractor;

import androidx.media3.common.util.UnstableApi;
import java.io.IOException;

@UnstableApi
public class ForwardingExtractorInput implements ExtractorInput {
    private final ExtractorInput input;

    public ForwardingExtractorInput(ExtractorInput extractorInput) {
        this.input = extractorInput;
    }

    @Override
    public boolean advancePeekPosition(int i6, boolean z7) throws IOException {
        return this.input.advancePeekPosition(i6, z7);
    }

    @Override
    public long getLength() {
        return this.input.getLength();
    }

    @Override
    public long getPeekPosition() {
        return this.input.getPeekPosition();
    }

    @Override
    public long getPosition() {
        return this.input.getPosition();
    }

    @Override
    public int peek(byte[] bArr, int i6, int i10) throws IOException {
        return this.input.peek(bArr, i6, i10);
    }

    @Override
    public boolean peekFully(byte[] bArr, int i6, int i10, boolean z7) throws IOException {
        return this.input.peekFully(bArr, i6, i10, z7);
    }

    @Override
    public int read(byte[] bArr, int i6, int i10) throws IOException {
        return this.input.read(bArr, i6, i10);
    }

    @Override
    public boolean readFully(byte[] bArr, int i6, int i10, boolean z7) throws IOException {
        return this.input.readFully(bArr, i6, i10, z7);
    }

    @Override
    public void resetPeekPosition() {
        this.input.resetPeekPosition();
    }

    @Override
    public <E extends Throwable> void setRetryPosition(long j10, E e5) throws Throwable {
        this.input.setRetryPosition(j10, e5);
    }

    @Override
    public int skip(int i6) throws IOException {
        return this.input.skip(i6);
    }

    @Override
    public boolean skipFully(int i6, boolean z7) throws IOException {
        return this.input.skipFully(i6, z7);
    }

    @Override
    public void advancePeekPosition(int i6) throws IOException {
        this.input.advancePeekPosition(i6);
    }

    @Override
    public void peekFully(byte[] bArr, int i6, int i10) throws IOException {
        this.input.peekFully(bArr, i6, i10);
    }

    @Override
    public void readFully(byte[] bArr, int i6, int i10) throws IOException {
        this.input.readFully(bArr, i6, i10);
    }

    @Override
    public void skipFully(int i6) throws IOException {
        this.input.skipFully(i6);
    }
}
