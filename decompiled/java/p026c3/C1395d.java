package p026c3;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.bumptech.glide.AbstractC1465c;
import p016b3.C1287t;
import p016b3.InterfaceC1288u;
import p175q3.C3470d;
import p228v2.C3981h;

public final class C1395d implements InterfaceC1288u {

    public final Context f4256a;

    public final InterfaceC1288u f4257b;

    public final InterfaceC1288u f4258c;

    public final Class f4259d;

    public C1395d(Context context, InterfaceC1288u interfaceC1288u, InterfaceC1288u interfaceC1288u2, Class cls) {
        this.f4256a = context.getApplicationContext();
        this.f4257b = interfaceC1288u;
        this.f4258c = interfaceC1288u2;
        this.f4259d = cls;
    }

    @Override
    public final C1287t mo3137a(Object obj, int i6, int i10, C3981h c3981h) {
        Uri uri = (Uri) obj;
        return new C1287t(new C3470d(uri), new C1394c(this.f4256a, this.f4257b, this.f4258c, uri, i6, i10, c3981h, this.f4259d));
    }

    @Override
    public final boolean mo3138b(Object obj) {
        return Build.VERSION.SDK_INT >= 29 && AbstractC1465c.m3474i((Uri) obj);
    }
}
