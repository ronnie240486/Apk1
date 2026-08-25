package p029c7;

public final class EnumC1403b {

    public static final EnumC1403b f4270a;

    public static final EnumC1403b[] f4271b;

    static {
        EnumC1403b enumC1403b = new EnumC1403b("INSTANCE", 0);
        f4270a = enumC1403b;
        f4271b = new EnumC1403b[]{enumC1403b};
    }

    public static EnumC1403b valueOf(String str) {
        return (EnumC1403b) Enum.valueOf(EnumC1403b.class, str);
    }

    public static EnumC1403b[] values() {
        return (EnumC1403b[]) f4271b.clone();
    }
}
