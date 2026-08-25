package p228v2;

public final class EnumC3974a {

    public static final EnumC3974a f13504a;

    public static final EnumC3974a f13505b;

    public static final EnumC3974a f13506c;

    public static final EnumC3974a[] f13507d;

    static {
        EnumC3974a enumC3974a = new EnumC3974a("PREFER_ARGB_8888", 0);
        f13504a = enumC3974a;
        EnumC3974a enumC3974a2 = new EnumC3974a("PREFER_RGB_565", 1);
        f13505b = enumC3974a2;
        f13507d = new EnumC3974a[]{enumC3974a, enumC3974a2};
        f13506c = enumC3974a;
    }

    public static EnumC3974a valueOf(String str) {
        return (EnumC3974a) Enum.valueOf(EnumC3974a.class, str);
    }

    public static EnumC3974a[] values() {
        return (EnumC3974a[]) f13507d.clone();
    }
}
