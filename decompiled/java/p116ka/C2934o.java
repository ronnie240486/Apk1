package p116ka;

import android.view.View;
import android.widget.ExpandableListView;

public final class C2934o implements ExpandableListView.OnGroupClickListener {

    public final ViewOnKeyListenerC2937r f9990a;

    public C2934o(ViewOnKeyListenerC2937r viewOnKeyListenerC2937r) {
        this.f9990a = viewOnKeyListenerC2937r;
    }

    @Override
    public final boolean onGroupClick(ExpandableListView expandableListView, View view, int i6, long j10) {
        ViewOnKeyListenerC2937r.m5945R(this.f9990a, expandableListView, i6);
        return true;
    }
}
