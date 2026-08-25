package androidx.leanback.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import java.util.ArrayList;
import p075h1.AbstractC2639a;

public class BaseCardView extends FrameLayout {

    public static final int[] f2063r = {R.attr.state_pressed};

    public int f2064a;

    public int f2065b;

    public int f2066c;

    public final ArrayList f2067d;

    public final ArrayList f2068e;

    public final ArrayList f2069f;

    public int f2070g;

    public int f2071h;

    public boolean f2072i;

    public final int f2073j;

    public final int f2074k;

    public final int f2075l;

    public float f2076m;

    public float f2077n;

    public float f2078o;

    public C0453c f2079p;

    public final RunnableC0447a f2080q;

    public static class LayoutParams extends FrameLayout.LayoutParams {

        public int f2081a;

        @SuppressLint({"CustomViewStyleable"})
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2081a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC2639a.f9160d);
            this.f2081a = typedArrayObtainStyledAttributes.getInt(0, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public BaseCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.p2serv.android.p032ds.R.attr.baseCardViewStyle);
    }

    private void setInfoViewVisibility(boolean z7) {
        int i6 = this.f2064a;
        ArrayList arrayList = this.f2068e;
        int i10 = 0;
        if (i6 != 3) {
            if (i6 != 2) {
                if (i6 == 1) {
                    m1347b();
                    if (z7) {
                        for (int i11 = 0; i11 < arrayList.size(); i11++) {
                            ((View) arrayList.get(i11)).setVisibility(0);
                        }
                    }
                    if ((z7 ? 1.0f : 0.0f) == this.f2078o) {
                        return;
                    }
                    C0453c c0453c = new C0453c(this, this.f2078o, z7 ? 1.0f : 0.0f, 0);
                    this.f2079p = c0453c;
                    c0453c.setDuration(this.f2074k);
                    this.f2079p.setInterpolator(new DecelerateInterpolator());
                    this.f2079p.setAnimationListener(new AnimationAnimationListenerC0450b(this, 2));
                    startAnimation(this.f2079p);
                    return;
                }
                return;
            }
            if (this.f2065b != 2) {
                for (int i12 = 0; i12 < arrayList.size(); i12++) {
                    ((View) arrayList.get(i12)).setVisibility(z7 ? 0 : 8);
                }
                return;
            }
            m1347b();
            if (z7) {
                for (int i13 = 0; i13 < arrayList.size(); i13++) {
                    ((View) arrayList.get(i13)).setVisibility(0);
                }
            }
            float f = z7 ? 1.0f : 0.0f;
            if (this.f2077n == f) {
                return;
            }
            C0453c c0453c2 = new C0453c(this, this.f2077n, f, 1);
            this.f2079p = c0453c2;
            c0453c2.setDuration(this.f2075l);
            this.f2079p.setInterpolator(new AccelerateDecelerateInterpolator());
            this.f2079p.setAnimationListener(new AnimationAnimationListenerC0450b(this, 1));
            startAnimation(this.f2079p);
            return;
        }
        if (z7) {
            for (int i14 = 0; i14 < arrayList.size(); i14++) {
                ((View) arrayList.get(i14)).setVisibility(0);
            }
            return;
        }
        for (int i15 = 0; i15 < arrayList.size(); i15++) {
            ((View) arrayList.get(i15)).setVisibility(8);
        }
        while (true) {
            ArrayList arrayList2 = this.f2069f;
            if (i10 >= arrayList2.size()) {
                this.f2076m = 0.0f;
                return;
            } else {
                ((View) arrayList2.get(i10)).setVisibility(8);
                i10++;
            }
        }
    }

    public final void m1346a(boolean z7) {
        m1347b();
        int i6 = 0;
        if (z7) {
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f2070g, 1073741824);
            int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int i10 = 0;
            int iMax = 0;
            while (true) {
                ArrayList arrayList = this.f2069f;
                if (i10 >= arrayList.size()) {
                    break;
                }
                View view = (View) arrayList.get(i10);
                view.setVisibility(0);
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                iMax = Math.max(iMax, view.getMeasuredHeight());
                i10++;
            }
            i6 = iMax;
        }
        C0453c c0453c = new C0453c(this, this.f2076m, z7 ? i6 : 0.0f, 2);
        this.f2079p = c0453c;
        c0453c.setDuration(this.f2075l);
        this.f2079p.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f2079p.setAnimationListener(new AnimationAnimationListenerC0450b(this, 0));
        startAnimation(this.f2079p);
    }

    public final void m1347b() {
        C0453c c0453c = this.f2079p;
        if (c0453c != null) {
            c0453c.cancel();
            this.f2079p = null;
            clearAnimation();
        }
    }

    @Override
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.f2081a = 0;
        return layoutParams;
    }

    @Override
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public int getCardType() {
        return this.f2064a;
    }

    @Deprecated
    public int getExtraVisibility() {
        return this.f2066c;
    }

    public final float getFinalInfoAlpha() {
        return (this.f2064a == 1 && this.f2065b == 2 && !isSelected()) ? 0.0f : 1.0f;
    }

    public final float getFinalInfoVisFraction() {
        return (this.f2064a == 2 && this.f2065b == 2 && !isSelected()) ? 0.0f : 1.0f;
    }

    public int getInfoVisibility() {
        return this.f2065b;
    }

    @Override
    public final int[] onCreateDrawableState(int i6) {
        boolean z7 = false;
        boolean z10 = false;
        for (int i10 : super.onCreateDrawableState(i6)) {
            if (i10 == 16842919) {
                z7 = true;
            }
            if (i10 == 16842910) {
                z10 = true;
            }
        }
        if (z7 && z10) {
            return View.PRESSED_ENABLED_STATE_SET;
        }
        if (z7) {
            return f2063r;
        }
        return z10 ? View.ENABLED_STATE_SET : View.EMPTY_STATE_SET;
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f2080q);
        m1347b();
    }

    @Override
    public final void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        ArrayList arrayList;
        float paddingTop = getPaddingTop();
        int i13 = 0;
        while (true) {
            ArrayList arrayList2 = this.f2067d;
            if (i13 >= arrayList2.size()) {
                break;
            }
            View view = (View) arrayList2.get(i13);
            if (view.getVisibility() != 8) {
                view.layout(getPaddingLeft(), (int) paddingTop, getPaddingLeft() + this.f2070g, (int) (view.getMeasuredHeight() + paddingTop));
                paddingTop += view.getMeasuredHeight();
            }
            i13++;
        }
        if (this.f2064a != 0) {
            int i14 = 0;
            float measuredHeight = 0.0f;
            while (true) {
                arrayList = this.f2068e;
                if (i14 >= arrayList.size()) {
                    break;
                }
                measuredHeight += ((View) arrayList.get(i14)).getMeasuredHeight();
                i14++;
            }
            int i15 = this.f2064a;
            if (i15 == 1) {
                paddingTop -= measuredHeight;
                if (paddingTop < 0.0f) {
                    paddingTop = 0.0f;
                }
            } else if (i15 != 2) {
                paddingTop -= this.f2076m;
            } else if (this.f2065b == 2) {
                measuredHeight *= this.f2077n;
            }
            for (int i16 = 0; i16 < arrayList.size(); i16++) {
                View view2 = (View) arrayList.get(i16);
                if (view2.getVisibility() != 8) {
                    int measuredHeight2 = view2.getMeasuredHeight();
                    if (measuredHeight2 > measuredHeight) {
                        measuredHeight2 = (int) measuredHeight;
                    }
                    float f = measuredHeight2;
                    paddingTop += f;
                    view2.layout(getPaddingLeft(), (int) paddingTop, getPaddingLeft() + this.f2070g, (int) paddingTop);
                    measuredHeight -= f;
                    if (measuredHeight <= 0.0f) {
                        break;
                    }
                }
            }
            if (this.f2064a == 3) {
                int i17 = 0;
                while (true) {
                    ArrayList arrayList3 = this.f2069f;
                    if (i17 >= arrayList3.size()) {
                        break;
                    }
                    View view3 = (View) arrayList3.get(i17);
                    if (view3.getVisibility() != 8) {
                        view3.layout(getPaddingLeft(), (int) paddingTop, getPaddingLeft() + this.f2070g, (int) (view3.getMeasuredHeight() + paddingTop));
                        paddingTop += view3.getMeasuredHeight();
                    }
                    i17++;
                }
            }
        }
        onSizeChanged(0, 0, i11 - i6, i12 - i10);
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        boolean z7;
        int measuredHeight;
        int measuredHeight2;
        boolean zIsActivated;
        this.f2070g = 0;
        this.f2071h = 0;
        ArrayList arrayList = this.f2067d;
        arrayList.clear();
        ArrayList arrayList2 = this.f2068e;
        arrayList2.clear();
        ArrayList arrayList3 = this.f2069f;
        arrayList3.clear();
        int childCount = getChildCount();
        int i11 = this.f2064a;
        if (i11 != 0) {
            int i12 = this.f2065b;
            if (i12 == 0) {
                zIsActivated = true;
            } else if (i12 == 1) {
                zIsActivated = isActivated();
            } else if (i12 != 2) {
                zIsActivated = false;
            } else if (i11 != 2) {
                zIsActivated = isSelected();
            } else if (this.f2077n > 0.0f) {
                zIsActivated = true;
            } else {
                zIsActivated = false;
            }
            if (zIsActivated) {
                z7 = true;
            } else {
                z7 = false;
            }
        } else {
            z7 = false;
        }
        boolean z10 = (this.f2064a == 3) && this.f2076m > 0.0f;
        int i13 = 0;
        while (true) {
            if (i13 >= childCount) {
                break;
            }
            View childAt = getChildAt(i13);
            if (childAt != null) {
                int i14 = ((LayoutParams) childAt.getLayoutParams()).f2081a;
                if (i14 == 1) {
                    childAt.setAlpha(this.f2078o);
                    arrayList2.add(childAt);
                    childAt.setVisibility(z7 ? 0 : 8);
                } else if (i14 == 2) {
                    arrayList3.add(childAt);
                    childAt.setVisibility(z10 ? 0 : 8);
                } else {
                    arrayList.add(childAt);
                    childAt.setVisibility(0);
                }
            }
            i13++;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int measuredHeight3 = 0;
        int iCombineMeasuredStates = 0;
        for (int i15 = 0; i15 < arrayList.size(); i15++) {
            View view = (View) arrayList.get(i15);
            if (view.getVisibility() != 8) {
                measureChild(view, iMakeMeasureSpec, iMakeMeasureSpec);
                this.f2070g = Math.max(this.f2070g, view.getMeasuredWidth());
                measuredHeight3 += view.getMeasuredHeight();
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view.getMeasuredState());
            }
        }
        setPivotX(this.f2070g / 2);
        setPivotY(measuredHeight3 / 2);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.f2070g, 1073741824);
        if (this.f2064a != 0) {
            measuredHeight2 = 0;
            for (int i16 = 0; i16 < arrayList2.size(); i16++) {
                View view2 = (View) arrayList2.get(i16);
                if (view2.getVisibility() != 8) {
                    measureChild(view2, iMakeMeasureSpec2, iMakeMeasureSpec);
                    if (this.f2064a != 1) {
                        measuredHeight2 += view2.getMeasuredHeight();
                    }
                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view2.getMeasuredState());
                }
            }
            if (this.f2064a == 3) {
                measuredHeight = 0;
                for (int i17 = 0; i17 < arrayList3.size(); i17++) {
                    View view3 = (View) arrayList3.get(i17);
                    if (view3.getVisibility() != 8) {
                        measureChild(view3, iMakeMeasureSpec2, iMakeMeasureSpec);
                        measuredHeight += view3.getMeasuredHeight();
                        iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view3.getMeasuredState());
                    }
                }
            } else {
                measuredHeight = 0;
            }
        } else {
            measuredHeight = 0;
            measuredHeight2 = 0;
        }
        boolean z11 = (this.f2064a != 0) && this.f2065b == 2;
        float f = measuredHeight3;
        float f3 = measuredHeight2;
        if (z11) {
            f3 *= this.f2077n;
        }
        this.f2071h = (int) (((f + f3) + measuredHeight) - (z11 ? 0.0f : this.f2076m));
        setMeasuredDimension(View.resolveSizeAndState(getPaddingRight() + getPaddingLeft() + this.f2070g, i6, iCombineMeasuredStates), View.resolveSizeAndState(getPaddingBottom() + getPaddingTop() + this.f2071h, i10, iCombineMeasuredStates << 16));
    }

    @Override
    public void setActivated(boolean z7) {
        if (z7 != isActivated()) {
            super.setActivated(z7);
            if (this.f2064a != 0) {
                int i6 = this.f2065b;
                boolean zIsActivated = true;
                if (i6 == 1) {
                    if (i6 != 0) {
                        if (i6 != 1) {
                            zIsActivated = i6 != 2 ? false : isSelected();
                        } else {
                            zIsActivated = isActivated();
                        }
                    }
                    setInfoViewVisibility(zIsActivated);
                }
            }
        }
    }

    public void setCardType(int i6) {
        if (this.f2064a != i6) {
            if (i6 < 0 || i6 >= 4) {
                Log.e("BaseCardView", "Invalid card type specified: " + i6 + ". Defaulting to type CARD_TYPE_MAIN_ONLY.");
                this.f2064a = 0;
            } else {
                this.f2064a = i6;
            }
            requestLayout();
        }
    }

    @Deprecated
    public void setExtraVisibility(int i6) {
        if (this.f2066c != i6) {
            this.f2066c = i6;
        }
    }

    public void setInfoVisibility(int i6) {
        if (this.f2065b == i6) {
            return;
        }
        m1347b();
        this.f2065b = i6;
        this.f2077n = getFinalInfoVisFraction();
        requestLayout();
        float finalInfoAlpha = getFinalInfoAlpha();
        if (finalInfoAlpha == this.f2078o) {
            return;
        }
        this.f2078o = finalInfoAlpha;
        int i10 = 0;
        while (true) {
            ArrayList arrayList = this.f2068e;
            if (i10 >= arrayList.size()) {
                return;
            }
            ((View) arrayList.get(i10)).setAlpha(this.f2078o);
            i10++;
        }
    }

    @Override
    public void setSelected(boolean z7) {
        if (z7 != isSelected()) {
            super.setSelected(z7);
            boolean zIsSelected = isSelected();
            RunnableC0447a runnableC0447a = this.f2080q;
            removeCallbacks(runnableC0447a);
            if (this.f2064a != 3) {
                if (this.f2065b == 2) {
                    setInfoViewVisibility(zIsSelected);
                }
            } else if (!zIsSelected) {
                m1346a(false);
            } else if (this.f2072i) {
                postDelayed(runnableC0447a, this.f2073j);
            } else {
                post(runnableC0447a);
                this.f2072i = true;
            }
        }
    }

    public void setSelectedAnimationDelayed(boolean z7) {
        this.f2072i = z7;
    }

    @Override
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @SuppressLint({"CustomViewStyleable"})
    public BaseCardView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f2080q = new RunnableC0447a(0, this);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC2639a.f9159c, i6, 0);
        try {
            this.f2064a = typedArrayObtainStyledAttributes.getInteger(3, 0);
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(2);
            if (drawable != null) {
                setForeground(drawable);
            }
            Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(1);
            if (drawable2 != null) {
                setBackground(drawable2);
            }
            this.f2065b = typedArrayObtainStyledAttributes.getInteger(5, 1);
            int integer = typedArrayObtainStyledAttributes.getInteger(4, 2);
            this.f2066c = integer;
            int i10 = this.f2065b;
            if (integer < i10) {
                this.f2066c = i10;
            }
            this.f2073j = typedArrayObtainStyledAttributes.getInteger(6, getResources().getInteger(com.p2serv.android.p032ds.R.integer.lb_card_selected_animation_delay));
            this.f2075l = typedArrayObtainStyledAttributes.getInteger(7, getResources().getInteger(com.p2serv.android.p032ds.R.integer.lb_card_selected_animation_duration));
            this.f2074k = typedArrayObtainStyledAttributes.getInteger(0, getResources().getInteger(com.p2serv.android.p032ds.R.integer.lb_card_activated_animation_duration));
            typedArrayObtainStyledAttributes.recycle();
            this.f2072i = true;
            this.f2067d = new ArrayList();
            this.f2068e = new ArrayList();
            this.f2069f = new ArrayList();
            this.f2076m = 0.0f;
            this.f2077n = getFinalInfoVisFraction();
            this.f2078o = getFinalInfoAlpha();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            LayoutParams layoutParams3 = new LayoutParams(layoutParams2);
            layoutParams3.f2081a = 0;
            layoutParams3.f2081a = layoutParams2.f2081a;
            return layoutParams3;
        }
        LayoutParams layoutParams4 = new LayoutParams(layoutParams);
        layoutParams4.f2081a = 0;
        return layoutParams4;
    }

    @Override
    public final FrameLayout.LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.f2081a = 0;
        return layoutParams;
    }
}
