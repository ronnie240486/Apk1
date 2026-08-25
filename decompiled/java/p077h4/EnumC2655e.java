package p077h4;

public final class EnumC2655e {

    public static final EnumC2655e f9262a;

    public static final EnumC2655e f9263b;

    public static final EnumC2655e f9264c;

    public static final EnumC2655e[] f9265d;

    static {
        EnumC2655e enumC2655e = new EnumC2655e("NETWORK_UNMETERED", 0);
        f9262a = enumC2655e;
        EnumC2655e enumC2655e2 = new EnumC2655e("DEVICE_IDLE", 1);
        f9263b = enumC2655e2;
        EnumC2655e enumC2655e3 = new EnumC2655e("DEVICE_CHARGING", 2);
        f9264c = enumC2655e3;
        f9265d = new EnumC2655e[]{enumC2655e, enumC2655e2, enumC2655e3};
    }

    public static EnumC2655e valueOf(String str) {
        return (EnumC2655e) Enum.valueOf(EnumC2655e.class, str);
    }

    public static EnumC2655e[] values() {
        return (EnumC2655e[]) f9265d.clone();
    }
}
