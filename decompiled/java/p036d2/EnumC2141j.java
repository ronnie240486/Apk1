package p036d2;

public final class EnumC2141j {

    public static final EnumC2141j f7773a;

    public static final EnumC2141j[] f7774b;

    EnumC2141j EF3;

    static {
        EnumC2141j enumC2141j = new EnumC2141j("IGNORE", 0);
        EnumC2141j enumC2141j2 = new EnumC2141j("RESPECT_PERFORMANCE", 1);
        f7773a = enumC2141j2;
        f7774b = new EnumC2141j[]{enumC2141j, enumC2141j2, new EnumC2141j("RESPECT_ALL", 2)};
    }

    public static EnumC2141j valueOf(String str) {
        return (EnumC2141j) Enum.valueOf(EnumC2141j.class, str);
    }

    public static EnumC2141j[] values() {
        return (EnumC2141j[]) f7774b.clone();
    }
}
