package p063fa;

import android.widget.ExpandableListView;

public final class C2515d implements ExpandableListView.OnGroupExpandListener {

    public final C2536k f8764a;

    public C2515d(C2536k c2536k) {
        this.f8764a = c2536k;
    }

    @Override
    public final void onGroupExpand(int i6) {
        this.f8764a.f8845l.put(Integer.valueOf(i6), Boolean.TRUE);
    }
}
