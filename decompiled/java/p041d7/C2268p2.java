package p041d7;

import com.google.common.util.concurrent.C1969m;
import java.util.Iterator;

public final class C2268p2 extends AbstractC2211h1 {

    public final Iterable f8023b;

    public final C1969m f8024c;

    public C2268p2(Iterable iterable, C1969m c1969m) {
        this.f8023b = iterable;
        this.f8024c = c1969m;
    }

    @Override
    public final Iterator iterator() {
        return new C2282r2(this.f8023b.iterator(), this.f8024c);
    }
}
