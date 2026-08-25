package p063fa;

import android.view.KeyEvent;
import android.view.View;
import p116ka.C2914d0;
import p251x6.C4129h;
import p251x6.C4132k;
import sa.C3736g;

public final class ViewOnKeyListenerC2573z0 implements View.OnKeyListener {

    public final int f8949a;

    public final Object f8950b;

    public ViewOnKeyListenerC2573z0(int i6, Object obj) {
        this.f8949a = i6;
        this.f8950b = obj;
    }

    @Override
    public final boolean onKey(View view, int i6, KeyEvent keyEvent) {
        C4129h c4129hM4341h;
        C4132k c4132k;
        switch (this.f8949a) {
            case 0:
                return ((C2511b1) this.f8950b).f8751d.onKey(view, i6, keyEvent);
            case 1:
                View.OnKeyListener onKeyListener = ((C2544m1) this.f8950b).f8751d;
                if (onKeyListener != null) {
                    return onKeyListener.onKey(view, i6, keyEvent);
                }
                return false;
            case 2:
                return ((C2550o1) this.f8950b).f8751d.onKey(view, i6, keyEvent);
            case 3:
                return ((C2550o1) this.f8950b).f8751d.onKey(view, i6, keyEvent);
            case 4:
                C2914d0 c2914d0 = (C2914d0) this.f8950b;
                if (i6 == 4) {
                    if (keyEvent.getAction() != 0) {
                        return true;
                    }
                    c2914d0.f9876d.f9912U.m7736f();
                    return true;
                }
                if (((Integer) view.getTag()).intValue() != 0 || i6 != 19) {
                    return false;
                }
                if (keyEvent.getAction() != 0 || (c4129hM4341h = c2914d0.f9876d.f9915X.m4341h(c2914d0.f9874b.getCurrentItem())) == null || (c4132k = c4129hM4341h.f14033g) == null) {
                    return true;
                }
                c4132k.requestFocus();
                return true;
            default:
                if (i6 != 20 && i6 != 19) {
                    return false;
                }
                ((C3736g) this.f8950b).dismiss();
                return true;
        }
    }
}
