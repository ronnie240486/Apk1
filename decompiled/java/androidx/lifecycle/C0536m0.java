package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import com.lzy.okgo.cache.CacheEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import p000a.C0002c;
import p094j0.AbstractC2755c;
import p103j9.AbstractC2796i;
import p227v1.InterfaceC3972d;
import p235v9.C4024b;
import p235v9.InterfaceC4023a;
import p243w8.C4064f;
import p253x8.AbstractC4158u;

public final class C0536m0 {

    public static final Class[] f2498f = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};

    public final LinkedHashMap f2499a;

    public final LinkedHashMap f2500b;

    public final LinkedHashMap f2501c;

    public final LinkedHashMap f2502d;

    public final InterfaceC3972d f2503e;

    public C0536m0(HashMap map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f2499a = linkedHashMap;
        this.f2500b = new LinkedHashMap();
        this.f2501c = new LinkedHashMap();
        this.f2502d = new LinkedHashMap();
        this.f2503e = new C0002c(1, this);
        linkedHashMap.putAll(map);
    }

    public static Bundle m1500a(C0536m0 c0536m0) {
        AbstractC2796i.m5785f(c0536m0, "this$0");
        Iterator it = AbstractC4158u.m8198r(c0536m0.f2500b).entrySet().iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            LinkedHashMap linkedHashMap = c0536m0.f2499a;
            if (!zHasNext) {
                Set<String> setKeySet = linkedHashMap.keySet();
                ArrayList arrayList = new ArrayList(setKeySet.size());
                ArrayList arrayList2 = new ArrayList(arrayList.size());
                for (String str : setKeySet) {
                    arrayList.add(str);
                    arrayList2.add(linkedHashMap.get(str));
                }
                C4064f[] c4064fArr = {new C4064f("keys", arrayList), new C4064f("values", arrayList2)};
                Bundle bundle = new Bundle(2);
                for (int i6 = 0; i6 < 2; i6++) {
                    C4064f c4064f = c4064fArr[i6];
                    String str2 = (String) c4064f.f13727a;
                    Object obj = c4064f.f13728b;
                    if (obj == null) {
                        bundle.putString(str2, null);
                    } else if (obj instanceof Boolean) {
                        bundle.putBoolean(str2, ((Boolean) obj).booleanValue());
                    } else if (obj instanceof Byte) {
                        bundle.putByte(str2, ((Number) obj).byteValue());
                    } else if (obj instanceof Character) {
                        bundle.putChar(str2, ((Character) obj).charValue());
                    } else if (obj instanceof Double) {
                        bundle.putDouble(str2, ((Number) obj).doubleValue());
                    } else if (obj instanceof Float) {
                        bundle.putFloat(str2, ((Number) obj).floatValue());
                    } else if (obj instanceof Integer) {
                        bundle.putInt(str2, ((Number) obj).intValue());
                    } else if (obj instanceof Long) {
                        bundle.putLong(str2, ((Number) obj).longValue());
                    } else if (obj instanceof Short) {
                        bundle.putShort(str2, ((Number) obj).shortValue());
                    } else if (obj instanceof Bundle) {
                        bundle.putBundle(str2, (Bundle) obj);
                    } else if (obj instanceof CharSequence) {
                        bundle.putCharSequence(str2, (CharSequence) obj);
                    } else if (obj instanceof Parcelable) {
                        bundle.putParcelable(str2, (Parcelable) obj);
                    } else if (obj instanceof boolean[]) {
                        bundle.putBooleanArray(str2, (boolean[]) obj);
                    } else if (obj instanceof byte[]) {
                        bundle.putByteArray(str2, (byte[]) obj);
                    } else if (obj instanceof char[]) {
                        bundle.putCharArray(str2, (char[]) obj);
                    } else if (obj instanceof double[]) {
                        bundle.putDoubleArray(str2, (double[]) obj);
                    } else if (obj instanceof float[]) {
                        bundle.putFloatArray(str2, (float[]) obj);
                    } else if (obj instanceof int[]) {
                        bundle.putIntArray(str2, (int[]) obj);
                    } else if (obj instanceof long[]) {
                        bundle.putLongArray(str2, (long[]) obj);
                    } else if (obj instanceof short[]) {
                        bundle.putShortArray(str2, (short[]) obj);
                    } else if (obj instanceof Object[]) {
                        Class<?> componentType = obj.getClass().getComponentType();
                        AbstractC2796i.m5782c(componentType);
                        if (Parcelable.class.isAssignableFrom(componentType)) {
                            bundle.putParcelableArray(str2, (Parcelable[]) obj);
                        } else if (String.class.isAssignableFrom(componentType)) {
                            bundle.putStringArray(str2, (String[]) obj);
                        } else if (CharSequence.class.isAssignableFrom(componentType)) {
                            bundle.putCharSequenceArray(str2, (CharSequence[]) obj);
                        } else {
                            if (!Serializable.class.isAssignableFrom(componentType)) {
                                throw new IllegalArgumentException("Illegal value array type " + componentType.getCanonicalName() + " for key \"" + str2 + '\"');
                            }
                            bundle.putSerializable(str2, (Serializable) obj);
                        }
                    } else if (obj instanceof Serializable) {
                        bundle.putSerializable(str2, (Serializable) obj);
                    } else if (obj instanceof IBinder) {
                        bundle.putBinder(str2, (IBinder) obj);
                    } else if (obj instanceof Size) {
                        AbstractC2755c.m5722a(bundle, str2, (Size) obj);
                    } else {
                        if (!(obj instanceof SizeF)) {
                            throw new IllegalArgumentException("Illegal value type " + obj.getClass().getCanonicalName() + " for key \"" + str2 + '\"');
                        }
                        AbstractC2755c.m5723b(bundle, str2, (SizeF) obj);
                    }
                }
                return bundle;
            }
            Map.Entry entry = (Map.Entry) it.next();
            String str3 = (String) entry.getKey();
            Bundle bundleSaveState = ((InterfaceC3972d) entry.getValue()).saveState();
            AbstractC2796i.m5785f(str3, CacheEntity.KEY);
            if (bundleSaveState != null) {
                Class[] clsArr = f2498f;
                int i10 = 0;
                while (true) {
                    if (i10 >= 29) {
                        throw new IllegalArgumentException("Can't put value with type " + bundleSaveState.getClass() + " into saved state");
                    }
                    Class cls = clsArr[i10];
                    AbstractC2796i.m5782c(cls);
                    if (cls.isInstance(bundleSaveState)) {
                        break;
                    }
                    i10++;
                }
            }
            Object obj2 = c0536m0.f2501c.get(str3);
            C0518d0 c0518d0 = obj2 instanceof C0518d0 ? (C0518d0) obj2 : null;
            if (c0518d0 != null) {
                c0518d0.m1490j(bundleSaveState);
            } else {
                linkedHashMap.put(str3, bundleSaveState);
            }
            InterfaceC4023a interfaceC4023a = (InterfaceC4023a) c0536m0.f2502d.get(str3);
            if (interfaceC4023a != null) {
                ((C4024b) interfaceC4023a).m8012a(bundleSaveState);
            }
        }
    }

    public C0536m0() {
        this.f2499a = new LinkedHashMap();
        this.f2500b = new LinkedHashMap();
        this.f2501c = new LinkedHashMap();
        this.f2502d = new LinkedHashMap();
        this.f2503e = new C0002c(1, this);
    }
}
