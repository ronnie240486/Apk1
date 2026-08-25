package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import java.util.WeakHashMap;
import p002a1.C0026b;
import p045e.AbstractC2341a;
import p138n0.AbstractC3155s0;

public class LinearLayoutCompat extends ViewGroup {

    public boolean f673a;

    public int f674b;

    public int f675c;

    public int f676d;

    public int f677e;

    public int f678f;

    public float f679g;

    public boolean f680h;

    public int[] f681i;

    public int[] f682j;

    public Drawable f683k;

    public int f684l;

    public int f685m;

    public int f686n;

    public int f687o;

    public static class LayoutParams extends LinearLayout.LayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public final void m573f(Canvas canvas, int i6) {
        this.f683k.setBounds(getPaddingLeft() + this.f687o, i6, (getWidth() - getPaddingRight()) - this.f687o, this.f685m + i6);
        this.f683k.draw(canvas);
    }

    public final void m574g(Canvas canvas, int i6) {
        this.f683k.setBounds(i6, getPaddingTop() + this.f687o, this.f684l + i6, (getHeight() - getPaddingBottom()) - this.f687o);
        this.f683k.draw(canvas);
    }

    @Override
    public int getBaseline() {
        int i6;
        if (this.f674b < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i10 = this.f674b;
        if (childCount <= i10) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i10);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.f674b == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int bottom = this.f675c;
        if (this.f676d == 1 && (i6 = this.f677e & 112) != 48) {
            if (i6 == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f678f) / 2;
            } else if (i6 == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.f678f;
            }
        }
        return bottom + ((LinearLayout.LayoutParams) ((LayoutParams) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.f674b;
    }

    public Drawable getDividerDrawable() {
        return this.f683k;
    }

    public int getDividerPadding() {
        return this.f687o;
    }

    public int getDividerWidth() {
        return this.f684l;
    }

    public int getGravity() {
        return this.f677e;
    }

    public int getOrientation() {
        return this.f676d;
    }

    public int getShowDividers() {
        return this.f686n;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f679g;
    }

    @Override
    public LayoutParams generateDefaultLayoutParams() {
        int i6 = this.f676d;
        if (i6 == 0) {
            return new LayoutParams(-2, -2);
        }
        if (i6 == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public final boolean m575k(int i6) {
        if (i6 == 0) {
            return (this.f686n & 1) != 0;
        }
        if (i6 == getChildCount()) {
            return (this.f686n & 4) != 0;
        }
        if ((this.f686n & 2) == 0) {
            return false;
        }
        for (int i10 = i6 - 1; i10 >= 0; i10--) {
            if (getChildAt(i10).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    @Override
    public final void onDraw(Canvas canvas) {
        int right;
        int left;
        int i6;
        int bottom;
        if (this.f683k == null) {
            return;
        }
        int i10 = 0;
        if (this.f676d == 1) {
            int virtualChildCount = getVirtualChildCount();
            while (i10 < virtualChildCount) {
                View childAt = getChildAt(i10);
                if (childAt != null && childAt.getVisibility() != 8 && m575k(i10)) {
                    m573f(canvas, (childAt.getTop() - ((LinearLayout.LayoutParams) ((LayoutParams) childAt.getLayoutParams())).topMargin) - this.f685m);
                }
                i10++;
            }
            if (m575k(virtualChildCount)) {
                View childAt2 = getChildAt(virtualChildCount - 1);
                if (childAt2 == null) {
                    bottom = (getHeight() - getPaddingBottom()) - this.f685m;
                } else {
                    bottom = childAt2.getBottom() + ((LinearLayout.LayoutParams) ((LayoutParams) childAt2.getLayoutParams())).bottomMargin;
                }
                m573f(canvas, bottom);
                return;
            }
            return;
        }
        int virtualChildCount2 = getVirtualChildCount();
        boolean zM648a = AbstractC0189c4.m648a(this);
        while (i10 < virtualChildCount2) {
            View childAt3 = getChildAt(i10);
            if (childAt3 != null && childAt3.getVisibility() != 8 && m575k(i10)) {
                LayoutParams layoutParams = (LayoutParams) childAt3.getLayoutParams();
                m574g(canvas, zM648a ? childAt3.getRight() + ((LinearLayout.LayoutParams) layoutParams).rightMargin : (childAt3.getLeft() - ((LinearLayout.LayoutParams) layoutParams).leftMargin) - this.f684l);
            }
            i10++;
        }
        if (m575k(virtualChildCount2)) {
            View childAt4 = getChildAt(virtualChildCount2 - 1);
            if (childAt4 != null) {
                LayoutParams layoutParams2 = (LayoutParams) childAt4.getLayoutParams();
                if (zM648a) {
                    left = childAt4.getLeft() - ((LinearLayout.LayoutParams) layoutParams2).leftMargin;
                    i6 = this.f684l;
                    right = left - i6;
                } else {
                    right = childAt4.getRight() + ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                }
            } else if (zM648a) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i6 = this.f684l;
                right = left - i6;
            }
            m574g(canvas, right);
        }
    }

    @Override
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override
    public void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        int paddingLeft;
        int i13;
        int i14;
        int i15;
        int i16;
        int baseline;
        int i17;
        int i18;
        int measuredHeight;
        int paddingTop;
        int i19;
        int i20;
        int i21;
        int i22 = 8;
        if (this.f676d == 1) {
            int paddingLeft2 = getPaddingLeft();
            int i23 = i11 - i6;
            int paddingRight = i23 - getPaddingRight();
            int paddingRight2 = (i23 - paddingLeft2) - getPaddingRight();
            int virtualChildCount = getVirtualChildCount();
            int i24 = this.f677e;
            int i25 = i24 & 112;
            int i26 = 8388615 & i24;
            if (i25 != 16) {
                paddingTop = i25 != 80 ? getPaddingTop() : ((getPaddingTop() + i12) - i10) - this.f678f;
            } else {
                paddingTop = getPaddingTop() + (((i12 - i10) - this.f678f) / 2);
            }
            int i27 = 0;
            while (i27 < virtualChildCount) {
                View childAt = getChildAt(i27);
                if (childAt != null && childAt.getVisibility() != i22) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight2 = childAt.getMeasuredHeight();
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    int i28 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                    if (i28 < 0) {
                        i28 = i26;
                    }
                    WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                    int absoluteGravity = Gravity.getAbsoluteGravity(i28, getLayoutDirection()) & 7;
                    if (absoluteGravity != 1) {
                        if (absoluteGravity != 5) {
                            i21 = ((LinearLayout.LayoutParams) layoutParams).leftMargin + paddingLeft2;
                        } else {
                            i19 = paddingRight - measuredWidth;
                            i20 = ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                        }
                        if (m575k(i27)) {
                            paddingTop += this.f685m;
                        }
                        int i29 = paddingTop + ((LinearLayout.LayoutParams) layoutParams).topMargin;
                        childAt.layout(i21, i29, measuredWidth + i21, i29 + measuredHeight2);
                        paddingTop = measuredHeight2 + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + i29;
                    } else {
                        i19 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft2 + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                        i20 = ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                    }
                    i21 = i19 - i20;
                    if (m575k(i27)) {
                        paddingTop += this.f685m;
                    }
                    int i210 = paddingTop + ((LinearLayout.LayoutParams) layoutParams).topMargin;
                    childAt.layout(i21, i210, measuredWidth + i21, i210 + measuredHeight2);
                    paddingTop = measuredHeight2 + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + i210;
                }
                i27++;
                i22 = 8;
            }
            return;
        }
        boolean zM648a = AbstractC0189c4.m648a(this);
        int paddingTop2 = getPaddingTop();
        int i30 = i12 - i10;
        int paddingBottom = i30 - getPaddingBottom();
        int paddingBottom2 = (i30 - paddingTop2) - getPaddingBottom();
        int virtualChildCount2 = getVirtualChildCount();
        int i31 = this.f677e;
        int i32 = 8388615 & i31;
        int i33 = i31 & 112;
        boolean z10 = this.f673a;
        int[] iArr = this.f681i;
        int[] iArr2 = this.f682j;
        WeakHashMap weakHashMap2 = AbstractC3155s0.f10642a;
        int absoluteGravity2 = Gravity.getAbsoluteGravity(i32, getLayoutDirection());
        if (absoluteGravity2 != 1) {
            paddingLeft = absoluteGravity2 != 5 ? getPaddingLeft() : ((getPaddingLeft() + i11) - i6) - this.f678f;
        } else {
            paddingLeft = getPaddingLeft() + (((i11 - i6) - this.f678f) / 2);
        }
        if (zM648a) {
            i13 = virtualChildCount2 - 1;
            i14 = -1;
        } else {
            i13 = 0;
            i14 = 1;
        }
        int i34 = 0;
        while (i34 < virtualChildCount2) {
            int i35 = (i14 * i34) + i13;
            View childAt2 = getChildAt(i35);
            if (childAt2 == null) {
                i14 = i14;
                i15 = virtualChildCount2;
                i33 = i33;
                i16 = 1;
            } else {
                if (childAt2.getVisibility() != 8) {
                    int measuredWidth2 = childAt2.getMeasuredWidth();
                    int measuredHeight3 = childAt2.getMeasuredHeight();
                    LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                    if (z10) {
                        i15 = virtualChildCount2;
                        baseline = ((LinearLayout.LayoutParams) layoutParams2).height != -1 ? childAt2.getBaseline() : -1;
                        i17 = ((LinearLayout.LayoutParams) layoutParams2).gravity;
                        if (i17 < 0) {
                            i17 = i33;
                        }
                        i18 = i17 & 112;
                        if (i18 != 16) {
                            measuredHeight = ((((paddingBottom2 - measuredHeight3) / 2) + paddingTop2) + ((LinearLayout.LayoutParams) layoutParams2).topMargin) - ((LinearLayout.LayoutParams) layoutParams2).bottomMargin;
                        } else if (i18 != 48) {
                            measuredHeight = ((LinearLayout.LayoutParams) layoutParams2).topMargin + paddingTop2;
                            if (baseline != -1) {
                                measuredHeight = (iArr[1] - baseline) + measuredHeight;
                            }
                        } else if (i18 != 80) {
                            measuredHeight = paddingTop2;
                        } else {
                            measuredHeight = (paddingBottom - measuredHeight3) - ((LinearLayout.LayoutParams) layoutParams2).bottomMargin;
                            if (baseline != -1) {
                                measuredHeight -= iArr2[2] - (childAt2.getMeasuredHeight() - baseline);
                            }
                        }
                        if (m575k(i35)) {
                            paddingLeft += this.f684l;
                        }
                        int i36 = paddingLeft + ((LinearLayout.LayoutParams) layoutParams2).leftMargin;
                        childAt2.layout(i36, measuredHeight, i36 + measuredWidth2, measuredHeight + measuredHeight3);
                        paddingLeft = measuredWidth2 + ((LinearLayout.LayoutParams) layoutParams2).rightMargin + i36;
                    } else {
                        i15 = virtualChildCount2;
                    }
                    i17 = ((LinearLayout.LayoutParams) layoutParams2).gravity;
                    if (i17 < 0) {
                        i17 = i33;
                    }
                    i18 = i17 & 112;
                    if (i18 != 16) {
                        measuredHeight = ((((paddingBottom2 - measuredHeight3) / 2) + paddingTop2) + ((LinearLayout.LayoutParams) layoutParams2).topMargin) - ((LinearLayout.LayoutParams) layoutParams2).bottomMargin;
                    } else if (i18 != 48) {
                        measuredHeight = ((LinearLayout.LayoutParams) layoutParams2).topMargin + paddingTop2;
                        if (baseline != -1) {
                            measuredHeight = (iArr[1] - baseline) + measuredHeight;
                        }
                    } else if (i18 != 80) {
                        measuredHeight = paddingTop2;
                    } else {
                        measuredHeight = (paddingBottom - measuredHeight3) - ((LinearLayout.LayoutParams) layoutParams2).bottomMargin;
                        if (baseline != -1) {
                            measuredHeight -= iArr2[2] - (childAt2.getMeasuredHeight() - baseline);
                        }
                    }
                    if (m575k(i35)) {
                        paddingLeft += this.f684l;
                    }
                    int i37 = paddingLeft + ((LinearLayout.LayoutParams) layoutParams2).leftMargin;
                    childAt2.layout(i37, measuredHeight, i37 + measuredWidth2, measuredHeight + measuredHeight3);
                    paddingLeft = measuredWidth2 + ((LinearLayout.LayoutParams) layoutParams2).rightMargin + i37;
                } else {
                    i15 = virtualChildCount2;
                }
                i16 = 1;
            }
            i34 += i16;
            i13 = i13;
            i14 = i14;
            virtualChildCount2 = i15;
            i33 = i33;
        }
    }

    @Override
    public void onMeasure(int i6, int i10) {
        char c5;
        int iMax;
        int i11;
        float f;
        int i12;
        int i13;
        int i14;
        char c8;
        int i15;
        View childAt;
        int i16;
        int i17;
        int i18;
        int baseline;
        int i19;
        int iMakeMeasureSpec;
        int i20;
        View childAt2;
        LayoutParams layoutParams;
        int i21;
        View childAt3;
        LayoutParams layoutParams2;
        float f3;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        boolean z7;
        boolean z10;
        LayoutParams layoutParams3;
        int measuredWidth;
        boolean z11;
        int i28;
        boolean z12;
        int i29;
        int measuredHeight;
        boolean z13;
        int baseline2;
        int i30;
        int i31;
        boolean z14;
        int i32;
        int i33;
        LayoutParams layoutParams4;
        boolean z15;
        int i34;
        boolean z16;
        int iMax2;
        int i35 = -2;
        int i36 = 1073741824;
        int i37 = 8;
        int i38 = Integer.MIN_VALUE;
        float f4 = 0.0f;
        if (this.f676d == 1) {
            this.f678f = 0;
            int virtualChildCount = getVirtualChildCount();
            int mode = View.MeasureSpec.getMode(i6);
            int mode2 = View.MeasureSpec.getMode(i10);
            int i39 = this.f674b;
            boolean z17 = this.f680h;
            int i40 = 0;
            float f5 = 0.0f;
            int iMax3 = 0;
            int iMax4 = 0;
            boolean z18 = false;
            int iMax5 = 0;
            int i41 = 0;
            int i42 = 0;
            boolean z19 = true;
            boolean z20 = false;
            while (i40 < virtualChildCount) {
                View childAt4 = getChildAt(i40);
                if (childAt4 == null) {
                    this.f678f = this.f678f;
                } else {
                    if (childAt4.getVisibility() != i37) {
                        if (m575k(i40)) {
                            this.f678f += this.f685m;
                        }
                        LayoutParams layoutParams5 = (LayoutParams) childAt4.getLayoutParams();
                        float f10 = ((LinearLayout.LayoutParams) layoutParams5).weight;
                        f5 += f10;
                        if (mode2 == i36 && ((LinearLayout.LayoutParams) layoutParams5).height == 0 && f10 > f4) {
                            int i43 = this.f678f;
                            this.f678f = Math.max(i43, ((LinearLayout.LayoutParams) layoutParams5).topMargin + i43 + ((LinearLayout.LayoutParams) layoutParams5).bottomMargin);
                            layoutParams4 = layoutParams5;
                            z15 = true;
                        } else {
                            if (((LinearLayout.LayoutParams) layoutParams5).height != 0 || f10 <= f4) {
                                i33 = Integer.MIN_VALUE;
                            } else {
                                ((LinearLayout.LayoutParams) layoutParams5).height = i35;
                                i33 = 0;
                            }
                            int i44 = f5 == f4 ? this.f678f : 0;
                            layoutParams4 = layoutParams5;
                            measureChildWithMargins(childAt4, i6, 0, i10, i44);
                            if (i33 != i38) {
                                ((LinearLayout.LayoutParams) layoutParams4).height = i33;
                            }
                            int measuredHeight2 = childAt4.getMeasuredHeight();
                            int i45 = this.f678f;
                            this.f678f = Math.max(i45, i45 + measuredHeight2 + ((LinearLayout.LayoutParams) layoutParams4).topMargin + ((LinearLayout.LayoutParams) layoutParams4).bottomMargin);
                            int i46 = iMax5;
                            if (z17) {
                                iMax5 = Math.max(measuredHeight2, i46);
                            }
                            z15 = z18;
                        }
                        if (i39 >= 0 && i39 == i40 + 1) {
                            this.f675c = this.f678f;
                        }
                        if (i40 < i39 && ((LinearLayout.LayoutParams) layoutParams4).weight > 0.0f) {
                            throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                        }
                        i34 = mode;
                        if (i34 == 1073741824 || ((LinearLayout.LayoutParams) layoutParams4).width != -1) {
                            z16 = false;
                        } else {
                            z16 = true;
                            z20 = true;
                        }
                        int i47 = ((LinearLayout.LayoutParams) layoutParams4).leftMargin + ((LinearLayout.LayoutParams) layoutParams4).rightMargin;
                        int measuredWidth2 = childAt4.getMeasuredWidth() + i47;
                        iMax2 = Math.max(i41, measuredWidth2);
                        int iCombineMeasuredStates = View.combineMeasuredStates(i42, childAt4.getMeasuredState());
                        boolean z21 = z19 && ((LinearLayout.LayoutParams) layoutParams4).width == -1;
                        if (((LinearLayout.LayoutParams) layoutParams4).weight > 0.0f) {
                            if (!z16) {
                                i47 = measuredWidth2;
                            }
                            iMax4 = Math.max(iMax4, i47);
                        } else {
                            int i48 = iMax4;
                            if (!z16) {
                                i47 = measuredWidth2;
                            }
                            iMax3 = Math.max(iMax3, i47);
                            iMax4 = i48;
                        }
                        z18 = z15;
                        i42 = iCombineMeasuredStates;
                        z19 = z21;
                    }
                    i40++;
                    mode = i34;
                    i41 = iMax2;
                    i39 = i39;
                    mode2 = mode2;
                    virtualChildCount = virtualChildCount;
                    i35 = -2;
                    i36 = 1073741824;
                    i37 = 8;
                    i38 = Integer.MIN_VALUE;
                    f4 = 0.0f;
                }
                i39 = i39;
                mode2 = mode2;
                i34 = mode;
                virtualChildCount = virtualChildCount;
                iMax2 = i41;
                i40++;
                mode = i34;
                i41 = iMax2;
                i39 = i39;
                mode2 = mode2;
                virtualChildCount = virtualChildCount;
                i35 = -2;
                i36 = 1073741824;
                i37 = 8;
                i38 = Integer.MIN_VALUE;
                f4 = 0.0f;
            }
            int i49 = mode2;
            int i50 = mode;
            int i51 = virtualChildCount;
            int iMax6 = iMax3;
            int i52 = iMax4;
            int i53 = iMax5;
            int i54 = i41;
            int iCombineMeasuredStates2 = i42;
            if (this.f678f > 0 && m575k(i51)) {
                this.f678f += this.f685m;
            }
            int i55 = i49;
            if (z17 && (i55 == Integer.MIN_VALUE || i55 == 0)) {
                this.f678f = 0;
                for (int i56 = 0; i56 < i51; i56++) {
                    View childAt5 = getChildAt(i56);
                    if (childAt5 == null) {
                        this.f678f = this.f678f;
                    } else if (childAt5.getVisibility() != 8) {
                        LayoutParams layoutParams6 = (LayoutParams) childAt5.getLayoutParams();
                        int i57 = this.f678f;
                        this.f678f = Math.max(i57, i57 + i53 + ((LinearLayout.LayoutParams) layoutParams6).topMargin + ((LinearLayout.LayoutParams) layoutParams6).bottomMargin);
                    }
                }
            }
            int paddingBottom = getPaddingBottom() + getPaddingTop() + this.f678f;
            this.f678f = paddingBottom;
            int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i10, 0);
            int i58 = (16777215 & iResolveSizeAndState) - this.f678f;
            if (z18 || (i58 != 0 && f5 > 0.0f)) {
                float f11 = this.f679g;
                if (f11 > 0.0f) {
                    f5 = f11;
                }
                this.f678f = 0;
                int i59 = 0;
                while (i59 < i51) {
                    View childAt6 = getChildAt(i59);
                    if (childAt6.getVisibility() == 8) {
                        i30 = i55;
                    } else {
                        LayoutParams layoutParams7 = (LayoutParams) childAt6.getLayoutParams();
                        float f12 = ((LinearLayout.LayoutParams) layoutParams7).weight;
                        if (f12 > 0.0f) {
                            int i60 = (int) ((i58 * f12) / f5);
                            f5 -= f12;
                            int i61 = i58 - i60;
                            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i6, getPaddingRight() + getPaddingLeft() + ((LinearLayout.LayoutParams) layoutParams7).leftMargin + ((LinearLayout.LayoutParams) layoutParams7).rightMargin, ((LinearLayout.LayoutParams) layoutParams7).width);
                            if (((LinearLayout.LayoutParams) layoutParams7).height == 0) {
                                i32 = 1073741824;
                                if (i55 == 1073741824) {
                                    if (i60 <= 0) {
                                        i60 = 0;
                                    }
                                    childAt6.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i60, 1073741824));
                                }
                                iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, childAt6.getMeasuredState() & (-256));
                                i58 = i61;
                            } else {
                                i32 = 1073741824;
                            }
                            int measuredHeight3 = childAt6.getMeasuredHeight() + i60;
                            if (measuredHeight3 < 0) {
                                measuredHeight3 = 0;
                            }
                            childAt6.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight3, i32));
                            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, childAt6.getMeasuredState() & (-256));
                            i58 = i61;
                        }
                        int i62 = ((LinearLayout.LayoutParams) layoutParams7).leftMargin + ((LinearLayout.LayoutParams) layoutParams7).rightMargin;
                        int measuredWidth3 = childAt6.getMeasuredWidth() + i62;
                        int iMax7 = Math.max(i54, measuredWidth3);
                        if (i50 != 1073741824) {
                            i30 = i55;
                            i31 = -1;
                            if (((LinearLayout.LayoutParams) layoutParams7).width != -1) {
                            }
                            iMax6 = Math.max(iMax6, i62);
                            if (z19 || ((LinearLayout.LayoutParams) layoutParams7).width != i31) {
                                z14 = false;
                            } else {
                                z14 = true;
                            }
                            int i63 = this.f678f;
                            this.f678f = Math.max(i63, childAt6.getMeasuredHeight() + i63 + ((LinearLayout.LayoutParams) layoutParams7).topMargin + ((LinearLayout.LayoutParams) layoutParams7).bottomMargin);
                            z19 = z14;
                            i54 = iMax7;
                        } else {
                            i30 = i55;
                            i31 = -1;
                        }
                        i62 = measuredWidth3;
                        iMax6 = Math.max(iMax6, i62);
                        if (z19) {
                            z14 = false;
                        } else {
                            z14 = false;
                        }
                        int i64 = this.f678f;
                        this.f678f = Math.max(i64, childAt6.getMeasuredHeight() + i64 + ((LinearLayout.LayoutParams) layoutParams7).topMargin + ((LinearLayout.LayoutParams) layoutParams7).bottomMargin);
                        z19 = z14;
                        i54 = iMax7;
                    }
                    i59++;
                    i55 = i30;
                }
                this.f678f = getPaddingBottom() + getPaddingTop() + this.f678f;
            } else {
                iMax6 = Math.max(iMax6, i52);
                if (z17 && i55 != 1073741824) {
                    for (int i65 = 0; i65 < i51; i65++) {
                        View childAt7 = getChildAt(i65);
                        if (childAt7 != null && childAt7.getVisibility() != 8 && ((LinearLayout.LayoutParams) ((LayoutParams) childAt7.getLayoutParams())).weight > 0.0f) {
                            childAt7.measure(View.MeasureSpec.makeMeasureSpec(childAt7.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i53, 1073741824));
                        }
                    }
                }
            }
            int i66 = i54;
            if (z19 || i50 == 1073741824) {
                iMax6 = i66;
            }
            setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + iMax6, getSuggestedMinimumWidth()), i6, iCombineMeasuredStates2), iResolveSizeAndState);
            if (z20) {
                int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
                for (int i67 = 0; i67 < i51; i67++) {
                    View childAt8 = getChildAt(i67);
                    if (childAt8.getVisibility() != 8) {
                        LayoutParams layoutParams8 = (LayoutParams) childAt8.getLayoutParams();
                        if (((LinearLayout.LayoutParams) layoutParams8).width == -1) {
                            int i68 = ((LinearLayout.LayoutParams) layoutParams8).height;
                            ((LinearLayout.LayoutParams) layoutParams8).height = childAt8.getMeasuredHeight();
                            measureChildWithMargins(childAt8, iMakeMeasureSpec2, 0, i10, 0);
                            ((LinearLayout.LayoutParams) layoutParams8).height = i68;
                        }
                    }
                }
                return;
            }
            return;
        }
        this.f678f = 0;
        int virtualChildCount2 = getVirtualChildCount();
        int mode3 = View.MeasureSpec.getMode(i6);
        int mode4 = View.MeasureSpec.getMode(i10);
        if (this.f681i == null || this.f682j == null) {
            this.f681i = new int[4];
            this.f682j = new int[4];
        }
        int[] iArr = this.f681i;
        int[] iArr2 = this.f682j;
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        boolean z22 = this.f673a;
        boolean z23 = this.f680h;
        boolean z24 = mode3 == 1073741824;
        int iMax8 = 0;
        float f13 = 0.0f;
        int i69 = 0;
        int i70 = 0;
        int i71 = 0;
        int iMax9 = 0;
        int iMax10 = 0;
        boolean z25 = true;
        boolean z26 = false;
        boolean z27 = false;
        while (i70 < virtualChildCount2) {
            View childAt9 = getChildAt(i70);
            if (childAt9 == null) {
                this.f678f = this.f678f;
                i27 = i70;
                z7 = z23;
                z10 = z22;
            } else {
                int i72 = iMax8;
                int i73 = i69;
                if (childAt9.getVisibility() == 8) {
                    z10 = z22;
                    iMax8 = i72;
                    i69 = i73;
                    i27 = i70;
                    z7 = z23;
                } else {
                    if (m575k(i70)) {
                        this.f678f += this.f684l;
                    }
                    LayoutParams layoutParams9 = (LayoutParams) childAt9.getLayoutParams();
                    float f14 = ((LinearLayout.LayoutParams) layoutParams9).weight;
                    float f15 = f13 + f14;
                    if (mode3 == 1073741824 && ((LinearLayout.LayoutParams) layoutParams9).width == 0 && f14 > 0.0f) {
                        if (z24) {
                            this.f678f = ((LinearLayout.LayoutParams) layoutParams9).leftMargin + ((LinearLayout.LayoutParams) layoutParams9).rightMargin + this.f678f;
                        } else {
                            int i74 = this.f678f;
                            this.f678f = Math.max(i74, ((LinearLayout.LayoutParams) layoutParams9).leftMargin + i74 + ((LinearLayout.LayoutParams) layoutParams9).rightMargin);
                        }
                        if (z22) {
                            int iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(0, 0);
                            childAt9.measure(iMakeMeasureSpec3, iMakeMeasureSpec3);
                            layoutParams3 = layoutParams9;
                            i24 = i72;
                            i25 = i73;
                            i27 = i70;
                            z7 = z23;
                            z10 = z22;
                        } else {
                            layoutParams3 = layoutParams9;
                            i24 = i72;
                            i25 = i73;
                            i27 = i70;
                            i28 = 1073741824;
                            z7 = z23;
                            z10 = z22;
                            z11 = true;
                        }
                        if (mode4 == i28 && ((LinearLayout.LayoutParams) layoutParams3).height == -1) {
                            z12 = true;
                            z27 = true;
                        } else {
                            z12 = false;
                        }
                        i29 = ((LinearLayout.LayoutParams) layoutParams3).topMargin + ((LinearLayout.LayoutParams) layoutParams3).bottomMargin;
                        measuredHeight = childAt9.getMeasuredHeight() + i29;
                        int iCombineMeasuredStates3 = View.combineMeasuredStates(i71, childAt9.getMeasuredState());
                        if (!z10 && (baseline2 = childAt9.getBaseline()) != -1) {
                            int i75 = ((LinearLayout.LayoutParams) layoutParams3).gravity;
                            if (i75 < 0) {
                                i75 = this.f677e;
                            }
                            int i76 = (((i75 & 112) >> 4) & (-2)) >> 1;
                            iArr[i76] = Math.max(iArr[i76], baseline2);
                            iArr2[i76] = Math.max(iArr2[i76], measuredHeight - baseline2);
                        }
                        int iMax11 = Math.max(i25, measuredHeight);
                        if (z25 || ((LinearLayout.LayoutParams) layoutParams3).height != -1) {
                            z13 = false;
                        } else {
                            z13 = true;
                        }
                        if (((LinearLayout.LayoutParams) layoutParams3).weight > 0.0f) {
                            if (z12) {
                                measuredHeight = i29;
                            }
                            iMax10 = Math.max(iMax10, measuredHeight);
                            iMax8 = i24;
                        } else {
                            if (z12) {
                                measuredHeight = i29;
                            }
                            iMax8 = Math.max(i24, measuredHeight);
                        }
                        i69 = iMax11;
                        i71 = iCombineMeasuredStates3;
                        z26 = z11;
                        z25 = z13;
                        f13 = f15;
                    } else {
                        int i77 = i70;
                        if (((LinearLayout.LayoutParams) layoutParams9).width == 0) {
                            f3 = 0.0f;
                            if (f14 > 0.0f) {
                                ((LinearLayout.LayoutParams) layoutParams9).width = -2;
                                i22 = 0;
                            }
                            if (f15 == f3) {
                                i23 = this.f678f;
                            } else {
                                i23 = 0;
                            }
                            i24 = i72;
                            i25 = i73;
                            i26 = i22;
                            i27 = i77;
                            z7 = z23;
                            z10 = z22;
                            measureChildWithMargins(childAt9, i6, i23, i10, 0);
                            if (i26 != Integer.MIN_VALUE) {
                                layoutParams3 = layoutParams9;
                                ((LinearLayout.LayoutParams) layoutParams3).width = i26;
                            } else {
                                layoutParams3 = layoutParams9;
                            }
                            measuredWidth = childAt9.getMeasuredWidth();
                            if (z24) {
                                this.f678f = ((LinearLayout.LayoutParams) layoutParams3).leftMargin + measuredWidth + ((LinearLayout.LayoutParams) layoutParams3).rightMargin + this.f678f;
                            } else {
                                int i78 = this.f678f;
                                this.f678f = Math.max(i78, i78 + measuredWidth + ((LinearLayout.LayoutParams) layoutParams3).leftMargin + ((LinearLayout.LayoutParams) layoutParams3).rightMargin);
                            }
                            if (z7) {
                                iMax9 = Math.max(measuredWidth, iMax9);
                            }
                        } else {
                            f3 = 0.0f;
                        }
                        i22 = Integer.MIN_VALUE;
                        if (f15 == f3) {
                            i23 = this.f678f;
                        } else {
                            i23 = 0;
                        }
                        i24 = i72;
                        i25 = i73;
                        i26 = i22;
                        i27 = i77;
                        z7 = z23;
                        z10 = z22;
                        measureChildWithMargins(childAt9, i6, i23, i10, 0);
                        if (i26 != Integer.MIN_VALUE) {
                            layoutParams3 = layoutParams9;
                            ((LinearLayout.LayoutParams) layoutParams3).width = i26;
                        } else {
                            layoutParams3 = layoutParams9;
                        }
                        measuredWidth = childAt9.getMeasuredWidth();
                        if (z24) {
                            this.f678f = ((LinearLayout.LayoutParams) layoutParams3).leftMargin + measuredWidth + ((LinearLayout.LayoutParams) layoutParams3).rightMargin + this.f678f;
                        } else {
                            int i79 = this.f678f;
                            this.f678f = Math.max(i79, i79 + measuredWidth + ((LinearLayout.LayoutParams) layoutParams3).leftMargin + ((LinearLayout.LayoutParams) layoutParams3).rightMargin);
                        }
                        if (z7) {
                            iMax9 = Math.max(measuredWidth, iMax9);
                        }
                    }
                    z11 = z26;
                    i28 = 1073741824;
                    if (mode4 == i28) {
                        z12 = false;
                    } else {
                        z12 = false;
                    }
                    i29 = ((LinearLayout.LayoutParams) layoutParams3).topMargin + ((LinearLayout.LayoutParams) layoutParams3).bottomMargin;
                    measuredHeight = childAt9.getMeasuredHeight() + i29;
                    int iCombineMeasuredStates4 = View.combineMeasuredStates(i71, childAt9.getMeasuredState());
                    if (!z10) {
                    }
                    int iMax12 = Math.max(i25, measuredHeight);
                    if (z25) {
                        z13 = false;
                    } else {
                        z13 = false;
                    }
                    if (((LinearLayout.LayoutParams) layoutParams3).weight > 0.0f) {
                        if (z12) {
                            measuredHeight = i29;
                        }
                        iMax10 = Math.max(iMax10, measuredHeight);
                        iMax8 = i24;
                    } else {
                        if (z12) {
                            measuredHeight = i29;
                        }
                        iMax8 = Math.max(i24, measuredHeight);
                    }
                    i69 = iMax12;
                    i71 = iCombineMeasuredStates4;
                    z26 = z11;
                    z25 = z13;
                    f13 = f15;
                }
            }
            i70 = i27 + 1;
            z23 = z7;
            z22 = z10;
        }
        int i80 = i69;
        boolean z28 = z23;
        boolean z29 = z22;
        if (this.f678f > 0 && m575k(virtualChildCount2)) {
            this.f678f += this.f684l;
        }
        int i81 = iArr[1];
        if (i81 == -1 && iArr[0] == -1 && iArr[2] == -1) {
            c5 = 3;
            if (iArr[3] == -1) {
                iMax = i80;
            }
            if (z28 && (mode3 == Integer.MIN_VALUE || mode3 == 0)) {
                this.f678f = 0;
                for (i21 = 0; i21 < virtualChildCount2; i21++) {
                    childAt3 = getChildAt(i21);
                    if (childAt3 == null) {
                        this.f678f = this.f678f;
                    } else if (childAt3.getVisibility() == 8) {
                        layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                        if (z24) {
                            this.f678f = ((LinearLayout.LayoutParams) layoutParams2).leftMargin + iMax9 + ((LinearLayout.LayoutParams) layoutParams2).rightMargin + this.f678f;
                        } else {
                            int i82 = this.f678f;
                            this.f678f = Math.max(i82, i82 + iMax9 + ((LinearLayout.LayoutParams) layoutParams2).leftMargin + ((LinearLayout.LayoutParams) layoutParams2).rightMargin);
                        }
                    }
                }
            }
            int paddingRight = getPaddingRight() + getPaddingLeft() + this.f678f;
            this.f678f = paddingRight;
            int iResolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i6, 0);
            i11 = (16777215 & iResolveSizeAndState2) - this.f678f;
            if (!z26 || (i11 != 0 && f13 > 0.0f)) {
                f = this.f679g;
                if (f > 0.0f) {
                    f13 = f;
                }
                iArr[3] = -1;
                iArr[2] = -1;
                iArr[1] = -1;
                iArr[0] = -1;
                iArr2[3] = -1;
                iArr2[2] = -1;
                iArr2[1] = -1;
                iArr2[0] = -1;
                this.f678f = 0;
                int iCombineMeasuredStates5 = i71;
                iMax = -1;
                i12 = 0;
                while (i12 < virtualChildCount2) {
                    childAt = getChildAt(i12);
                    if (childAt != null || childAt.getVisibility() == 8) {
                        i16 = i11;
                        virtualChildCount2 = virtualChildCount2;
                    } else {
                        LayoutParams layoutParams10 = (LayoutParams) childAt.getLayoutParams();
                        float f16 = ((LinearLayout.LayoutParams) layoutParams10).weight;
                        if (f16 > 0.0f) {
                            int i83 = (int) ((i11 * f16) / f13);
                            float f17 = f13 - f16;
                            int i84 = i11 - i83;
                            int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i10, getPaddingBottom() + getPaddingTop() + ((LinearLayout.LayoutParams) layoutParams10).topMargin + ((LinearLayout.LayoutParams) layoutParams10).bottomMargin, ((LinearLayout.LayoutParams) layoutParams10).height);
                            if (((LinearLayout.LayoutParams) layoutParams10).width == 0) {
                                i19 = 1073741824;
                                if (mode3 == 1073741824) {
                                    if (i83 <= 0) {
                                        i83 = 0;
                                    }
                                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i83, 1073741824), childMeasureSpec2);
                                }
                                iCombineMeasuredStates5 = View.combineMeasuredStates(iCombineMeasuredStates5, childAt.getMeasuredState() & (-16777216));
                                f13 = f17;
                                i17 = i84;
                            } else {
                                i19 = 1073741824;
                            }
                            int measuredWidth4 = childAt.getMeasuredWidth() + i83;
                            if (measuredWidth4 < 0) {
                                measuredWidth4 = 0;
                            }
                            childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth4, i19), childMeasureSpec2);
                            iCombineMeasuredStates5 = View.combineMeasuredStates(iCombineMeasuredStates5, childAt.getMeasuredState() & (-16777216));
                            f13 = f17;
                            i17 = i84;
                        } else {
                            i17 = i11;
                        }
                        if (z24) {
                            this.f678f = childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams10).leftMargin + ((LinearLayout.LayoutParams) layoutParams10).rightMargin + this.f678f;
                        } else {
                            int i85 = this.f678f;
                            this.f678f = Math.max(i85, childAt.getMeasuredWidth() + i85 + ((LinearLayout.LayoutParams) layoutParams10).leftMargin + ((LinearLayout.LayoutParams) layoutParams10).rightMargin);
                        }
                        boolean z30 = mode4 != 1073741824 && ((LinearLayout.LayoutParams) layoutParams10).height == -1;
                        int i86 = ((LinearLayout.LayoutParams) layoutParams10).topMargin + ((LinearLayout.LayoutParams) layoutParams10).bottomMargin;
                        int measuredHeight4 = childAt.getMeasuredHeight() + i86;
                        iMax = Math.max(iMax, measuredHeight4);
                        if (!z30) {
                            i86 = measuredHeight4;
                        }
                        iMax8 = Math.max(iMax8, i86);
                        if (z25) {
                            i18 = -1;
                            boolean z31 = ((LinearLayout.LayoutParams) layoutParams10).height == -1;
                            if (!z29 && (baseline = childAt.getBaseline()) != i18) {
                                int i87 = ((LinearLayout.LayoutParams) layoutParams10).gravity;
                                if (i87 < 0) {
                                    i87 = this.f677e;
                                }
                                int i88 = (((i87 & 112) >> 4) & (-2)) >> 1;
                                iArr[i88] = Math.max(iArr[i88], baseline);
                                iArr2[i88] = Math.max(iArr2[i88], measuredHeight4 - baseline);
                            }
                            z25 = z31;
                            i16 = i17;
                            f13 = f13;
                        } else {
                            i18 = -1;
                        }
                        if (!z29) {
                        }
                        z25 = z31;
                        i16 = i17;
                        f13 = f13;
                    }
                    i12++;
                    i11 = i16;
                    virtualChildCount2 = virtualChildCount2;
                }
                i13 = virtualChildCount2;
                this.f678f = getPaddingRight() + getPaddingLeft() + this.f678f;
                i14 = iArr[1];
                if (i14 != -1 && iArr[0] == -1 && iArr[2] == -1) {
                    c8 = 3;
                    if (iArr[3] == -1) {
                        i15 = 0;
                    }
                    i71 = iCombineMeasuredStates5;
                } else {
                    c8 = 3;
                }
                i15 = 0;
                iMax = Math.max(iMax, Math.max(iArr2[c8], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[c8], Math.max(iArr[0], Math.max(i14, iArr[2]))));
                i71 = iCombineMeasuredStates5;
            } else {
                iMax8 = Math.max(iMax8, iMax10);
                if (z28 && mode3 != 1073741824) {
                    for (int i89 = 0; i89 < virtualChildCount2; i89++) {
                        View childAt10 = getChildAt(i89);
                        if (childAt10 != null && childAt10.getVisibility() != 8 && ((LinearLayout.LayoutParams) ((LayoutParams) childAt10.getLayoutParams())).weight > 0.0f) {
                            childAt10.measure(View.MeasureSpec.makeMeasureSpec(iMax9, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt10.getMeasuredHeight(), 1073741824));
                        }
                    }
                }
                i13 = virtualChildCount2;
                i15 = 0;
            }
            if (z25 || mode4 == 1073741824) {
                iMax8 = iMax;
            }
            setMeasuredDimension((i71 & (-16777216)) | iResolveSizeAndState2, View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + iMax8, getSuggestedMinimumHeight()), i10, i71 << 16));
            if (z27) {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
                i20 = i13;
                while (i15 < i20) {
                    childAt2 = getChildAt(i15);
                    if (childAt2.getVisibility() != 8) {
                        layoutParams = (LayoutParams) childAt2.getLayoutParams();
                        if (((LinearLayout.LayoutParams) layoutParams).height == -1) {
                            int i90 = ((LinearLayout.LayoutParams) layoutParams).width;
                            ((LinearLayout.LayoutParams) layoutParams).width = childAt2.getMeasuredWidth();
                            measureChildWithMargins(childAt2, i6, 0, iMakeMeasureSpec, 0);
                            ((LinearLayout.LayoutParams) layoutParams).width = i90;
                        }
                    }
                    i15++;
                }
            }
        }
        c5 = 3;
        iMax = Math.max(i80, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[c5], Math.max(iArr[0], Math.max(i81, iArr[2]))));
        if (z28) {
            this.f678f = 0;
            while (i21 < virtualChildCount2) {
                childAt3 = getChildAt(i21);
                if (childAt3 == null) {
                    this.f678f = this.f678f;
                } else if (childAt3.getVisibility() == 8) {
                    layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                    if (z24) {
                        this.f678f = ((LinearLayout.LayoutParams) layoutParams2).leftMargin + iMax9 + ((LinearLayout.LayoutParams) layoutParams2).rightMargin + this.f678f;
                    } else {
                        int i810 = this.f678f;
                        this.f678f = Math.max(i810, i810 + iMax9 + ((LinearLayout.LayoutParams) layoutParams2).leftMargin + ((LinearLayout.LayoutParams) layoutParams2).rightMargin);
                    }
                }
            }
        }
        int paddingRight2 = getPaddingRight() + getPaddingLeft() + this.f678f;
        this.f678f = paddingRight2;
        int iResolveSizeAndState3 = View.resolveSizeAndState(Math.max(paddingRight2, getSuggestedMinimumWidth()), i6, 0);
        i11 = (16777215 & iResolveSizeAndState3) - this.f678f;
        if (z26) {
            f = this.f679g;
            if (f > 0.0f) {
                f13 = f;
            }
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            this.f678f = 0;
            int iCombineMeasuredStates6 = i71;
            iMax = -1;
            i12 = 0;
            while (i12 < virtualChildCount2) {
                childAt = getChildAt(i12);
                if (childAt != null) {
                    i16 = i11;
                    virtualChildCount2 = virtualChildCount2;
                } else {
                    i16 = i11;
                    virtualChildCount2 = virtualChildCount2;
                }
                i12++;
                i11 = i16;
                virtualChildCount2 = virtualChildCount2;
            }
            i13 = virtualChildCount2;
            this.f678f = getPaddingRight() + getPaddingLeft() + this.f678f;
            i14 = iArr[1];
            if (i14 != -1) {
                c8 = 3;
                i15 = 0;
                iMax = Math.max(iMax, Math.max(iArr2[c8], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[c8], Math.max(iArr[0], Math.max(i14, iArr[2]))));
            } else {
                c8 = 3;
                i15 = 0;
                iMax = Math.max(iMax, Math.max(iArr2[c8], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[c8], Math.max(iArr[0], Math.max(i14, iArr[2]))));
            }
            i71 = iCombineMeasuredStates6;
        } else {
            f = this.f679g;
            if (f > 0.0f) {
                f13 = f;
            }
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            this.f678f = 0;
            int iCombineMeasuredStates7 = i71;
            iMax = -1;
            i12 = 0;
            while (i12 < virtualChildCount2) {
                childAt = getChildAt(i12);
                if (childAt != null) {
                    i16 = i11;
                    virtualChildCount2 = virtualChildCount2;
                } else {
                    i16 = i11;
                    virtualChildCount2 = virtualChildCount2;
                }
                i12++;
                i11 = i16;
                virtualChildCount2 = virtualChildCount2;
            }
            i13 = virtualChildCount2;
            this.f678f = getPaddingRight() + getPaddingLeft() + this.f678f;
            i14 = iArr[1];
            if (i14 != -1) {
                c8 = 3;
                i15 = 0;
                iMax = Math.max(iMax, Math.max(iArr2[c8], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[c8], Math.max(iArr[0], Math.max(i14, iArr[2]))));
            } else {
                c8 = 3;
                i15 = 0;
                iMax = Math.max(iMax, Math.max(iArr2[c8], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[c8], Math.max(iArr[0], Math.max(i14, iArr[2]))));
            }
            i71 = iCombineMeasuredStates7;
        }
        if (z25) {
            iMax8 = iMax;
        } else {
            iMax8 = iMax;
        }
        setMeasuredDimension((i71 & (-16777216)) | iResolveSizeAndState3, View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + iMax8, getSuggestedMinimumHeight()), i10, i71 << 16));
        if (z27) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
            i20 = i13;
            while (i15 < i20) {
                childAt2 = getChildAt(i15);
                if (childAt2.getVisibility() != 8) {
                    layoutParams = (LayoutParams) childAt2.getLayoutParams();
                    if (((LinearLayout.LayoutParams) layoutParams).height == -1) {
                        int i91 = ((LinearLayout.LayoutParams) layoutParams).width;
                        ((LinearLayout.LayoutParams) layoutParams).width = childAt2.getMeasuredWidth();
                        measureChildWithMargins(childAt2, i6, 0, iMakeMeasureSpec, 0);
                        ((LinearLayout.LayoutParams) layoutParams).width = i91;
                    }
                }
                i15++;
            }
        }
    }

    public void setBaselineAligned(boolean z7) {
        this.f673a = z7;
    }

    public void setBaselineAlignedChildIndex(int i6) {
        if (i6 >= 0 && i6 < getChildCount()) {
            this.f674b = i6;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f683k) {
            return;
        }
        this.f683k = drawable;
        if (drawable != null) {
            this.f684l = drawable.getIntrinsicWidth();
            this.f685m = drawable.getIntrinsicHeight();
        } else {
            this.f684l = 0;
            this.f685m = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i6) {
        this.f687o = i6;
    }

    public void setGravity(int i6) {
        if (this.f677e != i6) {
            if ((8388615 & i6) == 0) {
                i6 |= 8388611;
            }
            if ((i6 & 112) == 0) {
                i6 |= 48;
            }
            this.f677e = i6;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i6) {
        int i10 = i6 & 8388615;
        int i11 = this.f677e;
        if ((8388615 & i11) != i10) {
            this.f677e = i10 | ((-8388616) & i11);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z7) {
        this.f680h = z7;
    }

    public void setOrientation(int i6) {
        if (this.f676d != i6) {
            this.f676d = i6;
            requestLayout();
        }
    }

    public void setShowDividers(int i6) {
        if (i6 != this.f686n) {
            requestLayout();
        }
        this.f686n = i6;
    }

    public void setVerticalGravity(int i6) {
        int i10 = i6 & 112;
        int i11 = this.f677e;
        if ((i11 & 112) != i10) {
            this.f677e = i10 | (i11 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.f679g = Math.max(0.0f, f);
    }

    @Override
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f673a = true;
        this.f674b = -1;
        this.f675c = 0;
        this.f677e = 8388659;
        int[] iArr = AbstractC2341a.f8167o;
        C0026b c0026bM111C = C0026b.m111C(context, attributeSet, iArr, i6);
        AbstractC3155s0.m6346p(this, context, iArr, attributeSet, (TypedArray) c0026bM111C.f55c, i6, 0);
        TypedArray typedArray = (TypedArray) c0026bM111C.f55c;
        int i10 = typedArray.getInt(1, -1);
        if (i10 >= 0) {
            setOrientation(i10);
        }
        int i11 = typedArray.getInt(0, -1);
        if (i11 >= 0) {
            setGravity(i11);
        }
        boolean z7 = typedArray.getBoolean(2, true);
        if (!z7) {
            setBaselineAligned(z7);
        }
        this.f679g = typedArray.getFloat(4, -1.0f);
        this.f674b = typedArray.getInt(3, -1);
        this.f680h = typedArray.getBoolean(7, false);
        setDividerDrawable(c0026bM111C.m140t(5));
        this.f686n = typedArray.getInt(8, 0);
        this.f687o = typedArray.getDimensionPixelSize(6, 0);
        c0026bM111C.m120F();
    }
}
