package p063fa;

import android.view.View;
import androidx.recyclerview.widget.AbstractC1174p1;
import org.bitspark.android.beans.Menu;
import p055ea.C2448k;

public final class ViewOnFocusChangeListenerC2538k1 implements View.OnFocusChangeListener {

    public final int f8850a;

    public final int f8851b;

    public final Menu f8852c;

    public final AbstractC1174p1 f8853d;

    public final AbstractC2512c f8854e;

    public ViewOnFocusChangeListenerC2538k1(AbstractC2512c abstractC2512c, int i6, AbstractC1174p1 abstractC1174p1, Menu menu, int i10) {
        this.f8850a = i10;
        this.f8854e = abstractC2512c;
        this.f8851b = i6;
        this.f8853d = abstractC1174p1;
        this.f8852c = menu;
    }

    @Override
    public final void onFocusChange(View view, boolean z7) {
        switch (this.f8850a) {
            case 0:
                if (z7) {
                    C2544m1 c2544m1 = (C2544m1) this.f8854e;
                    int i6 = c2544m1.f8868i;
                    int i10 = this.f8851b;
                    if (i10 != i6) {
                        C2448k c2448k = c2544m1.f8750c;
                        View view2 = ((C2541l1) this.f8853d).itemView;
                        c2448k.m5486d(i10, this.f8852c);
                        c2544m1.f8868i = i10;
                    }
                }
                break;
            default:
                if (z7) {
                    C2550o1 c2550o1 = (C2550o1) this.f8854e;
                    int i11 = c2550o1.f8752e;
                    int i12 = this.f8851b;
                    if (i11 != i12) {
                        c2550o1.f8752e = i12;
                        View view3 = ((C2547n1) this.f8853d).itemView;
                        View view4 = c2550o1.f8753f;
                        if (view4 != null) {
                            view4.setSelected(false);
                        }
                        view3.setSelected(true);
                        c2550o1.f8753f = view3;
                        c2550o1.f8750c.m5486d(i12, this.f8852c);
                    }
                }
                break;
        }
    }
}
