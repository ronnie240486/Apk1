package com.tencent.bugly.proguard;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p000a.AbstractC0004e;

public final class C2084k {

    protected String f7635a = "GBK";

    private ByteBuffer f7636b;

    public static class a {

        public byte f7637a;

        public int f7638b;
    }

    public C2084k() {
    }

    private boolean m4897b(int i6) {
        int i10;
        try {
            a aVar = new a();
            while (true) {
                int iM4888a = m4888a(aVar, this.f7636b.duplicate());
                i10 = aVar.f7638b;
                if (i6 <= i10 || aVar.f7637a == 11) {
                    break;
                    break;
                }
                m4893a(iM4888a);
                m4892a(aVar.f7637a);
            }
            return i6 == i10;
        } catch (C2078h | BufferUnderflowException unused) {
        }
    }

    private boolean[] m4899d(int i6, boolean z7) {
        if (!m4897b(i6)) {
            if (z7) {
                throw new C2078h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        m4894a(aVar);
        if (aVar.f7637a != 9) {
            throw new C2078h("type mismatch.");
        }
        int iM4906a = m4906a(0, 0, true);
        if (iM4906a < 0) {
            throw new C2078h("size invalid: ".concat(String.valueOf(iM4906a)));
        }
        boolean[] zArr = new boolean[iM4906a];
        for (int i10 = 0; i10 < iM4906a; i10++) {
            zArr[i10] = m4914a(0, true);
        }
        return zArr;
    }

    private short[] m4900e(int i6, boolean z7) {
        if (!m4897b(i6)) {
            if (z7) {
                throw new C2078h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        m4894a(aVar);
        if (aVar.f7637a != 9) {
            throw new C2078h("type mismatch.");
        }
        int iM4906a = m4906a(0, 0, true);
        if (iM4906a < 0) {
            throw new C2078h("size invalid: ".concat(String.valueOf(iM4906a)));
        }
        short[] sArr = new short[iM4906a];
        for (int i10 = 0; i10 < iM4906a; i10++) {
            sArr[i10] = m4912a(sArr[0], 0, true);
        }
        return sArr;
    }

    private int[] m4901f(int i6, boolean z7) {
        if (!m4897b(i6)) {
            if (z7) {
                throw new C2078h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        m4894a(aVar);
        if (aVar.f7637a != 9) {
            throw new C2078h("type mismatch.");
        }
        int iM4906a = m4906a(0, 0, true);
        if (iM4906a < 0) {
            throw new C2078h("size invalid: ".concat(String.valueOf(iM4906a)));
        }
        int[] iArr = new int[iM4906a];
        for (int i10 = 0; i10 < iM4906a; i10++) {
            iArr[i10] = m4906a(iArr[0], 0, true);
        }
        return iArr;
    }

    private long[] m4902g(int i6, boolean z7) {
        if (!m4897b(i6)) {
            if (z7) {
                throw new C2078h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        m4894a(aVar);
        if (aVar.f7637a != 9) {
            throw new C2078h("type mismatch.");
        }
        int iM4906a = m4906a(0, 0, true);
        if (iM4906a < 0) {
            throw new C2078h("size invalid: ".concat(String.valueOf(iM4906a)));
        }
        long[] jArr = new long[iM4906a];
        for (int i10 = 0; i10 < iM4906a; i10++) {
            jArr[i10] = m4908a(jArr[0], 0, true);
        }
        return jArr;
    }

    private float[] m4903h(int i6, boolean z7) {
        if (!m4897b(i6)) {
            if (z7) {
                throw new C2078h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        m4894a(aVar);
        if (aVar.f7637a != 9) {
            throw new C2078h("type mismatch.");
        }
        int iM4906a = m4906a(0, 0, true);
        if (iM4906a < 0) {
            throw new C2078h("size invalid: ".concat(String.valueOf(iM4906a)));
        }
        float[] fArr = new float[iM4906a];
        for (int i10 = 0; i10 < iM4906a; i10++) {
            fArr[i10] = m4887a(fArr[0], 0, true);
        }
        return fArr;
    }

    private double[] m4904i(int i6, boolean z7) {
        if (!m4897b(i6)) {
            if (z7) {
                throw new C2078h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        m4894a(aVar);
        if (aVar.f7637a != 9) {
            throw new C2078h("type mismatch.");
        }
        int iM4906a = m4906a(0, 0, true);
        if (iM4906a < 0) {
            throw new C2078h("size invalid: ".concat(String.valueOf(iM4906a)));
        }
        double[] dArr = new double[iM4906a];
        for (int i10 = 0; i10 < iM4906a; i10++) {
            dArr[i10] = m4886a(dArr[0], 0, true);
        }
        return dArr;
    }

    public final void m4913a(byte[] bArr) {
        ByteBuffer byteBuffer = this.f7636b;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        this.f7636b = ByteBuffer.wrap(bArr);
    }

    public final byte[] m4916c(int i6, boolean z7) {
        if (!m4897b(i6)) {
            if (z7) {
                throw new C2078h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        m4894a(aVar);
        byte b8 = aVar.f7637a;
        if (b8 == 9) {
            int iM4906a = m4906a(0, 0, true);
            if (iM4906a < 0) {
                throw new C2078h("size invalid: ".concat(String.valueOf(iM4906a)));
            }
            byte[] bArr = new byte[iM4906a];
            for (int i10 = 0; i10 < iM4906a; i10++) {
                bArr[i10] = m4905a(bArr[0], 0, true);
            }
            return bArr;
        }
        if (b8 != 13) {
            throw new C2078h("type mismatch.");
        }
        a aVar2 = new a();
        m4894a(aVar2);
        if (aVar2.f7637a != 0) {
            StringBuilder sbM27u = AbstractC0004e.m27u(i6, "type mismatch, tag: ", ", type: ");
            sbM27u.append((int) aVar.f7637a);
            sbM27u.append(", ");
            sbM27u.append((int) aVar2.f7637a);
            throw new C2078h(sbM27u.toString());
        }
        int iM4906a2 = m4906a(0, 0, true);
        if (iM4906a2 >= 0) {
            byte[] bArr2 = new byte[iM4906a2];
            this.f7636b.get(bArr2);
            return bArr2;
        }
        StringBuilder sbM27u2 = AbstractC0004e.m27u(i6, "invalid size, tag: ", ", type: ");
        sbM27u2.append((int) aVar.f7637a);
        sbM27u2.append(", ");
        sbM27u2.append((int) aVar2.f7637a);
        sbM27u2.append(", size: ");
        sbM27u2.append(iM4906a2);
        throw new C2078h(sbM27u2.toString());
    }

    public C2084k(byte[] bArr) {
        this.f7636b = ByteBuffer.wrap(bArr);
    }

    private static int m4888a(a aVar, ByteBuffer byteBuffer) {
        byte b8 = byteBuffer.get();
        aVar.f7637a = (byte) (b8 & 15);
        int i6 = (b8 & 240) >> 4;
        aVar.f7638b = i6;
        if (i6 != 15) {
            return 1;
        }
        aVar.f7638b = byteBuffer.get();
        return 2;
    }

    public C2084k(byte[] bArr, byte b8) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        this.f7636b = byteBufferWrap;
        byteBufferWrap.position(4);
    }

    private void m4896b() {
        a aVar = new a();
        m4894a(aVar);
        m4892a(aVar.f7637a);
    }

    private void m4894a(a aVar) {
        m4888a(aVar, this.f7636b);
    }

    private void m4893a(int i6) {
        ByteBuffer byteBuffer = this.f7636b;
        byteBuffer.position(byteBuffer.position() + i6);
    }

    public final String m4915b(int i6, boolean z7) {
        if (!m4897b(i6)) {
            if (z7) {
                throw new C2078h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        m4894a(aVar);
        byte b8 = aVar.f7637a;
        if (b8 == 6) {
            int i10 = this.f7636b.get();
            if (i10 < 0) {
                i10 += 256;
            }
            byte[] bArr = new byte[i10];
            this.f7636b.get(bArr);
            try {
                return new String(bArr, this.f7635a);
            } catch (UnsupportedEncodingException unused) {
                return new String(bArr);
            }
        }
        if (b8 == 7) {
            int i11 = this.f7636b.getInt();
            if (i11 <= 104857600 && i11 >= 0) {
                byte[] bArr2 = new byte[i11];
                this.f7636b.get(bArr2);
                try {
                    return new String(bArr2, this.f7635a);
                } catch (UnsupportedEncodingException unused2) {
                    return new String(bArr2);
                }
            }
            throw new C2078h("String too long: ".concat(String.valueOf(i11)));
        }
        throw new C2078h("type mismatch.");
    }

    private void m4891a() {
        a aVar = new a();
        do {
            m4894a(aVar);
            m4892a(aVar.f7637a);
        } while (aVar.f7637a != 11);
    }

    private void m4892a(byte b8) {
        int i6 = 0;
        switch (b8) {
            case 0:
                m4893a(1);
                return;
            case 1:
                m4893a(2);
                return;
            case 2:
                m4893a(4);
                return;
            case 3:
                m4893a(8);
                return;
            case 4:
                m4893a(4);
                return;
            case 5:
                m4893a(8);
                return;
            case 6:
                int i10 = this.f7636b.get();
                if (i10 < 0) {
                    i10 += 256;
                }
                m4893a(i10);
                return;
            case 7:
                m4893a(this.f7636b.getInt());
                return;
            case 8:
                int iM4906a = m4906a(0, 0, true);
                while (i6 < iM4906a * 2) {
                    m4896b();
                    i6++;
                }
                return;
            case 9:
                int iM4906a2 = m4906a(0, 0, true);
                while (i6 < iM4906a2) {
                    m4896b();
                    i6++;
                }
                return;
            case 10:
                m4891a();
                return;
            case 11:
            case 12:
                return;
            case 13:
                a aVar = new a();
                m4894a(aVar);
                if (aVar.f7637a == 0) {
                    m4893a(m4906a(0, 0, true));
                    return;
                } else {
                    StringBuilder sbM27u = AbstractC0004e.m27u(b8, "skipField with invalid type, type value: ", ", ");
                    sbM27u.append((int) aVar.f7637a);
                    throw new C2078h(sbM27u.toString());
                }
            default:
                throw new C2078h("invalid type.");
        }
    }

    private <T> T[] m4898b(T t5, int i6, boolean z7) {
        if (!m4897b(i6)) {
            if (z7) {
                throw new C2078h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        m4894a(aVar);
        if (aVar.f7637a == 9) {
            int iM4906a = m4906a(0, 0, true);
            if (iM4906a >= 0) {
                T[] tArr = (T[]) ((Object[]) Array.newInstance(t5.getClass(), iM4906a));
                for (int i10 = 0; i10 < iM4906a; i10++) {
                    tArr[i10] = m4910a((Object) t5, 0, true);
                }
                return tArr;
            }
            throw new C2078h("size invalid: ".concat(String.valueOf(iM4906a)));
        }
        throw new C2078h("type mismatch.");
    }

    public final boolean m4914a(int i6, boolean z7) {
        return m4905a((byte) 0, i6, z7) != 0;
    }

    public final byte m4905a(byte b8, int i6, boolean z7) {
        if (!m4897b(i6)) {
            if (z7) {
                throw new C2078h("require field not exist.");
            }
            return b8;
        }
        a aVar = new a();
        m4894a(aVar);
        byte b10 = aVar.f7637a;
        if (b10 == 0) {
            return this.f7636b.get();
        }
        if (b10 == 12) {
            return (byte) 0;
        }
        throw new C2078h("type mismatch.");
    }

    public final short m4912a(short s10, int i6, boolean z7) {
        if (!m4897b(i6)) {
            if (z7) {
                throw new C2078h("require field not exist.");
            }
            return s10;
        }
        a aVar = new a();
        m4894a(aVar);
        byte b8 = aVar.f7637a;
        if (b8 == 0) {
            return this.f7636b.get();
        }
        if (b8 == 1) {
            return this.f7636b.getShort();
        }
        if (b8 == 12) {
            return (short) 0;
        }
        throw new C2078h("type mismatch.");
    }

    public final int m4906a(int i6, int i10, boolean z7) {
        if (!m4897b(i10)) {
            if (z7) {
                throw new C2078h("require field not exist.");
            }
            return i6;
        }
        a aVar = new a();
        m4894a(aVar);
        byte b8 = aVar.f7637a;
        if (b8 == 0) {
            return this.f7636b.get();
        }
        if (b8 == 1) {
            return this.f7636b.getShort();
        }
        if (b8 == 2) {
            return this.f7636b.getInt();
        }
        if (b8 == 12) {
            return 0;
        }
        throw new C2078h("type mismatch.");
    }

    public final long m4908a(long j10, int i6, boolean z7) {
        int i10;
        if (!m4897b(i6)) {
            if (z7) {
                throw new C2078h("require field not exist.");
            }
            return j10;
        }
        a aVar = new a();
        m4894a(aVar);
        byte b8 = aVar.f7637a;
        if (b8 == 0) {
            i10 = this.f7636b.get();
        } else if (b8 == 1) {
            i10 = this.f7636b.getShort();
        } else {
            if (b8 != 2) {
                if (b8 == 3) {
                    return this.f7636b.getLong();
                }
                if (b8 == 12) {
                    return 0L;
                }
                throw new C2078h("type mismatch.");
            }
            i10 = this.f7636b.getInt();
        }
        return i10;
    }

    private float m4887a(float f, int i6, boolean z7) {
        if (!m4897b(i6)) {
            if (z7) {
                throw new C2078h("require field not exist.");
            }
            return f;
        }
        a aVar = new a();
        m4894a(aVar);
        byte b8 = aVar.f7637a;
        if (b8 == 4) {
            return this.f7636b.getFloat();
        }
        if (b8 == 12) {
            return 0.0f;
        }
        throw new C2078h("type mismatch.");
    }

    private double m4886a(double d, int i6, boolean z7) {
        if (!m4897b(i6)) {
            if (z7) {
                throw new C2078h("require field not exist.");
            }
            return d;
        }
        a aVar = new a();
        m4894a(aVar);
        byte b8 = aVar.f7637a;
        if (b8 == 4) {
            return this.f7636b.getFloat();
        }
        if (b8 == 5) {
            return this.f7636b.getDouble();
        }
        if (b8 == 12) {
            return 0.0d;
        }
        throw new C2078h("type mismatch.");
    }

    public final <K, V> HashMap<K, V> m4911a(Map<K, V> map, int i6, boolean z7) {
        return (HashMap) m4890a(new HashMap(), map, i6, z7);
    }

    private <K, V> Map<K, V> m4890a(Map<K, V> map, Map<K, V> map2, int i6, boolean z7) {
        if (map2 != null && !map2.isEmpty()) {
            Map.Entry<K, V> next = map2.entrySet().iterator().next();
            K key = next.getKey();
            V value = next.getValue();
            if (m4897b(i6)) {
                a aVar = new a();
                m4894a(aVar);
                if (aVar.f7637a == 8) {
                    int iM4906a = m4906a(0, 0, true);
                    if (iM4906a < 0) {
                        throw new C2078h("size invalid: ".concat(String.valueOf(iM4906a)));
                    }
                    for (int i10 = 0; i10 < iM4906a; i10++) {
                        map.put(m4910a(key, 0, true), m4910a(value, 1, true));
                    }
                } else {
                    throw new C2078h("type mismatch.");
                }
            } else if (z7) {
                throw new C2078h("require field not exist.");
            }
            return map;
        }
        return new HashMap();
    }

    private <T> T[] m4895a(T[] tArr, int i6, boolean z7) {
        if (tArr != null && tArr.length != 0) {
            return (T[]) m4898b(tArr[0], i6, z7);
        }
        throw new C2078h("unable to get type of key and value.");
    }

    private <T> List<T> m4889a(List<T> list, int i6, boolean z7) {
        if (list != null && !list.isEmpty()) {
            Object[] objArrM4898b = m4898b(list.get(0), i6, z7);
            if (objArrM4898b == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : objArrM4898b) {
                arrayList.add(obj);
            }
            return arrayList;
        }
        return new ArrayList();
    }

    public final AbstractC2088m m4909a(AbstractC2088m abstractC2088m, int i6, boolean z7) {
        if (!m4897b(i6)) {
            if (z7) {
                throw new C2078h("require field not exist.");
            }
            return null;
        }
        try {
            AbstractC2088m abstractC2088m2 = (AbstractC2088m) abstractC2088m.getClass().newInstance();
            a aVar = new a();
            m4894a(aVar);
            if (aVar.f7637a == 10) {
                abstractC2088m2.mo4851a(this);
                m4891a();
                return abstractC2088m2;
            }
            throw new C2078h("type mismatch.");
        } catch (Exception e5) {
            throw new C2078h(e5.getMessage());
        }
    }

    public final <T> Object m4910a(T t5, int i6, boolean z7) {
        if (t5 instanceof Byte) {
            return Byte.valueOf(m4905a((byte) 0, i6, z7));
        }
        if (t5 instanceof Boolean) {
            return Boolean.valueOf(m4914a(i6, z7));
        }
        if (t5 instanceof Short) {
            return Short.valueOf(m4912a((short) 0, i6, z7));
        }
        if (t5 instanceof Integer) {
            return Integer.valueOf(m4906a(0, i6, z7));
        }
        if (t5 instanceof Long) {
            return Long.valueOf(m4908a(0L, i6, z7));
        }
        if (t5 instanceof Float) {
            return Float.valueOf(m4887a(0.0f, i6, z7));
        }
        if (t5 instanceof Double) {
            return Double.valueOf(m4886a(0.0d, i6, z7));
        }
        if (t5 instanceof String) {
            return String.valueOf(m4915b(i6, z7));
        }
        if (t5 instanceof Map) {
            return m4911a((Map) t5, i6, z7);
        }
        if (t5 instanceof List) {
            return m4889a((List) t5, i6, z7);
        }
        if (t5 instanceof AbstractC2088m) {
            return m4909a((AbstractC2088m) t5, i6, z7);
        }
        if (t5.getClass().isArray()) {
            if (!(t5 instanceof byte[]) && !(t5 instanceof Byte[])) {
                if (t5 instanceof boolean[]) {
                    return m4899d(i6, z7);
                }
                if (t5 instanceof short[]) {
                    return m4900e(i6, z7);
                }
                if (t5 instanceof int[]) {
                    return m4901f(i6, z7);
                }
                if (t5 instanceof long[]) {
                    return m4902g(i6, z7);
                }
                if (t5 instanceof float[]) {
                    return m4903h(i6, z7);
                }
                if (t5 instanceof double[]) {
                    return m4904i(i6, z7);
                }
                return m4895a((Object[]) t5, i6, z7);
            }
            return m4916c(i6, z7);
        }
        throw new C2078h("read object error: unsupport type.");
    }

    public final int m4907a(String str) {
        this.f7635a = str;
        return 0;
    }
}
