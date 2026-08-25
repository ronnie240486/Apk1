package p248x3;

public final class EnumC4107c {

    public static final EnumC4107c f13925a;

    public static final EnumC4107c f13926b;

    public static final EnumC4107c f13927c;

    public static final EnumC4107c[] f13928d;

    static {
        EnumC4107c enumC4107c = new EnumC4107c("DEFAULT", 0);
        f13925a = enumC4107c;
        EnumC4107c enumC4107c2 = new EnumC4107c("VERY_LOW", 1);
        f13926b = enumC4107c2;
        EnumC4107c enumC4107c3 = new EnumC4107c("HIGHEST", 2);
        f13927c = enumC4107c3;
        f13928d = new EnumC4107c[]{enumC4107c, enumC4107c2, enumC4107c3};
    }

    public static EnumC4107c valueOf(String str) {
        return (EnumC4107c) Enum.valueOf(EnumC4107c.class, str);
    }

    public static EnumC4107c[] values() {
        return (EnumC4107c[]) f13928d.clone();
    }
}
