package com.bumptech.glide;

public final class EnumC1469g {

    public static final EnumC1469g f4441a;

    public static final EnumC1469g f4442b;

    public static final EnumC1469g f4443c;

    public static final EnumC1469g f4444d;

    public static final EnumC1469g[] f4445e;

    static {
        EnumC1469g enumC1469g = new EnumC1469g("IMMEDIATE", 0);
        f4441a = enumC1469g;
        EnumC1469g enumC1469g2 = new EnumC1469g("HIGH", 1);
        f4442b = enumC1469g2;
        EnumC1469g enumC1469g3 = new EnumC1469g("NORMAL", 2);
        f4443c = enumC1469g3;
        EnumC1469g enumC1469g4 = new EnumC1469g("LOW", 3);
        f4444d = enumC1469g4;
        f4445e = new EnumC1469g[]{enumC1469g, enumC1469g2, enumC1469g3, enumC1469g4};
    }

    public static EnumC1469g valueOf(String str) {
        return (EnumC1469g) Enum.valueOf(EnumC1469g.class, str);
    }

    public static EnumC1469g[] values() {
        return (EnumC1469g[]) f4445e.clone();
    }
}
