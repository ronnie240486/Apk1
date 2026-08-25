package com.google.android.material.internal;

import android.graphics.Typeface;

public final class C1814c {

    public final int f6362a;

    public final C1816d f6363b;

    public C1814c(C1816d c1816d, int i6) {
        this.f6362a = i6;
        this.f6363b = c1816d;
    }

    public final void m4253a(Typeface typeface) {
        switch (this.f6362a) {
            case 0:
                C1816d c1816d = this.f6363b;
                if (c1816d.m4269n(typeface)) {
                    c1816d.m4265j(false);
                }
                break;
            default:
                C1816d c1816d2 = this.f6363b;
                if (c1816d2.m4271p(typeface)) {
                    c1816d2.m4265j(false);
                }
                break;
        }
    }
}
