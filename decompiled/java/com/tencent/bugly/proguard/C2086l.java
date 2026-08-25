package com.tencent.bugly.proguard;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class C2086l {

    public ByteBuffer f7641a;

    protected String f7642b;

    public C2086l(int i6) {
        this.f7642b = "GBK";
        this.f7641a = ByteBuffer.allocate(i6);
    }

    private void m4919a(int i6) {
        if (this.f7641a.remaining() < i6) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate((this.f7641a.capacity() + i6) * 2);
            byteBufferAllocate.put(this.f7641a.array(), 0, this.f7641a.position());
            this.f7641a = byteBufferAllocate;
        }
    }

    private void m4927b(byte b8, int i6) {
        if (i6 < 15) {
            this.f7641a.put((byte) (b8 | (i6 << 4)));
        } else {
            if (i6 >= 256) {
                throw new C2082j("tag is too large: ".concat(String.valueOf(i6)));
            }
            this.f7641a.put((byte) (b8 | 240));
            this.f7641a.put((byte) i6);
        }
    }

    public C2086l() {
        this(128);
    }

    public final void m4938a(boolean z7, int i6) {
        m4929a(z7 ? (byte) 1 : (byte) 0, i6);
    }

    public final void m4929a(byte b8, int i6) {
        m4919a(3);
        if (b8 == 0) {
            m4927b((byte) 12, i6);
        } else {
            m4927b((byte) 0, i6);
            this.f7641a.put(b8);
        }
    }

    public final void m4937a(short s10, int i6) {
        m4919a(4);
        if (s10 >= -128 && s10 <= 127) {
            m4929a((byte) s10, i6);
        } else {
            m4927b((byte) 1, i6);
            this.f7641a.putShort(s10);
        }
    }

    public final void m4930a(int i6, int i10) {
        m4919a(6);
        if (i6 >= -32768 && i6 <= 32767) {
            m4937a((short) i6, i10);
        } else {
            m4927b((byte) 2, i10);
            this.f7641a.putInt(i6);
        }
    }

    public final void m4931a(long j10, int i6) {
        m4919a(10);
        if (j10 >= -2147483648L && j10 <= 2147483647L) {
            m4930a((int) j10, i6);
        } else {
            m4927b((byte) 3, i6);
            this.f7641a.putLong(j10);
        }
    }

    private void m4918a(float f, int i6) {
        m4919a(6);
        m4927b((byte) 4, i6);
        this.f7641a.putFloat(f);
    }

    private void m4917a(double d, int i6) {
        m4919a(10);
        m4927b((byte) 5, i6);
        this.f7641a.putDouble(d);
    }

    public final void m4934a(String str, int i6) {
        byte[] bytes;
        try {
            bytes = str.getBytes(this.f7642b);
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        m4919a(bytes.length + 10);
        if (bytes.length > 255) {
            m4927b((byte) 7, i6);
            this.f7641a.putInt(bytes.length);
            this.f7641a.put(bytes);
        } else {
            m4927b((byte) 6, i6);
            this.f7641a.put((byte) bytes.length);
            this.f7641a.put(bytes);
        }
    }

    public final <K, V> void m4936a(Map<K, V> map, int i6) {
        m4919a(8);
        m4927b((byte) 8, i6);
        m4930a(map == null ? 0 : map.size(), 0);
        if (map != null) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                m4933a(entry.getKey(), 0);
                m4933a(entry.getValue(), 1);
            }
        }
    }

    private void m4926a(boolean[] zArr, int i6) {
        m4919a(8);
        m4927b((byte) 9, i6);
        m4930a(zArr.length, 0);
        for (boolean z7 : zArr) {
            m4938a(z7, 0);
        }
    }

    public final void m4939a(byte[] bArr, int i6) {
        m4919a(bArr.length + 8);
        m4927b((byte) 13, i6);
        m4927b((byte) 0, 0);
        m4930a(bArr.length, 0);
        this.f7641a.put(bArr);
    }

    private void m4925a(short[] sArr, int i6) {
        m4919a(8);
        m4927b((byte) 9, i6);
        m4930a(sArr.length, 0);
        for (short s10 : sArr) {
            m4937a(s10, 0);
        }
    }

    private void m4922a(int[] iArr, int i6) {
        m4919a(8);
        m4927b((byte) 9, i6);
        m4930a(iArr.length, 0);
        for (int i10 : iArr) {
            m4930a(i10, 0);
        }
    }

    private void m4923a(long[] jArr, int i6) {
        m4919a(8);
        m4927b((byte) 9, i6);
        m4930a(jArr.length, 0);
        for (long j10 : jArr) {
            m4931a(j10, 0);
        }
    }

    private void m4921a(float[] fArr, int i6) {
        m4919a(8);
        m4927b((byte) 9, i6);
        m4930a(fArr.length, 0);
        for (float f : fArr) {
            m4918a(f, 0);
        }
    }

    private void m4920a(double[] dArr, int i6) {
        m4919a(8);
        m4927b((byte) 9, i6);
        m4930a(dArr.length, 0);
        for (double d : dArr) {
            m4917a(d, 0);
        }
    }

    private void m4924a(Object[] objArr, int i6) {
        m4919a(8);
        m4927b((byte) 9, i6);
        m4930a(objArr.length, 0);
        for (Object obj : objArr) {
            m4933a(obj, 0);
        }
    }

    public final <T> void m4935a(Collection<T> collection, int i6) {
        m4919a(8);
        m4927b((byte) 9, i6);
        m4930a(collection == null ? 0 : collection.size(), 0);
        if (collection != null) {
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                m4933a(it.next(), 0);
            }
        }
    }

    public final void m4932a(AbstractC2088m abstractC2088m, int i6) {
        m4919a(2);
        m4927b((byte) 10, i6);
        abstractC2088m.mo4852a(this);
        m4919a(2);
        m4927b((byte) 11, 0);
    }

    public final void m4933a(Object obj, int i6) {
        if (obj instanceof Byte) {
            m4929a(((Byte) obj).byteValue(), i6);
            return;
        }
        if (obj instanceof Boolean) {
            m4938a(((Boolean) obj).booleanValue(), i6);
            return;
        }
        if (obj instanceof Short) {
            m4937a(((Short) obj).shortValue(), i6);
            return;
        }
        if (obj instanceof Integer) {
            m4930a(((Integer) obj).intValue(), i6);
            return;
        }
        if (obj instanceof Long) {
            m4931a(((Long) obj).longValue(), i6);
            return;
        }
        if (obj instanceof Float) {
            m4918a(((Float) obj).floatValue(), i6);
            return;
        }
        if (obj instanceof Double) {
            m4917a(((Double) obj).doubleValue(), i6);
            return;
        }
        if (obj instanceof String) {
            m4934a((String) obj, i6);
            return;
        }
        if (obj instanceof Map) {
            m4936a((Map) obj, i6);
            return;
        }
        if (obj instanceof List) {
            m4935a((Collection) obj, i6);
            return;
        }
        if (obj instanceof AbstractC2088m) {
            m4932a((AbstractC2088m) obj, i6);
            return;
        }
        if (obj instanceof byte[]) {
            m4939a((byte[]) obj, i6);
            return;
        }
        if (obj instanceof boolean[]) {
            m4926a((boolean[]) obj, i6);
            return;
        }
        if (obj instanceof short[]) {
            m4925a((short[]) obj, i6);
            return;
        }
        if (obj instanceof int[]) {
            m4922a((int[]) obj, i6);
            return;
        }
        if (obj instanceof long[]) {
            m4923a((long[]) obj, i6);
            return;
        }
        if (obj instanceof float[]) {
            m4921a((float[]) obj, i6);
            return;
        }
        if (obj instanceof double[]) {
            m4920a((double[]) obj, i6);
            return;
        }
        if (obj.getClass().isArray()) {
            m4924a((Object[]) obj, i6);
        } else if (obj instanceof Collection) {
            m4935a((Collection) obj, i6);
        } else {
            throw new C2082j("write object error: unsupport type. " + obj.getClass());
        }
    }

    public final int m4928a(String str) {
        this.f7642b = str;
        return 0;
    }
}
