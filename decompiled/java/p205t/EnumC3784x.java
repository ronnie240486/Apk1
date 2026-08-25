package p205t;

public final class EnumC3784x {

    public static final EnumC3784x f12729a;

    public static final EnumC3784x f12730b;

    public static final EnumC3784x f12731c;

    public static final EnumC3784x f12732d;

    public static final EnumC3784x[] f12733e;

    static {
        EnumC3784x enumC3784x = new EnumC3784x("UNDEFINED", 0);
        f12729a = enumC3784x;
        EnumC3784x enumC3784x2 = new EnumC3784x("SETUP", 1);
        f12730b = enumC3784x2;
        EnumC3784x enumC3784x3 = new EnumC3784x("MOVING", 2);
        f12731c = enumC3784x3;
        EnumC3784x enumC3784x4 = new EnumC3784x("FINISHED", 3);
        f12732d = enumC3784x4;
        f12733e = new EnumC3784x[]{enumC3784x, enumC3784x2, enumC3784x3, enumC3784x4};
    }

    public static EnumC3784x valueOf(String str) {
        return (EnumC3784x) Enum.valueOf(EnumC3784x.class, str);
    }

    public static EnumC3784x[] values() {
        return (EnumC3784x[]) f12733e.clone();
    }
}
