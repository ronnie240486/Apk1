package p021b9;

public final class EnumC1367a {

    public static final EnumC1367a f4179a;

    public static final EnumC1367a[] f4180b;

    static {
        EnumC1367a enumC1367a = new EnumC1367a("COROUTINE_SUSPENDED", 0);
        f4179a = enumC1367a;
        f4180b = new EnumC1367a[]{enumC1367a, new EnumC1367a("UNDECIDED", 1), new EnumC1367a("RESUMED", 2)};
    }

    public static EnumC1367a valueOf(String str) {
        return (EnumC1367a) Enum.valueOf(EnumC1367a.class, str);
    }

    public static EnumC1367a[] values() {
        return (EnumC1367a[]) f4180b.clone();
    }
}
