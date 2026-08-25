package androidx.core.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.media3.extractor.p010ts.TsExtractor;
import com.bumptech.glide.AbstractC1466d;
import java.util.ArrayList;
import java.util.WeakHashMap;
import p001a0.C0019b;
import p138n0.AbstractC3119g0;
import p138n0.AbstractC3155s0;
import p138n0.C3121h;
import p138n0.C3142o;
import p138n0.C3151r;
import p138n0.InterfaceC3139n;
import p138n0.InterfaceC3148q;
import p143n5.AbstractC3198d;

public class NestedScrollView extends FrameLayout implements InterfaceC3148q, InterfaceC3139n {

    public static final float f1620C = (float) (Math.log(0.78d) / Math.log(0.9d));

    public static final C0376i f1621D = new C0376i(0);

    public static final int[] f1622E = {R.attr.fillViewport};

    public InterfaceC0378k f1623A;

    public final C3121h f1624B;

    public final float f1625a;

    public long f1626b;

    public final Rect f1627c;

    public final OverScroller f1628d;

    public final EdgeEffect f1629e;

    public final EdgeEffect f1630f;

    public int f1631g;

    public boolean f1632h;

    public boolean f1633i;

    public View f1634j;

    public boolean f1635k;

    public VelocityTracker f1636l;

    public boolean f1637m;

    public boolean f1638n;

    public final int f1639o;

    public final int f1640p;

    public final int f1641q;

    public int f1642r;

    public final int[] f1643s;

    public final int[] f1644t;

    public int f1645u;

    public int f1646v;

    public SavedState f1647w;

    public final C3151r f1648x;

    public final C3142o f1649y;

    public float f1650z;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0379l();

        public int f1651a;

