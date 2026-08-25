package com.google.android.material.internal;

import android.view.SubMenu;
import p105k.C2840n;
import p105k.MenuC2838l;

public final class C1822h extends MenuC2838l {
    @Override
    public final SubMenu addSubMenu(int i6, int i10, int i11, CharSequence charSequence) {
        C2840n c2840nMo4297a = mo4297a(i6, i10, i11, charSequence);
        C1833s c1833s = new C1833s(this.f9687a, this, c2840nMo4297a);
        c2840nMo4297a.f9731o = c1833s;
        c1833s.setHeaderTitle(c2840nMo4297a.f9721e);
        return c1833s;
    }
}
