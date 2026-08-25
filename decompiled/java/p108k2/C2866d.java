package p108k2;

import coil.memory.MemoryCache$Key;
import com.google.android.gms.cast.framework.internal.featurehighlight.C1498f;
import p007a7.C0069f;
import p028c6.C1399b;

public final class C2866d extends C1498f {

    public final C0069f f9797h;

    public C2866d(int i6, C0069f c0069f) {
        super(i6);
        this.f9797h = c0069f;
    }

    @Override
    public final void mo3611a(Object obj, Object obj2, Object obj3) {
        C2865c c2865c = (C2865c) obj2;
        ((C1399b) this.f9797h.f196b).m3270b((MemoryCache$Key) obj, c2865c.f9794a, c2865c.f9795b, c2865c.f9796c);
    }

    @Override
    public final int mo3618h(Object obj, Object obj2) {
        return ((C2865c) obj2).f9796c;
    }
}
