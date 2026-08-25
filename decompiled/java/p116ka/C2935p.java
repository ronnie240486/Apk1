package p116ka;

import android.view.View;
import android.widget.ExpandableListView;

public final class C2935p implements ExpandableListView.OnChildClickListener {

    public final int f9991a;

    public final ViewOnKeyListenerC2937r f9992b;

    public C2935p(ViewOnKeyListenerC2937r viewOnKeyListenerC2937r, int i6) {
        this.f9992b = viewOnKeyListenerC2937r;
        this.f9991a = i6;
    }

    @Override
    public final boolean onChildClick(ExpandableListView expandableListView, View view, int i6, int i10, long j10) {
        return ViewOnKeyListenerC2937r.m5946S(this.f9992b, view, i6, i10, this.f9991a);
    }
}
