package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.CheckBox;
import androidx.core.widget.InterfaceC0386s;
import com.bumptech.glide.AbstractC1465c;
import com.p2serv.android.p032ds.R;

public class AppCompatCheckBox extends CheckBox implements InterfaceC0386s {

    public final C0280v f612a;

    public final C0275u f613b;

    public final C0291x0 f614c;

    public C0295y f615d;

    public AppCompatCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.checkboxStyle);
    }

    private C0295y getEmojiTextViewHelper() {
        if (this.f615d == null) {
            this.f615d = new C0295y(this);
        }
        return this.f615d;
    }

    @Override
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0275u c0275u = this.f613b;
        if (c0275u != null) {
            c0275u.m773a();
        }
        C0291x0 c0291x0 = this.f614c;
        if (c0291x0 != null) {
            c0291x0.m816b();
        }
    }

    @Override
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        C0280v c0280v = this.f612a;
        if (c0280v != null) {
            c0280v.getClass();
        }
        return compoundPaddingLeft;
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0275u c0275u = this.f613b;
        if (c0275u != null) {
            return c0275u.m774c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0275u c0275u = this.f613b;
        if (c0275u != null) {
            return c0275u.m775d();
        }
        return null;
    }

    public ColorStateList getSupportButtonTintList() {
        C0280v c0280v = this.f612a;
        if (c0280v != null) {
            return (ColorStateList) c0280v.f1082a;
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        C0280v c0280v = this.f612a;
        if (c0280v != null) {
            return (PorterDuff.Mode) c0280v.f1083b;
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f614c.m817d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f614c.m818e();
    }

    @Override
    public void setAllCaps(boolean z7) {
        super.setAllCaps(z7);
        getEmojiTextViewHelper().m830c(z7);
    }

    @Override
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0275u c0275u = this.f613b;
        if (c0275u != null) {
            c0275u.m777f();
        }
    }

    @Override
    public void setBackgroundResource(int i6) {
        super.setBackgroundResource(i6);
        C0275u c0275u = this.f613b;
        if (c0275u != null) {
            c0275u.m778g(i6);
        }
    }

    @Override
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        C0280v c0280v = this.f612a;
        if (c0280v != null) {
            if (c0280v.f1086e) {
                c0280v.f1086e = false;
            } else {
                c0280v.f1086e = true;
                c0280v.m785a();
            }
        }
    }

    @Override
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0291x0 c0291x0 = this.f614c;
        if (c0291x0 != null) {
            c0291x0.m816b();
        }
    }

    @Override
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0291x0 c0291x0 = this.f614c;
        if (c0291x0 != null) {
            c0291x0.m816b();
        }
    }

    public void setEmojiCompatEnabled(boolean z7) {
        getEmojiTextViewHelper().m831d(z7);
    }

    @Override
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().m828a(inputFilterArr));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0275u c0275u = this.f613b;
        if (c0275u != null) {
            c0275u.m780i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0275u c0275u = this.f613b;
        if (c0275u != null) {
            c0275u.m781j(mode);
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        C0280v c0280v = this.f612a;
        if (c0280v != null) {
            c0280v.f1082a = colorStateList;
            c0280v.f1084c = true;
            c0280v.m785a();
        }
    }

    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        C0280v c0280v = this.f612a;
        if (c0280v != null) {
            c0280v.f1083b = mode;
            c0280v.f1085d = true;
            c0280v.m785a();
        }
    }

    @Override
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        C0291x0 c0291x0 = this.f614c;
        c0291x0.m824l(colorStateList);
        c0291x0.m816b();
    }

    @Override
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        C0291x0 c0291x0 = this.f614c;
        c0291x0.m825m(mode);
        c0291x0.m816b();
    }

    public AppCompatCheckBox(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        AbstractC0229k3.m718a(context);
        AbstractC0224j3.m702a(this, getContext());
        C0280v c0280v = new C0280v(this);
        this.f612a = c0280v;
        c0280v.m789e(attributeSet, i6);
        C0275u c0275u = new C0275u(this);
        this.f613b = c0275u;
        c0275u.m776e(attributeSet, i6);
        C0291x0 c0291x0 = new C0291x0(this);
        this.f614c = c0291x0;
        c0291x0.m819f(attributeSet, i6);
        getEmojiTextViewHelper().m829b(attributeSet, i6);
    }

    @Override
    public void setButtonDrawable(int i6) {
        setButtonDrawable(AbstractC1465c.m3473h(getContext(), i6));
    }
}
