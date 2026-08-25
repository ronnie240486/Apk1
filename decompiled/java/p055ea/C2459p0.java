package p055ea;

import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.TransferListener;

public final class C2459p0 implements TransferListener {

    public long f8649a;

    public long f8650b;

    public long f8651c;

    @Override
    public final void onBytesTransferred(DataSource dataSource, DataSpec dataSpec, boolean z7, int i6) {
        this.f8649a += (long) i6;
    }

    @Override
    public final void onTransferEnd(DataSource dataSource, DataSpec dataSpec, boolean z7) {
    }

    @Override
    public final void onTransferInitializing(DataSource dataSource, DataSpec dataSpec, boolean z7) {
    }

    @Override
    public final void onTransferStart(DataSource dataSource, DataSpec dataSpec, boolean z7) {
    }
}
