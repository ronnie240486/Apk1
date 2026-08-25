package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.LinearInterpolator;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import androidx.appcompat.app.ViewOnClickListenerC0122a;
import androidx.appcompat.widget.ViewOnFocusChangeListenerC0263r2;
import com.bumptech.glide.AbstractC1465c;
import com.p2serv.android.p032ds.R;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import p001a0.C0019b;
import p006a6.C0062a;
import p007a7.C0066c;
import p138n0.AbstractC3155s0;
import p148o0.AccessibilityManagerTouchExplorationStateChangeListenerC3227b;
import p156o9.AbstractC3281e;
import p221u6.C3901a;
import p221u6.C3905e;
import p221u6.C3907g;
import p221u6.C3908h;
import p221u6.C3911k;
import p221u6.C3913m;
import p262y5.AbstractC4268a;

public final class C1875m extends AbstractC1876n {

    public final C1871i f6852e;

    public final ViewOnFocusChangeListenerC0263r2 f6853f;

    public final C1872j f6854g;

    public final C1863a f6855h;

    public final C1864b f6856i;

    public final ViewOnAttachStateChangeListenerC1873k f6857j;

    public final C0019b f6858k;

    public boolean f6859l;

    public boolean f6860m;

    public long f6861n;

    public StateListDrawable f6862o;

    public C3908h f6863p;

    public AccessibilityManager f6864q;

    public ValueAnimator f6865r;

    public ValueAnimator f6866s;

    public C1875m(TextInputLayout textInputLayout, int i6) {
        super(textInputLayout, i6);
        this.f6852e = new C1871i(this, 0);
        this.f6853f = new ViewOnFocusChangeListenerC0263r2(2, this);
        this.f6854g = new C1872j(this, textInputLayout);
        this.f6855h = new C1863a(this, 1);
        this.f6856i = new C1864b(this, 1);
        this.f6857j = new ViewOnAttachStateChangeListenerC1873k(0, this);
        this.f6858k = new C0019b(21, this);
        this.f6859l = false;
        this.f6860m = false;
        this.f6861n = Long.MAX_VALUE;
    }

    public static void m4386d(C1875m c1875m, AutoCompleteTextView autoCompleteTextView) {
        if (autoCompleteTextView == null) {
            c1875m.getClass();
            return;
        }
        c1875m.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis() - c1875m.f6861n;
        if (jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300) {
            c1875m.f6859l = false;
        }
        if (c1875m.f6859l) {
            c1875m.f6859l = false;
            return;
        }
        c1875m.m4392i(!c1875m.f6860m);
        if (!c1875m.f6860m) {
            autoCompleteTextView.dismissDropDown();
        } else {
            autoCompleteTextView.requestFocus();
            autoCompleteTextView.showDropDown();
        }
    }

    public static boolean m4387h(EditText editText) {
        return editText.getKeyListener() != null;
    }

