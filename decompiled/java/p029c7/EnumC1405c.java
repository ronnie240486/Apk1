package p029c7;

public final class EnumC1405c {

    public static final EnumC1405c f4292a;

    public static final EnumC1405c[] f4293b;

    static {
        EnumC1405c enumC1405c = new EnumC1405c("INSTANCE", 0);
        f4292a = enumC1405c;
        f4293b = new EnumC1405c[]{enumC1405c};
    }

    public static EnumC1405c valueOf(String str) {
        return (EnumC1405c) Enum.valueOf(EnumC1405c.class, str);
    }

    public static EnumC1405c[] values() {
        return (EnumC1405c[]) f4293b.clone();
    }
}
