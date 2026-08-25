package androidx.leanback.widget;

import android.view.View;

public final class ViewOnFocusChangeListenerC0487o0 implements View.OnFocusChangeListener {

    public final int f2375a;

    public final SearchBar f2376b;

    public ViewOnFocusChangeListenerC0487o0(SearchBar searchBar, int i6) {
        this.f2375a = i6;
        this.f2376b = searchBar;
    }

    @Override
    public final void onFocusChange(View view, boolean z7) {
        switch (this.f2375a) {
            case 0:
                SearchBar searchBar = this.f2376b;
                if (z7) {
                    searchBar.f2231h.post(new RunnableC0489p0(searchBar, 1));
                } else {
                    searchBar.f2232i.hideSoftInputFromWindow(searchBar.f2224a.getWindowToken(), 0);
                }
                searchBar.m1398d(z7);
                break;
            default:
                SearchBar searchBar2 = this.f2376b;
                if (z7) {
                    searchBar2.f2232i.hideSoftInputFromWindow(searchBar2.f2224a.getWindowToken(), 0);
                    if (searchBar2.f2233j) {
                        searchBar2.m1395a();
                        searchBar2.f2233j = false;
                    }
                } else {
                    searchBar2.m1396b();
                }
                searchBar2.m1398d(z7);
                break;
        }
    }
}
