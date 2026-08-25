package androidx.leanback.transition;

import android.view.View;
import p222u7.AbstractC3928d;

public final class C0442c extends AbstractC3928d {

    public final int f2045b;

    @Override
    public final float mo1345h(View view) {
        switch (this.f2045b) {
            case 0:
                return view.getTranslationX() - view.getWidth();
            case 1:
                return view.getTranslationX() + view.getWidth();
            case 2:
                return view.getLayoutDirection() == 1 ? view.getTranslationX() + view.getWidth() : view.getTranslationX() - view.getWidth();
            default:
                return view.getLayoutDirection() == 1 ? view.getTranslationX() - view.getWidth() : view.getTranslationX() + view.getWidth();
        }
    }
}
