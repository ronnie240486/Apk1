package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.internal.AbstractC1811a0;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.WeakHashMap;
import p001a0.C0022e;
import p065g0.AbstractC2581a;
import p138n0.AbstractC3119g0;
import p138n0.AbstractC3155s0;
import p143n5.AbstractC3198d;
import p156o9.AbstractC3280d;
import p221u6.C3908h;
import p250x5.AbstractC4121a;
import p263y6.AbstractC4275a;

public class MaterialToolbar extends Toolbar {

    public static final ImageView.ScaleType[] f5852d0 = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    public Integer f5853U;

    public boolean f5854V;

    public boolean f5855W;

    public ImageView.ScaleType f5856b0;

    public Boolean f5857c0;

    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.toolbarStyle);
    }

    public ImageView.ScaleType getLogoScaleType() {
        return this.f5856b0;
    }

    public Integer getNavigationIconTint() {
        return this.f5853U;
    }

    @Override
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        AbstractC3280d.m6568E(this);
    }

    @Override
    public final void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        ImageView imageView;
        Drawable drawable;
        super.onLayout(z7, i6, i10, i11, i12);
        ImageView imageView2 = null;
        if (this.f5854V || this.f5855W) {
            ArrayList arrayListM4247g = AbstractC1811a0.m4247g(this, getTitle());
            boolean zIsEmpty = arrayListM4247g.isEmpty();
            C0022e c0022e = AbstractC1811a0.f6357c;
            TextView textView = zIsEmpty ? null : (TextView) Collections.min(arrayListM4247g, c0022e);
            ArrayList arrayListM4247g2 = AbstractC1811a0.m4247g(this, getSubtitle());
            TextView textView2 = arrayListM4247g2.isEmpty() ? null : (TextView) Collections.max(arrayListM4247g2, c0022e);
            if (textView != null || textView2 != null) {
                int measuredWidth = getMeasuredWidth();
                int i13 = measuredWidth / 2;
                int paddingLeft = getPaddingLeft();
                int paddingRight = measuredWidth - getPaddingRight();
                for (int i14 = 0; i14 < getChildCount(); i14++) {
                    View childAt = getChildAt(i14);
                    if (childAt.getVisibility() != 8 && childAt != textView && childAt != textView2) {
                        if (childAt.getRight() < i13 && childAt.getRight() > paddingLeft) {
                            paddingLeft = childAt.getRight();
                        }
                        if (childAt.getLeft() > i13 && childAt.getLeft() < paddingRight) {
                            paddingRight = childAt.getLeft();
                        }
                    }
                }
                Pair pair = new Pair(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
                if (this.f5854V && textView != null) {
                    m4096x(textView, pair);
                }
                if (this.f5855W && textView2 != null) {
                    m4096x(textView2, pair);
                }
            }
        }
        Drawable logo = getLogo();
        if (logo != null) {
            for (int i15 = 0; i15 < getChildCount(); i15++) {
                View childAt2 = getChildAt(i15);
                if ((childAt2 instanceof ImageView) && (drawable = (imageView = (ImageView) childAt2).getDrawable()) != null && drawable.getConstantState() != null && drawable.getConstantState().equals(logo.getConstantState())) {
                    imageView2 = imageView;
                    break;
                }
            }
        }
        if (imageView2 != null) {
            Boolean bool = this.f5857c0;
            if (bool != null) {
                imageView2.setAdjustViewBounds(bool.booleanValue());
            }
            ImageView.ScaleType scaleType = this.f5856b0;
            if (scaleType != null) {
                imageView2.setScaleType(scaleType);
            }
        }
    }

    @Override
    public void setElevation(float f) {
        super.setElevation(f);
        AbstractC3280d.m6565B(this, f);
    }

    public void setLogoAdjustViewBounds(boolean z7) {
        Boolean bool = this.f5857c0;
        if (bool == null || bool.booleanValue() != z7) {
            this.f5857c0 = Boolean.valueOf(z7);
            requestLayout();
        }
    }

    public void setLogoScaleType(ImageView.ScaleType scaleType) {
        if (this.f5856b0 != scaleType) {
            this.f5856b0 = scaleType;
            requestLayout();
        }
    }

    @Override
    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null && this.f5853U != null) {
            drawable = AbstractC3198d.m6448W(drawable.mutate());
            AbstractC2581a.m5585g(drawable, this.f5853U.intValue());
        }
        super.setNavigationIcon(drawable);
    }

    public void setNavigationIconTint(int i6) {
        this.f5853U = Integer.valueOf(i6);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z7) {
        if (this.f5855W != z7) {
            this.f5855W = z7;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z7) {
        if (this.f5854V != z7) {
            this.f5854V = z7;
            requestLayout();
        }
    }

    public final void m4096x(TextView textView, Pair pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = textView.getMeasuredWidth();
        int i6 = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i10 = measuredWidth2 + i6;
        int iMax = Math.max(Math.max(((Integer) pair.first).intValue() - i6, 0), Math.max(i10 - ((Integer) pair.second).intValue(), 0));
        if (iMax > 0) {
            i6 += iMax;
            i10 -= iMax;
            textView.measure(View.MeasureSpec.makeMeasureSpec(i10 - i6, 1073741824), textView.getMeasuredHeightAndState());
        }
        textView.layout(i6, textView.getTop(), i10, textView.getBottom());
    }

    public MaterialToolbar(Context context, AttributeSet attributeSet, int i6) {
        super(AbstractC4275a.m8323a(context, attributeSet, i6, R.style.Widget_MaterialComponents_Toolbar), attributeSet, i6);
        Context context2 = getContext();
        TypedArray typedArrayM4250j = AbstractC1811a0.m4250j(context2, attributeSet, AbstractC4121a.f13966J, i6, R.style.Widget_MaterialComponents_Toolbar, new int[0]);
        if (typedArrayM4250j.hasValue(2)) {
            setNavigationIconTint(typedArrayM4250j.getColor(2, -1));
        }
        this.f5854V = typedArrayM4250j.getBoolean(4, false);
        this.f5855W = typedArrayM4250j.getBoolean(3, false);
        int i10 = typedArrayM4250j.getInt(1, -1);
        if (i10 >= 0) {
            ImageView.ScaleType[] scaleTypeArr = f5852d0;
            if (i10 < scaleTypeArr.length) {
                this.f5856b0 = scaleTypeArr[i10];
            }
        }
        if (typedArrayM4250j.hasValue(0)) {
            this.f5857c0 = Boolean.valueOf(typedArrayM4250j.getBoolean(0, false));
        }
        typedArrayM4250j.recycle();
        Drawable background = getBackground();
        if (background == null || (background instanceof ColorDrawable)) {
            C3908h c3908h = new C3908h();
            c3908h.m7809n(ColorStateList.valueOf(background != null ? ((ColorDrawable) background).getColor() : 0));
            c3908h.m7806k(context2);
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            c3908h.m7808m(AbstractC3119g0.m6170i(this));
            setBackground(c3908h);
        }
    }
}
