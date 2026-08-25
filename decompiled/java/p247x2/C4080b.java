package p247x2;

public final class C4080b extends RuntimeException {
    public C4080b(Throwable th) {
        super("Unexpected exception thrown by non-Glide code", th);
    }
}
