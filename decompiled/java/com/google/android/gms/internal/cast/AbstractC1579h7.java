package com.google.android.gms.internal.cast;

import androidx.fragment.app.C0423q;

public abstract class AbstractC1579h7 implements Cloneable {

    public final AbstractC1589i7 f5337a;

    public AbstractC1589i7 f5338b;

    public AbstractC1579h7(AbstractC1589i7 abstractC1589i7) {
        this.f5337a = abstractC1589i7;
        if (abstractC1589i7.m3869g()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.f5338b = (AbstractC1589i7) abstractC1589i7.mo3714h(4, null);
    }

    public final AbstractC1589i7 m3839a() {
        AbstractC1589i7 abstractC1589i7M3840b = m3840b();
        abstractC1589i7M3840b.getClass();
        boolean z7 = true;
        byte bByteValue = ((Byte) abstractC1589i7M3840b.mo3714h(1, null)).byteValue();
        if (bByteValue != 1) {
            if (bByteValue == 0) {
                z7 = false;
            } else {
                boolean zMo3740f = C1738y7.f5738c.m4060a(abstractC1589i7M3840b.getClass()).mo3740f(abstractC1589i7M3840b);
                abstractC1589i7M3840b.mo3714h(2, true == zMo3740f ? abstractC1589i7M3840b : null);
                z7 = zMo3740f;
            }
        }
        if (z7) {
            return abstractC1589i7M3840b;
        }
        throw new C0423q("Message was missing required fields.  (Lite runtime could not determine which fields were missing).", 3);
    }

    public final AbstractC1589i7 m3840b() {
        if (!this.f5338b.m3869g()) {
            return this.f5338b;
        }
        AbstractC1589i7 abstractC1589i7 = this.f5338b;
        abstractC1589i7.getClass();
        C1738y7.f5738c.m4060a(abstractC1589i7.getClass()).mo3738d(abstractC1589i7);
        abstractC1589i7.m3867d();
        return this.f5338b;
    }

    public final void m3841c() {
        if (this.f5338b.m3869g()) {
            return;
        }
        AbstractC1589i7 abstractC1589i7 = (AbstractC1589i7) this.f5337a.mo3714h(4, null);
        C1738y7.f5738c.m4060a(abstractC1589i7.getClass()).mo3741g(abstractC1589i7, this.f5338b);
        this.f5338b = abstractC1589i7;
    }

    public final Object clone() {
        AbstractC1579h7 abstractC1579h7 = (AbstractC1579h7) this.f5337a.mo3714h(5, null);
        abstractC1579h7.f5338b = m3840b();
        return abstractC1579h7;
    }
}
