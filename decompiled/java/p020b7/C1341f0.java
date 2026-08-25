package p020b7;

import java.io.Serializable;

public final class C1341f0 implements InterfaceC1339e0, Serializable {

    public final transient Object f4156a = new Object();

    public final InterfaceC1339e0 f4157b;

    public volatile transient boolean f4158c;

    public transient Object f4159d;

    public C1341f0(InterfaceC1339e0 interfaceC1339e0) {
        this.f4157b = interfaceC1339e0;
    }

    @Override
    public final Object get() {
        if (!this.f4158c) {
            synchronized (this.f4156a) {
                try {
                    if (!this.f4158c) {
                        Object obj = this.f4157b.get();
                        this.f4159d = obj;
                        this.f4158c = true;
                        return obj;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f4159d;
    }

    public final String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder("Suppliers.memoize(");
        if (this.f4158c) {
            obj = "<supplier that returned " + this.f4159d + ">";
        } else {
            obj = this.f4157b;
        }
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }
}
