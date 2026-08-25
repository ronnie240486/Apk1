package p028c6;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import android.view.View;
import coil.memory.MemoryCache$Key;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;
import p018b5.AbstractC1312l;
import p049e3.C2378a0;
import p097j3.InterfaceC2770a;
import p106k0.C2859g;
import p108k2.C2867e;
import p148o0.AbstractC3236k;
import p148o0.InterfaceC3244s;
import p228v2.C3981h;
import p247x2.InterfaceC4102x;
import p253x8.AbstractC4147j;
import p256y.AbstractC4193j;
import p256y.C4194k;
import p256y.C4195l;

public final class C1399b implements InterfaceC3244s, InterfaceC2770a {

    public int f4261a;

    public final Object f4262b;

    public C1399b(int i6, Object obj) {
        this.f4262b = obj;
        this.f4261a = i6;
    }

    public void m3269a() {
        WeakReference weakReference;
        this.f4261a = 0;
        Iterator it = ((LinkedHashMap) this.f4262b).values().iterator();
        while (it.hasNext()) {
            ArrayList arrayList = (ArrayList) it.next();
            if (arrayList.size() <= 1) {
                C2867e c2867e = (C2867e) AbstractC4147j.m8182V(arrayList);
                if (((c2867e == null || (weakReference = c2867e.f9799b) == null) ? null : (Bitmap) weakReference.get()) == null) {
                    it.remove();
                }
            } else {
                int size = arrayList.size();
                int i6 = 0;
                for (int i10 = 0; i10 < size; i10++) {
                    int i11 = i10 - i6;
                    if (((C2867e) arrayList.get(i11)).f9799b.get() == null) {
                        arrayList.remove(i11);
                        i6++;
                    }
                }
                if (arrayList.isEmpty()) {
                    it.remove();
                }
            }
        }
    }

