package p042d8;

public final class EnumC2336b {

    public static final EnumC2336b f8126a;

    public static final EnumC2336b f8127b;

    public static final EnumC2336b f8128c;

    public static final EnumC2336b f8129d;

    public static final EnumC2336b f8130e;

    public static final EnumC2336b f8131f;

    public static final EnumC2336b f8132g;

    public static final EnumC2336b f8133h;

    public static final EnumC2336b f8134i;

    public static final EnumC2336b f8135j;

    public static final EnumC2336b[] f8136k;

    static {
        EnumC2336b enumC2336b = new EnumC2336b("ATTACH", 0);
        f8126a = enumC2336b;
        EnumC2336b enumC2336b2 = new EnumC2336b("CREATE", 1);
        f8127b = enumC2336b2;
        EnumC2336b enumC2336b3 = new EnumC2336b("CREATE_VIEW", 2);
        f8128c = enumC2336b3;
        EnumC2336b enumC2336b4 = new EnumC2336b("START", 3);
        f8129d = enumC2336b4;
        EnumC2336b enumC2336b5 = new EnumC2336b("RESUME", 4);
        f8130e = enumC2336b5;
        EnumC2336b enumC2336b6 = new EnumC2336b("PAUSE", 5);
        f8131f = enumC2336b6;
        EnumC2336b enumC2336b7 = new EnumC2336b("STOP", 6);
        f8132g = enumC2336b7;
        EnumC2336b enumC2336b8 = new EnumC2336b("DESTROY_VIEW", 7);
        f8133h = enumC2336b8;
        EnumC2336b enumC2336b9 = new EnumC2336b("DESTROY", 8);
        f8134i = enumC2336b9;
        EnumC2336b enumC2336b10 = new EnumC2336b("DETACH", 9);
        f8135j = enumC2336b10;
        f8136k = new EnumC2336b[]{enumC2336b, enumC2336b2, enumC2336b3, enumC2336b4, enumC2336b5, enumC2336b6, enumC2336b7, enumC2336b8, enumC2336b9, enumC2336b10};
    }

    public static EnumC2336b valueOf(String str) {
        return (EnumC2336b) Enum.valueOf(EnumC2336b.class, str);
    }

    public static EnumC2336b[] values() {
        return (EnumC2336b[]) f8136k.clone();
    }
}
