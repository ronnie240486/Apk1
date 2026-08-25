package p130m2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import p103j9.AbstractC2796i;
import p115k9.InterfaceC2905a;
import p243w8.C4064f;
import p253x8.C4156s;

public final class C3067o implements Iterable, InterfaceC2905a {

    public static final C3067o f10512b = new C3067o(C4156s.f14075a);

    public final Map f10513a;

    public C3067o(Map map) {
        this.f10513a = map;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C3067o) {
            if (AbstractC2796i.m5780a(this.f10513a, ((C3067o) obj).f10513a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f10513a.hashCode();
    }

    @Override
    public final Iterator iterator() {
        Map map = this.f10513a;
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (entry.getValue() != null) {
                throw new ClassCastException();
            }
            arrayList.add(new C4064f(str, null));
        }
        return arrayList.iterator();
    }

    public final String toString() {
        return "Parameters(entries=" + this.f10513a + ')';
    }
}
