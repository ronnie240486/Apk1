package androidx.media3.datasource;

import androidx.media3.common.util.UnstableApi;

@UnstableApi
public interface TransferListener {
    void onBytesTransferred(DataSource dataSource, DataSpec dataSpec, boolean z7, int i6);

    void onTransferEnd(DataSource dataSource, DataSpec dataSpec, boolean z7);

    void onTransferInitializing(DataSource dataSource, DataSpec dataSpec, boolean z7);

    void onTransferStart(DataSource dataSource, DataSpec dataSpec, boolean z7);
}
