package p221u6;

import android.graphics.Canvas;
import android.graphics.Matrix;
import java.util.ArrayList;
import java.util.Iterator;
import p211t6.C3811a;

public final class C3916p extends AbstractC3922v {

    public final ArrayList f13189b;

    public final Matrix f13190c;

    public C3916p(ArrayList arrayList, Matrix matrix) {
        this.f13189b = arrayList;
        this.f13190c = matrix;
    }

    @Override
    public final void mo7829a(Matrix matrix, C3811a c3811a, int i6, Canvas canvas) {
        Iterator it = this.f13189b.iterator();
        while (it.hasNext()) {
            ((AbstractC3922v) it.next()).mo7829a(this.f13190c, c3811a, i6, canvas);
        }
    }
}
