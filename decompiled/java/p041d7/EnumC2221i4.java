package p041d7;

import p020b7.InterfaceC1346i;

public abstract class EnumC2221i4 implements InterfaceC1346i {

    public static final C2207g4 f7943a;

    public static final C2214h4 f7944b;

    public static final EnumC2221i4[] f7945c;

    static {
        C2207g4 c2207g4 = new C2207g4();
        f7943a = c2207g4;
        C2214h4 c2214h4 = new C2214h4();
        f7944b = c2214h4;
        f7945c = new EnumC2221i4[]{c2207g4, c2214h4};
    }

    public static EnumC2221i4 valueOf(String str) {
        return (EnumC2221i4) Enum.valueOf(EnumC2221i4.class, str);
    }

    public static EnumC2221i4[] values() {
        return (EnumC2221i4[]) f7945c.clone();
    }
}
