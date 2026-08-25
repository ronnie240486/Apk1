package sa;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.AbstractC1185t0;
import androidx.recyclerview.widget.C1162l1;
import androidx.recyclerview.widget.RecyclerView;
import p003a2.AbstractC0032a;
import p103j9.AbstractC2796i;

public final class C3731b extends AbstractC1185t0 {

    public final int f12497a;

    public final int f12498b;

    public final int f12499c;

    public final int f12500d;

    public C3731b(int i6, int i10, int i11, int i12) {
        this.f12497a = i6;
        this.f12498b = i10;
        this.f12499c = i11;
        this.f12500d = i12;
    }

    @Override
    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, C1162l1 c1162l1) {
        AbstractC2796i.m5785f(rect, AbstractC0032a.m165s("38nUCGAG2A==\n", "sLygWgVlrKg=\n"));
        AbstractC2796i.m5785f(view, AbstractC0032a.m165s("2CEx0w==\n", "rkhUpAp5OEA=\n"));
        AbstractC2796i.m5785f(recyclerView, AbstractC0032a.m165s("g+qX7DNw\n", "84vliV0EiQs=\n"));
        AbstractC2796i.m5785f(c1162l1, AbstractC0032a.m165s("P0ZB50k=\n", "TDIgkyzbfII=\n"));
        super.getItemOffsets(rect, view, recyclerView, c1162l1);
        rect.set(this.f12497a, this.f12498b, this.f12499c, this.f12500d);
    }
}
