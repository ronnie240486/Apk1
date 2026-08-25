package p113k7;

public final class EnumC2896c {

    public static final EnumC2896c f9838a;

    public static final EnumC2896c[] f9839b;

    static {
        EnumC2896c enumC2896c = new EnumC2896c("DEFAULT", 0);
        f9838a = enumC2896c;
        f9839b = new EnumC2896c[]{enumC2896c, new EnumC2896c("SIGNED", 1), new EnumC2896c("FIXED", 2)};
    }

    public static EnumC2896c valueOf(String str) {
        return (EnumC2896c) Enum.valueOf(EnumC2896c.class, str);
    }

    public static EnumC2896c[] values() {
        return (EnumC2896c[]) f9839b.clone();
    }
}
