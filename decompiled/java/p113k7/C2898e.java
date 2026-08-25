package p113k7;

import com.lzy.okgo.cache.CacheEntity;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import p050e4.EnumC2411c;
import p080h7.C2664b;
import p080h7.C2665c;
import p080h7.InterfaceC2666d;
import p080h7.InterfaceC2667e;
import p080h7.InterfaceC2668f;
import p101j7.C2780a;

public final class C2898e implements InterfaceC2667e {

    public static final Charset f9840f = Charset.forName("UTF-8");

    public static final C2665c f9841g;

    public static final C2665c f9842h;

    public static final C2780a f9843i;

    public OutputStream f9844a;

    public final HashMap f9845b;

    public final HashMap f9846c;

    public final C2780a f9847d;

    public final C2900g f9848e = new C2900g(this);

    static {
        C2894a c2894a = new C2894a(1);
        HashMap map = new HashMap();
        map.put(InterfaceC2897d.class, c2894a);
        f9841g = new C2665c(CacheEntity.KEY, Collections.unmodifiableMap(new HashMap(map)));
        C2894a c2894a2 = new C2894a(2);
        HashMap map2 = new HashMap();
        map2.put(InterfaceC2897d.class, c2894a2);
        f9842h = new C2665c("value", Collections.unmodifiableMap(new HashMap(map2)));
        f9843i = new C2780a(1);
    }

    public C2898e(ByteArrayOutputStream byteArrayOutputStream, HashMap map, HashMap map2, C2780a c2780a) {
        this.f9844a = byteArrayOutputStream;
        this.f9845b = map;
        this.f9846c = map2;
        this.f9847d = c2780a;
    }

    public static int m5897f(C2665c c2665c) {
        InterfaceC2897d interfaceC2897d = (InterfaceC2897d) ((Annotation) c2665c.f9296b.get(InterfaceC2897d.class));
        if (interfaceC2897d != null) {
            return ((C2894a) interfaceC2897d).f9836a;
        }
        throw new C2664b("Field has no @Protobuf config");
    }

    @Override
    public final InterfaceC2667e mo5671a(C2665c c2665c, long j10) throws IOException {
        if (j10 != 0) {
            InterfaceC2897d interfaceC2897d = (InterfaceC2897d) ((Annotation) c2665c.f9296b.get(InterfaceC2897d.class));
            if (interfaceC2897d == null) {
                throw new C2664b("Field has no @Protobuf config");
            }
            m5901g(((C2894a) interfaceC2897d).f9836a << 3);
            m5902h(j10);
        }
        return this;
    }

    public final void m5898b(C2665c c2665c, int i6, boolean z7) {
        if (z7 && i6 == 0) {
            return;
        }
        InterfaceC2897d interfaceC2897d = (InterfaceC2897d) ((Annotation) c2665c.f9296b.get(InterfaceC2897d.class));
        if (interfaceC2897d == null) {
            throw new C2664b("Field has no @Protobuf config");
        }
        m5901g(((C2894a) interfaceC2897d).f9836a << 3);
        m5901g(i6);
    }

    public final void m5899c(C2665c c2665c, Object obj, boolean z7) {
        if (obj == null) {
            return;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z7 && charSequence.length() == 0) {
                return;
            }
            m5901g((m5897f(c2665c) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(f9840f);
            m5901g(bytes.length);
            this.f9844a.write(bytes);
            return;
        }
        if (obj instanceof Collection) {
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                m5899c(c2665c, it.next(), false);
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                m5900e(f9843i, c2665c, (Map.Entry) it2.next(), false);
            }
            return;
        }
        if (obj instanceof Double) {
            double dDoubleValue = ((Double) obj).doubleValue();
            if (z7 && dDoubleValue == 0.0d) {
                return;
            }
            m5901g((m5897f(c2665c) << 3) | 1);
            this.f9844a.write(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putDouble(dDoubleValue).array());
            return;
        }
        if (obj instanceof Float) {
            float fFloatValue = ((Float) obj).floatValue();
            if (z7 && fFloatValue == 0.0f) {
                return;
            }
            m5901g((m5897f(c2665c) << 3) | 5);
            this.f9844a.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putFloat(fFloatValue).array());
            return;
        }
        if (obj instanceof Number) {
            long jLongValue = ((Number) obj).longValue();
            if (z7 && jLongValue == 0) {
                return;
            }
            InterfaceC2897d interfaceC2897d = (InterfaceC2897d) ((Annotation) c2665c.f9296b.get(InterfaceC2897d.class));
            if (interfaceC2897d == null) {
                throw new C2664b("Field has no @Protobuf config");
            }
            m5901g(((C2894a) interfaceC2897d).f9836a << 3);
            m5902h(jLongValue);
            return;
        }
        if (obj instanceof Boolean) {
            m5898b(c2665c, ((Boolean) obj).booleanValue() ? 1 : 0, z7);
            return;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            if (z7 && bArr.length == 0) {
                return;
            }
            m5901g((m5897f(c2665c) << 3) | 2);
            m5901g(bArr.length);
            this.f9844a.write(bArr);
            return;
        }
        InterfaceC2666d interfaceC2666d = (InterfaceC2666d) this.f9845b.get(obj.getClass());
        if (interfaceC2666d != null) {
            m5900e(interfaceC2666d, c2665c, obj, z7);
            return;
        }
        InterfaceC2668f interfaceC2668f = (InterfaceC2668f) this.f9846c.get(obj.getClass());
        if (interfaceC2668f != null) {
            C2900g c2900g = this.f9848e;
            c2900g.f9850a = false;
            c2900g.f9852c = c2665c;
            c2900g.f9851b = z7;
            interfaceC2668f.mo192a(obj, c2900g);
            return;
        }
        if (obj instanceof EnumC2411c) {
            m5898b(c2665c, ((EnumC2411c) obj).f8413a, true);
        } else if (obj instanceof Enum) {
            m5898b(c2665c, ((Enum) obj).ordinal(), true);
        } else {
            m5900e(this.f9847d, c2665c, obj, z7);
        }
    }

    @Override
    public final InterfaceC2667e mo5672d(C2665c c2665c, Object obj) {
        m5899c(c2665c, obj, true);
        return this;
    }

    public final void m5900e(InterfaceC2666d interfaceC2666d, C2665c c2665c, Object obj, boolean z7) throws IOException {
        C2895b c2895b = new C2895b();
        c2895b.f9837a = 0L;
        try {
            OutputStream outputStream = this.f9844a;
            this.f9844a = c2895b;
            try {
                interfaceC2666d.mo192a(obj, this);
                this.f9844a = outputStream;
                long j10 = c2895b.f9837a;
                c2895b.close();
                if (z7 && j10 == 0) {
                    return;
                }
                m5901g((m5897f(c2665c) << 3) | 2);
                m5902h(j10);
                interfaceC2666d.mo192a(obj, this);
            } catch (Throwable th) {
                this.f9844a = outputStream;
                throw th;
            }
        } catch (Throwable th2) {
            try {
                c2895b.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public final void m5901g(int i6) throws IOException {
        while ((i6 & (-128)) != 0) {
            this.f9844a.write((i6 & 127) | 128);
            i6 >>>= 7;
        }
        this.f9844a.write(i6 & 127);
    }

    public final void m5902h(long j10) throws IOException {
        while (((-128) & j10) != 0) {
            this.f9844a.write((((int) j10) & 127) | 128);
            j10 >>>= 7;
        }
        this.f9844a.write(((int) j10) & 127);
    }
}
