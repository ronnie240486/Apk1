package com.google.android.material.internal;

import android.view.View;
import com.google.android.material.bottomappbar.C1760b;
import java.util.WeakHashMap;
import p138n0.AbstractC3155s0;
import p138n0.C3153r1;

public final class C1813b0 implements InterfaceC1817d0 {

    public final boolean f6358a;

    public final boolean f6359b;

    public final boolean f6360c;

    public final C1760b f6361d;

    public C1813b0(boolean z7, boolean z10, boolean z11, C1760b c1760b) {
        this.f6358a = z7;
        this.f6359b = z10;
        this.f6360c = z11;
        this.f6361d = c1760b;
    }

    @Override
    public final C3153r1 mo443o(View view, C3153r1 c3153r1, C1819e0 c1819e0) {
        if (this.f6358a) {
            c1819e0.f6439d = c3153r1.m6325a() + c1819e0.f6439d;
        }
        boolean zM4249i = AbstractC1811a0.m4249i(view);
        if (this.f6359b) {
            if (zM4249i) {
                c1819e0.f6438c = c3153r1.m6326b() + c1819e0.f6438c;
            } else {
                c1819e0.f6436a = c3153r1.m6326b() + c1819e0.f6436a;
            }
        }
        if (this.f6360c) {
            if (zM4249i) {
                c1819e0.f6436a = c3153r1.m6327c() + c1819e0.f6436a;
            } else {
                c1819e0.f6438c = c3153r1.m6327c() + c1819e0.f6438c;
            }
        }
        int i6 = c1819e0.f6436a;
        int i10 = c1819e0.f6437b;
        int i11 = c1819e0.f6438c;
        int i12 = c1819e0.f6439d;
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        view.setPaddingRelative(i6, i10, i11, i12);
        this.f6361d.mo443o(view, c3153r1, c1819e0);
        return c3153r1;
    }
}
