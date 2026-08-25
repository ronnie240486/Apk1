package p086i3;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import p124l6.C2977c;
import p268z1.C4288c;

public final class C2687c extends Drawable.ConstantState {

    public final int f9335a;

    public final Object f9336b;

    public C2687c(int i6, Object obj) {
        this.f9335a = i6;
        this.f9336b = obj;
    }

    @Override
    public boolean canApplyTheme() {
        switch (this.f9335a) {
            case 2:
                return ((Drawable.ConstantState) this.f9336b).canApplyTheme();
            default:
                return super.canApplyTheme();
        }
    }

    @Override
    public final int getChangingConfigurations() {
        switch (this.f9335a) {
            case 0:
                return 0;
            case 1:
                return 0;
            default:
                return ((Drawable.ConstantState) this.f9336b).getChangingConfigurations();
        }
    }

    @Override
    public final Drawable newDrawable() {
        switch (this.f9335a) {
            case 0:
                return new C2688d(this);
            case 1:
                return (C2977c) this.f9336b;
            default:
                C4288c c4288c = new C4288c(null);
                Drawable drawableNewDrawable = ((Drawable.ConstantState) this.f9336b).newDrawable();
                c4288c.f14529a = drawableNewDrawable;
                drawableNewDrawable.setCallback(c4288c.f14527d);
                return c4288c;
        }
    }

    public C2687c(C2977c c2977c) {
        this.f9335a = 1;
        this.f9336b = c2977c;
    }

    @Override
    public Drawable newDrawable(Resources resources) {
        switch (this.f9335a) {
            case 0:
                return new C2688d(this);
            case 1:
            default:
                return super.newDrawable(resources);
            case 2:
                C4288c c4288c = new C4288c(null);
                Drawable drawableNewDrawable = ((Drawable.ConstantState) this.f9336b).newDrawable(resources);
                c4288c.f14529a = drawableNewDrawable;
                drawableNewDrawable.setCallback(c4288c.f14527d);
                return c4288c;
        }
    }

    @Override
    public Drawable newDrawable(Resources resources, Resources.Theme theme) {
        switch (this.f9335a) {
            case 2:
                C4288c c4288c = new C4288c(null);
                Drawable drawableNewDrawable = ((Drawable.ConstantState) this.f9336b).newDrawable(resources, theme);
                c4288c.f14529a = drawableNewDrawable;
                drawableNewDrawable.setCallback(c4288c.f14527d);
                return c4288c;
            default:
                return super.newDrawable(resources, theme);
        }
    }
}
