package p173q1;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import androidx.appcompat.app.C0157r0;
import androidx.mediarouter.media.MediaRouteProviderService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import p101j7.C2782c;
import p222u7.AbstractC3928d;

public class C3418j0 implements IBinder.DeathRecipient {

    public final Messenger f11528a;

    public final int f11529b;

    public final String f11530c;

    public C3456x f11531d;

    public long f11532e;

    public final SparseArray f11533f = new SparseArray();

    public final C2782c f11534g = new C2782c(28, this);

    public final C3421k0 f11535h;

    public C3418j0(C3421k0 c3421k0, Messenger messenger, int i6, String str) {
        this.f11535h = c3421k0;
        this.f11528a = messenger;
        this.f11529b = i6;
        this.f11530c = str;
    }

    public Bundle mo6928a(C0157r0 c0157r0) {
        return MediaRouteProviderService.m2804a(c0157r0, this.f11529b);
    }

    public Bundle mo6929b(String str, C3400d0 c3400d0, int i6) {
        SparseArray sparseArray = this.f11533f;
        if (sparseArray.indexOfKey(i6) >= 0) {
            return null;
        }
        C3421k0 c3421k0 = this.f11535h;
        AbstractC3394b0 abstractC3394b0Mo6902a = c3421k0.f11538a.f3441d.mo6902a(str, c3400d0);
        if (abstractC3394b0Mo6902a == null) {
            return null;
        }
        abstractC3394b0Mo6902a.m6893q(AbstractC3928d.m7849m(c3421k0.f11538a.getApplicationContext()), this.f11534g);
        sparseArray.put(i6, abstractC3394b0Mo6902a);
        Bundle bundle = new Bundle();
        bundle.putString("groupableTitle", abstractC3394b0Mo6902a.mo6887k());
        bundle.putString("transferableTitle", abstractC3394b0Mo6902a.mo6888l());
        return bundle;
    }

    @Override
    public final void binderDied() {
        this.f11535h.f11538a.f3439b.obtainMessage(1, this.f11528a).sendToTarget();
    }

    public boolean mo6930c(String str, String str2, C3400d0 c3400d0, int i6) {
        SparseArray sparseArray = this.f11533f;
        if (sparseArray.indexOfKey(i6) >= 0) {
            return false;
        }
        C3421k0 c3421k0 = this.f11535h;
        AbstractC3397c0 abstractC3397c0Mo6905d = str2 == null ? c3421k0.f11538a.f3441d.mo6905d(str, c3400d0) : c3421k0.f11538a.f3441d.mo6904c(str, str2);
        if (abstractC3397c0Mo6905d == null) {
            return false;
        }
        sparseArray.put(i6, abstractC3397c0Mo6905d);
        return true;
    }

    public void mo6931d() {
        SparseArray sparseArray = this.f11533f;
        int size = sparseArray.size();
        for (int i6 = 0; i6 < size; i6++) {
            ((AbstractC3397c0) sparseArray.valueAt(i6)).mo6897e();
        }
        sparseArray.clear();
        this.f11528a.getBinder().unlinkToDeath(this, 0);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (Objects.equals(this.f11531d, null)) {
            return;
        }
        this.f11531d = null;
        this.f11532e = jElapsedRealtime;
        this.f11535h.m6998h();
    }

    public final AbstractC3397c0 m6994e(int i6) {
        return (AbstractC3397c0) this.f11533f.get(i6);
    }

    public boolean mo6932f(int i6) {
        SparseArray sparseArray = this.f11533f;
        AbstractC3397c0 abstractC3397c0 = (AbstractC3397c0) sparseArray.get(i6);
        if (abstractC3397c0 == null) {
            return false;
        }
        sparseArray.remove(i6);
        abstractC3397c0.mo6897e();
        return true;
    }

    public void mo6933g(AbstractC3394b0 abstractC3394b0, C3454w c3454w, ArrayList arrayList) {
        SparseArray sparseArray = this.f11533f;
        int iIndexOfValue = sparseArray.indexOfValue(abstractC3394b0);
        if (iIndexOfValue < 0) {
            Log.w("MediaRouteProviderSrv", "Ignoring unknown dynamic group route controller: " + abstractC3394b0);
            return;
        }
        int iKeyAt = sparseArray.keyAt(iIndexOfValue);
        ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C3460z c3460z = (C3460z) it.next();
            if (c3460z.f11724f == null) {
                Bundle bundle = new Bundle();
                c3460z.f11724f = bundle;
                bundle.putBundle("mrDescriptor", c3460z.f11719a.f11701a);
                c3460z.f11724f.putInt("selectionState", c3460z.f11720b);
                c3460z.f11724f.putBoolean("isUnselectable", c3460z.f11721c);
                c3460z.f11724f.putBoolean("isGroupable", c3460z.f11722d);
                c3460z.f11724f.putBoolean("isTransferable", c3460z.f11723e);
            }
            arrayList2.add(c3460z.f11724f);
        }
        Bundle bundle2 = new Bundle();
        if (c3454w != null) {
            bundle2.putParcelable("groupRoute", c3454w.f11701a);
        }
        bundle2.putParcelableArrayList("dynamicRoutes", arrayList2);
        MediaRouteProviderService.m2806e(this.f11528a, 7, 0, iKeyAt, bundle2, null);
    }

    public final String toString() {
        int i6 = MediaRouteProviderService.f3437f;
        return "Client connection " + this.f11528a.getBinder().toString();
    }
}
