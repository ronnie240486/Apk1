package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import p001a0.C0019b;
import p105k.AbstractC2826c;
import p105k.AbstractC2846t;
import p105k.C2840n;
import p105k.InterfaceC2850x;
import p105k.InterfaceC2852z;
import p105k.MenuC2838l;
import p105k.SubMenuC2831e0;
import p138n0.AbstractC3106c;

public final class C0225k extends AbstractC2826c {

    public C0215i f961j;

    public Drawable f962k;

    public boolean f963l;

    public boolean f964m;

    public boolean f965n;

    public int f966o;

    public int f967p;

    public int f968q;

    public boolean f969r;

    public final SparseBooleanArray f970s;

    public C0195e f971t;

    public C0195e f972u;

    public RunnableC0205g f973v;

    public C0200f f974w;

    public final C0019b f975x;

    public int f976y;

    public C0225k(Context context) {
        this.f9609a = context;
        this.f9612d = LayoutInflater.from(context);
        this.f9614f = R.layout.abc_action_menu_layout;
        this.f9615g = R.layout.abc_action_menu_item_layout;
        this.f970s = new SparseBooleanArray();
        this.f975x = new C0019b(4, this);
    }

    public final View m706a(C2840n c2840n, View view, ViewGroup viewGroup) {
        InterfaceC2852z interfaceC2852z;
        View actionView = c2840n.getActionView();
        if (actionView == null || c2840n.m5843e()) {
            if (view instanceof InterfaceC2852z) {
                interfaceC2852z = (InterfaceC2852z) view;
            } else {
                interfaceC2852z = (InterfaceC2852z) this.f9612d.inflate(this.f9615g, viewGroup, false);
            }
            interfaceC2852z.mo532c(c2840n);
            ActionMenuItemView actionMenuItemView = (ActionMenuItemView) interfaceC2852z;
            actionMenuItemView.setItemInvoker((ActionMenuView) this.f9616h);
            if (this.f974w == null) {
                this.f974w = new C0200f(this);
            }
            actionMenuItemView.setPopupCallback(this.f974w);
            actionView = (View) interfaceC2852z;
        }
        actionView.setVisibility(c2840n.f9716C ? 8 : 0);
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        ((ActionMenuView) viewGroup).getClass();
        if (!(layoutParams instanceof ActionMenuView.LayoutParams)) {
            actionView.setLayoutParams(ActionMenuView.m559m(layoutParams));
        }
        return actionView;
    }

    @Override
    public final void mo707b(MenuC2838l menuC2838l, boolean z7) {
        m708c();
        C0195e c0195e = this.f972u;
        if (c0195e != null && c0195e.m5855b()) {
            c0195e.f9763i.dismiss();
        }
        InterfaceC2850x interfaceC2850x = this.f9613e;
        if (interfaceC2850x != null) {
            interfaceC2850x.mo86b(menuC2838l, z7);
        }
    }

    public final boolean m708c() {
        Object obj;
        RunnableC0205g runnableC0205g = this.f973v;
        if (runnableC0205g != null && (obj = this.f9616h) != null) {
            ((View) obj).removeCallbacks(runnableC0205g);
            this.f973v = null;
            return true;
        }
        C0195e c0195e = this.f971t;
        if (c0195e == null) {
            return false;
        }
        if (c0195e.m5855b()) {
            c0195e.f9763i.dismiss();
        }
        return true;
    }

