package p064g;

import android.graphics.drawable.Animatable;
import p123l5.AbstractC2973a;
import p268z1.C4288c;

public final class C2574a extends AbstractC2973a {

    public final int f8951r;

    public final Animatable f8952s;

    public C2574a(Animatable animatable, int i6) {
        this.f8951r = i6;
        this.f8952s = animatable;
    }

    @Override
    public final void mo5562S() {
        switch (this.f8951r) {
            case 0:
                this.f8952s.start();
                break;
            default:
                ((C4288c) this.f8952s).start();
                break;
        }
    }

    @Override
    public final void mo5563U() {
        switch (this.f8951r) {
            case 0:
                this.f8952s.stop();
                break;
            default:
                ((C4288c) this.f8952s).stop();
                break;
        }
    }
}
