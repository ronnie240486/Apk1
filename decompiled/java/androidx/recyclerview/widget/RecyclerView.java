package androidx.recyclerview.widget;

import android.R;
import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Trace;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.customview.view.AbsSavedState;
import androidx.media3.extractor.p010ts.TsExtractor;
import com.bumptech.glide.AbstractC1466d;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import p000a.AbstractC0004e;
import p003a2.AbstractC0032a;
import p055ea.AbstractC2460q;
import p123l5.AbstractC2973a;
import p138n0.AbstractC3119g0;
import p138n0.AbstractC3128j0;
import p138n0.AbstractC3155s0;
import p138n0.AbstractC3158t0;
import p138n0.AbstractC3167w0;
import p138n0.C3121h;
import p138n0.C3142o;
import p138n0.InterfaceC3124i;
import p138n0.InterfaceC3139n;
import p143n5.AbstractC3198d;
import p160p.C3347k;
import p216u0.C3888a;
import p217u1.AbstractC3889a;
import p253x8.AbstractC4148k;

public class RecyclerView extends ViewGroup implements InterfaceC3139n {
    static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC;
    static final boolean ALLOW_THREAD_GAP_WORK;
    static final int DEFAULT_ORIENTATION = 1;
    static final boolean DISPATCH_TEMP_DETACH = false;
    private static final float FLING_DESTRETCH_FACTOR = 4.0f;
    static final boolean FORCE_INVALIDATE_DISPLAY_LIST;
    static final long FOREVER_NS = Long.MAX_VALUE;
    public static final int HORIZONTAL = 0;
    private static final float INFLEXION = 0.35f;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
    static final String LOW_RES_ROTARY_ENCODER_FEATURE = "android.hardware.rotaryencoder.lowres";
    static final int MAX_SCROLL_DURATION = 2000;
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    private static final float SCROLL_FRICTION = 0.015f;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    static final String TRACE_PREFETCH_TAG = "RV Prefetch";
    static final String TRACE_SCROLL_TAG = "RV Scroll";
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    static final boolean VERBOSE_TRACING = false;
    public static final int VERTICAL = 1;
    static boolean sDebugAssertionsEnabled;
    static final C1165m1 sDefaultEdgeEffectFactory;
    static final Interpolator sQuinticInterpolator;
    static boolean sVerboseLoggingEnabled;
    C1180r1 mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    AbstractC1158k0 mAdapter;
    C1126b mAdapterHelper;
    boolean mAdapterUpdateDuringMeasure;
    private EdgeEffect mBottomGlow;
    private InterfaceC1170o0 mChildDrawingOrderCallback;
    C1134d mChildHelper;
    boolean mClipToPadding;
    boolean mDataSetHasChangedAfterLayout;
    C3121h mDifferentialMotionFlingController;
    private final InterfaceC3124i mDifferentialMotionFlingTarget;
    boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;
    private AbstractC1173p0 mEdgeEffectFactory;
    boolean mEnableFastScroller;
    boolean mFirstLayoutComplete;
    RunnableC1184t mGapWorker;
    boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth;
    private InterfaceC1124a1 mInterceptingOnItemTouchListener;
    boolean mIsAttached;
    AbstractC1182s0 mItemAnimator;
    private InterfaceC1176q0 mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    final ArrayList<AbstractC1185t0> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastAutoMeasureNonExactMeasuredHeight;
    private int mLastAutoMeasureNonExactMeasuredWidth;
    private boolean mLastAutoMeasureSkippedDueToExact;
    private int mLastTouchX;
    private int mLastTouchY;
    AbstractC1197x0 mLayout;
    private int mLayoutOrScrollCounter;
    boolean mLayoutSuppressed;
    boolean mLayoutWasDefered;
    private EdgeEffect mLeftGlow;
    boolean mLowResRotaryEncoderFeature;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final C1147g1 mObserver;
    private List<InterfaceC1200y0> mOnChildAttachStateListeners;
    private AbstractC1203z0 mOnFlingListener;
    private final ArrayList<InterfaceC1124a1> mOnItemTouchListeners;
    final List<AbstractC1174p1> mPendingAccessibilityImportanceChange;
    SavedState mPendingSavedState;
    private final float mPhysicalCoef;
    boolean mPostedAnimatorRunner;
    C1178r mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    final C1140e1 mRecycler;
    InterfaceC1144f1 mRecyclerListener;
    final List<InterfaceC1144f1> mRecyclerListeners;
    final int[] mReusableIntPair;
    private EdgeEffect mRightGlow;
    float mScaledHorizontalScrollFactor;
    float mScaledVerticalScrollFactor;
    private AbstractC1128b1 mScrollListener;
    private List<AbstractC1128b1> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private C3142o mScrollingChildHelper;
    final C1162l1 mState;
    final Rect mTempRect;
    private final Rect mTempRect2;
    final RectF mTempRectF;
    private EdgeEffect mTopGlow;
    private int mTouchSlop;
    final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    final RunnableC1171o1 mViewFlinger;
    private final InterfaceC1137d2 mViewInfoProcessCallback;
    final C1141e2 mViewInfoStore;
    private static final int[] NESTED_SCROLLING_ATTRS = {R.attr.nestedScrollingEnabled};
    private static final float DECELERATION_RATE = (float) (Math.log(0.78d) / Math.log(0.9d));

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C1150h1();

