package p186r3;

public abstract class AbstractC3602f {

    public static final ExecutorC3601e f12098a = new ExecutorC3601e(0);

    public static final ExecutorC3601e f12099b = new ExecutorC3601e(1);

    public static void m7223a(String str, boolean z7) {
        if (!z7) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void m7224b(Object obj) {
        m7225c(obj, "Argument must not be null");
    }

    public static void m7225c(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }
}
