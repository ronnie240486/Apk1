package p272z5;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.material.badge.BadgeState$State;
import com.google.android.material.internal.AbstractC1811a0;
import com.google.android.material.internal.C1838x;
import com.google.android.material.internal.InterfaceC1837w;
import com.p2serv.android.p032ds.R;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import java.util.WeakHashMap;
import p138n0.AbstractC3155s0;
import p189r6.C3639d;
import p221u6.C3908h;
import p221u6.C3912l;

public final class C4355a extends Drawable implements InterfaceC1837w {

    public final WeakReference f14765a;

    public final C3908h f14766b;

    public final C1838x f14767c;

    public final Rect f14768d;

    public final C4356b f14769e;

    public float f14770f;

    public float f14771g;

    public final int f14772h;

    public float f14773i;

    public float f14774j;

    public float f14775k;

    public WeakReference f14776l;

    public WeakReference f14777m;

    public C4355a(Context context, BadgeState$State badgeState$State) {
        C3639d c3639d;
        Context context2;
        WeakReference weakReference = new WeakReference(context);
        this.f14765a = weakReference;
        AbstractC1811a0.m4243c(context, AbstractC1811a0.f6356b, "Theme.MaterialComponents");
        this.f14768d = new Rect();
        C3908h c3908h = new C3908h();
        this.f14766b = c3908h;
        C1838x c1838x = new C1838x(this);
        this.f14767c = c1838x;
        TextPaint textPaint = c1838x.f6494a;
        textPaint.setTextAlign(Paint.Align.CENTER);
        Context context3 = (Context) weakReference.get();
        if (context3 != null && c1838x.f6499f != (c3639d = new C3639d(context3, R.style.TextAppearance_MaterialComponents_Badge)) && (context2 = (Context) weakReference.get()) != null) {
            c1838x.m4286b(c3639d, context2);
            m8398g();
        }
        C4356b c4356b = new C4356b(context, badgeState$State);
        this.f14769e = c4356b;
        BadgeState$State badgeState$State2 = c4356b.f14779b;
        this.f14772h = ((int) Math.pow(10.0d, ((double) badgeState$State2.f5887f) - 1.0d)) - 1;
        c1838x.f6497d = true;
        m8398g();
        invalidateSelf();
        c1838x.f6497d = true;
        m8398g();
        invalidateSelf();
        textPaint.setAlpha(getAlpha());
        invalidateSelf();
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(badgeState$State2.f5883b.intValue());
        if (c3908h.f13126a.f13109c != colorStateListValueOf) {
            c3908h.m7809n(colorStateListValueOf);
            invalidateSelf();
        }
        textPaint.setColor(badgeState$State2.f5884c.intValue());
        invalidateSelf();
        WeakReference weakReference2 = this.f14776l;
        if (weakReference2 != null && weakReference2.get() != null) {
            View view = (View) this.f14776l.get();
            WeakReference weakReference3 = this.f14777m;
            m8397f(view, weakReference3 != null ? (FrameLayout) weakReference3.get() : null);
        }
        m8398g();
        setVisible(badgeState$State2.f5893l.booleanValue(), false);
    }

    @Override
    public final void mo4284a() {
        invalidateSelf();
    }

    public final String m8393b() {
        int iM8395d = m8395d();
        int i6 = this.f14772h;
        C4356b c4356b = this.f14769e;
        if (iM8395d <= i6) {
            return NumberFormat.getInstance(c4356b.f14779b.f5888g).format(m8395d());
        }
        Context context = (Context) this.f14765a.get();
        return context == null ? "" : String.format(c4356b.f14779b.f5888g, context.getString(R.string.mtrl_exceed_max_badge_number_suffix), Integer.valueOf(i6), "+");
    }

    public final CharSequence m8394c() {
        Context context;
        if (!isVisible()) {
            return null;
        }
        boolean zM8396e = m8396e();
        C4356b c4356b = this.f14769e;
        if (!zM8396e) {
            return c4356b.f14779b.f5889h;
        }
        if (c4356b.f14779b.f5890i == 0 || (context = (Context) this.f14765a.get()) == null) {
            return null;
        }
        int iM8395d = m8395d();
        int i6 = this.f14772h;
        BadgeState$State badgeState$State = c4356b.f14779b;
        return iM8395d <= i6 ? context.getResources().getQuantityString(badgeState$State.f5890i, m8395d(), Integer.valueOf(m8395d())) : context.getString(badgeState$State.f5891j, Integer.valueOf(i6));
    }

    public final int m8395d() {
        if (m8396e()) {
            return this.f14769e.f14779b.f5886e;
        }
        return 0;
    }

