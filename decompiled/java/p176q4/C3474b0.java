package p176q4;

import android.util.Log;
import android.util.SparseIntArray;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.internal.cast.C1507a5;
import com.google.android.gms.internal.cast.C1522c0;
import com.google.android.gms.internal.cast.C1532d0;
import com.google.android.gms.internal.cast.C1540d8;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import p187r4.C3611a;
import p230v4.AbstractC3987a;
import p230v4.C3988b;

public final class C3474b0 {

    public final int f11753a;

    public final Object f11754b;

    public C3474b0(int i6, Object obj) {
        this.f11753a = i6;
        this.f11754b = obj;
    }

    public void m7107e(String str, long j10, int i6, long j11, long j12) {
        switch (this.f11753a) {
            case 0:
                C1507a5 c1507a5 = ((C3475c) this.f11754b).f11765l;
                if (c1507a5 != null) {
                    C1540d8 c1540d8M3261l = c1507a5.f5205a.m3261l();
                    C1522c0 c1522c0 = new C1522c0(str);
                    c1522c0.f5225b = j10;
                    c1522c0.f5226c = i6;
                    c1522c0.f5227d = j11;
                    c1522c0.f5228e = j12;
                    C1532d0 c1532d0 = new C1532d0(c1522c0);
                    c1532d0.f5242f = c1540d8M3261l.f5263h;
                    c1540d8M3261l.f5259d.add(c1532d0);
                }
                break;
        }
    }

    public void m7109g(int[] iArr) {
        switch (this.f11753a) {
            case 1:
                ArrayList arrayListM7971d = AbstractC3987a.m7971d(iArr);
                C3611a c3611a = (C3611a) this.f11754b;
                if (!c3611a.f12118d.equals(arrayListM7971d)) {
                    c3611a.m7250h();
                    c3611a.f12120f.evictAll();
                    c3611a.f12121g.clear();
                    c3611a.f12118d = arrayListM7971d;
                    C3611a.m7244b(c3611a);
                    c3611a.m7249g();
                    c3611a.m7248f();
                    break;
                }
                break;
        }
    }

    public void m7111i(int[] iArr, int i6) {
        int size;
        switch (this.f11753a) {
            case 1:
                if (i6 == 0) {
                    size = ((C3611a) this.f11754b).f12118d.size();
                } else {
                    C3611a c3611a = (C3611a) this.f11754b;
                    size = c3611a.f12119e.get(i6, -1);
                    if (size == -1) {
                        c3611a.m7246d();
                        return;
                    }
                }
                C3611a c3611a2 = (C3611a) this.f11754b;
                c3611a2.m7250h();
                c3611a2.f12118d.addAll(size, AbstractC3987a.m7971d(iArr));
                C3611a.m7244b(c3611a2);
                Set set = c3611a2.f12127m;
                synchronized (set) {
                    Iterator it = set.iterator();
                    if (it.hasNext()) {
                        if (it.next() != null) {
                            throw new ClassCastException();
                        }
                        throw null;
                    }
                }
                c3611a2.m7248f();
                return;
            default:
                return;
        }
    }

