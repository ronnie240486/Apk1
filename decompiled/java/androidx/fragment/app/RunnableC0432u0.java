package androidx.fragment.app;

import java.util.ArrayList;
import p000a.AbstractC0004e;

public final class RunnableC0432u0 implements Runnable {

    public final int f1999a;

    public final C0434v0 f2000b;

    public final C0407i f2001c;

    public RunnableC0432u0(C0407i c0407i, C0434v0 c0434v0, int i6) {
        this.f1999a = i6;
        this.f2001c = c0407i;
        this.f2000b = c0434v0;
    }

    @Override
    public final void run() {
        switch (this.f1999a) {
            case 0:
                ArrayList arrayList = this.f2001c.f1847b;
                C0434v0 c0434v0 = this.f2000b;
                if (arrayList.contains(c0434v0)) {
                    AbstractC0004e.m7a(c0434v0.f2007a, c0434v0.f2009c.f1951F);
                }
                break;
            default:
                C0407i c0407i = this.f2001c;
                ArrayList arrayList2 = c0407i.f1847b;
                C0434v0 c0434v1 = this.f2000b;
                arrayList2.remove(c0434v1);
                c0407i.f1848c.remove(c0434v1);
                break;
        }
    }
}
