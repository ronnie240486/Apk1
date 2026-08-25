package p131m3;

import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;
import p097j3.C2773d;
import p160p.C3341e;
import p186r3.C3608l;
import p247x2.C4088j;
import p247x2.C4100v;

public final class C3075b {

    public static final C4100v f10536c = new C4100v(Object.class, Object.class, Object.class, Collections.singletonList(new C4088j(Object.class, Object.class, Object.class, Collections.emptyList(), new C2773d(0), null)), null);

    public final C3341e f10537a = new C3341e(0);

    public final AtomicReference f10538b = new AtomicReference();

    public final void m6110a(Class cls, Class cls2, Class cls3, C4100v c4100v) {
        synchronized (this.f10537a) {
            C3341e c3341e = this.f10537a;
            C3608l c3608l = new C3608l(cls, cls2, cls3);
            if (c4100v == null) {
                c4100v = f10536c;
            }
            c3341e.put(c3608l, c4100v);
        }
    }
}
