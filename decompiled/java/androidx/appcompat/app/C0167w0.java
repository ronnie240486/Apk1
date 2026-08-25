package androidx.appcompat.app;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.C0225k;
import java.lang.ref.WeakReference;
import p001a0.C0023f;
import p007a7.C0069f;
import p093j.AbstractC2740a;
import p093j.C2748i;
import p105k.InterfaceC2836j;
import p105k.MenuC2838l;

public final class C0167w0 extends AbstractC2740a implements InterfaceC2836j {

    public final Context f450c;

    public final MenuC2838l f451d;

    public C0069f f452e;

    public WeakReference f453f;

    public final C0169x0 f454g;

    public C0167w0(C0169x0 c0169x0, Context context, C0069f c0069f) {
        this.f454g = c0169x0;
        this.f450c = context;
        this.f452e = c0069f;
        MenuC2838l menuC2838l = new MenuC2838l(context);
        menuC2838l.f9698l = 1;
        this.f451d = menuC2838l;
        menuC2838l.f9691e = this;
    }

    @Override
    public final void mo473a() {
        C0169x0 c0169x0 = this.f454g;
        if (c0169x0.f480z != this) {
            return;
        }
        if (c0169x0.f463G) {
            c0169x0.f457A = this;
            c0169x0.f458B = this.f452e;
        } else {
            this.f452e.m222E(this);
        }
        this.f452e = null;
        c0169x0.m518V(false);
        ActionBarContextView actionBarContextView = c0169x0.f477w;
        if (actionBarContextView.f536k == null) {
            actionBarContextView.m543e();
        }
        c0169x0.f474t.setHideOnContentScrollEnabled(c0169x0.f468L);
        c0169x0.f480z = null;
    }

    @Override
    public final View mo474b() {
        WeakReference weakReference = this.f453f;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override
    public final MenuC2838l mo475c() {
        return this.f451d;
    }

    @Override
    public final MenuInflater mo476d() {
        return new C2748i(this.f450c);
    }

    @Override
    public final CharSequence mo477e() {
        return this.f454g.f477w.getSubtitle();
    }

    @Override
    public final CharSequence mo478f() {
        return this.f454g.f477w.getTitle();
    }

    @Override
    public final void mo479g() {
        if (this.f454g.f480z != this) {
            return;
        }
        MenuC2838l menuC2838l = this.f451d;
        menuC2838l.m5840y();
        try {
            this.f452e.m223F(this, menuC2838l);
        } finally {
            menuC2838l.m5839x();
        }
    }

    @Override
    public final boolean mo480h() {
        return this.f454g.f477w.f544s;
    }

    @Override
    public final void mo481i(View view) {
        this.f454g.f477w.setCustomView(view);
        this.f453f = new WeakReference(view);
    }

    @Override
    public final boolean mo94j(MenuC2838l menuC2838l, MenuItem menuItem) {
        C0069f c0069f = this.f452e;
        if (c0069f != null) {
            return ((C0023f) c0069f.f196b).m107g(this, menuItem);
        }
        return false;
    }

    @Override
    public final void mo482k(int i6) {
        mo483l(this.f454g.f472r.getResources().getString(i6));
    }

    @Override
    public final void mo483l(CharSequence charSequence) {
        this.f454g.f477w.setSubtitle(charSequence);
    }

    @Override
    public final void mo484m(int i6) {
        mo485o(this.f454g.f472r.getResources().getString(i6));
    }

    @Override
    public final void mo97n(MenuC2838l menuC2838l) {
        if (this.f452e == null) {
            return;
        }
        mo479g();
        C0225k c0225k = this.f454g.f477w.f529d;
        if (c0225k != null) {
            c0225k.m716n();
        }
    }

    @Override
    public final void mo485o(CharSequence charSequence) {
        this.f454g.f477w.setTitle(charSequence);
    }

    @Override
    public final void mo486p(boolean z7) {
        this.f9408b = z7;
        this.f454g.f477w.setTitleOptional(z7);
    }
}
