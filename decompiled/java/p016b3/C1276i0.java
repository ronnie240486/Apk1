package p016b3;

import android.net.Uri;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import p228v2.C3981h;

public final class C1276i0 implements InterfaceC1288u {

    public static final Set f4029b = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));

    public final InterfaceC1288u f4030a;

    public C1276i0(InterfaceC1288u interfaceC1288u) {
        this.f4030a = interfaceC1288u;
    }

    @Override
    public final C1287t mo3137a(Object obj, int i6, int i10, C3981h c3981h) {
        return this.f4030a.mo3137a(new C1278k(((Uri) obj).toString()), i6, i10, c3981h);
    }

    @Override
    public final boolean mo3138b(Object obj) {
        return f4029b.contains(((Uri) obj).getScheme());
    }
}
