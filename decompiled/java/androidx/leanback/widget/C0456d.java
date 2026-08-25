package androidx.leanback.widget;

import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.AbstractC1174p1;
import androidx.recyclerview.widget.InterfaceC1144f1;
import com.google.android.gms.cast.framework.internal.featurehighlight.C1498f;

public final class C0456d implements InterfaceC1144f1 {

    public final AbstractC0474j f2322a;

    public C0456d(AbstractC0474j abstractC0474j) {
        this.f2322a = abstractC0474j;
    }

    public final void m1421a(AbstractC1174p1 abstractC1174p1) {
        GridLayoutManager gridLayoutManager = this.f2322a.f2345a;
        gridLayoutManager.getClass();
        int absoluteAdapterPosition = abstractC1174p1.getAbsoluteAdapterPosition();
        if (absoluteAdapterPosition != -1) {
            View view = abstractC1174p1.itemView;
            C0476j1 c0476j1 = gridLayoutManager.f2102N;
            int i6 = c0476j1.f2351a;
            if (i6 == 1) {
                C1498f c1498f = (C1498f) c0476j1.f2353c;
                if (c1498f == null || c1498f.m3617g() == 0) {
                    return;
                }
                ((C1498f) c0476j1.f2353c).m3615e(Integer.toString(absoluteAdapterPosition));
                return;
            }
            if ((i6 == 2 || i6 == 3) && ((C1498f) c0476j1.f2353c) != null) {
                String string = Integer.toString(absoluteAdapterPosition);
                SparseArray<Parcelable> sparseArray = new SparseArray<>();
                view.saveHierarchyState(sparseArray);
                ((C1498f) c0476j1.f2353c).m3614d(string, sparseArray);
            }
        }
    }
}
