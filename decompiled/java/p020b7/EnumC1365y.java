package p020b7;

public abstract class EnumC1365y implements InterfaceC1354n {

    public static final C1363w f4176a;

    public static final EnumC1365y[] f4177b;

    EnumC1365y EF0;

    static {
        EnumC1365y enumC1365y = new EnumC1365y() {
            @Override
            public final boolean apply(Object obj) {
                return true;
            }

            @Override
            public final String toString() {
                return "Predicates.alwaysTrue()";
            }
        };
        EnumC1365y enumC1365y2 = new EnumC1365y() {
            @Override
            public final boolean apply(Object obj) {
                return false;
            }

            @Override
            public final String toString() {
                return "Predicates.alwaysFalse()";
            }
        };
        C1363w c1363w = new C1363w();
        f4176a = c1363w;
        f4177b = new EnumC1365y[]{enumC1365y, enumC1365y2, c1363w, new EnumC1365y() {
            @Override
            public final boolean apply(Object obj) {
                return obj != null;
            }

            @Override
            public final String toString() {
                return "Predicates.notNull()";
            }
        }};
    }

    public static EnumC1365y valueOf(String str) {
        return (EnumC1365y) Enum.valueOf(EnumC1365y.class, str);
    }

    public static EnumC1365y[] values() {
        return (EnumC1365y[]) f4177b.clone();
    }
}
