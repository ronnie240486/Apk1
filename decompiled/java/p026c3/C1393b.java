package p026c3;

import android.content.Context;
import android.net.Uri;
import java.io.File;
import p016b3.C1262b0;
import p016b3.InterfaceC1288u;
import p016b3.InterfaceC1289v;

public final class C1393b implements InterfaceC1289v {

    public final Context f4243a;

    public final Class f4244b;

    public C1393b(Context context, Class cls) {
        this.f4243a = context;
        this.f4244b = cls;
    }

    @Override
    public final InterfaceC1288u mo3136a(C1262b0 c1262b0) {
        Class cls = this.f4244b;
        return new C1395d(this.f4243a, c1262b0.m3140b(File.class, cls), c1262b0.m3140b(Uri.class, cls), cls);
    }
}
