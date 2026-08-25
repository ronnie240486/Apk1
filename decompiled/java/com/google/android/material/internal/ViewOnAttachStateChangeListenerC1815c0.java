package com.google.android.material.internal;

import android.view.View;
import com.p2serv.android.p032ds.R;
import java.util.WeakHashMap;
import p138n0.AbstractC3113e0;
import p138n0.AbstractC3155s0;
import p237w0.AbstractC4044e;

public final class ViewOnAttachStateChangeListenerC1815c0 implements View.OnAttachStateChangeListener {

    public final int f6364a;

    public ViewOnAttachStateChangeListenerC1815c0(int i6) {
        this.f6364a = i6;
    }

    @Override
    public final void onViewAttachedToWindow(View view) {
        switch (this.f6364a) {
            case 0:
                view.removeOnAttachStateChangeListener(this);
                WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                AbstractC3113e0.m6130c(view);
                break;
            default:
                (view != null ? (AbstractC4044e) view.getTag(R.id.dataBinding) : null).f13696b.run();
                view.removeOnAttachStateChangeListener(this);
                break;
        }
    }

    @Override
    public final void onViewDetachedFromWindow(View view) {
        int i6 = this.f6364a;
    }

    private final void m4254a(View view) {
    }

    private final void m4255b(View view) {
    }
}
