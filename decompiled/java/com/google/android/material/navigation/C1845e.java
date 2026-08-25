package com.google.android.material.navigation;

import android.content.Context;
import android.view.SubMenu;
import p000a.AbstractC0004e;
import p105k.C2840n;
import p105k.MenuC2838l;

public final class C1845e extends MenuC2838l {

    public final int f6551A;

    public final Class f6552z;

    public C1845e(Context context, Class cls, int i6) {
        super(context);
        this.f6552z = cls;
        this.f6551A = i6;
    }

    @Override
    public final C2840n mo4297a(int i6, int i10, int i11, CharSequence charSequence) {
        int size = this.f9692f.size() + 1;
        int i12 = this.f6551A;
        if (size <= i12) {
            m5840y();
            C2840n c2840nMo4297a = super.mo4297a(i6, i10, i11, charSequence);
            c2840nMo4297a.m5845g(true);
            m5839x();
            return c2840nMo4297a;
        }
        String simpleName = this.f6552z.getSimpleName();
        StringBuilder sb = new StringBuilder("Maximum number of items supported by ");
        sb.append(simpleName);
        sb.append(" is ");
        sb.append(i12);
        sb.append(". Limit can be checked with ");
        throw new IllegalArgumentException(AbstractC0004e.m26t(sb, simpleName, "#getMaxItemCount()"));
    }

    @Override
    public final SubMenu addSubMenu(int i6, int i10, int i11, CharSequence charSequence) {
        throw new UnsupportedOperationException(this.f6552z.getSimpleName().concat(" does not support submenus"));
    }
}
