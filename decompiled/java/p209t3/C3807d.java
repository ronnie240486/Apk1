package p209t3;

import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.AbstractC1174p1;
import java.util.HashSet;
import java.util.LinkedHashSet;

public final class C3807d extends AbstractC1174p1 {

    public final SparseArray f12847a;

    public final View f12848b;

    public C3807d(View view) {
        super(view);
        this.f12847a = new SparseArray();
        new LinkedHashSet();
        new LinkedHashSet();
        new HashSet();
        this.f12848b = view;
    }

    public final View m7583b(int i6) {
        SparseArray sparseArray = this.f12847a;
        View view = (View) sparseArray.get(i6);
        if (view != null) {
            return view;
        }
        View viewFindViewById = this.itemView.findViewById(i6);
        sparseArray.put(i6, viewFindViewById);
        return viewFindViewById;
    }

    public final void m7584c(int i6, boolean z7) {
        m7583b(i6).setVisibility(z7 ? 0 : 4);
    }
}
