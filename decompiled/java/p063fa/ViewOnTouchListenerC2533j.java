package p063fa;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ExpandableListView;
import p116ka.C2933n;
import p116ka.ViewOnKeyListenerC2937r;

public final class ViewOnTouchListenerC2533j implements View.OnTouchListener {

    public final int f8820a;

    public final int f8821b;

    public final C2536k f8822c;

    public ViewOnTouchListenerC2533j(C2536k c2536k, int i6, int i10) {
        this.f8822c = c2536k;
        this.f8820a = i6;
        this.f8821b = i10;
    }

    @Override
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            C2536k c2536k = this.f8822c;
            C2933n c2933n = c2536k.f8846m;
            ExpandableListView expandableListView = c2536k.f8835b;
            ViewOnKeyListenerC2937r.m5946S(c2933n.f9989b, view, this.f8820a, this.f8821b, 0);
        }
        return false;
    }
}
