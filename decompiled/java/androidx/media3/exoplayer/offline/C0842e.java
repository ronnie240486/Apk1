package androidx.media3.exoplayer.offline;

import androidx.media3.datasource.cache.CacheWriter;
import androidx.media3.exoplayer.scheduler.RequirementsWatcher;

public final class C0842e implements RequirementsWatcher.Listener, CacheWriter.ProgressListener {

    public final Object f2920a;

    public C0842e(Object obj) {
        this.f2920a = obj;
    }

    @Override
    public void onProgress(long j10, long j11, long j12) {
        ((ProgressiveDownloader) this.f2920a).onProgress(j10, j11, j12);
    }

    @Override
    public void onRequirementsStateChanged(RequirementsWatcher requirementsWatcher, int i6) {
        ((DownloadManager) this.f2920a).onRequirementsStateChanged(requirementsWatcher, i6);
    }
}