    @Override
    public final void draw(Canvas canvas) {
        if (getBounds().isEmpty() || getAlpha() == 0 || !isVisible()) {
            return;
        }
        this.f14766b.draw(canvas);
        if (m8396e()) {
            Rect rect = new Rect();
            String strM8393b = m8393b();
            C1838x c1838x = this.f14767c;
            c1838x.f6494a.getTextBounds(strM8393b, 0, strM8393b.length(), rect);
            canvas.drawText(strM8393b, this.f14770f, this.f14771g + (rect.height() / 2), c1838x.f6494a);
        }
    }

    public final boolean m8396e() {
        return this.f14769e.f14779b.f5886e != -1;
    }

    public final void m8397f(View view, FrameLayout frameLayout) {
        this.f14776l = new WeakReference(view);
        this.f14777m = new WeakReference(frameLayout);
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
        m8398g();
        invalidateSelf();
    }

    public final void m8398g() {
        Context context = (Context) this.f14765a.get();
        WeakReference weakReference = this.f14776l;
        View view = weakReference != null ? (View) weakReference.get() : null;
        if (context == null || view == null) {
            return;
        }
        Rect rect = new Rect();
        Rect rect2 = this.f14768d;
        rect.set(rect2);
        Rect rect3 = new Rect();
        view.getDrawingRect(rect3);
        WeakReference weakReference2 = this.f14777m;
        FrameLayout frameLayout = weakReference2 != null ? (FrameLayout) weakReference2.get() : null;
        if (frameLayout != null) {
            frameLayout.offsetDescendantRectToMyCoords(view, rect3);
        }
        boolean zM8396e = m8396e();
        C4356b c4356b = this.f14769e;
        int iIntValue = c4356b.f14779b.f5899r.intValue() + (zM8396e ? c4356b.f14779b.f5897p.intValue() : c4356b.f14779b.f5895n.intValue());
        BadgeState$State badgeState$State = c4356b.f14779b;
        int iIntValue2 = badgeState$State.f5892k.intValue();
        if (iIntValue2 == 8388691 || iIntValue2 == 8388693) {
            this.f14771g = rect3.bottom - iIntValue;
        } else {
            this.f14771g = rect3.top + iIntValue;
        }
        int iM8395d = m8395d();
        float f = c4356b.f14781d;
        if (iM8395d <= 9) {
            if (!m8396e()) {
                f = c4356b.f14780c;
            }
            this.f14773i = f;
            this.f14775k = f;
            this.f14774j = f;
        } else {
            this.f14773i = f;
            this.f14775k = f;
            this.f14774j = (this.f14767c.m4285a(m8393b()) / 2.0f) + c4356b.f14782e;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(m8396e() ? R.dimen.mtrl_badge_text_horizontal_edge_offset : R.dimen.mtrl_badge_horizontal_edge_offset);
        int iIntValue3 = badgeState$State.f5898q.intValue() + (m8396e() ? badgeState$State.f5896o.intValue() : badgeState$State.f5894m.intValue());
        int iIntValue4 = badgeState$State.f5892k.intValue();
        if (iIntValue4 == 8388659 || iIntValue4 == 8388691) {
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            this.f14770f = view.getLayoutDirection() == 0 ? (rect3.left - this.f14774j) + dimensionPixelSize + iIntValue3 : ((rect3.right + this.f14774j) - dimensionPixelSize) - iIntValue3;
        } else {
            WeakHashMap weakHashMap2 = AbstractC3155s0.f10642a;
            this.f14770f = view.getLayoutDirection() == 0 ? ((rect3.right + this.f14774j) - dimensionPixelSize) - iIntValue3 : (rect3.left - this.f14774j) + dimensionPixelSize + iIntValue3;
        }
        float f3 = this.f14770f;
        float f4 = this.f14771g;
        float f5 = this.f14774j;
        float f10 = this.f14775k;
        rect2.set((int) (f3 - f5), (int) (f4 - f10), (int) (f3 + f5), (int) (f4 + f10));
        float f11 = this.f14773i;
        C3908h c3908h = this.f14766b;
        C3912l c3912lM7826f = c3908h.f13126a.f13107a.m7826f();
        c3912lM7826f.m7820c(f11);
        c3908h.setShapeAppearanceModel(c3912lM7826f.m7819a());
        if (rect.equals(rect2)) {
            return;
        }
        c3908h.setBounds(rect2);
    }

    @Override
    public final int getAlpha() {
        return this.f14769e.f14779b.f5885d;
    }

    @Override
    public final int getIntrinsicHeight() {
        return this.f14768d.height();
    }

    @Override
    public final int getIntrinsicWidth() {
        return this.f14768d.width();
    }

    @Override
    public final int getOpacity() {
        return -3;
    }

    @Override
    public final boolean isStateful() {
        return false;
    }

    @Override
    public final boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @Override
    public final void setAlpha(int i6) {
        C4356b c4356b = this.f14769e;
        c4356b.f14778a.f5885d = i6;
        c4356b.f14779b.f5885d = i6;
        this.f14767c.f6494a.setAlpha(getAlpha());
        invalidateSelf();
    }

    @Override
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
