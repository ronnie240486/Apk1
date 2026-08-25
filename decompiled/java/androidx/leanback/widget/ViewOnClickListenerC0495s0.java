package androidx.leanback.widget;

import android.view.View;

public final class ViewOnClickListenerC0495s0 implements View.OnClickListener {

    public final SearchBar f2436a;

    public ViewOnClickListenerC0495s0(SearchBar searchBar) {
        this.f2436a = searchBar;
    }

    @Override
    public final void onClick(View view) {
        SearchBar searchBar = this.f2436a;
        if (searchBar.f2245v) {
            searchBar.m1396b();
        } else {
            searchBar.m1395a();
        }
    }
}
