package androidx.recyclerview.widget;

import android.view.View;
import java.util.List;

public final class C1199y {

    public boolean f3730a;

    public int f3731b;

    public int f3732c;

    public int f3733d;

    public int f3734e;

    public int f3735f;

    public int f3736g;

    public int f3737h;

    public int f3738i;

    public int f3739j;

    public List f3740k;

    public boolean f3741l;

    public final void m3011a(View view) {
        int layoutPosition;
        int size = this.f3740k.size();
        View view2 = null;
        int i6 = Integer.MAX_VALUE;
        for (int i10 = 0; i10 < size; i10++) {
            View view3 = ((AbstractC1174p1) this.f3740k.get(i10)).itemView;
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view3.getLayoutParams();
            if (view3 != view && !layoutParams.f3465a.isRemoved() && (layoutPosition = (layoutParams.f3465a.getLayoutPosition() - this.f3733d) * this.f3734e) >= 0 && layoutPosition < i6) {
                view2 = view3;
                if (layoutPosition == 0) {
                    break;
                } else {
                    i6 = layoutPosition;
                }
            }
        }
        if (view2 == null) {
            this.f3733d = -1;
        } else {
            this.f3733d = ((RecyclerView.LayoutParams) view2.getLayoutParams()).f3465a.getLayoutPosition();
        }
    }

    public final View m3012b(C1140e1 c1140e1) {
        List list = this.f3740k;
        if (list == null) {
            View view = c1140e1.m2935l(this.f3733d, Long.MAX_VALUE).itemView;
            this.f3733d += this.f3734e;
            return view;
        }
        int size = list.size();
        for (int i6 = 0; i6 < size; i6++) {
            View view2 = ((AbstractC1174p1) this.f3740k.get(i6)).itemView;
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view2.getLayoutParams();
            if (!layoutParams.f3465a.isRemoved() && this.f3733d == layoutParams.f3465a.getLayoutPosition()) {
                m3011a(view2);
                return view2;
            }
        }
        return null;
    }
}
