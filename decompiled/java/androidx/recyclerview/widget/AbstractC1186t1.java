package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;

public abstract class AbstractC1186t1 extends AbstractC1203z0 {
    static final float MILLISECONDS_PER_INCH = 100.0f;
    private Scroller mGravityScroller;
    RecyclerView mRecyclerView;
    private final AbstractC1128b1 mScrollListener = new C1183s1(this);

    public void attachToRecyclerView(RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            recyclerView2.removeOnScrollListener(this.mScrollListener);
            this.mRecyclerView.setOnFlingListener(null);
        }
        this.mRecyclerView = recyclerView;
        if (recyclerView != null) {
            if (recyclerView.getOnFlingListener() != null) {
                throw new IllegalStateException("An instance of OnFlingListener already set.");
            }
            this.mRecyclerView.addOnScrollListener(this.mScrollListener);
            this.mRecyclerView.setOnFlingListener(this);
            this.mGravityScroller = new Scroller(this.mRecyclerView.getContext(), new DecelerateInterpolator());
            snapToTargetExistingView();
        }
    }

    public abstract int[] calculateDistanceToFinalSnap(AbstractC1197x0 abstractC1197x0, View view);

    @SuppressLint({"UnknownNullness"})
    public int[] calculateScrollDistance(int i6, int i10) {
        this.mGravityScroller.fling(0, 0, i6, i10, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return new int[]{this.mGravityScroller.getFinalX(), this.mGravityScroller.getFinalY()};
    }

    public abstract AbstractC1159k1 createScroller(AbstractC1197x0 abstractC1197x0);

    @Deprecated
    public C1123a0 createSnapScroller(AbstractC1197x0 abstractC1197x0) {
        if (abstractC1197x0 instanceof InterfaceC1156j1) {
            return new C1139e0(this, this.mRecyclerView.getContext(), 1);
        }
        return null;
    }

    public abstract View findSnapView(AbstractC1197x0 abstractC1197x0);

    public abstract int findTargetSnapPosition(AbstractC1197x0 abstractC1197x0, int i6, int i10);

    @Override
    public boolean onFling(int i6, int i10) {
        AbstractC1159k1 abstractC1159k1CreateScroller;
        int iFindTargetSnapPosition;
        AbstractC1197x0 layoutManager = this.mRecyclerView.getLayoutManager();
        if (layoutManager == null || this.mRecyclerView.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.mRecyclerView.getMinFlingVelocity();
        if ((Math.abs(i10) <= minFlingVelocity && Math.abs(i6) <= minFlingVelocity) || !(layoutManager instanceof InterfaceC1156j1) || (abstractC1159k1CreateScroller = createScroller(layoutManager)) == null || (iFindTargetSnapPosition = findTargetSnapPosition(layoutManager, i6, i10)) == -1) {
            return false;
        }
        abstractC1159k1CreateScroller.setTargetPosition(iFindTargetSnapPosition);
        layoutManager.startSmoothScroll(abstractC1159k1CreateScroller);
        return true;
    }

    public void snapToTargetExistingView() {
        AbstractC1197x0 layoutManager;
        View viewFindSnapView;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (viewFindSnapView = findSnapView(layoutManager)) == null) {
            return;
        }
        int[] iArrCalculateDistanceToFinalSnap = calculateDistanceToFinalSnap(layoutManager, viewFindSnapView);
        int i6 = iArrCalculateDistanceToFinalSnap[0];
        if (i6 == 0 && iArrCalculateDistanceToFinalSnap[1] == 0) {
            return;
        }
        this.mRecyclerView.smoothScrollBy(i6, iArrCalculateDistanceToFinalSnap[1]);
    }
}
