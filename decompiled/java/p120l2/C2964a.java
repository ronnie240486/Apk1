package p120l2;

import okhttp3.CacheControl;
import p091i9.InterfaceC2713a;
import p103j9.AbstractC2797j;

public final class C2964a extends AbstractC2797j implements InterfaceC2713a {

    public final C2966c f10150a;

    public C2964a(C2966c c2966c) {
        super(0);
        this.f10150a = c2966c;
    }

    @Override
    public final Object invoke() {
        return CacheControl.Companion.parse(this.f10150a.f10157f);
    }
}
