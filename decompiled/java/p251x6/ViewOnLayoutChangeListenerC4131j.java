package p251x6;

import android.view.View;

public final class ViewOnLayoutChangeListenerC4131j implements View.OnLayoutChangeListener {

    public final View f14037a;

    public final C4132k f14038b;

    public ViewOnLayoutChangeListenerC4131j(C4132k c4132k, View view) {
        this.f14038b = c4132k;
        this.f14037a = view;
    }

    @Override
    public final void onLayoutChange(View view, int i6, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        View view2 = this.f14037a;
        if (view2.getVisibility() == 0) {
            this.f14038b.m8148c(view2);
        }
    }
}
