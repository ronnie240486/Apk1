package androidx.leanback.transition;

import android.content.Context;
import android.transition.Slide;
import android.util.AttributeSet;

public class SlideNoPropagation extends Slide {
    public SlideNoPropagation(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override
    public final void setSlideEdge(int i6) {
        super.setSlideEdge(i6);
        setPropagation(null);
    }
}
