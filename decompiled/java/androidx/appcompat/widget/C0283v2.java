package androidx.appcompat.widget;

import android.view.KeyEvent;
import android.widget.TextView;

public final class C0283v2 implements TextView.OnEditorActionListener {

    public final SearchView f1097a;

    public C0283v2(SearchView searchView) {
        this.f1097a = searchView;
    }

    @Override
    public final boolean onEditorAction(TextView textView, int i6, KeyEvent keyEvent) {
        this.f1097a.m597s();
        return true;
    }
}
