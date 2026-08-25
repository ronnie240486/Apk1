package p270z3;

import android.util.SparseArray;

public final class EnumC4329w {

    public static final EnumC4329w f14683a;

    public static final EnumC4329w[] f14684b;

    static {
        EnumC4329w enumC4329w = new EnumC4329w("DEFAULT", 0);
        f14683a = enumC4329w;
        EnumC4329w enumC4329w2 = new EnumC4329w("UNMETERED_ONLY", 1);
        EnumC4329w enumC4329w3 = new EnumC4329w("UNMETERED_OR_DAILY", 2);
        EnumC4329w enumC4329w4 = new EnumC4329w("FAST_IF_RADIO_AWAKE", 3);
        EnumC4329w enumC4329w5 = new EnumC4329w("NEVER", 4);
        EnumC4329w enumC4329w6 = new EnumC4329w("UNRECOGNIZED", 5);
        f14684b = new EnumC4329w[]{enumC4329w, enumC4329w2, enumC4329w3, enumC4329w4, enumC4329w5, enumC4329w6};
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, enumC4329w);
        sparseArray.put(1, enumC4329w2);
        sparseArray.put(2, enumC4329w3);
        sparseArray.put(3, enumC4329w4);
        sparseArray.put(4, enumC4329w5);
        sparseArray.put(-1, enumC4329w6);
    }

    public static EnumC4329w valueOf(String str) {
        return (EnumC4329w) Enum.valueOf(EnumC4329w.class, str);
    }

    public static EnumC4329w[] values() {
        return (EnumC4329w[]) f14684b.clone();
    }
}
