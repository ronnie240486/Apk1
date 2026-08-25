package p017b4;

import android.content.Context;
import p038d4.C2153c;
import p038d4.InterfaceC2152b;
import p087i4.C2704i;
import p221u6.C3905e;
import p249x4.C4112e;

public final class C1298e implements InterfaceC2152b {

    public final int f4075a;

    public final C2153c f4076b;

    public C1298e(C2153c c2153c, int i6) {
        this.f4075a = i6;
        this.f4076b = c2153c;
    }

    @Override
    public final Object get() {
        switch (this.f4075a) {
            case 0:
                return new C1297d((Context) this.f4076b.f7798a, new C3905e(19), new C4112e(18));
            case 1:
                String packageName = ((Context) this.f4076b.f7798a).getPackageName();
                if (packageName != null) {
                    return packageName;
                }
                throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
            default:
                return new C2704i((Context) this.f4076b.f7798a, Integer.valueOf(C2704i.f9394d).intValue(), "com.google.android.datatransport.events");
        }
    }
}
