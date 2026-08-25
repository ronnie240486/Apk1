package p228v2;

public final class EnumC3982i {

    public static final EnumC3982i f13516a;

    public static final EnumC3982i[] f13517b;

    EnumC3982i EF2;

    static {
        EnumC3982i enumC3982i = new EnumC3982i("SRGB", 0);
        EnumC3982i enumC3982i2 = new EnumC3982i("DISPLAY_P3", 1);
        f13516a = enumC3982i2;
        f13517b = new EnumC3982i[]{enumC3982i, enumC3982i2};
    }

    public static EnumC3982i valueOf(String str) {
        return (EnumC3982i) Enum.valueOf(EnumC3982i.class, str);
    }

    public static EnumC3982i[] values() {
        return (EnumC3982i[]) f13517b.clone();
    }
}
