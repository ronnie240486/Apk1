package androidx.leanback.widget;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;

public final class C0491q0 implements TextWatcher {

    public final RunnableC0489p0 f2430a;

    public final SearchBar f2431b;

    public C0491q0(SearchBar searchBar, RunnableC0489p0 runnableC0489p0) {
        this.f2431b = searchBar;
        this.f2430a = runnableC0489p0;
    }

    @Override
    public final void onTextChanged(CharSequence charSequence, int i6, int i10, int i11) {
        SearchBar searchBar = this.f2431b;
        if (searchBar.f2245v) {
            return;
        }
        Handler handler = searchBar.f2231h;
        RunnableC0489p0 runnableC0489p0 = this.f2430a;
        handler.removeCallbacks(runnableC0489p0);
        handler.post(runnableC0489p0);
    }

    @Override
    public final void afterTextChanged(Editable editable) {
    }

    @Override
    public final void beforeTextChanged(CharSequence charSequence, int i6, int i10, int i11) {
    }
}