    @Override
    public final boolean mo709e(SubMenuC2831e0 subMenuC2831e0) {
        boolean z7;
        if (!subMenuC2831e0.hasVisibleItems()) {
            return false;
        }
        SubMenuC2831e0 subMenuC2831e1 = subMenuC2831e0;
        while (true) {
            MenuC2838l menuC2838l = subMenuC2831e1.f9646z;
            if (menuC2838l == this.f9611c) {
                break;
            }
            subMenuC2831e1 = (SubMenuC2831e0) menuC2838l;
        }
        ViewGroup viewGroup = (ViewGroup) this.f9616h;
        View view = null;
        view = null;
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = viewGroup.getChildAt(i6);
                if ((childAt instanceof InterfaceC2852z) && ((InterfaceC2852z) childAt).getItemData() == subMenuC2831e1.f9645A) {
                    view = childAt;
                    break;
                }
            }
        }
        if (view == null) {
            return false;
        }
        this.f976y = subMenuC2831e0.f9645A.f9717a;
        int size = subMenuC2831e0.f9692f.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                z7 = false;
                break;
            }
            MenuItem item = subMenuC2831e0.getItem(i10);
            if (item.isVisible() && item.getIcon() != null) {
                z7 = true;
                break;
            }
            i10++;
        }
        C0195e c0195e = new C0195e(this, this.f9610b, subMenuC2831e0, view);
        this.f972u = c0195e;
        c0195e.f9761g = z7;
        AbstractC2846t abstractC2846t = c0195e.f9763i;
        if (abstractC2846t != null) {
            abstractC2846t.mo5807q(z7);
        }
        C0195e c0195e2 = this.f972u;
        if (!c0195e2.m5855b()) {
            if (c0195e2.f9759e == null) {
                throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
            }
            c0195e2.m5856d(0, 0, false, false);
        }
        InterfaceC2850x interfaceC2850x = this.f9613e;
        if (interfaceC2850x != null) {
            interfaceC2850x.mo90f(subMenuC2831e0);
        }
        return true;
    }

    @Override
    public final void mo710g(Parcelable parcelable) {
        int i6;
        MenuItem menuItemFindItem;
        if ((parcelable instanceof ActionMenuPresenter$SavedState) && (i6 = ((ActionMenuPresenter$SavedState) parcelable).f574a) > 0 && (menuItemFindItem = this.f9611c.findItem(i6)) != null) {
            mo709e((SubMenuC2831e0) menuItemFindItem.getSubMenu());
        }
    }

    public final boolean m711h() {
        C0195e c0195e = this.f971t;
        return c0195e != null && c0195e.m5855b();
    }

    @Override
    public final void mo712j(boolean z7) {
        int i6;
        ViewGroup viewGroup = (ViewGroup) this.f9616h;
        ArrayList arrayList = null;
        boolean z10 = false;
        if (viewGroup != null) {
            MenuC2838l menuC2838l = this.f9611c;
            if (menuC2838l != null) {
                menuC2838l.m5830i();
                ArrayList arrayListM5831l = this.f9611c.m5831l();
                int size = arrayListM5831l.size();
                i6 = 0;
                for (int i10 = 0; i10 < size; i10++) {
                    C2840n c2840n = (C2840n) arrayListM5831l.get(i10);
                    if (c2840n.m5844f()) {
                        View childAt = viewGroup.getChildAt(i6);
                        C2840n itemData = childAt instanceof InterfaceC2852z ? ((InterfaceC2852z) childAt).getItemData() : null;
                        View viewM706a = m706a(c2840n, childAt, viewGroup);
                        if (c2840n != itemData) {
                            viewM706a.setPressed(false);
                            viewM706a.jumpDrawablesToCurrentState();
                        }
                        if (viewM706a != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) viewM706a.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(viewM706a);
                            }
                            ((ViewGroup) this.f9616h).addView(viewM706a, i6);
                        }
                        i6++;
                    }
                }
            } else {
                i6 = 0;
            }
            while (i6 < viewGroup.getChildCount()) {
                if (viewGroup.getChildAt(i6) == this.f961j) {
                    i6++;
                } else {
                    viewGroup.removeViewAt(i6);
                }
            }
        }
        ((View) this.f9616h).requestLayout();
        MenuC2838l menuC2838l2 = this.f9611c;
        if (menuC2838l2 != null) {
            menuC2838l2.m5830i();
            ArrayList arrayList2 = menuC2838l2.f9695i;
            int size2 = arrayList2.size();
            for (int i11 = 0; i11 < size2; i11++) {
                AbstractC3106c abstractC3106c = ((C2840n) arrayList2.get(i11)).f9714A;
                if (abstractC3106c != null) {
                    abstractC3106c.f10578a = this;
                }
            }
        }
        MenuC2838l menuC2838l3 = this.f9611c;
        if (menuC2838l3 != null) {
            menuC2838l3.m5830i();
            arrayList = menuC2838l3.f9696j;
        }
        if (this.f964m && arrayList != null) {
            int size3 = arrayList.size();
            if (size3 == 1) {
                z10 = !((C2840n) arrayList.get(0)).f9716C;
            } else if (size3 > 0) {
                z10 = true;
            }
        }
        if (z10) {
            if (this.f961j == null) {
                this.f961j = new C0215i(this, this.f9609a);
            }
            ViewGroup viewGroup3 = (ViewGroup) this.f961j.getParent();
            if (viewGroup3 != this.f9616h) {
                if (viewGroup3 != null) {
                    viewGroup3.removeView(this.f961j);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f9616h;
                C0215i c0215i = this.f961j;
                actionMenuView.getClass();
                ActionMenuView.LayoutParams layoutParamsM558l = ActionMenuView.m558l();
                layoutParamsM558l.f587a = true;
                actionMenuView.addView(c0215i, layoutParamsM558l);
            }
        } else {
            C0215i c0215i2 = this.f961j;
            if (c0215i2 != null) {
                Object parent = c0215i2.getParent();
                Object obj = this.f9616h;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.f961j);
                }
            }
        }
        ((ActionMenuView) this.f9616h).setOverflowReserved(this.f964m);
    }

    @Override
    public final void mo713k(Context context, MenuC2838l menuC2838l) {
        this.f9610b = context;
        LayoutInflater.from(context);
        this.f9611c = menuC2838l;
        Resources resources = context.getResources();
        if (!this.f965n) {
            this.f964m = true;
        }
        int i6 = 2;
        this.f966o = context.getResources().getDisplayMetrics().widthPixels / 2;
        Configuration configuration = context.getResources().getConfiguration();
        int i10 = configuration.screenWidthDp;
        int i11 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i10 > 600 || ((i10 > 960 && i11 > 720) || (i10 > 720 && i11 > 960))) {
            i6 = 5;
        } else if (i10 >= 500 || ((i10 > 640 && i11 > 480) || (i10 > 480 && i11 > 640))) {
            i6 = 4;
        } else if (i10 >= 360) {
            i6 = 3;
        }
        this.f968q = i6;
        int measuredWidth = this.f966o;
        if (this.f964m) {
            if (this.f961j == null) {
                C0215i c0215i = new C0215i(this, this.f9609a);
                this.f961j = c0215i;
                if (this.f963l) {
                    c0215i.setImageDrawable(this.f962k);
                    this.f962k = null;
                    this.f963l = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f961j.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.f961j.getMeasuredWidth();
        } else {
            this.f961j = null;
        }
        this.f967p = measuredWidth;
        float f = resources.getDisplayMetrics().density;
    }

    @Override
    public final boolean mo714l() {
        ArrayList arrayListM5831l;
        int size;
        int i6;
        boolean z7;
        MenuC2838l menuC2838l = this.f9611c;
        if (menuC2838l != null) {
            arrayListM5831l = menuC2838l.m5831l();
            size = arrayListM5831l.size();
        } else {
            arrayListM5831l = null;
            size = 0;
        }
        int i10 = this.f968q;
        int i11 = this.f967p;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.f9616h;
        int i12 = 0;
        boolean z10 = false;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            i6 = 2;
            z7 = true;
            if (i12 >= size) {
                break;
            }
            C2840n c2840n = (C2840n) arrayListM5831l.get(i12);
            int i15 = c2840n.f9741y;
            if ((i15 & 2) == 2) {
                i13++;
            } else if ((i15 & 1) == 1) {
                i14++;
            } else {
                z10 = true;
            }
            if (this.f969r && c2840n.f9716C) {
                i10 = 0;
            }
            i12++;
        }
        if (this.f964m && (z10 || i14 + i13 > i10)) {
            i10--;
        }
        int i16 = i10 - i13;
        SparseBooleanArray sparseBooleanArray = this.f970s;
        sparseBooleanArray.clear();
        int i17 = 0;
        int i18 = 0;
        while (i17 < size) {
            C2840n c2840n2 = (C2840n) arrayListM5831l.get(i17);
            int i19 = c2840n2.f9741y;
            boolean z11 = (i19 & 2) == i6;
            int i20 = c2840n2.f9718b;
            if (z11) {
                View viewM706a = m706a(c2840n2, null, viewGroup);
                viewM706a.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                int measuredWidth = viewM706a.getMeasuredWidth();
                i11 -= measuredWidth;
                if (i18 == 0) {
                    i18 = measuredWidth;
                }
                if (i20 != 0) {
                    sparseBooleanArray.put(i20, z7);
                }
                c2840n2.m5846h(z7);
            } else {
                if ((i19 & 1) == z7) {
                    boolean z12 = sparseBooleanArray.get(i20);
                    boolean z13 = (i16 > 0 || z12) && i11 > 0;
                    if (z13) {
                        View viewM706a2 = m706a(c2840n2, null, viewGroup);
                        viewM706a2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                        int measuredWidth2 = viewM706a2.getMeasuredWidth();
                        i11 -= measuredWidth2;
                        if (i18 == 0) {
                            i18 = measuredWidth2;
                        }
                        z13 &= i11 + i18 > 0;
                    }
                    if (z13 && i20 != 0) {
                        sparseBooleanArray.put(i20, true);
                    } else if (z12) {
                        sparseBooleanArray.put(i20, false);
                        for (int i21 = 0; i21 < i17; i21++) {
                            C2840n c2840n3 = (C2840n) arrayListM5831l.get(i21);
                            if (c2840n3.f9718b == i20) {
                                if (c2840n3.m5844f()) {
                                    i16++;
                                }
                                c2840n3.m5846h(false);
                            }
                        }
                    }
                    if (z13) {
                        i16--;
                    }
                    c2840n2.m5846h(z13);
                } else {
                    c2840n2.m5846h(false);
                }
                i17++;
                i6 = 2;
                z7 = true;
            }
            i17++;
            i6 = 2;
            z7 = true;
        }
        return true;
    }

    @Override
    public final Parcelable mo715m() {
        ActionMenuPresenter$SavedState actionMenuPresenter$SavedState = new ActionMenuPresenter$SavedState();
        actionMenuPresenter$SavedState.f574a = this.f976y;
        return actionMenuPresenter$SavedState;
    }

    public final boolean m716n() {
        MenuC2838l menuC2838l;
        if (!this.f964m || m711h() || (menuC2838l = this.f9611c) == null || this.f9616h == null || this.f973v != null) {
            return false;
        }
        menuC2838l.m5830i();
        if (menuC2838l.f9696j.isEmpty()) {
            return false;
        }
        RunnableC0205g runnableC0205g = new RunnableC0205g(this, new C0195e(this, this.f9610b, this.f9611c, this.f961j));
        this.f973v = runnableC0205g;
        ((View) this.f9616h).post(runnableC0205g);
        return true;
    }
}
