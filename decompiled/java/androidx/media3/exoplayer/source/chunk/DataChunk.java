package androidx.media3.exoplayer.source.chunk;

import androidx.media3.common.C0565C;
import androidx.media3.common.Format;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceUtil;
import androidx.media3.datasource.DataSpec;
import java.io.IOException;
import java.util.Arrays;

@UnstableApi
public abstract class DataChunk extends Chunk {
    private static final int READ_GRANULARITY = 16384;
    private byte[] data;
    private volatile boolean loadCanceled;

    public DataChunk(DataSource dataSource, DataSpec dataSpec, int i6, Format format, int i10, Object obj, byte[] bArr) {
        super(dataSource, dataSpec, i6, format, i10, obj, C0565C.TIME_UNSET, C0565C.TIME_UNSET);
        this.data = bArr == null ? Util.EMPTY_BYTE_ARRAY : bArr;
    }

    private void maybeExpandData(int i6) {
        byte[] bArr = this.data;
        if (bArr.length < i6 + 16384) {
            this.data = Arrays.copyOf(bArr, bArr.length + 16384);
        }
    }

    @Override
    public final void cancelLoad() {
        this.loadCanceled = true;
    }

    public abstract void consume(byte[] bArr, int i6) throws IOException;

    public byte[] getDataHolder() {
        return this.data;
    }

    @Override
    public final void load() throws IOException {
        try {
            this.dataSource.open(this.dataSpec);
            int i6 = 0;
            int i10 = 0;
            while (i6 != -1 && !this.loadCanceled) {
                maybeExpandData(i10);
                i6 = this.dataSource.read(this.data, i10, 16384);
                if (i6 != -1) {
                    i10 += i6;
                }
            }
            if (!this.loadCanceled) {
                consume(this.data, i10);
            }
        } finally {
            DataSourceUtil.closeQuietly(this.dataSource);
        }
    }
}
