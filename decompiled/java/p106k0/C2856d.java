package p106k0;

import java.util.ArrayList;
import p007a7.C0069f;
import p128m0.InterfaceC3025a;
import p160p.C3347k;

public final class C2856d implements InterfaceC3025a {

    public final int f9774a;

    public final Object f9775b;

    public C2856d(int i6, Object obj) {
        this.f9774a = i6;
        this.f9775b = obj;
    }

    @Override
    public final void accept(Object obj) {
        switch (this.f9774a) {
            case 0:
                C2857e c2857e = (C2857e) obj;
                if (c2857e == null) {
                    c2857e = new C2857e(-3);
                }
                ((C0069f) this.f9775b).m224G(c2857e);
                return;
            default:
                C2857e c2857e2 = (C2857e) obj;
                synchronized (AbstractC2858f.f9780c) {
                    try {
                        C3347k c3347k = AbstractC2858f.f9781d;
                        ArrayList arrayList = (ArrayList) c3347k.get((String) this.f9775b);
                        if (arrayList == null) {
                            return;
                        }
                        c3347k.remove((String) this.f9775b);
                        for (int i6 = 0; i6 < arrayList.size(); i6++) {
                            ((InterfaceC3025a) arrayList.get(i6)).accept(c2857e2);
                        }
                        return;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
        }
    }
}
