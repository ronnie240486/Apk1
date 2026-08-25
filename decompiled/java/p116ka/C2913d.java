package p116ka;

import android.view.View;
import org.bitspark.android.beans.HistoryBean;
import p063fa.AbstractC2562u;
import p063fa.C2560t;
import p063fa.InterfaceC2549o0;

public final class C2913d implements InterfaceC2549o0 {

    public final int f9871a;

    public final ViewOnKeyListenerC2915e f9872b;

    public C2913d(ViewOnKeyListenerC2915e viewOnKeyListenerC2915e, int i6) {
        this.f9871a = i6;
        this.f9872b = viewOnKeyListenerC2915e;
    }

    @Override
    public final void mo5482a(int i6, View view) {
        switch (this.f9871a) {
            case 0:
                AbstractC2562u.f8912f = 1;
                ViewOnKeyListenerC2915e viewOnKeyListenerC2915e = this.f9872b;
                C2560t c2560t = viewOnKeyListenerC2915e.f9884Y;
                c2560t.notifyItemChanged(c2560t.f8914b);
                C2560t c2560t2 = viewOnKeyListenerC2915e.f9884Y;
                c2560t2.f8915c = c2560t2.f8916d.getChildLayoutPosition(view);
                C2560t c2560t3 = viewOnKeyListenerC2915e.f9884Y;
                c2560t3.f8914b = c2560t3.f8916d.getChildLayoutPosition(view);
                C2560t c2560t4 = viewOnKeyListenerC2915e.f9884Y;
                c2560t4.notifyItemChanged(c2560t4.f8914b);
                viewOnKeyListenerC2915e.m5909R((HistoryBean) viewOnKeyListenerC2915e.f9884Y.f8903g.get(i6));
                break;
            default:
                AbstractC2562u.f8912f = 1;
                ViewOnKeyListenerC2915e viewOnKeyListenerC2915e2 = this.f9872b;
                C2560t c2560t5 = viewOnKeyListenerC2915e2.f9886b0;
                c2560t5.notifyItemChanged(c2560t5.f8914b);
                C2560t c2560t6 = viewOnKeyListenerC2915e2.f9886b0;
                c2560t6.f8915c = c2560t6.f8916d.getChildLayoutPosition(view);
                C2560t c2560t7 = viewOnKeyListenerC2915e2.f9886b0;
                c2560t7.f8914b = c2560t7.f8916d.getChildLayoutPosition(view);
                C2560t c2560t8 = viewOnKeyListenerC2915e2.f9886b0;
                c2560t8.notifyItemChanged(c2560t8.f8914b);
                viewOnKeyListenerC2915e2.m5909R((HistoryBean) viewOnKeyListenerC2915e2.f9886b0.f8903g.get(i6));
                break;
        }
    }
}
