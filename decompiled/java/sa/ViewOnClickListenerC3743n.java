package sa;

import android.view.View;

public final class ViewOnClickListenerC3743n implements View.OnClickListener {

    public final int f12544a;

    public final C3745p f12545b;

    public ViewOnClickListenerC3743n(C3745p c3745p, int i6) {
        this.f12544a = i6;
        this.f12545b = c3745p;
    }

    @Override
    public final void onClick(View view) {
        switch (this.f12544a) {
            case 0:
                C3745p c3745p = this.f12545b;
                Runnable runnable = c3745p.f12547k0;
                if (runnable != null) {
                    runnable.run();
                }
                c3745p.m1274Q(false, false);
                break;
            case 1:
                C3745p c3745p2 = this.f12545b;
                Runnable runnable2 = c3745p2.f12548l0;
                if (runnable2 != null) {
                    runnable2.run();
                    c3745p2.f12552p0.setEnabled(false);
                }
                break;
            default:
                this.f12545b.m1274Q(false, false);
                break;
        }
    }
}
