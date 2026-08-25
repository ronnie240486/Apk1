package sa;

import android.view.View;

public final class ViewOnClickListenerC3732c implements View.OnClickListener {

    public final int f12501a;

    public final DialogC3734e f12502b;

    public final ViewOnKeyListenerC3733d f12503c;

    public ViewOnClickListenerC3732c(ViewOnKeyListenerC3733d viewOnKeyListenerC3733d, DialogC3734e dialogC3734e, int i6) {
        this.f12501a = i6;
        this.f12503c = viewOnKeyListenerC3733d;
        this.f12502b = dialogC3734e;
    }

    @Override
    public final void onClick(View view) {
        switch (this.f12501a) {
            case 0:
                this.f12503c.f12509f.onClick(this.f12502b, -1);
                break;
            default:
                this.f12503c.f12510g.onClick(this.f12502b, -2);
                break;
        }
    }
}
