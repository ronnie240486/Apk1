package p020b7;

import androidx.media3.exoplayer.analytics.C0709z;

public final class C1343g0 implements InterfaceC1339e0 {

    public static final C0709z f4161d = new C0709z(1);

    public final Object f4162a = new Object();

    public volatile InterfaceC1339e0 f4163b;

    public Object f4164c;

    public C1343g0(InterfaceC1339e0 interfaceC1339e0) {
        this.f4163b = interfaceC1339e0;
    }

    @Override
    public final Object get() {
        InterfaceC1339e0 interfaceC1339e0 = this.f4163b;
        C0709z c0709z = f4161d;
        if (interfaceC1339e0 != c0709z) {
            synchronized (this.f4162a) {
                try {
                    if (this.f4163b != c0709z) {
                        Object obj = this.f4163b.get();
                        this.f4164c = obj;
                        this.f4163b = c0709z;
                        return obj;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f4164c;
    }

    public final String toString() {
        Object obj = this.f4163b;
        StringBuilder sb = new StringBuilder("Suppliers.memoize(");
        if (obj == f4161d) {
            obj = "<supplier that returned " + this.f4164c + ">";
        }
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }
}
