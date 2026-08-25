package p173q1;

import android.content.ComponentName;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.lzy.okgo.model.Progress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Objects;
import p128m0.C3026b;

public class C3445s0 {

    public final C3442r0 f11652a;

    public final String f11653b;

    public final String f11654c;

    public String f11655d;

    public String f11656e;

    public Uri f11657f;

    public boolean f11658g;

    public final boolean f11659h;

    public int f11660i;

    public boolean f11661j;

    public int f11663l;

    public int f11664m;

    public int f11665n;

    public int f11666o;

    public int f11667p;

    public int f11668q;

    public Bundle f11670s;

    public IntentSender f11671t;

    public C3454w f11672u;

    public final ArrayList f11662k = new ArrayList();

    public int f11669r = -1;

    public ArrayList f11673v = new ArrayList();

    public C3445s0(C3442r0 c3442r0, String str, String str2, boolean z7) {
        this.f11652a = c3442r0;
        this.f11653b = str;
        this.f11654c = str2;
        this.f11659h = z7;
    }

    public static AbstractC3394b0 m7018b() {
        C3451u0.m7067b();
        AbstractC3397c0 abstractC3397c0 = C3451u0.m7068c().f11492e;
        if (abstractC3397c0 instanceof AbstractC3394b0) {
            return (AbstractC3394b0) abstractC3397c0;
        }
        return null;
    }

    public final C3436p0 m7019a() {
        if (this instanceof C3436p0) {
            return (C3436p0) this;
        }
        return null;
    }

    public final AbstractC3403e0 m7020c() {
        C3442r0 c3442r0 = this.f11652a;
        c3442r0.getClass();
        C3451u0.m7067b();
        return c3442r0.f11643a;
    }

    public final boolean m7021d() {
        C3451u0.m7067b();
        C3445s0 c3445s0 = C3451u0.m7068c().f11509v;
        if (c3445s0 == null) {
            throw new IllegalStateException("There is no default route.  The media router has not yet been fully initialized.");
        }
        if (c3445s0 == this || this.f11665n == 3) {
            return true;
        }
        return TextUtils.equals(((ComponentName) m7020c().f11451b.f9501b).getPackageName(), "android") && m7030m("android.media.intent.category.LIVE_AUDIO") && !m7030m("android.media.intent.category.LIVE_VIDEO");
    }

    public final boolean m7022e() {
        return !this.f11673v.isEmpty();
    }

    public final boolean m7023f() {
        return this.f11672u != null && this.f11658g;
    }

    public final boolean m7024g() {
        C3451u0.m7067b();
        return C3451u0.m7068c().m6940g() == this;
    }

