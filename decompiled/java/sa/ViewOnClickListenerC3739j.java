package sa;

import android.view.View;

public final class ViewOnClickListenerC3739j implements View.OnClickListener {

    public final int f12519a;

    public final DialogC3734e f12520b;

    public final ViewOnKeyListenerC3740k f12521c;

    public ViewOnClickListenerC3739j(ViewOnKeyListenerC3740k viewOnKeyListenerC3740k, DialogC3734e dialogC3734e, int i6) {
        this.f12519a = i6;
        this.f12521c = viewOnKeyListenerC3740k;
        this.f12520b = dialogC3734e;
    }

    @Override
    public final void onClick(View view) {
        switch (this.f12519a) {
            case 0:
                this.f12521c.f12529h.onClick(this.f12520b, -1);
                break;
            case 1:
                this.f12521c.f12530i.onClick(this.f12520b, -2);
                break;
            default:
                this.f12521c.f12531j.onClick(this.f12520b, -2);
                break;
        }
    }
}
