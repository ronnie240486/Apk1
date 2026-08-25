package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import com.p2serv.android.p032ds.R;
import java.util.WeakHashMap;
import p065g0.AbstractC2581a;
import p138n0.AbstractC3155s0;
import p156o9.AbstractC3281e;
import p201s6.AbstractC3722c;
import p201s6.C3720a;
import p201s6.C3721b;
import p221u6.C3908h;
import p221u6.C3913m;
import p221u6.InterfaceC3924x;

public final class C1771c {

    public static final boolean f6043t;

    public static final boolean f6044u;

    public final MaterialButton f6045a;

    public C3913m f6046b;

    public int f6047c;

    public int f6048d;

    public int f6049e;

    public int f6050f;

    public int f6051g;

    public int f6052h;

    public PorterDuff.Mode f6053i;

    public ColorStateList f6054j;

    public ColorStateList f6055k;

    public ColorStateList f6056l;

    public Drawable f6057m;

    public boolean f6058n = false;

    public boolean f6059o = false;

    public boolean f6060p = false;

    public boolean f6061q;

    public LayerDrawable f6062r;

    public int f6063s;

    static {
        int i6 = Build.VERSION.SDK_INT;
        f6043t = true;
        f6044u = i6 <= 22;
    }

    public C1771c(MaterialButton materialButton, C3913m c3913m) {
        this.f6045a = materialButton;
        this.f6046b = c3913m;
    }

    public final InterfaceC3924x m4148a() {
        LayerDrawable layerDrawable = this.f6062r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return this.f6062r.getNumberOfLayers() > 2 ? (InterfaceC3924x) this.f6062r.getDrawable(2) : (InterfaceC3924x) this.f6062r.getDrawable(1);
    }

    public final C3908h m4149b(boolean z7) {
        LayerDrawable layerDrawable = this.f6062r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return f6043t ? (C3908h) ((LayerDrawable) ((InsetDrawable) this.f6062r.getDrawable(0)).getDrawable()).getDrawable(!z7 ? 1 : 0) : (C3908h) this.f6062r.getDrawable(!z7 ? 1 : 0);
    }

    public final void m4150c(C3913m c3913m) {
        this.f6046b = c3913m;
        if (!f6044u || this.f6059o) {
            if (m4149b(false) != null) {
                m4149b(false).setShapeAppearanceModel(c3913m);
            }
            if (m4149b(true) != null) {
                m4149b(true).setShapeAppearanceModel(c3913m);
            }
            if (m4148a() != null) {
                m4148a().setShapeAppearanceModel(c3913m);
                return;
            }
            return;
        }
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        MaterialButton materialButton = this.f6045a;
        int paddingStart = materialButton.getPaddingStart();
        int paddingTop = materialButton.getPaddingTop();
        int paddingEnd = materialButton.getPaddingEnd();
        int paddingBottom = materialButton.getPaddingBottom();
        m4152e();
        materialButton.setPaddingRelative(paddingStart, paddingTop, paddingEnd, paddingBottom);
    }

    public final void m4151d(int i6, int i10) {
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        MaterialButton materialButton = this.f6045a;
        int paddingStart = materialButton.getPaddingStart();
        int paddingTop = materialButton.getPaddingTop();
        int paddingEnd = materialButton.getPaddingEnd();
        int paddingBottom = materialButton.getPaddingBottom();
        int i11 = this.f6049e;
        int i12 = this.f6050f;
        this.f6050f = i10;
        this.f6049e = i6;
        if (!this.f6059o) {
            m4152e();
        }
        materialButton.setPaddingRelative(paddingStart, (paddingTop + i6) - i11, paddingEnd, (paddingBottom + i10) - i12);
    }

    public final void m4152e() {
        Drawable insetDrawable;
        C3908h c3908h = new C3908h(this.f6046b);
        MaterialButton materialButton = this.f6045a;
        c3908h.m7806k(materialButton.getContext());
        AbstractC2581a.m5586h(c3908h, this.f6054j);
        PorterDuff.Mode mode = this.f6053i;
        if (mode != null) {
            AbstractC2581a.m5587i(c3908h, mode);
        }
        float f = this.f6052h;
        ColorStateList colorStateList = this.f6055k;
        c3908h.f13126a.f13116j = f;
        c3908h.invalidateSelf();
        c3908h.m7814s(colorStateList);
        C3908h c3908h2 = new C3908h(this.f6046b);
        c3908h2.setTint(0);
        float f3 = this.f6052h;
        int iM6626p = this.f6058n ? AbstractC3281e.m6626p(R.attr.colorSurface, materialButton) : 0;
        c3908h2.f13126a.f13116j = f3;
        c3908h2.invalidateSelf();
        c3908h2.m7814s(ColorStateList.valueOf(iM6626p));
        if (f6043t) {
            C3908h c3908h3 = new C3908h(this.f6046b);
            this.f6057m = c3908h3;
            AbstractC2581a.m5585g(c3908h3, -1);
            RippleDrawable rippleDrawable = new RippleDrawable(AbstractC3722c.m7485b(this.f6056l), new InsetDrawable((Drawable) new LayerDrawable(new Drawable[]{c3908h2, c3908h}), this.f6047c, this.f6049e, this.f6048d, this.f6050f), this.f6057m);
            this.f6062r = rippleDrawable;
            insetDrawable = rippleDrawable;
        } else {
            C3908h c3908h4 = new C3908h(this.f6046b);
            C3720a c3720a = new C3720a();
            c3720a.f12472a = c3908h4;
            c3720a.f12473b = false;
            C3721b c3721b = new C3721b(c3720a);
            this.f6057m = c3721b;
            AbstractC2581a.m5586h(c3721b, AbstractC3722c.m7485b(this.f6056l));
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{c3908h2, c3908h, this.f6057m});
            this.f6062r = layerDrawable;
            insetDrawable = new InsetDrawable((Drawable) layerDrawable, this.f6047c, this.f6049e, this.f6048d, this.f6050f);
        }
        materialButton.setInternalBackground(insetDrawable);
        C3908h c3908hM4149b = m4149b(false);
        if (c3908hM4149b != null) {
            c3908hM4149b.m7808m(this.f6063s);
        }
    }

    public final void m4153f() {
        C3908h c3908hM4149b = m4149b(false);
        C3908h c3908hM4149b2 = m4149b(true);
        if (c3908hM4149b != null) {
            float f = this.f6052h;
            ColorStateList colorStateList = this.f6055k;
            c3908hM4149b.f13126a.f13116j = f;
            c3908hM4149b.invalidateSelf();
            c3908hM4149b.m7814s(colorStateList);
            if (c3908hM4149b2 != null) {
                float f3 = this.f6052h;
                int iM6626p = this.f6058n ? AbstractC3281e.m6626p(R.attr.colorSurface, this.f6045a) : 0;
                c3908hM4149b2.f13126a.f13116j = f3;
                c3908hM4149b2.invalidateSelf();
                c3908hM4149b2.m7814s(ColorStateList.valueOf(iM6626p));
            }
        }
    }
}
