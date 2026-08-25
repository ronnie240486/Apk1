package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.p2serv.android.p032ds.R;

public class ShadowOverlayContainer extends FrameLayout {

    public final int f2281a;

    static {
        new Rect();
    }

    public ShadowOverlayContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public int getShadowType() {
        return this.f2281a;
    }

    public View getWrappedView() {
        return null;
    }

    @Override
    public final boolean hasOverlappingRendering() {
        return false;
    }

    @Override
    public final void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        super.onLayout(z7, i6, i10, i11, i12);
    }

    public ShadowOverlayContainer(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f2281a = 2;
        getResources().getDimension(R.dimen.lb_material_shadow_normal_z);
        getResources().getDimension(R.dimen.lb_material_shadow_focused_z);
        this.f2281a = 3;
    }

    public void setOverlayColor(int i6) {
    }

    public void setShadowFocusLevel(float f) {
    }
}
