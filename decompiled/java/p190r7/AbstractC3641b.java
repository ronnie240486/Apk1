package p190r7;

import p154o7.C3260a;

public abstract class AbstractC3641b {

    public static final boolean f12232a;

    public static final C3260a f12233b;

    public static final C3260a f12234c;

    public static final C3260a f12235d;

    static {
        boolean z7;
        try {
            Class.forName("java.sql.Date");
            z7 = true;
        } catch (ClassNotFoundException unused) {
            z7 = false;
        }
        f12232a = z7;
        if (z7) {
            f12233b = C3640a.f12227c;
            f12234c = C3640a.f12228d;
            f12235d = C3640a.f12229e;
        } else {
            f12233b = null;
            f12234c = null;
            f12235d = null;
        }
    }
}