        public Parcelable f3469c;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f3469c = parcel.readParcelable(classLoader == null ? AbstractC1197x0.class.getClassLoader() : classLoader);
        }

        @Override
        public final void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeParcelable(this.f3469c, 0);
        }
    }

    static {
        int i6 = Build.VERSION.SDK_INT;
        FORCE_INVALIDATE_DISPLAY_LIST = false;
        ALLOW_SIZE_IN_UNSPECIFIED_SPEC = i6 >= 23;
        ALLOW_THREAD_GAP_WORK = true;
        Class<?> cls = Integer.TYPE;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, cls, cls};
        sQuinticInterpolator = new InterpolatorC1149h0();
        sDefaultEdgeEffectFactory = new C1165m1();
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    private void addAnimatingView(AbstractC1174p1 abstractC1174p1) {
        View view = abstractC1174p1.itemView;
        boolean z7 = view.getParent() == this;
        this.mRecycler.m2936m(getChildViewHolder(view));
        if (abstractC1174p1.isTmpDetached()) {
            this.mChildHelper.m2910b(view, -1, view.getLayoutParams(), true);
            return;
        }
        if (!z7) {
            this.mChildHelper.m2909a(view, -1, true);
            return;
        }
        C1134d c1134d = this.mChildHelper;
        int iIndexOfChild = ((RecyclerView) c1134d.f3533a.f3584a).indexOfChild(view);
        if (iIndexOfChild >= 0) {
            c1134d.f3534b.m2907i(iIndexOfChild);
            c1134d.m2917i(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    private void animateChange(AbstractC1174p1 abstractC1174p1, AbstractC1174p1 abstractC1174p2, C1179r0 c1179r0, C1179r0 c1179r1, boolean z7, boolean z10) {
        abstractC1174p1.setIsRecyclable(false);
        if (z7) {
            addAnimatingView(abstractC1174p1);
        }
        if (abstractC1174p1 != abstractC1174p2) {
            if (z10) {
                addAnimatingView(abstractC1174p2);
            }
            abstractC1174p1.mShadowedHolder = abstractC1174p2;
            addAnimatingView(abstractC1174p1);
            this.mRecycler.m2936m(abstractC1174p1);
            abstractC1174p2.setIsRecyclable(false);
            abstractC1174p2.mShadowingHolder = abstractC1174p1;
        }
        if (this.mItemAnimator.mo2953a(abstractC1174p1, abstractC1174p2, c1179r0, c1179r1)) {
            postAnimationRunner();
        }
    }

    private void cancelScroll() {
        resetScroll();
        setScrollState(0);
    }

    public static void clearNestedRecyclerViewIfNotNested(AbstractC1174p1 abstractC1174p1) {
        WeakReference<RecyclerView> weakReference = abstractC1174p1.mNestedRecyclerView;
        if (weakReference != null) {
            RecyclerView recyclerView = weakReference.get();
            while (recyclerView != null) {
                if (recyclerView == abstractC1174p1.itemView) {
                    return;
                }
                Object parent = recyclerView.getParent();
                recyclerView = parent instanceof View ? (View) parent : null;
            }
            abstractC1174p1.mNestedRecyclerView = null;
        }
    }

    private int consumeFlingInStretch(int i6, EdgeEffect edgeEffect, EdgeEffect edgeEffect2, int i10) {
        if (i6 > 0 && edgeEffect != null && AbstractC1466d.m3495m(edgeEffect) != 0.0f) {
            int iRound = Math.round(AbstractC1466d.m3506z(edgeEffect, ((-i6) * FLING_DESTRETCH_FACTOR) / i10, 0.5f) * ((-i10) / FLING_DESTRETCH_FACTOR));
            if (iRound != i6) {
                edgeEffect.finish();
            }
            return i6 - iRound;
        }
        if (i6 >= 0 || edgeEffect2 == null || AbstractC1466d.m3495m(edgeEffect2) == 0.0f) {
            return i6;
        }
        float f = i10;
        int iRound2 = Math.round(AbstractC1466d.m3506z(edgeEffect2, (i6 * FLING_DESTRETCH_FACTOR) / f, 0.5f) * (f / FLING_DESTRETCH_FACTOR));
        if (iRound2 != i6) {
            edgeEffect2.finish();
        }
        return i6 - iRound2;
    }

    private void createLayoutManager(Context context, String str, AttributeSet attributeSet, int i6, int i10) {
        Object[] objArr;
        Constructor constructor;
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return;
            }
            String fullClassName = getFullClassName(context, strTrim);
            try {
                Class<? extends U> clsAsSubclass = Class.forName(fullClassName, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(AbstractC1197x0.class);
                try {
                    constructor = clsAsSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i6), Integer.valueOf(i10)};
                } catch (NoSuchMethodException e5) {
                    objArr = null;
                    try {
                        constructor = clsAsSubclass.getConstructor(null);
                    } catch (NoSuchMethodException e10) {
                        e10.initCause(e5);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + fullClassName, e10);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((AbstractC1197x0) constructor.newInstance(objArr));
            } catch (ClassCastException e11) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + fullClassName, e11);
            } catch (ClassNotFoundException e12) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + fullClassName, e12);
            } catch (IllegalAccessException e13) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + fullClassName, e13);
            } catch (InstantiationException e14) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e14);
            } catch (InvocationTargetException e15) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e15);
            }
        }
    }

    private boolean didChildRangeChange(int i6, int i10) {
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        int[] iArr = this.mMinMaxLayoutPositions;
        return (iArr[0] == i6 && iArr[1] == i10) ? false : true;
    }

    private void dispatchContentChangedIfNecessary() {
        int i6 = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (i6 == 0 || !isAccessibilityEnabled()) {
            return;
        }
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
        accessibilityEventObtain.setEventType(2048);
        accessibilityEventObtain.setContentChangeTypes(i6);
        sendAccessibilityEventUnchecked(accessibilityEventObtain);
    }

    private void dispatchLayoutStep1() {
        C1133c2 c1133c2;
        this.mState.m2969a(1);
        fillRemainingScrollValues(this.mState);
        this.mState.f3623i = false;
        startInterceptRequestLayout();
        C1141e2 c1141e2 = this.mViewInfoStore;
        c1141e2.f3557a.clear();
        c1141e2.f3558b.m6795b();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        saveFocusInfo();
        C1162l1 c1162l1 = this.mState;
        c1162l1.f3622h = c1162l1.f3624j && this.mItemsChanged;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        c1162l1.f3621g = c1162l1.f3625k;
        c1162l1.f3619e = this.mAdapter.getItemCount();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.f3624j) {
            int iM2913e = this.mChildHelper.m2913e();
            for (int i6 = 0; i6 < iM2913e; i6++) {
                AbstractC1174p1 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2912d(i6));
                if (!childViewHolderInt.shouldIgnore() && (!childViewHolderInt.isInvalid() || this.mAdapter.hasStableIds())) {
                    AbstractC1182s0 abstractC1182s0 = this.mItemAnimator;
                    AbstractC1182s0.m2989b(childViewHolderInt);
                    childViewHolderInt.getUnmodifiedPayloads();
                    abstractC1182s0.getClass();
                    C1179r0 c1179r0 = new C1179r0();
                    c1179r0.m2988a(childViewHolderInt);
                    C3347k c3347k = this.mViewInfoStore.f3557a;
                    C1133c2 c1133c2M2908a = (C1133c2) c3347k.get(childViewHolderInt);
                    if (c1133c2M2908a == null) {
                        c1133c2M2908a = C1133c2.m2908a();
                        c3347k.put(childViewHolderInt, c1133c2M2908a);
                    }
                    c1133c2M2908a.f3531b = c1179r0;
                    c1133c2M2908a.f3530a |= 4;
                    if (this.mState.f3622h && childViewHolderInt.isUpdated() && !childViewHolderInt.isRemoved() && !childViewHolderInt.shouldIgnore() && !childViewHolderInt.isInvalid()) {
                        this.mViewInfoStore.f3558b.m6801h(getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                    }
                }
            }
        }
        if (this.mState.f3625k) {
            saveOldPositions();
            C1162l1 c1162l2 = this.mState;
            boolean z7 = c1162l2.f3620f;
            c1162l2.f3620f = false;
            this.mLayout.onLayoutChildren(this.mRecycler, c1162l2);
            this.mState.f3620f = z7;
            for (int i10 = 0; i10 < this.mChildHelper.m2913e(); i10++) {
                AbstractC1174p1 childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.m2912d(i10));
                if (!childViewHolderInt2.shouldIgnore() && ((c1133c2 = (C1133c2) this.mViewInfoStore.f3557a.get(childViewHolderInt2)) == null || (c1133c2.f3530a & 4) == 0)) {
                    AbstractC1182s0.m2989b(childViewHolderInt2);
                    boolean zHasAnyOfTheFlags = childViewHolderInt2.hasAnyOfTheFlags(8192);
                    AbstractC1182s0 abstractC1182s1 = this.mItemAnimator;
                    childViewHolderInt2.getUnmodifiedPayloads();
                    abstractC1182s1.getClass();
                    C1179r0 c1179r1 = new C1179r0();
                    c1179r1.m2988a(childViewHolderInt2);
                    if (zHasAnyOfTheFlags) {
                        recordAnimationInfoIfBouncedHiddenView(childViewHolderInt2, c1179r1);
                    } else {
                        C3347k c3347k2 = this.mViewInfoStore.f3557a;
                        C1133c2 c1133c2M2908a2 = (C1133c2) c3347k2.get(childViewHolderInt2);
                        if (c1133c2M2908a2 == null) {
                            c1133c2M2908a2 = C1133c2.m2908a();
                            c3347k2.put(childViewHolderInt2, c1133c2M2908a2);
                        }
                        c1133c2M2908a2.f3530a |= 2;
                        c1133c2M2908a2.f3531b = c1179r1;
                    }
                }
            }
            clearOldPositions();
        } else {
            clearOldPositions();
        }
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.f3618d = 2;
    }

    private void dispatchLayoutStep2() {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.m2969a(6);
        this.mAdapterHelper.m2873c();
        this.mState.f3619e = this.mAdapter.getItemCount();
        this.mState.f3617c = 0;
        if (this.mPendingSavedState != null && this.mAdapter.canRestoreState()) {
            Parcelable parcelable = this.mPendingSavedState.f3469c;
            if (parcelable != null) {
                this.mLayout.onRestoreInstanceState(parcelable);
            }
            this.mPendingSavedState = null;
        }
        C1162l1 c1162l1 = this.mState;
        c1162l1.f3621g = false;
        this.mLayout.onLayoutChildren(this.mRecycler, c1162l1);
        C1162l1 c1162l2 = this.mState;
        c1162l2.f3620f = false;
        c1162l2.f3624j = c1162l2.f3624j && this.mItemAnimator != null;
        c1162l2.f3618d = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
    }

    private void dispatchLayoutStep3() {
        boolean zM2957g;
        this.mState.m2969a(4);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        C1162l1 c1162l1 = this.mState;
        c1162l1.f3618d = 1;
        if (c1162l1.f3624j) {
            for (int iM2913e = this.mChildHelper.m2913e() - 1; iM2913e >= 0; iM2913e--) {
                AbstractC1174p1 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2912d(iM2913e));
                if (!childViewHolderInt.shouldIgnore()) {
                    long changedHolderKey = getChangedHolderKey(childViewHolderInt);
                    this.mItemAnimator.getClass();
                    C1179r0 c1179r0 = new C1179r0();
                    c1179r0.m2988a(childViewHolderInt);
                    AbstractC1174p1 abstractC1174p1 = (AbstractC1174p1) this.mViewInfoStore.f3558b.m6797d(changedHolderKey);
                    if (abstractC1174p1 == null || abstractC1174p1.shouldIgnore()) {
                        this.mViewInfoStore.m2938a(childViewHolderInt, c1179r0);
                    } else {
                        C1133c2 c1133c2 = (C1133c2) this.mViewInfoStore.f3557a.get(abstractC1174p1);
                        boolean z7 = (c1133c2 == null || (c1133c2.f3530a & 1) == 0) ? false : true;
                        C1133c2 c1133c3 = (C1133c2) this.mViewInfoStore.f3557a.get(childViewHolderInt);
                        boolean z10 = (c1133c3 == null || (c1133c3.f3530a & 1) == 0) ? false : true;
                        if (z7 && abstractC1174p1 == childViewHolderInt) {
                            this.mViewInfoStore.m2938a(childViewHolderInt, c1179r0);
                        } else {
                            C1179r0 c1179r0M2939b = this.mViewInfoStore.m2939b(abstractC1174p1, 4);
                            this.mViewInfoStore.m2938a(childViewHolderInt, c1179r0);
                            C1179r0 c1179r0M2939b2 = this.mViewInfoStore.m2939b(childViewHolderInt, 8);
                            if (c1179r0M2939b == null) {
                                handleMissingPreInfoForChangeError(changedHolderKey, childViewHolderInt, abstractC1174p1);
                            } else {
                                animateChange(abstractC1174p1, childViewHolderInt, c1179r0M2939b, c1179r0M2939b2, z7, z10);
                            }
                        }
                    }
                }
            }
            C1141e2 c1141e2 = this.mViewInfoStore;
            InterfaceC1137d2 interfaceC1137d2 = this.mViewInfoProcessCallback;
            C3347k c3347k = c1141e2.f3557a;
            for (int i6 = c3347k.f11334c - 1; i6 >= 0; i6--) {
                AbstractC1174p1 abstractC1174p2 = (AbstractC1174p1) c3347k.m6812f(i6);
                C1133c2 c1133c4 = (C1133c2) c3347k.mo6814h(i6);
                int i10 = c1133c4.f3530a;
                if ((i10 & 3) == 3) {
                    RecyclerView recyclerView = (RecyclerView) ((C1152i0) interfaceC1137d2).f3584a;
                    recyclerView.mLayout.removeAndRecycleView(abstractC1174p2.itemView, recyclerView.mRecycler);
                } else if ((i10 & 1) != 0) {
                    C1179r0 c1179r1 = c1133c4.f3531b;
                    if (c1179r1 == null) {
                        RecyclerView recyclerView2 = (RecyclerView) ((C1152i0) interfaceC1137d2).f3584a;
                        recyclerView2.mLayout.removeAndRecycleView(abstractC1174p2.itemView, recyclerView2.mRecycler);
                    } else {
                        C1179r0 c1179r2 = c1133c4.f3532c;
                        RecyclerView recyclerView3 = (RecyclerView) ((C1152i0) interfaceC1137d2).f3584a;
                        recyclerView3.mRecycler.m2936m(abstractC1174p2);
                        recyclerView3.animateDisappearance(abstractC1174p2, c1179r1, c1179r2);
                    }
                } else if ((i10 & 14) == 14) {
                    ((RecyclerView) ((C1152i0) interfaceC1137d2).f3584a).animateAppearance(abstractC1174p2, c1133c4.f3531b, c1133c4.f3532c);
                } else if ((i10 & 12) == 12) {
                    C1179r0 c1179r3 = c1133c4.f3531b;
                    C1179r0 c1179r4 = c1133c4.f3532c;
                    C1152i0 c1152i0 = (C1152i0) interfaceC1137d2;
                    c1152i0.getClass();
                    abstractC1174p2.setIsRecyclable(false);
                    RecyclerView recyclerView4 = (RecyclerView) c1152i0.f3584a;
                    if (!recyclerView4.mDataSetHasChangedAfterLayout) {
                        C1157k c1157k = (C1157k) recyclerView4.mItemAnimator;
                        c1157k.getClass();
                        int i11 = c1179r3.f3678a;
                        int i12 = c1179r4.f3678a;
                        if (i11 == i12 && c1179r3.f3679b == c1179r4.f3679b) {
                            c1157k.m2990c(abstractC1174p2);
                            zM2957g = false;
                        } else {
                            zM2957g = c1157k.m2957g(abstractC1174p2, i11, c1179r3.f3679b, i12, c1179r4.f3679b);
                        }
                        if (zM2957g) {
                            recyclerView4.postAnimationRunner();
                        }
                    } else if (recyclerView4.mItemAnimator.mo2953a(abstractC1174p2, abstractC1174p2, c1179r3, c1179r4)) {
                        recyclerView4.postAnimationRunner();
                    }
                } else if ((i10 & 4) != 0) {
                    C1179r0 c1179r5 = c1133c4.f3531b;
                    RecyclerView recyclerView5 = (RecyclerView) ((C1152i0) interfaceC1137d2).f3584a;
                    recyclerView5.mRecycler.m2936m(abstractC1174p2);
                    recyclerView5.animateDisappearance(abstractC1174p2, c1179r5, null);
                } else if ((i10 & 8) != 0) {
                    ((RecyclerView) ((C1152i0) interfaceC1137d2).f3584a).animateAppearance(abstractC1174p2, c1133c4.f3531b, c1133c4.f3532c);
                }
                c1133c4.f3530a = 0;
                c1133c4.f3531b = null;
                c1133c4.f3532c = null;
                C1133c2.f3529d.mo6101c(c1133c4);
            }
        }
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        C1162l1 c1162l2 = this.mState;
        c1162l2.f3616b = c1162l2.f3619e;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        c1162l2.f3624j = false;
        c1162l2.f3625k = false;
        this.mLayout.mRequestedSimpleAnimations = false;
        ArrayList arrayList = this.mRecycler.f3550b;
        if (arrayList != null) {
            arrayList.clear();
        }
        AbstractC1197x0 abstractC1197x0 = this.mLayout;
        if (abstractC1197x0.mPrefetchMaxObservedInInitialPrefetch) {
            abstractC1197x0.mPrefetchMaxCountObserved = 0;
            abstractC1197x0.mPrefetchMaxObservedInInitialPrefetch = false;
            this.mRecycler.m2937n();
        }
        this.mLayout.onLayoutCompleted(this.mState);
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        C1141e2 c1141e3 = this.mViewInfoStore;
        c1141e3.f3557a.clear();
        c1141e3.f3558b.m6795b();
        int[] iArr = this.mMinMaxLayoutPositions;
        if (didChildRangeChange(iArr[0], iArr[1])) {
            dispatchOnScrolled(0, 0);
        }
        recoverFocusFromState();
        resetFocusInfo();
    }

    private boolean dispatchToOnItemTouchListeners(MotionEvent motionEvent) {
        InterfaceC1124a1 interfaceC1124a1 = this.mInterceptingOnItemTouchListener;
        if (interfaceC1124a1 == null) {
            if (motionEvent.getAction() == 0) {
                return false;
            }
            return findInterceptingOnItemTouchListener(motionEvent);
        }
        C1172p c1172p = (C1172p) interfaceC1124a1;
        if (c1172p.f3667v != 0) {
            if (motionEvent.getAction() == 0) {
                boolean zM2977b = c1172p.m2977b(motionEvent.getX(), motionEvent.getY());
                boolean zM2976a = c1172p.m2976a(motionEvent.getX(), motionEvent.getY());
                if (zM2977b || zM2976a) {
                    if (zM2976a) {
                        c1172p.f3668w = 1;
                        c1172p.f3661p = (int) motionEvent.getX();
                    } else if (zM2977b) {
                        c1172p.f3668w = 2;
                        c1172p.f3658m = (int) motionEvent.getY();
                    }
                    c1172p.m2978d(2);
                }
            } else if (motionEvent.getAction() == 1 && c1172p.f3667v == 2) {
                c1172p.f3658m = 0.0f;
                c1172p.f3661p = 0.0f;
                c1172p.m2978d(1);
                c1172p.f3668w = 0;
            } else if (motionEvent.getAction() == 2 && c1172p.f3667v == 2) {
                c1172p.m2979e();
                int i6 = c1172p.f3668w;
                int i10 = c1172p.f3647b;
                if (i6 == 1) {
                    float x10 = motionEvent.getX();
                    int[] iArr = c1172p.f3670y;
                    iArr[0] = i10;
                    int i11 = c1172p.f3662q - i10;
                    iArr[1] = i11;
                    float fMax = Math.max(i10, Math.min(i11, x10));
                    if (Math.abs(c1172p.f3660o - fMax) >= 2.0f) {
                        int iM2975c = C1172p.m2975c(c1172p.f3661p, fMax, iArr, c1172p.f3664s.computeHorizontalScrollRange(), c1172p.f3664s.computeHorizontalScrollOffset(), c1172p.f3662q);
                        if (iM2975c != 0) {
                            c1172p.f3664s.scrollBy(iM2975c, 0);
                        }
                        c1172p.f3661p = fMax;
                    }
                }
                if (c1172p.f3668w == 2) {
                    float y7 = motionEvent.getY();
                    int[] iArr2 = c1172p.f3669x;
                    iArr2[0] = i10;
                    int i12 = c1172p.f3663r - i10;
                    iArr2[1] = i12;
                    float fMax2 = Math.max(i10, Math.min(i12, y7));
                    if (Math.abs(c1172p.f3657l - fMax2) >= 2.0f) {
                        int iM2975c2 = C1172p.m2975c(c1172p.f3658m, fMax2, iArr2, c1172p.f3664s.computeVerticalScrollRange(), c1172p.f3664s.computeVerticalScrollOffset(), c1172p.f3663r);
                        if (iM2975c2 != 0) {
                            c1172p.f3664s.scrollBy(0, iM2975c2);
                        }
                        c1172p.f3658m = fMax2;
                    }
                }
            }
        }
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.mInterceptingOnItemTouchListener = null;
        }
        return true;
    }

    private boolean findInterceptingOnItemTouchListener(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.mOnItemTouchListeners.size();
        for (int i6 = 0; i6 < size; i6++) {
            InterfaceC1124a1 interfaceC1124a1 = this.mOnItemTouchListeners.get(i6);
            C1172p c1172p = (C1172p) interfaceC1124a1;
            int i10 = c1172p.f3667v;
            if (i10 == 1) {
                boolean zM2977b = c1172p.m2977b(motionEvent.getX(), motionEvent.getY());
                boolean zM2976a = c1172p.m2976a(motionEvent.getX(), motionEvent.getY());
                if (motionEvent.getAction() == 0 && (zM2977b || zM2976a)) {
                    if (zM2976a) {
                        c1172p.f3668w = 1;
                        c1172p.f3661p = (int) motionEvent.getX();
                    } else if (zM2977b) {
                        c1172p.f3668w = 2;
                        c1172p.f3658m = (int) motionEvent.getY();
                    }
                    c1172p.m2978d(2);
                    if (action != 3) {
                        this.mInterceptingOnItemTouchListener = interfaceC1124a1;
                        return true;
                    }
                }
            } else if (i10 != 2) {
                continue;
            } else if (action != 3) {
                this.mInterceptingOnItemTouchListener = interfaceC1124a1;
                return true;
            }
        }
        return false;
    }

    private void findMinMaxChildLayoutPositions(int[] iArr) {
        int iM2913e = this.mChildHelper.m2913e();
        if (iM2913e == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i6 = Integer.MAX_VALUE;
        int i10 = Integer.MIN_VALUE;
        for (int i11 = 0; i11 < iM2913e; i11++) {
            AbstractC1174p1 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2912d(i11));
            if (!childViewHolderInt.shouldIgnore()) {
                int layoutPosition = childViewHolderInt.getLayoutPosition();
                if (layoutPosition < i6) {
                    i6 = layoutPosition;
                }
                if (layoutPosition > i10) {
                    i10 = layoutPosition;
                }
            }
        }
        iArr[0] = i6;
        iArr[1] = i10;
    }

    public static RecyclerView findNestedRecyclerView(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            RecyclerView recyclerViewFindNestedRecyclerView = findNestedRecyclerView(viewGroup.getChildAt(i6));
            if (recyclerViewFindNestedRecyclerView != null) {
                return recyclerViewFindNestedRecyclerView;
            }
        }
        return null;
    }

    private View findNextViewToFocus() {
        AbstractC1174p1 abstractC1174p1FindViewHolderForAdapterPosition;
        C1162l1 c1162l1 = this.mState;
        int i6 = c1162l1.f3626l;
        if (i6 == -1) {
            i6 = 0;
        }
        int iM2970b = c1162l1.m2970b();
        for (int i10 = i6; i10 < iM2970b; i10++) {
            AbstractC1174p1 abstractC1174p1FindViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i10);
            if (abstractC1174p1FindViewHolderForAdapterPosition2 == null) {
                break;
            }
            if (abstractC1174p1FindViewHolderForAdapterPosition2.itemView.hasFocusable()) {
                return abstractC1174p1FindViewHolderForAdapterPosition2.itemView;
            }
        }
        int iMin = Math.min(iM2970b, i6);
        do {
            iMin--;
            if (iMin < 0 || (abstractC1174p1FindViewHolderForAdapterPosition = findViewHolderForAdapterPosition(iMin)) == null) {
                return null;
            }
        } while (!abstractC1174p1FindViewHolderForAdapterPosition.itemView.hasFocusable());
        return abstractC1174p1FindViewHolderForAdapterPosition.itemView;
    }

    public static AbstractC1174p1 getChildViewHolderInt(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).f3465a;
    }

    public static void getDecoratedBoundsWithMarginsInt(View view, Rect rect) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect2 = layoutParams.f3466b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
    }

    private int getDeepestFocusedViewWithId(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    private String getFullClassName(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        if (str.contains(".")) {
            return str;
        }
        return RecyclerView.class.getPackage().getName() + '.' + str;
    }

    private C3142o getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new C3142o(this);
        }
        return this.mScrollingChildHelper;
    }

    private float getSplineFlingDistance(int i6) {
        double dLog = Math.log((Math.abs(i6) * INFLEXION) / (this.mPhysicalCoef * SCROLL_FRICTION));
        float f = DECELERATION_RATE;
        return (float) (Math.exp((((double) f) / (((double) f) - 1.0d)) * dLog) * ((double) (this.mPhysicalCoef * SCROLL_FRICTION)));
    }

    private void handleMissingPreInfoForChangeError(long j10, AbstractC1174p1 abstractC1174p1, AbstractC1174p1 abstractC1174p2) {
        int iM2913e = this.mChildHelper.m2913e();
        for (int i6 = 0; i6 < iM2913e; i6++) {
            AbstractC1174p1 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2912d(i6));
            if (childViewHolderInt != abstractC1174p1 && getChangedHolderKey(childViewHolderInt) == j10) {
                AbstractC1158k0 abstractC1158k0 = this.mAdapter;
                if (abstractC1158k0 == null || !abstractC1158k0.hasStableIds()) {
                    StringBuilder sb = new StringBuilder("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:");
                    sb.append(childViewHolderInt);
                    sb.append(" \n View Holder 2:");
                    sb.append(abstractC1174p1);
                    throw new IllegalStateException(AbstractC0004e.m22p(this, sb));
                }
                StringBuilder sb2 = new StringBuilder("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:");
                sb2.append(childViewHolderInt);
                sb2.append(" \n View Holder 2:");
                sb2.append(abstractC1174p1);
                throw new IllegalStateException(AbstractC0004e.m22p(this, sb2));
            }
        }
        Log.e(TAG, "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + abstractC1174p2 + " cannot be found but it is necessary for " + abstractC1174p1 + exceptionLabel());
    }

    private boolean hasUpdatedView() {
        int iM2913e = this.mChildHelper.m2913e();
        for (int i6 = 0; i6 < iM2913e; i6++) {
            AbstractC1174p1 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2912d(i6));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.isUpdated()) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"InlinedApi"})
    private void initAutofill() {
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        int i6 = Build.VERSION.SDK_INT;
        if ((i6 >= 26 ? AbstractC3128j0.m6208c(this) : 0) != 0 || i6 < 26) {
            return;
        }
        AbstractC3128j0.m6218m(this, 8);
    }

    private void initChildrenHelper() {
        this.mChildHelper = new C1134d(new C1152i0(this));
    }

    private boolean isPreferredNextFocus(View view, View view2, int i6) {
        int i10;
        if (view2 == null || view2 == this || view2 == view || findContainingItemView(view2) == null) {
            return false;
        }
        if (view == null || findContainingItemView(view) == null) {
            return true;
        }
        this.mTempRect.set(0, 0, view.getWidth(), view.getHeight());
        this.mTempRect2.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        offsetDescendantRectToMyCoords(view2, this.mTempRect2);
        byte b8 = -1;
        int i11 = this.mLayout.getLayoutDirection() == 1 ? -1 : 1;
        Rect rect = this.mTempRect;
        int i12 = rect.left;
        Rect rect2 = this.mTempRect2;
        int i13 = rect2.left;
        if ((i12 < i13 || rect.right <= i13) && rect.right < rect2.right) {
            i10 = 1;
        } else {
            int i14 = rect.right;
            int i15 = rect2.right;
            i10 = ((i14 > i15 || i12 >= i15) && i12 > i13) ? -1 : 0;
        }
        int i16 = rect.top;
        int i17 = rect2.top;
        if ((i16 < i17 || rect.bottom <= i17) && rect.bottom < rect2.bottom) {
            b8 = 1;
        } else {
            int i18 = rect.bottom;
            int i19 = rect2.bottom;
            if ((i18 <= i19 && i16 < i19) || i16 <= i17) {
                b8 = 0;
            }
        }
        if (i6 == 1) {
            return b8 < 0 || (b8 == 0 && i10 * i11 < 0);
        }
        if (i6 == 2) {
            return b8 > 0 || (b8 == 0 && i10 * i11 > 0);
        }
        if (i6 == 17) {
            return i10 < 0;
        }
        if (i6 == 33) {
            return b8 < 0;
        }
        if (i6 == 66) {
            return i10 > 0;
        }
        if (i6 == 130) {
            return b8 > 0;
        }
        StringBuilder sb = new StringBuilder("Invalid direction: ");
        sb.append(i6);
        throw new IllegalArgumentException(AbstractC0004e.m22p(this, sb));
    }

    private void nestedScrollByInternal(int i6, int i10, MotionEvent motionEvent, int i11) {
        AbstractC1197x0 abstractC1197x0 = this.mLayout;
        if (abstractC1197x0 == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        boolean zCanScrollHorizontally = abstractC1197x0.canScrollHorizontally();
        boolean zCanScrollVertically = this.mLayout.canScrollVertically();
        int i12 = zCanScrollVertically ? (zCanScrollHorizontally ? 1 : 0) | 2 : zCanScrollHorizontally ? 1 : 0;
        float height = motionEvent == null ? getHeight() / 2.0f : motionEvent.getY();
        float width = motionEvent == null ? getWidth() / 2.0f : motionEvent.getX();
        int iReleaseHorizontalGlow = i6 - releaseHorizontalGlow(i6, height);
        int iReleaseVerticalGlow = i10 - releaseVerticalGlow(i10, width);
        startNestedScroll(i12, i11);
        if (dispatchNestedPreScroll(zCanScrollHorizontally ? iReleaseHorizontalGlow : 0, zCanScrollVertically ? iReleaseVerticalGlow : 0, this.mReusableIntPair, this.mScrollOffset, i11)) {
            int[] iArr2 = this.mReusableIntPair;
            iReleaseHorizontalGlow -= iArr2[0];
            iReleaseVerticalGlow -= iArr2[1];
        }
        scrollByInternal(zCanScrollHorizontally ? iReleaseHorizontalGlow : 0, zCanScrollVertically ? iReleaseVerticalGlow : 0, motionEvent, i11);
        RunnableC1184t runnableC1184t = this.mGapWorker;
        if (runnableC1184t != null && (iReleaseHorizontalGlow != 0 || iReleaseVerticalGlow != 0)) {
            runnableC1184t.m2992a(this, iReleaseHorizontalGlow, iReleaseVerticalGlow);
        }
        stopNestedScroll(i11);
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
            int i6 = actionIndex == 0 ? 1 : 0;
            this.mScrollPointerId = motionEvent.getPointerId(i6);
            int x10 = (int) (motionEvent.getX(i6) + 0.5f);
            this.mLastTouchX = x10;
            this.mInitialTouchX = x10;
            int y7 = (int) (motionEvent.getY(i6) + 0.5f);
            this.mLastTouchY = y7;
            this.mInitialTouchY = y7;
        }
    }

    private boolean predictiveItemAnimationsEnabled() {
        return this.mItemAnimator != null && this.mLayout.supportsPredictiveItemAnimations();
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        boolean z7;
        boolean z10 = false;
        if (this.mDataSetHasChangedAfterLayout) {
            C1126b c1126b = this.mAdapterHelper;
            c1126b.m2881k(c1126b.f3515b);
            c1126b.m2881k(c1126b.f3516c);
            c1126b.f3519f = 0;
            if (this.mDispatchItemsChangedEvent) {
                this.mLayout.onItemsChanged(this);
            }
        }
        if (predictiveItemAnimationsEnabled()) {
            this.mAdapterHelper.m2880j();
        } else {
            this.mAdapterHelper.m2873c();
        }
        boolean z11 = this.mItemsAddedOrRemoved || this.mItemsChanged;
        this.mState.f3624j = this.mFirstLayoutComplete && this.mItemAnimator != null && ((z7 = this.mDataSetHasChangedAfterLayout) || z11 || this.mLayout.mRequestedSimpleAnimations) && (!z7 || this.mAdapter.hasStableIds());
        C1162l1 c1162l1 = this.mState;
        if (c1162l1.f3624j && z11 && !this.mDataSetHasChangedAfterLayout && predictiveItemAnimationsEnabled()) {
            z10 = true;
        }
        c1162l1.f3625k = z10;
    }

    private void pullGlows(float f, float f3, float f4, float f5) {
        boolean z7;
        boolean z10 = true;
        if (f3 >= 0.0f) {
            if (f3 > 0.0f) {
                ensureRightGlow();
                AbstractC1466d.m3506z(this.mRightGlow, f3 / getWidth(), f4 / getHeight());
            } else {
                z7 = false;
            }
            if (f5 < 0.0f) {
                ensureTopGlow();
                AbstractC1466d.m3506z(this.mTopGlow, (-f5) / getHeight(), f / getWidth());
            } else if (f5 > 0.0f) {
                ensureBottomGlow();
                AbstractC1466d.m3506z(this.mBottomGlow, f5 / getHeight(), 1.0f - (f / getWidth()));
            } else {
                z10 = z7;
            }
            if (z10 && f3 == 0.0f && f5 == 0.0f) {
                return;
            }
            postInvalidateOnAnimation();
        }
        ensureLeftGlow();
        AbstractC1466d.m3506z(this.mLeftGlow, (-f3) / getWidth(), 1.0f - (f4 / getHeight()));
        z7 = true;
        if (f5 < 0.0f) {
            ensureTopGlow();
            AbstractC1466d.m3506z(this.mTopGlow, (-f5) / getHeight(), f / getWidth());
        } else if (f5 > 0.0f) {
            ensureBottomGlow();
            AbstractC1466d.m3506z(this.mBottomGlow, f5 / getHeight(), 1.0f - (f / getWidth()));
        } else {
            z10 = z7;
        }
        if (z10) {
        }
        postInvalidateOnAnimation();
    }

    private void recoverFocusFromState() {
        View viewFindViewById;
        if (!this.mPreserveFocusAfterLayout || this.mAdapter == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            if (!this.mChildHelper.f3535c.contains(getFocusedChild())) {
                return;
            }
        }
        View viewFindNextViewToFocus = null;
        AbstractC1174p1 abstractC1174p1FindViewHolderForItemId = (this.mState.f3627m == -1 || !this.mAdapter.hasStableIds()) ? null : findViewHolderForItemId(this.mState.f3627m);
        if (abstractC1174p1FindViewHolderForItemId != null) {
            if (!this.mChildHelper.f3535c.contains(abstractC1174p1FindViewHolderForItemId.itemView) && abstractC1174p1FindViewHolderForItemId.itemView.hasFocusable()) {
                viewFindNextViewToFocus = abstractC1174p1FindViewHolderForItemId.itemView;
            } else if (this.mChildHelper.m2913e() > 0) {
                viewFindNextViewToFocus = findNextViewToFocus();
            }
        } else if (this.mChildHelper.m2913e() > 0) {
            viewFindNextViewToFocus = findNextViewToFocus();
        }
        if (viewFindNextViewToFocus != null) {
            int i6 = this.mState.f3628n;
            if (i6 != -1 && (viewFindViewById = viewFindNextViewToFocus.findViewById(i6)) != null && viewFindViewById.isFocusable()) {
                viewFindNextViewToFocus = viewFindViewById;
            }
            viewFindNextViewToFocus.requestFocus();
        }
    }

    private void releaseGlows() {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.mLeftGlow.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = this.mTopGlow;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mRightGlow;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.mBottomGlow.isFinished();
        }
        if (zIsFinished) {
            postInvalidateOnAnimation();
        }
    }

    private int releaseHorizontalGlow(int i6, float f) {
        float height = f / getHeight();
        float width = i6 / getWidth();
        EdgeEffect edgeEffect = this.mLeftGlow;
        float f3 = 0.0f;
        if (edgeEffect == null || AbstractC1466d.m3495m(edgeEffect) == 0.0f) {
            EdgeEffect edgeEffect2 = this.mRightGlow;
            if (edgeEffect2 != null && AbstractC1466d.m3495m(edgeEffect2) != 0.0f) {
                if (canScrollHorizontally(1)) {
                    this.mRightGlow.onRelease();
                } else {
                    float fM3506z = AbstractC1466d.m3506z(this.mRightGlow, width, height);
                    if (AbstractC1466d.m3495m(this.mRightGlow) == 0.0f) {
                        this.mRightGlow.onRelease();
                    }
                    f3 = fM3506z;
                }
                invalidate();
            }
        } else {
            if (canScrollHorizontally(-1)) {
                this.mLeftGlow.onRelease();
            } else {
                float f4 = -AbstractC1466d.m3506z(this.mLeftGlow, -width, 1.0f - height);
                if (AbstractC1466d.m3495m(this.mLeftGlow) == 0.0f) {
                    this.mLeftGlow.onRelease();
                }
                f3 = f4;
            }
            invalidate();
        }
        return Math.round(f3 * getWidth());
    }

    private int releaseVerticalGlow(int i6, float f) {
        float width = f / getWidth();
        float height = i6 / getHeight();
        EdgeEffect edgeEffect = this.mTopGlow;
        float f3 = 0.0f;
        if (edgeEffect == null || AbstractC1466d.m3495m(edgeEffect) == 0.0f) {
            EdgeEffect edgeEffect2 = this.mBottomGlow;
            if (edgeEffect2 != null && AbstractC1466d.m3495m(edgeEffect2) != 0.0f) {
                if (canScrollVertically(1)) {
                    this.mBottomGlow.onRelease();
                } else {
                    float fM3506z = AbstractC1466d.m3506z(this.mBottomGlow, height, 1.0f - width);
                    if (AbstractC1466d.m3495m(this.mBottomGlow) == 0.0f) {
                        this.mBottomGlow.onRelease();
                    }
                    f3 = fM3506z;
                }
                invalidate();
            }
        } else {
            if (canScrollVertically(-1)) {
                this.mTopGlow.onRelease();
            } else {
                float f4 = -AbstractC1466d.m3506z(this.mTopGlow, -height, width);
                if (AbstractC1466d.m3495m(this.mTopGlow) == 0.0f) {
                    this.mTopGlow.onRelease();
                }
                f3 = f4;
            }
            invalidate();
        }
        return Math.round(f3 * getHeight());
    }

    private void requestChildOnScreen(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (!layoutParams2.f3467c) {
                Rect rect = this.mTempRect;
                int i6 = rect.left;
                Rect rect2 = layoutParams2.f3466b;
                rect.left = i6 - rect2.left;
                rect.right += rect2.right;
                rect.top -= rect2.top;
                rect.bottom += rect2.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
        }
        this.mLayout.requestChildRectangleOnScreen(this, view, this.mTempRect, !this.mFirstLayoutComplete, view2 == null);
    }

    private void resetFocusInfo() {
        C1162l1 c1162l1 = this.mState;
        c1162l1.f3627m = -1L;
        c1162l1.f3626l = -1;
        c1162l1.f3628n = -1;
    }

    private void resetScroll() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        stopNestedScroll(0);
        releaseGlows();
    }

    private void saveFocusInfo() {
        int absoluteAdapterPosition;
        View focusedChild = (this.mPreserveFocusAfterLayout && hasFocus() && this.mAdapter != null) ? getFocusedChild() : null;
        AbstractC1174p1 abstractC1174p1FindContainingViewHolder = focusedChild != null ? findContainingViewHolder(focusedChild) : null;
        if (abstractC1174p1FindContainingViewHolder == null) {
            resetFocusInfo();
            return;
        }
        this.mState.f3627m = this.mAdapter.hasStableIds() ? abstractC1174p1FindContainingViewHolder.getItemId() : -1L;
        C1162l1 c1162l1 = this.mState;
        if (this.mDataSetHasChangedAfterLayout) {
            absoluteAdapterPosition = -1;
        } else {
            absoluteAdapterPosition = abstractC1174p1FindContainingViewHolder.isRemoved() ? abstractC1174p1FindContainingViewHolder.mOldPosition : abstractC1174p1FindContainingViewHolder.getAbsoluteAdapterPosition();
        }
        c1162l1.f3626l = absoluteAdapterPosition;
        this.mState.f3628n = getDeepestFocusedViewWithId(abstractC1174p1FindContainingViewHolder.itemView);
    }

    private void setAdapterInternal(AbstractC1158k0 abstractC1158k0, boolean z7, boolean z10) {
        AbstractC1158k0 abstractC1158k1 = this.mAdapter;
        if (abstractC1158k1 != null) {
            abstractC1158k1.unregisterAdapterDataObserver(this.mObserver);
            this.mAdapter.onDetachedFromRecyclerView(this);
        }
        if (!z7 || z10) {
            removeAndRecycleViews();
        }
        C1126b c1126b = this.mAdapterHelper;
        c1126b.m2881k(c1126b.f3515b);
        c1126b.m2881k(c1126b.f3516c);
        int i6 = 0;
        c1126b.f3519f = 0;
        AbstractC1158k0 abstractC1158k2 = this.mAdapter;
        this.mAdapter = abstractC1158k0;
        if (abstractC1158k0 != null) {
            abstractC1158k0.registerAdapterDataObserver(this.mObserver);
            abstractC1158k0.onAttachedToRecyclerView(this);
        }
        AbstractC1197x0 abstractC1197x0 = this.mLayout;
        if (abstractC1197x0 != null) {
            abstractC1197x0.onAdapterChanged(abstractC1158k2, this.mAdapter);
        }
        C1140e1 c1140e1 = this.mRecycler;
        AbstractC1158k0 abstractC1158k3 = this.mAdapter;
        c1140e1.f3549a.clear();
        c1140e1.m2930g();
        c1140e1.m2929f(abstractC1158k2, true);
        C1136d1 c1136d1M2927c = c1140e1.m2927c();
        if (abstractC1158k2 != null) {
            c1136d1M2927c.f3542b--;
        }
        if (!z7 && c1136d1M2927c.f3542b == 0) {
            while (true) {
                SparseArray sparseArray = c1136d1M2927c.f3541a;
                if (i6 >= sparseArray.size()) {
                    break;
                }
                C1132c1 c1132c1 = (C1132c1) sparseArray.valueAt(i6);
                Iterator it = c1132c1.f3525a.iterator();
                while (it.hasNext()) {
                    AbstractC2973a.m6015e(((AbstractC1174p1) it.next()).itemView);
                }
                c1132c1.f3525a.clear();
                i6++;
            }
        }
        if (abstractC1158k3 != null) {
            c1136d1M2927c.f3542b++;
        } else {
            c1136d1M2927c.getClass();
        }
        c1140e1.m2928e();
        this.mState.f3620f = true;
    }

    public static void setDebugAssertionsEnabled(boolean z7) {
        sDebugAssertionsEnabled = z7;
    }

    public static void setVerboseLoggingEnabled(boolean z7) {
        sVerboseLoggingEnabled = z7;
    }

    private boolean shouldAbsorb(EdgeEffect edgeEffect, int i6, int i10) {
        if (i6 > 0) {
            return true;
        }
        return getSplineFlingDistance(-i6) < AbstractC1466d.m3495m(edgeEffect) * ((float) i10);
    }

    private void startNestedScrollForType(int i6) {
        boolean zCanScrollHorizontally = this.mLayout.canScrollHorizontally();
        int i10 = zCanScrollHorizontally;
        if (this.mLayout.canScrollVertically()) {
            i10 = (zCanScrollHorizontally ? 1 : 0) | 2;
        }
        startNestedScroll(i10, i6);
    }

    private boolean stopGlowAnimations(MotionEvent motionEvent) {
        boolean z7;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || AbstractC1466d.m3495m(edgeEffect) == 0.0f || canScrollHorizontally(-1)) {
            z7 = false;
        } else {
            AbstractC1466d.m3506z(this.mLeftGlow, 0.0f, 1.0f - (motionEvent.getY() / getHeight()));
            z7 = true;
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (edgeEffect2 != null && AbstractC1466d.m3495m(edgeEffect2) != 0.0f && !canScrollHorizontally(1)) {
            AbstractC1466d.m3506z(this.mRightGlow, 0.0f, motionEvent.getY() / getHeight());
            z7 = true;
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && AbstractC1466d.m3495m(edgeEffect3) != 0.0f && !canScrollVertically(-1)) {
            AbstractC1466d.m3506z(this.mTopGlow, 0.0f, motionEvent.getX() / getWidth());
            z7 = true;
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 == null || AbstractC1466d.m3495m(edgeEffect4) == 0.0f || canScrollVertically(1)) {
            return z7;
        }
        AbstractC1466d.m3506z(this.mBottomGlow, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
        return true;
    }

    private void stopScrollersInternal() {
        RunnableC1171o1 runnableC1171o1 = this.mViewFlinger;
        runnableC1171o1.f3641g.removeCallbacks(runnableC1171o1);
        runnableC1171o1.f3637c.abortAnimation();
        AbstractC1197x0 abstractC1197x0 = this.mLayout;
        if (abstractC1197x0 != null) {
            abstractC1197x0.stopSmoothScroller();
        }
    }

    public boolean m2836a() {
        return isChildrenDrawingOrderEnabled();
    }

    public void absorbGlows(int i6, int i10) {
        if (i6 < 0) {
            ensureLeftGlow();
            if (this.mLeftGlow.isFinished()) {
                this.mLeftGlow.onAbsorb(-i6);
            }
        } else if (i6 > 0) {
            ensureRightGlow();
            if (this.mRightGlow.isFinished()) {
                this.mRightGlow.onAbsorb(i6);
            }
        }
        if (i10 < 0) {
            ensureTopGlow();
            if (this.mTopGlow.isFinished()) {
                this.mTopGlow.onAbsorb(-i10);
            }
        } else if (i10 > 0) {
            ensureBottomGlow();
            if (this.mBottomGlow.isFinished()) {
                this.mBottomGlow.onAbsorb(i10);
            }
        }
        if (i6 == 0 && i10 == 0) {
            return;
        }
        postInvalidateOnAnimation();
    }

    @Override
    public void addFocusables(ArrayList<View> arrayList, int i6, int i10) {
        AbstractC1197x0 abstractC1197x0 = this.mLayout;
        if (abstractC1197x0 == null || !abstractC1197x0.onAddFocusables(this, arrayList, i6, i10)) {
            super.addFocusables(arrayList, i6, i10);
        }
    }

    public void addItemDecoration(AbstractC1185t0 abstractC1185t0, int i6) {
        AbstractC1197x0 abstractC1197x0 = this.mLayout;
        if (abstractC1197x0 != null) {
            abstractC1197x0.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i6 < 0) {
            this.mItemDecorations.add(abstractC1185t0);
        } else {
            this.mItemDecorations.add(i6, abstractC1185t0);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void addOnChildAttachStateChangeListener(InterfaceC1200y0 interfaceC1200y0) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList();
        }
        this.mOnChildAttachStateListeners.add(interfaceC1200y0);
    }

    public void addOnItemTouchListener(InterfaceC1124a1 interfaceC1124a1) {
        this.mOnItemTouchListeners.add(interfaceC1124a1);
    }

    public void addOnScrollListener(AbstractC1128b1 abstractC1128b1) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(abstractC1128b1);
    }

    public void addRecyclerListener(InterfaceC1144f1 interfaceC1144f1) {
        AbstractC0032a.m160n("'listener' arg cannot be null.", interfaceC1144f1 != null);
        this.mRecyclerListeners.add(interfaceC1144f1);
    }

    public void animateAppearance(AbstractC1174p1 abstractC1174p1, C1179r0 c1179r0, C1179r0 c1179r1) {
        boolean zM2957g;
        abstractC1174p1.setIsRecyclable(false);
        C1157k c1157k = (C1157k) this.mItemAnimator;
        if (c1179r0 != null) {
            c1157k.getClass();
            int i6 = c1179r0.f3678a;
            int i10 = c1179r1.f3678a;
            if (i6 == i10 && c1179r0.f3679b == c1179r1.f3679b) {
                c1157k.m2961l(abstractC1174p1);
                abstractC1174p1.itemView.setAlpha(0.0f);
                c1157k.f3602i.add(abstractC1174p1);
                zM2957g = true;
            } else {
                zM2957g = c1157k.m2957g(abstractC1174p1, i6, c1179r0.f3679b, i10, c1179r1.f3679b);
            }
        } else {
            c1157k.m2961l(abstractC1174p1);
            abstractC1174p1.itemView.setAlpha(0.0f);
            c1157k.f3602i.add(abstractC1174p1);
            zM2957g = true;
        }
        if (zM2957g) {
            postAnimationRunner();
        }
    }

    public void animateDisappearance(AbstractC1174p1 abstractC1174p1, C1179r0 c1179r0, C1179r0 c1179r1) {
        boolean zM2957g;
        addAnimatingView(abstractC1174p1);
        abstractC1174p1.setIsRecyclable(false);
        C1157k c1157k = (C1157k) this.mItemAnimator;
        c1157k.getClass();
        int i6 = c1179r0.f3678a;
        int i10 = c1179r0.f3679b;
        View view = abstractC1174p1.itemView;
        int left = c1179r1 == null ? view.getLeft() : c1179r1.f3678a;
        int top = c1179r1 == null ? view.getTop() : c1179r1.f3679b;
        if (abstractC1174p1.isRemoved() || (i6 == left && i10 == top)) {
            c1157k.m2961l(abstractC1174p1);
            c1157k.f3601h.add(abstractC1174p1);
            zM2957g = true;
        } else {
            view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
            zM2957g = c1157k.m2957g(abstractC1174p1, i6, i10, left, top);
        }
        if (zM2957g) {
            postAnimationRunner();
        }
    }

    public void assertInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            return;
        }
        if (str != null) {
            throw new IllegalStateException(AbstractC0004e.m22p(this, AbstractC2460q.m5498l(str)));
        }
        throw new IllegalStateException(AbstractC0004e.m22p(this, new StringBuilder("Cannot call this method unless RecyclerView is computing a layout or scrolling")));
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException(AbstractC0004e.m22p(this, new StringBuilder("Cannot call this method while RecyclerView is computing a layout or scrolling")));
        }
        if (this.mDispatchScrollCounter > 0) {
            Log.w(TAG, "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(AbstractC0004e.m22p(this, new StringBuilder(""))));
        }
    }

    public boolean canReuseUpdatedViewHolder(AbstractC1174p1 abstractC1174p1) {
        AbstractC1182s0 abstractC1182s0 = this.mItemAnimator;
        if (abstractC1182s0 != null) {
            C1157k c1157k = (C1157k) abstractC1182s0;
            if (abstractC1174p1.getUnmodifiedPayloads().isEmpty() && c1157k.f3600g && !abstractC1174p1.isInvalid()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.mLayout.checkLayoutParams((LayoutParams) layoutParams);
    }

    public void clearOldPositions() {
        int iM2916h = this.mChildHelper.m2916h();
        for (int i6 = 0; i6 < iM2916h; i6++) {
            AbstractC1174p1 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2915g(i6));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.clearOldPosition();
            }
        }
        C1140e1 c1140e1 = this.mRecycler;
        ArrayList arrayList = c1140e1.f3551c;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((AbstractC1174p1) arrayList.get(i10)).clearOldPosition();
        }
        ArrayList arrayList2 = c1140e1.f3549a;
        int size2 = arrayList2.size();
        for (int i11 = 0; i11 < size2; i11++) {
            ((AbstractC1174p1) arrayList2.get(i11)).clearOldPosition();
        }
        ArrayList arrayList3 = c1140e1.f3550b;
        if (arrayList3 != null) {
            int size3 = arrayList3.size();
            for (int i12 = 0; i12 < size3; i12++) {
                ((AbstractC1174p1) c1140e1.f3550b.get(i12)).clearOldPosition();
            }
        }
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<InterfaceC1200y0> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void clearOnScrollListeners() {
        List<AbstractC1128b1> list = this.mScrollListeners;
        if (list != null) {
            list.clear();
        }
    }

    @Override
    public int computeHorizontalScrollExtent() {
        AbstractC1197x0 abstractC1197x0 = this.mLayout;
        if (abstractC1197x0 != null && abstractC1197x0.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollExtent(this.mState);
        }
        return 0;
    }

    @Override
    public int computeHorizontalScrollOffset() {
        AbstractC1197x0 abstractC1197x0 = this.mLayout;
        if (abstractC1197x0 != null && abstractC1197x0.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollOffset(this.mState);
        }
        return 0;
    }

    @Override
    public int computeHorizontalScrollRange() {
        AbstractC1197x0 abstractC1197x0 = this.mLayout;
        if (abstractC1197x0 != null && abstractC1197x0.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollRange(this.mState);
        }
        return 0;
    }

    @Override
    public int computeVerticalScrollExtent() {
        AbstractC1197x0 abstractC1197x0 = this.mLayout;
        if (abstractC1197x0 != null && abstractC1197x0.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollExtent(this.mState);
        }
        return 0;
    }

    @Override
    public int computeVerticalScrollOffset() {
        AbstractC1197x0 abstractC1197x0 = this.mLayout;
        if (abstractC1197x0 != null && abstractC1197x0.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollOffset(this.mState);
        }
        return 0;
    }

    @Override
    public int computeVerticalScrollRange() {
        AbstractC1197x0 abstractC1197x0 = this.mLayout;
        if (abstractC1197x0 != null && abstractC1197x0.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollRange(this.mState);
        }
        return 0;
    }

    public void considerReleasingGlowsOnScroll(int i6, int i10) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished() || i6 <= 0) {
            zIsFinished = false;
        } else {
            this.mLeftGlow.onRelease();
            zIsFinished = this.mLeftGlow.isFinished();
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i6 < 0) {
            this.mRightGlow.onRelease();
            zIsFinished |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i10 > 0) {
            this.mTopGlow.onRelease();
            zIsFinished |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i10 < 0) {
            this.mBottomGlow.onRelease();
            zIsFinished |= this.mBottomGlow.isFinished();
        }
        if (zIsFinished) {
            postInvalidateOnAnimation();
        }
    }

    public int consumeFlingInHorizontalStretch(int i6) {
        return consumeFlingInStretch(i6, this.mLeftGlow, this.mRightGlow, getWidth());
    }

    public int consumeFlingInVerticalStretch(int i6) {
        return consumeFlingInStretch(i6, this.mTopGlow, this.mBottomGlow, getHeight());
    }

    public void consumePendingUpdateOperations() {
        if (!this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout) {
            Trace.beginSection(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
            dispatchLayout();
            Trace.endSection();
            return;
        }
        if (this.mAdapterHelper.m2877g()) {
            C1126b c1126b = this.mAdapterHelper;
            int i6 = c1126b.f3519f;
            if ((i6 & 4) == 0 || (i6 & 11) != 0) {
                if (c1126b.m2877g()) {
                    Trace.beginSection(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
                    dispatchLayout();
                    Trace.endSection();
                    return;
                }
                return;
            }
            Trace.beginSection(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
            startInterceptRequestLayout();
            onEnterLayoutOrScroll();
            this.mAdapterHelper.m2880j();
            if (!this.mLayoutWasDefered) {
                if (hasUpdatedView()) {
                    dispatchLayout();
                } else {
                    this.mAdapterHelper.m2872b();
                }
            }
            stopInterceptRequestLayout(true);
            onExitLayoutOrScroll();
            Trace.endSection();
        }
    }

    public void defaultOnMeasure(int i6, int i10) {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        setMeasuredDimension(AbstractC1197x0.chooseSize(i6, paddingRight, getMinimumWidth()), AbstractC1197x0.chooseSize(i10, getPaddingBottom() + getPaddingTop(), getMinimumHeight()));
    }

    public void dispatchChildAttached(View view) {
        AbstractC1174p1 childViewHolderInt = getChildViewHolderInt(view);
        onChildAttachedToWindow(view);
        AbstractC1158k0 abstractC1158k0 = this.mAdapter;
        if (abstractC1158k0 != null && childViewHolderInt != null) {
            abstractC1158k0.onViewAttachedToWindow(childViewHolderInt);
        }
        List<InterfaceC1200y0> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).onChildViewAttachedToWindow(view);
            }
        }
    }

    public void dispatchChildDetached(View view) {
        AbstractC1174p1 childViewHolderInt = getChildViewHolderInt(view);
        onChildDetachedFromWindow(view);
        AbstractC1158k0 abstractC1158k0 = this.mAdapter;
        if (abstractC1158k0 != null && childViewHolderInt != null) {
            abstractC1158k0.onViewDetachedFromWindow(childViewHolderInt);
        }
        List<InterfaceC1200y0> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).onChildViewDetachedFromWindow(view);
            }
        }
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (super.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        AbstractC1197x0 layoutManager = getLayoutManager();
        int itemCount = 0;
        if (layoutManager == null) {
            return false;
        }
        if (layoutManager.canScrollVertically()) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 92 || keyCode == 93) {
                int measuredHeight = getMeasuredHeight();
                if (keyCode == 93) {
                    smoothScrollBy(0, measuredHeight, null, Integer.MIN_VALUE);
                } else {
                    smoothScrollBy(0, -measuredHeight, null, Integer.MIN_VALUE);
                }
                return true;
            }
            if (keyCode == 122 || keyCode == 123) {
                boolean zIsLayoutReversed = layoutManager.isLayoutReversed();
                if (keyCode == 122) {
                    if (zIsLayoutReversed) {
                        itemCount = getAdapter().getItemCount();
                    }
                } else if (!zIsLayoutReversed) {
                    itemCount = getAdapter().getItemCount();
                }
                smoothScrollToPosition(itemCount);
                return true;
            }
        } else if (layoutManager.canScrollHorizontally()) {
            int keyCode2 = keyEvent.getKeyCode();
            if (keyCode2 == 92 || keyCode2 == 93) {
                int measuredWidth = getMeasuredWidth();
                if (keyCode2 == 93) {
                    smoothScrollBy(measuredWidth, 0, null, Integer.MIN_VALUE);
                } else {
                    smoothScrollBy(-measuredWidth, 0, null, Integer.MIN_VALUE);
                }
                return true;
            }
            if (keyCode2 == 122 || keyCode2 == 123) {
                boolean zIsLayoutReversed2 = layoutManager.isLayoutReversed();
                if (keyCode2 == 122) {
                    if (zIsLayoutReversed2) {
                        itemCount = getAdapter().getItemCount();
                    }
                } else if (!zIsLayoutReversed2) {
                    itemCount = getAdapter().getItemCount();
                }
                smoothScrollToPosition(itemCount);
                return true;
            }
        }
        return false;
    }

    public void dispatchLayout() {
        if (this.mAdapter == null) {
            Log.w(TAG, "No adapter attached; skipping layout");
            return;
        }
        if (this.mLayout == null) {
            Log.e(TAG, "No layout manager attached; skipping layout");
            return;
        }
        this.mState.f3623i = false;
        boolean z7 = this.mLastAutoMeasureSkippedDueToExact && !(this.mLastAutoMeasureNonExactMeasuredWidth == getWidth() && this.mLastAutoMeasureNonExactMeasuredHeight == getHeight());
        this.mLastAutoMeasureNonExactMeasuredWidth = 0;
        this.mLastAutoMeasureNonExactMeasuredHeight = 0;
        this.mLastAutoMeasureSkippedDueToExact = false;
        if (this.mState.f3618d == 1) {
            dispatchLayoutStep1();
            this.mLayout.setExactMeasureSpecsFrom(this);
            dispatchLayoutStep2();
        } else {
            C1126b c1126b = this.mAdapterHelper;
            if ((c1126b.f3516c.isEmpty() || c1126b.f3515b.isEmpty()) && !z7 && this.mLayout.getWidth() == getWidth() && this.mLayout.getHeight() == getHeight()) {
                this.mLayout.setExactMeasureSpecsFrom(this);
            } else {
                this.mLayout.setExactMeasureSpecsFrom(this);
                dispatchLayoutStep2();
            }
        }
        dispatchLayoutStep3();
    }

    @Override
    public boolean dispatchNestedFling(float f, float f3, boolean z7) {
        return getScrollingChildHelper().m6280a(f, f3, z7);
    }

    @Override
    public boolean dispatchNestedPreFling(float f, float f3) {
        return getScrollingChildHelper().m6281b(f, f3);
    }

    @Override
    public boolean dispatchNestedPreScroll(int i6, int i10, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().m6282c(i6, i10, iArr, iArr2, 0);
    }

    @Override
    public boolean dispatchNestedScroll(int i6, int i10, int i11, int i12, int[] iArr) {
        return getScrollingChildHelper().m6283d(i6, i10, i11, i12, iArr, 0, null);
    }

    public void dispatchOnScrollStateChanged(int i6) {
        AbstractC1197x0 abstractC1197x0 = this.mLayout;
        if (abstractC1197x0 != null) {
            abstractC1197x0.onScrollStateChanged(i6);
        }
        onScrollStateChanged(i6);
        AbstractC1128b1 abstractC1128b1 = this.mScrollListener;
        if (abstractC1128b1 != null) {
            abstractC1128b1.onScrollStateChanged(this, i6);
        }
        List<AbstractC1128b1> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrollStateChanged(this, i6);
            }
        }
    }

    public void dispatchOnScrolled(int i6, int i10) {
        this.mDispatchScrollCounter++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i6, scrollY - i10);
        onScrolled(i6, i10);
        AbstractC1128b1 abstractC1128b1 = this.mScrollListener;
        if (abstractC1128b1 != null) {
            abstractC1128b1.onScrolled(this, i6, i10);
        }
        List<AbstractC1128b1> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrolled(this, i6, i10);
            }
        }
        this.mDispatchScrollCounter--;
    }

    public void dispatchPendingImportantForAccessibilityChanges() {
        int i6;
        for (int size = this.mPendingAccessibilityImportanceChange.size() - 1; size >= 0; size--) {
            AbstractC1174p1 abstractC1174p1 = this.mPendingAccessibilityImportanceChange.get(size);
            if (abstractC1174p1.itemView.getParent() == this && !abstractC1174p1.shouldIgnore() && (i6 = abstractC1174p1.mPendingAccessibilityState) != -1) {
                abstractC1174p1.itemView.setImportantForAccessibility(i6);
                abstractC1174p1.mPendingAccessibilityState = -1;
            }
        }
        this.mPendingAccessibilityImportanceChange.clear();
    }

    @Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override
    public void draw(Canvas canvas) {
        boolean z7;
        super.draw(canvas);
        int size = this.mItemDecorations.size();
        boolean z10 = false;
        for (int i6 = 0; i6 < size; i6++) {
            this.mItemDecorations.get(i6).onDrawOver(canvas, this, this.mState);
        }
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z7 = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.mClipToPadding ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.mLeftGlow;
            z7 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.mTopGlow;
            z7 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.mRightGlow;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.mClipToPadding ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(paddingTop, -width);
            EdgeEffect edgeEffect6 = this.mRightGlow;
            z7 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.mBottomGlow;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                canvas.translate(getPaddingRight() + (-getWidth()), getPaddingBottom() + (-getHeight()));
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.mBottomGlow;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z10 = true;
            }
            z7 |= z10;
            canvas.restoreToCount(iSave4);
        }
        if ((z7 || this.mItemAnimator == null || this.mItemDecorations.size() <= 0 || !this.mItemAnimator.mo2956f()) ? z7 : true) {
            postInvalidateOnAnimation();
        }
    }

    @Override
    public boolean drawChild(Canvas canvas, View view, long j10) {
        return super.drawChild(canvas, view, j10);
    }

    public void ensureBottomGlow() {
        if (this.mBottomGlow != null) {
            return;
        }
        ((C1165m1) this.mEdgeEffectFactory).getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.mBottomGlow = edgeEffect;
        if (this.mClipToPadding) {
            edgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void ensureLeftGlow() {
        if (this.mLeftGlow != null) {
            return;
        }
        ((C1165m1) this.mEdgeEffectFactory).getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.mLeftGlow = edgeEffect;
        if (this.mClipToPadding) {
            edgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public void ensureRightGlow() {
        if (this.mRightGlow != null) {
            return;
        }
        ((C1165m1) this.mEdgeEffectFactory).getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.mRightGlow = edgeEffect;
        if (this.mClipToPadding) {
            edgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public void ensureTopGlow() {
        if (this.mTopGlow != null) {
            return;
        }
        ((C1165m1) this.mEdgeEffectFactory).getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.mTopGlow = edgeEffect;
        if (this.mClipToPadding) {
            edgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public String exceptionLabel() {
        return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + getContext();
    }

    public final void fillRemainingScrollValues(C1162l1 c1162l1) {
        if (getScrollState() != 2) {
            c1162l1.f3629o = 0;
            c1162l1.f3630p = 0;
        } else {
            OverScroller overScroller = this.mViewFlinger.f3637c;
            c1162l1.f3629o = overScroller.getFinalX() - overScroller.getCurrX();
            c1162l1.f3630p = overScroller.getFinalY() - overScroller.getCurrY();
        }
    }

    public View findChildViewUnder(float f, float f3) {
        for (int iM2913e = this.mChildHelper.m2913e() - 1; iM2913e >= 0; iM2913e--) {
            View viewM2912d = this.mChildHelper.m2912d(iM2913e);
            float translationX = viewM2912d.getTranslationX();
            float translationY = viewM2912d.getTranslationY();
            if (f >= viewM2912d.getLeft() + translationX && f <= viewM2912d.getRight() + translationX && f3 >= viewM2912d.getTop() + translationY && f3 <= viewM2912d.getBottom() + translationY) {
                return viewM2912d;
            }
        }
        return null;
    }

    public View findContainingItemView(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public AbstractC1174p1 findContainingViewHolder(View view) {
        View viewFindContainingItemView = findContainingItemView(view);
        if (viewFindContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(viewFindContainingItemView);
    }

    public AbstractC1174p1 findViewHolderForAdapterPosition(int i6) {
        AbstractC1174p1 abstractC1174p1 = null;
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int iM2916h = this.mChildHelper.m2916h();
        for (int i10 = 0; i10 < iM2916h; i10++) {
            AbstractC1174p1 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2915g(i10));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && getAdapterPositionInRecyclerView(childViewHolderInt) == i6) {
                C1134d c1134d = this.mChildHelper;
                if (!c1134d.f3535c.contains(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                abstractC1174p1 = childViewHolderInt;
            }
        }
        return abstractC1174p1;
    }

    public AbstractC1174p1 findViewHolderForItemId(long j10) {
        AbstractC1158k0 abstractC1158k0 = this.mAdapter;
        AbstractC1174p1 abstractC1174p1 = null;
        if (abstractC1158k0 != null && abstractC1158k0.hasStableIds()) {
            int iM2916h = this.mChildHelper.m2916h();
            for (int i6 = 0; i6 < iM2916h; i6++) {
                AbstractC1174p1 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2915g(i6));
                if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && childViewHolderInt.getItemId() == j10) {
                    C1134d c1134d = this.mChildHelper;
                    if (!c1134d.f3535c.contains(childViewHolderInt.itemView)) {
                        return childViewHolderInt;
                    }
                    abstractC1174p1 = childViewHolderInt;
                }
            }
        }
        return abstractC1174p1;
    }

    public AbstractC1174p1 findViewHolderForLayoutPosition(int i6) {
        return findViewHolderForPosition(i6, false);
    }

    @Deprecated
    public AbstractC1174p1 findViewHolderForPosition(int i6) {
        return findViewHolderForPosition(i6, false);
    }

    public boolean fling(int i6, int i10) {
        return fling(i6, i10, this.mMinFlingVelocity, this.mMaxFlingVelocity);
    }

    public boolean flingNoThresholdCheck(int i6, int i10) {
        return fling(i6, i10, 0, Integer.MAX_VALUE);
    }

    @Override
    public View focusSearch(View view, int i6) {
        View viewOnFocusSearchFailed;
        boolean z7;
        View viewOnInterceptFocusSearch = this.mLayout.onInterceptFocusSearch(view, i6);
        if (viewOnInterceptFocusSearch != null) {
            return viewOnInterceptFocusSearch;
        }
        boolean z10 = (this.mAdapter == null || this.mLayout == null || isComputingLayout() || this.mLayoutSuppressed) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z10 && (i6 == 2 || i6 == 1)) {
            if (this.mLayout.canScrollVertically()) {
                if (focusFinder.findNextFocus(this, view, i6 == 2 ? TsExtractor.TS_STREAM_TYPE_HDMV_DTS : 33) == null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
            } else {
                z7 = false;
            }
            if (!z7 && this.mLayout.canScrollHorizontally()) {
                z7 = focusFinder.findNextFocus(this, view, (this.mLayout.getLayoutDirection() == 1) ^ (i6 == 2) ? 66 : 17) == null;
            }
            if (z7) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                this.mLayout.onFocusSearchFailed(view, i6, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
            viewOnFocusSearchFailed = focusFinder.findNextFocus(this, view, i6);
        } else {
            View viewFindNextFocus = focusFinder.findNextFocus(this, view, i6);
            if (viewFindNextFocus == null && z10) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                viewOnFocusSearchFailed = this.mLayout.onFocusSearchFailed(view, i6, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            } else {
                viewOnFocusSearchFailed = viewFindNextFocus;
            }
        }
        if (viewOnFocusSearchFailed == null || viewOnFocusSearchFailed.hasFocusable()) {
            return isPreferredNextFocus(view, viewOnFocusSearchFailed, i6) ? viewOnFocusSearchFailed : super.focusSearch(view, i6);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i6);
        }
        requestChildOnScreen(viewOnFocusSearchFailed, null);
        return view;
    }

    @Override
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        AbstractC1197x0 abstractC1197x0 = this.mLayout;
        if (abstractC1197x0 != null) {
            return abstractC1197x0.generateDefaultLayoutParams();
        }
        throw new IllegalStateException(AbstractC0004e.m22p(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    @Override
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        AbstractC1197x0 abstractC1197x0 = this.mLayout;
        if (abstractC1197x0 != null) {
            return abstractC1197x0.generateLayoutParams(getContext(), attributeSet);
        }
        throw new IllegalStateException(AbstractC0004e.m22p(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    @Override
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public AbstractC1158k0 getAdapter() {
        return this.mAdapter;
    }

    public int getAdapterPositionInRecyclerView(AbstractC1174p1 abstractC1174p1) {
        if (abstractC1174p1.hasAnyOfTheFlags(524) || !abstractC1174p1.isBound()) {
            return -1;
        }
        C1126b c1126b = this.mAdapterHelper;
        int i6 = abstractC1174p1.mPosition;
        ArrayList arrayList = c1126b.f3515b;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            C1122a c1122a = (C1122a) arrayList.get(i10);
            int i11 = c1122a.f3510a;
            if (i11 != 1) {
                if (i11 == 2) {
                    int i12 = c1122a.f3511b;
                    if (i12 <= i6) {
                        int i13 = c1122a.f3513d;
                        if (i12 + i13 > i6) {
                            return -1;
                        }
                        i6 -= i13;
                    } else {
                        continue;
                    }
                } else if (i11 == 8) {
                    int i14 = c1122a.f3511b;
                    if (i14 == i6) {
                        i6 = c1122a.f3513d;
                    } else {
                        if (i14 < i6) {
                            i6--;
                        }
                        if (c1122a.f3513d <= i6) {
                            i6++;
                        }
                    }
                }
            } else if (c1122a.f3511b <= i6) {
                i6 += c1122a.f3513d;
            }
        }
        return i6;
    }

    @Override
    public int getBaseline() {
        AbstractC1197x0 abstractC1197x0 = this.mLayout;
        return abstractC1197x0 != null ? abstractC1197x0.getBaseline() : super.getBaseline();
    }

    public long getChangedHolderKey(AbstractC1174p1 abstractC1174p1) {
        return this.mAdapter.hasStableIds() ? abstractC1174p1.getItemId() : abstractC1174p1.mPosition;
    }

    public int getChildAdapterPosition(View view) {
        AbstractC1174p1 childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getAbsoluteAdapterPosition();
        }
        return -1;
    }

    @Override
    public int getChildDrawingOrder(int i6, int i10) {
        return super.getChildDrawingOrder(i6, i10);
    }

    public long getChildItemId(View view) {
        AbstractC1174p1 childViewHolderInt;
        AbstractC1158k0 abstractC1158k0 = this.mAdapter;
        if (abstractC1158k0 == null || !abstractC1158k0.hasStableIds() || (childViewHolderInt = getChildViewHolderInt(view)) == null) {
            return -1L;
        }
        return childViewHolderInt.getItemId();
    }

    public int getChildLayoutPosition(View view) {
        AbstractC1174p1 childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getLayoutPosition();
        }
        return -1;
    }

    @Deprecated
    public int getChildPosition(View view) {
        return getChildAdapterPosition(view);
    }

    public AbstractC1174p1 getChildViewHolder(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return getChildViewHolderInt(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    @Override
    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    public C1180r1 getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        getDecoratedBoundsWithMarginsInt(view, rect);
    }

    public AbstractC1173p0 getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    public AbstractC1182s0 getItemAnimator() {
        return this.mItemAnimator;
    }

    public Rect getItemDecorInsetsForChild(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        boolean z7 = layoutParams.f3467c;
        Rect rect = layoutParams.f3466b;
        if (!z7) {
            return rect;
        }
        if (this.mState.f3621g && (layoutParams.f3465a.isUpdated() || layoutParams.f3465a.isInvalid())) {
            return rect;
        }
        rect.set(0, 0, 0, 0);
        int size = this.mItemDecorations.size();
        for (int i6 = 0; i6 < size; i6++) {
            this.mTempRect.set(0, 0, 0, 0);
            this.mItemDecorations.get(i6).getItemOffsets(this.mTempRect, view, this, this.mState);
            int i10 = rect.left;
            Rect rect2 = this.mTempRect;
            rect.left = i10 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        layoutParams.f3467c = false;
        return rect;
    }

    public AbstractC1185t0 getItemDecorationAt(int i6) {
        int itemDecorationCount = getItemDecorationCount();
        if (i6 >= 0 && i6 < itemDecorationCount) {
            return this.mItemDecorations.get(i6);
        }
        throw new IndexOutOfBoundsException(i6 + " is an invalid index for size " + itemDecorationCount);
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    public AbstractC1197x0 getLayoutManager() {
        return this.mLayout;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public long getNanoTime() {
        if (ALLOW_THREAD_GAP_WORK) {
            return System.nanoTime();
        }
        return 0L;
    }

    public AbstractC1203z0 getOnFlingListener() {
        return this.mOnFlingListener;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    public C1136d1 getRecycledViewPool() {
        return this.mRecycler.m2927c();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    @Override
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().m6285f(0);
    }

    public boolean hasPendingAdapterUpdates() {
        return !this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout || this.mAdapterHelper.m2877g();
    }

    public void initAdapterManager() {
        this.mAdapterHelper = new C1126b(new C1152i0(this));
    }

    public void initFastScroller(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            throw new IllegalArgumentException(AbstractC0004e.m22p(this, new StringBuilder("Trying to set fast scroller without both required drawables.")));
        }
        Resources resources = getContext().getResources();
        new C1172p(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(com.p2serv.android.p032ds.R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(com.p2serv.android.p032ds.R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(com.p2serv.android.p032ds.R.dimen.fastscroll_margin));
    }

    public void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() == 0) {
            return;
        }
        AbstractC1197x0 abstractC1197x0 = this.mLayout;
        if (abstractC1197x0 != null) {
            abstractC1197x0.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public boolean isAccessibilityEnabled() {
        AccessibilityManager accessibilityManager = this.mAccessibilityManager;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public boolean isAnimating() {
        AbstractC1182s0 abstractC1182s0 = this.mItemAnimator;
        return abstractC1182s0 != null && abstractC1182s0.mo2956f();
    }

    @Override
    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    public boolean isComputingLayout() {
        return this.mLayoutOrScrollCounter > 0;
    }

    @Deprecated
    public boolean isLayoutFrozen() {
        return isLayoutSuppressed();
    }

    @Override
    public final boolean isLayoutSuppressed() {
        return this.mLayoutSuppressed;
    }

    @Override
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().f10629d;
    }

    public void jumpToPositionForSmoothScroller(int i6) {
        if (this.mLayout == null) {
            return;
        }
        setScrollState(2);
        this.mLayout.scrollToPosition(i6);
        awakenScrollBars();
    }

    public void markItemDecorInsetsDirty() {
        int iM2916h = this.mChildHelper.m2916h();
        for (int i6 = 0; i6 < iM2916h; i6++) {
            ((LayoutParams) this.mChildHelper.m2915g(i6).getLayoutParams()).f3467c = true;
        }
        ArrayList arrayList = this.mRecycler.f3551c;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            LayoutParams layoutParams = (LayoutParams) ((AbstractC1174p1) arrayList.get(i10)).itemView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.f3467c = true;
            }
        }
    }

    public void markKnownViewsInvalid() {
        int iM2916h = this.mChildHelper.m2916h();
        for (int i6 = 0; i6 < iM2916h; i6++) {
            AbstractC1174p1 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2915g(i6));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.addFlags(6);
            }
        }
        markItemDecorInsetsDirty();
        C1140e1 c1140e1 = this.mRecycler;
        ArrayList arrayList = c1140e1.f3551c;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            AbstractC1174p1 abstractC1174p1 = (AbstractC1174p1) arrayList.get(i10);
            if (abstractC1174p1 != null) {
                abstractC1174p1.addFlags(6);
                abstractC1174p1.addChangePayload(null);
            }
        }
        AbstractC1158k0 abstractC1158k0 = c1140e1.f3556h.mAdapter;
        if (abstractC1158k0 == null || !abstractC1158k0.hasStableIds()) {
            c1140e1.m2930g();
        }
    }

    public void nestedScrollBy(int i6, int i10) {
        nestedScrollByInternal(i6, i10, null, 1);
    }

    public void offsetChildrenHorizontal(int i6) {
        int iM2913e = this.mChildHelper.m2913e();
        for (int i10 = 0; i10 < iM2913e; i10++) {
            this.mChildHelper.m2912d(i10).offsetLeftAndRight(i6);
        }
    }

    public void offsetChildrenVertical(int i6) {
        int iM2913e = this.mChildHelper.m2913e();
        for (int i10 = 0; i10 < iM2913e; i10++) {
            this.mChildHelper.m2912d(i10).offsetTopAndBottom(i6);
        }
    }

    public void offsetPositionRecordsForInsert(int i6, int i10) {
        int iM2916h = this.mChildHelper.m2916h();
        for (int i11 = 0; i11 < iM2916h; i11++) {
            AbstractC1174p1 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2915g(i11));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i6) {
                if (sVerboseLoggingEnabled) {
                    Log.d(TAG, "offsetPositionRecordsForInsert attached child " + i11 + " holder " + childViewHolderInt + " now at position " + (childViewHolderInt.mPosition + i10));
                }
                childViewHolderInt.offsetPosition(i10, false);
                this.mState.f3620f = true;
            }
        }
        ArrayList arrayList = this.mRecycler.f3551c;
        int size = arrayList.size();
        for (int i12 = 0; i12 < size; i12++) {
            AbstractC1174p1 abstractC1174p1 = (AbstractC1174p1) arrayList.get(i12);
            if (abstractC1174p1 != null && abstractC1174p1.mPosition >= i6) {
                if (sVerboseLoggingEnabled) {
                    Log.d(TAG, "offsetPositionRecordsForInsert cached " + i12 + " holder " + abstractC1174p1 + " now at position " + (abstractC1174p1.mPosition + i10));
                }
                abstractC1174p1.offsetPosition(i10, false);
            }
        }
        requestLayout();
    }

    public void offsetPositionRecordsForMove(int i6, int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int iM2916h = this.mChildHelper.m2916h();
        int i18 = -1;
        if (i6 < i10) {
            i12 = i6;
            i11 = i10;
            i13 = -1;
        } else {
            i11 = i6;
            i12 = i10;
            i13 = 1;
        }
        for (int i19 = 0; i19 < iM2916h; i19++) {
            AbstractC1174p1 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2915g(i19));
            if (childViewHolderInt != null && (i17 = childViewHolderInt.mPosition) >= i12 && i17 <= i11) {
                if (sVerboseLoggingEnabled) {
                    Log.d(TAG, "offsetPositionRecordsForMove attached child " + i19 + " holder " + childViewHolderInt);
                }
                if (childViewHolderInt.mPosition == i6) {
                    childViewHolderInt.offsetPosition(i10 - i6, false);
                } else {
                    childViewHolderInt.offsetPosition(i13, false);
                }
                this.mState.f3620f = true;
            }
        }
        C1140e1 c1140e1 = this.mRecycler;
        c1140e1.getClass();
        if (i6 < i10) {
            i15 = i6;
            i14 = i10;
        } else {
            i14 = i6;
            i15 = i10;
            i18 = 1;
        }
        ArrayList arrayList = c1140e1.f3551c;
        int size = arrayList.size();
        for (int i20 = 0; i20 < size; i20++) {
            AbstractC1174p1 abstractC1174p1 = (AbstractC1174p1) arrayList.get(i20);
            if (abstractC1174p1 != null && (i16 = abstractC1174p1.mPosition) >= i15 && i16 <= i14) {
                if (i16 == i6) {
                    abstractC1174p1.offsetPosition(i10 - i6, false);
                } else {
                    abstractC1174p1.offsetPosition(i18, false);
                }
                if (sVerboseLoggingEnabled) {
                    Log.d(TAG, "offsetPositionRecordsForMove cached child " + i20 + " holder " + abstractC1174p1);
                }
            }
        }
        requestLayout();
    }

    public void offsetPositionRecordsForRemove(int i6, int i10, boolean z7) {
        int i11 = i6 + i10;
        int iM2916h = this.mChildHelper.m2916h();
        for (int i12 = 0; i12 < iM2916h; i12++) {
            AbstractC1174p1 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2915g(i12));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                int i13 = childViewHolderInt.mPosition;
                if (i13 >= i11) {
                    if (sVerboseLoggingEnabled) {
                        Log.d(TAG, "offsetPositionRecordsForRemove attached child " + i12 + " holder " + childViewHolderInt + " now at position " + (childViewHolderInt.mPosition - i10));
                    }
                    childViewHolderInt.offsetPosition(-i10, z7);
                    this.mState.f3620f = true;
                } else if (i13 >= i6) {
                    if (sVerboseLoggingEnabled) {
                        Log.d(TAG, "offsetPositionRecordsForRemove attached child " + i12 + " holder " + childViewHolderInt + " now REMOVED");
                    }
                    childViewHolderInt.flagRemovedAndOffsetPosition(i6 - 1, -i10, z7);
                    this.mState.f3620f = true;
                }
            }
        }
        C1140e1 c1140e1 = this.mRecycler;
        ArrayList arrayList = c1140e1.f3551c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            AbstractC1174p1 abstractC1174p1 = (AbstractC1174p1) arrayList.get(size);
            if (abstractC1174p1 != null) {
                int i14 = abstractC1174p1.mPosition;
                if (i14 >= i11) {
                    if (sVerboseLoggingEnabled) {
                        Log.d(TAG, "offsetPositionRecordsForRemove cached " + size + " holder " + abstractC1174p1 + " now at position " + (abstractC1174p1.mPosition - i10));
                    }
                    abstractC1174p1.offsetPosition(-i10, z7);
                } else if (i14 >= i6) {
                    abstractC1174p1.addFlags(8);
                    c1140e1.m2931h(size);
                }
            }
        }
        requestLayout();
    }

    @Override
    public void onAttachedToWindow() {
        float refreshRate;
        super.onAttachedToWindow();
        this.mLayoutOrScrollCounter = 0;
        this.mIsAttached = true;
        this.mFirstLayoutComplete = this.mFirstLayoutComplete && !isLayoutRequested();
        this.mRecycler.m2928e();
        AbstractC1197x0 abstractC1197x0 = this.mLayout;
        if (abstractC1197x0 != null) {
            abstractC1197x0.dispatchAttachedToWindow(this);
        }
        this.mPostedAnimatorRunner = false;
        if (ALLOW_THREAD_GAP_WORK) {
            ThreadLocal threadLocal = RunnableC1184t.f3695e;
            RunnableC1184t runnableC1184t = (RunnableC1184t) threadLocal.get();
            this.mGapWorker = runnableC1184t;
            if (runnableC1184t == null) {
                this.mGapWorker = new RunnableC1184t();
                WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                Display display = getDisplay();
                if (isInEditMode() || display == null) {
                    refreshRate = 60.0f;
                } else {
                    refreshRate = display.getRefreshRate();
                    if (refreshRate < 30.0f) {
                        refreshRate = 60.0f;
                    }
                }
                RunnableC1184t runnableC1184t2 = this.mGapWorker;
                runnableC1184t2.f3699c = (long) (1.0E9f / refreshRate);
                threadLocal.set(runnableC1184t2);
            }
            RunnableC1184t runnableC1184t3 = this.mGapWorker;
            runnableC1184t3.getClass();
            boolean z7 = sDebugAssertionsEnabled;
            ArrayList arrayList = runnableC1184t3.f3697a;
            if (z7 && arrayList.contains(this)) {
                throw new IllegalStateException("RecyclerView already present in worker list!");
            }
            arrayList.add(this);
        }
    }

    @Override
    public void onDetachedFromWindow() {
        RunnableC1184t runnableC1184t;
        super.onDetachedFromWindow();
        AbstractC1182s0 abstractC1182s0 = this.mItemAnimator;
        if (abstractC1182s0 != null) {
            abstractC1182s0.mo2955e();
        }
        stopScroll();
        int i6 = 0;
        this.mIsAttached = false;
        AbstractC1197x0 abstractC1197x0 = this.mLayout;
        if (abstractC1197x0 != null) {
            abstractC1197x0.dispatchDetachedFromWindow(this, this.mRecycler);
        }
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.getClass();
        while (C1133c2.f3529d.mo6099a() != null) {
        }
        C1140e1 c1140e1 = this.mRecycler;
        int i10 = 0;
        while (true) {
            ArrayList arrayList = c1140e1.f3551c;
            if (i10 >= arrayList.size()) {
                break;
            }
            AbstractC2973a.m6015e(((AbstractC1174p1) arrayList.get(i10)).itemView);
            i10++;
        }
        c1140e1.m2929f(c1140e1.f3556h.mAdapter, false);
        while (i6 < getChildCount()) {
            int i11 = i6 + 1;
            View childAt = getChildAt(i6);
            if (childAt == null) {
                throw new IndexOutOfBoundsException();
            }
            C3888a c3888a = (C3888a) childAt.getTag(com.p2serv.android.p032ds.R.id.pooling_container_listener_holder_tag);
            if (c3888a == null) {
                c3888a = new C3888a();
                childAt.setTag(com.p2serv.android.p032ds.R.id.pooling_container_listener_holder_tag, c3888a);
            }
            ArrayList arrayList2 = c3888a.f13074a;
            int iM8191O = AbstractC4148k.m8191O(arrayList2);
            if (-1 < iM8191O) {
                throw AbstractC0004e.m17k(iM8191O, arrayList2);
            }
            i6 = i11;
        }
        if (!ALLOW_THREAD_GAP_WORK || (runnableC1184t = this.mGapWorker) == null) {
            return;
        }
        boolean zRemove = runnableC1184t.f3697a.remove(this);
        if (sDebugAssertionsEnabled && !zRemove) {
            throw new IllegalStateException("RecyclerView removal failed!");
        }
        this.mGapWorker = null;
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.mItemDecorations.size();
        for (int i6 = 0; i6 < size; i6++) {
            this.mItemDecorations.get(i6).onDraw(canvas, this, this.mState);
        }
    }

    public void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    public void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    @Override
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        int i6;
        float axisValue;
        boolean z7;
        if (this.mLayout != null && !this.mLayoutSuppressed && motionEvent.getAction() == 8) {
            float f = 0.0f;
            if ((motionEvent.getSource() & 2) != 0) {
                float f3 = this.mLayout.canScrollVertically() ? -motionEvent.getAxisValue(9) : 0.0f;
                if (this.mLayout.canScrollHorizontally()) {
                    axisValue = motionEvent.getAxisValue(10);
                    z7 = false;
                    f = f3;
                    i6 = 0;
                } else {
                    f = f3;
                    i6 = 0;
                    axisValue = 0.0f;
                    z7 = false;
                }
            } else if ((motionEvent.getSource() & 4194304) != 0) {
                i6 = 26;
                axisValue = motionEvent.getAxisValue(26);
                if (this.mLayout.canScrollVertically()) {
                    f = -axisValue;
                } else {
                    if (!this.mLayout.canScrollHorizontally()) {
                    }
                    z7 = this.mLowResRotaryEncoderFeature;
                }
                axisValue = 0.0f;
                z7 = this.mLowResRotaryEncoderFeature;
            } else {
                i6 = 0;
                axisValue = 0.0f;
                z7 = false;
            }
            int i10 = (int) (f * this.mScaledVerticalScrollFactor);
            int i11 = (int) (axisValue * this.mScaledHorizontalScrollFactor);
            if (z7) {
                OverScroller overScroller = this.mViewFlinger.f3637c;
                smoothScrollBy((overScroller.getFinalX() - overScroller.getCurrX()) + i11, (overScroller.getFinalY() - overScroller.getCurrY()) + i10, null, Integer.MIN_VALUE, true);
            } else {
                nestedScrollByInternal(i11, i10, motionEvent, 1);
            }
            if (i6 != 0 && !z7) {
                this.mDifferentialMotionFlingController.m6188a(motionEvent, i6);
            }
        }
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z7;
        if (this.mLayoutSuppressed) {
            return false;
        }
        this.mInterceptingOnItemTouchListener = null;
        if (findInterceptingOnItemTouchListener(motionEvent)) {
            cancelScroll();
            return true;
        }
        AbstractC1197x0 abstractC1197x0 = this.mLayout;
        if (abstractC1197x0 == null) {
            return false;
        }
        boolean zCanScrollHorizontally = abstractC1197x0.canScrollHorizontally();
        boolean zCanScrollVertically = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.mIgnoreMotionEventTillDown) {
                this.mIgnoreMotionEventTillDown = false;
            }
            this.mScrollPointerId = motionEvent.getPointerId(0);
            int x10 = (int) (motionEvent.getX() + 0.5f);
            this.mLastTouchX = x10;
            this.mInitialTouchX = x10;
            int y7 = (int) (motionEvent.getY() + 0.5f);
            this.mLastTouchY = y7;
            this.mInitialTouchY = y7;
            if (stopGlowAnimations(motionEvent) || this.mScrollState == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                stopNestedScroll(1);
            }
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
            startNestedScrollForType(0);
        } else if (actionMasked == 1) {
            this.mVelocityTracker.clear();
            stopNestedScroll(0);
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
            if (iFindPointerIndex < 0) {
                Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x11 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y9 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            if (this.mScrollState != 1) {
                int i6 = x11 - this.mInitialTouchX;
                int i10 = y9 - this.mInitialTouchY;
                if (!zCanScrollHorizontally || Math.abs(i6) <= this.mTouchSlop) {
                    z7 = false;
                } else {
                    this.mLastTouchX = x11;
                    z7 = true;
                }
                if (zCanScrollVertically && Math.abs(i10) > this.mTouchSlop) {
                    this.mLastTouchY = y9;
                    z7 = true;
                }
                if (z7) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            cancelScroll();
        } else if (actionMasked == 5) {
            this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
            int x12 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.mLastTouchX = x12;
            this.mInitialTouchX = x12;
            int y10 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.mLastTouchY = y10;
            this.mInitialTouchY = y10;
        } else if (actionMasked == 6) {
            onPointerUp(motionEvent);
        }
        return this.mScrollState == 1;
    }

    @Override
    public void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        Trace.beginSection(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        Trace.endSection();
        this.mFirstLayoutComplete = true;
    }

    @Override
    public void onMeasure(int i6, int i10) {
        AbstractC1197x0 abstractC1197x0 = this.mLayout;
        if (abstractC1197x0 == null) {
            defaultOnMeasure(i6, i10);
            return;
        }
        boolean z7 = false;
        if (abstractC1197x0.isAutoMeasureEnabled()) {
            int mode = View.MeasureSpec.getMode(i6);
            int mode2 = View.MeasureSpec.getMode(i10);
            this.mLayout.onMeasure(this.mRecycler, this.mState, i6, i10);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z7 = true;
            }
            this.mLastAutoMeasureSkippedDueToExact = z7;
            if (z7 || this.mAdapter == null) {
                return;
            }
            if (this.mState.f3618d == 1) {
                dispatchLayoutStep1();
            }
            this.mLayout.setMeasureSpecs(i6, i10);
            this.mState.f3623i = true;
            dispatchLayoutStep2();
            this.mLayout.setMeasuredDimensionFromChildren(i6, i10);
            if (this.mLayout.shouldMeasureTwice()) {
                this.mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.mState.f3623i = true;
                dispatchLayoutStep2();
                this.mLayout.setMeasuredDimensionFromChildren(i6, i10);
            }
            this.mLastAutoMeasureNonExactMeasuredWidth = getMeasuredWidth();
            this.mLastAutoMeasureNonExactMeasuredHeight = getMeasuredHeight();
            return;
        }
        if (this.mHasFixedSize) {
            this.mLayout.onMeasure(this.mRecycler, this.mState, i6, i10);
            return;
        }
        if (this.mAdapterUpdateDuringMeasure) {
            startInterceptRequestLayout();
            onEnterLayoutOrScroll();
            processAdapterUpdatesAndSetAnimationFlags();
            onExitLayoutOrScroll();
            C1162l1 c1162l1 = this.mState;
            if (c1162l1.f3625k) {
                c1162l1.f3621g = true;
            } else {
                this.mAdapterHelper.m2873c();
                this.mState.f3621g = false;
            }
            this.mAdapterUpdateDuringMeasure = false;
            stopInterceptRequestLayout(false);
        } else if (this.mState.f3625k) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        AbstractC1158k0 abstractC1158k0 = this.mAdapter;
        if (abstractC1158k0 != null) {
            this.mState.f3619e = abstractC1158k0.getItemCount();
        } else {
            this.mState.f3619e = 0;
        }
        startInterceptRequestLayout();
        this.mLayout.onMeasure(this.mRecycler, this.mState, i6, i10);
        stopInterceptRequestLayout(false);
        this.mState.f3621g = false;
    }

    @Override
    public boolean onRequestFocusInDescendants(int i6, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i6, rect);
    }

    @Override
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.mPendingSavedState = savedState;
        super.onRestoreInstanceState(savedState.f1689a);
        requestLayout();
    }

    @Override
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.mPendingSavedState;
        if (savedState2 != null) {
            savedState.f3469c = savedState2.f3469c;
        } else {
            AbstractC1197x0 abstractC1197x0 = this.mLayout;
            if (abstractC1197x0 != null) {
                savedState.f3469c = abstractC1197x0.onSaveInstanceState();
            } else {
                savedState.f3469c = null;
            }
        }
        return savedState;
    }

    @Override
    public void onSizeChanged(int i6, int i10, int i11, int i12) {
        super.onSizeChanged(i6, i10, i11, i12);
        if (i6 == i11 && i10 == i12) {
            return;
        }
        invalidateGlows();
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z7;
        if (this.mLayoutSuppressed || this.mIgnoreMotionEventTillDown) {
            return false;
        }
        if (dispatchToOnItemTouchListeners(motionEvent)) {
            cancelScroll();
            return true;
        }
        AbstractC1197x0 abstractC1197x0 = this.mLayout;
        if (abstractC1197x0 == null) {
            return false;
        }
        boolean zCanScrollHorizontally = abstractC1197x0.canScrollHorizontally();
        boolean zCanScrollVertically = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        int[] iArr2 = this.mNestedOffsets;
        motionEventObtain.offsetLocation(iArr2[0], iArr2[1]);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                this.mVelocityTracker.addMovement(motionEventObtain);
                this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxFlingVelocity);
                float f = zCanScrollHorizontally ? -this.mVelocityTracker.getXVelocity(this.mScrollPointerId) : 0.0f;
                float f3 = zCanScrollVertically ? -this.mVelocityTracker.getYVelocity(this.mScrollPointerId) : 0.0f;
                if ((f == 0.0f && f3 == 0.0f) || !fling((int) f, (int) f3)) {
                    setScrollState(0);
                }
                resetScroll();
            } else if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
                if (iFindPointerIndex < 0) {
                    Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                    return false;
                }
                int x10 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
                int y7 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
                int iMax = this.mLastTouchX - x10;
                int iMax2 = this.mLastTouchY - y7;
                if (this.mScrollState != 1) {
                    if (zCanScrollHorizontally) {
                        iMax = iMax > 0 ? Math.max(0, iMax - this.mTouchSlop) : Math.min(0, iMax + this.mTouchSlop);
                        if (iMax != 0) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                    } else {
                        z7 = false;
                    }
                    if (zCanScrollVertically) {
                        iMax2 = iMax2 > 0 ? Math.max(0, iMax2 - this.mTouchSlop) : Math.min(0, iMax2 + this.mTouchSlop);
                        if (iMax2 != 0) {
                            z7 = true;
                        }
                    }
                    if (z7) {
                        setScrollState(1);
                    }
                }
                if (this.mScrollState == 1) {
                    int[] iArr3 = this.mReusableIntPair;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    int iReleaseHorizontalGlow = iMax - releaseHorizontalGlow(iMax, motionEvent.getY());
                    int iReleaseVerticalGlow = iMax2 - releaseVerticalGlow(iMax2, motionEvent.getX());
                    if (dispatchNestedPreScroll(zCanScrollHorizontally ? iReleaseHorizontalGlow : 0, zCanScrollVertically ? iReleaseVerticalGlow : 0, this.mReusableIntPair, this.mScrollOffset, 0)) {
                        int[] iArr4 = this.mReusableIntPair;
                        iReleaseHorizontalGlow -= iArr4[0];
                        iReleaseVerticalGlow -= iArr4[1];
                        int[] iArr5 = this.mNestedOffsets;
                        int i6 = iArr5[0];
                        int[] iArr6 = this.mScrollOffset;
                        iArr5[0] = i6 + iArr6[0];
                        iArr5[1] = iArr5[1] + iArr6[1];
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    int i10 = iReleaseVerticalGlow;
                    int[] iArr7 = this.mScrollOffset;
                    this.mLastTouchX = x10 - iArr7[0];
                    this.mLastTouchY = y7 - iArr7[1];
                    if (scrollByInternal(zCanScrollHorizontally ? iReleaseHorizontalGlow : 0, zCanScrollVertically ? i10 : 0, motionEvent, 0)) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    RunnableC1184t runnableC1184t = this.mGapWorker;
                    if (runnableC1184t != null && (iReleaseHorizontalGlow != 0 || i10 != 0)) {
                        runnableC1184t.m2992a(this, iReleaseHorizontalGlow, i10);
                    }
                }
            } else if (actionMasked == 3) {
                cancelScroll();
            } else if (actionMasked == 5) {
                this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
                int x11 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                this.mLastTouchX = x11;
                this.mInitialTouchX = x11;
                int y9 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                this.mLastTouchY = y9;
                this.mInitialTouchY = y9;
            } else if (actionMasked == 6) {
                onPointerUp(motionEvent);
            }
            motionEventObtain.recycle();
            return true;
        }
        this.mScrollPointerId = motionEvent.getPointerId(0);
        int x12 = (int) (motionEvent.getX() + 0.5f);
        this.mLastTouchX = x12;
        this.mInitialTouchX = x12;
        int y10 = (int) (motionEvent.getY() + 0.5f);
        this.mLastTouchY = y10;
        this.mInitialTouchY = y10;
        startNestedScrollForType(0);
        this.mVelocityTracker.addMovement(motionEventObtain);
        motionEventObtain.recycle();
        return true;
    }

    public void postAnimationRunner() {
        if (this.mPostedAnimatorRunner || !this.mIsAttached) {
            return;
        }
        Runnable runnable = this.mItemAnimatorRunner;
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        postOnAnimation(runnable);
        this.mPostedAnimatorRunner = true;
    }

    public void processDataSetCompletelyChanged(boolean z7) {
        this.mDispatchItemsChangedEvent = z7 | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    public void recordAnimationInfoIfBouncedHiddenView(AbstractC1174p1 abstractC1174p1, C1179r0 c1179r0) {
        abstractC1174p1.setFlags(0, 8192);
        if (this.mState.f3622h && abstractC1174p1.isUpdated() && !abstractC1174p1.isRemoved() && !abstractC1174p1.shouldIgnore()) {
            this.mViewInfoStore.f3558b.m6801h(getChangedHolderKey(abstractC1174p1), abstractC1174p1);
        }
        C3347k c3347k = this.mViewInfoStore.f3557a;
        C1133c2 c1133c2M2908a = (C1133c2) c3347k.get(abstractC1174p1);
        if (c1133c2M2908a == null) {
            c1133c2M2908a = C1133c2.m2908a();
            c3347k.put(abstractC1174p1, c1133c2M2908a);
        }
        c1133c2M2908a.f3531b = c1179r0;
        c1133c2M2908a.f3530a |= 4;
    }

    public void removeAndRecycleViews() {
        AbstractC1182s0 abstractC1182s0 = this.mItemAnimator;
        if (abstractC1182s0 != null) {
            abstractC1182s0.mo2955e();
        }
        AbstractC1197x0 abstractC1197x0 = this.mLayout;
        if (abstractC1197x0 != null) {
            abstractC1197x0.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        }
        C1140e1 c1140e1 = this.mRecycler;
        c1140e1.f3549a.clear();
        c1140e1.m2930g();
    }

    public boolean removeAnimatingView(View view) {
        startInterceptRequestLayout();
        C1134d c1134d = this.mChildHelper;
        C1130c c1130c = c1134d.f3534b;
        C1152i0 c1152i0 = c1134d.f3533a;
        int i6 = c1134d.f3536d;
        boolean z7 = true;
        if (i6 != 1) {
            if (i6 == 2) {
                throw new IllegalStateException("Cannot call removeViewIfHidden within removeViewIfHidden");
            }
            try {
                c1134d.f3536d = 2;
                int iIndexOfChild = ((RecyclerView) c1152i0.f3584a).indexOfChild(view);
                if (iIndexOfChild == -1) {
                    c1134d.m2920l(view);
                } else if (c1130c.m2903e(iIndexOfChild)) {
                    c1130c.m2905g(iIndexOfChild);
                    c1134d.m2920l(view);
                    c1152i0.m2949c(iIndexOfChild);
                } else {
                    c1134d.f3536d = 0;
                }
                c1134d.f3536d = 0;
                if (z7) {
                    AbstractC1174p1 childViewHolderInt = getChildViewHolderInt(view);
                    this.mRecycler.m2936m(childViewHolderInt);
                    this.mRecycler.m2933j(childViewHolderInt);
                    if (sVerboseLoggingEnabled) {
                        Log.d(TAG, "after removing animated view: " + view + ", " + this);
                    }
                }
                stopInterceptRequestLayout(!z7);
                return z7;
            } catch (Throwable th) {
                c1134d.f3536d = 0;
                throw th;
            }
        }
        if (c1134d.f3537e != view) {
            throw new IllegalStateException("Cannot call removeViewIfHidden within removeView(At) for a different view");
        }
        z7 = false;
        if (z7) {
            AbstractC1174p1 childViewHolderInt2 = getChildViewHolderInt(view);
            this.mRecycler.m2936m(childViewHolderInt2);
            this.mRecycler.m2933j(childViewHolderInt2);
            if (sVerboseLoggingEnabled) {
                Log.d(TAG, "after removing animated view: " + view + ", " + this);
            }
        }
        stopInterceptRequestLayout(!z7);
        return z7;
    }

    @Override
    public void removeDetachedView(View view, boolean z7) {
        AbstractC1174p1 childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached()) {
                childViewHolderInt.clearTmpDetachFlag();
            } else if (!childViewHolderInt.shouldIgnore()) {
                StringBuilder sb = new StringBuilder("Called removeDetachedView with a view which is not flagged as tmp detached.");
                sb.append(childViewHolderInt);
                throw new IllegalArgumentException(AbstractC0004e.m22p(this, sb));
            }
        } else if (sDebugAssertionsEnabled) {
            StringBuilder sb2 = new StringBuilder("No ViewHolder found for child: ");
            sb2.append(view);
            throw new IllegalArgumentException(AbstractC0004e.m22p(this, sb2));
        }
        view.clearAnimation();
        dispatchChildDetached(view);
        super.removeDetachedView(view, z7);
    }

    public void removeItemDecoration(AbstractC1185t0 abstractC1185t0) {
        AbstractC1197x0 abstractC1197x0 = this.mLayout;
        if (abstractC1197x0 != null) {
            abstractC1197x0.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        this.mItemDecorations.remove(abstractC1185t0);
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void removeItemDecorationAt(int i6) {
        int itemDecorationCount = getItemDecorationCount();
        if (i6 >= 0 && i6 < itemDecorationCount) {
            removeItemDecoration(getItemDecorationAt(i6));
            return;
        }
        throw new IndexOutOfBoundsException(i6 + " is an invalid index for size " + itemDecorationCount);
    }

    public void removeOnChildAttachStateChangeListener(InterfaceC1200y0 interfaceC1200y0) {
        List<InterfaceC1200y0> list = this.mOnChildAttachStateListeners;
        if (list == null) {
            return;
        }
        list.remove(interfaceC1200y0);
    }

    public void removeOnItemTouchListener(InterfaceC1124a1 interfaceC1124a1) {
        this.mOnItemTouchListeners.remove(interfaceC1124a1);
        if (this.mInterceptingOnItemTouchListener == interfaceC1124a1) {
            this.mInterceptingOnItemTouchListener = null;
        }
    }

    public void removeOnScrollListener(AbstractC1128b1 abstractC1128b1) {
        List<AbstractC1128b1> list = this.mScrollListeners;
        if (list != null) {
            list.remove(abstractC1128b1);
        }
    }

    public void removeRecyclerListener(InterfaceC1144f1 interfaceC1144f1) {
        this.mRecyclerListeners.remove(interfaceC1144f1);
    }

    public void repositionShadowingViews() {
        AbstractC1174p1 abstractC1174p1;
        int iM2913e = this.mChildHelper.m2913e();
        for (int i6 = 0; i6 < iM2913e; i6++) {
            View viewM2912d = this.mChildHelper.m2912d(i6);
            AbstractC1174p1 childViewHolder = getChildViewHolder(viewM2912d);
            if (childViewHolder != null && (abstractC1174p1 = childViewHolder.mShadowingHolder) != null) {
                View view = abstractC1174p1.itemView;
                int left = viewM2912d.getLeft();
                int top = viewM2912d.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    @Override
    public void requestChildFocus(View view, View view2) {
        if (!this.mLayout.onRequestChildFocus(this, this.mState, view, view2) && view2 != null) {
            requestChildOnScreen(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z7) {
        return this.mLayout.requestChildRectangleOnScreen(this, view, rect, z7);
    }

    @Override
    public void requestDisallowInterceptTouchEvent(boolean z7) {
        int size = this.mOnItemTouchListeners.size();
        for (int i6 = 0; i6 < size; i6++) {
            this.mOnItemTouchListeners.get(i6).getClass();
        }
        super.requestDisallowInterceptTouchEvent(z7);
    }

    @Override
    public void requestLayout() {
        if (this.mInterceptRequestLayoutDepth != 0 || this.mLayoutSuppressed) {
            this.mLayoutWasDefered = true;
        } else {
            super.requestLayout();
        }
    }

    public void saveOldPositions() {
        int iM2916h = this.mChildHelper.m2916h();
        for (int i6 = 0; i6 < iM2916h; i6++) {
            AbstractC1174p1 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2915g(i6));
            if (sDebugAssertionsEnabled && childViewHolderInt.mPosition == -1 && !childViewHolderInt.isRemoved()) {
                throw new IllegalStateException(AbstractC0004e.m22p(this, new StringBuilder("view holder cannot have position -1 unless it is removed")));
            }
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.saveOldPosition();
            }
        }
    }

    @Override
    public void scrollBy(int i6, int i10) {
        AbstractC1197x0 abstractC1197x0 = this.mLayout;
        if (abstractC1197x0 == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        boolean zCanScrollHorizontally = abstractC1197x0.canScrollHorizontally();
        boolean zCanScrollVertically = this.mLayout.canScrollVertically();
        if (zCanScrollHorizontally || zCanScrollVertically) {
            if (!zCanScrollHorizontally) {
                i6 = 0;
            }
            if (!zCanScrollVertically) {
                i10 = 0;
            }
            scrollByInternal(i6, i10, null, 0);
        }
    }

    public boolean scrollByInternal(int i6, int i10, MotionEvent motionEvent, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        consumePendingUpdateOperations();
        if (this.mAdapter != null) {
            int[] iArr = this.mReusableIntPair;
            iArr[0] = 0;
            iArr[1] = 0;
            scrollStep(i6, i10, iArr);
            int[] iArr2 = this.mReusableIntPair;
            int i16 = iArr2[0];
            int i17 = iArr2[1];
            i12 = i17;
            i13 = i16;
            i14 = i6 - i16;
            i15 = i10 - i17;
        } else {
            i12 = 0;
            i13 = 0;
            i14 = 0;
            i15 = 0;
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.mReusableIntPair;
        iArr3[0] = 0;
        iArr3[1] = 0;
        dispatchNestedScroll(i13, i12, i14, i15, this.mScrollOffset, i11, iArr3);
        int[] iArr4 = this.mReusableIntPair;
        int i18 = iArr4[0];
        int i19 = i14 - i18;
        int i20 = iArr4[1];
        int i21 = i15 - i20;
        boolean z7 = (i18 == 0 && i20 == 0) ? false : true;
        int i22 = this.mLastTouchX;
        int[] iArr5 = this.mScrollOffset;
        int i23 = iArr5[0];
        this.mLastTouchX = i22 - i23;
        int i24 = this.mLastTouchY;
        int i25 = iArr5[1];
        this.mLastTouchY = i24 - i25;
        int[] iArr6 = this.mNestedOffsets;
        iArr6[0] = iArr6[0] + i23;
        iArr6[1] = iArr6[1] + i25;
        if (getOverScrollMode() != 2) {
            if (motionEvent != null && !AbstractC3198d.m6477z(motionEvent, 8194)) {
                pullGlows(motionEvent.getX(), i19, motionEvent.getY(), i21);
                if (Build.VERSION.SDK_INT >= 31 && AbstractC3198d.m6477z(motionEvent, 4194304)) {
                    releaseGlows();
                }
            }
            considerReleasingGlowsOnScroll(i6, i10);
        }
        if (i13 != 0 || i12 != 0) {
            dispatchOnScrolled(i13, i12);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z7 && i13 == 0 && i12 == 0) ? false : true;
    }

    public void scrollStep(int i6, int i10, int[] iArr) {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        Trace.beginSection(TRACE_SCROLL_TAG);
        fillRemainingScrollValues(this.mState);
        int iScrollHorizontallyBy = i6 != 0 ? this.mLayout.scrollHorizontallyBy(i6, this.mRecycler, this.mState) : 0;
        int iScrollVerticallyBy = i10 != 0 ? this.mLayout.scrollVerticallyBy(i10, this.mRecycler, this.mState) : 0;
        Trace.endSection();
        repositionShadowingViews();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        if (iArr != null) {
            iArr[0] = iScrollHorizontallyBy;
            iArr[1] = iScrollVerticallyBy;
        }
    }

    @Override
    public void scrollTo(int i6, int i10) {
        Log.w(TAG, "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollToPosition(int i6) {
        if (this.mLayoutSuppressed) {
            return;
        }
        stopScroll();
        AbstractC1197x0 abstractC1197x0 = this.mLayout;
        if (abstractC1197x0 == null) {
            Log.e(TAG, "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            abstractC1197x0.scrollToPosition(i6);
            awakenScrollBars();
        }
    }

    @Override
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (shouldDeferAccessibilityEvent(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(C1180r1 c1180r1) {
        this.mAccessibilityDelegate = c1180r1;
        AbstractC3155s0.m6347q(this, c1180r1);
    }

    public void setAdapter(AbstractC1158k0 abstractC1158k0) {
        setLayoutFrozen(false);
        setAdapterInternal(abstractC1158k0, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(InterfaceC1170o0 interfaceC1170o0) {
        if (interfaceC1170o0 == null) {
            return;
        }
        setChildrenDrawingOrderEnabled(false);
    }

    public boolean setChildImportantForAccessibilityInternal(AbstractC1174p1 abstractC1174p1, int i6) {
        if (!isComputingLayout()) {
            abstractC1174p1.itemView.setImportantForAccessibility(i6);
            return true;
        }
        abstractC1174p1.mPendingAccessibilityState = i6;
        this.mPendingAccessibilityImportanceChange.add(abstractC1174p1);
        return false;
    }

    @Override
    public void setClipToPadding(boolean z7) {
        if (z7 != this.mClipToPadding) {
            invalidateGlows();
        }
        this.mClipToPadding = z7;
        super.setClipToPadding(z7);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(AbstractC1173p0 abstractC1173p0) {
        abstractC1173p0.getClass();
        this.mEdgeEffectFactory = abstractC1173p0;
        invalidateGlows();
    }

    public void setHasFixedSize(boolean z7) {
        this.mHasFixedSize = z7;
    }

    public void setItemAnimator(AbstractC1182s0 abstractC1182s0) {
        AbstractC1182s0 abstractC1182s1 = this.mItemAnimator;
        if (abstractC1182s1 != null) {
            abstractC1182s1.mo2955e();
            this.mItemAnimator.f3687a = null;
        }
        this.mItemAnimator = abstractC1182s0;
        if (abstractC1182s0 != null) {
            abstractC1182s0.f3687a = this.mItemAnimatorListener;
        }
    }

    public void setItemViewCacheSize(int i6) {
        C1140e1 c1140e1 = this.mRecycler;
        c1140e1.f3553e = i6;
        c1140e1.m2937n();
    }

    @Deprecated
    public void setLayoutFrozen(boolean z7) {
        suppressLayout(z7);
    }

    public void setLayoutManager(AbstractC1197x0 abstractC1197x0) {
        RecyclerView recyclerView;
        if (abstractC1197x0 == this.mLayout) {
            return;
        }
        stopScroll();
        if (this.mLayout != null) {
            AbstractC1182s0 abstractC1182s0 = this.mItemAnimator;
            if (abstractC1182s0 != null) {
                abstractC1182s0.mo2955e();
            }
            this.mLayout.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
            C1140e1 c1140e1 = this.mRecycler;
            c1140e1.f3549a.clear();
            c1140e1.m2930g();
            if (this.mIsAttached) {
                this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
            }
            this.mLayout.setRecyclerView(null);
            this.mLayout = null;
        } else {
            C1140e1 c1140e2 = this.mRecycler;
            c1140e2.f3549a.clear();
            c1140e2.m2930g();
        }
        C1134d c1134d = this.mChildHelper;
        c1134d.f3534b.m2906h();
        ArrayList arrayList = c1134d.f3535c;
        int size = arrayList.size();
        while (true) {
            size--;
            recyclerView = (RecyclerView) c1134d.f3533a.f3584a;
            if (size < 0) {
                break;
            }
            AbstractC1174p1 childViewHolderInt = getChildViewHolderInt((View) arrayList.get(size));
            if (childViewHolderInt != null) {
                childViewHolderInt.onLeftHiddenState(recyclerView);
            }
            arrayList.remove(size);
        }
        int childCount = recyclerView.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = recyclerView.getChildAt(i6);
            recyclerView.dispatchChildDetached(childAt);
            childAt.clearAnimation();
        }
        recyclerView.removeAllViews();
        this.mLayout = abstractC1197x0;
        if (abstractC1197x0 != null) {
            if (abstractC1197x0.mRecyclerView != null) {
                StringBuilder sb = new StringBuilder("LayoutManager ");
                sb.append(abstractC1197x0);
                sb.append(" is already attached to a RecyclerView:");
                throw new IllegalArgumentException(AbstractC0004e.m22p(abstractC1197x0.mRecyclerView, sb));
            }
            abstractC1197x0.setRecyclerView(this);
            if (this.mIsAttached) {
                this.mLayout.dispatchAttachedToWindow(this);
            }
        }
        this.mRecycler.m2937n();
        requestLayout();
    }

    @Override
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override
    public void setNestedScrollingEnabled(boolean z7) {
        C3142o scrollingChildHelper = getScrollingChildHelper();
        if (scrollingChildHelper.f10629d) {
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            AbstractC3119g0.m6187z(scrollingChildHelper.f10628c);
        }
        scrollingChildHelper.f10629d = z7;
    }

    public void setOnFlingListener(AbstractC1203z0 abstractC1203z0) {
        this.mOnFlingListener = abstractC1203z0;
    }

    @Deprecated
    public void setOnScrollListener(AbstractC1128b1 abstractC1128b1) {
        this.mScrollListener = abstractC1128b1;
    }

    public void setPreserveFocusAfterLayout(boolean z7) {
        this.mPreserveFocusAfterLayout = z7;
    }

    public void setRecycledViewPool(C1136d1 c1136d1) {
        C1140e1 c1140e1 = this.mRecycler;
        RecyclerView recyclerView = c1140e1.f3556h;
        c1140e1.m2929f(recyclerView.mAdapter, false);
        C1136d1 c1136d2 = c1140e1.f3555g;
        if (c1136d2 != null) {
            c1136d2.f3542b--;
        }
        c1140e1.f3555g = c1136d1;
        if (c1136d1 != null && recyclerView.getAdapter() != null) {
            c1140e1.f3555g.f3542b++;
        }
        c1140e1.m2928e();
    }

    @Deprecated
    public void setRecyclerListener(InterfaceC1144f1 interfaceC1144f1) {
        this.mRecyclerListener = interfaceC1144f1;
    }

    public void setScrollState(int i6) {
        if (i6 == this.mScrollState) {
            return;
        }
        if (sVerboseLoggingEnabled) {
            StringBuilder sbM27u = AbstractC0004e.m27u(i6, "setting scroll state to ", " from ");
            sbM27u.append(this.mScrollState);
            Log.d(TAG, sbM27u.toString(), new Exception());
        }
        this.mScrollState = i6;
        if (i6 != 2) {
            stopScrollersInternal();
        }
        dispatchOnScrollStateChanged(i6);
    }

    public void setScrollingTouchSlop(int i6) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i6 != 0) {
            if (i6 == 1) {
                this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
            Log.w(TAG, "setScrollingTouchSlop(): bad argument constant " + i6 + "; using default value");
        }
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(AbstractC1168n1 abstractC1168n1) {
        this.mRecycler.getClass();
    }

    public boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (!isComputingLayout()) {
            return false;
        }
        int contentChangeTypes = accessibilityEvent != null ? accessibilityEvent.getContentChangeTypes() : 0;
        this.mEatenAccessibilityChangeFlags |= contentChangeTypes != 0 ? contentChangeTypes : 0;
        return true;
    }

    public void smoothScrollBy(int i6, int i10) {
        smoothScrollBy(i6, i10, null);
    }

    public void smoothScrollToPosition(int i6) {
        if (this.mLayoutSuppressed) {
            return;
        }
        AbstractC1197x0 abstractC1197x0 = this.mLayout;
        if (abstractC1197x0 == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            abstractC1197x0.smoothScrollToPosition(this, this.mState, i6);
        }
    }

    public void startInterceptRequestLayout() {
        int i6 = this.mInterceptRequestLayoutDepth + 1;
        this.mInterceptRequestLayoutDepth = i6;
        if (i6 != 1 || this.mLayoutSuppressed) {
            return;
        }
        this.mLayoutWasDefered = false;
    }

    @Override
    public boolean startNestedScroll(int i6) {
        return getScrollingChildHelper().m6286g(i6, 0);
    }

    public void stopInterceptRequestLayout(boolean z7) {
        if (this.mInterceptRequestLayoutDepth < 1) {
            if (sDebugAssertionsEnabled) {
                throw new IllegalStateException(AbstractC0004e.m22p(this, new StringBuilder("stopInterceptRequestLayout was called more times than startInterceptRequestLayout.")));
            }
            this.mInterceptRequestLayoutDepth = 1;
        }
        if (!z7 && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
        if (this.mInterceptRequestLayoutDepth == 1) {
            if (z7 && this.mLayoutWasDefered && !this.mLayoutSuppressed && this.mLayout != null && this.mAdapter != null) {
                dispatchLayout();
            }
            if (!this.mLayoutSuppressed) {
                this.mLayoutWasDefered = false;
            }
        }
        this.mInterceptRequestLayoutDepth--;
    }

    @Override
    public void stopNestedScroll() {
        getScrollingChildHelper().m6287h(0);
    }

    public void stopScroll() {
        setScrollState(0);
        stopScrollersInternal();
    }

    @Override
    public final void suppressLayout(boolean z7) {
        if (z7 != this.mLayoutSuppressed) {
            assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
            if (z7) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
                this.mLayoutSuppressed = true;
                this.mIgnoreMotionEventTillDown = true;
                stopScroll();
                return;
            }
            this.mLayoutSuppressed = false;
            if (this.mLayoutWasDefered && this.mLayout != null && this.mAdapter != null) {
                requestLayout();
            }
            this.mLayoutWasDefered = false;
        }
    }

    public void swapAdapter(AbstractC1158k0 abstractC1158k0, boolean z7) {
        setLayoutFrozen(false);
        setAdapterInternal(abstractC1158k0, true, z7);
        processDataSetCompletelyChanged(true);
        requestLayout();
    }

    public void viewRangeUpdate(int i6, int i10, Object obj) {
        int i11;
        int i12;
        int iM2916h = this.mChildHelper.m2916h();
        int i13 = i10 + i6;
        for (int i14 = 0; i14 < iM2916h; i14++) {
            View viewM2915g = this.mChildHelper.m2915g(i14);
            AbstractC1174p1 childViewHolderInt = getChildViewHolderInt(viewM2915g);
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && (i12 = childViewHolderInt.mPosition) >= i6 && i12 < i13) {
                childViewHolderInt.addFlags(2);
                childViewHolderInt.addChangePayload(obj);
                ((LayoutParams) viewM2915g.getLayoutParams()).f3467c = true;
            }
        }
        C1140e1 c1140e1 = this.mRecycler;
        ArrayList arrayList = c1140e1.f3551c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            AbstractC1174p1 abstractC1174p1 = (AbstractC1174p1) arrayList.get(size);
            if (abstractC1174p1 != null && (i11 = abstractC1174p1.mPosition) >= i6 && i11 < i13) {
                abstractC1174p1.addFlags(2);
                c1140e1.m2931h(size);
            }
        }
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.p2serv.android.p032ds.R.attr.recyclerViewStyle);
    }

    private boolean fling(int i6, int i10, int i11, int i12) {
        int iMax;
        int i13;
        AbstractC1197x0 abstractC1197x0 = this.mLayout;
        if (abstractC1197x0 == null) {
            Log.e(TAG, "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.mLayoutSuppressed) {
            return false;
        }
        boolean zCanScrollHorizontally = abstractC1197x0.canScrollHorizontally();
        boolean zCanScrollVertically = this.mLayout.canScrollVertically();
        if (!zCanScrollHorizontally || Math.abs(i6) < i11) {
            i6 = 0;
        }
        if (!zCanScrollVertically || Math.abs(i10) < i11) {
            i10 = 0;
        }
        if (i6 == 0 && i10 == 0) {
            return false;
        }
        if (i6 == 0) {
            iMax = 0;
        } else {
            EdgeEffect edgeEffect = this.mLeftGlow;
            if (edgeEffect == null || AbstractC1466d.m3495m(edgeEffect) == 0.0f) {
                EdgeEffect edgeEffect2 = this.mRightGlow;
                if (edgeEffect2 == null || AbstractC1466d.m3495m(edgeEffect2) == 0.0f) {
                    iMax = 0;
                } else if (shouldAbsorb(this.mRightGlow, i6, getWidth())) {
                    this.mRightGlow.onAbsorb(i6);
                    i6 = 0;
                }
            } else {
                int i14 = -i6;
                if (shouldAbsorb(this.mLeftGlow, i14, getWidth())) {
                    this.mLeftGlow.onAbsorb(i14);
                    i6 = 0;
                }
            }
            iMax = i6;
            i6 = 0;
        }
        if (i10 == 0) {
            i13 = i10;
            i10 = 0;
        } else {
            EdgeEffect edgeEffect3 = this.mTopGlow;
            if (edgeEffect3 == null || AbstractC1466d.m3495m(edgeEffect3) == 0.0f) {
                EdgeEffect edgeEffect4 = this.mBottomGlow;
                if (edgeEffect4 == null || AbstractC1466d.m3495m(edgeEffect4) == 0.0f) {
                    i13 = i10;
                    i10 = 0;
                } else if (shouldAbsorb(this.mBottomGlow, i10, getHeight())) {
                    this.mBottomGlow.onAbsorb(i10);
                    i10 = 0;
                }
            } else {
                int i15 = -i10;
                if (shouldAbsorb(this.mTopGlow, i15, getHeight())) {
                    this.mTopGlow.onAbsorb(i15);
                    i10 = 0;
                }
            }
            i13 = 0;
        }
        if (iMax != 0 || i10 != 0) {
            int i16 = -i12;
            iMax = Math.max(i16, Math.min(iMax, i12));
            i10 = Math.max(i16, Math.min(i10, i12));
            startNestedScrollForType(1);
            this.mViewFlinger.m2972a(iMax, i10);
        }
        if (i6 == 0 && i13 == 0) {
            return (iMax == 0 && i10 == 0) ? false : true;
        }
        float f = i6;
        float f3 = i13;
        if (!dispatchNestedPreFling(f, f3)) {
            boolean z7 = zCanScrollHorizontally || zCanScrollVertically;
            dispatchNestedFling(f, f3, z7);
            AbstractC1203z0 abstractC1203z0 = this.mOnFlingListener;
            if (abstractC1203z0 != null && abstractC1203z0.onFling(i6, i13)) {
                return true;
            }
            if (z7) {
                startNestedScrollForType(1);
                int i17 = -i12;
                this.mViewFlinger.m2972a(Math.max(i17, Math.min(i6, i12)), Math.max(i17, Math.min(i13, i12)));
                return true;
            }
        }
        return false;
    }

    public AbstractC1174p1 findViewHolderForPosition(int i6, boolean z7) {
        C1134d c1134d;
        int iM2916h = this.mChildHelper.m2916h();
        AbstractC1174p1 abstractC1174p1 = null;
        for (int i10 = 0; i10 < iM2916h; i10++) {
            AbstractC1174p1 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2915g(i10));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved()) {
                if (z7) {
                    if (childViewHolderInt.mPosition != i6) {
                        continue;
                    } else {
                        c1134d = this.mChildHelper;
                        if (c1134d.f3535c.contains(childViewHolderInt.itemView)) {
                            return childViewHolderInt;
                        }
                        abstractC1174p1 = childViewHolderInt;
                    }
                } else if (childViewHolderInt.getLayoutPosition() != i6) {
                    continue;
                } else {
                    c1134d = this.mChildHelper;
                    if (c1134d.f3535c.contains(childViewHolderInt.itemView)) {
                        return childViewHolderInt;
                    }
                    abstractC1174p1 = childViewHolderInt;
                }
            }
        }
        return abstractC1174p1;
    }

    public void onExitLayoutOrScroll(boolean z7) {
        int i6 = this.mLayoutOrScrollCounter - 1;
        this.mLayoutOrScrollCounter = i6;
        if (i6 < 1) {
            if (sDebugAssertionsEnabled && i6 < 0) {
                throw new IllegalStateException(AbstractC0004e.m22p(this, new StringBuilder("layout or scroll counter cannot go below zero.Some calls are not matching")));
            }
            this.mLayoutOrScrollCounter = 0;
            if (z7) {
                dispatchContentChangedIfNecessary();
                dispatchPendingImportantForAccessibilityChanges();
            }
        }
    }

    public void smoothScrollBy(int i6, int i10, Interpolator interpolator) {
        smoothScrollBy(i6, i10, interpolator, Integer.MIN_VALUE);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i6) {
        float fM6364a;
        float fM6364a2;
        super(context, attributeSet, i6);
        int i10 = 1;
        this.mObserver = new C1147g1(this);
        this.mRecycler = new C1140e1(this);
        this.mViewInfoStore = new C1141e2();
        this.mUpdateChildViewsRunnable = new RunnableC1146g0(this, 0);
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mRecyclerListeners = new ArrayList();
        this.mItemDecorations = new ArrayList<>();
        this.mOnItemTouchListeners = new ArrayList<>();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mEdgeEffectFactory = sDefaultEdgeEffectFactory;
        C1157k c1157k = new C1157k();
        c1157k.f3687a = null;
        c1157k.f3688b = new ArrayList();
        c1157k.f3689c = 120L;
        c1157k.f3690d = 120L;
        c1157k.f3691e = 250L;
        c1157k.f3692f = 250L;
        c1157k.f3600g = true;
        c1157k.f3601h = new ArrayList();
        c1157k.f3602i = new ArrayList();
        c1157k.f3603j = new ArrayList();
        c1157k.f3604k = new ArrayList();
        c1157k.f3605l = new ArrayList();
        c1157k.f3606m = new ArrayList();
        c1157k.f3607n = new ArrayList();
        c1157k.f3608o = new ArrayList();
        c1157k.f3609p = new ArrayList();
        c1157k.f3610q = new ArrayList();
        c1157k.f3611r = new ArrayList();
        this.mItemAnimator = c1157k;
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new RunnableC1171o1(this);
        this.mPrefetchRegistry = ALLOW_THREAD_GAP_WORK ? new C1178r() : null;
        C1162l1 c1162l1 = new C1162l1();
        c1162l1.f3615a = -1;
        c1162l1.f3616b = 0;
        c1162l1.f3617c = 0;
        c1162l1.f3618d = 1;
        c1162l1.f3619e = 0;
        c1162l1.f3620f = false;
        c1162l1.f3621g = false;
        c1162l1.f3622h = false;
        c1162l1.f3623i = false;
        c1162l1.f3624j = false;
        c1162l1.f3625k = false;
        this.mState = c1162l1;
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new C1152i0(this);
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mReusableIntPair = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new RunnableC1146g0(this, i10);
        this.mLastAutoMeasureNonExactMeasuredWidth = 0;
        this.mLastAutoMeasureNonExactMeasuredHeight = 0;
        this.mViewInfoProcessCallback = new C1152i0(this);
        C1152i0 c1152i0 = new C1152i0(this);
        this.mDifferentialMotionFlingTarget = c1152i0;
        this.mDifferentialMotionFlingController = new C3121h(getContext(), c1152i0);
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 26) {
            Method method = AbstractC3167w0.f10655a;
            fM6364a = AbstractC3158t0.m6352a(viewConfiguration);
        } else {
            fM6364a = AbstractC3167w0.m6364a(viewConfiguration, context);
        }
        this.mScaledHorizontalScrollFactor = fM6364a;
        if (i11 >= 26) {
            fM6364a2 = AbstractC3158t0.m6353b(viewConfiguration);
        } else {
            fM6364a2 = AbstractC3167w0.m6364a(viewConfiguration, context);
        }
        this.mScaledVerticalScrollFactor = fM6364a2;
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mPhysicalCoef = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        setWillNotDraw(getOverScrollMode() == 2);
        this.mItemAnimator.f3687a = this.mItemAnimatorListener;
        initAdapterManager();
        initChildrenHelper();
        initAutofill();
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new C1180r1(this));
        int[] iArr = AbstractC3889a.f13075a;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i6, 0);
        AbstractC3155s0.m6346p(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, i6, 0);
        String string = typedArrayObtainStyledAttributes.getString(8);
        if (typedArrayObtainStyledAttributes.getInt(2, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.mClipToPadding = typedArrayObtainStyledAttributes.getBoolean(1, true);
        boolean z7 = typedArrayObtainStyledAttributes.getBoolean(3, false);
        this.mEnableFastScroller = z7;
        if (z7) {
            initFastScroller((StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(6), typedArrayObtainStyledAttributes.getDrawable(7), (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(4), typedArrayObtainStyledAttributes.getDrawable(5));
        }
        typedArrayObtainStyledAttributes.recycle();
        this.mLowResRotaryEncoderFeature = context.getPackageManager().hasSystemFeature(LOW_RES_ROTARY_ENCODER_FEATURE);
        createLayoutManager(context, string, attributeSet, i6, 0);
        int[] iArr2 = NESTED_SCROLLING_ATTRS;
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i6, 0);
        AbstractC3155s0.m6346p(this, context, iArr2, attributeSet, typedArrayObtainStyledAttributes2, i6, 0);
        boolean z10 = typedArrayObtainStyledAttributes2.getBoolean(0, true);
        typedArrayObtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z10);
        setTag(com.p2serv.android.p032ds.R.id.is_pooling_container_tag, Boolean.TRUE);
    }

    public boolean dispatchNestedPreScroll(int i6, int i10, int[] iArr, int[] iArr2, int i11) {
        return getScrollingChildHelper().m6282c(i6, i10, iArr, iArr2, i11);
    }

    public boolean dispatchNestedScroll(int i6, int i10, int i11, int i12, int[] iArr, int i13) {
        return getScrollingChildHelper().m6283d(i6, i10, i11, i12, iArr, i13, null);
    }

    public boolean hasNestedScrollingParent(int i6) {
        return getScrollingChildHelper().m6285f(i6);
    }

    public void smoothScrollBy(int i6, int i10, Interpolator interpolator, int i11) {
        smoothScrollBy(i6, i10, interpolator, i11, false);
    }

    public boolean startNestedScroll(int i6, int i10) {
        return getScrollingChildHelper().m6286g(i6, i10);
    }

    public void stopNestedScroll(int i6) {
        getScrollingChildHelper().m6287h(i6);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        public AbstractC1174p1 f3465a;

        public final Rect f3466b;

        public boolean f3467c;

        public boolean f3468d;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3466b = new Rect();
            this.f3467c = true;
            this.f3468d = false;
        }

        public LayoutParams(int i6, int i10) {
            super(i6, i10);
            this.f3466b = new Rect();
            this.f3467c = true;
            this.f3468d = false;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f3466b = new Rect();
            this.f3467c = true;
            this.f3468d = false;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f3466b = new Rect();
            this.f3467c = true;
            this.f3468d = false;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
            this.f3466b = new Rect();
            this.f3467c = true;
            this.f3468d = false;
        }
    }

    public void smoothScrollBy(int i6, int i10, Interpolator interpolator, int i11, boolean z7) {
        AbstractC1197x0 abstractC1197x0 = this.mLayout;
        if (abstractC1197x0 == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        if (!abstractC1197x0.canScrollHorizontally()) {
            i6 = 0;
        }
        if (!this.mLayout.canScrollVertically()) {
            i10 = 0;
        }
        if (i6 == 0 && i10 == 0) {
            return;
        }
        if (i11 != Integer.MIN_VALUE && i11 <= 0) {
            scrollBy(i6, i10);
            return;
        }
        if (z7) {
            int i12 = i6 != 0 ? 1 : 0;
            if (i10 != 0) {
                i12 |= 2;
            }
            startNestedScroll(i12, 1);
        }
        this.mViewFlinger.m2974c(i6, i10, interpolator, i11);
    }

    public final void dispatchNestedScroll(int i6, int i10, int i11, int i12, int[] iArr, int i13, int[] iArr2) {
        getScrollingChildHelper().m6283d(i6, i10, i11, i12, iArr, i13, iArr2);
    }

    public void addItemDecoration(AbstractC1185t0 abstractC1185t0) {
        addItemDecoration(abstractC1185t0, -1);
    }

    @Override
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        AbstractC1197x0 abstractC1197x0 = this.mLayout;
        if (abstractC1197x0 != null) {
            return abstractC1197x0.generateLayoutParams(layoutParams);
        }
        throw new IllegalStateException(AbstractC0004e.m22p(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    public void onChildAttachedToWindow(View view) {
    }

    public void onChildDetachedFromWindow(View view) {
    }

    public void onScrollStateChanged(int i6) {
    }

    public void onScrolled(int i6, int i10) {
    }
}
