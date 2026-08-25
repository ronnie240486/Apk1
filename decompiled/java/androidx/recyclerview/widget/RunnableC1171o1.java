package androidx.recyclerview.widget;

import android.os.Build;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.Arrays;
import java.util.WeakHashMap;
import p138n0.AbstractC3155s0;

public final class RunnableC1171o1 implements Runnable {

    public int f3635a;

    public int f3636b;

    public OverScroller f3637c;

    public Interpolator f3638d;

    public boolean f3639e;

    public boolean f3640f;

    public final RecyclerView f3641g;

    public RunnableC1171o1(RecyclerView recyclerView) {
        this.f3641g = recyclerView;
        Interpolator interpolator = RecyclerView.sQuinticInterpolator;
        this.f3638d = interpolator;
        this.f3639e = false;
        this.f3640f = false;
        this.f3637c = new OverScroller(recyclerView.getContext(), interpolator);
    }

    public final void m2972a(int i6, int i10) {
        RecyclerView recyclerView = this.f3641g;
        recyclerView.setScrollState(2);
        this.f3636b = 0;
        this.f3635a = 0;
        Interpolator interpolator = this.f3638d;
        Interpolator interpolator2 = RecyclerView.sQuinticInterpolator;
        if (interpolator != interpolator2) {
            this.f3638d = interpolator2;
            this.f3637c = new OverScroller(recyclerView.getContext(), interpolator2);
        }
        this.f3637c.fling(0, 0, i6, i10, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        m2973b();
    }

    public final void m2973b() {
        if (this.f3639e) {
            this.f3640f = true;
            return;
        }
        RecyclerView recyclerView = this.f3641g;
        recyclerView.removeCallbacks(this);
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        recyclerView.postOnAnimation(this);
    }

    public final void m2974c(int i6, int i10, Interpolator interpolator, int i11) {
        RecyclerView recyclerView = this.f3641g;
        if (i11 == Integer.MIN_VALUE) {
            int iAbs = Math.abs(i6);
            int iAbs2 = Math.abs(i10);
            boolean z7 = iAbs > iAbs2;
            int width = z7 ? recyclerView.getWidth() : recyclerView.getHeight();
            if (!z7) {
                iAbs = iAbs2;
            }
            i11 = Math.min((int) (((iAbs / width) + 1.0f) * 300.0f), 2000);
        }
        int i12 = i11;
        if (interpolator == null) {
            interpolator = RecyclerView.sQuinticInterpolator;
        }
        if (this.f3638d != interpolator) {
            this.f3638d = interpolator;
            this.f3637c = new OverScroller(recyclerView.getContext(), interpolator);
        }
        this.f3636b = 0;
        this.f3635a = 0;
        recyclerView.setScrollState(2);
        this.f3637c.startScroll(0, 0, i6, i10, i12);
        if (Build.VERSION.SDK_INT < 23) {
            this.f3637c.computeScrollOffset();
        }
        m2973b();
    }

    @Override
    public final void run() {
        int i6;
        int i10;
        int i11;
        int i12;
        int i13;
        RecyclerView recyclerView = this.f3641g;
        if (recyclerView.mLayout == null) {
            recyclerView.removeCallbacks(this);
            this.f3637c.abortAnimation();
            return;
        }
        this.f3640f = false;
        this.f3639e = true;
        recyclerView.consumePendingUpdateOperations();
        OverScroller overScroller = this.f3637c;
        if (overScroller.computeScrollOffset()) {
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int i14 = currX - this.f3635a;
            int i15 = currY - this.f3636b;
            this.f3635a = currX;
            this.f3636b = currY;
            int iConsumeFlingInHorizontalStretch = recyclerView.consumeFlingInHorizontalStretch(i14);
            int iConsumeFlingInVerticalStretch = recyclerView.consumeFlingInVerticalStretch(i15);
            int[] iArr = recyclerView.mReusableIntPair;
            iArr[0] = 0;
            iArr[1] = 0;
            if (recyclerView.dispatchNestedPreScroll(iConsumeFlingInHorizontalStretch, iConsumeFlingInVerticalStretch, iArr, null, 1)) {
                int[] iArr2 = recyclerView.mReusableIntPair;
                iConsumeFlingInHorizontalStretch -= iArr2[0];
                iConsumeFlingInVerticalStretch -= iArr2[1];
            }
            if (recyclerView.getOverScrollMode() != 2) {
                recyclerView.considerReleasingGlowsOnScroll(iConsumeFlingInHorizontalStretch, iConsumeFlingInVerticalStretch);
            }
            if (recyclerView.mAdapter != null) {
                int[] iArr3 = recyclerView.mReusableIntPair;
                iArr3[0] = 0;
                iArr3[1] = 0;
                recyclerView.scrollStep(iConsumeFlingInHorizontalStretch, iConsumeFlingInVerticalStretch, iArr3);
                int[] iArr4 = recyclerView.mReusableIntPair;
                int i16 = iArr4[0];
                int i17 = iArr4[1];
                int i18 = iConsumeFlingInHorizontalStretch - i16;
                int i19 = iConsumeFlingInVerticalStretch - i17;
                AbstractC1159k1 abstractC1159k1 = recyclerView.mLayout.mSmoothScroller;
                if (abstractC1159k1 != null && !abstractC1159k1.isPendingInitialRun() && abstractC1159k1.isRunning()) {
                    int iM2970b = recyclerView.mState.m2970b();
                    if (iM2970b == 0) {
                        abstractC1159k1.stop();
                    } else if (abstractC1159k1.getTargetPosition() >= iM2970b) {
                        abstractC1159k1.setTargetPosition(iM2970b - 1);
                        abstractC1159k1.onAnimation(i16, i17);
                    } else {
                        abstractC1159k1.onAnimation(i16, i17);
                    }
                }
                i11 = i17;
                i12 = i16;
                i6 = i18;
                i10 = i19;
            } else {
                i6 = iConsumeFlingInHorizontalStretch;
                i10 = iConsumeFlingInVerticalStretch;
                i11 = 0;
                i12 = 0;
            }
            if (!recyclerView.mItemDecorations.isEmpty()) {
                recyclerView.invalidate();
            }
            int[] iArr5 = recyclerView.mReusableIntPair;
            iArr5[0] = 0;
            iArr5[1] = 0;
            recyclerView.dispatchNestedScroll(i12, i11, i6, i10, null, 1, iArr5);
            int[] iArr6 = recyclerView.mReusableIntPair;
            int i20 = i6 - iArr6[0];
            int i21 = i10 - iArr6[1];
            if (i12 != 0 || i11 != 0) {
                recyclerView.dispatchOnScrolled(i12, i11);
            }
            if (!recyclerView.awakenScrollBars()) {
                recyclerView.invalidate();
            }
            boolean z7 = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i20 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i21 != 0));
            AbstractC1159k1 abstractC1159k2 = recyclerView.mLayout.mSmoothScroller;
            if ((abstractC1159k2 == null || !abstractC1159k2.isPendingInitialRun()) && z7) {
                if (recyclerView.getOverScrollMode() != 2) {
                    int currVelocity = (int) overScroller.getCurrVelocity();
                    if (i20 < 0) {
                        i13 = -currVelocity;
                    } else {
                        i13 = i20 > 0 ? currVelocity : 0;
                    }
                    if (i21 < 0) {
                        currVelocity = -currVelocity;
                    } else if (i21 <= 0) {
                        currVelocity = 0;
                    }
                    recyclerView.absorbGlows(i13, currVelocity);
                }
                if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                    C1178r c1178r = recyclerView.mPrefetchRegistry;
                    int[] iArr7 = c1178r.f3676c;
                    if (iArr7 != null) {
                        Arrays.fill(iArr7, -1);
                    }
                    c1178r.f3677d = 0;
                }
            } else {
                m2973b();
                RunnableC1184t runnableC1184t = recyclerView.mGapWorker;
                if (runnableC1184t != null) {
                    runnableC1184t.m2992a(recyclerView, i12, i11);
                }
            }
            if (Build.VERSION.SDK_INT >= 35) {
                AbstractC1167n0.m2971a(recyclerView, Math.abs(overScroller.getCurrVelocity()));
            }
        }
        AbstractC1159k1 abstractC1159k3 = recyclerView.mLayout.mSmoothScroller;
        if (abstractC1159k3 != null && abstractC1159k3.isPendingInitialRun()) {
            abstractC1159k3.onAnimation(0, 0);
        }
        this.f3639e = false;
        if (!this.f3640f) {
            recyclerView.setScrollState(0);
            recyclerView.stopNestedScroll(1);
        } else {
            recyclerView.removeCallbacks(this);
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            recyclerView.postOnAnimation(this);
        }
    }
}
