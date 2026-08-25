package p063fa;

import android.view.MotionEvent;
import android.view.View;
import androidx.leanback.widget.VerticalGridView;
import p116ka.C2933n;
import p116ka.ViewOnKeyListenerC2937r;

public final class ViewOnTouchListenerC2527h implements View.OnTouchListener {

    public final int f8805a;

    public final int f8806b;

    public final Object f8807c;

    public ViewOnTouchListenerC2527h(int i6, int i10, Object obj) {
        this.f8805a = i10;
        this.f8807c = obj;
        this.f8806b = i6;
    }

    @Override
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        VerticalGridView verticalGridView;
        VerticalGridView verticalGridView2;
        switch (this.f8805a) {
            case 0:
                if (motionEvent.getAction() == 1) {
                    C2536k c2536k = (C2536k) this.f8807c;
                    ViewOnKeyListenerC2937r.m5945R(c2536k.f8846m.f9989b, c2536k.f8835b, this.f8806b);
                }
                break;
            case 1:
                C2516d0 c2516d0 = (C2516d0) this.f8807c;
                C2933n c2933n = c2516d0.f8818b;
                if (c2933n != null && (verticalGridView = c2933n.f9989b.f10000W) != null) {
                    verticalGridView.setFocusScrollStrategy(1);
                }
                if (motionEvent.getAction() == 1) {
                    if (!c2516d0.f8771h) {
                        c2516d0.f8769f.m5942a(view, this.f8806b, Boolean.TRUE);
                    } else {
                        c2516d0.f8771h = false;
                    }
                }
                break;
            default:
                C2525g0 c2525g0 = (C2525g0) this.f8807c;
                C2933n c2933n2 = c2525g0.f8818b;
                if (c2933n2 != null && (verticalGridView2 = c2933n2.f9989b.f10000W) != null) {
                    verticalGridView2.setFocusScrollStrategy(1);
                }
                if (motionEvent.getAction() == 1) {
                    if (!c2525g0.f8803h) {
                        c2525g0.f8801f.m5942a(view, this.f8806b, Boolean.TRUE);
                    } else {
                        c2525g0.f8803h = false;
                    }
                }
                break;
        }
        return false;
    }
}