    public final boolean m7025h(C3424l0 c3424l0) {
        if (c3424l0 == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        C3451u0.m7067b();
        ArrayList<IntentFilter> arrayList = this.f11662k;
        if (arrayList == null) {
            return false;
        }
        c3424l0.m7000a();
        if (c3424l0.f11569b.isEmpty()) {
            return false;
        }
        for (IntentFilter intentFilter : arrayList) {
            if (intentFilter != null) {
                Iterator it = c3424l0.f11569b.iterator();
                while (it.hasNext()) {
                    if (intentFilter.hasCategory((String) it.next())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int m7026i(C3454w c3454w) {
        int i6;
        C3445s0 c3445s0;
        int iCountActions;
        if (this.f11672u == c3454w) {
            return 0;
        }
        this.f11672u = c3454w;
        if (c3454w == null) {
            return 0;
        }
        if (Objects.equals(this.f11655d, c3454w.m7090g())) {
            i6 = 0;
        } else {
            this.f11655d = c3454w.m7090g();
            i6 = 1;
        }
        String str = this.f11656e;
        Bundle bundle = c3454w.f11701a;
        if (!Objects.equals(str, bundle.getString(Progress.STATUS))) {
            this.f11656e = bundle.getString(Progress.STATUS);
            i6 = 1;
        }
        if (!Objects.equals(this.f11657f, c3454w.m7088e())) {
            this.f11657f = c3454w.m7088e();
            i6 = 1;
        }
        if (this.f11658g != bundle.getBoolean("enabled", true)) {
            this.f11658g = bundle.getBoolean("enabled", true);
            i6 = 1;
        }
        if (this.f11660i != bundle.getInt("connectionState", 0)) {
            this.f11660i = bundle.getInt("connectionState", 0);
            i6 = 1;
        }
        ArrayList arrayList = this.f11662k;
        ArrayList arrayListM7085b = c3454w.m7085b();
        if (arrayList != arrayListM7085b) {
            if (arrayList != null) {
                ListIterator listIterator = arrayList.listIterator();
                ListIterator listIterator2 = arrayListM7085b.listIterator();
                while (true) {
                    if (listIterator.hasNext() && listIterator2.hasNext()) {
                        IntentFilter intentFilter = (IntentFilter) listIterator.next();
                        IntentFilter intentFilter2 = (IntentFilter) listIterator2.next();
                        if (intentFilter != intentFilter2) {
                            if (intentFilter != null && intentFilter2 != null && (iCountActions = intentFilter.countActions()) == intentFilter2.countActions()) {
                                int i10 = 0;
                                while (true) {
                                    if (i10 >= iCountActions) {
                                        int iCountCategories = intentFilter.countCategories();
                                        if (iCountCategories == intentFilter2.countCategories()) {
                                            int i11 = 0;
                                            while (true) {
                                                if (i11 >= iCountCategories) {
                                                    continue;
                                                } else if (intentFilter.getCategory(i11).equals(intentFilter2.getCategory(i11))) {
                                                    i11++;
                                                }
                                            }
                                        }
                                    } else if (intentFilter.getAction(i10).equals(intentFilter2.getAction(i10))) {
                                        i10++;
                                    }
                                }
                            }
                        }
                    } else if (listIterator.hasNext() || listIterator2.hasNext()) {
                    }
                    arrayList.clear();
                    arrayList.addAll(c3454w.m7085b());
                    i6 = 1;
                }
            } else {
                arrayList.clear();
                arrayList.addAll(c3454w.m7085b());
                i6 = 1;
            }
        }
        if (this.f11663l != bundle.getInt("playbackType", 1)) {
            this.f11663l = bundle.getInt("playbackType", 1);
            i6 = 1;
        }
        if (this.f11664m != bundle.getInt("playbackStream", -1)) {
            this.f11664m = bundle.getInt("playbackStream", -1);
            i6 = 1;
        }
        if (this.f11665n != c3454w.m7086c()) {
            this.f11665n = c3454w.m7086c();
            i6 = 1;
        }
        int i12 = 3;
        if (this.f11666o != c3454w.m7092i()) {
            this.f11666o = c3454w.m7092i();
            i6 = 3;
        }
        if (this.f11667p != c3454w.m7091h()) {
            this.f11667p = c3454w.m7091h();
            i6 = 3;
        }
        if (this.f11668q != c3454w.m7093j()) {
            this.f11668q = c3454w.m7093j();
        } else {
            i12 = i6;
        }
        if (this.f11669r != bundle.getInt("presentationDisplayId", -1)) {
            this.f11669r = bundle.getInt("presentationDisplayId", -1);
            i12 |= 5;
        }
        if (!Objects.equals(this.f11670s, bundle.getBundle("extras"))) {
            this.f11670s = bundle.getBundle("extras");
            i12 |= 1;
        }
        if (!Objects.equals(this.f11671t, (IntentSender) bundle.getParcelable("settingsIntent"))) {
            this.f11671t = (IntentSender) bundle.getParcelable("settingsIntent");
            i12 |= 1;
        }
        if (this.f11661j != bundle.getBoolean("canDisconnect", false)) {
            this.f11661j = bundle.getBoolean("canDisconnect", false);
            i12 |= 5;
        }
        ArrayList<String> arrayListM7087d = c3454w.m7087d();
        ArrayList arrayList2 = new ArrayList();
        boolean z7 = arrayListM7087d.size() != this.f11673v.size();
        if (!arrayListM7087d.isEmpty()) {
            C3411h c3411hM7068c = C3451u0.m7068c();
            for (String str2 : arrayListM7087d) {
                c3411hM7068c.getClass();
                String str3 = (String) c3411hM7068c.f11498k.get(new C3026b(((ComponentName) this.f11652a.f11646d.f9501b).flattenToShortString(), str2));
                Iterator it = c3411hM7068c.f11496i.iterator();
                do {
                    if (!it.hasNext()) {
                        c3445s0 = null;
                        break;
                    }
                    c3445s0 = (C3445s0) it.next();
                } while (!c3445s0.f11654c.equals(str3));
                if (c3445s0 != null) {
                    arrayList2.add(c3445s0);
                    if (!z7 && !this.f11673v.contains(c3445s0)) {
                        z7 = true;
                    }
                }
            }
        }
        if (!z7) {
            return i12;
        }
        this.f11673v = arrayList2;
        return i12 | 1;
    }

    public final void m7027j(int i6) {
        C3451u0.m7067b();
        C3411h c3411hM7068c = C3451u0.m7068c();
        int iMin = Math.min(this.f11668q, Math.max(0, i6));
        AbstractC3397c0 abstractC3397c0M6939f = c3411hM7068c.m6939f(this);
        if (abstractC3397c0M6939f != null) {
            abstractC3397c0M6939f.mo6894g(iMin);
        }
    }

    public final void m7028k(int i6) {
        AbstractC3397c0 abstractC3397c0M6939f;
        C3451u0.m7067b();
        if (i6 == 0 || (abstractC3397c0M6939f = C3451u0.m7068c().m6939f(this)) == null) {
            return;
        }
        abstractC3397c0M6939f.mo6895j(i6);
    }

    public final void m7029l(boolean z7) {
        C3451u0.m7067b();
        C3451u0.m7068c().m6943j(this, 3, z7);
    }

    public final boolean m7030m(String str) {
        C3451u0.m7067b();
        Iterator it = this.f11662k.iterator();
        while (it.hasNext()) {
            if (((IntentFilter) it.next()).hasCategory(str)) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("MediaRouter.RouteInfo{ uniqueId=");
        sb.append(this.f11654c);
        sb.append(", name=");
        sb.append(this.f11655d);
        sb.append(", description=");
        sb.append(this.f11656e);
        sb.append(", iconUri=");
        sb.append(this.f11657f);
        sb.append(", enabled=");
        sb.append(this.f11658g);
        sb.append(", isSystemRoute=");
        sb.append(this.f11659h);
        sb.append(", connectionState=");
        sb.append(this.f11660i);
        sb.append(", canDisconnect=");
        sb.append(this.f11661j);
        sb.append(", playbackType=");
        sb.append(this.f11663l);
        sb.append(", playbackStream=");
        sb.append(this.f11664m);
        sb.append(", deviceType=");
        sb.append(this.f11665n);
        sb.append(", volumeHandling=");
        sb.append(this.f11666o);
        sb.append(", volume=");
        sb.append(this.f11667p);
        sb.append(", volumeMax=");
        sb.append(this.f11668q);
        sb.append(", presentationDisplayId=");
        sb.append(this.f11669r);
        sb.append(", extras=");
        sb.append(this.f11670s);
        sb.append(", settingsIntent=");
        sb.append(this.f11671t);
        sb.append(", providerPackageName=");
        sb.append(((ComponentName) this.f11652a.f11646d.f9501b).getPackageName());
        if (m7022e()) {
            sb.append(", members=[");
            int size = this.f11673v.size();
            for (int i6 = 0; i6 < size; i6++) {
                if (i6 > 0) {
                    sb.append(", ");
                }
                if (this.f11673v.get(i6) != this) {
                    sb.append(((C3445s0) this.f11673v.get(i6)).f11654c);
                }
            }
            sb.append(']');
        }
        sb.append(" }");
        return sb.toString();
    }
}
