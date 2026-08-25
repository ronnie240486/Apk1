package p103j9;

import java.util.List;
import p055ea.AbstractC2460q;
import p091i9.InterfaceC2713a;
import p091i9.InterfaceC2724l;
import p091i9.InterfaceC2728p;
import p091i9.InterfaceC2729q;
import p115k9.InterfaceC2905a;
import p115k9.InterfaceC2906b;
import p243w8.InterfaceC4059a;

public abstract class AbstractC2804q {
    public static List m5796a(Object obj) {
        if ((obj instanceof InterfaceC2905a) && !(obj instanceof InterfaceC2906b)) {
            m5799d(obj, "kotlin.collections.MutableList");
            throw null;
        }
        try {
            return (List) obj;
        } catch (ClassCastException e5) {
            AbstractC2796i.m5789j(e5, AbstractC2804q.class.getName());
            throw e5;
        }
    }

    public static void m5797b(InterfaceC2728p interfaceC2728p) {
        if (m5798c(2, interfaceC2728p)) {
            return;
        }
        m5799d(interfaceC2728p, "kotlin.jvm.functions.Function2");
        throw null;
    }

    public static boolean m5798c(int i6, Object obj) {
        int arity;
        if (!(obj instanceof InterfaceC4059a)) {
            return false;
        }
        if (obj instanceof InterfaceC2794g) {
            arity = ((InterfaceC2794g) obj).getArity();
        } else if (obj instanceof InterfaceC2713a) {
            arity = 0;
        } else if (obj instanceof InterfaceC2724l) {
            arity = 1;
        } else if (obj instanceof InterfaceC2728p) {
            arity = 2;
        } else {
            arity = obj instanceof InterfaceC2729q ? 3 : -1;
        }
        return arity == i6;
    }

    public static void m5799d(Object obj, String str) {
        ClassCastException classCastException = new ClassCastException(AbstractC2460q.m5495i(obj.getClass().getName(), " cannot be cast to ", str));
        AbstractC2796i.m5789j(classCastException, AbstractC2804q.class.getName());
        throw classCastException;
    }
}
