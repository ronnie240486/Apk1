package p065g0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

public final class C2591k extends Drawable.ConstantState {

    public int f9036a;

    public Drawable.ConstantState f9037b;

    public ColorStateList f9038c;

    public PorterDuff.Mode f9039d;

    @Override
    public final int getChangingConfigurations() {
        int i6 = this.f9036a;
        Drawable.ConstantState constantState = this.f9037b;
        return i6 | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    @Override
    public final Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override
    public final Drawable newDrawable(Resources resources) {
        C2590j c2590j = new C2590j();
        c2590j.f9033d = this;
        Drawable.ConstantState constantState = this.f9037b;
        if (constantState != null) {
            c2590j.m5612h(constantState.newDrawable(resources));
        }
        C2590j.m5605a();
        return c2590j;
    }
}
