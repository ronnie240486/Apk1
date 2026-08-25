package androidx.media3.exoplayer.util;

import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.UnstableApi;
import java.util.concurrent.Executor;

@UnstableApi
public interface ReleasableExecutor extends Executor {

    public abstract class CC {
        public static ReleasableExecutor m2603a(final Executor executor, final Consumer consumer) {
            return new ReleasableExecutor() {
                @Override
                public void execute(Runnable runnable) {
                    executor.execute(runnable);
                }

                @Override
                public void release() {
                    consumer.accept(executor);
                }
            };
        }
    }

    void release();
}
