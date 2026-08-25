package androidx.appcompat.widget;

import android.view.inputmethod.InputMethodManager;

public final class RunnableC0188c3 implements Runnable {

    public final SearchView.SearchAutoComplete f879a;

    public RunnableC0188c3(SearchView.SearchAutoComplete searchAutoComplete) {
        this.f879a = searchAutoComplete;
    }

    @Override
    public final void run() {
        SearchView.SearchAutoComplete searchAutoComplete = this.f879a;
        if (searchAutoComplete.f760g) {
            ((InputMethodManager) searchAutoComplete.getContext().getSystemService("input_method")).showSoftInput(searchAutoComplete, 0);
            searchAutoComplete.f760g = false;
        }
    }
}
