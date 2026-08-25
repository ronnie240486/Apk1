package p020b7;

public abstract class AbstractC1344h {
    public abstract boolean mo3236a(Object obj, Object obj2);

    public abstract int mo3237b(Object obj);

    public final boolean m3238c(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return mo3236a(obj, obj2);
    }
}
