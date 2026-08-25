package p041d7;

import java.io.Serializable;

public final class C2229j5 extends AbstractC2173b5 implements Serializable {

    public static final C2229j5 f7960a = new C2229j5();

    @Override
    public final AbstractC2173b5 mo5103a() {
        return C2166a5.f7831a;
    }

    @Override
    public final int compare(Object obj, Object obj2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        comparable.getClass();
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    public final String toString() {
        return "Ordering.natural().reverse()";
    }
}
