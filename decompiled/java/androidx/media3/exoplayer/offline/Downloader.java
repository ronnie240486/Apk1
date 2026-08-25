package androidx.media3.exoplayer.offline;

import androidx.media3.common.util.UnstableApi;
import java.io.IOException;

@UnstableApi
public interface Downloader {

    public interface ProgressListener {
        void onProgress(long j10, long j11, float f);
    }

    void cancel();

    void download(ProgressListener progressListener) throws InterruptedException, IOException;

    void remove();
}
