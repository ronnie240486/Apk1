package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import okio.BufferedSource;
import p103j9.AbstractC2796i;

public interface PushObserver {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final PushObserver CANCEL = new Companion.PushObserverCancel();

    public static final class Companion {
        static final Companion $$INSTANCE = new Companion();

        public static final class PushObserverCancel implements PushObserver {
            @Override
            public boolean onData(int i6, BufferedSource bufferedSource, int i10, boolean z7) throws IOException {
                AbstractC2796i.m5785f(bufferedSource, "source");
                bufferedSource.skip(i10);
                return true;
            }

            @Override
            public boolean onHeaders(int i6, List<Header> list, boolean z7) {
                AbstractC2796i.m5785f(list, "responseHeaders");
                return true;
            }

            @Override
            public boolean onRequest(int i6, List<Header> list) {
                AbstractC2796i.m5785f(list, "requestHeaders");
                return true;
            }

            @Override
            public void onReset(int i6, ErrorCode errorCode) {
                AbstractC2796i.m5785f(errorCode, "errorCode");
            }
        }

        private Companion() {
        }
    }

    boolean onData(int i6, BufferedSource bufferedSource, int i10, boolean z7) throws IOException;

    boolean onHeaders(int i6, List<Header> list, boolean z7);

    boolean onRequest(int i6, List<Header> list);

    void onReset(int i6, ErrorCode errorCode);
}
