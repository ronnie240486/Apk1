package p218u2;

import okhttp3.OkHttpClient;
import p016b3.C1278k;
import p016b3.C1287t;
import p016b3.InterfaceC1288u;
import p228v2.C3981h;

public final class C3892c implements InterfaceC1288u {

    public final OkHttpClient f13084a;

    public C3892c(OkHttpClient okHttpClient) {
        this.f13084a = okHttpClient;
    }

    @Override
    public final C1287t mo3137a(Object obj, int i6, int i10, C3981h c3981h) {
        C1278k c1278k = (C1278k) obj;
        return new C1287t(c1278k, new C3890a(this.f13084a, c1278k));
    }

    @Override
    public final boolean mo3138b(Object obj) {
        return true;
    }
}
