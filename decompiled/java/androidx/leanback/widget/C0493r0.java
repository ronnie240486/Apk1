package androidx.leanback.widget;

import android.view.KeyEvent;
import android.widget.TextView;

public final class C0493r0 implements TextView.OnEditorActionListener {

    public final SearchBar f2433a;

    public C0493r0(SearchBar searchBar) {
        this.f2433a = searchBar;
    }

    @Override
    public final boolean onEditorAction(TextView textView, int i6, KeyEvent keyEvent) {
        SearchBar searchBar = this.f2433a;
        if (3 == i6 || i6 == 0) {
            searchBar.getClass();
        }
        if (1 == i6) {
            searchBar.getClass();
        }
        if (2 != i6) {
            return false;
        }
        searchBar.f2232i.hideSoftInputFromWindow(searchBar.f2224a.getWindowToken(), 0);
        searchBar.f2231h.postDelayed(new RunnableC0447a(2, this), 500L);
        return true;
    }
}
