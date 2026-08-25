package p016b3;

import android.net.Uri;
import com.bumptech.glide.load.data.C1475a;
import com.bumptech.glide.load.data.C1488n;
import com.bumptech.glide.load.data.InterfaceC1479e;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import p175q3.C3470d;
import p228v2.C3981h;

public final class C1274h0 implements InterfaceC1288u {

    public static final Set f4022b = Collections.unmodifiableSet(new HashSet(Arrays.asList("file", "content", "android.resource")));

    public final Object f4023a;

    public C1274h0(C1272g0 c1272g0) {
        this.f4023a = c1272g0;
    }

    @Override
    public final C1287t mo3137a(Object obj, int i6, int i10, C3981h c3981h) {
        InterfaceC1479e c1475a;
        Uri uri = (Uri) obj;
        C3470d c3470d = new C3470d(uri);
        C1272g0 c1272g0 = (C1272g0) this.f4023a;
        switch (c1272g0.f4018a) {
            case 0:
                c1475a = new C1475a(c1272g0.f4019b, uri, 0);
                break;
            case 1:
                c1475a = new C1475a(c1272g0.f4019b, uri, 1);
                break;
            default:
                c1475a = new C1488n(1, uri, c1272g0.f4019b);
                break;
        }
        return new C1287t(c3470d, c1475a);
    }

    @Override
    public final boolean mo3138b(Object obj) {
        return f4022b.contains(((Uri) obj).getScheme());
    }
}
