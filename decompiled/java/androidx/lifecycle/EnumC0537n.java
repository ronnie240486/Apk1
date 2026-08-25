package androidx.lifecycle;

public final class EnumC0537n {
    private static final EnumC0537n[] $VALUES;
    public static final C0533l Companion;
    public static final EnumC0537n ON_ANY;
    public static final EnumC0537n ON_CREATE;
    public static final EnumC0537n ON_DESTROY;
    public static final EnumC0537n ON_PAUSE;
    public static final EnumC0537n ON_RESUME;
    public static final EnumC0537n ON_START;
    public static final EnumC0537n ON_STOP;

    static {
        EnumC0537n enumC0537n = new EnumC0537n("ON_CREATE", 0);
        ON_CREATE = enumC0537n;
        EnumC0537n enumC0537n2 = new EnumC0537n("ON_START", 1);
        ON_START = enumC0537n2;
        EnumC0537n enumC0537n3 = new EnumC0537n("ON_RESUME", 2);
        ON_RESUME = enumC0537n3;
        EnumC0537n enumC0537n4 = new EnumC0537n("ON_PAUSE", 3);
        ON_PAUSE = enumC0537n4;
        EnumC0537n enumC0537n5 = new EnumC0537n("ON_STOP", 4);
        ON_STOP = enumC0537n5;
        EnumC0537n enumC0537n6 = new EnumC0537n("ON_DESTROY", 5);
        ON_DESTROY = enumC0537n6;
        EnumC0537n enumC0537n7 = new EnumC0537n("ON_ANY", 6);
        ON_ANY = enumC0537n7;
        $VALUES = new EnumC0537n[]{enumC0537n, enumC0537n2, enumC0537n3, enumC0537n4, enumC0537n5, enumC0537n6, enumC0537n7};
        Companion = new C0533l();
    }

    public static EnumC0537n valueOf(String str) {
        return (EnumC0537n) Enum.valueOf(EnumC0537n.class, str);
    }

    public static EnumC0537n[] values() {
        return (EnumC0537n[]) $VALUES.clone();
    }

    public final EnumC0539o m1501a() {
        switch (AbstractC0535m.f2497a[ordinal()]) {
            case 1:
            case 2:
                return EnumC0539o.f2509c;
            case 3:
            case 4:
                return EnumC0539o.f2510d;
            case 5:
                return EnumC0539o.f2511e;
            case 6:
                return EnumC0539o.f2507a;
            default:
                throw new IllegalArgumentException(this + " has no target state");
        }
    }
}
