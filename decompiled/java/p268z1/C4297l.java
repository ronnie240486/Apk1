package p268z1;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

public final class C4297l extends Drawable.ConstantState {

    public int f14571a;

    public C4296k f14572b;

    public ColorStateList f14573c;

    public PorterDuff.Mode f14574d;

    public boolean f14575e;

    public Bitmap f14576f;

    public ColorStateList f14577g;

    public PorterDuff.Mode f14578h;

    public int f14579i;

    public boolean f14580j;

    public boolean f14581k;

    public Paint f14582l;

    @Override
    public int getChangingConfigurations() {
        return this.f14571a;
    }

    @Override
    public final Drawable newDrawable() {
        return new C4299n(this);
    }

    @Override
    public final Drawable newDrawable(Resources resources) {
        return new C4299n(this);
    }
}
