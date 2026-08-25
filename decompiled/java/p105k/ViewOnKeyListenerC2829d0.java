package p105k;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.C0218i2;
import androidx.appcompat.widget.C0267s1;
import androidx.appcompat.widget.ViewTreeObserverOnGlobalLayoutListenerC0255q;
import com.google.android.material.textfield.ViewOnAttachStateChangeListenerC1873k;
import com.p2serv.android.p032ds.R;
import java.util.WeakHashMap;
import p138n0.AbstractC3155s0;

public final class ViewOnKeyListenerC2829d0 extends AbstractC2846t implements PopupWindow.OnDismissListener, View.OnKeyListener {

    public final Context f9623b;

    public final MenuC2838l f9624c;

    public final C2835i f9625d;

    public final boolean f9626e;

    public final int f9627f;

    public final int f9628g;

    public final C0218i2 f9629h;

    public C2847u f9632k;

    public View f9633l;

    public View f9634m;

    public InterfaceC2850x f9635n;

    public ViewTreeObserver f9636o;

    public boolean f9637p;

    public boolean f9638q;

    public int f9639r;

    public boolean f9641t;

    public final ViewTreeObserverOnGlobalLayoutListenerC0255q f9630i = new ViewTreeObserverOnGlobalLayoutListenerC0255q(5, this);

    public final ViewOnAttachStateChangeListenerC1873k f9631j = new ViewOnAttachStateChangeListenerC1873k(2, this);

    public int f9640s = 0;

    public ViewOnKeyListenerC2829d0(int i6, Context context, View view, MenuC2838l menuC2838l, boolean z7) {
        this.f9623b = context;
        this.f9624c = menuC2838l;
        this.f9626e = z7;
        this.f9625d = new C2835i(menuC2838l, LayoutInflater.from(context), z7, R.layout.abc_popup_menu_item_layout);
        this.f9628g = i6;
        Resources resources = context.getResources();
        this.f9627f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f9633l = view;
        this.f9629h = new C0218i2(context, null, i6, 0);
        menuC2838l.m5826b(this, context);
    }

