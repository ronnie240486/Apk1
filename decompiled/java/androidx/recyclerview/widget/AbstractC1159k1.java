package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.util.Log;
import android.view.View;

public abstract class AbstractC1159k1 {
    private AbstractC1197x0 mLayoutManager;
    private boolean mPendingInitialRun;
    private RecyclerView mRecyclerView;
    private final C1153i1 mRecyclingAction;
    private boolean mRunning;
    private boolean mStarted;
    private int mTargetPosition = -1;
    private View mTargetView;

    public AbstractC1159k1() {
        C1153i1 c1153i1 = new C1153i1();
        c1153i1.f3588d = -1;
        c1153i1.f3590f = false;
        c1153i1.f3591g = 0;
        c1153i1.f3585a = 0;
        c1153i1.f3586b = 0;
        c1153i1.f3587c = Integer.MIN_VALUE;
        c1153i1.f3589e = null;
        this.mRecyclingAction = c1153i1;
    }

    public PointF computeScrollVectorForPosition(int i6) {
        Object layoutManager = getLayoutManager();
        if (layoutManager instanceof InterfaceC1156j1) {
            return ((InterfaceC1156j1) layoutManager).computeScrollVectorForPosition(i6);
        }
        Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + InterfaceC1156j1.class.getCanonicalName());
        return null;
    }

    public View findViewByPosition(int i6) {
        return this.mRecyclerView.mLayout.findViewByPosition(i6);
    }

    public int getChildCount() {
        return this.mRecyclerView.mLayout.getChildCount();
    }

    public int getChildPosition(View view) {
        return this.mRecyclerView.getChildLayoutPosition(view);
    }

    public AbstractC1197x0 getLayoutManager() {
        return this.mLayoutManager;
    }

    public int getTargetPosition() {
        return this.mTargetPosition;
    }

    @Deprecated
    public void instantScrollToPosition(int i6) {
        this.mRecyclerView.scrollToPosition(i6);
    }

    public boolean isPendingInitialRun() {
        return this.mPendingInitialRun;
    }

    public boolean isRunning() {
        return this.mRunning;
    }

    public void normalize(PointF pointF) {
        float f = pointF.x;
        float f3 = pointF.y;
        float fSqrt = (float) Math.sqrt((f3 * f3) + (f * f));
        pointF.x /= fSqrt;
        pointF.y /= fSqrt;
    }

    public void onAnimation(int i6, int i10) {
        PointF pointFComputeScrollVectorForPosition;
        RecyclerView recyclerView = this.mRecyclerView;
        if (this.mTargetPosition == -1 || recyclerView == null) {
            stop();
        }
        if (this.mPendingInitialRun && this.mTargetView == null && this.mLayoutManager != null && (pointFComputeScrollVectorForPosition = computeScrollVectorForPosition(this.mTargetPosition)) != null) {
            float f = pointFComputeScrollVectorForPosition.x;
            if (f != 0.0f || pointFComputeScrollVectorForPosition.y != 0.0f) {
                recyclerView.scrollStep((int) Math.signum(f), (int) Math.signum(pointFComputeScrollVectorForPosition.y), null);
            }
        }
        this.mPendingInitialRun = false;
        View view = this.mTargetView;
        if (view != null) {
            if (getChildPosition(view) == this.mTargetPosition) {
                onTargetFound(this.mTargetView, recyclerView.mState, this.mRecyclingAction);
                this.mRecyclingAction.m2950a(recyclerView);
                stop();
            } else {
                Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                this.mTargetView = null;
            }
        }
        if (this.mRunning) {
            onSeekTargetStep(i6, i10, recyclerView.mState, this.mRecyclingAction);
            C1153i1 c1153i1 = this.mRecyclingAction;
            boolean z7 = c1153i1.f3588d >= 0;
            c1153i1.m2950a(recyclerView);
            if (z7 && this.mRunning) {
                this.mPendingInitialRun = true;
                recyclerView.mViewFlinger.m2973b();
            }
        }
    }

    public void onChildAttachedToWindow(View view) {
        if (getChildPosition(view) == getTargetPosition()) {
            this.mTargetView = view;
            if (RecyclerView.sVerboseLoggingEnabled) {
                Log.d("RecyclerView", "smooth scroll target view has been attached");
            }
        }
    }

    public abstract void onSeekTargetStep(int i6, int i10, C1162l1 c1162l1, C1153i1 c1153i1);

    public abstract void onStart();

    public abstract void onStop();

    public abstract void onTargetFound(View view, C1162l1 c1162l1, C1153i1 c1153i1);

    public void setTargetPosition(int i6) {
        this.mTargetPosition = i6;
    }

    public void start(RecyclerView recyclerView, AbstractC1197x0 abstractC1197x0) {
        RunnableC1171o1 runnableC1171o1 = recyclerView.mViewFlinger;
        runnableC1171o1.f3641g.removeCallbacks(runnableC1171o1);
        runnableC1171o1.f3637c.abortAnimation();
        if (this.mStarted) {
            Log.w("RecyclerView", "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
        }
        this.mRecyclerView = recyclerView;
        this.mLayoutManager = abstractC1197x0;
        int i6 = this.mTargetPosition;
        if (i6 == -1) {
            throw new IllegalArgumentException("Invalid target position");
        }
        recyclerView.mState.f3615a = i6;
        this.mRunning = true;
        this.mPendingInitialRun = true;
        this.mTargetView = findViewByPosition(getTargetPosition());
        onStart();
        this.mRecyclerView.mViewFlinger.m2973b();
        this.mStarted = true;
    }

    public final void stop() {
        if (this.mRunning) {
            this.mRunning = false;
            onStop();
            this.mRecyclerView.mState.f3615a = -1;
            this.mTargetView = null;
            this.mTargetPosition = -1;
            this.mPendingInitialRun = false;
            this.mLayoutManager.onSmoothScrollerStopped(this);
            this.mLayoutManager = null;
            this.mRecyclerView = null;
        }
    }
}
