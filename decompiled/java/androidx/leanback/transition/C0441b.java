package androidx.leanback.transition;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import p187r4.AbstractC3612b;

public final class C0441b extends AbstractC3612b {

    public final FadeAndShortSlide f2044c;

    public C0441b(FadeAndShortSlide fadeAndShortSlide) {
        this.f2044c = fadeAndShortSlide;
    }

    @Override
    public final float mo1344o(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
        int iCenterY;
        int height = (view.getHeight() / 2) + iArr[1];
        viewGroup.getLocationOnScreen(iArr);
        Rect epicenter = this.f2044c.getEpicenter();
        if (epicenter == null) {
            iCenterY = (viewGroup.getHeight() / 2) + iArr[1];
        } else {
            iCenterY = epicenter.centerY();
        }
        if (height < iCenterY) {
            return view.getTranslationY() - fadeAndShortSlide.m1341b(viewGroup);
        }
        return fadeAndShortSlide.m1341b(viewGroup) + view.getTranslationY();
    }
}
