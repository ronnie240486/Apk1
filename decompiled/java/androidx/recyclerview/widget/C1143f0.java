package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.graphics.PointF;
import android.view.View;

public class C1143f0 extends AbstractC1186t1 {
    private static final int MAX_SCROLL_ON_FLING_DURATION = 100;
    private AbstractC1135d0 mHorizontalHelper;
    private AbstractC1135d0 mVerticalHelper;

    public static int m2942a(View view, AbstractC1135d0 abstractC1135d0) {
        return ((abstractC1135d0.mo2884c(view) / 2) + abstractC1135d0.mo2886e(view)) - ((abstractC1135d0.mo2893l() / 2) + abstractC1135d0.mo2892k());
    }

    public static View m2943b(AbstractC1197x0 abstractC1197x0, AbstractC1135d0 abstractC1135d0) {
        int childCount = abstractC1197x0.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int iMo2893l = (abstractC1135d0.mo2893l() / 2) + abstractC1135d0.mo2892k();
        int i6 = Integer.MAX_VALUE;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = abstractC1197x0.getChildAt(i10);
            int iAbs = Math.abs(((abstractC1135d0.mo2884c(childAt) / 2) + abstractC1135d0.mo2886e(childAt)) - iMo2893l);
            if (iAbs < i6) {
                view = childAt;
                i6 = iAbs;
            }
        }
        return view;
    }

    public final AbstractC1135d0 m2944c(AbstractC1197x0 abstractC1197x0) {
        AbstractC1135d0 abstractC1135d0 = this.mHorizontalHelper;
        if (abstractC1135d0 == null || abstractC1135d0.f3538a != abstractC1197x0) {
            this.mHorizontalHelper = new C1127b0(abstractC1197x0);
        }
        return this.mHorizontalHelper;
    }

    @Override
    public int[] calculateDistanceToFinalSnap(AbstractC1197x0 abstractC1197x0, View view) {
        int[] iArr = new int[2];
        if (abstractC1197x0.canScrollHorizontally()) {
            iArr[0] = m2942a(view, m2944c(abstractC1197x0));
        } else {
            iArr[0] = 0;
        }
        if (abstractC1197x0.canScrollVertically()) {
            iArr[1] = m2942a(view, m2945d(abstractC1197x0));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override
    public AbstractC1159k1 createScroller(AbstractC1197x0 abstractC1197x0) {
        if (abstractC1197x0 instanceof InterfaceC1156j1) {
            return new C1139e0(this, this.mRecyclerView.getContext(), 0);
        }
        return null;
    }

    public final AbstractC1135d0 m2945d(AbstractC1197x0 abstractC1197x0) {
        AbstractC1135d0 abstractC1135d0 = this.mVerticalHelper;
        if (abstractC1135d0 == null || abstractC1135d0.f3538a != abstractC1197x0) {
            this.mVerticalHelper = new C1131c0(abstractC1197x0);
        }
        return this.mVerticalHelper;
    }

    @Override
    public View findSnapView(AbstractC1197x0 abstractC1197x0) {
        if (abstractC1197x0.canScrollVertically()) {
            return m2943b(abstractC1197x0, m2945d(abstractC1197x0));
        }
        if (abstractC1197x0.canScrollHorizontally()) {
            return m2943b(abstractC1197x0, m2944c(abstractC1197x0));
        }
        return null;
    }

    @Override
    @SuppressLint({"UnknownNullness"})
    public int findTargetSnapPosition(AbstractC1197x0 abstractC1197x0, int i6, int i10) {
        PointF pointFComputeScrollVectorForPosition;
        int itemCount = abstractC1197x0.getItemCount();
        if (itemCount == 0) {
            return -1;
        }
        View view = null;
        AbstractC1135d0 abstractC1135d0M2945d = abstractC1197x0.canScrollVertically() ? m2945d(abstractC1197x0) : abstractC1197x0.canScrollHorizontally() ? m2944c(abstractC1197x0) : null;
        if (abstractC1135d0M2945d == null) {
            return -1;
        }
        int childCount = abstractC1197x0.getChildCount();
        boolean z7 = false;
        View view2 = null;
        int i11 = Integer.MIN_VALUE;
        int i12 = Integer.MAX_VALUE;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = abstractC1197x0.getChildAt(i13);
            if (childAt != null) {
                int iM2942a = m2942a(childAt, abstractC1135d0M2945d);
                if (iM2942a <= 0 && iM2942a > i11) {
                    view2 = childAt;
                    i11 = iM2942a;
                }
                if (iM2942a >= 0 && iM2942a < i12) {
                    view = childAt;
                    i12 = iM2942a;
                }
            }
        }
        boolean z10 = !abstractC1197x0.canScrollHorizontally() ? i10 <= 0 : i6 <= 0;
        if (z10 && view != null) {
            return abstractC1197x0.getPosition(view);
        }
        if (!z10 && view2 != null) {
            return abstractC1197x0.getPosition(view2);
        }
        if (z10) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        int position = abstractC1197x0.getPosition(view);
        int itemCount2 = abstractC1197x0.getItemCount();
        if ((abstractC1197x0 instanceof InterfaceC1156j1) && (pointFComputeScrollVectorForPosition = ((InterfaceC1156j1) abstractC1197x0).computeScrollVectorForPosition(itemCount2 - 1)) != null && (pointFComputeScrollVectorForPosition.x < 0.0f || pointFComputeScrollVectorForPosition.y < 0.0f)) {
            z7 = true;
        }
        int i14 = position + (z7 == z10 ? -1 : 1);
        if (i14 < 0 || i14 >= itemCount) {
            return -1;
        }
        return i14;
    }
}
