package okhttp3.internal.cache;

import java.io.IOException;
import p091i9.InterfaceC2724l;
import p103j9.AbstractC2796i;
import p103j9.AbstractC2797j;
import p243w8.C4070l;

public final class DiskLruCache$Editor$newSink$1$1 extends AbstractC2797j implements InterfaceC2724l {
    final DiskLruCache this$0;
    final DiskLruCache.Editor this$1;

    public DiskLruCache$Editor$newSink$1$1(DiskLruCache diskLruCache, DiskLruCache.Editor editor) {
        super(1);
        this.this$0 = diskLruCache;
        this.this$1 = editor;
    }

    @Override
    public Object invoke(Object obj) {
        invoke((IOException) obj);
        return C4070l.f13734a;
    }

    public final void invoke(IOException iOException) {
        AbstractC2796i.m5785f(iOException, "it");
        DiskLruCache diskLruCache = this.this$0;
        DiskLruCache.Editor editor = this.this$1;
        synchronized (diskLruCache) {
            editor.detach$okhttp();
        }
    }
}
