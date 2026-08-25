package p205t;

import android.view.View;

public final class C3752d extends AbstractC3762i {

    public final int f12593d;

    @Override
    public final void mo7503c(View view, float f) {
        switch (this.f12593d) {
            case 0:
                view.setAlpha(m7508a(f));
                break;
            case 1:
                view.setElevation(m7508a(f));
                break;
            case 2:
                view.setRotation(m7508a(f));
                break;
            case 3:
                view.setRotationX(m7508a(f));
                break;
            case 4:
                view.setRotationY(m7508a(f));
                break;
            case 5:
                view.setScaleX(m7508a(f));
                break;
            case 6:
                view.setScaleY(m7508a(f));
                break;
            case 7:
                view.setTranslationX(m7508a(f));
                break;
            case 8:
                view.setTranslationY(m7508a(f));
                break;
            default:
                view.setTranslationZ(m7508a(f));
                break;
        }
    }
}
