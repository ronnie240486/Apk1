package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.material.internal.AbstractC1811a0;
import com.google.android.material.navigation.AbstractC1846f;
import com.google.android.material.navigation.AbstractC1852l;
import com.p2serv.android.p032ds.R;
import p002a1.C0026b;
import p019b6.C1327b;
import p019b6.InterfaceC1328c;
import p019b6.InterfaceC1329d;
import p249x4.C4112e;
import p250x5.AbstractC4121a;

public class BottomNavigationView extends AbstractC1852l {
    public BottomNavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bottomNavigationStyle);
    }

    @Override
    public final AbstractC1846f mo4121a(Context context) {
        return new C1327b(context);
    }

    @Override
    public int getMaxItemCount() {
        return 5;
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        if (View.MeasureSpec.getMode(i10) != 1073741824 && suggestedMinimumHeight > 0) {
            i10 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i10), getPaddingBottom() + getPaddingTop() + suggestedMinimumHeight), 1073741824);
        }
        super.onMeasure(i6, i10);
    }

    public void setItemHorizontalTranslationEnabled(boolean z7) {
        C1327b c1327b = (C1327b) getMenuView();
        if (c1327b.f4136I != z7) {
            c1327b.setItemHorizontalTranslationEnabled(z7);
            getPresenter().mo712j(false);
        }
    }

    @Deprecated
    public void setOnNavigationItemReselectedListener(InterfaceC1328c interfaceC1328c) {
        setOnItemReselectedListener(interfaceC1328c);
    }

    @Deprecated
    public void setOnNavigationItemSelectedListener(InterfaceC1329d interfaceC1329d) {
        setOnItemSelectedListener(interfaceC1329d);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6, R.style.Widget_Design_BottomNavigationView);
        C0026b c0026bM4251k = AbstractC1811a0.m4251k(getContext(), attributeSet, AbstractC4121a.f13992f, i6, R.style.Widget_Design_BottomNavigationView, new int[0]);
        TypedArray typedArray = (TypedArray) c0026bM4251k.f55c;
        setItemHorizontalTranslationEnabled(typedArray.getBoolean(1, true));
        if (typedArray.hasValue(0)) {
            setMinimumHeight(typedArray.getDimensionPixelSize(0, 0));
        }
        c0026bM4251k.m120F();
        AbstractC1811a0.m4244d(this, new C4112e(4));
    }
}
