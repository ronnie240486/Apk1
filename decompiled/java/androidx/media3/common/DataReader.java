package androidx.media3.common;

import androidx.media3.common.util.UnstableApi;
import java.io.IOException;

@UnstableApi
public interface DataReader {
    int read(byte[] bArr, int i6, int i10) throws IOException;
}
