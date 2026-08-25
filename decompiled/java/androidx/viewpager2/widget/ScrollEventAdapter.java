package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.AbstractC1128b1;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Locale;
import p000a.AbstractC0004e;

final class ScrollEventAdapter extends AbstractC1128b1 {
    private static final int NO_POSITION = -1;
    private static final int STATE_IDLE = 0;
    private static final int STATE_IN_PROGRESS_FAKE_DRAG = 4;
    private static final int STATE_IN_PROGRESS_IMMEDIATE_SCROLL = 3;
    private static final int STATE_IN_PROGRESS_MANUAL_DRAG = 1;
    private static final int STATE_IN_PROGRESS_SMOOTH_SCROLL = 2;
    private int mAdapterState;
    private ViewPager2.OnPageChangeCallback mCallback;
    private boolean mDataSetChangeHappened;
    private boolean mDispatchSelected;
    private int mDragStartPosition;
    private boolean mFakeDragging;
    private final LinearLayoutManager mLayoutManager;
    private final RecyclerView mRecyclerView;
    private boolean mScrollHappened;
    private int mScrollState;
    private ScrollEventValues mScrollValues;
    private int mTarget;
    private final ViewPager2 mViewPager;

    public static final class ScrollEventValues {
        float mOffset;
        int mOffsetPx;
        int mPosition;

        public void reset() {
            this.mPosition = -1;
            this.mOffset = 0.0f;
            this.mOffsetPx = 0;
        }
    }

    public ScrollEventAdapter(ViewPager2 viewPager2) {
        this.mViewPager = viewPager2;
        RecyclerView recyclerView = viewPager2.mRecyclerView;
        this.mRecyclerView = recyclerView;
        this.mLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.mScrollValues = new ScrollEventValues();
        resetState();
    }

