package androidx.media3.exoplayer.upstream;

import androidx.media3.common.util.Consumer;
import java.util.concurrent.ExecutorService;

public final class C0964h implements Consumer {
    @Override
    public final void accept(Object obj) {
        ((ExecutorService) obj).shutdown();
    }
}
