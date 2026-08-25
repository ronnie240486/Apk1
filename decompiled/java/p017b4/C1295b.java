package p017b4;

import android.content.Context;
import p000a.AbstractC0004e;
import p110k4.InterfaceC2890a;

public final class C1295b extends AbstractC1296c {

    public final Context f4068a;

    public final InterfaceC2890a f4069b;

    public final InterfaceC2890a f4070c;

    public final String f4071d;

    public C1295b(Context context, InterfaceC2890a interfaceC2890a, InterfaceC2890a interfaceC2890a2, String str) {
        if (context == null) {
            throw new NullPointerException("Null applicationContext");
        }
        this.f4068a = context;
        if (interfaceC2890a == null) {
            throw new NullPointerException("Null wallClock");
        }
        this.f4069b = interfaceC2890a;
        if (interfaceC2890a2 == null) {
            throw new NullPointerException("Null monotonicClock");
        }
        this.f4070c = interfaceC2890a2;
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        this.f4071d = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC1296c)) {
            return false;
        }
        AbstractC1296c abstractC1296c = (AbstractC1296c) obj;
        if (this.f4068a.equals(((C1295b) abstractC1296c).f4068a)) {
            C1295b c1295b = (C1295b) abstractC1296c;
            if (this.f4069b.equals(c1295b.f4069b) && this.f4070c.equals(c1295b.f4070c) && this.f4071d.equals(c1295b.f4071d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.f4068a.hashCode() ^ 1000003) * 1000003) ^ this.f4069b.hashCode()) * 1000003) ^ this.f4070c.hashCode()) * 1000003) ^ this.f4071d.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CreationContext{applicationContext=");
        sb.append(this.f4068a);
        sb.append(", wallClock=");
        sb.append(this.f4069b);
        sb.append(", monotonicClock=");
        sb.append(this.f4070c);
        sb.append(", backendName=");
        return AbstractC0004e.m26t(sb, this.f4071d, "}");
    }
}
