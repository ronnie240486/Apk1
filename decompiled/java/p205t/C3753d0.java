package p205t;

import android.view.View;

public final class C3753d0 extends AbstractC3761h0 {

    public final int f12594f;

    @Override
    public final void mo7504c(View view, float f) {
        switch (this.f12594f) {
            case 0:
                view.setAlpha(m7507a(f));
                break;
            case 1:
                view.setElevation(m7507a(f));
                break;
            case 2:
                view.setPivotX(m7507a(f));
                break;
            case 3:
                view.setPivotY(m7507a(f));
                break;
            case 4:
                view.setRotation(m7507a(f));
                break;
            case 5:
                view.setRotationX(m7507a(f));
                break;
            case 6:
                view.setRotationY(m7507a(f));
                break;
            case 7:
                view.setScaleX(m7507a(f));
                break;
            case 8:
                view.setScaleY(m7507a(f));
                break;
            case 9:
                view.setTranslationX(m7507a(f));
                break;
            case 10:
                view.setTranslationY(m7507a(f));
                break;
            default:
                view.setTranslationZ(m7507a(f));
                break;
        }
    }
}