        public final String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f1651a + "}";
        }

        @Override
        public final void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeInt(this.f1651a);
        }
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.p2serv.android.p032ds.R.attr.nestedScrollViewStyle);
    }

    public static boolean m1097m(View view, NestedScrollView nestedScrollView) {
        if (view == nestedScrollView) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && m1097m((View) parent, nestedScrollView);
    }

    @Override
    public final void mo547a(View view, View view2, int i6, int i10) {
        C3151r c3151r = this.f1648x;
        if (i10 == 1) {
            c3151r.f10635b = i6;
        } else {
            c3151r.f10634a = i6;
        }
        m1113w(2, i10);
    }

    @Override
    public final void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    @Override
    public final void mo548b(View view, int i6, int i10, int[] iArr, int i11) {
        m1100e(i6, i10, iArr, null, i11);
    }

    public final boolean m1098c(int i6) {
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i6);
        int maxScrollAmount = getMaxScrollAmount();
        if (viewFindNextFocus == null || !m1104n(viewFindNextFocus, maxScrollAmount, getHeight())) {
            if (i6 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i6 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getHeight() + getScrollY()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i6 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            m1110t(maxScrollAmount, 0, 1, true);
        } else {
            Rect rect = this.f1627c;
            viewFindNextFocus.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(viewFindNextFocus, rect);
            m1110t(m1099d(rect), 0, 1, true);
            viewFindNextFocus.requestFocus(i6);
        }
        if (viewFindFocus != null && viewFindFocus.isFocused() && !m1104n(viewFindFocus, 0, getHeight())) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    @Override
    public final int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override
    public final int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override
    public final int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override
    public final void computeScroll() {
        int iRound;
        int[] iArr;
        int i6;
        int scrollRange;
        int overScrollMode;
        if (this.f1628d.isFinished()) {
            return;
        }
        this.f1628d.computeScrollOffset();
        int currY = this.f1628d.getCurrY();
        int i10 = currY - this.f1646v;
        int height = getHeight();
        EdgeEffect edgeEffect = this.f1630f;
        EdgeEffect edgeEffect2 = this.f1629e;
        if (i10 <= 0 || AbstractC1466d.m3495m(edgeEffect2) == 0.0f) {
            if (i10 < 0 && AbstractC1466d.m3495m(edgeEffect) != 0.0f) {
                float f = height;
                iRound = Math.round(AbstractC1466d.m3506z(edgeEffect, (i10 * 4.0f) / f, 0.5f) * (f / 4.0f));
                if (iRound != i10) {
                    edgeEffect.finish();
                }
            }
            this.f1646v = currY;
            iArr = this.f1644t;
            iArr[1] = 0;
            m1100e(0, i10, iArr, null, 1);
            i6 = i10 - iArr[1];
            scrollRange = getScrollRange();
            if (i6 != 0) {
                int scrollY = getScrollY();
                m1107q(i6, getScrollX(), scrollY, scrollRange);
                int scrollY2 = getScrollY() - scrollY;
                int i11 = i6 - scrollY2;
                iArr[1] = 0;
                this.f1649y.m6283d(0, scrollY2, 0, i11, this.f1643s, 1, iArr);
                i6 = i11 - iArr[1];
            }
            if (i6 != 0) {
                overScrollMode = getOverScrollMode();
                if (overScrollMode != 0 || (overScrollMode == 1 && scrollRange > 0)) {
                    if (i6 < 0) {
                        if (edgeEffect2.isFinished()) {
                            edgeEffect2.onAbsorb((int) this.f1628d.getCurrVelocity());
                        }
                    } else if (edgeEffect.isFinished()) {
                        edgeEffect.onAbsorb((int) this.f1628d.getCurrVelocity());
                    }
                }
                this.f1628d.abortAnimation();
                m1115y(1);
            }
            if (this.f1628d.isFinished()) {
                m1115y(1);
            } else {
                postInvalidateOnAnimation();
            }
        }
        iRound = Math.round(AbstractC1466d.m3506z(edgeEffect2, ((-i10) * 4.0f) / height, 0.5f) * ((-height) / 4.0f));
        if (iRound != i10) {
            edgeEffect2.finish();
        }
        i10 -= iRound;
        this.f1646v = currY;
        iArr = this.f1644t;
        iArr[1] = 0;
        m1100e(0, i10, iArr, null, 1);
        i6 = i10 - iArr[1];
        scrollRange = getScrollRange();
        if (i6 != 0) {
            int scrollY3 = getScrollY();
            m1107q(i6, getScrollX(), scrollY3, scrollRange);
            int scrollY4 = getScrollY() - scrollY3;
            int i12 = i6 - scrollY4;
            iArr[1] = 0;
            this.f1649y.m6283d(0, scrollY4, 0, i12, this.f1643s, 1, iArr);
            i6 = i12 - iArr[1];
        }
        if (i6 != 0) {
            overScrollMode = getOverScrollMode();
            if (overScrollMode != 0) {
                if (i6 < 0) {
                    if (edgeEffect2.isFinished()) {
                        edgeEffect2.onAbsorb((int) this.f1628d.getCurrVelocity());
                    }
                } else if (edgeEffect.isFinished()) {
                    edgeEffect.onAbsorb((int) this.f1628d.getCurrVelocity());
                }
            } else if (i6 < 0) {
                if (edgeEffect2.isFinished()) {
                    edgeEffect2.onAbsorb((int) this.f1628d.getCurrVelocity());
                }
            } else if (edgeEffect.isFinished()) {
                edgeEffect.onAbsorb((int) this.f1628d.getCurrVelocity());
            }
            this.f1628d.abortAnimation();
            m1115y(1);
        }
        if (this.f1628d.isFinished()) {
            postInvalidateOnAnimation();
        } else {
            m1115y(1);
        }
    }

    @Override
    public final int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override
    public final int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override
    public final int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int iMax = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        return scrollY > iMax ? bottom + (scrollY - iMax) : bottom;
    }

    public final int m1099d(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i6 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i10 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i6 - verticalFadingEdgeLength : i6;
        int i11 = rect.bottom;
        if (i11 > i10 && rect.top > scrollY) {
            return Math.min(rect.height() > height ? rect.top - scrollY : rect.bottom - i10, (childAt.getBottom() + layoutParams.bottomMargin) - i6);
        }
        if (rect.top >= scrollY || i11 >= i10) {
            return 0;
        }
        return Math.max(rect.height() > height ? 0 - (i10 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
    }

    @Override
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m1101h(keyEvent);
    }

    @Override
    public final boolean dispatchNestedFling(float f, float f3, boolean z7) {
        return this.f1649y.m6280a(f, f3, z7);
    }

    @Override
    public final boolean dispatchNestedPreFling(float f, float f3) {
        return this.f1649y.m6281b(f, f3);
    }

    @Override
    public final boolean dispatchNestedPreScroll(int i6, int i10, int[] iArr, int[] iArr2) {
        return this.f1649y.m6282c(i6, i10, iArr, iArr2, 0);
    }

    @Override
    public final boolean dispatchNestedScroll(int i6, int i10, int i11, int i12, int[] iArr) {
        return this.f1649y.m6283d(i6, i10, i11, i12, iArr, 0, null);
    }

    @Override
    public final void draw(Canvas canvas) {
        int paddingLeft;
        super.draw(canvas);
        int scrollY = getScrollY();
        EdgeEffect edgeEffect = this.f1629e;
        int paddingLeft2 = 0;
        if (!edgeEffect.isFinished()) {
            int iSave = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int iMin = Math.min(0, scrollY);
            if (AbstractC0377j.m1138a(this)) {
                width -= getPaddingRight() + getPaddingLeft();
                paddingLeft = getPaddingLeft();
            } else {
                paddingLeft = 0;
            }
            if (AbstractC0377j.m1138a(this)) {
                height -= getPaddingBottom() + getPaddingTop();
                iMin += getPaddingTop();
            }
            canvas.translate(paddingLeft, iMin);
            edgeEffect.setSize(width, height);
            if (edgeEffect.draw(canvas)) {
                postInvalidateOnAnimation();
            }
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect2 = this.f1630f;
        if (edgeEffect2.isFinished()) {
            return;
        }
        int iSave2 = canvas.save();
        int width2 = getWidth();
        int height2 = getHeight();
        int iMax = Math.max(getScrollRange(), scrollY) + height2;
        if (AbstractC0377j.m1138a(this)) {
            width2 -= getPaddingRight() + getPaddingLeft();
            paddingLeft2 = getPaddingLeft();
        }
        if (AbstractC0377j.m1138a(this)) {
            height2 -= getPaddingBottom() + getPaddingTop();
            iMax -= getPaddingBottom();
        }
        canvas.translate(paddingLeft2 - width2, iMax);
        canvas.rotate(180.0f, width2, 0.0f);
        edgeEffect2.setSize(width2, height2);
        if (edgeEffect2.draw(canvas)) {
            postInvalidateOnAnimation();
        }
        canvas.restoreToCount(iSave2);
    }

    public final boolean m1100e(int i6, int i10, int[] iArr, int[] iArr2, int i11) {
        return this.f1649y.m6282c(i6, i10, iArr, null, i11);
    }

    @Override
    public final void mo551f(int i6, View view) {
        C3151r c3151r = this.f1648x;
        if (i6 == 1) {
            c3151r.f10635b = 0;
        } else {
            c3151r.f10634a = 0;
        }
        m1115y(i6);
    }

    @Override
    public final void mo552g(View view, int i6, int i10, int i11, int i12, int i13, int[] iArr) {
        m1105o(i12, i13, iArr);
    }

    @Override
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override
    public int getNestedScrollAxes() {
        C3151r c3151r = this.f1648x;
        return c3151r.f10635b | c3151r.f10634a;
    }

    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    @Override
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public float getVerticalScrollFactorCompat() {
        if (this.f1650z == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.f1650z = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.f1650z;
    }

    public final boolean m1101h(KeyEvent keyEvent) {
        this.f1627c.setEmpty();
        int childCount = getChildCount();
        int i6 = TsExtractor.TS_STREAM_TYPE_HDMV_DTS;
        if (childCount > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            if (childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom()) {
                if (keyEvent.getAction() != 0) {
                    return false;
                }
                int keyCode = keyEvent.getKeyCode();
                if (keyCode == 19) {
                    return keyEvent.isAltPressed() ? m1103l(33) : m1098c(33);
                }
                if (keyCode == 20) {
                    return keyEvent.isAltPressed() ? m1103l(TsExtractor.TS_STREAM_TYPE_HDMV_DTS) : m1098c(TsExtractor.TS_STREAM_TYPE_HDMV_DTS);
                }
                if (keyCode == 62) {
                    if (keyEvent.isShiftPressed()) {
                        i6 = 33;
                    }
                    m1108r(i6);
                    return false;
                }
                if (keyCode == 92) {
                    return m1103l(33);
                }
                if (keyCode == 93) {
                    return m1103l(TsExtractor.TS_STREAM_TYPE_HDMV_DTS);
                }
                if (keyCode == 122) {
                    m1108r(33);
                    return false;
                }
                if (keyCode != 123) {
                    return false;
                }
                m1108r(TsExtractor.TS_STREAM_TYPE_HDMV_DTS);
                return false;
            }
        }
        if (!isFocused() || keyEvent.getKeyCode() == 4) {
            return false;
        }
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, TsExtractor.TS_STREAM_TYPE_HDMV_DTS);
        return (viewFindNextFocus == null || viewFindNextFocus == this || !viewFindNextFocus.requestFocus(TsExtractor.TS_STREAM_TYPE_HDMV_DTS)) ? false : true;
    }

    @Override
    public final boolean hasNestedScrollingParent() {
        return this.f1649y.m6285f(0);
    }

    @Override
    public final void mo554i(View view, int i6, int i10, int i11, int i12, int i13) {
        m1105o(i12, i13, null);
    }

    @Override
    public final boolean isNestedScrollingEnabled() {
        return this.f1649y.f10629d;
    }

    @Override
    public final boolean mo555j(View view, View view2, int i6, int i10) {
        return (i6 & 2) != 0;
    }

    public final void m1102k(int i6) {
        if (getChildCount() > 0) {
            this.f1628d.fling(getScrollX(), getScrollY(), 0, i6, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            m1113w(2, 1);
            this.f1646v = getScrollY();
            postInvalidateOnAnimation();
        }
    }

    public final boolean m1103l(int i6) {
        int childCount;
        boolean z7 = i6 == 130;
        int height = getHeight();
        Rect rect = this.f1627c;
        rect.top = 0;
        rect.bottom = height;
        if (z7 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            int paddingBottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            rect.bottom = paddingBottom;
            rect.top = paddingBottom - height;
        }
        return m1109s(i6, rect.top, rect.bottom);
    }

    @Override
    public final void measureChild(View view, int i6, int i10) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i6, getPaddingRight() + getPaddingLeft(), layoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override
    public final void measureChildWithMargins(View view, int i6, int i10, int i11, int i12) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i6, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i10, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    public final boolean m1104n(View view, int i6, int i10) {
        Rect rect = this.f1627c;
        view.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(view, rect);
        return rect.bottom + i6 >= getScrollY() && rect.top - i6 <= getScrollY() + i10;
    }

    public final void m1105o(int i6, int i10, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i6);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.f1649y.m6283d(0, scrollY2, 0, i6 - scrollY2, null, i10, iArr);
    }

    @Override
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1633i = false;
    }

    @Override
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        int i6;
        float axisValue;
        int width;
        if (motionEvent.getAction() == 8 && !this.f1635k) {
            if (AbstractC3198d.m6477z(motionEvent, 2)) {
                i6 = 9;
                axisValue = motionEvent.getAxisValue(9);
                width = (int) motionEvent.getX();
            } else if (AbstractC3198d.m6477z(motionEvent, 4194304)) {
                axisValue = motionEvent.getAxisValue(26);
                width = getWidth() / 2;
                i6 = 26;
            } else {
                i6 = 0;
                axisValue = 0.0f;
                width = 0;
            }
            if (axisValue != 0.0f) {
                m1110t(-((int) (getVerticalScrollFactorCompat() * axisValue)), width, 1, AbstractC3198d.m6477z(motionEvent, 8194));
                if (i6 != 0) {
                    this.f1624B.m6188a(motionEvent, i6);
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        VelocityTracker velocityTracker2;
        int action = motionEvent.getAction();
        boolean z7 = true;
        if (action == 2 && this.f1635k) {
            return true;
        }
        int i6 = action & 255;
        if (i6 == 0) {
            int y7 = (int) motionEvent.getY();
            int x10 = (int) motionEvent.getX();
            if (getChildCount() > 0) {
                int scrollY = getScrollY();
                View childAt = getChildAt(0);
                if (y7 < childAt.getTop() - scrollY || y7 >= childAt.getBottom() - scrollY || x10 < childAt.getLeft() || x10 >= childAt.getRight()) {
                    if (!m1114x(motionEvent) && this.f1628d.isFinished()) {
                        z7 = false;
                    }
                    this.f1635k = z7;
                    velocityTracker = this.f1636l;
                    if (velocityTracker != null) {
                        velocityTracker.recycle();
                        this.f1636l = null;
                    }
                } else {
                    this.f1631g = y7;
                    this.f1642r = motionEvent.getPointerId(0);
                    VelocityTracker velocityTracker3 = this.f1636l;
                    if (velocityTracker3 == null) {
                        this.f1636l = VelocityTracker.obtain();
                    } else {
                        velocityTracker3.clear();
                    }
                    this.f1636l.addMovement(motionEvent);
                    this.f1628d.computeScrollOffset();
                    if (!m1114x(motionEvent) && this.f1628d.isFinished()) {
                        z7 = false;
                    }
                    this.f1635k = z7;
                    m1113w(2, 0);
                }
            } else {
                if (!m1114x(motionEvent)) {
                    z7 = false;
                }
                this.f1635k = z7;
                velocityTracker = this.f1636l;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    this.f1636l = null;
                }
            }
        } else if (i6 == 1) {
            this.f1635k = false;
            this.f1642r = -1;
            velocityTracker2 = this.f1636l;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.f1636l = null;
            }
            if (this.f1628d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                postInvalidateOnAnimation();
            }
            m1115y(0);
        } else if (i6 == 2) {
            int i10 = this.f1642r;
            if (i10 != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i10);
                if (iFindPointerIndex == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + i10 + " in onInterceptTouchEvent");
                } else {
                    int y9 = (int) motionEvent.getY(iFindPointerIndex);
                    if (Math.abs(y9 - this.f1631g) > this.f1639o && (2 & getNestedScrollAxes()) == 0) {
                        this.f1635k = true;
                        this.f1631g = y9;
                        if (this.f1636l == null) {
                            this.f1636l = VelocityTracker.obtain();
                        }
                        this.f1636l.addMovement(motionEvent);
                        this.f1645u = 0;
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
            }
        } else if (i6 == 3) {
            this.f1635k = false;
            this.f1642r = -1;
            velocityTracker2 = this.f1636l;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.f1636l = null;
            }
            if (this.f1628d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                postInvalidateOnAnimation();
            }
            m1115y(0);
        } else if (i6 == 6) {
            m1106p(motionEvent);
        }
        return this.f1635k;
    }

    @Override
    public final void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        int measuredHeight;
        super.onLayout(z7, i6, i10, i11, i12);
        int i13 = 0;
        this.f1632h = false;
        View view = this.f1634j;
        if (view != null && m1097m(view, this)) {
            View view2 = this.f1634j;
            Rect rect = this.f1627c;
            view2.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(view2, rect);
            int iM1099d = m1099d(rect);
            if (iM1099d != 0) {
                scrollBy(0, iM1099d);
            }
        }
        this.f1634j = null;
        if (!this.f1633i) {
            if (this.f1647w != null) {
                scrollTo(getScrollX(), this.f1647w.f1651a);
                this.f1647w = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            } else {
                measuredHeight = 0;
            }
            int paddingTop = ((i12 - i10) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            if (paddingTop < measuredHeight && scrollY >= 0) {
                i13 = paddingTop + scrollY > measuredHeight ? measuredHeight - paddingTop : scrollY;
            }
            if (i13 != scrollY) {
                scrollTo(getScrollX(), i13);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f1633i = true;
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        super.onMeasure(i6, i10);
        if (this.f1637m && View.MeasureSpec.getMode(i10) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i6, getPaddingRight() + getPaddingLeft() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override
    public final boolean onNestedFling(View view, float f, float f3, boolean z7) {
        if (z7) {
            return false;
        }
        dispatchNestedFling(0.0f, f3, true);
        m1102k((int) f3);
        return true;
    }

    @Override
    public final boolean onNestedPreFling(View view, float f, float f3) {
        return this.f1649y.m6281b(f, f3);
    }

    @Override
    public final void onNestedPreScroll(View view, int i6, int i10, int[] iArr) {
        m1100e(i6, i10, iArr, null, 0);
    }

    @Override
    public final void onNestedScroll(View view, int i6, int i10, int i11, int i12) {
        m1105o(i12, 0, null);
    }

    @Override
    public final void onNestedScrollAccepted(View view, View view2, int i6) {
        mo547a(view, view2, i6, 0);
    }

    @Override
    public final void onOverScrolled(int i6, int i10, boolean z7, boolean z10) {
        super.scrollTo(i6, i10);
    }

    @Override
    public final boolean onRequestFocusInDescendants(int i6, Rect rect) {
        if (i6 == 2) {
            i6 = TsExtractor.TS_STREAM_TYPE_HDMV_DTS;
        } else if (i6 == 1) {
            i6 = 33;
        }
        View viewFindNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i6) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i6);
        if (viewFindNextFocus != null && m1104n(viewFindNextFocus, 0, getHeight())) {
            return viewFindNextFocus.requestFocus(i6, rect);
        }
        return false;
    }

    @Override
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f1647w = savedState;
        requestLayout();
    }

    @Override
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1651a = getScrollY();
        return savedState;
    }

    @Override
    public final void onScrollChanged(int i6, int i10, int i11, int i12) {
        super.onScrollChanged(i6, i10, i11, i12);
        InterfaceC0378k interfaceC0378k = this.f1623A;
        if (interfaceC0378k != null) {
            interfaceC0378k.mo1139k(this);
        }
    }

    @Override
    public final void onSizeChanged(int i6, int i10, int i11, int i12) {
        super.onSizeChanged(i6, i10, i11, i12);
        View viewFindFocus = findFocus();
        if (viewFindFocus == null || this == viewFindFocus || !m1104n(viewFindFocus, 0, i12)) {
            return;
        }
        Rect rect = this.f1627c;
        viewFindFocus.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(viewFindFocus, rect);
        int iM1099d = m1099d(rect);
        if (iM1099d != 0) {
            if (this.f1638n) {
                m1112v(0, iM1099d, false);
            } else {
                scrollBy(0, iM1099d);
            }
        }
    }

    @Override
    public final boolean onStartNestedScroll(View view, View view2, int i6) {
        return mo555j(view, view2, i6, 0);
    }

    @Override
    public final void onStopNestedScroll(View view) {
        mo551f(0, view);
    }

    @Override
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        if (this.f1636l == null) {
            this.f1636l = VelocityTracker.obtain();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1645u = 0;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        float f = 0.0f;
        motionEventObtain.offsetLocation(0.0f, this.f1645u);
        if (actionMasked != 0) {
            EdgeEffect edgeEffect = this.f1630f;
            EdgeEffect edgeEffect2 = this.f1629e;
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.f1636l;
                velocityTracker.computeCurrentVelocity(1000, this.f1641q);
                int yVelocity = (int) velocityTracker.getYVelocity(this.f1642r);
                if (Math.abs(yVelocity) >= this.f1640p) {
                    if (AbstractC1466d.m3495m(edgeEffect2) != 0.0f) {
                        if (m1111u(edgeEffect2, yVelocity)) {
                            edgeEffect2.onAbsorb(yVelocity);
                        } else {
                            m1102k(-yVelocity);
                        }
                    } else if (AbstractC1466d.m3495m(edgeEffect) != 0.0f) {
                        int i6 = -yVelocity;
                        if (m1111u(edgeEffect, i6)) {
                            edgeEffect.onAbsorb(i6);
                        } else {
                            m1102k(i6);
                        }
                    } else {
                        int i10 = -yVelocity;
                        float f3 = i10;
                        if (!this.f1649y.m6281b(0.0f, f3)) {
                            dispatchNestedFling(0.0f, f3, true);
                            m1102k(i10);
                        }
                    }
                } else if (this.f1628d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    postInvalidateOnAnimation();
                }
                this.f1642r = -1;
                this.f1635k = false;
                VelocityTracker velocityTracker2 = this.f1636l;
                if (velocityTracker2 != null) {
                    velocityTracker2.recycle();
                    this.f1636l = null;
                }
                m1115y(0);
                this.f1629e.onRelease();
                this.f1630f.onRelease();
            } else if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f1642r);
                if (iFindPointerIndex == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + this.f1642r + " in onTouchEvent");
                } else {
                    int y7 = (int) motionEvent.getY(iFindPointerIndex);
                    int i11 = this.f1631g - y7;
                    float x10 = motionEvent.getX(iFindPointerIndex) / getWidth();
                    float height = i11 / getHeight();
                    if (AbstractC1466d.m3495m(edgeEffect2) != 0.0f) {
                        float f4 = -AbstractC1466d.m3506z(edgeEffect2, -height, x10);
                        if (AbstractC1466d.m3495m(edgeEffect2) == 0.0f) {
                            edgeEffect2.onRelease();
                        }
                        f = f4;
                    } else if (AbstractC1466d.m3495m(edgeEffect) != 0.0f) {
                        float fM3506z = AbstractC1466d.m3506z(edgeEffect, height, 1.0f - x10);
                        if (AbstractC1466d.m3495m(edgeEffect) == 0.0f) {
                            edgeEffect.onRelease();
                        }
                        f = fM3506z;
                    }
                    int iRound = Math.round(f * getHeight());
                    if (iRound != 0) {
                        invalidate();
                    }
                    int i12 = i11 - iRound;
                    if (!this.f1635k && Math.abs(i12) > this.f1639o) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f1635k = true;
                        i12 = i12 > 0 ? i12 - this.f1639o : i12 + this.f1639o;
                    }
                    if (this.f1635k) {
                        int iM1110t = m1110t(i12, (int) motionEvent.getX(iFindPointerIndex), 0, false);
                        this.f1631g = y7 - iM1110t;
                        this.f1645u += iM1110t;
                    }
                }
            } else if (actionMasked == 3) {
                if (this.f1635k && getChildCount() > 0 && this.f1628d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    postInvalidateOnAnimation();
                }
                this.f1642r = -1;
                this.f1635k = false;
                VelocityTracker velocityTracker3 = this.f1636l;
                if (velocityTracker3 != null) {
                    velocityTracker3.recycle();
                    this.f1636l = null;
                }
                m1115y(0);
                this.f1629e.onRelease();
                this.f1630f.onRelease();
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.f1631g = (int) motionEvent.getY(actionIndex);
                this.f1642r = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                m1106p(motionEvent);
                this.f1631g = (int) motionEvent.getY(motionEvent.findPointerIndex(this.f1642r));
            }
        } else {
            if (getChildCount() == 0) {
                return false;
            }
            if (this.f1635k && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.f1628d.isFinished()) {
                this.f1628d.abortAnimation();
                m1115y(1);
            }
            int y9 = (int) motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            this.f1631g = y9;
            this.f1642r = pointerId;
            m1113w(2, 0);
        }
        VelocityTracker velocityTracker4 = this.f1636l;
        if (velocityTracker4 != null) {
            velocityTracker4.addMovement(motionEventObtain);
        }
        motionEventObtain.recycle();
        return true;
    }

    public final void m1106p(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f1642r) {
            int i6 = actionIndex == 0 ? 1 : 0;
            this.f1631g = (int) motionEvent.getY(i6);
            this.f1642r = motionEvent.getPointerId(i6);
            VelocityTracker velocityTracker = this.f1636l;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public final boolean m1107q(int i6, int i10, int i11, int i12) {
        boolean z7;
        boolean z10;
        getOverScrollMode();
        super.computeHorizontalScrollRange();
        super.computeHorizontalScrollExtent();
        computeVerticalScrollRange();
        super.computeVerticalScrollExtent();
        int i13 = i11 + i6;
        if (i10 <= 0 && i10 >= 0) {
            z7 = false;
        } else {
            i10 = 0;
            z7 = true;
        }
        if (i13 > i12) {
            z10 = true;
        } else if (i13 < 0) {
            z10 = true;
            i12 = 0;
        } else {
            i12 = i13;
            z10 = false;
        }
        if (z10 && !this.f1649y.m6285f(1)) {
            this.f1628d.springBack(i10, i12, 0, 0, 0, getScrollRange());
        }
        super.scrollTo(i10, i12);
        return z7 || z10;
    }

    public final void m1108r(int i6) {
        boolean z7 = i6 == 130;
        int height = getHeight();
        Rect rect = this.f1627c;
        if (z7) {
            rect.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int paddingBottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
                if (rect.top + height > paddingBottom) {
                    rect.top = paddingBottom - height;
                }
            }
        } else {
            int scrollY = getScrollY() - height;
            rect.top = scrollY;
            if (scrollY < 0) {
                rect.top = 0;
            }
        }
        int i10 = rect.top;
        int i11 = height + i10;
        rect.bottom = i11;
        m1109s(i6, i10, i11);
    }

    @Override
    public final void requestChildFocus(View view, View view2) {
        if (this.f1632h) {
            this.f1634j = view2;
        } else {
            Rect rect = this.f1627c;
            view2.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(view2, rect);
            int iM1099d = m1099d(rect);
            if (iM1099d != 0) {
                scrollBy(0, iM1099d);
            }
        }
        super.requestChildFocus(view, view2);
    }

    @Override
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z7) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        int iM1099d = m1099d(rect);
        boolean z10 = iM1099d != 0;
        if (z10) {
            if (z7) {
                scrollBy(0, iM1099d);
            } else {
                m1112v(0, iM1099d, false);
            }
        }
        return z10;
    }

    @Override
    public final void requestDisallowInterceptTouchEvent(boolean z7) {
        VelocityTracker velocityTracker;
        if (z7 && (velocityTracker = this.f1636l) != null) {
            velocityTracker.recycle();
            this.f1636l = null;
        }
        super.requestDisallowInterceptTouchEvent(z7);
    }

    @Override
    public final void requestLayout() {
        this.f1632h = true;
        super.requestLayout();
    }

    public final boolean m1109s(int i6, int i10, int i11) {
        boolean z7;
        int height = getHeight();
        int scrollY = getScrollY();
        int i12 = height + scrollY;
        boolean z10 = i6 == 33;
        ArrayList<View> focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z11 = false;
        for (int i13 = 0; i13 < size; i13++) {
            View view2 = focusables.get(i13);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i10 < bottom && top < i11) {
                boolean z12 = i10 < top && bottom < i11;
                if (view == null) {
                    view = view2;
                    z11 = z12;
                } else {
                    boolean z13 = (z10 && top < view.getTop()) || (!z10 && bottom > view.getBottom());
                    if (z11) {
                        if (z12 && z13) {
                            view = view2;
                        }
                    } else if (z12) {
                        view = view2;
                        z11 = true;
                    } else if (z13) {
                        view = view2;
                    }
                }
            }
        }
        if (view == null) {
            view = this;
        }
        if (i10 < scrollY || i11 > i12) {
            m1110t(z10 ? i10 - scrollY : i11 - i12, 0, 1, true);
            z7 = true;
        } else {
            z7 = false;
        }
        if (view != findFocus()) {
            view.requestFocus(i6);
        }
        return z7;
    }

    @Override
    public final void scrollTo(int i6, int i10) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (width >= width2 || i6 < 0) {
                i6 = 0;
            } else if (width + i6 > width2) {
                i6 = width2 - width;
            }
            if (height >= height2 || i10 < 0) {
                i10 = 0;
            } else if (height + i10 > height2) {
                i10 = height2 - height;
            }
            if (i6 == getScrollX() && i10 == getScrollY()) {
                return;
            }
            super.scrollTo(i6, i10);
        }
    }

    public void setFillViewport(boolean z7) {
        if (z7 != this.f1637m) {
            this.f1637m = z7;
            requestLayout();
        }
    }

    @Override
    public void setNestedScrollingEnabled(boolean z7) {
        C3142o c3142o = this.f1649y;
        if (c3142o.f10629d) {
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            AbstractC3119g0.m6187z(c3142o.f10628c);
        }
        c3142o.f10629d = z7;
    }

    public void setOnScrollChangeListener(InterfaceC0378k interfaceC0378k) {
        this.f1623A = interfaceC0378k;
    }

    public void setSmoothScrollingEnabled(boolean z7) {
        this.f1638n = z7;
    }

    @Override
    public final boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override
    public final boolean startNestedScroll(int i6) {
        return this.f1649y.m6286g(i6, 0);
    }

    @Override
    public final void stopNestedScroll() {
        m1115y(0);
    }

    public final int m1110t(int i6, int i10, int i11, boolean z7) {
        int i12;
        int i13;
        boolean z10;
        VelocityTracker velocityTracker;
        if (i11 == 1) {
            m1113w(2, i11);
        }
        boolean zM6282c = this.f1649y.m6282c(0, i6, this.f1644t, this.f1643s, i11);
        int[] iArr = this.f1644t;
        int[] iArr2 = this.f1643s;
        if (zM6282c) {
            i12 = i6 - iArr[1];
            i13 = iArr2[1];
        } else {
            i12 = i6;
            i13 = 0;
        }
        int scrollY = getScrollY();
        int scrollRange = getScrollRange();
        int overScrollMode = getOverScrollMode();
        boolean z11 = (overScrollMode == 0 || (overScrollMode == 1 && getScrollRange() > 0)) && !z7;
        boolean z12 = m1107q(i12, 0, scrollY, scrollRange) && !this.f1649y.m6285f(i11);
        int scrollY2 = getScrollY() - scrollY;
        iArr[1] = 0;
        this.f1649y.m6283d(0, scrollY2, 0, i12 - scrollY2, this.f1643s, i11, iArr);
        int i14 = i13 + iArr2[1];
        int i15 = i12 - iArr[1];
        int i16 = scrollY + i15;
        EdgeEffect edgeEffect = this.f1630f;
        EdgeEffect edgeEffect2 = this.f1629e;
        if (i16 < 0) {
            if (z11) {
                AbstractC1466d.m3506z(edgeEffect2, (-i15) / getHeight(), i10 / getWidth());
                if (!edgeEffect.isFinished()) {
                    edgeEffect.onRelease();
                }
            }
        } else if (i16 > scrollRange && z11) {
            AbstractC1466d.m3506z(edgeEffect, i15 / getHeight(), 1.0f - (i10 / getWidth()));
            if (!edgeEffect2.isFinished()) {
                edgeEffect2.onRelease();
            }
        }
        if (edgeEffect2.isFinished() && edgeEffect.isFinished()) {
            z10 = z12;
        } else {
            postInvalidateOnAnimation();
            z10 = false;
        }
        if (z10 && i11 == 0 && (velocityTracker = this.f1636l) != null) {
            velocityTracker.clear();
        }
        if (i11 == 1) {
            m1115y(i11);
            edgeEffect2.onRelease();
            edgeEffect.onRelease();
        }
        return i14;
    }

    public final boolean m1111u(EdgeEffect edgeEffect, int i6) {
        if (i6 > 0) {
            return true;
        }
        float fM3495m = AbstractC1466d.m3495m(edgeEffect) * getHeight();
        float fAbs = Math.abs(-i6) * 0.35f;
        float f = this.f1625a * 0.015f;
        double dLog = Math.log(fAbs / f);
        double d = f1620C;
        return ((float) (Math.exp((d / (d - 1.0d)) * dLog) * ((double) f))) < fM3495m;
    }

    public final void m1112v(int i6, int i10, boolean z7) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.f1626b > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            this.f1628d.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i10 + scrollY, Math.max(0, height - height2))) - scrollY, 250);
            if (z7) {
                m1113w(2, 1);
            } else {
                m1115y(1);
            }
            this.f1646v = getScrollY();
            postInvalidateOnAnimation();
        } else {
            if (!this.f1628d.isFinished()) {
                this.f1628d.abortAnimation();
                m1115y(1);
            }
            scrollBy(i6, i10);
        }
        this.f1626b = AnimationUtils.currentAnimationTimeMillis();
    }

    public final boolean m1113w(int i6, int i10) {
        return this.f1649y.m6286g(2, i10);
    }

    public final boolean m1114x(MotionEvent motionEvent) {
        boolean z7;
        EdgeEffect edgeEffect = this.f1629e;
        if (AbstractC1466d.m3495m(edgeEffect) != 0.0f) {
            AbstractC1466d.m3506z(edgeEffect, 0.0f, motionEvent.getX() / getWidth());
            z7 = true;
        } else {
            z7 = false;
        }
        EdgeEffect edgeEffect2 = this.f1630f;
        if (AbstractC1466d.m3495m(edgeEffect2) == 0.0f) {
            return z7;
        }
        AbstractC1466d.m3506z(edgeEffect2, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
        return true;
    }

    public final void m1115y(int i6) {
        this.f1649y.m6287h(i6);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f1627c = new Rect();
        this.f1632h = true;
        this.f1633i = false;
        this.f1634j = null;
        this.f1635k = false;
        this.f1638n = true;
        this.f1642r = -1;
        this.f1643s = new int[2];
        this.f1644t = new int[2];
        this.f1624B = new C3121h(getContext(), new C0019b(7, this));
        int i10 = Build.VERSION.SDK_INT;
        this.f1629e = i10 >= 31 ? AbstractC0373f.m1123a(context, attributeSet) : new EdgeEffect(context);
        this.f1630f = i10 >= 31 ? AbstractC0373f.m1123a(context, attributeSet) : new EdgeEffect(context);
        this.f1625a = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        this.f1628d = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f1639o = viewConfiguration.getScaledTouchSlop();
        this.f1640p = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1641q = viewConfiguration.getScaledMaximumFlingVelocity();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1622E, i6, 0);
        setFillViewport(typedArrayObtainStyledAttributes.getBoolean(0, false));
        typedArrayObtainStyledAttributes.recycle();
        this.f1648x = new C3151r();
        this.f1649y = new C3142o(this);
        setNestedScrollingEnabled(true);
        AbstractC3155s0.m6347q(this, f1621D);
    }

    @Override
    public final void addView(View view, int i6) {
        if (getChildCount() <= 0) {
            super.addView(view, i6);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override
    public final void addView(View view, int i6, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i6, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
}
