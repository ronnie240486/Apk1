package androidx.leanback.transition;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import p187r4.AbstractC3612b;

public final class C0440a extends AbstractC3612b {

    public final int f2043c;

    public C0440a(int i6) {
        this.f2043c = i6;
    }

    @Override
    public float mo1343n(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
        int iCenterX;
        switch (this.f2043c) {
            case 0:
                if (viewGroup.getLayoutDirection() == 1) {
                    return fadeAndShortSlide.m1340a(viewGroup) + view.getTranslationX();
                }
                return view.getTranslationX() - fadeAndShortSlide.m1340a(viewGroup);
            case 1:
                return viewGroup.getLayoutDirection() == 1 ? view.getTranslationX() - fadeAndShortSlide.m1340a(viewGroup) : view.getTranslationX() + fadeAndShortSlide.m1340a(viewGroup);
            case 2:
                int width = (view.getWidth() / 2) + iArr[0];
                viewGroup.getLocationOnScreen(iArr);
                Rect epicenter = fadeAndShortSlide.getEpicenter();
                if (epicenter == null) {
                    iCenterX = (viewGroup.getWidth() / 2) + iArr[0];
                } else {
                    iCenterX = epicenter.centerX();
                }
                return width < iCenterX ? view.getTranslationX() - fadeAndShortSlide.m1340a(viewGroup) : view.getTranslationX() + fadeAndShortSlide.m1340a(viewGroup);
            default:
                return super.mo1343n(fadeAndShortSlide, viewGroup, view, iArr);
        }
    }

    @Override
    public float mo1344o(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
        switch (this.f2043c) {
            case 3:
                return fadeAndShortSlide.m1341b(viewGroup) + view.getTranslationY();
            case 4:
                return view.getTranslationY() - fadeAndShortSlide.m1341b(viewGroup);
            default:
                return super.mo1344o(fadeAndShortSlide, viewGroup, view, iArr);
        }
    }
}
