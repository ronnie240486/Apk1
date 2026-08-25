package androidx.recyclerview.widget;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import p000a.AbstractC0004e;

public final class C1134d {

    public final C1152i0 f3533a;

    public View f3537e;

    public int f3536d = 0;

    public final C1130c f3534b = new C1130c();

    public final ArrayList f3535c = new ArrayList();

    public C1134d(C1152i0 c1152i0) {
        this.f3533a = c1152i0;
    }

    public final void m2909a(View view, int i6, boolean z7) {
        RecyclerView recyclerView = (RecyclerView) this.f3533a.f3584a;
        int childCount = i6 < 0 ? recyclerView.getChildCount() : m2914f(i6);
        this.f3534b.m2904f(childCount, z7);
        if (z7) {
            m2917i(view);
        }
        recyclerView.addView(view, childCount);
        recyclerView.dispatchChildAttached(view);
    }

    public final void m2910b(View view, int i6, ViewGroup.LayoutParams layoutParams, boolean z7) {
        RecyclerView recyclerView = (RecyclerView) this.f3533a.f3584a;
        int childCount = i6 < 0 ? recyclerView.getChildCount() : m2914f(i6);
        this.f3534b.m2904f(childCount, z7);
        if (z7) {
            m2917i(view);
        }
        AbstractC1174p1 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (!childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                StringBuilder sb = new StringBuilder("Called attach on a child which is not detached: ");
                sb.append(childViewHolderInt);
                throw new IllegalArgumentException(AbstractC0004e.m22p(recyclerView, sb));
            }
            if (RecyclerView.sVerboseLoggingEnabled) {
                Log.d("RecyclerView", "reAttach " + childViewHolderInt);
            }
            childViewHolderInt.clearTmpDetachFlag();
        } else if (RecyclerView.sDebugAssertionsEnabled) {
            StringBuilder sb2 = new StringBuilder("No ViewHolder found for child: ");
            sb2.append(view);
            sb2.append(", index: ");
            sb2.append(childCount);
            throw new IllegalArgumentException(AbstractC0004e.m22p(recyclerView, sb2));
        }
        recyclerView.attachViewToParent(view, childCount, layoutParams);
    }

    public final void m2911c(int i6) {
        int iM2914f = m2914f(i6);
        this.f3534b.m2905g(iM2914f);
        RecyclerView recyclerView = (RecyclerView) this.f3533a.f3584a;
        View childAt = recyclerView.getChildAt(iM2914f);
        if (childAt != null) {
            AbstractC1174p1 childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
            if (childViewHolderInt != null) {
                if (childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                    StringBuilder sb = new StringBuilder("called detach on an already detached child ");
                    sb.append(childViewHolderInt);
                    throw new IllegalArgumentException(AbstractC0004e.m22p(recyclerView, sb));
                }
                if (RecyclerView.sVerboseLoggingEnabled) {
                    Log.d("RecyclerView", "tmpDetach " + childViewHolderInt);
                }
                childViewHolderInt.addFlags(256);
            }
        } else if (RecyclerView.sDebugAssertionsEnabled) {
            StringBuilder sb2 = new StringBuilder("No view at offset ");
            sb2.append(iM2914f);
            throw new IllegalArgumentException(AbstractC0004e.m22p(recyclerView, sb2));
        }
        recyclerView.detachViewFromParent(iM2914f);
    }

    public final View m2912d(int i6) {
        return ((RecyclerView) this.f3533a.f3584a).getChildAt(m2914f(i6));
    }

    public final int m2913e() {
        return ((RecyclerView) this.f3533a.f3584a).getChildCount() - this.f3535c.size();
    }

    public final int m2914f(int i6) {
        if (i6 < 0) {
            return -1;
        }
        int childCount = ((RecyclerView) this.f3533a.f3584a).getChildCount();
        int i10 = i6;
        while (i10 < childCount) {
            C1130c c1130c = this.f3534b;
            int iM2901c = i6 - (i10 - c1130c.m2901c(i10));
            if (iM2901c == 0) {
                while (c1130c.m2903e(i10)) {
                    i10++;
                }
                return i10;
            }
            i10 += iM2901c;
        }
        return -1;
    }

    public final View m2915g(int i6) {
        return ((RecyclerView) this.f3533a.f3584a).getChildAt(i6);
    }

    public final int m2916h() {
        return ((RecyclerView) this.f3533a.f3584a).getChildCount();
    }

    public final void m2917i(View view) {
        this.f3535c.add(view);
        C1152i0 c1152i0 = this.f3533a;
        AbstractC1174p1 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            childViewHolderInt.onEnteredHiddenState((RecyclerView) c1152i0.f3584a);
        }
    }

    public final int m2918j(View view) {
        int iIndexOfChild = ((RecyclerView) this.f3533a.f3584a).indexOfChild(view);
        if (iIndexOfChild == -1) {
            return -1;
        }
        C1130c c1130c = this.f3534b;
        if (c1130c.m2903e(iIndexOfChild)) {
            return -1;
        }
        return iIndexOfChild - c1130c.m2901c(iIndexOfChild);
    }

    public final void m2919k(int i6) {
        C1152i0 c1152i0 = this.f3533a;
        int i10 = this.f3536d;
        if (i10 == 1) {
            throw new IllegalStateException("Cannot call removeView(At) within removeView(At)");
        }
        if (i10 == 2) {
            throw new IllegalStateException("Cannot call removeView(At) within removeViewIfHidden");
        }
        try {
            int iM2914f = m2914f(i6);
            View childAt = ((RecyclerView) c1152i0.f3584a).getChildAt(iM2914f);
            if (childAt == null) {
                return;
            }
            this.f3536d = 1;
            this.f3537e = childAt;
            if (this.f3534b.m2905g(iM2914f)) {
                m2920l(childAt);
            }
            c1152i0.m2949c(iM2914f);
        } finally {
            this.f3536d = 0;
            this.f3537e = null;
        }
    }

    public final void m2920l(View view) {
        if (this.f3535c.remove(view)) {
            C1152i0 c1152i0 = this.f3533a;
            AbstractC1174p1 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                childViewHolderInt.onLeftHiddenState((RecyclerView) c1152i0.f3584a);
            }
        }
    }

    public final String toString() {
        return this.f3534b.toString() + ", hidden list:" + this.f3535c.size();
    }
}
