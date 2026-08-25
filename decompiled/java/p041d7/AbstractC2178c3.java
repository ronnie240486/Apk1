package p041d7;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public abstract class AbstractC2178c3 extends WeakReference implements InterfaceC2199f3 {

    public final int f7851a;

    public AbstractC2178c3(Object obj, int i6, ReferenceQueue referenceQueue) {
        super(obj, referenceQueue);
        this.f7851a = i6;
    }

    @Override
    public InterfaceC2199f3 mo5106b() {
        return null;
    }

    @Override
    public final int mo5107c() {
        return this.f7851a;
    }

    @Override
    public final Object getKey() {
        return get();
    }
}
