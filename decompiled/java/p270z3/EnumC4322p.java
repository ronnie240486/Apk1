package p270z3;

public final class EnumC4322p {

    public static final EnumC4322p f14677a;

    public static final EnumC4322p[] f14678b;

    EnumC4322p EF2;

    static {
        EnumC4322p enumC4322p = new EnumC4322p("UNKNOWN", 0);
        EnumC4322p enumC4322p2 = new EnumC4322p("ANDROID_FIREBASE", 1);
        f14677a = enumC4322p2;
        f14678b = new EnumC4322p[]{enumC4322p, enumC4322p2};
    }

    public static EnumC4322p valueOf(String str) {
        return (EnumC4322p) Enum.valueOf(EnumC4322p.class, str);
    }

    public static EnumC4322p[] values() {
        return (EnumC4322p[]) f14678b.clone();
    }
}
