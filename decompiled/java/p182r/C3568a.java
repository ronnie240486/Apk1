package p182r;

import java.util.concurrent.CancellationException;

public final class C3568a {

    public static final C3568a f12024b;

    public static final C3568a f12025c;

    public final CancellationException f12026a;

    static {
        if (AbstractC3574g.f12039d) {
            f12025c = null;
            f12024b = null;
        } else {
            f12025c = new C3568a(false, null);
            f12024b = new C3568a(true, null);
        }
    }

    public C3568a(boolean z7, CancellationException cancellationException) {
        this.f12026a = cancellationException;
    }
}
