package okhttp3.internal.cache;

import java.io.IOException;
import okhttp3.internal.Util;
import p091i9.InterfaceC2724l;
import p103j9.AbstractC2796i;
import p103j9.AbstractC2797j;
import p243w8.C4070l;

public final class DiskLruCache$newJournalWriter$faultHidingSink$1 extends AbstractC2797j implements InterfaceC2724l {
    final DiskLruCache this$0;

    public DiskLruCache$newJournalWriter$faultHidingSink$1(DiskLruCache diskLruCache) {
        super(1);
        this.this$0 = diskLruCache;
    }

    @Override
    public Object invoke(Object obj) {
        invoke((IOException) obj);
        return C4070l.f13734a;
    }

    public final void invoke(IOException iOException) {
        AbstractC2796i.m5785f(iOException, "it");
        DiskLruCache diskLruCache = this.this$0;
        if (!Util.assertionsEnabled || Thread.holdsLock(diskLruCache)) {
            this.this$0.hasJournalErrors = true;
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + diskLruCache);
    }
}
