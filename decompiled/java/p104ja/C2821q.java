package p104ja;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.leanback.widget.VerticalGridView;
import com.p2serv.android.p032ds.R;
import p237w0.AbstractC4044e;

public final class C2821q extends AbstractC2820p {

    public static final SparseIntArray f9590q;

    public long f9591p;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f9590q = sparseIntArray;
        sparseIntArray.put(R.id.iv_top, 1);
        sparseIntArray.put(R.id.tv_top, 2);
        sparseIntArray.put(R.id.divider, 3);
        sparseIntArray.put(R.id.vg, 4);
    }

    public C2821q(View view) {
        Object[] objArrM8047R = AbstractC4044e.m8047R(view, 5, f9590q);
        View view2 = (View) objArrM8047R[3];
        super(view, view2, (TextView) objArrM8047R[2], (VerticalGridView) objArrM8047R[4]);
        this.f9591p = -1L;
        ((ConstraintLayout) objArrM8047R[0]).setTag(null);
        m8049T(view);
        synchronized (this) {
            this.f9591p = 1L;
        }
        m8048S();
    }

    @Override
    public final void mo5800O() {
        synchronized (this) {
            this.f9591p = 0L;
        }
    }

    @Override
    public final boolean mo5801P() {
        synchronized (this) {
            try {
                return this.f9591p != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
