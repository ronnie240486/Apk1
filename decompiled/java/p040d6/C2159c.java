package p040d6;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.cardview.widget.CardView;
import com.google.android.material.card.MaterialCardView;
import com.p2serv.android.p032ds.R;
import java.util.WeakHashMap;
import p065g0.AbstractC2581a;
import p124l6.C2982h;
import p138n0.AbstractC3155s0;
import p143n5.AbstractC3198d;
import p147o.AbstractC3225b;
import p147o.C3224a;
import p201s6.AbstractC3722c;
import p221u6.C3904d;
import p221u6.C3908h;
import p221u6.C3911k;
import p221u6.C3912l;
import p221u6.C3913m;
import p250x5.AbstractC4121a;

public final class C2159c {

    public static final double f7801t = Math.cos(Math.toRadians(45.0d));

    public static final ColorDrawable f7802u;

    public final MaterialCardView f7803a;

    public final C3908h f7805c;

    public final C3908h f7806d;

    public int f7807e;

    public int f7808f;

    public int f7809g;

    public int f7810h;

    public Drawable f7811i;

    public Drawable f7812j;

    public ColorStateList f7813k;

    public ColorStateList f7814l;

    public C3913m f7815m;

    public ColorStateList f7816n;

    public RippleDrawable f7817o;

    public LayerDrawable f7818p;

    public C3908h f7819q;

    public boolean f7821s;

    public final Rect f7804b = new Rect();

    public boolean f7820r = false;

    static {
        f7802u = Build.VERSION.SDK_INT <= 28 ? new ColorDrawable() : null;
    }

