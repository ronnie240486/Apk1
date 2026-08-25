package p270z3;

import android.util.SparseArray;

public final class EnumC4327u {

    public static final SparseArray f14681a;

    public static final EnumC4327u[] f14682b;

    EnumC4327u EF3;

    static {
        EnumC4327u enumC4327u = new EnumC4327u("MOBILE", 0);
        EnumC4327u enumC4327u2 = new EnumC4327u("WIFI", 1);
        EnumC4327u enumC4327u3 = new EnumC4327u("MOBILE_MMS", 2);
        EnumC4327u enumC4327u4 = new EnumC4327u("MOBILE_SUPL", 3);
        EnumC4327u enumC4327u5 = new EnumC4327u("MOBILE_DUN", 4);
        EnumC4327u enumC4327u6 = new EnumC4327u("MOBILE_HIPRI", 5);
        EnumC4327u enumC4327u7 = new EnumC4327u("WIMAX", 6);
        EnumC4327u enumC4327u8 = new EnumC4327u("BLUETOOTH", 7);
        EnumC4327u enumC4327u9 = new EnumC4327u("DUMMY", 8);
        EnumC4327u enumC4327u10 = new EnumC4327u("ETHERNET", 9);
        EnumC4327u enumC4327u11 = new EnumC4327u("MOBILE_FOTA", 10);
        EnumC4327u enumC4327u12 = new EnumC4327u("MOBILE_IMS", 11);
        EnumC4327u enumC4327u13 = new EnumC4327u("MOBILE_CBS", 12);
        EnumC4327u enumC4327u14 = new EnumC4327u("WIFI_P2P", 13);
        EnumC4327u enumC4327u15 = new EnumC4327u("MOBILE_IA", 14);
        EnumC4327u enumC4327u16 = new EnumC4327u("MOBILE_EMERGENCY", 15);
        EnumC4327u enumC4327u17 = new EnumC4327u("PROXY", 16);
        EnumC4327u enumC4327u18 = new EnumC4327u("VPN", 17);
        EnumC4327u enumC4327u19 = new EnumC4327u("NONE", 18);
        f14682b = new EnumC4327u[]{enumC4327u, enumC4327u2, enumC4327u3, enumC4327u4, enumC4327u5, enumC4327u6, enumC4327u7, enumC4327u8, enumC4327u9, enumC4327u10, enumC4327u11, enumC4327u12, enumC4327u13, enumC4327u14, enumC4327u15, enumC4327u16, enumC4327u17, enumC4327u18, enumC4327u19};
        SparseArray sparseArray = new SparseArray();
        f14681a = sparseArray;
        sparseArray.put(0, enumC4327u);
        sparseArray.put(1, enumC4327u2);
        sparseArray.put(2, enumC4327u3);
        sparseArray.put(3, enumC4327u4);
        sparseArray.put(4, enumC4327u5);
        sparseArray.put(5, enumC4327u6);
        sparseArray.put(6, enumC4327u7);
        sparseArray.put(7, enumC4327u8);
        sparseArray.put(8, enumC4327u9);
        sparseArray.put(9, enumC4327u10);
        sparseArray.put(10, enumC4327u11);
        sparseArray.put(11, enumC4327u12);
        sparseArray.put(12, enumC4327u13);
        sparseArray.put(13, enumC4327u14);
        sparseArray.put(14, enumC4327u15);
        sparseArray.put(15, enumC4327u16);
        sparseArray.put(16, enumC4327u17);
        sparseArray.put(17, enumC4327u18);
        sparseArray.put(-1, enumC4327u19);
    }

    public static EnumC4327u valueOf(String str) {
        return (EnumC4327u) Enum.valueOf(EnumC4327u.class, str);
    }

    public static EnumC4327u[] values() {
        return (EnumC4327u[]) f14682b.clone();
    }
}
