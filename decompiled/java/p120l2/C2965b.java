package p120l2;

import okhttp3.MediaType;
import p091i9.InterfaceC2713a;
import p103j9.AbstractC2797j;

public final class C2965b extends AbstractC2797j implements InterfaceC2713a {

    public final C2966c f10151a;

    public C2965b(C2966c c2966c) {
        super(0);
        this.f10151a = c2966c;
    }

    @Override
    public final Object invoke() {
        String str = this.f10151a.f10157f.get("Content-Type");
        if (str != null) {
            return MediaType.Companion.parse(str);
        }
        return null;
    }
}
