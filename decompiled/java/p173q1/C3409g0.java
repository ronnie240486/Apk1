package p173q1;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Messenger;
import android.util.SparseArray;
import androidx.appcompat.app.C0157r0;
import androidx.mediarouter.media.MediaRouteProviderService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import p041d7.C2203g0;
import p160p.C3341e;

public final class C3409g0 extends C3418j0 {

    public final C3341e f11476i;

    public final Handler f11477j;

    public final Map f11478k;

    public final C3412h0 f11479l;

    public C3409g0(C3412h0 c3412h0, Messenger messenger, int i6, String str) {
        super(c3412h0, messenger, i6, str);
        this.f11479l = c3412h0;
        this.f11476i = new C3341e(0);
        this.f11477j = new Handler(Looper.getMainLooper());
        if (i6 < 4) {
            this.f11478k = new C3341e(0);
        } else {
            this.f11478k = Collections.emptyMap();
        }
    }

    @Override
    public final Bundle mo6928a(C0157r0 c0157r0) {
        Map map = this.f11478k;
        boolean zIsEmpty = map.isEmpty();
        int i6 = this.f11529b;
        if (zIsEmpty) {
            return MediaRouteProviderService.m2804a(c0157r0, i6);
        }
        ArrayList arrayList = new ArrayList();
        for (C3454w c3454w : (List) c0157r0.f429c) {
            if (map.containsKey(c3454w.m7089f())) {
                new ArrayList();
                new ArrayList();
                new HashSet();
                Bundle bundle = new Bundle(c3454w.f11701a);
                ArrayList arrayListM7087d = c3454w.m7087d();
                ArrayList arrayListM7085b = c3454w.m7085b();
                HashSet hashSetM7084a = c3454w.m7084a();
                bundle.putBoolean("enabled", false);
                bundle.putParcelableArrayList("controlFilters", new ArrayList<>(arrayListM7085b));
                bundle.putStringArrayList("groupMemberIds", new ArrayList<>(arrayListM7087d));
                bundle.putStringArrayList("allowedPackages", new ArrayList<>(hashSetM7084a));
                arrayList.add(new C3454w(bundle));
            } else {
                arrayList.add(c3454w);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll((List) c0157r0.f429c);
        arrayList2.clear();
        arrayList2.addAll(arrayList);
        return MediaRouteProviderService.m2804a(new C0157r0(arrayList2, c0157r0.f428b), i6);
    }

    @Override
    public final Bundle mo6929b(String str, C3400d0 c3400d0, int i6) {
        Bundle bundleMo6929b = super.mo6929b(str, c3400d0, i6);
        if (bundleMo6929b != null && this.f11530c != null) {
            this.f11479l.f11514i.m7080e(this, (AbstractC3397c0) this.f11533f.get(i6), i6, this.f11530c, str);
        }
        return bundleMo6929b;
    }

    @Override
    public final boolean mo6930c(String str, String str2, C3400d0 c3400d0, int i6) {
        C3341e c3341e = this.f11476i;
        AbstractC3397c0 abstractC3397c0 = (AbstractC3397c0) c3341e.get(str);
        SparseArray sparseArray = this.f11533f;
        if (abstractC3397c0 != null) {
            sparseArray.put(i6, abstractC3397c0);
            return true;
        }
        boolean zMo6930c = super.mo6930c(str, str2, c3400d0, i6);
        if (str2 == null && zMo6930c && this.f11530c != null) {
            this.f11479l.f11514i.m7080e(this, (AbstractC3397c0) sparseArray.get(i6), i6, this.f11530c, str);
        }
        if (zMo6930c) {
            c3341e.put(str, (AbstractC3397c0) sparseArray.get(i6));
        }
        return zMo6930c;
    }

    @Override
    public final void mo6931d() {
        SparseArray sparseArray = this.f11533f;
        int size = sparseArray.size();
        for (int i6 = 0; i6 < size; i6++) {
            this.f11479l.f11514i.m7081f(sparseArray.keyAt(i6));
        }
        this.f11476i.clear();
        super.mo6931d();
    }

    @Override
    public final boolean mo6932f(int i6) {
        C0157r0 c0157r0;
        C3412h0 c3412h0 = this.f11479l;
        c3412h0.f11514i.m7081f(i6);
        AbstractC3397c0 abstractC3397c0 = (AbstractC3397c0) this.f11533f.get(i6);
        if (abstractC3397c0 != null) {
            C3341e c3341e = this.f11476i;
            for (Map.Entry entry : (C2203g0) c3341e.entrySet()) {
                if (entry.getValue() == abstractC3397c0) {
                    c3341e.remove(entry.getKey());
                    break;
                }
            }
        }
        Map map = this.f11478k;
        for (Map.Entry entry2 : map.entrySet()) {
            if (((Integer) entry2.getValue()).intValue() == i6) {
                if (map.remove((String) entry2.getKey()) != null && (c0157r0 = c3412h0.f11538a.f3441d.f11456g) != null) {
                    MediaRouteProviderService.m2806e(this.f11528a, 5, 0, 0, mo6928a(c0157r0), null);
                    break;
                }
                break;
                break;
            }
        }
        return super.mo6932f(i6);
    }

    @Override
    public final void mo6933g(AbstractC3394b0 abstractC3394b0, C3454w c3454w, ArrayList arrayList) {
        super.mo6933g(abstractC3394b0, c3454w, arrayList);
        C3452v c3452v = this.f11479l.f11514i;
        if (c3452v != null) {
            c3452v.m7082g(abstractC3394b0, c3454w, arrayList);
        }
    }
}
