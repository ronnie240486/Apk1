package androidx.recyclerview.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;

public final class C1139e0 extends C1123a0 {

    public final int f3547a;

    public final AbstractC1186t1 f3548b;

    public C1139e0(AbstractC1186t1 abstractC1186t1, Context context, int i6) {
        super(context);
        this.f3547a = i6;
        this.f3548b = abstractC1186t1;
    }

    @Override
    public final float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        switch (this.f3547a) {
            case 0:
                break;
        }
        return 100.0f / displayMetrics.densityDpi;
    }

    @Override
    public int calculateTimeForScrolling(int i6) {
        switch (this.f3547a) {
            case 0:
                return Math.min(100, super.calculateTimeForScrolling(i6));
            default:
                return super.calculateTimeForScrolling(i6);
        }
    }

    @Override
    public final void onTargetFound(View view, C1162l1 c1162l1, C1153i1 c1153i1) {
        switch (this.f3547a) {
            case 0:
                C1143f0 c1143f0 = (C1143f0) this.f3548b;
                int[] iArrCalculateDistanceToFinalSnap = c1143f0.calculateDistanceToFinalSnap(c1143f0.mRecyclerView.getLayoutManager(), view);
                int i6 = iArrCalculateDistanceToFinalSnap[0];
                int i10 = iArrCalculateDistanceToFinalSnap[1];
                int iCalculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i6), Math.abs(i10)));
                if (iCalculateTimeForDeceleration > 0) {
                    c1153i1.m2951b(i6, i10, this.mDecelerateInterpolator, iCalculateTimeForDeceleration);
                }
                break;
            default:
                AbstractC1186t1 abstractC1186t1 = this.f3548b;
                RecyclerView recyclerView = abstractC1186t1.mRecyclerView;
                if (recyclerView != null) {
                    int[] iArrCalculateDistanceToFinalSnap2 = abstractC1186t1.calculateDistanceToFinalSnap(recyclerView.getLayoutManager(), view);
                    int i11 = iArrCalculateDistanceToFinalSnap2[0];
                    int i12 = iArrCalculateDistanceToFinalSnap2[1];
                    int iCalculateTimeForDeceleration2 = calculateTimeForDeceleration(Math.max(Math.abs(i11), Math.abs(i12)));
                    if (iCalculateTimeForDeceleration2 > 0) {
                        c1153i1.m2951b(i11, i12, this.mDecelerateInterpolator, iCalculateTimeForDeceleration2);
                    }
                    break;
                }
                break;
        }
    }
}
