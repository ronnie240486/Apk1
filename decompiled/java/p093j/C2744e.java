package p093j;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.C0225k;
import java.lang.ref.WeakReference;
import p001a0.C0023f;
import p007a7.C0069f;
import p105k.InterfaceC2836j;
import p105k.MenuC2838l;

public final class C2744e extends AbstractC2740a implements InterfaceC2836j {

    public Context f9415c;

    public ActionBarContextView f9416d;

    public C0069f f9417e;

    public WeakReference f9418f;

    public boolean f9419g;

    public MenuC2838l f9420h;

    @Override
    public final void mo473a() {
        if (this.f9419g) {
            return;
        }
        this.f9419g = true;
        this.f9417e.m222E(this);
    }

    @Override
    public final View mo474b() {
        WeakReference weakReference = this.f9418f;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override
    public final MenuC2838l mo475c() {
        return this.f9420h;
    }

    @Override
    public final MenuInflater mo476d() {
        return new C2748i(this.f9416d.getContext());
    }

    @Override
    public final CharSequence mo477e() {
        return this.f9416d.getSubtitle();
    }

    @Override
    public final CharSequence mo478f() {
        return this.f9416d.getTitle();
    }

    @Override
    public final void mo479g() {
        this.f9417e.m223F(this, this.f9420h);
    }

    @Override
    public final boolean mo480h() {
        return this.f9416d.f544s;
    }

    @Override
    public final void mo481i(View view) {
        this.f9416d.setCustomView(view);
        this.f9418f = view != null ? new WeakReference(view) : null;
    }

    @Override
    public final boolean mo94j(MenuC2838l menuC2838l, MenuItem menuItem) {
        return ((C0023f) this.f9417e.f196b).m107g(this, menuItem);
    }

    @Override
    public final void mo482k(int i6) {
        mo483l(this.f9415c.getString(i6));
    }

    @Override
    public final void mo483l(CharSequence charSequence) {
        this.f9416d.setSubtitle(charSequence);
    }

    @Override
    public final void mo484m(int i6) {
        mo485o(this.f9415c.getString(i6));
    }

    @Override
    public final void mo97n(MenuC2838l menuC2838l) {
        mo479g();
        C0225k c0225k = this.f9416d.f529d;
        if (c0225k != null) {
            c0225k.m716n();
        }
    }

    @Override
    public final void mo485o(CharSequence charSequence) {
        this.f9416d.setTitle(charSequence);
    }

    @Override
    public final void mo486p(boolean z7) {
        this.f9408b = z7;
        this.f9416d.setTitleOptional(z7);
    }
}
