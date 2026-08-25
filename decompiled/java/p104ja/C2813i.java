package p104ja;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.p2serv.android.p032ds.R;
import p237w0.AbstractC4044e;

public final class C2813i extends AbstractC2812h {

    public static final SparseIntArray f9566n;

    public long f9567m;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f9566n = sparseIntArray;
        sparseIntArray.put(R.id.bg, 1);
        sparseIntArray.put(R.id.content_container, 2);
    }

    public C2813i(View view) {
        Object[] objArrM8047R = AbstractC4044e.m8047R(view, 3, f9566n);
        super(view, (FrameLayout) objArrM8047R[2]);
        this.f9567m = -1L;
        ((ConstraintLayout) objArrM8047R[0]).setTag(null);
        m8049T(view);
        synchronized (this) {
            this.f9567m = 1L;
        }
        m8048S();
    }

    @Override
    public final void mo5800O() {
        synchronized (this) {
            this.f9567m = 0L;
        }
    }

    @Override
    public final boolean mo5801P() {
        synchronized (this) {
            try {
                return this.f9567m != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
