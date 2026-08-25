package p258y1;

import android.view.View;
import android.view.ViewGroup;

public final class C4231t extends AbstractC4233v {

    public final int f14370v;

    @Override
    public final float mo8272a(ViewGroup viewGroup, View view) {
        switch (this.f14370v) {
            case 0:
                return view.getTranslationY() - viewGroup.getHeight();
            default:
                return view.getTranslationY() + viewGroup.getHeight();
        }
    }
}
