package p020b7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p001a0.C0019b;

public final class C1333b0 {

    public final C0019b f4147b;

    public final C1338e f4146a = C1338e.f4154a;

    public final int f4148c = Integer.MAX_VALUE;

    public C1333b0(C0019b c0019b) {
        this.f4147b = c0019b;
    }

    public final List m3234a(CharSequence charSequence) {
        charSequence.getClass();
        C0019b c0019b = this.f4147b;
        c0019b.getClass();
        C1331a0 c1331a0 = new C1331a0(c0019b, this, charSequence);
        ArrayList arrayList = new ArrayList();
        while (c1331a0.hasNext()) {
            arrayList.add((String) c1331a0.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
