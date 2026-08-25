package androidx.appcompat.widget;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;

public final class ViewOnKeyListenerC0278u2 implements View.OnKeyListener {

    public final SearchView f1077a;

    public ViewOnKeyListenerC0278u2(SearchView searchView) {
        this.f1077a = searchView;
    }

    @Override
    public final boolean onKey(View view, int i6, KeyEvent keyEvent) {
        SearchView searchView = this.f1077a;
        if (searchView.f741c0 == null) {
            return false;
        }
        SearchView.SearchAutoComplete searchAutoComplete = searchView.f746p;
        if (!searchAutoComplete.isPopupShowing() || searchAutoComplete.getListSelection() == -1) {
            if (TextUtils.getTrimmedLength(searchAutoComplete.getText()) == 0 || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i6 != 66) {
                return false;
            }
            view.cancelLongPress();
            searchView.getContext().startActivity(searchView.m590l("android.intent.action.SEARCH", null, null, searchAutoComplete.getText().toString()));
            return true;
        }
        if (searchView.f741c0 == null || searchView.f731O == null || keyEvent.getAction() != 0 || !keyEvent.hasNoModifiers()) {
            return false;
        }
        if (i6 == 66 || i6 == 84 || i6 == 61) {
            searchView.m594p(searchAutoComplete.getListSelection());
        } else {
            if (i6 != 21 && i6 != 22) {
                if (i6 != 19) {
                    return false;
                }
                searchAutoComplete.getListSelection();
                return false;
            }
            searchAutoComplete.setSelection(i6 == 21 ? 0 : searchAutoComplete.length());
            searchAutoComplete.setListSelection(0);
            searchAutoComplete.clearListSelection();
            searchAutoComplete.m604a();
        }
        return true;
    }
}
