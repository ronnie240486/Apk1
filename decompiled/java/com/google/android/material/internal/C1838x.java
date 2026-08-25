package com.google.android.material.internal;

import android.content.Context;
import android.text.TextPaint;
import java.lang.ref.WeakReference;
import p189r6.C3639d;

public final class C1838x {

    public float f6496c;

    public final WeakReference f6498e;

    public C3639d f6499f;

    public final TextPaint f6494a = new TextPaint(1);

    public final C1836v f6495b = new C1836v(0, this);

    public boolean f6497d = true;

    public C1838x(InterfaceC1837w interfaceC1837w) {
        this.f6498e = new WeakReference(null);
        this.f6498e = new WeakReference(interfaceC1837w);
    }

    public final float m4285a(String str) {
        if (!this.f6497d) {
            return this.f6496c;
        }
        float fMeasureText = str == null ? 0.0f : this.f6494a.measureText((CharSequence) str, 0, str.length());
        this.f6496c = fMeasureText;
        this.f6497d = false;
        return fMeasureText;
    }

    public final void m4286b(C3639d c3639d, Context context) {
        if (this.f6499f != c3639d) {
            this.f6499f = c3639d;
            if (c3639d != null) {
                TextPaint textPaint = this.f6494a;
                C1836v c1836v = this.f6495b;
                c3639d.m7368f(context, textPaint, c1836v);
                InterfaceC1837w interfaceC1837w = (InterfaceC1837w) this.f6498e.get();
                if (interfaceC1837w != null) {
                    textPaint.drawableState = interfaceC1837w.getState();
                }
                c3639d.m7367e(context, textPaint, c1836v);
                this.f6497d = true;
            }
            InterfaceC1837w interfaceC1837w2 = (InterfaceC1837w) this.f6498e.get();
            if (interfaceC1837w2 != null) {
                interfaceC1837w2.mo4284a();
                interfaceC1837w2.onStateChange(interfaceC1837w2.getState());
            }
        }
    }
}
