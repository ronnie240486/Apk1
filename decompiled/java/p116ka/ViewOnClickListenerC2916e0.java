package p116ka;

import android.view.View;
import ba.C1371d;
import com.p2serv.android.p032ds.R;

public final class ViewOnClickListenerC2916e0 implements View.OnClickListener {

    public final int f9894a;

    public final C2924i0 f9895b;

    public ViewOnClickListenerC2916e0(C2924i0 c2924i0, int i6) {
        this.f9894a = i6;
        this.f9895b = c2924i0;
    }

    @Override
    public final void onClick(View view) {
        switch (this.f9894a) {
            case 0:
                this.f9895b.f9912U.m7736f();
                break;
            default:
                C2924i0 c2924i0 = this.f9895b;
                C1371d.m3242a(c2924i0.m1321j(), 0, c2924i0.m1324m().getString(R.string.no_source)).show();
                break;
        }
    }
}