    private void dispatchScrolled(int i6, float f, int i10) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.mCallback;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageScrolled(i6, f, i10);
        }
    }

    private void dispatchSelected(int i6) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.mCallback;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageSelected(i6);
        }
    }

    private void dispatchStateChanged(int i6) {
        if ((this.mAdapterState == 3 && this.mScrollState == 0) || this.mScrollState == i6) {
            return;
        }
        this.mScrollState = i6;
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.mCallback;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageScrollStateChanged(i6);
        }
    }

    private int getPosition() {
        return this.mLayoutManager.findFirstVisibleItemPosition();
    }

    private boolean isInAnyDraggingState() {
        int i6 = this.mAdapterState;
        return i6 == 1 || i6 == 4;
    }

    private void resetState() {
        this.mAdapterState = 0;
        this.mScrollState = 0;
        this.mScrollValues.reset();
        this.mDragStartPosition = -1;
        this.mTarget = -1;
        this.mDispatchSelected = false;
        this.mScrollHappened = false;
        this.mFakeDragging = false;
        this.mDataSetChangeHappened = false;
    }

    private void startDrag(boolean z7) {
        this.mFakeDragging = z7;
        this.mAdapterState = z7 ? 4 : 1;
        int i6 = this.mTarget;
        if (i6 != -1) {
            this.mDragStartPosition = i6;
            this.mTarget = -1;
        } else if (this.mDragStartPosition == -1) {
            this.mDragStartPosition = getPosition();
        }
        dispatchStateChanged(1);
    }

    private void updateScrollEventValues() {
        int top;
        ScrollEventValues scrollEventValues = this.mScrollValues;
        int iFindFirstVisibleItemPosition = this.mLayoutManager.findFirstVisibleItemPosition();
        scrollEventValues.mPosition = iFindFirstVisibleItemPosition;
        if (iFindFirstVisibleItemPosition == -1) {
            scrollEventValues.reset();
            return;
        }
        View viewFindViewByPosition = this.mLayoutManager.findViewByPosition(iFindFirstVisibleItemPosition);
        if (viewFindViewByPosition == null) {
            scrollEventValues.reset();
            return;
        }
        int leftDecorationWidth = this.mLayoutManager.getLeftDecorationWidth(viewFindViewByPosition);
        int rightDecorationWidth = this.mLayoutManager.getRightDecorationWidth(viewFindViewByPosition);
        int topDecorationHeight = this.mLayoutManager.getTopDecorationHeight(viewFindViewByPosition);
        int bottomDecorationHeight = this.mLayoutManager.getBottomDecorationHeight(viewFindViewByPosition);
        ViewGroup.LayoutParams layoutParams = viewFindViewByPosition.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            leftDecorationWidth += marginLayoutParams.leftMargin;
            rightDecorationWidth += marginLayoutParams.rightMargin;
            topDecorationHeight += marginLayoutParams.topMargin;
            bottomDecorationHeight += marginLayoutParams.bottomMargin;
        }
        int height = viewFindViewByPosition.getHeight() + topDecorationHeight + bottomDecorationHeight;
        int width = viewFindViewByPosition.getWidth() + leftDecorationWidth + rightDecorationWidth;
        if (this.mLayoutManager.getOrientation() == 0) {
            top = (viewFindViewByPosition.getLeft() - leftDecorationWidth) - this.mRecyclerView.getPaddingLeft();
            if (this.mViewPager.isRtl()) {
                top = -top;
            }
            height = width;
        } else {
            top = (viewFindViewByPosition.getTop() - topDecorationHeight) - this.mRecyclerView.getPaddingTop();
        }
        int i6 = -top;
        scrollEventValues.mOffsetPx = i6;
        if (i6 >= 0) {
            scrollEventValues.mOffset = height == 0 ? 0.0f : i6 / height;
        } else {
            if (new AnimateLayoutChangeDetector(this.mLayoutManager).mayHaveInterferingAnimations()) {
                throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
            }
            Locale locale = Locale.US;
            throw new IllegalStateException(AbstractC0004e.m20n(scrollEventValues.mOffsetPx, "Page can only be offset by a positive amount, not by "));
        }
    }

    public double getRelativeScrollPosition() {
        updateScrollEventValues();
        ScrollEventValues scrollEventValues = this.mScrollValues;
        return ((double) scrollEventValues.mPosition) + ((double) scrollEventValues.mOffset);
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public boolean isDragging() {
        return this.mScrollState == 1;
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    public boolean isIdle() {
        return this.mScrollState == 0;
    }

    public void notifyBeginFakeDrag() {
        this.mAdapterState = 4;
        startDrag(true);
    }

    public void notifyDataSetChangeHappened() {
        this.mDataSetChangeHappened = true;
    }

    public void notifyEndFakeDrag() {
        if (!isDragging() || this.mFakeDragging) {
            this.mFakeDragging = false;
            updateScrollEventValues();
            ScrollEventValues scrollEventValues = this.mScrollValues;
            if (scrollEventValues.mOffsetPx != 0) {
                dispatchStateChanged(2);
                return;
            }
            int i6 = scrollEventValues.mPosition;
            if (i6 != this.mDragStartPosition) {
                dispatchSelected(i6);
            }
            dispatchStateChanged(0);
            resetState();
        }
    }

    public void notifyProgrammaticScroll(int i6, boolean z7) {
        this.mAdapterState = z7 ? 2 : 3;
        this.mFakeDragging = false;
        boolean z10 = this.mTarget != i6;
        this.mTarget = i6;
        dispatchStateChanged(2);
        if (z10) {
            dispatchSelected(i6);
        }
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int i6) {
        if (!(this.mAdapterState == 1 && this.mScrollState == 1) && i6 == 1) {
            startDrag(false);
            return;
        }
        if (isInAnyDraggingState() && i6 == 2) {
            if (this.mScrollHappened) {
                dispatchStateChanged(2);
                this.mDispatchSelected = true;
                return;
            }
            return;
        }
        if (isInAnyDraggingState() && i6 == 0) {
            updateScrollEventValues();
            if (this.mScrollHappened) {
                ScrollEventValues scrollEventValues = this.mScrollValues;
                if (scrollEventValues.mOffsetPx == 0) {
                    int i10 = this.mDragStartPosition;
                    int i11 = scrollEventValues.mPosition;
                    if (i10 != i11) {
                        dispatchSelected(i11);
                    }
                }
            } else {
                int i12 = this.mScrollValues.mPosition;
                if (i12 != -1) {
                    dispatchScrolled(i12, 0.0f, 0);
                }
            }
            dispatchStateChanged(0);
            resetState();
        }
        if (this.mAdapterState == 2 && i6 == 0 && this.mDataSetChangeHappened) {
            updateScrollEventValues();
            ScrollEventValues scrollEventValues2 = this.mScrollValues;
            if (scrollEventValues2.mOffsetPx == 0) {
                int i13 = this.mTarget;
                int i14 = scrollEventValues2.mPosition;
                if (i13 != i14) {
                    if (i14 == -1) {
                        i14 = 0;
                    }
                    dispatchSelected(i14);
                }
                dispatchStateChanged(0);
                resetState();
            }
        }
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int i6, int i10) {
        ScrollEventValues scrollEventValues;
        int i11;
        this.mScrollHappened = true;
        updateScrollEventValues();
        if (this.mDispatchSelected) {
            this.mDispatchSelected = false;
            if (i10 > 0) {
                scrollEventValues = this.mScrollValues;
                if (scrollEventValues.mOffsetPx != 0) {
                    i11 = scrollEventValues.mPosition + 1;
                } else {
                    i11 = this.mScrollValues.mPosition;
                }
            } else {
                if (i10 == 0) {
                    if ((i6 < 0) == this.mViewPager.isRtl()) {
                        scrollEventValues = this.mScrollValues;
                        if (scrollEventValues.mOffsetPx != 0) {
                            i11 = scrollEventValues.mPosition + 1;
                        }
                    }
                }
                i11 = this.mScrollValues.mPosition;
            }
            this.mTarget = i11;
            if (this.mDragStartPosition != i11) {
                dispatchSelected(i11);
            }
        } else if (this.mAdapterState == 0) {
            int i12 = this.mScrollValues.mPosition;
            if (i12 == -1) {
                i12 = 0;
            }
            dispatchSelected(i12);
        }
        ScrollEventValues scrollEventValues2 = this.mScrollValues;
        int i13 = scrollEventValues2.mPosition;
        if (i13 == -1) {
            i13 = 0;
        }
        dispatchScrolled(i13, scrollEventValues2.mOffset, scrollEventValues2.mOffsetPx);
        ScrollEventValues scrollEventValues3 = this.mScrollValues;
        int i14 = scrollEventValues3.mPosition;
        int i15 = this.mTarget;
        if ((i14 == i15 || i15 == -1) && scrollEventValues3.mOffsetPx == 0 && this.mScrollState != 1) {
            dispatchStateChanged(0);
            resetState();
        }
    }

    public void setOnPageChangeCallback(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.mCallback = onPageChangeCallback;
    }
}
