package p124l6;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.p2serv.android.p032ds.R;
import java.util.WeakHashMap;
import p101j7.C2782c;
import p138n0.AbstractC3155s0;
import p262y5.C4272e;

public final class C2979e extends AbstractC2976b {

    public final C2978d f10218g;

    public final boolean f10219h;

    public final ExtendedFloatingActionButton f10220i;

    public C2979e(ExtendedFloatingActionButton extendedFloatingActionButton, C2782c c2782c, C2978d c2978d, boolean z7) {
        super(extendedFloatingActionButton, c2782c);
        this.f10220i = extendedFloatingActionButton;
        this.f10218g = c2978d;
        this.f10219h = z7;
    }

    @Override
    public final AnimatorSet mo6026a() {
        int measuredHeight;
        int measuredWidth;
        C4272e c4272e = this.f10199f;
        if (c4272e == null) {
            if (this.f10198e == null) {
                this.f10198e = C4272e.m8314b(this.f10194a, mo6028c());
            }
            c4272e = this.f10198e;
            c4272e.getClass();
        }
        boolean zM8319g = c4272e.m8319g("width");
        C2978d c2978d = this.f10218g;
        ExtendedFloatingActionButton extendedFloatingActionButton = this.f10220i;
        if (zM8319g) {
            PropertyValuesHolder[] propertyValuesHolderArrM8317e = c4272e.m8317e("width");
            PropertyValuesHolder propertyValuesHolder = propertyValuesHolderArrM8317e[0];
            float width = extendedFloatingActionButton.getWidth();
            switch (c2978d.f10216a) {
                case 0:
                    ExtendedFloatingActionButton extendedFloatingActionButton2 = c2978d.f10217b;
                    measuredWidth = extendedFloatingActionButton2.f6278z + (extendedFloatingActionButton2.getMeasuredWidth() - (extendedFloatingActionButton2.getCollapsedPadding() * 2)) + extendedFloatingActionButton2.f6277y;
                    break;
                default:
                    measuredWidth = c2978d.f10217b.getCollapsedSize();
                    break;
            }
            propertyValuesHolder.setFloatValues(width, measuredWidth);
            c4272e.m8320h("width", propertyValuesHolderArrM8317e);
        }
        if (c4272e.m8319g("height")) {
            PropertyValuesHolder[] propertyValuesHolderArrM8317e2 = c4272e.m8317e("height");
            PropertyValuesHolder propertyValuesHolder2 = propertyValuesHolderArrM8317e2[0];
            float height = extendedFloatingActionButton.getHeight();
            switch (c2978d.f10216a) {
                case 0:
                    measuredHeight = c2978d.f10217b.getMeasuredHeight();
                    break;
                default:
                    measuredHeight = c2978d.f10217b.getCollapsedSize();
                    break;
            }
            propertyValuesHolder2.setFloatValues(height, measuredHeight);
            c4272e.m8320h("height", propertyValuesHolderArrM8317e2);
        }
        if (c4272e.m8319g("paddingStart")) {
            PropertyValuesHolder[] propertyValuesHolderArrM8317e3 = c4272e.m8317e("paddingStart");
            PropertyValuesHolder propertyValuesHolder3 = propertyValuesHolderArrM8317e3[0];
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            propertyValuesHolder3.setFloatValues(extendedFloatingActionButton.getPaddingStart(), c2978d.m6036c());
            c4272e.m8320h("paddingStart", propertyValuesHolderArrM8317e3);
        }
        if (c4272e.m8319g("paddingEnd")) {
            PropertyValuesHolder[] propertyValuesHolderArrM8317e4 = c4272e.m8317e("paddingEnd");
            PropertyValuesHolder propertyValuesHolder4 = propertyValuesHolderArrM8317e4[0];
            WeakHashMap weakHashMap2 = AbstractC3155s0.f10642a;
            propertyValuesHolder4.setFloatValues(extendedFloatingActionButton.getPaddingEnd(), c2978d.m6035b());
            c4272e.m8320h("paddingEnd", propertyValuesHolderArrM8317e4);
        }
        if (c4272e.m8319g("labelOpacity")) {
            PropertyValuesHolder[] propertyValuesHolderArrM8317e5 = c4272e.m8317e("labelOpacity");
            boolean z7 = this.f10219h;
            propertyValuesHolderArrM8317e5[0].setFloatValues(z7 ? 0.0f : 1.0f, z7 ? 1.0f : 0.0f);
            c4272e.m8320h("labelOpacity", propertyValuesHolderArrM8317e5);
        }
        return m6027b(c4272e);
    }

    @Override
    public final int mo6028c() {
        return this.f10219h ? R.animator.mtrl_extended_fab_change_size_expand_motion_spec : R.animator.mtrl_extended_fab_change_size_collapse_motion_spec;
    }

    @Override
    public final void mo6030e() {
        this.f10197d.f9501b = null;
        ExtendedFloatingActionButton extendedFloatingActionButton = this.f10220i;
        extendedFloatingActionButton.f6268C = false;
        extendedFloatingActionButton.setHorizontallyScrolling(false);
        ViewGroup.LayoutParams layoutParams = extendedFloatingActionButton.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        C2978d c2978d = this.f10218g;
        layoutParams.width = c2978d.m6034a().width;
        layoutParams.height = c2978d.m6034a().height;
    }

    @Override
    public final void mo6031f(Animator animator) {
        C2782c c2782c = this.f10197d;
        Animator animator2 = (Animator) c2782c.f9501b;
        if (animator2 != null) {
            animator2.cancel();
        }
        c2782c.f9501b = animator;
        boolean z7 = this.f10219h;
        ExtendedFloatingActionButton extendedFloatingActionButton = this.f10220i;
        extendedFloatingActionButton.f6267B = z7;
        extendedFloatingActionButton.f6268C = true;
        extendedFloatingActionButton.setHorizontallyScrolling(true);
    }

    @Override
    public final void mo6032g() {
        boolean z7 = this.f10219h;
        ExtendedFloatingActionButton extendedFloatingActionButton = this.f10220i;
        extendedFloatingActionButton.f6267B = z7;
        ViewGroup.LayoutParams layoutParams = extendedFloatingActionButton.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        C2978d c2978d = this.f10218g;
        layoutParams.width = c2978d.m6034a().width;
        layoutParams.height = c2978d.m6034a().height;
        int iM6036c = c2978d.m6036c();
        int paddingTop = extendedFloatingActionButton.getPaddingTop();
        int iM6035b = c2978d.m6035b();
        int paddingBottom = extendedFloatingActionButton.getPaddingBottom();
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        extendedFloatingActionButton.setPaddingRelative(iM6036c, paddingTop, iM6035b, paddingBottom);
        extendedFloatingActionButton.requestLayout();
    }

    @Override
    public final boolean mo6033h() {
        ExtendedFloatingActionButton extendedFloatingActionButton = this.f10220i;
        return this.f10219h == extendedFloatingActionButton.f6267B || extendedFloatingActionButton.getIcon() == null || TextUtils.isEmpty(extendedFloatingActionButton.getText());
    }
}
