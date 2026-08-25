package p041d7;

import java.io.Serializable;

public final class C2166a5 extends AbstractC2173b5 implements Serializable {

    public static final C2166a5 f7831a = new C2166a5();

    @Override
    public final AbstractC2173b5 mo5103a() {
        return C2229j5.f7960a;
    }

    @Override
    public final int compare(Object obj, Object obj2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        comparable.getClass();
        comparable2.getClass();
        return comparable.compareTo(comparable2);
    }

    public final String toString() {
        return "Ordering.natural()";
    }
}
