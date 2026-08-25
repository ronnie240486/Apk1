package com.google.android.material.internal;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.C1180r1;
import p148o0.C3233h;

public final class C1829o extends C1180r1 {

    public final C1832r f6448f;

    public C1829o(C1832r c1832r, NavigationMenuView navigationMenuView) {
        super(navigationMenuView);
        this.f6448f = c1832r;
    }

    @Override
    public final void mo1136d(View view, C3233h c3233h) {
        super.mo1136d(view, c3233h);
        C1832r c1832r = this.f6448f.f6454e.f6443d;
        int i6 = c1832r.f6451b.getChildCount() == 0 ? 0 : 1;
        for (int i10 = 0; i10 < c1832r.f6454e.f6440a.size(); i10++) {
            if (c1832r.f6454e.getItemViewType(i10) == 0) {
                i6++;
            }
        }
        c3233h.f10862a.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(i6, 0, false));
    }
}
