package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    public C1757j f5858a;

    public int f5859b;

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5859b = 0;
    }

    @Override
    public boolean mo926h(CoordinatorLayout coordinatorLayout, View view, int i6) {
        mo4095u(coordinatorLayout, view, i6);
        if (this.f5858a == null) {
            this.f5858a = new C1757j(view);
        }
        C1757j c1757j = this.f5858a;
        View view2 = c1757j.f5877a;
        c1757j.f5878b = view2.getTop();
        c1757j.f5879c = view2.getLeft();
        this.f5858a.m4099a();
        int i10 = this.f5859b;
        if (i10 == 0) {
            return true;
        }
        this.f5858a.m4100b(i10);
        this.f5859b = 0;
        return true;
    }

    public int m4097s() {
        C1757j c1757j = this.f5858a;
        if (c1757j != null) {
            return c1757j.f5880d;
        }
        return 0;
    }

    public int mo4080t() {
        return m4097s();
    }

    public void mo4095u(CoordinatorLayout coordinatorLayout, View view, int i6) {
        coordinatorLayout.m914v(i6, view);
    }

    public boolean m4098v(int i6) {
        C1757j c1757j = this.f5858a;
        if (c1757j != null) {
            return c1757j.m4100b(i6);
        }
        this.f5859b = i6;
        return false;
    }

    public ViewOffsetBehavior() {
        this.f5859b = 0;
    }
}