    @Override
    public final void mo4379a() {
        Context context = this.f6868b;
        float dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = context.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        C3908h c3908hM4391g = m4391g(dimensionPixelOffset, dimensionPixelOffset3, dimensionPixelOffset, dimensionPixelOffset2);
        C3908h c3908hM4391g2 = m4391g(0.0f, dimensionPixelOffset3, dimensionPixelOffset, dimensionPixelOffset2);
        this.f6863p = c3908hM4391g;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.f6862o = stateListDrawable;
        stateListDrawable.addState(new int[]{android.R.attr.state_above_anchor}, c3908hM4391g);
        this.f6862o.addState(new int[0], c3908hM4391g2);
        int i6 = this.f6870d;
        if (i6 == 0) {
            i6 = R.drawable.mtrl_dropdown_arrow;
        }
        TextInputLayout textInputLayout = this.f6867a;
        textInputLayout.setEndIconDrawable(i6);
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.exposed_dropdown_menu_content_description));
        textInputLayout.setEndIconOnClickListener(new ViewOnClickListenerC0122a(7, this));
        LinkedHashSet linkedHashSet = textInputLayout.f6775c0;
        C1863a c1863a = this.f6855h;
        linkedHashSet.add(c1863a);
        if (textInputLayout.f6778e != null) {
            c1863a.m4377a(textInputLayout);
        }
        textInputLayout.f6783g0.add(this.f6856i);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        LinearInterpolator linearInterpolator = AbstractC4268a.f14469a;
        valueAnimatorOfFloat.setInterpolator(linearInterpolator);
        valueAnimatorOfFloat.setDuration(67);
        valueAnimatorOfFloat.addUpdateListener(new C0066c(4, this));
        this.f6866s = valueAnimatorOfFloat;
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat2.setInterpolator(linearInterpolator);
        valueAnimatorOfFloat2.setDuration(50);
        valueAnimatorOfFloat2.addUpdateListener(new C0066c(4, this));
        this.f6865r = valueAnimatorOfFloat2;
        valueAnimatorOfFloat2.addListener(new C0062a(4, this));
        this.f6864q = (AccessibilityManager) context.getSystemService("accessibility");
        textInputLayout.addOnAttachStateChangeListener(this.f6857j);
        m4390f();
    }

    @Override
    public final boolean mo4388b(int i6) {
        return i6 != 0;
    }

    public final void m4389e(AutoCompleteTextView autoCompleteTextView) {
        if (m4387h(autoCompleteTextView)) {
            return;
        }
        TextInputLayout textInputLayout = this.f6867a;
        int boxBackgroundMode = textInputLayout.getBoxBackgroundMode();
        C3908h boxBackground = textInputLayout.getBoxBackground();
        int iM6626p = AbstractC3281e.m6626p(R.attr.colorControlHighlight, autoCompleteTextView);
        int[][] iArr = {new int[]{android.R.attr.state_pressed}, new int[0]};
        if (boxBackgroundMode != 2) {
            if (boxBackgroundMode == 1) {
                int boxBackgroundColor = textInputLayout.getBoxBackgroundColor();
                RippleDrawable rippleDrawable = new RippleDrawable(new ColorStateList(iArr, new int[]{AbstractC3281e.m6634x(0.1f, iM6626p, boxBackgroundColor), boxBackgroundColor}), boxBackground, boxBackground);
                WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                autoCompleteTextView.setBackground(rippleDrawable);
                return;
            }
            return;
        }
        int iM6626p2 = AbstractC3281e.m6626p(R.attr.colorSurface, autoCompleteTextView);
        C3908h c3908h = new C3908h(boxBackground.f13126a.f13107a);
        int iM6634x = AbstractC3281e.m6634x(0.1f, iM6626p, iM6626p2);
        c3908h.m7809n(new ColorStateList(iArr, new int[]{iM6634x, 0}));
        c3908h.setTint(iM6626p2);
        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{iM6634x, iM6626p2});
        C3908h c3908h2 = new C3908h(boxBackground.f13126a.f13107a);
        c3908h2.setTint(-1);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, c3908h, c3908h2), boxBackground});
        WeakHashMap weakHashMap2 = AbstractC3155s0.f10642a;
        autoCompleteTextView.setBackground(layerDrawable);
    }

    public final void m4390f() {
        TextInputLayout textInputLayout;
        if (this.f6864q == null || (textInputLayout = this.f6867a) == null) {
            return;
        }
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        if (textInputLayout.isAttachedToWindow()) {
            this.f6864q.addTouchExplorationStateChangeListener(new AccessibilityManagerTouchExplorationStateChangeListenerC3227b(this.f6858k));
        }
    }

    public final C3908h m4391g(float f, int i6, float f3, float f4) {
        int i10 = 0;
        C3911k c3911k = new C3911k();
        C3911k c3911k2 = new C3911k();
        C3911k c3911k3 = new C3911k();
        C3911k c3911k4 = new C3911k();
        C3905e c3905e = new C3905e(i10);
        C3905e c3905e2 = new C3905e(i10);
        C3905e c3905e3 = new C3905e(i10);
        C3905e c3905e4 = new C3905e(i10);
        C3901a c3901a = new C3901a(f);
        C3901a c3901a2 = new C3901a(f);
        C3901a c3901a3 = new C3901a(f3);
        C3901a c3901a4 = new C3901a(f3);
        C3913m c3913m = new C3913m();
        c3913m.f13164a = c3911k;
        c3913m.f13165b = c3911k2;
        c3913m.f13166c = c3911k3;
        c3913m.f13167d = c3911k4;
        c3913m.f13168e = c3901a;
        c3913m.f13169f = c3901a2;
        c3913m.f13170g = c3901a4;
        c3913m.f13171h = c3901a3;
        c3913m.f13172i = c3905e;
        c3913m.f13173j = c3905e2;
        c3913m.f13174k = c3905e3;
        c3913m.f13175l = c3905e4;
        Paint paint = C3908h.f13125w;
        String simpleName = C3908h.class.getSimpleName();
        Context context = this.f6868b;
        int iM3478m = AbstractC1465c.m3478m(context, R.attr.colorSurface, simpleName);
        C3908h c3908h = new C3908h();
        c3908h.m7806k(context);
        c3908h.m7809n(ColorStateList.valueOf(iM3478m));
        c3908h.m7808m(f4);
        c3908h.setShapeAppearanceModel(c3913m);
        C3907g c3907g = c3908h.f13126a;
        if (c3907g.f13113g == null) {
            c3907g.f13113g = new Rect();
        }
        c3908h.f13126a.f13113g.set(0, i6, 0, i6);
        c3908h.invalidateSelf();
        return c3908h;
    }

    public final void m4392i(boolean z7) {
        if (this.f6860m != z7) {
            this.f6860m = z7;
            this.f6866s.cancel();
            this.f6865r.start();
        }
    }
}
