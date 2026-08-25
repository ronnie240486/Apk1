package p042d8;

public final class EnumC2335a {

    public static final EnumC2335a f8119a;

    public static final EnumC2335a f8120b;

    public static final EnumC2335a f8121c;

    public static final EnumC2335a f8122d;

    public static final EnumC2335a f8123e;

    public static final EnumC2335a f8124f;

    public static final EnumC2335a[] f8125g;

    static {
        EnumC2335a enumC2335a = new EnumC2335a("CREATE", 0);
        f8119a = enumC2335a;
        EnumC2335a enumC2335a2 = new EnumC2335a("START", 1);
        f8120b = enumC2335a2;
        EnumC2335a enumC2335a3 = new EnumC2335a("RESUME", 2);
        f8121c = enumC2335a3;
        EnumC2335a enumC2335a4 = new EnumC2335a("PAUSE", 3);
        f8122d = enumC2335a4;
        EnumC2335a enumC2335a5 = new EnumC2335a("STOP", 4);
        f8123e = enumC2335a5;
        EnumC2335a enumC2335a6 = new EnumC2335a("DESTROY", 5);
        f8124f = enumC2335a6;
        f8125g = new EnumC2335a[]{enumC2335a, enumC2335a2, enumC2335a3, enumC2335a4, enumC2335a5, enumC2335a6};
    }

    public static EnumC2335a valueOf(String str) {
        return (EnumC2335a) Enum.valueOf(EnumC2335a.class, str);
    }

    public static EnumC2335a[] values() {
        return (EnumC2335a[]) f8125g.clone();
    }
}
