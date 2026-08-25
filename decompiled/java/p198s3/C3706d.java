package p198s3;

public final class C3706d {

    public volatile boolean f12412a;

    public final void m7468a() {
        if (this.f12412a) {
            throw new IllegalStateException("Already released");
        }
    }
}
