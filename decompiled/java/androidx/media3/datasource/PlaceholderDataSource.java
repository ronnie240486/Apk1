package androidx.media3.datasource;

import android.net.Uri;
import androidx.media3.common.util.UnstableApi;
import java.io.IOException;
import java.util.Map;

@UnstableApi
public final class PlaceholderDataSource implements DataSource {
    public static final PlaceholderDataSource INSTANCE = new PlaceholderDataSource();
    public static final DataSource.Factory FACTORY = new C0652i();

    private PlaceholderDataSource() {
    }

    public static PlaceholderDataSource m1745a() {
        return new PlaceholderDataSource();
    }

    @Override
    public final Map getResponseHeaders() {
        return AbstractC0641c.m1776a(this);
    }

    @Override
    public Uri getUri() {
        return null;
    }

    @Override
    public long open(DataSpec dataSpec) throws IOException {
        throw new IOException("PlaceholderDataSource cannot be opened");
    }

    @Override
    public int read(byte[] bArr, int i6, int i10) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void close() {
    }

    @Override
    public void addTransferListener(TransferListener transferListener) {
    }
}
