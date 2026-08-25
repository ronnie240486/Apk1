package p225v;

public final class EnumC3957d {

    public static final EnumC3957d f13319a;

    public static final EnumC3957d f13320b;

    public static final EnumC3957d f13321c;

    public static final EnumC3957d f13322d;

    public static final EnumC3957d[] f13323e;

    static {
        EnumC3957d enumC3957d = new EnumC3957d("FIXED", 0);
        f13319a = enumC3957d;
        EnumC3957d enumC3957d2 = new EnumC3957d("WRAP_CONTENT", 1);
        f13320b = enumC3957d2;
        EnumC3957d enumC3957d3 = new EnumC3957d("MATCH_CONSTRAINT", 2);
        f13321c = enumC3957d3;
        EnumC3957d enumC3957d4 = new EnumC3957d("MATCH_PARENT", 3);
        f13322d = enumC3957d4;
        f13323e = new EnumC3957d[]{enumC3957d, enumC3957d2, enumC3957d3, enumC3957d4};
    }

    public static EnumC3957d valueOf(String str) {
        return (EnumC3957d) Enum.valueOf(EnumC3957d.class, str);
    }

    public static EnumC3957d[] values() {
        return (EnumC3957d[]) f13323e.clone();
    }
}
