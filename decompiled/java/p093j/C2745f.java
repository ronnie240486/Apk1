package p093j;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import p105k.MenuC2825b0;

public final class C2745f extends ActionMode {

    public final Context f9421a;

    public final AbstractC2740a f9422b;

    public C2745f(Context context, AbstractC2740a abstractC2740a) {
        this.f9421a = context;
        this.f9422b = abstractC2740a;
    }

    @Override
    public final void finish() {
        this.f9422b.mo473a();
    }

    @Override
    public final View getCustomView() {
        return this.f9422b.mo474b();
    }

    @Override
    public final Menu getMenu() {
        return new MenuC2825b0(this.f9421a, this.f9422b.mo475c());
    }

    @Override
    public final MenuInflater getMenuInflater() {
        return this.f9422b.mo476d();
    }

    @Override
    public final CharSequence getSubtitle() {
        return this.f9422b.mo477e();
    }

    @Override
    public final Object getTag() {
        return this.f9422b.f9407a;
    }

    @Override
    public final CharSequence getTitle() {
        return this.f9422b.mo478f();
    }

    @Override
    public final boolean getTitleOptionalHint() {
        return this.f9422b.f9408b;
    }

    @Override
    public final void invalidate() {
        this.f9422b.mo479g();
    }

    @Override
    public final boolean isTitleOptional() {
        return this.f9422b.mo480h();
    }

    @Override
    public final void setCustomView(View view) {
        this.f9422b.mo481i(view);
    }

    @Override
    public final void setSubtitle(CharSequence charSequence) {
        this.f9422b.mo483l(charSequence);
    }

    @Override
    public final void setTag(Object obj) {
        this.f9422b.f9407a = obj;
    }

    @Override
    public final void setTitle(CharSequence charSequence) {
        this.f9422b.mo485o(charSequence);
    }

    @Override
    public final void setTitleOptionalHint(boolean z7) {
        this.f9422b.mo486p(z7);
    }

    @Override
    public final void setSubtitle(int i6) {
        this.f9422b.mo482k(i6);
    }

    @Override
    public final void setTitle(int i6) {
        this.f9422b.mo484m(i6);
    }
}
