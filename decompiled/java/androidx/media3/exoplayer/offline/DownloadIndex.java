package androidx.media3.exoplayer.offline;

import androidx.media3.common.util.UnstableApi;
import java.io.IOException;

@UnstableApi
public interface DownloadIndex {
    Download getDownload(String str) throws IOException;

    DownloadCursor getDownloads(int... iArr) throws IOException;
}
