package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import p002a1.C0026b;
import p045e.AbstractC2341a;
import p065g0.AbstractC2581a;
import p138n0.AbstractC3155s0;
import p143n5.AbstractC3198d;

public final class C0191d0 extends C0179b0 {

    public final AppCompatSeekBar f882e;

    public Drawable f883f;

    public ColorStateList f884g;

    public PorterDuff.Mode f885h;

    public boolean f886i;

    public boolean f887j;

    public C0191d0(AppCompatSeekBar appCompatSeekBar) {
        super(appCompatSeekBar);
        this.f884g = null;
        this.f885h = null;
        this.f886i = false;
        this.f887j = false;
        this.f882e = appCompatSeekBar;
    }

    @Override
    public final void mo640b(AttributeSet attributeSet, int i6) {
        super.mo640b(attributeSet, i6);
        AppCompatSeekBar appCompatSeekBar = this.f882e;
        Context context = appCompatSeekBar.getContext();
        int[] iArr = AbstractC2341a.f8160h;
        C0026b c0026bM111C = C0026b.m111C(context, attributeSet, iArr, i6);
        AbstractC3155s0.m6346p(appCompatSeekBar, appCompatSeekBar.getContext(), iArr, attributeSet, (TypedArray) c0026bM111C.f55c, i6, 0);
        Drawable drawableM141u = c0026bM111C.m141u(0);
        if (drawableM141u != null) {
            appCompatSeekBar.setThumb(drawableM141u);
        }
        Drawable drawableM140t = c0026bM111C.m140t(1);
        Drawable drawable = this.f883f;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.f883f = drawableM140t;
        if (drawableM140t != null) {
            drawableM140t.setCallback(appCompatSeekBar);
            AbstractC3198d.m6442Q(drawableM140t, appCompatSeekBar.getLayoutDirection());
            if (drawableM140t.isStateful()) {
                drawableM140t.setState(appCompatSeekBar.getDrawableState());
            }
            m649f();
        }
        appCompatSeekBar.invalidate();
        TypedArray typedArray = (TypedArray) c0026bM111C.f55c;
        if (typedArray.hasValue(3)) {
            this.f885h = AbstractC0237m1.m737c(typedArray.getInt(3, -1), this.f885h);
            this.f887j = true;
        }
        if (typedArray.hasValue(2)) {
            this.f884g = c0026bM111C.m139s(2);
            this.f886i = true;
        }
        c0026bM111C.m120F();
        m649f();
    }

    public final void m649f() {
        Drawable drawable = this.f883f;
        if (drawable != null) {
            if (this.f886i || this.f887j) {
                Drawable drawableM6448W = AbstractC3198d.m6448W(drawable.mutate());
                this.f883f = drawableM6448W;
                if (this.f886i) {
                    AbstractC2581a.m5586h(drawableM6448W, this.f884g);
                }
                if (this.f887j) {
                    AbstractC2581a.m5587i(this.f883f, this.f885h);
                }
                if (this.f883f.isStateful()) {
                    this.f883f.setState(this.f882e.getDrawableState());
                }
            }
        }
    }

    public final void m650g(Canvas canvas) {
        if (this.f883f != null) {
            AppCompatSeekBar appCompatSeekBar = this.f882e;
            int max = appCompatSeekBar.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f883f.getIntrinsicWidth();
                int intrinsicHeight = this.f883f.getIntrinsicHeight();
                int i6 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i10 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f883f.setBounds(-i6, -i10, i6, i10);
                float width = ((appCompatSeekBar.getWidth() - appCompatSeekBar.getPaddingLeft()) - appCompatSeekBar.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(appCompatSeekBar.getPaddingLeft(), appCompatSeekBar.getHeight() / 2);
                for (int i11 = 0; i11 <= max; i11++) {
                    this.f883f.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }
}
