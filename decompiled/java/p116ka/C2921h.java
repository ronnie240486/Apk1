package p116ka;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import org.bitspark.android.beans.EventBean;
import p003a2.AbstractC0032a;
import p247x2.C4098t;

public final class C2921h {

    public final AtomicInteger f9902a;

    public final int f9903b;

    public final ArrayList f9904c;

    public final EventBean f9905d;

    public final ViewOnKeyListenerC2925j f9906e;

    public C2921h(ViewOnKeyListenerC2925j viewOnKeyListenerC2925j, AtomicInteger atomicInteger, int i6, ArrayList arrayList, EventBean eventBean) {
        this.f9906e = viewOnKeyListenerC2925j;
        this.f9902a = atomicInteger;
        this.f9903b = i6;
        this.f9904c = arrayList;
        this.f9905d = eventBean;
    }

    public final void m5913a(C4098t c4098t, Object obj) {
        AbstractC0032a.m165s("KkpTTPkjVCEPQFBd\n", "YiU+Kb9RNUY=\n");
        AbstractC0032a.m165s("0Huejq0jSfjMZbKPoyVIyvRhnoyRKkLO4miVjKcwDdzSe5SQ+GI=\n", "oAn74sJCLbk=\n");
        Objects.toString(obj);
        AbstractC0032a.m165s("dgfIwQ==\n", "Virl/5M1dWk=\n");
        Objects.toString(c4098t);
        if (this.f9902a.incrementAndGet() == this.f9903b) {
            ViewOnKeyListenerC2925j.m5920Q(this.f9906e, this.f9904c);
        }
    }

    public final void m5914b(Object obj, Object obj2) {
        AbstractC0032a.m165s("bzhaAz/7wg9KMlkS\n", "J1c3ZnmJo2g=\n");
        AbstractC0032a.m165s("KM1KVZap+ps002ZUmK/7qQzXSleqoPGtGt5BV5y6vpUThQ8=\n", "WL8vOfnInto=\n");
        Objects.toString(obj2);
        ArrayList arrayList = this.f9904c;
        arrayList.add(this.f9905d);
        if (this.f9902a.incrementAndGet() == this.f9903b) {
            ViewOnKeyListenerC2925j.m5920Q(this.f9906e, arrayList);
        }
    }
}
