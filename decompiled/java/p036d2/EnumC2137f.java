package p036d2;

public final class EnumC2137f {

    public static final EnumC2137f f7760a;

    public static final EnumC2137f f7761b;

    public static final EnumC2137f f7762c;

    public static final EnumC2137f f7763d;

    public static final EnumC2137f[] f7764e;

    static {
        EnumC2137f enumC2137f = new EnumC2137f("MEMORY_CACHE", 0);
        f7760a = enumC2137f;
        EnumC2137f enumC2137f2 = new EnumC2137f("MEMORY", 1);
        f7761b = enumC2137f2;
        EnumC2137f enumC2137f3 = new EnumC2137f("DISK", 2);
        f7762c = enumC2137f3;
        EnumC2137f enumC2137f4 = new EnumC2137f("NETWORK", 3);
        f7763d = enumC2137f4;
        f7764e = new EnumC2137f[]{enumC2137f, enumC2137f2, enumC2137f3, enumC2137f4};
    }

    public static EnumC2137f valueOf(String str) {
        return (EnumC2137f) Enum.valueOf(EnumC2137f.class, str);
    }

    public static EnumC2137f[] values() {
        return (EnumC2137f[]) f7764e.clone();
    }
}
