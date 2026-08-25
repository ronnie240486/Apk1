package androidx.leanback.widget;

import android.database.Observable;

public final class C0460e0 extends Observable {
    public final void m1422a() {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((C0451b0) ((Observable) this).mObservers.get(size)).f2313a.notifyDataSetChanged();
        }
    }

    public final void m1423b(int i6) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((C0451b0) ((Observable) this).mObservers.get(size)).f2313a.notifyItemRangeChanged(i6, 1);
        }
    }

    public final void m1424c(int i6, int i10) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((C0451b0) ((Observable) this).mObservers.get(size)).f2313a.notifyItemRangeInserted(i6, i10);
        }
    }

    public final void m1425d(int i6, int i10) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((C0451b0) ((Observable) this).mObservers.get(size)).f2313a.notifyItemRangeRemoved(i6, i10);
        }
    }
}
