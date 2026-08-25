package com.tencent.bugly.proguard;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public final class C2080i {

    private StringBuilder f7625a;

    private int f7626b;

    public C2080i(StringBuilder sb, int i6) {
        this.f7625a = sb;
        this.f7626b = i6;
    }

    private void m4876a(String str) {
        for (int i6 = 0; i6 < this.f7626b; i6++) {
            this.f7625a.append('\t');
        }
        if (str != null) {
            StringBuilder sb = this.f7625a;
            sb.append(str);
            sb.append(": ");
        }
    }

    public final C2080i m4884a(boolean z7, String str) {
        m4876a(str);
        StringBuilder sb = this.f7625a;
        sb.append(z7 ? 'T' : 'F');
        sb.append('\n');
        return this;
    }

    public final C2080i m4877a(byte b8, String str) {
        m4876a(str);
        StringBuilder sb = this.f7625a;
        sb.append((int) b8);
        sb.append('\n');
        return this;
    }

    private C2080i m4865a(char c5, String str) {
        m4876a(str);
        StringBuilder sb = this.f7625a;
        sb.append(c5);
        sb.append('\n');
        return this;
    }

    public final C2080i m4883a(short s10, String str) {
        m4876a(str);
        StringBuilder sb = this.f7625a;
        sb.append((int) s10);
        sb.append('\n');
        return this;
    }

    public final C2080i m4878a(int i6, String str) {
        m4876a(str);
        StringBuilder sb = this.f7625a;
        sb.append(i6);
        sb.append('\n');
        return this;
    }

    public final C2080i m4879a(long j10, String str) {
        m4876a(str);
        StringBuilder sb = this.f7625a;
        sb.append(j10);
        sb.append('\n');
        return this;
    }

    private C2080i m4867a(float f, String str) {
        m4876a(str);
        StringBuilder sb = this.f7625a;
        sb.append(f);
        sb.append('\n');
        return this;
    }

    private C2080i m4866a(double d, String str) {
        m4876a(str);
        StringBuilder sb = this.f7625a;
        sb.append(d);
        sb.append('\n');
        return this;
    }

    public final C2080i m4881a(String str, String str2) {
        m4876a(str2);
        if (str == null) {
            this.f7625a.append("null\n");
        } else {
            StringBuilder sb = this.f7625a;
            sb.append(str);
            sb.append('\n');
        }
        return this;
    }

    public final C2080i m4885a(byte[] bArr, String str) {
        m4876a(str);
        if (bArr == null) {
            this.f7625a.append("null\n");
            return this;
        }
        if (bArr.length == 0) {
            StringBuilder sb = this.f7625a;
            sb.append(bArr.length);
            sb.append(", []\n");
            return this;
        }
        StringBuilder sb2 = this.f7625a;
        sb2.append(bArr.length);
        sb2.append(", [\n");
        C2080i c2080i = new C2080i(this.f7625a, this.f7626b + 1);
        for (byte b8 : bArr) {
            c2080i.m4877a(b8, (String) null);
        }
        m4865a(']', (String) null);
        return this;
    }

    private C2080i m4875a(short[] sArr, String str) {
        m4876a(str);
        if (sArr == null) {
            this.f7625a.append("null\n");
            return this;
        }
        if (sArr.length == 0) {
            StringBuilder sb = this.f7625a;
            sb.append(sArr.length);
            sb.append(", []\n");
            return this;
        }
        StringBuilder sb2 = this.f7625a;
        sb2.append(sArr.length);
        sb2.append(", [\n");
        C2080i c2080i = new C2080i(this.f7625a, this.f7626b + 1);
        for (short s10 : sArr) {
            c2080i.m4883a(s10, (String) null);
        }
        m4865a(']', (String) null);
        return this;
    }

    private C2080i m4872a(int[] iArr, String str) {
        m4876a(str);
        if (iArr == null) {
            this.f7625a.append("null\n");
            return this;
        }
        if (iArr.length == 0) {
            StringBuilder sb = this.f7625a;
            sb.append(iArr.length);
            sb.append(", []\n");
            return this;
        }
        StringBuilder sb2 = this.f7625a;
        sb2.append(iArr.length);
        sb2.append(", [\n");
        C2080i c2080i = new C2080i(this.f7625a, this.f7626b + 1);
        for (int i6 : iArr) {
            c2080i.m4878a(i6, (String) null);
        }
        m4865a(']', (String) null);
        return this;
    }

    private C2080i m4873a(long[] jArr, String str) {
        m4876a(str);
        if (jArr == null) {
            this.f7625a.append("null\n");
            return this;
        }
        if (jArr.length == 0) {
            StringBuilder sb = this.f7625a;
            sb.append(jArr.length);
            sb.append(", []\n");
            return this;
        }
        StringBuilder sb2 = this.f7625a;
        sb2.append(jArr.length);
        sb2.append(", [\n");
        C2080i c2080i = new C2080i(this.f7625a, this.f7626b + 1);
        for (long j10 : jArr) {
            c2080i.m4879a(j10, (String) null);
        }
        m4865a(']', (String) null);
        return this;
    }

    private C2080i m4871a(float[] fArr, String str) {
        m4876a(str);
        if (fArr == null) {
            this.f7625a.append("null\n");
            return this;
        }
        if (fArr.length == 0) {
            StringBuilder sb = this.f7625a;
            sb.append(fArr.length);
            sb.append(", []\n");
            return this;
        }
        StringBuilder sb2 = this.f7625a;
        sb2.append(fArr.length);
        sb2.append(", [\n");
        C2080i c2080i = new C2080i(this.f7625a, this.f7626b + 1);
        for (float f : fArr) {
            c2080i.m4867a(f, (String) null);
        }
        m4865a(']', (String) null);
        return this;
    }

    private C2080i m4870a(double[] dArr, String str) {
        m4876a(str);
        if (dArr == null) {
            this.f7625a.append("null\n");
            return this;
        }
        if (dArr.length == 0) {
            StringBuilder sb = this.f7625a;
            sb.append(dArr.length);
            sb.append(", []\n");
            return this;
        }
        StringBuilder sb2 = this.f7625a;
        sb2.append(dArr.length);
        sb2.append(", [\n");
        C2080i c2080i = new C2080i(this.f7625a, this.f7626b + 1);
        for (double d : dArr) {
            c2080i.m4866a(d, (String) null);
        }
        m4865a(']', (String) null);
        return this;
    }

    public final <K, V> C2080i m4882a(Map<K, V> map, String str) {
        m4876a(str);
        if (map == null) {
            this.f7625a.append("null\n");
            return this;
        }
        if (map.isEmpty()) {
            StringBuilder sb = this.f7625a;
            sb.append(map.size());
            sb.append(", {}\n");
            return this;
        }
        StringBuilder sb2 = this.f7625a;
        sb2.append(map.size());
        sb2.append(", {\n");
        C2080i c2080i = new C2080i(this.f7625a, this.f7626b + 1);
        C2080i c2080i2 = new C2080i(this.f7625a, this.f7626b + 2);
        for (Map.Entry<K, V> entry : map.entrySet()) {
            c2080i.m4865a('(', (String) null);
            c2080i2.m4868a(entry.getKey(), (String) null);
            c2080i2.m4868a(entry.getValue(), (String) null);
            c2080i.m4865a(')', (String) null);
        }
        m4865a('}', (String) null);
        return this;
    }

    private <T> C2080i m4874a(T[] tArr, String str) {
        m4876a(str);
        if (tArr == null) {
            this.f7625a.append("null\n");
            return this;
        }
        if (tArr.length == 0) {
            StringBuilder sb = this.f7625a;
            sb.append(tArr.length);
            sb.append(", []\n");
            return this;
        }
        StringBuilder sb2 = this.f7625a;
        sb2.append(tArr.length);
        sb2.append(", [\n");
        C2080i c2080i = new C2080i(this.f7625a, this.f7626b + 1);
        for (T t5 : tArr) {
            c2080i.m4868a(t5, (String) null);
        }
        m4865a(']', (String) null);
        return this;
    }

    private <T> C2080i m4869a(Collection<T> collection, String str) {
        if (collection == null) {
            m4876a(str);
            this.f7625a.append("null\t");
            return this;
        }
        return m4874a(collection.toArray(), str);
    }

    private <T> C2080i m4868a(T t5, String str) {
        if (t5 == 0) {
            this.f7625a.append("null\n");
        } else if (t5 instanceof Byte) {
            m4877a(((Byte) t5).byteValue(), str);
        } else if (t5 instanceof Boolean) {
            m4884a(((Boolean) t5).booleanValue(), str);
        } else if (t5 instanceof Short) {
            m4883a(((Short) t5).shortValue(), str);
        } else if (t5 instanceof Integer) {
            m4878a(((Integer) t5).intValue(), str);
        } else if (t5 instanceof Long) {
            m4879a(((Long) t5).longValue(), str);
        } else if (t5 instanceof Float) {
            m4867a(((Float) t5).floatValue(), str);
        } else if (t5 instanceof Double) {
            m4866a(((Double) t5).doubleValue(), str);
        } else if (t5 instanceof String) {
            m4881a((String) t5, str);
        } else if (t5 instanceof Map) {
            m4882a((Map) t5, str);
        } else if (t5 instanceof List) {
            m4869a((Collection) t5, str);
        } else if (t5 instanceof AbstractC2088m) {
            m4880a((AbstractC2088m) t5, str);
        } else if (t5 instanceof byte[]) {
            m4885a((byte[]) t5, str);
        } else if (t5 instanceof boolean[]) {
            m4868a((boolean[]) t5, str);
        } else if (t5 instanceof short[]) {
            m4875a((short[]) t5, str);
        } else if (t5 instanceof int[]) {
            m4872a((int[]) t5, str);
        } else if (t5 instanceof long[]) {
            m4873a((long[]) t5, str);
        } else if (t5 instanceof float[]) {
            m4871a((float[]) t5, str);
        } else if (t5 instanceof double[]) {
            m4870a((double[]) t5, str);
        } else if (t5.getClass().isArray()) {
            m4874a((Object[]) t5, str);
        } else {
            throw new C2082j("write object error: unsupport type.");
        }
        return this;
    }

    public final C2080i m4880a(AbstractC2088m abstractC2088m, String str) {
        m4865a('{', str);
        if (abstractC2088m == null) {
            StringBuilder sb = this.f7625a;
            sb.append('\t');
            sb.append("null");
        } else {
            abstractC2088m.mo4853a(this.f7625a, this.f7626b + 1);
        }
        m4865a('}', (String) null);
        return this;
    }
}
