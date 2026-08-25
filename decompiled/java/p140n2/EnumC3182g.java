package p140n2;

public final class EnumC3182g {

    public static final EnumC3182g f10674a;

    public static final EnumC3182g f10675b;

    public static final EnumC3182g[] f10676c;

    static {
        EnumC3182g enumC3182g = new EnumC3182g("FILL", 0);
        f10674a = enumC3182g;
        EnumC3182g enumC3182g2 = new EnumC3182g("FIT", 1);
        f10675b = enumC3182g2;
        f10676c = new EnumC3182g[]{enumC3182g, enumC3182g2};
    }

    public static EnumC3182g valueOf(String str) {
        return (EnumC3182g) Enum.valueOf(EnumC3182g.class, str);
    }

    public static EnumC3182g[] values() {
        return (EnumC3182g[]) f10676c.clone();
    }
}
