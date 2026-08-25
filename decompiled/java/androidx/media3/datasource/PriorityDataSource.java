package androidx.media3.datasource;

import android.net.Uri;
import androidx.media3.common.PriorityTaskManager;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@UnstableApi
public final class PriorityDataSource implements DataSource {
    private final int priority;
    private final PriorityTaskManager priorityTaskManager;
    private final DataSource upstream;

    public static final class Factory implements DataSource.Factory {
        private final int priority;
        private final PriorityTaskManager priorityTaskManager;
        private final DataSource.Factory upstreamFactory;

        public Factory(DataSource.Factory factory, PriorityTaskManager priorityTaskManager, int i6) {
            this.upstreamFactory = factory;
            this.priorityTaskManager = priorityTaskManager;
            this.priority = i6;
        }

        @Override
        public PriorityDataSource createDataSource() {
            return new PriorityDataSource(this.upstreamFactory.createDataSource(), this.priorityTaskManager, this.priority);
        }
    }

    public PriorityDataSource(DataSource dataSource, PriorityTaskManager priorityTaskManager, int i6) {
        this.upstream = (DataSource) Assertions.checkNotNull(dataSource);
        this.priorityTaskManager = (PriorityTaskManager) Assertions.checkNotNull(priorityTaskManager);
        this.priority = i6;
    }

    @Override
    public void addTransferListener(TransferListener transferListener) {
        Assertions.checkNotNull(transferListener);
        this.upstream.addTransferListener(transferListener);
    }

    @Override
    public void close() throws IOException {
        this.upstream.close();
    }

    @Override
    public Map<String, List<String>> getResponseHeaders() {
        return this.upstream.getResponseHeaders();
    }

    @Override
    public Uri getUri() {
        return this.upstream.getUri();
    }

    @Override
    public long open(DataSpec dataSpec) throws IOException {
        this.priorityTaskManager.proceedOrThrow(this.priority);
        return this.upstream.open(dataSpec);
    }

    @Override
    public int read(byte[] bArr, int i6, int i10) throws IOException {
        this.priorityTaskManager.proceedOrThrow(this.priority);
        return this.upstream.read(bArr, i6, i10);
    }
}
