package androidx.media3.extractor.metadata.id3;

import androidx.media3.common.util.UnstableApi;
import java.util.Arrays;
import p000a.AbstractC0004e;

@UnstableApi
public final class BinaryFrame extends Id3Frame {
    public final byte[] data;

    public BinaryFrame(String str, byte[] bArr) {
        super(str);
        this.data = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || BinaryFrame.class != obj.getClass()) {
            return false;
        }
        BinaryFrame binaryFrame = (BinaryFrame) obj;
        return this.f3093id.equals(binaryFrame.f3093id) && Arrays.equals(this.data, binaryFrame.data);
    }

    public int hashCode() {
        return Arrays.hashCode(this.data) + AbstractC0004e.m14h(527, 31, this.f3093id);
    }
}
