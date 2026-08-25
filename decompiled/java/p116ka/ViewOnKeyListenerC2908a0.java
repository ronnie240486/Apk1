package p116ka;

import android.view.KeyEvent;
import android.view.View;

public final class ViewOnKeyListenerC2908a0 implements View.OnKeyListener {

    public final int f9865a;

    public final C2924i0 f9866b;

    public ViewOnKeyListenerC2908a0(C2924i0 c2924i0, int i6) {
        this.f9865a = i6;
        this.f9866b = c2924i0;
    }

    @Override
    public final boolean onKey(View view, int i6, KeyEvent keyEvent) {
        switch (this.f9865a) {
            case 0:
                if (i6 != 4) {
                    return false;
                }
                if (keyEvent.getAction() == 0) {
                    this.f9866b.f9912U.m7736f();
                }
                return true;
            default:
                C2924i0 c2924i0 = this.f9866b;
                if (c2924i0.f9919c0.isShown()) {
                    if (i6 == 21 || i6 == 22 || i6 == 19 || i6 == 20) {
                        return true;
                    }
                    if (i6 == 4) {
                        if (keyEvent.getAction() != 0) {
                            return true;
                        }
                        c2924i0.f9912U.m7736f();
                        return true;
                    }
                }
                return false;
        }
    }
}