    @Override
    public final void mo576a() {
        View view;
        if (mo578c()) {
            return;
        }
        if (this.f9637p || (view = this.f9633l) == null) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
        this.f9634m = view;
        C0218i2 c0218i2 = this.f9629h;
        c0218i2.f715y.setOnDismissListener(this);
        c0218i2.f706p = this;
        c0218i2.f714x = true;
        c0218i2.f715y.setFocusable(true);
        View view2 = this.f9634m;
        boolean z7 = this.f9636o == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f9636o = viewTreeObserver;
        if (z7) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f9630i);
        }
        view2.addOnAttachStateChangeListener(this.f9631j);
        c0218i2.f705o = view2;
        c0218i2.f702l = this.f9640s;
        boolean z10 = this.f9638q;
        Context context = this.f9623b;
        C2835i c2835i = this.f9625d;
        if (!z10) {
            this.f9639r = AbstractC2846t.m5851o(c2835i, context, this.f9627f);
            this.f9638q = true;
        }
        c0218i2.m587r(this.f9639r);
        c0218i2.f715y.setInputMethodMode(2);
        Rect rect = this.f9753a;
        c0218i2.f713w = rect != null ? new Rect(rect) : null;
        c0218i2.mo576a();
        C0267s1 c0267s1 = c0218i2.f693c;
        c0267s1.setOnKeyListener(this);
        if (this.f9641t) {
            MenuC2838l menuC2838l = this.f9624c;
            if (menuC2838l.f9699m != null) {
                FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) c0267s1, false);
                TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
                if (textView != null) {
                    textView.setText(menuC2838l.f9699m);
                }
                frameLayout.setEnabled(false);
                c0267s1.addHeaderView(frameLayout, null, false);
            }
        }
        c0218i2.mo586q(c2835i);
        c0218i2.mo576a();
    }

    @Override
    public final void mo707b(MenuC2838l menuC2838l, boolean z7) {
        if (menuC2838l != this.f9624c) {
            return;
        }
        dismiss();
        InterfaceC2850x interfaceC2850x = this.f9635n;
        if (interfaceC2850x != null) {
            interfaceC2850x.mo86b(menuC2838l, z7);
        }
    }

    @Override
    public final boolean mo578c() {
        return !this.f9637p && this.f9629h.f715y.isShowing();
    }

    @Override
    public final void dismiss() {
        if (mo578c()) {
            this.f9629h.dismiss();
        }
    }

    @Override
    public final boolean mo709e(SubMenuC2831e0 subMenuC2831e0) {
        if (subMenuC2831e0.hasVisibleItems()) {
            View view = this.f9634m;
            C2849w c2849w = new C2849w(this.f9628g, this.f9623b, view, subMenuC2831e0, this.f9626e);
            InterfaceC2850x interfaceC2850x = this.f9635n;
            c2849w.f9762h = interfaceC2850x;
            AbstractC2846t abstractC2846t = c2849w.f9763i;
            if (abstractC2846t != null) {
                abstractC2846t.mo5804i(interfaceC2850x);
            }
            boolean zM5852w = AbstractC2846t.m5852w(subMenuC2831e0);
            c2849w.f9761g = zM5852w;
            AbstractC2846t abstractC2846t2 = c2849w.f9763i;
            if (abstractC2846t2 != null) {
                abstractC2846t2.mo5807q(zM5852w);
            }
            c2849w.f9764j = this.f9632k;
            this.f9632k = null;
            this.f9624c.m5827c(false);
            C0218i2 c0218i2 = this.f9629h;
            int width = c0218i2.f696f;
            int iM585o = c0218i2.m585o();
            int i6 = this.f9640s;
            View view2 = this.f9633l;
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            if ((Gravity.getAbsoluteGravity(i6, view2.getLayoutDirection()) & 7) == 5) {
                width += this.f9633l.getWidth();
            }
            if (!c2849w.m5855b()) {
                if (c2849w.f9759e != null) {
                    c2849w.m5856d(width, iM585o, true, true);
                }
            }
            InterfaceC2850x interfaceC2850x2 = this.f9635n;
            if (interfaceC2850x2 != null) {
                interfaceC2850x2.mo90f(subMenuC2831e0);
            }
            return true;
        }
        return false;
    }

    @Override
    public final C0267s1 mo581h() {
        return this.f9629h.f693c;
    }

    @Override
    public final void mo5804i(InterfaceC2850x interfaceC2850x) {
        this.f9635n = interfaceC2850x;
    }

    @Override
    public final void mo712j(boolean z7) {
        this.f9638q = false;
        C2835i c2835i = this.f9625d;
        if (c2835i != null) {
            c2835i.notifyDataSetChanged();
        }
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
    public final void onDismiss() {
        this.f9637p = true;
        this.f9624c.m5827c(true);
        ViewTreeObserver viewTreeObserver = this.f9636o;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f9636o = this.f9634m.getViewTreeObserver();
            }
            this.f9636o.removeGlobalOnLayoutListener(this.f9630i);
            this.f9636o = null;
        }
        this.f9634m.removeOnAttachStateChangeListener(this.f9631j);
        C2847u c2847u = this.f9632k;
        if (c2847u != null) {
            c2847u.onDismiss();
        }
    }

    @Override
    public final boolean onKey(View view, int i6, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i6 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override
    public final void mo5806p(View view) {
        this.f9633l = view;
    }

    @Override
    public final void mo5807q(boolean z7) {
        this.f9625d.f9682c = z7;
    }

    @Override
    public final void mo5808r(int i6) {
        this.f9640s = i6;
    }

    @Override
    public final void mo5809s(int i6) {
        this.f9629h.f696f = i6;
    }

    @Override
    public final void mo5810t(PopupWindow.OnDismissListener onDismissListener) {
        this.f9632k = (C2847u) onDismissListener;
    }

    @Override
    public final void mo5811u(boolean z7) {
        this.f9641t = z7;
    }

    @Override
    public final void mo5812v(int i6) {
        this.f9629h.m583j(i6);
    }

    @Override
    public final void mo710g(Parcelable parcelable) {
    }

    @Override
    public final void mo5805n(MenuC2838l menuC2838l) {
    }
}
