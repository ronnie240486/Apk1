package p181q9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p003a2.AbstractC0032a;
import p253x8.C4155r;

public abstract class AbstractC3548f extends AbstractC3550h {
    public static List m7172p(InterfaceC3545c interfaceC3545c) {
        Iterator it = interfaceC3545c.iterator();
        if (!it.hasNext()) {
            return C4155r.f14074a;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return AbstractC0032a.m154F(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
