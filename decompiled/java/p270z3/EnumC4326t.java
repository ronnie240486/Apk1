package p270z3;

import android.util.SparseArray;

public final class EnumC4326t {

    public static final SparseArray f14679a;

    public static final EnumC4326t[] f14680b;

    EnumC4326t EF5;

    static {
        EnumC4326t enumC4326t = new EnumC4326t("UNKNOWN_MOBILE_SUBTYPE", 0);
        EnumC4326t enumC4326t2 = new EnumC4326t("GPRS", 1);
        EnumC4326t enumC4326t3 = new EnumC4326t("EDGE", 2);
        EnumC4326t enumC4326t4 = new EnumC4326t("UMTS", 3);
        EnumC4326t enumC4326t5 = new EnumC4326t("CDMA", 4);
        EnumC4326t enumC4326t6 = new EnumC4326t("EVDO_0", 5);
        EnumC4326t enumC4326t7 = new EnumC4326t("EVDO_A", 6);
        EnumC4326t enumC4326t8 = new EnumC4326t("RTT", 7);
        EnumC4326t enumC4326t9 = new EnumC4326t("HSDPA", 8);
        EnumC4326t enumC4326t10 = new EnumC4326t("HSUPA", 9);
        EnumC4326t enumC4326t11 = new EnumC4326t("HSPA", 10);
        EnumC4326t enumC4326t12 = new EnumC4326t("IDEN", 11);
        EnumC4326t enumC4326t13 = new EnumC4326t("EVDO_B", 12);
        EnumC4326t enumC4326t14 = new EnumC4326t("LTE", 13);
        EnumC4326t enumC4326t15 = new EnumC4326t("EHRPD", 14);
        EnumC4326t enumC4326t16 = new EnumC4326t("HSPAP", 15);
        EnumC4326t enumC4326t17 = new EnumC4326t("GSM", 16);
        EnumC4326t enumC4326t18 = new EnumC4326t("TD_SCDMA", 17);
        EnumC4326t enumC4326t19 = new EnumC4326t("IWLAN", 18);
        EnumC4326t enumC4326t20 = new EnumC4326t("LTE_CA", 19);
        f14680b = new EnumC4326t[]{enumC4326t, enumC4326t2, enumC4326t3, enumC4326t4, enumC4326t5, enumC4326t6, enumC4326t7, enumC4326t8, enumC4326t9, enumC4326t10, enumC4326t11, enumC4326t12, enumC4326t13, enumC4326t14, enumC4326t15, enumC4326t16, enumC4326t17, enumC4326t18, enumC4326t19, enumC4326t20, new EnumC4326t("COMBINED", 20)};
        SparseArray sparseArray = new SparseArray();
        f14679a = sparseArray;
        sparseArray.put(0, enumC4326t);
        sparseArray.put(1, enumC4326t2);
        sparseArray.put(2, enumC4326t3);
        sparseArray.put(3, enumC4326t4);
        sparseArray.put(4, enumC4326t5);
        sparseArray.put(5, enumC4326t6);
        sparseArray.put(6, enumC4326t7);
        sparseArray.put(7, enumC4326t8);
        sparseArray.put(8, enumC4326t9);
        sparseArray.put(9, enumC4326t10);
        sparseArray.put(10, enumC4326t11);
        sparseArray.put(11, enumC4326t12);
        sparseArray.put(12, enumC4326t13);
        sparseArray.put(13, enumC4326t14);
        sparseArray.put(14, enumC4326t15);
        sparseArray.put(15, enumC4326t16);
        sparseArray.put(16, enumC4326t17);
        sparseArray.put(17, enumC4326t18);
        sparseArray.put(18, enumC4326t19);
        sparseArray.put(19, enumC4326t20);
    }

    public static EnumC4326t valueOf(String str) {
        return (EnumC4326t) Enum.valueOf(EnumC4326t.class, str);
    }

    public static EnumC4326t[] values() {
        return (EnumC4326t[]) f14680b.clone();
    }
}
