package p055ea;

import p003a2.AbstractC0032a;

public final class EnumC2438f {

    public static final EnumC2438f f8547a;

    public static final EnumC2438f f8548b;

    public static final EnumC2438f[] f8549c;

    static {
        EnumC2438f enumC2438f = new EnumC2438f(AbstractC0032a.m165s("amHIBQ==\n", "J1KdPdptvVo=\n"), 0);
        f8547a = enumC2438f;
        EnumC2438f enumC2438f2 = new EnumC2438f(AbstractC0032a.m165s("zbI=\n", "meFN4oMiMro=\n"), 1);
        f8548b = enumC2438f2;
        f8549c = new EnumC2438f[]{enumC2438f, enumC2438f2};
    }

    public static EnumC2438f valueOf(String str) {
        return (EnumC2438f) Enum.valueOf(EnumC2438f.class, str);
    }

    public static EnumC2438f[] values() {
        return (EnumC2438f[]) f8549c.clone();
    }
}
