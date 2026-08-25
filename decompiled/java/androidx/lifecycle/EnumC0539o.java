package androidx.lifecycle;

public final class EnumC0539o {

    public static final EnumC0539o f2507a;

    public static final EnumC0539o f2508b;

    public static final EnumC0539o f2509c;

    public static final EnumC0539o f2510d;

    public static final EnumC0539o f2511e;

    public static final EnumC0539o[] f2512f;

    static {
        EnumC0539o enumC0539o = new EnumC0539o("DESTROYED", 0);
        f2507a = enumC0539o;
        EnumC0539o enumC0539o2 = new EnumC0539o("INITIALIZED", 1);
        f2508b = enumC0539o2;
        EnumC0539o enumC0539o3 = new EnumC0539o("CREATED", 2);
        f2509c = enumC0539o3;
        EnumC0539o enumC0539o4 = new EnumC0539o("STARTED", 3);
        f2510d = enumC0539o4;
        EnumC0539o enumC0539o5 = new EnumC0539o("RESUMED", 4);
        f2511e = enumC0539o5;
        f2512f = new EnumC0539o[]{enumC0539o, enumC0539o2, enumC0539o3, enumC0539o4, enumC0539o5};
    }

    public static EnumC0539o valueOf(String str) {
        return (EnumC0539o) Enum.valueOf(EnumC0539o.class, str);
    }

    public static EnumC0539o[] values() {
        return (EnumC0539o[]) f2512f.clone();
    }
}
