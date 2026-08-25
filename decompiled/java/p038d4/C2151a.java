package p038d4;

import p027c4.InterfaceC1397a;
import p234v8.InterfaceC4022a;

public final class C2151a implements InterfaceC4022a, InterfaceC1397a {

    public static final Object f7795c = new Object();

    public volatile InterfaceC2152b f7796a;

    public volatile Object f7797b = f7795c;

    public C2151a(InterfaceC2152b interfaceC2152b) {
        this.f7796a = interfaceC2152b;
    }

    public static InterfaceC4022a m5087a(InterfaceC2152b interfaceC2152b) {
        return interfaceC2152b instanceof C2151a ? interfaceC2152b : new C2151a(interfaceC2152b);
    }

    @Override
    public final Object get() {
        Object obj = this.f7797b;
        Object obj2 = f7795c;
        if (obj == obj2) {
            synchronized (this) {
                try {
                    obj = this.f7797b;
                    if (obj == obj2) {
                        obj = this.f7796a.get();
                        Object obj3 = this.f7797b;
                        if (obj3 != obj2 && obj3 != obj) {
                            throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj3 + " & " + obj + ". This is likely due to a circular dependency.");
                        }
                        this.f7797b = obj;
                        this.f7796a = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return obj;
    }
}
