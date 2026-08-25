package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.C0308d;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.p2serv.android.p032ds.R;
import java.util.WeakHashMap;
import p138n0.AbstractC3155s0;
import p221u6.C3908h;
import p221u6.C3910j;
import p221u6.C3912l;
import p250x5.AbstractC4121a;
import p256y.C4187d;

class RadialViewGroup extends ConstraintLayout {

    public final RunnableC1888e f6934q;

    public int f6935r;

    public final C3908h f6936s;

    public RadialViewGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override
    public final void addView(View view, int i6, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i6, layoutParams);
        if (view.getId() == -1) {
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            view.setId(View.generateViewId());
        }
        Handler handler = getHandler();
        if (handler != null) {
            RunnableC1888e runnableC1888e = this.f6934q;
            handler.removeCallbacks(runnableC1888e);
            handler.post(runnableC1888e);
        }
    }

    public final void m4410o() {
        int childCount = getChildCount();
        int i6 = 1;
        for (int i10 = 0; i10 < childCount; i10++) {
            if ("skip".equals(getChildAt(i10).getTag())) {
                i6++;
            }
        }
        C0308d c0308d = new C0308d();
        c0308d.m896d(this);
        float f = 0.0f;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getId() != R.id.circle_center && !"skip".equals(childAt.getTag())) {
                int id = childAt.getId();
                int i12 = this.f6935r;
                C4187d c4187d = c0308d.m897g(id).f1409d;
                c4187d.f14205x = R.id.circle_center;
                c4187d.f14206y = i12;
                c4187d.f14207z = f;
                f = (360.0f / (childCount - i6)) + f;
            }
        }
        c0308d.m894b(this);
    }

    @Override
    public final void onFinishInflate() {
        super.onFinishInflate();
        m4410o();
    }

    @Override
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        Handler handler = getHandler();
        if (handler != null) {
            RunnableC1888e runnableC1888e = this.f6934q;
            handler.removeCallbacks(runnableC1888e);
            handler.post(runnableC1888e);
        }
    }

    @Override
    public final void setBackgroundColor(int i6) {
        this.f6936s.m7809n(ColorStateList.valueOf(i6));
    }

    public RadialViewGroup(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        LayoutInflater.from(context).inflate(R.layout.material_radial_view_group, this);
        C3908h c3908h = new C3908h();
        this.f6936s = c3908h;
        C3910j c3910j = new C3910j(0.5f);
        C3912l c3912lM7826f = c3908h.f13126a.f13107a.m7826f();
        c3912lM7826f.f13155e = c3910j;
        c3912lM7826f.f13156f = c3910j;
        c3912lM7826f.f13157g = c3910j;
        c3912lM7826f.f13158h = c3910j;
        c3908h.setShapeAppearanceModel(c3912lM7826f.m7819a());
        this.f6936s.m7809n(ColorStateList.valueOf(-1));
        C3908h c3908h2 = this.f6936s;
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        setBackground(c3908h2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC4121a.f13971O, i6, 0);
        this.f6935r = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f6934q = new RunnableC1888e(this);
        typedArrayObtainStyledAttributes.recycle();
    }
}
