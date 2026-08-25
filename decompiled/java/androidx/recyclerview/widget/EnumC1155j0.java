package androidx.recyclerview.widget;

public final class EnumC1155j0 {

    public static final EnumC1155j0 f3597a;

    public static final EnumC1155j0[] f3598b;

    static {
        EnumC1155j0 enumC1155j0 = new EnumC1155j0("ALLOW", 0);
        f3597a = enumC1155j0;
        f3598b = new EnumC1155j0[]{enumC1155j0, new EnumC1155j0("PREVENT_WHEN_EMPTY", 1), new EnumC1155j0("PREVENT", 2)};
    }

    public static EnumC1155j0 valueOf(String str) {
        return (EnumC1155j0) Enum.valueOf(EnumC1155j0.class, str);
    }

    public static EnumC1155j0[] values() {
        return (EnumC1155j0[]) f3598b.clone();
    }
}