    public void m7113k(MediaQueueItem[] mediaQueueItemArr) {
        switch (this.f11753a) {
            case 1:
                HashSet hashSet = new HashSet();
                C3611a c3611a = (C3611a) this.f11754b;
                ArrayList arrayList = c3611a.f12121g;
                arrayList.clear();
                int i6 = 0;
                while (true) {
                    int length = mediaQueueItemArr.length;
                    SparseIntArray sparseIntArray = c3611a.f12119e;
                    if (i6 >= length) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            int i10 = sparseIntArray.get(((Integer) it.next()).intValue(), -1);
                            if (i10 != -1) {
                                hashSet.add(Integer.valueOf(i10));
                            }
                        }
                        arrayList.clear();
                        ArrayList arrayList2 = new ArrayList(hashSet);
                        Collections.sort(arrayList2);
                        c3611a.m7250h();
                        AbstractC3987a.m7973f(arrayList2);
                        C3611a.m7243a(c3611a);
                        c3611a.m7248f();
                    } else {
                        MediaQueueItem mediaQueueItem = mediaQueueItemArr[i6];
                        int i11 = mediaQueueItem.f4696b;
                        c3611a.f12120f.put(Integer.valueOf(i11), mediaQueueItem);
                        int i12 = sparseIntArray.get(i11, -1);
                        if (i12 == -1) {
                            c3611a.m7246d();
                        } else {
                            hashSet.add(Integer.valueOf(i12));
                            i6++;
                        }
                    }
                    break;
                }
                break;
        }
    }

    public void m7115m(int[] iArr) {
        switch (this.f11753a) {
            case 1:
                ArrayList arrayList = new ArrayList();
                for (int i6 : iArr) {
                    C3611a c3611a = (C3611a) this.f11754b;
                    c3611a.f12120f.remove(Integer.valueOf(i6));
                    SparseIntArray sparseIntArray = c3611a.f12119e;
                    int i10 = sparseIntArray.get(i6, -1);
                    if (i10 == -1) {
                        c3611a.m7246d();
                        return;
                    } else {
                        sparseIntArray.delete(i6);
                        arrayList.add(Integer.valueOf(i10));
                    }
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                Collections.sort(arrayList);
                C3611a c3611a2 = (C3611a) this.f11754b;
                c3611a2.m7250h();
                c3611a2.f12118d.removeAll(AbstractC3987a.m7971d(iArr));
                C3611a.m7244b(c3611a2);
                AbstractC3987a.m7973f(arrayList);
                Set set = c3611a2.f12127m;
                synchronized (set) {
                    Iterator it = set.iterator();
                    if (it.hasNext()) {
                        if (it.next() != null) {
                            throw new ClassCastException();
                        }
                        throw null;
                    }
                }
                c3611a2.m7248f();
                return;
            default:
                return;
        }
    }

    public void m7117o(ArrayList arrayList, ArrayList arrayList2, int i6) {
        switch (this.f11753a) {
            case 1:
                ArrayList arrayList3 = new ArrayList();
                if (i6 == 0) {
                    ((C3611a) this.f11754b).f12118d.size();
                } else if (arrayList2.isEmpty()) {
                    C3988b c3988b = ((C3611a) this.f11754b).f12115a;
                    Log.w(c3988b.f13521a, c3988b.m7977d("Received a Queue Reordered message with an empty reordered items IDs list.", new Object[0]));
                } else {
                    SparseIntArray sparseIntArray = ((C3611a) this.f11754b).f12119e;
                    if (sparseIntArray.get(i6, -1) == -1) {
                        sparseIntArray.get(((Integer) arrayList2.get(0)).intValue(), -1);
                    }
                }
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    int iIntValue = ((Integer) it.next()).intValue();
                    C3611a c3611a = (C3611a) this.f11754b;
                    int i10 = c3611a.f12119e.get(iIntValue, -1);
                    if (i10 == -1) {
                        c3611a.m7246d();
                        return;
                    }
                    arrayList3.add(Integer.valueOf(i10));
                }
                C3611a c3611a2 = (C3611a) this.f11754b;
                c3611a2.m7250h();
                c3611a2.f12118d = arrayList;
                C3611a.m7244b(c3611a2);
                Set set = c3611a2.f12127m;
                synchronized (set) {
                    Iterator it2 = set.iterator();
                    if (it2.hasNext()) {
                        if (it2.next() != null) {
                            throw new ClassCastException();
                        }
                        throw null;
                    }
                }
                c3611a2.m7248f();
                return;
            default:
                return;
        }
    }

    public void m7119q(int[] iArr) {
        switch (this.f11753a) {
            case 1:
                ArrayList arrayList = new ArrayList();
                int i6 = 0;
                while (true) {
                    int length = iArr.length;
                    C3611a c3611a = (C3611a) this.f11754b;
                    if (i6 >= length) {
                        Collections.sort(arrayList);
                        c3611a.m7250h();
                        AbstractC3987a.m7973f(arrayList);
                        C3611a.m7243a(c3611a);
                        c3611a.m7248f();
                    } else {
                        int i10 = iArr[i6];
                        c3611a.f12120f.remove(Integer.valueOf(i10));
                        int i11 = c3611a.f12119e.get(i10, -1);
                        if (i11 == -1) {
                            c3611a.m7246d();
                        } else {
                            arrayList.add(Integer.valueOf(i11));
                            i6++;
                        }
                    }
                    break;
                }
                break;
        }
    }

    public final void m7103a() {
    }

    public final void m7104b() {
    }

    public final void m7105c() {
    }

    public final void m7106d() {
    }

    public final void m7121s() {
    }

    public final void m7110h(int[] iArr) {
    }

    public final void m7114l(MediaQueueItem[] mediaQueueItemArr) {
    }

    public final void m7116n(int[] iArr) {
    }

    public final void m7120r(int[] iArr) {
    }

    public final void m7112j(int[] iArr, int i6) {
    }

    public final void m7118p(ArrayList arrayList, ArrayList arrayList2, int i6) {
    }

    public final void m7108f(String str, long j10, int i6, long j11, long j12) {
    }
}
