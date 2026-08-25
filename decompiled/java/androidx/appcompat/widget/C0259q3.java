package androidx.appcompat.widget;

import android.content.Context;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;
import p093j.InterfaceC2741b;
import p105k.C2840n;
import p105k.InterfaceC2851y;
import p105k.MenuC2838l;
import p105k.SubMenuC2831e0;

public final class C0259q3 implements InterfaceC2851y {

    public MenuC2838l f1040a;

    public C2840n f1041b;

    public final Toolbar f1042c;

    public C0259q3(Toolbar toolbar) {
        this.f1042c = toolbar;
    }

    @Override
    public final boolean mo763d(C2840n c2840n) {
        Toolbar toolbar = this.f1042c;
        toolbar.m615c();
        ViewParent parent = toolbar.f834h.getParent();
        if (parent != toolbar) {
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(toolbar.f834h);
            }
            toolbar.addView(toolbar.f834h);
        }
        View actionView = c2840n.getActionView();
        toolbar.f835i = actionView;
        this.f1041b = c2840n;
        ViewParent parent2 = actionView.getParent();
        if (parent2 != toolbar) {
            if (parent2 instanceof ViewGroup) {
                ((ViewGroup) parent2).removeView(toolbar.f835i);
            }
            Toolbar.LayoutParams layoutParamsM609h = Toolbar.m609h();
            layoutParamsM609h.f247a = (toolbar.f840n & 112) | 8388611;
            layoutParamsM609h.f853b = 2;
            toolbar.f835i.setLayoutParams(layoutParamsM609h);
            toolbar.addView(toolbar.f835i);
        }
        for (int childCount = toolbar.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = toolbar.getChildAt(childCount);
            if (((Toolbar.LayoutParams) childAt.getLayoutParams()).f853b != 2 && childAt != toolbar.f827a) {
                toolbar.removeViewAt(childCount);
                toolbar.f811E.add(childAt);
            }
        }
        toolbar.requestLayout();
        c2840n.f9716C = true;
        c2840n.f9730n.mo4279p(false);
        KeyEvent.Callback callback = toolbar.f835i;
        if (callback instanceof InterfaceC2741b) {
            ((InterfaceC2741b) callback).mo588b();
        }
        toolbar.m631w();
        return true;
    }

    @Override
    public final boolean mo709e(SubMenuC2831e0 subMenuC2831e0) {
        return false;
    }

    @Override
    public final boolean mo764f(C2840n c2840n) {
        Toolbar toolbar = this.f1042c;
        KeyEvent.Callback callback = toolbar.f835i;
        if (callback instanceof InterfaceC2741b) {
            ((InterfaceC2741b) callback).mo589e();
        }
        toolbar.removeView(toolbar.f835i);
        toolbar.removeView(toolbar.f834h);
        toolbar.f835i = null;
        ArrayList arrayList = toolbar.f811E;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            toolbar.addView((View) arrayList.get(size));
        }
        arrayList.clear();
        this.f1041b = null;
        toolbar.requestLayout();
        c2840n.f9716C = false;
        c2840n.f9730n.mo4279p(false);
        toolbar.m631w();
        return true;
    }

    @Override
    public final int getId() {
        return 0;
    }

    @Override
    public final void mo712j(boolean z7) {
        if (this.f1041b != null) {
            MenuC2838l menuC2838l = this.f1040a;
            if (menuC2838l != null) {
                int size = menuC2838l.f9692f.size();
                for (int i6 = 0; i6 < size; i6++) {
                    if (this.f1040a.getItem(i6) == this.f1041b) {
                        return;
                    }
                }
            }
            mo764f(this.f1041b);
        }
    }

    @Override
    public final void mo713k(Context context, MenuC2838l menuC2838l) {
        C2840n c2840n;
        MenuC2838l menuC2838l2 = this.f1040a;
        if (menuC2838l2 != null && (c2840n = this.f1041b) != null) {
            menuC2838l2.mo5813d(c2840n);
        }
        this.f1040a = menuC2838l;
    }

    @Override
    public final boolean mo714l() {
        return false;
    }

    @Override
    public final Parcelable mo715m() {
        return null;
    }

    @Override
    public final void mo710g(Parcelable parcelable) {
    }

    @Override
    public final void mo707b(MenuC2838l menuC2838l, boolean z7) {
    }
}
