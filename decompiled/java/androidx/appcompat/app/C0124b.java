package androidx.appcompat.app;

import android.view.View;
import android.widget.AbsListView;

public final class C0124b implements AbsListView.OnScrollListener {

    public final View f260a;

    public final View f261b;

    public C0124b(View view, View view2) {
        this.f260a = view;
        this.f261b = view2;
    }

    @Override
    public final void onScroll(AbsListView absListView, int i6, int i10, int i11) {
        C0136h.m413b(absListView, this.f260a, this.f261b);
    }

    @Override
    public final void onScrollStateChanged(AbsListView absListView, int i6) {
    }
}
