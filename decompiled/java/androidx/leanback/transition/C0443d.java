package androidx.leanback.transition;

import android.view.View;
import p003a2.AbstractC0032a;

public final class C0443d extends AbstractC0032a {

    public final int f2046b;

    @Override
    public final float mo1345h(View view) {
        switch (this.f2046b) {
            case 0:
                return view.getTranslationY() - view.getHeight();
            default:
                return view.getTranslationY() + view.getHeight();
        }
    }
}
