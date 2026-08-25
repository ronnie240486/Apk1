package p268z1;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;

public final class C4298m extends Drawable.ConstantState {

    public final Drawable.ConstantState f14583a;

    public C4298m(Drawable.ConstantState constantState) {
        this.f14583a = constantState;
    }

    @Override
    public final boolean canApplyTheme() {
        return this.f14583a.canApplyTheme();
    }

    @Override
    public int getChangingConfigurations() {
        return this.f14583a.getChangingConfigurations();
    }

    @Override
    public final Drawable newDrawable() {
        C4299n c4299n = new C4299n();
        c4299n.f14529a = (VectorDrawable) this.f14583a.newDrawable();
        return c4299n;
    }

    @Override
    public final Drawable newDrawable(Resources resources) {
        C4299n c4299n = new C4299n();
        c4299n.f14529a = (VectorDrawable) this.f14583a.newDrawable(resources);
        return c4299n;
    }

    @Override
    public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
        C4299n c4299n = new C4299n();
        c4299n.f14529a = (VectorDrawable) this.f14583a.newDrawable(resources, theme);
        return c4299n;
    }
}