    public C2159c(MaterialCardView materialCardView, AttributeSet attributeSet, int i6) {
        this.f7803a = materialCardView;
        C3908h c3908h = new C3908h(materialCardView.getContext(), attributeSet, i6, R.style.Widget_MaterialComponents_CardView);
        this.f7805c = c3908h;
        c3908h.m7806k(materialCardView.getContext());
        c3908h.m7812q();
        C3912l c3912lM7826f = c3908h.f13126a.f13107a.m7826f();
        TypedArray typedArrayObtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, AbstractC4121a.f13994h, i6, R.style.CardView);
        if (typedArrayObtainStyledAttributes.hasValue(3)) {
            c3912lM7826f.m7820c(typedArrayObtainStyledAttributes.getDimension(3, 0.0f));
        }
        this.f7806d = new C3908h();
        m5094g(c3912lM7826f.m7819a());
        typedArrayObtainStyledAttributes.recycle();
    }

    public static float m5088b(AbstractC3198d abstractC3198d, float f) {
        if (abstractC3198d instanceof C3911k) {
            return (float) ((1.0d - f7801t) * ((double) f));
        }
        if (abstractC3198d instanceof C3904d) {
            return f / 2.0f;
        }
        return 0.0f;
    }

    public final float m5089a() {
        AbstractC3198d abstractC3198d = this.f7815m.f13164a;
        C3908h c3908h = this.f7805c;
        return Math.max(Math.max(m5088b(abstractC3198d, c3908h.m7804i()), m5088b(this.f7815m.f13165b, c3908h.f13126a.f13107a.f13169f.mo7794a(c3908h.m7802g()))), Math.max(m5088b(this.f7815m.f13166c, c3908h.f13126a.f13107a.f13170g.mo7794a(c3908h.m7802g())), m5088b(this.f7815m.f13167d, c3908h.f13126a.f13107a.f13171h.mo7794a(c3908h.m7802g()))));
    }

    public final LayerDrawable m5090c() {
        if (this.f7817o == null) {
            int[] iArr = AbstractC3722c.f12475a;
            this.f7819q = new C3908h(this.f7815m);
            this.f7817o = new RippleDrawable(this.f7813k, null, this.f7819q);
        }
        if (this.f7818p == null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.f7817o, this.f7806d, this.f7812j});
            this.f7818p = layerDrawable;
            layerDrawable.setId(2, R.id.mtrl_card_checked_layer_id);
        }
        return this.f7818p;
    }

    public final C2158b m5091d(Drawable drawable) {
        int iCeil;
        int i6;
        MaterialCardView materialCardView = this.f7803a;
        if (materialCardView.getUseCompatPadding()) {
            int iCeil2 = (int) Math.ceil((materialCardView.getMaxCardElevation() * 1.5f) + (m5095h() ? m5089a() : 0.0f));
            iCeil = (int) Math.ceil(materialCardView.getMaxCardElevation() + (m5095h() ? m5089a() : 0.0f));
            i6 = iCeil2;
        } else {
            iCeil = 0;
            i6 = 0;
        }
        return new C2158b(drawable, iCeil, i6, iCeil, i6);
    }

    public final void m5092e(int i6, int i10) {
        int iCeil;
        int iCeil2;
        int i11;
        int i12;
        if (this.f7818p != null) {
            MaterialCardView materialCardView = this.f7803a;
            if (materialCardView.getUseCompatPadding()) {
                iCeil = (int) Math.ceil(((materialCardView.getMaxCardElevation() * 1.5f) + (m5095h() ? m5089a() : 0.0f)) * 2.0f);
                iCeil2 = (int) Math.ceil((materialCardView.getMaxCardElevation() + (m5095h() ? m5089a() : 0.0f)) * 2.0f);
            } else {
                iCeil = 0;
                iCeil2 = 0;
            }
            int i13 = this.f7809g;
            int i14 = (i13 & 8388613) == 8388613 ? ((i6 - this.f7807e) - this.f7808f) - iCeil2 : this.f7807e;
            int i15 = (i13 & 80) == 80 ? this.f7807e : ((i10 - this.f7807e) - this.f7808f) - iCeil;
            int i16 = (i13 & 8388613) == 8388613 ? this.f7807e : ((i6 - this.f7807e) - this.f7808f) - iCeil2;
            int i17 = (i13 & 80) == 80 ? ((i10 - this.f7807e) - this.f7808f) - iCeil : this.f7807e;
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            if (materialCardView.getLayoutDirection() == 1) {
                i12 = i16;
                i11 = i14;
            } else {
                i11 = i16;
                i12 = i14;
            }
            this.f7818p.setLayerInset(2, i12, i17, i11, i15);
        }
    }

    public final void m5093f(Drawable drawable) {
        if (drawable != null) {
            Drawable drawableMutate = AbstractC3198d.m6448W(drawable).mutate();
            this.f7812j = drawableMutate;
            AbstractC2581a.m5586h(drawableMutate, this.f7814l);
            boolean z7 = this.f7803a.f6075j;
            Drawable drawable2 = this.f7812j;
            if (drawable2 != null) {
                drawable2.setAlpha(z7 ? 255 : 0);
            }
        } else {
            this.f7812j = f7802u;
        }
        LayerDrawable layerDrawable = this.f7818p;
        if (layerDrawable != null) {
            layerDrawable.setDrawableByLayerId(R.id.mtrl_card_checked_layer_id, this.f7812j);
        }
    }

    public final void m5094g(C3913m c3913m) {
        this.f7815m = c3913m;
        C3908h c3908h = this.f7805c;
        c3908h.setShapeAppearanceModel(c3913m);
        c3908h.f13147v = !c3908h.m7807l();
        C3908h c3908h2 = this.f7806d;
        if (c3908h2 != null) {
            c3908h2.setShapeAppearanceModel(c3913m);
        }
        C3908h c3908h3 = this.f7819q;
        if (c3908h3 != null) {
            c3908h3.setShapeAppearanceModel(c3913m);
        }
    }

    public final boolean m5095h() {
        MaterialCardView materialCardView = this.f7803a;
        return materialCardView.getPreventCornerOverlap() && this.f7805c.m7807l() && materialCardView.getUseCompatPadding();
    }

    public final void m5096i() {
        MaterialCardView materialCardView = this.f7803a;
        float cardViewRadius = 0.0f;
        float fM5089a = ((materialCardView.getPreventCornerOverlap() && !this.f7805c.m7807l()) || m5095h()) ? m5089a() : 0.0f;
        if (materialCardView.getPreventCornerOverlap() && materialCardView.getUseCompatPadding()) {
            cardViewRadius = (float) ((1.0d - f7801t) * ((double) materialCardView.getCardViewRadius()));
        }
        int i6 = (int) (fM5089a - cardViewRadius);
        Rect rect = this.f7804b;
        materialCardView.f1166c.set(rect.left + i6, rect.top + i6, rect.right + i6, rect.bottom + i6);
        C2982h c2982h = materialCardView.f1168e;
        if (!((CardView) c2982h.f10226c).getUseCompatPadding()) {
            c2982h.m6039B(0, 0, 0, 0);
            return;
        }
        C3224a c3224a = (C3224a) ((Drawable) c2982h.f10225b);
        float f = c3224a.f10829e;
        float f3 = c3224a.f10825a;
        CardView cardView = (CardView) c2982h.f10226c;
        int iCeil = (int) Math.ceil(AbstractC3225b.m6510a(f, f3, cardView.getPreventCornerOverlap()));
        int iCeil2 = (int) Math.ceil(AbstractC3225b.m6511b(f, f3, cardView.getPreventCornerOverlap()));
        c2982h.m6039B(iCeil, iCeil2, iCeil, iCeil2);
    }

    public final void m5097j() {
        boolean z7 = this.f7820r;
        MaterialCardView materialCardView = this.f7803a;
        if (!z7) {
            materialCardView.setBackgroundInternal(m5091d(this.f7805c));
        }
        materialCardView.setForeground(m5091d(this.f7811i));
    }
}
