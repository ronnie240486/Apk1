package p218u2;

import okhttp3.OkHttpClient;
import p016b3.C1262b0;
import p016b3.InterfaceC1288u;
import p016b3.InterfaceC1289v;

public final class C3891b implements InterfaceC1289v {

    public static volatile OkHttpClient f13082b;

    public final OkHttpClient f13083a;

    public C3891b(OkHttpClient okHttpClient) {
        this.f13083a = okHttpClient;
    }

    @Override
    public final InterfaceC1288u mo3136a(C1262b0 c1262b0) {
        return new C3892c(this.f13083a);
    }
}
