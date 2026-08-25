package p253x8;

import java.util.Collection;
import java.util.Iterator;
import p103j9.AbstractC2796i;

public abstract class AbstractC4153p extends AbstractC4152o {
    public static void m8195S(Collection collection, Iterable iterable) {
        AbstractC2796i.m5785f(collection, "<this>");
        AbstractC2796i.m5785f(iterable, "elements");
        if (iterable instanceof Collection) {
            collection.addAll((Collection) iterable);
            return;
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            collection.add(it.next());
        }
    }
}
