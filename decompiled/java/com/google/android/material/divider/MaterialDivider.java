package com.google.android.material.divider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.bumptech.glide.AbstractC1466d;
import com.google.android.material.internal.AbstractC1811a0;
import com.p2serv.android.p032ds.R;
import java.util.WeakHashMap;
import p138n0.AbstractC3155s0;
import p221u6.C3908h;
import p222u7.AbstractC3928d;
import p250x5.AbstractC4121a;
import p263y6.AbstractC4275a;

public class MaterialDivider extends View {

    public final C3908h f6249a;

    public int f6250b;

    public int f6251c;

    public int f6252d;

    public int f6253e;

    public MaterialDivider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialDividerStyle);
    }

    public int getDividerColor() {
        return this.f6251c;
    }

    public int getDividerInsetEnd() {
        return this.f6253e;
    }

    public int getDividerInsetStart() {
        return this.f6252d;
    }

    public int getDividerThickness() {
        return this.f6250b;
    }

    @Override
    public final void onDraw(Canvas canvas) {
        int width;
        int i6;
        super.onDraw(canvas);
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        boolean z7 = getLayoutDirection() == 1;
        int i10 = z7 ? this.f6253e : this.f6252d;
        if (z7) {
            width = getWidth();
            i6 = this.f6252d;
        } else {
            width = getWidth();
            i6 = this.f6253e;
        }
        int i11 = width - i6;
        C3908h c3908h = this.f6249a;
        c3908h.setBounds(i10, 0, i11, getBottom() - getTop());
        c3908h.draw(canvas);
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        super.onMeasure(i6, i10);
        int mode = View.MeasureSpec.getMode(i10);
        int measuredHeight = getMeasuredHeight();
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i11 = this.f6250b;
            if (i11 > 0 && measuredHeight != i11) {
                measuredHeight = i11;
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
    }

    public void setDividerColor(int i6) {
        if (this.f6251c != i6) {
            this.f6251c = i6;
            this.f6249a.m7809n(ColorStateList.valueOf(i6));
            invalidate();
        }
    }

    public void setDividerColorResource(int i6) {
        setDividerColor(AbstractC3928d.m7847i(getContext(), i6));
    }

    public void setDividerInsetEnd(int i6) {
        this.f6253e = i6;
    }

    public void setDividerInsetEndResource(int i6) {
        setDividerInsetEnd(getContext().getResources().getDimensionPixelOffset(i6));
    }

    public void setDividerInsetStart(int i6) {
        this.f6252d = i6;
    }

    public void setDividerInsetStartResource(int i6) {
        setDividerInsetStart(getContext().getResources().getDimensionPixelOffset(i6));
    }

    public void setDividerThickness(int i6) {
        if (this.f6250b != i6) {
            this.f6250b = i6;
            requestLayout();
        }
    }

    public void setDividerThicknessResource(int i6) {
        setDividerThickness(getContext().getResources().getDimensionPixelSize(i6));
    }

    public MaterialDivider(Context context, AttributeSet attributeSet, int i6) {
        super(AbstractC4275a.m8323a(context, attributeSet, i6, R.style.Widget_MaterialComponents_MaterialDivider), attributeSet, i6);
        Context context2 = getContext();
        this.f6249a = new C3908h();
        TypedArray typedArrayM4250j = AbstractC1811a0.m4250j(context2, attributeSet, AbstractC4121a.f13961E, i6, R.style.Widget_MaterialComponents_MaterialDivider, new int[0]);
        this.f6250b = typedArrayM4250j.getDimensionPixelSize(3, getResources().getDimensionPixelSize(R.dimen.material_divider_thickness));
        this.f6252d = typedArrayM4250j.getDimensionPixelOffset(2, 0);
        this.f6253e = typedArrayM4250j.getDimensionPixelOffset(1, 0);
        setDividerColor(AbstractC1466d.m3493k(context2, typedArrayM4250j, 0).getDefaultColor());
        typedArrayM4250j.recycle();
    }
}
