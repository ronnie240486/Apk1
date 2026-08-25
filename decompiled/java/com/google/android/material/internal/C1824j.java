package com.google.android.material.internal;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.ViewOnClickListenerC0122a;
import androidx.recyclerview.widget.AbstractC1158k0;
import androidx.recyclerview.widget.AbstractC1174p1;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import java.util.WeakHashMap;
import p105k.C2840n;
import p105k.SubMenuC2831e0;
import p138n0.AbstractC3155s0;
import p143n5.AbstractC3198d;

public final class C1824j extends AbstractC1158k0 {

    public final ArrayList f6440a = new ArrayList();

    public C2840n f6441b;

    public boolean f6442c;

    public final C1832r f6443d;

    public C1824j(C1832r c1832r) {
        this.f6443d = c1832r;
        m4277a();
    }

    public final void m4277a() {
        if (this.f6442c) {
            return;
        }
        this.f6442c = true;
        ArrayList arrayList = this.f6440a;
        arrayList.clear();
        arrayList.add(new C1825k());
        C1832r c1832r = this.f6443d;
        int size = c1832r.f6452c.m5831l().size();
        boolean z7 = false;
        int i6 = -1;
        int i10 = 0;
        boolean z10 = false;
        int size2 = 0;
        while (i10 < size) {
            C2840n c2840n = (C2840n) c1832r.f6452c.m5831l().get(i10);
            if (c2840n.isChecked()) {
                m4278b(c2840n);
            }
            if (c2840n.isCheckable()) {
                c2840n.m5845g(z7);
            }
            if (c2840n.hasSubMenu()) {
                SubMenuC2831e0 subMenuC2831e0 = c2840n.f9731o;
                if (subMenuC2831e0.hasVisibleItems()) {
                    if (i10 != 0) {
                        arrayList.add(new C1827m(c1832r.f6474y, z7 ? 1 : 0));
                    }
                    arrayList.add(new C1828n(c2840n));
                    int size3 = subMenuC2831e0.f9692f.size();
                    int i11 = 0;
                    boolean z11 = false;
                    while (i11 < size3) {
                        C2840n c2840n2 = (C2840n) subMenuC2831e0.getItem(i11);
                        if (c2840n2.isVisible()) {
                            if (!z11 && c2840n2.getIcon() != null) {
                                z11 = true;
                            }
                            if (c2840n2.isCheckable()) {
                                c2840n2.m5845g(z7);
                            }
                            if (c2840n.isChecked()) {
                                m4278b(c2840n);
                            }
                            arrayList.add(new C1828n(c2840n2));
                        }
                        i11++;
                        z7 = false;
                    }
                    if (z11) {
                        int size4 = arrayList.size();
                        for (int size5 = arrayList.size(); size5 < size4; size5++) {
                            ((C1828n) arrayList.get(size5)).f6447b = true;
                        }
                    }
                }
            } else {
                int i12 = c2840n.f9718b;
                if (i12 != i6) {
                    size2 = arrayList.size();
                    z10 = c2840n.getIcon() != null;
                    if (i10 != 0) {
                        size2++;
                        int i13 = c1832r.f6474y;
                        arrayList.add(new C1827m(i13, i13));
                    }
                } else {
                    if (!z10 && c2840n.getIcon() != null) {
                        int size6 = arrayList.size();
                        for (int i14 = size2; i14 < size6; i14++) {
                            ((C1828n) arrayList.get(i14)).f6447b = true;
                        }
                        z10 = true;
                    }
                    C1828n c1828n = new C1828n(c2840n);
                    c1828n.f6447b = z10;
                    arrayList.add(c1828n);
                    i6 = i12;
                }
                C1828n c1828n2 = new C1828n(c2840n);
                c1828n2.f6447b = z10;
                arrayList.add(c1828n2);
                i6 = i12;
            }
            i10++;
            z7 = false;
        }
        this.f6442c = false;
    }

    public final void m4278b(C2840n c2840n) {
        if (this.f6441b == c2840n || !c2840n.isCheckable()) {
            return;
        }
        C2840n c2840n2 = this.f6441b;
        if (c2840n2 != null) {
            c2840n2.setChecked(false);
        }
        this.f6441b = c2840n;
        c2840n.setChecked(true);
    }

    @Override
    public final int getItemCount() {
        return this.f6440a.size();
    }

    @Override
    public final long getItemId(int i6) {
        return i6;
    }

    @Override
    public final int getItemViewType(int i6) {
        InterfaceC1826l interfaceC1826l = (InterfaceC1826l) this.f6440a.get(i6);
        if (interfaceC1826l instanceof C1827m) {
            return 2;
        }
        if (interfaceC1826l instanceof C1825k) {
            return 3;
        }
        if (interfaceC1826l instanceof C1828n) {
            return ((C1828n) interfaceC1826l).f6446a.hasSubMenu() ? 1 : 0;
        }
        throw new RuntimeException("Unknown item type.");
    }

