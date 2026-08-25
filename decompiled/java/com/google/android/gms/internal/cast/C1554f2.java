package com.google.android.gms.internal.cast;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import p000a.AbstractC0004e;

public final class C1554f2 implements Map, Serializable {

    public static final C1554f2 f5294g = new C1554f2(null, new Object[0], 0);

    public transient C1524c2 f5295a;

    public transient C1534d2 f5296b;

    public transient C1544e2 f5297c;

    public final transient Object f5298d;

    public final transient Object[] f5299e;

    public final transient int f5300f;

    public C1554f2(Object obj, Object[] objArr, int i6) {
        this.f5298d = obj;
        this.f5299e = objArr;
        this.f5300f = i6;
    }

    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [short[], byte[]], vars: [r4v4 ??, r4v7 ??, r4v5 short[], r4v8 byte[]]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.rerun(InitCodeVariables.java:36)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:676)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        */
    public static void m3816a(java.util.Set r16) {
        /*
            Method dump skipped, instruction units count: 573
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.C1554f2.m3816a(java.util.Set):void");
    }

    @Override
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override
    public final boolean containsValue(Object obj) {
        C1544e2 c1544e2 = this.f5297c;
        if (c1544e2 == null) {
            c1544e2 = new C1544e2(this.f5299e, 1, this.f5300f);
            this.f5297c = c1544e2;
        }
        return c1544e2.contains(obj);
    }

    @Override
    public final Set entrySet() {
        C1524c2 c1524c2 = this.f5295a;
        if (c1524c2 != null) {
            return c1524c2;
        }
        C1524c2 c1524c3 = new C1524c2(this, this.f5299e, this.f5300f);
        this.f5295a = c1524c3;
        return c1524c3;
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @Override
    public final Object get(Object obj) {
        Object obj2;
        if (obj == null) {
            obj2 = null;
        } else {
            int i6 = this.f5300f;
            Object[] objArr = this.f5299e;
            if (i6 == 1) {
                Object obj3 = objArr[0];
                Objects.requireNonNull(obj3);
                if (obj3.equals(obj)) {
                    obj2 = objArr[1];
                    Objects.requireNonNull(obj2);
                } else {
                    obj2 = null;
                }
            } else {
                Object obj4 = this.f5298d;
                if (obj4 == null) {
                    obj2 = null;
                } else if (obj4 instanceof byte[]) {
                    byte[] bArr = (byte[]) obj4;
                    int length = bArr.length - 1;
                    int iM3692b = AbstractC1503a1.m3692b(obj.hashCode());
                    while (true) {
                        int i10 = iM3692b & length;
                        int i11 = bArr[i10] & 255;
                        if (i11 == 255) {
                            break;
                        }
                        if (obj.equals(objArr[i11])) {
                            obj2 = objArr[i11 ^ 1];
                        } else {
                            iM3692b = i10 + 1;
                        }
                    }
                    obj2 = null;
                } else if (obj4 instanceof short[]) {
                    short[] sArr = (short[]) obj4;
                    int length2 = sArr.length - 1;
                    int iM3692b2 = AbstractC1503a1.m3692b(obj.hashCode());
                    while (true) {
                        int i12 = iM3692b2 & length2;
                        char c5 = (char) sArr[i12];
                        if (c5 == 65535) {
                            break;
                        }
                        if (obj.equals(objArr[c5])) {
                            obj2 = objArr[c5 ^ 1];
                        } else {
                            iM3692b2 = i12 + 1;
                        }
                    }
                    obj2 = null;
                } else {
                    int[] iArr = (int[]) obj4;
                    int length3 = iArr.length - 1;
                    int iM3692b3 = AbstractC1503a1.m3692b(obj.hashCode());
                    while (true) {
                        int i13 = iM3692b3 & length3;
                        int i14 = iArr[i13];
                        if (i14 == -1) {
                            break;
                        }
                        if (obj.equals(objArr[i14])) {
                            obj2 = objArr[i14 ^ 1];
                        } else {
                            iM3692b3 = i13 + 1;
                        }
                    }
                    obj2 = null;
                }
            }
        }
        if (obj2 == null) {
            return null;
        }
        return obj2;
    }

    @Override
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override
    public final int hashCode() {
        C1524c2 c1524c2 = this.f5295a;
        if (c1524c2 == null) {
            c1524c2 = new C1524c2(this, this.f5299e, this.f5300f);
            this.f5295a = c1524c2;
        }
        Iterator it = c1524c2.iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode += next != null ? next.hashCode() : 0;
        }
        return iHashCode;
    }

    @Override
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public final Set keySet() {
        C1534d2 c1534d2 = this.f5296b;
        if (c1534d2 != null) {
            return c1534d2;
        }
        C1534d2 c1534d3 = new C1534d2(this, new C1544e2(this.f5299e, 0, this.f5300f));
        this.f5296b = c1534d3;
        return c1534d3;
    }

    @Override
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final int size() {
        return this.f5300f;
    }

    public final String toString() {
        int i6 = this.f5300f;
        if (i6 < 0) {
            throw new IllegalArgumentException(AbstractC0004e.m20n(i6, "size cannot be negative but was: "));
        }
        StringBuilder sb = new StringBuilder((int) Math.min(((long) i6) * 8, 1073741824L));
        sb.append('{');
        boolean z7 = true;
        for (Map.Entry entry : (C1524c2) entrySet()) {
            if (!z7) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            z7 = false;
        }
        sb.append('}');
        return sb.toString();
    }

    @Override
    public final Collection values() {
        C1544e2 c1544e2 = this.f5297c;
        if (c1544e2 != null) {
            return c1544e2;
        }
        C1544e2 c1544e3 = new C1544e2(this.f5299e, 1, this.f5300f);
        this.f5297c = c1544e3;
        return c1544e3;
    }
}