    public synchronized void m3270b(MemoryCache$Key memoryCache$Key, Bitmap bitmap, Map map, int i6) {
        try {
            LinkedHashMap linkedHashMap = (LinkedHashMap) this.f4262b;
            Object arrayList = linkedHashMap.get(memoryCache$Key);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(memoryCache$Key, arrayList);
            }
            ArrayList arrayList2 = (ArrayList) arrayList;
            int iIdentityHashCode = System.identityHashCode(bitmap);
            C2867e c2867e = new C2867e(iIdentityHashCode, new WeakReference(bitmap), map, i6);
            int size = arrayList2.size();
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    arrayList2.add(c2867e);
                    break;
                }
                C2867e c2867e2 = (C2867e) arrayList2.get(i10);
                if (i6 >= c2867e2.f9801d) {
                    if (c2867e2.f9798a != iIdentityHashCode || c2867e2.f9799b.get() != bitmap) {
                        arrayList2.add(i10, c2867e);
                        break;
                    } else {
                        arrayList2.set(i10, c2867e);
                        break;
                    }
                }
                i10++;
            }
            int i11 = this.f4261a;
            this.f4261a = i11 + 1;
            if (i11 >= 10) {
                m3269a();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public int m3271c(int i6) {
        int i10;
        float f = -1;
        SparseArray sparseArray = (SparseArray) this.f4262b;
        int i11 = 0;
        if (-1 == i6) {
            C4194k c4194k = i6 == -1 ? (C4194k) sparseArray.valueAt(0) : (C4194k) sparseArray.get(-1);
            if (c4194k == null) {
                return -1;
            }
            while (true) {
                ArrayList arrayList = c4194k.f14257b;
                if (i11 >= arrayList.size()) {
                    i11 = -1;
                    break;
                }
                if (((C4195l) arrayList.get(i11)).m8248a(f, f)) {
                    break;
                }
                i11++;
            }
            if (-1 == i11) {
                return -1;
            }
            i10 = i11 == -1 ? c4194k.f14258c : ((C4195l) c4194k.f14257b.get(i11)).f14263e;
        } else {
            C4194k c4194k2 = (C4194k) sparseArray.get(i6);
            if (c4194k2 == null) {
                return -1;
            }
            while (true) {
                ArrayList arrayList2 = c4194k2.f14257b;
                if (i11 >= arrayList2.size()) {
                    i11 = -1;
                    break;
                }
                if (((C4195l) arrayList2.get(i11)).m8248a(f, f)) {
                    break;
                }
                i11++;
            }
            i10 = i11 == -1 ? c4194k2.f14258c : ((C4195l) c4194k2.f14257b.get(i11)).f14263e;
        }
        return i10;
    }

    public synchronized void m3272d(int i6) {
        if (i6 >= 10 && i6 != 20) {
            m3269a();
        }
    }

    @Override
    public InterfaceC4102x mo89e(InterfaceC4102x interfaceC4102x, C3981h c3981h) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ((Bitmap) interfaceC4102x.get()).compress((Bitmap.CompressFormat) this.f4262b, this.f4261a, byteArrayOutputStream);
        interfaceC4102x.mo5405d();
        return new C2378a0(byteArrayOutputStream.toByteArray());
    }

    @Override
    public boolean perform(View view, AbstractC3236k abstractC3236k) {
        ((BottomSheetBehavior) this.f4262b).m4124A(this.f4261a);
        return true;
    }

    public C1399b(ConnectionResult connectionResult, int i6) {
        AbstractC1312l.m3198e(connectionResult);
        this.f4262b = connectionResult;
        this.f4261a = i6;
    }

    public C1399b(int i6) {
        switch (i6) {
            case 3:
                this.f4262b = new LinkedHashMap();
                break;
            default:
                this.f4262b = Bitmap.CompressFormat.JPEG;
                this.f4261a = 100;
                break;
        }
    }

    public C1399b(Context context, XmlResourceParser xmlResourceParser) {
        byte b8;
        this.f4261a = -1;
        this.f4262b = new SparseArray();
        new SparseArray();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), AbstractC4193j.f14252r);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i6 = 0; i6 < indexCount; i6++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i6);
            if (index == 0) {
                this.f4261a = typedArrayObtainStyledAttributes.getResourceId(index, this.f4261a);
            }
        }
        try {
            int eventType = xmlResourceParser.getEventType();
            C4194k c4194k = null;
            while (eventType != 1) {
                if (eventType == 0) {
                    xmlResourceParser.getName();
                } else if (eventType != 2) {
                    if (eventType == 3 && "StateSet".equals(xmlResourceParser.getName())) {
                        return;
                    }
                } else {
                    String name = xmlResourceParser.getName();
                    switch (name.hashCode()) {
                        case 80204913:
                            if (name.equals("State")) {
                                b8 = 2;
                            } else {
                                b8 = -1;
                            }
                            break;
                        case 1301459538:
                            if (name.equals("LayoutDescription")) {
                                b8 = 0;
                            } else {
                                b8 = -1;
                            }
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                b8 = 1;
                            } else {
                                b8 = -1;
                            }
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                b8 = 3;
                            } else {
                                b8 = -1;
                            }
                            break;
                        default:
                            b8 = -1;
                            break;
                    }
                    if (b8 != 0 && b8 != 1) {
                        if (b8 == 2) {
                            c4194k = new C4194k(context, xmlResourceParser);
                            ((SparseArray) this.f4262b).put(c4194k.f14256a, c4194k);
                        } else if (b8 != 3) {
                            Log.v("ConstraintLayoutStates", "unknown tag " + name);
                        } else {
                            C4195l c4195l = new C4195l(context, xmlResourceParser);
                            if (c4194k != null) {
                                c4194k.f14257b.add(c4195l);
                            }
                        }
                    }
                }
                eventType = xmlResourceParser.next();
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        } catch (XmlPullParserException e10) {
            e10.printStackTrace();
        }
    }

    public C1399b(int i6, C2859g[] c2859gArr) {
        this.f4261a = i6;
        this.f4262b = c2859gArr;
    }
}
