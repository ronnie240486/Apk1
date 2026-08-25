package com.google.android.material.navigation;

import android.content.Context;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.MenuItem;
import androidx.transition.AutoTransition;
import com.google.android.material.badge.BadgeState$State;
import com.google.android.material.internal.ParcelableSparseArray;
import p105k.C2840n;
import p105k.InterfaceC2851y;
import p105k.MenuC2838l;
import p105k.SubMenuC2831e0;
import p258y1.AbstractC4200b0;
import p272z5.C4355a;

public final class C1848h implements InterfaceC2851y {

    public AbstractC1846f f6583a;

    public boolean f6584b;

    public int f6585c;

    @Override
    public final boolean mo763d(C2840n c2840n) {
        return false;
    }

    @Override
    public final boolean mo709e(SubMenuC2831e0 subMenuC2831e0) {
        return false;
    }

    @Override
    public final boolean mo764f(C2840n c2840n) {
        return false;
    }

    @Override
    public final void mo710g(Parcelable parcelable) {
        SparseArray sparseArray;
        if (parcelable instanceof NavigationBarPresenter$SavedState) {
            AbstractC1846f abstractC1846f = this.f6583a;
            NavigationBarPresenter$SavedState navigationBarPresenter$SavedState = (NavigationBarPresenter$SavedState) parcelable;
            int i6 = navigationBarPresenter$SavedState.f6500a;
            int size = abstractC1846f.f6556B.f9692f.size();
            for (int i10 = 0; i10 < size; i10++) {
                MenuItem item = abstractC1846f.f6556B.getItem(i10);
                if (i6 == item.getItemId()) {
                    abstractC1846f.f6563g = i6;
                    abstractC1846f.f6564h = i10;
                    item.setChecked(true);
                    break;
                }
            }
            Context context = this.f6583a.getContext();
            ParcelableSparseArray parcelableSparseArray = navigationBarPresenter$SavedState.f6501b;
            SparseArray sparseArray2 = new SparseArray(parcelableSparseArray.size());
            for (int i11 = 0; i11 < parcelableSparseArray.size(); i11++) {
                int iKeyAt = parcelableSparseArray.keyAt(i11);
                BadgeState$State badgeState$State = (BadgeState$State) parcelableSparseArray.valueAt(i11);
                if (badgeState$State == null) {
                    throw new IllegalArgumentException("BadgeDrawable's savedState cannot be null");
                }
                sparseArray2.put(iKeyAt, new C4355a(context, badgeState$State));
            }
            AbstractC1846f abstractC1846f2 = this.f6583a;
            abstractC1846f2.getClass();
            int i12 = 0;
            while (true) {
                int size2 = sparseArray2.size();
                sparseArray = abstractC1846f2.f6573q;
                if (i12 >= size2) {
                    break;
                }
                int iKeyAt2 = sparseArray2.keyAt(i12);
                if (sparseArray.indexOfKey(iKeyAt2) < 0) {
                    sparseArray.append(iKeyAt2, sparseArray2.get(iKeyAt2));
                }
                i12++;
            }
            AbstractC1844d[] abstractC1844dArr = abstractC1846f2.f6562f;
            if (abstractC1844dArr != null) {
                for (AbstractC1844d abstractC1844d : abstractC1844dArr) {
                    abstractC1844d.setBadge((C4355a) sparseArray.get(abstractC1844d.getId()));
                }
            }
        }
    }

    @Override
    public final int getId() {
        return this.f6585c;
    }

    @Override
    public final void mo712j(boolean z7) {
        AutoTransition autoTransition;
        if (this.f6584b) {
            return;
        }
        if (z7) {
            this.f6583a.m4299a();
            return;
        }
        AbstractC1846f abstractC1846f = this.f6583a;
        MenuC2838l menuC2838l = abstractC1846f.f6556B;
        if (menuC2838l == null || abstractC1846f.f6562f == null) {
            return;
        }
        int size = menuC2838l.f9692f.size();
        if (size != abstractC1846f.f6562f.length) {
            abstractC1846f.m4299a();
            return;
        }
        int i6 = abstractC1846f.f6563g;
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = abstractC1846f.f6556B.getItem(i10);
            if (item.isChecked()) {
                abstractC1846f.f6563g = item.getItemId();
                abstractC1846f.f6564h = i10;
            }
        }
        if (i6 != abstractC1846f.f6563g && (autoTransition = abstractC1846f.f6557a) != null) {
            AbstractC4200b0.m8249a(abstractC1846f, autoTransition);
        }
        boolean zM4298f = AbstractC1846f.m4298f(abstractC1846f.f6561e, abstractC1846f.f6556B.m5831l().size());
        for (int i11 = 0; i11 < size; i11++) {
            abstractC1846f.f6555A.f6584b = true;
            abstractC1846f.f6562f[i11].setLabelVisibilityMode(abstractC1846f.f6561e);
            abstractC1846f.f6562f[i11].setShifting(zM4298f);
            abstractC1846f.f6562f[i11].mo532c((C2840n) abstractC1846f.f6556B.getItem(i11));
            abstractC1846f.f6555A.f6584b = false;
        }
    }

    @Override
    public final void mo713k(Context context, MenuC2838l menuC2838l) {
        this.f6583a.f6556B = menuC2838l;
    }

    @Override
    public final boolean mo714l() {
        return false;
    }

    @Override
    public final Parcelable mo715m() {
        NavigationBarPresenter$SavedState navigationBarPresenter$SavedState = new NavigationBarPresenter$SavedState();
        navigationBarPresenter$SavedState.f6500a = this.f6583a.getSelectedItemId();
        SparseArray<C4355a> badgeDrawables = this.f6583a.getBadgeDrawables();
        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
        for (int i6 = 0; i6 < badgeDrawables.size(); i6++) {
            int iKeyAt = badgeDrawables.keyAt(i6);
            C4355a c4355aValueAt = badgeDrawables.valueAt(i6);
            if (c4355aValueAt == null) {
                throw new IllegalArgumentException("badgeDrawable cannot be null");
            }
            parcelableSparseArray.put(iKeyAt, c4355aValueAt.f14769e.f14778a);
        }
        navigationBarPresenter$SavedState.f6501b = parcelableSparseArray;
        return navigationBarPresenter$SavedState;
    }

    @Override
    public final void mo707b(MenuC2838l menuC2838l, boolean z7) {
    }
}
