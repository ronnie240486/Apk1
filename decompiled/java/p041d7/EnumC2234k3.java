package p041d7;

import p020b7.AbstractC1344h;

public abstract class EnumC2234k3 {

    public static final C2220i3 f7974a;

    public static final C2227j3 f7975b;

    public static final EnumC2234k3[] f7976c;

    static {
        C2220i3 c2220i3 = new C2220i3();
        f7974a = c2220i3;
        C2227j3 c2227j3 = new C2227j3();
        f7975b = c2227j3;
        f7976c = new EnumC2234k3[]{c2220i3, c2227j3};
    }

    public static EnumC2234k3 valueOf(String str) {
        return (EnumC2234k3) Enum.valueOf(EnumC2234k3.class, str);
    }

    public static EnumC2234k3[] values() {
        return (EnumC2234k3[]) f7976c.clone();
    }

    public abstract AbstractC1344h mo5220a();
}
