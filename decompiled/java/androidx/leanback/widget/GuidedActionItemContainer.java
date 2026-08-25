package androidx.leanback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.bumptech.glide.AbstractC1466d;

class GuidedActionItemContainer extends NonOverlappingLinearLayoutWithForeground {

    public final boolean f2139d;

    public GuidedActionItemContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override
    public final View focusSearch(View view, int i6) {
        if (this.f2139d || !AbstractC1466d.m3500s(this, view)) {
            return super.focusSearch(view, i6);
        }
        View viewFocusSearch = super.focusSearch(view, i6);
        if (AbstractC1466d.m3500s(this, viewFocusSearch)) {
            return viewFocusSearch;
        }
        return null;
    }

    public GuidedActionItemContainer(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f2139d = true;
    }
}
