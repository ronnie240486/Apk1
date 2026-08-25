package com.google.android.material.datepicker;

import android.view.View;
import java.util.Iterator;

public final class ViewOnClickListenerC1802s implements View.OnClickListener {

    public final int f6209a;

    public final C1804u f6210b;

    public ViewOnClickListenerC1802s(C1804u c1804u, int i6) {
        this.f6209a = i6;
        this.f6210b = c1804u;
    }

    @Override
    public final void onClick(View view) {
        switch (this.f6209a) {
            case 0:
                C1804u c1804u = this.f6210b;
                Iterator it = c1804u.f6219k0.iterator();
                if (!it.hasNext()) {
                    c1804u.m1274Q(false, false);
                    return;
                } else {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    c1804u.m4206T().getClass();
                    throw null;
                }
            case 1:
                C1804u c1804u2 = this.f6210b;
                Iterator it2 = c1804u2.f6220l0.iterator();
                while (it2.hasNext()) {
                    ((View.OnClickListener) it2.next()).onClick(view);
                }
                c1804u2.m1274Q(false, false);
                return;
            default:
                C1804u c1804u3 = this.f6210b;
                c1804u3.f6217E0.setEnabled(c1804u3.m4206T().mo4174f());
                c1804u3.f6215C0.toggle();
                c1804u3.m4209Y(c1804u3.f6215C0);
                c1804u3.m4207W();
                return;
        }
    }
}
