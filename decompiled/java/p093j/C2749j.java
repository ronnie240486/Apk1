package p093j;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.appcompat.widget.C0279u3;
import java.util.ArrayList;
import java.util.Iterator;
import p138n0.C3102a1;
import p156o9.AbstractC3280d;

public final class C2749j {

    public Interpolator f9465c;

    public AbstractC3280d f9466d;

    public boolean f9467e;

    public long f9464b = -1;

    public final C0279u3 f9468f = new C0279u3(this);

    public final ArrayList f9463a = new ArrayList();

    public final void m5714a() {
        if (this.f9467e) {
            Iterator it = this.f9463a.iterator();
            while (it.hasNext()) {
                ((C3102a1) it.next()).m6122b();
            }
            this.f9467e = false;
        }
    }

    public final void m5715b() {
        View view;
        if (this.f9467e) {
            return;
        }
        for (C3102a1 c3102a1 : this.f9463a) {
            long j10 = this.f9464b;
            if (j10 >= 0) {
                c3102a1.m6123c(j10);
            }
            Interpolator interpolator = this.f9465c;
            if (interpolator != null && (view = (View) c3102a1.f10574a.get()) != null) {
                view.animate().setInterpolator(interpolator);
            }
            if (this.f9466d != null) {
                c3102a1.m6124d(this.f9468f);
            }
            View view2 = (View) c3102a1.f10574a.get();
            if (view2 != null) {
                view2.animate().start();
            }
        }
        this.f9467e = true;
    }
}
