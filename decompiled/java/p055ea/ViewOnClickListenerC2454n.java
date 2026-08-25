package p055ea;

import android.view.View;
import android.widget.LinearLayout;

public final class ViewOnClickListenerC2454n implements View.OnClickListener {

    public final int f8638a;

    public final LinearLayout f8639b;

    public ViewOnClickListenerC2454n(LinearLayout linearLayout, int i6) {
        this.f8638a = i6;
        this.f8639b = linearLayout;
    }

    @Override
    public final void onClick(View view) {
        switch (this.f8638a) {
            case 0:
                this.f8639b.requestFocus();
                break;
            default:
                this.f8639b.requestFocus();
                break;
        }
    }
}
