package p205t;

import android.view.View;

public final class C3763i0 extends AbstractC3771m0 {

    public final int f12616g;

    @Override
    public final boolean mo7510b(float f, long j10, View view, C3781u c3781u) {
        switch (this.f12616g) {
            case 0:
                view.setAlpha(m7513a(f, j10, view, c3781u));
                break;
            case 1:
                view.setElevation(m7513a(f, j10, view, c3781u));
                break;
            case 2:
                view.setRotation(m7513a(f, j10, view, c3781u));
                break;
            case 3:
                view.setRotationX(m7513a(f, j10, view, c3781u));
                break;
            case 4:
                view.setRotationY(m7513a(f, j10, view, c3781u));
                break;
            case 5:
                view.setScaleX(m7513a(f, j10, view, c3781u));
                break;
            case 6:
                view.setScaleY(m7513a(f, j10, view, c3781u));
                break;
            case 7:
                view.setTranslationX(m7513a(f, j10, view, c3781u));
                break;
            case 8:
                view.setTranslationY(m7513a(f, j10, view, c3781u));
                break;
            default:
                view.setTranslationZ(m7513a(f, j10, view, c3781u));
                break;
        }
        return this.f12627d;
    }
}
