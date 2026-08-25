package p063fa;

import android.view.KeyEvent;
import android.view.View;
import ma.C3091a;
import org.bitspark.android.Spark;
import p055ea.EnumC2434d;
import p116ka.ViewOnKeyListenerC2932m0;
import p209t3.C3807d;

public final class ViewOnKeyListenerC2521f implements View.OnKeyListener {

    public final int f8785a;

    public final int f8786b;

    public final Object f8787c;

    public ViewOnKeyListenerC2521f(int i6, int i10, Object obj) {
        this.f8785a = i10;
        this.f8787c = obj;
        this.f8786b = i6;
    }

    @Override
    public final boolean onKey(View view, int i6, KeyEvent keyEvent) {
        switch (this.f8785a) {
            case 0:
                int i10 = this.f8786b;
                if (i10 == 0 && i6 == 19) {
                    return true;
                }
                C2536k c2536k = (C2536k) this.f8787c;
                if (i10 == c2536k.getGroupCount() - 1 && i6 == 20) {
                    return c2536k.f8845l.get(Integer.valueOf(i10)) == null || !((Boolean) c2536k.f8845l.get(Integer.valueOf(i10))).booleanValue();
                }
                return c2536k.f8844k.onKey(view, i6, keyEvent);
            case 1:
                int i11 = this.f8786b;
                if (i11 == 0 && i6 == 19) {
                    return true;
                }
                C2516d0 c2516d0 = (C2516d0) this.f8787c;
                if (i11 == c2516d0.f8767d.size() - 1 && i6 == 20) {
                    return true;
                }
                return c2516d0.f8769f.f9989b.onKey(view, i6, keyEvent);
            case 2:
                C2525g0 c2525g0 = (C2525g0) this.f8787c;
                if (this.f8786b == c2525g0.f8799d.size() - 1 && i6 == 20) {
                    return true;
                }
                return c2525g0.f8801f.f9989b.onKey(view, i6, keyEvent);
            default:
                if (this.f8786b % 7 == 0 && keyEvent.getAction() == 0 && i6 == 21) {
                    Spark.f11002X1.sendEmptyMessage(105);
                    ViewOnKeyListenerC2932m0.f9951F0 = EnumC2434d.f8533e;
                    return true;
                }
                if (keyEvent.getAction() != 0 || i6 != 4) {
                    return false;
                }
                InterfaceC2546n0 interfaceC2546n0 = ((C3091a) this.f8787c).f10562m;
                if (interfaceC2546n0 == null) {
                    return true;
                }
                interfaceC2546n0.mo233j();
                return true;
        }
    }

    public ViewOnKeyListenerC2521f(C3091a c3091a, C3807d c3807d) {
        this.f8785a = 3;
        this.f8787c = c3091a;
        int layoutPosition = c3807d.getLayoutPosition();
        c3091a.getClass();
        this.f8786b = layoutPosition;
    }
}
