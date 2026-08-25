package p105k;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import androidx.appcompat.app.C0130e;
import androidx.appcompat.app.C0138i;
import androidx.appcompat.app.DialogInterfaceC0140j;
import androidx.appcompat.view.menu.ExpandedMenuView;

public final class C2834h implements InterfaceC2851y, AdapterView.OnItemClickListener {

    public Context f9674a;

    public LayoutInflater f9675b;

    public MenuC2838l f9676c;

    public ExpandedMenuView f9677d;

    public InterfaceC2850x f9678e;

    public C2833g f9679f;

    public C2834h(ContextWrapper contextWrapper) {
        this.f9674a = contextWrapper;
        this.f9675b = LayoutInflater.from(contextWrapper);
    }

    @Override
    public final void mo707b(MenuC2838l menuC2838l, boolean z7) {
        InterfaceC2850x interfaceC2850x = this.f9678e;
        if (interfaceC2850x != null) {
            interfaceC2850x.mo86b(menuC2838l, z7);
        }
    }

    @Override
    public final boolean mo763d(C2840n c2840n) {
        return false;
    }

    @Override
    public final boolean mo709e(SubMenuC2831e0 subMenuC2831e0) {
        if (!subMenuC2831e0.hasVisibleItems()) {
            return false;
        }
        DialogInterfaceOnKeyListenerC2839m dialogInterfaceOnKeyListenerC2839m = new DialogInterfaceOnKeyListenerC2839m();
        dialogInterfaceOnKeyListenerC2839m.f9711a = subMenuC2831e0;
        Context context = subMenuC2831e0.f9687a;
        C0138i c0138i = new C0138i(context);
        C0130e c0130e = c0138i.f383a;
        C2834h c2834h = new C2834h(c0130e.f273a);
        dialogInterfaceOnKeyListenerC2839m.f9713c = c2834h;
        c2834h.f9678e = dialogInterfaceOnKeyListenerC2839m;
        subMenuC2831e0.m5826b(c2834h, context);
        C2834h c2834h2 = dialogInterfaceOnKeyListenerC2839m.f9713c;
        if (c2834h2.f9679f == null) {
            c2834h2.f9679f = new C2833g(c2834h2);
        }
        c0130e.f279g = c2834h2.f9679f;
        c0130e.f280h = dialogInterfaceOnKeyListenerC2839m;
        View view = subMenuC2831e0.f9701o;
        if (view != null) {
            c0130e.f277e = view;
        } else {
            c0130e.f275c = subMenuC2831e0.f9700n;
            c0130e.f276d = subMenuC2831e0.f9699m;
        }
        c0130e.f278f = dialogInterfaceOnKeyListenerC2839m;
        DialogInterfaceC0140j dialogInterfaceC0140jM417a = c0138i.m417a();
        dialogInterfaceOnKeyListenerC2839m.f9712b = dialogInterfaceC0140jM417a;
        dialogInterfaceC0140jM417a.setOnDismissListener(dialogInterfaceOnKeyListenerC2839m);
        WindowManager.LayoutParams attributes = dialogInterfaceOnKeyListenerC2839m.f9712b.getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= 131072;
        dialogInterfaceOnKeyListenerC2839m.f9712b.show();
        InterfaceC2850x interfaceC2850x = this.f9678e;
        if (interfaceC2850x == null) {
            return true;
        }
        interfaceC2850x.mo90f(subMenuC2831e0);
        return true;
    }

    @Override
    public final boolean mo764f(C2840n c2840n) {
        return false;
    }

    @Override
    public final void mo710g(Parcelable parcelable) {
        SparseArray<Parcelable> sparseParcelableArray = ((Bundle) parcelable).getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f9677d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    @Override
    public final int getId() {
        return 0;
    }

    @Override
    public final void mo5804i(InterfaceC2850x interfaceC2850x) {
        throw null;
    }

    @Override
    public final void mo712j(boolean z7) {
        C2833g c2833g = this.f9679f;
        if (c2833g != null) {
            c2833g.notifyDataSetChanged();
        }
    }

    @Override
    public final void mo713k(Context context, MenuC2838l menuC2838l) {
        if (this.f9674a != null) {
            this.f9674a = context;
            if (this.f9675b == null) {
                this.f9675b = LayoutInflater.from(context);
            }
        }
        this.f9676c = menuC2838l;
        C2833g c2833g = this.f9679f;
        if (c2833g != null) {
            c2833g.notifyDataSetChanged();
        }
    }

    @Override
    public final boolean mo714l() {
        return false;
    }

    @Override
    public final Parcelable mo715m() {
        if (this.f9677d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        ExpandedMenuView expandedMenuView = this.f9677d;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        return bundle;
    }

    @Override
    public final void onItemClick(AdapterView adapterView, View view, int i6, long j10) {
        this.f9676c.m5832q(this.f9679f.getItem(i6), this, 0);
    }
}
