package p247x2;

import com.bumptech.glide.load.data.InterfaceC1481g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import p028c6.C1399b;
import p187r4.C3621k;
import p228v2.C3981h;

public final class C4100v {

    public final C3621k f13894a;

    public final List f13895b;

    public final String f13896c;

    public C4100v(Class cls, Class cls2, Class cls3, List list, C3621k c3621k) {
        this.f13894a = c3621k;
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Must not be empty.");
        }
        this.f13895b = list;
        this.f13896c = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public final InterfaceC4102x m8121a(int i6, int i10, C1399b c1399b, InterfaceC1481g interfaceC1481g, C3981h c3981h) {
        C3621k c3621k = this.f13894a;
        List list = (List) c3621k.m7329f();
        try {
            List list2 = this.f13895b;
            int size = list2.size();
            InterfaceC4102x interfaceC4102xM8092a = null;
            for (int i11 = 0; i11 < size; i11++) {
                try {
                    interfaceC4102xM8092a = ((C4088j) list2.get(i11)).m8092a(i6, i10, c1399b, interfaceC1481g, c3981h);
                } catch (C4098t e5) {
                    list.add(e5);
                }
                if (interfaceC4102xM8092a != null) {
                    break;
                }
            }
            if (interfaceC4102xM8092a != null) {
                c3621k.m7334k(list);
                return interfaceC4102xM8092a;
            }
            throw new C4098t(this.f13896c, new ArrayList(list));
        } catch (Throwable th) {
            c3621k.m7334k(list);
            throw th;
        }
    }

    public final String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f13895b.toArray()) + '}';
    }
}
