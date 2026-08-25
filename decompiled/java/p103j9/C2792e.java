package p103j9;

import com.bumptech.glide.AbstractC1466d;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p091i9.InterfaceC2713a;
import p091i9.InterfaceC2714b;
import p091i9.InterfaceC2715c;
import p091i9.InterfaceC2716d;
import p091i9.InterfaceC2717e;
import p091i9.InterfaceC2718f;
import p091i9.InterfaceC2719g;
import p091i9.InterfaceC2720h;
import p091i9.InterfaceC2721i;
import p091i9.InterfaceC2722j;
import p091i9.InterfaceC2723k;
import p091i9.InterfaceC2724l;
import p091i9.InterfaceC2725m;
import p091i9.InterfaceC2726n;
import p091i9.InterfaceC2727o;
import p091i9.InterfaceC2728p;
import p091i9.InterfaceC2729q;
import p091i9.InterfaceC2730r;
import p091i9.InterfaceC2731s;
import p091i9.InterfaceC2732t;
import p091i9.InterfaceC2733u;
import p091i9.InterfaceC2734v;
import p091i9.InterfaceC2735w;
import p170p9.InterfaceC3384b;
import p192r9.AbstractC3648f;
import p243w8.C4064f;
import p253x8.AbstractC4148k;
import p253x8.AbstractC4149l;
import p253x8.AbstractC4158u;

public final class C2792e implements InterfaceC3384b, InterfaceC2791d {

    public static final Map f9530b;

    public static final HashMap f9531c;

    public static final LinkedHashMap f9532d;

    public final Class f9533a;

