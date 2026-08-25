package androidx.appcompat.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.C0225k;
import androidx.appcompat.widget.C0259q3;
import androidx.appcompat.widget.C0284v3;
import androidx.appcompat.widget.Toolbar;
import com.bumptech.glide.AbstractC1465c;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import java.util.WeakHashMap;
import p000a.AbstractC0004e;
import p000a.RunnableC0005f;
import p105k.C2840n;
import p123l5.AbstractC2973a;
import p138n0.AbstractC3155s0;

public final class C0159s0 extends AbstractC2973a {

    public final C0284v3 f432r;

    public final WindowCallbackC0171z f433s;

    public final C0155q0 f434t;

    public boolean f435u;

    public boolean f436v;

    public boolean f437w;

    public final ArrayList f438x = new ArrayList();

    public final RunnableC0005f f439y = new RunnableC0005f(1, this);

    public C0159s0(Toolbar toolbar, CharSequence charSequence, WindowCallbackC0171z windowCallbackC0171z) {
        C0155q0 c0155q0 = new C0155q0(this);
        C0284v3 c0284v3 = new C0284v3(toolbar, false);
        this.f432r = c0284v3;
        windowCallbackC0171z.getClass();
        this.f433s = windowCallbackC0171z;
        c0284v3.f1108k = windowCallbackC0171z;
        toolbar.setOnMenuItemClickListener(c0155q0);
        if (!c0284v3.f1104g) {
            c0284v3.f1105h = charSequence;
            if ((c0284v3.f1099b & 8) != 0) {
                Toolbar toolbar2 = c0284v3.f1098a;
                toolbar2.setTitle(charSequence);
                if (c0284v3.f1104g) {
                    AbstractC3155s0.m6348r(toolbar2.getRootView(), charSequence);
                }
            }
        }
        this.f434t = new C0155q0(this);
    }

    @Override
    public final void mo445C() {
        this.f432r.f1098a.removeCallbacks(this.f439y);
    }

    @Override
    public final boolean mo446F(int i6, KeyEvent keyEvent) {
        Menu menuM456V = m456V();
        if (menuM456V == null) {
            return false;
        }
        menuM456V.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuM456V.performShortcut(i6, keyEvent, 0);
    }

    @Override
    public final boolean mo447G(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            mo448H();
        }
        return true;
    }

    @Override
    public final boolean mo448H() {
        return this.f432r.f1098a.m630v();
    }

    @Override
    public final void mo450K(boolean z7) {
        C0284v3 c0284v3 = this.f432r;
        c0284v3.m797a((c0284v3.f1099b & (-5)) | 4);
    }

    @Override
    public final void mo451L() {
        C0284v3 c0284v3 = this.f432r;
        Drawable drawableM3473h = AbstractC1465c.m3473h(c0284v3.f1098a.getContext(), R.drawable.quantum_ic_keyboard_arrow_down_white_36);
        c0284v3.f1103f = drawableM3473h;
        int i6 = c0284v3.f1099b & 4;
        Toolbar toolbar = c0284v3.f1098a;
        if (i6 == 0) {
            toolbar.setNavigationIcon((Drawable) null);
            return;
        }
        if (drawableM3473h == null) {
            drawableM3473h = c0284v3.f1112o;
        }
        toolbar.setNavigationIcon(drawableM3473h);
    }

    @Override
    public final void mo453O(String str) {
        this.f432r.m798b(str);
    }

    @Override
    public final void mo454P(String str) {
        C0284v3 c0284v3 = this.f432r;
        c0284v3.f1104g = true;
        c0284v3.f1105h = str;
        if ((c0284v3.f1099b & 8) != 0) {
            Toolbar toolbar = c0284v3.f1098a;
            toolbar.setTitle(str);
            if (c0284v3.f1104g) {
                AbstractC3155s0.m6348r(toolbar.getRootView(), str);
            }
        }
    }

    @Override
    public final void mo455R(CharSequence charSequence) {
        C0284v3 c0284v3 = this.f432r;
        if (c0284v3.f1104g) {
            return;
        }
        c0284v3.f1105h = charSequence;
        if ((c0284v3.f1099b & 8) != 0) {
            Toolbar toolbar = c0284v3.f1098a;
            toolbar.setTitle(charSequence);
            if (c0284v3.f1104g) {
                AbstractC3155s0.m6348r(toolbar.getRootView(), charSequence);
            }
        }
    }

    public final Menu m456V() {
        boolean z7 = this.f436v;
        C0284v3 c0284v3 = this.f432r;
        if (!z7) {
            C0157r0 c0157r0 = new C0157r0(0, this);
            C0155q0 c0155q0 = new C0155q0(this);
            Toolbar toolbar = c0284v3.f1098a;
            toolbar.f820N = c0157r0;
            toolbar.f821O = c0155q0;
            ActionMenuView actionMenuView = toolbar.f827a;
            if (actionMenuView != null) {
                actionMenuView.f581u = c0157r0;
                actionMenuView.f582v = c0155q0;
            }
            this.f436v = true;
        }
        return c0284v3.f1098a.getMenu();
    }

    @Override
    public final boolean mo457h() {
        C0225k c0225k;
        ActionMenuView actionMenuView = this.f432r.f1098a.f827a;
        return (actionMenuView == null || (c0225k = actionMenuView.f580t) == null || !c0225k.m708c()) ? false : true;
    }

    @Override
    public final boolean mo458i() {
        C2840n c2840n;
        C0259q3 c0259q3 = this.f432r.f1098a.f819M;
        if (c0259q3 == null || (c2840n = c0259q3.f1041b) == null) {
            return false;
        }
        if (c0259q3 == null) {
            c2840n = null;
        }
        if (c2840n == null) {
            return true;
        }
        c2840n.collapseActionView();
        return true;
    }

    @Override
    public final void mo459r(boolean z7) {
        if (z7 == this.f437w) {
            return;
        }
        this.f437w = z7;
        ArrayList arrayList = this.f438x;
        if (arrayList.size() > 0) {
            throw AbstractC0004e.m17k(0, arrayList);
        }
    }

    @Override
    public final int mo460u() {
        return this.f432r.f1099b;
    }

    @Override
    public final Context mo461v() {
        return this.f432r.f1098a.getContext();
    }

    @Override
    public final boolean mo462w() {
        C0284v3 c0284v3 = this.f432r;
        Toolbar toolbar = c0284v3.f1098a;
        RunnableC0005f runnableC0005f = this.f439y;
        toolbar.removeCallbacks(runnableC0005f);
        Toolbar toolbar2 = c0284v3.f1098a;
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        toolbar2.postOnAnimation(runnableC0005f);
        return true;
    }

    @Override
    public final void mo444B() {
    }

    @Override
    public final void mo449J(boolean z7) {
    }

    @Override
    public final void mo452N(boolean z7) {
    }
}
