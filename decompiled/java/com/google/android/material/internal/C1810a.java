package com.google.android.material.internal;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.chip.ChipGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import p051e6.C2420e;
import p051e6.InterfaceC2422g;

public final class C1810a {

    public final HashMap f6350a = new HashMap();

    public final HashSet f6351b = new HashSet();

    public C2420e f6352c;

    public boolean f6353d;

    public boolean f6354e;

    public final boolean m4236a(InterfaceC1821g interfaceC1821g) {
        int id = interfaceC1821g.getId();
        HashSet hashSet = this.f6351b;
        if (hashSet.contains(Integer.valueOf(id))) {
            return false;
        }
        InterfaceC1821g interfaceC1821g2 = (InterfaceC1821g) this.f6350a.get(Integer.valueOf(m4238c()));
        if (interfaceC1821g2 != null) {
            m4240e(interfaceC1821g2, false);
        }
        boolean zAdd = hashSet.add(Integer.valueOf(id));
        if (!interfaceC1821g.isChecked()) {
            interfaceC1821g.setChecked(true);
        }
        return zAdd;
    }

    public final ArrayList m4237b(ViewGroup viewGroup) {
        HashSet hashSet = new HashSet(this.f6351b);
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < viewGroup.getChildCount(); i6++) {
            View childAt = viewGroup.getChildAt(i6);
            if ((childAt instanceof InterfaceC1821g) && hashSet.contains(Integer.valueOf(childAt.getId()))) {
                arrayList.add(Integer.valueOf(childAt.getId()));
            }
        }
        return arrayList;
    }

    public final int m4238c() {
        if (this.f6353d) {
            HashSet hashSet = this.f6351b;
            if (!hashSet.isEmpty()) {
                return ((Integer) hashSet.iterator().next()).intValue();
            }
        }
        return -1;
    }

    public final void m4239d() {
        C2420e c2420e = this.f6352c;
        if (c2420e != null) {
            new HashSet(this.f6351b);
            ChipGroup chipGroup = c2420e.f8488a;
            InterfaceC2422g interfaceC2422g = chipGroup.f6105g;
            if (interfaceC2422g != null) {
                chipGroup.f6106h.m4237b(chipGroup);
                ChipGroup chipGroup2 = ((C2420e) interfaceC2422g).f8488a;
                if (chipGroup2.f6106h.f6353d) {
                    chipGroup2.getCheckedChipId();
                    throw null;
                }
            }
        }
    }

    public final boolean m4240e(InterfaceC1821g interfaceC1821g, boolean z7) {
        int id = interfaceC1821g.getId();
        HashSet hashSet = this.f6351b;
        if (!hashSet.contains(Integer.valueOf(id))) {
            return false;
        }
        if (z7 && hashSet.size() == 1 && hashSet.contains(Integer.valueOf(id))) {
            interfaceC1821g.setChecked(true);
            return false;
        }
        boolean zRemove = hashSet.remove(Integer.valueOf(id));
        if (interfaceC1821g.isChecked()) {
            interfaceC1821g.setChecked(false);
        }
        return zRemove;
    }
}
