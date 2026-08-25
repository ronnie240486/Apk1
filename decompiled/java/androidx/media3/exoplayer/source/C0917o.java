package androidx.media3.exoplayer.source;

import androidx.media3.common.util.Consumer;
import androidx.media3.datasource.DataSource;
import p020b7.InterfaceC1339e0;

public final class C0917o implements InterfaceC1339e0 {

    public final int f2997a;

    public final Object f2998b;

    public final Object f2999c;

    public C0917o(Object obj, int i6, Object obj2) {
        this.f2997a = i6;
        this.f2998b = obj;
        this.f2999c = obj2;
    }

    @Override
    public final Object get() {
        switch (this.f2997a) {
            case 0:
                return ProgressiveMediaSource.Factory.lambda$setDownloadExecutor$1((InterfaceC1339e0) this.f2998b, (Consumer) this.f2999c);
            case 1:
                return SingleSampleMediaSource.Factory.lambda$setDownloadExecutor$0((InterfaceC1339e0) this.f2998b, (Consumer) this.f2999c);
            default:
                return ((DefaultMediaSourceFactory.DelegateFactoryLoader) this.f2998b).lambda$loadSupplier$4((DataSource.Factory) this.f2999c);
        }
    }
}
