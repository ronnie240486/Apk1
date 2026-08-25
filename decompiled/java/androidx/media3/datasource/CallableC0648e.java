package androidx.media3.datasource;

import android.net.Uri;
import java.util.concurrent.Callable;

public final class CallableC0648e implements Callable {

    public final int f2672a;

    public final DataSourceBitmapLoader f2673b;

    public final Object f2674c;

    public CallableC0648e(DataSourceBitmapLoader dataSourceBitmapLoader, Object obj, int i6) {
        this.f2672a = i6;
        this.f2673b = dataSourceBitmapLoader;
        this.f2674c = obj;
    }

    @Override
    public final Object call() {
        switch (this.f2672a) {
            case 0:
                return this.f2673b.lambda$decodeBitmap$1((byte[]) this.f2674c);
            default:
                return this.f2673b.lambda$loadBitmap$2((Uri) this.f2674c);
        }
    }
}
