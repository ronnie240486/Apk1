package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.AbstractC0554v0;
import java.util.HashMap;
import java.util.Iterator;

public final class C0414l0 extends AbstractC0554v0 {

    public static final C0396c0 f1890j = new C0396c0();

    public final boolean f1894g;

    public final HashMap f1891d = new HashMap();

    public final HashMap f1892e = new HashMap();

    public final HashMap f1893f = new HashMap();

    public boolean f1895h = false;

    public boolean f1896i = false;

    public C0414l0(boolean z7) {
        this.f1894g = z7;
    }

    @Override
    public final void mo1267b() {
        if (Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f1895h = true;
    }

    public final void m1268c(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s) {
        if (this.f1896i) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f1891d.remove(abstractComponentCallbacksC0427s.f1969f) == null || !Log.isLoggable("FragmentManager", 2)) {
                return;
            }
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + abstractComponentCallbacksC0427s);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0414l0.class != obj.getClass()) {
            return false;
        }
        C0414l0 c0414l0 = (C0414l0) obj;
        return this.f1891d.equals(c0414l0.f1891d) && this.f1892e.equals(c0414l0.f1892e) && this.f1893f.equals(c0414l0.f1893f);
    }

    public final int hashCode() {
        return this.f1893f.hashCode() + ((this.f1892e.hashCode() + (this.f1891d.hashCode() * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator it = this.f1891d.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator it2 = this.f1892e.keySet().iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator it3 = this.f1893f.keySet().iterator();
        while (it3.hasNext()) {
            sb.append((String) it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
