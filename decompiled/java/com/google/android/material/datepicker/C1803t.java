package com.google.android.material.datepicker;

import androidx.fragment.app.AbstractComponentCallbacksC0427s;
import java.util.Iterator;

public final class C1803t {

    public final int f6211a;

    public final AbstractComponentCallbacksC0427s f6212b;

    public C1803t(int i6, AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s) {
        this.f6211a = i6;
        this.f6212b = abstractComponentCallbacksC0427s;
    }

    public final void m4202a() {
        switch (this.f6211a) {
            case 0:
                ((C1804u) this.f6212b).f6217E0.setEnabled(false);
                break;
            default:
                Iterator it = ((C1805v) this.f6212b).f6149T.iterator();
                while (it.hasNext()) {
                    ((C1803t) it.next()).m4202a();
                }
                break;
        }
    }

    public final void m4203b(Object obj) {
        switch (this.f6211a) {
            case 0:
                C1804u c1804u = (C1804u) this.f6212b;
                c1804u.m4208X();
                c1804u.f6217E0.setEnabled(c1804u.m4206T().mo4174f());
                break;
            default:
                Iterator it = ((C1805v) this.f6212b).f6149T.iterator();
                while (it.hasNext()) {
                    ((C1803t) it.next()).m4203b(obj);
                }
                break;
        }
    }
}
