package p097j3;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import p131m3.C3077d;
import p173q1.C3424l0;
import p228v2.InterfaceC3984k;

public final class C2772c {

    public ArrayList f9487a;

    public C2772c(int i6) {
        switch (i6) {
            case 1:
                this.f9487a = new ArrayList();
                break;
            case 2:
                this.f9487a = new ArrayList();
                break;
            case 3:
                this.f9487a = new ArrayList();
                break;
            default:
                this.f9487a = new ArrayList();
                break;
        }
    }

    public void m5742a(ArrayList arrayList) {
        if (arrayList.isEmpty()) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str == null) {
                throw new IllegalArgumentException("category must not be null");
            }
            if (this.f9487a == null) {
                this.f9487a = new ArrayList();
            }
            if (!this.f9487a.contains(str)) {
                this.f9487a.add(str);
            }
        }
    }

    public C3424l0 m5743b() {
        if (this.f9487a == null) {
            return C3424l0.f11567c;
        }
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("controlCategories", this.f9487a);
        return new C3424l0(bundle, this.f9487a);
    }

    public synchronized InterfaceC2770a m5744c(Class cls, Class cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return C2773d.f9488b;
        }
        for (C2771b c2771b : this.f9487a) {
            if (c2771b.f9484a.isAssignableFrom(cls) && cls2.isAssignableFrom(c2771b.f9485b)) {
                return c2771b.f9486c;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    public synchronized InterfaceC3984k m5745d(Class cls) {
        int size = this.f9487a.size();
        for (int i6 = 0; i6 < size; i6++) {
            C3077d c3077d = (C3077d) this.f9487a.get(i6);
            if (c3077d.f10542a.isAssignableFrom(cls)) {
                return c3077d.f10543b;
            }
        }
        return null;
    }

    public synchronized ArrayList m5746e(Class cls, Class cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        for (C2771b c2771b : this.f9487a) {
            if ((c2771b.f9484a.isAssignableFrom(cls) && cls2.isAssignableFrom(c2771b.f9485b)) && !arrayList.contains(c2771b.f9485b)) {
                arrayList.add(c2771b.f9485b);
            }
        }
        return arrayList;
    }

    public C2772c(C3424l0 c3424l0) {
        if (c3424l0 != null) {
            c3424l0.m7000a();
            if (c3424l0.f11569b.isEmpty()) {
                return;
            }
            this.f9487a = new ArrayList(c3424l0.f11569b);
            return;
        }
        throw new IllegalArgumentException("selector must not be null");
    }
}
