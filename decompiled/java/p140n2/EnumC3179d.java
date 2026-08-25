package p140n2;

public final class EnumC3179d {

    public static final EnumC3179d f10670a;

    public static final EnumC3179d[] f10671b;

    EnumC3179d EF3;

    static {
        EnumC3179d enumC3179d = new EnumC3179d("EXACT", 0);
        EnumC3179d enumC3179d2 = new EnumC3179d("INEXACT", 1);
        EnumC3179d enumC3179d3 = new EnumC3179d("AUTOMATIC", 2);
        f10670a = enumC3179d3;
        f10671b = new EnumC3179d[]{enumC3179d, enumC3179d2, enumC3179d3};
    }

    public static EnumC3179d valueOf(String str) {
        return (EnumC3179d) Enum.valueOf(EnumC3179d.class, str);
    }

    public static EnumC3179d[] values() {
        return (EnumC3179d[]) f10671b.clone();
    }
}
