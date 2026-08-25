package com.google.android.material.internal;

import android.graphics.Typeface;
import com.google.android.material.chip.Chip;
import p051e6.C2419d;
import p123l5.AbstractC2973a;

public final class C1836v extends AbstractC2973a {

    public final int f6492r;

    public final Object f6493s;

    public C1836v(int i6, Object obj) {
        this.f6492r = i6;
        this.f6493s = obj;
    }

    @Override
    public final void mo4282D(int i6) {
        switch (this.f6492r) {
            case 0:
                C1838x c1838x = (C1838x) this.f6493s;
                c1838x.f6497d = true;
                InterfaceC1837w interfaceC1837w = (InterfaceC1837w) c1838x.f6498e.get();
                if (interfaceC1837w != null) {
                    interfaceC1837w.mo4284a();
                }
                break;
        }
    }

    @Override
    public final void mo4283E(Typeface typeface, boolean z7) {
        switch (this.f6492r) {
            case 0:
                if (!z7) {
                    C1838x c1838x = (C1838x) this.f6493s;
                    c1838x.f6497d = true;
                    InterfaceC1837w interfaceC1837w = (InterfaceC1837w) c1838x.f6498e.get();
                    if (interfaceC1837w != null) {
                        interfaceC1837w.mo4284a();
                    }
                    break;
                }
                break;
            default:
                Chip chip = (Chip) this.f6493s;
                C2419d c2419d = chip.f6084e;
                chip.setText(c2419d.f8435D0 ? c2419d.f8436E : chip.getText());
                chip.requestLayout();
                chip.invalidate();
                break;
        }
    }

    private final void m4281V(int i6) {
    }
}
