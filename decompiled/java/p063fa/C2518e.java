package p063fa;

import android.widget.ExpandableListView;

public final class C2518e implements ExpandableListView.OnGroupCollapseListener {

    public final C2536k f8776a;

    public C2518e(C2536k c2536k) {
        this.f8776a = c2536k;
    }

    @Override
    public final void onGroupCollapse(int i6) {
        this.f8776a.f8845l.put(Integer.valueOf(i6), Boolean.FALSE);
    }
}