    @Override
    public final void onBindViewHolder(AbstractC1174p1 abstractC1174p1, int i6) {
        AbstractC1831q abstractC1831q = (AbstractC1831q) abstractC1174p1;
        int itemViewType = getItemViewType(i6);
        ArrayList arrayList = this.f6440a;
        C1832r c1832r = this.f6443d;
        if (itemViewType != 0) {
            if (itemViewType != 1) {
                if (itemViewType != 2) {
                    return;
                }
                C1827m c1827m = (C1827m) arrayList.get(i6);
                abstractC1831q.itemView.setPadding(c1832r.f6467r, c1827m.f6444a, c1832r.f6468s, c1827m.f6445b);
                return;
            }
            TextView textView = (TextView) abstractC1831q.itemView;
            textView.setText(((C1828n) arrayList.get(i6)).f6446a.f9721e);
            int i10 = c1832r.f6456g;
            if (i10 != 0) {
                AbstractC3198d.m6443R(textView, i10);
            }
            textView.setPadding(c1832r.f6469t, textView.getPaddingTop(), 0, textView.getPaddingBottom());
            ColorStateList colorStateList = c1832r.f6457h;
            if (colorStateList != null) {
                textView.setTextColor(colorStateList);
                return;
            }
            return;
        }
        NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) abstractC1831q.itemView;
        navigationMenuItemView.setIconTintList(c1832r.f6460k);
        int i11 = c1832r.f6458i;
        if (i11 != 0) {
            navigationMenuItemView.setTextAppearance(i11);
        }
        ColorStateList colorStateList2 = c1832r.f6459j;
        if (colorStateList2 != null) {
            navigationMenuItemView.setTextColor(colorStateList2);
        }
        Drawable drawable = c1832r.f6461l;
        Drawable drawableNewDrawable = drawable != null ? drawable.getConstantState().newDrawable() : null;
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        navigationMenuItemView.setBackground(drawableNewDrawable);
        RippleDrawable rippleDrawable = c1832r.f6462m;
        if (rippleDrawable != null) {
            navigationMenuItemView.setForeground(rippleDrawable.getConstantState().newDrawable());
        }
        C1828n c1828n = (C1828n) arrayList.get(i6);
        navigationMenuItemView.setNeedsEmptyIcon(c1828n.f6447b);
        int i12 = c1832r.f6463n;
        int i13 = c1832r.f6464o;
        navigationMenuItemView.setPadding(i12, i13, i12, i13);
        navigationMenuItemView.setIconPadding(c1832r.f6465p);
        if (c1832r.f6470u) {
            navigationMenuItemView.setIconSize(c1832r.f6466q);
        }
        navigationMenuItemView.setMaxLines(c1832r.f6472w);
        navigationMenuItemView.mo532c(c1828n.f6446a);
    }

    @Override
    public final AbstractC1174p1 onCreateViewHolder(ViewGroup viewGroup, int i6) {
        AbstractC1174p1 c1830p;
        C1832r c1832r = this.f6443d;
        if (i6 == 0) {
            LayoutInflater layoutInflater = c1832r.f6455f;
            ViewOnClickListenerC0122a viewOnClickListenerC0122a = c1832r.f6449A;
            c1830p = new C1830p(layoutInflater.inflate(R.layout.design_navigation_item, viewGroup, false));
            c1830p.itemView.setOnClickListener(viewOnClickListenerC0122a);
        } else if (i6 == 1) {
            c1830p = new C1823i(c1832r.f6455f.inflate(R.layout.design_navigation_item_subheader, viewGroup, false));
        } else {
            if (i6 != 2) {
                if (i6 != 3) {
                    return null;
                }
                return new C1823i(c1832r.f6451b);
            }
            c1830p = new C1823i(c1832r.f6455f.inflate(R.layout.design_navigation_item_separator, viewGroup, false));
        }
        return c1830p;
    }

    @Override
    public final void onViewRecycled(AbstractC1174p1 abstractC1174p1) {
        AbstractC1831q abstractC1831q = (AbstractC1831q) abstractC1174p1;
        if (abstractC1831q instanceof C1830p) {
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) abstractC1831q.itemView;
            FrameLayout frameLayout = navigationMenuItemView.f6343z;
            if (frameLayout != null) {
                frameLayout.removeAllViews();
            }
            navigationMenuItemView.f6342y.setCompoundDrawables(null, null, null, null);
        }
    }
}
