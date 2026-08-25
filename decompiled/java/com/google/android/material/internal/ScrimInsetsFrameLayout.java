package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.p2serv.android.p032ds.R;
import java.util.WeakHashMap;
import p001a0.C0019b;
import p138n0.AbstractC3119g0;
import p138n0.AbstractC3155s0;
import p138n0.C3153r1;
import p250x5.AbstractC4121a;

public class ScrimInsetsFrameLayout extends FrameLayout {

    public Drawable f6344a;

    public Rect f6345b;

    public final Rect f6346c;

    public boolean f6347d;

    public boolean f6348e;

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f6345b == null || this.f6344a == null) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(getScrollX(), getScrollY());
        boolean z7 = this.f6347d;
        Rect rect = this.f6346c;
        if (z7) {
            rect.set(0, 0, width, this.f6345b.top);
            this.f6344a.setBounds(rect);
            this.f6344a.draw(canvas);
        }
        if (this.f6348e) {
            rect.set(0, height - this.f6345b.bottom, width, height);
            this.f6344a.setBounds(rect);
            this.f6344a.draw(canvas);
        }
        Rect rect2 = this.f6345b;
        rect.set(0, rect2.top, rect2.left, height - rect2.bottom);
        this.f6344a.setBounds(rect);
        this.f6344a.draw(canvas);
        Rect rect3 = this.f6345b;
        rect.set(width - rect3.right, rect3.top, width, height - rect3.bottom);
        this.f6344a.setBounds(rect);
        this.f6344a.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.f6344a;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.f6344a;
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void setDrawBottomInsetForeground(boolean z7) {
        this.f6348e = z7;
    }

    public void setDrawTopInsetForeground(boolean z7) {
        this.f6347d = z7;
    }

    public void setScrimInsetForeground(Drawable drawable) {
        this.f6344a = drawable;
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f6346c = new Rect();
        this.f6347d = true;
        this.f6348e = true;
        TypedArray typedArrayM4250j = AbstractC1811a0.m4250j(context, attributeSet, AbstractC4121a.f13973Q, i6, R.style.Widget_Design_ScrimInsetsFrameLayout, new int[0]);
        this.f6344a = typedArrayM4250j.getDrawable(0);
        typedArrayM4250j.recycle();
        setWillNotDraw(true);
        C0019b c0019b = new C0019b(17, this);
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        AbstractC3119g0.m6182u(this, c0019b);
    }

    public void mo4234a(C3153r1 c3153r1) {
    }
}
