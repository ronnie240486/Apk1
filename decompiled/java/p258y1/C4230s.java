package p258y1;

import android.view.View;
import android.view.ViewGroup;
import java.util.WeakHashMap;
import p138n0.AbstractC3155s0;

public final class C4230s extends AbstractC4233v {

    public final int f14369v;

    @Override
    public final float mo8271b(ViewGroup viewGroup, View view) {
        switch (this.f14369v) {
            case 0:
                return view.getTranslationX() - viewGroup.getWidth();
            case 1:
                WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                return viewGroup.getLayoutDirection() == 1 ? view.getTranslationX() + viewGroup.getWidth() : view.getTranslationX() - viewGroup.getWidth();
            case 2:
                return view.getTranslationX() + viewGroup.getWidth();
            default:
                WeakHashMap weakHashMap2 = AbstractC3155s0.f10642a;
                return viewGroup.getLayoutDirection() == 1 ? view.getTranslationX() - viewGroup.getWidth() : view.getTranslationX() + viewGroup.getWidth();
        }
    }
}
