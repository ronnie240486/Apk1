package p063fa;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
import p055ea.C2448k;

public abstract class AbstractC2512c extends AbstractC2531i0 {

    public C2448k f8750c;

    public View.OnKeyListener f8751d;

    public int f8752e = 0;

    public View f8753f = null;

    public InterfaceC2549o0 f8754g;

    public final ArrayList f8755h;

    public AbstractC2512c(List list) {
        ArrayList arrayList = new ArrayList();
        this.f8755h = arrayList;
        arrayList.addAll(list);
    }

    public void mo5549a(List list) {
        ArrayList arrayList = this.f8755h;
        arrayList.clear();
        arrayList.addAll(list);
    }

    @Override
    public int getItemCount() {
        return this.f8755h.size();
    }
}
