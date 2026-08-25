package androidx.leanback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

class NonOverlappingFrameLayout extends FrameLayout {
    public NonOverlappingFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    @Override
    public final boolean hasOverlappingRendering() {
        return false;
    }

    public NonOverlappingFrameLayout(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
    }
}
