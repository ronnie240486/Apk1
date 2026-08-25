package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.p2serv.android.p032ds.R;

public class AppCompatImageButton extends ImageButton {

    public final C0275u f626a;

    public final C0300z f627b;

    public boolean f628c;

    public AppCompatImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.imageButtonStyle);
    }

    @Override
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0275u c0275u = this.f626a;
        if (c0275u != null) {
            c0275u.m773a();
        }
        C0300z c0300z = this.f627b;
        if (c0300z != null) {
            c0300z.m837a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0275u c0275u = this.f626a;
        if (c0275u != null) {
            return c0275u.m774c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0275u c0275u = this.f626a;
        if (c0275u != null) {
            return c0275u.m775d();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        C0234l3 c0234l3;
        C0300z c0300z = this.f627b;
        if (c0300z == null || (c0234l3 = (C0234l3) c0300z.f1150c) == null) {
            return null;
        }
        return c0234l3.f999a;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        C0234l3 c0234l3;
        C0300z c0300z = this.f627b;
        if (c0300z == null || (c0234l3 = (C0234l3) c0300z.f1150c) == null) {
            return null;
        }
        return c0234l3.f1000b;
    }

    @Override
    public final boolean hasOverlappingRendering() {
        return !(((ImageView) this.f627b.f1149b).getBackground() instanceof RippleDrawable) && super.hasOverlappingRendering();
    }

    @Override
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0275u c0275u = this.f626a;
        if (c0275u != null) {
            c0275u.m777f();
        }
    }

    @Override
    public void setBackgroundResource(int i6) {
        super.setBackgroundResource(i6);
        C0275u c0275u = this.f626a;
        if (c0275u != null) {
            c0275u.m778g(i6);
        }
    }

    @Override
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        C0300z c0300z = this.f627b;
        if (c0300z != null) {
            c0300z.m837a();
        }
    }

    @Override
    public void setImageDrawable(Drawable drawable) {
        C0300z c0300z = this.f627b;
        if (c0300z != null && drawable != null && !this.f628c) {
            c0300z.f1148a = drawable.getLevel();
        }
        super.setImageDrawable(drawable);
        if (c0300z != null) {
            c0300z.m837a();
            if (this.f628c) {
                return;
            }
            ImageView imageView = (ImageView) c0300z.f1149b;
            if (imageView.getDrawable() != null) {
                imageView.getDrawable().setLevel(c0300z.f1148a);
            }
        }
    }

    @Override
    public void setImageLevel(int i6) {
        super.setImageLevel(i6);
        this.f628c = true;
    }

    @Override
    public void setImageResource(int i6) {
        this.f627b.m839c(i6);
    }

    @Override
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        C0300z c0300z = this.f627b;
        if (c0300z != null) {
            c0300z.m837a();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0275u c0275u = this.f626a;
        if (c0275u != null) {
            c0275u.m780i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0275u c0275u = this.f626a;
        if (c0275u != null) {
            c0275u.m781j(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        C0300z c0300z = this.f627b;
        if (c0300z != null) {
            if (((C0234l3) c0300z.f1150c) == null) {
                c0300z.f1150c = new C0234l3();
            }
            C0234l3 c0234l3 = (C0234l3) c0300z.f1150c;
            c0234l3.f999a = colorStateList;
            c0234l3.f1002d = true;
            c0300z.m837a();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        C0300z c0300z = this.f627b;
        if (c0300z != null) {
            if (((C0234l3) c0300z.f1150c) == null) {
                c0300z.f1150c = new C0234l3();
            }
            C0234l3 c0234l3 = (C0234l3) c0300z.f1150c;
            c0234l3.f1000b = mode;
            c0234l3.f1001c = true;
            c0300z.m837a();
        }
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        AbstractC0229k3.m718a(context);
        this.f628c = false;
        AbstractC0224j3.m702a(this, getContext());
        C0275u c0275u = new C0275u(this);
        this.f626a = c0275u;
        c0275u.m776e(attributeSet, i6);
        C0300z c0300z = new C0300z(this);
        this.f627b = c0300z;
        c0300z.m838b(attributeSet, i6);
    }
}
