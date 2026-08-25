package p101j7;

import android.util.Base64;
import android.util.JsonWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import p080h7.C2664b;
import p080h7.C2665c;
import p080h7.InterfaceC2666d;
import p080h7.InterfaceC2667e;
import p080h7.InterfaceC2668f;
import p080h7.InterfaceC2669g;

public final class C2785f implements InterfaceC2667e, InterfaceC2669g {

    public final boolean f9511a = true;

    public final JsonWriter f9512b;

    public final HashMap f9513c;

    public final HashMap f9514d;

    public final C2780a f9515e;

    public final boolean f9516f;

    public C2785f(BufferedWriter bufferedWriter, HashMap map, HashMap map2, C2780a c2780a, boolean z7) {
        this.f9512b = new JsonWriter(bufferedWriter);
        this.f9513c = map;
        this.f9514d = map2;
        this.f9515e = c2780a;
        this.f9516f = z7;
    }

    @Override
    public final InterfaceC2667e mo5671a(C2665c c2665c, long j10) throws IOException {
        String str = c2665c.f9295a;
        m5769g();
        JsonWriter jsonWriter = this.f9512b;
        jsonWriter.name(str);
        m5769g();
        jsonWriter.value(j10);
        return this;
    }

    @Override
    public final InterfaceC2669g mo5673b(String str) throws IOException {
        m5769g();
        this.f9512b.value(str);
        return this;
    }

    @Override
    public final InterfaceC2669g mo5674c(boolean z7) throws IOException {
        m5769g();
        this.f9512b.value(z7);
        return this;
    }

    @Override
    public final InterfaceC2667e mo5672d(C2665c c2665c, Object obj) throws IOException {
        m5768f(obj, c2665c.f9295a);
        return this;
    }

    public final C2785f m5767e(Object obj) throws IOException {
        int i6 = 0;
        JsonWriter jsonWriter = this.f9512b;
        if (obj == null) {
            jsonWriter.nullValue();
            return this;
        }
        if (obj instanceof Number) {
            jsonWriter.value((Number) obj);
            return this;
        }
        if (!obj.getClass().isArray()) {
            if (obj instanceof Collection) {
                jsonWriter.beginArray();
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    m5767e(it.next());
                }
                jsonWriter.endArray();
                return this;
            }
            if (obj instanceof Map) {
                jsonWriter.beginObject();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object key = entry.getKey();
                    try {
                        m5768f(entry.getValue(), (String) key);
                    } catch (ClassCastException e5) {
                        throw new C2664b(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e5);
                    }
                }
                jsonWriter.endObject();
                return this;
            }
            InterfaceC2666d interfaceC2666d = (InterfaceC2666d) this.f9513c.get(obj.getClass());
            if (interfaceC2666d != null) {
                jsonWriter.beginObject();
                interfaceC2666d.mo192a(obj, this);
                jsonWriter.endObject();
                return this;
            }
            InterfaceC2668f interfaceC2668f = (InterfaceC2668f) this.f9514d.get(obj.getClass());
            if (interfaceC2668f != null) {
                interfaceC2668f.mo192a(obj, this);
                return this;
            }
            if (!(obj instanceof Enum)) {
                jsonWriter.beginObject();
                this.f9515e.mo192a(obj, this);
                throw null;
            }
            String strName = ((Enum) obj).name();
            m5769g();
            jsonWriter.value(strName);
            return this;
        }
        if (obj instanceof byte[]) {
            m5769g();
            jsonWriter.value(Base64.encodeToString((byte[]) obj, 2));
            return this;
        }
        jsonWriter.beginArray();
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            int length = iArr.length;
            while (i6 < length) {
                jsonWriter.value(iArr[i6]);
                i6++;
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            int length2 = jArr.length;
            while (i6 < length2) {
                long j10 = jArr[i6];
                m5769g();
                jsonWriter.value(j10);
                i6++;
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length3 = dArr.length;
            while (i6 < length3) {
                jsonWriter.value(dArr[i6]);
                i6++;
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            int length4 = zArr.length;
            while (i6 < length4) {
                jsonWriter.value(zArr[i6]);
                i6++;
            }
        } else if (obj instanceof Number[]) {
            Number[] numberArr = (Number[]) obj;
            int length5 = numberArr.length;
            while (i6 < length5) {
                m5767e(numberArr[i6]);
                i6++;
            }
        } else {
            Object[] objArr = (Object[]) obj;
            int length6 = objArr.length;
            while (i6 < length6) {
                m5767e(objArr[i6]);
                i6++;
            }
        }
        jsonWriter.endArray();
        return this;
    }

    public final C2785f m5768f(Object obj, String str) throws IOException {
        boolean z7 = this.f9516f;
        JsonWriter jsonWriter = this.f9512b;
        if (z7) {
            if (obj != null) {
                m5769g();
                jsonWriter.name(str);
                m5767e(obj);
            }
            return this;
        }
        m5769g();
        jsonWriter.name(str);
        if (obj == null) {
            jsonWriter.nullValue();
        } else {
            m5767e(obj);
        }
        return this;
    }

    public final void m5769g() {
        if (!this.f9511a) {
            throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
        }
    }
}
