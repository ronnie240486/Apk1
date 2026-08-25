package androidx.media3.extractor.metadata.scte35;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import p000a.AbstractC0004e;

@UnstableApi
public final class PrivateCommand extends SpliceCommand {
    public final byte[] commandBytes;
    public final long identifier;
    public final long ptsAdjustment;

    private PrivateCommand(long j10, byte[] bArr, long j11) {
        this.ptsAdjustment = j11;
        this.identifier = j10;
        this.commandBytes = bArr;
    }

    public static PrivateCommand parseFromSection(ParsableByteArray parsableByteArray, int i6, long j10) {
        long unsignedInt = parsableByteArray.readUnsignedInt();
        int i10 = i6 - 4;
        byte[] bArr = new byte[i10];
        parsableByteArray.readBytes(bArr, 0, i10);
        return new PrivateCommand(unsignedInt, bArr, j10);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SCTE-35 PrivateCommand { ptsAdjustment=");
        sb.append(this.ptsAdjustment);
        sb.append(", identifier= ");
        return AbstractC0004e.m25s(sb, this.identifier, " }");
    }
}
