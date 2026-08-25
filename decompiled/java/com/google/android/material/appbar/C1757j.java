package com.google.android.material.appbar;

import android.view.View;
import p138n0.AbstractC3155s0;

public final class C1757j {

    public final View f5877a;

    public int f5878b;

    public int f5879c;

    public int f5880d;

    public C1757j(View view) {
        this.f5877a = view;
    }

    public final void m4099a() {
        int i6 = this.f5880d;
        View view = this.f5877a;
        AbstractC3155s0.m6340j(i6 - (view.getTop() - this.f5878b), view);
        AbstractC3155s0.m6339i(0 - (view.getLeft() - this.f5879c), view);
    }

    public final boolean m4100b(int i6) {
        if (this.f5880d == i6) {
            return false;
        }
        this.f5880d = i6;
        m4099a();
        return true;
    }
}