    static {
        int i6 = 0;
        List listAsList = Arrays.asList(InterfaceC2713a.class, InterfaceC2724l.class, InterfaceC2728p.class, InterfaceC2729q.class, InterfaceC2730r.class, InterfaceC2731s.class, InterfaceC2732t.class, InterfaceC2733u.class, InterfaceC2734v.class, InterfaceC2735w.class, InterfaceC2714b.class, InterfaceC2715c.class, InterfaceC2716d.class, InterfaceC2717e.class, InterfaceC2718f.class, InterfaceC2719g.class, InterfaceC2720h.class, InterfaceC2721i.class, InterfaceC2722j.class, InterfaceC2723k.class, InterfaceC2725m.class, InterfaceC2726n.class, InterfaceC2727o.class);
        AbstractC2796i.m5784e(listAsList, "asList(...)");
        ArrayList arrayList = new ArrayList(AbstractC4149l.m8193Q(listAsList));
        for (Object obj : listAsList) {
            int i10 = i6 + 1;
            if (i6 < 0) {
                AbstractC4148k.m8192P();
                throw null;
            }
            arrayList.add(new C4064f((Class) obj, Integer.valueOf(i6)));
            i6 = i10;
        }
        f9530b = AbstractC4158u.m8197q(arrayList);
        HashMap map = new HashMap();
        map.put("boolean", "kotlin.Boolean");
        map.put("char", "kotlin.Char");
        map.put("byte", "kotlin.Byte");
        map.put("short", "kotlin.Short");
        map.put("int", "kotlin.Int");
        map.put("float", "kotlin.Float");
        map.put("long", "kotlin.Long");
        map.put("double", "kotlin.Double");
        HashMap map2 = new HashMap();
        map2.put("java.lang.Boolean", "kotlin.Boolean");
        map2.put("java.lang.Character", "kotlin.Char");
        map2.put("java.lang.Byte", "kotlin.Byte");
        map2.put("java.lang.Short", "kotlin.Short");
        map2.put("java.lang.Integer", "kotlin.Int");
        map2.put("java.lang.Float", "kotlin.Float");
        map2.put("java.lang.Long", "kotlin.Long");
        map2.put("java.lang.Double", "kotlin.Double");
        HashMap map3 = new HashMap();
        map3.put("java.lang.Object", "kotlin.Any");
        map3.put("java.lang.String", "kotlin.String");
        map3.put("java.lang.CharSequence", "kotlin.CharSequence");
        map3.put("java.lang.Throwable", "kotlin.Throwable");
        map3.put("java.lang.Cloneable", "kotlin.Cloneable");
        map3.put("java.lang.Number", "kotlin.Number");
        map3.put("java.lang.Comparable", "kotlin.Comparable");
        map3.put("java.lang.Enum", "kotlin.Enum");
        map3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        map3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        map3.put("java.util.Iterator", "kotlin.collections.Iterator");
        map3.put("java.util.Collection", "kotlin.collections.Collection");
        map3.put("java.util.List", "kotlin.collections.List");
        map3.put("java.util.Set", "kotlin.collections.Set");
        map3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        map3.put("java.util.Map", "kotlin.collections.Map");
        map3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        map3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        map3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        map3.putAll(map);
        map3.putAll(map2);
        Collection<String> collectionValues = map.values();
        AbstractC2796i.m5784e(collectionValues, "<get-values>(...)");
        for (String str : collectionValues) {
            StringBuilder sb = new StringBuilder("kotlin.jvm.internal.");
            AbstractC2796i.m5782c(str);
            sb.append(AbstractC3648f.m7389k0('.', str, str));
            sb.append("CompanionObject");
            map3.put(sb.toString(), str.concat(".Companion"));
        }
        for (Map.Entry entry : f9530b.entrySet()) {
            Class cls = (Class) entry.getKey();
            int iIntValue = ((Number) entry.getValue()).intValue();
            map3.put(cls.getName(), "kotlin.Function" + iIntValue);
        }
        f9531c = map3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC4158u.m8196p(map3.size()));
        for (Map.Entry entry2 : map3.entrySet()) {
            Object key = entry2.getKey();
            String str2 = (String) entry2.getValue();
            AbstractC2796i.m5782c(str2);
            linkedHashMap.put(key, AbstractC3648f.m7389k0('.', str2, str2));
        }
        f9532d = linkedHashMap;
    }

    public C2792e(Class cls) {
        AbstractC2796i.m5785f(cls, "jClass");
        this.f9533a = cls;
    }

    @Override
    public final Class mo5777a() {
        return this.f9533a;
    }

    public final String m5778b() {
        String str;
        Class cls = this.f9533a;
        AbstractC2796i.m5785f(cls, "jClass");
        String strConcat = null;
        if (cls.isAnonymousClass()) {
            return null;
        }
        if (!cls.isLocalClass()) {
            boolean zIsArray = cls.isArray();
            LinkedHashMap linkedHashMap = f9532d;
            if (!zIsArray) {
                String str2 = (String) linkedHashMap.get(cls.getName());
                return str2 == null ? cls.getSimpleName() : str2;
            }
            Class<?> componentType = cls.getComponentType();
            if (componentType.isPrimitive() && (str = (String) linkedHashMap.get(componentType.getName())) != null) {
                strConcat = str.concat("Array");
            }
            return strConcat == null ? "Array" : strConcat;
        }
        String simpleName = cls.getSimpleName();
        Method enclosingMethod = cls.getEnclosingMethod();
        if (enclosingMethod != null) {
            return AbstractC3648f.m7388j0(simpleName, enclosingMethod.getName() + '$');
        }
        Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
        if (enclosingConstructor != null) {
            return AbstractC3648f.m7388j0(simpleName, enclosingConstructor.getName() + '$');
        }
        int iM7380b0 = AbstractC3648f.m7380b0(simpleName, '$', 0, false, 6);
        if (iM7380b0 == -1) {
            return simpleName;
        }
        String strSubstring = simpleName.substring(iM7380b0 + 1, simpleName.length());
        AbstractC2796i.m5784e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof C2792e) && AbstractC1466d.m3497p(this).equals(AbstractC1466d.m3497p((InterfaceC3384b) obj));
    }

    public final int hashCode() {
        return AbstractC1466d.m3497p(this).hashCode();
    }

    public final String toString() {
        return this.f9533a + " (Kotlin reflection is not available)";
    }
}
