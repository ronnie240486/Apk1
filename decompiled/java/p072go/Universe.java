package p072go;

public abstract class Universe {

    public static final class proxyerror extends Exception implements Seq.Proxy, error {
        private final int refnum;

        public proxyerror(int i6) {
            this.refnum = i6;
            Seq.trackGoRef(i6, this);
        }

        @Override
        public native String error();

        @Override
        public String getMessage() {
            return error();
        }

        @Override
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }
    }

    static {
        Seq.touch();
        _init();
    }

    private Universe() {
    }

    private static native void _init();

    public static void touch() {
    }
}
