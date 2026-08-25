package p253x8;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import p003a2.AbstractC0032a;
import p091i9.InterfaceC2724l;
import p103j9.AbstractC2796i;
import p156o9.AbstractC3281e;
import qa.C3554b;

public abstract class AbstractC4147j extends AbstractC4153p {
    public static Object m8180T(Collection collection) {
        AbstractC2796i.m5785f(collection, "<this>");
        if (collection instanceof List) {
            return m8181U((List) collection);
        }
        Iterator it = collection.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static Object m8181U(List list) {
        AbstractC2796i.m5785f(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static Object m8182V(List list) {
        AbstractC2796i.m5785f(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static final void m8183W(Collection collection, StringBuilder sb, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i6, CharSequence charSequence4, InterfaceC2724l interfaceC2724l) {
        AbstractC2796i.m5785f(charSequence, "separator");
        AbstractC2796i.m5785f(charSequence2, "prefix");
        AbstractC2796i.m5785f(charSequence3, "postfix");
        AbstractC2796i.m5785f(charSequence4, "truncated");
        sb.append(charSequence2);
        int i10 = 0;
        for (Object obj : collection) {
            i10++;
            if (i10 > 1) {
                sb.append(charSequence);
            }
            if (i6 >= 0 && i10 > i6) {
                break;
            } else {
                AbstractC3281e.m6617g(sb, obj, interfaceC2724l);
            }
        }
        if (i6 >= 0 && i10 > i6) {
            sb.append(charSequence4);
        }
        sb.append(charSequence3);
    }

    public static String m8184X(Collection collection, String str, String str2, String str3, C3554b c3554b, int i6) {
        String str4 = (i6 & 2) != 0 ? "" : str2;
        String str5 = (i6 & 4) != 0 ? "" : str3;
        if ((i6 & 32) != 0) {
            c3554b = null;
        }
        AbstractC2796i.m5785f(str4, "prefix");
        AbstractC2796i.m5785f(str5, "postfix");
        StringBuilder sb = new StringBuilder();
        m8183W(collection, sb, str, str4, str5, -1, "...", c3554b);
        return sb.toString();
    }

    public static Object m8185Y(List list) {
        AbstractC2796i.m5785f(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(AbstractC4148k.m8191O(list));
    }

    public static ArrayList m8186Z(Collection collection, Iterable iterable) {
        AbstractC2796i.m5785f(collection, "<this>");
        AbstractC2796i.m5785f(iterable, "elements");
        if (!(iterable instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            AbstractC4153p.m8195S(arrayList, iterable);
            return arrayList;
        }
        Collection collection2 = (Collection) iterable;
        ArrayList arrayList2 = new ArrayList(collection2.size() + collection.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    public static ArrayList m8187a0(List list, Object obj) {
        AbstractC2796i.m5785f(list, "<this>");
        ArrayList arrayList = new ArrayList(list.size() + 1);
        arrayList.addAll(list);
        arrayList.add(obj);
        return arrayList;
    }

    public static final void m8188b0(Iterable iterable, AbstractCollection abstractCollection) {
        AbstractC2796i.m5785f(iterable, "<this>");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            abstractCollection.add(it.next());
        }
    }

    public static List m8189c0(Iterable iterable) {
        ArrayList arrayListM8190d0;
        AbstractC2796i.m5785f(iterable, "<this>");
        boolean z7 = iterable instanceof Collection;
        C4155r c4155r = C4155r.f14074a;
        if (z7) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                return c4155r;
            }
            if (size != 1) {
                return m8190d0(collection);
            }
            return AbstractC0032a.m154F(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
        }
        if (z7) {
            arrayListM8190d0 = m8190d0((Collection) iterable);
        } else {
            ArrayList arrayList = new ArrayList();
            m8188b0(iterable, arrayList);
            arrayListM8190d0 = arrayList;
        }
        int size2 = arrayListM8190d0.size();
        if (size2 != 0) {
            return size2 != 1 ? arrayListM8190d0 : AbstractC0032a.m154F(arrayListM8190d0.get(0));
        }
        return c4155r;
    }

    public static ArrayList m8190d0(Collection collection) {
        AbstractC2796i.m5785f(collection, "<this>");
        return new ArrayList(collection);
    }
}
