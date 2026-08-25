package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.ViewOnClickListenerC0122a;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import p105k.C2840n;
import p105k.InterfaceC2851y;
import p105k.MenuC2838l;
import p105k.SubMenuC2831e0;

public final class C1832r implements InterfaceC2851y {

    public NavigationMenuView f6450a;

    public LinearLayout f6451b;

    public MenuC2838l f6452c;

    public int f6453d;

    public C1824j f6454e;

    public LayoutInflater f6455f;

    public ColorStateList f6457h;

    public ColorStateList f6459j;

    public ColorStateList f6460k;

    public Drawable f6461l;

    public RippleDrawable f6462m;

    public int f6463n;

    public int f6464o;

    public int f6465p;

    public int f6466q;

    public int f6467r;

    public int f6468s;

    public int f6469t;

    public boolean f6470u;

    public int f6472w;

    public int f6473x;

    public int f6474y;

    public int f6456g = 0;

    public int f6458i = 0;

    public boolean f6471v = true;

    public int f6475z = -1;

    public final ViewOnClickListenerC0122a f6449A = new ViewOnClickListenerC0122a(4, this);

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
        C2840n c2840n;
        View actionView;
        ParcelableSparseArray parcelableSparseArray;
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.f6450a.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                C1824j c1824j = this.f6454e;
                c1824j.getClass();
                int i6 = bundle2.getInt("android:menu:checked", 0);
                ArrayList arrayList = c1824j.f6440a;
                if (i6 != 0) {
                    c1824j.f6442c = true;
                    int size = arrayList.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        InterfaceC1826l interfaceC1826l = (InterfaceC1826l) arrayList.get(i10);
                        if (interfaceC1826l instanceof C1828n) {
                            C2840n c2840n2 = ((C1828n) interfaceC1826l).f6446a;
                            if (c2840n2.f9717a == i6) {
                                c1824j.m4278b(c2840n2);
                                break;
                            }
                        }
                    }
                    c1824j.f6442c = false;
                    c1824j.m4277a();
                }
                SparseArray sparseParcelableArray2 = bundle2.getSparseParcelableArray("android:menu:action_views");
                if (sparseParcelableArray2 != null) {
                    int size2 = arrayList.size();
                    for (int i11 = 0; i11 < size2; i11++) {
                        InterfaceC1826l interfaceC1826l2 = (InterfaceC1826l) arrayList.get(i11);
                        if ((interfaceC1826l2 instanceof C1828n) && (actionView = (c2840n = ((C1828n) interfaceC1826l2).f6446a).getActionView()) != null && (parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray2.get(c2840n.f9717a)) != null) {
                            actionView.restoreHierarchyState(parcelableSparseArray);
                        }
                    }
                }
            }
            SparseArray<Parcelable> sparseParcelableArray3 = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray3 != null) {
                this.f6451b.restoreHierarchyState(sparseParcelableArray3);
            }
        }
    }

    @Override
    public final int getId() {
        return this.f6453d;
    }

    @Override
    public final void mo712j(boolean z7) {
        C1824j c1824j = this.f6454e;
        if (c1824j != null) {
            c1824j.m4277a();
            c1824j.notifyDataSetChanged();
        }
    }

    @Override
    public final void mo713k(Context context, MenuC2838l menuC2838l) {
        this.f6455f = LayoutInflater.from(context);
        this.f6452c = menuC2838l;
        this.f6474y = context.getResources().getDimensionPixelOffset(R.dimen.design_navigation_separator_vertical_padding);
    }

    @Override
    public final boolean mo714l() {
        return false;
    }

    @Override
    public final Parcelable mo715m() {
        Bundle bundle = new Bundle();
        if (this.f6450a != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.f6450a.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        C1824j c1824j = this.f6454e;
        if (c1824j != null) {
            c1824j.getClass();
            Bundle bundle2 = new Bundle();
            C2840n c2840n = c1824j.f6441b;
            if (c2840n != null) {
                bundle2.putInt("android:menu:checked", c2840n.f9717a);
            }
            SparseArray<? extends Parcelable> sparseArray2 = new SparseArray<>();
            ArrayList arrayList = c1824j.f6440a;
            int size = arrayList.size();
            for (int i6 = 0; i6 < size; i6++) {
                InterfaceC1826l interfaceC1826l = (InterfaceC1826l) arrayList.get(i6);
                if (interfaceC1826l instanceof C1828n) {
                    C2840n c2840n2 = ((C1828n) interfaceC1826l).f6446a;
                    View actionView = c2840n2 != null ? c2840n2.getActionView() : null;
                    if (actionView != null) {
                        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                        actionView.saveHierarchyState(parcelableSparseArray);
                        sparseArray2.put(c2840n2.f9717a, parcelableSparseArray);
                    }
                }
            }
            bundle2.putSparseParcelableArray("android:menu:action_views", sparseArray2);
            bundle.putBundle("android:menu:adapter", bundle2);
        }
        if (this.f6451b != null) {
            SparseArray<Parcelable> sparseArray3 = new SparseArray<>();
            this.f6451b.saveHierarchyState(sparseArray3);
            bundle.putSparseParcelableArray("android:menu:header", sparseArray3);
        }
        return bundle;
    }

    @Override
    public final void mo707b(MenuC2838l menuC2838l, boolean z7) {
    }
}
