package com.google.android.gms.internal.cast;

public final class EnumC1569g7 {

    public static final EnumC1569g7 f5324b;

    public static final EnumC1569g7 f5325c;

    public static final EnumC1569g7[] f5326d;

    public static final EnumC1569g7[] f5327e;

    public final int f5328a;

    EnumC1569g7 EF6;

    static {
        EnumC1648o7 enumC1648o7 = EnumC1648o7.f5521e;
        EnumC1569g7 enumC1569g7 = new EnumC1569g7("DOUBLE", 0, 0, 1, enumC1648o7);
        EnumC1648o7 enumC1648o8 = EnumC1648o7.f5520d;
        EnumC1569g7 enumC1569g8 = new EnumC1569g7("FLOAT", 1, 1, 1, enumC1648o8);
        EnumC1648o7 enumC1648o9 = EnumC1648o7.f5519c;
        EnumC1569g7 enumC1569g9 = new EnumC1569g7("INT64", 2, 2, 1, enumC1648o9);
        EnumC1569g7 enumC1569g10 = new EnumC1569g7("UINT64", 3, 3, 1, enumC1648o9);
        EnumC1648o7 enumC1648o10 = EnumC1648o7.f5518b;
        EnumC1569g7 enumC1569g11 = new EnumC1569g7("INT32", 4, 4, 1, enumC1648o10);
        EnumC1569g7 enumC1569g12 = new EnumC1569g7("FIXED64", 5, 5, 1, enumC1648o9);
        EnumC1569g7 enumC1569g13 = new EnumC1569g7("FIXED32", 6, 6, 1, enumC1648o10);
        EnumC1648o7 enumC1648o11 = EnumC1648o7.f5522f;
        EnumC1569g7 enumC1569g14 = new EnumC1569g7("BOOL", 7, 7, 1, enumC1648o11);
        EnumC1648o7 enumC1648o12 = EnumC1648o7.f5523g;
        EnumC1569g7 enumC1569g15 = new EnumC1569g7("STRING", 8, 8, 1, enumC1648o12);
        EnumC1648o7 enumC1648o13 = EnumC1648o7.f5526j;
        EnumC1569g7 enumC1569g16 = new EnumC1569g7("MESSAGE", 9, 9, 1, enumC1648o13);
        EnumC1648o7 enumC1648o14 = EnumC1648o7.f5524h;
        EnumC1569g7 enumC1569g17 = new EnumC1569g7("BYTES", 10, 10, 1, enumC1648o14);
        EnumC1569g7 enumC1569g18 = new EnumC1569g7("UINT32", 11, 11, 1, enumC1648o10);
        EnumC1648o7 enumC1648o15 = EnumC1648o7.f5525i;
        EnumC1569g7 enumC1569g19 = new EnumC1569g7("ENUM", 12, 12, 1, enumC1648o15);
        EnumC1569g7 enumC1569g20 = new EnumC1569g7("SFIXED32", 13, 13, 1, enumC1648o10);
        EnumC1569g7 enumC1569g21 = new EnumC1569g7("SFIXED64", 14, 14, 1, enumC1648o9);
        EnumC1569g7 enumC1569g22 = new EnumC1569g7("SINT32", 15, 15, 1, enumC1648o10);
        EnumC1569g7 enumC1569g23 = new EnumC1569g7("SINT64", 16, 16, 1, enumC1648o9);
        EnumC1569g7 enumC1569g24 = new EnumC1569g7("GROUP", 17, 17, 1, enumC1648o13);
        EnumC1569g7 enumC1569g25 = new EnumC1569g7("DOUBLE_LIST", 18, 18, 2, enumC1648o7);
        EnumC1569g7 enumC1569g26 = new EnumC1569g7("FLOAT_LIST", 19, 19, 2, enumC1648o8);
        EnumC1569g7 enumC1569g27 = new EnumC1569g7("INT64_LIST", 20, 20, 2, enumC1648o9);
        EnumC1569g7 enumC1569g28 = new EnumC1569g7("UINT64_LIST", 21, 21, 2, enumC1648o9);
        EnumC1569g7 enumC1569g29 = new EnumC1569g7("INT32_LIST", 22, 22, 2, enumC1648o10);
        EnumC1569g7 enumC1569g30 = new EnumC1569g7("FIXED64_LIST", 23, 23, 2, enumC1648o9);
        EnumC1569g7 enumC1569g31 = new EnumC1569g7("FIXED32_LIST", 24, 24, 2, enumC1648o10);
        EnumC1569g7 enumC1569g32 = new EnumC1569g7("BOOL_LIST", 25, 25, 2, enumC1648o11);
        EnumC1569g7 enumC1569g33 = new EnumC1569g7("STRING_LIST", 26, 26, 2, enumC1648o12);
        EnumC1569g7 enumC1569g34 = new EnumC1569g7("MESSAGE_LIST", 27, 27, 2, enumC1648o13);
        EnumC1569g7 enumC1569g35 = new EnumC1569g7("BYTES_LIST", 28, 28, 2, enumC1648o14);
        EnumC1569g7 enumC1569g36 = new EnumC1569g7("UINT32_LIST", 29, 29, 2, enumC1648o10);
        EnumC1569g7 enumC1569g37 = new EnumC1569g7("ENUM_LIST", 30, 30, 2, enumC1648o15);
        EnumC1569g7 enumC1569g38 = new EnumC1569g7("SFIXED32_LIST", 31, 31, 2, enumC1648o10);
        EnumC1569g7 enumC1569g39 = new EnumC1569g7("SFIXED64_LIST", 32, 32, 2, enumC1648o9);
        EnumC1569g7 enumC1569g40 = new EnumC1569g7("SINT32_LIST", 33, 33, 2, enumC1648o10);
        EnumC1569g7 enumC1569g41 = new EnumC1569g7("SINT64_LIST", 34, 34, 2, enumC1648o9);
        EnumC1569g7 enumC1569g42 = new EnumC1569g7("DOUBLE_LIST_PACKED", 35, 35, 3, enumC1648o7);
        f5324b = enumC1569g42;
        EnumC1569g7 enumC1569g43 = new EnumC1569g7("FLOAT_LIST_PACKED", 36, 36, 3, enumC1648o8);
        EnumC1569g7 enumC1569g44 = new EnumC1569g7("INT64_LIST_PACKED", 37, 37, 3, enumC1648o9);
        EnumC1569g7 enumC1569g45 = new EnumC1569g7("UINT64_LIST_PACKED", 38, 38, 3, enumC1648o9);
        EnumC1569g7 enumC1569g46 = new EnumC1569g7("INT32_LIST_PACKED", 39, 39, 3, enumC1648o10);
        EnumC1569g7 enumC1569g47 = new EnumC1569g7("FIXED64_LIST_PACKED", 40, 40, 3, enumC1648o9);
        EnumC1569g7 enumC1569g48 = new EnumC1569g7("FIXED32_LIST_PACKED", 41, 41, 3, enumC1648o10);
        EnumC1569g7 enumC1569g49 = new EnumC1569g7("BOOL_LIST_PACKED", 42, 42, 3, enumC1648o11);
        EnumC1569g7 enumC1569g50 = new EnumC1569g7("UINT32_LIST_PACKED", 43, 43, 3, enumC1648o10);
        EnumC1569g7 enumC1569g51 = new EnumC1569g7("ENUM_LIST_PACKED", 44, 44, 3, enumC1648o15);
        EnumC1569g7 enumC1569g52 = new EnumC1569g7("SFIXED32_LIST_PACKED", 45, 45, 3, enumC1648o10);
        EnumC1569g7 enumC1569g53 = new EnumC1569g7("SFIXED64_LIST_PACKED", 46, 46, 3, enumC1648o9);
        EnumC1569g7 enumC1569g54 = new EnumC1569g7("SINT32_LIST_PACKED", 47, 47, 3, enumC1648o10);
        EnumC1569g7 enumC1569g55 = new EnumC1569g7("SINT64_LIST_PACKED", 48, 48, 3, enumC1648o9);
        f5325c = enumC1569g55;
        f5327e = new EnumC1569g7[]{enumC1569g7, enumC1569g8, enumC1569g9, enumC1569g10, enumC1569g11, enumC1569g12, enumC1569g13, enumC1569g14, enumC1569g15, enumC1569g16, enumC1569g17, enumC1569g18, enumC1569g19, enumC1569g20, enumC1569g21, enumC1569g22, enumC1569g23, enumC1569g24, enumC1569g25, enumC1569g26, enumC1569g27, enumC1569g28, enumC1569g29, enumC1569g30, enumC1569g31, enumC1569g32, enumC1569g33, enumC1569g34, enumC1569g35, enumC1569g36, enumC1569g37, enumC1569g38, enumC1569g39, enumC1569g40, enumC1569g41, enumC1569g42, enumC1569g43, enumC1569g44, enumC1569g45, enumC1569g46, enumC1569g47, enumC1569g48, enumC1569g49, enumC1569g50, enumC1569g51, enumC1569g52, enumC1569g53, enumC1569g54, enumC1569g55, new EnumC1569g7("GROUP_LIST", 49, 49, 2, enumC1648o13), new EnumC1569g7("MAP", 50, 50, 4, EnumC1648o7.f5517a)};
        EnumC1569g7[] enumC1569g7ArrValues = values();
        f5326d = new EnumC1569g7[enumC1569g7ArrValues.length];
        for (EnumC1569g7 enumC1569g56 : enumC1569g7ArrValues) {
            f5326d[enumC1569g56.f5328a] = enumC1569g56;
        }
    }

    public EnumC1569g7(String str, int i6, int i10, int i11, EnumC1648o7 enumC1648o7) {
        super(str, i6);
        this.f5328a = i10;
        int i12 = i11 - 1;
        if (i12 == 1 || i12 == 3) {
            enumC1648o7.getClass();
        }
        if (i11 == 1) {
            EnumC1648o7 enumC1648o8 = EnumC1648o7.f5517a;
            enumC1648o7.ordinal();
        }
    }

    public static EnumC1569g7[] values() {
        return (EnumC1569g7[]) f5327e.clone();
    }

    public final int m3824a() {
        return this.f5328a;
    }
}
