package androidx.recyclerview.widget;

import android.database.Observable;

public final class C1161l0 extends Observable {
    public final boolean m2962a() {
        return !((Observable) this).mObservers.isEmpty();
    }

    public final void m2963b() {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((AbstractC1164m0) ((Observable) this).mObservers.get(size)).onChanged();
        }
    }

    public final void m2964c(int i6, int i10) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((AbstractC1164m0) ((Observable) this).mObservers.get(size)).onItemRangeMoved(i6, i10, 1);
        }
    }

    public final void m2965d(int i6, int i10, Object obj) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((AbstractC1164m0) ((Observable) this).mObservers.get(size)).onItemRangeChanged(i6, i10, obj);
        }
    }

    public final void m2966e(int i6, int i10) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((AbstractC1164m0) ((Observable) this).mObservers.get(size)).onItemRangeInserted(i6, i10);
        }
    }

    public final void m2967f(int i6, int i10) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((AbstractC1164m0) ((Observable) this).mObservers.get(size)).onItemRangeRemoved(i6, i10);
        }
    }

    public final void m2968g() {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((AbstractC1164m0) ((Observable) this).mObservers.get(size)).onStateRestorationPolicyChanged();
        }
    }
}
