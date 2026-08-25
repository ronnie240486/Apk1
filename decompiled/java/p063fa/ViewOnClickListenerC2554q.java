package p063fa;

import android.view.View;
import androidx.recyclerview.widget.AbstractC1158k0;

public final class ViewOnClickListenerC2554q implements View.OnClickListener {

    public final int f8894a;

    public final int f8895b;

    public final AbstractC1158k0 f8896c;

    public ViewOnClickListenerC2554q(AbstractC1158k0 abstractC1158k0, int i6, int i10) {
        this.f8894a = i10;
        this.f8896c = abstractC1158k0;
        this.f8895b = i6;
    }

    @Override
    public final void onClick(View view) {
        switch (this.f8894a) {
            case 0:
                InterfaceC2549o0 interfaceC2549o0 = ((C2560t) this.f8896c).f8904h;
                if (interfaceC2549o0 != null) {
                    interfaceC2549o0.mo5482a(this.f8895b, view);
                }
                break;
            case 1:
                ((C2516d0) this.f8896c).f8769f.m5942a(view, this.f8895b, Boolean.FALSE);
                break;
            case 2:
                ((C2525g0) this.f8896c).f8801f.m5942a(view, this.f8895b, Boolean.FALSE);
                break;
            case 3:
                InterfaceC2549o0 interfaceC2549o1 = ((C2543m0) this.f8896c).f8863a;
                if (interfaceC2549o1 != null) {
                    interfaceC2549o1.mo5482a(this.f8895b, view);
                }
                break;
            case 4:
                ((C2511b1) this.f8896c).f8754g.mo5482a(this.f8895b, view);
                break;
            case 5:
                ((C2550o1) this.f8896c).f8754g.mo5482a(this.f8895b, view);
                break;
            default:
                ((C2550o1) this.f8896c).f8754g.mo5482a(this.f8895b, view);
                break;
        }
    }
}
